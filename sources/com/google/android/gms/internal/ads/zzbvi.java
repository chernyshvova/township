package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbvi extends zzhs implements zzbvk {
    public zzbvi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zzA(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzb(zza, z);
        zzbr(25, zza);
    }

    public final zzbhg zzB() throws RemoteException {
        Parcel zzbq = zzbq(26, zza());
        zzbhg zzb = zzbhf.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvw zzC() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 27
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbvw
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbvw r1 = (com.google.android.gms.internal.ads.zzbvw) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbvu r2 = new com.google.android.gms.internal.ads.zzbvu
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvi.zzC():com.google.android.gms.internal.ads.zzbvw");
    }

    public final void zzD(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzd(zza, zzbdk);
        zza.writeString(str);
        zzhu.zzf(zza, zzbvn);
        zzbr(28, zza);
    }

    public final void zzE(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(30, zza);
    }

    public final void zzF(IObjectWrapper iObjectWrapper, zzbrq zzbrq, List<zzbrw> list) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzbrq);
        zza.writeTypedList(list);
        zzbr(31, zza);
    }

    public final void zzG(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzd(zza, zzbdk);
        zza.writeString(str);
        zzhu.zzf(zza, zzbvn);
        zzbr(32, zza);
    }

    public final zzbyb zzH() throws RemoteException {
        Parcel zzbq = zzbq(33, zza());
        zzbyb zzbyb = (zzbyb) zzhu.zzc(zzbq, zzbyb.CREATOR);
        zzbq.recycle();
        return zzbyb;
    }

    public final zzbyb zzI() throws RemoteException {
        Parcel zzbq = zzbq(34, zza());
        zzbyb zzbyb = (zzbyb) zzhu.zzc(zzbq, zzbyb.CREATOR);
        zzbq.recycle();
        return zzbyb;
    }

    public final void zzJ(IObjectWrapper iObjectWrapper, zzbdp zzbdp, zzbdk zzbdk, String str, String str2, zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzd(zza, zzbdp);
        zzhu.zzd(zza, zzbdk);
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzf(zza, zzbvn);
        zzbr(35, zza);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvq zzK() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 36
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbvq
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbvq r1 = (com.google.android.gms.internal.ads.zzbvq) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbvo r2 = new com.google.android.gms.internal.ads.zzbvo
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvi.zzK():com.google.android.gms.internal.ads.zzbvq");
    }

    public final void zzL(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(37, zza);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvs zzM() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 15
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbvs
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbvs r1 = (com.google.android.gms.internal.ads.zzbvs) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbvs r2 = new com.google.android.gms.internal.ads.zzbvs
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvi.zzM():com.google.android.gms.internal.ads.zzbvs");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvt zzN() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 16
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbvt
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbvt r1 = (com.google.android.gms.internal.ads.zzbvt) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbvt r2 = new com.google.android.gms.internal.ads.zzbvt
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvi.zzN():com.google.android.gms.internal.ads.zzbvt");
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzbdp zzbdp, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
        throw null;
    }

    public final IObjectWrapper zzf() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(2, zza()));
    }

    public final void zzg(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
        throw null;
    }

    public final void zzh() throws RemoteException {
        zzbr(4, zza());
    }

    public final void zzi() throws RemoteException {
        zzbr(5, zza());
    }

    public final void zzj(IObjectWrapper iObjectWrapper, zzbdp zzbdp, zzbdk zzbdk, String str, String str2, zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzd(zza, zzbdp);
        zzhu.zzd(zza, zzbdk);
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzf(zza, zzbvn);
        zzbr(6, zza);
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, String str2, zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzd(zza, zzbdk);
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzf(zza, zzbvn);
        zzbr(7, zza);
    }

    public final void zzl() throws RemoteException {
        zzbr(8, zza());
    }

    public final void zzm() throws RemoteException {
        zzbr(9, zza());
    }

    public final void zzn(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzccl zzccl, String str2) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzd(zza, zzbdk);
        zza.writeString((String) null);
        zzhu.zzf(zza, zzccl);
        zza.writeString(str2);
        zzbr(10, zza);
    }

    public final void zzo(zzbdk zzbdk, String str) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdk);
        zza.writeString(str);
        zzbr(11, zza);
    }

    public final void zzp() throws RemoteException {
        zzbr(12, zza());
    }

    public final boolean zzq() throws RemoteException {
        Parcel zzbq = zzbq(13, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, String str2, zzbvn zzbvn, zzblw zzblw, List<String> list) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzd(zza, zzbdk);
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzf(zza, zzbvn);
        zzhu.zzd(zza, zzblw);
        zza.writeStringList(list);
        zzbr(14, zza);
    }

    public final Bundle zzs() throws RemoteException {
        throw null;
    }

    public final Bundle zzt() throws RemoteException {
        throw null;
    }

    public final Bundle zzu() throws RemoteException {
        throw null;
    }

    public final void zzv(zzbdk zzbdk, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(21, zza);
    }

    public final boolean zzx() throws RemoteException {
        Parcel zzbq = zzbq(22, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzccl zzccl, List<String> list) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzccl);
        zza.writeStringList(list);
        zzbr(23, zza);
    }

    public final zzbnc zzz() throws RemoteException {
        throw null;
    }
}
