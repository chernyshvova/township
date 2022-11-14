package com.google.firebase.iid;

import android.util.Log;
import com.google.firebase.iid.WithinAppServiceConnection;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class WithinAppServiceConnection$BindRequest$$Lambda$0 implements Runnable {
    public final WithinAppServiceConnection.BindRequest arg$1;

    public WithinAppServiceConnection$BindRequest$$Lambda$0(WithinAppServiceConnection.BindRequest bindRequest) {
        this.arg$1 = bindRequest;
    }

    public final void run() {
        WithinAppServiceConnection.BindRequest bindRequest = this.arg$1;
        String action = bindRequest.intent.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        bindRequest.finish();
    }
}
