package com.google.firebase.messaging;

import android.content.Context;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.iid.Metadata;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class TopicsSubscriber$$Lambda$0 implements Callable {
    public final Context arg$1;
    public final ScheduledExecutorService arg$2;
    public final FirebaseInstanceId arg$3;
    public final Metadata arg$4;
    public final GmsRpc arg$5;

    public TopicsSubscriber$$Lambda$0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, Metadata metadata, GmsRpc gmsRpc) {
        this.arg$1 = context;
        this.arg$2 = scheduledExecutorService;
        this.arg$3 = firebaseInstanceId;
        this.arg$4 = metadata;
        this.arg$5 = gmsRpc;
    }

    public final Object call() {
        TopicsStore topicsStore;
        Context context = this.arg$1;
        ScheduledExecutorService scheduledExecutorService = this.arg$2;
        FirebaseInstanceId firebaseInstanceId = this.arg$3;
        Metadata metadata = this.arg$4;
        GmsRpc gmsRpc = this.arg$5;
        synchronized (TopicsStore.class) {
            topicsStore = null;
            if (TopicsStore.topicsStoreWeakReference != null) {
                topicsStore = (TopicsStore) TopicsStore.topicsStoreWeakReference.get();
            }
            if (topicsStore == null) {
                TopicsStore topicsStore2 = new TopicsStore(context.getSharedPreferences("com.google.android.gms.appid", 0), scheduledExecutorService);
                synchronized (topicsStore2) {
                    topicsStore2.topicOperationsQueue = SharedPreferencesQueue.createInstance(topicsStore2.sharedPreferences, "topic_operation_queue", ",", topicsStore2.syncExecutor);
                }
                TopicsStore.topicsStoreWeakReference = new WeakReference<>(topicsStore2);
                topicsStore = topicsStore2;
            }
        }
        return new TopicsSubscriber(firebaseInstanceId, metadata, topicsStore, gmsRpc, context, scheduledExecutorService);
    }
}
