package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcql implements zzdvu {
    public final /* synthetic */ zzcqn zza;
    public Long zzb;
    public String zzc;

    public /* synthetic */ zzcql(zzcqn zzcqn, zzcpp zzcpp) {
        this.zza = zzcqn;
    }

    public final zzdvv zza() {
        zzgjp.zzc(this.zzb, Long.class);
        zzgjp.zzc(this.zzc, String.class);
        return new zzcqm(this.zza, this.zzb, this.zzc, (zzcpp) null);
    }

    public final /* bridge */ /* synthetic */ zzdvu zzb(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzdvu zzc(long j) {
        this.zzb = Long.valueOf(j);
        return this;
    }
}
