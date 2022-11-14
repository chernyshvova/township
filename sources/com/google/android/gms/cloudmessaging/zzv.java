package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class zzv implements Continuation {
    public final Rpc zza;
    public final Bundle zzb;

    public zzv(Rpc rpc, Bundle bundle) {
        this.zza = rpc;
        this.zzb = bundle;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, task);
    }
}
