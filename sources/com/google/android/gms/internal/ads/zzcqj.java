package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqj {
    public zzcos zza;
    public zzcrc zzb;
    public zzfdb zzc;
    public zzcrn zzd;
    public zzezs zze;

    public zzcqj() {
    }

    public /* synthetic */ zzcqj(zzcpp zzcpp) {
    }

    public final zzcqj zza(zzcos zzcos) {
        this.zza = zzcos;
        return this;
    }

    public final zzcqj zzb(zzcrc zzcrc) {
        this.zzb = zzcrc;
        return this;
    }

    public final zzcop zzc() {
        zzgjp.zzc(this.zza, zzcos.class);
        zzgjp.zzc(this.zzb, zzcrc.class);
        if (this.zzc == null) {
            this.zzc = new zzfdb();
        }
        if (this.zzd == null) {
            this.zzd = new zzcrn();
        }
        if (this.zze == null) {
            this.zze = new zzezs();
        }
        return new zzcra(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (zzcpp) null);
    }
}
