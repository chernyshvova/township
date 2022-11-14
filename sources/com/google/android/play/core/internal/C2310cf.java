package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.play.core.internal.cf */
public final class C2310cf {

    /* renamed from: a */
    public final ConcurrentHashMap<C2309ce, List<Throwable>> f3256a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    public final ReferenceQueue<Throwable> f3257b = new ReferenceQueue<>();
}
