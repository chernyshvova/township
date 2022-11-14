package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzbn implements OnCompleteListener {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzbn(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        TaskCompletionSource taskCompletionSource = this.zza;
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(zzbp.zzc(((zzaa) task.getResult()).zza()));
            return;
        }
        Exception exception = task.getException();
        if (!(exception instanceof ApiException)) {
            zzfo.zza(exception);
            taskCompletionSource.trySetException(exception);
            return;
        }
        taskCompletionSource.trySetResult(zzbp.zzb(((ApiException) exception).getStatus()));
    }
}
