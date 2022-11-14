package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaw implements OnCompleteListener<TResult> {
    public final /* synthetic */ TaskCompletionSource zaa;
    public final /* synthetic */ zav zab;

    public zaw(zav zav, TaskCompletionSource taskCompletionSource) {
        this.zab = zav;
        this.zaa = taskCompletionSource;
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        this.zab.zab.remove(this.zaa);
    }
}
