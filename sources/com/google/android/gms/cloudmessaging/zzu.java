package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class zzu implements Runnable {
    public final TaskCompletionSource zza;

    public zzu(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        Rpc.zza(this.zza);
    }
}
