package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeku implements zzbcz {
    @GuardedBy("this")
    public zzbfb zza;

    public final synchronized void onAdClicked() {
        zzbfb zzbfb = this.zza;
        if (zzbfb != null) {
            try {
                zzbfb.zzb();
            } catch (RemoteException e) {
                zzcgs.zzj("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zza(zzbfb zzbfb) {
        this.zza = zzbfb;
    }
}
