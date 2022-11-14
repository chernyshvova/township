package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbod extends zzhs implements zzbof {
    public zzbod(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    public final boolean zzA() throws RemoteException {
        Parcel zzbq = zzbq(24, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final void zzB(zzbgq zzbgq) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbgq);
        zzbr(25, zza);
    }

    public final void zzC(zzbgm zzbgm) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbgm);
        zzbr(26, zza);
    }

    public final void zzD() throws RemoteException {
        zzbr(27, zza());
    }

    public final void zzE() throws RemoteException {
        zzbr(28, zza());
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbmf zzF() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 29
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbmf
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbmf r1 = (com.google.android.gms.internal.ads.zzbmf) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbmd r2 = new com.google.android.gms.internal.ads.zzbmd
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbod.zzF():com.google.android.gms.internal.ads.zzbmf");
    }

    public final boolean zzG() throws RemoteException {
        Parcel zzbq = zzbq(30, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final zzbhd zzH() throws RemoteException {
        Parcel zzbq = zzbq(31, zza());
        zzbhd zzb = zzbhc.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final void zzI(zzbha zzbha) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbha);
        zzbr(32, zza);
    }

    public final String zze() throws RemoteException {
        Parcel zzbq = zzbq(2, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final List zzf() throws RemoteException {
        Parcel zzbq = zzbq(3, zza());
        ArrayList zzg = zzhu.zzg(zzbq);
        zzbq.recycle();
        return zzg;
    }

    public final String zzg() throws RemoteException {
        Parcel zzbq = zzbq(4, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbmi zzh() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 5
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbmi
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzbmi r1 = (com.google.android.gms.internal.ads.zzbmi) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzbmg r2 = new com.google.android.gms.internal.ads.zzbmg
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbod.zzh():com.google.android.gms.internal.ads.zzbmi");
    }

    public final String zzi() throws RemoteException {
        Parcel zzbq = zzbq(6, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final String zzj() throws RemoteException {
        Parcel zzbq = zzbq(7, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final double zzk() throws RemoteException {
        Parcel zzbq = zzbq(8, zza());
        double readDouble = zzbq.readDouble();
        zzbq.recycle();
        return readDouble;
    }

    public final String zzl() throws RemoteException {
        Parcel zzbq = zzbq(9, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final String zzm() throws RemoteException {
        Parcel zzbq = zzbq(10, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final zzbhg zzn() throws RemoteException {
        Parcel zzbq = zzbq(11, zza());
        zzbhg zzb = zzbhf.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final String zzo() throws RemoteException {
        Parcel zzbq = zzbq(12, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final void zzp() throws RemoteException {
        zzbr(13, zza());
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbma zzq() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 14
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IAttributionInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbma
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbma r1 = (com.google.android.gms.internal.ads.zzbma) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbly r2 = new com.google.android.gms.internal.ads.zzbly
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbod.zzq():com.google.android.gms.internal.ads.zzbma");
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, bundle);
        zzbr(15, zza);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, bundle);
        Parcel zzbq = zzbq(16, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }

    public final void zzt(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, bundle);
        zzbr(17, zza);
    }

    public final IObjectWrapper zzu() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(18, zza()));
    }

    public final IObjectWrapper zzv() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(19, zza()));
    }

    public final Bundle zzw() throws RemoteException {
        Parcel zzbq = zzbq(20, zza());
        Bundle bundle = (Bundle) zzhu.zzc(zzbq, Bundle.CREATOR);
        zzbq.recycle();
        return bundle;
    }

    public final void zzx(zzboc zzboc) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzboc);
        zzbr(21, zza);
    }

    public final void zzy() throws RemoteException {
        zzbr(22, zza());
    }

    public final List zzz() throws RemoteException {
        Parcel zzbq = zzbq(23, zza());
        ArrayList zzg = zzhu.zzg(zzbq);
        zzbq.recycle();
        return zzg;
    }
}
