package com.google.android.play.core.internal;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.cc */
public final class C2307cc extends C2306cb {

    /* renamed from: a */
    public final C2306cb f3252a;

    /* renamed from: b */
    public final long f3253b;

    /* renamed from: c */
    public final long f3254c;

    public C2307cc(C2306cb cbVar, long j, long j2) {
        this.f3252a = cbVar;
        long a = mo33288a(j);
        this.f3253b = a;
        this.f3254c = mo33288a(a + j2);
    }

    /* renamed from: a */
    public final long mo33192a() {
        return this.f3254c - this.f3253b;
    }

    /* renamed from: a */
    public final long mo33288a(long j) {
        if (j < 0) {
            return 0;
        }
        return j > this.f3252a.mo33192a() ? this.f3252a.mo33192a() : j;
    }

    /* renamed from: a */
    public final InputStream mo33193a(long j, long j2) throws IOException {
        long a = mo33288a(this.f3253b);
        return this.f3252a.mo33193a(a, mo33288a(j2 + a) - a);
    }

    public final void close() throws IOException {
    }
}
