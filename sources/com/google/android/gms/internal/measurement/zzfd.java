package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfd extends zzfb<E> {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzfb zzc;

    public zzfd(zzfb zzfb, int i, int i2) {
        this.zzc = zzfb;
        this.zza = i;
        this.zzb = i2;
    }

    public final E get(int i) {
        zzeb.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    /* renamed from: zza */
    public final zzfb<E> subList(int i, int i2) {
        zzeb.zza(i, i2, this.zzb);
        zzfb zzfb = this.zzc;
        int i3 = this.zza;
        return (zzfb) zzfb.subList(i + i3, i2 + i3);
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
}
