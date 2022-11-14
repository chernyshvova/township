package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzye implements zzyc {
    public static final double[] zzc = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public String zza;
    public zztz zzb;
    @Nullable
    public final zzzr zzd;
    @Nullable
    public final zzakr zze;
    @Nullable
    public final zzyr zzf;
    public final boolean[] zzg;
    public final zzyd zzh;
    public long zzi;
    public boolean zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    public long zzn;
    public long zzo;
    public boolean zzp;
    public boolean zzq;

    public zzye() {
        this((zzzr) null);
    }

    public final void zza() {
        zzakj.zze(this.zzg);
        this.zzh.zza();
        zzyr zzyr = this.zzf;
        if (zzyr != null) {
            zzyr.zza();
        }
        this.zzi = 0;
        this.zzj = false;
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zza = zzzo.zzc();
        this.zzb = zztd.zza(zzzo.zzb(), 2);
        zzzr zzzr = this.zzd;
        if (zzzr != null) {
            zzzr.zza(zztd, zzzo);
        }
    }

    public final void zzc(long j, int i) {
        this.zzm = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzakr r21) {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.internal.ads.zztz r1 = r0.zzb
            com.google.android.gms.internal.ads.zzajg.zze(r1)
            int r1 = r21.zzg()
            int r2 = r21.zze()
            byte[] r3 = r21.zzi()
            long r4 = r0.zzi
            int r6 = r21.zzd()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzi = r4
            com.google.android.gms.internal.ads.zztz r4 = r0.zzb
            int r5 = r21.zzd()
            r6 = r21
            com.google.android.gms.internal.ads.zztx.zzb(r4, r6, r5)
        L_0x0028:
            boolean[] r4 = r0.zzg
            int r4 = com.google.android.gms.internal.ads.zzakj.zzd(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0041
            boolean r4 = r0.zzk
            if (r4 != 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzyd r4 = r0.zzh
            r4.zzc(r3, r1, r2)
        L_0x0039:
            com.google.android.gms.internal.ads.zzyr r4 = r0.zzf
            if (r4 == 0) goto L_0x0040
            r4.zzd(r3, r1, r2)
        L_0x0040:
            return
        L_0x0041:
            int r5 = r4 + 3
            byte[] r7 = r21.zzi()
            byte r7 = r7[r5]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.zzk
            if (r9 != 0) goto L_0x0131
            if (r8 <= 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzyd r9 = r0.zzh
            r9.zzc(r3, r1, r4)
        L_0x0058:
            if (r8 >= 0) goto L_0x005c
            int r9 = -r8
            goto L_0x005d
        L_0x005c:
            r9 = 0
        L_0x005d:
            com.google.android.gms.internal.ads.zzyd r14 = r0.zzh
            boolean r9 = r14.zzb(r7, r9)
            if (r9 == 0) goto L_0x0131
            com.google.android.gms.internal.ads.zzyd r9 = r0.zzh
            java.lang.String r14 = r0.zza
            if (r14 == 0) goto L_0x012f
            byte[] r15 = r9.zzc
            int r10 = r9.zza
            byte[] r10 = java.util.Arrays.copyOf(r15, r10)
            r11 = 4
            byte r15 = r10[r11]
            r16 = 5
            byte r12 = r10[r16]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r11
            int r17 = r12 >> 4
            r15 = r15 | r17
            r12 = r12 & 15
            r13 = 8
            int r12 = r12 << r13
            r18 = 6
            byte r13 = r10[r18]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r12 = r12 | r13
            r13 = 7
            byte r11 = r10[r13]
            r11 = r11 & 240(0xf0, float:3.36E-43)
            r13 = 4
            int r11 = r11 >> r13
            r13 = 2
            if (r11 == r13) goto L_0x00ae
            r13 = 3
            if (r11 == r13) goto L_0x00a8
            r13 = 4
            if (r11 == r13) goto L_0x00a2
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00b5
        L_0x00a2:
            int r11 = r12 * 121
            float r11 = (float) r11
            int r13 = r15 * 100
            goto L_0x00b3
        L_0x00a8:
            int r11 = r12 * 16
            float r11 = (float) r11
            int r13 = r15 * 9
            goto L_0x00b3
        L_0x00ae:
            int r11 = r12 * 4
            float r11 = (float) r11
            int r13 = r15 * 3
        L_0x00b3:
            float r13 = (float) r13
            float r11 = r11 / r13
        L_0x00b5:
            com.google.android.gms.internal.ads.zzkb r13 = new com.google.android.gms.internal.ads.zzkb
            r13.<init>()
            r13.zza(r14)
            java.lang.String r14 = "video/mpeg2"
            r13.zzj(r14)
            r13.zzo(r15)
            r13.zzp(r12)
            r13.zzs(r11)
            java.util.List r11 = java.util.Collections.singletonList(r10)
            r13.zzl(r11)
            com.google.android.gms.internal.ads.zzkc r11 = r13.zzD()
            r12 = 7
            byte r12 = r10[r12]
            r12 = r12 & 15
            int r12 = r12 + -1
            if (r12 < 0) goto L_0x010e
            r13 = 8
            if (r12 >= r13) goto L_0x010e
            double[] r13 = zzc
            r12 = r13[r12]
            int r9 = r9.zzb
            int r9 = r9 + 9
            byte r9 = r10[r9]
            r10 = r9 & 96
            int r10 = r10 >> 5
            r9 = r9 & 31
            if (r10 == r9) goto L_0x0106
            double r14 = (double) r10
            r18 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r14)
            double r14 = r14 + r18
            int r9 = r9 + 1
            double r9 = (double) r9
            java.lang.Double.isNaN(r9)
            double r14 = r14 / r9
            double r12 = r12 * r14
        L_0x0106:
            r9 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r9 = r9 / r12
            long r9 = (long) r9
            goto L_0x0110
        L_0x010e:
            r9 = 0
        L_0x0110:
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            android.util.Pair r9 = android.util.Pair.create(r11, r9)
            com.google.android.gms.internal.ads.zztz r10 = r0.zzb
            java.lang.Object r11 = r9.first
            com.google.android.gms.internal.ads.zzkc r11 = (com.google.android.gms.internal.ads.zzkc) r11
            r10.zza(r11)
            java.lang.Object r9 = r9.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            r0.zzl = r9
            r9 = 1
            r0.zzk = r9
            goto L_0x0131
        L_0x012f:
            r1 = 0
            throw r1
        L_0x0131:
            com.google.android.gms.internal.ads.zzyr r9 = r0.zzf
            r10 = 178(0xb2, float:2.5E-43)
            if (r9 == 0) goto L_0x0179
            if (r8 <= 0) goto L_0x013e
            r9.zzd(r3, r1, r4)
            r1 = 0
            goto L_0x013f
        L_0x013e:
            int r1 = -r8
        L_0x013f:
            com.google.android.gms.internal.ads.zzyr r8 = r0.zzf
            boolean r1 = r8.zze(r1)
            if (r1 == 0) goto L_0x0165
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzf
            byte[] r8 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzakj.zza(r8, r1)
            com.google.android.gms.internal.ads.zzakr r8 = r0.zze
            int r9 = com.google.android.gms.internal.ads.zzalh.zza
            com.google.android.gms.internal.ads.zzyr r9 = r0.zzf
            byte[] r9 = r9.zza
            r8.zzb(r9, r1)
            com.google.android.gms.internal.ads.zzzr r1 = r0.zzd
            long r8 = r0.zzo
            com.google.android.gms.internal.ads.zzakr r11 = r0.zze
            r1.zzb(r8, r11)
        L_0x0165:
            if (r7 != r10) goto L_0x0179
            byte[] r1 = r21.zzi()
            int r7 = r4 + 2
            byte r1 = r1[r7]
            r7 = 1
            if (r1 != r7) goto L_0x0177
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzf
            r1.zzc(r10)
        L_0x0177:
            r7 = 178(0xb2, float:2.5E-43)
        L_0x0179:
            if (r7 == 0) goto L_0x0188
            r1 = 179(0xb3, float:2.51E-43)
            if (r7 != r1) goto L_0x0180
            goto L_0x0188
        L_0x0180:
            r1 = 184(0xb8, float:2.58E-43)
            if (r7 != r1) goto L_0x01e7
            r1 = 1
            r0.zzp = r1
            goto L_0x01e7
        L_0x0188:
            int r1 = r2 - r4
            boolean r4 = r0.zzj
            if (r4 == 0) goto L_0x01ae
            boolean r4 = r0.zzq
            if (r4 == 0) goto L_0x01ae
            boolean r4 = r0.zzk
            if (r4 == 0) goto L_0x01ae
            boolean r11 = r0.zzp
            long r8 = r0.zzi
            long r12 = r0.zzn
            com.google.android.gms.internal.ads.zztz r4 = r0.zzb
            long r14 = r0.zzo
            long r8 = r8 - r12
            int r9 = (int) r8
            int r12 = r9 - r1
            r16 = 0
            r8 = r4
            r9 = r14
            r13 = r1
            r14 = r16
            r8.zzd(r9, r11, r12, r13, r14)
        L_0x01ae:
            boolean r4 = r0.zzj
            if (r4 == 0) goto L_0x01ba
            boolean r8 = r0.zzq
            if (r8 == 0) goto L_0x01b7
            goto L_0x01ba
        L_0x01b7:
            r1 = 0
            r4 = 1
            goto L_0x01e0
        L_0x01ba:
            long r8 = r0.zzi
            long r10 = (long) r1
            long r8 = r8 - r10
            r0.zzn = r8
            long r8 = r0.zzm
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 == 0) goto L_0x01cc
            goto L_0x01d6
        L_0x01cc:
            if (r4 == 0) goto L_0x01d4
            long r8 = r0.zzo
            long r12 = r0.zzl
            long r8 = r8 + r12
            goto L_0x01d6
        L_0x01d4:
            r8 = 0
        L_0x01d6:
            r0.zzo = r8
            r1 = 0
            r0.zzp = r1
            r0.zzm = r10
            r4 = 1
            r0.zzj = r4
        L_0x01e0:
            if (r7 != 0) goto L_0x01e4
            r12 = 1
            goto L_0x01e5
        L_0x01e4:
            r12 = 0
        L_0x01e5:
            r0.zzq = r12
        L_0x01e7:
            r1 = r5
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzye.zzd(com.google.android.gms.internal.ads.zzakr):void");
    }

    public final void zze() {
    }

    public zzye(@Nullable zzzr zzzr) {
        zzakr zzakr;
        this.zzd = zzzr;
        this.zzg = new boolean[4];
        this.zzh = new zzyd(128);
        if (zzzr != null) {
            this.zzf = new zzyr(178, 128);
            zzakr = new zzakr();
        } else {
            zzakr = null;
            this.zzf = null;
        }
        this.zze = zzakr;
    }
}
