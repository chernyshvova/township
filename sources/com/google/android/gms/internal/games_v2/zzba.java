package com.google.android.gms.internal.games_v2;

import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzba implements OnCompleteListener {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzba(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        TaskCompletionSource taskCompletionSource = this.zza;
        if (!task.isSuccessful() || !((Boolean) task.getResult()).booleanValue()) {
            taskCompletionSource.trySetResult(AuthenticationResult.zzb);
        } else {
            taskCompletionSource.trySetResult(AuthenticationResult.zza);
        }
    }
}
