package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzci implements Continuation {
    public final ListenerHolder zzfo;

    public zzci(ListenerHolder listenerHolder) {
        this.zzfo = listenerHolder;
    }

    public final Object then(Task task) {
        return zzch.zza(this.zzfo, task);
    }
}
