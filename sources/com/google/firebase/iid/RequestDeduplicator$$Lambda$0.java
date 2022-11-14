package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class RequestDeduplicator$$Lambda$0 implements Continuation {
    public final RequestDeduplicator arg$1;
    public final Pair arg$2;

    public RequestDeduplicator$$Lambda$0(RequestDeduplicator requestDeduplicator, Pair pair) {
        this.arg$1 = requestDeduplicator;
        this.arg$2 = pair;
    }

    public final Object then(Task task) {
        RequestDeduplicator requestDeduplicator = this.arg$1;
        Pair pair = this.arg$2;
        synchronized (requestDeduplicator) {
            requestDeduplicator.getTokenRequests.remove(pair);
        }
        return task;
    }
}
