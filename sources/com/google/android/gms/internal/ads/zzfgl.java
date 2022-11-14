package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzfgl implements Continuation {
    public static final Continuation zza = new zzfgl();

    public final Object then(Task task) {
        return Boolean.valueOf(task.isSuccessful());
    }
}
