package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import com.helpshift.util.ErrorReportProvider;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class HeartBeatInfoStorage {
    public static HeartBeatInfoStorage instance;
    public final SharedPreferences sharedPreferences;

    public HeartBeatInfoStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    public synchronized boolean shouldSendSdkHeartBeat(String str, long j) {
        if (!this.sharedPreferences.contains(str)) {
            this.sharedPreferences.edit().putLong(str, j).apply();
            return true;
        } else if (j - this.sharedPreferences.getLong(str, -1) < ErrorReportProvider.BATCH_TIME) {
            return false;
        } else {
            this.sharedPreferences.edit().putLong(str, j).apply();
            return true;
        }
    }
}
