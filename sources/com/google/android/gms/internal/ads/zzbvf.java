package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbvf extends zzhs implements zzbvh {
    public zzbvf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvk zzb(java.lang.String r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zza()
            r0.writeString(r4)
            r4 = 1
            android.os.Parcel r4 = r3.zzbq(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzbvk
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.internal.ads.zzbvk r0 = (com.google.android.gms.internal.ads.zzbvk) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.internal.ads.zzbvi r1 = new com.google.android.gms.internal.ads.zzbvi
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvf.zzb(java.lang.String):com.google.android.gms.internal.ads.zzbvk");
    }

    public final boolean zzc(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbq = zzbq(2, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }

    public final boolean zzd(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbq = zzbq(4, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }

    public final zzbxo zzf(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbq = zzbq(3, zza);
        zzbxo zzb = zzbxn.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }
}
