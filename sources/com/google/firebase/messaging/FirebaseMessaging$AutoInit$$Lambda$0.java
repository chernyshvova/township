package com.google.firebase.messaging;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class FirebaseMessaging$AutoInit$$Lambda$0 implements EventHandler {
    public final FirebaseMessaging.AutoInit arg$1;

    public FirebaseMessaging$AutoInit$$Lambda$0(FirebaseMessaging.AutoInit autoInit) {
        this.arg$1 = autoInit;
    }

    public final void handle(Event event) {
        FirebaseMessaging.AutoInit autoInit = this.arg$1;
        if (autoInit.isEnabled()) {
            FirebaseMessaging.this.fileIoExecutor.execute(new FirebaseMessaging$AutoInit$$Lambda$2(autoInit));
        }
    }
}
