package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefk extends zzcck implements zzdcn {
    @GuardedBy("this")
    public zzccl zza;
    @GuardedBy("this")
    public zzdcm zzb;
    @GuardedBy("this")
    public zzdin zzc;

    public final synchronized void zza(zzdcm zzdcm) {
        this.zzb = zzdcm;
    }

    public final synchronized void zzc(zzccl zzccl) {
        this.zza = zzccl;
    }

    public final synchronized void zzd(zzdin zzdin) {
        this.zzc = zzdin;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdin zzdin = this.zzc;
        if (zzdin != null) {
            ((zzeic) zzdin).zzd.zzb.execute(new zzeib((zzeic) zzdin, ((zzeic) zzdin).zza, ((zzeic) zzdin).zzb, ((zzeic) zzdin).zzc));
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdin zzdin = this.zzc;
        if (zzdin != null) {
            String valueOf = String.valueOf(((zzeic) zzdin).zzc.zza);
            zzcgs.zzi(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
        }
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdcm zzdcm = this.zzb;
        if (zzdcm != null) {
            zzdcm.zza();
        }
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccl zzccl = this.zza;
        if (zzccl != null) {
            ((zzeid) zzccl).zza.zzbE();
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccl zzccl = this.zza;
        if (zzccl != null) {
            ((zzeid) zzccl).zzd.zza();
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccl zzccl = this.zza;
        if (zzccl != null) {
            zzccl.zzj(iObjectWrapper);
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, zzccm zzccm) throws RemoteException {
        zzccl zzccl = this.zza;
        if (zzccl != null) {
            ((zzeid) zzccl).zzd.zzb(zzccm);
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccl zzccl = this.zza;
        if (zzccl != null) {
            ((zzeid) zzccl).zzb.onAdClicked();
        }
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdcm zzdcm = this.zzb;
        if (zzdcm != null) {
            zzdcm.zzb(i);
        }
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccl zzccl = this.zza;
        if (zzccl != null) {
            ((zzeid) zzccl).zzc.zzb();
        }
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccl zzccl = this.zza;
        if (zzccl != null) {
            ((zzeid) zzccl).zzc.zzf();
        }
    }
}
