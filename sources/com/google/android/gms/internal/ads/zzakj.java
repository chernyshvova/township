package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzakj {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object zzc = new Object();
    public static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    try {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    if (zzd.length <= i4) {
                        int[] iArr = zzd;
                        int length = zzd.length;
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = zzd[i7] - i5;
                System.arraycopy(bArr, i5, bArr, i6, i8);
                int i9 = i6 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i6 = i10 + 1;
                bArr[i10] = 0;
                i5 += i8 + 3;
            }
            System.arraycopy(bArr, i5, bArr, i6, i2 - i6);
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaki zzb(byte[] r20, int r21, int r22) {
        /*
            com.google.android.gms.internal.ads.zzaks r0 = new com.google.android.gms.internal.ads.zzaks
            r1 = r20
            r2 = r21
            r3 = r22
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.zzc(r1)
            int r2 = r0.zze(r1)
            int r5 = r0.zze(r1)
            int r6 = r0.zze(r1)
            int r7 = r0.zzf()
            r1 = 138(0x8a, float:1.93E-43)
            r3 = 3
            r8 = 1
            r9 = 100
            if (r2 == r9) goto L_0x0053
            r9 = 110(0x6e, float:1.54E-43)
            if (r2 == r9) goto L_0x0053
            r9 = 122(0x7a, float:1.71E-43)
            if (r2 == r9) goto L_0x0053
            r9 = 244(0xf4, float:3.42E-43)
            if (r2 == r9) goto L_0x0053
            r9 = 44
            if (r2 == r9) goto L_0x0053
            r9 = 83
            if (r2 == r9) goto L_0x0053
            r9 = 86
            if (r2 == r9) goto L_0x0053
            r9 = 118(0x76, float:1.65E-43)
            if (r2 == r9) goto L_0x0053
            r9 = 128(0x80, float:1.794E-43)
            if (r2 == r9) goto L_0x0053
            if (r2 != r1) goto L_0x004f
            r1 = 138(0x8a, float:1.93E-43)
            r2 = 138(0x8a, float:1.93E-43)
            goto L_0x0053
        L_0x004f:
            r1 = 1
            r9 = 0
            r11 = 0
            goto L_0x00a4
        L_0x0053:
            int r1 = r0.zzf()
            if (r1 != r3) goto L_0x005f
            boolean r9 = r0.zzd()
            r10 = 3
            goto L_0x0061
        L_0x005f:
            r9 = 0
            r10 = r1
        L_0x0061:
            r0.zzf()
            r0.zzf()
            r0.zzb()
            boolean r11 = r0.zzd()
            if (r11 == 0) goto L_0x00a3
            if (r10 == r3) goto L_0x0075
            r10 = 8
            goto L_0x0077
        L_0x0075:
            r10 = 12
        L_0x0077:
            r11 = 0
        L_0x0078:
            if (r11 >= r10) goto L_0x00a3
            boolean r12 = r0.zzd()
            if (r12 == 0) goto L_0x00a0
            r12 = 6
            if (r11 >= r12) goto L_0x0086
            r12 = 16
            goto L_0x0088
        L_0x0086:
            r12 = 64
        L_0x0088:
            r13 = 0
            r14 = 8
            r15 = 8
        L_0x008d:
            if (r13 >= r12) goto L_0x00a0
            if (r14 == 0) goto L_0x009a
            int r14 = r0.zzg()
            int r14 = r14 + r15
            int r14 = r14 + 256
            int r14 = r14 % 256
        L_0x009a:
            if (r14 == 0) goto L_0x009d
            r15 = r14
        L_0x009d:
            int r13 = r13 + 1
            goto L_0x008d
        L_0x00a0:
            int r11 = r11 + 1
            goto L_0x0078
        L_0x00a3:
            r11 = r9
        L_0x00a4:
            int r9 = r0.zzf()
            int r13 = r9 + 4
            int r9 = r0.zzf()
            if (r9 != 0) goto L_0x00b9
            int r10 = r0.zzf()
            int r10 = r10 + 4
            r20 = r5
            goto L_0x00e2
        L_0x00b9:
            if (r9 != r8) goto L_0x00df
            boolean r9 = r0.zzd()
            r0.zzg()
            r0.zzg()
            int r10 = r0.zzf()
            long r14 = (long) r10
            r10 = 0
            r20 = r5
        L_0x00cd:
            long r4 = (long) r10
            int r12 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d8
            r0.zzf()
            int r10 = r10 + 1
            goto L_0x00cd
        L_0x00d8:
            r4 = 1
            r5 = 0
            r16 = r9
            r14 = 1
            r15 = 0
            goto L_0x00e7
        L_0x00df:
            r20 = r5
            r10 = 0
        L_0x00e2:
            r4 = 0
            r14 = r9
            r15 = r10
            r16 = 0
        L_0x00e7:
            r0.zzf()
            r0.zzb()
            int r4 = r0.zzf()
            int r4 = r4 + r8
            int r5 = r0.zzf()
            boolean r12 = r0.zzd()
            int r9 = 2 - r12
            int r5 = r5 + r8
            int r5 = r5 * r9
            if (r12 != 0) goto L_0x0104
            r0.zzb()
        L_0x0104:
            r0.zzb()
            int r4 = r4 * 16
            int r5 = r5 * 16
            boolean r10 = r0.zzd()
            if (r10 == 0) goto L_0x013a
            int r10 = r0.zzf()
            int r17 = r0.zzf()
            int r18 = r0.zzf()
            int r19 = r0.zzf()
            if (r1 != 0) goto L_0x0124
            goto L_0x012f
        L_0x0124:
            if (r1 != r3) goto L_0x0128
            r3 = 1
            goto L_0x0129
        L_0x0128:
            r3 = 2
        L_0x0129:
            if (r1 != r8) goto L_0x012c
            r8 = 2
        L_0x012c:
            int r9 = r9 * r8
            r8 = r3
        L_0x012f:
            int r10 = r10 + r17
            int r10 = r10 * r8
            int r4 = r4 - r10
            int r18 = r18 + r19
            int r18 = r18 * r9
            int r5 = r5 - r18
        L_0x013a:
            r8 = r4
            r9 = r5
            boolean r1 = r0.zzd()
            if (r1 == 0) goto L_0x0178
            boolean r1 = r0.zzd()
            if (r1 == 0) goto L_0x0178
            r1 = 8
            int r1 = r0.zze(r1)
            r3 = 255(0xff, float:3.57E-43)
            if (r1 != r3) goto L_0x0165
            r3 = 16
            int r1 = r0.zze(r3)
            int r0 = r0.zze(r3)
            if (r1 == 0) goto L_0x0178
            if (r0 == 0) goto L_0x0178
            float r1 = (float) r1
            float r0 = (float) r0
            float r1 = r1 / r0
            r10 = r1
            goto L_0x017c
        L_0x0165:
            r0 = 17
            if (r1 >= r0) goto L_0x016f
            float[] r0 = zzb
            r0 = r0[r1]
            r10 = r0
            goto L_0x017c
        L_0x016f:
            r0 = 46
            java.lang.String r3 = "Unexpected aspect_ratio_idc value: "
            java.lang.String r4 = "NalUnitUtil"
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r0, r3, r1, r4)
        L_0x0178:
            r0 = 1065353216(0x3f800000, float:1.0)
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x017c:
            com.google.android.gms.internal.ads.zzaki r0 = new com.google.android.gms.internal.ads.zzaki
            r3 = r0
            r4 = r2
            r5 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakj.zzb(byte[], int, int):com.google.android.gms.internal.ads.zzaki");
    }

    public static zzakh zzc(byte[] bArr, int i, int i2) {
        zzaks zzaks = new zzaks(bArr, 3, i2);
        zzaks.zzc(8);
        int zzf = zzaks.zzf();
        int zzf2 = zzaks.zzf();
        zzaks.zzb();
        return new zzakh(zzf, zzf2, zzaks.zzd());
    }

    public static int zzd(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        int i3 = i2 - i;
        boolean z2 = false;
        zzajg.zzd(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zze(zArr);
            return i - 3;
        } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zze(zArr);
            return i - 2;
        } else if (i3 <= 2 || !zArr[2] || bArr[i] != 0 || bArr[i + 1] != 1) {
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                byte b = bArr[i5];
                if ((b & 254) == 0) {
                    int i6 = i5 - 2;
                    if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                        zze(zArr);
                        return i6;
                    }
                    i5 = i6;
                }
                i5 += 3;
            }
            if (i3 <= 2 ? i3 != 2 ? !zArr[1] || bArr[i4] != 1 : !(zArr[2] && bArr[i2 - 2] == 0 && bArr[i4] == 1) : !(bArr[i2 - 3] == 0 && bArr[i2 - 2] == 0 && bArr[i4] == 1)) {
                z = false;
            } else {
                z = true;
            }
            zArr[0] = z;
            zArr[1] = i3 <= 1 ? !(!zArr[2] || bArr[i4] != 0) : bArr[i2 + -2] == 0 && bArr[i4] == 0;
            if (bArr[i4] == 0) {
                z2 = true;
            }
            zArr[2] = z2;
            return i2;
        } else {
            zze(zArr);
            return i - 1;
        }
    }

    public static void zze(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
