package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.f */
public final class C2346f<ResultT> implements C2347g<ResultT> {

    /* renamed from: a */
    public final Executor f3296a;

    /* renamed from: b */
    public final Object f3297b = new Object();

    /* renamed from: c */
    public final OnSuccessListener<? super ResultT> f3298c;

    public C2346f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f3296a = executor;
        this.f3298c = onSuccessListener;
    }

    /* renamed from: a */
    public final void mo33325a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.f3297b) {
                if (this.f3298c != null) {
                    this.f3296a.execute(new C2345e(this, task));
                }
            }
        }
    }
}
