package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: WebViewLoginMethodHandler.kt */
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new WebViewLoginMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OAUTH_DIALOG = "oauth";
    public String e2e;
    public WebDialog loginDialog;
    public final String nameForLogging = "web_view";
    public final AccessTokenSource tokenSource = AccessTokenSource.WEB_VIEW;

    /* compiled from: WebViewLoginMethodHandler.kt */
    public final class AuthDialogBuilder extends WebDialog.Builder {
        public String authType;
        public String e2e;
        public boolean isFamilyLogin;
        public LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        public String redirect_uri = ServerProtocol.DIALOG_REDIRECT_URI;
        public boolean shouldSkipDedupe;
        public LoginTargetApp targetApp = LoginTargetApp.FACEBOOK;
        public final /* synthetic */ WebViewLoginMethodHandler this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AuthDialogBuilder(WebViewLoginMethodHandler webViewLoginMethodHandler, Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
            Intrinsics.checkNotNullParameter(webViewLoginMethodHandler, "this$0");
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Intrinsics.checkNotNullParameter(bundle, "parameters");
            this.this$0 = webViewLoginMethodHandler;
        }

        public WebDialog build() {
            Bundle parameters = getParameters();
            if (parameters != null) {
                parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.redirect_uri);
                parameters.putString("client_id", getApplicationId());
                parameters.putString("e2e", getE2e());
                parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, this.targetApp == LoginTargetApp.INSTAGRAM ? ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES : ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
                parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, getAuthType());
                parameters.putString("login_behavior", this.loginBehavior.name());
                if (this.isFamilyLogin) {
                    parameters.putString(ServerProtocol.DIALOG_PARAM_FX_APP, this.targetApp.toString());
                }
                if (this.shouldSkipDedupe) {
                    parameters.putString(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
                WebDialog.Companion companion = WebDialog.Companion;
                Context context = getContext();
                if (context != null) {
                    return companion.newInstance(context, "oauth", parameters, getTheme(), this.targetApp, getListener());
                }
                throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
        }

        public final String getAuthType() {
            String str = this.authType;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("authType");
            throw null;
        }

        public final String getE2e() {
            String str = this.e2e;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("e2e");
            throw null;
        }

        /* renamed from: setAuthType  reason: collision with other method in class */
        public final void m3667setAuthType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authType = str;
        }

        public final AuthDialogBuilder setE2E(String str) {
            Intrinsics.checkNotNullParameter(str, "e2e");
            setE2e(str);
            return this;
        }

        public final void setE2e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.e2e = str;
        }

        public final AuthDialogBuilder setFamilyLogin(boolean z) {
            this.isFamilyLogin = z;
            return this;
        }

        public final AuthDialogBuilder setIsChromeOS(boolean z) {
            this.redirect_uri = z ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
            return this;
        }

        public final AuthDialogBuilder setIsRerequest(boolean z) {
            return this;
        }

        public final AuthDialogBuilder setLoginBehavior(LoginBehavior loginBehavior2) {
            Intrinsics.checkNotNullParameter(loginBehavior2, "loginBehavior");
            this.loginBehavior = loginBehavior2;
            return this;
        }

        public final AuthDialogBuilder setLoginTargetApp(LoginTargetApp loginTargetApp) {
            Intrinsics.checkNotNullParameter(loginTargetApp, "targetApp");
            this.targetApp = loginTargetApp;
            return this;
        }

        public final AuthDialogBuilder setShouldSkipDedupe(boolean z) {
            this.shouldSkipDedupe = z;
            return this;
        }

        public final AuthDialogBuilder setAuthType(String str) {
            Intrinsics.checkNotNullParameter(str, "authType");
            setAuthType(str);
            return this;
        }
    }

    /* compiled from: WebViewLoginMethodHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, LoginFragment.SAVED_LOGIN_CLIENT);
    }

    public void cancel() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            if (webDialog != null) {
                webDialog.cancel();
            }
            this.loginDialog = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String getE2e() {
        return this.e2e;
    }

    public final WebDialog getLoginDialog() {
        return this.loginDialog;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public boolean needsInternetPermission() {
        return true;
    }

    public final void onWebDialogComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(request, "request");
        super.onComplete(request, bundle, facebookException);
    }

    public final void setE2e(String str) {
        this.e2e = str;
    }

    public final void setLoginDialog(WebDialog webDialog) {
        this.loginDialog = webDialog;
    }

    public int tryAuthorize(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle parameters = getParameters(request);
        WebViewLoginMethodHandler$tryAuthorize$listener$1 webViewLoginMethodHandler$tryAuthorize$listener$1 = new WebViewLoginMethodHandler$tryAuthorize$listener$1(this, request);
        String e2e2 = LoginClient.Companion.getE2E();
        this.e2e = e2e2;
        addLoggingExtra("e2e", e2e2);
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null) {
            return 0;
        }
        Utility utility = Utility.INSTANCE;
        boolean isChromeOS = Utility.isChromeOS(activity);
        AuthDialogBuilder authDialogBuilder = new AuthDialogBuilder(this, activity, request.getApplicationId(), parameters);
        String str = this.e2e;
        if (str != null) {
            this.loginDialog = authDialogBuilder.setE2E(str).setIsChromeOS(isChromeOS).setAuthType(request.getAuthType()).setLoginBehavior(request.getLoginBehavior()).setLoginTargetApp(request.getLoginTargetApp()).setFamilyLogin(request.isFamilyLogin()).setShouldSkipDedupe(request.shouldSkipAccountDeduplication()).setOnCompleteListener(webViewLoginMethodHandler$tryAuthorize$listener$1).build();
            FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
            facebookDialogFragment.setRetainInstance(true);
            facebookDialogFragment.setInnerDialog(this.loginDialog);
            facebookDialogFragment.show(activity.getSupportFragmentManager(), FacebookDialogFragment.TAG);
            return 1;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e2e);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
        this.e2e = parcel.readString();
    }
}
