package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zacg implements Runnable {
    public final /* synthetic */ zace zaa;

    public zacg(zace zace) {
        this.zaa = zace;
    }

    public final void run() {
        this.zaa.zah.zaa(new ConnectionResult(4));
    }
}
