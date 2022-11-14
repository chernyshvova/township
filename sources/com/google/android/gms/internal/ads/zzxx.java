package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxx implements zzta {
    public static final zztg zza = zzxw.zza;
    public final zzxy zzb;
    public final zzakr zzc;
    public final zzakr zzd;
    public final zzakq zze;
    public zztd zzf;
    public long zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;

    public zzxx() {
        this(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0052, code lost:
        r10.zzl();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
        if ((r4 - r1) >= 8192) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(com.google.android.gms.internal.ads.zztb r10) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            com.google.android.gms.internal.ads.zzakr r2 = r9.zzd
            byte[] r2 = r2.zzi()
            r3 = r10
            com.google.android.gms.internal.ads.zzsx r3 = (com.google.android.gms.internal.ads.zzsx) r3
            r4 = 10
            r3.zzh(r2, r0, r4, r0)
            com.google.android.gms.internal.ads.zzakr r2 = r9.zzd
            r2.zzh(r0)
            com.google.android.gms.internal.ads.zzakr r2 = r9.zzd
            int r2 = r2.zzr()
            r4 = 4801587(0x494433, float:6.728456E-39)
            if (r2 == r4) goto L_0x0090
            r10.zzl()
            r2 = r10
            com.google.android.gms.internal.ads.zzsx r2 = (com.google.android.gms.internal.ads.zzsx) r2
            r2.zzj(r1, r0)
            long r3 = r9.zzh
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0034
            long r3 = (long) r1
            r9.zzh = r3
        L_0x0034:
            r4 = r1
        L_0x0035:
            r3 = 0
            r5 = 0
        L_0x0037:
            com.google.android.gms.internal.ads.zzakr r6 = r9.zzd
            byte[] r6 = r6.zzi()
            r7 = 2
            r2.zzh(r6, r0, r7, r0)
            com.google.android.gms.internal.ads.zzakr r6 = r9.zzd
            r6.zzh(r0)
            com.google.android.gms.internal.ads.zzakr r6 = r9.zzd
            int r6 = r6.zzo()
            boolean r6 = com.google.android.gms.internal.ads.zzxy.zzf(r6)
            if (r6 != 0) goto L_0x0062
            r10.zzl()
            int r4 = r4 + 1
            int r3 = r4 - r1
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r3 >= r5) goto L_0x0061
            r2.zzj(r4, r0)
            goto L_0x0035
        L_0x0061:
            return r0
        L_0x0062:
            r6 = 1
            int r3 = r3 + r6
            r7 = 4
            if (r3 < r7) goto L_0x006d
            r8 = 188(0xbc, float:2.63E-43)
            if (r5 > r8) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            return r6
        L_0x006d:
            com.google.android.gms.internal.ads.zzakr r6 = r9.zzd
            byte[] r6 = r6.zzi()
            r2.zzh(r6, r0, r7, r0)
            com.google.android.gms.internal.ads.zzakq r6 = r9.zze
            r7 = 14
            r6.zzd(r7)
            com.google.android.gms.internal.ads.zzakq r6 = r9.zze
            r7 = 13
            int r6 = r6.zzh(r7)
            r7 = 6
            if (r6 > r7) goto L_0x0089
            return r0
        L_0x0089:
            int r7 = r6 + -6
            r2.zzj(r7, r0)
            int r5 = r5 + r6
            goto L_0x0037
        L_0x0090:
            com.google.android.gms.internal.ads.zzakr r2 = r9.zzd
            r4 = 3
            r2.zzk(r4)
            com.google.android.gms.internal.ads.zzakr r2 = r9.zzd
            int r2 = r2.zzA()
            int r4 = r2 + 10
            int r1 = r1 + r4
            r3.zzj(r2, r0)
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxx.zzd(com.google.android.gms.internal.ads.zztb):boolean");
    }

    public final void zze(zztd zztd) {
        this.zzf = zztd;
        this.zzb.zzb(zztd, new zzzo(Integer.MIN_VALUE, 0, 1));
        zztd.zzbl();
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        zzajg.zze(this.zzf);
        int zza2 = zztb.zza(this.zzc.zzi(), 0, 2048);
        if (!this.zzj) {
            this.zzf.zzbm(new zztu(-9223372036854775807L, 0));
            this.zzj = true;
        }
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzh(0);
        this.zzc.zzf(zza2);
        if (!this.zzi) {
            this.zzb.zzc(this.zzg, 4);
            this.zzi = true;
        }
        this.zzb.zzd(this.zzc);
        return 0;
    }

    public final void zzg(long j, long j2) {
        this.zzi = false;
        this.zzb.zza();
        this.zzg = j2;
    }

    public zzxx(int i) {
        this.zzb = new zzxy(true, (String) null);
        this.zzc = new zzakr(2048);
        this.zzh = -1;
        zzakr zzakr = new zzakr(10);
        this.zzd = zzakr;
        byte[] zzi2 = zzakr.zzi();
        this.zze = new zzakq(zzi2, zzi2.length);
    }
}
