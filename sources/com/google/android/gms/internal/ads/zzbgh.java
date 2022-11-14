package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbgh extends zzht implements zzbgi {
    public zzbgh() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbR(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x00e1;
                case 2: goto L_0x00d6;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00c0;
                case 5: goto L_0x00ad;
                case 6: goto L_0x009a;
                case 7: goto L_0x008f;
                case 8: goto L_0x0084;
                case 9: goto L_0x0079;
                case 10: goto L_0x006d;
                case 11: goto L_0x005d;
                case 12: goto L_0x004d;
                case 13: goto L_0x0041;
                case 14: goto L_0x0031;
                case 15: goto L_0x0029;
                case 16: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x000d
            r1 = 0
            goto L_0x0021
        L_0x000d:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzbgu
            if (r4 == 0) goto L_0x001b
            r1 = r2
            com.google.android.gms.internal.ads.zzbgu r1 = (com.google.android.gms.internal.ads.zzbgu) r1
            goto L_0x0021
        L_0x001b:
            com.google.android.gms.internal.ads.zzbgs r2 = new com.google.android.gms.internal.ads.zzbgs
            r2.<init>(r1)
            r1 = r2
        L_0x0021:
            r0.zzt(r1)
            r3.writeNoException()
            goto L_0x00e7
        L_0x0029:
            r0.zzs()
            r3.writeNoException()
            goto L_0x00e7
        L_0x0031:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbip> r1 = com.google.android.gms.internal.ads.zzbip.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzhu.zzc(r2, r1)
            com.google.android.gms.internal.ads.zzbip r1 = (com.google.android.gms.internal.ads.zzbip) r1
            r0.zzr(r1)
            r3.writeNoException()
            goto L_0x00e7
        L_0x0041:
            java.util.List r1 = r0.zzq()
            r3.writeNoException()
            r3.writeTypedList(r1)
            goto L_0x00e7
        L_0x004d:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzbrt r1 = com.google.android.gms.internal.ads.zzbrs.zzc(r1)
            r0.zzp(r1)
            r3.writeNoException()
            goto L_0x00e7
        L_0x005d:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzbvh r1 = com.google.android.gms.internal.ads.zzbvg.zzg(r1)
            r0.zzo(r1)
            r3.writeNoException()
            goto L_0x00e7
        L_0x006d:
            java.lang.String r1 = r2.readString()
            r0.zzn(r1)
            r3.writeNoException()
            goto L_0x00e7
        L_0x0079:
            java.lang.String r1 = r0.zzm()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x00e7
        L_0x0084:
            boolean r1 = r0.zzl()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzhu.zzb(r3, r1)
            goto L_0x00e7
        L_0x008f:
            float r1 = r0.zzk()
            r3.writeNoException()
            r3.writeFloat(r1)
            goto L_0x00e7
        L_0x009a:
            java.lang.String r1 = r2.readString()
            android.os.IBinder r2 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r0.zzj(r1, r2)
            r3.writeNoException()
            goto L_0x00e7
        L_0x00ad:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            java.lang.String r2 = r2.readString()
            r0.zzi(r1, r2)
            r3.writeNoException()
            goto L_0x00e7
        L_0x00c0:
            boolean r1 = com.google.android.gms.internal.ads.zzhu.zza(r2)
            r0.zzh(r1)
            r3.writeNoException()
            goto L_0x00e7
        L_0x00cb:
            java.lang.String r1 = r2.readString()
            r0.zzg(r1)
            r3.writeNoException()
            goto L_0x00e7
        L_0x00d6:
            float r1 = r2.readFloat()
            r0.zzf(r1)
            r3.writeNoException()
            goto L_0x00e7
        L_0x00e1:
            r0.zze()
            r3.writeNoException()
        L_0x00e7:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgh.zzbR(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
