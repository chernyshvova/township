package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzags extends zzagw {
    public static final /* synthetic */ int zza = 0;
    public static final int[] zzb = new int[0];
    public static final zzfnx<Integer> zzc = zzfnx.zzc(zzagg.zza);
    public static final zzfnx<Integer> zzd = zzfnx.zzc(zzagh.zza);
    public final AtomicReference<zzagm> zze;
    public final zzagc zzf;

    @Deprecated
    public zzags() {
        zzagm zzagm = zzagm.zza;
        throw null;
    }

    public static boolean zzd(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    @Nullable
    public static String zze(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static int zzf(zzkc zzkc, @Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzkc.zzc)) {
            return 4;
        }
        String zze2 = zze(str);
        String zze3 = zze(zzkc.zzc);
        if (zze3 == null || zze2 == null) {
            if (!z || zze3 != null) {
                return 0;
            }
            return 1;
        } else if (zze3.startsWith(zze2) || zze2.startsWith(zze3)) {
            return 3;
        } else {
            if (zzalh.zzu(zze3, "-")[0].equals(zzalh.zzu(zze2, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    public static boolean zzn(zzkc zzkc, @Nullable String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        if ((zzkc.zze & 16384) == 0 && zzd(i, false) && (i & i2) != 0 && ((str == null || zzalh.zzc(zzkc.zzl, str)) && (((i11 = zzkc.zzq) == -1 || (i7 <= i11 && i11 <= i3)) && ((i12 = zzkc.zzr) == -1 || (i8 <= i12 && i12 <= i4))))) {
            float f = zzkc.zzs;
            if ((f == -1.0f || (((float) i9) <= f && f <= ((float) i5))) && (i13 = zzkc.zzh) != -1 && i10 <= i13 && i13 <= i6) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.Integer> zzo(com.google.android.gms.internal.ads.zzafr r12, int r13, int r14, boolean r15) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.zza
            r0.<init>(r1)
            r1 = 0
            r2 = 0
        L_0x0009:
            int r3 = r12.zza
            if (r2 >= r3) goto L_0x0017
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.add(r3)
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0017:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == r2) goto L_0x00a3
            if (r14 == r2) goto L_0x00a3
            r3 = 0
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x0022:
            int r5 = r12.zza
            if (r3 >= r5) goto L_0x007d
            com.google.android.gms.internal.ads.zzkc r5 = r12.zza(r3)
            int r6 = r5.zzq
            if (r6 <= 0) goto L_0x007a
            int r7 = r5.zzr
            if (r7 <= 0) goto L_0x007a
            if (r15 == 0) goto L_0x0042
            r8 = 1
            if (r6 > r7) goto L_0x0039
            r9 = 0
            goto L_0x003a
        L_0x0039:
            r9 = 1
        L_0x003a:
            if (r13 > r14) goto L_0x003d
            r8 = 0
        L_0x003d:
            if (r9 == r8) goto L_0x0042
            r8 = r13
            r9 = r14
            goto L_0x0044
        L_0x0042:
            r9 = r13
            r8 = r14
        L_0x0044:
            int r10 = r6 * r8
            int r11 = r7 * r9
            if (r10 < r11) goto L_0x0054
            android.graphics.Point r7 = new android.graphics.Point
            int r6 = com.google.android.gms.internal.ads.zzalh.zzw(r11, r6)
            r7.<init>(r9, r6)
            goto L_0x005e
        L_0x0054:
            android.graphics.Point r6 = new android.graphics.Point
            int r7 = com.google.android.gms.internal.ads.zzalh.zzw(r10, r7)
            r6.<init>(r7, r8)
            r7 = r6
        L_0x005e:
            int r6 = r5.zzq
            int r5 = r5.zzr
            int r8 = r6 * r5
            int r9 = r7.x
            float r9 = (float) r9
            r10 = 1065017672(0x3f7ae148, float:0.98)
            float r9 = r9 * r10
            int r9 = (int) r9
            if (r6 < r9) goto L_0x007a
            int r6 = r7.y
            float r6 = (float) r6
            float r6 = r6 * r10
            int r6 = (int) r6
            if (r5 < r6) goto L_0x007a
            if (r8 >= r4) goto L_0x007a
            r4 = r8
        L_0x007a:
            int r3 = r3 + 1
            goto L_0x0022
        L_0x007d:
            if (r4 == r2) goto L_0x00a3
            int r13 = r0.size()
            r14 = -1
            int r13 = r13 + r14
        L_0x0085:
            if (r13 < 0) goto L_0x00a3
            java.lang.Object r15 = r0.get(r13)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            com.google.android.gms.internal.ads.zzkc r15 = r12.zza(r15)
            int r15 = r15.zzc()
            if (r15 == r14) goto L_0x009d
            if (r15 <= r4) goto L_0x00a0
        L_0x009d:
            r0.remove(r13)
        L_0x00a0:
            int r13 = r13 + -1
            goto L_0x0085
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzags.zzo(com.google.android.gms.internal.ads.zzafr, int, int, boolean):java.util.List");
    }

    public final void zza(zzagm zzagm) {
        if (!this.zze.getAndSet(zzagm).equals(zzagm)) {
            zzl();
        }
    }

    public final zzagm zzb() {
        return this.zze.get();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: com.google.android.gms.internal.ads.zzagf[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.google.android.gms.internal.ads.zzagu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: com.google.android.gms.internal.ads.zzagd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v52, resolved type: com.google.android.gms.internal.ads.zzagu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v31, resolved type: com.google.android.gms.internal.ads.zzagu} */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x0618, code lost:
        r1 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0173 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x03c9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x017a A[LOOP:1: B:21:0x004a->B:70:0x017a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x021f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.ads.zzmc[], com.google.android.gms.internal.ads.zzagf[]> zzc(com.google.android.gms.internal.ads.zzagv r43, int[][][] r44, int[] r45, com.google.android.gms.internal.ads.zzadv r46, com.google.android.gms.internal.ads.zzmv r47) throws com.google.android.gms.internal.ads.zzio {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzagm> r2 = r0.zze
            java.lang.Object r2 = r2.get()
            com.google.android.gms.internal.ads.zzagm r2 = (com.google.android.gms.internal.ads.zzagm) r2
            int r3 = r43.zza()
            int r4 = r43.zza()
            com.google.android.gms.internal.ads.zzagt[] r5 = new com.google.android.gms.internal.ads.zzagt[r4]
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0019:
            r10 = 2
            r13 = 1
            if (r7 >= r4) goto L_0x0265
            int r14 = r1.zzb(r7)
            if (r14 != r10) goto L_0x024c
            if (r8 != 0) goto L_0x0232
            com.google.android.gms.internal.ads.zzaft r8 = r1.zzc(r7)
            r14 = r44[r7]
            r15 = r45[r7]
            boolean r6 = r2.zzy
            if (r6 != 0) goto L_0x0195
            boolean r6 = r2.zzx
            if (r6 != 0) goto L_0x0195
            boolean r6 = r2.zzl
            if (r13 == r6) goto L_0x003c
            r6 = 16
            goto L_0x003e
        L_0x003c:
            r6 = 24
        L_0x003e:
            boolean r13 = r2.zzk
            if (r13 == 0) goto L_0x0048
            r13 = r15 & r6
            if (r13 == 0) goto L_0x0048
            r13 = 1
            goto L_0x0049
        L_0x0048:
            r13 = 0
        L_0x0049:
            r15 = 0
        L_0x004a:
            int r12 = r8.zzb
            if (r15 >= r12) goto L_0x0195
            com.google.android.gms.internal.ads.zzafr r12 = r8.zza(r15)
            r28 = r14[r15]
            int r11 = r2.zzb
            int r10 = r2.zzc
            int r0 = r2.zzd
            r29 = r3
            int r3 = r2.zze
            r30 = r4
            int r4 = r2.zzf
            r31 = r9
            int r9 = r2.zzg
            int r1 = r2.zzh
            r32 = r5
            int r5 = r2.zzi
            r33 = r7
            int r7 = r2.zzm
            r34 = r14
            int r14 = r2.zzn
            r35 = r8
            boolean r8 = r2.zzo
            r36 = r2
            int r2 = r12.zza
            r37 = r15
            r15 = 2
            if (r2 >= r15) goto L_0x0087
            int[] r0 = zzb
        L_0x0083:
            r38 = r13
            goto L_0x0170
        L_0x0087:
            java.util.List r2 = zzo(r12, r7, r14, r8)
            int r7 = r2.size()
            if (r7 >= r15) goto L_0x0094
            int[] r0 = zzb
            goto L_0x0083
        L_0x0094:
            if (r13 != 0) goto L_0x010e
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>()
            r38 = r13
            r8 = 0
            r14 = 0
            r15 = 0
        L_0x00a0:
            int r13 = r2.size()
            if (r8 >= r13) goto L_0x010b
            java.lang.Object r13 = r2.get(r8)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            com.google.android.gms.internal.ads.zzkc r13 = r12.zza(r13)
            java.lang.String r13 = r13.zzl
            boolean r16 = r7.add(r13)
            if (r16 == 0) goto L_0x00fe
            r39 = r7
            r41 = r8
            r40 = r15
            r7 = 0
            r15 = 0
        L_0x00c4:
            int r8 = r2.size()
            if (r7 >= r8) goto L_0x00f9
            java.lang.Object r8 = r2.get(r7)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            com.google.android.gms.internal.ads.zzkc r16 = r12.zza(r8)
            r18 = r28[r8]
            r17 = r13
            r19 = r6
            r20 = r11
            r21 = r10
            r22 = r0
            r23 = r3
            r24 = r4
            r25 = r9
            r26 = r1
            r27 = r5
            boolean r8 = zzn(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            if (r8 == 0) goto L_0x00f6
            int r15 = r15 + 1
        L_0x00f6:
            int r7 = r7 + 1
            goto L_0x00c4
        L_0x00f9:
            if (r15 <= r14) goto L_0x0104
            r14 = r15
            r15 = r13
            goto L_0x0106
        L_0x00fe:
            r39 = r7
            r41 = r8
            r40 = r15
        L_0x0104:
            r15 = r40
        L_0x0106:
            int r8 = r41 + 1
            r7 = r39
            goto L_0x00a0
        L_0x010b:
            r40 = r15
            goto L_0x0112
        L_0x010e:
            r38 = r13
            r40 = 0
        L_0x0112:
            int r7 = r2.size()
            r8 = -1
            int r7 = r7 + r8
        L_0x0118:
            if (r7 < 0) goto L_0x014a
            java.lang.Object r8 = r2.get(r7)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            com.google.android.gms.internal.ads.zzkc r16 = r12.zza(r8)
            r18 = r28[r8]
            r17 = r40
            r19 = r6
            r20 = r11
            r21 = r10
            r22 = r0
            r23 = r3
            r24 = r4
            r25 = r9
            r26 = r1
            r27 = r5
            boolean r8 = zzn(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            if (r8 != 0) goto L_0x0147
            r2.remove(r7)
        L_0x0147:
            int r7 = r7 + -1
            goto L_0x0118
        L_0x014a:
            int r0 = r2.size()
            r1 = 2
            if (r0 >= r1) goto L_0x0154
            int[] r0 = zzb
            goto L_0x0170
        L_0x0154:
            java.lang.Object[] r0 = r2.toArray()
            int r1 = r0.length
            int[] r2 = new int[r1]
            r3 = 0
        L_0x015c:
            if (r3 >= r1) goto L_0x016f
            r4 = r0[r3]
            if (r4 == 0) goto L_0x016d
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x015c
        L_0x016d:
            r3 = 0
            throw r3
        L_0x016f:
            r0 = r2
        L_0x0170:
            int r1 = r0.length
            if (r1 <= 0) goto L_0x017a
            com.google.android.gms.internal.ads.zzagt r1 = new com.google.android.gms.internal.ads.zzagt
            r2 = 0
            r1.<init>(r12, r0, r2)
            goto L_0x01a6
        L_0x017a:
            int r15 = r37 + 1
            r0 = r42
            r1 = r43
            r3 = r29
            r4 = r30
            r9 = r31
            r5 = r32
            r7 = r33
            r14 = r34
            r8 = r35
            r2 = r36
            r13 = r38
            r10 = 2
            goto L_0x004a
        L_0x0195:
            r36 = r2
            r29 = r3
            r30 = r4
            r32 = r5
            r33 = r7
            r35 = r8
            r31 = r9
            r34 = r14
            r1 = 0
        L_0x01a6:
            if (r1 != 0) goto L_0x021f
            r3 = r35
            r0 = 0
            r1 = 0
            r2 = 0
            r11 = -1
        L_0x01ae:
            int r4 = r3.zzb
            if (r0 >= r4) goto L_0x020d
            com.google.android.gms.internal.ads.zzafr r4 = r3.zza(r0)
            r5 = r36
            int r6 = r5.zzm
            int r7 = r5.zzn
            boolean r8 = r5.zzo
            java.util.List r6 = zzo(r4, r6, r7, r8)
            r7 = r34[r0]
            r8 = r2
            r2 = r1
            r1 = 0
        L_0x01c7:
            int r9 = r4.zza
            if (r1 >= r9) goto L_0x0206
            com.google.android.gms.internal.ads.zzkc r9 = r4.zza(r1)
            int r10 = r9.zze
            r10 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r10 == 0) goto L_0x01d6
            goto L_0x0203
        L_0x01d6:
            r10 = r7[r1]
            boolean r12 = r5.zzz
            boolean r10 = zzd(r10, r12)
            if (r10 == 0) goto L_0x0203
            com.google.android.gms.internal.ads.zzagr r10 = new com.google.android.gms.internal.ads.zzagr
            r12 = r7[r1]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            boolean r13 = r6.contains(r13)
            r10.<init>(r9, r5, r12, r13)
            boolean r9 = r10.zza
            if (r9 != 0) goto L_0x01f8
            boolean r9 = r5.zzj
            if (r9 != 0) goto L_0x01f8
            goto L_0x0203
        L_0x01f8:
            if (r8 == 0) goto L_0x0200
            int r9 = r10.compareTo(r8)
            if (r9 <= 0) goto L_0x0203
        L_0x0200:
            r11 = r1
            r2 = r4
            r8 = r10
        L_0x0203:
            int r1 = r1 + 1
            goto L_0x01c7
        L_0x0206:
            int r0 = r0 + 1
            r1 = r2
            r36 = r5
            r2 = r8
            goto L_0x01ae
        L_0x020d:
            r5 = r36
            if (r1 != 0) goto L_0x0213
            r12 = 0
            goto L_0x0222
        L_0x0213:
            com.google.android.gms.internal.ads.zzagt r12 = new com.google.android.gms.internal.ads.zzagt
            r0 = 1
            int[] r2 = new int[r0]
            r0 = 0
            r2[r0] = r11
            r12.<init>(r1, r2, r0)
            goto L_0x0222
        L_0x021f:
            r5 = r36
            r12 = r1
        L_0x0222:
            r32[r33] = r12
            if (r12 == 0) goto L_0x022c
            r0 = r43
            r6 = r33
            r8 = 1
            goto L_0x023e
        L_0x022c:
            r0 = r43
            r6 = r33
            r8 = 0
            goto L_0x023e
        L_0x0232:
            r29 = r3
            r30 = r4
            r32 = r5
            r31 = r9
            r5 = r2
            r0 = r43
            r6 = r7
        L_0x023e:
            com.google.android.gms.internal.ads.zzaft r1 = r0.zzc(r6)
            int r1 = r1.zzb
            if (r1 <= 0) goto L_0x0248
            r13 = 1
            goto L_0x0249
        L_0x0248:
            r13 = 0
        L_0x0249:
            r9 = r31 | r13
            goto L_0x0257
        L_0x024c:
            r0 = r1
            r29 = r3
            r30 = r4
            r32 = r5
            r6 = r7
            r31 = r9
            r5 = r2
        L_0x0257:
            int r7 = r6 + 1
            r1 = r0
            r2 = r5
            r3 = r29
            r4 = r30
            r5 = r32
            r0 = r42
            goto L_0x0019
        L_0x0265:
            r0 = r1
            r29 = r3
            r32 = r5
            r31 = r9
            r5 = r2
            r6 = r4
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = -1
        L_0x0272:
            if (r1 >= r6) goto L_0x03df
            int r7 = r0.zzb(r1)
            r8 = 1
            if (r7 != r8) goto L_0x03cb
            boolean r7 = r5.zzB
            if (r7 != 0) goto L_0x0284
            if (r31 != 0) goto L_0x0282
            goto L_0x0284
        L_0x0282:
            r7 = 0
            goto L_0x0285
        L_0x0284:
            r7 = 1
        L_0x0285:
            com.google.android.gms.internal.ads.zzaft r8 = r0.zzc(r1)
            r9 = r44[r1]
            r10 = r45[r1]
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = -1
        L_0x0291:
            int r14 = r8.zzb
            if (r10 >= r14) goto L_0x02e8
            com.google.android.gms.internal.ads.zzafr r14 = r8.zza(r10)
            r15 = r9[r10]
            r17 = r12
            r16 = r13
            r12 = r11
            r11 = 0
        L_0x02a1:
            int r13 = r14.zza
            if (r11 >= r13) goto L_0x02de
            r13 = r15[r11]
            r18 = r3
            boolean r3 = r5.zzz
            boolean r3 = zzd(r13, r3)
            if (r3 == 0) goto L_0x02d5
            com.google.android.gms.internal.ads.zzkc r3 = r14.zza(r11)
            com.google.android.gms.internal.ads.zzagj r13 = new com.google.android.gms.internal.ads.zzagj
            r19 = r14
            r14 = r15[r11]
            r13.<init>(r3, r5, r14)
            boolean r3 = r13.zza
            if (r3 != 0) goto L_0x02c7
            boolean r3 = r5.zzs
            if (r3 != 0) goto L_0x02c7
            goto L_0x02d7
        L_0x02c7:
            if (r12 == 0) goto L_0x02cf
            int r3 = r13.compareTo(r12)
            if (r3 <= 0) goto L_0x02d7
        L_0x02cf:
            r17 = r10
            r16 = r11
            r12 = r13
            goto L_0x02d7
        L_0x02d5:
            r19 = r14
        L_0x02d7:
            int r11 = r11 + 1
            r3 = r18
            r14 = r19
            goto L_0x02a1
        L_0x02de:
            r18 = r3
            int r10 = r10 + 1
            r11 = r12
            r13 = r16
            r12 = r17
            goto L_0x0291
        L_0x02e8:
            r18 = r3
            r3 = -1
            if (r12 != r3) goto L_0x02f6
            r16 = r1
            r36 = r5
            r30 = r6
            r0 = 0
            goto L_0x0399
        L_0x02f6:
            com.google.android.gms.internal.ads.zzafr r3 = r8.zza(r12)
            boolean r8 = r5.zzy
            if (r8 != 0) goto L_0x037f
            boolean r8 = r5.zzx
            if (r8 != 0) goto L_0x037f
            if (r7 == 0) goto L_0x037f
            r7 = r9[r12]
            int r8 = r5.zzr
            boolean r9 = r5.zzt
            boolean r10 = r5.zzu
            boolean r12 = r5.zzv
            com.google.android.gms.internal.ads.zzkc r14 = r3.zza(r13)
            int r15 = r3.zza
            int[] r15 = new int[r15]
            r36 = r5
            r30 = r6
            r0 = 0
            r5 = 0
        L_0x031c:
            int r6 = r3.zza
            if (r5 >= r6) goto L_0x036e
            if (r5 == r13) goto L_0x035e
            com.google.android.gms.internal.ads.zzkc r6 = r3.zza(r5)
            r16 = r1
            r1 = r7[r5]
            r17 = r7
            r7 = 0
            boolean r1 = zzd(r1, r7)
            if (r1 == 0) goto L_0x0367
            int r1 = r6.zzh
            r7 = -1
            if (r1 == r7) goto L_0x0367
            if (r1 > r8) goto L_0x0367
            if (r12 != 0) goto L_0x0344
            int r1 = r6.zzy
            if (r1 == r7) goto L_0x0367
            int r7 = r14.zzy
            if (r1 != r7) goto L_0x0367
        L_0x0344:
            if (r9 != 0) goto L_0x0352
            java.lang.String r1 = r6.zzl
            if (r1 == 0) goto L_0x0367
            java.lang.String r7 = r14.zzl
            boolean r1 = android.text.TextUtils.equals(r1, r7)
            if (r1 == 0) goto L_0x0367
        L_0x0352:
            if (r10 != 0) goto L_0x0362
            int r1 = r6.zzz
            r6 = -1
            if (r1 == r6) goto L_0x0367
            int r6 = r14.zzz
            if (r1 != r6) goto L_0x0367
            goto L_0x0362
        L_0x035e:
            r16 = r1
            r17 = r7
        L_0x0362:
            int r1 = r0 + 1
            r15[r0] = r5
            r0 = r1
        L_0x0367:
            int r5 = r5 + 1
            r1 = r16
            r7 = r17
            goto L_0x031c
        L_0x036e:
            r16 = r1
            int[] r0 = java.util.Arrays.copyOf(r15, r0)
            int r1 = r0.length
            r5 = 1
            if (r1 <= r5) goto L_0x0386
            com.google.android.gms.internal.ads.zzagt r1 = new com.google.android.gms.internal.ads.zzagt
            r6 = 0
            r1.<init>(r3, r0, r6)
            goto L_0x0388
        L_0x037f:
            r16 = r1
            r36 = r5
            r30 = r6
            r5 = 1
        L_0x0386:
            r6 = 0
            r1 = 0
        L_0x0388:
            if (r1 != 0) goto L_0x0393
            com.google.android.gms.internal.ads.zzagt r1 = new com.google.android.gms.internal.ads.zzagt
            int[] r0 = new int[r5]
            r0[r6] = r13
            r1.<init>(r3, r0, r6)
        L_0x0393:
            if (r11 == 0) goto L_0x03c9
            android.util.Pair r0 = android.util.Pair.create(r1, r11)
        L_0x0399:
            if (r0 == 0) goto L_0x03d3
            if (r2 == 0) goto L_0x03a7
            java.lang.Object r1 = r0.second
            com.google.android.gms.internal.ads.zzagj r1 = (com.google.android.gms.internal.ads.zzagj) r1
            int r1 = r1.compareTo(r2)
            if (r1 <= 0) goto L_0x03d3
        L_0x03a7:
            r1 = -1
            if (r4 == r1) goto L_0x03ad
            r1 = 0
            r32[r4] = r1
        L_0x03ad:
            java.lang.Object r1 = r0.first
            com.google.android.gms.internal.ads.zzagt r1 = (com.google.android.gms.internal.ads.zzagt) r1
            r32[r16] = r1
            com.google.android.gms.internal.ads.zzafr r2 = r1.zza
            int[] r1 = r1.zzb
            r3 = 0
            r1 = r1[r3]
            com.google.android.gms.internal.ads.zzkc r1 = r2.zza(r1)
            java.lang.String r1 = r1.zzc
            java.lang.Object r0 = r0.second
            com.google.android.gms.internal.ads.zzagj r0 = (com.google.android.gms.internal.ads.zzagj) r0
            r2 = r0
            r3 = r1
            r4 = r16
            goto L_0x03d5
        L_0x03c9:
            r0 = 0
            throw r0
        L_0x03cb:
            r16 = r1
            r18 = r3
            r36 = r5
            r30 = r6
        L_0x03d3:
            r3 = r18
        L_0x03d5:
            int r1 = r16 + 1
            r0 = r43
            r6 = r30
            r5 = r36
            goto L_0x0272
        L_0x03df:
            r18 = r3
            r36 = r5
            r0 = r6
            r2 = 0
            r3 = 0
            r8 = -1
        L_0x03e7:
            if (r2 >= r0) goto L_0x0517
            r1 = r43
            int r4 = r1.zzb(r2)
            r5 = 1
            if (r4 == r5) goto L_0x050b
            r5 = 2
            if (r4 == r5) goto L_0x050b
            r5 = 3
            if (r4 == r5) goto L_0x0469
            com.google.android.gms.internal.ads.zzaft r4 = r1.zzc(r2)
            r5 = r44[r2]
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
        L_0x0402:
            int r11 = r4.zzb
            if (r6 >= r11) goto L_0x0452
            com.google.android.gms.internal.ads.zzafr r11 = r4.zza(r6)
            r12 = r5[r6]
            r13 = r10
            r10 = r9
            r9 = r7
            r7 = 0
        L_0x0410:
            int r14 = r11.zza
            if (r7 >= r14) goto L_0x0446
            r14 = r12[r7]
            r45 = r4
            r15 = r36
            boolean r4 = r15.zzz
            boolean r4 = zzd(r14, r4)
            if (r4 == 0) goto L_0x043b
            com.google.android.gms.internal.ads.zzkc r4 = r11.zza(r7)
            com.google.android.gms.internal.ads.zzagk r14 = new com.google.android.gms.internal.ads.zzagk
            r16 = r5
            r5 = r12[r7]
            r14.<init>(r4, r5)
            if (r13 == 0) goto L_0x0437
            int r4 = r14.compareTo(r13)
            if (r4 <= 0) goto L_0x043d
        L_0x0437:
            r9 = r7
            r10 = r11
            r13 = r14
            goto L_0x043d
        L_0x043b:
            r16 = r5
        L_0x043d:
            int r7 = r7 + 1
            r4 = r45
            r36 = r15
            r5 = r16
            goto L_0x0410
        L_0x0446:
            r45 = r4
            r16 = r5
            r15 = r36
            int r6 = r6 + 1
            r7 = r9
            r9 = r10
            r10 = r13
            goto L_0x0402
        L_0x0452:
            r15 = r36
            if (r9 != 0) goto L_0x0458
            r4 = 0
            goto L_0x0463
        L_0x0458:
            com.google.android.gms.internal.ads.zzagt r4 = new com.google.android.gms.internal.ads.zzagt
            r5 = 1
            int[] r6 = new int[r5]
            r5 = 0
            r6[r5] = r7
            r4.<init>(r9, r6, r5)
        L_0x0463:
            r32[r2] = r4
            r11 = r18
            goto L_0x050f
        L_0x0469:
            r15 = r36
            com.google.android.gms.internal.ads.zzaft r4 = r1.zzc(r2)
            r5 = r44[r2]
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = -1
        L_0x0475:
            int r11 = r4.zzb
            if (r6 >= r11) goto L_0x04d2
            com.google.android.gms.internal.ads.zzafr r11 = r4.zza(r6)
            r12 = r5[r6]
            r13 = r10
            r10 = r9
            r9 = r7
            r7 = 0
        L_0x0483:
            int r14 = r11.zza
            if (r7 >= r14) goto L_0x04c6
            r14 = r12[r7]
            r45 = r4
            boolean r4 = r15.zzz
            boolean r4 = zzd(r14, r4)
            if (r4 == 0) goto L_0x04b5
            com.google.android.gms.internal.ads.zzkc r4 = r11.zza(r7)
            com.google.android.gms.internal.ads.zzagq r14 = new com.google.android.gms.internal.ads.zzagq
            r16 = r5
            r5 = r12[r7]
            r17 = r11
            r11 = r18
            r14.<init>(r4, r15, r5, r11)
            boolean r4 = r14.zza
            if (r4 == 0) goto L_0x04bb
            if (r10 == 0) goto L_0x04b0
            int r4 = r14.compareTo(r10)
            if (r4 <= 0) goto L_0x04bb
        L_0x04b0:
            r13 = r7
            r10 = r14
            r9 = r17
            goto L_0x04bb
        L_0x04b5:
            r16 = r5
            r17 = r11
            r11 = r18
        L_0x04bb:
            int r7 = r7 + 1
            r4 = r45
            r18 = r11
            r5 = r16
            r11 = r17
            goto L_0x0483
        L_0x04c6:
            r45 = r4
            r16 = r5
            r11 = r18
            int r6 = r6 + 1
            r7 = r9
            r9 = r10
            r10 = r13
            goto L_0x0475
        L_0x04d2:
            r11 = r18
            if (r7 != 0) goto L_0x04d8
            r4 = 0
            goto L_0x04e9
        L_0x04d8:
            com.google.android.gms.internal.ads.zzagt r4 = new com.google.android.gms.internal.ads.zzagt
            r5 = 1
            int[] r6 = new int[r5]
            r5 = 0
            r6[r5] = r10
            r4.<init>(r7, r6, r5)
            if (r9 == 0) goto L_0x0509
            android.util.Pair r4 = android.util.Pair.create(r4, r9)
        L_0x04e9:
            if (r4 == 0) goto L_0x050f
            if (r3 == 0) goto L_0x04f7
            java.lang.Object r5 = r4.second
            com.google.android.gms.internal.ads.zzagq r5 = (com.google.android.gms.internal.ads.zzagq) r5
            int r5 = r5.compareTo(r3)
            if (r5 <= 0) goto L_0x050f
        L_0x04f7:
            r3 = -1
            r5 = 0
            if (r8 == r3) goto L_0x04fd
            r32[r8] = r5
        L_0x04fd:
            java.lang.Object r3 = r4.first
            com.google.android.gms.internal.ads.zzagt r3 = (com.google.android.gms.internal.ads.zzagt) r3
            r32[r2] = r3
            java.lang.Object r3 = r4.second
            com.google.android.gms.internal.ads.zzagq r3 = (com.google.android.gms.internal.ads.zzagq) r3
            r8 = r2
            goto L_0x050f
        L_0x0509:
            r5 = 0
            throw r5
        L_0x050b:
            r11 = r18
            r15 = r36
        L_0x050f:
            int r2 = r2 + 1
            r18 = r11
            r36 = r15
            goto L_0x03e7
        L_0x0517:
            r1 = r43
            r15 = r36
            r3 = r29
            r2 = 0
        L_0x051e:
            if (r2 >= r3) goto L_0x0551
            boolean r4 = r15.zzb(r2)
            if (r4 == 0) goto L_0x052a
            r4 = 0
            r32[r2] = r4
            goto L_0x054e
        L_0x052a:
            r4 = 0
            com.google.android.gms.internal.ads.zzaft r5 = r1.zzc(r2)
            boolean r6 = r15.zzc(r2, r5)
            if (r6 == 0) goto L_0x054e
            com.google.android.gms.internal.ads.zzagp r6 = r15.zzd(r2, r5)
            if (r6 != 0) goto L_0x053d
            r7 = r4
            goto L_0x054c
        L_0x053d:
            com.google.android.gms.internal.ads.zzagt r7 = new com.google.android.gms.internal.ads.zzagt
            int r8 = r6.zza
            com.google.android.gms.internal.ads.zzafr r5 = r5.zza(r8)
            int[] r8 = r6.zzb
            int r6 = r6.zzc
            r7.<init>(r5, r8, r6)
        L_0x054c:
            r32[r2] = r7
        L_0x054e:
            int r2 = r2 + 1
            goto L_0x051e
        L_0x0551:
            r2 = r42
            r4 = 0
            com.google.android.gms.internal.ads.zzagc r11 = r2.zzf
            com.google.android.gms.internal.ads.zzahl r12 = r42.zzm()
            com.google.android.gms.internal.ads.zzfml r13 = com.google.android.gms.internal.ads.zzagd.zza(r32)
            com.google.android.gms.internal.ads.zzagf[] r14 = new com.google.android.gms.internal.ads.zzagf[r0]
            r10 = 0
        L_0x0561:
            if (r10 >= r0) goto L_0x05ac
            r5 = r32[r10]
            if (r5 == 0) goto L_0x05a5
            int[] r7 = r5.zzb
            int r6 = r7.length
            if (r6 != 0) goto L_0x056d
            goto L_0x05a5
        L_0x056d:
            r8 = 1
            if (r6 != r8) goto L_0x058a
            com.google.android.gms.internal.ads.zzagu r6 = new com.google.android.gms.internal.ads.zzagu
            com.google.android.gms.internal.ads.zzafr r8 = r5.zza
            r22 = 0
            r18 = r7[r22]
            int r5 = r5.zzc
            r20 = 0
            r21 = 0
            r16 = r6
            r17 = r8
            r19 = r5
            r16.<init>(r17, r18, r19, r20, r21)
            r17 = r10
            goto L_0x05a2
        L_0x058a:
            r22 = 0
            com.google.android.gms.internal.ads.zzafr r6 = r5.zza
            int r8 = r5.zzc
            java.lang.Object r5 = r13.get(r10)
            r16 = r5
            com.google.android.gms.internal.ads.zzfml r16 = (com.google.android.gms.internal.ads.zzfml) r16
            r5 = r11
            r9 = r12
            r17 = r10
            r10 = r16
            com.google.android.gms.internal.ads.zzagd r6 = r5.zza(r6, r7, r8, r9, r10)
        L_0x05a2:
            r14[r17] = r6
            goto L_0x05a9
        L_0x05a5:
            r17 = r10
            r22 = 0
        L_0x05a9:
            int r10 = r17 + 1
            goto L_0x0561
        L_0x05ac:
            r22 = 0
            com.google.android.gms.internal.ads.zzmc[] r0 = new com.google.android.gms.internal.ads.zzmc[r3]
            r5 = 0
        L_0x05b1:
            if (r5 >= r3) goto L_0x05cd
            boolean r6 = r15.zzb(r5)
            if (r6 != 0) goto L_0x05c7
            int r6 = r1.zzb(r5)
            r7 = 7
            if (r6 == r7) goto L_0x05c4
            r6 = r14[r5]
            if (r6 == 0) goto L_0x05c7
        L_0x05c4:
            com.google.android.gms.internal.ads.zzmc r6 = com.google.android.gms.internal.ads.zzmc.zza
            goto L_0x05c8
        L_0x05c7:
            r6 = r4
        L_0x05c8:
            r0[r5] = r6
            int r5 = r5 + 1
            goto L_0x05b1
        L_0x05cd:
            boolean r3 = r15.zzA
            if (r3 == 0) goto L_0x0636
            r3 = 0
            r4 = -1
            r8 = -1
        L_0x05d4:
            int r5 = r43.zza()
            if (r3 >= r5) goto L_0x0620
            int r15 = r1.zzb(r3)
            r5 = r14[r3]
            r6 = 1
            if (r15 == r6) goto L_0x05e8
            r6 = 2
            if (r15 != r6) goto L_0x061c
            r15 = 2
            goto L_0x05e9
        L_0x05e8:
            r6 = 2
        L_0x05e9:
            if (r5 == 0) goto L_0x061c
            r7 = r44[r3]
            com.google.android.gms.internal.ads.zzaft r9 = r1.zzc(r3)
            com.google.android.gms.internal.ads.zzafr r10 = r5.zza
            int r9 = r9.zzb(r10)
            r10 = 0
        L_0x05f8:
            int[] r11 = r5.zzc
            int r12 = r11.length
            if (r10 >= r12) goto L_0x060c
            r12 = r7[r9]
            r11 = r11[r10]
            r11 = r12[r11]
            r12 = 32
            r11 = r11 & r12
            if (r11 == r12) goto L_0x0609
            goto L_0x061c
        L_0x0609:
            int r10 = r10 + 1
            goto L_0x05f8
        L_0x060c:
            r10 = 1
            if (r15 != r10) goto L_0x0615
            r5 = -1
            if (r4 == r5) goto L_0x0613
            goto L_0x0618
        L_0x0613:
            r4 = r3
            goto L_0x061d
        L_0x0615:
            r5 = -1
            if (r8 == r5) goto L_0x061a
        L_0x0618:
            r1 = 0
            goto L_0x0622
        L_0x061a:
            r8 = r3
            goto L_0x061d
        L_0x061c:
            r5 = -1
        L_0x061d:
            int r3 = r3 + 1
            goto L_0x05d4
        L_0x0620:
            r5 = -1
            r1 = 1
        L_0x0622:
            if (r4 == r5) goto L_0x0628
            if (r8 == r5) goto L_0x0628
            r6 = 1
            goto L_0x0629
        L_0x0628:
            r6 = 0
        L_0x0629:
            r1 = r1 & r6
            if (r1 == 0) goto L_0x0636
            com.google.android.gms.internal.ads.zzmc r1 = new com.google.android.gms.internal.ads.zzmc
            r3 = 1
            r1.<init>(r3)
            r0[r4] = r1
            r0[r8] = r1
        L_0x0636:
            android.util.Pair r0 = android.util.Pair.create(r0, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzags.zzc(com.google.android.gms.internal.ads.zzagv, int[][][], int[], com.google.android.gms.internal.ads.zzadv, com.google.android.gms.internal.ads.zzmv):android.util.Pair");
    }

    public zzags(Context context) {
        this(zzagm.zza(context), new zzagc(), (byte[]) null);
    }

    public zzags(zzagm zzagm, zzagc zzagc, byte[] bArr) {
        this.zzf = zzagc;
        this.zze = new AtomicReference<>(zzagm);
    }
}
