package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfoe<E> extends zzfmv<E> {
    public static final zzfoe<Object> zza = new zzfoe(new Object[0], 0, (Object[]) null, 0, 0);
    public final transient Object[] zzb;
    public final transient Object[] zzc;
    public final transient int zzd;
    public final transient int zze;
    public final transient int zzf;

    public zzfoe(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zzc = objArr2;
        this.zzd = i2;
        this.zze = i;
        this.zzf = i3;
    }

    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr == null) {
            return false;
        }
        int zzb2 = zzfmd.zzb(obj);
        while (true) {
            int i = zzb2 & this.zzd;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzb2 = i + 1;
        }
    }

    public final int hashCode() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    public final int size() {
        return this.zzf;
    }

    public final zzfom<E> zza() {
        return zze().listIterator(0);
    }

    public final Object[] zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final boolean zzf() {
        throw null;
    }

    public final int zzg(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzf);
        return i + this.zzf;
    }

    public final boolean zzj() {
        return true;
    }

    public final zzfml<E> zzk() {
        return zzfml.zzs(this.zzb, this.zzf);
    }
}
