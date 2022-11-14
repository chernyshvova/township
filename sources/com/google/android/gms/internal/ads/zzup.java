package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzup implements zzta {
    public static final zztg zza = zzuo.zza;
    public final zzakr zzb = new zzakr(4);
    public final zzakr zzc = new zzakr(9);
    public final zzakr zzd = new zzakr(11);
    public final zzakr zze = new zzakr();
    public final zzuq zzf = new zzuq();
    public zztd zzg;
    public int zzh = 1;
    public boolean zzi;
    public long zzj;
    public int zzk;
    public int zzl;
    public int zzm;
    public long zzn;
    public boolean zzo;
    public zzun zzp;
    public zzut zzq;

    private final zzakr zza(zztb zztb) throws IOException {
        if (this.zzm > this.zze.zzj()) {
            zzakr zzakr = this.zze;
            int zzj2 = zzakr.zzj();
            zzakr.zzb(new byte[Math.max(zzj2 + zzj2, this.zzm)], 0);
        } else {
            this.zze.zzh(0);
        }
        this.zze.zzf(this.zzm);
        ((zzsx) zztb).zzb(this.zze.zzi(), 0, this.zzm, false);
        return this.zze;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzb() {
        if (!this.zzo) {
            this.zzg.zzbm(new zztu(-9223372036854775807L, 0));
            this.zzo = true;
        }
    }

    public final boolean zzd(zztb zztb) throws IOException {
        zzsx zzsx = (zzsx) zztb;
        zzsx.zzh(this.zzb.zzi(), 0, 3, false);
        this.zzb.zzh(0);
        if (this.zzb.zzr() != 4607062) {
            return false;
        }
        zzsx.zzh(this.zzb.zzi(), 0, 2, false);
        this.zzb.zzh(0);
        if ((this.zzb.zzo() & 250) != 0) {
            return false;
        }
        zzsx.zzh(this.zzb.zzi(), 0, 4, false);
        this.zzb.zzh(0);
        int zzv = this.zzb.zzv();
        zztb.zzl();
        zzsx zzsx2 = (zzsx) zztb;
        zzsx2.zzj(zzv, false);
        zzsx2.zzh(this.zzb.zzi(), 0, 4, false);
        this.zzb.zzh(0);
        if (this.zzb.zzv() == 0) {
            return true;
        }
        return false;
    }

    public final void zze(zztd zztd) {
        this.zzg = zztd;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzf(com.google.android.gms.internal.ads.zztb r17, com.google.android.gms.internal.ads.zzts r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zztd r2 = r0.zzg
            com.google.android.gms.internal.ads.zzajg.zze(r2)
        L_0x0009:
            int r2 = r0.zzh
            r3 = -1
            r4 = 8
            r5 = 9
            r6 = 2
            r7 = 4
            r8 = 0
            r9 = 1
            if (r2 == r9) goto L_0x0123
            r10 = 3
            if (r2 == r6) goto L_0x0115
            if (r2 == r10) goto L_0x00cd
            if (r2 != r7) goto L_0x00c7
            boolean r2 = r0.zzi
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x002c
            long r2 = r0.zzj
            long r14 = r0.zzn
            long r2 = r2 + r14
            goto L_0x003b
        L_0x002c:
            com.google.android.gms.internal.ads.zzuq r2 = r0.zzf
            long r2 = r2.zzc()
            int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x0039
            r2 = 0
            goto L_0x003b
        L_0x0039:
            long r2 = r0.zzn
        L_0x003b:
            int r14 = r0.zzl
            if (r14 != r4) goto L_0x0052
            com.google.android.gms.internal.ads.zzun r14 = r0.zzp
            if (r14 == 0) goto L_0x0053
            r16.zzb()
            com.google.android.gms.internal.ads.zzun r4 = r0.zzp
            com.google.android.gms.internal.ads.zzakr r5 = r16.zza(r17)
            boolean r2 = r4.zzf(r5, r2)
        L_0x0050:
            r3 = 1
            goto L_0x00a6
        L_0x0052:
            r4 = r14
        L_0x0053:
            if (r4 != r5) goto L_0x0067
            com.google.android.gms.internal.ads.zzut r4 = r0.zzq
            if (r4 == 0) goto L_0x009c
            r16.zzb()
            com.google.android.gms.internal.ads.zzut r4 = r0.zzq
            com.google.android.gms.internal.ads.zzakr r5 = r16.zza(r17)
            boolean r2 = r4.zzf(r5, r2)
            goto L_0x0050
        L_0x0067:
            r5 = 18
            if (r4 != r5) goto L_0x009c
            boolean r4 = r0.zzo
            if (r4 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzuq r4 = r0.zzf
            com.google.android.gms.internal.ads.zzakr r5 = r16.zza(r17)
            boolean r2 = r4.zzf(r5, r2)
            com.google.android.gms.internal.ads.zzuq r3 = r0.zzf
            long r3 = r3.zzc()
            int r5 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0050
            com.google.android.gms.internal.ads.zztd r5 = r0.zzg
            com.google.android.gms.internal.ads.zztr r14 = new com.google.android.gms.internal.ads.zztr
            com.google.android.gms.internal.ads.zzuq r15 = r0.zzf
            long[] r15 = r15.zze()
            com.google.android.gms.internal.ads.zzuq r10 = r0.zzf
            long[] r10 = r10.zzd()
            r14.<init>(r15, r10, r3)
            r5.zzbm(r14)
            r0.zzo = r9
            goto L_0x0050
        L_0x009c:
            int r2 = r0.zzm
            r3 = r1
            com.google.android.gms.internal.ads.zzsx r3 = (com.google.android.gms.internal.ads.zzsx) r3
            r3.zze(r2, r8)
            r2 = 0
            r3 = 0
        L_0x00a6:
            boolean r4 = r0.zzi
            if (r4 != 0) goto L_0x00c0
            if (r2 == 0) goto L_0x00c0
            r0.zzi = r9
            com.google.android.gms.internal.ads.zzuq r2 = r0.zzf
            long r4 = r2.zzc()
            int r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00bc
            long r4 = r0.zzn
            long r10 = -r4
            goto L_0x00be
        L_0x00bc:
            r10 = 0
        L_0x00be:
            r0.zzj = r10
        L_0x00c0:
            r0.zzk = r7
            r0.zzh = r6
            if (r3 == 0) goto L_0x0009
            return r8
        L_0x00c7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00cd:
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzd
            byte[] r2 = r2.zzi()
            r4 = 11
            boolean r2 = r1.zzb(r2, r8, r4, r9)
            if (r2 != 0) goto L_0x00dc
            return r3
        L_0x00dc:
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzd
            r2.zzh(r8)
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzd
            int r2 = r2.zzn()
            r0.zzl = r2
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzd
            int r2 = r2.zzr()
            r0.zzm = r2
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzd
            int r2 = r2.zzr()
            long r2 = (long) r2
            r0.zzn = r2
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzd
            int r2 = r2.zzn()
            int r2 = r2 << 24
            long r2 = (long) r2
            long r4 = r0.zzn
            long r2 = r2 | r4
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            r0.zzn = r2
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzd
            r2.zzk(r10)
            r0.zzh = r7
            goto L_0x0009
        L_0x0115:
            int r2 = r0.zzk
            r3 = r1
            com.google.android.gms.internal.ads.zzsx r3 = (com.google.android.gms.internal.ads.zzsx) r3
            r3.zze(r2, r8)
            r0.zzk = r8
            r0.zzh = r10
            goto L_0x0009
        L_0x0123:
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            byte[] r2 = r2.zzi()
            boolean r2 = r1.zzb(r2, r8, r5, r9)
            if (r2 != 0) goto L_0x0130
            return r3
        L_0x0130:
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            r2.zzh(r8)
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            r2.zzk(r7)
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            int r2 = r2.zzn()
            r3 = r2 & 1
            r2 = r2 & r7
            if (r2 == 0) goto L_0x0156
            com.google.android.gms.internal.ads.zzun r2 = r0.zzp
            if (r2 != 0) goto L_0x0156
            com.google.android.gms.internal.ads.zzun r2 = new com.google.android.gms.internal.ads.zzun
            com.google.android.gms.internal.ads.zztd r7 = r0.zzg
            com.google.android.gms.internal.ads.zztz r4 = r7.zza(r4, r9)
            r2.<init>(r4)
            r0.zzp = r2
        L_0x0156:
            if (r3 == 0) goto L_0x0169
            com.google.android.gms.internal.ads.zzut r2 = r0.zzq
            if (r2 != 0) goto L_0x0169
            com.google.android.gms.internal.ads.zzut r2 = new com.google.android.gms.internal.ads.zzut
            com.google.android.gms.internal.ads.zztd r3 = r0.zzg
            com.google.android.gms.internal.ads.zztz r3 = r3.zza(r5, r6)
            r2.<init>(r3)
            r0.zzq = r2
        L_0x0169:
            com.google.android.gms.internal.ads.zztd r2 = r0.zzg
            r2.zzbl()
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            int r2 = r2.zzv()
            int r2 = r2 + -5
            r0.zzk = r2
            r0.zzh = r6
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzup.zzf(com.google.android.gms.internal.ads.zztb, com.google.android.gms.internal.ads.zzts):int");
    }

    public final void zzg(long j, long j2) {
        if (j == 0) {
            this.zzh = 1;
            this.zzi = false;
        } else {
            this.zzh = 3;
        }
        this.zzk = 0;
    }
}
