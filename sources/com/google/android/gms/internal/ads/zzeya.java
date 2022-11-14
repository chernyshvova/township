package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeya extends zzfgi {
    public final /* synthetic */ zzbfv zza;
    public final /* synthetic */ zzeyb zzb;

    public zzeya(zzeyb zzeyb, zzbfv zzbfv) {
        this.zzb = zzeyb;
        this.zza = zzbfv;
    }

    public final void zzl() {
        if (this.zzb.zzd != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
