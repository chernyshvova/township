package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$0 implements Runnable {
    public final FirebaseMessaging arg$1;
    public final FirebaseInstanceId arg$2;

    public FirebaseMessaging$$Lambda$0(FirebaseMessaging firebaseMessaging, FirebaseInstanceId firebaseInstanceId) {
        this.arg$1 = firebaseMessaging;
        this.arg$2 = firebaseInstanceId;
    }

    public final void run() {
        FirebaseMessaging firebaseMessaging = this.arg$1;
        FirebaseInstanceId firebaseInstanceId = this.arg$2;
        if (firebaseMessaging.autoInit.isEnabled()) {
            firebaseInstanceId.getToken();
        }
    }
}
