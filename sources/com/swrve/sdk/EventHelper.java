package com.swrve.sdk;

import android.content.Context;
import android.os.Bundle;
import com.helpshift.common.domain.network.NetworkConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class EventHelper {
    public static final Object BATCH_API_VERSION = NetworkConstants.apiVersion;

    public static ArrayList<String> createGenericEvent(String str, String str2, String str3, String str4, String str5, Map<String, String> map, int i) throws JSONException {
        return createGenericEvent(System.currentTimeMillis(), str, str2, str3, str4, str5, map, i);
    }

    public static List<String> createSessionStartEvent(long j, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(eventAsJSON("session_start", (Map<String, Object>) null, (Map<String, String>) null, i, j));
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception building session start event", e, new Object[0]);
        }
        return arrayList;
    }

    public static String eventAsJSON(String str, Map<String, Object> map, int i, long j) throws JSONException {
        return eventAsJSON(str, map, (Map<String, String>) null, i, j);
    }

    public static String eventsAsBatch(LinkedHashMap<Long, String> linkedHashMap, String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ISwrveCommon.BATCH_EVENT_KEY_USER, str);
        jSONObject.put(ISwrveCommon.BATCH_EVENT_KEY_SESSION_TOKEN, str3);
        jSONObject.put("version", BATCH_API_VERSION);
        jSONObject.put("app_version", str2);
        jSONObject.put(ISwrveCommon.BATCH_EVENT_KEY_UNIQUE_DEVICE_ID, str4);
        jSONObject.put("data", orderedMapToJSONArray(linkedHashMap));
        return jSONObject.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r2 = r0.getJSONArray("data");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String extractEventFromBatch(java.lang.String r2) throws java.lang.Exception {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r2)
            java.lang.String r2 = "data"
            boolean r1 = r0.has(r2)
            if (r1 == 0) goto L_0x001f
            org.json.JSONArray r2 = r0.getJSONArray(r2)
            if (r2 == 0) goto L_0x001f
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x001f
            r0 = 0
            java.lang.String r2 = r2.getString(r0)
            goto L_0x0021
        L_0x001f:
            java.lang.String r2 = ""
        L_0x0021:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.EventHelper.extractEventFromBatch(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getEventName(java.lang.String r1, java.util.Map<java.lang.String, java.lang.Object> r2) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1377559170: goto L_0x004e;
                case -22151246: goto L_0x0044;
                case 104024: goto L_0x003a;
                case 3599307: goto L_0x0030;
                case 14367183: goto L_0x0026;
                case 96891546: goto L_0x001c;
                case 200597881: goto L_0x0012;
                case 1743324417: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0058
        L_0x0008:
            java.lang.String r0 = "purchase"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 5
            goto L_0x0059
        L_0x0012:
            java.lang.String r0 = "session_start"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 0
            goto L_0x0059
        L_0x001c:
            java.lang.String r0 = "event"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 4
            goto L_0x0059
        L_0x0026:
            java.lang.String r0 = "currency_given"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 6
            goto L_0x0059
        L_0x0030:
            java.lang.String r0 = "user"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 7
            goto L_0x0059
        L_0x003a:
            java.lang.String r0 = "iap"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 3
            goto L_0x0059
        L_0x0044:
            java.lang.String r0 = "session_end"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 1
            goto L_0x0059
        L_0x004e:
            java.lang.String r0 = "buy_in"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0058
            r1 = 2
            goto L_0x0059
        L_0x0058:
            r1 = -1
        L_0x0059:
            switch(r1) {
                case 0: goto L_0x007a;
                case 1: goto L_0x0077;
                case 2: goto L_0x0074;
                case 3: goto L_0x0071;
                case 4: goto L_0x0068;
                case 5: goto L_0x0065;
                case 6: goto L_0x0062;
                case 7: goto L_0x005f;
                default: goto L_0x005c;
            }
        L_0x005c:
            java.lang.String r1 = ""
            return r1
        L_0x005f:
            java.lang.String r1 = "Swrve.user_properties_changed"
            return r1
        L_0x0062:
            java.lang.String r1 = "Swrve.currency_given"
            return r1
        L_0x0065:
            java.lang.String r1 = "Swrve.user_purchase"
            return r1
        L_0x0068:
            java.lang.String r1 = "name"
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            return r1
        L_0x0071:
            java.lang.String r1 = "Swrve.iap"
            return r1
        L_0x0074:
            java.lang.String r1 = "Swrve.buy_in"
            return r1
        L_0x0077:
            java.lang.String r1 = "Swrve.session.end"
            return r1
        L_0x007a:
            java.lang.String r1 = "Swrve.session.start"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.EventHelper.getEventName(java.lang.String, java.util.Map):java.lang.String");
    }

    public static String getPushDeliveredBatchEvent(ArrayList<String> arrayList) throws Exception {
        String userId = SwrveCommon.getInstance().getUserId();
        String appVersion = SwrveCommon.getInstance().getAppVersion();
        String sessionKey = SwrveCommon.getInstance().getSessionKey();
        String deviceId = SwrveCommon.getInstance().getDeviceId();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(-1L, arrayList.get(0));
        return eventsAsBatch(linkedHashMap, userId, appVersion, sessionKey, deviceId);
    }

    public static ArrayList<String> getPushDeliveredEvent(Bundle bundle, long j, boolean z, String str) throws Exception {
        if (bundle == null || !SwrveHelper.isSwrvePush(bundle)) {
            return new ArrayList<>();
        }
        String string = bundle.getString(SwrveNotificationInternalPayloadConstants.SWRVE_TRACKING_KEY);
        HashMap hashMap = new HashMap();
        if (SwrveHelper.isNullOrEmpty(string)) {
            string = bundle.getString(SwrveNotificationConstants.SWRVE_SILENT_TRACKING_KEY);
            hashMap.put("silent", String.valueOf(true));
        } else {
            hashMap.put("silent", String.valueOf(false));
        }
        String str2 = string;
        hashMap.put(ISwrveCommon.GENERIC_EVENT_PAYLOAD_DISPLAYED, String.valueOf(z));
        if (SwrveHelper.isNotNullOrEmpty(str)) {
            hashMap.put("reason", str);
        }
        return createGenericEvent(j, str2, ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_PUSH, ISwrveCommon.GENERIC_EVENT_ACTION_TYPE_DELIVERED, (String) null, (String) null, hashMap, SwrveCommon.getInstance().getNextSequenceNumber());
    }

    public static JSONArray orderedMapToJSONArray(LinkedHashMap<Long, String> linkedHashMap) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Long, String> value : linkedHashMap.entrySet()) {
            jSONArray.put(new JSONObject((String) value.getValue()));
        }
        return jSONArray;
    }

    public static String qaLogEventAsJSON(long j, String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("time", j);
        jSONObject.put("type", "qa_log_event");
        jSONObject.put("log_source", str);
        jSONObject.put("log_type", str2);
        jSONObject.put("log_details", new JSONObject(str3));
        return jSONObject.toString();
    }

    public static void sendButtonClickEvent(Context context, String str, String str2, String str3, Map<String, String> map) {
        try {
            ISwrveCommon instance = SwrveCommon.getInstance();
            ArrayList<String> createGenericEvent = createGenericEvent(str2, str, ISwrveCommon.GENERIC_EVENT_ACTION_TYPE_BUTTON_CLICK, str3, (String) null, map, instance.getNextSequenceNumber());
            SwrveLogger.m2752d("Sending button_click for id:%s contextId:%s campaignType:%s", str2, str3, str);
            instance.sendEventsInBackground(context, instance.getUserId(), createGenericEvent);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception trying to send button click event.", e, new Object[0]);
        }
    }

    public static void sendEngagedEvent(Context context, String str, String str2, Map<String, String> map) {
        try {
            ISwrveCommon instance = SwrveCommon.getInstance();
            ArrayList<String> arrayList = new ArrayList<>();
            int nextSequenceNumber = instance.getNextSequenceNumber();
            if (ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_GEO.equalsIgnoreCase(str)) {
                SwrveLogger.m2752d("Sending generic engaged event.", new Object[0]);
                arrayList = createGenericEvent(str2, ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_GEO, ISwrveCommon.GENERIC_EVENT_ACTION_TYPE_ENGAGED, "", "", map, nextSequenceNumber);
            } else if (ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_PUSH.equalsIgnoreCase(str)) {
                String str3 = "Swrve.Messages.Push-" + str2 + ".engaged";
                SwrveLogger.m2752d("Sending engaged event: %s", str3);
                HashMap hashMap = new HashMap();
                hashMap.put("name", str3);
                arrayList.add(eventAsJSON("event", hashMap, map, nextSequenceNumber, System.currentTimeMillis()));
            }
            instance.sendEventsInBackground(context, instance.getUserId(), arrayList);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception trying to send engaged event.", e, new Object[0]);
        }
    }

    public static void sendUninitiatedDeviceUpdateEvent(Context context, String str, JSONObject jSONObject) {
        try {
            ISwrveCommon instance = SwrveCommon.getInstance();
            HashMap hashMap = new HashMap();
            hashMap.put("attributes", jSONObject);
            hashMap.put("user_initiated", "false");
            String eventAsJSON = eventAsJSON("device_update", hashMap, (Map<String, String>) null, instance.getNextSequenceNumber(), System.currentTimeMillis());
            ArrayList arrayList = new ArrayList();
            arrayList.add(eventAsJSON);
            instance.sendEventsInBackground(context, str, arrayList);
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK couldn't send uninitiated device_update event.", e, new Object[0]);
        }
    }

    public static ArrayList<String> createGenericEvent(long j, String str, String str2, String str3, String str4, String str5, Map<String, String> map, int i) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put("id", str);
        hashMap.put(ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_KEY, str2);
        hashMap.put(ISwrveCommon.GENERIC_EVENT_ACTION_TYPE_KEY, str3);
        if (SwrveHelper.isNotNullOrEmpty(str4)) {
            hashMap.put(ISwrveCommon.GENERIC_EVENT_CONTEXT_ID_KEY, str4);
        }
        if (SwrveHelper.isNotNullOrEmpty(str5)) {
            hashMap.put(ISwrveCommon.GENERIC_EVENT_CAMPAIGN_ID_KEY, str5);
        }
        arrayList.add(eventAsJSON(ISwrveCommon.EVENT_TYPE_GENERIC_CAMPAIGN, hashMap, map, i, j));
        return arrayList;
    }

    public static String eventAsJSON(String str, Map<String, Object> map, Map<String, String> map2, int i, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", str);
        jSONObject.put("time", j);
        if (i > 0) {
            jSONObject.put(ISwrveCommon.CACHE_SEQNUM, i);
        }
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        }
        if (map2 != null && map2.size() > 0) {
            jSONObject.put("payload", new JSONObject(map2));
        }
        return jSONObject.toString();
    }
}
