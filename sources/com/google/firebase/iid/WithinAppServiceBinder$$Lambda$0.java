package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.WithinAppServiceConnection;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class WithinAppServiceBinder$$Lambda$0 implements OnCompleteListener {
    public final WithinAppServiceConnection.BindRequest arg$1;

    public WithinAppServiceBinder$$Lambda$0(WithinAppServiceConnection.BindRequest bindRequest) {
        this.arg$1 = bindRequest;
    }

    public final void onComplete(Task task) {
        this.arg$1.finish();
    }
}
