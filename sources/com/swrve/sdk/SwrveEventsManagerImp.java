package com.swrve.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.swrve.sdk.config.SwrveConfigBase;
import com.swrve.sdk.localstorage.LocalStorage;
import com.swrve.sdk.localstorage.SwrveMultiLayerLocalStorage;
import com.swrve.sdk.rest.IRESTClient;
import com.swrve.sdk.rest.IRESTResponseListener;
import com.swrve.sdk.rest.RESTResponse;
import com.swrve.sdk.rest.RESTResponseLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class SwrveEventsManagerImp implements SwrveEventsManager {
    public static final String PREF_EVENT_SEND_RESPONSE_LOG = "EVENT_SEND_RESPONSE_LOG";
    public static final Object RESPONSE_LOG_LOCK = new Object();
    public static boolean shouldSendResponseLogs = true;
    public final String appVersion;
    public final SwrveConfigBase config;
    public final Context context;
    public final String deviceId;
    public final IRESTClient restClient;
    public final String sessionToken;
    public final String userId;

    public SwrveEventsManagerImp(Context context2, SwrveConfigBase swrveConfigBase, IRESTClient iRESTClient, String str, String str2, String str3, String str4) {
        this.context = context2;
        this.config = swrveConfigBase;
        this.restClient = iRESTClient;
        this.userId = str;
        this.appVersion = str2;
        this.sessionToken = str3;
        this.deviceId = str4;
    }

    private void postBatchRequest(LocalStorage localStorage, String str, int i, IPostBatchRequestListener iPostBatchRequestListener) {
        IRESTClient iRESTClient = this.restClient;
        final int i2 = i;
        final LocalStorage localStorage2 = localStorage;
        final IPostBatchRequestListener iPostBatchRequestListener2 = iPostBatchRequestListener;
        final String str2 = str;
        iRESTClient.post(this.config.getEventsUrl() + SwrveImp.BATCH_EVENTS_ACTION, str, new IRESTResponseListener() {
            public void onException(Exception exc) {
                SwrveLogger.m2753e("Error posting batch of events. postData:%s", exc, str2);
            }

            public void onResponse(RESTResponse rESTResponse) {
                boolean z = true;
                if (SwrveHelper.userErrorResponseCode(rESTResponse.responseCode)) {
                    SwrveEventsManagerImp.this.logResponse(rESTResponse, i2);
                    SwrveLogger.m2754e("Error sending events to Swrve. responseCode: %s\tresponseBody:%s", Integer.valueOf(rESTResponse.responseCode), rESTResponse.responseBody);
                } else if (SwrveHelper.successResponseCode(rESTResponse.responseCode)) {
                    SwrveEventsManagerImp.this.sendResponseLogs(localStorage2);
                    SwrveLogger.m2755i("Events sent to Swrve", new Object[0]);
                } else if (SwrveHelper.serverErrorResponseCode(rESTResponse.responseCode)) {
                    SwrveLogger.m2754e("Error sending events to Swrve. Wil retry. responseCode: %s\tresponseBody:%s", Integer.valueOf(rESTResponse.responseCode), rESTResponse.responseBody);
                    z = false;
                } else {
                    SwrveEventsManagerImp.this.logResponse(rESTResponse, i2);
                    SwrveLogger.m2754e("Error sending events to Swrve. responseCode: %s\tresponseBody:%s", Integer.valueOf(rESTResponse.responseCode), rESTResponse.responseBody);
                }
                iPostBatchRequestListener2.onResponse(z);
            }
        });
    }

    private int sendEvents(final LinkedHashMap<LocalStorage, LinkedHashMap<Long, String>> linkedHashMap) {
        int i;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (linkedHashMap.isEmpty()) {
            return 0;
        }
        SwrveLogger.m2755i("Sending queued events", new Object[0]);
        LocalStorage localStorage = null;
        try {
            Iterator<LocalStorage> it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                localStorage = it.next();
                linkedHashMap2.putAll(linkedHashMap.get(localStorage));
            }
            i = linkedHashMap2.size();
            try {
                String eventsAsBatch = EventHelper.eventsAsBatch(linkedHashMap2, this.userId, this.appVersion, this.sessionToken, this.deviceId);
                SwrveLogger.m2755i("Sending %s events to Swrve", Integer.valueOf(linkedHashMap2.size()));
                postBatchRequest(localStorage, eventsAsBatch, i, new IPostBatchRequestListener() {
                    public void onResponse(boolean z) {
                        if (z) {
                            for (LocalStorage localStorage : linkedHashMap.keySet()) {
                                localStorage.removeEvents(SwrveEventsManagerImp.this.userId, ((LinkedHashMap) linkedHashMap.get(localStorage)).keySet());
                            }
                            return;
                        }
                        SwrveLogger.m2754e("Batch of events could not be sent, retrying", new Object[0]);
                    }
                });
            } catch (JSONException e) {
                e = e;
            }
        } catch (JSONException e2) {
            e = e2;
            i = 0;
            SwrveLogger.m2753e("Unable to generate event batch, and send events", e, new Object[0]);
            return i;
        }
        return i;
    }

    private LinkedHashMap<Long, String> storeEvents(List<String> list, LocalStorage localStorage) throws Exception {
        LinkedHashMap<Long, String> linkedHashMap = new LinkedHashMap<>();
        for (String next : list) {
            linkedHashMap.put(Long.valueOf(localStorage.addEvent(this.userId, next)), next);
        }
        return linkedHashMap;
    }

    public int getNextSequenceNumber() {
        if (SwrveCommon.getInstance() == null) {
            return 0;
        }
        return SwrveCommon.getInstance().getNextSequenceNumber();
    }

    public long getTime() {
        return System.currentTimeMillis();
    }

    public void logResponse(RESTResponse rESTResponse, int i) {
        RESTResponseLog rESTResponseLog;
        RESTResponse rESTResponse2 = rESTResponse;
        String valueOf = String.valueOf(rESTResponse2.responseCode);
        Gson gson = new Gson();
        synchronized (RESPONSE_LOG_LOCK) {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(PREF_EVENT_SEND_RESPONSE_LOG, 0);
            String string = sharedPreferences.getString(valueOf, (String) null);
            if (string == null) {
                rESTResponseLog = new RESTResponseLog(rESTResponse2.responseCode, i, 1, getTime(), rESTResponse2.responseBody, rESTResponse2.responseHeaders);
            } else {
                RESTResponseLog rESTResponseLog2 = (RESTResponseLog) gson.fromJson(string, new TypeToken<RESTResponseLog>() {
                }.getType());
                rESTResponseLog = new RESTResponseLog(rESTResponse2.responseCode, rESTResponseLog2.eventsCount + i, rESTResponseLog2.requestCount + 1, getTime(), rESTResponse2.responseBody, rESTResponse2.responseHeaders);
            }
            sharedPreferences.edit().putString(valueOf, gson.toJson((Object) rESTResponseLog)).apply();
            shouldSendResponseLogs = true;
        }
    }

    public void sendResponseLogs(LocalStorage localStorage) {
        Map<String, ?> all;
        if (shouldSendResponseLogs) {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(PREF_EVENT_SEND_RESPONSE_LOG, 0);
            synchronized (RESPONSE_LOG_LOCK) {
                all = sharedPreferences.getAll();
                sharedPreferences.edit().clear().apply();
                shouldSendResponseLogs = false;
            }
            try {
                ArrayList arrayList = new ArrayList();
                Gson gson = new Gson();
                for (Map.Entry<String, ?> value : all.entrySet()) {
                    RESTResponseLog rESTResponseLog = (RESTResponseLog) gson.fromJson((String) value.getValue(), new TypeToken<RESTResponseLog>() {
                    }.getType());
                    HashMap hashMap = new HashMap();
                    hashMap.put("code", String.valueOf(rESTResponseLog.code));
                    hashMap.put("events_count", String.valueOf(rESTResponseLog.eventsCount));
                    hashMap.put("request_count", String.valueOf(rESTResponseLog.requestCount));
                    hashMap.put("body", rESTResponseLog.body);
                    hashMap.put("headers", rESTResponseLog.headers);
                    hashMap.put("time", String.valueOf(rESTResponseLog.time));
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("name", "Swrve.RestResponseLog");
                    arrayList.add(EventHelper.eventAsJSON("event", hashMap2, hashMap, getNextSequenceNumber(), getTime()));
                }
                if (localStorage != null) {
                    storeAndSendEvents(arrayList, localStorage);
                }
            } catch (Exception e) {
                SwrveLogger.m2753e("Error sending rest response logs.", e, new Object[0]);
            }
        }
    }

    public int sendStoredEvents(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage) {
        int sendEvents;
        synchronized (SwrveMultiLayerLocalStorage.EVENT_LOCK) {
            sendEvents = sendEvents(swrveMultiLayerLocalStorage.getCombinedFirstNEvents(Integer.valueOf(this.config.getMaxEventsPerFlush()), this.userId));
        }
        return sendEvents;
    }

    public int storeAndSendEvents(List<String> list, LocalStorage localStorage) throws Exception {
        int sendEvents;
        if (list == null || list.size() == 0) {
            return 0;
        }
        synchronized (SwrveMultiLayerLocalStorage.EVENT_LOCK) {
            LinkedHashMap<Long, String> storeEvents = storeEvents(list, localStorage);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(localStorage, storeEvents);
            sendEvents = sendEvents(linkedHashMap);
        }
        return sendEvents;
    }
}
