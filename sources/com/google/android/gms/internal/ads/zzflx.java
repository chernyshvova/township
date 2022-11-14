package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzflx<T> extends zzfnx<T> implements Serializable {
    public final Comparator<T> zza;

    public zzflx(Comparator<T> comparator) {
        if (comparator != null) {
            this.zza = comparator;
            return;
        }
        throw null;
    }

    public final int compare(T t, T t2) {
        return this.zza.compare(t, t2);
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzflx) {
            return this.zza.equals(((zzflx) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }
}
