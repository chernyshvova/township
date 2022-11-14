package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzext extends zzfgi {
    public final /* synthetic */ zzbgx zza;
    public final /* synthetic */ zzexv zzb;

    public zzext(zzexv zzexv, zzbgx zzbgx) {
        this.zzb = zzexv;
        this.zza = zzbgx;
    }

    public final void zzl() {
        if (this.zzb.zzf != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
