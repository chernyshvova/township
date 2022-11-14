package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzccc extends zzht implements zzccd {
    public zzccc() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.google.android.gms.internal.ads.zzccb} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzccg] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbR(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 1
            if (r3 == r6) goto L_0x0127
            r0 = 2
            if (r3 == r0) goto L_0x0120
            r0 = 3
            r1 = 0
            if (r3 == r0) goto L_0x00ff
            r0 = 34
            if (r3 == r0) goto L_0x00f4
            switch(r3) {
                case 5: goto L_0x00e9;
                case 6: goto L_0x00e2;
                case 7: goto L_0x00db;
                case 8: goto L_0x00d4;
                case 9: goto L_0x00c5;
                case 10: goto L_0x00b5;
                case 11: goto L_0x00a5;
                case 12: goto L_0x0099;
                case 13: goto L_0x008d;
                case 14: goto L_0x007d;
                case 15: goto L_0x0071;
                case 16: goto L_0x004f;
                case 17: goto L_0x0047;
                case 18: goto L_0x0037;
                case 19: goto L_0x002b;
                case 20: goto L_0x001f;
                case 21: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            r3 = 0
            return r3
        L_0x0013:
            com.google.android.gms.internal.ads.zzbhd r3 = r2.zzt()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzhu.zzf(r5, r3)
            goto L_0x0135
        L_0x001f:
            boolean r3 = r2.zzs()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzhu.zzb(r5, r3)
            goto L_0x0135
        L_0x002b:
            java.lang.String r3 = r4.readString()
            r2.zzq(r3)
            r5.writeNoException()
            goto L_0x0135
        L_0x0037:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzp(r3)
            r5.writeNoException()
            goto L_0x0135
        L_0x0047:
            r4.readString()
            r5.writeNoException()
            goto L_0x0135
        L_0x004f:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0056
            goto L_0x0069
        L_0x0056:
            java.lang.String r4 = "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r0 = r4 instanceof com.google.android.gms.internal.ads.zzccb
            if (r0 == 0) goto L_0x0064
            r1 = r4
            com.google.android.gms.internal.ads.zzccb r1 = (com.google.android.gms.internal.ads.zzccb) r1
            goto L_0x0069
        L_0x0064:
            com.google.android.gms.internal.ads.zzccb r1 = new com.google.android.gms.internal.ads.zzccb
            r1.<init>(r3)
        L_0x0069:
            r2.zzu(r1)
            r5.writeNoException()
            goto L_0x0135
        L_0x0071:
            android.os.Bundle r3 = r2.zzo()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzhu.zze(r5, r3)
            goto L_0x0135
        L_0x007d:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbfv r3 = com.google.android.gms.internal.ads.zzbfu.zzb(r3)
            r2.zzn(r3)
            r5.writeNoException()
            goto L_0x0135
        L_0x008d:
            java.lang.String r3 = r4.readString()
            r2.zzm(r3)
            r5.writeNoException()
            goto L_0x0135
        L_0x0099:
            java.lang.String r3 = r2.zzl()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0135
        L_0x00a5:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzk(r3)
            r5.writeNoException()
            goto L_0x0135
        L_0x00b5:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzj(r3)
            r5.writeNoException()
            goto L_0x0135
        L_0x00c5:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzi(r3)
            r5.writeNoException()
            goto L_0x0135
        L_0x00d4:
            r2.zzh()
            r5.writeNoException()
            goto L_0x0135
        L_0x00db:
            r2.zzg()
            r5.writeNoException()
            goto L_0x0135
        L_0x00e2:
            r2.zzf()
            r5.writeNoException()
            goto L_0x0135
        L_0x00e9:
            boolean r3 = r2.zze()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzhu.zzb(r5, r3)
            goto L_0x0135
        L_0x00f4:
            boolean r3 = com.google.android.gms.internal.ads.zzhu.zza(r4)
            r2.zzr(r3)
            r5.writeNoException()
            goto L_0x0135
        L_0x00ff:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0106
            goto L_0x0119
        L_0x0106:
            java.lang.String r4 = "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r0 = r4 instanceof com.google.android.gms.internal.ads.zzccg
            if (r0 == 0) goto L_0x0114
            r1 = r4
            com.google.android.gms.internal.ads.zzccg r1 = (com.google.android.gms.internal.ads.zzccg) r1
            goto L_0x0119
        L_0x0114:
            com.google.android.gms.internal.ads.zzcce r1 = new com.google.android.gms.internal.ads.zzcce
            r1.<init>(r3)
        L_0x0119:
            r2.zzd(r1)
            r5.writeNoException()
            goto L_0x0135
        L_0x0120:
            r2.zzc()
            r5.writeNoException()
            goto L_0x0135
        L_0x0127:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzcch> r3 = com.google.android.gms.internal.ads.zzcch.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzhu.zzc(r4, r3)
            com.google.android.gms.internal.ads.zzcch r3 = (com.google.android.gms.internal.ads.zzcch) r3
            r2.zzb(r3)
            r5.writeNoException()
        L_0x0135:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccc.zzbR(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
