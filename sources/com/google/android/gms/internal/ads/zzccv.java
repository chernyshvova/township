package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzccv extends zzht implements zzccw {
    public zzccv() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbR(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x0041;
                case 2: goto L_0x003d;
                case 3: goto L_0x001d;
                case 4: goto L_0x0015;
                case 5: goto L_0x0009;
                case 6: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            r0.zzj()
            goto L_0x0044
        L_0x0009:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbdd> r1 = com.google.android.gms.internal.ads.zzbdd.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzhu.zzc(r2, r1)
            com.google.android.gms.internal.ads.zzbdd r1 = (com.google.android.gms.internal.ads.zzbdd) r1
            r0.zzi(r1)
            goto L_0x0044
        L_0x0015:
            int r1 = r2.readInt()
            r0.zzh(r1)
            goto L_0x0044
        L_0x001d:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0025
            r1 = 0
            goto L_0x0039
        L_0x0025:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzccq
            if (r4 == 0) goto L_0x0033
            r1 = r2
            com.google.android.gms.internal.ads.zzccq r1 = (com.google.android.gms.internal.ads.zzccq) r1
            goto L_0x0039
        L_0x0033:
            com.google.android.gms.internal.ads.zzcco r2 = new com.google.android.gms.internal.ads.zzcco
            r2.<init>(r1)
            r1 = r2
        L_0x0039:
            r0.zzg(r1)
            goto L_0x0044
        L_0x003d:
            r0.zzf()
            goto L_0x0044
        L_0x0041:
            r0.zze()
        L_0x0044:
            r3.writeNoException()
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccv.zzbR(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
