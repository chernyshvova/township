package com.swrve.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SwrveBackgroundEventSenderWorker extends Worker {
    public SwrveBackgroundEventSenderWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result success = ListenableWorker.Result.success();
        try {
            SwrveLogger.m2755i("SwrveSDK: SwrveBackgroundEventSenderWorker started.", new Object[0]);
            new SwrveBackgroundEventSender((Swrve) SwrveSDKBase.getInstance(), getApplicationContext()).handleSendEvents(getInputData());
            return success;
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: SwrveBackgroundEventSenderWorker exception.", e, new Object[0]);
            return ListenableWorker.Result.failure();
        }
    }
}
