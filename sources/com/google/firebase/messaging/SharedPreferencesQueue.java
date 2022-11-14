package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.WorkerThread;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final class SharedPreferencesQueue {
    @GuardedBy("internalQueue")
    public boolean bulkOperation = false;
    @GuardedBy("internalQueue")
    public final ArrayDeque<String> internalQueue = new ArrayDeque<>();
    public final String itemSeparator;
    public final String queueName;
    public final SharedPreferences sharedPreferences;
    public final Executor syncExecutor;

    public SharedPreferencesQueue(SharedPreferences sharedPreferences2, String str, String str2, Executor executor) {
        this.sharedPreferences = sharedPreferences2;
        this.queueName = str;
        this.itemSeparator = str2;
        this.syncExecutor = executor;
    }

    @WorkerThread
    public static SharedPreferencesQueue createInstance(SharedPreferences sharedPreferences2, String str, String str2, Executor executor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences2, str, str2, executor);
        synchronized (sharedPreferencesQueue.internalQueue) {
            sharedPreferencesQueue.internalQueue.clear();
            String string = sharedPreferencesQueue.sharedPreferences.getString(sharedPreferencesQueue.queueName, "");
            if (!TextUtils.isEmpty(string)) {
                if (string.contains(sharedPreferencesQueue.itemSeparator)) {
                    String[] split = string.split(sharedPreferencesQueue.itemSeparator, -1);
                    if (split.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str3 : split) {
                        if (!TextUtils.isEmpty(str3)) {
                            sharedPreferencesQueue.internalQueue.add(str3);
                        }
                    }
                }
            }
        }
        return sharedPreferencesQueue;
    }
}
