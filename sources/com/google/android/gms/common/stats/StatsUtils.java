package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class StatsUtils {
    @RecentlyNonNull
    @KeepForSdk
    public static String getEventKey(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent) {
        return String.valueOf(((long) System.identityHashCode(intent)) | (((long) System.identityHashCode(context)) << 32));
    }

    @RecentlyNonNull
    @KeepForSdk
    public static String getEventKey(@RecentlyNonNull PowerManager.WakeLock wakeLock, @RecentlyNonNull String str) {
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (true == TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }
}
