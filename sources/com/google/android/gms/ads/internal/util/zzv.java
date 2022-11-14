package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;

@TargetApi(18)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzv extends zzu {
    public boolean zzg(View view) {
        return super.zzg(view) || view.getWindowId() != null;
    }

    public final int zzh() {
        return 14;
    }

    public final long zzi() {
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
    }
}
