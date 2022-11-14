package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C2349i;

/* renamed from: com.google.android.play.core.review.b */
public final class C2332b extends ResultReceiver {

    /* renamed from: a */
    public final /* synthetic */ C2349i f3268a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2332b(Handler handler, C2349i iVar) {
        super(handler);
        this.f3268a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        this.f3268a.mo33331b(null);
    }
}
