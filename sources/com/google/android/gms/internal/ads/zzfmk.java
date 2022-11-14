package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfmk extends zzfml {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzfml zzc;

    public zzfmk(zzfml zzfml, int i, int i2) {
        this.zzc = zzfml;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzfke.zze(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final boolean zzf() {
        return true;
    }

    /* renamed from: zzh */
    public final zzfml subList(int i, int i2) {
        zzfke.zzg(i, i2, this.zzb);
        zzfml zzfml = this.zzc;
        int i3 = this.zza;
        return zzfml.subList(i + i3, i2 + i3);
    }
}
