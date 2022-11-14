package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzgc extends WeakReference<Throwable> {
    public final int zza;

    public zzgc(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zza = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzgc.class) {
            if (this == obj) {
                return true;
            }
            zzgc zzgc = (zzgc) obj;
            return this.zza == zzgc.zza && get() == zzgc.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
