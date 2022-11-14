package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.internal.ah */
public abstract class C2293ah implements Runnable {

    /* renamed from: a */
    public final C2349i<?> f3230a;

    public C2293ah() {
        this.f3230a = null;
    }

    public C2293ah(C2349i<?> iVar) {
        this.f3230a = iVar;
    }

    /* renamed from: a */
    public abstract void mo33154a();

    public final void run() {
        try {
            mo33154a();
        } catch (Exception e) {
            C2349i<?> iVar = this.f3230a;
            if (iVar != null) {
                iVar.mo33330b(e);
            }
        }
    }
}
