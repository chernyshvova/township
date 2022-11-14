package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaqn {
    public static final int zza = zzava.zzl("vide");
    public static final int zzb = zzava.zzl("soun");
    public static final int zzc = zzava.zzl("text");
    public static final int zzd = zzava.zzl("sbtl");
    public static final int zze = zzava.zzl("subt");
    public static final int zzf = zzava.zzl("clcp");
    public static final int zzg = zzava.zzl("cenc");
    public static final int zzh = zzava.zzl("meta");

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v11, resolved type: byte[]} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0570: MOVE  (r6v19 java.lang.String) = (r44v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x07ea  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x083c  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0845 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x0846  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01c3  */
    public static com.google.android.gms.internal.ads.zzaqy zza(com.google.android.gms.internal.ads.zzaqe r51, com.google.android.gms.internal.ads.zzaqf r52, long r53, com.google.android.gms.internal.ads.zzaph r55, boolean r56) throws com.google.android.gms.internal.ads.zzann {
        /*
            r0 = r51
            r15 = r55
            int r1 = com.google.android.gms.internal.ads.zzaqg.zzH
            com.google.android.gms.internal.ads.zzaqe r1 = r0.zzd(r1)
            int r2 = com.google.android.gms.internal.ads.zzaqg.zzV
            com.google.android.gms.internal.ads.zzaqf r2 = r1.zzc(r2)
            com.google.android.gms.internal.ads.zzaut r2 = r2.zza
            r14 = 16
            r2.zzi(r14)
            int r2 = r2.zzr()
            int r3 = zzb
            r4 = 4
            r12 = 3
            r11 = -1
            if (r2 != r3) goto L_0x0024
            r10 = 1
            goto L_0x0044
        L_0x0024:
            int r3 = zza
            if (r2 != r3) goto L_0x002a
            r10 = 2
            goto L_0x0044
        L_0x002a:
            int r3 = zzc
            if (r2 == r3) goto L_0x0043
            int r3 = zzd
            if (r2 == r3) goto L_0x0043
            int r3 = zze
            if (r2 == r3) goto L_0x0043
            int r3 = zzf
            if (r2 != r3) goto L_0x003b
            goto L_0x0043
        L_0x003b:
            int r3 = zzh
            if (r2 != r3) goto L_0x0041
            r10 = 4
            goto L_0x0044
        L_0x0041:
            r10 = -1
            goto L_0x0044
        L_0x0043:
            r10 = 3
        L_0x0044:
            r8 = 0
            if (r10 != r11) goto L_0x0048
            return r8
        L_0x0048:
            int r2 = com.google.android.gms.internal.ads.zzaqg.zzR
            com.google.android.gms.internal.ads.zzaqf r2 = r0.zzc(r2)
            com.google.android.gms.internal.ads.zzaut r2 = r2.zza
            r7 = 8
            r2.zzi(r7)
            int r3 = r2.zzr()
            int r3 = com.google.android.gms.internal.ads.zzaqg.zze(r3)
            if (r3 != 0) goto L_0x0062
            r5 = 8
            goto L_0x0064
        L_0x0062:
            r5 = 16
        L_0x0064:
            r2.zzj(r5)
            int r5 = r2.zzr()
            r2.zzj(r4)
            int r6 = r2.zzg()
            if (r3 != 0) goto L_0x0076
            r13 = 4
            goto L_0x0078
        L_0x0076:
            r13 = 8
        L_0x0078:
            r9 = 0
        L_0x0079:
            r19 = 0
            r21 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r9 >= r13) goto L_0x009e
            byte[] r8 = r2.zza
            int r24 = r6 + r9
            byte r8 = r8[r24]
            if (r8 == r11) goto L_0x009a
            if (r3 != 0) goto L_0x0091
            long r8 = r2.zzp()
            goto L_0x0095
        L_0x0091:
            long r8 = r2.zzv()
        L_0x0095:
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x00a3
            goto L_0x00a1
        L_0x009a:
            int r9 = r9 + 1
            r8 = 0
            goto L_0x0079
        L_0x009e:
            r2.zzj(r13)
        L_0x00a1:
            r8 = r21
        L_0x00a3:
            r2.zzj(r14)
            int r3 = r2.zzr()
            int r6 = r2.zzr()
            r2.zzj(r4)
            int r13 = r2.zzr()
            int r2 = r2.zzr()
            r4 = 65536(0x10000, float:9.18355E-41)
            r14 = -65536(0xffffffffffff0000, float:NaN)
            if (r3 != 0) goto L_0x00d3
            if (r6 != r4) goto L_0x00d2
            if (r13 != r14) goto L_0x00ce
            if (r2 != 0) goto L_0x00c8
            r2 = 90
            goto L_0x00f3
        L_0x00c8:
            r3 = 0
            r6 = 65536(0x10000, float:9.18355E-41)
            r13 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x00d3
        L_0x00ce:
            r3 = 0
            r6 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00d3
        L_0x00d2:
            r3 = 0
        L_0x00d3:
            if (r3 != 0) goto L_0x00e6
            if (r6 != r14) goto L_0x00e3
            if (r13 != r4) goto L_0x00de
            if (r2 != 0) goto L_0x00df
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x00f3
        L_0x00de:
            r4 = r13
        L_0x00df:
            r3 = 0
            r6 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x00e7
        L_0x00e3:
            r4 = r13
            r3 = 0
            goto L_0x00e7
        L_0x00e6:
            r4 = r13
        L_0x00e7:
            if (r3 != r14) goto L_0x00f2
            if (r6 != 0) goto L_0x00f2
            if (r4 != 0) goto L_0x00f2
            if (r2 != r14) goto L_0x00f2
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x00f3
        L_0x00f2:
            r2 = 0
        L_0x00f3:
            com.google.android.gms.internal.ads.zzaqm r14 = new com.google.android.gms.internal.ads.zzaqm
            r14.<init>(r5, r8, r2)
            int r2 = (r53 > r21 ? 1 : (r53 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x0105
            long r2 = r14.zzb
            r26 = r2
            r2 = r52
            goto L_0x0109
        L_0x0105:
            r2 = r52
            r26 = r53
        L_0x0109:
            com.google.android.gms.internal.ads.zzaut r2 = r2.zza
            r2.zzi(r7)
            int r3 = r2.zzr()
            int r3 = com.google.android.gms.internal.ads.zzaqg.zze(r3)
            if (r3 != 0) goto L_0x011b
            r3 = 8
            goto L_0x011d
        L_0x011b:
            r3 = 16
        L_0x011d:
            r2.zzj(r3)
            long r32 = r2.zzp()
            int r2 = (r26 > r21 ? 1 : (r26 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x012b
            r26 = r21
            goto L_0x0136
        L_0x012b:
            r28 = 1000000(0xf4240, double:4.940656E-318)
            r30 = r32
            long r2 = com.google.android.gms.internal.ads.zzava.zzj(r26, r28, r30)
            r26 = r2
        L_0x0136:
            int r2 = com.google.android.gms.internal.ads.zzaqg.zzI
            com.google.android.gms.internal.ads.zzaqe r2 = r1.zzd(r2)
            int r3 = com.google.android.gms.internal.ads.zzaqg.zzJ
            com.google.android.gms.internal.ads.zzaqe r2 = r2.zzd(r3)
            int r3 = com.google.android.gms.internal.ads.zzaqg.zzU
            com.google.android.gms.internal.ads.zzaqf r1 = r1.zzc(r3)
            com.google.android.gms.internal.ads.zzaut r1 = r1.zza
            r1.zzi(r7)
            int r3 = r1.zzr()
            int r3 = com.google.android.gms.internal.ads.zzaqg.zze(r3)
            if (r3 != 0) goto L_0x015a
            r4 = 8
            goto L_0x015c
        L_0x015a:
            r4 = 16
        L_0x015c:
            r1.zzj(r4)
            long r4 = r1.zzp()
            if (r3 != 0) goto L_0x0167
            r3 = 4
            goto L_0x0169
        L_0x0167:
            r3 = 8
        L_0x0169:
            r1.zzj(r3)
            int r1 = r1.zzm()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r12)
            int r6 = r1 >> 10
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r3.append(r6)
            int r6 = r1 >> 5
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r3.append(r6)
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
            android.util.Pair r13 = android.util.Pair.create(r3, r1)
            int r1 = com.google.android.gms.internal.ads.zzaqg.zzW
            com.google.android.gms.internal.ads.zzaqf r1 = r2.zzc(r1)
            com.google.android.gms.internal.ads.zzaut r9 = r1.zza
            int r21 = r14.zza
            int r22 = r14.zzc
            java.lang.Object r1 = r13.second
            r8 = r1
            java.lang.String r8 = (java.lang.String) r8
            r1 = 12
            r9.zzi(r1)
            int r6 = r9.zzr()
            com.google.android.gms.internal.ads.zzaqj r5 = new com.google.android.gms.internal.ads.zzaqj
            r5.<init>(r6)
            r4 = 0
        L_0x01c1:
            if (r4 >= r6) goto L_0x07ce
            int r3 = r9.zzg()
            int r2 = r9.zzr()
            if (r2 <= 0) goto L_0x01cf
            r1 = 1
            goto L_0x01d0
        L_0x01cf:
            r1 = 0
        L_0x01d0:
            java.lang.String r12 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzaul.zzb(r1, r12)
            int r1 = r9.zzr()
            int r7 = com.google.android.gms.internal.ads.zzaqg.zze
            if (r1 == r7) goto L_0x05cf
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzf
            if (r1 == r7) goto L_0x05cf
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzac
            if (r1 == r7) goto L_0x05cf
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzan
            if (r1 == r7) goto L_0x05cf
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzg
            if (r1 == r7) goto L_0x05cf
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzh
            if (r1 == r7) goto L_0x05cf
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzi
            if (r1 == r7) goto L_0x05cf
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaM
            if (r1 == r7) goto L_0x05cf
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaN
            if (r1 != r7) goto L_0x01ff
            goto L_0x05cf
        L_0x01ff:
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzl
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzad
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzq
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzs
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzu
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzx
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzv
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzw
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaA
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaB
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzo
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzp
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzm
            if (r1 == r7) goto L_0x0315
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaQ
            if (r1 != r7) goto L_0x0239
            goto L_0x0315
        L_0x0239:
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzam
            if (r1 == r7) goto L_0x0274
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaw
            if (r1 == r7) goto L_0x0274
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzax
            if (r1 == r7) goto L_0x0274
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzay
            if (r1 == r7) goto L_0x0274
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaz
            if (r1 != r7) goto L_0x024e
            goto L_0x0274
        L_0x024e:
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaP
            if (r1 != r7) goto L_0x025f
            java.lang.String r1 = java.lang.Integer.toString(r21)
            java.lang.String r7 = "application/x-camera-motion"
            r12 = 0
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzank.zzf(r1, r7, r12, r11, r15)
            r5.zzb = r1
        L_0x025f:
            r34 = r2
            r24 = r3
            r35 = r4
            r0 = r5
            r18 = r6
            r38 = r8
            r50 = r9
            r23 = r10
            r47 = r13
            r16 = r14
            goto L_0x0378
        L_0x0274:
            r12 = 0
            int r7 = r3 + 16
            r9.zzi(r7)
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzam
            java.lang.String r23 = "application/ttml+xml"
            r29 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r1 != r7) goto L_0x028a
            r17 = r12
            r7 = 1
            r11 = 0
            goto L_0x02c4
        L_0x028a:
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaw
            if (r1 != r7) goto L_0x02a2
            int r1 = r2 + -16
            byte[] r7 = new byte[r1]
            r11 = 0
            r9.zzk(r7, r11, r1)
            java.util.List r1 = java.util.Collections.singletonList(r7)
            java.lang.String r7 = "application/x-quicktime-tx3g"
            r17 = r1
            r23 = r7
        L_0x02a0:
            r7 = 1
            goto L_0x02c4
        L_0x02a2:
            r11 = 0
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzax
            if (r1 != r7) goto L_0x02ae
            java.lang.String r1 = "application/x-mp4-vtt"
            r23 = r1
            r17 = r12
            goto L_0x02a0
        L_0x02ae:
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzay
            if (r1 != r7) goto L_0x02b7
            r17 = r12
            r29 = r19
            goto L_0x02a0
        L_0x02b7:
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaz
            if (r1 != r7) goto L_0x030f
            r7 = 1
            r5.zzd = r7
            java.lang.String r1 = "application/x-mp4-cea-608"
            r23 = r1
            r17 = r12
        L_0x02c4:
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r18 = 0
            r34 = -1
            r35 = 0
            r36 = -1
            r52 = r13
            r13 = r2
            r2 = r23
            r37 = r3
            r3 = r18
            r38 = r4
            r4 = r34
            r39 = r5
            r5 = r35
            r18 = r6
            r6 = r8
            r23 = 1
            r7 = r36
            r40 = r8
            r8 = r55
            r41 = r9
            r23 = r10
            r11 = 1
            r9 = r29
            r0 = 1
            r11 = r17
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzank.zzd(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11)
            r11 = r39
            r11.zzb = r1
            r47 = r52
            r0 = r11
            r34 = r13
            r16 = r14
            r24 = r37
            r35 = r38
            r38 = r40
            r50 = r41
            goto L_0x0378
        L_0x030f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0315:
            r37 = r3
            r38 = r4
            r11 = r5
            r18 = r6
            r40 = r8
            r41 = r9
            r23 = r10
            r52 = r13
            r0 = 1
            r10 = 0
            r13 = r2
            r9 = r37
            int r3 = r9 + 16
            r8 = r41
            r8.zzi(r3)
            r2 = 6
            if (r56 == 0) goto L_0x033d
            int r3 = r8.zzm()
            r8.zzj(r2)
            r7 = 8
            goto L_0x0343
        L_0x033d:
            r7 = 8
            r8.zzj(r7)
            r3 = 0
        L_0x0343:
            if (r3 == 0) goto L_0x0380
            if (r3 != r0) goto L_0x0348
            goto L_0x0380
        L_0x0348:
            r6 = 2
            if (r3 != r6) goto L_0x0369
            r2 = 16
            r8.zzj(r2)
            long r2 = r8.zzs()
            double r2 = java.lang.Double.longBitsToDouble(r2)
            long r2 = java.lang.Math.round(r2)
            int r3 = (int) r2
            int r2 = r8.zzu()
            r4 = 20
            r8.zzj(r4)
            r5 = 16
            goto L_0x0398
        L_0x0369:
            r47 = r52
            r50 = r8
            r24 = r9
            r0 = r11
            r34 = r13
            r16 = r14
            r35 = r38
            r38 = r40
        L_0x0378:
            r25 = 3
            r28 = -1
            r29 = 0
            goto L_0x07ad
        L_0x0380:
            r6 = 2
            int r4 = r8.zzm()
            r8.zzj(r2)
            int r2 = r8.zzt()
            if (r3 != r0) goto L_0x0394
            r5 = 16
            r8.zzj(r5)
            goto L_0x0396
        L_0x0394:
            r5 = 16
        L_0x0396:
            r3 = r2
            r2 = r4
        L_0x0398:
            int r4 = r8.zzg()
            int r5 = com.google.android.gms.internal.ads.zzaqg.zzad
            if (r1 != r5) goto L_0x03aa
            r5 = r38
            int r1 = zze(r8, r9, r13, r11, r5)
            r8.zzi(r4)
            goto L_0x03ac
        L_0x03aa:
            r5 = r38
        L_0x03ac:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzq
            java.lang.String r0 = "audio/raw"
            if (r1 != r6) goto L_0x03b5
            java.lang.String r1 = "audio/ac3"
            goto L_0x03fe
        L_0x03b5:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzs
            if (r1 != r6) goto L_0x03bc
            java.lang.String r1 = "audio/eac3"
            goto L_0x03fe
        L_0x03bc:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzu
            if (r1 != r6) goto L_0x03c3
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x03fe
        L_0x03c3:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzv
            if (r1 == r6) goto L_0x03fc
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzw
            if (r1 != r6) goto L_0x03cc
            goto L_0x03fc
        L_0x03cc:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzx
            if (r1 != r6) goto L_0x03d3
            java.lang.String r1 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x03fe
        L_0x03d3:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzaA
            if (r1 != r6) goto L_0x03da
            java.lang.String r1 = "audio/3gpp"
            goto L_0x03fe
        L_0x03da:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzaB
            if (r1 != r6) goto L_0x03e1
            java.lang.String r1 = "audio/amr-wb"
            goto L_0x03fe
        L_0x03e1:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzo
            if (r1 == r6) goto L_0x03fa
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzp
            if (r1 != r6) goto L_0x03ea
            goto L_0x03fa
        L_0x03ea:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzm
            if (r1 != r6) goto L_0x03f1
            java.lang.String r1 = "audio/mpeg"
            goto L_0x03fe
        L_0x03f1:
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzaQ
            if (r1 != r6) goto L_0x03f8
            java.lang.String r1 = "audio/alac"
            goto L_0x03fe
        L_0x03f8:
            r1 = r10
            goto L_0x03fe
        L_0x03fa:
            r1 = r0
            goto L_0x03fe
        L_0x03fc:
            java.lang.String r1 = "audio/vnd.dts.hd"
        L_0x03fe:
            r6 = r1
            r28 = r2
            r29 = r3
            r30 = r10
        L_0x0405:
            int r1 = r4 - r9
            if (r1 >= r13) goto L_0x055a
            r8.zzi(r4)
            int r3 = r8.zzr()
            if (r3 <= 0) goto L_0x0414
            r1 = 1
            goto L_0x0415
        L_0x0414:
            r1 = 0
        L_0x0415:
            com.google.android.gms.internal.ads.zzaul.zzb(r1, r12)
            int r1 = r8.zzr()
            int r2 = com.google.android.gms.internal.ads.zzaqg.zzM
            if (r1 == r2) goto L_0x04d6
            if (r56 == 0) goto L_0x0428
            int r2 = com.google.android.gms.internal.ads.zzaqg.zzn
            if (r1 != r2) goto L_0x0428
            goto L_0x04d6
        L_0x0428:
            int r2 = com.google.android.gms.internal.ads.zzaqg.zzr
            if (r1 != r2) goto L_0x0451
            int r1 = r4 + 8
            r8.zzi(r1)
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r2 = r40
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzanw.zza(r8, r1, r2, r15)
            r11.zzb = r1
        L_0x043d:
            r38 = r2
            r2 = r3
            r43 = r5
            r44 = r6
            r15 = r8
            r46 = r9
            r34 = r13
            r16 = 2
            r25 = 16
            r13 = r11
        L_0x044e:
            r11 = 0
            goto L_0x04d1
        L_0x0451:
            r2 = r40
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzt
            if (r1 != r7) goto L_0x0467
            int r1 = r4 + 8
            r8.zzi(r1)
            java.lang.String r1 = java.lang.Integer.toString(r21)
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzanw.zzb(r8, r1, r2, r15)
            r11.zzb = r1
            goto L_0x043d
        L_0x0467:
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzy
            if (r1 != r7) goto L_0x04aa
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r7 = 0
            r34 = -1
            r35 = -1
            r36 = 0
            r37 = 0
            r38 = r2
            r2 = r6
            r42 = r3
            r3 = r7
            r7 = r4
            r4 = r34
            r43 = r5
            r25 = 16
            r5 = r35
            r44 = r6
            r16 = 2
            r6 = r28
            r45 = r7
            r7 = r29
            r15 = r8
            r8 = r36
            r46 = r9
            r9 = r55
            r10 = r37
            r34 = r13
            r13 = r11
            r11 = r38
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzank.zzb(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13.zzb = r1
        L_0x04a5:
            r2 = r42
            r4 = r45
            goto L_0x044e
        L_0x04aa:
            r38 = r2
            r42 = r3
            r45 = r4
            r43 = r5
            r44 = r6
            r15 = r8
            r46 = r9
            r34 = r13
            r16 = 2
            r25 = 16
            r13 = r11
            int r2 = com.google.android.gms.internal.ads.zzaqg.zzaQ
            if (r1 != r2) goto L_0x04a5
            r2 = r42
            byte[] r1 = new byte[r2]
            r4 = r45
            r15.zzi(r4)
            r11 = 0
            r15.zzk(r1, r11, r2)
            r30 = r1
        L_0x04d1:
            r6 = r44
            r10 = -1
            goto L_0x0548
        L_0x04d6:
            r2 = r3
            r43 = r5
            r44 = r6
            r15 = r8
            r46 = r9
            r34 = r13
            r38 = r40
            r16 = 2
            r25 = 16
            r13 = r11
            r11 = 0
            int r3 = com.google.android.gms.internal.ads.zzaqg.zzM
            if (r1 != r3) goto L_0x04ef
            r1 = r4
        L_0x04ed:
            r10 = -1
            goto L_0x0512
        L_0x04ef:
            int r1 = r15.zzg()
        L_0x04f3:
            int r3 = r1 - r4
            if (r3 >= r2) goto L_0x0510
            r15.zzi(r1)
            int r3 = r15.zzr()
            if (r3 <= 0) goto L_0x0502
            r9 = 1
            goto L_0x0503
        L_0x0502:
            r9 = 0
        L_0x0503:
            com.google.android.gms.internal.ads.zzaul.zzb(r9, r12)
            int r5 = r15.zzr()
            int r6 = com.google.android.gms.internal.ads.zzaqg.zzM
            if (r5 == r6) goto L_0x04ed
            int r1 = r1 + r3
            goto L_0x04f3
        L_0x0510:
            r1 = -1
            goto L_0x04ed
        L_0x0512:
            if (r1 == r10) goto L_0x0546
            android.util.Pair r1 = zzd(r15, r1)
            java.lang.Object r3 = r1.first
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.second
            r30 = r1
            byte[] r30 = (byte[]) r30
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0544
            android.util.Pair r1 = com.google.android.gms.internal.ads.zzaum.zza(r30)
            java.lang.Object r5 = r1.first
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r28 = r1
            r6 = r3
            r29 = r5
            goto L_0x0548
        L_0x0544:
            r6 = r3
            goto L_0x0548
        L_0x0546:
            r6 = r44
        L_0x0548:
            int r4 = r4 + r2
            r11 = r13
            r8 = r15
            r13 = r34
            r40 = r38
            r5 = r43
            r9 = r46
            r7 = 8
            r10 = 0
            r15 = r55
            goto L_0x0405
        L_0x055a:
            r43 = r5
            r44 = r6
            r15 = r8
            r46 = r9
            r34 = r13
            r38 = r40
            r10 = -1
            r16 = 2
            r25 = 16
            r13 = r11
            r11 = 0
            com.google.android.gms.internal.ads.zzank r1 = r13.zzb
            if (r1 != 0) goto L_0x05be
            r6 = r44
            if (r6 == 0) goto L_0x05be
            boolean r0 = r0.equals(r6)
            r1 = 1
            if (r1 == r0) goto L_0x057d
            r8 = -1
            goto L_0x057e
        L_0x057d:
            r8 = 2
        L_0x057e:
            java.lang.String r1 = java.lang.Integer.toString(r21)
            if (r30 != 0) goto L_0x0586
            r0 = 0
            goto L_0x058a
        L_0x0586:
            java.util.List r0 = java.util.Collections.singletonList(r30)
        L_0x058a:
            r3 = 0
            r4 = -1
            r5 = -1
            r9 = -1
            r12 = -1
            r30 = 0
            r31 = 0
            r2 = r6
            r6 = r28
            r7 = r29
            r28 = -1
            r10 = r12
            r29 = 0
            r11 = r0
            r0 = 3
            r12 = r55
            r47 = r52
            r0 = r13
            r48 = r34
            r13 = r30
            r16 = r14
            r14 = r38
            r49 = r15
            r15 = r31
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzank.zzc(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.zzb = r1
            r35 = r43
            r24 = r46
            r50 = r49
            goto L_0x07ab
        L_0x05be:
            r47 = r52
            r0 = r13
            r16 = r14
            r28 = -1
            r29 = 0
            r50 = r15
            r35 = r43
            r24 = r46
            goto L_0x07ab
        L_0x05cf:
            r48 = r2
            r46 = r3
            r43 = r4
            r0 = r5
            r18 = r6
            r38 = r8
            r49 = r9
            r23 = r10
            r47 = r13
            r16 = r14
            r28 = -1
            r29 = 0
            r15 = r46
            int r3 = r15 + 16
            r14 = r49
            r14.zzi(r3)
            r13 = 16
            r14.zzj(r13)
            int r6 = r14.zzm()
            int r7 = r14.zzm()
            r2 = 50
            r14.zzj(r2)
            int r2 = r14.zzg()
            int r3 = com.google.android.gms.internal.ads.zzaqg.zzac
            if (r1 != r3) goto L_0x0615
            r11 = r43
            r10 = r48
            int r1 = zze(r14, r15, r10, r0, r11)
            r14.zzi(r2)
            goto L_0x0619
        L_0x0615:
            r11 = r43
            r10 = r48
        L_0x0619:
            r3 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            r4 = 0
            r9 = 0
            r25 = 1065353216(0x3f800000, float:1.0)
            r30 = 0
            r31 = -1
        L_0x0624:
            int r5 = r2 - r15
            if (r5 >= r10) goto L_0x076d
            r14.zzi(r2)
            int r5 = r14.zzg()
            int r8 = r14.zzr()
            if (r8 != 0) goto L_0x063f
            int r8 = r14.zzg()
            int r8 = r8 - r15
            if (r8 != r10) goto L_0x063e
            goto L_0x076d
        L_0x063e:
            r8 = 0
        L_0x063f:
            if (r8 <= 0) goto L_0x0643
            r13 = 1
            goto L_0x0644
        L_0x0643:
            r13 = 0
        L_0x0644:
            com.google.android.gms.internal.ads.zzaul.zzb(r13, r12)
            int r13 = r14.zzr()
            r48 = r10
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzK
            if (r13 != r10) goto L_0x0671
            if (r3 != 0) goto L_0x0655
            r9 = 1
            goto L_0x0656
        L_0x0655:
            r9 = 0
        L_0x0656:
            com.google.android.gms.internal.ads.zzaul.zzd(r9)
            int r5 = r5 + 8
            r14.zzi(r5)
            com.google.android.gms.internal.ads.zzavb r3 = com.google.android.gms.internal.ads.zzavb.zza(r14)
            java.util.List<byte[]> r9 = r3.zza
            int r5 = r3.zzb
            r0.zzc = r5
            if (r4 != 0) goto L_0x066e
            float r3 = r3.zzc
            r25 = r3
        L_0x066e:
            java.lang.String r3 = "video/avc"
            goto L_0x068e
        L_0x0671:
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzL
            if (r13 != r10) goto L_0x0694
            if (r3 != 0) goto L_0x0679
            r9 = 1
            goto L_0x067a
        L_0x0679:
            r9 = 0
        L_0x067a:
            com.google.android.gms.internal.ads.zzaul.zzd(r9)
            int r5 = r5 + 8
            r14.zzi(r5)
            com.google.android.gms.internal.ads.zzavh r3 = com.google.android.gms.internal.ads.zzavh.zza(r14)
            java.util.List<byte[]> r9 = r3.zza
            int r3 = r3.zzb
            r0.zzc = r3
            java.lang.String r3 = "video/hevc"
        L_0x068e:
            r34 = r1
        L_0x0690:
            r10 = 2
            r13 = 3
            goto L_0x0764
        L_0x0694:
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzaO
            if (r13 != r10) goto L_0x06aa
            if (r3 != 0) goto L_0x069c
            r3 = 1
            goto L_0x069d
        L_0x069c:
            r3 = 0
        L_0x069d:
            com.google.android.gms.internal.ads.zzaul.zzd(r3)
            int r3 = com.google.android.gms.internal.ads.zzaqg.zzaM
            if (r1 != r3) goto L_0x06a7
            java.lang.String r3 = "video/x-vnd.on2.vp8"
            goto L_0x068e
        L_0x06a7:
            java.lang.String r3 = "video/x-vnd.on2.vp9"
            goto L_0x068e
        L_0x06aa:
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzj
            if (r13 != r10) goto L_0x06b9
            if (r3 != 0) goto L_0x06b2
            r3 = 1
            goto L_0x06b3
        L_0x06b2:
            r3 = 0
        L_0x06b3:
            com.google.android.gms.internal.ads.zzaul.zzd(r3)
            java.lang.String r3 = "video/3gpp"
            goto L_0x068e
        L_0x06b9:
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzM
            if (r13 != r10) goto L_0x06d9
            if (r3 != 0) goto L_0x06c1
            r9 = 1
            goto L_0x06c2
        L_0x06c1:
            r9 = 0
        L_0x06c2:
            com.google.android.gms.internal.ads.zzaul.zzd(r9)
            android.util.Pair r3 = zzd(r14, r5)
            java.lang.Object r5 = r3.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.second
            byte[] r3 = (byte[]) r3
            java.util.List r9 = java.util.Collections.singletonList(r3)
            r34 = r1
            r3 = r5
            goto L_0x0690
        L_0x06d9:
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzal
            if (r13 != r10) goto L_0x06f2
            int r5 = r5 + 8
            r14.zzi(r5)
            int r4 = r14.zzu()
            float r4 = (float) r4
            int r5 = r14.zzu()
            float r5 = (float) r5
            float r25 = r4 / r5
            r34 = r1
            r4 = 1
            goto L_0x0690
        L_0x06f2:
            int r10 = com.google.android.gms.internal.ads.zzaqg.zzaK
            if (r13 != r10) goto L_0x0728
            int r10 = r5 + 8
        L_0x06f8:
            int r13 = r10 - r5
            if (r13 >= r8) goto L_0x071d
            r14.zzi(r10)
            int r13 = r14.zzr()
            r34 = r1
            int r1 = r14.zzr()
            r52 = r4
            int r4 = com.google.android.gms.internal.ads.zzaqg.zzaL
            if (r1 != r4) goto L_0x0717
            byte[] r1 = r14.zza
            int r13 = r13 + r10
            byte[] r1 = java.util.Arrays.copyOfRange(r1, r10, r13)
            goto L_0x0722
        L_0x0717:
            int r10 = r10 + r13
            r4 = r52
            r1 = r34
            goto L_0x06f8
        L_0x071d:
            r34 = r1
            r52 = r4
            r1 = 0
        L_0x0722:
            r4 = r52
            r30 = r1
            goto L_0x0690
        L_0x0728:
            r34 = r1
            r52 = r4
            int r1 = com.google.android.gms.internal.ads.zzaqg.zzaJ
            if (r13 != r1) goto L_0x0760
            int r1 = r14.zzl()
            r13 = 3
            r14.zzj(r13)
            if (r1 != 0) goto L_0x075e
            int r1 = r14.zzl()
            if (r1 == 0) goto L_0x0758
            r4 = 1
            r10 = 2
            if (r1 == r4) goto L_0x0753
            if (r1 == r10) goto L_0x074e
            if (r1 == r13) goto L_0x0749
            goto L_0x0762
        L_0x0749:
            r4 = r52
            r31 = 3
            goto L_0x0764
        L_0x074e:
            r4 = r52
            r31 = 2
            goto L_0x0764
        L_0x0753:
            r4 = r52
            r31 = 1
            goto L_0x0764
        L_0x0758:
            r10 = 2
            r4 = r52
            r31 = 0
            goto L_0x0764
        L_0x075e:
            r10 = 2
            goto L_0x0762
        L_0x0760:
            r10 = 2
            r13 = 3
        L_0x0762:
            r4 = r52
        L_0x0764:
            int r2 = r2 + r8
            r1 = r34
            r10 = r48
            r13 = 16
            goto L_0x0624
        L_0x076d:
            r48 = r10
            r10 = 2
            r13 = 3
            if (r3 == 0) goto L_0x07a3
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r4 = 0
            r5 = -1
            r8 = -1
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r24 = 0
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            r8 = r12
            r34 = r48
            r12 = 2
            r10 = r22
            r35 = r11
            r11 = r25
            r12 = r30
            r25 = 3
            r30 = 16
            r13 = r31
            r50 = r14
            r14 = r24
            r24 = r15
            r15 = r55
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzank.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.zzb = r1
            goto L_0x07af
        L_0x07a3:
            r35 = r11
            r50 = r14
            r24 = r15
            r34 = r48
        L_0x07ab:
            r25 = 3
        L_0x07ad:
            r30 = 16
        L_0x07af:
            int r3 = r24 + r34
            r1 = r50
            r1.zzi(r3)
            int r4 = r35 + 1
            r15 = r55
            r5 = r0
            r9 = r1
            r14 = r16
            r6 = r18
            r10 = r23
            r8 = r38
            r13 = r47
            r7 = 8
            r11 = -1
            r12 = 3
            r0 = r51
            goto L_0x01c1
        L_0x07ce:
            r0 = r5
            r23 = r10
            r47 = r13
            r16 = r14
            r29 = 0
            int r1 = com.google.android.gms.internal.ads.zzaqg.zzS
            r2 = r51
            com.google.android.gms.internal.ads.zzaqe r1 = r2.zzd(r1)
            if (r1 == 0) goto L_0x083c
            int r2 = com.google.android.gms.internal.ads.zzaqg.zzT
            com.google.android.gms.internal.ads.zzaqf r1 = r1.zzc(r2)
            if (r1 != 0) goto L_0x07ea
            goto L_0x083c
        L_0x07ea:
            com.google.android.gms.internal.ads.zzaut r1 = r1.zza
            r2 = 8
            r1.zzi(r2)
            int r2 = r1.zzr()
            int r2 = com.google.android.gms.internal.ads.zzaqg.zze(r2)
            int r3 = r1.zzu()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r9 = 0
        L_0x0802:
            if (r9 >= r3) goto L_0x0835
            r6 = 1
            if (r2 != r6) goto L_0x080c
            long r7 = r1.zzv()
            goto L_0x0810
        L_0x080c:
            long r7 = r1.zzp()
        L_0x0810:
            r4[r9] = r7
            if (r2 != r6) goto L_0x0819
            long r7 = r1.zzs()
            goto L_0x081e
        L_0x0819:
            int r7 = r1.zzr()
            long r7 = (long) r7
        L_0x081e:
            r5[r9] = r7
            short r7 = r1.zzo()
            if (r7 != r6) goto L_0x082d
            r7 = 2
            r1.zzj(r7)
            int r9 = r9 + 1
            goto L_0x0802
        L_0x082d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0835:
            android.util.Pair r1 = android.util.Pair.create(r4, r5)
            r2 = r1
            r1 = 0
            goto L_0x0841
        L_0x083c:
            r1 = 0
            android.util.Pair r2 = android.util.Pair.create(r1, r1)
        L_0x0841:
            com.google.android.gms.internal.ads.zzank r3 = r0.zzb
            if (r3 != 0) goto L_0x0846
            return r1
        L_0x0846:
            com.google.android.gms.internal.ads.zzaqy r1 = new com.google.android.gms.internal.ads.zzaqy
            int r16 = r16.zza
            r3 = r47
            java.lang.Object r3 = r3.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r18 = r3.longValue()
            com.google.android.gms.internal.ads.zzank r3 = r0.zzb
            int r4 = r0.zzd
            com.google.android.gms.internal.ads.zzaqz[] r5 = r0.zza
            int r0 = r0.zzc
            java.lang.Object r6 = r2.first
            r28 = r6
            long[] r28 = (long[]) r28
            java.lang.Object r2 = r2.second
            r29 = r2
            long[] r29 = (long[]) r29
            r15 = r1
            r17 = r23
            r20 = r32
            r22 = r26
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r0
            r15.<init>(r16, r17, r18, r20, r22, r24, r25, r26, r27, r28, r29)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqn.zza(com.google.android.gms.internal.ads.zzaqe, com.google.android.gms.internal.ads.zzaqf, long, com.google.android.gms.internal.ads.zzaph, boolean):com.google.android.gms.internal.ads.zzaqy");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0194 A[LOOP:5: B:56:0x0194->B:57:0x0196, LOOP_START, PHI: r2 r3 r19 r25 
      PHI: (r2v38 int) = (r2v26 int), (r2v43 int) binds: [B:55:0x0192, B:57:0x0196] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v27 int) = (r3v23 int), (r3v42 int) binds: [B:55:0x0192, B:57:0x0196] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r19v11 long) = (r19v7 long), (r19v14 long) binds: [B:55:0x0192, B:57:0x0196] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r25v7 int) = (r25v3 int), (r25v9 int) binds: [B:55:0x0192, B:57:0x0196] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0244  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzarb zzb(com.google.android.gms.internal.ads.zzaqy r39, com.google.android.gms.internal.ads.zzaqe r40, com.google.android.gms.internal.ads.zzapp r41) throws com.google.android.gms.internal.ads.zzann {
        /*
            r0 = r39
            r1 = r40
            r2 = r41
            int r3 = com.google.android.gms.internal.ads.zzaqg.zzas
            com.google.android.gms.internal.ads.zzaqf r3 = r1.zzc(r3)
            if (r3 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzaqk r4 = new com.google.android.gms.internal.ads.zzaqk
            r4.<init>(r3)
            goto L_0x0021
        L_0x0014:
            int r3 = com.google.android.gms.internal.ads.zzaqg.zzat
            com.google.android.gms.internal.ads.zzaqf r3 = r1.zzc(r3)
            if (r3 == 0) goto L_0x04c6
            com.google.android.gms.internal.ads.zzaql r4 = new com.google.android.gms.internal.ads.zzaql
            r4.<init>(r3)
        L_0x0021:
            int r3 = r4.zza()
            r5 = 0
            if (r3 != 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzarb r0 = new com.google.android.gms.internal.ads.zzarb
            long[] r7 = new long[r5]
            int[] r8 = new int[r5]
            r9 = 0
            long[] r10 = new long[r5]
            int[] r11 = new int[r5]
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            return r0
        L_0x0038:
            int r5 = com.google.android.gms.internal.ads.zzaqg.zzau
            com.google.android.gms.internal.ads.zzaqf r5 = r1.zzc(r5)
            if (r5 != 0) goto L_0x0048
            int r5 = com.google.android.gms.internal.ads.zzaqg.zzav
            com.google.android.gms.internal.ads.zzaqf r5 = r1.zzc(r5)
            r6 = 1
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            com.google.android.gms.internal.ads.zzaut r5 = r5.zza
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzar
            com.google.android.gms.internal.ads.zzaqf r7 = r1.zzc(r7)
            com.google.android.gms.internal.ads.zzaut r7 = r7.zza
            int r8 = com.google.android.gms.internal.ads.zzaqg.zzao
            com.google.android.gms.internal.ads.zzaqf r8 = r1.zzc(r8)
            com.google.android.gms.internal.ads.zzaut r8 = r8.zza
            int r9 = com.google.android.gms.internal.ads.zzaqg.zzap
            com.google.android.gms.internal.ads.zzaqf r9 = r1.zzc(r9)
            r10 = 0
            if (r9 == 0) goto L_0x0067
            com.google.android.gms.internal.ads.zzaut r9 = r9.zza
            goto L_0x0068
        L_0x0067:
            r9 = r10
        L_0x0068:
            int r11 = com.google.android.gms.internal.ads.zzaqg.zzaq
            com.google.android.gms.internal.ads.zzaqf r1 = r1.zzc(r11)
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.internal.ads.zzaut r1 = r1.zza
            goto L_0x0074
        L_0x0073:
            r1 = r10
        L_0x0074:
            com.google.android.gms.internal.ads.zzaqh r11 = new com.google.android.gms.internal.ads.zzaqh
            r11.<init>(r7, r5, r6)
            r5 = 12
            r8.zzi(r5)
            int r6 = r8.zzu()
            int r6 = r6 + -1
            int r7 = r8.zzu()
            int r12 = r8.zzu()
            if (r1 == 0) goto L_0x0096
            r1.zzi(r5)
            int r13 = r1.zzu()
            goto L_0x0097
        L_0x0096:
            r13 = 0
        L_0x0097:
            if (r9 == 0) goto L_0x00a9
            r9.zzi(r5)
            int r5 = r9.zzu()
            if (r5 <= 0) goto L_0x00ab
            int r10 = r9.zzu()
            int r10 = r10 + -1
            goto L_0x00ae
        L_0x00a9:
            r5 = 0
            r10 = r9
        L_0x00ab:
            r9 = -1
            r9 = r10
            r10 = -1
        L_0x00ae:
            boolean r14 = r4.zzc()
            if (r14 == 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzank r14 = r0.zzf
            java.lang.String r14 = r14.zzf
            java.lang.String r15 = "audio/raw"
            boolean r14 = r15.equals(r14)
            if (r14 == 0) goto L_0x0163
            if (r6 != 0) goto L_0x0163
            if (r13 != 0) goto L_0x0162
            if (r5 != 0) goto L_0x0162
            int r1 = r11.zza
            long[] r5 = new long[r1]
            int[] r6 = new int[r1]
        L_0x00cc:
            boolean r7 = r11.zza()
            if (r7 == 0) goto L_0x00dd
            int r7 = r11.zzb
            long r8 = r11.zzd
            r5[r7] = r8
            int r8 = r11.zzc
            r6[r7] = r8
            goto L_0x00cc
        L_0x00dd:
            int r4 = r4.zzb()
            long r7 = (long) r12
            r9 = 8192(0x2000, float:1.14794E-41)
            int r9 = r9 / r4
            r10 = 0
            r11 = 0
        L_0x00e7:
            if (r10 >= r1) goto L_0x00f3
            r12 = r6[r10]
            int r12 = com.google.android.gms.internal.ads.zzava.zze(r12, r9)
            int r11 = r11 + r12
            int r10 = r10 + 1
            goto L_0x00e7
        L_0x00f3:
            long[] r10 = new long[r11]
            int[] r12 = new int[r11]
            long[] r13 = new long[r11]
            int[] r11 = new int[r11]
            r14 = 0
            r15 = 0
            r16 = 0
            r19 = 0
        L_0x0101:
            if (r14 >= r1) goto L_0x0153
            r20 = r6[r14]
            r21 = r5[r14]
            r37 = r16
            r16 = r1
            r1 = r37
            r38 = r20
            r20 = r5
            r5 = r38
        L_0x0113:
            if (r5 <= 0) goto L_0x0141
            int r23 = java.lang.Math.min(r9, r5)
            r10[r19] = r21
            r40 = r6
            int r6 = r4 * r23
            r12[r19] = r6
            int r15 = java.lang.Math.max(r15, r6)
            r6 = r9
            r24 = r10
            long r9 = (long) r1
            long r9 = r9 * r7
            r13[r19] = r9
            r9 = 1
            r11[r19] = r9
            r9 = r12[r19]
            long r9 = (long) r9
            long r21 = r21 + r9
            int r1 = r1 + r23
            int r5 = r5 - r23
            int r19 = r19 + 1
            r9 = r6
            r10 = r24
            r6 = r40
            goto L_0x0113
        L_0x0141:
            r40 = r6
            r6 = r9
            r24 = r10
            int r14 = r14 + 1
            r5 = r20
            r6 = r40
            r37 = r16
            r16 = r1
            r1 = r37
            goto L_0x0101
        L_0x0153:
            r24 = r10
            r1 = r0
            r27 = r3
            r9 = r12
            r10 = r15
            r8 = r24
            r21 = 0
            r12 = r11
            r11 = r13
            goto L_0x0292
        L_0x0162:
            r6 = 0
        L_0x0163:
            long[] r14 = new long[r3]
            int[] r15 = new int[r3]
            r40 = r5
            long[] r5 = new long[r3]
            r16 = r6
            int[] r6 = new int[r3]
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r23 = r8
            r2 = r12
            r0 = 0
            r8 = 0
            r19 = 0
            r21 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r12 = r7
            r7 = r40
            r37 = r13
            r13 = r10
            r10 = r16
            r16 = r37
        L_0x0192:
            if (r8 >= r3) goto L_0x0222
        L_0x0194:
            if (r25 != 0) goto L_0x01ae
            boolean r19 = r11.zza()
            com.google.android.gms.internal.ads.zzaul.zzd(r19)
            r40 = r2
            r27 = r3
            long r2 = r11.zzd
            r19 = r2
            int r2 = r11.zzc
            r25 = r2
            r3 = r27
            r2 = r40
            goto L_0x0194
        L_0x01ae:
            r40 = r2
            r27 = r3
            if (r1 == 0) goto L_0x01c7
        L_0x01b4:
            if (r24 != 0) goto L_0x01c5
            if (r16 <= 0) goto L_0x01c3
            int r24 = r1.zzu()
            int r26 = r1.zzr()
            int r16 = r16 + -1
            goto L_0x01b4
        L_0x01c3:
            r24 = 0
        L_0x01c5:
            int r24 = r24 + -1
        L_0x01c7:
            r2 = r26
            r14[r8] = r19
            int r3 = r4.zzb()
            r15[r8] = r3
            if (r3 <= r0) goto L_0x01d4
            r0 = r3
        L_0x01d4:
            r26 = r4
            long r3 = (long) r2
            long r3 = r21 + r3
            r5[r8] = r3
            if (r9 != 0) goto L_0x01df
            r3 = 1
            goto L_0x01e0
        L_0x01df:
            r3 = 0
        L_0x01e0:
            r6[r8] = r3
            if (r8 != r13) goto L_0x01f2
            r3 = 1
            r6[r8] = r3
            int r7 = r7 + -1
            if (r7 <= 0) goto L_0x01f2
            int r3 = r9.zzu()
            int r3 = r3 + -1
            r13 = r3
        L_0x01f2:
            r3 = r40
            r40 = r5
            long r4 = (long) r3
            long r21 = r21 + r4
            int r12 = r12 + -1
            if (r12 != 0) goto L_0x020e
            if (r10 <= 0) goto L_0x020c
            int r3 = r23.zzu()
            int r4 = r23.zzu()
            int r10 = r10 + -1
            r12 = r3
            r3 = r4
            goto L_0x020e
        L_0x020c:
            r4 = 0
            r12 = 0
        L_0x020e:
            r4 = r15[r8]
            long r4 = (long) r4
            long r19 = r19 + r4
            int r25 = r25 + -1
            int r8 = r8 + 1
            r5 = r40
            r4 = r26
            r26 = r2
            r2 = r3
            r3 = r27
            goto L_0x0192
        L_0x0222:
            r27 = r3
            r40 = r5
            if (r24 != 0) goto L_0x022a
            r2 = 1
            goto L_0x022b
        L_0x022a:
            r2 = 0
        L_0x022b:
            com.google.android.gms.internal.ads.zzaul.zza(r2)
        L_0x022e:
            if (r16 <= 0) goto L_0x0242
            int r2 = r1.zzu()
            if (r2 != 0) goto L_0x0238
            r2 = 1
            goto L_0x0239
        L_0x0238:
            r2 = 0
        L_0x0239:
            com.google.android.gms.internal.ads.zzaul.zza(r2)
            r1.zzr()
            int r16 = r16 + -1
            goto L_0x022e
        L_0x0242:
            if (r7 != 0) goto L_0x0258
            if (r12 != 0) goto L_0x0257
            if (r25 != 0) goto L_0x0255
            if (r10 == 0) goto L_0x0250
            r1 = 0
            r2 = 0
            r12 = 0
            r25 = 0
            goto L_0x0257
        L_0x0250:
            r1 = r39
            r19 = r0
            goto L_0x028b
        L_0x0255:
            r1 = 0
            r12 = 0
        L_0x0257:
            r7 = 0
        L_0x0258:
            r1 = r39
            r19 = r0
            r0 = r25
            int r2 = r1.zza
            r3 = 215(0xd7, float:3.01E-43)
            java.lang.String r4 = "Inconsistent stbl box for track "
            java.lang.String r5 = ": remainingSynchronizationSamples "
            java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline22(r3, r4, r2, r5, r7)
            java.lang.String r3 = ", remainingSamplesAtTimestampDelta "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r3 = ", remainingSamplesInChunk "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ", remainingTimestampDeltaChanges "
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "AtomParsers"
            android.util.Log.w(r2, r0)
        L_0x028b:
            r11 = r40
            r12 = r6
            r8 = r14
            r9 = r15
            r10 = r19
        L_0x0292:
            long[] r0 = r1.zzi
            if (r0 == 0) goto L_0x04ad
            boolean r0 = r41.zzb()
            if (r0 == 0) goto L_0x029e
            goto L_0x04ad
        L_0x029e:
            long[] r0 = r1.zzi
            int r2 = r0.length
            r3 = 1
            if (r2 != r3) goto L_0x0329
            int r2 = r1.zzb
            if (r2 != r3) goto L_0x0329
            int r2 = r11.length
            r3 = 2
            if (r2 < r3) goto L_0x0329
            long[] r3 = r1.zzj
            r4 = 0
            r5 = r3[r4]
            r28 = r0[r4]
            long r3 = r1.zzc
            long r13 = r1.zzd
            r30 = r3
            r32 = r13
            long r3 = com.google.android.gms.internal.ads.zzava.zzj(r28, r30, r32)
            long r3 = r3 + r5
            r0 = 0
            r13 = r11[r0]
            int r0 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0329
            r0 = 1
            r15 = r11[r0]
            int r0 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x0329
            int r2 = r2 + -1
            r15 = r11[r2]
            int r0 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0329
            int r0 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r0 > 0) goto L_0x0329
            long r28 = r5 - r13
            com.google.android.gms.internal.ads.zzank r0 = r1.zzf
            int r0 = r0.zzs
            long r5 = (long) r0
            long r13 = r1.zzc
            r30 = r5
            r32 = r13
            long r5 = com.google.android.gms.internal.ads.zzava.zzj(r28, r30, r32)
            long r28 = r21 - r3
            com.google.android.gms.internal.ads.zzank r0 = r1.zzf
            int r0 = r0.zzs
            long r2 = (long) r0
            long r13 = r1.zzc
            r30 = r2
            r32 = r13
            long r2 = com.google.android.gms.internal.ads.zzava.zzj(r28, r30, r32)
            r13 = 0
            int r0 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x0306
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x0329
        L_0x0306:
            r13 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x0329
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x0312
            goto L_0x0329
        L_0x0312:
            int r0 = (int) r5
            r4 = r41
            r4.zzb = r0
            int r0 = (int) r2
            r4.zzc = r0
            long r0 = r1.zzc
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzava.zzk(r11, r2, r0)
            com.google.android.gms.internal.ads.zzarb r0 = new com.google.android.gms.internal.ads.zzarb
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            return r0
        L_0x0329:
            long[] r0 = r1.zzi
            int r2 = r0.length
            r3 = 1
            if (r2 != r3) goto L_0x035c
            r2 = 0
            r3 = r0[r2]
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x035e
            r0 = 0
        L_0x0339:
            int r3 = r11.length
            if (r0 >= r3) goto L_0x0355
            r3 = r11[r0]
            long[] r5 = r1.zzj
            r6 = r5[r2]
            long r13 = r3 - r6
            r15 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r1.zzc
            r17 = r2
            long r2 = com.google.android.gms.internal.ads.zzava.zzj(r13, r15, r17)
            r11[r0] = r2
            int r0 = r0 + 1
            r2 = 0
            goto L_0x0339
        L_0x0355:
            com.google.android.gms.internal.ads.zzarb r0 = new com.google.android.gms.internal.ads.zzarb
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            return r0
        L_0x035c:
            r5 = 0
        L_0x035e:
            int r0 = r1.zzb
            r2 = 1
            if (r0 != r2) goto L_0x0365
            r0 = 1
            goto L_0x0366
        L_0x0365:
            r0 = 0
        L_0x0366:
            r2 = 0
            r3 = 0
            r4 = 0
            r7 = 0
        L_0x036a:
            long[] r13 = r1.zzi
            int r14 = r13.length
            r15 = -1
            if (r7 >= r14) goto L_0x03ad
            long[] r14 = r1.zzj
            r5 = r14[r7]
            int r14 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r14 == 0) goto L_0x03a2
            r19 = r13[r7]
            long r13 = r1.zzc
            r40 = r9
            r15 = r10
            long r9 = r1.zzd
            r21 = r13
            r23 = r9
            long r9 = com.google.android.gms.internal.ads.zzava.zzj(r19, r21, r23)
            r13 = 1
            int r13 = com.google.android.gms.internal.ads.zzava.zzi(r11, r5, r13, r13)
            long r5 = r5 + r9
            r9 = 0
            int r5 = com.google.android.gms.internal.ads.zzava.zzi(r11, r5, r0, r9)
            int r6 = r5 - r13
            int r6 = r6 + r2
            if (r3 == r13) goto L_0x039c
            r2 = 1
            goto L_0x039d
        L_0x039c:
            r2 = 0
        L_0x039d:
            r2 = r2 | r4
            r4 = r2
            r3 = r5
            r2 = r6
            goto L_0x03a5
        L_0x03a2:
            r40 = r9
            r15 = r10
        L_0x03a5:
            int r7 = r7 + 1
            r9 = r40
            r10 = r15
            r5 = 0
            goto L_0x036a
        L_0x03ad:
            r40 = r9
            r15 = r10
            r3 = r27
            if (r2 == r3) goto L_0x03b6
            r3 = 1
            goto L_0x03b7
        L_0x03b6:
            r3 = 0
        L_0x03b7:
            r3 = r3 | r4
            if (r3 == 0) goto L_0x03bd
            long[] r4 = new long[r2]
            goto L_0x03be
        L_0x03bd:
            r4 = r8
        L_0x03be:
            if (r3 == 0) goto L_0x03c3
            int[] r5 = new int[r2]
            goto L_0x03c5
        L_0x03c3:
            r5 = r40
        L_0x03c5:
            r6 = 1
            if (r6 != r3) goto L_0x03ca
            r10 = 0
            goto L_0x03cb
        L_0x03ca:
            r10 = r15
        L_0x03cb:
            if (r3 == 0) goto L_0x03d0
            int[] r6 = new int[r2]
            goto L_0x03d1
        L_0x03d0:
            r6 = r12
        L_0x03d1:
            long[] r2 = new long[r2]
            r7 = 0
            r9 = 0
            r22 = r10
            r19 = 0
        L_0x03d9:
            long[] r10 = r1.zzi
            int r13 = r10.length
            if (r7 >= r13) goto L_0x0484
            long[] r13 = r1.zzj
            r14 = r13[r7]
            r29 = r10[r7]
            r16 = -1
            int r10 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r10 == 0) goto L_0x0472
            r10 = r6
            r21 = r7
            long r6 = r1.zzc
            r31 = r12
            long r12 = r1.zzd
            r23 = r29
            r25 = r6
            r27 = r12
            long r6 = com.google.android.gms.internal.ads.zzava.zzj(r23, r25, r27)
            r12 = 1
            int r12 = com.google.android.gms.internal.ads.zzava.zzi(r11, r14, r12, r12)
            long r6 = r6 + r14
            r13 = 0
            int r6 = com.google.android.gms.internal.ads.zzava.zzi(r11, r6, r0, r13)
            if (r3 == 0) goto L_0x041c
            int r7 = r6 - r12
            java.lang.System.arraycopy(r8, r12, r4, r9, r7)
            r13 = r40
            java.lang.System.arraycopy(r13, r12, r5, r9, r7)
            r40 = r14
            r15 = r31
            java.lang.System.arraycopy(r15, r12, r10, r9, r7)
            goto L_0x0422
        L_0x041c:
            r13 = r40
            r40 = r14
            r15 = r31
        L_0x0422:
            r7 = r22
        L_0x0424:
            if (r12 >= r6) goto L_0x046b
            r16 = 1000000(0xf4240, double:4.940656E-318)
            r23 = r6
            r22 = r7
            long r6 = r1.zzd
            r25 = r40
            r24 = r13
            r13 = r19
            r27 = r15
            r15 = r16
            r17 = r6
            long r6 = com.google.android.gms.internal.ads.zzava.zzj(r13, r15, r17)
            r13 = r11[r12]
            long r31 = r13 - r25
            r33 = 1000000(0xf4240, double:4.940656E-318)
            long r13 = r1.zzc
            r35 = r13
            long r13 = com.google.android.gms.internal.ads.zzava.zzj(r31, r33, r35)
            long r6 = r6 + r13
            r2[r9] = r6
            if (r3 == 0) goto L_0x045c
            r6 = r5[r9]
            r7 = r22
            if (r6 <= r7) goto L_0x045e
            r7 = r24[r12]
            goto L_0x045e
        L_0x045c:
            r7 = r22
        L_0x045e:
            int r9 = r9 + 1
            int r12 = r12 + 1
            r6 = r23
            r13 = r24
            r40 = r25
            r15 = r27
            goto L_0x0424
        L_0x046b:
            r24 = r13
            r27 = r15
            r22 = r7
            goto L_0x0479
        L_0x0472:
            r24 = r40
            r10 = r6
            r21 = r7
            r27 = r12
        L_0x0479:
            long r19 = r19 + r29
            int r7 = r21 + 1
            r6 = r10
            r40 = r24
            r12 = r27
            goto L_0x03d9
        L_0x0484:
            r10 = r6
            r0 = 0
            r1 = 0
        L_0x0487:
            int r3 = r10.length
            if (r0 >= r3) goto L_0x0493
            if (r1 != 0) goto L_0x0495
            r1 = r10[r0]
            r1 = r1 & 1
            int r0 = r0 + 1
            goto L_0x0487
        L_0x0493:
            if (r1 == 0) goto L_0x04a5
        L_0x0495:
            com.google.android.gms.internal.ads.zzarb r0 = new com.google.android.gms.internal.ads.zzarb
            r19 = r0
            r20 = r4
            r21 = r5
            r23 = r2
            r24 = r10
            r19.<init>(r20, r21, r22, r23, r24)
            return r0
        L_0x04a5:
            com.google.android.gms.internal.ads.zzann r0 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r1 = "The edited sample sequence does not contain a sync sample."
            r0.<init>(r1)
            throw r0
        L_0x04ad:
            r24 = r9
            r15 = r10
            r27 = r12
            long r0 = r1.zzc
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzava.zzk(r11, r2, r0)
            com.google.android.gms.internal.ads.zzarb r0 = new com.google.android.gms.internal.ads.zzarb
            r7 = r0
            r9 = r24
            r10 = r15
            r12 = r27
            r7.<init>(r8, r9, r10, r11, r12)
            return r0
        L_0x04c6:
            com.google.android.gms.internal.ads.zzann r0 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>(r1)
            goto L_0x04cf
        L_0x04ce:
            throw r0
        L_0x04cf:
            goto L_0x04ce
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqn.zzb(com.google.android.gms.internal.ads.zzaqy, com.google.android.gms.internal.ads.zzaqe, com.google.android.gms.internal.ads.zzapp):com.google.android.gms.internal.ads.zzarb");
    }

    public static zzarq zzc(zzaqf zzaqf, boolean z) {
        if (z) {
            return null;
        }
        zzaut zzaut = zzaqf.zza;
        zzaut.zzi(8);
        while (zzaut.zzd() >= 8) {
            int zzg2 = zzaut.zzg();
            int zzr = zzaut.zzr();
            if (zzaut.zzr() == zzaqg.zzaD) {
                zzaut.zzi(zzg2);
                int i = zzg2 + zzr;
                zzaut.zzj(12);
                while (zzaut.zzg() < i) {
                    int zzg3 = zzaut.zzg();
                    int zzr2 = zzaut.zzr();
                    if (zzaut.zzr() == zzaqg.zzaE) {
                        zzaut.zzi(zzg3);
                        int i2 = zzg3 + zzr2;
                        zzaut.zzj(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzaut.zzg() < i2) {
                            zzarp zza2 = zzaqt.zza(zzaut);
                            if (zza2 != null) {
                                arrayList.add(zza2);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new zzarq((List<? extends zzarp>) arrayList);
                    }
                    zzaut.zzj(zzr2 - 8);
                }
                return null;
            }
            zzaut.zzj(zzr - 8);
        }
        return null;
    }

    public static Pair<String, byte[]> zzd(zzaut zzaut, int i) {
        zzaut.zzi(i + 12);
        zzaut.zzj(1);
        zzf(zzaut);
        zzaut.zzj(2);
        int zzl = zzaut.zzl();
        if ((zzl & 128) != 0) {
            zzaut.zzj(2);
        }
        if ((zzl & 64) != 0) {
            zzaut.zzj(zzaut.zzm());
        }
        if ((zzl & 32) != 0) {
            zzaut.zzj(2);
        }
        zzaut.zzj(1);
        zzf(zzaut);
        int zzl2 = zzaut.zzl();
        String str = null;
        if (zzl2 == 32) {
            str = "video/mp4v-es";
        } else if (zzl2 == 33) {
            str = "video/avc";
        } else if (zzl2 != 35) {
            if (zzl2 != 64) {
                if (zzl2 == 107) {
                    return Pair.create("audio/mpeg", (Object) null);
                }
                if (zzl2 == 165) {
                    str = "audio/ac3";
                } else if (zzl2 != 166) {
                    switch (zzl2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (zzl2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", (Object) null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", (Object) null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzaut.zzj(12);
        zzaut.zzj(1);
        int zzf2 = zzf(zzaut);
        byte[] bArr = new byte[zzf2];
        zzaut.zzk(bArr, 0, zzf2);
        return Pair.create(str, bArr);
    }

    public static int zze(zzaut zzaut, int i, int i2, zzaqj zzaqj, int i3) {
        zzaut zzaut2 = zzaut;
        int zzg2 = zzaut.zzg();
        while (true) {
            boolean z = false;
            if (zzg2 - i >= i2) {
                return 0;
            }
            zzaut.zzi(zzg2);
            int zzr = zzaut.zzr();
            zzaul.zzb(zzr > 0, "childAtomSize should be positive");
            if (zzaut.zzr() == zzaqg.zzY) {
                int i4 = zzg2 + 8;
                Pair pair = null;
                Integer num = null;
                zzaqz zzaqz = null;
                boolean z2 = false;
                while (i4 - zzg2 < zzr) {
                    zzaut.zzi(i4);
                    int zzr2 = zzaut.zzr();
                    int zzr3 = zzaut.zzr();
                    if (zzr3 == zzaqg.zzae) {
                        num = Integer.valueOf(zzaut.zzr());
                    } else if (zzr3 == zzaqg.zzZ) {
                        zzaut.zzj(4);
                        z2 = zzaut.zzr() == zzg;
                    } else if (zzr3 == zzaqg.zzaa) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= zzr2) {
                                zzaqz = null;
                                break;
                            }
                            zzaut.zzi(i5);
                            int zzr4 = zzaut.zzr();
                            if (zzaut.zzr() == zzaqg.zzab) {
                                zzaut.zzj(6);
                                boolean z3 = zzaut.zzl() == 1;
                                int zzl = zzaut.zzl();
                                byte[] bArr = new byte[16];
                                zzaut.zzk(bArr, 0, 16);
                                zzaqz = new zzaqz(z3, zzl, bArr);
                            } else {
                                i5 += zzr4;
                            }
                        }
                    }
                    i4 += zzr2;
                }
                if (z2) {
                    zzaul.zzb(num != null, "frma atom is mandatory");
                    if (zzaqz != null) {
                        z = true;
                    }
                    zzaul.zzb(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzaqz);
                }
                if (pair != null) {
                    zzaqj.zza[i3] = (zzaqz) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            zzaqj zzaqj2 = zzaqj;
            zzg2 += zzr;
        }
    }

    public static int zzf(zzaut zzaut) {
        int zzl = zzaut.zzl();
        int i = zzl & 127;
        while ((zzl & 128) == 128) {
            zzl = zzaut.zzl();
            i = (i << 7) | (zzl & 127);
        }
        return i;
    }
}
