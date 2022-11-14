package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class DataHolderResult implements Releasable, Result {
    @RecentlyNonNull
    @KeepForSdk
    public final DataHolder mDataHolder;
    @RecentlyNonNull
    @KeepForSdk
    public final Status mStatus;

    @KeepForSdk
    public DataHolderResult(@RecentlyNonNull DataHolder dataHolder) {
        this(dataHolder, new Status(dataHolder.getStatusCode()));
    }

    @RecentlyNonNull
    @KeepForSdk
    public Status getStatus() {
        return this.mStatus;
    }

    @KeepForSdk
    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @KeepForSdk
    public DataHolderResult(@RecentlyNonNull DataHolder dataHolder, @RecentlyNonNull Status status) {
        this.mStatus = status;
        this.mDataHolder = dataHolder;
    }
}
