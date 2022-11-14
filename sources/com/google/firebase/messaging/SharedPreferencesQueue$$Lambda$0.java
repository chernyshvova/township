package com.google.firebase.messaging;

import android.content.SharedPreferences;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class SharedPreferencesQueue$$Lambda$0 implements Runnable {
    public final SharedPreferencesQueue arg$1;

    public SharedPreferencesQueue$$Lambda$0(SharedPreferencesQueue sharedPreferencesQueue) {
        this.arg$1 = sharedPreferencesQueue;
    }

    public final void run() {
        SharedPreferencesQueue sharedPreferencesQueue = this.arg$1;
        synchronized (sharedPreferencesQueue.internalQueue) {
            SharedPreferences.Editor edit = sharedPreferencesQueue.sharedPreferences.edit();
            String str = sharedPreferencesQueue.queueName;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = sharedPreferencesQueue.internalQueue.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(sharedPreferencesQueue.itemSeparator);
            }
            edit.putString(str, sb.toString()).commit();
        }
    }
}
