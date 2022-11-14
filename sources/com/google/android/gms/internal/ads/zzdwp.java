package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdwp implements Runnable {
    public final zzdww zza;
    public final Object zzb;
    public final zzchj zzc;
    public final String zzd;
    public final long zze;

    public zzdwp(zzdww zzdww, Object obj, zzchj zzchj, String str, long j) {
        this.zza = zzdww;
        this.zzb = obj;
        this.zzc = zzchj;
        this.zzd = str;
        this.zze = j;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
