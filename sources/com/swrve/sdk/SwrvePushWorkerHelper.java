package com.swrve.sdk;

import android.content.Context;
import android.os.Bundle;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import java.util.Map;

public class SwrvePushWorkerHelper {
    public final Context context;
    public final Data inputData;
    public boolean isSwrvePush;
    public OneTimeWorkRequest workRequest;
    public final Class<? extends ListenableWorker> workerClass;

    public SwrvePushWorkerHelper(Context context2, Class<? extends ListenableWorker> cls, Map<String, String> map) {
        this.context = context2;
        this.workerClass = cls;
        Data.Builder builder = new Data.Builder();
        if (map != null) {
            for (String next : map.keySet()) {
                builder.putString(next, map.get(next));
                checkIsSwrvePush(next, map.get(next));
            }
        }
        this.inputData = builder.build();
    }

    private void checkIsSwrvePush(String str, String str2) {
        if (SwrveHelper.isNotNullOrEmpty(str) && SwrveHelper.isNotNullOrEmpty(str2)) {
            if (str.equalsIgnoreCase(SwrveNotificationInternalPayloadConstants.SWRVE_TRACKING_KEY) || str.equalsIgnoreCase(SwrveNotificationConstants.SWRVE_SILENT_TRACKING_KEY)) {
                this.isSwrvePush = true;
            }
        }
    }

    public synchronized void enqueueWorkRequest(Context context2, OneTimeWorkRequest oneTimeWorkRequest) {
        WorkManager.getInstance(context2).enqueue((WorkRequest) oneTimeWorkRequest);
    }

    public boolean handle() {
        boolean z;
        SwrveLogger.m2755i("SwrveSDK: Attempt to handle push message via SwrvePushWorkerHelper.", new Object[0]);
        try {
            if (this.isSwrvePush) {
                OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(this.workerClass).setInputData(this.inputData)).build();
                this.workRequest = oneTimeWorkRequest;
                enqueueWorkRequest(this.context, oneTimeWorkRequest);
                z = true;
                try {
                    SwrveLogger.m2755i("SwrveSDK: Swrve push worker queued with data via SwrvePushWorkerHelper.", new Object[0]);
                    return true;
                } catch (Exception e) {
                    e = e;
                    SwrveLogger.m2753e("SwrveSDK: Error trying to queue SwrvePushWorkerHelper.", e, new Object[0]);
                    return z;
                }
            } else {
                SwrveLogger.m2755i("SwrveSDK: Swrve will not handle this push because it is not a swrve push.", new Object[0]);
                return false;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public SwrvePushWorkerHelper(Context context2, Class<? extends ListenableWorker> cls, Bundle bundle) {
        this.context = context2;
        this.workerClass = cls;
        Data.Builder builder = new Data.Builder();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    builder.putString(str, str2);
                    checkIsSwrvePush(str, str2);
                } else {
                    SwrveLogger.m2758w("SwrveSDK: SwrvePushWorkerHelper found non string type object in bundle..", new Object[0]);
                }
            }
        }
        this.inputData = builder.build();
    }
}
