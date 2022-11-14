package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.e */
public final class C2345e implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Task f3294a;

    /* renamed from: b */
    public final /* synthetic */ C2346f f3295b;

    public C2345e(C2346f fVar, Task task) {
        this.f3295b = fVar;
        this.f3294a = task;
    }

    public final void run() {
        synchronized (this.f3295b.f3297b) {
            if (this.f3295b.f3298c != null) {
                this.f3295b.f3298c.onSuccess(this.f3294a.getResult());
            }
        }
    }
}
