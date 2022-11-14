package com.swrve.sdk;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import java.util.Map;

public abstract class SwrvePushManagerBaseWorker extends Worker {
    public SwrvePushManagerBaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private Bundle convertToBundle(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (String next : map.keySet()) {
                if (map.get(next) instanceof String) {
                    bundle.putString(next, (String) map.get(next));
                }
            }
        }
        return bundle;
    }

    @NonNull
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result success = ListenableWorker.Result.success();
        try {
            SwrveLogger.m2755i("SwrveSDK: SwrvePushWorker started.", new Object[0]);
            getSwrvePushManager().processMessage(convertToBundle(getInputData().getKeyValueMap()));
            return success;
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: SwrvePushWorker exception.", e, new Object[0]);
            return ListenableWorker.Result.failure();
        }
    }

    public abstract SwrvePushManager getSwrvePushManager();
}
