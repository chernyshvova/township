package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cg */
public final class C2311cg extends C2308cd {

    /* renamed from: a */
    public final C2310cf f3258a = new C2310cf();

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r1 = new java.util.Vector(2);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo33290a(java.lang.Throwable r5, java.lang.Throwable r6) {
        /*
            r4 = this;
            if (r6 == r5) goto L_0x004a
            if (r6 == 0) goto L_0x0042
            com.google.android.play.core.internal.cf r0 = r4.f3258a
        L_0x0006:
            java.lang.ref.ReferenceQueue<java.lang.Throwable> r1 = r0.f3257b
            java.lang.ref.Reference r1 = r1.poll()
            if (r1 == 0) goto L_0x0014
            java.util.concurrent.ConcurrentHashMap<com.google.android.play.core.internal.ce, java.util.List<java.lang.Throwable>> r2 = r0.f3256a
            r2.remove(r1)
            goto L_0x0006
        L_0x0014:
            com.google.android.play.core.internal.ce r1 = new com.google.android.play.core.internal.ce
            r2 = 0
            r1.<init>(r5, r2)
            java.util.concurrent.ConcurrentHashMap<com.google.android.play.core.internal.ce, java.util.List<java.lang.Throwable>> r2 = r0.f3256a
            java.lang.Object r1 = r2.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0025
            goto L_0x003e
        L_0x0025:
            java.util.Vector r1 = new java.util.Vector
            r2 = 2
            r1.<init>(r2)
            java.util.concurrent.ConcurrentHashMap<com.google.android.play.core.internal.ce, java.util.List<java.lang.Throwable>> r2 = r0.f3256a
            com.google.android.play.core.internal.ce r3 = new com.google.android.play.core.internal.ce
            java.lang.ref.ReferenceQueue<java.lang.Throwable> r0 = r0.f3257b
            r3.<init>(r5, r0)
            java.lang.Object r5 = r2.putIfAbsent(r3, r1)
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r1 = r5
        L_0x003e:
            r1.add(r6)
            return
        L_0x0042:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "The suppressed exception cannot be null."
            r5.<init>(r6)
            throw r5
        L_0x004a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Self suppression is not allowed."
            r5.<init>(r0, r6)
            goto L_0x0053
        L_0x0052:
            throw r5
        L_0x0053:
            goto L_0x0052
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.C2311cg.mo33290a(java.lang.Throwable, java.lang.Throwable):void");
    }
}
