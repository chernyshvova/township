package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdlz extends zzbhf {
    public final Object zza = new Object();
    @Nullable
    public final zzbhg zzb;
    @Nullable
    public final zzbvw zzc;

    public zzdlz(@Nullable zzbhg zzbhg, @Nullable zzbvw zzbvw) {
        this.zzb = zzbhg;
        this.zzc = zzbvw;
    }

    public final void zze() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzf() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzg(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzh() throws RemoteException {
        throw new RemoteException();
    }

    public final int zzi() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzj() throws RemoteException {
        zzbvw zzbvw = this.zzc;
        if (zzbvw != null) {
            return zzbvw.zzA();
        }
        return 0.0f;
    }

    public final float zzk() throws RemoteException {
        zzbvw zzbvw = this.zzc;
        if (zzbvw != null) {
            return zzbvw.zzB();
        }
        return 0.0f;
    }

    public final void zzl(zzbhj zzbhj) throws RemoteException {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg != null) {
                zzbhg.zzl(zzbhj);
            }
        }
    }

    public final float zzm() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzn() throws RemoteException {
        throw new RemoteException();
    }

    public final zzbhj zzo() throws RemoteException {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg == null) {
                return null;
            }
            zzbhj zzo = zzbhg.zzo();
            return zzo;
        }
    }

    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzq() throws RemoteException {
        throw new RemoteException();
    }
}
