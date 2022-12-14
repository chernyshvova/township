package com.google.android.gms.internal.measurement;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.drive.DriveFile;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjn<T> implements zzkb<T> {
    public static final int[] zza = new int[0];
    public static final Unsafe zzb = zzkz.zzc();
    public final int[] zzc;
    public final Object[] zzd;
    public final int zze;
    public final int zzf;
    public final zzjj zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final int[] zzl;
    public final int zzm;
    public final int zzn;
    public final zzjr zzo;
    public final zzit zzp;
    public final zzkt<?, ?> zzq;
    public final zzhn<?> zzr;
    public final zzjc zzs;

    public zzjn(int[] iArr, Object[] objArr, int i, int i2, zzjj zzjj, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjr zzjr, zzit zzit, zzkt<?, ?> zzkt, zzhn<?> zzhn, zzjc zzjc) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjj instanceof zzhy;
        this.zzj = z;
        this.zzh = zzhn != null && zzhn.zza(zzjj);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjr;
        this.zzp = zzit;
        this.zzq = zzkt;
        this.zzr = zzhn;
        this.zzg = zzjj;
        this.zzs = zzjc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:159:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x038c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.google.android.gms.internal.measurement.zzjn<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzjh r34, com.google.android.gms.internal.measurement.zzjr r35, com.google.android.gms.internal.measurement.zzit r36, com.google.android.gms.internal.measurement.zzkt<?, ?> r37, com.google.android.gms.internal.measurement.zzhn<?> r38, com.google.android.gms.internal.measurement.zzjc r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjz
            if (r1 == 0) goto L_0x040f
            com.google.android.gms.internal.measurement.zzjz r0 = (com.google.android.gms.internal.measurement.zzjz) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.measurement.zzju.zzb
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0031
            r5 = 1
        L_0x0027:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0032
            r5 = r7
            goto L_0x0027
        L_0x0031:
            r7 = 1
        L_0x0032:
            int r5 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0051
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x003e:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x004e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x003e
        L_0x004e:
            int r5 = r5 << r9
            r7 = r7 | r5
            r5 = r10
        L_0x0051:
            if (r7 != 0) goto L_0x005e
            int[] r7 = zza
            r14 = r7
            r7 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            goto L_0x016f
        L_0x005e:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x007d
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006a:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x007a
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r5 = r5 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x006a
        L_0x007a:
            int r7 = r7 << r9
            r5 = r5 | r7
            r7 = r10
        L_0x007d:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x009c
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0089:
            int r12 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x0099
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r12
            goto L_0x0089
        L_0x0099:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r12
        L_0x009c:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x00bb
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00a8:
            int r13 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00b8
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r12
            r9 = r9 | r10
            int r12 = r12 + 13
            r10 = r13
            goto L_0x00a8
        L_0x00b8:
            int r10 = r10 << r12
            r9 = r9 | r10
            r10 = r13
        L_0x00bb:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00da
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00c7:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00d7
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r10 = r10 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00c7
        L_0x00d7:
            int r12 = r12 << r13
            r10 = r10 | r12
            r12 = r14
        L_0x00da:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00f9
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00e6:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x00f6
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00e6
        L_0x00f6:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00f9:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x011a
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0105:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x0116
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0105
        L_0x0116:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011a:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x013d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0126:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0138
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0126
        L_0x0138:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x013d:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0162
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r3 = r16
            r16 = 13
        L_0x014b:
            int r17 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r6) goto L_0x015d
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r16
            r15 = r15 | r3
            int r16 = r16 + 13
            r3 = r17
            goto L_0x014b
        L_0x015d:
            int r3 = r3 << r16
            r15 = r15 | r3
            r16 = r17
        L_0x0162:
            int r3 = r15 + r13
            int r3 = r3 + r14
            int[] r3 = new int[r3]
            int r14 = r5 << 1
            int r14 = r14 + r7
            r7 = r14
            r14 = r3
            r3 = r5
            r5 = r16
        L_0x016f:
            sun.misc.Unsafe r8 = zzb
            java.lang.Object[] r16 = r0.zze()
            com.google.android.gms.internal.measurement.zzjj r17 = r0.zzc()
            java.lang.Class r6 = r17.getClass()
            r17 = r5
            int r5 = r12 * 3
            int[] r5 = new int[r5]
            int r12 = r12 << r4
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r19 = r15 + r13
            r13 = r7
            r21 = r15
            r7 = r17
            r22 = r19
            r17 = 0
            r20 = 0
        L_0x0193:
            if (r7 >= r2) goto L_0x03e3
            int r23 = r7 + 1
            char r7 = r1.charAt(r7)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r4) goto L_0x01c5
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r4 = r23
            r23 = 13
        L_0x01a6:
            int r25 = r4 + 1
            char r4 = r1.charAt(r4)
            r26 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x01bf
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r23
            r7 = r7 | r2
            int r23 = r23 + 13
            r4 = r25
            r2 = r26
            goto L_0x01a6
        L_0x01bf:
            int r2 = r4 << r23
            r7 = r7 | r2
            r2 = r25
            goto L_0x01c9
        L_0x01c5:
            r26 = r2
            r2 = r23
        L_0x01c9:
            int r4 = r2 + 1
            char r2 = r1.charAt(r2)
            r23 = r4
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r4) goto L_0x01fb
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r4 = r23
            r23 = 13
        L_0x01dc:
            int r25 = r4 + 1
            char r4 = r1.charAt(r4)
            r27 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r15) goto L_0x01f5
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r23
            r2 = r2 | r4
            int r23 = r23 + 13
            r4 = r25
            r15 = r27
            goto L_0x01dc
        L_0x01f5:
            int r4 = r4 << r23
            r2 = r2 | r4
            r4 = r25
            goto L_0x01ff
        L_0x01fb:
            r27 = r15
            r4 = r23
        L_0x01ff:
            r15 = r2 & 255(0xff, float:3.57E-43)
            r23 = r10
            r10 = r2 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x020d
            int r10 = r17 + 1
            r14[r17] = r20
            r17 = r10
        L_0x020d:
            r10 = 51
            r29 = r9
            if (r15 < r10) goto L_0x02aa
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r9) goto L_0x023c
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
        L_0x0222:
            int r32 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r9) goto L_0x0237
            r9 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r31
            r4 = r4 | r9
            int r31 = r31 + 13
            r10 = r32
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0222
        L_0x0237:
            int r9 = r10 << r31
            r4 = r4 | r9
            r10 = r32
        L_0x023c:
            int r9 = r15 + -51
            r31 = r10
            r10 = 9
            if (r9 == r10) goto L_0x025d
            r10 = 17
            if (r9 != r10) goto L_0x0249
            goto L_0x025d
        L_0x0249:
            r10 = 12
            if (r9 != r10) goto L_0x025b
            if (r11 != 0) goto L_0x025b
            int r9 = r20 / 3
            r10 = 1
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r10 = r13 + 1
            r13 = r16[r13]
            r12[r9] = r13
            r13 = r10
        L_0x025b:
            r10 = 1
            goto L_0x026a
        L_0x025d:
            int r9 = r20 / 3
            r10 = 1
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r24 = r13 + 1
            r13 = r16[r13]
            r12[r9] = r13
            r13 = r24
        L_0x026a:
            int r4 = r4 << r10
            r9 = r16[r4]
            boolean r10 = r9 instanceof java.lang.reflect.Field
            if (r10 == 0) goto L_0x0274
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x027c
        L_0x0274:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = zza((java.lang.Class<?>) r6, (java.lang.String) r9)
            r16[r4] = r9
        L_0x027c:
            long r9 = r8.objectFieldOffset(r9)
            int r10 = (int) r9
            int r4 = r4 + 1
            r9 = r16[r4]
            r25 = r10
            boolean r10 = r9 instanceof java.lang.reflect.Field
            if (r10 == 0) goto L_0x028e
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0296
        L_0x028e:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = zza((java.lang.Class<?>) r6, (java.lang.String) r9)
            r16[r4] = r9
        L_0x0296:
            long r9 = r8.objectFieldOffset(r9)
            int r4 = (int) r9
            r30 = r1
            r9 = r4
            r1 = r11
            r28 = r12
            r10 = r25
            r11 = r31
            r4 = 0
            r18 = 1
            goto L_0x03a8
        L_0x02aa:
            int r9 = r13 + 1
            r10 = r16[r13]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = zza((java.lang.Class<?>) r6, (java.lang.String) r10)
            r13 = 9
            if (r15 == r13) goto L_0x031e
            r13 = 17
            if (r15 != r13) goto L_0x02bd
            goto L_0x031e
        L_0x02bd:
            r13 = 27
            if (r15 == r13) goto L_0x030d
            r13 = 49
            if (r15 != r13) goto L_0x02c6
            goto L_0x030d
        L_0x02c6:
            r13 = 12
            if (r15 == r13) goto L_0x02f9
            r13 = 30
            if (r15 == r13) goto L_0x02f9
            r13 = 44
            if (r15 != r13) goto L_0x02d3
            goto L_0x02f9
        L_0x02d3:
            r13 = 50
            if (r15 != r13) goto L_0x032c
            int r13 = r21 + 1
            r14[r21] = r20
            int r21 = r20 / 3
            r24 = 1
            int r21 = r21 << 1
            int r25 = r9 + 1
            r9 = r16[r9]
            r12[r21] = r9
            r9 = r2 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x02f6
            int r21 = r21 + 1
            int r9 = r25 + 1
            r25 = r16[r25]
            r12[r21] = r25
            r21 = r13
            goto L_0x032c
        L_0x02f6:
            r21 = r13
            goto L_0x031b
        L_0x02f9:
            if (r11 != 0) goto L_0x030a
            int r13 = r20 / 3
            r24 = 1
            int r13 = r13 << 1
            int r13 = r13 + 1
            int r25 = r9 + 1
            r9 = r16[r9]
            r12[r13] = r9
            goto L_0x031b
        L_0x030a:
            r24 = 1
            goto L_0x032c
        L_0x030d:
            r24 = 1
            int r13 = r20 / 3
            int r13 = r13 << 1
            int r13 = r13 + 1
            int r25 = r9 + 1
            r9 = r16[r9]
            r12[r13] = r9
        L_0x031b:
            r13 = r25
            goto L_0x032d
        L_0x031e:
            r24 = 1
            int r13 = r20 / 3
            int r13 = r13 << 1
            int r13 = r13 + 1
            java.lang.Class r25 = r10.getType()
            r12[r13] = r25
        L_0x032c:
            r13 = r9
        L_0x032d:
            long r9 = r8.objectFieldOffset(r10)
            int r10 = (int) r9
            r9 = r2 & 4096(0x1000, float:5.74E-42)
            r25 = r13
            r13 = 4096(0x1000, float:5.74E-42)
            if (r9 != r13) goto L_0x038c
            r9 = 17
            if (r15 > r9) goto L_0x038c
            int r9 = r4 + 1
            char r4 = r1.charAt(r4)
            r13 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r13) goto L_0x0364
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r18 = 13
        L_0x034d:
            int r28 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r13) goto L_0x035f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r18
            r4 = r4 | r9
            int r18 = r18 + 13
            r9 = r28
            goto L_0x034d
        L_0x035f:
            int r9 = r9 << r18
            r4 = r4 | r9
            r9 = r28
        L_0x0364:
            r18 = 1
            int r24 = r3 << 1
            int r28 = r4 / 32
            int r28 = r28 + r24
            r13 = r16[r28]
            r30 = r1
            boolean r1 = r13 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x0377
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x037f
        L_0x0377:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zza((java.lang.Class<?>) r6, (java.lang.String) r13)
            r16[r28] = r13
        L_0x037f:
            r1 = r11
            r28 = r12
            long r11 = r8.objectFieldOffset(r13)
            int r12 = (int) r11
            int r4 = r4 % 32
            r11 = r9
            r9 = r12
            goto L_0x0398
        L_0x038c:
            r30 = r1
            r1 = r11
            r28 = r12
            r18 = 1
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r4
            r4 = 0
        L_0x0398:
            r12 = 18
            if (r15 < r12) goto L_0x03a6
            r12 = 49
            if (r15 > r12) goto L_0x03a6
            int r12 = r22 + 1
            r14[r22] = r10
            r22 = r12
        L_0x03a6:
            r13 = r25
        L_0x03a8:
            int r12 = r20 + 1
            r5[r20] = r7
            int r7 = r12 + 1
            r20 = r3
            r3 = r2 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x03b7
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03b8
        L_0x03b7:
            r3 = 0
        L_0x03b8:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03bf
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c0
        L_0x03bf:
            r2 = 0
        L_0x03c0:
            r2 = r2 | r3
            int r3 = r15 << 20
            r2 = r2 | r3
            r2 = r2 | r10
            r5[r12] = r2
            int r2 = r7 + 1
            int r3 = r4 << 20
            r3 = r3 | r9
            r5[r7] = r3
            r7 = r11
            r3 = r20
            r10 = r23
            r15 = r27
            r12 = r28
            r9 = r29
            r4 = 1
            r11 = r1
            r20 = r2
            r2 = r26
            r1 = r30
            goto L_0x0193
        L_0x03e3:
            r29 = r9
            r23 = r10
            r1 = r11
            r28 = r12
            r27 = r15
            com.google.android.gms.internal.measurement.zzjn r2 = new com.google.android.gms.internal.measurement.zzjn
            com.google.android.gms.internal.measurement.zzjj r10 = r0.zzc()
            r12 = 0
            r0 = r5
            r5 = r2
            r6 = r0
            r7 = r28
            r8 = r29
            r9 = r23
            r13 = r14
            r14 = r27
            r15 = r19
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r20 = r39
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r2
        L_0x040f:
            com.google.android.gms.internal.measurement.zzkm r0 = (com.google.android.gms.internal.measurement.zzkm) r0
            int r0 = r0.zza()
            int r1 = com.google.android.gms.internal.measurement.zzju.zzb
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            goto L_0x041e
        L_0x041d:
            throw r0
        L_0x041e:
            goto L_0x041d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzjh, com.google.android.gms.internal.measurement.zzjr, com.google.android.gms.internal.measurement.zzit, com.google.android.gms.internal.measurement.zzkt, com.google.android.gms.internal.measurement.zzhn, com.google.android.gms.internal.measurement.zzjc):com.google.android.gms.internal.measurement.zzjn");
    }

    private final zzif zzc(int i) {
        return (zzif) this.zzd[((i / 3) << 1) + 1];
    }

    public static zzks zze(Object obj) {
        zzhy zzhy = (zzhy) obj;
        zzks zzks = zzhy.zzb;
        if (zzks != zzks.zza()) {
            return zzks;
        }
        zzks zzb2 = zzks.zzb();
        zzhy.zzb = zzb2;
        return zzb2;
    }

    public static boolean zzf(int i) {
        return (i & DriveFile.MODE_WRITE_ONLY) != 0;
    }

    public static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzkz.zzf(t, j)).booleanValue();
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzd2 = zzd(i);
                long j = (long) (1048575 & zzd2);
                int i2 = this.zzc[i];
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zze(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzd(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzc(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zzkd.zza(this.zzs, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzkz.zza((Object) t, j, zzkz.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzkd.zza(this.zzq, t, t2);
            if (this.zzh) {
                zzkd.zza(this.zzr, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    public final boolean zzd(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t2).zzf();
            }
            int i6 = this.zzl[i5];
            int i7 = this.zzc[i6];
            int zzd2 = zzd(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzd2) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza(t2, i7, i6) && !zza((Object) t2, zzd2, zza(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzb2 = this.zzs.zzb(zzkz.zzf(t2, (long) (zzd2 & 1048575)));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i6)).zzc.zza() == zzln.MESSAGE) {
                                    zzkb<?> zzkb = null;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzkb == null) {
                                            zzkb = zzjx.zza().zza(next.getClass());
                                        }
                                        if (!zzkb.zzd(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzkz.zzf(t2, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzkb zza2 = zza(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i6, i2, i, i10) && !zza((Object) t2, zzd2, zza(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzkz.zzf(t, zzd2);
            if (zzf2 != null) {
                zzkz.zza((Object) t, zzd2, this.zzs.zzd(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    public static <T> long zze(T t, long j) {
        return ((Long) zzkz.zzf(t, j)).longValue();
    }

    public static <T> float zzc(T t, long j) {
        return ((Float) zzkz.zzf(t, j)).floatValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    public static <T> int zzd(T t, long j) {
        return ((Integer) zzkz.zzf(t, j)).intValue();
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object obj = null;
            if (zza(t, i2, i)) {
                obj = zzkz.zzf(t, j);
            }
            Object zzf2 = zzkz.zzf(t2, j);
            if (obj != null && zzf2 != null) {
                zzkz.zza((Object) t, j, zzia.zza(obj, zzf2));
                zzb(t, i2, i);
            } else if (zzf2 != null) {
                zzkz.zza((Object) t, j, zzf2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02ae, code lost:
        r11 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r13, r12, r3, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0736, code lost:
        r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r9, r6, r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x08c2, code lost:
        r4 = r4 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x090e, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x090f, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0911, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0913, code lost:
        r3 = r3 + 3;
        r5 = 1048575;
        r6 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r0.zzj
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = 1
            r7 = 0
            r9 = 0
            if (r2 == 0) goto L_0x0488
            sun.misc.Unsafe r2 = zzb
            r10 = 0
            r11 = 0
        L_0x0016:
            int[] r12 = r0.zzc
            int r12 = r12.length
            if (r10 >= r12) goto L_0x0480
            int r12 = r0.zzd((int) r10)
            r3 = r3 & r12
            int r3 = r3 >>> 20
            int[] r13 = r0.zzc
            r13 = r13[r10]
            r12 = r12 & r5
            long r14 = (long) r12
            com.google.android.gms.internal.measurement.zzhs r12 = com.google.android.gms.internal.measurement.zzhs.DOUBLE_LIST_PACKED
            int r12 = r12.zza()
            if (r3 < r12) goto L_0x003e
            com.google.android.gms.internal.measurement.zzhs r12 = com.google.android.gms.internal.measurement.zzhs.SINT64_LIST_PACKED
            int r12 = r12.zza()
            if (r3 > r12) goto L_0x003e
            int[] r12 = r0.zzc
            int r16 = r10 + 2
            r12 = r12[r16]
        L_0x003e:
            switch(r3) {
                case 0: goto L_0x046d;
                case 1: goto L_0x0462;
                case 2: goto L_0x0453;
                case 3: goto L_0x0444;
                case 4: goto L_0x0435;
                case 5: goto L_0x042a;
                case 6: goto L_0x041f;
                case 7: goto L_0x0414;
                case 8: goto L_0x03f7;
                case 9: goto L_0x03e3;
                case 10: goto L_0x03d1;
                case 11: goto L_0x03c1;
                case 12: goto L_0x03b1;
                case 13: goto L_0x03a5;
                case 14: goto L_0x0399;
                case 15: goto L_0x0389;
                case 16: goto L_0x0379;
                case 17: goto L_0x0363;
                case 18: goto L_0x0359;
                case 19: goto L_0x034f;
                case 20: goto L_0x0345;
                case 21: goto L_0x033b;
                case 22: goto L_0x0331;
                case 23: goto L_0x0327;
                case 24: goto L_0x031d;
                case 25: goto L_0x0313;
                case 26: goto L_0x0309;
                case 27: goto L_0x02fb;
                case 28: goto L_0x02f1;
                case 29: goto L_0x02e7;
                case 30: goto L_0x02dd;
                case 31: goto L_0x02d3;
                case 32: goto L_0x02c9;
                case 33: goto L_0x02bf;
                case 34: goto L_0x02b5;
                case 35: goto L_0x029a;
                case 36: goto L_0x0285;
                case 37: goto L_0x0270;
                case 38: goto L_0x025b;
                case 39: goto L_0x0246;
                case 40: goto L_0x0231;
                case 41: goto L_0x021b;
                case 42: goto L_0x0205;
                case 43: goto L_0x01ef;
                case 44: goto L_0x01d9;
                case 45: goto L_0x01c3;
                case 46: goto L_0x01ad;
                case 47: goto L_0x0197;
                case 48: goto L_0x0181;
                case 49: goto L_0x0173;
                case 50: goto L_0x0163;
                case 51: goto L_0x0155;
                case 52: goto L_0x0149;
                case 53: goto L_0x0139;
                case 54: goto L_0x0129;
                case 55: goto L_0x0119;
                case 56: goto L_0x010d;
                case 57: goto L_0x0101;
                case 58: goto L_0x00f5;
                case 59: goto L_0x00d7;
                case 60: goto L_0x00c3;
                case 61: goto L_0x00b1;
                case 62: goto L_0x00a1;
                case 63: goto L_0x0091;
                case 64: goto L_0x0085;
                case 65: goto L_0x0079;
                case 66: goto L_0x0069;
                case 67: goto L_0x0059;
                case 68: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x047a
        L_0x0043:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r1, r14)
            com.google.android.gms.internal.measurement.zzjj r3 = (com.google.android.gms.internal.measurement.zzjj) r3
            com.google.android.gms.internal.measurement.zzkb r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzc(r13, r3, r12)
            goto L_0x0479
        L_0x0059:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            long r14 = zze(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r13, (long) r14)
            goto L_0x0479
        L_0x0069:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r13, (int) r3)
            goto L_0x0479
        L_0x0079:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r13, (long) r7)
            goto L_0x0479
        L_0x0085:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzj(r13, r9)
            goto L_0x0479
        L_0x0091:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzk(r13, r3)
            goto L_0x0479
        L_0x00a1:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r13, (int) r3)
            goto L_0x0479
        L_0x00b1:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r1, r14)
            com.google.android.gms.internal.measurement.zzgp r3 = (com.google.android.gms.internal.measurement.zzgp) r3
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r13, (com.google.android.gms.internal.measurement.zzgp) r3)
            goto L_0x0479
        L_0x00c3:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r1, r14)
            com.google.android.gms.internal.measurement.zzkb r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zza((int) r13, (java.lang.Object) r3, (com.google.android.gms.internal.measurement.zzkb) r12)
            goto L_0x0479
        L_0x00d7:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.measurement.zzgp
            if (r12 == 0) goto L_0x00ed
            com.google.android.gms.internal.measurement.zzgp r3 = (com.google.android.gms.internal.measurement.zzgp) r3
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r13, (com.google.android.gms.internal.measurement.zzgp) r3)
            goto L_0x0479
        L_0x00ed:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (java.lang.String) r3)
            goto L_0x0479
        L_0x00f5:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (boolean) r6)
            goto L_0x0479
        L_0x0101:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzi(r13, r9)
            goto L_0x0479
        L_0x010d:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r13, (long) r7)
            goto L_0x0479
        L_0x0119:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = zzd(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r13, (int) r3)
            goto L_0x0479
        L_0x0129:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            long r14 = zze(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13, (long) r14)
            goto L_0x0479
        L_0x0139:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            long r14 = zze(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzd((int) r13, (long) r14)
            goto L_0x0479
        L_0x0149:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (float) r4)
            goto L_0x0479
        L_0x0155:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x047a
            r14 = 0
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (double) r14)
            goto L_0x0479
        L_0x0163:
            com.google.android.gms.internal.measurement.zzjc r3 = r0.zzs
            java.lang.Object r12 = com.google.android.gms.internal.measurement.zzkz.zzf(r1, r14)
            java.lang.Object r14 = r0.zzb((int) r10)
            int r3 = r3.zza(r13, r12, r14)
            goto L_0x0479
        L_0x0173:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            com.google.android.gms.internal.measurement.zzkb r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzb((int) r13, (java.util.List<com.google.android.gms.internal.measurement.zzjj>) r3, (com.google.android.gms.internal.measurement.zzkb) r12)
            goto L_0x0479
        L_0x0181:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzc(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x0197:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzg(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x01ad:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzi(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x01c3:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzh(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x01d9:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzd(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x01ef:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzf(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x0205:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzj(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x021b:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzh(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x0231:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzi(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x0246:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zze(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x025b:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzb(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x0270:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zza((java.util.List<java.lang.Long>) r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x0285:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzh(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
            goto L_0x02ae
        L_0x029a:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzi(r3)
            if (r3 <= 0) goto L_0x047a
            int r12 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13)
            int r13 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r3)
        L_0x02ae:
            int r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r13, r12, r3, r11)
            r11 = r3
            goto L_0x047a
        L_0x02b5:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzc(r13, r3, r9)
            goto L_0x0479
        L_0x02bf:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzg(r13, r3, r9)
            goto L_0x0479
        L_0x02c9:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzi(r13, r3, r9)
            goto L_0x0479
        L_0x02d3:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzh(r13, r3, r9)
            goto L_0x0479
        L_0x02dd:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzd(r13, r3, r9)
            goto L_0x0479
        L_0x02e7:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzf(r13, r3, r9)
            goto L_0x0479
        L_0x02f1:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzb(r13, r3)
            goto L_0x0479
        L_0x02fb:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            com.google.android.gms.internal.measurement.zzkb r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zza((int) r13, (java.util.List<?>) r3, (com.google.android.gms.internal.measurement.zzkb) r12)
            goto L_0x0479
        L_0x0309:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zza((int) r13, (java.util.List<?>) r3)
            goto L_0x0479
        L_0x0313:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzj(r13, r3, r9)
            goto L_0x0479
        L_0x031d:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzh(r13, r3, r9)
            goto L_0x0479
        L_0x0327:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzi(r13, r3, r9)
            goto L_0x0479
        L_0x0331:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zze(r13, r3, r9)
            goto L_0x0479
        L_0x033b:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzb((int) r13, (java.util.List<java.lang.Long>) r3, (boolean) r9)
            goto L_0x0479
        L_0x0345:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zza((int) r13, (java.util.List<java.lang.Long>) r3, (boolean) r9)
            goto L_0x0479
        L_0x034f:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzh(r13, r3, r9)
            goto L_0x0479
        L_0x0359:
            java.util.List r3 = zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zzi(r13, r3, r9)
            goto L_0x0479
        L_0x0363:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r1, r14)
            com.google.android.gms.internal.measurement.zzjj r3 = (com.google.android.gms.internal.measurement.zzjj) r3
            com.google.android.gms.internal.measurement.zzkb r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzc(r13, r3, r12)
            goto L_0x0479
        L_0x0379:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            long r14 = com.google.android.gms.internal.measurement.zzkz.zzb(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r13, (long) r14)
            goto L_0x0479
        L_0x0389:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r13, (int) r3)
            goto L_0x0479
        L_0x0399:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r13, (long) r7)
            goto L_0x0479
        L_0x03a5:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzj(r13, r9)
            goto L_0x0479
        L_0x03b1:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzk(r13, r3)
            goto L_0x0479
        L_0x03c1:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r13, (int) r3)
            goto L_0x0479
        L_0x03d1:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r1, r14)
            com.google.android.gms.internal.measurement.zzgp r3 = (com.google.android.gms.internal.measurement.zzgp) r3
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r13, (com.google.android.gms.internal.measurement.zzgp) r3)
            goto L_0x0479
        L_0x03e3:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r1, r14)
            com.google.android.gms.internal.measurement.zzkb r12 = r0.zza((int) r10)
            int r3 = com.google.android.gms.internal.measurement.zzkd.zza((int) r13, (java.lang.Object) r3, (com.google.android.gms.internal.measurement.zzkb) r12)
            goto L_0x0479
        L_0x03f7:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.measurement.zzgp
            if (r12 == 0) goto L_0x040d
            com.google.android.gms.internal.measurement.zzgp r3 = (com.google.android.gms.internal.measurement.zzgp) r3
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r13, (com.google.android.gms.internal.measurement.zzgp) r3)
            goto L_0x0479
        L_0x040d:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (java.lang.String) r3)
            goto L_0x0479
        L_0x0414:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (boolean) r6)
            goto L_0x0479
        L_0x041f:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzi(r13, r9)
            goto L_0x0479
        L_0x042a:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r13, (long) r7)
            goto L_0x0479
        L_0x0435:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r13, (int) r3)
            goto L_0x0479
        L_0x0444:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            long r14 = com.google.android.gms.internal.measurement.zzkz.zzb(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zze((int) r13, (long) r14)
            goto L_0x0479
        L_0x0453:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            long r14 = com.google.android.gms.internal.measurement.zzkz.zzb(r1, r14)
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzd((int) r13, (long) r14)
            goto L_0x0479
        L_0x0462:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (float) r4)
            goto L_0x0479
        L_0x046d:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x047a
            r14 = 0
            int r3 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r13, (double) r14)
        L_0x0479:
            int r11 = r11 + r3
        L_0x047a:
            int r10 = r10 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x0480:
            com.google.android.gms.internal.measurement.zzkt<?, ?> r2 = r0.zzq
            int r1 = zza(r2, r1)
            int r1 = r1 + r11
            return r1
        L_0x0488:
            sun.misc.Unsafe r2 = zzb
            r3 = 0
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 0
        L_0x0490:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r3 >= r9) goto L_0x091b
            int r9 = r0.zzd((int) r3)
            int[] r10 = r0.zzc
            r11 = r10[r3]
            r12 = 267386880(0xff00000, float:2.3665827E-29)
            r12 = r12 & r9
            int r12 = r12 >>> 20
            r13 = 17
            if (r12 > r13) goto L_0x04b9
            int r13 = r3 + 2
            r10 = r10[r13]
            r13 = r10 & r5
            int r10 = r10 >>> 20
            int r6 = r6 << r10
            if (r13 == r7) goto L_0x04ba
            long r7 = (long) r13
            int r7 = r2.getInt(r1, r7)
            r8 = r7
            r7 = r13
            goto L_0x04ba
        L_0x04b9:
            r6 = 0
        L_0x04ba:
            r5 = r5 & r9
            long r9 = (long) r5
            switch(r12) {
                case 0: goto L_0x0904;
                case 1: goto L_0x08fa;
                case 2: goto L_0x08ec;
                case 3: goto L_0x08de;
                case 4: goto L_0x08d0;
                case 5: goto L_0x08c4;
                case 6: goto L_0x08b9;
                case 7: goto L_0x08af;
                case 8: goto L_0x0894;
                case 9: goto L_0x0883;
                case 10: goto L_0x0874;
                case 11: goto L_0x0867;
                case 12: goto L_0x085a;
                case 13: goto L_0x0850;
                case 14: goto L_0x0845;
                case 15: goto L_0x0837;
                case 16: goto L_0x0829;
                case 17: goto L_0x0815;
                case 18: goto L_0x0808;
                case 19: goto L_0x07fa;
                case 20: goto L_0x07ee;
                case 21: goto L_0x07e2;
                case 22: goto L_0x07d6;
                case 23: goto L_0x07ca;
                case 24: goto L_0x07be;
                case 25: goto L_0x07b2;
                case 26: goto L_0x07a6;
                case 27: goto L_0x0796;
                case 28: goto L_0x078a;
                case 29: goto L_0x077d;
                case 30: goto L_0x0770;
                case 31: goto L_0x0763;
                case 32: goto L_0x0756;
                case 33: goto L_0x0749;
                case 34: goto L_0x073c;
                case 35: goto L_0x0722;
                case 36: goto L_0x070d;
                case 37: goto L_0x06f8;
                case 38: goto L_0x06e3;
                case 39: goto L_0x06ce;
                case 40: goto L_0x06b9;
                case 41: goto L_0x06a3;
                case 42: goto L_0x068d;
                case 43: goto L_0x0677;
                case 44: goto L_0x0661;
                case 45: goto L_0x064b;
                case 46: goto L_0x0635;
                case 47: goto L_0x061f;
                case 48: goto L_0x0609;
                case 49: goto L_0x05f9;
                case 50: goto L_0x05e9;
                case 51: goto L_0x05db;
                case 52: goto L_0x05ce;
                case 53: goto L_0x05be;
                case 54: goto L_0x05ae;
                case 55: goto L_0x059e;
                case 56: goto L_0x0590;
                case 57: goto L_0x0583;
                case 58: goto L_0x0576;
                case 59: goto L_0x0558;
                case 60: goto L_0x0544;
                case 61: goto L_0x0532;
                case 62: goto L_0x0522;
                case 63: goto L_0x0512;
                case 64: goto L_0x0505;
                case 65: goto L_0x04f7;
                case 66: goto L_0x04e7;
                case 67: goto L_0x04d7;
                case 68: goto L_0x04c1;
                default: goto L_0x04bf;
            }
        L_0x04bf:
            goto L_0x0911
        L_0x04c1:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            java.lang.Object r5 = r2.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzjj r5 = (com.google.android.gms.internal.measurement.zzjj) r5
            com.google.android.gms.internal.measurement.zzkb r6 = r0.zza((int) r3)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzc(r11, r5, r6)
            goto L_0x08ad
        L_0x04d7:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            long r5 = zze(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r11, (long) r5)
            goto L_0x08ad
        L_0x04e7:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            int r5 = zzd(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r11, (int) r5)
            goto L_0x08ad
        L_0x04f7:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r11, (long) r5)
            goto L_0x08ad
        L_0x0505:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzj(r11, r5)
            goto L_0x08ad
        L_0x0512:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            int r5 = zzd(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzk(r11, r5)
            goto L_0x08ad
        L_0x0522:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            int r5 = zzd(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r11, (int) r5)
            goto L_0x08ad
        L_0x0532:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            java.lang.Object r5 = r2.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzgp r5 = (com.google.android.gms.internal.measurement.zzgp) r5
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r11, (com.google.android.gms.internal.measurement.zzgp) r5)
            goto L_0x08ad
        L_0x0544:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            java.lang.Object r5 = r2.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzkb r6 = r0.zza((int) r3)
            int r5 = com.google.android.gms.internal.measurement.zzkd.zza((int) r11, (java.lang.Object) r5, (com.google.android.gms.internal.measurement.zzkb) r6)
            goto L_0x08ad
        L_0x0558:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            java.lang.Object r5 = r2.getObject(r1, r9)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzgp
            if (r6 == 0) goto L_0x056e
            com.google.android.gms.internal.measurement.zzgp r5 = (com.google.android.gms.internal.measurement.zzgp) r5
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r11, (com.google.android.gms.internal.measurement.zzgp) r5)
            goto L_0x08ad
        L_0x056e:
            java.lang.String r5 = (java.lang.String) r5
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (java.lang.String) r5)
            goto L_0x08ad
        L_0x0576:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            r5 = 1
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (boolean) r5)
            goto L_0x08ad
        L_0x0583:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzi(r11, r5)
            goto L_0x08ad
        L_0x0590:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r11, (long) r5)
            goto L_0x08ad
        L_0x059e:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            int r5 = zzd(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r11, (int) r5)
            goto L_0x08ad
        L_0x05ae:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            long r5 = zze(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11, (long) r5)
            goto L_0x08ad
        L_0x05be:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            long r5 = zze(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzd((int) r11, (long) r5)
            goto L_0x08ad
        L_0x05ce:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (float) r5)
            goto L_0x08ad
        L_0x05db:
            boolean r5 = r0.zza(r1, (int) r11, (int) r3)
            if (r5 == 0) goto L_0x0911
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (double) r5)
            goto L_0x08ad
        L_0x05e9:
            com.google.android.gms.internal.measurement.zzjc r5 = r0.zzs
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.lang.Object r9 = r0.zzb((int) r3)
            int r5 = r5.zza(r11, r6, r9)
            goto L_0x08ad
        L_0x05f9:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzkb r6 = r0.zza((int) r3)
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzb((int) r11, (java.util.List<com.google.android.gms.internal.measurement.zzjj>) r5, (com.google.android.gms.internal.measurement.zzkb) r6)
            goto L_0x08ad
        L_0x0609:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzc(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x061f:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzg(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x0635:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzi(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x064b:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzh(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x0661:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzd(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x0677:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzf(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x068d:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzj(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x06a3:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzh(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x06b9:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzi(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x06ce:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zze(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x06e3:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzb(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x06f8:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zza((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x070d:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzh(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
            goto L_0x0736
        L_0x0722:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzi(r5)
            if (r5 <= 0) goto L_0x0911
            int r6 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11)
            int r9 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r5)
        L_0x0736:
            int r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r9, r6, r5, r4)
            goto L_0x0911
        L_0x073c:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            r6 = 0
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzc(r11, r5, r6)
            goto L_0x0805
        L_0x0749:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzg(r11, r6, r5)
            goto L_0x0805
        L_0x0756:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzi(r11, r6, r5)
            goto L_0x0805
        L_0x0763:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzh(r11, r6, r5)
            goto L_0x0805
        L_0x0770:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzd(r11, r6, r5)
            goto L_0x0805
        L_0x077d:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzf(r11, r6, r5)
            goto L_0x08ad
        L_0x078a:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzb(r11, r5)
            goto L_0x08ad
        L_0x0796:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzkb r6 = r0.zza((int) r3)
            int r5 = com.google.android.gms.internal.measurement.zzkd.zza((int) r11, (java.util.List<?>) r5, (com.google.android.gms.internal.measurement.zzkb) r6)
            goto L_0x08ad
        L_0x07a6:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzkd.zza((int) r11, (java.util.List<?>) r5)
            goto L_0x08ad
        L_0x07b2:
            java.lang.Object r5 = r2.getObject(r1, r9)
            java.util.List r5 = (java.util.List) r5
            r6 = 0
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzj(r11, r5, r6)
            goto L_0x0805
        L_0x07be:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzh(r11, r6, r5)
            goto L_0x0805
        L_0x07ca:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzi(r11, r6, r5)
            goto L_0x0805
        L_0x07d6:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zze(r11, r6, r5)
            goto L_0x0805
        L_0x07e2:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzb((int) r11, (java.util.List<java.lang.Long>) r6, (boolean) r5)
            goto L_0x0805
        L_0x07ee:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zza((int) r11, (java.util.List<java.lang.Long>) r6, (boolean) r5)
            goto L_0x0805
        L_0x07fa:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzh(r11, r6, r5)
        L_0x0805:
            int r4 = r4 + r5
            goto L_0x0913
        L_0x0808:
            r5 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r5 = com.google.android.gms.internal.measurement.zzkd.zzi(r11, r6, r5)
            goto L_0x08ad
        L_0x0815:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            java.lang.Object r5 = r2.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzjj r5 = (com.google.android.gms.internal.measurement.zzjj) r5
            com.google.android.gms.internal.measurement.zzkb r6 = r0.zza((int) r3)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzc(r11, r5, r6)
            goto L_0x08ad
        L_0x0829:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            long r5 = r2.getLong(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r11, (long) r5)
            goto L_0x08ad
        L_0x0837:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            int r5 = r2.getInt(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r11, (int) r5)
            goto L_0x08ad
        L_0x0845:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzh((int) r11, (long) r5)
            goto L_0x08ad
        L_0x0850:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzj(r11, r5)
            goto L_0x08ad
        L_0x085a:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            int r5 = r2.getInt(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzk(r11, r5)
            goto L_0x08ad
        L_0x0867:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            int r5 = r2.getInt(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r11, (int) r5)
            goto L_0x08ad
        L_0x0874:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            java.lang.Object r5 = r2.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzgp r5 = (com.google.android.gms.internal.measurement.zzgp) r5
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r11, (com.google.android.gms.internal.measurement.zzgp) r5)
            goto L_0x08ad
        L_0x0883:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            java.lang.Object r5 = r2.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzkb r6 = r0.zza((int) r3)
            int r5 = com.google.android.gms.internal.measurement.zzkd.zza((int) r11, (java.lang.Object) r5, (com.google.android.gms.internal.measurement.zzkb) r6)
            goto L_0x08ad
        L_0x0894:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            java.lang.Object r5 = r2.getObject(r1, r9)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzgp
            if (r6 == 0) goto L_0x08a7
            com.google.android.gms.internal.measurement.zzgp r5 = (com.google.android.gms.internal.measurement.zzgp) r5
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzc((int) r11, (com.google.android.gms.internal.measurement.zzgp) r5)
            goto L_0x08ad
        L_0x08a7:
            java.lang.String r5 = (java.lang.String) r5
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (java.lang.String) r5)
        L_0x08ad:
            int r4 = r4 + r5
            goto L_0x0911
        L_0x08af:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0911
            r5 = 1
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (boolean) r5)
            goto L_0x090e
        L_0x08b9:
            r5 = r8 & r6
            r6 = 0
            if (r5 == 0) goto L_0x0913
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzi(r11, r6)
        L_0x08c2:
            int r4 = r4 + r5
            goto L_0x0913
        L_0x08c4:
            r5 = r8 & r6
            r9 = 0
            if (r5 == 0) goto L_0x0913
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzg((int) r11, (long) r9)
            goto L_0x0805
        L_0x08d0:
            r5 = r6 & r8
            if (r5 == 0) goto L_0x0913
            int r5 = r2.getInt(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzf((int) r11, (int) r5)
            goto L_0x0805
        L_0x08de:
            r5 = r6 & r8
            if (r5 == 0) goto L_0x0913
            long r5 = r2.getLong(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zze((int) r11, (long) r5)
            goto L_0x0805
        L_0x08ec:
            r5 = r6 & r8
            if (r5 == 0) goto L_0x0913
            long r5 = r2.getLong(r1, r9)
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzd((int) r11, (long) r5)
            goto L_0x0805
        L_0x08fa:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0913
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (float) r5)
            goto L_0x08c2
        L_0x0904:
            r5 = r8 & r6
            if (r5 == 0) goto L_0x0913
            r5 = 0
            int r5 = com.google.android.gms.internal.measurement.zzhi.zzb((int) r11, (double) r5)
        L_0x090e:
            int r5 = r5 + r4
        L_0x090f:
            r4 = r5
            goto L_0x0913
        L_0x0911:
            r5 = r4
            goto L_0x090f
        L_0x0913:
            int r3 = r3 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = 1
            goto L_0x0490
        L_0x091b:
            r2 = 0
            com.google.android.gms.internal.measurement.zzkt<?, ?> r3 = r0.zzq
            int r3 = zza(r3, r1)
            int r3 = r3 + r4
            boolean r4 = r0.zzh
            if (r4 == 0) goto L_0x0975
            com.google.android.gms.internal.measurement.zzhn<?> r4 = r0.zzr
            com.google.android.gms.internal.measurement.zzhr r1 = r4.zza((java.lang.Object) r1)
            r4 = 0
        L_0x092e:
            com.google.android.gms.internal.measurement.zzkc<T, java.lang.Object> r5 = r1.zza
            int r5 = r5.zzc()
            if (r4 >= r5) goto L_0x094e
            com.google.android.gms.internal.measurement.zzkc<T, java.lang.Object> r5 = r1.zza
            java.util.Map$Entry r5 = r5.zzb((int) r4)
            java.lang.Object r6 = r5.getKey()
            com.google.android.gms.internal.measurement.zzht r6 = (com.google.android.gms.internal.measurement.zzht) r6
            java.lang.Object r5 = r5.getValue()
            int r5 = com.google.android.gms.internal.measurement.zzhr.zza((com.google.android.gms.internal.measurement.zzht<?>) r6, (java.lang.Object) r5)
            int r2 = r2 + r5
            int r4 = r4 + 1
            goto L_0x092e
        L_0x094e:
            com.google.android.gms.internal.measurement.zzkc<T, java.lang.Object> r1 = r1.zza
            java.lang.Iterable r1 = r1.zzd()
            java.util.Iterator r1 = r1.iterator()
        L_0x0958:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0974
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            com.google.android.gms.internal.measurement.zzht r5 = (com.google.android.gms.internal.measurement.zzht) r5
            java.lang.Object r4 = r4.getValue()
            int r4 = com.google.android.gms.internal.measurement.zzhr.zza((com.google.android.gms.internal.measurement.zzht<?>) r5, (java.lang.Object) r4)
            int r2 = r2 + r4
            goto L_0x0958
        L_0x0974:
            int r3 = r3 + r2
        L_0x0975:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzb(java.lang.Object):int");
    }

    public static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            throw new RuntimeException(GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline23(GeneratedOutlineSupport.outline3(arrays, name.length() + GeneratedOutlineSupport.outline3(str, 40)), "Field ", str, " for ", name), " not found. Known fields are ", arrays));
        }
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkz.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkz.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkz.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkz.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzd((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zze((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzkd.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzkd.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzkd.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzkd.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzkd.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzkd.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzkd.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.measurement.zzkz.zzc(r10, r6)
            boolean r5 = com.google.android.gms.internal.measurement.zzkz.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.measurement.zzkz.zzd(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.measurement.zzkz.zzd(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.measurement.zzkz.zze(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.measurement.zzkz.zze(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.measurement.zzkt<?, ?> r0 = r9.zzq
            java.lang.Object r0 = r0.zzb(r10)
            com.google.android.gms.internal.measurement.zzkt<?, ?> r2 = r9.zzq
            java.lang.Object r2 = r2.zzb(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.measurement.zzhn<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzhr r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.measurement.zzhn<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzhr r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0229, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022d
            int r3 = r8.zzd((int) r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0229
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            boolean r3 = zzf(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            float r3 = zzc(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            double r3 = zzb(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkz.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkz.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0229
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkz.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzkz.zzc(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkz.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkz.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkz.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzkz.zzd(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzkz.zze(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((long) r3)
        L_0x0227:
            int r3 = r3 + r2
            r2 = r3
        L_0x0229:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022d:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzkt<?, ?> r0 = r8.zzq
            java.lang.Object r0 = r0.zzb(r9)
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            boolean r1 = r8.zzh
            if (r1 == 0) goto L_0x024b
            int r0 = r0 * 53
            com.google.android.gms.internal.measurement.zzhn<?> r1 = r8.zzr
            com.google.android.gms.internal.measurement.zzhr r9 = r1.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r0 = r0 + r9
        L_0x024b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object):int");
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzkz.zzf(t, zzd2);
            Object zzf3 = zzkz.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzkz.zza((Object) t, zzd2, zzia.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzkz.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    public static <UT, UB> int zza(zzkt<UT, UB> zzkt, T t) {
        return zzkt.zzf(zzkt.zzb(t));
    }

    public static List<?> zza(Object obj, long j) {
        return (List) zzkz.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzlm r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.measurement.zzlp.zzb
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.measurement.zzkt<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzlm) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.measurement.zzhn<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzhr r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzkc<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzd((int) r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.measurement.zzhn<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.measurement.zzhn<?> r10 = r13.zzr
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzkb r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkb) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzgp r8 = (com.google.android.gms.internal.measurement.zzgp) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzgp) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzkb r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkb) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzlm) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzf(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, (long) r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.measurement.zzlm) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkb r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzlm) r15, (com.google.android.gms.internal.measurement.zzkb) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzlm) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzlm) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r9, (java.util.List<com.google.android.gms.internal.measurement.zzgp>) r8, (com.google.android.gms.internal.measurement.zzlm) r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkb r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzkd.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzlm) r15, (com.google.android.gms.internal.measurement.zzkb) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.measurement.zzlm) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzlm) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzlm) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzkb r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkb) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzgp r8 = (com.google.android.gms.internal.measurement.zzgp) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzgp) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzkb r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkb) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzlm) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zzkz.zzc(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zzkz.zzd(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.measurement.zzkz.zze(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.measurement.zzhn<?> r14 = r13.zzr
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.measurement.zzhn<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzhr r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzkc<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = 0
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzd((int) r8)
            int[] r10 = r13.zzc
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.measurement.zzhn<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.measurement.zzhn<?> r11 = r13.zzr
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0576
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x055a
        L_0x0576:
            r1 = r3
            goto L_0x055a
        L_0x0578:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a15;
                case 1: goto L_0x0a05;
                case 2: goto L_0x09f5;
                case 3: goto L_0x09e5;
                case 4: goto L_0x09d5;
                case 5: goto L_0x09c5;
                case 6: goto L_0x09b5;
                case 7: goto L_0x09a4;
                case 8: goto L_0x0993;
                case 9: goto L_0x097e;
                case 10: goto L_0x096b;
                case 11: goto L_0x095a;
                case 12: goto L_0x0949;
                case 13: goto L_0x0938;
                case 14: goto L_0x0927;
                case 15: goto L_0x0916;
                case 16: goto L_0x0905;
                case 17: goto L_0x08f0;
                case 18: goto L_0x08df;
                case 19: goto L_0x08ce;
                case 20: goto L_0x08bd;
                case 21: goto L_0x08ac;
                case 22: goto L_0x089b;
                case 23: goto L_0x088a;
                case 24: goto L_0x0879;
                case 25: goto L_0x0868;
                case 26: goto L_0x0857;
                case 27: goto L_0x0842;
                case 28: goto L_0x0831;
                case 29: goto L_0x0820;
                case 30: goto L_0x080f;
                case 31: goto L_0x07fe;
                case 32: goto L_0x07ed;
                case 33: goto L_0x07dc;
                case 34: goto L_0x07cb;
                case 35: goto L_0x07ba;
                case 36: goto L_0x07a9;
                case 37: goto L_0x0798;
                case 38: goto L_0x0787;
                case 39: goto L_0x0776;
                case 40: goto L_0x0765;
                case 41: goto L_0x0754;
                case 42: goto L_0x0743;
                case 43: goto L_0x0732;
                case 44: goto L_0x0721;
                case 45: goto L_0x0710;
                case 46: goto L_0x06ff;
                case 47: goto L_0x06ee;
                case 48: goto L_0x06dd;
                case 49: goto L_0x06c8;
                case 50: goto L_0x06bd;
                case 51: goto L_0x06ac;
                case 52: goto L_0x069b;
                case 53: goto L_0x068a;
                case 54: goto L_0x0679;
                case 55: goto L_0x0668;
                case 56: goto L_0x0657;
                case 57: goto L_0x0646;
                case 58: goto L_0x0635;
                case 59: goto L_0x0624;
                case 60: goto L_0x060f;
                case 61: goto L_0x05fc;
                case 62: goto L_0x05eb;
                case 63: goto L_0x05da;
                case 64: goto L_0x05c9;
                case 65: goto L_0x05b8;
                case 66: goto L_0x05a7;
                case 67: goto L_0x0596;
                case 68: goto L_0x0581;
                default: goto L_0x057f;
            }
        L_0x057f:
            goto L_0x0a24
        L_0x0581:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzkb r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzkb) r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzgp r9 = (com.google.android.gms.internal.measurement.zzgp) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzgp) r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzkb r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzkb) r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzlm) r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzf(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, (long) r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.measurement.zzlm) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkb r11 = r13.zza((int) r8)
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlm) r15, (com.google.android.gms.internal.measurement.zzkb) r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzlm) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzlm) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r10, (java.util.List<com.google.android.gms.internal.measurement.zzgp>) r9, (com.google.android.gms.internal.measurement.zzlm) r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkb r11 = r13.zza((int) r8)
            com.google.android.gms.internal.measurement.zzkd.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlm) r15, (com.google.android.gms.internal.measurement.zzkb) r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzlm) r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzlm) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzkd.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzlm) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzkb r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzkb) r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzgp r9 = (com.google.android.gms.internal.measurement.zzgp) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzgp) r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzkb r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzkb) r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkz.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzlm) r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.measurement.zzkz.zzc(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkz.zzb(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.measurement.zzkz.zzd(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.measurement.zzkz.zze(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.measurement.zzhn<?> r2 = r13.zzr
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0a28
        L_0x0a3c:
            r1 = r3
            goto L_0x0a28
        L_0x0a3e:
            com.google.android.gms.internal.measurement.zzkt<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzlm) r15)
            return
        L_0x0a44:
            r13.zzb(r14, (com.google.android.gms.internal.measurement.zzlm) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlm):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.measurement.zzlm r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.measurement.zzhn<?> r3 = r0.zzr
            com.google.android.gms.internal.measurement.zzhr r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.measurement.zzkc<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zzc
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzb
            r10 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x002f:
            if (r10 >= r6) goto L_0x048f
            int r13 = r0.zzd((int) r10)
            int[] r14 = r0.zzc
            r15 = r14[r10]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            r9 = 17
            if (r4 > r9) goto L_0x005a
            int r9 = r10 + 2
            r9 = r14[r9]
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r9 & r14
            if (r8 == r11) goto L_0x0054
            long r11 = (long) r8
            int r12 = r7.getInt(r1, r11)
            r11 = r8
        L_0x0054:
            int r8 = r9 >>> 20
            r9 = 1
            int r8 = r9 << r8
            goto L_0x005b
        L_0x005a:
            r8 = 0
        L_0x005b:
            if (r5 == 0) goto L_0x0079
            com.google.android.gms.internal.measurement.zzhn<?> r9 = r0.zzr
            int r9 = r9.zza((java.util.Map.Entry<?, ?>) r5)
            if (r9 > r15) goto L_0x0079
            com.google.android.gms.internal.measurement.zzhn<?> r9 = r0.zzr
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0077
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x005b
        L_0x0077:
            r5 = 0
            goto L_0x005b
        L_0x0079:
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r13 & r9
            long r13 = (long) r13
            switch(r4) {
                case 0: goto L_0x0480;
                case 1: goto L_0x0474;
                case 2: goto L_0x0468;
                case 3: goto L_0x045c;
                case 4: goto L_0x0450;
                case 5: goto L_0x0444;
                case 6: goto L_0x0438;
                case 7: goto L_0x042c;
                case 8: goto L_0x0420;
                case 9: goto L_0x040f;
                case 10: goto L_0x0400;
                case 11: goto L_0x03f3;
                case 12: goto L_0x03e6;
                case 13: goto L_0x03d9;
                case 14: goto L_0x03cc;
                case 15: goto L_0x03bf;
                case 16: goto L_0x03b2;
                case 17: goto L_0x03a1;
                case 18: goto L_0x0391;
                case 19: goto L_0x0381;
                case 20: goto L_0x0371;
                case 21: goto L_0x0361;
                case 22: goto L_0x0351;
                case 23: goto L_0x0341;
                case 24: goto L_0x0331;
                case 25: goto L_0x0321;
                case 26: goto L_0x0312;
                case 27: goto L_0x02ff;
                case 28: goto L_0x02f0;
                case 29: goto L_0x02e0;
                case 30: goto L_0x02d0;
                case 31: goto L_0x02c0;
                case 32: goto L_0x02b0;
                case 33: goto L_0x02a0;
                case 34: goto L_0x0290;
                case 35: goto L_0x0280;
                case 36: goto L_0x0270;
                case 37: goto L_0x0260;
                case 38: goto L_0x0250;
                case 39: goto L_0x0240;
                case 40: goto L_0x0230;
                case 41: goto L_0x0220;
                case 42: goto L_0x0210;
                case 43: goto L_0x0200;
                case 44: goto L_0x01f0;
                case 45: goto L_0x01e0;
                case 46: goto L_0x01d0;
                case 47: goto L_0x01c0;
                case 48: goto L_0x01b0;
                case 49: goto L_0x019d;
                case 50: goto L_0x0194;
                case 51: goto L_0x0185;
                case 52: goto L_0x0176;
                case 53: goto L_0x0167;
                case 54: goto L_0x0158;
                case 55: goto L_0x0149;
                case 56: goto L_0x013a;
                case 57: goto L_0x012b;
                case 58: goto L_0x011c;
                case 59: goto L_0x010d;
                case 60: goto L_0x00fa;
                case 61: goto L_0x00ea;
                case 62: goto L_0x00dc;
                case 63: goto L_0x00ce;
                case 64: goto L_0x00c0;
                case 65: goto L_0x00b2;
                case 66: goto L_0x00a4;
                case 67: goto L_0x0096;
                case 68: goto L_0x0084;
                default: goto L_0x0081;
            }
        L_0x0081:
            r4 = 0
            goto L_0x048b
        L_0x0084:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzkb r8 = r0.zza((int) r10)
            r2.zzb((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzkb) r8)
            goto L_0x0081
        L_0x0096:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x0081
        L_0x00a4:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zzf(r15, r4)
            goto L_0x0081
        L_0x00b2:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x0081
        L_0x00c0:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zza((int) r15, (int) r4)
            goto L_0x0081
        L_0x00ce:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zzb((int) r15, (int) r4)
            goto L_0x0081
        L_0x00dc:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zze((int) r15, (int) r4)
            goto L_0x0081
        L_0x00ea:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzgp r4 = (com.google.android.gms.internal.measurement.zzgp) r4
            r2.zza((int) r15, (com.google.android.gms.internal.measurement.zzgp) r4)
            goto L_0x0081
        L_0x00fa:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzkb r8 = r0.zza((int) r10)
            r2.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzkb) r8)
            goto L_0x0081
        L_0x010d:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            java.lang.Object r4 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzlm) r2)
            goto L_0x0081
        L_0x011c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            boolean r4 = zzf(r1, r13)
            r2.zza((int) r15, (boolean) r4)
            goto L_0x0081
        L_0x012b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zzd((int) r15, (int) r4)
            goto L_0x0081
        L_0x013a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x0081
        L_0x0149:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zzc((int) r15, (int) r4)
            goto L_0x0081
        L_0x0158:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x0081
        L_0x0167:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x0081
        L_0x0176:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            float r4 = zzc(r1, r13)
            r2.zza((int) r15, (float) r4)
            goto L_0x0081
        L_0x0185:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            double r13 = zzb(r1, (long) r13)
            r2.zza((int) r15, (double) r13)
            goto L_0x0081
        L_0x0194:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.zza((com.google.android.gms.internal.measurement.zzlm) r2, (int) r15, (java.lang.Object) r4, (int) r10)
            goto L_0x0081
        L_0x019d:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkb r13 = r0.zza((int) r10)
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzlm) r2, (com.google.android.gms.internal.measurement.zzkb) r13)
            goto L_0x0081
        L_0x01b0:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 1
            com.google.android.gms.internal.measurement.zzkd.zze(r4, r8, r2, r15)
            goto L_0x0081
        L_0x01c0:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzj(r4, r8, r2, r15)
            goto L_0x0081
        L_0x01d0:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzg(r4, r8, r2, r15)
            goto L_0x0081
        L_0x01e0:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzl(r4, r8, r2, r15)
            goto L_0x0081
        L_0x01f0:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzm(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0200:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzi(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0210:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzn(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0220:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzk(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0230:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzf(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0240:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzh(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0250:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzd(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0260:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzc(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0270:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzlm) r2, (boolean) r15)
            goto L_0x0081
        L_0x0280:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzlm) r2, (boolean) r15)
            goto L_0x0081
        L_0x0290:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.measurement.zzkd.zze(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02a0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzj(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02b0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzg(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02c0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzl(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02d0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzm(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02e0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzi(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02f0:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzgp>) r8, (com.google.android.gms.internal.measurement.zzlm) r2)
            goto L_0x0081
        L_0x02ff:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkb r13 = r0.zza((int) r10)
            com.google.android.gms.internal.measurement.zzkd.zza((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzlm) r2, (com.google.android.gms.internal.measurement.zzkb) r13)
            goto L_0x0081
        L_0x0312:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zza((int) r4, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.measurement.zzlm) r2)
            goto L_0x0081
        L_0x0321:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.measurement.zzkd.zzn(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0331:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzk(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0341:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzf(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0351:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzh(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0361:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzd(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0371:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzc(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0381:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzlm) r2, (boolean) r15)
            goto L_0x0081
        L_0x0391:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzkd.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzlm) r2, (boolean) r15)
            goto L_0x0081
        L_0x03a1:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzkb r13 = r0.zza((int) r10)
            r2.zzb((int) r15, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkb) r13)
            goto L_0x048b
        L_0x03b2:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x048b
        L_0x03bf:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zzf(r15, r8)
            goto L_0x048b
        L_0x03cc:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x048b
        L_0x03d9:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zza((int) r15, (int) r8)
            goto L_0x048b
        L_0x03e6:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zzb((int) r15, (int) r8)
            goto L_0x048b
        L_0x03f3:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zze((int) r15, (int) r8)
            goto L_0x048b
        L_0x0400:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzgp r8 = (com.google.android.gms.internal.measurement.zzgp) r8
            r2.zza((int) r15, (com.google.android.gms.internal.measurement.zzgp) r8)
            goto L_0x048b
        L_0x040f:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzkb r13 = r0.zza((int) r10)
            r2.zza((int) r15, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzkb) r13)
            goto L_0x048b
        L_0x0420:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            java.lang.Object r8 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzlm) r2)
            goto L_0x048b
        L_0x042c:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            boolean r8 = com.google.android.gms.internal.measurement.zzkz.zzc(r1, r13)
            r2.zza((int) r15, (boolean) r8)
            goto L_0x048b
        L_0x0438:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zzd((int) r15, (int) r8)
            goto L_0x048b
        L_0x0444:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x048b
        L_0x0450:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zzc((int) r15, (int) r8)
            goto L_0x048b
        L_0x045c:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x048b
        L_0x0468:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x048b
        L_0x0474:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            float r8 = com.google.android.gms.internal.measurement.zzkz.zzd(r1, r13)
            r2.zza((int) r15, (float) r8)
            goto L_0x048b
        L_0x0480:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            double r13 = com.google.android.gms.internal.measurement.zzkz.zze(r1, r13)
            r2.zza((int) r15, (double) r13)
        L_0x048b:
            int r10 = r10 + 3
            goto L_0x002f
        L_0x048f:
            if (r5 == 0) goto L_0x04a6
            com.google.android.gms.internal.measurement.zzhn<?> r4 = r0.zzr
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a4
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x048f
        L_0x04a4:
            r5 = 0
            goto L_0x048f
        L_0x04a6:
            com.google.android.gms.internal.measurement.zzkt<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.measurement.zzlm) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzlm):void");
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    public static <T> double zzb(T t, long j) {
        return ((Double) zzkz.zzf(t, j)).doubleValue();
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzkz.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzkz.zza((Object) t, j));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzkz.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final <K, V> void zza(zzlm zzlm, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlm.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    public static <UT, UB> void zza(zzkt<UT, UB> zzkt, T t, zzlm zzlm) throws IOException {
        zzkt.zza(zzkt.zzb(t), zzlm);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzjy r14, com.google.android.gms.internal.measurement.zzhl r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x05de
            com.google.android.gms.internal.measurement.zzkt<?, ?> r8 = r12.zzq
            com.google.android.gms.internal.measurement.zzhn<?> r9 = r12.zzr
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zza()     // Catch:{ all -> 0x05c6 }
            int r3 = r12.zzg(r2)     // Catch:{ all -> 0x05c6 }
            if (r3 >= 0) goto L_0x0078
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzm
        L_0x001a:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r8.zzb((java.lang.Object) r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r3 = r12.zzh     // Catch:{ all -> 0x05c6 }
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.measurement.zzjj r3 = r12.zzg     // Catch:{ all -> 0x05c6 }
            java.lang.Object r2 = r9.zza(r15, r3, r2)     // Catch:{ all -> 0x05c6 }
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.measurement.zzhr r1 = r9.zzb(r13)     // Catch:{ all -> 0x05c6 }
        L_0x0044:
            r11 = r1
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x05c6 }
            r1 = r11
            goto L_0x0009
        L_0x0051:
            r8.zza((com.google.android.gms.internal.measurement.zzjy) r14)     // Catch:{ all -> 0x05c6 }
            if (r10 != 0) goto L_0x005b
            java.lang.Object r2 = r8.zzc(r13)     // Catch:{ all -> 0x05c6 }
            r10 = r2
        L_0x005b:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzjy) r14)     // Catch:{ all -> 0x05c6 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0063:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0072
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0063
        L_0x0072:
            if (r10 == 0) goto L_0x0077
            r8.zzb((java.lang.Object) r13, r10)
        L_0x0077:
            return
        L_0x0078:
            int r4 = r12.zzd((int) r3)     // Catch:{ all -> 0x05c6 }
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r5 = r5 & r4
            int r5 = r5 >>> 20
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x0572;
                case 1: goto L_0x0563;
                case 2: goto L_0x0554;
                case 3: goto L_0x0545;
                case 4: goto L_0x0536;
                case 5: goto L_0x0527;
                case 6: goto L_0x0518;
                case 7: goto L_0x0509;
                case 8: goto L_0x0501;
                case 9: goto L_0x04d0;
                case 10: goto L_0x04c1;
                case 11: goto L_0x04b2;
                case 12: goto L_0x0490;
                case 13: goto L_0x0481;
                case 14: goto L_0x0472;
                case 15: goto L_0x0463;
                case 16: goto L_0x0454;
                case 17: goto L_0x0423;
                case 18: goto L_0x0415;
                case 19: goto L_0x0407;
                case 20: goto L_0x03f9;
                case 21: goto L_0x03eb;
                case 22: goto L_0x03dd;
                case 23: goto L_0x03cf;
                case 24: goto L_0x03c1;
                case 25: goto L_0x03b3;
                case 26: goto L_0x0391;
                case 27: goto L_0x037f;
                case 28: goto L_0x0371;
                case 29: goto L_0x0363;
                case 30: goto L_0x034e;
                case 31: goto L_0x0340;
                case 32: goto L_0x0332;
                case 33: goto L_0x0324;
                case 34: goto L_0x0316;
                case 35: goto L_0x0308;
                case 36: goto L_0x02fa;
                case 37: goto L_0x02ec;
                case 38: goto L_0x02de;
                case 39: goto L_0x02d0;
                case 40: goto L_0x02c2;
                case 41: goto L_0x02b4;
                case 42: goto L_0x02a6;
                case 43: goto L_0x0298;
                case 44: goto L_0x0283;
                case 45: goto L_0x0275;
                case 46: goto L_0x0267;
                case 47: goto L_0x0259;
                case 48: goto L_0x024b;
                case 49: goto L_0x0239;
                case 50: goto L_0x01f7;
                case 51: goto L_0x01e5;
                case 52: goto L_0x01d3;
                case 53: goto L_0x01c1;
                case 54: goto L_0x01af;
                case 55: goto L_0x019d;
                case 56: goto L_0x018b;
                case 57: goto L_0x0179;
                case 58: goto L_0x0167;
                case 59: goto L_0x015f;
                case 60: goto L_0x012e;
                case 61: goto L_0x0120;
                case 62: goto L_0x010e;
                case 63: goto L_0x00e9;
                case 64: goto L_0x00d7;
                case 65: goto L_0x00c5;
                case 66: goto L_0x00b3;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008f;
                default: goto L_0x0087;
            }
        L_0x0087:
            if (r10 != 0) goto L_0x0582
            java.lang.Object r2 = r8.zza()     // Catch:{ zzii -> 0x059f }
            goto L_0x0581
        L_0x008f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkb r6 = r12.zza((int) r3)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r6 = r14.zzb(r6, r15)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x00a1:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzt()     // Catch:{ zzii -> 0x059f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x00b3:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            int r6 = r14.zzs()     // Catch:{ zzii -> 0x059f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x00c5:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzr()     // Catch:{ zzii -> 0x059f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x00d7:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            int r6 = r14.zzq()     // Catch:{ zzii -> 0x059f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x00e9:
            int r5 = r14.zzp()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzif r7 = r12.zzc((int) r3)     // Catch:{ zzii -> 0x059f }
            if (r7 == 0) goto L_0x0100
            boolean r7 = r7.zza(r5)     // Catch:{ zzii -> 0x059f }
            if (r7 == 0) goto L_0x00fa
            goto L_0x0100
        L_0x00fa:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzkd.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0100:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzii -> 0x059f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r6, (java.lang.Object) r4)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x010e:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            int r6 = r14.zzo()     // Catch:{ zzii -> 0x059f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0120:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzgp r6 = r14.zzn()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x012e:
            boolean r5 = r12.zza(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            if (r5 == 0) goto L_0x014a
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzkz.zzf(r13, r4)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkb r7 = r12.zza((int) r3)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            goto L_0x015a
        L_0x014a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkb r6 = r12.zza((int) r3)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
        L_0x015a:
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x015f:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.measurement.zzjy) r14)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0167:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            boolean r6 = r14.zzk()     // Catch:{ zzii -> 0x059f }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0179:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            int r6 = r14.zzj()     // Catch:{ zzii -> 0x059f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x018b:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzi()     // Catch:{ zzii -> 0x059f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x019d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            int r6 = r14.zzh()     // Catch:{ zzii -> 0x059f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x01af:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzf()     // Catch:{ zzii -> 0x059f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x01c1:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzg()     // Catch:{ zzii -> 0x059f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x01d3:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            float r6 = r14.zze()     // Catch:{ zzii -> 0x059f }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x01e5:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzii -> 0x059f }
            double r6 = r14.zzd()     // Catch:{ zzii -> 0x059f }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x01f7:
            java.lang.Object r2 = r12.zzb((int) r3)     // Catch:{ zzii -> 0x059f }
            int r3 = r12.zzd((int) r3)     // Catch:{ zzii -> 0x059f }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkz.zzf(r13, r3)     // Catch:{ zzii -> 0x059f }
            if (r5 != 0) goto L_0x0211
            com.google.android.gms.internal.measurement.zzjc r5 = r12.zzs     // Catch:{ zzii -> 0x059f }
            java.lang.Object r5 = r5.zze(r2)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzii -> 0x059f }
            goto L_0x0228
        L_0x0211:
            com.google.android.gms.internal.measurement.zzjc r6 = r12.zzs     // Catch:{ zzii -> 0x059f }
            boolean r6 = r6.zzc(r5)     // Catch:{ zzii -> 0x059f }
            if (r6 == 0) goto L_0x0228
            com.google.android.gms.internal.measurement.zzjc r6 = r12.zzs     // Catch:{ zzii -> 0x059f }
            java.lang.Object r6 = r6.zze(r2)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzjc r7 = r12.zzs     // Catch:{ zzii -> 0x059f }
            r7.zza(r6, r5)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r6)     // Catch:{ zzii -> 0x059f }
            r5 = r6
        L_0x0228:
            com.google.android.gms.internal.measurement.zzjc r3 = r12.zzs     // Catch:{ zzii -> 0x059f }
            java.util.Map r3 = r3.zza(r5)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzjc r4 = r12.zzs     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzja r2 = r4.zzf(r2)     // Catch:{ zzii -> 0x059f }
            r14.zza(r3, r2, (com.google.android.gms.internal.measurement.zzhl) r15)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0239:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkb r2 = r12.zza((int) r3)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzit r3 = r12.zzp     // Catch:{ zzii -> 0x059f }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzii -> 0x059f }
            r14.zzb(r3, r2, r15)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x024b:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzq(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0259:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzp(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0267:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzo(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0275:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzn(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0283:
            com.google.android.gms.internal.measurement.zzit r5 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzii -> 0x059f }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzii -> 0x059f }
            r14.zzm(r4)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzif r3 = r12.zzc((int) r3)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzkd.zza(r2, r4, r3, r10, r8)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0298:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzl(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x02a6:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzh(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x02b4:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzg(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x02c2:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzf(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x02d0:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zze(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x02de:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzc(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x02ec:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzd(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x02fa:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzb(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0308:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zza(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0316:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzq(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0324:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzp(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0332:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzo(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0340:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzn(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x034e:
            com.google.android.gms.internal.measurement.zzit r5 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzii -> 0x059f }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzii -> 0x059f }
            r14.zzm(r4)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzif r3 = r12.zzc((int) r3)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzkd.zza(r2, r4, r3, r10, r8)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0363:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzl(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0371:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzk(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x037f:
            com.google.android.gms.internal.measurement.zzkb r2 = r12.zza((int) r3)     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzit r5 = r12.zzp     // Catch:{ zzii -> 0x059f }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zza(r3, r2, (com.google.android.gms.internal.measurement.zzhl) r15)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0391:
            boolean r2 = zzf(r4)     // Catch:{ zzii -> 0x059f }
            if (r2 == 0) goto L_0x03a5
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzj(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x03a5:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzi(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x03b3:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzh(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x03c1:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzg(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x03cf:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzf(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x03dd:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zze(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x03eb:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzc(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x03f9:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzd(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0407:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zzb(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0415:
            com.google.android.gms.internal.measurement.zzit r2 = r12.zzp     // Catch:{ zzii -> 0x059f }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzii -> 0x059f }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzii -> 0x059f }
            r14.zza(r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0423:
            boolean r2 = r12.zza(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            if (r2 == 0) goto L_0x0441
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzkz.zzf(r13, r4)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkb r3 = r12.zza((int) r3)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r3 = r14.zzb(r3, r15)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0441:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkb r2 = r12.zza((int) r3)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0454:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzt()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0463:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            int r2 = r14.zzs()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0472:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzr()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0481:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            int r2 = r14.zzq()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0490:
            int r5 = r14.zzp()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzif r7 = r12.zzc((int) r3)     // Catch:{ zzii -> 0x059f }
            if (r7 == 0) goto L_0x04a7
            boolean r7 = r7.zza(r5)     // Catch:{ zzii -> 0x059f }
            if (r7 == 0) goto L_0x04a1
            goto L_0x04a7
        L_0x04a1:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzkd.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x04a7:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r6, (int) r5)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x04b2:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            int r2 = r14.zzo()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x04c1:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzgp r2 = r14.zzn()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x04d0:
            boolean r2 = r12.zza(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            if (r2 == 0) goto L_0x04ee
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzkz.zzf(r13, r4)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkb r3 = r12.zza((int) r3)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x04ee:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkb r2 = r12.zza((int) r3)     // Catch:{ zzii -> 0x059f }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0501:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.measurement.zzjy) r14)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0509:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            boolean r2 = r14.zzk()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (boolean) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0518:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            int r2 = r14.zzj()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0527:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzi()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0536:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            int r2 = r14.zzh()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0545:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzf()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0554:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            long r6 = r14.zzg()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0563:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            float r2 = r14.zze()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (float) r2)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0572:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzii -> 0x059f }
            double r6 = r14.zzd()     // Catch:{ zzii -> 0x059f }
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r13, (long) r4, (double) r6)     // Catch:{ zzii -> 0x059f }
            r12.zzb(r13, (int) r3)     // Catch:{ zzii -> 0x059f }
            goto L_0x0009
        L_0x0581:
            r10 = r2
        L_0x0582:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzjy) r14)     // Catch:{ zzii -> 0x059f }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x058a:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0599
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x058a
        L_0x0599:
            if (r10 == 0) goto L_0x059e
            r8.zzb((java.lang.Object) r13, r10)
        L_0x059e:
            return
        L_0x059f:
            r8.zza((com.google.android.gms.internal.measurement.zzjy) r14)     // Catch:{ all -> 0x05c6 }
            if (r10 != 0) goto L_0x05a9
            java.lang.Object r2 = r8.zzc(r13)     // Catch:{ all -> 0x05c6 }
            r10 = r2
        L_0x05a9:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzjy) r14)     // Catch:{ all -> 0x05c6 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x05b1:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x05c0
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05b1
        L_0x05c0:
            if (r10 == 0) goto L_0x05c5
            r8.zzb((java.lang.Object) r13, r10)
        L_0x05c5:
            return
        L_0x05c6:
            r14 = move-exception
            int r15 = r12.zzm
        L_0x05c9:
            int r0 = r12.zzn
            if (r15 >= r0) goto L_0x05d8
            int[] r0 = r12.zzl
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x05c9
        L_0x05d8:
            if (r10 == 0) goto L_0x05dd
            r8.zzb((java.lang.Object) r13, r10)
        L_0x05dd:
            throw r14
        L_0x05de:
            goto L_0x05e0
        L_0x05df:
            throw r0
        L_0x05e0:
            goto L_0x05df
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzjy, com.google.android.gms.internal.measurement.zzhl):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.measurement.zzlg r4, java.lang.Class<?> r5, com.google.android.gms.internal.measurement.zzgo r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.measurement.zzjm.zza
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzd(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzb(r1, r2, r6)
            long r2 = r6.zzb
            long r2 = com.google.android.gms.internal.measurement.zzhb.zza((long) r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r1, r2, r6)
            int r2 = r6.zza
            int r2 = com.google.android.gms.internal.measurement.zzhb.zze(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.measurement.zzjx r4 = com.google.android.gms.internal.measurement.zzjx.zza()
            com.google.android.gms.internal.measurement.zzkb r4 = r4.zza(r5)
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza((com.google.android.gms.internal.measurement.zzkb) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzgo) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzb(r1, r2, r6)
            long r2 = r6.zzb
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r1, r2, r6)
            int r2 = r6.zza
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.measurement.zzgl.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzc = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.measurement.zzgl.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzc = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzc = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.measurement.zzgl.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzc = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.measurement.zzgl.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzb(r1, r2, r6)
            long r2 = r6.zzb
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzc = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(byte[], int, int, com.google.android.gms.internal.measurement.zzlg, java.lang.Class, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0422 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzgo r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzig r11 = (com.google.android.gms.internal.measurement.zzig) r11
            boolean r12 = r11.zza()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.measurement.zzig r11 = r11.zza(r12)
            sun.misc.Unsafe r12 = zzb
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x03a6;
                case 20: goto L_0x0365;
                case 21: goto L_0x0365;
                case 22: goto L_0x034b;
                case 23: goto L_0x030c;
                case 24: goto L_0x02cd;
                case 25: goto L_0x0276;
                case 26: goto L_0x01c3;
                case 27: goto L_0x01a9;
                case 28: goto L_0x0151;
                case 29: goto L_0x034b;
                case 30: goto L_0x0119;
                case 31: goto L_0x02cd;
                case 32: goto L_0x030c;
                case 33: goto L_0x00cc;
                case 34: goto L_0x007f;
                case 35: goto L_0x03e4;
                case 36: goto L_0x03a6;
                case 37: goto L_0x0365;
                case 38: goto L_0x0365;
                case 39: goto L_0x034b;
                case 40: goto L_0x030c;
                case 41: goto L_0x02cd;
                case 42: goto L_0x0276;
                case 43: goto L_0x034b;
                case 44: goto L_0x0119;
                case 45: goto L_0x02cd;
                case 46: goto L_0x030c;
                case 47: goto L_0x00cc;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0422
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0422
            com.google.android.gms.internal.measurement.zzkb r1 = r0.zza((int) r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza((com.google.android.gms.internal.measurement.zzkb) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.measurement.zzgo) r27)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza((com.google.android.gms.internal.measurement.zzkb) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.measurement.zzgo) r27)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzhb.zza((long) r4)
            r11.zza((long) r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzhb.zza((long) r8)
            r11.zza((long) r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzhb.zza((long) r8)
            r11.zza((long) r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzhb.zze(r4)
            r11.zzd(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzhb.zze(r4)
            r11.zzd(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzhb.zze(r4)
            r11.zzd(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.measurement.zzgl.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzig<?>) r11, (com.google.android.gms.internal.measurement.zzgo) r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.measurement.zzgl.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzig<?>) r6, (com.google.android.gms.internal.measurement.zzgo) r7)
        L_0x0131:
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1
            com.google.android.gms.internal.measurement.zzks r3 = r1.zzb
            com.google.android.gms.internal.measurement.zzks r4 = com.google.android.gms.internal.measurement.zzks.zza()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.measurement.zzif r4 = r0.zzc((int) r8)
            com.google.android.gms.internal.measurement.zzkt<?, ?> r5 = r0.zzq
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkd.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.measurement.zzks r3 = (com.google.android.gms.internal.measurement.zzks) r3
            if (r3 == 0) goto L_0x014e
            r1.zzb = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.measurement.zzgp r4 = com.google.android.gms.internal.measurement.zzgp.zza
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.measurement.zzgp r6 = com.google.android.gms.internal.measurement.zzgp.zza((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.measurement.zzgp r4 = com.google.android.gms.internal.measurement.zzgp.zza
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.measurement.zzgp r6 = com.google.android.gms.internal.measurement.zzgp.zza((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.measurement.zzkb r1 = r0.zza((int) r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x0216
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0211
            if (r6 != 0) goto L_0x01de
            r11.add(r1)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzia.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01e8:
            int r4 = r4 + r6
        L_0x01e9:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x020c
            if (r6 != 0) goto L_0x0201
            r11.add(r1)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzia.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x0216:
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0271
            if (r6 != 0) goto L_0x0224
            r11.add(r1)
            goto L_0x0237
        L_0x0224:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzlb.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzia.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x0236:
            r4 = r8
        L_0x0237:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0267
            if (r6 != 0) goto L_0x024f
            r11.add(r1)
            goto L_0x0237
        L_0x024f:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzlb.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzia.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzh()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzh()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzb()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.measurement.zzgn r11 = (com.google.android.gms.internal.measurement.zzgn) r11
            int r2 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0290
            r5 = 1
            goto L_0x0291
        L_0x0290:
            r5 = 0
        L_0x0291:
            r11.zza((boolean) r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgn r11 = (com.google.android.gms.internal.measurement.zzgn) r11
            int r4 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r11.zza((boolean) r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = 1
            goto L_0x02c9
        L_0x02c8:
            r6 = 0
        L_0x02c9:
            r11.zza((boolean) r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r18, r19)
            r11.zzd(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4)
            r11.zzd(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r1)
            r11.zza((long) r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            long r8 = com.google.android.gms.internal.measurement.zzgl.zzb(r18, r19)
            r11.zza((long) r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r4)
            r11.zza((long) r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzig<?>) r11, (com.google.android.gms.internal.measurement.zzgo) r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.measurement.zzig<?>) r25, (com.google.android.gms.internal.measurement.zzgo) r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r1, r7)
            long r4 = r7.zzb
            r11.zza((long) r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza((long) r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza((long) r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.measurement.zzhx r11 = (com.google.android.gms.internal.measurement.zzhx) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.measurement.zzgl.zzd(r3, r1)
            r11.zza((float) r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzhx r11 = (com.google.android.gms.internal.measurement.zzhx) r11
            float r1 = com.google.android.gms.internal.measurement.zzgl.zzd(r18, r19)
            r11.zza((float) r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.measurement.zzgl.zzd(r3, r4)
            r11.zza((float) r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.measurement.zzhj r11 = (com.google.android.gms.internal.measurement.zzhj) r11
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.measurement.zzgl.zzc(r3, r1)
            r11.zza((double) r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zza()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zzhj r11 = (com.google.android.gms.internal.measurement.zzhj) r11
            double r8 = com.google.android.gms.internal.measurement.zzgl.zzc(r18, r19)
            r11.zza((double) r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.measurement.zzgl.zzc(r3, r4)
            r11.zza((double) r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.measurement.zzgo r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r12 = r7.zzb((int) r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.measurement.zzjc r2 = r7.zzs
            boolean r2 = r2.zzc(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.measurement.zzjc r2 = r7.zzs
            java.lang.Object r2 = r2.zze(r12)
            com.google.android.gms.internal.measurement.zzjc r3 = r7.zzs
            r3.zza(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zzjc r8 = r7.zzs
            com.google.android.gms.internal.measurement.zzja r8 = r8.zzf(r12)
            com.google.android.gms.internal.measurement.zzjc r12 = r7.zzs
            java.util.Map r12 = r12.zza(r1)
            int r10 = com.google.android.gms.internal.measurement.zzgl.zza(r9, r10, r15)
            int r13 = r15.zza
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzb
            V r0 = r8.zzd
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.measurement.zzgl.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.measurement.zzgo) r15)
            int r10 = r15.zza
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.measurement.zzlg r1 = r8.zzc
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzlg r4 = r8.zzc
            V r10 = r8.zzd
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzlg) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzgo) r6)
            java.lang.Object r0 = r15.zzc
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.measurement.zzlg r1 = r8.zza
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzlg r4 = r8.zza
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzlg) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzgo) r6)
            java.lang.Object r14 = r15.zzc
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.measurement.zzgl.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.measurement.zzgo) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.measurement.zzij r8 = com.google.android.gms.internal.measurement.zzij.zzg()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.measurement.zzij r8 = com.google.android.gms.internal.measurement.zzij.zza()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.measurement.zzgo r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzb
            int[] r7 = r0.zzc
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.measurement.zzkb r2 = r0.zza((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzgl.zza((com.google.android.gms.internal.measurement.zzkb) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.measurement.zzgo) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r4, r11)
            long r3 = r11.zzb
            long r3 = com.google.android.gms.internal.measurement.zzhb.zza((long) r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.measurement.zzhb.zze(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r11)
            int r4 = r11.zza
            com.google.android.gms.internal.measurement.zzif r5 = r0.zzc((int) r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zza(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.measurement.zzks r1 = zze((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zza((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgl.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.measurement.zzkb r2 = r0.zza((int) r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.measurement.zzgl.zza((com.google.android.gms.internal.measurement.zzkb) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzgo) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r11)
            int r4 = r11.zza
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.measurement.zzlb.zza((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.measurement.zzij r1 = com.google.android.gms.internal.measurement.zzij.zzh()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.measurement.zzia.zza
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r4, r11)
            long r3 = r11.zzb
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgl.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.measurement.zzgl.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgl.zza(r3, r4, r11)
            int r3 = r11.zza
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgl.zzb(r3, r4, r11)
            long r3 = r11.zzb
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.measurement.zzgl.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.measurement.zzgl.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.measurement.zzgo):int");
    }

    private final zzkb zza(int i) {
        int i2 = (i / 3) << 1;
        zzkb zzkb = (zzkb) this.zzd[i2];
        if (zzkb != null) {
            return zzkb;
        }
        zzkb zza2 = zzjx.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03bb, code lost:
        if (r0 == r15) goto L_0x0424;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x03fe, code lost:
        if (r0 == r15) goto L_0x0424;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x025a, code lost:
        r5 = r6 | r22;
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x025e, code lost:
        r3 = r8;
        r1 = r9;
        r9 = r13;
        r13 = r2;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02cc, code lost:
        r5 = r6 | r22;
        r6 = r30;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x030a, code lost:
        r5 = r6 | r22;
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x030e, code lost:
        r3 = r8;
        r1 = r9;
        r2 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0312, code lost:
        r13 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0316, code lost:
        r7 = r32;
        r2 = r3;
        r22 = r6;
        r26 = r10;
        r17 = r11;
        r6 = r30;
        r30 = r9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.measurement.zzgo r33) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r33
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x04cb
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzgo) r9)
            int r3 = r9.zza
            r4 = r3
            r3 = r0
            goto L_0x002b
        L_0x002a:
            r4 = r0
        L_0x002b:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r1) goto L_0x0038
            int r2 = r2 / r8
            int r1 = r15.zza((int) r0, (int) r2)
            goto L_0x003c
        L_0x0038:
            int r1 = r15.zzg(r0)
        L_0x003c:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004f
            r30 = r0
            r2 = r3
            r8 = r4
            r22 = r5
            r26 = r10
            r7 = r11
            r17 = 0
            r18 = -1
            goto L_0x0428
        L_0x004f:
            int[] r1 = r15.zzc
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = r4
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r8 & r17
            long r12 = (long) r4
            r4 = 17
            r20 = r8
            if (r11 > r4) goto L_0x0325
            int r4 = r2 + 2
            r1 = r1[r4]
            int r4 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r4
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r4
            if (r1 == r6) goto L_0x0085
            if (r6 == r4) goto L_0x007e
            long r8 = (long) r6
            r10.putInt(r14, r8, r5)
        L_0x007e:
            long r5 = (long) r1
            int r5 = r10.getInt(r14, r5)
            r8 = r1
            goto L_0x0086
        L_0x0085:
            r8 = r6
        L_0x0086:
            r6 = r5
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02ee;
                case 1: goto L_0x02d2;
                case 2: goto L_0x02a9;
                case 3: goto L_0x02a9;
                case 4: goto L_0x028c;
                case 5: goto L_0x0265;
                case 6: goto L_0x023d;
                case 7: goto L_0x0210;
                case 8: goto L_0x01e6;
                case 9: goto L_0x01ab;
                case 10: goto L_0x018d;
                case 11: goto L_0x028c;
                case 12: goto L_0x014e;
                case 13: goto L_0x023d;
                case 14: goto L_0x0265;
                case 15: goto L_0x012d;
                case 16: goto L_0x00f9;
                case 17: goto L_0x009c;
                default: goto L_0x008b;
            }
        L_0x008b:
            r12 = r29
            r13 = r33
            r9 = r0
            r11 = r2
            r30 = r8
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0316
        L_0x009c:
            r5 = 3
            if (r7 != r5) goto L_0x00e7
            int r1 = r0 << 3
            r5 = r1 | 4
            com.google.android.gms.internal.measurement.zzkb r1 = r15.zza((int) r2)
            r9 = r0
            r0 = r1
            r18 = -1
            r1 = r29
            r11 = r2
            r2 = r3
            r3 = r31
            r7 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r5
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza((com.google.android.gms.internal.measurement.zzkb) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.measurement.zzgo) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00c9
            r4 = r33
            java.lang.Object r1 = r4.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x00d8
        L_0x00c9:
            r4 = r33
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r4.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r12, r1)
        L_0x00d8:
            r5 = r6 | r22
            r12 = r29
            r13 = r31
            r3 = r7
            r6 = r8
            r1 = r9
            r2 = r11
            r11 = r32
            r9 = r4
            goto L_0x0019
        L_0x00e7:
            r9 = r0
            r11 = r2
            r7 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            r30 = r8
            r8 = r7
            goto L_0x0316
        L_0x00f9:
            r4 = r33
            r9 = r0
            r11 = r2
            r5 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x0125
            r1 = r12
            r12 = r29
            int r7 = com.google.android.gms.internal.measurement.zzgl.zzb(r12, r3, r4)
            r20 = r1
            long r0 = r4.zzb
            long r23 = com.google.android.gms.internal.measurement.zzhb.zza((long) r0)
            r0 = r10
            r2 = r20
            r1 = r28
            r13 = r4
            r30 = r8
            r8 = r5
            r4 = r23
            r0.putLong(r1, r2, r4)
            goto L_0x02cc
        L_0x0125:
            r12 = r29
            r13 = r4
            r30 = r8
            r8 = r5
            goto L_0x0316
        L_0x012d:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r12, r3, r13)
            int r1 = r13.zza
            int r1 = com.google.android.gms.internal.measurement.zzhb.zze(r1)
            r10.putInt(r14, r4, r1)
            goto L_0x030a
        L_0x014e:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r12, r3, r13)
            int r1 = r13.zza
            com.google.android.gms.internal.measurement.zzif r2 = r15.zzc((int) r11)
            if (r2 == 0) goto L_0x0188
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x0173
            goto L_0x0188
        L_0x0173:
            com.google.android.gms.internal.measurement.zzks r2 = zze((java.lang.Object) r28)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zza((int) r8, (java.lang.Object) r1)
            r5 = r6
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
            r6 = r30
            goto L_0x0312
        L_0x0188:
            r10.putInt(r14, r4, r1)
            goto L_0x030a
        L_0x018d:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x0316
            int r0 = com.google.android.gms.internal.measurement.zzgl.zze(r12, r3, r13)
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x030a
        L_0x01ab:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x01e2
            com.google.android.gms.internal.measurement.zzkb r0 = r15.zza((int) r11)
            r2 = r31
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza((com.google.android.gms.internal.measurement.zzkb) r0, (byte[]) r12, (int) r3, (int) r2, (com.google.android.gms.internal.measurement.zzgo) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01d3
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x025a
        L_0x01d3:
            java.lang.Object r1 = r10.getObject(r14, r4)
            java.lang.Object r3 = r13.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r1, (java.lang.Object) r3)
            r10.putObject(r14, r4, r1)
            goto L_0x025a
        L_0x01e2:
            r2 = r31
            goto L_0x0316
        L_0x01e6:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r0) goto L_0x0316
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x0206
            int r0 = com.google.android.gms.internal.measurement.zzgl.zzc(r12, r3, r13)
            goto L_0x020a
        L_0x0206:
            int r0 = com.google.android.gms.internal.measurement.zzgl.zzd(r12, r3, r13)
        L_0x020a:
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x025a
        L_0x0210:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r0 = com.google.android.gms.internal.measurement.zzgl.zzb(r12, r3, r13)
            r3 = r0
            long r0 = r13.zzb
            r20 = 0
            int r7 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r7 == 0) goto L_0x0233
            r0 = 1
            goto L_0x0234
        L_0x0233:
            r0 = 0
        L_0x0234:
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r4, (boolean) r0)
            r5 = r6 | r22
            r6 = r30
            r0 = r3
            goto L_0x025e
        L_0x023d:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r1) goto L_0x0316
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r12, r3)
            r10.putInt(r14, r4, r0)
            int r0 = r3 + 4
        L_0x025a:
            r5 = r6 | r22
            r6 = r30
        L_0x025e:
            r3 = r8
            r1 = r9
            r9 = r13
            r13 = r2
            r2 = r11
            goto L_0x04c7
        L_0x0265:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r0) goto L_0x0316
            long r20 = com.google.android.gms.internal.measurement.zzgl.zzb(r12, r3)
            r0 = r10
            r1 = r28
            r7 = r3
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x030a
        L_0x028c:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r12, r3, r13)
            int r1 = r13.zza
            r10.putInt(r14, r4, r1)
            goto L_0x030a
        L_0x02a9:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r7 = com.google.android.gms.internal.measurement.zzgl.zzb(r12, r3, r13)
            long r2 = r13.zzb
            r0 = r10
            r1 = r28
            r20 = r2
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
        L_0x02cc:
            r5 = r6 | r22
            r6 = r30
            r0 = r7
            goto L_0x030e
        L_0x02d2:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r1) goto L_0x0316
            float r0 = com.google.android.gms.internal.measurement.zzgl.zzd(r12, r3)
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r4, (float) r0)
            int r0 = r3 + 4
            goto L_0x030a
        L_0x02ee:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x0316
            double r0 = com.google.android.gms.internal.measurement.zzgl.zzc(r12, r3)
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r4, (double) r0)
            int r0 = r3 + 8
        L_0x030a:
            r5 = r6 | r22
            r6 = r30
        L_0x030e:
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
        L_0x0312:
            r13 = r31
            goto L_0x04c7
        L_0x0316:
            r7 = r32
            r2 = r3
            r22 = r6
            r26 = r10
            r17 = r11
            r6 = r30
            r30 = r9
            goto L_0x0428
        L_0x0325:
            r4 = r2
            r1 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r9
            r9 = r0
            r0 = 27
            if (r11 != r0) goto L_0x038c
            r0 = 2
            if (r7 != r0) goto L_0x037d
            java.lang.Object r0 = r10.getObject(r14, r1)
            com.google.android.gms.internal.measurement.zzig r0 = (com.google.android.gms.internal.measurement.zzig) r0
            boolean r7 = r0.zza()
            if (r7 != 0) goto L_0x0357
            int r7 = r0.size()
            if (r7 != 0) goto L_0x034e
            r7 = 10
            goto L_0x0350
        L_0x034e:
            int r7 = r7 << 1
        L_0x0350:
            com.google.android.gms.internal.measurement.zzig r0 = r0.zza(r7)
            r10.putObject(r14, r1, r0)
        L_0x0357:
            r7 = r0
            com.google.android.gms.internal.measurement.zzkb r0 = r15.zza((int) r4)
            r1 = r8
            r2 = r29
            r17 = r4
            r4 = r31
            r22 = r5
            r5 = r7
            r23 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r32
            r3 = r8
            r1 = r9
            r9 = r13
            r2 = r17
            r5 = r22
            r6 = r23
            r13 = r31
            goto L_0x0019
        L_0x037d:
            r17 = r4
            r22 = r5
            r23 = r6
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            goto L_0x0401
        L_0x038c:
            r17 = r4
            r22 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x03d9
            r6 = r20
            long r5 = (long) r6
            r0 = r27
            r24 = r1
            r1 = r28
            r2 = r29
            r4 = r3
            r15 = r4
            r4 = r31
            r20 = r5
            r5 = r8
            r6 = r9
            r19 = r8
            r8 = r17
            r30 = r9
            r26 = r10
            r9 = r20
            r12 = r24
            r14 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzgo) r14)
            if (r0 != r15) goto L_0x03bf
            goto L_0x0424
        L_0x03bf:
            r15 = r27
            r14 = r28
            r12 = r29
            r1 = r30
            r13 = r31
            r11 = r32
            r9 = r33
            r2 = r17
            r3 = r19
            r5 = r22
            r6 = r23
            r10 = r26
            goto L_0x0019
        L_0x03d9:
            r24 = r1
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            r6 = r20
            r0 = 50
            if (r11 != r0) goto L_0x0409
            r0 = 2
            if (r7 != r0) goto L_0x0401
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r17
            r6 = r24
            r8 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzgo) r8)
            if (r0 != r15) goto L_0x03bf
            goto L_0x0424
        L_0x0401:
            r7 = r32
            r2 = r15
        L_0x0404:
            r8 = r19
            r6 = r23
            goto L_0x0428
        L_0x0409:
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r8 = r6
            r6 = r30
            r9 = r11
            r10 = r24
            r12 = r17
            r13 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzgo) r13)
            if (r0 != r15) goto L_0x04af
        L_0x0424:
            r7 = r32
            r2 = r0
            goto L_0x0404
        L_0x0428:
            if (r8 != r7) goto L_0x0437
            if (r7 != 0) goto L_0x042d
            goto L_0x0437
        L_0x042d:
            r9 = r27
            r12 = r28
            r0 = r2
            r3 = r8
            r5 = r22
            goto L_0x04d4
        L_0x0437:
            r9 = r27
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x0488
            r10 = r33
            com.google.android.gms.internal.measurement.zzhl r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzhl r1 = com.google.android.gms.internal.measurement.zzhl.zza()
            if (r0 == r1) goto L_0x0483
            com.google.android.gms.internal.measurement.zzjj r0 = r9.zzg
            com.google.android.gms.internal.measurement.zzhl r1 = r10.zzd
            r11 = r30
            com.google.android.gms.internal.measurement.zzhy$zzf r0 = r1.zza(r0, r11)
            if (r0 != 0) goto L_0x0473
            com.google.android.gms.internal.measurement.zzks r4 = zze((java.lang.Object) r28)
            r0 = r8
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzks) r4, (com.google.android.gms.internal.measurement.zzgo) r5)
            r14 = r28
            r12 = r29
            r13 = r31
            r3 = r8
            r15 = r9
            r9 = r10
            r1 = r11
            r2 = r17
            r5 = r22
            r10 = r26
            goto L_0x04ac
        L_0x0473:
            r12 = r28
            r0 = r12
            com.google.android.gms.internal.measurement.zzhy$zzd r0 = (com.google.android.gms.internal.measurement.zzhy.zzd) r0
            r0.zza()
            com.google.android.gms.internal.measurement.zzhr<com.google.android.gms.internal.measurement.zzhy$zzc> r0 = r0.zzc
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0483:
            r12 = r28
            r11 = r30
            goto L_0x048e
        L_0x0488:
            r12 = r28
            r11 = r30
            r10 = r33
        L_0x048e:
            com.google.android.gms.internal.measurement.zzks r4 = zze((java.lang.Object) r28)
            r0 = r8
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzks) r4, (com.google.android.gms.internal.measurement.zzgo) r5)
            r13 = r31
            r3 = r8
            r15 = r9
            r9 = r10
            r1 = r11
            r14 = r12
            r2 = r17
            r5 = r22
            r10 = r26
            r12 = r29
        L_0x04ac:
            r11 = r7
            goto L_0x0019
        L_0x04af:
            r11 = r30
            r8 = r19
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r9 = r33
            r3 = r8
            r1 = r11
            r2 = r17
            r5 = r22
            r6 = r23
            r10 = r26
        L_0x04c7:
            r11 = r32
            goto L_0x0019
        L_0x04cb:
            r22 = r5
            r23 = r6
            r26 = r10
            r7 = r11
            r12 = r14
            r9 = r15
        L_0x04d4:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r1) goto L_0x04df
            long r1 = (long) r6
            r4 = r26
            r4.putInt(r12, r1, r5)
        L_0x04df:
            r1 = 0
            int r2 = r9.zzm
        L_0x04e2:
            int r4 = r9.zzn
            if (r2 >= r4) goto L_0x04f5
            int[] r4 = r9.zzl
            r4 = r4[r2]
            com.google.android.gms.internal.measurement.zzkt<?, ?> r5 = r9.zzq
            java.lang.Object r1 = r9.zza((java.lang.Object) r12, (int) r4, r1, r5)
            com.google.android.gms.internal.measurement.zzks r1 = (com.google.android.gms.internal.measurement.zzks) r1
            int r2 = r2 + 1
            goto L_0x04e2
        L_0x04f5:
            if (r1 == 0) goto L_0x04fc
            com.google.android.gms.internal.measurement.zzkt<?, ?> r2 = r9.zzq
            r2.zzb((java.lang.Object) r12, r1)
        L_0x04fc:
            if (r7 != 0) goto L_0x0508
            r1 = r31
            if (r0 != r1) goto L_0x0503
            goto L_0x050e
        L_0x0503:
            com.google.android.gms.internal.measurement.zzij r0 = com.google.android.gms.internal.measurement.zzij.zzg()
            throw r0
        L_0x0508:
            r1 = r31
            if (r0 > r1) goto L_0x050f
            if (r3 != r7) goto L_0x050f
        L_0x050e:
            return r0
        L_0x050f:
            com.google.android.gms.internal.measurement.zzij r0 = com.google.android.gms.internal.measurement.zzij.zzg()
            goto L_0x0515
        L_0x0514:
            throw r0
        L_0x0515:
            goto L_0x0514
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02dc, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0323, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0346, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0348, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ca, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0234, code lost:
        r6 = r6 | r23;
        r9 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0239, code lost:
        r2 = r5;
        r29 = r7;
        r18 = r10;
        r7 = r20;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzgo r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            boolean r0 = r15.zzj
            if (r0 == 0) goto L_0x038d
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r13) goto L_0x0370
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzgo) r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0033
        L_0x0030:
            r17 = r0
            r4 = r3
        L_0x0033:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x0040
            int r2 = r2 / 3
            int r0 = r15.zza((int) r5, (int) r2)
            goto L_0x0044
        L_0x0040:
            int r0 = r15.zzg(r5)
        L_0x0044:
            r2 = r0
            if (r2 != r10) goto L_0x0052
            r2 = r4
            r25 = r5
            r29 = r9
            r18 = 0
        L_0x004e:
            r20 = -1
            goto L_0x034a
        L_0x0052:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r1 & r18
            int r10 = r18 >>> 20
            r33 = r5
            r5 = r1 & r8
            r18 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x0242
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            r20 = r2
            if (r0 == r7) goto L_0x0092
            if (r7 == r5) goto L_0x0085
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x0087
        L_0x0085:
            r7 = r18
        L_0x0087:
            if (r0 == r5) goto L_0x008f
            long r1 = (long) r0
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x008f:
            r2 = r7
            r7 = r0
            goto L_0x0094
        L_0x0092:
            r2 = r18
        L_0x0094:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x021d;
                case 1: goto L_0x0206;
                case 2: goto L_0x01e4;
                case 3: goto L_0x01e4;
                case 4: goto L_0x01cd;
                case 5: goto L_0x01ab;
                case 6: goto L_0x0194;
                case 7: goto L_0x0174;
                case 8: goto L_0x0151;
                case 9: goto L_0x0124;
                case 10: goto L_0x010c;
                case 11: goto L_0x01cd;
                case 12: goto L_0x00f5;
                case 13: goto L_0x0194;
                case 14: goto L_0x01ab;
                case 15: goto L_0x00da;
                case 16: goto L_0x00a5;
                default: goto L_0x0098;
            }
        L_0x0098:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            goto L_0x0239
        L_0x00a5:
            if (r3 != 0) goto L_0x00cc
            int r10 = com.google.android.gms.internal.measurement.zzgl.zzb(r12, r4, r11)
            long r0 = r11.zzb
            long r17 = com.google.android.gms.internal.measurement.zzhb.zza((long) r0)
            r0 = r2
            r1 = r31
            r4 = r20
            r20 = r7
            r7 = r2
            r2 = r8
            r25 = r33
            r8 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r8
            r0 = r10
            goto L_0x028c
        L_0x00cc:
            r25 = r33
            r8 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            r5 = r4
            r10 = r8
            goto L_0x0239
        L_0x00da:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzhb.zze(r1)
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x00f5:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r12, r4, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x010c:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.measurement.zzgl.zze(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0124:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            com.google.android.gms.internal.measurement.zzkb r0 = r15.zza((int) r10)
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza((com.google.android.gms.internal.measurement.zzkb) r0, (byte[]) r12, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgo) r11)
            java.lang.Object r1 = r7.getObject(r14, r8)
            if (r1 != 0) goto L_0x0146
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0146:
            java.lang.Object r2 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r1, (java.lang.Object) r2)
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0151:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x0169
            int r0 = com.google.android.gms.internal.measurement.zzgl.zzc(r12, r4, r11)
            goto L_0x016d
        L_0x0169:
            int r0 = com.google.android.gms.internal.measurement.zzgl.zzd(r12, r4, r11)
        L_0x016d:
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0174:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.measurement.zzgl.zzb(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018e
            r1 = 1
            goto L_0x018f
        L_0x018e:
            r1 = 0
        L_0x018f:
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r8, (boolean) r1)
            goto L_0x0234
        L_0x0194:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r12, r4)
            r7.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0234
        L_0x01ab:
            r25 = r33
            r10 = r20
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            long r17 = com.google.android.gms.internal.measurement.zzgl.zzb(r12, r4)
            r0 = r7
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0234
        L_0x01ca:
            r5 = r4
            goto L_0x0239
        L_0x01cd:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0239
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r12, r5, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x01e4:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0239
            int r17 = com.google.android.gms.internal.measurement.zzgl.zzb(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r7
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            r0 = r17
            goto L_0x028c
        L_0x0206:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0239
            float r0 = com.google.android.gms.internal.measurement.zzgl.zzd(r12, r5)
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r8, (float) r0)
            int r0 = r5 + 4
            goto L_0x0234
        L_0x021d:
            r25 = r33
            r5 = r4
            r10 = r20
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0239
            double r0 = com.google.android.gms.internal.measurement.zzgl.zzc(r12, r5)
            com.google.android.gms.internal.measurement.zzkz.zza((java.lang.Object) r14, (long) r8, (double) r0)
            int r0 = r5 + 8
        L_0x0234:
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            goto L_0x028c
        L_0x0239:
            r2 = r5
            r29 = r7
            r18 = r10
            r7 = r20
            goto L_0x004e
        L_0x0242:
            r25 = r33
            r5 = r4
            r20 = r7
            r7 = r18
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r2
            r0 = 27
            if (r10 != r0) goto L_0x029f
            r0 = 2
            if (r3 != r0) goto L_0x0292
            java.lang.Object r0 = r7.getObject(r14, r8)
            com.google.android.gms.internal.measurement.zzig r0 = (com.google.android.gms.internal.measurement.zzig) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x0272
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0269
            r1 = 10
            goto L_0x026b
        L_0x0269:
            int r1 = r1 << 1
        L_0x026b:
            com.google.android.gms.internal.measurement.zzig r0 = r0.zza(r1)
            r7.putObject(r14, r8, r0)
        L_0x0272:
            r8 = r0
            com.google.android.gms.internal.measurement.zzkb r0 = r15.zza((int) r4)
            r1 = r17
            r2 = r32
            r3 = r5
            r18 = r4
            r4 = r34
            r5 = r8
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza(r0, r1, r2, r3, r4, r5, r6)
            r9 = r7
            r6 = r8
            r2 = r18
        L_0x028c:
            r7 = r20
            r1 = r25
            goto L_0x036a
        L_0x0292:
            r18 = r4
            r15 = r5
            r27 = r6
            r29 = r7
            r28 = r20
            r20 = -1
            goto L_0x0326
        L_0x029f:
            r18 = r4
            r0 = 49
            if (r10 > r0) goto L_0x02f4
            r1 = r21
            long r1 = (long) r1
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r4 = r3
            r3 = r5
            r33 = r4
            r4 = r34
            r15 = r5
            r5 = r17
            r27 = r6
            r6 = r25
            r28 = r20
            r20 = r7
            r7 = r33
            r23 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r18
            r19 = r10
            r29 = r20
            r20 = -1
            r9 = r21
            r11 = r19
            r12 = r23
            r14 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzgo) r14)
            if (r0 != r15) goto L_0x02e0
            goto L_0x0348
        L_0x02e0:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r18
            r1 = r25
            r6 = r27
            r7 = r28
            goto L_0x0368
        L_0x02f4:
            r33 = r3
            r15 = r5
            r27 = r6
            r29 = r7
            r23 = r8
            r19 = r10
            r28 = r20
            r1 = r21
            r20 = -1
            r0 = 50
            r9 = r19
            if (r9 != r0) goto L_0x032c
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x0326
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r18
            r6 = r23
            r8 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzgo) r8)
            if (r0 != r15) goto L_0x02e0
            goto L_0x0348
        L_0x0326:
            r2 = r15
        L_0x0327:
            r6 = r27
            r7 = r28
            goto L_0x034a
        L_0x032c:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r25
            r10 = r23
            r12 = r18
            r13 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzgo) r13)
            if (r0 != r15) goto L_0x02e0
        L_0x0348:
            r2 = r0
            goto L_0x0327
        L_0x034a:
            com.google.android.gms.internal.measurement.zzks r4 = zze((java.lang.Object) r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzgl.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzks) r4, (com.google.android.gms.internal.measurement.zzgo) r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r18
            r1 = r25
        L_0x0368:
            r9 = r29
        L_0x036a:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001e
        L_0x0370:
            r27 = r6
            r29 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0383
            long r1 = (long) r7
            r3 = r31
            r6 = r27
            r4 = r29
            r4.putInt(r3, r1, r6)
        L_0x0383:
            r4 = r34
            if (r0 != r4) goto L_0x0388
            return
        L_0x0388:
            com.google.android.gms.internal.measurement.zzij r0 = com.google.android.gms.internal.measurement.zzij.zzg()
            throw r0
        L_0x038d:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r6 = r35
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzgo) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgo):void");
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkt<UT, UB> zzkt) {
        zzif zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzkz.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzkt);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzif zzif, UB ub, zzkt<UT, UB> zzkt) {
        zzja<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzif.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzkt.zza();
                }
                zzgx zzc2 = zzgp.zzc(zzjb.zza(zzf2, next.getKey(), next.getValue()));
                try {
                    zzjb.zza(zzc2.zzb(), zzf2, next.getKey(), next.getValue());
                    zzkt.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public static boolean zza(Object obj, int i, zzkb zzkb) {
        return zzkb.zzd(zzkz.zzf(obj, (long) (i & 1048575)));
    }

    public static void zza(int i, Object obj, zzlm zzlm) throws IOException {
        if (obj instanceof String) {
            zzlm.zza(i, (String) obj);
        } else {
            zzlm.zza(i, (zzgp) obj);
        }
    }

    private final void zza(Object obj, int i, zzjy zzjy) throws IOException {
        if (zzf(i)) {
            zzkz.zza(obj, (long) (i & 1048575), (Object) zzjy.zzm());
        } else if (this.zzi) {
            zzkz.zza(obj, (long) (i & 1048575), (Object) zzjy.zzl());
        } else {
            zzkz.zza(obj, (long) (i & 1048575), (Object) zzjy.zzn());
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (zze2 & 1048575);
        if (j == 1048575) {
            int zzd2 = zzd(i);
            long j2 = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzkz.zze(t, j2) != RoundRectDrawableWithShadow.COS_45;
                case 1:
                    return zzkz.zzd(t, j2) != 0.0f;
                case 2:
                    return zzkz.zzb(t, j2) != 0;
                case 3:
                    return zzkz.zzb(t, j2) != 0;
                case 4:
                    return zzkz.zza((Object) t, j2) != 0;
                case 5:
                    return zzkz.zzb(t, j2) != 0;
                case 6:
                    return zzkz.zza((Object) t, j2) != 0;
                case 7:
                    return zzkz.zzc(t, j2);
                case 8:
                    Object zzf2 = zzkz.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgp) {
                        return !zzgp.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzkz.zzf(t, j2) != null;
                case 10:
                    return !zzgp.zza.equals(zzkz.zzf(t, j2));
                case 11:
                    return zzkz.zza((Object) t, j2) != 0;
                case 12:
                    return zzkz.zza((Object) t, j2) != 0;
                case 13:
                    return zzkz.zza((Object) t, j2) != 0;
                case 14:
                    return zzkz.zzb(t, j2) != 0;
                case 15:
                    return zzkz.zza((Object) t, j2) != 0;
                case 16:
                    return zzkz.zzb(t, j2) != 0;
                case 17:
                    return zzkz.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzkz.zza((Object) t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzkz.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }
}
