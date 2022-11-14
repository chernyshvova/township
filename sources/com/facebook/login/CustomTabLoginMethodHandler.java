package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CustomTab;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CustomTabLoginMethodHandler.kt */
public final class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static final int API_EC_DIALOG_CANCEL = 4201;
    public static final int CHALLENGE_LENGTH = 20;
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new CustomTabLoginMethodHandler$Companion$CREATOR$1();
    public static final int CUSTOM_TAB_REQUEST_CODE = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OAUTH_DIALOG = "oauth";
    public static boolean calledThroughLoggedOutAppSwitch;
    public String currentPackage;
    public String expectedChallenge;
    public final String nameForLogging = "custom_tab";
    public final AccessTokenSource tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
    public String validRedirectURI;

    /* compiled from: CustomTabLoginMethodHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, LoginFragment.SAVED_LOGIN_CLIENT);
        Utility utility = Utility.INSTANCE;
        this.expectedChallenge = Utility.generateRandomString(20);
        calledThroughLoggedOutAppSwitch = false;
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectURI());
    }

    private final String getChromePackage() {
        String str = this.currentPackage;
        if (str != null) {
            return str;
        }
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        String chromePackage = CustomTabUtils.getChromePackage();
        this.currentPackage = chromePackage;
        return chromePackage;
    }

    private final String getDeveloperDefinedRedirectURI() {
        return super.getRedirectUrl();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onCustomTabComplete(java.lang.String r7, com.facebook.login.LoginClient.Request r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x00d9
            java.lang.String r0 = "fbconnect://cct."
            r1 = 0
            r2 = 2
            boolean r0 = kotlin.text.CharsKt__CharKt.startsWith$default(r7, r0, r1, r2)
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = super.getRedirectUrl()
            boolean r0 = kotlin.text.CharsKt__CharKt.startsWith$default(r7, r0, r1, r2)
            if (r0 == 0) goto L_0x00d9
        L_0x0016:
            android.net.Uri r7 = android.net.Uri.parse(r7)
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE
            java.lang.String r0 = r7.getQuery()
            android.os.Bundle r0 = com.facebook.internal.Utility.parseUrlQueryString(r0)
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
            java.lang.String r7 = r7.getFragment()
            android.os.Bundle r7 = com.facebook.internal.Utility.parseUrlQueryString(r7)
            r0.putAll(r7)
            boolean r7 = r6.validateChallengeParam(r0)
            r1 = 0
            if (r7 != 0) goto L_0x0043
            com.facebook.FacebookException r7 = new com.facebook.FacebookException
            java.lang.String r0 = "Invalid state parameter"
            r7.<init>((java.lang.String) r0)
            super.onComplete(r8, r1, r7)
            return
        L_0x0043:
            java.lang.String r7 = "error"
            java.lang.String r7 = r0.getString(r7)
            if (r7 != 0) goto L_0x0051
            java.lang.String r7 = "error_type"
            java.lang.String r7 = r0.getString(r7)
        L_0x0051:
            java.lang.String r2 = "error_msg"
            java.lang.String r2 = r0.getString(r2)
            if (r2 != 0) goto L_0x005f
            java.lang.String r2 = "error_message"
            java.lang.String r2 = r0.getString(r2)
        L_0x005f:
            if (r2 != 0) goto L_0x0067
            java.lang.String r2 = "error_description"
            java.lang.String r2 = r0.getString(r2)
        L_0x0067:
            java.lang.String r3 = "error_code"
            java.lang.String r3 = r0.getString(r3)
            r4 = -1
            if (r3 != 0) goto L_0x0071
            goto L_0x0076
        L_0x0071:
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0076 }
            goto L_0x0077
        L_0x0076:
            r3 = -1
        L_0x0077:
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r7)
            if (r5 == 0) goto L_0x00a4
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r2)
            if (r5 == 0) goto L_0x00a4
            if (r3 != r4) goto L_0x00a4
            java.lang.String r7 = "access_token"
            boolean r7 = r0.containsKey(r7)
            if (r7 == 0) goto L_0x0095
            super.onComplete(r8, r0, r1)
            return
        L_0x0095:
            com.facebook.FacebookSdk r7 = com.facebook.FacebookSdk.INSTANCE
            java.util.concurrent.Executor r7 = com.facebook.FacebookSdk.getExecutor()
            com.facebook.login.-$$Lambda$0BMF4P_RxQCfsUXf0Xd3ErROU8g r1 = new com.facebook.login.-$$Lambda$0BMF4P_RxQCfsUXf0Xd3ErROU8g
            r1.<init>(r8, r0)
            r7.execute(r1)
            goto L_0x00d9
        L_0x00a4:
            if (r7 == 0) goto L_0x00bf
            java.lang.String r0 = "access_denied"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            if (r0 != 0) goto L_0x00b6
            java.lang.String r0 = "OAuthAccessDeniedException"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            if (r0 == 0) goto L_0x00bf
        L_0x00b6:
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            super.onComplete(r8, r1, r7)
            goto L_0x00d9
        L_0x00bf:
            r0 = 4201(0x1069, float:5.887E-42)
            if (r3 != r0) goto L_0x00cc
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            super.onComplete(r8, r1, r7)
            goto L_0x00d9
        L_0x00cc:
            com.facebook.FacebookRequestError r0 = new com.facebook.FacebookRequestError
            r0.<init>(r3, r7, r2)
            com.facebook.FacebookServiceException r7 = new com.facebook.FacebookServiceException
            r7.<init>(r0, r2)
            super.onComplete(r8, r1, r7)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.onCustomTabComplete(java.lang.String, com.facebook.login.LoginClient$Request):void");
    }

    /* renamed from: onCustomTabComplete$lambda-0  reason: not valid java name */
    public static final void m3651onCustomTabComplete$lambda0(CustomTabLoginMethodHandler customTabLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(customTabLoginMethodHandler, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(bundle, "$values");
        try {
            customTabLoginMethodHandler.onComplete(request, customTabLoginMethodHandler.processCodeExchange(request, bundle), (FacebookException) null);
        } catch (FacebookException e) {
            customTabLoginMethodHandler.onComplete(request, (Bundle) null, e);
        }
    }

    private final boolean validateChallengeParam(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return Intrinsics.areEqual(new JSONObject(string).getString(LoginLogger.EVENT_PARAM_CHALLENGE), this.expectedChallenge);
        } catch (JSONException unused) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public String getRedirectUrl() {
        return this.validRedirectURI;
    }

    public String getSSODevice() {
        return "chrome_custom_tab";
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
            return super.onActivityResult(i, i2, intent);
        }
        if (i != 1) {
            return super.onActivityResult(i, i2, intent);
        }
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (pendingRequest == null) {
            return false;
        }
        String str = null;
        if (i2 == -1) {
            if (intent != null) {
                str = intent.getStringExtra(CustomTabMainActivity.EXTRA_URL);
            }
            onCustomTabComplete(str, pendingRequest);
            return true;
        }
        super.onComplete(pendingRequest, (Bundle) null, new FacebookOperationCanceledException());
        return false;
    }

    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "param");
        jSONObject.put(LoginLogger.EVENT_PARAM_CHALLENGE, this.expectedChallenge);
    }

    public int tryAuthorize(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LoginClient loginClient = getLoginClient();
        if (getRedirectUrl().length() == 0) {
            return 0;
        }
        Bundle addExtraParameters = addExtraParameters(getParameters(request), request);
        if (calledThroughLoggedOutAppSwitch) {
            addExtraParameters.putString(ServerProtocol.DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (FacebookSdk.hasCustomTabsPrefetching) {
            if (request.isInstagramLogin()) {
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(InstagramCustomTab.Companion.getURIForAction("oauth", addExtraParameters));
            } else {
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(CustomTab.Companion.getURIForAction("oauth", addExtraParameters));
            }
        }
        FragmentActivity activity = loginClient.getActivity();
        if (activity == null) {
            return 0;
        }
        Intent intent = new Intent(activity, CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, "oauth");
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, addExtraParameters);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
        intent.putExtra(CustomTabMainActivity.EXTRA_TARGET_APP, request.getLoginTargetApp().toString());
        Fragment fragment = loginClient.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, 1);
        }
        return 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.expectedChallenge);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
        this.expectedChallenge = parcel.readString();
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectURI());
    }
}
