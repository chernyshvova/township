package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.d */
public final class C2344d<ResultT> implements C2347g<ResultT> {

    /* renamed from: a */
    public final Executor f3291a;

    /* renamed from: b */
    public final Object f3292b = new Object();

    /* renamed from: c */
    public final OnFailureListener f3293c;

    public C2344d(Executor executor, OnFailureListener onFailureListener) {
        this.f3291a = executor;
        this.f3293c = onFailureListener;
    }

    /* renamed from: a */
    public final void mo33325a(Task<ResultT> task) {
        if (!task.isSuccessful()) {
            synchronized (this.f3292b) {
                if (this.f3293c != null) {
                    this.f3291a.execute(new C2343c(this, task));
                }
            }
        }
    }
}
