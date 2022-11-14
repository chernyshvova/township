package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaae implements Runnable {
    public final /* synthetic */ zaaf zaa;

    public zaae(zaaf zaaf) {
        this.zaa = zaaf;
    }

    public final void run() {
        this.zaa.zad.cancelAvailabilityErrorNotifications(this.zaa.zac);
    }
}
