package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final class zzp extends WeakReference<Throwable> {
    public final int zza;

    public zzp(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zza = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzp.class) {
            if (this == obj) {
                return true;
            }
            zzp zzp = (zzp) obj;
            return this.zza == zzp.zza && get() == zzp.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
