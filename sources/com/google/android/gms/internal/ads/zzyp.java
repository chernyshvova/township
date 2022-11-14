package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyp implements zzyc {
    @Nullable
    public final String zza;
    public final zzakr zzb;
    public final zzakq zzc;
    public zztz zzd;
    public String zze;
    public zzkc zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    public int zzj;
    public long zzk;
    public boolean zzl;
    public int zzm;
    public int zzn;
    public int zzo;
    public boolean zzp;
    public long zzq;
    public int zzr;
    public long zzs;
    public int zzt;
    @Nullable
    public String zzu;

    public zzyp(@Nullable String str) {
        this.zza = str;
        zzakr zzakr = new zzakr(1024);
        this.zzb = zzakr;
        byte[] zzi2 = zzakr.zzi();
        this.zzc = new zzakq(zzi2, zzi2.length);
    }

    private final int zzf(zzakq zzakq) throws zzlg {
        int zzb2 = zzakq.zzb();
        zzoy zzb3 = zzoz.zzb(zzakq, true);
        this.zzu = zzb3.zzc;
        this.zzr = zzb3.zza;
        this.zzt = zzb3.zzb;
        return zzb2 - zzakq.zzb();
    }

    public static long zzg(zzakq zzakq) {
        return (long) zzakq.zzh((zzakq.zzh(2) + 1) * 8);
    }

    public final void zza() {
        this.zzg = 0;
        this.zzl = false;
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zzd = zztd.zza(zzzo.zzb(), 1);
        this.zze = zzzo.zzc();
    }

    public final void zzc(long j, int i) {
        this.zzk = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0157, code lost:
        if (r14.zzl == false) goto L_0x01b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzakr r15) throws com.google.android.gms.internal.ads.zzlg {
        /*
            r14 = this;
            com.google.android.gms.internal.ads.zztz r0 = r14.zzd
            com.google.android.gms.internal.ads.zzajg.zze(r0)
        L_0x0005:
            int r0 = r15.zzd()
            if (r0 <= 0) goto L_0x0219
            int r0 = r14.zzg
            r1 = 86
            r2 = 1
            if (r0 == 0) goto L_0x020f
            r3 = 2
            r4 = 0
            if (r0 == r2) goto L_0x01f9
            r1 = 3
            r5 = 8
            if (r0 == r3) goto L_0x01cb
            int r0 = r15.zzd()
            int r3 = r14.zzi
            int r6 = r14.zzh
            int r3 = r3 - r6
            int r0 = java.lang.Math.min(r0, r3)
            com.google.android.gms.internal.ads.zzakq r3 = r14.zzc
            byte[] r3 = r3.zza
            int r6 = r14.zzh
            r15.zzm(r3, r6, r0)
            int r3 = r14.zzh
            int r3 = r3 + r0
            r14.zzh = r3
            int r0 = r14.zzi
            if (r3 != r0) goto L_0x0005
            com.google.android.gms.internal.ads.zzakq r0 = r14.zzc
            r0.zzd(r4)
            com.google.android.gms.internal.ads.zzakq r0 = r14.zzc
            boolean r3 = r0.zzg()
            r6 = 0
            if (r3 != 0) goto L_0x0155
            r14.zzl = r2
            int r3 = r0.zzh(r2)
            if (r3 != r2) goto L_0x0056
            int r3 = r0.zzh(r2)
            r7 = 1
            goto L_0x0058
        L_0x0056:
            r7 = r3
            r3 = 0
        L_0x0058:
            r14.zzm = r3
            if (r3 != 0) goto L_0x014f
            if (r7 != r2) goto L_0x0062
            zzg(r0)
            r7 = 1
        L_0x0062:
            boolean r3 = r0.zzg()
            if (r3 == 0) goto L_0x0149
            r3 = 6
            int r8 = r0.zzh(r3)
            r14.zzn = r8
            r8 = 4
            int r9 = r0.zzh(r8)
            int r10 = r0.zzh(r1)
            if (r9 != 0) goto L_0x0143
            if (r10 != 0) goto L_0x0143
            if (r7 != 0) goto L_0x00d8
            int r9 = r0.zzc()
            int r10 = r14.zzf(r0)
            r0.zzd(r9)
            int r9 = r10 + 7
            int r9 = r9 / r5
            byte[] r9 = new byte[r9]
            r0.zzi(r9, r4, r10)
            com.google.android.gms.internal.ads.zzkb r10 = new com.google.android.gms.internal.ads.zzkb
            r10.<init>()
            java.lang.String r11 = r14.zze
            r10.zza(r11)
            java.lang.String r11 = "audio/mp4a-latm"
            r10.zzj(r11)
            java.lang.String r11 = r14.zzu
            r10.zzh(r11)
            int r11 = r14.zzt
            r10.zzw(r11)
            int r11 = r14.zzr
            r10.zzx(r11)
            java.util.List r9 = java.util.Collections.singletonList(r9)
            r10.zzl(r9)
            java.lang.String r9 = r14.zza
            r10.zzd(r9)
            com.google.android.gms.internal.ads.zzkc r9 = r10.zzD()
            com.google.android.gms.internal.ads.zzkc r10 = r14.zzf
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x00e5
            r14.zzf = r9
            r10 = 1024000000(0x3d090000, double:5.059232213E-315)
            int r12 = r9.zzz
            long r12 = (long) r12
            long r10 = r10 / r12
            r14.zzs = r10
            com.google.android.gms.internal.ads.zztz r10 = r14.zzd
            r10.zza(r9)
            goto L_0x00e5
        L_0x00d8:
            long r9 = zzg(r0)
            int r10 = (int) r9
            int r9 = r14.zzf(r0)
            int r10 = r10 - r9
            r0.zzf(r10)
        L_0x00e5:
            int r9 = r0.zzh(r1)
            r14.zzo = r9
            if (r9 == 0) goto L_0x0110
            if (r9 == r2) goto L_0x010a
            if (r9 == r1) goto L_0x0106
            if (r9 == r8) goto L_0x0106
            r1 = 5
            if (r9 == r1) goto L_0x0106
            if (r9 == r3) goto L_0x0102
            r1 = 7
            if (r9 != r1) goto L_0x00fc
            goto L_0x0102
        L_0x00fc:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            r15.<init>()
            throw r15
        L_0x0102:
            r0.zzf(r2)
            goto L_0x0113
        L_0x0106:
            r0.zzf(r3)
            goto L_0x0113
        L_0x010a:
            r1 = 9
            r0.zzf(r1)
            goto L_0x0113
        L_0x0110:
            r0.zzf(r5)
        L_0x0113:
            boolean r1 = r0.zzg()
            r14.zzp = r1
            r8 = 0
            r14.zzq = r8
            if (r1 == 0) goto L_0x0139
            if (r7 == r2) goto L_0x0133
        L_0x0121:
            boolean r1 = r0.zzg()
            long r2 = r14.zzq
            long r2 = r2 << r5
            int r7 = r0.zzh(r5)
            long r7 = (long) r7
            long r2 = r2 + r7
            r14.zzq = r2
            if (r1 != 0) goto L_0x0121
            goto L_0x0139
        L_0x0133:
            long r1 = zzg(r0)
            r14.zzq = r1
        L_0x0139:
            boolean r1 = r0.zzg()
            if (r1 == 0) goto L_0x015a
            r0.zzf(r5)
            goto L_0x015a
        L_0x0143:
            com.google.android.gms.internal.ads.zzlg r15 = new com.google.android.gms.internal.ads.zzlg
            r15.<init>(r6, r6)
            throw r15
        L_0x0149:
            com.google.android.gms.internal.ads.zzlg r15 = new com.google.android.gms.internal.ads.zzlg
            r15.<init>(r6, r6)
            throw r15
        L_0x014f:
            com.google.android.gms.internal.ads.zzlg r15 = new com.google.android.gms.internal.ads.zzlg
            r15.<init>(r6, r6)
            throw r15
        L_0x0155:
            boolean r1 = r14.zzl
            if (r1 != 0) goto L_0x015a
            goto L_0x01b3
        L_0x015a:
            int r1 = r14.zzm
            if (r1 != 0) goto L_0x01c5
            int r1 = r14.zzn
            if (r1 != 0) goto L_0x01bf
            int r1 = r14.zzo
            if (r1 != 0) goto L_0x01b9
            r1 = 0
        L_0x0167:
            int r2 = r0.zzh(r5)
            int r10 = r1 + r2
            r1 = 255(0xff, float:3.57E-43)
            if (r2 == r1) goto L_0x01b7
            int r1 = r0.zzc()
            r2 = r1 & 7
            if (r2 != 0) goto L_0x0181
            com.google.android.gms.internal.ads.zzakr r2 = r14.zzb
            int r1 = r1 >> 3
            r2.zzh(r1)
            goto L_0x0191
        L_0x0181:
            com.google.android.gms.internal.ads.zzakr r1 = r14.zzb
            byte[] r1 = r1.zzi()
            int r2 = r10 * 8
            r0.zzi(r1, r4, r2)
            com.google.android.gms.internal.ads.zzakr r1 = r14.zzb
            r1.zzh(r4)
        L_0x0191:
            com.google.android.gms.internal.ads.zztz r1 = r14.zzd
            com.google.android.gms.internal.ads.zzakr r2 = r14.zzb
            com.google.android.gms.internal.ads.zztx.zzb(r1, r2, r10)
            com.google.android.gms.internal.ads.zztz r6 = r14.zzd
            long r7 = r14.zzk
            r9 = 1
            r11 = 0
            r12 = 0
            r6.zzd(r7, r9, r10, r11, r12)
            long r1 = r14.zzk
            long r5 = r14.zzs
            long r1 = r1 + r5
            r14.zzk = r1
            boolean r1 = r14.zzp
            if (r1 == 0) goto L_0x01b3
            long r1 = r14.zzq
            int r2 = (int) r1
            r0.zzf(r2)
        L_0x01b3:
            r14.zzg = r4
            goto L_0x0005
        L_0x01b7:
            r1 = r10
            goto L_0x0167
        L_0x01b9:
            com.google.android.gms.internal.ads.zzlg r15 = new com.google.android.gms.internal.ads.zzlg
            r15.<init>(r6, r6)
            throw r15
        L_0x01bf:
            com.google.android.gms.internal.ads.zzlg r15 = new com.google.android.gms.internal.ads.zzlg
            r15.<init>(r6, r6)
            throw r15
        L_0x01c5:
            com.google.android.gms.internal.ads.zzlg r15 = new com.google.android.gms.internal.ads.zzlg
            r15.<init>(r6, r6)
            throw r15
        L_0x01cb:
            int r0 = r14.zzj
            r0 = r0 & -225(0xffffffffffffff1f, float:NaN)
            int r0 = r0 << r5
            int r2 = r15.zzn()
            r0 = r0 | r2
            r14.zzi = r0
            com.google.android.gms.internal.ads.zzakr r2 = r14.zzb
            byte[] r2 = r2.zzi()
            int r2 = r2.length
            if (r0 <= r2) goto L_0x01f3
            int r0 = r14.zzi
            com.google.android.gms.internal.ads.zzakr r2 = r14.zzb
            r2.zza(r0)
            com.google.android.gms.internal.ads.zzakq r0 = r14.zzc
            com.google.android.gms.internal.ads.zzakr r2 = r14.zzb
            byte[] r2 = r2.zzi()
            int r3 = r2.length
            r0.zza(r2, r3)
        L_0x01f3:
            r14.zzh = r4
            r14.zzg = r1
            goto L_0x0005
        L_0x01f9:
            int r0 = r15.zzn()
            r2 = r0 & 224(0xe0, float:3.14E-43)
            r5 = 224(0xe0, float:3.14E-43)
            if (r2 != r5) goto L_0x0209
            r14.zzj = r0
            r14.zzg = r3
            goto L_0x0005
        L_0x0209:
            if (r0 == r1) goto L_0x0005
            r14.zzg = r4
            goto L_0x0005
        L_0x020f:
            int r0 = r15.zzn()
            if (r0 != r1) goto L_0x0005
            r14.zzg = r2
            goto L_0x0005
        L_0x0219:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyp.zzd(com.google.android.gms.internal.ads.zzakr):void");
    }

    public final void zze() {
    }
}
