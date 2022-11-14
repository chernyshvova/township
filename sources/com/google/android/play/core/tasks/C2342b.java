package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.b */
public final class C2342b<ResultT> implements C2347g<ResultT> {

    /* renamed from: a */
    public final Executor f3286a;

    /* renamed from: b */
    public final Object f3287b = new Object();

    /* renamed from: c */
    public final OnCompleteListener<ResultT> f3288c;

    public C2342b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f3286a = executor;
        this.f3288c = onCompleteListener;
    }

    /* renamed from: a */
    public final void mo33325a(Task<ResultT> task) {
        synchronized (this.f3287b) {
            if (this.f3288c != null) {
                this.f3286a.execute(new C2341a(this, task));
            }
        }
    }
}
