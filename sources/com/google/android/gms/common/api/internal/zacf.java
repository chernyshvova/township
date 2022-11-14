package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zacf implements Runnable {
    public final /* synthetic */ zak zaa;
    public final /* synthetic */ zace zab;

    public zacf(zace zace, zak zak) {
        this.zab = zace;
        this.zaa = zak;
    }

    public final void run() {
        this.zab.zab(this.zaa);
    }
}
