package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxu implements zzta {
    public static final zztg zza = zzxt.zza;
    public final zzxv zzb = new zzxv((String) null);
    public final zzakr zzc = new zzakr(16384);
    public boolean zzd;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0046, code lost:
        r16.zzl();
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004f, code lost:
        if ((r5 - r3) >= 8192) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(com.google.android.gms.internal.ads.zztb r16) throws java.io.IOException {
        /*
            r15 = this;
            com.google.android.gms.internal.ads.zzakr r0 = new com.google.android.gms.internal.ads.zzakr
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.zzi()
            r5 = r16
            com.google.android.gms.internal.ads.zzsx r5 = (com.google.android.gms.internal.ads.zzsx) r5
            r5.zzh(r4, r2, r1, r2)
            r0.zzh(r2)
            int r4 = r0.zzr()
            r6 = 4801587(0x494433, float:6.728456E-39)
            r7 = 3
            if (r4 == r6) goto L_0x009c
            r16.zzl()
            r4 = r16
            com.google.android.gms.internal.ads.zzsx r4 = (com.google.android.gms.internal.ads.zzsx) r4
            r4.zzj(r3, r2)
            r5 = r3
        L_0x002c:
            r1 = 0
        L_0x002d:
            byte[] r6 = r0.zzi()
            r8 = 7
            r4.zzh(r6, r2, r8, r2)
            r0.zzh(r2)
            int r6 = r0.zzo()
            r9 = 44096(0xac40, float:6.1792E-41)
            r10 = 44097(0xac41, float:6.1793E-41)
            if (r6 == r9) goto L_0x0056
            if (r6 == r10) goto L_0x0056
            r16.zzl()
            int r5 = r5 + 1
            int r1 = r5 - r3
            r6 = 8192(0x2000, float:1.14794E-41)
            if (r1 >= r6) goto L_0x0055
            r4.zzj(r5, r2)
            goto L_0x002c
        L_0x0055:
            return r2
        L_0x0056:
            r9 = 1
            int r1 = r1 + r9
            r11 = 4
            if (r1 < r11) goto L_0x005c
            return r9
        L_0x005c:
            byte[] r9 = r0.zzi()
            int r12 = r9.length
            r13 = -1
            if (r12 >= r8) goto L_0x0066
            r12 = -1
            goto L_0x0093
        L_0x0066:
            r12 = 2
            byte r12 = r9[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 8
            byte r14 = r9[r7]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r12 = r12 | r14
            r14 = 65535(0xffff, float:9.1834E-41)
            if (r12 != r14) goto L_0x008d
            byte r11 = r9[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 16
            r12 = 5
            byte r12 = r9[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 8
            r11 = r11 | r12
            r12 = 6
            byte r9 = r9[r12]
            r9 = r9 & 255(0xff, float:3.57E-43)
            r12 = r11 | r9
            goto L_0x008e
        L_0x008d:
            r8 = 4
        L_0x008e:
            if (r6 != r10) goto L_0x0092
            int r8 = r8 + 2
        L_0x0092:
            int r12 = r12 + r8
        L_0x0093:
            if (r12 != r13) goto L_0x0096
            return r2
        L_0x0096:
            int r12 = r12 + -7
            r4.zzj(r12, r2)
            goto L_0x002d
        L_0x009c:
            r0.zzk(r7)
            int r4 = r0.zzA()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.zzj(r4, r2)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxu.zzd(com.google.android.gms.internal.ads.zztb):boolean");
    }

    public final void zze(zztd zztd) {
        this.zzb.zzb(zztd, new zzzo(Integer.MIN_VALUE, 0, 1));
        zztd.zzbl();
        zztd.zzbm(new zztu(-9223372036854775807L, 0));
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        int zza2 = zztb.zza(this.zzc.zzi(), 0, 16384);
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzh(0);
        this.zzc.zzf(zza2);
        if (!this.zzd) {
            this.zzb.zzc(0, 4);
            this.zzd = true;
        }
        this.zzb.zzd(this.zzc);
        return 0;
    }

    public final void zzg(long j, long j2) {
        this.zzd = false;
        this.zzb.zza();
    }
}
