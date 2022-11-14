package com.playrix.engine;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.drive.DriveFile;
import org.json.JSONException;
import org.json.JSONObject;

public class Scheduler {
    public static final String INTENT_DATA_KEY = "data";
    public static final String TAG = "[Scheduler] ";
    public int lastRequestId = -1;
    public final String preferencesKey;
    public final Class<?> receiverClass;

    public Scheduler(Class<?> cls, String str) {
        this.receiverClass = cls;
        this.preferencesKey = str;
    }

    public static JSONObject getDataFromIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("data");
        if (stringExtra != null) {
            try {
                return new JSONObject(stringExtra);
            } catch (JSONException unused) {
                Logger.logError("[Scheduler] error parsing intent: invalid JSON string : " + stringExtra);
                return null;
            }
        } else {
            Logger.logError("[Scheduler] error parsing intent: no data field in the intent!");
            return null;
        }
    }

    private synchronized int getLastRequestId() {
        if (this.lastRequestId == -1) {
            this.lastRequestId = Engine.getSharedPreferencesInt(this.preferencesKey, 0);
        }
        return this.lastRequestId;
    }

    private synchronized int getNextRequestId() {
        int lastRequestId2;
        lastRequestId2 = getLastRequestId() + 1;
        setLastRequestId(lastRequestId2);
        return lastRequestId2;
    }

    private synchronized int resetLastRequestId() {
        int lastRequestId2;
        lastRequestId2 = getLastRequestId();
        setLastRequestId(0);
        return lastRequestId2;
    }

    private synchronized void setLastRequestId(int i) {
        this.lastRequestId = i;
        Engine.putSharedPreferencesInt(this.preferencesKey, i);
    }

    public synchronized void cancelAll() {
        try {
            Context context = Engine.getContext();
            int resetLastRequestId = resetLastRequestId();
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(context, this.receiverClass);
            for (int i = 1; i <= resetLastRequestId; i++) {
                PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, DriveFile.MODE_WRITE_ONLY);
                if (broadcast != null) {
                    alarmManager.cancel(broadcast);
                }
            }
        } catch (Exception e) {
            Logger.logError("[Scheduler] exception while cancelling scheduled intents : " + e.toString());
        }
        return;
    }

    public synchronized boolean schedule(long j, JSONObject jSONObject) {
        try {
            Context context = Engine.getContext();
            int nextRequestId = getNextRequestId();
            Intent intent = new Intent(context, this.receiverClass);
            intent.putExtra("data", jSONObject.toString());
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, j, PendingIntent.getBroadcast(context, nextRequestId, intent, 134217728));
        } catch (Exception e) {
            Logger.logError("[Scheduler] Error while scheduling " + jSONObject.toString() + " for " + this.receiverClass.getName() + " : " + e.toString());
            return false;
        }
        return true;
    }
}
