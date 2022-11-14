package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import com.facebook.internal.WebDialog;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzpf {
    public static final /* synthetic */ int zza = 0;
    public static final int[] zzb = {AdError.CACHE_ERROR_CODE, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, WebDialog.NO_PADDING_SCREEN_WIDTH, 400, 400, 2048};

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        if (r11 != 11) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009a, code lost:
        if (r11 != 11) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009f, code lost:
        if (r11 != 8) goto L_0x00a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzpe zza(com.google.android.gms.internal.ads.zzakq r11) {
        /*
            r0 = 16
            int r1 = r11.zzh(r0)
            int r0 = r11.zzh(r0)
            r2 = 4
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L_0x0018
            r0 = 24
            int r0 = r11.zzh(r0)
            r3 = 7
            goto L_0x0019
        L_0x0018:
            r3 = 4
        L_0x0019:
            int r0 = r0 + r3
            r3 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r3) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r7 = r0
            r0 = 2
            int r1 = r11.zzh(r0)
            r3 = 0
            r4 = 3
            if (r1 != r4) goto L_0x003f
            r1 = 0
        L_0x002c:
            int r5 = r11.zzh(r0)
            int r5 = r5 + r1
            boolean r1 = r11.zzg()
            if (r1 != 0) goto L_0x003a
            int r5 = r5 + r4
            r1 = r5
            goto L_0x003f
        L_0x003a:
            int r5 = r5 + 1
            int r1 = r5 << 2
            goto L_0x002c
        L_0x003f:
            r5 = 10
            int r5 = r11.zzh(r5)
            boolean r6 = r11.zzg()
            if (r6 == 0) goto L_0x0054
            int r6 = r11.zzh(r4)
            if (r6 <= 0) goto L_0x0054
            r11.zzf(r0)
        L_0x0054:
            boolean r6 = r11.zzg()
            r8 = 44100(0xac44, float:6.1797E-41)
            r9 = 48000(0xbb80, float:6.7262E-41)
            r10 = 1
            if (r10 == r6) goto L_0x0065
            r6 = 44100(0xac44, float:6.1797E-41)
            goto L_0x0068
        L_0x0065:
            r6 = 48000(0xbb80, float:6.7262E-41)
        L_0x0068:
            int r11 = r11.zzh(r2)
            if (r6 != r8) goto L_0x0078
            r8 = 13
            if (r11 != r8) goto L_0x0078
            int[] r11 = zzb
            r11 = r11[r8]
            r8 = r11
            goto L_0x00a8
        L_0x0078:
            if (r6 != r9) goto L_0x00a7
            r8 = 14
            if (r11 >= r8) goto L_0x00a7
            int[] r3 = zzb
            r3 = r3[r11]
            int r5 = r5 % 5
            r8 = 8
            if (r5 == r10) goto L_0x009d
            r9 = 11
            if (r5 == r0) goto L_0x0098
            if (r5 == r4) goto L_0x009d
            if (r5 == r2) goto L_0x0091
            goto L_0x00a2
        L_0x0091:
            if (r11 == r4) goto L_0x00a4
            if (r11 == r8) goto L_0x00a4
            if (r11 != r9) goto L_0x00a2
            goto L_0x00a4
        L_0x0098:
            if (r11 == r8) goto L_0x00a4
            if (r11 != r9) goto L_0x00a2
            goto L_0x00a4
        L_0x009d:
            if (r11 == r4) goto L_0x00a4
            if (r11 != r8) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r8 = r3
            goto L_0x00a8
        L_0x00a4:
            int r3 = r3 + 1
            goto L_0x00a2
        L_0x00a7:
            r8 = 0
        L_0x00a8:
            com.google.android.gms.internal.ads.zzpe r11 = new com.google.android.gms.internal.ads.zzpe
            r5 = 2
            r9 = 0
            r3 = r11
            r4 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpf.zza(com.google.android.gms.internal.ads.zzakq):com.google.android.gms.internal.ads.zzpe");
    }

    public static void zzb(int i, zzakr zzakr) {
        zzakr.zza(7);
        byte[] zzi = zzakr.zzi();
        zzi[0] = -84;
        zzi[1] = 64;
        zzi[2] = -1;
        zzi[3] = -1;
        zzi[4] = (byte) ((i >> 16) & 255);
        zzi[5] = (byte) ((i >> 8) & 255);
        zzi[6] = (byte) (i & 255);
    }
}
