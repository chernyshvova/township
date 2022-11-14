package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaas implements GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ StatusPendingResult zaa;

    public zaas(zaar zaar, StatusPendingResult statusPendingResult) {
        this.zaa = statusPendingResult;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zaa.setResult(new Status(8));
    }
}
