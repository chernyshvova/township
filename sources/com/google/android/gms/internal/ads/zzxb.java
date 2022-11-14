package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxb implements zzxi {
    public final zzxh zza;
    public final long zzb;
    public final long zzc;
    public final zzxn zzd;
    public int zze;
    public long zzf;
    public long zzg;
    public long zzh;
    public long zzi;
    public long zzj;
    public long zzk;
    public long zzl;

    public zzxb(zzxn zzxn, long j, long j2, long j3, long j4, boolean z) {
        zzajg.zza(j >= 0 && j2 > j);
        this.zzd = zzxn;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzxh();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zztb r24) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            int r2 = r0.zze
            r3 = 1
            r5 = 0
            r6 = -1
            if (r2 == 0) goto L_0x00fe
            if (r2 == r3) goto L_0x0111
            r3 = 2
            r10 = 3
            if (r2 == r3) goto L_0x0018
            if (r2 == r10) goto L_0x0015
            return r6
        L_0x0015:
            r2 = r6
            goto L_0x00bf
        L_0x0018:
            long r2 = r0.zzi
            long r11 = r0.zzj
            int r13 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0024
        L_0x0020:
            r2 = r6
            r11 = r2
            goto L_0x00b8
        L_0x0024:
            long r2 = r24.zzn()
            com.google.android.gms.internal.ads.zzxh r11 = r0.zza
            long r12 = r0.zzj
            boolean r11 = r11.zzb(r1, r12)
            if (r11 != 0) goto L_0x0043
            long r11 = r0.zzi
            int r13 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003b
            r2 = r6
            goto L_0x00b8
        L_0x003b:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "No ogg page can be found."
            r1.<init>(r2)
            throw r1
        L_0x0043:
            com.google.android.gms.internal.ads.zzxh r11 = r0.zza
            r11.zzc(r1, r5)
            r24.zzl()
            long r11 = r0.zzh
            com.google.android.gms.internal.ads.zzxh r13 = r0.zza
            long r14 = r13.zzb
            long r11 = r11 - r14
            int r8 = r13.zzd
            int r9 = r13.zze
            int r8 = r8 + r9
            r16 = 0
            int r9 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r9 < 0) goto L_0x0065
            r18 = 72000(0x11940, double:3.55727E-319)
            int r9 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r9 >= 0) goto L_0x0065
            goto L_0x0020
        L_0x0065:
            int r9 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r9 >= 0) goto L_0x006e
            r0.zzj = r2
            r0.zzl = r14
            goto L_0x007c
        L_0x006e:
            long r2 = r24.zzn()
            long r13 = (long) r8
            long r2 = r2 + r13
            r0.zzi = r2
            com.google.android.gms.internal.ads.zzxh r2 = r0.zza
            long r2 = r2.zzb
            r0.zzk = r2
        L_0x007c:
            long r2 = r0.zzj
            long r13 = r0.zzi
            long r2 = r2 - r13
            r18 = 100000(0x186a0, double:4.94066E-319)
            int r9 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r9 >= 0) goto L_0x008d
            r0.zzj = r13
            r2 = r6
            r11 = r13
            goto L_0x00b8
        L_0x008d:
            long r2 = (long) r8
            int r8 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r8 > 0) goto L_0x0095
            r8 = 2
            goto L_0x0097
        L_0x0095:
            r8 = 1
        L_0x0097:
            long r13 = r24.zzn()
            long r4 = r0.zzj
            long r6 = r0.zzi
            long r2 = r2 * r8
            long r13 = r13 - r2
            long r2 = r4 - r6
            long r2 = r2 * r11
            long r8 = r0.zzl
            long r11 = r0.zzk
            long r8 = r8 - r11
            long r2 = r2 / r8
            long r17 = r2 + r13
            r2 = -1
            long r21 = r4 + r2
            r19 = r6
            long r11 = com.google.android.gms.internal.ads.zzalh.zzy(r17, r19, r21)
        L_0x00b8:
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00bd
            return r11
        L_0x00bd:
            r0.zze = r10
        L_0x00bf:
            com.google.android.gms.internal.ads.zzxh r4 = r0.zza
            r4.zzb(r1, r2)
            com.google.android.gms.internal.ads.zzxh r2 = r0.zza
            r3 = 0
            r2.zzc(r1, r3)
            com.google.android.gms.internal.ads.zzxh r2 = r0.zza
            long r3 = r2.zzb
            long r5 = r0.zzh
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00e1
            r24.zzl()
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzk
            r3 = 2
            long r1 = r1 + r3
            long r1 = -r1
            return r1
        L_0x00e1:
            r3 = 2
            int r5 = r2.zzd
            int r2 = r2.zze
            r6 = r1
            com.google.android.gms.internal.ads.zzsx r6 = (com.google.android.gms.internal.ads.zzsx) r6
            int r5 = r5 + r2
            r2 = 0
            r6.zze(r5, r2)
            long r5 = r24.zzn()
            r0.zzi = r5
            com.google.android.gms.internal.ads.zzxh r2 = r0.zza
            long r5 = r2.zzb
            r0.zzk = r5
            r2 = -1
            goto L_0x00bf
        L_0x00fe:
            long r4 = r24.zzn()
            r0.zzg = r4
            r0.zze = r3
            long r2 = r0.zzc
            r6 = -65307(0xffffffffffff00e5, double:NaN)
            long r2 = r2 + r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0111
            return r2
        L_0x0111:
            com.google.android.gms.internal.ads.zzxh r2 = r0.zza
            r2.zza()
            com.google.android.gms.internal.ads.zzxh r2 = r0.zza
            r3 = -1
            boolean r2 = r2.zzb(r1, r3)
            if (r2 == 0) goto L_0x0159
        L_0x0120:
            com.google.android.gms.internal.ads.zzxh r2 = r0.zza
            r3 = 0
            r2.zzc(r1, r3)
            com.google.android.gms.internal.ads.zzxh r2 = r0.zza
            int r4 = r2.zzd
            int r2 = r2.zze
            r5 = r1
            com.google.android.gms.internal.ads.zzsx r5 = (com.google.android.gms.internal.ads.zzsx) r5
            int r4 = r4 + r2
            r5.zze(r4, r3)
            com.google.android.gms.internal.ads.zzxh r2 = r0.zza
            int r4 = r2.zza
            r5 = 4
            r4 = r4 & r5
            if (r4 == r5) goto L_0x014d
            r4 = -1
            boolean r2 = r2.zzb(r1, r4)
            if (r2 == 0) goto L_0x014d
            long r6 = r24.zzn()
            long r8 = r0.zzc
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x0120
        L_0x014d:
            com.google.android.gms.internal.ads.zzxh r1 = r0.zza
            long r1 = r1.zzb
            r0.zzf = r1
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzg
            return r1
        L_0x0159:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            goto L_0x0160
        L_0x015f:
            throw r1
        L_0x0160:
            goto L_0x015f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxb.zza(com.google.android.gms.internal.ads.zztb):long");
    }

    public final void zzb(long j) {
        this.zzh = zzalh.zzy(j, 0, this.zzf - 1);
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0;
        this.zzl = this.zzf;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ zztv zzc() {
        if (this.zzf != 0) {
            return new zzxa(this, (zzwz) null);
        }
        return null;
    }
}
