package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaam implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ zaaf zaa;

    public zaam(zaaf zaaf) {
        this.zaa = zaaf;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        ClientSettings clientSettings = (ClientSettings) Preconditions.checkNotNull(this.zaa.zar);
        ((zae) Preconditions.checkNotNull(this.zaa.zak)).zaa(new zaak(this.zaa));
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zaa.zab.lock();
        try {
            if (this.zaa.zaa(connectionResult)) {
                this.zaa.zag();
                this.zaa.zae();
            } else {
                this.zaa.zab(connectionResult);
            }
        } finally {
            this.zaa.zab.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
    }

    public /* synthetic */ zaam(zaaf zaaf, zaae zaae) {
        this(zaaf);
    }
}
