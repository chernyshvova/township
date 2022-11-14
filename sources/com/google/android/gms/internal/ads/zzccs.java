package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzccs extends zzht implements zzcct {
    public zzccs() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzcct zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (queryLocalInterface instanceof zzcct) {
            return (zzcct) queryLocalInterface;
        }
        return new zzccr(iBinder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.google.android.gms.internal.ads.zzcdb} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzcda] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.internal.ads.zzccw] */
    /* JADX WARNING: type inference failed for: r0v14, types: [com.google.android.gms.internal.ads.zzcda] */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbR(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            java.lang.String r5 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback"
            r0 = 0
            switch(r2) {
                case 1: goto L_0x010c;
                case 2: goto L_0x00eb;
                case 3: goto L_0x00e0;
                case 4: goto L_0x00d5;
                case 5: goto L_0x00c6;
                case 6: goto L_0x00a4;
                case 7: goto L_0x0094;
                case 8: goto L_0x0084;
                case 9: goto L_0x0078;
                case 10: goto L_0x0064;
                case 11: goto L_0x0058;
                case 12: goto L_0x004c;
                case 13: goto L_0x003c;
                case 14: goto L_0x0014;
                case 15: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            r2 = 0
            return r2
        L_0x0008:
            boolean r2 = com.google.android.gms.internal.ads.zzhu.zza(r3)
            r1.zzo(r2)
            r4.writeNoException()
            goto L_0x0132
        L_0x0014:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbdk> r2 = com.google.android.gms.internal.ads.zzbdk.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhu.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzbdk r2 = (com.google.android.gms.internal.ads.zzbdk) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0023
            goto L_0x0034
        L_0x0023:
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzcda
            if (r0 == 0) goto L_0x002f
            r0 = r5
            com.google.android.gms.internal.ads.zzcda r0 = (com.google.android.gms.internal.ads.zzcda) r0
            goto L_0x0034
        L_0x002f:
            com.google.android.gms.internal.ads.zzccy r0 = new com.google.android.gms.internal.ads.zzccy
            r0.<init>(r3)
        L_0x0034:
            r1.zzd(r2, r0)
            r4.writeNoException()
            goto L_0x0132
        L_0x003c:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbha r2 = com.google.android.gms.internal.ads.zzbgz.zzb(r2)
            r1.zzn(r2)
            r4.writeNoException()
            goto L_0x0132
        L_0x004c:
            com.google.android.gms.internal.ads.zzbhd r2 = r1.zzm()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhu.zzf(r4, r2)
            goto L_0x0132
        L_0x0058:
            com.google.android.gms.internal.ads.zzccq r2 = r1.zzl()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhu.zzf(r4, r2)
            goto L_0x0132
        L_0x0064:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            boolean r3 = com.google.android.gms.internal.ads.zzhu.zza(r3)
            r1.zzk(r2, r3)
            r4.writeNoException()
            goto L_0x0132
        L_0x0078:
            android.os.Bundle r2 = r1.zzg()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhu.zze(r4, r2)
            goto L_0x0132
        L_0x0084:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbgx r2 = com.google.android.gms.internal.ads.zzbgw.zzb(r2)
            r1.zzf(r2)
            r4.writeNoException()
            goto L_0x0132
        L_0x0094:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzcdh> r2 = com.google.android.gms.internal.ads.zzcdh.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhu.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzcdh r2 = (com.google.android.gms.internal.ads.zzcdh) r2
            r1.zzh(r2)
            r4.writeNoException()
            goto L_0x0132
        L_0x00a4:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00ab
            goto L_0x00be
        L_0x00ab:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzcdb
            if (r5 == 0) goto L_0x00b9
            r0 = r3
            com.google.android.gms.internal.ads.zzcdb r0 = (com.google.android.gms.internal.ads.zzcdb) r0
            goto L_0x00be
        L_0x00b9:
            com.google.android.gms.internal.ads.zzcdb r0 = new com.google.android.gms.internal.ads.zzcdb
            r0.<init>(r2)
        L_0x00be:
            r1.zzp(r0)
            r4.writeNoException()
            goto L_0x0132
        L_0x00c6:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zzb(r2)
            r4.writeNoException()
            goto L_0x0132
        L_0x00d5:
            java.lang.String r2 = r1.zzj()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x0132
        L_0x00e0:
            boolean r2 = r1.zzi()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhu.zzb(r4, r2)
            goto L_0x0132
        L_0x00eb:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00f2
            goto L_0x0105
        L_0x00f2:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzccw
            if (r5 == 0) goto L_0x0100
            r0 = r3
            com.google.android.gms.internal.ads.zzccw r0 = (com.google.android.gms.internal.ads.zzccw) r0
            goto L_0x0105
        L_0x0100:
            com.google.android.gms.internal.ads.zzccu r0 = new com.google.android.gms.internal.ads.zzccu
            r0.<init>(r2)
        L_0x0105:
            r1.zze(r0)
            r4.writeNoException()
            goto L_0x0132
        L_0x010c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbdk> r2 = com.google.android.gms.internal.ads.zzbdk.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhu.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzbdk r2 = (com.google.android.gms.internal.ads.zzbdk) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x011b
            goto L_0x012c
        L_0x011b:
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzcda
            if (r0 == 0) goto L_0x0127
            r0 = r5
            com.google.android.gms.internal.ads.zzcda r0 = (com.google.android.gms.internal.ads.zzcda) r0
            goto L_0x012c
        L_0x0127:
            com.google.android.gms.internal.ads.zzccy r0 = new com.google.android.gms.internal.ads.zzccy
            r0.<init>(r3)
        L_0x012c:
            r1.zzc(r2, r0)
            r4.writeNoException()
        L_0x0132:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccs.zzbR(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
