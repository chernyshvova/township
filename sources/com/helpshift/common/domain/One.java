package com.helpshift.common.domain;

import java.util.concurrent.atomic.AtomicBoolean;

public class One extends C2500F {

    /* renamed from: f */
    public final C2500F f3329f;
    public final AtomicBoolean running = new AtomicBoolean(false);

    public One(C2500F f) {
        this.f3329f = f;
    }

    /* renamed from: f */
    public void mo33949f() {
        if (this.running.compareAndSet(false, true)) {
            try {
                this.f3329f.mo33949f();
            } finally {
                this.running.set(false);
            }
        }
    }

    public C2500F getF() {
        return this.f3329f;
    }
}
