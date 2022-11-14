package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcxv implements zzfqa<zzcxi> {
    public final /* synthetic */ zzfqa zza;
    public final /* synthetic */ zzcxw zzb;

    public zzcxv(zzcxw zzcxw, zzfqa zzfqa) {
        this.zzb = zzcxw;
        this.zza = zzfqa;
    }

    public final void zza(Throwable th) {
        zzche.zze.execute(new zzcxt(this.zzb));
        this.zza.zza(th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzche.zze.execute(new zzcxt(this.zzb));
        this.zza.zzb((zzcxi) obj);
    }
}
