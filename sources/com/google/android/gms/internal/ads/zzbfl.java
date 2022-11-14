package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbfl extends zzhs implements zzbfn {
    public zzbfl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbfk zze() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 1
            android.os.Parcel r0 = r4.zzbq(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbfk
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzbfk r1 = (com.google.android.gms.internal.ads.zzbfk) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzbfi r2 = new com.google.android.gms.internal.ads.zzbfi
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfl.zze():com.google.android.gms.internal.ads.zzbfk");
    }

    public final void zzf(zzbfe zzbfe) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbfe);
        zzbr(2, zza);
    }

    public final void zzg(zzbng zzbng) throws RemoteException {
        throw null;
    }

    public final void zzh(zzbnj zzbnj) throws RemoteException {
        throw null;
    }

    public final void zzi(String str, zzbnp zzbnp, zzbnm zzbnm) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzhu.zzf(zza, zzbnp);
        zzhu.zzf(zza, zzbnm);
        zzbr(5, zza);
    }

    public final void zzj(zzblw zzblw) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzblw);
        zzbr(6, zza);
    }

    public final void zzk(zzbnt zzbnt, zzbdp zzbdp) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbnt);
        zzhu.zzd(zza, zzbdp);
        zzbr(8, zza);
    }

    public final void zzl(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        throw null;
    }

    public final void zzm(zzbnw zzbnw) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbnw);
        zzbr(10, zza);
    }

    public final void zzn(zzbry zzbry) throws RemoteException {
        throw null;
    }

    public final void zzo(zzbsh zzbsh) throws RemoteException {
        throw null;
    }

    public final void zzp(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, adManagerAdViewOptions);
        zzbr(15, zza);
    }

    public final void zzq(zzbgc zzbgc) throws RemoteException {
        throw null;
    }
}
