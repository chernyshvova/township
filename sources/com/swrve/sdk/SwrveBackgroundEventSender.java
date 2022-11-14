package com.swrve.sdk;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.localstorage.SQLiteLocalStorage;
import com.swrve.sdk.localstorage.SwrveMultiLayerLocalStorage;
import java.util.Arrays;
import java.util.List;

public class SwrveBackgroundEventSender {
    public static final String DATA_KEY_EVENTS = "events";
    public static final String DATA_KEY_USER_ID = "userId";
    public final Context context;
    public final SwrveBase swrve;
    public String userId;
    public OneTimeWorkRequest workRequest;

    public SwrveBackgroundEventSender(SwrveBase swrveBase, Context context2) {
        this.swrve = swrveBase;
        this.context = context2;
    }

    private SwrveEventsManager getSendEventsManager(SwrveBase swrveBase, String str, SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage) {
        String deviceId = SwrveLocalStorageUtil.getDeviceId(swrveMultiLayerLocalStorage);
        return new SwrveEventsManagerImp(this.context, swrveBase.config, swrveBase.restClient, str, swrveBase.appVersion, SwrveHelper.generateSessionToken(swrveBase.apiKey, swrveBase.appId, str), deviceId);
    }

    public synchronized void enqueueWorkRequest(OneTimeWorkRequest oneTimeWorkRequest) {
        WorkManager.getInstance(this.context).enqueue((WorkRequest) oneTimeWorkRequest);
    }

    public OneTimeWorkRequest getOneTimeWorkRequest(String str, List<String> list) {
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        return (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(SwrveBackgroundEventSenderWorker.class).setConstraints(build)).setInputData(new Data.Builder().putString("userId", str).putStringArray("events", (String[]) list.toArray(new String[list.size()])).build())).build();
    }

    public int handleSendEvents(Data data) throws Exception {
        String string = data.getString("userId");
        this.userId = string;
        if (SwrveHelper.isNullOrEmpty(string)) {
            this.userId = SwrveSDKBase.getUserId();
        }
        String[] stringArray = data.getStringArray("events");
        if (stringArray == null || stringArray.length <= 0) {
            return 0;
        }
        return handleSendEvents((List<String>) Arrays.asList(stringArray));
    }

    public void send(String str, List<String> list) {
        try {
            OneTimeWorkRequest oneTimeWorkRequest = getOneTimeWorkRequest(str, list);
            this.workRequest = oneTimeWorkRequest;
            enqueueWorkRequest(oneTimeWorkRequest);
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: Error trying to queue events to be sent in the background worker.", e, new Object[0]);
        }
    }

    private int handleSendEvents(List<String> list) throws Exception {
        SQLiteLocalStorage sQLiteLocalStorage = new SQLiteLocalStorage(this.context, this.swrve.config.getDbName(), this.swrve.config.getMaxSqliteDbSize());
        SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage = new SwrveMultiLayerLocalStorage(sQLiteLocalStorage);
        if (SwrveHelper.isNotNullOrEmpty(this.userId)) {
            int storeAndSendEvents = getSendEventsManager(this.swrve, this.userId, swrveMultiLayerLocalStorage).storeAndSendEvents(list, sQLiteLocalStorage);
            SwrveLogger.m2755i(GeneratedOutlineSupport.outline14("SwrveBackgroundEventSender: eventsSent: ", storeAndSendEvents), new Object[0]);
            return storeAndSendEvents;
        }
        SwrveLogger.m2755i("SwrveBackgroundEventSender: no user to save events log events against.", new Object[0]);
        return 0;
    }
}
