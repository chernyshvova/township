package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzelb {
    public final zzelg<zzcxi> zza;
    public final String zzb;
    @GuardedBy("this")
    @Nullable
    public zzbhd zzc;

    public zzelb(zzelg<zzcxi> zzelg, String str) {
        this.zza = zzelg;
        this.zzb = str;
    }

    public final synchronized boolean zza() throws RemoteException {
        return this.zza.zzb();
    }

    public final synchronized void zzb(zzbdk zzbdk, int i) throws RemoteException {
        this.zzc = null;
        this.zza.zza(zzbdk, this.zzb, new zzelh(i), new zzela(this));
    }

    public final synchronized String zzc() {
        String str;
        str = null;
        try {
            zzbhd zzbhd = this.zzc;
            if (zzbhd != null) {
                str = zzbhd.zze();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return str;
    }

    public final synchronized String zzd() {
        String str;
        str = null;
        try {
            zzbhd zzbhd = this.zzc;
            if (zzbhd != null) {
                str = zzbhd.zze();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return str;
    }
}
