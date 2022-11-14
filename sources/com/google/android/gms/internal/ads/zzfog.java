package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfog<T> extends zzfnx<T> implements Serializable {
    public final zzfnx<? super T> zza;

    public zzfog(zzfnx<? super T> zzfnx) {
        this.zza = zzfnx;
    }

    public final int compare(T t, T t2) {
        return this.zza.compare(t2, t);
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfog) {
            return this.zza.equals(((zzfog) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 10), valueOf, ".reverse()");
    }

    public final <S extends T> zzfnx<S> zza() {
        return this.zza;
    }
}
