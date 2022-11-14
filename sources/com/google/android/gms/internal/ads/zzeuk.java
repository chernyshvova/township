package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeuk implements zzelf<zzcvc> {
    public final /* synthetic */ zzeul zza;

    public zzeuk(zzeul zzeul) {
        this.zza = zzeul;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcvc zzcvc = (zzcvc) obj;
        synchronized (this.zza) {
            zzcvc zzcvc2 = this.zza.zza;
            if (zzcvc2 != null) {
                zzcvc2.zzT();
            }
            zzeul zzeul = this.zza;
            zzeul.zza = zzcvc;
            zzcvc.zza(zzeul);
            zzeud zzM = this.zza.zzg;
            zzeul zzeul2 = this.zza;
            zzM.zzn(new zzcvd(zzcvc, zzeul2, zzeul2.zzg));
            zzcvc.zzS();
        }
    }
}
