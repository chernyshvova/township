package com.google.android.gms.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final /* synthetic */ class zaa implements SuccessContinuation {
    public static final SuccessContinuation zaa = new zaa();

    public final Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
