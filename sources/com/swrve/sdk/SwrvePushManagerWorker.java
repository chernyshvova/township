package com.swrve.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;

public class SwrvePushManagerWorker extends SwrvePushManagerBaseWorker {
    public SwrvePushManagerWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public SwrvePushManager getSwrvePushManager() {
        return new SwrvePushManagerImp(getApplicationContext());
    }
}
