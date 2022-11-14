package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class Batch extends BasePendingResult<BatchResult> {
    public int zab;
    public boolean zac;
    public boolean zad;
    public final PendingResult<?>[] zae;
    public final Object zaf;

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class Builder {
        public List<PendingResult<?>> zaa = new ArrayList();
        public GoogleApiClient zab;

        public Builder(@RecentlyNonNull GoogleApiClient googleApiClient) {
            this.zab = googleApiClient;
        }

        @RecentlyNonNull
        public final <R extends Result> BatchResultToken<R> add(@RecentlyNonNull PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.zaa.size());
            this.zaa.add(pendingResult);
            return batchResultToken;
        }

        @RecentlyNonNull
        public final Batch build() {
            return new Batch(this.zaa, this.zab, (zab) null);
        }
    }

    public Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zaf = new Object();
        int size = list.size();
        this.zab = size;
        this.zae = new PendingResult[size];
        if (list.isEmpty()) {
            setResult(new BatchResult(Status.RESULT_SUCCESS, this.zae));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult<?> pendingResult = list.get(i);
            this.zae[i] = pendingResult;
            pendingResult.addStatusListener(new zab(this));
        }
    }

    public final void cancel() {
        super.cancel();
        for (PendingResult<?> cancel : this.zae) {
            cancel.cancel();
        }
    }

    @RecentlyNonNull
    public final BatchResult createFailedResult(@RecentlyNonNull Status status) {
        return new BatchResult(status, this.zae);
    }

    public static /* synthetic */ int zab(Batch batch) {
        int i = batch.zab;
        batch.zab = i - 1;
        return i;
    }

    public /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zab zab2) {
        this(list, googleApiClient);
    }
}
