package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxr implements zzta {
    public static final zztg zza = zzxq.zza;
    public final zzxs zzb = new zzxs((String) null);
    public final zzakr zzc = new zzakr(2786);
    public boolean zzd;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        r9.zzl();
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0046, code lost:
        if ((r5 - r3) >= 8192) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(com.google.android.gms.internal.ads.zztb r9) throws java.io.IOException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzakr r0 = new com.google.android.gms.internal.ads.zzakr
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.zzi()
            r5 = r9
            com.google.android.gms.internal.ads.zzsx r5 = (com.google.android.gms.internal.ads.zzsx) r5
            r5.zzh(r4, r2, r1, r2)
            r0.zzh(r2)
            int r4 = r0.zzr()
            r6 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r6) goto L_0x0065
            r9.zzl()
            r4 = r9
            com.google.android.gms.internal.ads.zzsx r4 = (com.google.android.gms.internal.ads.zzsx) r4
            r4.zzj(r3, r2)
            r5 = r3
        L_0x0029:
            r1 = 0
        L_0x002a:
            byte[] r6 = r0.zzi()
            r7 = 6
            r4.zzh(r6, r2, r7, r2)
            r0.zzh(r2)
            int r6 = r0.zzo()
            r7 = 2935(0xb77, float:4.113E-42)
            if (r6 == r7) goto L_0x004d
            r9.zzl()
            int r5 = r5 + 1
            int r1 = r5 - r3
            r6 = 8192(0x2000, float:1.14794E-41)
            if (r1 >= r6) goto L_0x004c
            r4.zzj(r5, r2)
            goto L_0x0029
        L_0x004c:
            return r2
        L_0x004d:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L_0x0053
            return r6
        L_0x0053:
            byte[] r6 = r0.zzi()
            int r6 = com.google.android.gms.internal.ads.zzpc.zzd(r6)
            r7 = -1
            if (r6 != r7) goto L_0x005f
            return r2
        L_0x005f:
            int r6 = r6 + -6
            r4.zzj(r6, r2)
            goto L_0x002a
        L_0x0065:
            r4 = 3
            r0.zzk(r4)
            int r4 = r0.zzA()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.zzj(r4, r2)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxr.zzd(com.google.android.gms.internal.ads.zztb):boolean");
    }

    public final void zze(zztd zztd) {
        this.zzb.zzb(zztd, new zzzo(Integer.MIN_VALUE, 0, 1));
        zztd.zzbl();
        zztd.zzbm(new zztu(-9223372036854775807L, 0));
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        int zza2 = zztb.zza(this.zzc.zzi(), 0, 2786);
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
