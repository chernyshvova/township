package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzw<E> extends zzu<E> {
    public static final zzu<Object> zza = new zzw(new Object[0], 0);
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzw(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final E get(int i) {
        zzl.zza(i, this.zzc, "index");
        return this.zzb[i];
    }

    public final int size() {
        return this.zzc;
    }

    public final Object[] zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final boolean zzf() {
        return false;
    }

    public final int zzg(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
