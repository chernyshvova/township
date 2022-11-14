package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdwj implements zzdvt {
    public final long zza;
    public final String zzb;
    public final zzdvy zzc;
    public final zzexv zzd;

    public zzdwj(long j, Context context, zzdvy zzdvy, zzcop zzcop, String str) {
        this.zza = j;
        this.zzb = str;
        this.zzc = zzdvy;
        zzexx zzt = zzcop.zzt();
        zzt.zzc(context);
        zzt.zzb(str);
        this.zzd = zzt.zza().zzb();
    }

    public final void zza(zzbdk zzbdk) {
        try {
            this.zzd.zzc(zzbdk, new zzdwh(this));
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzb() {
        try {
            this.zzd.zze(new zzdwi(this));
            this.zzd.zzb(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzc() {
    }
}
