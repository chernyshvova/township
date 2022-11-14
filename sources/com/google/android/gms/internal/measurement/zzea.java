package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzea<T> extends zzdy<T> {
    public final T zza;

    public zzea(T t) {
        this.zza = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzea) {
            return this.zza.equals(((zzea) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return GeneratedOutlineSupport.outline12(valueOf.length() + 13, "Optional.of(", valueOf, ")");
    }

    public final boolean zza() {
        return true;
    }

    public final T zzb() {
        return this.zza;
    }
}
