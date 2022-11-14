package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ServerProtocol.kt */
public final class ServerProtocol {
    public static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
    public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
    public static final String DIALOG_PARAM_APP_ID = "app_id";
    public static final String DIALOG_PARAM_AUTHENTICATION_TOKEN = "id_token";
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
    public static final String DIALOG_PARAM_CBT = "cbt";
    public static final String DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH = "cct_over_app_switch";
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
    public static final String DIALOG_PARAM_CODE_CHALLENGE = "code_challenge";
    public static final String DIALOG_PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";
    public static final String DIALOG_PARAM_CODE_REDIRECT_URI = "code_redirect_uri";
    public static final String DIALOG_PARAM_CUSTOM_TABS_PREFETCHING = "cct_prefetching";
    public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
    public static final String DIALOG_PARAM_DISPLAY = "display";
    public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
    public static final String DIALOG_PARAM_E2E = "e2e";
    public static final String DIALOG_PARAM_FAIL_ON_LOGGED_OUT = "fail_on_logged_out";
    public static final String DIALOG_PARAM_FX_APP = "fx_app";
    public static final String DIALOG_PARAM_IES = "ies";
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
    public static final String DIALOG_PARAM_LOGIN_BEHAVIOR = "login_behavior";
    public static final String DIALOG_PARAM_MESSENGER_PAGE_ID = "messenger_page_id";
    public static final String DIALOG_PARAM_NONCE = "nonce";
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
    public static final String DIALOG_PARAM_RESET_MESSENGER_STATE = "reset_messenger_state";
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
    public static final String DIALOG_PARAM_SCOPE = "scope";
    public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
    public static final String DIALOG_PARAM_SKIP_DEDUPE = "skip_dedupe";
    public static final String DIALOG_PARAM_SSO_DEVICE = "sso";
    public static final String DIALOG_PARAM_STATE = "state";
    public static final String DIALOG_PATH = "dialog/";
    public static final String DIALOG_REDIRECT_CHROME_OS_URI = "fbconnect://chrome_os_success";
    public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
    public static final String DIALOG_RESPONSE_TYPE_CODE = "code,signed_request,graph_domain";
    public static final String DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST = "id_token,token,signed_request,graph_domain";
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES = "token,signed_request,graph_domain,granted_scopes";
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request,graph_domain";
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
    public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
    public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
    public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
    public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
    public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
    public static final String GRAPH_URL_FORMAT = "https://graph.%s";
    public static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
    public static final String INSTAGRAM_OAUTH_PATH = "oauth/authorize";
    public static final ServerProtocol INSTANCE = new ServerProtocol();
    public static final String TAG;

    static {
        String name = ServerProtocol.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "ServerProtocol::class.java.name");
        TAG = name;
    }

    public static final String getDefaultAPIVersion() {
        return "v13.0";
    }

    public static final String getDialogAuthority() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return GeneratedOutlineSupport.outline21(new Object[]{FacebookSdk.getFacebookDomain()}, 1, DIALOG_AUTHORITY_FORMAT, "java.lang.String.format(format, *args)");
    }

    public static final String getErrorConnectionFailure() {
        return "CONNECTION_FAILURE";
    }

    public static final Collection<String> getErrorsProxyAuthDisabled() {
        return CollectionsKt__CollectionsKt.listOf("service_disabled", "AndroidAuthKillSwitchException");
    }

    public static final Collection<String> getErrorsUserCanceled() {
        return CollectionsKt__CollectionsKt.listOf("access_denied", "OAuthAccessDeniedException");
    }

    public static final String getFacebookGraphUrlBase() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return GeneratedOutlineSupport.outline21(new Object[]{FacebookSdk.getFacebookDomain()}, 1, GRAPH_URL_FORMAT, "java.lang.String.format(format, *args)");
    }

    public static final String getGraphUrlBase() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return GeneratedOutlineSupport.outline21(new Object[]{FacebookSdk.getGraphDomain()}, 1, GRAPH_URL_FORMAT, "java.lang.String.format(format, *args)");
    }

    public static final String getGraphUrlBaseForSubdomain(String str) {
        Intrinsics.checkNotNullParameter(str, "subdomain");
        return GeneratedOutlineSupport.outline21(new Object[]{str}, 1, GRAPH_URL_FORMAT, "java.lang.String.format(format, *args)");
    }

    public static final String getGraphVideoUrlBase() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return GeneratedOutlineSupport.outline21(new Object[]{FacebookSdk.getGraphDomain()}, 1, GRAPH_VIDEO_URL_FORMAT, "java.lang.String.format(format, *args)");
    }

    public static final String getInstagramDialogAuthority() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return GeneratedOutlineSupport.outline21(new Object[]{FacebookSdk.getInstagramDomain()}, 1, DIALOG_AUTHORITY_FORMAT, "java.lang.String.format(format, *args)");
    }

    public static final Bundle getQueryParamsForPlatformActivityIntentWebFallback(String str, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "callId");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        String applicationSignature = FacebookSdk.getApplicationSignature(applicationContext);
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(applicationSignature)) {
            return null;
        }
        Bundle outline5 = GeneratedOutlineSupport.outline5(FALLBACK_DIALOG_PARAM_KEY_HASH, applicationSignature);
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        outline5.putString("app_id", FacebookSdk.getApplicationId());
        outline5.putInt("version", i);
        outline5.putString(DIALOG_PARAM_DISPLAY, "touch");
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", str);
        try {
            BundleJSONConverter bundleJSONConverter = BundleJSONConverter.INSTANCE;
            JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle2);
            BundleJSONConverter bundleJSONConverter2 = BundleJSONConverter.INSTANCE;
            if (bundle == null) {
                bundle = new Bundle();
            }
            JSONObject convertToJSON2 = BundleJSONConverter.convertToJSON(bundle);
            if (convertToJSON != null) {
                if (convertToJSON2 != null) {
                    outline5.putString("bridge_args", convertToJSON.toString());
                    outline5.putString("method_args", convertToJSON2.toString());
                    return outline5;
                }
            }
            return null;
        } catch (JSONException e) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, Intrinsics.stringPlus("Error creating Url -- ", e));
            return null;
        } catch (IllegalArgumentException e2) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, Intrinsics.stringPlus("Error creating Url -- ", e2));
            return null;
        }
    }
}
