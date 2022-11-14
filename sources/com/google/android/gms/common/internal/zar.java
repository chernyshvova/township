package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zar implements PendingResult.StatusListener {
    public final /* synthetic */ PendingResult zaa;
    public final /* synthetic */ TaskCompletionSource zab;
    public final /* synthetic */ PendingResultUtil.ResultConverter zac;
    public final /* synthetic */ PendingResultUtil.zaa zad;

    public zar(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.zaa zaa2) {
        this.zaa = pendingResult;
        this.zab = taskCompletionSource;
        this.zac = resultConverter;
        this.zad = zaa2;
    }

    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            this.zab.setResult(this.zac.convert(this.zaa.await(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.zab.setException(this.zad.zaa(status));
    }
}
