package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@VisibleForTesting(otherwise = 3)
/* compiled from: NativeAppLoginMethodHandler.kt */
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    public final AccessTokenSource tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, LoginFragment.SAVED_LOGIN_CLIENT);
    }

    private final void completeLogin(LoginClient.Result result) {
        if (result != null) {
            getLoginClient().completeAndValidate(result);
        } else {
            getLoginClient().tryNextHandler();
        }
    }

    private final void processSuccessResponse(LoginClient.Request request, Bundle bundle) {
        if (bundle.containsKey("code")) {
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(bundle.getString("code"))) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable(request, bundle) {
                    public final /* synthetic */ LoginClient.Request f$1;
                    public final /* synthetic */ Bundle f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        NativeAppLoginMethodHandler.m3666processSuccessResponse$lambda0(NativeAppLoginMethodHandler.this, this.f$1, this.f$2);
                    }
                });
                return;
            }
        }
        handleResultOk(request, bundle);
    }

    /* renamed from: processSuccessResponse$lambda-0  reason: not valid java name */
    public static final void m3666processSuccessResponse$lambda0(NativeAppLoginMethodHandler nativeAppLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(nativeAppLoginMethodHandler, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(bundle, "$extras");
        try {
            nativeAppLoginMethodHandler.handleResultOk(request, nativeAppLoginMethodHandler.processCodeExchange(request, bundle));
        } catch (FacebookServiceException e) {
            FacebookRequestError requestError = e.getRequestError();
            nativeAppLoginMethodHandler.handleResultError(request, requestError.getErrorType(), requestError.getErrorMessage(), String.valueOf(requestError.getErrorCode()));
        } catch (FacebookException e2) {
            nativeAppLoginMethodHandler.handleResultError(request, (String) null, e2.getMessage(), (String) null);
        }
    }

    public String getError(Bundle bundle) {
        String string = bundle == null ? null : bundle.getString("error");
        if (string != null) {
            return string;
        }
        if (bundle == null) {
            return null;
        }
        return bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
    }

    public String getErrorMessage(Bundle bundle) {
        String string = bundle == null ? null : bundle.getString("error_message");
        if (string != null) {
            return string;
        }
        if (bundle == null) {
            return null;
        }
        return bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public void handleResultCancel(LoginClient.Request request, Intent intent) {
        Object obj;
        Intrinsics.checkNotNullParameter(intent, "data");
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        String str = null;
        if (!(extras == null || (obj = extras.get("error_code")) == null)) {
            str = obj.toString();
        }
        ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
        if (Intrinsics.areEqual(ServerProtocol.getErrorConnectionFailure(), str)) {
            completeLogin(LoginClient.Result.Companion.createErrorResult(request, error, getErrorMessage(extras), str));
            return;
        }
        completeLogin(LoginClient.Result.Companion.createCancelResult(request, error));
    }

    public void handleResultError(LoginClient.Request request, String str, String str2, String str3) {
        if (str == null || !Intrinsics.areEqual(str, "logged_out")) {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            if (CollectionsKt__CollectionsKt.contains(ServerProtocol.getErrorsProxyAuthDisabled(), str)) {
                completeLogin((LoginClient.Result) null);
                return;
            }
            ServerProtocol serverProtocol2 = ServerProtocol.INSTANCE;
            if (CollectionsKt__CollectionsKt.contains(ServerProtocol.getErrorsUserCanceled(), str)) {
                completeLogin(LoginClient.Result.Companion.createCancelResult(request, (String) null));
            } else {
                completeLogin(LoginClient.Result.Companion.createErrorResult(request, str, str2, str3));
            }
        } else {
            CustomTabLoginMethodHandler.Companion companion = CustomTabLoginMethodHandler.Companion;
            CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
            completeLogin((LoginClient.Result) null);
        }
    }

    public void handleResultOk(LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        try {
            completeLogin(LoginClient.Result.Companion.createCompositeTokenResult(request, LoginMethodHandler.Companion.createAccessTokenFromWebBundle(request.getPermissions(), bundle, getTokenSource(), request.getApplicationId()), LoginMethodHandler.Companion.createAuthenticationTokenFromWebBundle(bundle, request.getNonce())));
        } catch (FacebookException e) {
            completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, request, (String) null, e.getMessage(), (String) null, 8, (Object) null));
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (intent == null) {
            completeLogin(LoginClient.Result.Companion.createCancelResult(pendingRequest, "Operation canceled"));
        } else if (i2 == 0) {
            handleResultCancel(pendingRequest, intent);
        } else if (i2 != -1) {
            completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, pendingRequest, "Unexpected resultCode from authorization.", (String) null, (String) null, 8, (Object) null));
        } else {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, pendingRequest, "Unexpected null from returned authorization data.", (String) null, (String) null, 8, (Object) null));
                return true;
            }
            String error = getError(extras);
            Object obj = extras.get("error_code");
            String obj2 = obj == null ? null : obj.toString();
            String errorMessage = getErrorMessage(extras);
            String string = extras.getString("e2e");
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(string)) {
                logWebLoginCompleted(string);
            }
            if (error == null && obj2 == null && errorMessage == null && pendingRequest != null) {
                processSuccessResponse(pendingRequest, extras);
            } else {
                handleResultError(pendingRequest, error, errorMessage, obj2);
            }
        }
        return true;
    }

    public abstract int tryAuthorize(LoginClient.Request request);

    public boolean tryIntent(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            Fragment fragment = getLoginClient().getFragment();
            if (fragment == null) {
                return true;
            }
            fragment.startActivityForResult(intent, i);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
    }
}
