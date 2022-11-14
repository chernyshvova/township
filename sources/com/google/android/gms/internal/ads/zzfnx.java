package com.google.android.gms.internal.ads;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfnx<T> implements Comparator<T> {
    public static <C extends Comparable> zzfnx<C> zzb() {
        return zzfnv.zza;
    }

    public static <T> zzfnx<T> zzc(Comparator<T> comparator) {
        if (comparator instanceof zzfnx) {
            return (zzfnx) comparator;
        }
        return new zzflx(comparator);
    }

    public abstract int compare(@NullableDecl T t, @NullableDecl T t2);

    public <S extends T> zzfnx<S> zza() {
        return new zzfog(this);
    }
}
