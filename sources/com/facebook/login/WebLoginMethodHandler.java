package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: WebLoginMethodHandler.kt */
public abstract class WebLoginMethodHandler extends LoginMethodHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
    public static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
    public String e2e;

    /* compiled from: WebLoginMethodHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, LoginFragment.SAVED_LOGIN_CLIENT);
    }

    private final String loadCookieToken() {
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            activity = FacebookSdk.getApplicationContext();
        }
        return activity.getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).getString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, "");
    }

    private final void saveCookieToken(String str) {
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            activity = FacebookSdk.getApplicationContext();
        }
        activity.getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).edit().putString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, str).apply();
    }

    public Bundle addExtraParameters(Bundle bundle, LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(bundle, "parameters");
        Intrinsics.checkNotNullParameter(request, "request");
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, getRedirectUrl());
        if (request.isInstagramLogin()) {
            bundle.putString("app_id", request.getApplicationId());
        } else {
            bundle.putString("client_id", request.getApplicationId());
        }
        bundle.putString("e2e", LoginClient.Companion.getE2E());
        if (request.isInstagramLogin()) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES);
        } else {
            if (request.getPermissions().contains("openid")) {
                bundle.putString("nonce", request.getNonce());
            }
            bundle.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST);
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_CODE_CHALLENGE, request.getCodeChallenge());
        CodeChallengeMethod codeChallengeMethod = request.getCodeChallengeMethod();
        bundle.putString(ServerProtocol.DIALOG_PARAM_CODE_CHALLENGE_METHOD, codeChallengeMethod == null ? null : codeChallengeMethod.name());
        bundle.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        bundle.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, request.getAuthType());
        bundle.putString("login_behavior", request.getLoginBehavior().name());
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString("sdk", Intrinsics.stringPlus("android-", FacebookSdk.getSdkVersion()));
        if (getSSODevice() != null) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_SSO_DEVICE, getSSODevice());
        }
        boolean z = FacebookSdk.hasCustomTabsPrefetching;
        String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        bundle.putString(ServerProtocol.DIALOG_PARAM_CUSTOM_TABS_PREFETCHING, z ? str : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (request.isFamilyLogin()) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_FX_APP, request.getLoginTargetApp().toString());
        }
        if (request.shouldSkipAccountDeduplication()) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        if (request.getMessengerPageId() != null) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_MESSENGER_PAGE_ID, request.getMessengerPageId());
            if (!request.getResetMessengerState()) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            bundle.putString(ServerProtocol.DIALOG_PARAM_RESET_MESSENGER_STATE, str);
        }
        return bundle;
    }

    public Bundle getParameters(LoginClient.Request request) {
        String str;
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty((Collection<?>) request.getPermissions())) {
            String join = TextUtils.join(",", request.getPermissions());
            bundle.putString("scope", join);
            addLoggingExtra("scope", join);
        }
        DefaultAudience defaultAudience = request.getDefaultAudience();
        if (defaultAudience == null) {
            defaultAudience = DefaultAudience.NONE;
        }
        bundle.putString("default_audience", defaultAudience.getNativeProtocolAudience());
        bundle.putString("state", getClientState(request.getAuthId()));
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken == null) {
            str = null;
        } else {
            str = currentAccessToken.getToken();
        }
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (str == null || !Intrinsics.areEqual(str, loadCookieToken())) {
            FragmentActivity activity = getLoginClient().getActivity();
            if (activity != null) {
                Utility utility2 = Utility.INSTANCE;
                Utility.clearFacebookCookies(activity);
            }
            addLoggingExtra("access_token", str2);
        } else {
            bundle.putString("access_token", str);
            addLoggingExtra("access_token", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_CBT, String.valueOf(System.currentTimeMillis()));
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_IES, str2);
        return bundle;
    }

    public String getSSODevice() {
        return null;
    }

    public abstract AccessTokenSource getTokenSource();

    @VisibleForTesting(otherwise = 4)
    public void onComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        LoginClient.Result result;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(request, "request");
        LoginClient loginClient = getLoginClient();
        this.e2e = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.e2e = bundle.getString("e2e");
            }
            try {
                AccessToken createAccessTokenFromWebBundle = LoginMethodHandler.Companion.createAccessTokenFromWebBundle(request.getPermissions(), bundle, getTokenSource(), request.getApplicationId());
                result = LoginClient.Result.Companion.createCompositeTokenResult(loginClient.getPendingRequest(), createAccessTokenFromWebBundle, LoginMethodHandler.Companion.createAuthenticationTokenFromWebBundle(bundle, request.getNonce()));
                if (loginClient.getActivity() != null) {
                    try {
                        CookieSyncManager.createInstance(loginClient.getActivity()).sync();
                    } catch (Exception unused) {
                    }
                    if (createAccessTokenFromWebBundle != null) {
                        saveCookieToken(createAccessTokenFromWebBundle.getToken());
                    }
                }
            } catch (FacebookException e) {
                result = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, loginClient.getPendingRequest(), (String) null, e.getMessage(), (String) null, 8, (Object) null);
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            result = LoginClient.Result.Companion.createCancelResult(loginClient.getPendingRequest(), LoginMethodHandler.USER_CANCELED_LOG_IN_ERROR_MESSAGE);
        } else {
            this.e2e = null;
            if (facebookException == null) {
                str = null;
            } else {
                str = facebookException.getMessage();
            }
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                str2 = String.valueOf(requestError.getErrorCode());
                str = requestError.toString();
            } else {
                str2 = null;
            }
            result = LoginClient.Result.Companion.createErrorResult(loginClient.getPendingRequest(), (String) null, str, str2);
        }
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(this.e2e)) {
            logWebLoginCompleted(this.e2e);
        }
        loginClient.completeAndValidate(result);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
    }
}
