package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfs<E> extends zzfg<E> {
    public static final zzfs<Object> zza = new zzfs(new Object[0], 0, (Object[]) null, 0, 0);
    public final transient Object[] zzb;
    public final transient Object[] zzc;
    public final transient int zzd;
    public final transient int zze;
    public final transient int zzf;

    public zzfs(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
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
        int zza2 = zzez.zza(obj);
        while (true) {
            int i = zza2 & this.zzd;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zza2 = i + 1;
        }
    }

    public final int hashCode() {
        return this.zze;
    }

    public final int size() {
        return this.zzf;
    }

    /* renamed from: zza */
    public final zzfx<E> iterator() {
        return (zzfx) zze().iterator();
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
        return false;
    }

    public final boolean zzg() {
        return true;
    }

    public final zzfb<E> zzh() {
        return zzfb.zzb(this.zzb, this.zzf);
    }

    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzf);
        return i + this.zzf;
    }
}
