package com.google.android.play.core.tasks;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.play.core.tasks.n */
public final class C2354n implements OnSuccessListener, OnFailureListener {

    /* renamed from: a */
    public final CountDownLatch f3309a = new CountDownLatch(1);

    public /* synthetic */ C2354n(byte[] bArr) {
    }

    public final void onFailure(Exception exc) {
        this.f3309a.countDown();
    }

    public final void onSuccess(Object obj) {
        this.f3309a.countDown();
    }
}
