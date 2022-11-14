package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$1 implements OnSuccessListener {
    public final FirebaseMessaging arg$1;

    public FirebaseMessaging$$Lambda$1(FirebaseMessaging firebaseMessaging) {
        this.arg$1 = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        boolean z;
        TopicsSubscriber topicsSubscriber = (TopicsSubscriber) obj;
        if (this.arg$1.autoInit.isEnabled()) {
            if (topicsSubscriber.store.getNextTopicOperation() != null) {
                synchronized (topicsSubscriber) {
                    z = topicsSubscriber.syncScheduledOrRunning;
                }
                if (!z) {
                    topicsSubscriber.syncWithDelaySecondsInternal(0);
                }
            }
        }
    }
}
