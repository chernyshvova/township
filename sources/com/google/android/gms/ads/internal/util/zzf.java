package com.google.android.gms.ads.internal.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzfjj;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzf extends zzfjj {
    public zzf(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzs.zzg().zzg(e, "AdMobHandler.handleMessage");
        }
    }

    public final void zza(Message message) {
        try {
            super.zza(message);
        } catch (Throwable th) {
            zzs.zzc();
            zzr.zzO(zzs.zzg().zzm(), th);
            throw th;
        }
    }
}
