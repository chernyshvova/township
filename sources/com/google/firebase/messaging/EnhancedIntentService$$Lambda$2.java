package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class EnhancedIntentService$$Lambda$2 implements OnCompleteListener {
    public final EnhancedIntentService arg$1;
    public final Intent arg$2;

    public EnhancedIntentService$$Lambda$2(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.arg$1 = enhancedIntentService;
        this.arg$2 = intent;
    }

    public final void onComplete(Task task) {
        this.arg$1.lambda$onStartCommand$1$EnhancedIntentService(this.arg$2, task);
    }
}
