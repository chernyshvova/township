package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyh implements zzyc {
    public static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    @Nullable
    public final zzzr zzb;
    @Nullable
    public final zzakr zzc;
    public final boolean[] zzd;
    public final zzyf zze;
    @Nullable
    public final zzyr zzf;
    public zzyg zzg;
    public long zzh;
    public String zzi;
    public zztz zzj;
    public boolean zzk;
    public long zzl;

    public zzyh() {
        this((zzzr) null);
    }

    public final void zza() {
        zzakj.zze(this.zzd);
        this.zze.zza();
        zzyg zzyg = this.zzg;
        if (zzyg != null) {
            zzyg.zza();
        }
        this.zzf.zza();
        this.zzh = 0;
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zzi = zzzo.zzc();
        zztz zza2 = zztd.zza(zzzo.zzb(), 2);
        this.zzj = zza2;
        this.zzg = new zzyg(zza2);
        this.zzb.zza(zztd, zzzo);
    }

    public final void zzc(long j, int i) {
        this.zzl = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01cf A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzakr r19) {
        /*
            r18 = this;
            r0 = r18
            com.google.android.gms.internal.ads.zzyg r1 = r0.zzg
            com.google.android.gms.internal.ads.zzajg.zze(r1)
            com.google.android.gms.internal.ads.zztz r1 = r0.zzj
            com.google.android.gms.internal.ads.zzajg.zze(r1)
            int r1 = r19.zzg()
            int r2 = r19.zze()
            byte[] r3 = r19.zzi()
            long r4 = r0.zzh
            int r6 = r19.zzd()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzh = r4
            com.google.android.gms.internal.ads.zztz r4 = r0.zzj
            int r5 = r19.zzd()
            r6 = r19
            com.google.android.gms.internal.ads.zztx.zzb(r4, r6, r5)
        L_0x002d:
            boolean[] r4 = r0.zzd
            int r4 = com.google.android.gms.internal.ads.zzakj.zzd(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0049
            boolean r4 = r0.zzk
            if (r4 != 0) goto L_0x003e
            com.google.android.gms.internal.ads.zzyf r4 = r0.zze
            r4.zzc(r3, r1, r2)
        L_0x003e:
            com.google.android.gms.internal.ads.zzyg r4 = r0.zzg
            r4.zzc(r3, r1, r2)
            com.google.android.gms.internal.ads.zzyr r4 = r0.zzf
            r4.zzd(r3, r1, r2)
            return
        L_0x0049:
            int r5 = r4 + 3
            byte[] r7 = r19.zzi()
            byte r7 = r7[r5]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.zzk
            if (r9 != 0) goto L_0x0182
            if (r8 <= 0) goto L_0x0060
            com.google.android.gms.internal.ads.zzyf r9 = r0.zze
            r9.zzc(r3, r1, r4)
        L_0x0060:
            if (r8 >= 0) goto L_0x0064
            int r9 = -r8
            goto L_0x0065
        L_0x0064:
            r9 = 0
        L_0x0065:
            com.google.android.gms.internal.ads.zzyf r12 = r0.zze
            boolean r9 = r12.zzb(r7, r9)
            if (r9 == 0) goto L_0x0182
            com.google.android.gms.internal.ads.zztz r9 = r0.zzj
            com.google.android.gms.internal.ads.zzyf r12 = r0.zze
            int r13 = r12.zzb
            java.lang.String r14 = r0.zzi
            if (r14 == 0) goto L_0x0180
            byte[] r15 = r12.zzc
            int r12 = r12.zza
            byte[] r12 = java.util.Arrays.copyOf(r15, r12)
            com.google.android.gms.internal.ads.zzakq r15 = new com.google.android.gms.internal.ads.zzakq
            int r10 = r12.length
            r15.<init>(r12, r10)
            r15.zzk(r13)
            r10 = 4
            r15.zzk(r10)
            r15.zze()
            r13 = 8
            r15.zzf(r13)
            boolean r16 = r15.zzg()
            r11 = 3
            if (r16 == 0) goto L_0x00a1
            r15.zzf(r10)
            r15.zzf(r11)
        L_0x00a1:
            int r10 = r15.zzh(r10)
            r16 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r11 = "Invalid aspect ratio"
            java.lang.String r13 = "H263Reader"
            r17 = r5
            r5 = 15
            if (r10 != r5) goto L_0x00c6
            r5 = 8
            int r10 = r15.zzh(r5)
            int r5 = r15.zzh(r5)
            if (r5 != 0) goto L_0x00c1
            android.util.Log.w(r13, r11)
            goto L_0x00d3
        L_0x00c1:
            float r10 = (float) r10
            float r5 = (float) r5
            float r16 = r10 / r5
            goto L_0x00cd
        L_0x00c6:
            r5 = 7
            if (r10 >= r5) goto L_0x00d0
            float[] r5 = zza
            r16 = r5[r10]
        L_0x00cd:
            r5 = r16
            goto L_0x00d5
        L_0x00d0:
            android.util.Log.w(r13, r11)
        L_0x00d3:
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x00d5:
            boolean r10 = r15.zzg()
            r11 = 2
            if (r10 == 0) goto L_0x010f
            r15.zzf(r11)
            r10 = 1
            r15.zzf(r10)
            boolean r10 = r15.zzg()
            if (r10 == 0) goto L_0x010f
            r10 = 15
            r15.zzf(r10)
            r15.zze()
            r15.zzf(r10)
            r15.zze()
            r15.zzf(r10)
            r15.zze()
            r11 = 3
            r15.zzf(r11)
            r11 = 11
            r15.zzf(r11)
            r15.zze()
            r15.zzf(r10)
            r15.zze()
        L_0x010f:
            r10 = 2
            int r10 = r15.zzh(r10)
            if (r10 == 0) goto L_0x011b
            java.lang.String r10 = "Unhandled video object layer shape"
            android.util.Log.w(r13, r10)
        L_0x011b:
            r15.zze()
            r10 = 16
            int r10 = r15.zzh(r10)
            r15.zze()
            boolean r11 = r15.zzg()
            if (r11 == 0) goto L_0x0142
            if (r10 != 0) goto L_0x0135
            java.lang.String r10 = "Invalid vop_increment_time_resolution"
            android.util.Log.w(r13, r10)
            goto L_0x0142
        L_0x0135:
            int r10 = r10 + -1
            r11 = 0
        L_0x0138:
            if (r10 <= 0) goto L_0x013f
            int r11 = r11 + 1
            int r10 = r10 >> 1
            goto L_0x0138
        L_0x013f:
            r15.zzf(r11)
        L_0x0142:
            r15.zze()
            r10 = 13
            int r11 = r15.zzh(r10)
            r15.zze()
            int r10 = r15.zzh(r10)
            r15.zze()
            r15.zze()
            com.google.android.gms.internal.ads.zzkb r13 = new com.google.android.gms.internal.ads.zzkb
            r13.<init>()
            r13.zza(r14)
            java.lang.String r14 = "video/mp4v-es"
            r13.zzj(r14)
            r13.zzo(r11)
            r13.zzp(r10)
            r13.zzs(r5)
            java.util.List r5 = java.util.Collections.singletonList(r12)
            r13.zzl(r5)
            com.google.android.gms.internal.ads.zzkc r5 = r13.zzD()
            r9.zza(r5)
            r5 = 1
            r0.zzk = r5
            goto L_0x0184
        L_0x0180:
            r1 = 0
            throw r1
        L_0x0182:
            r17 = r5
        L_0x0184:
            com.google.android.gms.internal.ads.zzyg r5 = r0.zzg
            r5.zzc(r3, r1, r4)
            com.google.android.gms.internal.ads.zzyr r5 = r0.zzf
            if (r8 <= 0) goto L_0x0192
            r5.zzd(r3, r1, r4)
            r10 = 0
            goto L_0x0193
        L_0x0192:
            int r10 = -r8
        L_0x0193:
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzf
            boolean r1 = r1.zze(r10)
            if (r1 == 0) goto L_0x01b9
            com.google.android.gms.internal.ads.zzyr r1 = r0.zzf
            byte[] r5 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzakj.zza(r5, r1)
            com.google.android.gms.internal.ads.zzakr r5 = r0.zzc
            int r8 = com.google.android.gms.internal.ads.zzalh.zza
            com.google.android.gms.internal.ads.zzyr r8 = r0.zzf
            byte[] r8 = r8.zza
            r5.zzb(r8, r1)
            com.google.android.gms.internal.ads.zzzr r1 = r0.zzb
            long r8 = r0.zzl
            com.google.android.gms.internal.ads.zzakr r5 = r0.zzc
            r1.zzb(r8, r5)
        L_0x01b9:
            r1 = 178(0xb2, float:2.5E-43)
            if (r7 != r1) goto L_0x01cf
            byte[] r5 = r19.zzi()
            int r7 = r4 + 2
            byte r5 = r5[r7]
            r7 = 1
            if (r5 != r7) goto L_0x01cd
            com.google.android.gms.internal.ads.zzyr r5 = r0.zzf
            r5.zzc(r1)
        L_0x01cd:
            r7 = 178(0xb2, float:2.5E-43)
        L_0x01cf:
            int r1 = r2 - r4
            long r4 = r0.zzh
            com.google.android.gms.internal.ads.zzyg r8 = r0.zzg
            long r9 = (long) r1
            long r4 = r4 - r9
            boolean r9 = r0.zzk
            r8.zzd(r4, r1, r9)
            com.google.android.gms.internal.ads.zzyg r1 = r0.zzg
            long r4 = r0.zzl
            r1.zzb(r7, r4)
            r1 = r17
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyh.zzd(com.google.android.gms.internal.ads.zzakr):void");
    }

    public final void zze() {
    }

    public zzyh(@Nullable zzzr zzzr) {
        this.zzb = zzzr;
        this.zzd = new boolean[4];
        this.zze = new zzyf(128);
        this.zzf = new zzyr(178, 128);
        this.zzc = new zzakr();
    }
}
