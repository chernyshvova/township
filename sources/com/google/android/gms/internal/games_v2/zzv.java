package com.google.android.gms.internal.games_v2;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzv extends zzm {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzv(zzw zzw, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, @Nullable zzaa zzaa) {
        if (zzaa == null) {
            this.zza.setException(new ApiException(status));
        } else {
            this.zza.setResult(zzaa);
        }
    }
}
