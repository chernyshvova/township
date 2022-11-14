package com.google.android.gms.ads.internal.util;

import android.net.ConnectivityManager;
import android.net.Network;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzo extends ConnectivityManager.NetworkCallback {
    public zzo(zzr zzr) {
    }

    public final void onAvailable(Network network) {
        synchronized (zzr.class) {
            boolean unused = zzr.zzd = true;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzr.class) {
            boolean unused = zzr.zzd = false;
        }
    }
}
