package com.google.firebase.messaging;

import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class FirebaseMessaging$AutoInit$$Lambda$2 implements Runnable {
    public final FirebaseMessaging.AutoInit arg$1;

    public FirebaseMessaging$AutoInit$$Lambda$2(FirebaseMessaging.AutoInit autoInit) {
        this.arg$1 = autoInit;
    }

    public final void run() {
        FirebaseMessaging.this.iid.getToken();
    }
}
