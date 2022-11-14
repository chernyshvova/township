package com.google.android.gms.ads.internal.util;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzm implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzr zzb;

    public zzm(zzr zzr, Context context) {
        this.zzb = zzr;
        this.zza = context;
    }

    public final void run() {
        synchronized (this.zzb.zzf) {
            String unused = this.zzb.zzg = zzr.zzU(this.zza);
            this.zzb.zzf.notifyAll();
        }
    }
}
