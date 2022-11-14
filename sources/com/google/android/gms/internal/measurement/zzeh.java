package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzeh<T> implements zzec<T> {
    public volatile zzec<T> zza;
    public volatile boolean zzb;
    @NullableDecl
    public T zzc;

    public zzeh(zzec<T> zzec) {
        this.zza = (zzec) zzeb.zza(zzec);
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            String valueOf = String.valueOf(this.zzc);
            obj = GeneratedOutlineSupport.outline12(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
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
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
