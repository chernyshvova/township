package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaav implements ResultCallback<Status> {
    public final /* synthetic */ StatusPendingResult zaa;
    public final /* synthetic */ boolean zab;
    public final /* synthetic */ GoogleApiClient zac;
    public final /* synthetic */ zaar zad;

    public zaav(zaar zaar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.zad = zaar;
        this.zaa = statusPendingResult;
        this.zab = z;
        this.zac = googleApiClient;
    }

    public final /* synthetic */ void onResult(@NonNull Result result) {
        Status status = (Status) result;
        Storage.getInstance(this.zad.zaj).zaa();
        if (status.isSuccess() && this.zad.isConnected()) {
            this.zad.reconnect();
        }
        this.zaa.setResult(status);
        if (this.zab) {
            this.zac.disconnect();
        }
    }
}
