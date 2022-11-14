package com.google.android.gms.internal.consent_sdk;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzck extends WeakReference<Throwable> {
    public final int zza;

    public zzck(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zza = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzck.class) {
            if (this == obj) {
                return true;
            }
            zzck zzck = (zzck) obj;
            return this.zza == zzck.zza && get() == zzck.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
