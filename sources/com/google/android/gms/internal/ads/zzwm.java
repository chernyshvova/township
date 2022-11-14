package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwm implements zzta {
    public static final zztg zza = zzwj.zza;
    public static final byte[] zzb = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final zzkc zzc;
    public int zzA;
    public int zzB;
    public boolean zzC;
    public zztd zzD;
    public zztz[] zzE;
    public zztz[] zzF;
    public boolean zzG;
    public final List<zzkc> zzd;
    public final SparseArray<zzwl> zze;
    public final zzakr zzf;
    public final zzakr zzg;
    public final zzakr zzh;
    public final byte[] zzi;
    public final zzakr zzj;
    public final zzabj zzk;
    public final zzakr zzl;
    public final ArrayDeque<zzvx> zzm;
    public final ArrayDeque<zzwk> zzn;
    public int zzo;
    public int zzp;
    public long zzq;
    public int zzr;
    @Nullable
    public zzakr zzs;
    public long zzt;
    public int zzu;
    public long zzv;
    public long zzw;
    public long zzx;
    @Nullable
    public zzwl zzy;
    public int zzz;

    static {
        zzkb zzkb = new zzkb();
        zzkb.zzj("application/x-emsg");
        zzc = zzkb.zzD();
    }

    public zzwm() {
        this(0, (zzale) null);
    }

    private final void zza() {
        this.zzo = 0;
        this.zzr = 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: com.google.android.gms.internal.ads.zzwl} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r7v34 */
    /* JADX WARNING: type inference failed for: r7v47 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0348  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(long r45) throws com.google.android.gms.internal.ads.zzlg {
        /*
            r44 = this;
            r0 = r44
            r1 = r0
        L_0x0003:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvx> r2 = r1.zzm
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x070a
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvx> r2 = r1.zzm
            java.lang.Object r2 = r2.peek()
            com.google.android.gms.internal.ads.zzvx r2 = (com.google.android.gms.internal.ads.zzvx) r2
            long r2 = r2.zza
            int r4 = (r2 > r45 ? 1 : (r2 == r45 ? 0 : -1))
            if (r4 != 0) goto L_0x070a
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvx> r2 = r1.zzm
            java.lang.Object r2 = r2.pop()
            r3 = r2
            com.google.android.gms.internal.ads.zzvx r3 = (com.google.android.gms.internal.ads.zzvx) r3
            int r2 = r3.zzd
            r4 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r5 = 12
            r7 = 0
            if (r2 != r4) goto L_0x0145
            java.util.List<com.google.android.gms.internal.ads.zzvy> r2 = r3.zzb
            com.google.android.gms.internal.ads.zzsa r2 = zzi(r2)
            r4 = 1836475768(0x6d766578, float:4.7659988E27)
            com.google.android.gms.internal.ads.zzvx r4 = r3.zzd(r4)
            if (r4 == 0) goto L_0x0144
            android.util.SparseArray r11 = new android.util.SparseArray
            r11.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzvy> r7 = r4.zzb
            int r7 = r7.size()
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10 = 0
        L_0x004c:
            if (r10 >= r7) goto L_0x00bc
            java.util.List<com.google.android.gms.internal.ads.zzvy> r12 = r4.zzb
            java.lang.Object r12 = r12.get(r10)
            com.google.android.gms.internal.ads.zzvy r12 = (com.google.android.gms.internal.ads.zzvy) r12
            int r13 = r12.zzd
            r14 = 1953654136(0x74726578, float:7.6818474E31)
            if (r13 != r14) goto L_0x0095
            com.google.android.gms.internal.ads.zzakr r12 = r12.zza
            r12.zzh(r5)
            int r5 = r12.zzv()
            int r13 = r12.zzv()
            int r14 = r12.zzv()
            int r15 = r12.zzv()
            int r12 = r12.zzv()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.ads.zzwh r6 = new com.google.android.gms.internal.ads.zzwh
            int r13 = r13 + -1
            r6.<init>(r13, r14, r15, r12)
            android.util.Pair r5 = android.util.Pair.create(r5, r6)
            java.lang.Object r6 = r5.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r5 = r5.second
            com.google.android.gms.internal.ads.zzwh r5 = (com.google.android.gms.internal.ads.zzwh) r5
            r11.put(r6, r5)
            goto L_0x00b5
        L_0x0095:
            r5 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r13 != r5) goto L_0x00b5
            com.google.android.gms.internal.ads.zzakr r5 = r12.zza
            r6 = 8
            r5.zzh(r6)
            int r8 = r5.zzv()
            int r8 = com.google.android.gms.internal.ads.zzvz.zze(r8)
            if (r8 != 0) goto L_0x00b0
            long r8 = r5.zzt()
            goto L_0x00b7
        L_0x00b0:
            long r8 = r5.zzD()
            goto L_0x00b7
        L_0x00b5:
            r6 = 8
        L_0x00b7:
            int r10 = r10 + 1
            r5 = 12
            goto L_0x004c
        L_0x00bc:
            com.google.android.gms.internal.ads.zztp r4 = new com.google.android.gms.internal.ads.zztp
            r4.<init>()
            com.google.android.gms.internal.ads.zzwi r10 = new com.google.android.gms.internal.ads.zzwi
            r10.<init>(r1)
            r12 = 0
            r13 = 0
            r5 = r8
            r7 = r2
            r8 = r12
            r9 = r13
            java.util.List r2 = com.google.android.gms.internal.ads.zzwg.zza(r3, r4, r5, r7, r8, r9, r10)
            int r3 = r2.size()
            android.util.SparseArray<com.google.android.gms.internal.ads.zzwl> r4 = r1.zze
            int r4 = r4.size()
            if (r4 != 0) goto L_0x0115
            r4 = 0
        L_0x00dd:
            if (r4 >= r3) goto L_0x010e
            java.lang.Object r5 = r2.get(r4)
            com.google.android.gms.internal.ads.zzwy r5 = (com.google.android.gms.internal.ads.zzwy) r5
            com.google.android.gms.internal.ads.zzwv r6 = r5.zza
            com.google.android.gms.internal.ads.zzwl r7 = new com.google.android.gms.internal.ads.zzwl
            com.google.android.gms.internal.ads.zztd r8 = r1.zzD
            int r9 = r6.zzb
            com.google.android.gms.internal.ads.zztz r8 = r8.zza(r4, r9)
            int r9 = r6.zza
            com.google.android.gms.internal.ads.zzwh r9 = zzj(r11, r9)
            r7.<init>(r8, r5, r9)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzwl> r5 = r1.zze
            int r8 = r6.zza
            r5.put(r8, r7)
            long r7 = r1.zzw
            long r5 = r6.zze
            long r5 = java.lang.Math.max(r7, r5)
            r1.zzw = r5
            int r4 = r4 + 1
            goto L_0x00dd
        L_0x010e:
            com.google.android.gms.internal.ads.zztd r2 = r1.zzD
            r2.zzbl()
            goto L_0x0003
        L_0x0115:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzwl> r4 = r1.zze
            int r4 = r4.size()
            if (r4 != r3) goto L_0x011f
            r4 = 1
            goto L_0x0120
        L_0x011f:
            r4 = 0
        L_0x0120:
            com.google.android.gms.internal.ads.zzajg.zzd(r4)
            r4 = 0
        L_0x0124:
            if (r4 >= r3) goto L_0x0003
            java.lang.Object r5 = r2.get(r4)
            com.google.android.gms.internal.ads.zzwy r5 = (com.google.android.gms.internal.ads.zzwy) r5
            com.google.android.gms.internal.ads.zzwv r6 = r5.zza
            android.util.SparseArray<com.google.android.gms.internal.ads.zzwl> r7 = r1.zze
            int r8 = r6.zza
            java.lang.Object r7 = r7.get(r8)
            com.google.android.gms.internal.ads.zzwl r7 = (com.google.android.gms.internal.ads.zzwl) r7
            int r6 = r6.zza
            com.google.android.gms.internal.ads.zzwh r6 = zzj(r11, r6)
            r7.zza(r5, r6)
            int r4 = r4 + 1
            goto L_0x0124
        L_0x0144:
            throw r7
        L_0x0145:
            r6 = 8
            r4 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r2 != r4) goto L_0x06f2
            android.util.SparseArray<com.google.android.gms.internal.ads.zzwl> r2 = r1.zze
            byte[] r1 = r1.zzi
            java.util.List<com.google.android.gms.internal.ads.zzvx> r4 = r3.zzc
            int r4 = r4.size()
            r5 = 0
        L_0x0157:
            if (r5 >= r4) goto L_0x065c
            java.util.List<com.google.android.gms.internal.ads.zzvx> r8 = r3.zzc
            java.lang.Object r8 = r8.get(r5)
            com.google.android.gms.internal.ads.zzvx r8 = (com.google.android.gms.internal.ads.zzvx) r8
            int r9 = r8.zzd
            r10 = 1953653094(0x74726166, float:7.6813435E31)
            if (r9 != r10) goto L_0x0642
            r9 = 1952868452(0x74666864, float:7.301914E31)
            com.google.android.gms.internal.ads.zzvy r9 = r8.zzc(r9)
            if (r9 == 0) goto L_0x0641
            com.google.android.gms.internal.ads.zzakr r9 = r9.zza
            r9.zzh(r6)
            int r10 = r9.zzv()
            r11 = 16777215(0xffffff, float:2.3509886E-38)
            r10 = r10 & r11
            int r11 = r9.zzv()
            int r12 = r2.size()
            r13 = 1
            if (r12 != r13) goto L_0x0191
            r11 = 0
            java.lang.Object r11 = r2.valueAt(r11)
            com.google.android.gms.internal.ads.zzwl r11 = (com.google.android.gms.internal.ads.zzwl) r11
            goto L_0x0197
        L_0x0191:
            java.lang.Object r11 = r2.get(r11)
            com.google.android.gms.internal.ads.zzwl r11 = (com.google.android.gms.internal.ads.zzwl) r11
        L_0x0197:
            if (r11 != 0) goto L_0x019a
            goto L_0x01e2
        L_0x019a:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x01a8
            long r12 = r9.zzD()
            com.google.android.gms.internal.ads.zzwx r7 = r11.zzb
            r7.zzb = r12
            r7.zzc = r12
        L_0x01a8:
            com.google.android.gms.internal.ads.zzwh r7 = r11.zze
            r12 = r10 & 2
            if (r12 == 0) goto L_0x01b5
            int r12 = r9.zzv()
            int r12 = r12 + -1
            goto L_0x01b7
        L_0x01b5:
            int r12 = r7.zza
        L_0x01b7:
            r13 = r10 & 8
            if (r13 == 0) goto L_0x01c0
            int r13 = r9.zzv()
            goto L_0x01c2
        L_0x01c0:
            int r13 = r7.zzb
        L_0x01c2:
            r14 = r10 & 16
            if (r14 == 0) goto L_0x01cb
            int r14 = r9.zzv()
            goto L_0x01cd
        L_0x01cb:
            int r14 = r7.zzc
        L_0x01cd:
            r10 = r10 & 32
            if (r10 == 0) goto L_0x01d6
            int r7 = r9.zzv()
            goto L_0x01d8
        L_0x01d6:
            int r7 = r7.zzd
        L_0x01d8:
            com.google.android.gms.internal.ads.zzwx r9 = r11.zzb
            com.google.android.gms.internal.ads.zzwh r10 = new com.google.android.gms.internal.ads.zzwh
            r10.<init>(r12, r13, r14, r7)
            r9.zza = r10
            r7 = r11
        L_0x01e2:
            if (r7 != 0) goto L_0x01e7
            r7 = 0
            goto L_0x0642
        L_0x01e7:
            com.google.android.gms.internal.ads.zzwx r9 = r7.zzb
            long r10 = r9.zzq
            boolean r12 = r9.zzr
            r7.zzb()
            r13 = 1
            boolean unused = r7.zzl = true
            r14 = 1952867444(0x74666474, float:7.3014264E31)
            com.google.android.gms.internal.ads.zzvy r14 = r8.zzc(r14)
            if (r14 == 0) goto L_0x021a
            com.google.android.gms.internal.ads.zzakr r10 = r14.zza
            r10.zzh(r6)
            int r6 = r10.zzv()
            int r6 = com.google.android.gms.internal.ads.zzvz.zze(r6)
            if (r6 != r13) goto L_0x0211
            long r10 = r10.zzD()
            goto L_0x0215
        L_0x0211:
            long r10 = r10.zzt()
        L_0x0215:
            r9.zzq = r10
            r9.zzr = r13
            goto L_0x021e
        L_0x021a:
            r9.zzq = r10
            r9.zzr = r12
        L_0x021e:
            java.util.List<com.google.android.gms.internal.ads.zzvy> r6 = r8.zzb
            int r10 = r6.size()
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0227:
            r14 = 1953658222(0x7472756e, float:7.683823E31)
            if (r11 >= r10) goto L_0x024d
            java.lang.Object r15 = r6.get(r11)
            com.google.android.gms.internal.ads.zzvy r15 = (com.google.android.gms.internal.ads.zzvy) r15
            r16 = r2
            int r2 = r15.zzd
            if (r2 != r14) goto L_0x0248
            com.google.android.gms.internal.ads.zzakr r2 = r15.zza
            r14 = 12
            r2.zzh(r14)
            int r2 = r2.zzB()
            if (r2 <= 0) goto L_0x0248
            int r13 = r13 + r2
            int r12 = r12 + 1
        L_0x0248:
            int r11 = r11 + 1
            r2 = r16
            goto L_0x0227
        L_0x024d:
            r16 = r2
            r2 = 0
            r7.zzh = r2
            r7.zzg = r2
            r7.zzf = r2
            com.google.android.gms.internal.ads.zzwx r2 = r7.zzb
            r2.zzd = r12
            r2.zze = r13
            int[] r11 = r2.zzg
            int r11 = r11.length
            if (r11 >= r12) goto L_0x0269
            long[] r11 = new long[r12]
            r2.zzf = r11
            int[] r11 = new int[r12]
            r2.zzg = r11
        L_0x0269:
            int[] r11 = r2.zzh
            int r11 = r11.length
            if (r11 >= r13) goto L_0x0286
            int r13 = r13 * 125
            int r13 = r13 / 100
            int[] r11 = new int[r13]
            r2.zzh = r11
            int[] r11 = new int[r13]
            r2.zzi = r11
            long[] r11 = new long[r13]
            r2.zzj = r11
            boolean[] r11 = new boolean[r13]
            r2.zzk = r11
            boolean[] r11 = new boolean[r13]
            r2.zzm = r11
        L_0x0286:
            r2 = 0
            r11 = 0
            r12 = 0
        L_0x0289:
            if (r2 >= r10) goto L_0x042a
            java.lang.Object r13 = r6.get(r2)
            com.google.android.gms.internal.ads.zzvy r13 = (com.google.android.gms.internal.ads.zzvy) r13
            int r15 = r13.zzd
            if (r15 != r14) goto L_0x03fb
            int r14 = r12 + 1
            com.google.android.gms.internal.ads.zzakr r13 = r13.zza
            r15 = 8
            r13.zzh(r15)
            int r15 = r13.zzv()
            r17 = 16777215(0xffffff, float:2.3509886E-38)
            r15 = r15 & r17
            r17 = r4
            com.google.android.gms.internal.ads.zzwy r4 = r7.zzd
            com.google.android.gms.internal.ads.zzwv r4 = r4.zza
            r18 = r6
            com.google.android.gms.internal.ads.zzwx r6 = r7.zzb
            r19 = r10
            com.google.android.gms.internal.ads.zzwh r10 = r6.zza
            int r20 = com.google.android.gms.internal.ads.zzalh.zza
            r21 = r14
            int[] r14 = r6.zzg
            int r20 = r13.zzB()
            r14[r12] = r20
            long[] r14 = r6.zzf
            r20 = r1
            long r0 = r6.zzb
            r14[r12] = r0
            r22 = r15 & 1
            if (r22 == 0) goto L_0x02dc
            r22 = r3
            int r3 = r13.zzv()
            r23 = r8
            r24 = r9
            long r8 = (long) r3
            long r0 = r0 + r8
            r14[r12] = r0
            goto L_0x02e2
        L_0x02dc:
            r22 = r3
            r23 = r8
            r24 = r9
        L_0x02e2:
            r0 = r15 & 4
            int r1 = r10.zzd
            if (r0 == 0) goto L_0x02ec
            int r1 = r13.zzv()
        L_0x02ec:
            r3 = r15 & 256(0x100, float:3.59E-43)
            r8 = r15 & 512(0x200, float:7.175E-43)
            r9 = r15 & 1024(0x400, float:1.435E-42)
            r14 = r15 & 2048(0x800, float:2.87E-42)
            long[] r15 = r4.zzh
            if (r15 == 0) goto L_0x0320
            r25 = r1
            int r1 = r15.length
            r26 = r5
            r5 = 1
            if (r1 != r5) goto L_0x0324
            r1 = 0
            r27 = r15[r1]
            r29 = 0
            int r5 = (r27 > r29 ? 1 : (r27 == r29 ? 0 : -1))
            if (r5 != 0) goto L_0x0324
            long[] r5 = r4.zzi
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzalh.zzd(r5)
            long[] r5 = (long[]) r5
            r27 = r5[r1]
            r29 = 1000000(0xf4240, double:4.940656E-318)
            r5 = r2
            long r1 = r4.zzc
            r31 = r1
            long r1 = com.google.android.gms.internal.ads.zzalh.zzF(r27, r29, r31)
            goto L_0x0327
        L_0x0320:
            r25 = r1
            r26 = r5
        L_0x0324:
            r5 = r2
            r1 = 0
        L_0x0327:
            int[] r15 = r6.zzh
            r27 = r5
            int[] r5 = r6.zzi
            r28 = r15
            long[] r15 = r6.zzj
            r29 = r7
            boolean[] r7 = r6.zzk
            r30 = r7
            int[] r7 = r6.zzg
            r7 = r7[r12]
            int r7 = r7 + r11
            r31 = r11
            long r11 = r4.zzc
            r37 = r1
            long r1 = r6.zzq
            r4 = r31
        L_0x0346:
            if (r4 >= r7) goto L_0x03f0
            if (r3 == 0) goto L_0x0353
            int r31 = r13.zzv()
            r39 = r3
            r3 = r31
            goto L_0x0357
        L_0x0353:
            r39 = r3
            int r3 = r10.zzb
        L_0x0357:
            zzc(r3)
            if (r8 == 0) goto L_0x0365
            int r31 = r13.zzv()
            r40 = r7
            r7 = r31
            goto L_0x0369
        L_0x0365:
            r40 = r7
            int r7 = r10.zzc
        L_0x0369:
            zzc(r7)
            if (r9 == 0) goto L_0x0377
            int r31 = r13.zzv()
            r41 = r0
            r0 = r31
            goto L_0x0385
        L_0x0377:
            if (r4 != 0) goto L_0x0381
            r4 = 0
            r41 = r0
            if (r0 == 0) goto L_0x0383
            r0 = r25
            goto L_0x0385
        L_0x0381:
            r41 = r0
        L_0x0383:
            int r0 = r10.zzd
        L_0x0385:
            if (r14 == 0) goto L_0x039a
            r42 = r8
            int r8 = r13.zzv()
            r43 = r9
            long r8 = (long) r8
            r31 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r8 * r31
            long r8 = r8 / r11
            int r9 = (int) r8
            r5[r4] = r9
            goto L_0x03a1
        L_0x039a:
            r42 = r8
            r43 = r9
            r8 = 0
            r5[r4] = r8
        L_0x03a1:
            r33 = 1000000(0xf4240, double:4.940656E-318)
            r31 = r1
            r35 = r11
            long r8 = com.google.android.gms.internal.ads.zzalh.zzF(r31, r33, r35)
            long r8 = r8 - r37
            r15[r4] = r8
            r32 = r5
            boolean r5 = r6.zzr
            if (r5 != 0) goto L_0x03c4
            r5 = r29
            r29 = r10
            com.google.android.gms.internal.ads.zzwy r10 = r5.zzd
            r33 = r11
            long r10 = r10.zzh
            long r8 = r8 + r10
            r15[r4] = r8
            goto L_0x03ca
        L_0x03c4:
            r33 = r11
            r5 = r29
            r29 = r10
        L_0x03ca:
            r28[r4] = r7
            int r0 = r0 >> 16
            r7 = 1
            r0 = r0 & r7
            r0 = r0 ^ r7
            if (r7 == r0) goto L_0x03d5
            r0 = 0
            goto L_0x03d6
        L_0x03d5:
            r0 = 1
        L_0x03d6:
            r30[r4] = r0
            long r7 = (long) r3
            long r1 = r1 + r7
            int r4 = r4 + 1
            r10 = r29
            r11 = r33
            r3 = r39
            r7 = r40
            r0 = r41
            r8 = r42
            r9 = r43
            r29 = r5
            r5 = r32
            goto L_0x0346
        L_0x03f0:
            r40 = r7
            r5 = r29
            r6.zzq = r1
            r12 = r21
            r11 = r40
            goto L_0x0410
        L_0x03fb:
            r20 = r1
            r27 = r2
            r22 = r3
            r17 = r4
            r26 = r5
            r18 = r6
            r5 = r7
            r23 = r8
            r24 = r9
            r19 = r10
            r31 = r11
        L_0x0410:
            int r2 = r27 + 1
            r14 = 1953658222(0x7472756e, float:7.683823E31)
            r0 = r44
            r7 = r5
            r4 = r17
            r6 = r18
            r10 = r19
            r1 = r20
            r3 = r22
            r8 = r23
            r9 = r24
            r5 = r26
            goto L_0x0289
        L_0x042a:
            r20 = r1
            r22 = r3
            r17 = r4
            r26 = r5
            r5 = r7
            r23 = r8
            r24 = r9
            com.google.android.gms.internal.ads.zzwy r0 = r5.zzd
            com.google.android.gms.internal.ads.zzwv r0 = r0.zza
            r1 = r24
            com.google.android.gms.internal.ads.zzwh r2 = r1.zza
            if (r2 == 0) goto L_0x063f
            int r2 = r2.zza
            com.google.android.gms.internal.ads.zzww r0 = r0.zza(r2)
            r2 = 1935763834(0x7361697a, float:1.785898E31)
            r8 = r23
            com.google.android.gms.internal.ads.zzvy r2 = r8.zzc(r2)
            if (r2 == 0) goto L_0x04b9
            if (r0 == 0) goto L_0x04b7
            com.google.android.gms.internal.ads.zzakr r2 = r2.zza
            int r3 = r0.zzd
            r4 = 8
            r2.zzh(r4)
            int r5 = r2.zzv()
            r6 = 1
            r5 = r5 & r6
            if (r5 != r6) goto L_0x0468
            r2.zzk(r4)
        L_0x0468:
            int r4 = r2.zzn()
            int r5 = r2.zzB()
            int r6 = r1.zze
            if (r5 > r6) goto L_0x04a6
            if (r4 != 0) goto L_0x048b
            boolean[] r4 = r1.zzm
            r6 = 0
            r7 = 0
        L_0x047a:
            if (r6 >= r5) goto L_0x0498
            int r9 = r2.zzn()
            int r7 = r7 + r9
            if (r9 <= r3) goto L_0x0485
            r9 = 1
            goto L_0x0486
        L_0x0485:
            r9 = 0
        L_0x0486:
            r4[r6] = r9
            int r6 = r6 + 1
            goto L_0x047a
        L_0x048b:
            if (r4 <= r3) goto L_0x048f
            r2 = 1
            goto L_0x0490
        L_0x048f:
            r2 = 0
        L_0x0490:
            int r7 = r4 * r5
            boolean[] r3 = r1.zzm
            r4 = 0
            java.util.Arrays.fill(r3, r4, r5, r2)
        L_0x0498:
            r2 = 0
            boolean[] r3 = r1.zzm
            int r4 = r1.zze
            java.util.Arrays.fill(r3, r5, r4, r2)
            if (r7 <= 0) goto L_0x04b9
            r1.zza(r7)
            goto L_0x04b9
        L_0x04a6:
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            r1 = 78
            java.lang.String r2 = "Saiz sample count "
            java.lang.String r3 = " is greater than fragment sample count"
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline11(r1, r2, r5, r3, r6)
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        L_0x04b7:
            r0 = 0
            throw r0
        L_0x04b9:
            r2 = 1935763823(0x7361696f, float:1.7858967E31)
            com.google.android.gms.internal.ads.zzvy r2 = r8.zzc(r2)
            if (r2 == 0) goto L_0x04ff
            com.google.android.gms.internal.ads.zzakr r2 = r2.zza
            r3 = 8
            r2.zzh(r3)
            int r4 = r2.zzv()
            r5 = r4 & 1
            r6 = 1
            if (r5 != r6) goto L_0x04d5
            r2.zzk(r3)
        L_0x04d5:
            int r3 = r2.zzB()
            if (r3 != r6) goto L_0x04f0
            long r5 = r1.zzc
            int r3 = com.google.android.gms.internal.ads.zzvz.zze(r4)
            if (r3 != 0) goto L_0x04e8
            long r2 = r2.zzt()
            goto L_0x04ec
        L_0x04e8:
            long r2 = r2.zzD()
        L_0x04ec:
            long r5 = r5 + r2
            r1.zzc = r5
            goto L_0x04ff
        L_0x04f0:
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            r1 = 40
            java.lang.String r2 = "Unexpected saio entry count: "
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r1, r2, r3)
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        L_0x04ff:
            r2 = 1936027235(0x73656e63, float:1.8177412E31)
            com.google.android.gms.internal.ads.zzvy r2 = r8.zzc(r2)
            if (r2 == 0) goto L_0x050e
            com.google.android.gms.internal.ads.zzakr r2 = r2.zza
            r3 = 0
            zzh(r2, r3, r1)
        L_0x050e:
            if (r0 == 0) goto L_0x0513
            java.lang.String r0 = r0.zzb
            goto L_0x0514
        L_0x0513:
            r0 = 0
        L_0x0514:
            r29 = r0
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x0519:
            java.util.List<com.google.android.gms.internal.ads.zzvy> r4 = r8.zzb
            int r4 = r4.size()
            if (r0 >= r4) goto L_0x0556
            java.util.List<com.google.android.gms.internal.ads.zzvy> r4 = r8.zzb
            java.lang.Object r4 = r4.get(r0)
            com.google.android.gms.internal.ads.zzvy r4 = (com.google.android.gms.internal.ads.zzvy) r4
            com.google.android.gms.internal.ads.zzakr r5 = r4.zza
            int r4 = r4.zzd
            r6 = 1935828848(0x73626770, float:1.7937577E31)
            r7 = 1936025959(0x73656967, float:1.817587E31)
            if (r4 != r6) goto L_0x0542
            r4 = 12
            r5.zzh(r4)
            int r4 = r5.zzv()
            if (r4 != r7) goto L_0x0553
            r2 = r5
            goto L_0x0553
        L_0x0542:
            r6 = 12
            r9 = 1936158820(0x73677064, float:1.8336489E31)
            if (r4 != r9) goto L_0x0553
            r5.zzh(r6)
            int r4 = r5.zzv()
            if (r4 != r7) goto L_0x0553
            r3 = r5
        L_0x0553:
            int r0 = r0 + 1
            goto L_0x0519
        L_0x0556:
            if (r2 == 0) goto L_0x0600
            if (r3 != 0) goto L_0x055c
            goto L_0x0600
        L_0x055c:
            r0 = 8
            r2.zzh(r0)
            int r4 = r2.zzv()
            r5 = 4
            r2.zzk(r5)
            int r4 = com.google.android.gms.internal.ads.zzvz.zze(r4)
            r6 = 1
            if (r4 != r6) goto L_0x0573
            r2.zzk(r5)
        L_0x0573:
            int r2 = r2.zzv()
            if (r2 != r6) goto L_0x05f7
            r3.zzh(r0)
            int r0 = r3.zzv()
            int r0 = com.google.android.gms.internal.ads.zzvz.zze(r0)
            r3.zzk(r5)
            if (r0 != r6) goto L_0x059d
            long r4 = r3.zzt()
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0594
            goto L_0x05a3
        L_0x0594:
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r1 = "Variable length description in sgpd found (unsupported)"
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        L_0x059d:
            r2 = 2
            if (r0 < r2) goto L_0x05a3
            r3.zzk(r5)
        L_0x05a3:
            long r4 = r3.zzt()
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x05ee
            r0 = 1
            r3.zzk(r0)
            int r2 = r3.zzn()
            r4 = r2 & 240(0xf0, float:3.36E-43)
            int r32 = r4 >> 4
            r33 = r2 & 15
            int r2 = r3.zzn()
            if (r2 != r0) goto L_0x0600
            int r30 = r3.zzn()
            r2 = 16
            byte[] r4 = new byte[r2]
            r5 = 0
            r3.zzm(r4, r5, r2)
            if (r30 != 0) goto L_0x05db
            int r2 = r3.zzn()
            byte[] r6 = new byte[r2]
            r3.zzm(r6, r5, r2)
            r34 = r6
            goto L_0x05de
        L_0x05db:
            r2 = 0
            r34 = r2
        L_0x05de:
            r1.zzl = r0
            com.google.android.gms.internal.ads.zzww r0 = new com.google.android.gms.internal.ads.zzww
            r28 = 1
            r27 = r0
            r31 = r4
            r27.<init>(r28, r29, r30, r31, r32, r33, r34)
            r1.zzn = r0
            goto L_0x0600
        L_0x05ee:
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        L_0x05f7:
            r0 = 0
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "Entry count in sbgp != 1 (unsupported)."
            r1.<init>(r2, r0)
            throw r1
        L_0x0600:
            java.util.List<com.google.android.gms.internal.ads.zzvy> r0 = r8.zzb
            int r0 = r0.size()
            r2 = 0
        L_0x0607:
            if (r2 >= r0) goto L_0x063a
            java.util.List<com.google.android.gms.internal.ads.zzvy> r3 = r8.zzb
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.ads.zzvy r3 = (com.google.android.gms.internal.ads.zzvy) r3
            int r4 = r3.zzd
            r5 = 1970628964(0x75756964, float:3.1109627E32)
            if (r4 != r5) goto L_0x0633
            com.google.android.gms.internal.ads.zzakr r3 = r3.zza
            r4 = 8
            r3.zzh(r4)
            r4 = 0
            r5 = 16
            r6 = r20
            r3.zzm(r6, r4, r5)
            byte[] r4 = zzb
            boolean r4 = java.util.Arrays.equals(r6, r4)
            if (r4 == 0) goto L_0x0635
            zzh(r3, r5, r1)
            goto L_0x0635
        L_0x0633:
            r6 = r20
        L_0x0635:
            int r2 = r2 + 1
            r20 = r6
            goto L_0x0607
        L_0x063a:
            r6 = r20
            r0 = 0
            r7 = r0
            goto L_0x064b
        L_0x063f:
            r0 = 0
            throw r0
        L_0x0641:
            throw r7
        L_0x0642:
            r6 = r1
            r16 = r2
            r22 = r3
            r17 = r4
            r26 = r5
        L_0x064b:
            int r5 = r26 + 1
            r0 = 8
            r0 = r44
            r1 = r6
            r2 = r16
            r4 = r17
            r3 = r22
            r6 = 8
            goto L_0x0157
        L_0x065c:
            r2 = r3
            java.util.List<com.google.android.gms.internal.ads.zzvy> r0 = r2.zzb
            com.google.android.gms.internal.ads.zzsa r0 = zzi(r0)
            r3 = r44
            if (r0 == 0) goto L_0x06ab
            android.util.SparseArray<com.google.android.gms.internal.ads.zzwl> r1 = r3.zze
            int r1 = r1.size()
            r2 = 0
        L_0x066e:
            if (r2 >= r1) goto L_0x06ab
            android.util.SparseArray<com.google.android.gms.internal.ads.zzwl> r4 = r3.zze
            java.lang.Object r4 = r4.valueAt(r2)
            com.google.android.gms.internal.ads.zzwl r4 = (com.google.android.gms.internal.ads.zzwl) r4
            com.google.android.gms.internal.ads.zzwy r5 = r4.zzd
            com.google.android.gms.internal.ads.zzwv r5 = r5.zza
            com.google.android.gms.internal.ads.zzwx r6 = r4.zzb
            com.google.android.gms.internal.ads.zzwh r6 = r6.zza
            int r8 = com.google.android.gms.internal.ads.zzalh.zza
            int r6 = r6.zza
            com.google.android.gms.internal.ads.zzww r5 = r5.zza(r6)
            if (r5 == 0) goto L_0x068d
            java.lang.String r5 = r5.zzb
            goto L_0x068e
        L_0x068d:
            r5 = r7
        L_0x068e:
            com.google.android.gms.internal.ads.zzsa r5 = r0.zza(r5)
            com.google.android.gms.internal.ads.zzwy r6 = r4.zzd
            com.google.android.gms.internal.ads.zzwv r6 = r6.zza
            com.google.android.gms.internal.ads.zzkc r6 = r6.zzf
            com.google.android.gms.internal.ads.zzkb r6 = r6.zza()
            r6.zzm(r5)
            com.google.android.gms.internal.ads.zzkc r5 = r6.zzD()
            com.google.android.gms.internal.ads.zztz r4 = r4.zza
            r4.zza(r5)
            int r2 = r2 + 1
            goto L_0x066e
        L_0x06ab:
            long r0 = r3.zzv
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x06f0
            android.util.SparseArray<com.google.android.gms.internal.ads.zzwl> r0 = r3.zze
            int r0 = r0.size()
            r1 = 0
        L_0x06bd:
            if (r1 >= r0) goto L_0x06e9
            android.util.SparseArray<com.google.android.gms.internal.ads.zzwl> r2 = r3.zze
            java.lang.Object r2 = r2.valueAt(r1)
            com.google.android.gms.internal.ads.zzwl r2 = (com.google.android.gms.internal.ads.zzwl) r2
            long r4 = r3.zzv
            int r6 = r2.zzf
        L_0x06cb:
            com.google.android.gms.internal.ads.zzwx r7 = r2.zzb
            int r8 = r7.zze
            if (r6 >= r8) goto L_0x06e6
            long r7 = r7.zzb(r6)
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 >= 0) goto L_0x06e6
            com.google.android.gms.internal.ads.zzwx r7 = r2.zzb
            boolean[] r7 = r7.zzk
            boolean r7 = r7[r6]
            if (r7 == 0) goto L_0x06e3
            r2.zzi = r6
        L_0x06e3:
            int r6 = r6 + 1
            goto L_0x06cb
        L_0x06e6:
            int r1 = r1 + 1
            goto L_0x06bd
        L_0x06e9:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3.zzv = r0
        L_0x06f0:
            r1 = r3
            goto L_0x0707
        L_0x06f2:
            r2 = r3
            r3 = r0
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvx> r0 = r1.zzm
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0707
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvx> r0 = r1.zzm
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzvx r0 = (com.google.android.gms.internal.ads.zzvx) r0
            r0.zzb(r2)
        L_0x0707:
            r0 = r3
            goto L_0x0003
        L_0x070a:
            r3 = r0
            r44.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwm.zzb(long):void");
    }

    public static int zzc(int i) throws zzlg {
        if (i >= 0) {
            return i;
        }
        throw new zzlg(GeneratedOutlineSupport.outline9(38, "Unexpected negative value: ", i), (Throwable) null);
    }

    public static void zzh(zzakr zzakr, int i, zzwx zzwx) throws zzlg {
        zzakr.zzh(i + 8);
        int zzv2 = zzakr.zzv() & ViewCompat.MEASURED_SIZE_MASK;
        if ((zzv2 & 1) == 0) {
            boolean z = (zzv2 & 2) != 0;
            int zzB2 = zzakr.zzB();
            if (zzB2 == 0) {
                Arrays.fill(zzwx.zzm, 0, zzwx.zze, false);
                return;
            }
            int i2 = zzwx.zze;
            if (zzB2 == i2) {
                Arrays.fill(zzwx.zzm, 0, zzB2, z);
                zzwx.zza(zzakr.zzd());
                zzakr.zzm(zzwx.zzo.zzi(), 0, zzwx.zzo.zze());
                zzwx.zzo.zzh(0);
                zzwx.zzp = false;
                return;
            }
            throw new zzlg(GeneratedOutlineSupport.outline11(80, "Senc sample count ", zzB2, " is different from fragment sample count", i2), (Throwable) null);
        }
        throw new zzlg("Overriding TrackEncryptionBox parameters is unsupported.", (Throwable) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009e  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzsa zzi(java.util.List<com.google.android.gms.internal.ads.zzvy> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r2
        L_0x0008:
            if (r3 >= r0) goto L_0x00ac
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzvy r5 = (com.google.android.gms.internal.ads.zzvy) r5
            int r6 = r5.zzd
            r7 = 1886614376(0x70737368, float:3.013775E29)
            if (r6 != r7) goto L_0x00a8
            if (r4 != 0) goto L_0x001e
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001e:
            com.google.android.gms.internal.ads.zzakr r5 = r5.zza
            byte[] r5 = r5.zzi()
            com.google.android.gms.internal.ads.zzakr r6 = new com.google.android.gms.internal.ads.zzakr
            r6.<init>((byte[]) r5)
            int r8 = r6.zze()
            r9 = 32
            if (r8 >= r9) goto L_0x0032
            goto L_0x0080
        L_0x0032:
            r6.zzh(r1)
            int r8 = r6.zzv()
            int r9 = r6.zzd()
            int r9 = r9 + 4
            if (r8 == r9) goto L_0x0042
            goto L_0x0080
        L_0x0042:
            int r8 = r6.zzv()
            if (r8 == r7) goto L_0x0049
            goto L_0x0080
        L_0x0049:
            int r7 = r6.zzv()
            int r7 = com.google.android.gms.internal.ads.zzvz.zze(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x005e
            r6 = 37
            java.lang.String r8 = "Unsupported pssh version: "
            java.lang.String r9 = "PsshAtomUtil"
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r6, r8, r7, r9)
            goto L_0x0080
        L_0x005e:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.zzx()
            long r12 = r6.zzx()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x0076
            int r8 = r6.zzB()
            int r8 = r8 * 16
            r6.zzk(r8)
        L_0x0076:
            int r8 = r6.zzB()
            int r10 = r6.zzd()
            if (r8 == r10) goto L_0x0082
        L_0x0080:
            r6 = r2
            goto L_0x008c
        L_0x0082:
            byte[] r10 = new byte[r8]
            r6.zzm(r10, r1, r8)
            com.google.android.gms.internal.ads.zzws r6 = new com.google.android.gms.internal.ads.zzws
            r6.<init>(r9, r7, r10)
        L_0x008c:
            if (r6 != 0) goto L_0x0090
            r6 = r2
            goto L_0x0094
        L_0x0090:
            java.util.UUID r6 = r6.zza
        L_0x0094:
            if (r6 != 0) goto L_0x009e
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto L_0x00a8
        L_0x009e:
            com.google.android.gms.internal.ads.zzrz r7 = new com.google.android.gms.internal.ads.zzrz
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r2, r8, r5)
            r4.add(r7)
        L_0x00a8:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x00ac:
            if (r4 != 0) goto L_0x00af
            return r2
        L_0x00af:
            com.google.android.gms.internal.ads.zzsa r14 = new com.google.android.gms.internal.ads.zzsa
            r14.<init>((java.util.List<com.google.android.gms.internal.ads.zzrz>) r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwm.zzi(java.util.List):com.google.android.gms.internal.ads.zzsa");
    }

    public static final zzwh zzj(SparseArray<zzwh> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        zzwh zzwh = sparseArray.get(i);
        if (zzwh != null) {
            return zzwh;
        }
        throw null;
    }

    public final boolean zzd(zztb zztb) throws IOException {
        return zzwu.zza(zztb);
    }

    public final void zze(zztd zztd) {
        this.zzD = zztd;
        zza();
        zztz[] zztzArr = new zztz[2];
        this.zzE = zztzArr;
        int i = 0;
        zztz[] zztzArr2 = (zztz[]) zzalh.zzf(zztzArr, 0);
        this.zzE = zztzArr2;
        for (zztz zza2 : zztzArr2) {
            zza2.zza(zzc);
        }
        this.zzF = new zztz[this.zzd.size()];
        int i2 = 100;
        while (i < this.zzF.length) {
            int i3 = i2 + 1;
            zztz zza3 = this.zzD.zza(i2, 3);
            zza3.zza(this.zzd.get(i));
            this.zzF[i] = zza3;
            i++;
            i2 = i3;
        }
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        byte b;
        boolean z;
        zzwm zzwm;
        long zzF2;
        long j;
        long zzt2;
        String str;
        String str2;
        long j2;
        long j3;
        long j4;
        zzwl zzwl;
        int i;
        boolean z2;
        int i2;
        zzwm zzwm2 = this;
        zztb zztb2 = zztb;
        while (true) {
            int i3 = zzwm2.zzo;
            b = 1;
            z = false;
            if (i3 == 0) {
                zzwm = zzwm2;
                if (zzwm.zzr == 0) {
                    if (!zztb2.zzb(zzwm.zzl.zzi(), 0, 8, true)) {
                        return -1;
                    }
                    zzwm.zzr = 8;
                    zzwm.zzl.zzh(0);
                    zzwm.zzq = zzwm.zzl.zzt();
                    zzwm.zzp = zzwm.zzl.zzv();
                }
                long j5 = zzwm.zzq;
                if (j5 == 1) {
                    ((zzsx) zztb2).zzb(zzwm.zzl.zzi(), 8, 8, false);
                    zzwm.zzr += 8;
                    zzwm.zzq = zzwm.zzl.zzD();
                } else if (j5 == 0) {
                    long zzo2 = zztb.zzo();
                    if (zzo2 == -1 && !zzwm.zzm.isEmpty()) {
                        zzo2 = zzwm.zzm.peek().zza;
                    }
                    if (zzo2 != -1) {
                        zzwm.zzq = (zzo2 - zztb.zzn()) + ((long) zzwm.zzr);
                    }
                }
                if (zzwm.zzq >= ((long) zzwm.zzr)) {
                    long zzn2 = zztb.zzn() - ((long) zzwm.zzr);
                    int i4 = zzwm.zzp;
                    if ((i4 == 1836019558 || i4 == 1835295092) && !zzwm.zzG) {
                        zzwm.zzD.zzbm(new zztu(zzwm.zzw, zzn2));
                        zzwm.zzG = true;
                    }
                    if (zzwm.zzp == 1836019558) {
                        int size = zzwm.zze.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            zzwx zzwx = zzwm.zze.valueAt(i5).zzb;
                            zzwx.zzc = zzn2;
                            zzwx.zzb = zzn2;
                        }
                    }
                    int i6 = zzwm.zzp;
                    if (i6 == 1835295092) {
                        zzwm.zzy = null;
                        zzwm.zzt = zzn2 + zzwm.zzq;
                        zzwm.zzo = 2;
                    } else if (i6 == 1836019574 || i6 == 1953653099 || i6 == 1835297121 || i6 == 1835626086 || i6 == 1937007212 || i6 == 1836019558 || i6 == 1953653094 || i6 == 1836475768 || i6 == 1701082227) {
                        long zzn3 = (zztb.zzn() + zzwm.zzq) - 8;
                        zzwm.zzm.push(new zzvx(zzwm.zzp, zzn3));
                        if (zzwm.zzq == ((long) zzwm.zzr)) {
                            zzwm.zzb(zzn3);
                        } else {
                            zza();
                        }
                    } else if (i6 == 1751411826 || i6 == 1835296868 || i6 == 1836476516 || i6 == 1936286840 || i6 == 1937011556 || i6 == 1937011827 || i6 == 1668576371 || i6 == 1937011555 || i6 == 1937011578 || i6 == 1937013298 || i6 == 1937007471 || i6 == 1668232756 || i6 == 1937011571 || i6 == 1952867444 || i6 == 1952868452 || i6 == 1953196132 || i6 == 1953654136 || i6 == 1953658222 || i6 == 1886614376 || i6 == 1935763834 || i6 == 1935763823 || i6 == 1936027235 || i6 == 1970628964 || i6 == 1935828848 || i6 == 1936158820 || i6 == 1701606260 || i6 == 1835362404 || i6 == 1701671783) {
                        if (zzwm.zzr == 8) {
                            long j6 = zzwm.zzq;
                            if (j6 <= 2147483647L) {
                                zzakr zzakr = new zzakr((int) j6);
                                System.arraycopy(zzwm.zzl.zzi(), 0, zzakr.zzi(), 0, 8);
                                zzwm.zzs = zzakr;
                                zzwm.zzo = 1;
                            } else {
                                throw new zzlg("Leaf atom with length > 2147483647 (unsupported).", (Throwable) null);
                            }
                        } else {
                            throw new zzlg("Leaf atom defines extended atom size (unsupported).", (Throwable) null);
                        }
                    } else if (zzwm.zzq <= 2147483647L) {
                        zzwm.zzs = null;
                        zzwm.zzo = 1;
                    } else {
                        throw new zzlg("Skipping atom with length > 2147483647 (unsupported).", (Throwable) null);
                    }
                } else {
                    throw new zzlg("Atom size less than header length (unsupported).", (Throwable) null);
                }
            } else if (i3 != 1) {
                if (i3 != 2) {
                    zzwl = zzwm2.zzy;
                    if (zzwl != null) {
                        break;
                    }
                    SparseArray<zzwl> sparseArray = zzwm2.zze;
                    int size2 = sparseArray.size();
                    long j7 = Long.MAX_VALUE;
                    zzwl zzwl2 = null;
                    for (int i7 = 0; i7 < size2; i7++) {
                        zzwl valueAt = sparseArray.valueAt(i7);
                        if ((valueAt.zzl || valueAt.zzf != valueAt.zzd.zzb) && (!valueAt.zzl || valueAt.zzh != valueAt.zzb.zzd)) {
                            long zzd2 = valueAt.zzd();
                            if (zzd2 < j7) {
                                zzwl2 = valueAt;
                                j7 = zzd2;
                            }
                        }
                    }
                    if (zzwl2 == null) {
                        int zzn4 = (int) (zzwm2.zzt - zztb.zzn());
                        if (zzn4 >= 0) {
                            ((zzsx) zztb2).zze(zzn4, false);
                            zza();
                        } else {
                            throw new zzlg("Offset to end of mdat was negative.", (Throwable) null);
                        }
                    } else {
                        int zzd3 = (int) (zzwl2.zzd() - zztb.zzn());
                        if (zzd3 < 0) {
                            Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            zzd3 = 0;
                        }
                        ((zzsx) zztb2).zze(zzd3, false);
                        zzwm2.zzy = zzwl2;
                        zzwl = zzwl2;
                    }
                } else {
                    int size3 = zzwm2.zze.size();
                    long j8 = Long.MAX_VALUE;
                    zzwl zzwl3 = null;
                    for (int i8 = 0; i8 < size3; i8++) {
                        zzwx zzwx2 = zzwm2.zze.valueAt(i8).zzb;
                        if (zzwx2.zzp) {
                            long j9 = zzwx2.zzc;
                            if (j9 < j8) {
                                zzwl3 = zzwm2.zze.valueAt(i8);
                                j8 = j9;
                            }
                        }
                    }
                    if (zzwl3 == null) {
                        zzwm2.zzo = 3;
                    } else {
                        int zzn5 = (int) (j8 - zztb.zzn());
                        if (zzn5 >= 0) {
                            zzsx zzsx = (zzsx) zztb2;
                            zzsx.zze(zzn5, false);
                            zzwx zzwx3 = zzwl3.zzb;
                            zzsx.zzb(zzwx3.zzo.zzi(), 0, zzwx3.zzo.zze(), false);
                            zzwx3.zzo.zzh(0);
                            zzwx3.zzp = false;
                        } else {
                            throw new zzlg("Offset to encryption data was negative.", (Throwable) null);
                        }
                    }
                }
                zzwm = zzwm2;
            } else {
                int i9 = ((int) zzwm2.zzq) - zzwm2.zzr;
                zzakr zzakr2 = zzwm2.zzs;
                if (zzakr2 != null) {
                    ((zzsx) zztb2).zzb(zzakr2.zzi(), 8, i9, false);
                    zzvy zzvy = new zzvy(zzwm2.zzp, zzakr2);
                    long zzn6 = zztb.zzn();
                    if (!zzwm2.zzm.isEmpty()) {
                        zzwm2.zzm.peek().zza(zzvy);
                        zzwm = zzwm2;
                    } else {
                        int i10 = zzvy.zzd;
                        if (i10 == 1936286840) {
                            zzakr zzakr3 = zzvy.zza;
                            zzakr3.zzh(8);
                            int zzv2 = zzakr3.zzv();
                            zzakr3.zzk(4);
                            long zzt3 = zzakr3.zzt();
                            if (zzvz.zze(zzv2) == 0) {
                                j4 = zzakr3.zzt();
                                j3 = zzakr3.zzt();
                            } else {
                                j4 = zzakr3.zzD();
                                j3 = zzakr3.zzD();
                            }
                            long j10 = j4;
                            long j11 = zzn6 + j3;
                            long zzF3 = zzalh.zzF(j10, 1000000, zzt3);
                            zzakr3.zzk(2);
                            int zzo3 = zzakr3.zzo();
                            int[] iArr = new int[zzo3];
                            long[] jArr = new long[zzo3];
                            long[] jArr2 = new long[zzo3];
                            long[] jArr3 = new long[zzo3];
                            long j12 = j10;
                            long j13 = zzF3;
                            int i11 = 0;
                            while (i11 < zzo3) {
                                int zzv3 = zzakr3.zzv();
                                if ((zzv3 & Integer.MIN_VALUE) == 0) {
                                    long zzt4 = zzakr3.zzt();
                                    iArr[i11] = zzv3 & Integer.MAX_VALUE;
                                    jArr[i11] = j11;
                                    jArr3[i11] = j13;
                                    long j14 = j12 + zzt4;
                                    int i12 = zzo3;
                                    long[] jArr4 = jArr2;
                                    long[] jArr5 = jArr3;
                                    int[] iArr2 = iArr;
                                    long zzF4 = zzalh.zzF(j14, 1000000, zzt3);
                                    jArr4[i11] = zzF4 - jArr5[i11];
                                    zzakr3.zzk(4);
                                    j11 += (long) iArr2[i11];
                                    i11++;
                                    iArr = iArr2;
                                    jArr3 = jArr5;
                                    jArr2 = jArr4;
                                    jArr = jArr;
                                    zzo3 = i12;
                                    long j15 = zzF4;
                                    j12 = j14;
                                    j13 = j15;
                                } else {
                                    throw new zzlg("Unhandled indirect reference", (Throwable) null);
                                }
                            }
                            Pair create = Pair.create(Long.valueOf(zzF3), new zzsv(iArr, jArr, jArr2, jArr3));
                            zzwm = this;
                            zzwm.zzx = ((Long) create.first).longValue();
                            zzwm.zzD.zzbm((zztv) create.second);
                            zzwm.zzG = true;
                        } else {
                            zzwm = zzwm2;
                            if (i10 == 1701671783) {
                                zzakr zzakr4 = zzvy.zza;
                                if (zzwm.zzE.length != 0) {
                                    zzakr4.zzh(8);
                                    int zze2 = zzvz.zze(zzakr4.zzv());
                                    if (zze2 == 0) {
                                        String zzG2 = zzakr4.zzG(0);
                                        if (zzG2 != null) {
                                            String zzG3 = zzakr4.zzG(0);
                                            if (zzG3 != null) {
                                                long zzt5 = zzakr4.zzt();
                                                zzF2 = zzalh.zzF(zzakr4.zzt(), 1000000, zzt5);
                                                long j16 = zzwm.zzx;
                                                j = j16 != -9223372036854775807L ? j16 + zzF2 : -9223372036854775807L;
                                                long zzF5 = zzalh.zzF(zzakr4.zzt(), 1000, zzt5);
                                                zzt2 = zzakr4.zzt();
                                                str = zzG3;
                                                str2 = zzG2;
                                                j2 = zzF5;
                                            } else {
                                                throw null;
                                            }
                                        } else {
                                            throw null;
                                        }
                                    } else if (zze2 != 1) {
                                        GeneratedOutlineSupport.outline29(46, "Skipping unsupported emsg version: ", zze2, "FragmentedMp4Extractor");
                                    } else {
                                        long zzt6 = zzakr4.zzt();
                                        long zzF6 = zzalh.zzF(zzakr4.zzD(), 1000000, zzt6);
                                        long zzF7 = zzalh.zzF(zzakr4.zzt(), 1000, zzt6);
                                        zzt2 = zzakr4.zzt();
                                        String zzG4 = zzakr4.zzG(0);
                                        if (zzG4 != null) {
                                            String zzG5 = zzakr4.zzG(0);
                                            if (zzG5 != null) {
                                                str = zzG5;
                                                zzF2 = -9223372036854775807L;
                                                str2 = zzG4;
                                                j2 = zzF7;
                                                j = zzF6;
                                            } else {
                                                throw null;
                                            }
                                        } else {
                                            throw null;
                                        }
                                    }
                                    long j17 = zzt2;
                                    byte[] bArr = new byte[zzakr4.zzd()];
                                    zzakr4.zzm(bArr, 0, zzakr4.zzd());
                                    zzakr zzakr5 = new zzakr(zzwm.zzk.zza(new zzabi(str2, str, j2, j17, bArr)));
                                    int zzd4 = zzakr5.zzd();
                                    for (zztz zzf2 : zzwm.zzE) {
                                        zzakr5.zzh(0);
                                        zzf2.zzf(zzakr5, zzd4);
                                    }
                                    if (j == -9223372036854775807L) {
                                        zzwm.zzn.addLast(new zzwk(zzF2, zzd4));
                                        zzwm.zzu += zzd4;
                                    } else {
                                        for (zztz zzd5 : zzwm.zzE) {
                                            zzd5.zzd(j, 1, zzd4, 0, (zzty) null);
                                        }
                                    }
                                }
                            }
                        }
                        zztb2 = zztb;
                    }
                } else {
                    zzwm = zzwm2;
                    ((zzsx) zztb2).zze(i9, false);
                }
                zzwm.zzb(zztb.zzn());
            }
            zzwm2 = zzwm;
        }
        byte b2 = 6;
        if (zzwm2.zzo == 3) {
            int zze3 = zzwl.zze();
            zzwm2.zzz = zze3;
            if (zzwl.zzf < zzwl.zzi) {
                ((zzsx) zztb2).zze(zze3, false);
                zzww zzi2 = zzwl.zzi();
                if (zzi2 != null) {
                    zzakr zzakr6 = zzwl.zzb.zzo;
                    int i13 = zzi2.zzd;
                    if (i13 != 0) {
                        zzakr6.zzk(i13);
                    }
                    if (zzwl.zzb.zzc(zzwl.zzf)) {
                        zzakr6.zzk(zzakr6.zzo() * 6);
                    }
                }
                if (!zzwl.zzg()) {
                    zzwm2.zzy = null;
                }
                zzwm2.zzo = 3;
                return 0;
            }
            if (zzwl.zzd.zza.zzg == 1) {
                zzwm2.zzz = zze3 - 8;
                ((zzsx) zztb2).zze(8, false);
            }
            if ("audio/ac4".equals(zzwl.zzd.zza.zzf.zzl)) {
                zzwm2.zzA = zzwl.zzh(zzwm2.zzz, 7);
                zzpf.zzb(zzwm2.zzz, zzwm2.zzj);
                zztx.zzb(zzwl.zza, zzwm2.zzj, 7);
                i2 = zzwm2.zzA + 7;
                zzwm2.zzA = i2;
            } else {
                i2 = zzwl.zzh(zzwm2.zzz, 0);
                zzwm2.zzA = i2;
            }
            zzwm2.zzz += i2;
            zzwm2.zzo = 4;
            zzwm2.zzB = 0;
        }
        zzwv zzwv = zzwl.zzd.zza;
        zztz zztz = zzwl.zza;
        long zzc2 = zzwl.zzc();
        if (zzwv.zzj == 0) {
            while (true) {
                int i14 = zzwm2.zzA;
                int i15 = zzwm2.zzz;
                if (i14 >= i15) {
                    break;
                }
                zzwm2.zzA += zztx.zza(zztz, zztb2, i15 - i14, false);
            }
        } else {
            byte[] zzi3 = zzwm2.zzg.zzi();
            zzi3[0] = 0;
            zzi3[1] = 0;
            zzi3[2] = 0;
            int i16 = zzwv.zzj;
            int i17 = i16 + 1;
            int i18 = 4 - i16;
            while (zzwm2.zzA < zzwm2.zzz) {
                int i19 = zzwm2.zzB;
                if (i19 == 0) {
                    ((zzsx) zztb2).zzb(zzi3, i18, i17, z);
                    zzwm2.zzg.zzh(z ? 1 : 0);
                    int zzv4 = zzwm2.zzg.zzv();
                    if (zzv4 > 0) {
                        zzwm2.zzB = zzv4 - 1;
                        zzwm2.zzf.zzh(z);
                        zztx.zzb(zztz, zzwm2.zzf, 4);
                        zztx.zzb(zztz, zzwm2.zzg, b);
                        if (zzwm2.zzF.length > 0) {
                            String str3 = zzwv.zzf.zzl;
                            byte b3 = zzi3[4];
                            byte[] bArr2 = zzakj.zza;
                            if (("video/avc".equals(str3) && (b3 & 31) == b2) || ("video/hevc".equals(str3) && ((b3 & 126) >> b) == 39)) {
                                z2 = true;
                                zzwm2.zzC = z2;
                                zzwm2.zzA += 5;
                                zzwm2.zzz += i18;
                            }
                        }
                        z2 = false;
                        zzwm2.zzC = z2;
                        zzwm2.zzA += 5;
                        zzwm2.zzz += i18;
                    } else {
                        throw new zzlg("Invalid NAL length", (Throwable) null);
                    }
                } else {
                    if (zzwm2.zzC) {
                        zzwm2.zzh.zza(i19);
                        ((zzsx) zztb2).zzb(zzwm2.zzh.zzi(), 0, zzwm2.zzB, false);
                        zztx.zzb(zztz, zzwm2.zzh, zzwm2.zzB);
                        i = zzwm2.zzB;
                        int zza2 = zzakj.zza(zzwm2.zzh.zzi(), zzwm2.zzh.zze());
                        zzwm2.zzh.zzh("video/hevc".equals(zzwv.zzf.zzl) ? 1 : 0);
                        zzwm2.zzh.zzf(zza2);
                        zzsu.zza(zzc2, zzwm2.zzh, zzwm2.zzF);
                    } else {
                        i = zztx.zza(zztz, zztb2, i19, false);
                    }
                    zzwm2.zzA += i;
                    zzwm2.zzB -= i;
                    b2 = 6;
                    b = 1;
                }
                z = false;
            }
        }
        int zzf3 = zzwl.zzf();
        zzww zzi4 = zzwl.zzi();
        long j18 = zzc2;
        zztz.zzd(zzc2, zzf3, zzwm2.zzz, 0, zzi4 != null ? zzi4.zzc : null);
        while (!zzwm2.zzn.isEmpty()) {
            zzwk removeFirst = zzwm2.zzn.removeFirst();
            zzwm2.zzu -= removeFirst.zzb;
            long j19 = removeFirst.zza + j18;
            for (zztz zzd6 : zzwm2.zzE) {
                zzd6.zzd(j19, 1, removeFirst.zzb, zzwm2.zzu, (zzty) null);
            }
        }
        if (!zzwl.zzg()) {
            zzwm2.zzy = null;
        }
        zzwm2.zzo = 3;
        return 0;
    }

    public final void zzg(long j, long j2) {
        int size = this.zze.size();
        for (int i = 0; i < size; i++) {
            this.zze.valueAt(i).zzb();
        }
        this.zzn.clear();
        this.zzu = 0;
        this.zzv = j2;
        this.zzm.clear();
        zza();
    }

    public zzwm(int i, @Nullable zzale zzale) {
        this.zzd = Collections.unmodifiableList(Collections.emptyList());
        this.zzk = new zzabj();
        this.zzl = new zzakr(16);
        this.zzf = new zzakr(zzakj.zza);
        this.zzg = new zzakr(5);
        this.zzh = new zzakr();
        byte[] bArr = new byte[16];
        this.zzi = bArr;
        this.zzj = new zzakr(bArr);
        this.zzm = new ArrayDeque<>();
        this.zzn = new ArrayDeque<>();
        this.zze = new SparseArray<>();
        this.zzw = -9223372036854775807L;
        this.zzv = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzD = zztd.zza;
        this.zzE = new zztz[0];
        this.zzF = new zztz[0];
    }
}
