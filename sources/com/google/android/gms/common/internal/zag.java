package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zag implements BaseGmsClient.BaseConnectionCallbacks {
    public final /* synthetic */ ConnectionCallbacks zaa;

    public zag(ConnectionCallbacks connectionCallbacks) {
        this.zaa = connectionCallbacks;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zaa.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i) {
        this.zaa.onConnectionSuspended(i);
    }
}
