package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzoz {
    public static final /* synthetic */ int zza = 0;
    public static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    public static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzoy zza(byte[] bArr) throws zzlg {
        return zzb(new zzakq(bArr, bArr.length), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a9, code lost:
        if (r13 != 3) goto L_0x00c1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzoy zzb(com.google.android.gms.internal.ads.zzakq r13, boolean r14) throws com.google.android.gms.internal.ads.zzlg {
        /*
            int r0 = zzc(r13)
            int r1 = zzd(r13)
            r2 = 4
            int r3 = r13.zzh(r2)
            r4 = 19
            java.lang.String r5 = "mp4a.40."
            java.lang.String r5 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r4, r5, r0)
            r6 = 22
            r7 = 5
            if (r0 == r7) goto L_0x001e
            r7 = 29
            if (r0 != r7) goto L_0x002c
        L_0x001e:
            int r1 = zzd(r13)
            int r0 = zzc(r13)
            if (r0 != r6) goto L_0x002c
            int r3 = r13.zzh(r2)
        L_0x002c:
            r7 = 0
            if (r14 == 0) goto L_0x00c1
            r14 = 17
            r8 = 6
            r9 = 1
            r10 = 2
            r11 = 3
            if (r0 == r9) goto L_0x0055
            if (r0 == r10) goto L_0x0055
            if (r0 == r11) goto L_0x0055
            if (r0 == r2) goto L_0x0055
            if (r0 == r8) goto L_0x0055
            r2 = 7
            if (r0 == r2) goto L_0x0055
            if (r0 == r14) goto L_0x0055
            switch(r0) {
                case 19: goto L_0x0055;
                case 20: goto L_0x0055;
                case 21: goto L_0x0055;
                case 22: goto L_0x0055;
                case 23: goto L_0x0055;
                default: goto L_0x0047;
            }
        L_0x0047:
            com.google.android.gms.internal.ads.zzlg r13 = new com.google.android.gms.internal.ads.zzlg
            r14 = 42
            java.lang.String r1 = "Unsupported audio object type: "
            java.lang.String r14 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r14, r1, r0)
            r13.<init>(r14, r7)
            throw r13
        L_0x0055:
            boolean r2 = r13.zzg()
            if (r2 == 0) goto L_0x0062
            java.lang.String r2 = "AacUtil"
            java.lang.String r12 = "Unexpected frameLengthFlag = 1"
            android.util.Log.w(r2, r12)
        L_0x0062:
            boolean r2 = r13.zzg()
            if (r2 == 0) goto L_0x006d
            r2 = 14
            r13.zzf(r2)
        L_0x006d:
            boolean r2 = r13.zzg()
            if (r3 == 0) goto L_0x00bb
            r12 = 20
            if (r0 == r8) goto L_0x0080
            if (r0 != r12) goto L_0x007e
            r0 = 20
            r8 = 20
            goto L_0x0081
        L_0x007e:
            r8 = r0
            goto L_0x0084
        L_0x0080:
            r8 = r0
        L_0x0081:
            r13.zzf(r11)
        L_0x0084:
            if (r2 == 0) goto L_0x009f
            if (r0 != r6) goto L_0x008e
            r0 = 16
            r13.zzf(r0)
            goto L_0x008f
        L_0x008e:
            r6 = r0
        L_0x008f:
            if (r6 == r14) goto L_0x0099
            if (r6 == r4) goto L_0x0099
            if (r6 == r12) goto L_0x0099
            r14 = 23
            if (r6 != r14) goto L_0x009c
        L_0x0099:
            r13.zzf(r11)
        L_0x009c:
            r13.zzf(r9)
        L_0x009f:
            switch(r8) {
                case 17: goto L_0x00a3;
                case 18: goto L_0x00a2;
                case 19: goto L_0x00a3;
                case 20: goto L_0x00a3;
                case 21: goto L_0x00a3;
                case 22: goto L_0x00a3;
                case 23: goto L_0x00a3;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            goto L_0x00c1
        L_0x00a3:
            int r13 = r13.zzh(r10)
            if (r13 == r10) goto L_0x00ac
            if (r13 == r11) goto L_0x00ad
            goto L_0x00c1
        L_0x00ac:
            r11 = r13
        L_0x00ad:
            com.google.android.gms.internal.ads.zzlg r13 = new com.google.android.gms.internal.ads.zzlg
            r14 = 33
            java.lang.String r0 = "Unsupported epConfig: "
            java.lang.String r14 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r14, r0, r11)
            r13.<init>(r14, r7)
            throw r13
        L_0x00bb:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            r13.<init>()
            throw r13
        L_0x00c1:
            int[] r13 = zzc
            r13 = r13[r3]
            r14 = -1
            if (r13 == r14) goto L_0x00ce
            com.google.android.gms.internal.ads.zzoy r14 = new com.google.android.gms.internal.ads.zzoy
            r14.<init>(r1, r13, r5, r7)
            return r14
        L_0x00ce:
            com.google.android.gms.internal.ads.zzlg r13 = new com.google.android.gms.internal.ads.zzlg
            r13.<init>(r7, r7)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoz.zzb(com.google.android.gms.internal.ads.zzakq, boolean):com.google.android.gms.internal.ads.zzoy");
    }

    public static int zzc(zzakq zzakq) {
        int zzh = zzakq.zzh(5);
        return zzh == 31 ? zzakq.zzh(6) + 32 : zzh;
    }

    public static int zzd(zzakq zzakq) throws zzlg {
        int zzh = zzakq.zzh(4);
        if (zzh == 15) {
            return zzakq.zzh(24);
        }
        if (zzh < 13) {
            return zzb[zzh];
        }
        throw new zzlg((String) null, (Throwable) null);
    }
}
