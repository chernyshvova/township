package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzuy implements zztv {
    public final /* synthetic */ zztv zza;
    public final /* synthetic */ zzuz zzb;

    public zzuy(zzuz zzuz, zztv zztv) {
        this.zzb = zzuz;
        this.zza = zztv;
    }

    public final boolean zza() {
        return this.zza.zza();
    }

    public final zztt zzb(long j) {
        zztt zzb2 = this.zza.zzb(j);
        zztw zztw = zzb2.zza;
        zztw zztw2 = new zztw(zztw.zzb, this.zzb.zzb + zztw.zzc);
        zztw zztw3 = zzb2.zzb;
        return new zztt(zztw2, new zztw(zztw3.zzb, this.zzb.zzb + zztw3.zzc));
    }

    public final long zzc() {
        return this.zza.zzc();
    }
}
