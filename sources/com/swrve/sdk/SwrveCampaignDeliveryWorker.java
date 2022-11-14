package com.swrve.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SwrveCampaignDeliveryWorker extends Worker {
    public SwrveCampaignDeliveryWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result failure = ListenableWorker.Result.failure();
        try {
            SwrveLogger.m2755i("SwrveSDK: SwrveCampaignDeliveryWorker started.", new Object[0]);
            return new CampaignDeliveryManager(getApplicationContext()).post(getInputData(), getRunAttemptCount());
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: SwrveCampaignDeliveryWorker exception.", e, new Object[0]);
            return failure;
        }
    }
}
