package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.FacebookRequestErrorClassification;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzt implements zzzu {
    public static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    public static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    public final zztd zzc;
    public final zztz zzd;
    public final zzzx zze;
    public final int zzf;
    public final byte[] zzg;
    public final zzakr zzh;
    public final int zzi;
    public final zzkc zzj;
    public int zzk;
    public long zzl;
    public int zzm;
    public long zzn;

    public zzzt(zztd zztd, zztz zztz, zzzx zzzx) throws zzlg {
        this.zzc = zztd;
        this.zzd = zztz;
        this.zze = zzzx;
        this.zzi = Math.max(1, zzzx.zzc / 10);
        zzakr zzakr = new zzakr(zzzx.zzf);
        zzakr.zzp();
        int zzp = zzakr.zzp();
        this.zzf = zzp;
        int i = zzzx.zzb;
        int i2 = (((zzzx.zzd - (i * 4)) * 8) / (zzzx.zze * i)) + 1;
        if (zzp == i2) {
            int zzw = zzalh.zzw(this.zzi, zzp);
            this.zzg = new byte[(zzzx.zzd * zzw)];
            int i3 = this.zzf;
            this.zzh = new zzakr((i3 + i3) * i * zzw);
            int i4 = ((zzzx.zzc * zzzx.zzd) * 8) / this.zzf;
            zzkb zzkb = new zzkb();
            zzkb.zzj("audio/raw");
            zzkb.zzf(i4);
            zzkb.zzg(i4);
            int i5 = this.zzi;
            zzkb.zzk((i5 + i5) * i);
            zzkb.zzw(zzzx.zzb);
            zzkb.zzx(zzzx.zzc);
            zzkb.zzy(2);
            this.zzj = zzkb.zzD();
            return;
        }
        throw new zzlg(GeneratedOutlineSupport.outline11(56, "Expected frames per block: ", i2, "; got: ", zzp), (Throwable) null);
    }

    private final void zzd(int i) {
        long j = this.zzl;
        long zzF = zzalh.zzF(this.zzn, 1000000, (long) this.zze.zzc);
        int zzf2 = zzf(i);
        this.zzd.zzd(j + zzF, 1, zzf2, this.zzm - zzf2, (zzty) null);
        this.zzn += (long) i;
        this.zzm -= zzf2;
    }

    private final int zze(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zzf(int i) {
        return (i + i) * this.zze.zzb;
    }

    public final void zza(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0;
    }

    public final void zzb(int i, long j) {
        this.zzc.zzbm(new zzaaa(this.zze, this.zzf, (long) i, j));
        this.zzd.zza(this.zzj);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0044 A[EDGE_INSN: B:38:0x0044->B:10:0x0044 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0024  */
    public final boolean zzc(com.google.android.gms.internal.ads.zztb r20, long r21) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            int r3 = r0.zzi
            int r4 = r0.zzm
            int r4 = r0.zze(r4)
            int r3 = r3 - r4
            int r4 = r0.zzf
            int r3 = com.google.android.gms.internal.ads.zzalh.zzw(r3, r4)
            com.google.android.gms.internal.ads.zzzx r4 = r0.zze
            int r4 = r4.zzd
            int r3 = r3 * r4
            r6 = 0
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0021
        L_0x001f:
            r6 = 1
            goto L_0x0022
        L_0x0021:
            r6 = 0
        L_0x0022:
            if (r6 != 0) goto L_0x0044
            int r7 = r0.zzk
            if (r7 >= r3) goto L_0x0044
            int r7 = r3 - r7
            long r7 = (long) r7
            long r7 = java.lang.Math.min(r7, r1)
            byte[] r9 = r0.zzg
            int r10 = r0.zzk
            int r8 = (int) r7
            r7 = r20
            int r8 = r7.zza(r9, r10, r8)
            r9 = -1
            if (r8 != r9) goto L_0x003e
            goto L_0x001f
        L_0x003e:
            int r9 = r0.zzk
            int r9 = r9 + r8
            r0.zzk = r9
            goto L_0x0022
        L_0x0044:
            int r1 = r0.zzk
            com.google.android.gms.internal.ads.zzzx r2 = r0.zze
            int r2 = r2.zzd
            int r1 = r1 / r2
            if (r1 <= 0) goto L_0x014e
            byte[] r2 = r0.zzg
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzh
            r7 = 0
        L_0x0052:
            if (r7 >= r1) goto L_0x0117
            r8 = 0
        L_0x0055:
            com.google.android.gms.internal.ads.zzzx r9 = r0.zze
            int r9 = r9.zzb
            if (r8 >= r9) goto L_0x010f
            byte[] r9 = r3.zzi()
            com.google.android.gms.internal.ads.zzzx r10 = r0.zze
            int r11 = r10.zzd
            int r10 = r10.zzb
            int r12 = r7 * r11
            int r13 = r8 * 4
            int r13 = r13 + r12
            int r12 = r10 * 4
            int r12 = r12 + r13
            int r11 = r11 / r10
            int r11 = r11 + -4
            int r14 = r13 + 1
            byte r14 = r2[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << 8
            byte r15 = r2[r13]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r14 = r14 | r15
            short r14 = (short) r14
            int r13 = r13 + 2
            byte r13 = r2[r13]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r15 = 88
            int r13 = java.lang.Math.min(r13, r15)
            int[] r16 = zzb
            r16 = r16[r13]
            int r4 = r0.zzf
            int r4 = r4 * r7
            int r4 = r4 * r10
            int r4 = r4 + r8
            int r4 = r4 + r4
            r15 = r14 & 255(0xff, float:3.57E-43)
            byte r15 = (byte) r15
            r9[r4] = r15
            int r15 = r4 + 1
            int r5 = r14 >> 8
            byte r5 = (byte) r5
            r9[r15] = r5
            r5 = 0
        L_0x00a3:
            int r15 = r11 + r11
            if (r5 >= r15) goto L_0x0107
            int r15 = r5 / 8
            int r15 = r15 * r10
            int r15 = r15 * 4
            int r15 = r15 + r12
            int r18 = r5 / 2
            int r18 = r18 % 4
            int r18 = r18 + r15
            byte r15 = r2[r18]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r18 = r5 % 2
            if (r18 != 0) goto L_0x00bf
            r15 = r15 & 15
            goto L_0x00c1
        L_0x00bf:
            int r15 = r15 >> 4
        L_0x00c1:
            r18 = r15 & 7
            int r18 = r18 + r18
            r17 = 1
            int r18 = r18 + 1
            int r18 = r18 * r16
            r16 = r2
            int r2 = r18 >> 3
            r18 = r15 & 8
            if (r18 == 0) goto L_0x00d4
            int r2 = -r2
        L_0x00d4:
            int r14 = r14 + r2
            r2 = -32768(0xffffffffffff8000, float:NaN)
            r21 = r11
            r11 = 32767(0x7fff, float:4.5916E-41)
            int r14 = com.google.android.gms.internal.ads.zzalh.zzx(r14, r2, r11)
            int r2 = r10 + r10
            int r4 = r4 + r2
            r2 = r14 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r9[r4] = r2
            int r2 = r4 + 1
            int r11 = r14 >> 8
            byte r11 = (byte) r11
            r9[r2] = r11
            int[] r2 = zza
            r2 = r2[r15]
            int r13 = r13 + r2
            r2 = 88
            r11 = 0
            int r13 = com.google.android.gms.internal.ads.zzalh.zzx(r13, r11, r2)
            int[] r11 = zzb
            r11 = r11[r13]
            int r5 = r5 + 1
            r2 = r16
            r16 = r11
            r11 = r21
            goto L_0x00a3
        L_0x0107:
            r16 = r2
            r17 = 1
            int r8 = r8 + 1
            goto L_0x0055
        L_0x010f:
            r16 = r2
            r17 = 1
            int r7 = r7 + 1
            goto L_0x0052
        L_0x0117:
            int r2 = r0.zzf
            int r2 = r2 * r1
            int r2 = r0.zzf(r2)
            r4 = 0
            r3.zzh(r4)
            r3.zzf(r2)
            int r2 = r0.zzk
            com.google.android.gms.internal.ads.zzzx r3 = r0.zze
            int r3 = r3.zzd
            int r1 = r1 * r3
            int r2 = r2 - r1
            r0.zzk = r2
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzh
            int r1 = r1.zze()
            com.google.android.gms.internal.ads.zztz r2 = r0.zzd
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzh
            com.google.android.gms.internal.ads.zztx.zzb(r2, r3, r1)
            int r2 = r0.zzm
            int r2 = r2 + r1
            r0.zzm = r2
            int r1 = r0.zze(r2)
            int r2 = r0.zzi
            if (r1 < r2) goto L_0x014e
            r0.zzd(r2)
        L_0x014e:
            if (r6 == 0) goto L_0x015b
            int r1 = r0.zzm
            int r1 = r0.zze(r1)
            if (r1 <= 0) goto L_0x015b
            r0.zzd(r1)
        L_0x015b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzt.zzc(com.google.android.gms.internal.ads.zztb, long):boolean");
    }
}
