package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzlo {
    public final zzajq zza = new zzajq();

    public final zzlo zza(int i) {
        this.zza.zza(i);
        return this;
    }

    public final zzlo zzb(int i, boolean z) {
        zzajq zzajq = this.zza;
        if (z) {
            zzajq.zza(i);
        }
        return this;
    }

    public final zzlo zzc(int... iArr) {
        zzajq zzajq = this.zza;
        for (int zza2 : iArr) {
            zzajq.zza(zza2);
        }
        return this;
    }

    public final zzlo zzd(zzlp zzlp) {
        zzajq zzajq = this.zza;
        zzajr zza2 = zzlp.zzc;
        for (int i = 0; i < zza2.zza(); i++) {
            zzajq.zza(zza2.zzb(i));
        }
        return this;
    }

    public final zzlp zze() {
        return new zzlp(this.zza.zzb(), (zzlm) null);
    }
}
