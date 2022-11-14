package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfoj<E> extends zzfmv<E> {
    public final transient E zza;
    public transient int zzb;

    public zzfoj(E e) {
        if (e != null) {
            this.zza = e;
            return;
        }
        throw null;
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

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new zzfmw(this.zza);
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

    public final zzfom<E> zza() {
        return new zzfmw(this.zza);
    }

    public final boolean zzf() {
        throw null;
    }

    public final int zzg(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    public final boolean zzj() {
        return this.zzb != 0;
    }

    public final zzfml<E> zzk() {
        return zzfml.zzj(this.zza);
    }

    public zzfoj(E e, int i) {
        this.zza = e;
        this.zzb = i;
    }
}
