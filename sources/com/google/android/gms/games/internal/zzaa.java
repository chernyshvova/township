package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzaa extends zza {
    public final TaskCompletionSource<String> zza;

    public zzaa(TaskCompletionSource<String> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzn(Status status, String str) {
        if (!status.isSuccess()) {
            TaskCompletionSource<String> taskCompletionSource = this.zza;
            int i = zzas.zze;
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(status));
            return;
        }
        this.zza.setResult(str);
    }
}
