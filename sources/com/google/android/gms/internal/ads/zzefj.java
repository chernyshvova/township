package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefj extends zzbvm implements zzdcn {
    @GuardedBy("this")
    public zzbvn zza;
    @GuardedBy("this")
    public zzdcm zzb;

    public final synchronized void zza(zzdcm zzdcm) {
        this.zzb = zzdcm;
    }

    public final synchronized void zzc(zzbvn zzbvn) {
        this.zza = zzbvn;
    }

    public final synchronized void zze() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zze();
        }
    }

    public final synchronized void zzf() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzf();
        }
    }

    public final synchronized void zzg(int i) throws RemoteException {
        zzdcm zzdcm = this.zzb;
        if (zzdcm != null) {
            zzdcm.zzb(i);
        }
    }

    public final synchronized void zzh() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzh();
        }
    }

    public final synchronized void zzi() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzi();
        }
    }

    public final synchronized void zzj() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzj();
        }
        zzdcm zzdcm = this.zzb;
        if (zzdcm != null) {
            zzdcm.zza();
        }
    }

    public final synchronized void zzk() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzk();
        }
    }

    public final synchronized void zzl(String str, String str2) throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzl(str, str2);
        }
    }

    public final synchronized void zzm(zzbnc zzbnc, String str) throws RemoteException {
    }

    public final synchronized void zzn() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzn();
        }
    }

    public final synchronized void zzo() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzo();
        }
    }

    public final synchronized void zzp(zzccm zzccm) throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzp(zzccm);
        }
    }

    public final synchronized void zzq() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzq();
        }
    }

    public final synchronized void zzr(zzccq zzccq) throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzr(zzccq);
        }
    }

    public final synchronized void zzs(int i) throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzs(i);
        }
    }

    public final synchronized void zzt() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzt();
        }
    }

    public final synchronized void zzu() throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzu();
        }
    }

    public final synchronized void zzv(String str) throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzv(str);
        }
    }

    public final synchronized void zzw(int i, String str) throws RemoteException {
        zzdcm zzdcm = this.zzb;
        if (zzdcm != null) {
            zzdcm.zzc(i, str);
        }
    }

    public final synchronized void zzx(zzbdd zzbdd) throws RemoteException {
        zzdcm zzdcm = this.zzb;
        if (zzdcm != null) {
            zzdcm.zzd(zzbdd);
        }
    }

    public final synchronized void zzy(zzbdd zzbdd) throws RemoteException {
        zzbvn zzbvn = this.zza;
        if (zzbvn != null) {
            zzbvn.zzy(zzbdd);
        }
    }
}
