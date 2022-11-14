package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbfp extends zzhs implements zzbfr {
    public zzbfp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final boolean zzA() throws RemoteException {
        Parcel zzbq = zzbq(23, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final void zzB(zzccg zzccg) throws RemoteException {
        throw null;
    }

    public final void zzC(String str) throws RemoteException {
        throw null;
    }

    public final void zzD(String str) throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbhg zzE() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 26
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoController"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbhg
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbhg r1 = (com.google.android.gms.internal.ads.zzbhg) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbhe r2 = new com.google.android.gms.internal.ads.zzbhe
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfp.zzE():com.google.android.gms.internal.ads.zzbhg");
    }

    public final void zzF(zzbiv zzbiv) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbiv);
        zzbr(29, zza);
    }

    public final void zzG(zzbhk zzbhk) throws RemoteException {
        throw null;
    }

    public final void zzH(zzbdv zzbdv) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdv);
        zzbr(39, zza);
    }

    public final void zzI(zzaxv zzaxv) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzaxv);
        zzbr(40, zza);
    }

    public final void zzJ(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzb(zza, z);
        zzbr(34, zza);
    }

    public final void zzO(zzbha zzbha) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbha);
        zzbr(42, zza);
    }

    public final void zzP(zzbdk zzbdk, zzbfh zzbfh) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, zzbfh);
        zzbr(43, zza);
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(44, zza);
    }

    public final void zzR(zzbgf zzbgf) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbgf);
        zzbr(45, zza);
    }

    public final void zzab(zzbgc zzbgc) throws RemoteException {
        throw null;
    }

    public final IObjectWrapper zzb() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(1, zza()));
    }

    public final boolean zzbZ() throws RemoteException {
        throw null;
    }

    public final void zzc() throws RemoteException {
        zzbr(2, zza());
    }

    public final boolean zze(zzbdk zzbdk) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdk);
        Parcel zzbq = zzbq(4, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }

    public final void zzf() throws RemoteException {
        zzbr(5, zza());
    }

    public final void zzg() throws RemoteException {
        zzbr(6, zza());
    }

    public final void zzh(zzbfe zzbfe) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbfe);
        zzbr(7, zza);
    }

    public final void zzi(zzbfy zzbfy) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbfy);
        zzbr(8, zza);
    }

    public final void zzj(zzbfv zzbfv) throws RemoteException {
        throw null;
    }

    public final Bundle zzk() throws RemoteException {
        throw null;
    }

    public final void zzl() throws RemoteException {
        throw null;
    }

    public final void zzm() throws RemoteException {
        zzbr(11, zza());
    }

    public final zzbdp zzn() throws RemoteException {
        Parcel zzbq = zzbq(12, zza());
        zzbdp zzbdp = (zzbdp) zzhu.zzc(zzbq, zzbdp.CREATOR);
        zzbq.recycle();
        return zzbdp;
    }

    public final void zzo(zzbdp zzbdp) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdp);
        zzbr(13, zza);
    }

    public final void zzp(zzcaa zzcaa) throws RemoteException {
        throw null;
    }

    public final void zzq(zzcad zzcad, String str) throws RemoteException {
        throw null;
    }

    public final String zzr() throws RemoteException {
        throw null;
    }

    public final String zzs() throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbhd zzt() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 41
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IResponseInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbhd
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbhd r1 = (com.google.android.gms.internal.ads.zzbhd) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbhb r2 = new com.google.android.gms.internal.ads.zzbhb
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfp.zzt():com.google.android.gms.internal.ads.zzbhd");
    }

    public final String zzu() throws RemoteException {
        Parcel zzbq = zzbq(31, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbfy zzv() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 32
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbfy
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbfy r1 = (com.google.android.gms.internal.ads.zzbfy) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbfw r2 = new com.google.android.gms.internal.ads.zzbfw
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfp.zzv():com.google.android.gms.internal.ads.zzbfy");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbfe zzw() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 33
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbfe
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbfe r1 = (com.google.android.gms.internal.ads.zzbfe) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbfc r2 = new com.google.android.gms.internal.ads.zzbfc
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfp.zzw():com.google.android.gms.internal.ads.zzbfe");
    }

    public final void zzx(zzbki zzbki) throws RemoteException {
        throw null;
    }

    public final void zzy(zzbfb zzbfb) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbfb);
        zzbr(20, zza);
    }

    public final void zzz(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzb(zza, z);
        zzbr(22, zza);
    }
}
