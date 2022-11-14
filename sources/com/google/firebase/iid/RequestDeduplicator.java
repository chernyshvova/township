package com.google.firebase.iid;

import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public class RequestDeduplicator {
    public final Executor executor;
    @GuardedBy("this")
    public final Map<Pair<String, String>, Task<InstanceIdResult>> getTokenRequests = new ArrayMap();

    public RequestDeduplicator(Executor executor2) {
        this.executor = executor2;
    }
}
