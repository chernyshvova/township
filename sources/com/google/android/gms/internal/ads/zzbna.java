package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbna extends zzhs implements zzbnc {
    public zzbna(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public final String zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbq = zzbq(1, zza);
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbmi zzf(java.lang.String r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zza()
            r0.writeString(r4)
            r4 = 2
            android.os.Parcel r4 = r3.zzbq(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzbmi
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.internal.ads.zzbmi r0 = (com.google.android.gms.internal.ads.zzbmi) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.internal.ads.zzbmg r1 = new com.google.android.gms.internal.ads.zzbmg
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbna.zzf(java.lang.String):com.google.android.gms.internal.ads.zzbmi");
    }

    public final List<String> zzg() throws RemoteException {
        Parcel zzbq = zzbq(3, zza());
        ArrayList<String> createStringArrayList = zzbq.createStringArrayList();
        zzbq.recycle();
        return createStringArrayList;
    }

    public final String zzh() throws RemoteException {
        Parcel zzbq = zzbq(4, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final void zzi(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbr(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzbr(6, zza());
    }

    public final zzbhg zzk() throws RemoteException {
        Parcel zzbq = zzbq(7, zza());
        zzbhg zzb = zzbhf.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final void zzl() throws RemoteException {
        zzbr(8, zza());
    }

    public final IObjectWrapper zzm() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(9, zza()));
    }

    public final boolean zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        Parcel zzbq = zzbq(10, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }

    public final boolean zzo() throws RemoteException {
        Parcel zzbq = zzbq(12, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzbq = zzbq(13, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(14, zza);
    }

    public final void zzr() throws RemoteException {
        zzbr(15, zza());
    }
}
