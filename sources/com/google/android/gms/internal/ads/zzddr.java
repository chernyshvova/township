package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzddr implements Runnable {
    public final WeakReference<zzdds> zza;

    public /* synthetic */ zzddr(zzdds zzdds, zzddq zzddq) {
        this.zza = new WeakReference<>(zzdds);
    }

    public final void run() {
        zzdds zzdds = (zzdds) this.zza.get();
        if (zzdds != null) {
            zzdds.zzr(zzddp.zza);
        }
    }
}
