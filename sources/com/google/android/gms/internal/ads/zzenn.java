package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzenn implements zzeqp<zzeno> {
    public final zzfqo zza;
    public final zzdsx zzb;
    public final String zzc;
    public final zzeyw zzd;

    public zzenn(zzfqo zzfqo, zzdsx zzdsx, zzeyw zzeyw, String str) {
        this.zza = zzfqo;
        this.zzb = zzdsx;
        this.zzd = zzeyw;
        this.zzc = str;
    }

    public final zzfqn<zzeno> zza() {
        return this.zza.zzb(new zzenm(this));
    }

    public final /* synthetic */ zzeno zzb() throws Exception {
        return new zzeno(this.zzb.zzb(this.zzd.zzf, this.zzc), this.zzb.zzc());
    }
}
