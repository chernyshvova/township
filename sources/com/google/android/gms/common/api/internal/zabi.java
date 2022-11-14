package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zabi implements Runnable {
    public final /* synthetic */ zabg zaa;

    public zabi(zabg zabg) {
        this.zaa = zabg;
    }

    public final void run() {
        this.zaa.zaa.zac.disconnect(this.zaa.zaa.zac.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
