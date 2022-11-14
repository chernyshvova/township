package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzee<T> implements zzec<T>, Serializable {
    public final zzec<T> zza;
    public volatile transient boolean zzb;
    @NullableDecl
    public transient T zzc;

    public zzee(zzec<T> zzec) {
        this.zza = (zzec) zzeb.zza(zzec);
    }

    public final String toString() {
        Object obj;
        if (this.zzb) {
            String valueOf = String.valueOf(this.zzc);
            obj = GeneratedOutlineSupport.outline12(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        } else {
            obj = this.zza;
        }
        String valueOf2 = String.valueOf(obj);
        return GeneratedOutlineSupport.outline12(valueOf2.length() + 19, "Suppliers.memoize(", valueOf2, ")");
    }

    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
