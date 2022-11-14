package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.m */
public final class C2353m<ResultT> extends Task<ResultT> {

    /* renamed from: a */
    public final Object f3304a = new Object();

    /* renamed from: b */
    public final C2348h<ResultT> f3305b = new C2348h<>();

    /* renamed from: c */
    public boolean f3306c;

    /* renamed from: d */
    public ResultT f3307d;

    /* renamed from: e */
    public Exception f3308e;

    /* renamed from: a */
    public final void mo33334a(Exception exc) {
        synchronized (this.f3304a) {
            if (!this.f3306c) {
                this.f3306c = true;
                this.f3308e = exc;
            } else {
                throw new IllegalStateException("Task is already complete");
            }
        }
        this.f3305b.mo33328a(this);
    }

    /* renamed from: c */
    public final void mo33336c() {
        synchronized (this.f3304a) {
            if (this.f3306c) {
                this.f3305b.mo33328a(this);
            }
        }
    }

    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.f3304a) {
            if (this.f3306c) {
                Exception exc = this.f3308e;
                if (exc == null) {
                    resultt = this.f3307d;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw new IllegalStateException("Task is not yet complete");
            }
        }
        return resultt;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f3304a) {
            z = false;
            if (this.f3306c && this.f3308e == null) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final void mo33335a(ResultT resultt) {
        synchronized (this.f3304a) {
            if (!this.f3306c) {
                this.f3306c = true;
                this.f3307d = resultt;
            } else {
                throw new IllegalStateException("Task is already complete");
            }
        }
        this.f3305b.mo33328a(this);
    }
}
