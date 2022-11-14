package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.i */
public final class C2349i<ResultT> {

    /* renamed from: a */
    public final C2353m<ResultT> f3302a = new C2353m<>();

    /* renamed from: b */
    public final void mo33330b(Exception exc) {
        C2353m<ResultT> mVar = this.f3302a;
        synchronized (mVar.f3304a) {
            if (!mVar.f3306c) {
                mVar.f3306c = true;
                mVar.f3308e = exc;
                mVar.f3305b.mo33328a(mVar);
            }
        }
    }

    /* renamed from: b */
    public final void mo33331b(ResultT resultt) {
        C2353m<ResultT> mVar = this.f3302a;
        synchronized (mVar.f3304a) {
            if (!mVar.f3306c) {
                mVar.f3306c = true;
                mVar.f3307d = resultt;
                mVar.f3305b.mo33328a(mVar);
            }
        }
    }
}
