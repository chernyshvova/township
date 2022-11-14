package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcxu implements zzfqa<zzcxp> {
    public final /* synthetic */ zzfqa zza;
    public final /* synthetic */ zzcxw zzb;

    public zzcxu(zzcxw zzcxw, zzfqa zzfqa) {
        this.zzb = zzcxw;
        this.zza = zzfqa;
    }

    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzche.zze.execute(new zzcxt(this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcxw.zze(this.zzb, ((zzcxp) obj).zza, this.zza);
    }
}
