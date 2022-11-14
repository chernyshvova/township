package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaqs implements zzapl {
    public static final zzapn zza = new zzaqp();
    public static final int zzb = zzava.zzl("seig");
    public static final byte[] zzc = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public final SparseArray<zzaqr> zzd;
    public final zzaut zze;
    public final zzaut zzf;
    public final zzaut zzg;
    public final zzaut zzh;
    public final zzaut zzi;
    public final byte[] zzj;
    public final Stack<zzaqe> zzk;
    public final LinkedList<zzaqq> zzl;
    public int zzm;
    public int zzn;
    public long zzo;
    public int zzp;
    public zzaut zzq;
    public long zzr;
    public long zzs;
    public zzaqr zzt;
    public int zzu;
    public int zzv;
    public int zzw;
    public zzapm zzx;
    public boolean zzy;

    public zzaqs() {
        this(0, (zzaux) null, (zzaqy) null);
    }

    private final void zza() {
        this.zzm = 0;
        this.zzp = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(long r48) throws com.google.android.gms.internal.ads.zzann {
        /*
            r47 = this;
        L_0x0000:
            r0 = r47
            r1 = r0
        L_0x0003:
            java.util.Stack<com.google.android.gms.internal.ads.zzaqe> r2 = r1.zzk
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0608
            java.util.Stack<com.google.android.gms.internal.ads.zzaqe> r2 = r1.zzk
            java.lang.Object r2 = r2.peek()
            com.google.android.gms.internal.ads.zzaqe r2 = (com.google.android.gms.internal.ads.zzaqe) r2
            long r2 = r2.zza
            int r4 = (r2 > r48 ? 1 : (r2 == r48 ? 0 : -1))
            if (r4 != 0) goto L_0x0608
            java.util.Stack<com.google.android.gms.internal.ads.zzaqe> r2 = r1.zzk
            java.lang.Object r2 = r2.pop()
            com.google.android.gms.internal.ads.zzaqe r2 = (com.google.android.gms.internal.ads.zzaqe) r2
            int r3 = r2.zzaR
            int r4 = com.google.android.gms.internal.ads.zzaqg.zzE
            r5 = 12
            r6 = 8
            if (r3 != r4) goto L_0x015e
            java.util.List<com.google.android.gms.internal.ads.zzaqf> r3 = r2.zzb
            com.google.android.gms.internal.ads.zzaph r3 = zzh(r3)
            int r4 = com.google.android.gms.internal.ads.zzaqg.zzP
            com.google.android.gms.internal.ads.zzaqe r4 = r2.zzd(r4)
            android.util.SparseArray r14 = new android.util.SparseArray
            r14.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzaqf> r8 = r4.zzb
            int r8 = r8.size()
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r11 = 0
            r15 = r9
        L_0x0049:
            if (r11 >= r8) goto L_0x00b3
            java.util.List<com.google.android.gms.internal.ads.zzaqf> r9 = r4.zzb
            java.lang.Object r9 = r9.get(r11)
            com.google.android.gms.internal.ads.zzaqf r9 = (com.google.android.gms.internal.ads.zzaqf) r9
            int r10 = r9.zzaR
            int r12 = com.google.android.gms.internal.ads.zzaqg.zzB
            if (r10 != r12) goto L_0x0091
            com.google.android.gms.internal.ads.zzaut r9 = r9.zza
            r9.zzi(r5)
            int r5 = r9.zzr()
            int r10 = r9.zzu()
            int r12 = r9.zzu()
            int r13 = r9.zzu()
            int r9 = r9.zzr()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.ads.zzaqo r7 = new com.google.android.gms.internal.ads.zzaqo
            int r10 = r10 + -1
            r7.<init>(r10, r12, r13, r9)
            android.util.Pair r5 = android.util.Pair.create(r5, r7)
            java.lang.Object r7 = r5.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r5 = r5.second
            com.google.android.gms.internal.ads.zzaqo r5 = (com.google.android.gms.internal.ads.zzaqo) r5
            r14.put(r7, r5)
            goto L_0x00ae
        L_0x0091:
            int r5 = com.google.android.gms.internal.ads.zzaqg.zzQ
            if (r10 != r5) goto L_0x00ae
            com.google.android.gms.internal.ads.zzaut r5 = r9.zza
            r5.zzi(r6)
            int r7 = r5.zzr()
            int r7 = com.google.android.gms.internal.ads.zzaqg.zze(r7)
            if (r7 != 0) goto L_0x00a9
            long r9 = r5.zzp()
            goto L_0x00ad
        L_0x00a9:
            long r9 = r5.zzv()
        L_0x00ad:
            r15 = r9
        L_0x00ae:
            int r11 = r11 + 1
            r5 = 12
            goto L_0x0049
        L_0x00b3:
            android.util.SparseArray r4 = new android.util.SparseArray
            r4.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzaqe> r5 = r2.zzc
            int r5 = r5.size()
            r6 = 0
        L_0x00bf:
            if (r6 >= r5) goto L_0x00e7
            java.util.List<com.google.android.gms.internal.ads.zzaqe> r7 = r2.zzc
            java.lang.Object r7 = r7.get(r6)
            r8 = r7
            com.google.android.gms.internal.ads.zzaqe r8 = (com.google.android.gms.internal.ads.zzaqe) r8
            int r7 = r8.zzaR
            int r9 = com.google.android.gms.internal.ads.zzaqg.zzG
            if (r7 != r9) goto L_0x00e4
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzF
            com.google.android.gms.internal.ads.zzaqf r9 = r2.zzc(r7)
            r13 = 0
            r10 = r15
            r12 = r3
            com.google.android.gms.internal.ads.zzaqy r7 = com.google.android.gms.internal.ads.zzaqn.zza(r8, r9, r10, r12, r13)
            if (r7 == 0) goto L_0x00e4
            int r8 = r7.zza
            r4.put(r8, r7)
        L_0x00e4:
            int r6 = r6 + 1
            goto L_0x00bf
        L_0x00e7:
            int r2 = r4.size()
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaqr> r3 = r1.zzd
            int r3 = r3.size()
            if (r3 != 0) goto L_0x012f
            r3 = 0
        L_0x00f4:
            if (r3 >= r2) goto L_0x0128
            java.lang.Object r5 = r4.valueAt(r3)
            com.google.android.gms.internal.ads.zzaqy r5 = (com.google.android.gms.internal.ads.zzaqy) r5
            com.google.android.gms.internal.ads.zzaqr r6 = new com.google.android.gms.internal.ads.zzaqr
            com.google.android.gms.internal.ads.zzapm r7 = r1.zzx
            int r8 = r5.zzb
            com.google.android.gms.internal.ads.zzapu r7 = r7.zzbn(r3, r8)
            r6.<init>(r7)
            int r7 = r5.zza
            java.lang.Object r7 = r14.get(r7)
            com.google.android.gms.internal.ads.zzaqo r7 = (com.google.android.gms.internal.ads.zzaqo) r7
            r6.zza(r5, r7)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaqr> r7 = r1.zzd
            int r8 = r5.zza
            r7.put(r8, r6)
            long r6 = r1.zzs
            long r8 = r5.zze
            long r5 = java.lang.Math.max(r6, r8)
            r1.zzs = r5
            int r3 = r3 + 1
            goto L_0x00f4
        L_0x0128:
            com.google.android.gms.internal.ads.zzapm r2 = r1.zzx
            r2.zzbo()
            goto L_0x0003
        L_0x012f:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaqr> r3 = r1.zzd
            int r3 = r3.size()
            if (r3 != r2) goto L_0x0139
            r7 = 1
            goto L_0x013a
        L_0x0139:
            r7 = 0
        L_0x013a:
            com.google.android.gms.internal.ads.zzaul.zzd(r7)
            r3 = 0
        L_0x013e:
            if (r3 >= r2) goto L_0x0003
            java.lang.Object r5 = r4.valueAt(r3)
            com.google.android.gms.internal.ads.zzaqy r5 = (com.google.android.gms.internal.ads.zzaqy) r5
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaqr> r6 = r1.zzd
            int r7 = r5.zza
            java.lang.Object r6 = r6.get(r7)
            com.google.android.gms.internal.ads.zzaqr r6 = (com.google.android.gms.internal.ads.zzaqr) r6
            int r7 = r5.zza
            java.lang.Object r7 = r14.get(r7)
            com.google.android.gms.internal.ads.zzaqo r7 = (com.google.android.gms.internal.ads.zzaqo) r7
            r6.zza(r5, r7)
            int r3 = r3 + 1
            goto L_0x013e
        L_0x015e:
            int r4 = com.google.android.gms.internal.ads.zzaqg.zzN
            if (r3 != r4) goto L_0x05f1
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaqr> r3 = r1.zzd
            byte[] r1 = r1.zzj
            java.util.List<com.google.android.gms.internal.ads.zzaqe> r4 = r2.zzc
            int r4 = r4.size()
            r5 = 0
        L_0x016d:
            r7 = 1
            if (r5 >= r4) goto L_0x05c4
            java.util.List<com.google.android.gms.internal.ads.zzaqe> r8 = r2.zzc
            java.lang.Object r8 = r8.get(r5)
            com.google.android.gms.internal.ads.zzaqe r8 = (com.google.android.gms.internal.ads.zzaqe) r8
            int r9 = r8.zzaR
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzO
            if (r9 != r10) goto L_0x05ad
            int r9 = com.google.android.gms.internal.ads.zzaqg.zzA
            com.google.android.gms.internal.ads.zzaqf r9 = r8.zzc(r9)
            com.google.android.gms.internal.ads.zzaut r9 = r9.zza
            r9.zzi(r6)
            int r10 = r9.zzr()
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzf(r10)
            int r11 = r9.zzr()
            java.lang.Object r11 = r3.get(r11)
            com.google.android.gms.internal.ads.zzaqr r11 = (com.google.android.gms.internal.ads.zzaqr) r11
            if (r11 != 0) goto L_0x019f
            r11 = 0
            goto L_0x01e6
        L_0x019f:
            r12 = r10 & 1
            if (r12 == 0) goto L_0x01ad
            long r12 = r9.zzv()
            com.google.android.gms.internal.ads.zzara r14 = r11.zza
            r14.zzb = r12
            r14.zzc = r12
        L_0x01ad:
            com.google.android.gms.internal.ads.zzaqo r12 = r11.zzd
            r13 = r10 & 2
            if (r13 == 0) goto L_0x01ba
            int r13 = r9.zzu()
            int r13 = r13 + -1
            goto L_0x01bc
        L_0x01ba:
            int r13 = r12.zza
        L_0x01bc:
            r14 = r10 & 8
            if (r14 == 0) goto L_0x01c5
            int r14 = r9.zzu()
            goto L_0x01c7
        L_0x01c5:
            int r14 = r12.zzb
        L_0x01c7:
            r15 = r10 & 16
            if (r15 == 0) goto L_0x01d0
            int r15 = r9.zzu()
            goto L_0x01d2
        L_0x01d0:
            int r15 = r12.zzc
        L_0x01d2:
            r10 = r10 & 32
            if (r10 == 0) goto L_0x01db
            int r9 = r9.zzu()
            goto L_0x01dd
        L_0x01db:
            int r9 = r12.zzd
        L_0x01dd:
            com.google.android.gms.internal.ads.zzara r10 = r11.zza
            com.google.android.gms.internal.ads.zzaqo r12 = new com.google.android.gms.internal.ads.zzaqo
            r12.<init>(r13, r14, r15, r9)
            r10.zza = r12
        L_0x01e6:
            if (r11 != 0) goto L_0x01ea
            goto L_0x05ad
        L_0x01ea:
            com.google.android.gms.internal.ads.zzara r9 = r11.zza
            long r12 = r9.zzr
            r11.zzb()
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzz
            com.google.android.gms.internal.ads.zzaqf r10 = r8.zzc(r10)
            if (r10 == 0) goto L_0x0217
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzz
            com.google.android.gms.internal.ads.zzaqf r10 = r8.zzc(r10)
            com.google.android.gms.internal.ads.zzaut r10 = r10.zza
            r10.zzi(r6)
            int r6 = r10.zzr()
            int r6 = com.google.android.gms.internal.ads.zzaqg.zze(r6)
            if (r6 != r7) goto L_0x0213
            long r12 = r10.zzv()
            goto L_0x0217
        L_0x0213:
            long r12 = r10.zzp()
        L_0x0217:
            java.util.List<com.google.android.gms.internal.ads.zzaqf> r6 = r8.zzb
            int r7 = r6.size()
            r10 = 0
            r14 = 0
            r15 = 0
        L_0x0220:
            if (r15 >= r7) goto L_0x024f
            java.lang.Object r16 = r6.get(r15)
            r17 = r3
            r3 = r16
            com.google.android.gms.internal.ads.zzaqf r3 = (com.google.android.gms.internal.ads.zzaqf) r3
            r16 = r4
            int r4 = r3.zzaR
            r18 = r12
            int r12 = com.google.android.gms.internal.ads.zzaqg.zzC
            if (r4 != r12) goto L_0x0246
            com.google.android.gms.internal.ads.zzaut r3 = r3.zza
            r4 = 12
            r3.zzi(r4)
            int r3 = r3.zzu()
            if (r3 <= 0) goto L_0x0246
            int r10 = r10 + r3
            int r14 = r14 + 1
        L_0x0246:
            int r15 = r15 + 1
            r4 = r16
            r3 = r17
            r12 = r18
            goto L_0x0220
        L_0x024f:
            r17 = r3
            r16 = r4
            r18 = r12
            r3 = 0
            r11.zzg = r3
            r11.zzf = r3
            r11.zze = r3
            com.google.android.gms.internal.ads.zzara r3 = r11.zza
            r3.zzd = r14
            r3.zze = r10
            int[] r4 = r3.zzg
            if (r4 == 0) goto L_0x0269
            int r4 = r4.length
            if (r4 >= r14) goto L_0x0271
        L_0x0269:
            long[] r4 = new long[r14]
            r3.zzf = r4
            int[] r4 = new int[r14]
            r3.zzg = r4
        L_0x0271:
            int[] r4 = r3.zzh
            if (r4 == 0) goto L_0x0278
            int r4 = r4.length
            if (r4 >= r10) goto L_0x0290
        L_0x0278:
            int r10 = r10 * 125
            int r10 = r10 / 100
            int[] r4 = new int[r10]
            r3.zzh = r4
            int[] r4 = new int[r10]
            r3.zzi = r4
            long[] r4 = new long[r10]
            r3.zzj = r4
            boolean[] r4 = new boolean[r10]
            r3.zzk = r4
            boolean[] r4 = new boolean[r10]
            r3.zzm = r4
        L_0x0290:
            r3 = 0
            r4 = 0
            r10 = 0
        L_0x0293:
            if (r3 >= r7) goto L_0x03f6
            java.lang.Object r12 = r6.get(r3)
            com.google.android.gms.internal.ads.zzaqf r12 = (com.google.android.gms.internal.ads.zzaqf) r12
            int r13 = r12.zzaR
            int r14 = com.google.android.gms.internal.ads.zzaqg.zzC
            if (r13 != r14) goto L_0x03cc
            int r13 = r10 + 1
            com.google.android.gms.internal.ads.zzaut r12 = r12.zza
            r14 = 8
            r12.zzi(r14)
            int r14 = r12.zzr()
            int r14 = com.google.android.gms.internal.ads.zzaqg.zzf(r14)
            com.google.android.gms.internal.ads.zzaqy r15 = r11.zzc
            r20 = r6
            com.google.android.gms.internal.ads.zzara r6 = r11.zza
            r21 = r7
            com.google.android.gms.internal.ads.zzaqo r7 = r6.zza
            r22 = r13
            int[] r13 = r6.zzg
            int r23 = r12.zzu()
            r13[r10] = r23
            long[] r13 = r6.zzf
            r23 = r1
            long r0 = r6.zzb
            r13[r10] = r0
            r24 = r14 & 1
            if (r24 == 0) goto L_0x02e1
            r24 = r2
            int r2 = r12.zzr()
            r25 = r8
            r26 = r9
            long r8 = (long) r2
            long r0 = r0 + r8
            r13[r10] = r0
            goto L_0x02e7
        L_0x02e1:
            r24 = r2
            r25 = r8
            r26 = r9
        L_0x02e7:
            r0 = r14 & 4
            int r1 = r7.zzd
            if (r0 == 0) goto L_0x02f1
            int r1 = r12.zzu()
        L_0x02f1:
            r2 = r14 & 256(0x100, float:3.59E-43)
            r8 = r14 & 512(0x200, float:7.175E-43)
            r9 = r14 & 1024(0x400, float:1.435E-42)
            r13 = r14 & 2048(0x800, float:2.87E-42)
            long[] r14 = r15.zzi
            if (r14 == 0) goto L_0x031e
            r27 = r1
            int r1 = r14.length
            r28 = r5
            r5 = 1
            if (r1 != r5) goto L_0x0322
            r1 = 0
            r29 = r14[r1]
            r31 = 0
            int r5 = (r29 > r31 ? 1 : (r29 == r31 ? 0 : -1))
            if (r5 != 0) goto L_0x0322
            long[] r5 = r15.zzj
            r29 = r5[r1]
            r31 = 1000(0x3e8, double:4.94E-321)
            r1 = r13
            long r13 = r15.zzc
            r33 = r13
            long r13 = com.google.android.gms.internal.ads.zzava.zzj(r29, r31, r33)
            goto L_0x0325
        L_0x031e:
            r27 = r1
            r28 = r5
        L_0x0322:
            r1 = r13
            r13 = 0
        L_0x0325:
            int[] r5 = r6.zzh
            r29 = r11
            int[] r11 = r6.zzi
            r30 = r3
            long[] r3 = r6.zzj
            r31 = r5
            boolean[] r5 = r6.zzk
            r32 = r5
            int[] r5 = r6.zzg
            r5 = r5[r10]
            int r5 = r5 + r4
            r39 = r3
            r33 = r4
            long r3 = r15.zzc
            r40 = r13
            if (r10 <= 0) goto L_0x0347
            long r13 = r6.zzr
            goto L_0x0349
        L_0x0347:
            r13 = r18
        L_0x0349:
            r10 = r33
        L_0x034b:
            if (r10 >= r5) goto L_0x03c6
            if (r2 == 0) goto L_0x0354
            int r15 = r12.zzu()
            goto L_0x0356
        L_0x0354:
            int r15 = r7.zzb
        L_0x0356:
            if (r8 == 0) goto L_0x0361
            int r33 = r12.zzu()
            r42 = r2
            r2 = r33
            goto L_0x0365
        L_0x0361:
            r42 = r2
            int r2 = r7.zzc
        L_0x0365:
            if (r10 != 0) goto L_0x036f
            r10 = 0
            if (r0 == 0) goto L_0x036f
            r43 = r0
            r0 = r27
            goto L_0x037e
        L_0x036f:
            if (r9 == 0) goto L_0x037a
            int r33 = r12.zzr()
            r43 = r0
            r0 = r33
            goto L_0x037e
        L_0x037a:
            r43 = r0
            int r0 = r7.zzd
        L_0x037e:
            if (r1 == 0) goto L_0x0392
            r44 = r1
            int r1 = r12.zzr()
            int r1 = r1 * 1000
            r45 = r7
            r46 = r8
            long r7 = (long) r1
            long r7 = r7 / r3
            int r1 = (int) r7
            r11[r10] = r1
            goto L_0x039b
        L_0x0392:
            r44 = r1
            r45 = r7
            r46 = r8
            r1 = 0
            r11[r10] = r1
        L_0x039b:
            r35 = 1000(0x3e8, double:4.94E-321)
            r33 = r13
            r37 = r3
            long r7 = com.google.android.gms.internal.ads.zzava.zzj(r33, r35, r37)
            long r7 = r7 - r40
            r39[r10] = r7
            r31[r10] = r2
            int r0 = r0 >> 16
            r1 = 1
            r0 = r0 & r1
            r0 = r0 ^ r1
            if (r1 == r0) goto L_0x03b4
            r0 = 0
            goto L_0x03b5
        L_0x03b4:
            r0 = 1
        L_0x03b5:
            r32[r10] = r0
            long r0 = (long) r15
            long r13 = r13 + r0
            int r10 = r10 + 1
            r2 = r42
            r0 = r43
            r1 = r44
            r7 = r45
            r8 = r46
            goto L_0x034b
        L_0x03c6:
            r6.zzr = r13
            r4 = r5
            r10 = r22
            goto L_0x03e0
        L_0x03cc:
            r23 = r1
            r24 = r2
            r30 = r3
            r33 = r4
            r28 = r5
            r20 = r6
            r21 = r7
            r25 = r8
            r26 = r9
            r29 = r11
        L_0x03e0:
            int r3 = r30 + 1
            r0 = r47
            r6 = r20
            r7 = r21
            r1 = r23
            r2 = r24
            r8 = r25
            r9 = r26
            r5 = r28
            r11 = r29
            goto L_0x0293
        L_0x03f6:
            r23 = r1
            r24 = r2
            r28 = r5
            r25 = r8
            r26 = r9
            r29 = r11
            int r0 = com.google.android.gms.internal.ads.zzaqg.zzaf
            com.google.android.gms.internal.ads.zzaqf r0 = r8.zzc(r0)
            if (r0 == 0) goto L_0x0474
            r11 = r29
            com.google.android.gms.internal.ads.zzaqy r1 = r11.zzc
            com.google.android.gms.internal.ads.zzaqz[] r1 = r1.zzh
            r2 = r26
            com.google.android.gms.internal.ads.zzaqo r3 = r2.zza
            int r3 = r3.zza
            r1 = r1[r3]
            com.google.android.gms.internal.ads.zzaut r0 = r0.zza
            int r1 = r1.zza
            r3 = 8
            r0.zzi(r3)
            int r4 = r0.zzr()
            int r4 = com.google.android.gms.internal.ads.zzaqg.zzf(r4)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0430
            r0.zzj(r3)
        L_0x0430:
            int r3 = r0.zzl()
            int r4 = r0.zzu()
            int r5 = r2.zze
            if (r4 != r5) goto L_0x0464
            if (r3 != 0) goto L_0x0453
            boolean[] r3 = r2.zzm
            r5 = 0
            r6 = 0
        L_0x0442:
            if (r5 >= r4) goto L_0x0460
            int r7 = r0.zzl()
            int r6 = r6 + r7
            if (r7 <= r1) goto L_0x044d
            r7 = 1
            goto L_0x044e
        L_0x044d:
            r7 = 0
        L_0x044e:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x0442
        L_0x0453:
            if (r3 <= r1) goto L_0x0457
            r0 = 1
            goto L_0x0458
        L_0x0457:
            r0 = 0
        L_0x0458:
            int r6 = r3 * r4
            boolean[] r1 = r2.zzm
            r3 = 0
            java.util.Arrays.fill(r1, r3, r4, r0)
        L_0x0460:
            r2.zza(r6)
            goto L_0x0476
        L_0x0464:
            com.google.android.gms.internal.ads.zzann r0 = new com.google.android.gms.internal.ads.zzann
            r1 = 41
            java.lang.String r2 = "Length mismatch: "
            java.lang.String r3 = ", "
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline11(r1, r2, r4, r3, r5)
            r0.<init>(r1)
            throw r0
        L_0x0474:
            r2 = r26
        L_0x0476:
            int r0 = com.google.android.gms.internal.ads.zzaqg.zzag
            com.google.android.gms.internal.ads.zzaqf r0 = r8.zzc(r0)
            if (r0 == 0) goto L_0x04bd
            com.google.android.gms.internal.ads.zzaut r0 = r0.zza
            r1 = 8
            r0.zzi(r1)
            int r3 = r0.zzr()
            int r4 = com.google.android.gms.internal.ads.zzaqg.zzf(r3)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0494
            r0.zzj(r1)
        L_0x0494:
            int r1 = r0.zzu()
            if (r1 != r5) goto L_0x04af
            long r4 = r2.zzc
            int r1 = com.google.android.gms.internal.ads.zzaqg.zze(r3)
            if (r1 != 0) goto L_0x04a7
            long r0 = r0.zzp()
            goto L_0x04ab
        L_0x04a7:
            long r0 = r0.zzv()
        L_0x04ab:
            long r4 = r4 + r0
            r2.zzc = r4
            goto L_0x04bd
        L_0x04af:
            com.google.android.gms.internal.ads.zzann r0 = new com.google.android.gms.internal.ads.zzann
            r2 = 40
            java.lang.String r3 = "Unexpected saio entry count: "
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r2, r3, r1)
            r0.<init>(r1)
            throw r0
        L_0x04bd:
            int r0 = com.google.android.gms.internal.ads.zzaqg.zzak
            com.google.android.gms.internal.ads.zzaqf r0 = r8.zzc(r0)
            if (r0 == 0) goto L_0x04cb
            com.google.android.gms.internal.ads.zzaut r0 = r0.zza
            r1 = 0
            zzc(r0, r1, r2)
        L_0x04cb:
            int r0 = com.google.android.gms.internal.ads.zzaqg.zzah
            com.google.android.gms.internal.ads.zzaqf r0 = r8.zzc(r0)
            int r1 = com.google.android.gms.internal.ads.zzaqg.zzai
            com.google.android.gms.internal.ads.zzaqf r1 = r8.zzc(r1)
            if (r0 == 0) goto L_0x056d
            if (r1 == 0) goto L_0x056d
            com.google.android.gms.internal.ads.zzaut r0 = r0.zza
            com.google.android.gms.internal.ads.zzaut r1 = r1.zza
            r3 = 8
            r0.zzi(r3)
            int r3 = r0.zzr()
            int r4 = r0.zzr()
            int r5 = zzb
            if (r4 == r5) goto L_0x04f2
            goto L_0x056d
        L_0x04f2:
            int r3 = com.google.android.gms.internal.ads.zzaqg.zze(r3)
            r4 = 4
            r5 = 1
            if (r3 != r5) goto L_0x04fd
            r0.zzj(r4)
        L_0x04fd:
            int r0 = r0.zzr()
            if (r0 != r5) goto L_0x0565
            r0 = 8
            r1.zzi(r0)
            int r0 = r1.zzr()
            int r3 = r1.zzr()
            int r6 = zzb
            if (r3 != r6) goto L_0x056d
            int r0 = com.google.android.gms.internal.ads.zzaqg.zze(r0)
            r3 = 2
            if (r0 != r5) goto L_0x052e
            long r4 = r1.zzp()
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0526
            goto L_0x0533
        L_0x0526:
            com.google.android.gms.internal.ads.zzann r0 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r1 = "Variable length decription in sgpd found (unsupported)"
            r0.<init>(r1)
            throw r0
        L_0x052e:
            if (r0 < r3) goto L_0x0533
            r1.zzj(r4)
        L_0x0533:
            long r4 = r1.zzp()
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x055d
            r1.zzj(r3)
            int r0 = r1.zzl()
            r3 = 1
            if (r0 != r3) goto L_0x056d
            int r0 = r1.zzl()
            r4 = 16
            byte[] r5 = new byte[r4]
            r6 = 0
            r1.zzk(r5, r6, r4)
            r2.zzl = r3
            com.google.android.gms.internal.ads.zzaqz r1 = new com.google.android.gms.internal.ads.zzaqz
            r1.<init>(r3, r0, r5)
            r2.zzn = r1
            goto L_0x056d
        L_0x055d:
            com.google.android.gms.internal.ads.zzann r0 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x0565:
            com.google.android.gms.internal.ads.zzann r0 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r1 = "Entry count in sbgp != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x056d:
            java.util.List<com.google.android.gms.internal.ads.zzaqf> r0 = r8.zzb
            int r0 = r0.size()
            r1 = 0
        L_0x0574:
            if (r1 >= r0) goto L_0x05a6
            java.util.List<com.google.android.gms.internal.ads.zzaqf> r3 = r8.zzb
            java.lang.Object r3 = r3.get(r1)
            com.google.android.gms.internal.ads.zzaqf r3 = (com.google.android.gms.internal.ads.zzaqf) r3
            int r4 = r3.zzaR
            int r5 = com.google.android.gms.internal.ads.zzaqg.zzaj
            if (r4 != r5) goto L_0x059f
            com.google.android.gms.internal.ads.zzaut r3 = r3.zza
            r4 = 8
            r3.zzi(r4)
            r4 = 16
            r5 = 0
            r7 = r23
            r3.zzk(r7, r5, r4)
            byte[] r5 = zzc
            boolean r5 = java.util.Arrays.equals(r7, r5)
            if (r5 == 0) goto L_0x05a1
            zzc(r3, r4, r2)
            goto L_0x05a1
        L_0x059f:
            r7 = r23
        L_0x05a1:
            int r1 = r1 + 1
            r23 = r7
            goto L_0x0574
        L_0x05a6:
            r7 = r23
            r0 = 8
            r6 = 8
            goto L_0x05b6
        L_0x05ad:
            r7 = r1
            r24 = r2
            r17 = r3
            r16 = r4
            r28 = r5
        L_0x05b6:
            int r5 = r28 + 1
            r0 = 1
            r0 = r47
            r1 = r7
            r4 = r16
            r3 = r17
            r2 = r24
            goto L_0x016d
        L_0x05c4:
            java.util.List<com.google.android.gms.internal.ads.zzaqf> r0 = r2.zzb
            com.google.android.gms.internal.ads.zzaph r0 = zzh(r0)
            if (r0 == 0) goto L_0x0000
            r3 = r47
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaqr> r1 = r3.zzd
            int r1 = r1.size()
            r2 = 0
        L_0x05d5:
            if (r2 >= r1) goto L_0x05ef
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaqr> r4 = r3.zzd
            java.lang.Object r4 = r4.valueAt(r2)
            com.google.android.gms.internal.ads.zzaqr r4 = (com.google.android.gms.internal.ads.zzaqr) r4
            com.google.android.gms.internal.ads.zzapu r5 = r4.zzb
            com.google.android.gms.internal.ads.zzaqy r4 = r4.zzc
            com.google.android.gms.internal.ads.zzank r4 = r4.zzf
            com.google.android.gms.internal.ads.zzank r4 = r4.zzi(r0)
            r5.zza(r4)
            int r2 = r2 + 1
            goto L_0x05d5
        L_0x05ef:
            r1 = r3
            goto L_0x0605
        L_0x05f1:
            r3 = r0
            java.util.Stack<com.google.android.gms.internal.ads.zzaqe> r0 = r1.zzk
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0605
            java.util.Stack<com.google.android.gms.internal.ads.zzaqe> r0 = r1.zzk
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzaqe r0 = (com.google.android.gms.internal.ads.zzaqe) r0
            r0.zzb(r2)
        L_0x0605:
            r0 = r3
            goto L_0x0003
        L_0x0608:
            r3 = r0
            r47.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqs.zzb(long):void");
    }

    public static void zzc(zzaut zzaut, int i, zzara zzara) throws zzann {
        zzaut.zzi(i + 8);
        int zzf2 = zzaqg.zzf(zzaut.zzr());
        if ((zzf2 & 1) == 0) {
            boolean z = (zzf2 & 2) != 0;
            int zzu2 = zzaut.zzu();
            int i2 = zzara.zze;
            if (zzu2 == i2) {
                Arrays.fill(zzara.zzm, 0, zzu2, z);
                zzara.zza(zzaut.zzd());
                zzaut.zzk(zzara.zzp.zza, 0, zzara.zzo);
                zzara.zzp.zzi(0);
                zzara.zzq = false;
                return;
            }
            throw new zzann(GeneratedOutlineSupport.outline11(41, "Length mismatch: ", zzu2, RESTClient.COMMA_SEPARATOR, i2));
        }
        throw new zzann("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaph zzh(java.util.List<com.google.android.gms.internal.ads.zzaqf> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r2
        L_0x0008:
            if (r3 >= r0) goto L_0x00aa
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzaqf r5 = (com.google.android.gms.internal.ads.zzaqf) r5
            int r6 = r5.zzaR
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzX
            if (r6 != r7) goto L_0x00a6
            if (r4 != 0) goto L_0x001d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001d:
            com.google.android.gms.internal.ads.zzaut r5 = r5.zza
            byte[] r5 = r5.zza
            com.google.android.gms.internal.ads.zzaut r6 = new com.google.android.gms.internal.ads.zzaut
            r6.<init>((byte[]) r5)
            int r7 = r6.zze()
            r8 = 32
            if (r7 >= r8) goto L_0x002f
            goto L_0x007f
        L_0x002f:
            r6.zzi(r1)
            int r7 = r6.zzr()
            int r8 = r6.zzd()
            int r8 = r8 + 4
            if (r7 == r8) goto L_0x003f
            goto L_0x007f
        L_0x003f:
            int r7 = r6.zzr()
            int r8 = com.google.android.gms.internal.ads.zzaqg.zzX
            if (r7 == r8) goto L_0x0048
            goto L_0x007f
        L_0x0048:
            int r7 = r6.zzr()
            int r7 = com.google.android.gms.internal.ads.zzaqg.zze(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x005d
            r6 = 37
            java.lang.String r8 = "Unsupported pssh version: "
            java.lang.String r9 = "PsshAtomUtil"
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r6, r8, r7, r9)
            goto L_0x007f
        L_0x005d:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.zzs()
            long r12 = r6.zzs()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x0075
            int r7 = r6.zzu()
            int r7 = r7 * 16
            r6.zzj(r7)
        L_0x0075:
            int r7 = r6.zzu()
            int r8 = r6.zzd()
            if (r7 == r8) goto L_0x0081
        L_0x007f:
            r6 = r2
            goto L_0x008a
        L_0x0081:
            byte[] r8 = new byte[r7]
            r6.zzk(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L_0x008a:
            if (r6 != 0) goto L_0x008e
            r6 = r2
            goto L_0x0092
        L_0x008e:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L_0x0092:
            if (r6 != 0) goto L_0x009c
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto L_0x00a6
        L_0x009c:
            com.google.android.gms.internal.ads.zzapg r7 = new com.google.android.gms.internal.ads.zzapg
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5, r1)
            r4.add(r7)
        L_0x00a6:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x00aa:
            if (r4 != 0) goto L_0x00ad
            return r2
        L_0x00ad:
            com.google.android.gms.internal.ads.zzaph r14 = new com.google.android.gms.internal.ads.zzaph
            r14.<init>((java.util.List<com.google.android.gms.internal.ads.zzapg>) r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqs.zzh(java.util.List):com.google.android.gms.internal.ads.zzaph");
    }

    public final void zzd(zzapm zzapm) {
        this.zzx = zzapm;
    }

    public final void zze(long j, long j2) {
        int size = this.zzd.size();
        for (int i = 0; i < size; i++) {
            this.zzd.valueAt(i).zzb();
        }
        this.zzl.clear();
        this.zzk.clear();
        zza();
    }

    public final boolean zzf(zzapk zzapk) throws IOException, InterruptedException {
        return zzaqx.zza(zzapk);
    }

    public final int zzg(zzapk zzapk, zzapq zzapq) throws IOException, InterruptedException {
        long j;
        long j2;
        zzapt zzapt;
        zzaqz zzaqz;
        zzapt zzapt2;
        int i;
        zzapk zzapk2 = zzapk;
        while (true) {
            int i2 = this.zzm;
            int i3 = 0;
            if (i2 == 0) {
                if (this.zzp == 0) {
                    if (!zzapk2.zzb(this.zzi.zza, 0, 8, true)) {
                        return -1;
                    }
                    this.zzp = 8;
                    this.zzi.zzi(0);
                    this.zzo = this.zzi.zzp();
                    this.zzn = this.zzi.zzr();
                }
                long j3 = this.zzo;
                if (j3 == 1) {
                    zzapk2.zzb(this.zzi.zza, 8, 8, false);
                    this.zzp += 8;
                    j3 = this.zzi.zzv();
                    this.zzo = j3;
                }
                if (j3 >= ((long) this.zzp)) {
                    long zzh2 = zzapk.zzh() - ((long) this.zzp);
                    if (this.zzn == zzaqg.zzN) {
                        int size = this.zzd.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            zzara zzara = this.zzd.valueAt(i4).zza;
                            zzara.zzc = zzh2;
                            zzara.zzb = zzh2;
                        }
                    }
                    int i5 = this.zzn;
                    if (i5 == zzaqg.zzk) {
                        this.zzt = null;
                        this.zzr = zzh2 + this.zzo;
                        if (!this.zzy) {
                            this.zzx.zzc(new zzapr(this.zzs));
                            this.zzy = true;
                        }
                        this.zzm = 2;
                    } else if (i5 == zzaqg.zzE || i5 == zzaqg.zzG || i5 == zzaqg.zzH || i5 == zzaqg.zzI || i5 == zzaqg.zzJ || i5 == zzaqg.zzN || i5 == zzaqg.zzO || i5 == zzaqg.zzP || i5 == zzaqg.zzS) {
                        long zzh3 = (zzapk.zzh() + this.zzo) - 8;
                        this.zzk.add(new zzaqe(this.zzn, zzh3));
                        if (this.zzo == ((long) this.zzp)) {
                            zzb(zzh3);
                        } else {
                            zza();
                        }
                    } else if (i5 == zzaqg.zzV || i5 == zzaqg.zzU || i5 == zzaqg.zzF || i5 == zzaqg.zzD || i5 == zzaqg.zzW || i5 == zzaqg.zzz || i5 == zzaqg.zzA || i5 == zzaqg.zzR || i5 == zzaqg.zzB || i5 == zzaqg.zzC || i5 == zzaqg.zzX || i5 == zzaqg.zzaf || i5 == zzaqg.zzag || i5 == zzaqg.zzak || i5 == zzaqg.zzaj || i5 == zzaqg.zzah || i5 == zzaqg.zzai || i5 == zzaqg.zzT || i5 == zzaqg.zzQ || i5 == zzaqg.zzaI) {
                        if (this.zzp == 8) {
                            long j4 = this.zzo;
                            if (j4 <= 2147483647L) {
                                zzaut zzaut = new zzaut((int) j4);
                                this.zzq = zzaut;
                                System.arraycopy(this.zzi.zza, 0, zzaut.zza, 0, 8);
                                this.zzm = 1;
                            } else {
                                throw new zzann("Leaf atom with length > 2147483647 (unsupported).");
                            }
                        } else {
                            throw new zzann("Leaf atom defines extended atom size (unsupported).");
                        }
                    } else if (this.zzo <= 2147483647L) {
                        this.zzq = null;
                        this.zzm = 1;
                    } else {
                        throw new zzann("Skipping atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new zzann("Atom size less than header length (unsupported).");
                }
            } else if (i2 != 1) {
                long j5 = RecyclerView.FOREVER_NS;
                if (i2 != 2) {
                    if (i2 == 3) {
                        if (this.zzt != null) {
                            break;
                        }
                        SparseArray<zzaqr> sparseArray = this.zzd;
                        int size2 = sparseArray.size();
                        zzaqr zzaqr = null;
                        for (int i6 = 0; i6 < size2; i6++) {
                            zzaqr valueAt = sparseArray.valueAt(i6);
                            int i7 = valueAt.zzg;
                            zzara zzara2 = valueAt.zza;
                            if (i7 != zzara2.zzd) {
                                long j6 = zzara2.zzf[i7];
                                if (j6 < j5) {
                                    zzaqr = valueAt;
                                    j5 = j6;
                                }
                            }
                        }
                        if (zzaqr == null) {
                            int zzh4 = (int) (this.zzr - zzapk.zzh());
                            if (zzh4 >= 0) {
                                zzapk2.zzd(zzh4, false);
                                zza();
                            } else {
                                throw new zzann("Offset to end of mdat was negative.");
                            }
                        } else {
                            int zzh5 = (int) (zzaqr.zza.zzf[zzaqr.zzg] - zzapk.zzh());
                            if (zzh5 < 0) {
                                Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                zzh5 = 0;
                            }
                            zzapk2.zzd(zzh5, false);
                            this.zzt = zzaqr;
                        }
                    } else {
                        break;
                    }
                } else {
                    int size3 = this.zzd.size();
                    zzaqr zzaqr2 = null;
                    for (int i8 = 0; i8 < size3; i8++) {
                        zzara zzara3 = this.zzd.valueAt(i8).zza;
                        if (zzara3.zzq) {
                            long j7 = zzara3.zzc;
                            if (j7 < j5) {
                                zzaqr2 = this.zzd.valueAt(i8);
                                j5 = j7;
                            }
                        }
                    }
                    if (zzaqr2 == null) {
                        this.zzm = 3;
                    } else {
                        int zzh6 = (int) (j5 - zzapk.zzh());
                        if (zzh6 >= 0) {
                            zzapk2.zzd(zzh6, false);
                            zzara zzara4 = zzaqr2.zza;
                            zzapk2.zzb(zzara4.zzp.zza, 0, zzara4.zzo, false);
                            zzara4.zzp.zzi(0);
                            zzara4.zzq = false;
                        } else {
                            throw new zzann("Offset to encryption data was negative.");
                        }
                    }
                }
            } else {
                int i9 = ((int) this.zzo) - this.zzp;
                zzaut zzaut2 = this.zzq;
                if (zzaut2 != null) {
                    zzapk2.zzb(zzaut2.zza, 8, i9, false);
                    zzaqf zzaqf = new zzaqf(this.zzn, this.zzq);
                    long zzh7 = zzapk.zzh();
                    if (!this.zzk.isEmpty()) {
                        this.zzk.peek().zza(zzaqf);
                    } else if (zzaqf.zzaR == zzaqg.zzD) {
                        zzaut zzaut3 = zzaqf.zza;
                        zzaut3.zzi(8);
                        int zzr2 = zzaut3.zzr();
                        zzaut3.zzj(4);
                        long zzp2 = zzaut3.zzp();
                        if (zzaqg.zze(zzr2) == 0) {
                            j2 = zzaut3.zzp();
                            j = zzaut3.zzp();
                        } else {
                            j2 = zzaut3.zzv();
                            j = zzaut3.zzv();
                        }
                        long j8 = j + zzh7;
                        long j9 = j2;
                        long j10 = j8;
                        long zzj2 = zzava.zzj(j9, 1000000, zzp2);
                        zzaut3.zzj(2);
                        int zzm2 = zzaut3.zzm();
                        int[] iArr = new int[zzm2];
                        long[] jArr = new long[zzm2];
                        long[] jArr2 = new long[zzm2];
                        long[] jArr3 = new long[zzm2];
                        long j11 = zzj2;
                        while (i3 < zzm2) {
                            int zzr3 = zzaut3.zzr();
                            if ((zzr3 & Integer.MIN_VALUE) == 0) {
                                long zzp3 = zzaut3.zzp();
                                iArr[i3] = zzr3 & Integer.MAX_VALUE;
                                jArr[i3] = j10;
                                jArr3[i3] = j11;
                                long j12 = j9 + zzp3;
                                int i10 = zzm2;
                                long[] jArr4 = jArr2;
                                long[] jArr5 = jArr3;
                                j11 = zzava.zzj(j12, 1000000, zzp2);
                                jArr4[i3] = j11 - jArr5[i3];
                                zzaut3.zzj(4);
                                j10 += (long) iArr[i3];
                                i3++;
                                jArr3 = jArr5;
                                jArr2 = jArr4;
                                jArr = jArr;
                                zzm2 = i10;
                                j9 = j12;
                            } else {
                                throw new zzann("Unhandled indirect reference");
                            }
                        }
                        Pair create = Pair.create(Long.valueOf(zzj2), new zzapj(iArr, jArr, jArr2, jArr3));
                        ((Long) create.first).longValue();
                        this.zzx.zzc((zzaps) create.second);
                        this.zzy = true;
                    }
                } else {
                    zzapk2.zzd(i9, false);
                }
                zzb(zzapk.zzh());
            }
        }
        zzaqr zzaqr3 = this.zzt;
        zzara zzara5 = zzaqr3.zza;
        int[] iArr2 = zzara5.zzh;
        int i11 = zzaqr3.zze;
        int i12 = iArr2[i11];
        this.zzu = i12;
        if (zzara5.zzl) {
            zzaut zzaut4 = zzara5.zzp;
            int i13 = zzara5.zza.zza;
            zzaqz zzaqz2 = zzara5.zzn;
            if (zzaqz2 == null) {
                zzaqz2 = zzaqr3.zzc.zzh[i13];
            }
            int i14 = zzaqz2.zza;
            boolean z = zzara5.zzm[i11];
            zzaut zzaut5 = this.zzh;
            zzaut5.zza[0] = (byte) ((true != z ? 0 : 128) | i14);
            zzaut5.zzi(0);
            zzapu zzapu = zzaqr3.zzb;
            zzapu.zzb(this.zzh, 1);
            zzapu.zzb(zzaut4, i14);
            if (!z) {
                i = i14 + 1;
            } else {
                int zzm3 = zzaut4.zzm();
                zzaut4.zzj(-2);
                int i15 = (zzm3 * 6) + 2;
                zzapu.zzb(zzaut4, i15);
                i = i14 + 1 + i15;
            }
            this.zzv = i;
            i12 = this.zzu + i;
            this.zzu = i12;
        } else {
            this.zzv = 0;
        }
        if (this.zzt.zzc.zzg == 1) {
            this.zzu = i12 - 8;
            zzapk2.zzd(8, false);
        }
        this.zzm = 4;
        this.zzw = 0;
        zzaqr zzaqr4 = this.zzt;
        zzara zzara6 = zzaqr4.zza;
        zzaqy zzaqy = zzaqr4.zzc;
        zzapu zzapu2 = zzaqr4.zzb;
        int i16 = zzaqr4.zze;
        int i17 = zzaqy.zzk;
        if (i17 == 0) {
            while (true) {
                int i18 = this.zzv;
                int i19 = this.zzu;
                if (i18 >= i19) {
                    break;
                }
                this.zzv += zzapu2.zzd(zzapk2, i19 - i18, false);
            }
        } else {
            byte[] bArr = this.zzf.zza;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i20 = i17 + 1;
            int i21 = 4 - i17;
            while (this.zzv < this.zzu) {
                int i22 = this.zzw;
                if (i22 == 0) {
                    zzapk2.zzb(bArr, i21, i20, false);
                    this.zzf.zzi(0);
                    this.zzw = this.zzf.zzu() - 1;
                    this.zze.zzi(0);
                    zzapu2.zzb(this.zze, 4);
                    zzapu2.zzb(this.zzf, 1);
                    this.zzv += 5;
                    this.zzu += i21;
                } else {
                    int zzd2 = zzapu2.zzd(zzapk2, i22, false);
                    this.zzv += zzd2;
                    this.zzw -= zzd2;
                }
            }
        }
        long j13 = (zzara6.zzj[i16] + ((long) zzara6.zzi[i16])) * 1000;
        boolean z2 = zzara6.zzl;
        boolean z3 = (true != z2 ? (char) 0 : 0) | zzara6.zzk[i16];
        if (z2) {
            zzaqz = zzara6.zzn;
            if (zzaqz == null) {
                zzaqz = zzaqy.zzh[zzara6.zza.zza];
            }
            zzaqr zzaqr5 = this.zzt;
            if (zzaqz != zzaqr5.zzi) {
                zzapt2 = new zzapt(1, zzaqz.zzb);
            } else {
                zzapt2 = zzaqr5.zzh;
            }
            zzapt = zzapt2;
        } else {
            zzaqz = null;
            zzapt = null;
        }
        zzaqr zzaqr6 = this.zzt;
        zzaqr6.zzh = zzapt;
        zzaqr6.zzi = zzaqz;
        zzapu2.zzc(j13, z3 ? 1 : 0, this.zzu, 0, zzapt);
        if (this.zzl.isEmpty()) {
            zzaqr zzaqr7 = this.zzt;
            zzaqr7.zze++;
            int i23 = zzaqr7.zzf + 1;
            zzaqr7.zzf = i23;
            int[] iArr3 = zzara6.zzg;
            int i24 = zzaqr7.zzg;
            if (i23 == iArr3[i24]) {
                zzaqr7.zzg = i24 + 1;
                zzaqr7.zzf = 0;
                this.zzt = null;
            }
            this.zzm = 3;
            return 0;
        }
        int i25 = this.zzl.removeFirst().zzb;
        throw null;
    }

    public zzaqs(int i, zzaux zzaux, zzaqy zzaqy) {
        this.zzi = new zzaut(16);
        this.zze = new zzaut(zzaur.zza);
        this.zzf = new zzaut(5);
        this.zzg = new zzaut();
        this.zzh = new zzaut(1);
        this.zzj = new byte[16];
        this.zzk = new Stack<>();
        this.zzl = new LinkedList<>();
        this.zzd = new SparseArray<>();
        this.zzs = -9223372036854775807L;
        zza();
    }
}
