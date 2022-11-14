package com.swrve.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.ListenableWorker;
import java.util.Map;

public class SwrvePushServiceDefault {
    public static boolean handle(Context context, Map<String, String> map) {
        if (map != null) {
            return new SwrvePushWorkerHelper(context, (Class<? extends ListenableWorker>) SwrvePushManagerWorker.class, map).handle();
        }
        return false;
    }

    public static boolean handle(Context context, Intent intent) {
        return handle(context, intent.getExtras());
    }

    public static boolean handle(Context context, Bundle bundle) {
        if (bundle != null) {
            return new SwrvePushWorkerHelper(context, (Class<? extends ListenableWorker>) SwrvePushManagerWorker.class, bundle).handle();
        }
        return false;
    }
}
