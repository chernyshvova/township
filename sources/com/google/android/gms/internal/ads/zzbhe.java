package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhe extends zzhs implements zzbhg {
    public zzbhe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final void zze() throws RemoteException {
        zzbr(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbr(2, zza());
    }

    public final void zzg(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzb(zza, z);
        zzbr(3, zza);
    }

    public final boolean zzh() throws RemoteException {
        Parcel zzbq = zzbq(4, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final int zzi() throws RemoteException {
        Parcel zzbq = zzbq(5, zza());
        int readInt = zzbq.readInt();
        zzbq.recycle();
        return readInt;
    }

    public final float zzj() throws RemoteException {
        throw null;
    }

    public final float zzk() throws RemoteException {
        throw null;
    }

    public final void zzl(zzbhj zzbhj) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbhj);
        zzbr(8, zza);
    }

    public final float zzm() throws RemoteException {
        throw null;
    }

    public final boolean zzn() throws RemoteException {
        Parcel zzbq = zzbq(10, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbhj zzo() throws android.os.RemoteException {
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
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbhj
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbhj r1 = (com.google.android.gms.internal.ads.zzbhj) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbhh r2 = new com.google.android.gms.internal.ads.zzbhh
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhe.zzo():com.google.android.gms.internal.ads.zzbhj");
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzbq = zzbq(12, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final void zzq() throws RemoteException {
        zzbr(13, zza());
    }
}
