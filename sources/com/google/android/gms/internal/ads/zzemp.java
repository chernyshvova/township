package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzemp implements zzeqp<zzemq> {
    public final zzfqo zza;
    public final zzeyw zzb;
    public final zzcgy zzc;
    public final zzcgh zzd;

    public zzemp(zzfqo zzfqo, zzeyw zzeyw, zzcgy zzcgy, zzcgh zzcgh) {
        this.zza = zzfqo;
        this.zzb = zzeyw;
        this.zzc = zzcgy;
        this.zzd = zzcgh;
    }

    public final zzfqn<zzemq> zza() {
        return this.zza.zzb(new zzemo(this));
    }

    public final /* synthetic */ zzemq zzb() throws Exception {
        return new zzemq(this.zzb.zzj, this.zzc, this.zzd.zzj());
    }
}
