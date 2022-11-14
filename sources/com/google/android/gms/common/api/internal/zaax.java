package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaax extends zabm {
    public WeakReference<zaar> zaa;

    public zaax(zaar zaar) {
        this.zaa = new WeakReference<>(zaar);
    }

    public final void zaa() {
        zaar zaar = (zaar) this.zaa.get();
        if (zaar != null) {
            zaar.zae();
        }
    }
}
