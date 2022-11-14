package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WakeLocks {
    public static final String TAG = Logger.tagWithPrefix("WakeLocks");
    public static final WeakHashMap<PowerManager.WakeLock, String> sWakeLocks = new WeakHashMap<>();

    public static void checkWakeLocks() {
        HashMap hashMap = new HashMap();
        synchronized (sWakeLocks) {
            hashMap.putAll(sWakeLocks);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.get().warning(TAG, String.format("WakeLock held for %s", new Object[]{hashMap.get(wakeLock)}), new Throwable[0]);
            }
        }
    }

    public static PowerManager.WakeLock newWakeLock(@NonNull Context context, @NonNull String str) {
        String outline16 = GeneratedOutlineSupport.outline16("WorkManager: ", str);
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, outline16);
        synchronized (sWakeLocks) {
            sWakeLocks.put(newWakeLock, outline16);
        }
        return newWakeLock;
    }
}
