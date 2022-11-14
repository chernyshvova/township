package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class FcmBroadcastProcessor$$Lambda$4 implements Continuation {
    public static final Continuation $instance = new FcmBroadcastProcessor$$Lambda$4();

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$1$FcmBroadcastProcessor();
    }
}
