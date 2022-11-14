package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads-base@@20.3.0 */
public final class zzgcb extends WeakReference<Throwable> {
    public final int zza;

    public zzgcb(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zza = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzgcb.class) {
            if (this == obj) {
                return true;
            }
            zzgcb zzgcb = (zzgcb) obj;
            return this.zza == zzgcb.zza && get() == zzgcb.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
