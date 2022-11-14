package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzccr extends zzhs implements zzcct {
    public zzccr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(5, zza);
    }

    public final void zzc(zzbdk zzbdk, zzcda zzcda) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, zzcda);
        zzbr(1, zza);
    }

    public final void zzd(zzbdk zzbdk, zzcda zzcda) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, zzcda);
        zzbr(14, zza);
    }

    public final void zze(zzccw zzccw) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzccw);
        zzbr(2, zza);
    }

    public final void zzf(zzbgx zzbgx) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbgx);
        zzbr(8, zza);
    }

    public final Bundle zzg() throws RemoteException {
        Parcel zzbq = zzbq(9, zza());
        Bundle bundle = (Bundle) zzhu.zzc(zzbq, Bundle.CREATOR);
        zzbq.recycle();
        return bundle;
    }

    public final void zzh(zzcdh zzcdh) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzcdh);
        zzbr(7, zza);
    }

    public final boolean zzi() throws RemoteException {
        throw null;
    }

    public final String zzj() throws RemoteException {
        throw null;
    }

    public final void zzk(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzccq zzl() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 11
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzccq
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzccq r1 = (com.google.android.gms.internal.ads.zzccq) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzcco r2 = new com.google.android.gms.internal.ads.zzcco
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccr.zzl():com.google.android.gms.internal.ads.zzccq");
    }

    public final zzbhd zzm() throws RemoteException {
        Parcel zzbq = zzbq(12, zza());
        zzbhd zzb = zzbhc.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final void zzn(zzbha zzbha) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbha);
        zzbr(13, zza);
    }

    public final void zzo(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzb(zza, z);
        zzbr(15, zza);
    }

    public final void zzp(zzcdb zzcdb) throws RemoteException {
        throw null;
    }
}
