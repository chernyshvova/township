package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxa implements zztv {
    public final /* synthetic */ zzxb zza;

    public /* synthetic */ zzxa(zzxb zzxb, zzwz zzwz) {
        this.zza = zzxb;
    }

    public final boolean zza() {
        return true;
    }

    public final zztt zzb(long j) {
        long zzi = this.zza.zzd.zzi(j);
        zztw zztw = new zztw(j, zzalh.zzy((this.zza.zzb + (((this.zza.zzc - this.zza.zzb) * zzi) / this.zza.zzf)) - 30000, this.zza.zzb, this.zza.zzc - 1));
        return new zztt(zztw, zztw);
    }

    public final long zzc() {
        return this.zza.zzd.zzh(this.zza.zzf);
    }
}
