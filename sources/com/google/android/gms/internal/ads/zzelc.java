package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzelc implements zzdbg {
    public final zzekq zza;
    public final zzbsh zzb;

    public zzelc(zzekq zzekq, zzbsh zzbsh) {
        this.zza = zzekq;
        this.zzb = zzbsh;
    }

    public final void zzbT(zzbdd zzbdd) {
        zzekq zzekq = this.zza;
        zzbsh zzbsh = this.zzb;
        zzekq.zzbT(zzbdd);
        if (zzbsh != null) {
            try {
                zzbsh.zzg(zzbdd);
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
        if (zzbsh != null) {
            try {
                zzbsh.zzf(zzbdd.zza);
            } catch (RemoteException e2) {
                zzcgs.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
