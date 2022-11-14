package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzj implements zzzb {
    public final /* synthetic */ zzzk zza;
    public final zzakq zzb = new zzakq(new byte[5], 5);
    public final SparseArray<zzzp> zzc = new SparseArray<>();
    public final SparseIntArray zzd = new SparseIntArray();
    public final int zze;

    public zzzj(zzzk zzzk, int i) {
        this.zza = zzzk;
        this.zze = i;
    }

    public final void zza(zzale zzale, zztd zztd, zzzo zzzo) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0112, code lost:
        if (r29.zzn() == 21) goto L_0x00df;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.internal.ads.zzakr r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            int r2 = r29.zzn()
            r3 = 2
            if (r2 == r3) goto L_0x000c
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzzk r2 = r0.zza
            java.util.List r2 = r2.zzb
            r4 = 0
            java.lang.Object r2 = r2.get(r4)
            com.google.android.gms.internal.ads.zzale r2 = (com.google.android.gms.internal.ads.zzale) r2
            int r5 = r29.zzn()
            r5 = r5 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x0022
            return
        L_0x0022:
            r5 = 1
            r1.zzk(r5)
            int r6 = r29.zzo()
            r7 = 3
            r1.zzk(r7)
            com.google.android.gms.internal.ads.zzakq r8 = r0.zzb
            r1.zzl(r8, r3)
            com.google.android.gms.internal.ads.zzakq r8 = r0.zzb
            r8.zzf(r7)
            com.google.android.gms.internal.ads.zzzk r8 = r0.zza
            com.google.android.gms.internal.ads.zzakq r9 = r0.zzb
            r10 = 13
            int r9 = r9.zzh(r10)
            int unused = r8.zzq = r9
            com.google.android.gms.internal.ads.zzakq r8 = r0.zzb
            r1.zzl(r8, r3)
            com.google.android.gms.internal.ads.zzakq r3 = r0.zzb
            r8 = 4
            r3.zzf(r8)
            com.google.android.gms.internal.ads.zzakq r3 = r0.zzb
            r9 = 12
            int r3 = r3.zzh(r9)
            r1.zzk(r3)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzzp> r3 = r0.zzc
            r3.clear()
            android.util.SparseIntArray r3 = r0.zzd
            r3.clear()
            int r3 = r29.zzd()
        L_0x0069:
            if (r3 <= 0) goto L_0x01e4
            com.google.android.gms.internal.ads.zzakq r11 = r0.zzb
            r12 = 5
            r1.zzl(r11, r12)
            com.google.android.gms.internal.ads.zzakq r11 = r0.zzb
            r13 = 8
            int r11 = r11.zzh(r13)
            com.google.android.gms.internal.ads.zzakq r13 = r0.zzb
            r13.zzf(r7)
            com.google.android.gms.internal.ads.zzakq r13 = r0.zzb
            int r13 = r13.zzh(r10)
            com.google.android.gms.internal.ads.zzakq r14 = r0.zzb
            r14.zzf(r8)
            com.google.android.gms.internal.ads.zzakq r14 = r0.zzb
            int r14 = r14.zzh(r9)
            int r15 = r29.zzg()
            int r9 = r15 + r14
            r16 = -1
            r17 = 0
            r5 = r17
            r18 = r5
            r10 = -1
        L_0x009e:
            int r4 = r29.zzg()
            if (r4 >= r9) goto L_0x0194
            int r4 = r29.zzn()
            int r19 = r29.zzn()
            int r20 = r29.zzg()
            int r8 = r20 + r19
            if (r8 <= r9) goto L_0x00b6
            goto L_0x0194
        L_0x00b6:
            r7 = 89
            r20 = 172(0xac, float:2.41E-43)
            r22 = 135(0x87, float:1.89E-43)
            r23 = 129(0x81, float:1.81E-43)
            if (r4 != r12) goto L_0x00f0
            long r24 = r29.zzt()
            r26 = 1094921523(0x41432d33, double:5.409631094E-315)
            int r4 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1))
            if (r4 != 0) goto L_0x00ce
            r10 = 129(0x81, float:1.81E-43)
            goto L_0x00eb
        L_0x00ce:
            r26 = 1161904947(0x45414333, double:5.74057318E-315)
            int r4 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1))
            if (r4 != 0) goto L_0x00d8
            r10 = 135(0x87, float:1.89E-43)
            goto L_0x00eb
        L_0x00d8:
            r22 = 1094921524(0x41432d34, double:5.4096311E-315)
            int r4 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r4 != 0) goto L_0x00e2
        L_0x00df:
            r10 = 172(0xac, float:2.41E-43)
            goto L_0x00eb
        L_0x00e2:
            r22 = 1212503619(0x48455643, double:5.990563836E-315)
            int r4 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r4 != 0) goto L_0x00eb
            r10 = 36
        L_0x00eb:
            r21 = r2
        L_0x00ed:
            r22 = r6
            goto L_0x00fa
        L_0x00f0:
            r12 = 106(0x6a, float:1.49E-43)
            if (r4 != r12) goto L_0x00fd
            r21 = r2
            r22 = r6
            r10 = 129(0x81, float:1.81E-43)
        L_0x00fa:
            r12 = 4
            goto L_0x0183
        L_0x00fd:
            r12 = 122(0x7a, float:1.71E-43)
            if (r4 != r12) goto L_0x0108
            r21 = r2
            r22 = r6
            r10 = 135(0x87, float:1.89E-43)
            goto L_0x00fa
        L_0x0108:
            r12 = 127(0x7f, float:1.78E-43)
            if (r4 != r12) goto L_0x0115
            int r4 = r29.zzn()
            r7 = 21
            if (r4 != r7) goto L_0x00eb
            goto L_0x00df
        L_0x0115:
            r12 = 123(0x7b, float:1.72E-43)
            if (r4 != r12) goto L_0x0122
            r4 = 138(0x8a, float:1.93E-43)
            r21 = r2
            r22 = r6
            r10 = 138(0x8a, float:1.93E-43)
            goto L_0x00fa
        L_0x0122:
            r12 = 10
            if (r4 != r12) goto L_0x0135
            java.nio.charset.Charset r4 = com.google.android.gms.internal.ads.zzfjs.zzc
            r12 = 3
            java.lang.String r4 = r1.zzE(r12, r4)
            java.lang.String r4 = r4.trim()
            r21 = r2
            r5 = r4
            goto L_0x00ed
        L_0x0135:
            r12 = 3
            if (r4 != r7) goto L_0x0176
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x013d:
            int r10 = r29.zzg()
            if (r10 >= r8) goto L_0x016c
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzfjs.zzc
            java.lang.String r10 = r1.zzE(r12, r10)
            java.lang.String r10 = r10.trim()
            int r7 = r29.zzn()
            r21 = r2
            r12 = 4
            byte[] r2 = new byte[r12]
            r22 = r6
            r6 = 0
            r1.zzm(r2, r6, r12)
            com.google.android.gms.internal.ads.zzzl r6 = new com.google.android.gms.internal.ads.zzzl
            r6.<init>(r10, r7, r2)
            r4.add(r6)
            r2 = r21
            r6 = r22
            r7 = 89
            r12 = 3
            goto L_0x013d
        L_0x016c:
            r21 = r2
            r22 = r6
            r12 = 4
            r18 = r4
            r10 = 89
            goto L_0x0183
        L_0x0176:
            r21 = r2
            r22 = r6
            r12 = 4
            r2 = 111(0x6f, float:1.56E-43)
            if (r4 != r2) goto L_0x0183
            r2 = 257(0x101, float:3.6E-43)
            r10 = 257(0x101, float:3.6E-43)
        L_0x0183:
            int r2 = r29.zzg()
            int r8 = r8 - r2
            r1.zzk(r8)
            r2 = r21
            r6 = r22
            r7 = 3
            r8 = 4
            r12 = 5
            goto L_0x009e
        L_0x0194:
            r21 = r2
            r22 = r6
            r12 = 4
            r1.zzh(r9)
            com.google.android.gms.internal.ads.zzzm r2 = new com.google.android.gms.internal.ads.zzzm
            byte[] r4 = r29.zzi()
            byte[] r4 = java.util.Arrays.copyOfRange(r4, r15, r9)
            r6 = r18
            r2.<init>(r10, r5, r6, r4)
            r4 = 6
            if (r11 == r4) goto L_0x01b1
            r4 = 5
            if (r11 != r4) goto L_0x01b3
        L_0x01b1:
            int r11 = r2.zza
        L_0x01b3:
            int r14 = r14 + 5
            int r3 = r3 - r14
            com.google.android.gms.internal.ads.zzzk r4 = r0.zza
            android.util.SparseBooleanArray r4 = r4.zzg
            boolean r4 = r4.get(r13)
            if (r4 != 0) goto L_0x01d6
            com.google.android.gms.internal.ads.zzzk r4 = r0.zza
            com.google.android.gms.internal.ads.zzzn r4 = r4.zze
            com.google.android.gms.internal.ads.zzzp r2 = r4.zza(r11, r2)
            android.util.SparseIntArray r4 = r0.zzd
            r4.put(r13, r13)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzzp> r4 = r0.zzc
            r4.put(r13, r2)
        L_0x01d6:
            r2 = r21
            r6 = r22
            r4 = 0
            r5 = 1
            r7 = 3
            r8 = 4
            r9 = 12
            r10 = 13
            goto L_0x0069
        L_0x01e4:
            r21 = r2
            r22 = r6
            android.util.SparseIntArray r1 = r0.zzd
            int r1 = r1.size()
            r6 = 0
        L_0x01ef:
            if (r6 >= r1) goto L_0x0243
            android.util.SparseIntArray r2 = r0.zzd
            int r2 = r2.keyAt(r6)
            android.util.SparseIntArray r3 = r0.zzd
            int r3 = r3.valueAt(r6)
            com.google.android.gms.internal.ads.zzzk r4 = r0.zza
            android.util.SparseBooleanArray r4 = r4.zzg
            r5 = 1
            r4.put(r2, r5)
            com.google.android.gms.internal.ads.zzzk r4 = r0.zza
            android.util.SparseBooleanArray r4 = r4.zzh
            r4.put(r3, r5)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzzp> r4 = r0.zzc
            java.lang.Object r4 = r4.valueAt(r6)
            com.google.android.gms.internal.ads.zzzp r4 = (com.google.android.gms.internal.ads.zzzp) r4
            if (r4 == 0) goto L_0x0238
            com.google.android.gms.internal.ads.zzzk r5 = r0.zza
            com.google.android.gms.internal.ads.zztd r5 = r5.zzk
            com.google.android.gms.internal.ads.zzzo r7 = new com.google.android.gms.internal.ads.zzzo
            r8 = 8192(0x2000, float:1.14794E-41)
            r9 = r22
            r7.<init>(r9, r2, r8)
            r2 = r21
            r4.zza(r2, r5, r7)
            com.google.android.gms.internal.ads.zzzk r5 = r0.zza
            android.util.SparseArray r5 = r5.zzf
            r5.put(r3, r4)
            goto L_0x023c
        L_0x0238:
            r2 = r21
            r9 = r22
        L_0x023c:
            int r6 = r6 + 1
            r21 = r2
            r22 = r9
            goto L_0x01ef
        L_0x0243:
            com.google.android.gms.internal.ads.zzzk r1 = r0.zza
            android.util.SparseArray r1 = r1.zzf
            int r2 = r0.zze
            r1.remove(r2)
            com.google.android.gms.internal.ads.zzzk r1 = r0.zza
            r2 = 0
            int unused = r1.zzl = 0
            com.google.android.gms.internal.ads.zzzk r1 = r0.zza
            int r1 = r1.zzl
            if (r1 != 0) goto L_0x026b
            com.google.android.gms.internal.ads.zzzk r1 = r0.zza
            com.google.android.gms.internal.ads.zztd r1 = r1.zzk
            r1.zzbl()
            com.google.android.gms.internal.ads.zzzk r1 = r0.zza
            r2 = 1
            boolean unused = r1.zzm = true
        L_0x026b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzj.zzb(com.google.android.gms.internal.ads.zzakr):void");
    }
}
