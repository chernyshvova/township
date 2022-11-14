package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdre extends VideoController.VideoLifecycleCallbacks {
    public final zzdma zza;

    public zzdre(zzdma zzdma) {
        this.zza = zzdma;
    }

    public static zzbhj zza(zzdma zzdma) {
        zzbhg zzw = zzdma.zzw();
        if (zzw == null) {
            return null;
        }
        try {
            return zzw.zzo();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void onVideoEnd() {
        zzbhj zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzh();
            } catch (RemoteException e) {
                zzcgs.zzj("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzbhj zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzg();
            } catch (RemoteException e) {
                zzcgs.zzj("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoStart() {
        zzbhj zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zze();
            } catch (RemoteException e) {
                zzcgs.zzj("Unable to call onVideoEnd()", e);
            }
        }
    }
}
