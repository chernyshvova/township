package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> zaa;
    public final boolean zab;
    @Nullable
    public zap zac;

    public zaq(Api<?> api, boolean z) {
        this.zaa = api;
        this.zab = z;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        zaa().onConnected(bundle);
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zaa().zaa(connectionResult, this.zaa, this.zab);
    }

    public final void onConnectionSuspended(int i) {
        zaa().onConnectionSuspended(i);
    }

    public final void zaa(zap zap) {
        this.zac = zap;
    }

    private final zap zaa() {
        Preconditions.checkNotNull(this.zac, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.zac;
    }
}
