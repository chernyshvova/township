package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zar implements Runnable {
    public final /* synthetic */ zas zaa;

    public zar(zas zas) {
        this.zaa = zas;
    }

    public final void run() {
        this.zaa.zam.lock();
        try {
            this.zaa.zah();
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
