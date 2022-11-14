package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class zzx implements OnCompleteListener {
    public final Rpc zza;
    public final String zzb;
    public final ScheduledFuture zzc;

    public zzx(Rpc rpc, String str, ScheduledFuture scheduledFuture) {
        this.zza = rpc;
        this.zzb = str;
        this.zzc = scheduledFuture;
    }

    public final void onComplete(Task task) {
        this.zza.zza(this.zzb, this.zzc, task);
    }
}
