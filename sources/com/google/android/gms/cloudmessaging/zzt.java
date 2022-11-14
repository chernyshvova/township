package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class zzt implements Continuation {
    public static final Continuation zza = new zzt();

    public final Object then(Task task) {
        return Rpc.zza(task);
    }
}
