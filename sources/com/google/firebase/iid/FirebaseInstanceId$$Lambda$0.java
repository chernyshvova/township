package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class FirebaseInstanceId$$Lambda$0 implements Continuation {
    public final FirebaseInstanceId arg$1;
    public final String arg$2;
    public final String arg$3;

    public FirebaseInstanceId$$Lambda$0(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.arg$1 = firebaseInstanceId;
        this.arg$2 = str;
        this.arg$3 = str2;
    }

    public final Object then(Task task) {
        return this.arg$1.lambda$getInstanceId$2$FirebaseInstanceId(this.arg$2, this.arg$3);
    }
}
