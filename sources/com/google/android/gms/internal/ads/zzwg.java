package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwg {
    public static final byte[] zza = zzalh.zzs("OpusHead");

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e7, code lost:
        r6 = -9223372036854775807L;
     */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x06ff  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0703  */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x08ed  */
    /* JADX WARNING: Removed duplicated region for block: B:488:0x0996  */
    /* JADX WARNING: Removed duplicated region for block: B:491:0x09a9  */
    /* JADX WARNING: Removed duplicated region for block: B:496:0x09c9 A[LOOP:13: B:496:0x09c9->B:500:0x09d3, LOOP_START, PHI: r20 
      PHI: (r20v10 int) = (r20v9 int), (r20v11 int) binds: [B:495:0x09c7, B:500:0x09d3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:503:0x09dc  */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0a1a  */
    /* JADX WARNING: Removed duplicated region for block: B:518:0x0a2b  */
    /* JADX WARNING: Removed duplicated region for block: B:519:0x0a2e  */
    /* JADX WARNING: Removed duplicated region for block: B:524:0x0a8f  */
    /* JADX WARNING: Removed duplicated region for block: B:525:0x0aa6  */
    /* JADX WARNING: Removed duplicated region for block: B:669:0x0d3e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:713:0x09c0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.google.android.gms.internal.ads.zzwy> zza(com.google.android.gms.internal.ads.zzvx r45, com.google.android.gms.internal.ads.zztp r46, long r47, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzsa r49, boolean r50, boolean r51, com.google.android.gms.internal.ads.zzfju<com.google.android.gms.internal.ads.zzwv, com.google.android.gms.internal.ads.zzwv> r52) throws com.google.android.gms.internal.ads.zzlg {
        /*
            r0 = r45
            r1 = r46
            r12 = r49
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r15 = 0
        L_0x000c:
            java.util.List<com.google.android.gms.internal.ads.zzvx> r2 = r0.zzc
            int r2 = r2.size()
            if (r15 >= r2) goto L_0x0d48
            java.util.List<com.google.android.gms.internal.ads.zzvx> r2 = r0.zzc
            java.lang.Object r2 = r2.get(r15)
            r11 = r2
            com.google.android.gms.internal.ads.zzvx r11 = (com.google.android.gms.internal.ads.zzvx) r11
            int r2 = r11.zzd
            r3 = 1953653099(0x7472616b, float:7.681346E31)
            if (r2 == r3) goto L_0x0029
            r1 = r13
            r31 = r15
            goto L_0x0d2d
        L_0x0029:
            r2 = 1836476516(0x6d766864, float:4.7662196E27)
            com.google.android.gms.internal.ads.zzvy r2 = r0.zzc(r2)
            if (r2 == 0) goto L_0x0d46
            r9 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzvx r3 = r11.zzd(r9)
            if (r3 == 0) goto L_0x0d44
            r4 = 1751411826(0x68646c72, float:4.3148E24)
            com.google.android.gms.internal.ads.zzvy r4 = r3.zzc(r4)
            if (r4 == 0) goto L_0x0d42
            com.google.android.gms.internal.ads.zzakr r4 = r4.zza
            int r4 = zze(r4)
            r5 = 1936684398(0x736f756e, float:1.8971874E31)
            r6 = -1
            if (r4 != r5) goto L_0x0052
            r5 = 1
            goto L_0x0079
        L_0x0052:
            r5 = 1986618469(0x76696465, float:1.1834389E33)
            if (r4 != r5) goto L_0x0059
            r5 = 2
            goto L_0x0079
        L_0x0059:
            r5 = 1952807028(0x74657874, float:7.272211E31)
            if (r4 == r5) goto L_0x0078
            r5 = 1935832172(0x7362746c, float:1.7941596E31)
            if (r4 == r5) goto L_0x0078
            r5 = 1937072756(0x73756274, float:1.944137E31)
            if (r4 == r5) goto L_0x0078
            r5 = 1668047728(0x636c6370, float:4.3605968E21)
            if (r4 != r5) goto L_0x006e
            goto L_0x0078
        L_0x006e:
            r5 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r4 != r5) goto L_0x0076
            r4 = 5
            r5 = 5
            goto L_0x0079
        L_0x0076:
            r5 = -1
            goto L_0x0079
        L_0x0078:
            r5 = 3
        L_0x0079:
            r7 = 4
            r31 = r15
            r14 = 0
            if (r5 != r6) goto L_0x0089
            r1 = r52
            r2 = r11
            r32 = r13
            r0 = 0
            r10 = 2
            goto L_0x0734
        L_0x0089:
            r8 = 1953196132(0x746b6864, float:7.46037E31)
            com.google.android.gms.internal.ads.zzvy r8 = r11.zzc(r8)
            if (r8 == 0) goto L_0x0d40
            com.google.android.gms.internal.ads.zzakr r8 = r8.zza
            r4 = 8
            r8.zzh(r4)
            int r20 = r8.zzv()
            int r20 = com.google.android.gms.internal.ads.zzvz.zze(r20)
            if (r20 != 0) goto L_0x00a6
            r9 = 8
            goto L_0x00a8
        L_0x00a6:
            r9 = 16
        L_0x00a8:
            r8.zzk(r9)
            int r9 = r8.zzv()
            r8.zzk(r7)
            int r23 = r8.zzg()
            if (r20 != 0) goto L_0x00ba
            r10 = 4
            goto L_0x00bc
        L_0x00ba:
            r10 = 8
        L_0x00bc:
            r7 = 0
        L_0x00bd:
            r26 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 >= r10) goto L_0x00e4
            byte[] r28 = r8.zzi()
            int r29 = r23 + r7
            byte r4 = r28[r29]
            if (r4 == r6) goto L_0x00e1
            if (r20 != 0) goto L_0x00d5
            long r28 = r8.zzt()
            goto L_0x00d9
        L_0x00d5:
            long r28 = r8.zzD()
        L_0x00d9:
            int r4 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x00de
            goto L_0x00e7
        L_0x00de:
            r6 = r28
            goto L_0x00e9
        L_0x00e1:
            int r7 = r7 + 1
            goto L_0x00bd
        L_0x00e4:
            r8.zzk(r10)
        L_0x00e7:
            r6 = r26
        L_0x00e9:
            r4 = 16
            r8.zzk(r4)
            int r20 = r8.zzv()
            int r4 = r8.zzv()
            r10 = 4
            r8.zzk(r10)
            int r10 = r8.zzv()
            int r8 = r8.zzv()
            r14 = 65536(0x10000, float:9.18355E-41)
            r15 = -65536(0xffffffffffff0000, float:NaN)
            if (r20 != 0) goto L_0x011a
            if (r4 != r14) goto L_0x0118
            if (r10 != r15) goto L_0x0116
            if (r8 != 0) goto L_0x0111
            r4 = 90
            goto L_0x013e
        L_0x0111:
            r4 = 65536(0x10000, float:9.18355E-41)
            r10 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x0118
        L_0x0116:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x0118:
            r20 = 0
        L_0x011a:
            if (r20 != 0) goto L_0x012e
            if (r4 != r15) goto L_0x012a
            if (r10 != r14) goto L_0x0125
            if (r8 != 0) goto L_0x0126
            r4 = 270(0x10e, float:3.78E-43)
            goto L_0x013e
        L_0x0125:
            r14 = r10
        L_0x0126:
            r4 = 0
            r10 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x0132
        L_0x012a:
            r14 = r10
            r10 = r4
            r4 = 0
            goto L_0x0132
        L_0x012e:
            r14 = r10
            r10 = r4
            r4 = r20
        L_0x0132:
            if (r4 != r15) goto L_0x013d
            if (r10 != 0) goto L_0x013d
            if (r14 != 0) goto L_0x013d
            if (r8 != r15) goto L_0x013d
            r4 = 180(0xb4, float:2.52E-43)
            goto L_0x013e
        L_0x013d:
            r4 = 0
        L_0x013e:
            com.google.android.gms.internal.ads.zzwf r14 = new com.google.android.gms.internal.ads.zzwf
            r14.<init>(r9, r6, r4)
            int r4 = (r47 > r26 ? 1 : (r47 == r26 ? 0 : -1))
            if (r4 != 0) goto L_0x014e
            long r6 = r14.zzb
            r32 = r6
            goto L_0x0150
        L_0x014e:
            r32 = r47
        L_0x0150:
            com.google.android.gms.internal.ads.zzakr r2 = r2.zza
            r4 = 8
            r2.zzh(r4)
            int r4 = r2.zzv()
            int r4 = com.google.android.gms.internal.ads.zzvz.zze(r4)
            if (r4 != 0) goto L_0x0164
            r4 = 8
            goto L_0x0166
        L_0x0164:
            r4 = 16
        L_0x0166:
            r2.zzk(r4)
            long r28 = r2.zzt()
            int r2 = (r32 > r26 ? 1 : (r32 == r26 ? 0 : -1))
            if (r2 != 0) goto L_0x0172
            goto L_0x017d
        L_0x0172:
            r34 = 1000000(0xf4240, double:4.940656E-318)
            r36 = r28
            long r6 = com.google.android.gms.internal.ads.zzalh.zzF(r32, r34, r36)
            r26 = r6
        L_0x017d:
            r2 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzvx r4 = r3.zzd(r2)
            if (r4 == 0) goto L_0x0d3e
            r6 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzvx r2 = r4.zzd(r6)
            if (r2 == 0) goto L_0x0d3c
            r4 = 1835296868(0x6d646864, float:4.418049E27)
            com.google.android.gms.internal.ads.zzvy r3 = r3.zzc(r4)
            if (r3 == 0) goto L_0x0d3a
            com.google.android.gms.internal.ads.zzakr r3 = r3.zza
            r4 = 8
            r3.zzh(r4)
            int r7 = r3.zzv()
            int r7 = com.google.android.gms.internal.ads.zzvz.zze(r7)
            if (r7 != 0) goto L_0x01ac
            r8 = 8
            goto L_0x01ae
        L_0x01ac:
            r8 = 16
        L_0x01ae:
            r3.zzk(r8)
            long r8 = r3.zzt()
            if (r7 != 0) goto L_0x01b9
            r7 = 4
            goto L_0x01bb
        L_0x01b9:
            r7 = 8
        L_0x01bb:
            r3.zzk(r7)
            int r3 = r3.zzo()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r10 = 3
            r7.<init>(r10)
            int r15 = r3 >> 10
            r15 = r15 & 31
            int r15 = r15 + 96
            char r15 = (char) r15
            r7.append(r15)
            int r15 = r3 >> 5
            r15 = r15 & 31
            int r15 = r15 + 96
            char r15 = (char) r15
            r7.append(r15)
            r3 = r3 & 31
            int r3 = r3 + 96
            char r3 = (char) r3
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            java.lang.Long r7 = java.lang.Long.valueOf(r8)
            android.util.Pair r15 = android.util.Pair.create(r7, r3)
            r3 = 1937011556(0x73747364, float:1.9367383E31)
            com.google.android.gms.internal.ads.zzvy r2 = r2.zzc(r3)
            if (r2 == 0) goto L_0x0d38
            com.google.android.gms.internal.ads.zzakr r9 = r2.zza
            int r8 = r14.zza
            int r7 = r14.zzc
            java.lang.Object r2 = r15.second
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            r2 = 12
            r9.zzh(r2)
            int r0 = r9.zzv()
            r32 = r13
            com.google.android.gms.internal.ads.zzwc r13 = new com.google.android.gms.internal.ads.zzwc
            r13.<init>(r0)
            r1 = 0
        L_0x0219:
            if (r1 >= r0) goto L_0x067e
            r16 = r0
            int r0 = r9.zzg()
            r17 = r15
            int r15 = r9.zzv()
            if (r15 <= 0) goto L_0x022b
            r2 = 1
            goto L_0x022c
        L_0x022b:
            r2 = 0
        L_0x022c:
            java.lang.String r4 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzte.zza(r2, r4)
            int r4 = r9.zzv()
            r2 = 1635148593(0x61766331, float:2.840654E20)
            r6 = 1701733238(0x656e6376, float:7.035987E22)
            if (r4 == r2) goto L_0x041f
            r2 = 1635148595(0x61766333, float:2.8406544E20)
            if (r4 == r2) goto L_0x041f
            if (r4 == r6) goto L_0x041f
            r2 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r4 == r2) goto L_0x041f
            r2 = 1836070006(0x6d703476, float:4.646239E27)
            if (r4 == r2) goto L_0x041f
            r2 = 1752589105(0x68766331, float:4.6541277E24)
            if (r4 == r2) goto L_0x041f
            r2 = 1751479857(0x68657631, float:4.3344087E24)
            if (r4 == r2) goto L_0x041f
            r2 = 1932670515(0x73323633, float:1.4119387E31)
            if (r4 == r2) goto L_0x041f
            r2 = 1987063864(0x76703038, float:1.21789965E33)
            if (r4 == r2) goto L_0x041f
            r2 = 1987063865(0x76703039, float:1.2178997E33)
            if (r4 == r2) goto L_0x041f
            r2 = 1635135537(0x61763031, float:2.8383572E20)
            if (r4 == r2) goto L_0x041f
            r2 = 1685479798(0x64766176, float:1.8179687E22)
            if (r4 == r2) goto L_0x041f
            r2 = 1685479729(0x64766131, float:1.817961E22)
            if (r4 == r2) goto L_0x041f
            r2 = 1685481573(0x64766865, float:1.8181686E22)
            if (r4 == r2) goto L_0x041f
            r2 = 1685481521(0x64766831, float:1.8181627E22)
            if (r4 != r2) goto L_0x0282
            goto L_0x041f
        L_0x0282:
            r2 = 1836069985(0x6d703461, float:4.6462328E27)
            if (r4 == r2) goto L_0x03e6
            r2 = 1701733217(0x656e6361, float:7.0359778E22)
            if (r4 == r2) goto L_0x03e6
            r2 = 1633889587(0x61632d33, float:2.6191674E20)
            if (r4 == r2) goto L_0x03e6
            r2 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r4 == r2) goto L_0x03e6
            r2 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r4 == r2) goto L_0x03e6
            r2 = 1685353315(0x64747363, float:1.803728E22)
            if (r4 == r2) goto L_0x03e6
            r2 = 1685353317(0x64747365, float:1.8037282E22)
            if (r4 == r2) goto L_0x03e6
            r2 = 1685353320(0x64747368, float:1.8037286E22)
            if (r4 == r2) goto L_0x03e6
            r2 = 1685353324(0x6474736c, float:1.803729E22)
            if (r4 == r2) goto L_0x03e6
            r2 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r4 == r2) goto L_0x03e6
            r2 = 1935767394(0x73617762, float:1.7863284E31)
            if (r4 == r2) goto L_0x03e6
            r2 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r4 == r2) goto L_0x03e6
            r2 = 1936684916(0x736f7774, float:1.89725E31)
            if (r4 == r2) goto L_0x03e6
            r2 = 1953984371(0x74776f73, float:7.841539E31)
            if (r4 == r2) goto L_0x03e6
            r2 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r4 == r2) goto L_0x03e6
            r2 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r4 == r2) goto L_0x03e6
            r2 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r4 == r2) goto L_0x03e6
            r2 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r4 == r2) goto L_0x03e6
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r4 == r2) goto L_0x03e6
            r2 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r4 == r2) goto L_0x03e6
            r2 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r4 == r2) goto L_0x03e6
            r2 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r4 == r2) goto L_0x03e6
            r2 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r4 != r2) goto L_0x02f7
            goto L_0x03e6
        L_0x02f7:
            r2 = 1414810956(0x54544d4c, float:3.64731957E12)
            if (r4 == r2) goto L_0x0364
            r2 = 1954034535(0x74783367, float:7.865797E31)
            if (r4 == r2) goto L_0x0364
            r2 = 2004251764(0x77767474, float:4.998699E33)
            if (r4 == r2) goto L_0x0364
            r2 = 1937010800(0x73747070, float:1.9366469E31)
            if (r4 == r2) goto L_0x0364
            r2 = 1664495672(0x63363038, float:3.360782E21)
            if (r4 != r2) goto L_0x0311
            goto L_0x0364
        L_0x0311:
            r2 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r4 != r2) goto L_0x0337
            int r2 = r0 + 16
            r9.zzh(r2)
            r2 = 0
            r9.zzG(r2)
            java.lang.String r4 = r9.zzG(r2)
            if (r4 == 0) goto L_0x034f
            com.google.android.gms.internal.ads.zzkb r2 = new com.google.android.gms.internal.ads.zzkb
            r2.<init>()
            r2.zzb(r8)
            r2.zzj(r4)
            com.google.android.gms.internal.ads.zzkc r2 = r2.zzD()
            r13.zzb = r2
            goto L_0x034f
        L_0x0337:
            r2 = 1667329389(0x63616d6d, float:4.1584024E21)
            if (r4 != r2) goto L_0x034f
            com.google.android.gms.internal.ads.zzkb r2 = new com.google.android.gms.internal.ads.zzkb
            r2.<init>()
            r2.zzb(r8)
            java.lang.String r4 = "application/x-camera-motion"
            r2.zzj(r4)
            com.google.android.gms.internal.ads.zzkc r2 = r2.zzD()
            r13.zzb = r2
        L_0x034f:
            r24 = r0
            r18 = r1
            r19 = r3
            r21 = r5
            r3 = r7
            r2 = r8
            r41 = r11
            r20 = r14
            r33 = r15
            r4 = 3
            r10 = 2
            r14 = r9
            goto L_0x065c
        L_0x0364:
            int r2 = r0 + 16
            r9.zzh(r2)
            r2 = 1414810956(0x54544d4c, float:3.64731957E12)
            r33 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r4 != r2) goto L_0x037d
            java.lang.String r2 = "application/ttml+xml"
        L_0x0375:
            r4 = 0
            r42 = r33
            r33 = r11
            r10 = r42
            goto L_0x03b7
        L_0x037d:
            r2 = 1954034535(0x74783367, float:7.865797E31)
            if (r4 != r2) goto L_0x039c
            int r2 = r15 + -16
            byte[] r4 = new byte[r2]
            r6 = 0
            r9.zzm(r4, r6, r2)
            com.google.android.gms.internal.ads.zzfml r2 = com.google.android.gms.internal.ads.zzfml.zzj(r4)
            java.lang.String r4 = "application/x-quicktime-tx3g"
            r42 = r4
            r4 = r2
            r2 = r42
            r43 = r33
            r33 = r11
            r10 = r43
            goto L_0x03b7
        L_0x039c:
            r2 = 2004251764(0x77767474, float:4.998699E33)
            if (r4 != r2) goto L_0x03a4
            java.lang.String r2 = "application/x-mp4-vtt"
            goto L_0x0375
        L_0x03a4:
            r2 = 1937010800(0x73747070, float:1.9366469E31)
            if (r4 != r2) goto L_0x03b1
            java.lang.String r2 = "application/ttml+xml"
            r33 = r11
            r4 = 0
            r10 = 0
            goto L_0x03b7
        L_0x03b1:
            r2 = 1
            r13.zzd = r2
            java.lang.String r2 = "application/x-mp4-cea-608"
            goto L_0x0375
        L_0x03b7:
            com.google.android.gms.internal.ads.zzkb r6 = new com.google.android.gms.internal.ads.zzkb
            r6.<init>()
            r6.zzb(r8)
            r6.zzj(r2)
            r6.zzd(r3)
            r6.zzn(r10)
            r6.zzl(r4)
            com.google.android.gms.internal.ads.zzkc r2 = r6.zzD()
            r13.zzb = r2
            r24 = r0
            r18 = r1
            r19 = r3
            r21 = r5
            r3 = r7
            r2 = r8
            r20 = r14
            r41 = r33
            r4 = 3
            r10 = 2
            r14 = r9
            r33 = r15
            goto L_0x065c
        L_0x03e6:
            r33 = r11
            r10 = 12
            r2 = r9
            r19 = r3
            r3 = r4
            r20 = r14
            r6 = 16
            r11 = 1937007212(0x7374626c, float:1.9362132E31)
            r14 = 8
            r4 = r0
            r21 = r5
            r5 = r15
            r14 = 16
            r6 = r8
            r10 = r7
            r7 = r19
            r39 = r8
            r8 = r51
            r14 = r9
            r9 = r49
            r40 = r10
            r10 = r13
            r41 = r33
            r11 = r1
            zzf(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r24 = r0
            r18 = r1
            r33 = r15
            r2 = r39
            r3 = r40
            r4 = 3
            r10 = 2
            goto L_0x065c
        L_0x041f:
            r19 = r3
            r21 = r5
            r40 = r7
            r39 = r8
            r41 = r11
            r20 = r14
            r14 = r9
            int r2 = r0 + 16
            r14.zzh(r2)
            r2 = 16
            r14.zzk(r2)
            int r3 = r14.zzo()
            int r5 = r14.zzo()
            r7 = 50
            r14.zzk(r7)
            int r7 = r14.zzg()
            if (r4 != r6) goto L_0x0477
            android.util.Pair r4 = zzh(r14, r0, r15)
            if (r4 == 0) goto L_0x046f
            java.lang.Object r6 = r4.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r12 != 0) goto L_0x045b
            r10 = 0
            goto L_0x0465
        L_0x045b:
            java.lang.Object r8 = r4.second
            com.google.android.gms.internal.ads.zzww r8 = (com.google.android.gms.internal.ads.zzww) r8
            java.lang.String r8 = r8.zzb
            com.google.android.gms.internal.ads.zzsa r10 = r12.zza(r8)
        L_0x0465:
            com.google.android.gms.internal.ads.zzww[] r8 = r13.zza
            java.lang.Object r4 = r4.second
            com.google.android.gms.internal.ads.zzww r4 = (com.google.android.gms.internal.ads.zzww) r4
            r8[r1] = r4
            r4 = r6
            goto L_0x0473
        L_0x046f:
            r10 = r12
            r4 = 1701733238(0x656e6376, float:7.035987E22)
        L_0x0473:
            r14.zzh(r7)
            goto L_0x0478
        L_0x0477:
            r10 = r12
        L_0x0478:
            r6 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r4 != r6) goto L_0x0480
            java.lang.String r6 = "video/mpeg"
            goto L_0x0481
        L_0x0480:
            r6 = 0
        L_0x0481:
            r8 = 1065353216(0x3f800000, float:1.0)
            r18 = r1
            r8 = r7
            r22 = r10
            r1 = 0
            r2 = 0
            r9 = -1
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r7 = r6
            r6 = 0
        L_0x0490:
            int r10 = r8 - r0
            if (r10 >= r15) goto L_0x0619
            r14.zzh(r8)
            int r10 = r14.zzg()
            int r24 = r14.zzv()
            if (r24 != 0) goto L_0x04b1
            int r24 = r14.zzg()
            r25 = r2
            int r2 = r24 - r0
            if (r2 != r15) goto L_0x04af
            r24 = r0
            goto L_0x061d
        L_0x04af:
            r2 = 0
            goto L_0x04b5
        L_0x04b1:
            r25 = r2
            r2 = r24
        L_0x04b5:
            if (r2 <= 0) goto L_0x04bd
            r24 = r0
            r33 = r15
            r0 = 1
            goto L_0x04c2
        L_0x04bd:
            r24 = r0
            r33 = r15
            r0 = 0
        L_0x04c2:
            java.lang.String r15 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzte.zza(r0, r15)
            int r0 = r14.zzv()
            r15 = 1635148611(0x61766343, float:2.8406573E20)
            if (r0 != r15) goto L_0x04f1
            if (r7 != 0) goto L_0x04d4
            r0 = 1
            goto L_0x04d5
        L_0x04d4:
            r0 = 0
        L_0x04d5:
            r15 = 0
            com.google.android.gms.internal.ads.zzte.zza(r0, r15)
            int r10 = r10 + 8
            r14.zzh(r10)
            com.google.android.gms.internal.ads.zzalj r0 = com.google.android.gms.internal.ads.zzalj.zza(r14)
            java.util.List<byte[]> r7 = r0.zza
            int r10 = r0.zzb
            r13.zzc = r10
            if (r6 != 0) goto L_0x04ec
            float r11 = r0.zze
        L_0x04ec:
            java.lang.String r0 = r0.zzf
            java.lang.String r10 = "video/avc"
            goto L_0x0512
        L_0x04f1:
            r15 = 1752589123(0x68766343, float:4.6541328E24)
            if (r0 != r15) goto L_0x051c
            if (r7 != 0) goto L_0x04fa
            r0 = 1
            goto L_0x04fb
        L_0x04fa:
            r0 = 0
        L_0x04fb:
            r7 = 0
            com.google.android.gms.internal.ads.zzte.zza(r0, r7)
            int r10 = r10 + 8
            r14.zzh(r10)
            com.google.android.gms.internal.ads.zzals r0 = com.google.android.gms.internal.ads.zzals.zza(r14)
            java.util.List<byte[]> r7 = r0.zza
            int r10 = r0.zzb
            r13.zzc = r10
            java.lang.String r0 = r0.zzc
            java.lang.String r10 = "video/hevc"
        L_0x0512:
            r12 = r0
            r34 = r4
            r25 = r7
            r7 = r10
        L_0x0518:
            r4 = 3
        L_0x0519:
            r10 = 2
            goto L_0x060e
        L_0x051c:
            r15 = 1685480259(0x64766343, float:1.8180206E22)
            if (r0 == r15) goto L_0x0600
            r15 = 1685485123(0x64767643, float:1.8185683E22)
            if (r0 != r15) goto L_0x0528
            goto L_0x0600
        L_0x0528:
            r15 = 1987076931(0x76706343, float:1.21891066E33)
            if (r0 != r15) goto L_0x0541
            if (r7 != 0) goto L_0x0531
            r0 = 1
            goto L_0x0532
        L_0x0531:
            r0 = 0
        L_0x0532:
            r7 = 0
            com.google.android.gms.internal.ads.zzte.zza(r0, r7)
            r0 = 1987063864(0x76703038, float:1.21789965E33)
            if (r4 != r0) goto L_0x053e
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x0551
        L_0x053e:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
            goto L_0x0551
        L_0x0541:
            r15 = 1635135811(0x61763143, float:2.8384055E20)
            if (r0 != r15) goto L_0x0555
            if (r7 != 0) goto L_0x054a
            r0 = 1
            goto L_0x054b
        L_0x054a:
            r0 = 0
        L_0x054b:
            r15 = 0
            com.google.android.gms.internal.ads.zzte.zza(r0, r15)
            java.lang.String r0 = "video/av01"
        L_0x0551:
            r7 = r0
        L_0x0552:
            r34 = r4
            goto L_0x0518
        L_0x0555:
            r15 = 1681012275(0x64323633, float:1.3149704E22)
            if (r0 != r15) goto L_0x0566
            if (r7 != 0) goto L_0x055e
            r0 = 1
            goto L_0x055f
        L_0x055e:
            r0 = 0
        L_0x055f:
            r15 = 0
            com.google.android.gms.internal.ads.zzte.zza(r0, r15)
            java.lang.String r0 = "video/3gpp"
            goto L_0x0551
        L_0x0566:
            r15 = 1702061171(0x65736473, float:7.183675E22)
            if (r0 != r15) goto L_0x0589
            if (r7 != 0) goto L_0x056f
            r0 = 1
            goto L_0x0570
        L_0x056f:
            r0 = 0
        L_0x0570:
            r7 = 0
            com.google.android.gms.internal.ads.zzte.zza(r0, r7)
            android.util.Pair r0 = zzg(r14, r10)
            java.lang.Object r7 = r0.first
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r0.second
            byte[] r0 = (byte[]) r0
            if (r0 == 0) goto L_0x0552
            com.google.android.gms.internal.ads.zzfml r0 = com.google.android.gms.internal.ads.zzfml.zzj(r0)
            r25 = r0
            goto L_0x0552
        L_0x0589:
            r15 = 1885434736(0x70617370, float:2.7909473E29)
            if (r0 != r15) goto L_0x05a5
            int r10 = r10 + 8
            r14.zzh(r10)
            int r0 = r14.zzB()
            float r0 = (float) r0
            int r6 = r14.zzB()
            float r6 = (float) r6
            float r0 = r0 / r6
            r11 = r0
            r34 = r4
            r4 = 3
            r6 = 1
            goto L_0x0519
        L_0x05a5:
            r15 = 1937126244(0x73763364, float:1.9506033E31)
            if (r0 != r15) goto L_0x05d6
            int r0 = r10 + 8
        L_0x05ac:
            int r1 = r0 - r10
            if (r1 >= r2) goto L_0x05d0
            r14.zzh(r0)
            int r1 = r14.zzv()
            int r15 = r14.zzv()
            r34 = r4
            r4 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r15 != r4) goto L_0x05cc
            byte[] r4 = r14.zzi()
            int r1 = r1 + r0
            byte[] r10 = java.util.Arrays.copyOfRange(r4, r0, r1)
            goto L_0x05d3
        L_0x05cc:
            int r0 = r0 + r1
            r4 = r34
            goto L_0x05ac
        L_0x05d0:
            r34 = r4
            r10 = 0
        L_0x05d3:
            r1 = r10
            goto L_0x0518
        L_0x05d6:
            r34 = r4
            r4 = 1936995172(0x73743364, float:1.9347576E31)
            if (r0 != r4) goto L_0x0518
            int r0 = r14.zzn()
            r4 = 3
            r14.zzk(r4)
            if (r0 != 0) goto L_0x0519
            int r0 = r14.zzn()
            if (r0 == 0) goto L_0x05fd
            r10 = 1
            if (r0 == r10) goto L_0x05fa
            r10 = 2
            if (r0 == r10) goto L_0x05f8
            if (r0 == r4) goto L_0x05f6
            goto L_0x060e
        L_0x05f6:
            r9 = 3
            goto L_0x060e
        L_0x05f8:
            r9 = 2
            goto L_0x060e
        L_0x05fa:
            r10 = 2
            r9 = 1
            goto L_0x060e
        L_0x05fd:
            r10 = 2
            r9 = 0
            goto L_0x060e
        L_0x0600:
            r34 = r4
            r4 = 3
            r10 = 2
            com.google.android.gms.internal.ads.zzalm r0 = com.google.android.gms.internal.ads.zzalm.zza(r14)
            if (r0 == 0) goto L_0x060e
            java.lang.String r12 = r0.zza
            java.lang.String r7 = "video/dolby-vision"
        L_0x060e:
            int r8 = r8 + r2
            r0 = r24
            r2 = r25
            r15 = r33
            r4 = r34
            goto L_0x0490
        L_0x0619:
            r24 = r0
            r25 = r2
        L_0x061d:
            r33 = r15
            r4 = 3
            r10 = 2
            if (r7 == 0) goto L_0x0658
            com.google.android.gms.internal.ads.zzkb r0 = new com.google.android.gms.internal.ads.zzkb
            r0.<init>()
            r2 = r39
            r0.zzb(r2)
            r0.zzj(r7)
            r0.zzh(r12)
            r0.zzo(r3)
            r0.zzp(r5)
            r0.zzs(r11)
            r3 = r40
            r0.zzr(r3)
            r0.zzt(r1)
            r0.zzu(r9)
            r1 = r25
            r0.zzl(r1)
            r12 = r22
            r0.zzm(r12)
            com.google.android.gms.internal.ads.zzkc r0 = r0.zzD()
            r13.zzb = r0
            goto L_0x065c
        L_0x0658:
            r2 = r39
            r3 = r40
        L_0x065c:
            int r0 = r24 + r33
            r14.zzh(r0)
            int r1 = r18 + 1
            r12 = r49
            r8 = r2
            r7 = r3
            r9 = r14
            r0 = r16
            r15 = r17
            r3 = r19
            r14 = r20
            r5 = r21
            r11 = r41
            r2 = 12
            r4 = 8
            r6 = 1937007212(0x7374626c, float:1.9362132E31)
            r10 = 3
            goto L_0x0219
        L_0x067e:
            r21 = r5
            r41 = r11
            r20 = r14
            r17 = r15
            r10 = 2
            r0 = 1701082227(0x65647473, float:6.742798E22)
            r2 = r41
            com.google.android.gms.internal.ads.zzvx r0 = r2.zzd(r0)
            if (r0 == 0) goto L_0x06f8
            r1 = 1701606260(0x656c7374, float:6.9788014E22)
            com.google.android.gms.internal.ads.zzvy r0 = r0.zzc(r1)
            if (r0 != 0) goto L_0x069d
            r0 = 0
            goto L_0x06eb
        L_0x069d:
            com.google.android.gms.internal.ads.zzakr r0 = r0.zza
            r1 = 8
            r0.zzh(r1)
            int r1 = r0.zzv()
            int r1 = com.google.android.gms.internal.ads.zzvz.zze(r1)
            int r3 = r0.zzB()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r6 = 0
        L_0x06b5:
            if (r6 >= r3) goto L_0x06e7
            r7 = 1
            if (r1 != r7) goto L_0x06bf
            long r8 = r0.zzD()
            goto L_0x06c3
        L_0x06bf:
            long r8 = r0.zzt()
        L_0x06c3:
            r4[r6] = r8
            if (r1 != r7) goto L_0x06cc
            long r8 = r0.zzx()
            goto L_0x06d1
        L_0x06cc:
            int r8 = r0.zzv()
            long r8 = (long) r8
        L_0x06d1:
            r5[r6] = r8
            short r8 = r0.zzq()
            if (r8 != r7) goto L_0x06df
            r0.zzk(r10)
            int r6 = r6 + 1
            goto L_0x06b5
        L_0x06df:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x06e7:
            android.util.Pair r0 = android.util.Pair.create(r4, r5)
        L_0x06eb:
            if (r0 == 0) goto L_0x06f8
            java.lang.Object r1 = r0.first
            long[] r1 = (long[]) r1
            java.lang.Object r0 = r0.second
            long[] r0 = (long[]) r0
            r30 = r0
            goto L_0x06fb
        L_0x06f8:
            r1 = 0
            r30 = 0
        L_0x06fb:
            com.google.android.gms.internal.ads.zzkc r0 = r13.zzb
            if (r0 != 0) goto L_0x0703
            r1 = r52
            r0 = 0
            goto L_0x0734
        L_0x0703:
            com.google.android.gms.internal.ads.zzwv r0 = new com.google.android.gms.internal.ads.zzwv
            int r3 = r20.zza
            r4 = r17
            java.lang.Object r4 = r4.first
            java.lang.Long r4 = (java.lang.Long) r4
            long r19 = r4.longValue()
            com.google.android.gms.internal.ads.zzkc r4 = r13.zzb
            int r5 = r13.zzd
            com.google.android.gms.internal.ads.zzww[] r6 = r13.zza
            int r7 = r13.zzc
            r16 = r0
            r17 = r3
            r18 = r21
            r21 = r28
            r23 = r26
            r25 = r4
            r26 = r5
            r27 = r6
            r28 = r7
            r29 = r1
            r16.<init>(r17, r18, r19, r21, r23, r25, r26, r27, r28, r29, r30)
            r1 = r52
        L_0x0734:
            java.lang.Object r0 = r1.apply(r0)
            r12 = r0
            com.google.android.gms.internal.ads.zzwv r12 = (com.google.android.gms.internal.ads.zzwv) r12
            if (r12 == 0) goto L_0x0d2b
            r0 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzvx r0 = r2.zzd(r0)
            if (r0 == 0) goto L_0x0d29
            r2 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzvx r0 = r0.zzd(r2)
            if (r0 == 0) goto L_0x0d27
            r2 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzvx r0 = r0.zzd(r2)
            if (r0 == 0) goto L_0x0d25
            r2 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.gms.internal.ads.zzvy r2 = r0.zzc(r2)
            if (r2 == 0) goto L_0x0769
            com.google.android.gms.internal.ads.zzwd r3 = new com.google.android.gms.internal.ads.zzwd
            com.google.android.gms.internal.ads.zzkc r4 = r12.zzf
            r3.<init>(r2, r4)
            goto L_0x0777
        L_0x0769:
            r2 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.gms.internal.ads.zzvy r2 = r0.zzc(r2)
            if (r2 == 0) goto L_0x0d1d
            com.google.android.gms.internal.ads.zzwe r3 = new com.google.android.gms.internal.ads.zzwe
            r3.<init>(r2)
        L_0x0777:
            int r2 = r3.zza()
            if (r2 != 0) goto L_0x0797
            com.google.android.gms.internal.ads.zzwy r0 = new com.google.android.gms.internal.ads.zzwy
            r2 = 0
            long[] r13 = new long[r2]
            int[] r14 = new int[r2]
            r15 = 0
            long[] r3 = new long[r2]
            int[] r4 = new int[r2]
            r18 = 0
            r11 = r0
            r16 = r3
            r17 = r4
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
        L_0x0793:
            r1 = r32
            goto L_0x0d13
        L_0x0797:
            r4 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.gms.internal.ads.zzvy r4 = r0.zzc(r4)
            if (r4 != 0) goto L_0x07ae
            r4 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.gms.internal.ads.zzvy r4 = r0.zzc(r4)
            if (r4 == 0) goto L_0x07ac
            r5 = r4
            r4 = 1
            goto L_0x07b0
        L_0x07ac:
            r4 = 0
            throw r4
        L_0x07ae:
            r5 = r4
            r4 = 0
        L_0x07b0:
            com.google.android.gms.internal.ads.zzakr r5 = r5.zza
            r6 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.gms.internal.ads.zzvy r6 = r0.zzc(r6)
            if (r6 == 0) goto L_0x0d1b
            com.google.android.gms.internal.ads.zzakr r6 = r6.zza
            r7 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.gms.internal.ads.zzvy r7 = r0.zzc(r7)
            if (r7 == 0) goto L_0x0d19
            com.google.android.gms.internal.ads.zzakr r7 = r7.zza
            r8 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.gms.internal.ads.zzvy r8 = r0.zzc(r8)
            if (r8 == 0) goto L_0x07d4
            com.google.android.gms.internal.ads.zzakr r8 = r8.zza
            goto L_0x07d5
        L_0x07d4:
            r8 = 0
        L_0x07d5:
            r9 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.gms.internal.ads.zzvy r0 = r0.zzc(r9)
            if (r0 == 0) goto L_0x07e1
            com.google.android.gms.internal.ads.zzakr r0 = r0.zza
            goto L_0x07e2
        L_0x07e1:
            r0 = 0
        L_0x07e2:
            com.google.android.gms.internal.ads.zzwa r9 = new com.google.android.gms.internal.ads.zzwa
            r9.<init>(r6, r5, r4)
            r4 = 12
            r7.zzh(r4)
            int r5 = r7.zzB()
            r6 = -1
            int r5 = r5 + r6
            int r11 = r7.zzB()
            int r13 = r7.zzB()
            if (r0 == 0) goto L_0x0804
            r0.zzh(r4)
            int r14 = r0.zzB()
            goto L_0x0805
        L_0x0804:
            r14 = 0
        L_0x0805:
            if (r8 == 0) goto L_0x0818
            r8.zzh(r4)
            int r4 = r8.zzB()
            if (r4 <= 0) goto L_0x0816
            int r15 = r8.zzB()
            int r15 = r15 + r6
            goto L_0x081a
        L_0x0816:
            r8 = 0
            goto L_0x0819
        L_0x0818:
            r4 = 0
        L_0x0819:
            r15 = -1
        L_0x081a:
            int r10 = r3.zzb()
            com.google.android.gms.internal.ads.zzkc r1 = r12.zzf
            java.lang.String r1 = r1.zzl
            if (r10 == r6) goto L_0x08cd
            java.lang.String r6 = "audio/raw"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x083c
            java.lang.String r6 = "audio/g711-mlaw"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x083c
            java.lang.String r6 = "audio/g711-alaw"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x08cd
        L_0x083c:
            if (r5 != 0) goto L_0x08cd
            if (r14 != 0) goto L_0x08cc
            if (r4 != 0) goto L_0x08cc
            int r0 = r9.zza
            long[] r1 = new long[r0]
            int[] r3 = new int[r0]
        L_0x0848:
            boolean r4 = r9.zza()
            if (r4 == 0) goto L_0x0859
            int r4 = r9.zzb
            long r5 = r9.zzd
            r1[r4] = r5
            int r5 = r9.zzc
            r3[r4] = r5
            goto L_0x0848
        L_0x0859:
            long r4 = (long) r13
            r6 = 8192(0x2000, float:1.14794E-41)
            int r6 = r6 / r10
            r7 = 0
            r8 = 0
        L_0x085f:
            if (r7 >= r0) goto L_0x086b
            r9 = r3[r7]
            int r9 = com.google.android.gms.internal.ads.zzalh.zzw(r9, r6)
            int r8 = r8 + r9
            int r7 = r7 + 1
            goto L_0x085f
        L_0x086b:
            long[] r7 = new long[r8]
            int[] r9 = new int[r8]
            long[] r11 = new long[r8]
            int[] r8 = new int[r8]
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x0878:
            if (r13 >= r0) goto L_0x08be
            r17 = r3[r13]
            r18 = r1[r13]
            r42 = r17
            r17 = r0
            r0 = r42
        L_0x0884:
            if (r0 <= 0) goto L_0x08b2
            int r20 = java.lang.Math.min(r6, r0)
            r7[r16] = r18
            r21 = r1
            int r1 = r10 * r20
            r9[r16] = r1
            int r15 = java.lang.Math.max(r15, r1)
            r1 = r6
            r22 = r7
            long r6 = (long) r14
            long r6 = r6 * r4
            r11[r16] = r6
            r6 = 1
            r8[r16] = r6
            r6 = r9[r16]
            long r6 = (long) r6
            long r18 = r18 + r6
            int r14 = r14 + r20
            int r0 = r0 - r20
            int r16 = r16 + 1
            r6 = r1
            r1 = r21
            r7 = r22
            goto L_0x0884
        L_0x08b2:
            r21 = r1
            r1 = r6
            r22 = r7
            int r13 = r13 + 1
            r0 = r17
            r1 = r21
            goto L_0x0878
        L_0x08be:
            r22 = r7
            long r0 = (long) r14
            long r4 = r4 * r0
            r0 = r4
            r14 = r9
            r10 = r11
            r13 = r12
            r9 = r22
            r12 = r8
            goto L_0x0a81
        L_0x08cc:
            r5 = 0
        L_0x08cd:
            long[] r1 = new long[r2]
            int[] r6 = new int[r2]
            long[] r10 = new long[r2]
            r16 = r4
            int[] r4 = new int[r2]
            r17 = r11
            r19 = r12
            r12 = r13
            r20 = r14
            r14 = r15
            r11 = 0
            r13 = 0
            r18 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r15 = r5
            r5 = 0
        L_0x08eb:
            if (r5 >= r2) goto L_0x09c0
            r26 = 1
        L_0x08ef:
            if (r18 != 0) goto L_0x0914
            boolean r26 = r9.zza()
            if (r26 == 0) goto L_0x090c
            r28 = r12
            r27 = r13
            long r12 = r9.zzd
            r29 = r2
            int r2 = r9.zzc
            r18 = r2
            r22 = r12
            r13 = r27
            r12 = r28
            r2 = r29
            goto L_0x08ef
        L_0x090c:
            r29 = r2
            r28 = r12
            r27 = r13
            r2 = 0
            goto L_0x091c
        L_0x0914:
            r29 = r2
            r28 = r12
            r27 = r13
            r2 = r18
        L_0x091c:
            if (r26 != 0) goto L_0x093a
            java.lang.String r2 = "AtomParsers"
            java.lang.String r3 = "Unexpected end of chunk data"
            android.util.Log.w(r2, r3)
            long[] r1 = java.util.Arrays.copyOf(r1, r5)
            int[] r6 = java.util.Arrays.copyOf(r6, r5)
            long[] r10 = java.util.Arrays.copyOf(r10, r5)
            int[] r4 = java.util.Arrays.copyOf(r4, r5)
            r2 = r5
            r13 = r27
            goto L_0x09c4
        L_0x093a:
            if (r0 == 0) goto L_0x0955
            r13 = r27
        L_0x093e:
            if (r21 != 0) goto L_0x0951
            if (r20 <= 0) goto L_0x094d
            int r21 = r0.zzB()
            int r13 = r0.zzv()
            int r20 = r20 + -1
            goto L_0x093e
        L_0x094d:
            r12 = -1
            r21 = 0
            goto L_0x0952
        L_0x0951:
            r12 = -1
        L_0x0952:
            int r21 = r21 + -1
            goto L_0x0957
        L_0x0955:
            r13 = r27
        L_0x0957:
            r1[r5] = r22
            int r12 = r3.zzc()
            r6[r5] = r12
            if (r12 <= r11) goto L_0x0964
            r18 = r12
            goto L_0x0966
        L_0x0964:
            r18 = r11
        L_0x0966:
            long r11 = (long) r13
            long r11 = r24 + r11
            r10[r5] = r11
            if (r8 != 0) goto L_0x096f
            r11 = 1
            goto L_0x0970
        L_0x096f:
            r11 = 0
        L_0x0970:
            r4[r5] = r11
            if (r5 != r14) goto L_0x098a
            r11 = 1
            r4[r5] = r11
            int r16 = r16 + -1
            if (r16 <= 0) goto L_0x098a
            if (r8 == 0) goto L_0x0988
            int r11 = r8.zzB()
            r12 = -1
            int r11 = r11 + r12
            r12 = r3
            r26 = r4
            r14 = r11
            goto L_0x098d
        L_0x0988:
            r11 = 0
            throw r11
        L_0x098a:
            r12 = r3
            r26 = r4
        L_0x098d:
            r11 = r28
            long r3 = (long) r11
            long r24 = r24 + r3
            int r3 = r17 + -1
            if (r3 != 0) goto L_0x09a9
            if (r15 <= 0) goto L_0x09a6
            int r3 = r7.zzB()
            int r4 = r7.zzv()
            int r15 = r15 + -1
            r17 = r3
            r11 = r4
            goto L_0x09ab
        L_0x09a6:
            r17 = 0
            goto L_0x09ab
        L_0x09a9:
            r17 = r3
        L_0x09ab:
            r3 = r6[r5]
            long r3 = (long) r3
            long r22 = r22 + r3
            r3 = -1
            int r2 = r2 + r3
            int r5 = r5 + 1
            r3 = r12
            r4 = r26
            r12 = r11
            r11 = r18
            r18 = r2
            r2 = r29
            goto L_0x08eb
        L_0x09c0:
            r29 = r2
            r26 = r4
        L_0x09c4:
            long r7 = (long) r13
            long r7 = r24 + r7
            if (r0 == 0) goto L_0x09d9
        L_0x09c9:
            if (r20 <= 0) goto L_0x09d9
            int r3 = r0.zzB()
            if (r3 == 0) goto L_0x09d3
            r0 = 0
            goto L_0x09da
        L_0x09d3:
            r0.zzv()
            int r20 = r20 + -1
            goto L_0x09c9
        L_0x09d9:
            r0 = 1
        L_0x09da:
            if (r16 != 0) goto L_0x0a1a
            if (r17 != 0) goto L_0x0a10
            if (r18 != 0) goto L_0x0a07
            if (r15 != 0) goto L_0x09ff
            if (r21 != 0) goto L_0x09f6
            if (r0 != 0) goto L_0x09ee
            r13 = r19
            r0 = 0
            r3 = 0
            r5 = 0
            r9 = 0
            r12 = 0
            goto L_0x09fd
        L_0x09ee:
            r16 = r1
            r17 = r2
            r13 = r19
            goto L_0x0a79
        L_0x09f6:
            r13 = r19
            r12 = r21
            r3 = 0
            r5 = 0
            r9 = 0
        L_0x09fd:
            r15 = 0
            goto L_0x0a24
        L_0x09ff:
            r13 = r19
            r12 = r21
            r3 = 0
            r5 = 0
            r9 = 0
            goto L_0x0a24
        L_0x0a07:
            r9 = r18
            r13 = r19
            r12 = r21
            r3 = 0
            r5 = 0
            goto L_0x0a24
        L_0x0a10:
            r5 = r17
            r9 = r18
            r13 = r19
            r12 = r21
            r3 = 0
            goto L_0x0a24
        L_0x0a1a:
            r3 = r16
            r5 = r17
            r9 = r18
            r13 = r19
            r12 = r21
        L_0x0a24:
            int r14 = r13.zza
            r16 = r1
            r1 = 1
            if (r1 == r0) goto L_0x0a2e
            java.lang.String r0 = ", ctts invalid"
            goto L_0x0a30
        L_0x0a2e:
            java.lang.String r0 = ""
        L_0x0a30:
            int r1 = r0.length()
            r17 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 262
            r2.<init>(r1)
            java.lang.String r1 = "Inconsistent stbl box for track "
            r2.append(r1)
            r2.append(r14)
            java.lang.String r1 = ": remainingSynchronizationSamples "
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = ", remainingSamplesAtTimestampDelta "
            r2.append(r1)
            r2.append(r5)
            java.lang.String r1 = ", remainingSamplesInChunk "
            r2.append(r1)
            r2.append(r9)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r2.append(r1)
            r2.append(r15)
            java.lang.String r1 = ", remainingSamplesAtTimestampOffset "
            r2.append(r1)
            r2.append(r12)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "AtomParsers"
            android.util.Log.w(r1, r0)
        L_0x0a79:
            r12 = r4
            r14 = r6
            r0 = r7
            r15 = r11
            r9 = r16
            r2 = r17
        L_0x0a81:
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r13.zzc
            r3 = r0
            long r18 = com.google.android.gms.internal.ads.zzalh.zzF(r3, r5, r7)
            long[] r3 = r13.zzh
            if (r3 != 0) goto L_0x0aa6
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r13.zzc
            com.google.android.gms.internal.ads.zzalh.zzG(r10, r0, r2)
            com.google.android.gms.internal.ads.zzwy r0 = new com.google.android.gms.internal.ads.zzwy
            r11 = r0
            r8 = r12
            r12 = r13
            r13 = r9
            r16 = r10
            r17 = r8
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0793
        L_0x0aa6:
            r8 = r12
            int r4 = r3.length
            r5 = 1
            if (r4 != r5) goto L_0x0b5f
            int r4 = r13.zzb
            if (r4 != r5) goto L_0x0b5f
            int r4 = r10.length
            r5 = 2
            if (r4 < r5) goto L_0x0b5f
            long[] r5 = r13.zzi
            if (r5 == 0) goto L_0x0b5d
            r6 = 0
            r11 = r5[r6]
            r16 = r3[r6]
            long r6 = r13.zzc
            r5 = r2
            long r2 = r13.zzd
            r18 = r6
            r20 = r2
            long r2 = com.google.android.gms.internal.ads.zzalh.zzF(r16, r18, r20)
            long r2 = r2 + r11
            int r6 = r4 + -1
            r16 = r5
            r5 = 0
            r7 = 4
            int r7 = com.google.android.gms.internal.ads.zzalh.zzx(r7, r5, r6)
            int r4 = r4 + -4
            int r4 = com.google.android.gms.internal.ads.zzalh.zzx(r4, r5, r6)
            r17 = r10[r5]
            int r6 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x0b5a
            r6 = r10[r7]
            int r17 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r17 >= 0) goto L_0x0b5a
            r6 = r10[r4]
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0b5a
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x0b5a
            r6 = r10[r5]
            long r17 = r11 - r6
            com.google.android.gms.internal.ads.zzkc r4 = r13.zzf
            int r4 = r4.zzz
            long r4 = (long) r4
            long r6 = r13.zzc
            r19 = r4
            r21 = r6
            long r4 = com.google.android.gms.internal.ads.zzalh.zzF(r17, r19, r21)
            long r17 = r0 - r2
            com.google.android.gms.internal.ads.zzkc r2 = r13.zzf
            int r2 = r2.zzz
            long r2 = (long) r2
            long r6 = r13.zzc
            r19 = r2
            r21 = r6
            long r2 = com.google.android.gms.internal.ads.zzalh.zzF(r17, r19, r21)
            r6 = 0
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 != 0) goto L_0x0b1e
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x0b5a
        L_0x0b1e:
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 > 0) goto L_0x0b5a
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 > 0) goto L_0x0b5a
            int r0 = (int) r4
            r4 = r46
            r4.zza = r0
            int r0 = (int) r2
            r4.zzb = r0
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r13.zzc
            com.google.android.gms.internal.ads.zzalh.zzG(r10, r0, r2)
            long[] r0 = r13.zzh
            r1 = 0
            r16 = r0[r1]
            long r0 = r13.zzd
            r18 = 1000000(0xf4240, double:4.940656E-318)
            r20 = r0
            long r18 = com.google.android.gms.internal.ads.zzalh.zzF(r16, r18, r20)
            com.google.android.gms.internal.ads.zzwy r0 = new com.google.android.gms.internal.ads.zzwy
            r11 = r0
            r12 = r13
            r13 = r9
            r16 = r10
            r17 = r8
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0793
        L_0x0b5a:
            r4 = r46
            goto L_0x0b63
        L_0x0b5d:
            r2 = 0
            throw r2
        L_0x0b5f:
            r4 = r46
            r16 = r2
        L_0x0b63:
            long[] r2 = r13.zzh
            int r3 = r2.length
            r5 = 1
            if (r3 != r5) goto L_0x0bae
            r5 = 0
            r6 = r2[r5]
            r2 = 0
            int r11 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r11 != 0) goto L_0x0bad
            long[] r2 = r13.zzi
            if (r2 == 0) goto L_0x0bab
            r6 = r2[r5]
            r2 = 0
        L_0x0b79:
            int r3 = r10.length
            if (r2 >= r3) goto L_0x0b90
            r11 = r10[r2]
            long r16 = r11 - r6
            r18 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r13.zzc
            r20 = r11
            long r11 = com.google.android.gms.internal.ads.zzalh.zzF(r16, r18, r20)
            r10[r2] = r11
            int r2 = r2 + 1
            goto L_0x0b79
        L_0x0b90:
            long r2 = r13.zzc
            long r16 = r0 - r6
            r18 = 1000000(0xf4240, double:4.940656E-318)
            r20 = r2
            long r18 = com.google.android.gms.internal.ads.zzalh.zzF(r16, r18, r20)
            com.google.android.gms.internal.ads.zzwy r0 = new com.google.android.gms.internal.ads.zzwy
            r11 = r0
            r12 = r13
            r13 = r9
            r16 = r10
            r17 = r8
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0793
        L_0x0bab:
            r0 = 0
            throw r0
        L_0x0bad:
            r3 = 1
        L_0x0bae:
            int r0 = r13.zzb
            r1 = 1
            if (r0 != r1) goto L_0x0bb5
            r2 = 1
            goto L_0x0bb6
        L_0x0bb5:
            r2 = 0
        L_0x0bb6:
            int[] r0 = new int[r3]
            int[] r1 = new int[r3]
            long[] r3 = r13.zzi
            if (r3 == 0) goto L_0x0d17
            r5 = 0
            r6 = 0
            r7 = 0
            r11 = 0
        L_0x0bc2:
            long[] r12 = r13.zzh
            int r4 = r12.length
            if (r5 >= r4) goto L_0x0c27
            r4 = r14
            r17 = r15
            r14 = r3[r5]
            r18 = -1
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 == 0) goto L_0x0c15
            r21 = r12[r5]
            r12 = r3
            r18 = r4
            long r3 = r13.zzc
            r19 = r11
            r20 = r12
            long r11 = r13.zzd
            r23 = r3
            r25 = r11
            long r3 = com.google.android.gms.internal.ads.zzalh.zzF(r21, r23, r25)
            r11 = 1
            int r12 = com.google.android.gms.internal.ads.zzalh.zzD(r10, r14, r11, r11)
            r0[r5] = r12
            long r14 = r14 + r3
            r3 = 0
            int r4 = com.google.android.gms.internal.ads.zzalh.zzE(r10, r14, r2, r3)
            r1[r5] = r4
        L_0x0bf6:
            r4 = r0[r5]
            r12 = r1[r5]
            if (r4 >= r12) goto L_0x0c07
            r14 = r8[r4]
            r14 = r14 & r11
            if (r14 != 0) goto L_0x0c07
            int r4 = r4 + 1
            r0[r5] = r4
            r11 = 1
            goto L_0x0bf6
        L_0x0c07:
            int r11 = r12 - r4
            int r11 = r11 + r6
            if (r7 == r4) goto L_0x0c0e
            r4 = 1
            goto L_0x0c0f
        L_0x0c0e:
            r4 = 0
        L_0x0c0f:
            r4 = r19 | r4
            r6 = r11
            r7 = r12
            r11 = r4
            goto L_0x0c1c
        L_0x0c15:
            r20 = r3
            r18 = r4
            r19 = r11
            r3 = 0
        L_0x0c1c:
            int r5 = r5 + 1
            r4 = r46
            r15 = r17
            r14 = r18
            r3 = r20
            goto L_0x0bc2
        L_0x0c27:
            r19 = r11
            r18 = r14
            r17 = r15
            r4 = r16
            r3 = 0
            if (r6 == r4) goto L_0x0c34
            r2 = 1
            goto L_0x0c35
        L_0x0c34:
            r2 = 0
        L_0x0c35:
            r2 = r19 | r2
            if (r2 == 0) goto L_0x0c3c
            long[] r4 = new long[r6]
            goto L_0x0c3d
        L_0x0c3c:
            r4 = r9
        L_0x0c3d:
            if (r2 == 0) goto L_0x0c43
            int[] r5 = new int[r6]
            r14 = r5
            goto L_0x0c45
        L_0x0c43:
            r14 = r18
        L_0x0c45:
            r5 = 1
            if (r5 != r2) goto L_0x0c4a
            r17 = 0
        L_0x0c4a:
            if (r2 == 0) goto L_0x0c4f
            int[] r5 = new int[r6]
            goto L_0x0c50
        L_0x0c4f:
            r5 = r8
        L_0x0c50:
            long[] r6 = new long[r6]
            r7 = 0
            r11 = 0
            r15 = 0
        L_0x0c56:
            long[] r12 = r13.zzh
            int r12 = r12.length
            if (r7 >= r12) goto L_0x0cf3
            long[] r12 = r13.zzi
            r25 = r12[r7]
            r12 = r0[r7]
            r3 = r1[r7]
            if (r2 == 0) goto L_0x0c77
            r27 = r0
            int r0 = r3 - r12
            java.lang.System.arraycopy(r9, r12, r4, r11, r0)
            r28 = r1
            r1 = r18
            java.lang.System.arraycopy(r1, r12, r14, r11, r0)
            java.lang.System.arraycopy(r8, r12, r5, r11, r0)
            goto L_0x0c7d
        L_0x0c77:
            r27 = r0
            r28 = r1
            r1 = r18
        L_0x0c7d:
            r0 = r17
        L_0x0c7f:
            if (r12 >= r3) goto L_0x0cd0
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r29 = r8
            r18 = r9
            long r8 = r13.zzd
            r19 = r15
            r23 = r8
            long r8 = com.google.android.gms.internal.ads.zzalh.zzF(r19, r21, r23)
            r19 = r10[r12]
            r21 = r3
            r30 = r4
            long r3 = r19 - r25
            r17 = r0
            r19 = r1
            r0 = 0
            long r33 = java.lang.Math.max(r0, r3)
            r35 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r13.zzc
            r37 = r3
            long r3 = com.google.android.gms.internal.ads.zzalh.zzF(r33, r35, r37)
            long r8 = r8 + r3
            r6[r11] = r8
            if (r2 == 0) goto L_0x0cbd
            r3 = r14[r11]
            r4 = r17
            if (r3 <= r4) goto L_0x0cbf
            r3 = r19[r12]
            goto L_0x0cc0
        L_0x0cbd:
            r4 = r17
        L_0x0cbf:
            r3 = r4
        L_0x0cc0:
            int r11 = r11 + 1
            int r12 = r12 + 1
            r0 = r3
            r9 = r18
            r1 = r19
            r3 = r21
            r8 = r29
            r4 = r30
            goto L_0x0c7f
        L_0x0cd0:
            r19 = r1
            r30 = r4
            r29 = r8
            r18 = r9
            r4 = r0
            r0 = 0
            long[] r3 = r13.zzh
            r8 = r3[r7]
            long r15 = r15 + r8
            int r7 = r7 + 1
            r17 = r4
            r9 = r18
            r18 = r19
            r0 = r27
            r1 = r28
            r8 = r29
            r4 = r30
            r3 = 0
            goto L_0x0c56
        L_0x0cf3:
            r30 = r4
            long r0 = r13.zzd
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r19 = r15
            r23 = r0
            long r18 = com.google.android.gms.internal.ads.zzalh.zzF(r19, r21, r23)
            com.google.android.gms.internal.ads.zzwy r0 = new com.google.android.gms.internal.ads.zzwy
            r11 = r0
            r12 = r13
            r13 = r30
            r15 = r17
            r16 = r6
            r17 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0793
        L_0x0d13:
            r1.add(r0)
            goto L_0x0d2d
        L_0x0d17:
            r0 = 0
            throw r0
        L_0x0d19:
            r0 = 0
            throw r0
        L_0x0d1b:
            r0 = 0
            throw r0
        L_0x0d1d:
            r0 = 0
            java.lang.String r1 = "Track has no sample table size information"
            com.google.android.gms.internal.ads.zzlg r0 = com.google.android.gms.internal.ads.zzlg.zza(r1, r0)
            throw r0
        L_0x0d25:
            r0 = 0
            throw r0
        L_0x0d27:
            r0 = 0
            throw r0
        L_0x0d29:
            r0 = 0
            throw r0
        L_0x0d2b:
            r1 = r32
        L_0x0d2d:
            int r15 = r31 + 1
            r0 = r45
            r12 = r49
            r13 = r1
            r1 = r46
            goto L_0x000c
        L_0x0d38:
            r0 = 0
            throw r0
        L_0x0d3a:
            r0 = 0
            throw r0
        L_0x0d3c:
            r0 = 0
            throw r0
        L_0x0d3e:
            r0 = 0
            throw r0
        L_0x0d40:
            r0 = 0
            throw r0
        L_0x0d42:
            r0 = 0
            throw r0
        L_0x0d44:
            r0 = 0
            throw r0
        L_0x0d46:
            r0 = 0
            throw r0
        L_0x0d48:
            r1 = r13
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwg.zza(com.google.android.gms.internal.ads.zzvx, com.google.android.gms.internal.ads.zztp, long, com.google.android.gms.internal.ads.zzsa, boolean, boolean, com.google.android.gms.internal.ads.zzfju):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ae, code lost:
        if (r3 != 13) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d3, code lost:
        r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<com.google.android.gms.internal.ads.zzabe, com.google.android.gms.internal.ads.zzabe> zzb(com.google.android.gms.internal.ads.zzvy r11) {
        /*
            com.google.android.gms.internal.ads.zzakr r11 = r11.zza
            r0 = 8
            r11.zzh(r0)
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x000a:
            int r4 = r11.zzd()
            if (r4 < r0) goto L_0x00da
            int r4 = r11.zzg()
            int r5 = r11.zzv()
            int r6 = r11.zzv()
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r6 != r7) goto L_0x0075
            r11.zzh(r4)
            int r2 = r4 + r5
            r11.zzk(r0)
            zzd(r11)
        L_0x002c:
            int r6 = r11.zzg()
            if (r6 >= r2) goto L_0x0073
            int r6 = r11.zzg()
            int r7 = r11.zzv()
            int r8 = r11.zzv()
            r9 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r8 != r9) goto L_0x006e
            r11.zzh(r6)
            int r6 = r6 + r7
            r11.zzk(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x004f:
            int r7 = r11.zzg()
            if (r7 >= r6) goto L_0x005f
            com.google.android.gms.internal.ads.zzabd r7 = com.google.android.gms.internal.ads.zzwn.zza(r11)
            if (r7 == 0) goto L_0x004f
            r2.add(r7)
            goto L_0x004f
        L_0x005f:
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L_0x0066
            goto L_0x0073
        L_0x0066:
            com.google.android.gms.internal.ads.zzabe r6 = new com.google.android.gms.internal.ads.zzabe
            r6.<init>((java.util.List<? extends com.google.android.gms.internal.ads.zzabd>) r2)
            r2 = r6
            goto L_0x00d4
        L_0x006e:
            int r6 = r6 + r7
            r11.zzh(r6)
            goto L_0x002c
        L_0x0073:
            r2 = r1
            goto L_0x00d4
        L_0x0075:
            r7 = 1936553057(0x736d7461, float:1.8813092E31)
            if (r6 != r7) goto L_0x00d4
            r11.zzh(r4)
            int r3 = r4 + r5
            r6 = 12
            r11.zzk(r6)
        L_0x0084:
            int r7 = r11.zzg()
            if (r7 >= r3) goto L_0x00d3
            int r7 = r11.zzg()
            int r8 = r11.zzv()
            int r9 = r11.zzv()
            r10 = 1935766900(0x73617574, float:1.7862687E31)
            if (r9 != r10) goto L_0x00ce
            r3 = 14
            if (r8 >= r3) goto L_0x00a0
            goto L_0x00d3
        L_0x00a0:
            r3 = 5
            r11.zzk(r3)
            int r3 = r11.zzn()
            r7 = 1123024896(0x42f00000, float:120.0)
            if (r3 == r6) goto L_0x00b1
            r6 = 13
            if (r3 == r6) goto L_0x00b5
            goto L_0x00d3
        L_0x00b1:
            if (r3 != r6) goto L_0x00b5
            r7 = 1131413504(0x43700000, float:240.0)
        L_0x00b5:
            r3 = 1
            r11.zzk(r3)
            int r6 = r11.zzn()
            com.google.android.gms.internal.ads.zzabe r8 = new com.google.android.gms.internal.ads.zzabe
            com.google.android.gms.internal.ads.zzabd[] r3 = new com.google.android.gms.internal.ads.zzabd[r3]
            com.google.android.gms.internal.ads.zzacw r9 = new com.google.android.gms.internal.ads.zzacw
            r9.<init>((float) r7, (int) r6)
            r6 = 0
            r3[r6] = r9
            r8.<init>((com.google.android.gms.internal.ads.zzabd[]) r3)
            r3 = r8
            goto L_0x00d4
        L_0x00ce:
            int r7 = r7 + r8
            r11.zzh(r7)
            goto L_0x0084
        L_0x00d3:
            r3 = r1
        L_0x00d4:
            int r4 = r4 + r5
            r11.zzh(r4)
            goto L_0x000a
        L_0x00da:
            android.util.Pair r11 = android.util.Pair.create(r2, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwg.zzb(com.google.android.gms.internal.ads.zzvy):android.util.Pair");
    }

    @Nullable
    public static zzabe zzc(zzvx zzvx) {
        zzacs zzacs;
        zzvy zzc = zzvx.zzc(1751411826);
        zzvy zzc2 = zzvx.zzc(1801812339);
        zzvy zzc3 = zzvx.zzc(1768715124);
        if (zzc == null || zzc2 == null || zzc3 == null || zze(zzc.zza) != 1835299937) {
            return null;
        }
        zzakr zzakr = zzc2.zza;
        zzakr.zzh(12);
        int zzv = zzakr.zzv();
        String[] strArr = new String[zzv];
        for (int i = 0; i < zzv; i++) {
            int zzv2 = zzakr.zzv();
            zzakr.zzk(4);
            strArr[i] = zzakr.zzE(zzv2 - 8, zzfjs.zzc);
        }
        zzakr zzakr2 = zzc3.zza;
        zzakr2.zzh(8);
        ArrayList arrayList = new ArrayList();
        while (zzakr2.zzd() > 8) {
            int zzg = zzakr2.zzg();
            int zzv3 = zzakr2.zzv();
            int zzv4 = zzakr2.zzv() - 1;
            if (zzv4 < 0 || zzv4 >= zzv) {
                GeneratedOutlineSupport.outline29(52, "Skipped metadata with unknown key index: ", zzv4, "AtomParsers");
            } else {
                String str = strArr[zzv4];
                int i2 = zzg + zzv3;
                while (true) {
                    int zzg2 = zzakr2.zzg();
                    if (zzg2 >= i2) {
                        zzacs = null;
                        break;
                    }
                    int zzv5 = zzakr2.zzv();
                    if (zzakr2.zzv() == 1684108385) {
                        int zzv6 = zzakr2.zzv();
                        int zzv7 = zzakr2.zzv();
                        int i3 = zzv5 - 16;
                        byte[] bArr = new byte[i3];
                        zzakr2.zzm(bArr, 0, i3);
                        zzacs = new zzacs(str, bArr, zzv7, zzv6);
                        break;
                    }
                    zzakr2.zzh(zzg2 + zzv5);
                }
                if (zzacs != null) {
                    arrayList.add(zzacs);
                }
            }
            zzakr2.zzh(zzg + zzv3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzabe((List<? extends zzabd>) arrayList);
    }

    public static void zzd(zzakr zzakr) {
        int zzg = zzakr.zzg();
        zzakr.zzk(4);
        if (zzakr.zzv() != 1751411826) {
            zzg += 4;
        }
        zzakr.zzh(zzg);
    }

    public static int zze(zzakr zzakr) {
        zzakr.zzh(16);
        return zzakr.zzv();
    }

    /* JADX WARNING: type inference failed for: r1v22, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x033a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:166:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zzf(com.google.android.gms.internal.ads.zzakr r21, int r22, int r23, int r24, int r25, java.lang.String r26, boolean r27, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzsa r28, com.google.android.gms.internal.ads.zzwc r29, int r30) throws com.google.android.gms.internal.ads.zzlg {
        /*
            r0 = r21
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r28
            r6 = r29
            int r7 = r1 + 16
            r0.zzh(r7)
            r7 = 6
            if (r27 == 0) goto L_0x001e
            int r9 = r21.zzo()
            r0.zzk(r7)
            goto L_0x0024
        L_0x001e:
            r9 = 8
            r0.zzk(r9)
            r9 = 0
        L_0x0024:
            r10 = 20
            r11 = 16
            r12 = 2
            r13 = 1
            if (r9 == 0) goto L_0x004a
            if (r9 != r13) goto L_0x002f
            goto L_0x004a
        L_0x002f:
            if (r9 != r12) goto L_0x0049
            r0.zzk(r11)
            long r14 = r21.zzx()
            double r14 = java.lang.Double.longBitsToDouble(r14)
            long r14 = java.lang.Math.round(r14)
            int r7 = (int) r14
            int r9 = r21.zzB()
            r0.zzk(r10)
            goto L_0x005b
        L_0x0049:
            return
        L_0x004a:
            int r14 = r21.zzo()
            r0.zzk(r7)
            int r7 = r21.zzz()
            if (r9 != r13) goto L_0x005a
            r0.zzk(r11)
        L_0x005a:
            r9 = r14
        L_0x005b:
            int r11 = r21.zzg()
            r14 = 1701733217(0x656e6361, float:7.0359778E22)
            r15 = r22
            if (r15 != r14) goto L_0x008e
            android.util.Pair r15 = zzh(r0, r1, r2)
            if (r15 == 0) goto L_0x008a
            java.lang.Object r14 = r15.first
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            if (r5 != 0) goto L_0x0078
            r5 = 0
            goto L_0x0082
        L_0x0078:
            java.lang.Object r10 = r15.second
            com.google.android.gms.internal.ads.zzww r10 = (com.google.android.gms.internal.ads.zzww) r10
            java.lang.String r10 = r10.zzb
            com.google.android.gms.internal.ads.zzsa r5 = r5.zza(r10)
        L_0x0082:
            com.google.android.gms.internal.ads.zzww[] r10 = r6.zza
            java.lang.Object r15 = r15.second
            com.google.android.gms.internal.ads.zzww r15 = (com.google.android.gms.internal.ads.zzww) r15
            r10[r30] = r15
        L_0x008a:
            r0.zzh(r11)
            goto L_0x008f
        L_0x008e:
            r14 = r15
        L_0x008f:
            r10 = 1633889587(0x61632d33, float:2.6191674E20)
            r15 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r16 = "audio/raw"
            java.lang.String r12 = "audio/ac4"
            if (r14 != r10) goto L_0x00a0
            java.lang.String r16 = "audio/ac3"
        L_0x009d:
            r10 = -1
            goto L_0x0140
        L_0x00a0:
            r10 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r14 != r10) goto L_0x00a8
            java.lang.String r16 = "audio/eac3"
            goto L_0x009d
        L_0x00a8:
            r10 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r14 != r10) goto L_0x00b0
            r16 = r12
            goto L_0x009d
        L_0x00b0:
            r10 = 1685353315(0x64747363, float:1.803728E22)
            if (r14 != r10) goto L_0x00b8
            java.lang.String r16 = "audio/vnd.dts"
            goto L_0x009d
        L_0x00b8:
            r10 = 1685353320(0x64747368, float:1.8037286E22)
            if (r14 == r10) goto L_0x013c
            r10 = 1685353324(0x6474736c, float:1.803729E22)
            if (r14 != r10) goto L_0x00c4
            goto L_0x013c
        L_0x00c4:
            r10 = 1685353317(0x64747365, float:1.8037282E22)
            if (r14 != r10) goto L_0x00cc
            java.lang.String r16 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x009d
        L_0x00cc:
            r10 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r14 != r10) goto L_0x00d4
            java.lang.String r16 = "audio/3gpp"
            goto L_0x009d
        L_0x00d4:
            r10 = 1935767394(0x73617762, float:1.7863284E31)
            if (r14 != r10) goto L_0x00dc
            java.lang.String r16 = "audio/amr-wb"
            goto L_0x009d
        L_0x00dc:
            r10 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r14 == r10) goto L_0x013a
            r10 = 1936684916(0x736f7774, float:1.89725E31)
            if (r14 != r10) goto L_0x00e7
            goto L_0x013a
        L_0x00e7:
            r10 = 1953984371(0x74776f73, float:7.841539E31)
            if (r14 != r10) goto L_0x00ef
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0140
        L_0x00ef:
            r10 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r14 == r10) goto L_0x0136
            r10 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r14 != r10) goto L_0x00fa
            goto L_0x0136
        L_0x00fa:
            r10 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r14 != r10) goto L_0x0102
            java.lang.String r16 = "audio/mha1"
            goto L_0x009d
        L_0x0102:
            r10 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r14 != r10) goto L_0x010a
            java.lang.String r16 = "audio/mhm1"
            goto L_0x009d
        L_0x010a:
            if (r14 != r15) goto L_0x010f
            java.lang.String r16 = "audio/alac"
            goto L_0x009d
        L_0x010f:
            r10 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r14 != r10) goto L_0x0117
            java.lang.String r16 = "audio/g711-alaw"
            goto L_0x009d
        L_0x0117:
            r10 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r14 != r10) goto L_0x0120
            java.lang.String r16 = "audio/g711-mlaw"
            goto L_0x009d
        L_0x0120:
            r10 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r14 != r10) goto L_0x0129
            java.lang.String r16 = "audio/opus"
            goto L_0x009d
        L_0x0129:
            r10 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r14 != r10) goto L_0x0132
            java.lang.String r16 = "audio/flac"
            goto L_0x009d
        L_0x0132:
            r10 = -1
            r16 = 0
            goto L_0x0140
        L_0x0136:
            java.lang.String r16 = "audio/mpeg"
            goto L_0x009d
        L_0x013a:
            r10 = 2
            goto L_0x0140
        L_0x013c:
            java.lang.String r16 = "audio/vnd.dts.hd"
            goto L_0x009d
        L_0x0140:
            r13 = r16
            r14 = 0
            r19 = 0
        L_0x0145:
            int r15 = r11 - r1
            if (r15 >= r2) goto L_0x0334
            r0.zzh(r11)
            int r15 = r21.zzv()
            if (r15 <= 0) goto L_0x0154
            r8 = 1
            goto L_0x0155
        L_0x0154:
            r8 = 0
        L_0x0155:
            java.lang.String r1 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzte.zza(r8, r1)
            int r8 = r21.zzv()
            r2 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r8 != r2) goto L_0x017e
            int r1 = r15 + -13
            byte[] r2 = new byte[r1]
            int r8 = r11 + 13
            r0.zzh(r8)
            r8 = 0
            r0.zzm(r2, r8, r1)
            com.google.android.gms.internal.ads.zzfml r1 = com.google.android.gms.internal.ads.zzfml.zzj(r2)
            r19 = r1
            r16 = r10
        L_0x0178:
            r8 = 0
            r10 = 1
            r17 = 2
            goto L_0x032b
        L_0x017e:
            r2 = 1702061171(0x65736473, float:7.183675E22)
            if (r8 == r2) goto L_0x02fd
            if (r27 == 0) goto L_0x01c2
            r2 = 2002876005(0x77617665, float:4.5729223E33)
            if (r8 != r2) goto L_0x01c2
            int r2 = r21.zzg()
        L_0x018e:
            int r8 = r2 - r11
            if (r8 >= r15) goto L_0x01b8
            r0.zzh(r2)
            int r8 = r21.zzv()
            if (r8 <= 0) goto L_0x019f
            r16 = r10
            r10 = 1
            goto L_0x01a2
        L_0x019f:
            r16 = r10
            r10 = 0
        L_0x01a2:
            com.google.android.gms.internal.ads.zzte.zza(r10, r1)
            int r10 = r21.zzv()
            r20 = r1
            r1 = 1702061171(0x65736473, float:7.183675E22)
            if (r10 == r1) goto L_0x01b6
            int r2 = r2 + r8
            r10 = r16
            r1 = r20
            goto L_0x018e
        L_0x01b6:
            r1 = -1
            goto L_0x01bc
        L_0x01b8:
            r16 = r10
            r1 = -1
            r2 = -1
        L_0x01bc:
            r8 = 0
            r10 = 1
            r17 = 2
            goto L_0x0305
        L_0x01c2:
            r16 = r10
            r1 = 1684103987(0x64616333, float:1.6630662E22)
            if (r8 != r1) goto L_0x01db
            int r1 = r11 + 8
            r0.zzh(r1)
            java.lang.String r1 = java.lang.Integer.toString(r25)
            com.google.android.gms.internal.ads.zzkc r1 = com.google.android.gms.internal.ads.zzpc.zza(r0, r1, r4, r5)
            r6.zzb = r1
        L_0x01d8:
            r1 = 20
            goto L_0x0178
        L_0x01db:
            r1 = 1684366131(0x64656333, float:1.692581E22)
            if (r8 != r1) goto L_0x01f0
            int r1 = r11 + 8
            r0.zzh(r1)
            java.lang.String r1 = java.lang.Integer.toString(r25)
            com.google.android.gms.internal.ads.zzkc r1 = com.google.android.gms.internal.ads.zzpc.zzb(r0, r1, r4, r5)
            r6.zzb = r1
            goto L_0x01d8
        L_0x01f0:
            r1 = 1684103988(0x64616334, float:1.6630663E22)
            if (r8 != r1) goto L_0x0232
            int r1 = r11 + 8
            r0.zzh(r1)
            java.lang.String r1 = java.lang.Integer.toString(r25)
            r2 = 1
            r0.zzk(r2)
            int r8 = r21.zzn()
            r8 = r8 & 32
            int r8 = r8 >> 5
            if (r2 == r8) goto L_0x0210
            r2 = 44100(0xac44, float:6.1797E-41)
            goto L_0x0213
        L_0x0210:
            r2 = 48000(0xbb80, float:6.7262E-41)
        L_0x0213:
            com.google.android.gms.internal.ads.zzkb r8 = new com.google.android.gms.internal.ads.zzkb
            r8.<init>()
            r8.zza(r1)
            r8.zzj(r12)
            r1 = 2
            r8.zzw(r1)
            r8.zzx(r2)
            r8.zzm(r5)
            r8.zzd(r4)
            com.google.android.gms.internal.ads.zzkc r1 = r8.zzD()
            r6.zzb = r1
            goto L_0x01d8
        L_0x0232:
            r1 = 1684305011(0x64647473, float:1.6856995E22)
            if (r8 != r1) goto L_0x0255
            com.google.android.gms.internal.ads.zzkb r1 = new com.google.android.gms.internal.ads.zzkb
            r1.<init>()
            r1.zzb(r3)
            r1.zzj(r13)
            r1.zzw(r9)
            r1.zzx(r7)
            r1.zzm(r5)
            r1.zzd(r4)
            com.google.android.gms.internal.ads.zzkc r1 = r1.zzD()
            r6.zzb = r1
            goto L_0x01d8
        L_0x0255:
            r1 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r8 != r1) goto L_0x0277
            int r1 = r15 + -8
            byte[] r2 = zza
            int r8 = r2.length
            int r8 = r8 + r1
            byte[] r2 = java.util.Arrays.copyOf(r2, r8)
            int r8 = r11 + 8
            r0.zzh(r8)
            byte[] r8 = zza
            int r8 = r8.length
            r0.zzm(r2, r8, r1)
            java.util.List r1 = com.google.android.gms.internal.ads.zzre.zza(r2)
            r19 = r1
            goto L_0x0178
        L_0x0277:
            r1 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r8 != r1) goto L_0x02a9
            int r1 = r15 + -12
            int r2 = r1 + 4
            byte[] r2 = new byte[r2]
            r8 = 102(0x66, float:1.43E-43)
            r10 = 0
            r2[r10] = r8
            r8 = 76
            r10 = 1
            r2[r10] = r8
            r8 = 97
            r17 = 2
            r2[r17] = r8
            r8 = 3
            r18 = 67
            r2[r8] = r18
            int r8 = r11 + 12
            r0.zzh(r8)
            r8 = 4
            r0.zzm(r2, r8, r1)
            com.google.android.gms.internal.ads.zzfml r1 = com.google.android.gms.internal.ads.zzfml.zzj(r2)
            r19 = r1
        L_0x02a6:
            r8 = 0
            goto L_0x032b
        L_0x02a9:
            r1 = 1634492771(0x616c6163, float:2.7252807E20)
            r10 = 1
            r17 = 2
            if (r8 != r1) goto L_0x02fa
            int r2 = r15 + -12
            byte[] r7 = new byte[r2]
            int r8 = r11 + 12
            r0.zzh(r8)
            r8 = 0
            r0.zzm(r7, r8, r2)
            com.google.android.gms.internal.ads.zzakr r2 = new com.google.android.gms.internal.ads.zzakr
            r2.<init>((byte[]) r7)
            r9 = 9
            r2.zzh(r9)
            int r9 = r2.zzn()
            r1 = 20
            r2.zzh(r1)
            int r2 = r2.zzB()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            android.util.Pair r2 = android.util.Pair.create(r2, r9)
            java.lang.Object r9 = r2.first
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Object r2 = r2.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.google.android.gms.internal.ads.zzfml r7 = com.google.android.gms.internal.ads.zzfml.zzj(r7)
            r19 = r7
            r7 = r9
            r9 = r2
            goto L_0x032b
        L_0x02fa:
            r1 = 20
            goto L_0x02a6
        L_0x02fd:
            r16 = r10
            r8 = 0
            r10 = 1
            r17 = 2
            r2 = r11
            r1 = -1
        L_0x0305:
            if (r2 == r1) goto L_0x032b
            android.util.Pair r2 = zzg(r0, r2)
            java.lang.Object r13 = r2.first
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r2 = r2.second
            byte[] r2 = (byte[]) r2
            if (r2 == 0) goto L_0x032b
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x0327
            com.google.android.gms.internal.ads.zzoy r1 = com.google.android.gms.internal.ads.zzoz.zza(r2)
            int r7 = r1.zza
            int r9 = r1.zzb
            java.lang.String r14 = r1.zzc
        L_0x0327:
            com.google.android.gms.internal.ads.zzfml r19 = com.google.android.gms.internal.ads.zzfml.zzj(r2)
        L_0x032b:
            int r11 = r11 + r15
            r1 = r23
            r2 = r24
            r10 = r16
            goto L_0x0145
        L_0x0334:
            r16 = r10
            com.google.android.gms.internal.ads.zzkc r0 = r6.zzb
            if (r0 != 0) goto L_0x0366
            if (r13 == 0) goto L_0x0366
            com.google.android.gms.internal.ads.zzkb r0 = new com.google.android.gms.internal.ads.zzkb
            r0.<init>()
            r0.zzb(r3)
            r0.zzj(r13)
            r0.zzh(r14)
            r0.zzw(r9)
            r0.zzx(r7)
            r13 = r16
            r0.zzy(r13)
            r1 = r19
            r0.zzl(r1)
            r0.zzm(r5)
            r0.zzd(r4)
            com.google.android.gms.internal.ads.zzkc r0 = r0.zzD()
            r6.zzb = r0
        L_0x0366:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwg.zzf(com.google.android.gms.internal.ads.zzakr, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzsa, com.google.android.gms.internal.ads.zzwc, int):void");
    }

    public static Pair<String, byte[]> zzg(zzakr zzakr, int i) {
        zzakr.zzh(i + 12);
        zzakr.zzk(1);
        zzi(zzakr);
        zzakr.zzk(2);
        int zzn = zzakr.zzn();
        if ((zzn & 128) != 0) {
            zzakr.zzk(2);
        }
        if ((zzn & 64) != 0) {
            zzakr.zzk(zzakr.zzo());
        }
        if ((zzn & 32) != 0) {
            zzakr.zzk(2);
        }
        zzakr.zzk(1);
        zzi(zzakr);
        String zze = zzakg.zze(zzakr.zzn());
        if ("audio/mpeg".equals(zze) || "audio/vnd.dts".equals(zze) || "audio/vnd.dts.hd".equals(zze)) {
            return Pair.create(zze, (Object) null);
        }
        zzakr.zzk(12);
        zzakr.zzk(1);
        int zzi = zzi(zzakr);
        byte[] bArr = new byte[zzi];
        zzakr.zzm(bArr, 0, zzi);
        return Pair.create(zze, bArr);
    }

    @Nullable
    public static Pair<Integer, zzww> zzh(zzakr zzakr, int i, int i2) throws zzlg {
        Pair<Integer, zzww> pair;
        Integer num;
        zzww zzww;
        int i3;
        int i4;
        byte[] bArr;
        zzakr zzakr2 = zzakr;
        int zzg = zzakr.zzg();
        while (zzg - i < i2) {
            zzakr2.zzh(zzg);
            int zzv = zzakr.zzv();
            boolean z = true;
            zzte.zza(zzv > 0, "childAtomSize must be positive");
            if (zzakr.zzv() == 1936289382) {
                int i5 = zzg + 8;
                int i6 = -1;
                int i7 = 0;
                String str = null;
                Integer num2 = null;
                while (i5 - zzg < zzv) {
                    zzakr2.zzh(i5);
                    int zzv2 = zzakr.zzv();
                    int zzv3 = zzakr.zzv();
                    if (zzv3 == 1718775137) {
                        num2 = Integer.valueOf(zzakr.zzv());
                    } else if (zzv3 == 1935894637) {
                        zzakr2.zzk(4);
                        str = zzakr2.zzE(4, zzfjs.zzc);
                    } else if (zzv3 == 1935894633) {
                        i6 = i5;
                        i7 = zzv2;
                    }
                    i5 += zzv2;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    zzte.zza(num2 != null, "frma atom is mandatory");
                    zzte.zza(i6 != -1, "schi atom is mandatory");
                    int i8 = i6 + 8;
                    while (true) {
                        if (i8 - i6 >= i7) {
                            num = num2;
                            zzww = null;
                            break;
                        }
                        zzakr2.zzh(i8);
                        int zzv4 = zzakr.zzv();
                        if (zzakr.zzv() == 1952804451) {
                            int zzv5 = zzakr.zzv();
                            zzakr2.zzk(1);
                            if (zzvz.zze(zzv5) == 0) {
                                zzakr2.zzk(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int zzn = zzakr.zzn();
                                i4 = zzn & 15;
                                i3 = (zzn & 240) >> 4;
                            }
                            boolean z2 = zzakr.zzn() == 1;
                            int zzn2 = zzakr.zzn();
                            byte[] bArr2 = new byte[16];
                            zzakr2.zzm(bArr2, 0, 16);
                            if (!z2 || zzn2 != 0) {
                                bArr = null;
                            } else {
                                int zzn3 = zzakr.zzn();
                                byte[] bArr3 = new byte[zzn3];
                                zzakr2.zzm(bArr3, 0, zzn3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzww = new zzww(z2, str, zzn2, bArr2, i3, i4, bArr);
                        } else {
                            Integer num3 = num2;
                            i8 += zzv4;
                        }
                    }
                    if (zzww == null) {
                        z = false;
                    }
                    zzte.zza(z, "tenc atom is mandatory");
                    int i9 = zzalh.zza;
                    pair = Pair.create(num, zzww);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            zzg += zzv;
        }
        return null;
    }

    public static int zzi(zzakr zzakr) {
        int zzn = zzakr.zzn();
        int i = zzn & 127;
        while ((zzn & 128) == 128) {
            zzn = zzakr.zzn();
            i = (i << 7) | (zzn & 127);
        }
        return i;
    }
}
