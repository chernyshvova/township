package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaa implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzac zzc;

    public zzaa(zzac zzac, String str, long j) {
        this.zzc = zzac;
        this.zza = str;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        this.zzc.zza.zzb(this.zzc.toString());
    }
}
