package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class OptionalPendingResult<R extends Result> extends PendingResult<R> {
    @RecentlyNonNull
    public abstract R get();

    public abstract boolean isDone();
}
