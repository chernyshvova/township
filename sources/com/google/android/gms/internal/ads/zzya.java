package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzya implements zzyc {
    public final zzakr zza = new zzakr(new byte[18]);
    @Nullable
    public final String zzb;
    public String zzc;
    public zztz zzd;
    public int zze = 0;
    public int zzf;
    public int zzg;
    public long zzh;
    public zzkc zzi;
    public int zzj;
    public long zzk;

    public zzya(@Nullable String str) {
        this.zzb = str;
    }

    public final void zza() {
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zzc = zzzo.zzc();
        this.zzd = zztd.zza(zzzo.zzb(), 1);
    }

    public final void zzc(long j, int i) {
        this.zzk = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0009 A[EDGE_INSN: B:55:0x0009->B:49:0x0009 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzakr r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.google.android.gms.internal.ads.zztz r2 = r0.zzd
            com.google.android.gms.internal.ads.zzajg.zze(r2)
        L_0x0009:
            int r2 = r18.zzd()
            if (r2 <= 0) goto L_0x0184
            int r2 = r0.zze
            r3 = 8
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            r8 = 4
            if (r2 == 0) goto L_0x0134
            if (r2 == r7) goto L_0x004b
            int r2 = r18.zzd()
            int r3 = r0.zzj
            int r4 = r0.zzf
            int r3 = r3 - r4
            int r2 = java.lang.Math.min(r2, r3)
            com.google.android.gms.internal.ads.zztz r3 = r0.zzd
            com.google.android.gms.internal.ads.zztx.zzb(r3, r1, r2)
            int r3 = r0.zzf
            int r3 = r3 + r2
            r0.zzf = r3
            int r11 = r0.zzj
            if (r3 != r11) goto L_0x0009
            com.google.android.gms.internal.ads.zztz r7 = r0.zzd
            long r8 = r0.zzk
            r10 = 1
            r12 = 0
            r13 = 0
            r7.zzd(r8, r10, r11, r12, r13)
            long r2 = r0.zzk
            long r4 = r0.zzh
            long r2 = r2 + r4
            r0.zzk = r2
            r0.zze = r6
            goto L_0x0009
        L_0x004b:
            com.google.android.gms.internal.ads.zzakr r2 = r0.zza
            byte[] r2 = r2.zzi()
            int r9 = r18.zzd()
            int r10 = r0.zzf
            r11 = 18
            int r10 = 18 - r10
            int r9 = java.lang.Math.min(r9, r10)
            int r10 = r0.zzf
            r1.zzm(r2, r10, r9)
            int r2 = r0.zzf
            int r2 = r2 + r9
            r0.zzf = r2
            if (r2 != r11) goto L_0x0009
            com.google.android.gms.internal.ads.zzakr r2 = r0.zza
            byte[] r2 = r2.zzi()
            com.google.android.gms.internal.ads.zzkc r9 = r0.zzi
            if (r9 != 0) goto L_0x0085
            java.lang.String r9 = r0.zzc
            java.lang.String r10 = r0.zzb
            r12 = 0
            com.google.android.gms.internal.ads.zzkc r9 = com.google.android.gms.internal.ads.zzqx.zza(r2, r9, r10, r12)
            r0.zzi = r9
            com.google.android.gms.internal.ads.zztz r10 = r0.zzd
            r10.zza(r9)
        L_0x0085:
            byte r9 = r2[r6]
            r10 = 31
            r12 = -1
            r13 = -2
            r14 = 5
            r15 = 6
            r16 = 7
            if (r9 == r13) goto L_0x00cb
            if (r9 == r12) goto L_0x00b5
            if (r9 == r10) goto L_0x00a3
            byte r3 = r2[r14]
            r3 = r3 & r4
            int r3 = r3 << 12
            byte r4 = r2[r15]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r8
            r3 = r3 | r4
            byte r4 = r2[r16]
            goto L_0x00d8
        L_0x00a3:
            byte r9 = r2[r15]
            r4 = r4 & r9
            int r4 = r4 << 12
            byte r9 = r2[r16]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r8
            r4 = r4 | r9
            byte r3 = r2[r3]
            r3 = r3 & 60
            int r3 = r3 >> r5
            r3 = r3 | r4
            goto L_0x00c8
        L_0x00b5:
            byte r3 = r2[r16]
            r3 = r3 & r4
            int r3 = r3 << 12
            byte r4 = r2[r15]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r8
            r3 = r3 | r4
            r4 = 9
            byte r4 = r2[r4]
            r4 = r4 & 60
            int r4 = r4 >> r5
            r3 = r3 | r4
        L_0x00c8:
            int r3 = r3 + r7
            r4 = 1
            goto L_0x00de
        L_0x00cb:
            byte r3 = r2[r8]
            r3 = r3 & r4
            int r3 = r3 << 12
            byte r4 = r2[r16]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r8
            r3 = r3 | r4
            byte r4 = r2[r15]
        L_0x00d8:
            r4 = r4 & 240(0xf0, float:3.36E-43)
            int r4 = r4 >> r8
            r3 = r3 | r4
            int r3 = r3 + r7
            r4 = 0
        L_0x00de:
            if (r4 == 0) goto L_0x00e4
            int r3 = r3 * 16
            int r3 = r3 / 14
        L_0x00e4:
            r0.zzj = r3
            byte r3 = r2[r6]
            if (r3 == r13) goto L_0x0107
            if (r3 == r12) goto L_0x00fd
            if (r3 == r10) goto L_0x00f5
            byte r3 = r2[r8]
            r3 = r3 & r7
            int r3 = r3 << r15
            byte r2 = r2[r14]
            goto L_0x010d
        L_0x00f5:
            byte r3 = r2[r14]
            r3 = r3 & 7
            int r3 = r3 << r8
            byte r2 = r2[r15]
            goto L_0x0104
        L_0x00fd:
            byte r3 = r2[r8]
            r3 = r3 & 7
            int r3 = r3 << r8
            byte r2 = r2[r16]
        L_0x0104:
            r2 = r2 & 60
            goto L_0x010f
        L_0x0107:
            byte r3 = r2[r14]
            r3 = r3 & r7
            int r3 = r3 << r15
            byte r2 = r2[r8]
        L_0x010d:
            r2 = r2 & 252(0xfc, float:3.53E-43)
        L_0x010f:
            int r2 = r2 >> r5
            r2 = r2 | r3
            int r2 = r2 + r7
            int r2 = r2 * 32
            long r2 = (long) r2
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 * r7
            com.google.android.gms.internal.ads.zzkc r4 = r0.zzi
            int r4 = r4.zzz
            long r7 = (long) r4
            long r2 = r2 / r7
            int r3 = (int) r2
            long r2 = (long) r3
            r0.zzh = r2
            com.google.android.gms.internal.ads.zzakr r2 = r0.zza
            r2.zzh(r6)
            com.google.android.gms.internal.ads.zztz r2 = r0.zzd
            com.google.android.gms.internal.ads.zzakr r3 = r0.zza
            com.google.android.gms.internal.ads.zztx.zzb(r2, r3, r11)
            r0.zze = r5
            goto L_0x0009
        L_0x0134:
            int r2 = r18.zzd()
            if (r2 <= 0) goto L_0x0009
            int r2 = r0.zzg
            int r2 = r2 << r3
            r0.zzg = r2
            int r9 = r18.zzn()
            r2 = r2 | r9
            r0.zzg = r2
            r9 = 2147385345(0x7ffe8001, float:NaN)
            if (r2 == r9) goto L_0x015a
            r9 = -25230976(0xfffffffffe7f0180, float:-8.474023E37)
            if (r2 == r9) goto L_0x015a
            r9 = 536864768(0x1fffe800, float:1.0838051E-19)
            if (r2 == r9) goto L_0x015a
            r9 = -14745368(0xffffffffff1f00e8, float:-2.1135196E38)
            if (r2 != r9) goto L_0x0134
        L_0x015a:
            com.google.android.gms.internal.ads.zzakr r2 = r0.zza
            byte[] r2 = r2.zzi()
            int r3 = r0.zzg
            int r9 = r3 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r2[r6] = r9
            int r9 = r3 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r2[r7] = r9
            int r9 = r3 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r2[r5] = r9
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r2[r4] = r3
            r0.zzf = r8
            r0.zzg = r6
            r0.zze = r7
            goto L_0x0009
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzya.zzd(com.google.android.gms.internal.ads.zzakr):void");
    }

    public final void zze() {
    }
}
