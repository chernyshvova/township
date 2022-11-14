package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaat implements GoogleApiClient.ConnectionCallbacks {
    public final /* synthetic */ AtomicReference zaa;
    public final /* synthetic */ StatusPendingResult zab;
    public final /* synthetic */ zaar zac;

    public zaat(zaar zaar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zac = zaar;
        this.zaa = atomicReference;
        this.zab = statusPendingResult;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zac.zaa((GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.zaa.get()), this.zab, true);
    }

    public final void onConnectionSuspended(int i) {
    }
}
