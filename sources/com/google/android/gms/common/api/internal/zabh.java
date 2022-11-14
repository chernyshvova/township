package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zabh implements Runnable {
    public final /* synthetic */ ConnectionResult zaa;
    public final /* synthetic */ GoogleApiManager.zaa zab;

    public zabh(GoogleApiManager.zaa zaa2, ConnectionResult connectionResult) {
        this.zab = zaa2;
        this.zaa = connectionResult;
    }

    public final void run() {
        this.zab.onConnectionFailed(this.zaa);
    }
}
