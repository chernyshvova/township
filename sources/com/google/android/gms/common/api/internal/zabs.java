package com.google.android.gms.common.api.internal;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final /* synthetic */ class zabs implements Runnable {
    public final NonGmsServiceBrokerClient zaa;
    public final IBinder zab;

    public zabs(NonGmsServiceBrokerClient nonGmsServiceBrokerClient, IBinder iBinder) {
        this.zaa = nonGmsServiceBrokerClient;
        this.zab = iBinder;
    }

    public final void run() {
        this.zaa.zaa(this.zab);
    }
}
