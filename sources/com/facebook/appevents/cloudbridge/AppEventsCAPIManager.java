package com.facebook.appevents.cloudbridge;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.android.billingclient.api.zzam;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.helpshift.analytics.AnalyticsEventKey;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppEventsCAPIManager.kt */
public final class AppEventsCAPIManager {
    public static final AppEventsCAPIManager INSTANCE = new AppEventsCAPIManager();
    public static final String SETTINGS_PATH = "/cloudbridge_settings";
    public static final String TAG = AppEventsCAPIManager.class.getCanonicalName();
    public static boolean isEnabled;

    public static final void enable() {
        try {
            $$Lambda$m16G8HSqbE1bMmir1EfQXv1qNY r8 = $$Lambda$m16G8HSqbE1bMmir1EfQXv1qNY.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            GraphRequest graphRequest = new GraphRequest((AccessToken) null, Intrinsics.stringPlus(FacebookSdk.getApplicationId(), SETTINGS_PATH), (Bundle) null, HttpMethod.GET, r8, (String) null, 32, (DefaultConstructorMarker) null);
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nCreating Graph Request: \n=============\n%s\n\n ", graphRequest);
                graphRequest.executeAsync();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (JSONException e) {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
            String str2 = TAG;
            if (str2 != null) {
                companion2.log(loggingBehavior2, str2, " \n\nGraph Request Exception: \n=============\n%s\n\n ", zzam.stackTraceToString(e));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m3566enable$lambda0(GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        INSTANCE.getCAPIGSettingsFromGraphResponse$facebook_core_release(graphResponse);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047 A[Catch:{ all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055 A[Catch:{ all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A[Catch:{ all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[Catch:{ all -> 0x009f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.Object> getSavedCloudBridgeCredentials$facebook_core_release() {
        /*
            java.lang.Class<com.facebook.appevents.cloudbridge.AppEventsCAPIManager> r0 = com.facebook.appevents.cloudbridge.AppEventsCAPIManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x009f }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x009f }
            java.lang.String r3 = "com.facebook.sdk.CloudBridgeSavedCredentials"
            r4 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r3, r4)     // Catch:{ all -> 0x009f }
            if (r1 != 0) goto L_0x001a
            return r2
        L_0x001a:
            com.facebook.appevents.cloudbridge.SettingsAPIFields r3 = com.facebook.appevents.cloudbridge.SettingsAPIFields.DATASETID     // Catch:{ all -> 0x009f }
            java.lang.String r3 = r3.getRawValue()     // Catch:{ all -> 0x009f }
            java.lang.String r3 = r1.getString(r3, r2)     // Catch:{ all -> 0x009f }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r5 = com.facebook.appevents.cloudbridge.SettingsAPIFields.URL     // Catch:{ all -> 0x009f }
            java.lang.String r5 = r5.getRawValue()     // Catch:{ all -> 0x009f }
            java.lang.String r5 = r1.getString(r5, r2)     // Catch:{ all -> 0x009f }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r6 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ACCESSKEY     // Catch:{ all -> 0x009f }
            java.lang.String r6 = r6.getRawValue()     // Catch:{ all -> 0x009f }
            java.lang.String r1 = r1.getString(r6, r2)     // Catch:{ all -> 0x009f }
            r6 = 1
            if (r3 == 0) goto L_0x0044
            boolean r7 = kotlin.text.CharsKt__CharKt.isBlank(r3)     // Catch:{ all -> 0x009f }
            if (r7 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r7 = 0
            goto L_0x0045
        L_0x0044:
            r7 = 1
        L_0x0045:
            if (r7 != 0) goto L_0x009e
            if (r5 == 0) goto L_0x0052
            boolean r7 = kotlin.text.CharsKt__CharKt.isBlank(r5)     // Catch:{ all -> 0x009f }
            if (r7 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r7 = 0
            goto L_0x0053
        L_0x0052:
            r7 = 1
        L_0x0053:
            if (r7 != 0) goto L_0x009e
            if (r1 == 0) goto L_0x0060
            boolean r7 = kotlin.text.CharsKt__CharKt.isBlank(r1)     // Catch:{ all -> 0x009f }
            if (r7 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r7 = 0
            goto L_0x0061
        L_0x0060:
            r7 = 1
        L_0x0061:
            if (r7 == 0) goto L_0x0064
            goto L_0x009e
        L_0x0064:
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap     // Catch:{ all -> 0x009f }
            r7.<init>()     // Catch:{ all -> 0x009f }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r8 = com.facebook.appevents.cloudbridge.SettingsAPIFields.URL     // Catch:{ all -> 0x009f }
            java.lang.String r8 = r8.getRawValue()     // Catch:{ all -> 0x009f }
            r7.put(r8, r5)     // Catch:{ all -> 0x009f }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r8 = com.facebook.appevents.cloudbridge.SettingsAPIFields.DATASETID     // Catch:{ all -> 0x009f }
            java.lang.String r8 = r8.getRawValue()     // Catch:{ all -> 0x009f }
            r7.put(r8, r3)     // Catch:{ all -> 0x009f }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r8 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ACCESSKEY     // Catch:{ all -> 0x009f }
            java.lang.String r8 = r8.getRawValue()     // Catch:{ all -> 0x009f }
            r7.put(r8, r1)     // Catch:{ all -> 0x009f }
            com.facebook.internal.Logger$Companion r8 = com.facebook.internal.Logger.Companion     // Catch:{ all -> 0x009f }
            com.facebook.LoggingBehavior r9 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ all -> 0x009f }
            java.lang.String r10 = TAG     // Catch:{ all -> 0x009f }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x009f }
            java.lang.String r11 = " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n "
            r12 = 3
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ all -> 0x009f }
            r12[r4] = r3     // Catch:{ all -> 0x009f }
            r12[r6] = r5     // Catch:{ all -> 0x009f }
            r3 = 2
            r12[r3] = r1     // Catch:{ all -> 0x009f }
            r8.log((com.facebook.LoggingBehavior) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.Object[]) r12)     // Catch:{ all -> 0x009f }
            return r7
        L_0x009e:
            return r2
        L_0x009f:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsCAPIManager.getSavedCloudBridgeCredentials$facebook_core_release():java.util.Map");
    }

    public final void getCAPIGSettingsFromGraphResponse$facebook_core_release(GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        boolean z = false;
        if (graphResponse.getError() != null) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n ", graphResponse.getError().toString(), String.valueOf(graphResponse.getError().getException()));
                Map<String, Object> savedCloudBridgeCredentials$facebook_core_release = getSavedCloudBridgeCredentials$facebook_core_release();
                if (savedCloudBridgeCredentials$facebook_core_release != null) {
                    URL url = new URL(String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.URL.getRawValue())));
                    AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                    String valueOf = String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.DATASETID.getRawValue()));
                    AppEventsConversionsAPITransformerWebRequests.configure(valueOf, url.getProtocol() + "://" + url.getHost(), String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.ACCESSKEY.getRawValue())));
                    isEnabled = true;
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Logger.Companion companion2 = Logger.Companion;
        LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
        String str2 = TAG;
        if (str2 != null) {
            companion2.log(loggingBehavior2, str2, " \n\nGraph Response Received: \n================\n%s\n\n ", graphResponse);
            JSONObject jSONObject = graphResponse.getJSONObject();
            try {
                Utility utility = Utility.INSTANCE;
                Object obj = jSONObject == null ? null : jSONObject.get("data");
                if (obj != null) {
                    List<String> convertJSONArrayToList = Utility.convertJSONArrayToList((JSONArray) obj);
                    Utility utility2 = Utility.INSTANCE;
                    Map<String, Object> convertJSONObjectToHashMap = Utility.convertJSONObjectToHashMap(new JSONObject((String) CollectionsKt__CollectionsKt.first(convertJSONArrayToList)));
                    String str3 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.URL.getRawValue());
                    String str4 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.DATASETID.getRawValue());
                    String str5 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.ACCESSKEY.getRawValue());
                    if (str3 == null || str4 == null || str5 == null) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "CloudBridge Settings API response doesn't have valid data");
                        return;
                    }
                    try {
                        URL url2 = new URL(str3);
                        AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests2 = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                        AppEventsConversionsAPITransformerWebRequests.configure(str4, url2.getProtocol() + "://" + url2.getHost(), str5);
                        setSavedCloudBridgeCredentials$facebook_core_release(convertJSONObjectToHashMap);
                        if (convertJSONObjectToHashMap.get(SettingsAPIFields.ENABLED.getRawValue()) != null) {
                            Object obj2 = convertJSONObjectToHashMap.get(SettingsAPIFields.ENABLED.getRawValue());
                            if (obj2 != null) {
                                z = ((Boolean) obj2).booleanValue();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                        }
                        isEnabled = z;
                    } catch (MalformedURLException e) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "CloudBridge Settings API response doesn't have valid url\n %s ", zzam.stackTraceToString(e));
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
            } catch (JSONException e2) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "CloudBridge Settings API response is not a valid json: \n%s ", zzam.stackTraceToString(e2));
            } catch (NullPointerException e3) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "CloudBridge Settings API response is not a valid json: \n%s ", zzam.stackTraceToString(e3));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public final boolean isEnabled$facebook_core_release() {
        return isEnabled;
    }

    public final void setEnabled$facebook_core_release(boolean z) {
        isEnabled = z;
    }

    public final void setSavedCloudBridgeCredentials$facebook_core_release(Map<String, ? extends Object> map) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.CLOUDBRIDGE_SAVED_CREDENTIALS, 0);
        if (sharedPreferences != null) {
            if (map == null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.apply();
                return;
            }
            Object obj = map.get(SettingsAPIFields.DATASETID.getRawValue());
            Object obj2 = map.get(SettingsAPIFields.URL.getRawValue());
            Object obj3 = map.get(SettingsAPIFields.ACCESSKEY.getRawValue());
            if (obj != null && obj2 != null && obj3 != null) {
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString(SettingsAPIFields.DATASETID.getRawValue(), obj.toString());
                edit2.putString(SettingsAPIFields.URL.getRawValue(), obj2.toString());
                edit2.putString(SettingsAPIFields.ACCESSKEY.getRawValue(), obj3.toString());
                edit2.apply();
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, String.valueOf(TAG), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", obj, obj2, obj3);
            }
        }
    }
}
