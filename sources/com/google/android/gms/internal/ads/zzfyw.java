package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfyw extends zzgdy<zzfyx, zzfyw> implements zzgfl {
    public zzfyw() {
        super(zzfyx.zzg);
    }

    public final zzfyw zza(String str) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzfyx.zzh((zzfyx) this.zza, str);
        return this;
    }

    public final zzfyw zzb(zzgcz zzgcz) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzfyx) this.zza).zze = zzgcz;
        return this;
    }

    public final zzfyw zzc(zzfzy zzfzy) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzfyx) this.zza).zzf = zzfzy.zza();
        return this;
    }

    public /* synthetic */ zzfyw(zzfyv zzfyv) {
        super(zzfyx.zzg);
    }
}
