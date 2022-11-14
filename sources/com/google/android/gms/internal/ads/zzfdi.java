package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdi implements zzgjg<zzfdh> {
    public final zzgju<zzfdn> zza;
    public final zzgju<zzfdu> zzb;
    public final zzgju<ScheduledExecutorService> zzc;

    public zzfdi(zzgju<zzfdn> zzgju, zzgju<zzfdu> zzgju2, zzgju<ScheduledExecutorService> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Object obj;
        zzgja<zzfdn> zzc2 = zzgjf.zzc(this.zza);
        zzgja<zzfdu> zzc3 = zzgjf.zzc(this.zzb);
        ScheduledExecutorService zzb2 = this.zzc.zzb();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfV)).booleanValue()) {
            obj = new zzfdk(zzc2.zzb(), zzb2);
        } else {
            obj = zzc3.zzb();
        }
        zzgjp.zzb(obj);
        return obj;
    }
}
