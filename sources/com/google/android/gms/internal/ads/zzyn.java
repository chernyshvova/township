package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyn implements zzyc {
    public final zzzd zza;
    public String zzb;
    public zztz zzc;
    public zzym zzd;
    public boolean zze;
    public final boolean[] zzf = new boolean[3];
    public final zzyr zzg = new zzyr(32, 128);
    public final zzyr zzh = new zzyr(33, 128);
    public final zzyr zzi = new zzyr(34, 128);
    public final zzyr zzj = new zzyr(39, 128);
    public final zzyr zzk = new zzyr(40, 128);
    public long zzl;
    public long zzm;
    public final zzakr zzn = new zzakr();

    public zzyn(zzzd zzzd) {
        this.zza = zzzd;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        this.zzd.zzc(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zzd(bArr, i, i2);
            this.zzh.zzd(bArr, i, i2);
            this.zzi.zzd(bArr, i, i2);
        }
        this.zzj.zzd(bArr, i, i2);
        this.zzk.zzd(bArr, i, i2);
    }

    public final void zza() {
        this.zzl = 0;
        zzakj.zze(this.zzf);
        this.zzg.zza();
        this.zzh.zza();
        this.zzi.zza();
        this.zzj.zza();
        this.zzk.zza();
        zzym zzym = this.zzd;
        if (zzym != null) {
            zzym.zza();
        }
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zzb = zzzo.zzc();
        zztz zza2 = zztd.zza(zzzo.zzb(), 2);
        this.zzc = zza2;
        this.zzd = new zzym(zza2);
        this.zza.zza(zztd, zzzo);
    }

    public final void zzc(long j, int i) {
        this.zzm = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzakr r28) {
        /*
            r27 = this;
            r0 = r27
            com.google.android.gms.internal.ads.zztz r1 = r0.zzc
            com.google.android.gms.internal.ads.zzajg.zze(r1)
            int r1 = com.google.android.gms.internal.ads.zzalh.zza
        L_0x0009:
            int r1 = r28.zzd()
            if (r1 <= 0) goto L_0x0399
            int r1 = r28.zzg()
            int r2 = r28.zze()
            byte[] r3 = r28.zzi()
            long r4 = r0.zzl
            int r6 = r28.zzd()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzl = r4
            com.google.android.gms.internal.ads.zztz r4 = r0.zzc
            int r5 = r28.zzd()
            r6 = r28
            com.google.android.gms.internal.ads.zztx.zzb(r4, r6, r5)
        L_0x0030:
            if (r1 >= r2) goto L_0x0009
            boolean[] r4 = r0.zzf
            int r4 = com.google.android.gms.internal.ads.zzakj.zzd(r3, r1, r2, r4)
            if (r4 == r2) goto L_0x0396
            int r5 = r4 + 3
            byte r7 = r3[r5]
            r7 = r7 & 126(0x7e, float:1.77E-43)
            int r7 = r7 >> 1
            int r8 = r4 - r1
            if (r8 <= 0) goto L_0x0049
            r0.zzf(r3, r1, r4)
        L_0x0049:
            int r11 = r2 - r4
            long r9 = r0.zzl
            long r12 = (long) r11
            long r9 = r9 - r12
            if (r8 >= 0) goto L_0x0053
            int r1 = -r8
            goto L_0x0054
        L_0x0053:
            r1 = 0
        L_0x0054:
            long r12 = r0.zzm
            com.google.android.gms.internal.ads.zzym r4 = r0.zzd
            boolean r8 = r0.zze
            r4.zzd(r9, r11, r8)
            boolean r4 = r0.zze
            if (r4 != 0) goto L_0x02f8
            com.google.android.gms.internal.ads.zzyr r4 = r0.zzg
            r4.zze(r1)
            com.google.android.gms.internal.ads.zzyr r4 = r0.zzh
            r4.zze(r1)
            com.google.android.gms.internal.ads.zzyr r4 = r0.zzi
            r4.zze(r1)
            com.google.android.gms.internal.ads.zzyr r4 = r0.zzg
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x02f8
            com.google.android.gms.internal.ads.zzyr r4 = r0.zzh
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x02f8
            com.google.android.gms.internal.ads.zzyr r4 = r0.zzi
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x02f8
            com.google.android.gms.internal.ads.zztz r4 = r0.zzc
            java.lang.String r8 = r0.zzb
            com.google.android.gms.internal.ads.zzyr r14 = r0.zzg
            com.google.android.gms.internal.ads.zzyr r15 = r0.zzh
            r16 = r5
            com.google.android.gms.internal.ads.zzyr r5 = r0.zzi
            int r6 = r14.zzb
            r17 = r2
            int r2 = r15.zzb
            int r2 = r2 + r6
            r18 = r3
            int r3 = r5.zzb
            int r2 = r2 + r3
            byte[] r2 = new byte[r2]
            byte[] r3 = r14.zza
            r19 = r7
            r7 = 0
            java.lang.System.arraycopy(r3, r7, r2, r7, r6)
            byte[] r3 = r15.zza
            int r6 = r14.zzb
            r20 = r11
            int r11 = r15.zzb
            java.lang.System.arraycopy(r3, r7, r2, r6, r11)
            byte[] r3 = r5.zza
            int r6 = r14.zzb
            int r11 = r15.zzb
            int r6 = r6 + r11
            int r5 = r5.zzb
            java.lang.System.arraycopy(r3, r7, r2, r6, r5)
            com.google.android.gms.internal.ads.zzaks r3 = new com.google.android.gms.internal.ads.zzaks
            byte[] r5 = r15.zza
            int r6 = r15.zzb
            r3.<init>(r5, r7, r6)
            r5 = 44
            r3.zzc(r5)
            r5 = 3
            int r6 = r3.zze(r5)
            r3.zzb()
            r7 = 88
            r3.zzc(r7)
            r7 = 8
            r3.zzc(r7)
            r7 = 0
            r11 = 0
        L_0x00e3:
            if (r7 >= r6) goto L_0x00f8
            boolean r14 = r3.zzd()
            if (r14 == 0) goto L_0x00ed
            int r11 = r11 + 89
        L_0x00ed:
            boolean r14 = r3.zzd()
            if (r14 == 0) goto L_0x00f5
            int r11 = r11 + 8
        L_0x00f5:
            int r7 = r7 + 1
            goto L_0x00e3
        L_0x00f8:
            r3.zzc(r11)
            if (r6 <= 0) goto L_0x0103
            int r7 = 8 - r6
            int r7 = r7 + r7
            r3.zzc(r7)
        L_0x0103:
            r3.zzf()
            int r7 = r3.zzf()
            if (r7 != r5) goto L_0x0110
            r3.zzb()
            r7 = 3
        L_0x0110:
            int r5 = r3.zzf()
            int r11 = r3.zzf()
            boolean r14 = r3.zzd()
            r21 = r9
            r9 = 2
            if (r14 == 0) goto L_0x014d
            int r10 = r3.zzf()
            int r14 = r3.zzf()
            int r23 = r3.zzf()
            int r24 = r3.zzf()
            r25 = r12
            r12 = 1
            if (r7 == r12) goto L_0x013c
            if (r7 != r9) goto L_0x013a
            r7 = 2
            goto L_0x013c
        L_0x013a:
            r9 = 1
            goto L_0x013d
        L_0x013c:
            r9 = 2
        L_0x013d:
            if (r7 != r12) goto L_0x0141
            r7 = 2
            goto L_0x0142
        L_0x0141:
            r7 = 1
        L_0x0142:
            int r10 = r10 + r14
            int r10 = r10 * r9
            int r5 = r5 - r10
            int r23 = r23 + r24
            int r23 = r23 * r7
            int r11 = r11 - r23
            goto L_0x014f
        L_0x014d:
            r25 = r12
        L_0x014f:
            r3.zzf()
            r3.zzf()
            int r7 = r3.zzf()
            boolean r9 = r3.zzd()
            r10 = 1
            if (r10 == r9) goto L_0x0162
            r9 = r6
            goto L_0x0163
        L_0x0162:
            r9 = 0
        L_0x0163:
            if (r9 > r6) goto L_0x0171
            r3.zzf()
            r3.zzf()
            r3.zzf()
            int r9 = r9 + 1
            goto L_0x0163
        L_0x0171:
            r3.zzf()
            r3.zzf()
            r3.zzf()
            r3.zzf()
            r3.zzf()
            r3.zzf()
            boolean r6 = r3.zzd()
            r9 = 4
            if (r6 == 0) goto L_0x01c8
            boolean r6 = r3.zzd()
            if (r6 == 0) goto L_0x01c8
            r6 = 0
        L_0x0191:
            if (r6 >= r9) goto L_0x01c8
            r9 = 0
        L_0x0194:
            r10 = 6
            if (r9 >= r10) goto L_0x01c4
            boolean r10 = r3.zzd()
            if (r10 != 0) goto L_0x01a1
            r3.zzf()
            goto L_0x01bc
        L_0x01a1:
            r10 = 64
            int r12 = r6 + r6
            int r12 = r12 + 4
            r13 = 1
            int r12 = r13 << r12
            int r10 = java.lang.Math.min(r10, r12)
            if (r6 <= r13) goto L_0x01b3
            r3.zzg()
        L_0x01b3:
            r12 = 0
        L_0x01b4:
            if (r12 >= r10) goto L_0x01bc
            r3.zzg()
            int r12 = r12 + 1
            goto L_0x01b4
        L_0x01bc:
            r10 = 3
            if (r6 != r10) goto L_0x01c1
            r10 = 3
            goto L_0x01c2
        L_0x01c1:
            r10 = 1
        L_0x01c2:
            int r9 = r9 + r10
            goto L_0x0194
        L_0x01c4:
            int r6 = r6 + 1
            r9 = 4
            goto L_0x0191
        L_0x01c8:
            r6 = 2
            r3.zzc(r6)
            boolean r6 = r3.zzd()
            if (r6 == 0) goto L_0x01e0
            r6 = 8
            r3.zzc(r6)
            r3.zzf()
            r3.zzf()
            r3.zzb()
        L_0x01e0:
            int r6 = r3.zzf()
            r9 = 0
            r10 = 0
            r12 = 0
        L_0x01e7:
            if (r9 >= r6) goto L_0x0235
            if (r9 == 0) goto L_0x01ef
            boolean r10 = r3.zzd()
        L_0x01ef:
            if (r10 == 0) goto L_0x0209
            r3.zzb()
            r3.zzf()
            r13 = 0
        L_0x01f8:
            if (r13 > r12) goto L_0x0206
            boolean r14 = r3.zzd()
            if (r14 == 0) goto L_0x0203
            r3.zzb()
        L_0x0203:
            int r13 = r13 + 1
            goto L_0x01f8
        L_0x0206:
            r24 = r6
            goto L_0x0230
        L_0x0209:
            int r12 = r3.zzf()
            int r13 = r3.zzf()
            int r14 = r12 + r13
            r23 = 0
            r24 = r6
            r6 = 0
        L_0x0218:
            if (r6 >= r12) goto L_0x0223
            r3.zzf()
            r3.zzb()
            int r6 = r6 + 1
            goto L_0x0218
        L_0x0223:
            r6 = 0
        L_0x0224:
            if (r6 >= r13) goto L_0x022f
            r3.zzf()
            r3.zzb()
            int r6 = r6 + 1
            goto L_0x0224
        L_0x022f:
            r12 = r14
        L_0x0230:
            int r9 = r9 + 1
            r6 = r24
            goto L_0x01e7
        L_0x0235:
            boolean r6 = r3.zzd()
            if (r6 == 0) goto L_0x024a
            r6 = 0
        L_0x023c:
            int r9 = r3.zzf()
            if (r6 >= r9) goto L_0x024a
            int r9 = r7 + 5
            r3.zzc(r9)
            int r6 = r6 + 1
            goto L_0x023c
        L_0x024a:
            r6 = 2
            r3.zzc(r6)
            boolean r6 = r3.zzd()
            r7 = 24
            r9 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x02be
            boolean r6 = r3.zzd()
            if (r6 == 0) goto L_0x028c
            r6 = 8
            int r6 = r3.zze(r6)
            r10 = 255(0xff, float:3.57E-43)
            if (r6 != r10) goto L_0x027a
            r6 = 16
            int r10 = r3.zze(r6)
            int r6 = r3.zze(r6)
            if (r10 == 0) goto L_0x028c
            if (r6 == 0) goto L_0x028c
            float r9 = (float) r10
            float r6 = (float) r6
            float r9 = r9 / r6
            goto L_0x028c
        L_0x027a:
            r10 = 17
            if (r6 >= r10) goto L_0x0283
            float[] r9 = com.google.android.gms.internal.ads.zzakj.zzb
            r9 = r9[r6]
            goto L_0x028c
        L_0x0283:
            r10 = 46
            java.lang.String r12 = "Unexpected aspect_ratio_idc value: "
            java.lang.String r13 = "H265Reader"
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r10, r12, r6, r13)
        L_0x028c:
            boolean r6 = r3.zzd()
            if (r6 == 0) goto L_0x0295
            r3.zzb()
        L_0x0295:
            boolean r6 = r3.zzd()
            if (r6 == 0) goto L_0x02a8
            r6 = 4
            r3.zzc(r6)
            boolean r6 = r3.zzd()
            if (r6 == 0) goto L_0x02a8
            r3.zzc(r7)
        L_0x02a8:
            boolean r6 = r3.zzd()
            if (r6 == 0) goto L_0x02b4
            r3.zzf()
            r3.zzf()
        L_0x02b4:
            r3.zzb()
            boolean r6 = r3.zzd()
            if (r6 == 0) goto L_0x02be
            int r11 = r11 + r11
        L_0x02be:
            byte[] r6 = r15.zza
            int r10 = r15.zzb
            r12 = 0
            r3.zza(r6, r12, r10)
            r3.zzc(r7)
            java.lang.String r3 = com.google.android.gms.internal.ads.zzaji.zzb(r3)
            com.google.android.gms.internal.ads.zzkb r6 = new com.google.android.gms.internal.ads.zzkb
            r6.<init>()
            r6.zza(r8)
            java.lang.String r7 = "video/hevc"
            r6.zzj(r7)
            r6.zzh(r3)
            r6.zzo(r5)
            r6.zzp(r11)
            r6.zzs(r9)
            java.util.List r2 = java.util.Collections.singletonList(r2)
            r6.zzl(r2)
            com.google.android.gms.internal.ads.zzkc r2 = r6.zzD()
            r4.zza(r2)
            r2 = 1
            r0.zze = r2
            goto L_0x0306
        L_0x02f8:
            r17 = r2
            r18 = r3
            r16 = r5
            r19 = r7
            r21 = r9
            r20 = r11
            r25 = r12
        L_0x0306:
            com.google.android.gms.internal.ads.zzyr r2 = r0.zzj
            boolean r2 = r2.zze(r1)
            if (r2 == 0) goto L_0x0331
            com.google.android.gms.internal.ads.zzyr r2 = r0.zzj
            byte[] r3 = r2.zza
            int r2 = r2.zzb
            int r2 = com.google.android.gms.internal.ads.zzakj.zza(r3, r2)
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzn
            com.google.android.gms.internal.ads.zzyr r4 = r0.zzj
            byte[] r4 = r4.zza
            r3.zzb(r4, r2)
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzn
            r3 = 5
            r2.zzk(r3)
            com.google.android.gms.internal.ads.zzzd r2 = r0.zza
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzn
            r4 = r25
            r2.zzb(r4, r3)
            goto L_0x0333
        L_0x0331:
            r4 = r25
        L_0x0333:
            com.google.android.gms.internal.ads.zzyr r2 = r0.zzk
            boolean r1 = r2.zze(r1)
            if (r1 == 0) goto L_0x035b
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzk
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzakj.zza(r2, r1)
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzn
            com.google.android.gms.internal.ads.zzyr r3 = r0.zzk
            byte[] r3 = r3.zza
            r2.zzb(r3, r1)
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzn
            r2 = 5
            r1.zzk(r2)
            com.google.android.gms.internal.ads.zzzd r1 = r0.zza
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzn
            r1.zzb(r4, r2)
        L_0x035b:
            long r13 = r0.zzm
            com.google.android.gms.internal.ads.zzym r8 = r0.zzd
            boolean r15 = r0.zze
            r9 = r21
            r11 = r20
            r12 = r19
            r8.zzb(r9, r11, r12, r13, r15)
            boolean r1 = r0.zze
            if (r1 != 0) goto L_0x0380
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzg
            r2 = r19
            r1.zzc(r2)
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzh
            r1.zzc(r2)
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzi
            r1.zzc(r2)
            goto L_0x0382
        L_0x0380:
            r2 = r19
        L_0x0382:
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzj
            r1.zzc(r2)
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzk
            r1.zzc(r2)
            r6 = r28
            r1 = r16
            r2 = r17
            r3 = r18
            goto L_0x0030
        L_0x0396:
            r0.zzf(r3, r1, r2)
        L_0x0399:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyn.zzd(com.google.android.gms.internal.ads.zzakr):void");
    }

    public final void zze() {
    }
}
