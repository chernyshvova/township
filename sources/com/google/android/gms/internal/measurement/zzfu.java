package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfu<E> extends zzfg<E> {
    public final transient E zza;
    public transient int zzb;

    public zzfu(E e) {
        this.zza = zzeb.zza(e);
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: zza */
    public final zzfx<E> iterator() {
        return new zzfl(this.zza);
    }

    public final boolean zzf() {
        return false;
    }

    public final boolean zzg() {
        return this.zzb != 0;
    }

    public final zzfb<E> zzh() {
        return zzfb.zza(this.zza);
    }

    public zzfu(E e, int i) {
        this.zza = e;
        this.zzb = i;
    }

    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }
}
