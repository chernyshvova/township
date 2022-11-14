package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzeg<T> implements zzec<T>, Serializable {
    @NullableDecl
    public final T zza;

    public zzeg(@NullableDecl T t) {
        this.zza = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzeg) {
            return zzdz.zza(this.zza, ((zzeg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return GeneratedOutlineSupport.outline12(valueOf.length() + 22, "Suppliers.ofInstance(", valueOf, ")");
    }

    public final T zza() {
        return this.zza;
    }
}
