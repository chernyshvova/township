package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzt extends zzu {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzu zzc;

    public zzt(zzu zzu, int i, int i2) {
        this.zzc = zzu;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzl.zza(i, this.zzb, "index");
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
    public final zzu subList(int i, int i2) {
        zzl.zzc(i, i2, this.zzb);
        zzu zzu = this.zzc;
        int i3 = this.zza;
        return zzu.subList(i + i3, i2 + i3);
    }
}
