package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.play.core.internal.ce */
public final class C2309ce extends WeakReference<Throwable> {

    /* renamed from: a */
    public final int f3255a;

    public C2309ce(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f3255a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == C2309ce.class) {
            if (this == obj) {
                return true;
            }
            C2309ce ceVar = (C2309ce) obj;
            return this.f3255a == ceVar.f3255a && get() == ceVar.get();
        }
    }

    public final int hashCode() {
        return this.f3255a;
    }
}
