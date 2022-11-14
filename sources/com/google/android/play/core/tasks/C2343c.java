package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.c */
public final class C2343c implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Task f3289a;

    /* renamed from: b */
    public final /* synthetic */ C2344d f3290b;

    public C2343c(C2344d dVar, Task task) {
        this.f3290b = dVar;
        this.f3289a = task;
    }

    public final void run() {
        Exception exc;
        synchronized (this.f3290b.f3292b) {
            if (this.f3290b.f3293c != null) {
                OnFailureListener onFailureListener = this.f3290b.f3293c;
                C2353m mVar = (C2353m) this.f3289a;
                synchronized (mVar.f3304a) {
                    exc = mVar.f3308e;
                }
                onFailureListener.onFailure(exc);
            }
        }
    }
}
