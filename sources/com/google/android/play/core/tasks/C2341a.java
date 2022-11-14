package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.a */
public final class C2341a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Task f3284a;

    /* renamed from: b */
    public final /* synthetic */ C2342b f3285b;

    public C2341a(C2342b bVar, Task task) {
        this.f3285b = bVar;
        this.f3284a = task;
    }

    public final void run() {
        synchronized (this.f3285b.f3287b) {
            if (this.f3285b.f3288c != null) {
                this.f3285b.f3288c.onComplete(this.f3284a);
            }
        }
    }
}
