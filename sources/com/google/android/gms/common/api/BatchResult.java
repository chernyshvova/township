package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class BatchResult implements Result {
    public final Status zaa;
    public final PendingResult<?>[] zab;

    public BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.zaa = status;
        this.zab = pendingResultArr;
    }

    @RecentlyNonNull
    public final Status getStatus() {
        return this.zaa;
    }

    @RecentlyNonNull
    public final <R extends Result> R take(@RecentlyNonNull BatchResultToken<R> batchResultToken) {
        Preconditions.checkArgument(batchResultToken.mId < this.zab.length, "The result token does not belong to this batch");
        return this.zab[batchResultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
