package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzk implements zzta {
    public static final zztg zza = zzzh.zza;
    public final List<zzale> zzb;
    public final zzakr zzc;
    public final SparseIntArray zzd;
    public final zzzn zze;
    public final SparseArray<zzzp> zzf;
    public final SparseBooleanArray zzg;
    public final SparseBooleanArray zzh;
    public final zzzg zzi;
    public zzzf zzj;
    public zztd zzk;
    public int zzl;
    public boolean zzm;
    public boolean zzn;
    public boolean zzo;
    public int zzp;
    public int zzq;

    public zzzk() {
        this(0);
    }

    public static /* synthetic */ int zzb(zzzk zzzk) {
        int i = zzzk.zzl;
        zzzk.zzl = i + 1;
        return i;
    }

    public final boolean zzd(zztb zztb) throws IOException {
        byte[] zzi2 = this.zzc.zzi();
        zzsx zzsx = (zzsx) zztb;
        zzsx.zzh(zzi2, 0, 940, false);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 < 5) {
                if (zzi2[(i2 * 188) + i] != 71) {
                    i++;
                } else {
                    i2++;
                }
            }
            zzsx.zze(i, false);
            return true;
        }
        return false;
    }

    public final void zze(zztd zztd) {
        this.zzk = zztd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ae, code lost:
        if (r2 == false) goto L_0x01b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzf(com.google.android.gms.internal.ads.zztb r19, com.google.android.gms.internal.ads.zzts r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            long r11 = r19.zzo()
            boolean r3 = r0.zzm
            r13 = -1
            r15 = 1
            r10 = 0
            if (r3 == 0) goto L_0x00a8
            int r3 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0028
            com.google.android.gms.internal.ads.zzzg r3 = r0.zzi
            boolean r3 = r3.zza()
            if (r3 == 0) goto L_0x001f
            goto L_0x0028
        L_0x001f:
            com.google.android.gms.internal.ads.zzzg r3 = r0.zzi
            int r4 = r0.zzq
            int r1 = r3.zzb(r1, r2, r4)
            return r1
        L_0x0028:
            boolean r3 = r0.zzn
            r7 = 0
            if (r3 != 0) goto L_0x007d
            r0.zzn = r15
            com.google.android.gms.internal.ads.zzzg r3 = r0.zzi
            long r3 = r3.zzc()
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x006b
            com.google.android.gms.internal.ads.zzzf r9 = new com.google.android.gms.internal.ads.zzzf
            com.google.android.gms.internal.ads.zzzg r3 = r0.zzi
            com.google.android.gms.internal.ads.zzale r4 = r3.zzd()
            com.google.android.gms.internal.ads.zzzg r3 = r0.zzi
            long r5 = r3.zzc()
            int r3 = r0.zzq
            r16 = 112800(0x1b8a0, float:1.58066E-40)
            r17 = r3
            r3 = r9
            r13 = r7
            r7 = r11
            r15 = r9
            r9 = r17
            r10 = r16
            r3.<init>(r4, r5, r7, r9, r10)
            r0.zzj = r15
            com.google.android.gms.internal.ads.zztd r3 = r0.zzk
            com.google.android.gms.internal.ads.zztv r4 = r15.zza()
            r3.zzbm(r4)
            goto L_0x007e
        L_0x006b:
            r13 = r7
            com.google.android.gms.internal.ads.zztd r3 = r0.zzk
            com.google.android.gms.internal.ads.zztu r4 = new com.google.android.gms.internal.ads.zztu
            com.google.android.gms.internal.ads.zzzg r5 = r0.zzi
            long r5 = r5.zzc()
            r4.<init>(r5, r13)
            r3.zzbm(r4)
            goto L_0x007e
        L_0x007d:
            r13 = r7
        L_0x007e:
            boolean r3 = r0.zzo
            if (r3 == 0) goto L_0x0095
            r3 = 0
            r0.zzo = r3
            r0.zzg(r13, r13)
            long r4 = r19.zzn()
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x0091
            goto L_0x0096
        L_0x0091:
            r2.zza = r13
            r1 = 1
            return r1
        L_0x0095:
            r3 = 0
        L_0x0096:
            com.google.android.gms.internal.ads.zzzf r4 = r0.zzj
            if (r4 == 0) goto L_0x00a9
            boolean r4 = r4.zzc()
            if (r4 != 0) goto L_0x00a1
            goto L_0x00a9
        L_0x00a1:
            com.google.android.gms.internal.ads.zzzf r3 = r0.zzj
            int r1 = r3.zzd(r1, r2)
            return r1
        L_0x00a8:
            r3 = 0
        L_0x00a9:
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            byte[] r2 = r2.zzi()
            com.google.android.gms.internal.ads.zzakr r4 = r0.zzc
            int r4 = r4.zzg()
            int r4 = 9400 - r4
            r5 = 188(0xbc, float:2.63E-43)
            if (r4 < r5) goto L_0x00bc
            goto L_0x00d2
        L_0x00bc:
            com.google.android.gms.internal.ads.zzakr r4 = r0.zzc
            int r4 = r4.zzd()
            if (r4 <= 0) goto L_0x00cd
            com.google.android.gms.internal.ads.zzakr r6 = r0.zzc
            int r6 = r6.zzg()
            java.lang.System.arraycopy(r2, r6, r2, r3, r4)
        L_0x00cd:
            com.google.android.gms.internal.ads.zzakr r6 = r0.zzc
            r6.zzb(r2, r4)
        L_0x00d2:
            com.google.android.gms.internal.ads.zzakr r4 = r0.zzc
            int r4 = r4.zzd()
            r6 = -1
            if (r4 >= r5) goto L_0x00f1
            com.google.android.gms.internal.ads.zzakr r4 = r0.zzc
            int r4 = r4.zze()
            int r7 = 9400 - r4
            int r7 = r1.zza(r2, r4, r7)
            if (r7 != r6) goto L_0x00ea
            return r6
        L_0x00ea:
            com.google.android.gms.internal.ads.zzakr r6 = r0.zzc
            int r4 = r4 + r7
            r6.zzf(r4)
            goto L_0x00d2
        L_0x00f1:
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzc
            int r1 = r1.zzg()
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            int r2 = r2.zze()
            com.google.android.gms.internal.ads.zzakr r4 = r0.zzc
            byte[] r4 = r4.zzi()
            int r4 = com.google.android.gms.internal.ads.zzzq.zza(r4, r1, r2)
            com.google.android.gms.internal.ads.zzakr r5 = r0.zzc
            r5.zzh(r4)
            int r5 = r4 + 188
            if (r5 <= r2) goto L_0x0117
            int r2 = r0.zzp
            int r4 = r4 - r1
            int r4 = r4 + r2
            r0.zzp = r4
            goto L_0x0119
        L_0x0117:
            r0.zzp = r3
        L_0x0119:
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzc
            int r1 = r1.zze()
            if (r5 <= r1) goto L_0x0122
            return r3
        L_0x0122:
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            int r2 = r2.zzv()
            r4 = 8388608(0x800000, float:1.17549435E-38)
            r4 = r4 & r2
            if (r4 == 0) goto L_0x0133
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzc
            r1.zzh(r5)
            return r3
        L_0x0133:
            r4 = 4194304(0x400000, float:5.877472E-39)
            r4 = r4 & r2
            if (r4 == 0) goto L_0x013a
            r10 = 1
            goto L_0x013b
        L_0x013a:
            r10 = 0
        L_0x013b:
            int r4 = r2 >> 8
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = r2 & 32
            r8 = r2 & 16
            if (r8 == 0) goto L_0x014e
            android.util.SparseArray<com.google.android.gms.internal.ads.zzzp> r8 = r0.zzf
            java.lang.Object r8 = r8.get(r4)
            com.google.android.gms.internal.ads.zzzp r8 = (com.google.android.gms.internal.ads.zzzp) r8
            goto L_0x014f
        L_0x014e:
            r8 = 0
        L_0x014f:
            if (r8 != 0) goto L_0x0157
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzc
            r1.zzh(r5)
            return r3
        L_0x0157:
            r2 = r2 & 15
            android.util.SparseIntArray r9 = r0.zzd
            int r13 = r2 + -1
            int r9 = r9.get(r4, r13)
            android.util.SparseIntArray r13 = r0.zzd
            r13.put(r4, r2)
            if (r9 != r2) goto L_0x016e
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzc
            r1.zzh(r5)
            return r3
        L_0x016e:
            r13 = 1
            int r9 = r9 + r13
            r9 = r9 & 15
            if (r2 == r9) goto L_0x0177
            r8.zzb()
        L_0x0177:
            if (r7 == 0) goto L_0x0193
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            int r2 = r2.zzn()
            com.google.android.gms.internal.ads.zzakr r7 = r0.zzc
            int r7 = r7.zzn()
            r7 = r7 & 64
            if (r7 == 0) goto L_0x018b
            r7 = 2
            goto L_0x018c
        L_0x018b:
            r7 = 0
        L_0x018c:
            r10 = r10 | r7
            com.google.android.gms.internal.ads.zzakr r7 = r0.zzc
            int r2 = r2 + r6
            r7.zzk(r2)
        L_0x0193:
            boolean r2 = r0.zzm
            if (r2 != 0) goto L_0x019f
            android.util.SparseBooleanArray r6 = r0.zzh
            boolean r4 = r6.get(r4, r3)
            if (r4 != 0) goto L_0x01b0
        L_0x019f:
            com.google.android.gms.internal.ads.zzakr r4 = r0.zzc
            r4.zzf(r5)
            com.google.android.gms.internal.ads.zzakr r4 = r0.zzc
            r8.zzc(r4, r10)
            com.google.android.gms.internal.ads.zzakr r4 = r0.zzc
            r4.zzf(r1)
            if (r2 != 0) goto L_0x01bd
        L_0x01b0:
            boolean r1 = r0.zzm
            if (r1 == 0) goto L_0x01bd
            r1 = -1
            int r4 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x01bd
            r1 = 1
            r0.zzo = r1
        L_0x01bd:
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzc
            r1.zzh(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzk.zzf(com.google.android.gms.internal.ads.zztb, com.google.android.gms.internal.ads.zzts):int");
    }

    public final void zzg(long j, long j2) {
        zzzf zzzf;
        int size = this.zzb.size();
        for (int i = 0; i < size; i++) {
            zzale zzale = this.zzb.get(i);
            if (zzale.zzc() == -9223372036854775807L || !(zzale.zzc() == 0 || zzale.zza() == j2)) {
                zzale.zzd(j2);
            }
        }
        if (!(j2 == 0 || (zzzf = this.zzj) == null)) {
            zzzf.zzb(j2);
        }
        this.zzc.zza(0);
        this.zzd.clear();
        for (int i2 = 0; i2 < this.zzf.size(); i2++) {
            this.zzf.valueAt(i2).zzb();
        }
        this.zzp = 0;
    }

    public zzzk(int i) {
        this(1, 0, 112800);
    }

    public zzzk(int i, int i2, int i3) {
        zzale zzale = new zzale(0);
        this.zze = new zzxz(0);
        this.zzb = Collections.singletonList(zzale);
        this.zzc = new zzakr(new byte[9400], 0);
        this.zzg = new SparseBooleanArray();
        this.zzh = new SparseBooleanArray();
        this.zzf = new SparseArray<>();
        this.zzd = new SparseIntArray();
        this.zzi = new zzzg(112800);
        this.zzq = -1;
        this.zzg.clear();
        this.zzf.clear();
        SparseArray sparseArray = new SparseArray();
        int size = sparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzf.put(sparseArray.keyAt(i4), (zzzp) sparseArray.valueAt(i4));
        }
        this.zzf.put(0, new zzzc(new zzzi(this)));
    }
}
