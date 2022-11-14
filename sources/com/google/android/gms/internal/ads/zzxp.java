package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxp extends zzxn {
    @Nullable
    public zzxo zza;
    public int zzb;
    public boolean zzc;
    @Nullable
    public zzud zzd;
    @Nullable
    public zzub zze;

    public final void zza(boolean z) {
        super.zza(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    public final long zzb(zzakr zzakr) {
        int i;
        int i2 = 0;
        if ((zzakr.zzi()[0] & 1) == 1) {
            return -1;
        }
        byte b = zzakr.zzi()[0];
        zzxo zzxo = this.zza;
        zzajg.zze(zzxo);
        if (!zzxo.zzd[(b >> 1) & (255 >>> (8 - zzxo.zze))].zza) {
            i = zzxo.zza.zze;
        } else {
            i = zzxo.zza.zzf;
        }
        if (this.zzc) {
            i2 = (this.zzb + i) / 4;
        }
        long j = (long) i2;
        if (zzakr.zzj() < zzakr.zze() + 4) {
            byte[] copyOf = Arrays.copyOf(zzakr.zzi(), zzakr.zze() + 4);
            zzakr.zzb(copyOf, copyOf.length);
        } else {
            zzakr.zzf(zzakr.zze() + 4);
        }
        byte[] zzi = zzakr.zzi();
        zzi[zzakr.zze() - 4] = (byte) ((int) (j & 255));
        zzi[zzakr.zze() - 3] = (byte) ((int) ((j >>> 8) & 255));
        zzi[zzakr.zze() - 2] = (byte) ((int) ((j >>> 16) & 255));
        zzi[zzakr.zze() - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x03df A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03e1  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzakr r20, long r21, com.google.android.gms.internal.ads.zzxl r23) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r23
            com.google.android.gms.internal.ads.zzxo r3 = r0.zza
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzkc r1 = r2.zza
            if (r1 == 0) goto L_0x0011
            return r5
        L_0x0011:
            throw r4
        L_0x0012:
            com.google.android.gms.internal.ads.zzud r7 = r0.zzd
            r3 = 1
            if (r7 != 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzue.zzc(r3, r1, r5)
            int r9 = r20.zzC()
            int r10 = r20.zzn()
            int r11 = r20.zzC()
            int r4 = r20.zzw()
            if (r4 > 0) goto L_0x002f
            r4 = -1
            r12 = -1
            goto L_0x0030
        L_0x002f:
            r12 = r4
        L_0x0030:
            int r4 = r20.zzw()
            if (r4 > 0) goto L_0x0039
            r4 = -1
            r13 = -1
            goto L_0x003a
        L_0x0039:
            r13 = r4
        L_0x003a:
            int r4 = r20.zzw()
            if (r4 > 0) goto L_0x0043
            r4 = -1
            r14 = -1
            goto L_0x0044
        L_0x0043:
            r14 = r4
        L_0x0044:
            int r4 = r20.zzn()
            r5 = r4 & 15
            double r5 = (double) r5
            r7 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r5 = java.lang.Math.pow(r7, r5)
            int r15 = (int) r5
            r4 = r4 & 240(0xf0, float:3.36E-43)
            int r4 = r4 >> 4
            double r4 = (double) r4
            double r4 = java.lang.Math.pow(r7, r4)
            int r4 = (int) r4
            int r5 = r20.zzn()
            byte[] r6 = r20.zzi()
            int r1 = r20.zze()
            byte[] r18 = java.util.Arrays.copyOf(r6, r1)
            com.google.android.gms.internal.ads.zzud r1 = new com.google.android.gms.internal.ads.zzud
            r5 = r5 & r3
            if (r3 == r5) goto L_0x0075
            r3 = 0
            r17 = 0
            goto L_0x0078
        L_0x0075:
            r3 = 1
            r17 = 1
        L_0x0078:
            r8 = r1
            r16 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0.zzd = r1
            goto L_0x008b
        L_0x0081:
            com.google.android.gms.internal.ads.zzub r8 = r0.zze
            if (r8 != 0) goto L_0x008e
            com.google.android.gms.internal.ads.zzub r1 = com.google.android.gms.internal.ads.zzue.zzb(r1, r3, r3)
            r0.zze = r1
        L_0x008b:
            r1 = 0
            goto L_0x03db
        L_0x008e:
            int r4 = r20.zze()
            byte[] r9 = new byte[r4]
            byte[] r4 = r20.zzi()
            int r5 = r20.zze()
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r9, r6, r5)
            int r4 = r7.zza
            r5 = 5
            com.google.android.gms.internal.ads.zzue.zzc(r5, r1, r6)
            int r6 = r20.zzn()
            int r6 = r6 + r3
            com.google.android.gms.internal.ads.zzua r3 = new com.google.android.gms.internal.ads.zzua
            byte[] r10 = r20.zzi()
            r3.<init>(r10)
            int r1 = r20.zzg()
            int r1 = r1 * 8
            r3.zzc(r1)
            r1 = 0
        L_0x00be:
            r10 = 24
            r11 = 16
            if (r1 >= r6) goto L_0x01bf
            int r12 = r3.zzb(r10)
            r13 = 5653314(0x564342, float:7.92198E-39)
            if (r12 != r13) goto L_0x01ac
            int r11 = r3.zzb(r11)
            int r10 = r3.zzb(r10)
            long[] r12 = new long[r10]
            boolean r13 = r3.zza()
            if (r13 != 0) goto L_0x011a
            boolean r13 = r3.zza()
            r16 = 0
            r14 = 0
        L_0x00e4:
            if (r14 >= r10) goto L_0x0117
            if (r13 == 0) goto L_0x0103
            boolean r15 = r3.zza()
            if (r15 == 0) goto L_0x00fc
            int r5 = r3.zzb(r5)
            int r5 = r5 + 1
            r22 = r6
            long r5 = (long) r5
            r12[r14] = r5
            r5 = 0
            goto L_0x0111
        L_0x00fc:
            r22 = r6
            r5 = 0
            r12[r14] = r5
            goto L_0x0111
        L_0x0103:
            r22 = r6
            r5 = 0
            r15 = 5
            int r15 = r3.zzb(r15)
            int r15 = r15 + 1
            long r5 = (long) r15
            r12[r14] = r5
        L_0x0111:
            int r14 = r14 + 1
            r5 = 5
            r6 = r22
            goto L_0x00e4
        L_0x0117:
            r22 = r6
            goto L_0x014c
        L_0x011a:
            r22 = r6
            r5 = 5
            int r5 = r3.zzb(r5)
            int r5 = r5 + 1
            r6 = 0
        L_0x0124:
            if (r6 >= r10) goto L_0x014c
            int r13 = r10 - r6
            int r13 = com.google.android.gms.internal.ads.zzue.zza(r13)
            int r13 = r3.zzb(r13)
            r14 = 0
        L_0x0131:
            if (r14 >= r13) goto L_0x0143
            if (r6 >= r10) goto L_0x0143
            r15 = r8
            r16 = r9
            long r8 = (long) r5
            r12[r6] = r8
            int r6 = r6 + 1
            int r14 = r14 + 1
            r8 = r15
            r9 = r16
            goto L_0x0131
        L_0x0143:
            r15 = r8
            r16 = r9
            int r5 = r5 + 1
            r8 = r15
            r9 = r16
            goto L_0x0124
        L_0x014c:
            r15 = r8
            r16 = r9
            r5 = 4
            int r6 = r3.zzb(r5)
            r8 = 2
            if (r6 > r8) goto L_0x019d
            r9 = 1
            if (r6 == r9) goto L_0x015d
            if (r6 != r8) goto L_0x0193
            r6 = 2
        L_0x015d:
            r8 = 32
            r3.zzc(r8)
            r3.zzc(r8)
            int r5 = r3.zzb(r5)
            int r5 = r5 + r9
            r3.zzc(r9)
            if (r6 != r9) goto L_0x0188
            if (r11 == 0) goto L_0x0185
            long r8 = (long) r10
            double r8 = (double) r8
            long r10 = (long) r11
            double r10 = (double) r10
            java.lang.Double.isNaN(r10)
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = r12 / r10
            double r8 = java.lang.Math.pow(r8, r12)
            double r8 = java.lang.Math.floor(r8)
            long r8 = (long) r8
            goto L_0x018c
        L_0x0185:
            r8 = 0
            goto L_0x018c
        L_0x0188:
            long r8 = (long) r10
            long r10 = (long) r11
            long r8 = r8 * r10
        L_0x018c:
            long r5 = (long) r5
            long r5 = r5 * r8
            int r6 = (int) r5
            r3.zzc(r6)
        L_0x0193:
            int r1 = r1 + 1
            r5 = 5
            r6 = r22
            r8 = r15
            r9 = r16
            goto L_0x00be
        L_0x019d:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            r2 = 53
            java.lang.String r3 = "lookup type greater than 2 not decodable: "
            java.lang.String r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r2, r3, r6)
            r3 = 0
            r1.<init>(r2, r3)
            throw r1
        L_0x01ac:
            r1 = 0
            com.google.android.gms.internal.ads.zzlg r2 = new com.google.android.gms.internal.ads.zzlg
            int r3 = r3.zzd()
            r4 = 66
            java.lang.String r5 = "expected code book to start with [0x56, 0x43, 0x42] at "
            java.lang.String r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r4, r5, r3)
            r2.<init>(r3, r1)
            throw r2
        L_0x01bf:
            r15 = r8
            r16 = r9
            r1 = 6
            int r5 = r3.zzb(r1)
            int r5 = r5 + 1
            r6 = 0
        L_0x01ca:
            if (r6 >= r5) goto L_0x01de
            int r8 = r3.zzb(r11)
            if (r8 != 0) goto L_0x01d5
            int r6 = r6 + 1
            goto L_0x01ca
        L_0x01d5:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "placeholder of time domain transforms not zeroed out"
            r3 = 0
            r1.<init>(r2, r3)
            throw r1
        L_0x01de:
            int r5 = r3.zzb(r1)
            r6 = 1
            int r5 = r5 + r6
            r8 = 0
        L_0x01e5:
            r9 = 3
            r10 = 52
            if (r8 >= r5) goto L_0x02a1
            int r1 = r3.zzb(r11)
            if (r1 == 0) goto L_0x026f
            if (r1 != r6) goto L_0x0262
            r1 = 5
            int r1 = r3.zzb(r1)
            int[] r6 = new int[r1]
            r10 = 0
            r12 = -1
        L_0x01fb:
            if (r10 >= r1) goto L_0x020a
            r13 = 4
            int r13 = r3.zzb(r13)
            r6[r10] = r13
            if (r13 <= r12) goto L_0x0207
            r12 = r13
        L_0x0207:
            int r10 = r10 + 1
            goto L_0x01fb
        L_0x020a:
            int r12 = r12 + 1
            int[] r10 = new int[r12]
            r13 = 0
        L_0x020f:
            if (r13 >= r12) goto L_0x0242
            int r9 = r3.zzb(r9)
            int r9 = r9 + 1
            r10[r13] = r9
            r9 = 2
            int r9 = r3.zzb(r9)
            if (r9 <= 0) goto L_0x0226
            r14 = 8
            r3.zzc(r14)
            goto L_0x0228
        L_0x0226:
            r14 = 8
        L_0x0228:
            r17 = 0
            r21 = r5
            r11 = r14
            r5 = 0
        L_0x022e:
            r14 = 1
            int r14 = r14 << r9
            if (r5 >= r14) goto L_0x023a
            r3.zzc(r11)
            int r5 = r5 + 1
            r11 = 8
            goto L_0x022e
        L_0x023a:
            int r13 = r13 + 1
            r9 = 3
            r5 = r21
            r11 = 16
            goto L_0x020f
        L_0x0242:
            r21 = r5
            r5 = 2
            r3.zzc(r5)
            r5 = 4
            int r5 = r3.zzb(r5)
            r9 = 0
            r11 = 0
            r12 = 0
        L_0x0250:
            if (r9 >= r1) goto L_0x0297
            r13 = r6[r9]
            r13 = r10[r13]
            int r11 = r11 + r13
        L_0x0257:
            if (r12 >= r11) goto L_0x025f
            r3.zzc(r5)
            int r12 = r12 + 1
            goto L_0x0257
        L_0x025f:
            int r9 = r9 + 1
            goto L_0x0250
        L_0x0262:
            com.google.android.gms.internal.ads.zzlg r2 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r3 = "floor type greater than 1 not decodable: "
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r10, r3, r1)
            r3 = 0
            r2.<init>(r1, r3)
            throw r2
        L_0x026f:
            r21 = r5
            r1 = 8
            r3.zzc(r1)
            r5 = 16
            r3.zzc(r5)
            r3.zzc(r5)
            r5 = 6
            r3.zzc(r5)
            r3.zzc(r1)
            r5 = 4
            int r5 = r3.zzb(r5)
            int r5 = r5 + 1
            r6 = 0
        L_0x028d:
            if (r6 >= r5) goto L_0x0297
            r3.zzc(r1)
            int r6 = r6 + 1
            r1 = 8
            goto L_0x028d
        L_0x0297:
            int r8 = r8 + 1
            r1 = 6
            r6 = 1
            r5 = r21
            r11 = 16
            goto L_0x01e5
        L_0x02a1:
            int r5 = r3.zzb(r1)
            r6 = 1
            int r5 = r5 + r6
            r8 = 0
        L_0x02a8:
            if (r8 >= r5) goto L_0x030f
            r9 = 16
            int r11 = r3.zzb(r9)
            r9 = 2
            if (r11 > r9) goto L_0x0306
            r9 = 24
            r3.zzc(r9)
            r3.zzc(r9)
            r3.zzc(r9)
            int r1 = r3.zzb(r1)
            int r1 = r1 + r6
            r6 = 8
            r3.zzc(r6)
            int[] r9 = new int[r1]
            r11 = 0
        L_0x02cb:
            if (r11 >= r1) goto L_0x02e7
            r12 = 3
            int r12 = r3.zzb(r12)
            boolean r13 = r3.zza()
            if (r13 == 0) goto L_0x02de
            r13 = 5
            int r13 = r3.zzb(r13)
            goto L_0x02df
        L_0x02de:
            r13 = 0
        L_0x02df:
            int r13 = r13 * 8
            int r13 = r13 + r12
            r9[r11] = r13
            int r11 = r11 + 1
            goto L_0x02cb
        L_0x02e7:
            r11 = 0
        L_0x02e8:
            if (r11 >= r1) goto L_0x0301
            r12 = 0
        L_0x02eb:
            if (r12 >= r6) goto L_0x02fc
            r13 = r9[r11]
            r14 = 1
            int r14 = r14 << r12
            r13 = r13 & r14
            if (r13 == 0) goto L_0x02f7
            r3.zzc(r6)
        L_0x02f7:
            int r12 = r12 + 1
            r6 = 8
            goto L_0x02eb
        L_0x02fc:
            int r11 = r11 + 1
            r6 = 8
            goto L_0x02e8
        L_0x0301:
            int r8 = r8 + 1
            r1 = 6
            r6 = 1
            goto L_0x02a8
        L_0x0306:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "residueType greater than 2 is not decodable"
            r3 = 0
            r1.<init>(r2, r3)
            throw r1
        L_0x030f:
            int r1 = r3.zzb(r1)
            int r1 = r1 + 1
            r5 = 0
        L_0x0316:
            if (r5 >= r1) goto L_0x039b
            r6 = 16
            int r8 = r3.zzb(r6)
            if (r8 == 0) goto L_0x0337
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r10)
            java.lang.String r9 = "mapping type other than 0 not supported: "
            r6.append(r9)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.String r8 = "VorbisUtil"
            android.util.Log.e(r8, r6)
            goto L_0x038f
        L_0x0337:
            boolean r6 = r3.zza()
            if (r6 == 0) goto L_0x0345
            r6 = 4
            int r6 = r3.zzb(r6)
            int r6 = r6 + 1
            goto L_0x0346
        L_0x0345:
            r6 = 1
        L_0x0346:
            boolean r8 = r3.zza()
            if (r8 == 0) goto L_0x036a
            r8 = 8
            int r8 = r3.zzb(r8)
            int r8 = r8 + 1
            r9 = 0
        L_0x0355:
            if (r9 >= r8) goto L_0x036a
            int r11 = r4 + -1
            int r12 = com.google.android.gms.internal.ads.zzue.zza(r11)
            r3.zzc(r12)
            int r11 = com.google.android.gms.internal.ads.zzue.zza(r11)
            r3.zzc(r11)
            int r9 = r9 + 1
            goto L_0x0355
        L_0x036a:
            r8 = 2
            int r8 = r3.zzb(r8)
            if (r8 != 0) goto L_0x0392
            r8 = 1
            if (r6 <= r8) goto L_0x037e
            r8 = 0
        L_0x0375:
            if (r8 >= r4) goto L_0x037e
            r9 = 4
            r3.zzc(r9)
            int r8 = r8 + 1
            goto L_0x0375
        L_0x037e:
            r8 = 0
        L_0x037f:
            if (r8 >= r6) goto L_0x038f
            r9 = 8
            r3.zzc(r9)
            r3.zzc(r9)
            r3.zzc(r9)
            int r8 = r8 + 1
            goto L_0x037f
        L_0x038f:
            int r5 = r5 + 1
            goto L_0x0316
        L_0x0392:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "to reserved bits must be zero after mapping coupling steps"
            r3 = 0
            r1.<init>(r2, r3)
            throw r1
        L_0x039b:
            r1 = 6
            int r1 = r3.zzb(r1)
            int r1 = r1 + 1
            com.google.android.gms.internal.ads.zzuc[] r10 = new com.google.android.gms.internal.ads.zzuc[r1]
            r4 = 0
        L_0x03a5:
            if (r4 >= r1) goto L_0x03c5
            boolean r5 = r3.zza()
            r6 = 16
            int r8 = r3.zzb(r6)
            int r9 = r3.zzb(r6)
            r11 = 8
            int r11 = r3.zzb(r11)
            com.google.android.gms.internal.ads.zzuc r12 = new com.google.android.gms.internal.ads.zzuc
            r12.<init>(r5, r8, r9, r11)
            r10[r4] = r12
            int r4 = r4 + 1
            goto L_0x03a5
        L_0x03c5:
            boolean r3 = r3.zza()
            if (r3 == 0) goto L_0x041b
            com.google.android.gms.internal.ads.zzxo r3 = new com.google.android.gms.internal.ads.zzxo
            int r1 = r1 + -1
            int r11 = com.google.android.gms.internal.ads.zzue.zza(r1)
            r6 = r3
            r8 = r15
            r9 = r16
            r6.<init>(r7, r8, r9, r10, r11)
            r1 = r3
        L_0x03db:
            r0.zza = r1
            if (r1 != 0) goto L_0x03e1
            r1 = 1
            return r1
        L_0x03e1:
            com.google.android.gms.internal.ads.zzud r3 = r1.zza
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            byte[] r5 = r3.zzg
            r4.add(r5)
            byte[] r1 = r1.zzc
            r4.add(r1)
            com.google.android.gms.internal.ads.zzkb r1 = new com.google.android.gms.internal.ads.zzkb
            r1.<init>()
            java.lang.String r5 = "audio/vorbis"
            r1.zzj(r5)
            int r5 = r3.zzd
            r1.zzf(r5)
            int r5 = r3.zzc
            r1.zzg(r5)
            int r5 = r3.zza
            r1.zzw(r5)
            int r3 = r3.zzb
            r1.zzx(r3)
            r1.zzl(r4)
            com.google.android.gms.internal.ads.zzkc r1 = r1.zzD()
            r2.zza = r1
            r1 = 1
            return r1
        L_0x041b:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "framing bit after modes not set as expected"
            r3 = 0
            r1.<init>(r2, r3)
            goto L_0x0425
        L_0x0424:
            throw r1
        L_0x0425:
            goto L_0x0424
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxp.zzc(com.google.android.gms.internal.ads.zzakr, long, com.google.android.gms.internal.ads.zzxl):boolean");
    }

    public final void zzj(long j) {
        super.zzj(j);
        int i = 0;
        this.zzc = j != 0;
        zzud zzud = this.zzd;
        if (zzud != null) {
            i = zzud.zze;
        }
        this.zzb = i;
    }
}
