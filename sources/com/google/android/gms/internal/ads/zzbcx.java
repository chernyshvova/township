package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbcx extends zzgdy<zzbcy, zzbcx> implements zzgfl {
    public zzbcx() {
        super(zzbcy.zzg);
    }

    public final boolean zza() {
        return ((zzbcy) this.zza).zza();
    }

    public final zzbcx zzb(boolean z) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzbcy.zze((zzbcy) this.zza, z);
        return this;
    }

    public final zzbcx zzc(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzbcy.zzf((zzbcy) this.zza, i);
        return this;
    }

    public /* synthetic */ zzbcx(zzaze zzaze) {
        super(zzbcy.zzg);
    }
}
