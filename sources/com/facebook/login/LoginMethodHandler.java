package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.SavedStateHandle;
import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting(otherwise = 3)
/* compiled from: LoginMethodHandler.kt */
public abstract class LoginMethodHandler implements Parcelable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NO_SIGNED_REQUEST_ERROR_MESSAGE = "Authorization response does not contain the signed_request";
    public static final String NO_USER_ID_ERROR_MESSAGE = "Failed to retrieve user_id from signed_request";
    public static final String USER_CANCELED_LOG_IN_ERROR_MESSAGE = "User canceled log in.";
    public LoginClient loginClient;
    public Map<String, String> methodLoggingExtras;

    /* compiled from: LoginMethodHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
            String string;
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Utility utility2 = Utility.INSTANCE;
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            if (string2 != null) {
                boolean z = true;
                if (!(string2.length() == 0) && (string = bundle.getString(NativeProtocol.EXTRA_USER_ID)) != null) {
                    if (string.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        return new AccessToken(string2, str, string, stringArrayList, (Collection<String>) null, (Collection<String>) null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
                    }
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e8 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00e9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.AccessToken createAccessTokenFromWebBundle(java.util.Collection<java.lang.String> r17, android.os.Bundle r18, com.facebook.AccessTokenSource r19, java.lang.String r20) throws com.facebook.FacebookException {
            /*
                r16 = this;
                r0 = r18
                java.lang.String r1 = "bundle"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                java.lang.String r1 = "applicationId"
                r4 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
                com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
                java.util.Date r1 = new java.util.Date
                r1.<init>()
                java.lang.String r2 = "expires_in"
                java.util.Date r10 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r2, r1)
                java.lang.String r1 = "access_token"
                java.lang.String r3 = r0.getString(r1)
                r1 = 0
                if (r3 != 0) goto L_0x0025
                return r1
            L_0x0025:
                com.facebook.internal.Utility r2 = com.facebook.internal.Utility.INSTANCE
                java.util.Date r2 = new java.util.Date
                r5 = 0
                r2.<init>(r5)
                java.lang.String r5 = "data_access_expiration_time"
                java.util.Date r12 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r5, r2)
                java.lang.String r2 = "granted_scopes"
                java.lang.String r2 = r0.getString(r2)
                java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T>"
                r6 = 6
                java.lang.String r7 = ","
                r8 = 1
                r9 = 0
                if (r2 == 0) goto L_0x0071
                int r11 = r2.length()
                if (r11 <= 0) goto L_0x004b
                r11 = 1
                goto L_0x004c
            L_0x004b:
                r11 = 0
            L_0x004c:
                if (r11 == 0) goto L_0x0071
                java.lang.String[] r11 = new java.lang.String[]{r7}
                java.util.List r2 = kotlin.text.CharsKt__CharKt.split$default(r2, r11, r9, r9, r6)
                java.lang.String[] r11 = new java.lang.String[r9]
                java.lang.Object[] r2 = r2.toArray(r11)
                if (r2 == 0) goto L_0x006b
                java.lang.String[] r2 = (java.lang.String[]) r2
                int r11 = r2.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r11)
                java.util.ArrayList r2 = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(r2)
                r11 = r2
                goto L_0x0073
            L_0x006b:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r5)
                throw r0
            L_0x0071:
                r11 = r17
            L_0x0073:
                java.lang.String r2 = "denied_scopes"
                java.lang.String r2 = r0.getString(r2)
                if (r2 == 0) goto L_0x00a9
                int r13 = r2.length()
                if (r13 <= 0) goto L_0x0083
                r13 = 1
                goto L_0x0084
            L_0x0083:
                r13 = 0
            L_0x0084:
                if (r13 == 0) goto L_0x00a9
                java.lang.String[] r13 = new java.lang.String[]{r7}
                java.util.List r2 = kotlin.text.CharsKt__CharKt.split$default(r2, r13, r9, r9, r6)
                java.lang.String[] r13 = new java.lang.String[r9]
                java.lang.Object[] r2 = r2.toArray(r13)
                if (r2 == 0) goto L_0x00a3
                java.lang.String[] r2 = (java.lang.String[]) r2
                int r13 = r2.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r13)
                java.util.ArrayList r2 = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(r2)
                r13 = r2
                goto L_0x00aa
            L_0x00a3:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r5)
                throw r0
            L_0x00a9:
                r13 = r1
            L_0x00aa:
                java.lang.String r2 = "expired_scopes"
                java.lang.String r2 = r0.getString(r2)
                if (r2 == 0) goto L_0x00df
                int r14 = r2.length()
                if (r14 <= 0) goto L_0x00b9
                goto L_0x00ba
            L_0x00b9:
                r8 = 0
            L_0x00ba:
                if (r8 == 0) goto L_0x00df
                java.lang.String[] r7 = new java.lang.String[]{r7}
                java.util.List r2 = kotlin.text.CharsKt__CharKt.split$default(r2, r7, r9, r9, r6)
                java.lang.String[] r6 = new java.lang.String[r9]
                java.lang.Object[] r2 = r2.toArray(r6)
                if (r2 == 0) goto L_0x00d9
                java.lang.String[] r2 = (java.lang.String[]) r2
                int r5 = r2.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r5)
                java.util.ArrayList r2 = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(r2)
                r8 = r2
                goto L_0x00e0
            L_0x00d9:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r5)
                throw r0
            L_0x00df:
                r8 = r1
            L_0x00e0:
                com.facebook.internal.Utility r2 = com.facebook.internal.Utility.INSTANCE
                boolean r2 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r3)
                if (r2 == 0) goto L_0x00e9
                return r1
            L_0x00e9:
                java.lang.String r1 = "graph_domain"
                java.lang.String r1 = r0.getString(r1)
                java.lang.String r2 = "signed_request"
                java.lang.String r0 = r0.getString(r2)
                r14 = r16
                java.lang.String r5 = r14.getUserIDFromSignedRequest(r0)
                com.facebook.AccessToken r0 = new com.facebook.AccessToken
                java.util.Date r15 = new java.util.Date
                r15.<init>()
                r2 = r0
                r4 = r20
                r6 = r11
                r7 = r13
                r9 = r19
                r11 = r15
                r13 = r1
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginMethodHandler.Companion.createAccessTokenFromWebBundle(java.util.Collection, android.os.Bundle, com.facebook.AccessTokenSource, java.lang.String):com.facebook.AccessToken");
        }

        public final AuthenticationToken createAuthenticationTokenFromNativeLogin(Bundle bundle, String str) throws FacebookException {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (string != null) {
                boolean z = true;
                if (!(string.length() == 0) && str != null) {
                    if (str.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e) {
                            throw new FacebookException(e.getMessage());
                        }
                    }
                }
            }
            return null;
        }

        public final AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String str) throws FacebookException {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string != null) {
                boolean z = true;
                if (!(string.length() == 0) && str != null) {
                    if (str.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e) {
                            throw new FacebookException(e.getMessage(), (Throwable) e);
                        }
                    }
                }
            }
            return null;
        }

        public final String getUserIDFromSignedRequest(String str) throws FacebookException {
            if (str != null) {
                if (!(str.length() == 0)) {
                    try {
                        Object[] array = CharsKt__CharKt.split$default(str, new String[]{CodelessMatcher.CURRENT_CLASS_NAME}, false, 0, 6).toArray(new String[0]);
                        if (array != null) {
                            String[] strArr = (String[]) array;
                            if (strArr.length == 2) {
                                byte[] decode = Base64.decode(strArr[1], 0);
                                Intrinsics.checkNotNullExpressionValue(decode, "data");
                                String string = new JSONObject(new String(decode, Charsets.UTF_8)).getString("user_id");
                                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"user_id\")");
                                return string;
                            }
                            throw new FacebookException(LoginMethodHandler.NO_USER_ID_ERROR_MESSAGE);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } catch (UnsupportedEncodingException | JSONException unused) {
                    }
                }
            }
            throw new FacebookException(LoginMethodHandler.NO_SIGNED_REQUEST_ERROR_MESSAGE);
        }
    }

    public LoginMethodHandler(LoginClient loginClient2) {
        Intrinsics.checkNotNullParameter(loginClient2, LoginFragment.SAVED_LOGIN_CLIENT);
        setLoginClient(loginClient2);
    }

    public static final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        return Companion.createAccessTokenFromNativeLogin(bundle, accessTokenSource, str);
    }

    public static final AccessToken createAccessTokenFromWebBundle(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        return Companion.createAccessTokenFromWebBundle(collection, bundle, accessTokenSource, str);
    }

    public static final AuthenticationToken createAuthenticationTokenFromNativeLogin(Bundle bundle, String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromNativeLogin(bundle, str);
    }

    public static final AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromWebBundle(bundle, str);
    }

    public static final String getUserIDFromSignedRequest(String str) throws FacebookException {
        return Companion.getUserIDFromSignedRequest(str);
    }

    public void addLoggingExtra(String str, Object obj) {
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        Map<String, String> map = this.methodLoggingExtras;
        if (map != null) {
            String put = map.put(str, obj == null ? null : obj.toString());
        }
    }

    public void cancel() {
    }

    public String getClientState(String str) {
        Intrinsics.checkNotNullParameter(str, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, str);
            jSONObject.put(LoginLogger.EVENT_PARAM_METHOD, getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e) {
            Log.w("LoginMethodHandler", Intrinsics.stringPlus("Error creating client state json: ", e.getMessage()));
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "param.toString()");
        return jSONObject2;
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient2 = this.loginClient;
        if (loginClient2 != null) {
            return loginClient2;
        }
        Intrinsics.throwUninitializedPropertyAccessException(LoginFragment.SAVED_LOGIN_CLIENT);
        throw null;
    }

    public final Map<String, String> getMethodLoggingExtras() {
        return this.methodLoggingExtras;
    }

    public abstract String getNameForLogging();

    public String getRedirectUrl() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("fb");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        outline24.append(FacebookSdk.getApplicationId());
        outline24.append("://authorize/");
        return outline24.toString();
    }

    public void logWebLoginCompleted(String str) {
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        String applicationId = pendingRequest == null ? null : pendingRequest.getApplicationId();
        if (applicationId == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            applicationId = FacebookSdk.getApplicationId();
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(getLoginClient().getActivity(), applicationId);
        Bundle outline5 = GeneratedOutlineSupport.outline5(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        outline5.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        outline5.putString("app_id", applicationId);
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, (Double) null, outline5);
    }

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    public Bundle processCodeExchange(LoginClient.Request request, Bundle bundle) throws FacebookException {
        GraphRequest graphRequest;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, SavedStateHandle.VALUES);
        String string = bundle.getString("code");
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string)) {
            String str = null;
            if (string == null) {
                graphRequest = null;
            } else {
                PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
                String redirectUrl = getRedirectUrl();
                String codeVerifier = request.getCodeVerifier();
                if (codeVerifier == null) {
                    codeVerifier = "";
                }
                graphRequest = PKCEUtil.createCodeExchangeRequest(string, redirectUrl, codeVerifier);
            }
            if (graphRequest != null) {
                GraphResponse executeAndWait = graphRequest.executeAndWait();
                FacebookRequestError error = executeAndWait.getError();
                if (error == null) {
                    try {
                        JSONObject jSONObject = executeAndWait.getJSONObject();
                        if (jSONObject != null) {
                            str = jSONObject.getString("access_token");
                        }
                        if (jSONObject != null) {
                            Utility utility2 = Utility.INSTANCE;
                            if (!Utility.isNullOrEmpty(str)) {
                                bundle.putString("access_token", str);
                                if (jSONObject.has("id_token")) {
                                    bundle.putString("id_token", jSONObject.getString("id_token"));
                                }
                                return bundle;
                            }
                        }
                        throw new FacebookException("No access token found from result");
                    } catch (JSONException e) {
                        throw new FacebookException(Intrinsics.stringPlus("Fail to process code exchange response: ", e.getMessage()));
                    }
                } else {
                    throw new FacebookServiceException(error, error.getErrorMessage());
                }
            } else {
                throw new FacebookException("Failed to create code exchange request");
            }
        } else {
            throw new FacebookException("No code param found from the request");
        }
    }

    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "param");
    }

    public final void setLoginClient(LoginClient loginClient2) {
        Intrinsics.checkNotNullParameter(loginClient2, "<set-?>");
        this.loginClient = loginClient2;
    }

    public final void setMethodLoggingExtras(Map<String, String> map) {
        this.methodLoggingExtras = map;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    public abstract int tryAuthorize(LoginClient.Request request);

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        Utility utility = Utility.INSTANCE;
        Utility.writeStringMapToParcel(parcel, this.methodLoggingExtras);
    }

    public LoginMethodHandler(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        Utility utility = Utility.INSTANCE;
        Map<String, String> readStringMapFromParcel = Utility.readStringMapFromParcel(parcel);
        this.methodLoggingExtras = readStringMapFromParcel == null ? null : zzam.toMutableMap(readStringMapFromParcel);
    }
}
