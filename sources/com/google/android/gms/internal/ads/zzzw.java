package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzw implements zzta {
    public static final zztg zza = zzzs.zza;
    public zztd zzb;
    public zztz zzc;
    public zzzu zzd;
    public int zze = -1;
    public long zzf = -1;

    public final boolean zzd(zztb zztb) throws IOException {
        return zzzz.zza(zztb) != null;
    }

    public final void zze(zztd zztd) {
        this.zzb = zztd;
        this.zzc = zztd.zza(0, 1);
        zztd.zzbl();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        if (r2 != 65534) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzf(com.google.android.gms.internal.ads.zztb r18, com.google.android.gms.internal.ads.zzts r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.google.android.gms.internal.ads.zztz r2 = r0.zzc
            com.google.android.gms.internal.ads.zzajg.zze(r2)
            int r2 = com.google.android.gms.internal.ads.zzalh.zza
            com.google.android.gms.internal.ads.zzzu r2 = r0.zzd
            r3 = 1
            r4 = 0
            r5 = 0
            if (r2 != 0) goto L_0x0096
            com.google.android.gms.internal.ads.zzzx r9 = com.google.android.gms.internal.ads.zzzz.zza(r18)
            if (r9 == 0) goto L_0x008e
            int r2 = r9.zza
            r6 = 17
            if (r2 != r6) goto L_0x002b
            com.google.android.gms.internal.ads.zzzt r2 = new com.google.android.gms.internal.ads.zzzt
            com.google.android.gms.internal.ads.zztd r6 = r0.zzb
            com.google.android.gms.internal.ads.zztz r7 = r0.zzc
            r2.<init>(r6, r7, r9)
            r0.zzd = r2
            goto L_0x0096
        L_0x002b:
            r6 = 6
            if (r2 != r6) goto L_0x003e
            com.google.android.gms.internal.ads.zzzv r2 = new com.google.android.gms.internal.ads.zzzv
            com.google.android.gms.internal.ads.zztd r7 = r0.zzb
            com.google.android.gms.internal.ads.zztz r8 = r0.zzc
            r11 = -1
            java.lang.String r10 = "audio/g711-alaw"
            r6 = r2
            r6.<init>(r7, r8, r9, r10, r11)
            r0.zzd = r2
            goto L_0x0096
        L_0x003e:
            r6 = 7
            if (r2 != r6) goto L_0x0051
            com.google.android.gms.internal.ads.zzzv r2 = new com.google.android.gms.internal.ads.zzzv
            com.google.android.gms.internal.ads.zztd r7 = r0.zzb
            com.google.android.gms.internal.ads.zztz r8 = r0.zzc
            r11 = -1
            java.lang.String r10 = "audio/g711-mlaw"
            r6 = r2
            r6.<init>(r7, r8, r9, r10, r11)
            r0.zzd = r2
            goto L_0x0096
        L_0x0051:
            int r6 = r9.zze
            if (r2 == r3) goto L_0x0068
            r7 = 3
            if (r2 == r7) goto L_0x005e
            r7 = 65534(0xfffe, float:9.1833E-41)
            if (r2 == r7) goto L_0x0068
            goto L_0x0065
        L_0x005e:
            r2 = 32
            if (r6 != r2) goto L_0x0065
            r2 = 4
            r11 = 4
            goto L_0x006d
        L_0x0065:
            r2 = 0
            r11 = 0
            goto L_0x006d
        L_0x0068:
            int r2 = com.google.android.gms.internal.ads.zzalh.zzM(r6)
            r11 = r2
        L_0x006d:
            if (r11 == 0) goto L_0x007e
            com.google.android.gms.internal.ads.zzzv r2 = new com.google.android.gms.internal.ads.zzzv
            com.google.android.gms.internal.ads.zztd r7 = r0.zzb
            com.google.android.gms.internal.ads.zztz r8 = r0.zzc
            java.lang.String r10 = "audio/raw"
            r6 = r2
            r6.<init>(r7, r8, r9, r10, r11)
            r0.zzd = r2
            goto L_0x0096
        L_0x007e:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            int r2 = r9.zza
            r3 = 40
            java.lang.String r5 = "Unsupported WAV format type: "
            java.lang.String r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r3, r5, r2)
            r1.<init>(r2, r4)
            throw r1
        L_0x008e:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "Unsupported or unrecognized wav header."
            r1.<init>(r2, r4)
            throw r1
        L_0x0096:
            int r2 = r0.zze
            r6 = -1
            r8 = -1
            if (r2 != r8) goto L_0x0151
            r18.zzl()
            com.google.android.gms.internal.ads.zzakr r2 = new com.google.android.gms.internal.ads.zzakr
            r9 = 8
            r2.<init>((int) r9)
            com.google.android.gms.internal.ads.zzzy r10 = com.google.android.gms.internal.ads.zzzy.zza(r1, r2)
        L_0x00ab:
            int r11 = r10.zza
            r12 = 1684108385(0x64617461, float:1.6635614E22)
            java.lang.String r13 = "WavHeaderReader"
            if (r11 == r12) goto L_0x00f1
            r12 = 1380533830(0x52494646, float:2.16116855E11)
            if (r11 == r12) goto L_0x00c5
            r14 = 1718449184(0x666d7420, float:2.8033575E23)
            if (r11 == r14) goto L_0x00c5
            r14 = 39
            java.lang.String r15 = "Ignoring unknown WAV chunk: "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r14, r15, r11, r13)
        L_0x00c5:
            long r13 = r10.zzb
            r15 = 8
            long r13 = r13 + r15
            int r10 = r10.zza
            if (r10 != r12) goto L_0x00d0
            r13 = 12
        L_0x00d0:
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 > 0) goto L_0x00e3
            r10 = r1
            com.google.android.gms.internal.ads.zzsx r10 = (com.google.android.gms.internal.ads.zzsx) r10
            int r11 = (int) r13
            r10.zze(r11, r5)
            com.google.android.gms.internal.ads.zzzy r10 = com.google.android.gms.internal.ads.zzzy.zza(r1, r2)
            goto L_0x00ab
        L_0x00e3:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            r2 = 51
            java.lang.String r3 = "Chunk is too large (~2GB+) to skip; id: "
            java.lang.String r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r2, r3, r10)
            r1.<init>(r2, r4)
            throw r1
        L_0x00f1:
            r2 = r1
            com.google.android.gms.internal.ads.zzsx r2 = (com.google.android.gms.internal.ads.zzsx) r2
            r2.zze(r9, r5)
            long r11 = r18.zzn()
            long r9 = r10.zzb
            long r9 = r9 + r11
            long r14 = r18.zzo()
            int r2 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0129
            int r2 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x0129
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 69
            r2.<init>(r4)
            java.lang.String r4 = "Data exceeds input length: "
            r2.append(r4)
            r2.append(r9)
            java.lang.String r4 = ", "
            r2.append(r4)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r13, r2)
            r9 = r14
        L_0x0129:
            java.lang.Long r2 = java.lang.Long.valueOf(r11)
            java.lang.Long r4 = java.lang.Long.valueOf(r9)
            android.util.Pair r2 = android.util.Pair.create(r2, r4)
            java.lang.Object r4 = r2.first
            java.lang.Long r4 = (java.lang.Long) r4
            int r4 = r4.intValue()
            r0.zze = r4
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r9 = r2.longValue()
            r0.zzf = r9
            com.google.android.gms.internal.ads.zzzu r2 = r0.zzd
            int r4 = r0.zze
            r2.zzb(r4, r9)
            goto L_0x0163
        L_0x0151:
            long r9 = r18.zzn()
            r11 = 0
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x0163
            int r2 = r0.zze
            r4 = r1
            com.google.android.gms.internal.ads.zzsx r4 = (com.google.android.gms.internal.ads.zzsx) r4
            r4.zze(r2, r5)
        L_0x0163:
            long r9 = r0.zzf
            int r2 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x016a
            goto L_0x016b
        L_0x016a:
            r3 = 0
        L_0x016b:
            com.google.android.gms.internal.ads.zzajg.zzd(r3)
            long r2 = r0.zzf
            long r6 = r18.zzn()
            com.google.android.gms.internal.ads.zzzu r4 = r0.zzd
            long r2 = r2 - r6
            boolean r1 = r4.zzc(r1, r2)
            if (r1 == 0) goto L_0x017e
            return r8
        L_0x017e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzw.zzf(com.google.android.gms.internal.ads.zztb, com.google.android.gms.internal.ads.zzts):int");
    }

    public final void zzg(long j, long j2) {
        zzzu zzzu = this.zzd;
        if (zzzu != null) {
            zzzu.zza(j2);
        }
    }
}
