package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.playrix.gplay.billing.Base64;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzza implements zzta {
    public static final zztg zza = zzyy.zza;
    public final zzale zzb = new zzale(0);
    public final SparseArray<zzyz> zzc = new SparseArray<>();
    public final zzakr zzd = new zzakr(4096);
    public final zzyx zze = new zzyx();
    public boolean zzf;
    public boolean zzg;
    public boolean zzh;
    public long zzi;
    @Nullable
    public zzyw zzj;
    public zztd zzk;
    public boolean zzl;

    public final boolean zzd(zztb zztb) throws IOException {
        byte[] bArr = new byte[14];
        zzsx zzsx = (zzsx) zztb;
        zzsx.zzh(bArr, 0, 14, false);
        if ((((bArr[0] & Base64.EQUALS_SIGN_ENC) << 24) | ((bArr[1] & Base64.EQUALS_SIGN_ENC) << 16) | ((bArr[2] & Base64.EQUALS_SIGN_ENC) << 8) | (bArr[3] & Base64.EQUALS_SIGN_ENC)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzsx.zzj(bArr[13] & 7, false);
        zzsx.zzh(bArr, 0, 3, false);
        return ((((bArr[0] & Base64.EQUALS_SIGN_ENC) << 16) | ((bArr[1] & Base64.EQUALS_SIGN_ENC) << 8)) | (bArr[2] & Base64.EQUALS_SIGN_ENC)) == 1;
    }

    public final void zze(zztd zztd) {
        this.zzk = zztd;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzf(com.google.android.gms.internal.ads.zztb r13, com.google.android.gms.internal.ads.zzts r14) throws java.io.IOException {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zztd r0 = r12.zzk
            com.google.android.gms.internal.ads.zzajg.zze(r0)
            long r7 = r13.zzo()
            r9 = -1
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzyx r0 = r12.zze
            boolean r0 = r0.zza()
            if (r0 == 0) goto L_0x0018
            goto L_0x001f
        L_0x0018:
            com.google.android.gms.internal.ads.zzyx r0 = r12.zze
            int r13 = r0.zzc(r13, r14)
            return r13
        L_0x001f:
            boolean r0 = r12.zzl
            r11 = 1
            if (r0 != 0) goto L_0x0066
            r12.zzl = r11
            com.google.android.gms.internal.ads.zzyx r0 = r12.zze
            long r0 = r0.zzd()
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0054
            com.google.android.gms.internal.ads.zzyw r0 = new com.google.android.gms.internal.ads.zzyw
            com.google.android.gms.internal.ads.zzyx r1 = r12.zze
            com.google.android.gms.internal.ads.zzale r2 = r1.zzb()
            com.google.android.gms.internal.ads.zzyx r1 = r12.zze
            long r3 = r1.zzd()
            r1 = r0
            r5 = r7
            r1.<init>(r2, r3, r5)
            r12.zzj = r0
            com.google.android.gms.internal.ads.zztd r1 = r12.zzk
            com.google.android.gms.internal.ads.zztv r0 = r0.zza()
            r1.zzbm(r0)
            goto L_0x0066
        L_0x0054:
            com.google.android.gms.internal.ads.zztd r0 = r12.zzk
            com.google.android.gms.internal.ads.zztu r1 = new com.google.android.gms.internal.ads.zztu
            com.google.android.gms.internal.ads.zzyx r2 = r12.zze
            long r2 = r2.zzd()
            r4 = 0
            r1.<init>(r2, r4)
            r0.zzbm(r1)
        L_0x0066:
            com.google.android.gms.internal.ads.zzyw r0 = r12.zzj
            if (r0 == 0) goto L_0x0078
            boolean r0 = r0.zzc()
            if (r0 != 0) goto L_0x0071
            goto L_0x0078
        L_0x0071:
            com.google.android.gms.internal.ads.zzyw r0 = r12.zzj
            int r13 = r0.zzd(r13, r14)
            return r13
        L_0x0078:
            r13.zzl()
            int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r14 == 0) goto L_0x0085
            long r0 = r13.zzm()
            long r7 = r7 - r0
            goto L_0x0086
        L_0x0085:
            r7 = r9
        L_0x0086:
            r14 = -1
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0093
            r0 = 4
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            return r14
        L_0x0093:
            com.google.android.gms.internal.ads.zzakr r0 = r12.zzd
            byte[] r0 = r0.zzi()
            r1 = 4
            r2 = 0
            boolean r0 = r13.zzh(r0, r2, r1, r11)
            if (r0 != 0) goto L_0x00a2
            return r14
        L_0x00a2:
            com.google.android.gms.internal.ads.zzakr r0 = r12.zzd
            r0.zzh(r2)
            com.google.android.gms.internal.ads.zzakr r0 = r12.zzd
            int r0 = r0.zzv()
            r1 = 441(0x1b9, float:6.18E-43)
            if (r0 != r1) goto L_0x00b2
            return r14
        L_0x00b2:
            r14 = 442(0x1ba, float:6.2E-43)
            if (r0 != r14) goto L_0x00d8
            com.google.android.gms.internal.ads.zzakr r14 = r12.zzd
            byte[] r14 = r14.zzi()
            com.google.android.gms.internal.ads.zzsx r13 = (com.google.android.gms.internal.ads.zzsx) r13
            r0 = 10
            r13.zzh(r14, r2, r0, r2)
            com.google.android.gms.internal.ads.zzakr r14 = r12.zzd
            r0 = 9
            r14.zzh(r0)
            com.google.android.gms.internal.ads.zzakr r14 = r12.zzd
            int r14 = r14.zzn()
            r14 = r14 & 7
            int r14 = r14 + 14
            r13.zze(r14, r2)
            return r2
        L_0x00d8:
            r14 = 443(0x1bb, float:6.21E-43)
            r1 = 2
            r3 = 6
            if (r0 != r14) goto L_0x00f9
            com.google.android.gms.internal.ads.zzakr r14 = r12.zzd
            byte[] r14 = r14.zzi()
            com.google.android.gms.internal.ads.zzsx r13 = (com.google.android.gms.internal.ads.zzsx) r13
            r13.zzh(r14, r2, r1, r2)
            com.google.android.gms.internal.ads.zzakr r14 = r12.zzd
            r14.zzh(r2)
            com.google.android.gms.internal.ads.zzakr r14 = r12.zzd
            int r14 = r14.zzo()
            int r14 = r14 + r3
            r13.zze(r14, r2)
            return r2
        L_0x00f9:
            int r14 = r0 >> 8
            if (r14 == r11) goto L_0x0103
            com.google.android.gms.internal.ads.zzsx r13 = (com.google.android.gms.internal.ads.zzsx) r13
            r13.zze(r11, r2)
            return r2
        L_0x0103:
            r14 = r0 & 255(0xff, float:3.57E-43)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzyz> r0 = r12.zzc
            java.lang.Object r0 = r0.get(r14)
            com.google.android.gms.internal.ads.zzyz r0 = (com.google.android.gms.internal.ads.zzyz) r0
            boolean r4 = r12.zzf
            if (r4 != 0) goto L_0x018a
            if (r0 != 0) goto L_0x016b
            r4 = 189(0xbd, float:2.65E-43)
            r5 = 0
            if (r14 != r4) goto L_0x0127
            com.google.android.gms.internal.ads.zzxs r4 = new com.google.android.gms.internal.ads.zzxs
            r4.<init>(r5)
            r12.zzg = r11
            long r5 = r13.zzn()
            r12.zzi = r5
        L_0x0125:
            r5 = r4
            goto L_0x014f
        L_0x0127:
            r4 = r14 & 224(0xe0, float:3.14E-43)
            r6 = 192(0xc0, float:2.69E-43)
            if (r4 != r6) goto L_0x013b
            com.google.android.gms.internal.ads.zzyq r4 = new com.google.android.gms.internal.ads.zzyq
            r4.<init>(r5)
            r12.zzg = r11
            long r5 = r13.zzn()
            r12.zzi = r5
            goto L_0x0125
        L_0x013b:
            r4 = r14 & 240(0xf0, float:3.36E-43)
            r6 = 224(0xe0, float:3.14E-43)
            if (r4 != r6) goto L_0x014f
            com.google.android.gms.internal.ads.zzye r4 = new com.google.android.gms.internal.ads.zzye
            r4.<init>(r5)
            r12.zzh = r11
            long r5 = r13.zzn()
            r12.zzi = r5
            goto L_0x0125
        L_0x014f:
            if (r5 == 0) goto L_0x016b
            com.google.android.gms.internal.ads.zzzo r0 = new com.google.android.gms.internal.ads.zzzo
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 256(0x100, float:3.59E-43)
            r0.<init>(r4, r14, r6)
            com.google.android.gms.internal.ads.zztd r4 = r12.zzk
            r5.zzb(r4, r0)
            com.google.android.gms.internal.ads.zzyz r0 = new com.google.android.gms.internal.ads.zzyz
            com.google.android.gms.internal.ads.zzale r4 = r12.zzb
            r0.<init>(r5, r4)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzyz> r4 = r12.zzc
            r4.put(r14, r0)
        L_0x016b:
            boolean r14 = r12.zzg
            r4 = 1048576(0x100000, double:5.180654E-318)
            if (r14 == 0) goto L_0x017b
            boolean r14 = r12.zzh
            if (r14 == 0) goto L_0x017b
            long r4 = r12.zzi
            r6 = 8192(0x2000, double:4.0474E-320)
            long r4 = r4 + r6
        L_0x017b:
            long r6 = r13.zzn()
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x018a
            r12.zzf = r11
            com.google.android.gms.internal.ads.zztd r14 = r12.zzk
            r14.zzbl()
        L_0x018a:
            com.google.android.gms.internal.ads.zzakr r14 = r12.zzd
            byte[] r14 = r14.zzi()
            com.google.android.gms.internal.ads.zzsx r13 = (com.google.android.gms.internal.ads.zzsx) r13
            r13.zzh(r14, r2, r1, r2)
            com.google.android.gms.internal.ads.zzakr r14 = r12.zzd
            r14.zzh(r2)
            com.google.android.gms.internal.ads.zzakr r14 = r12.zzd
            int r14 = r14.zzo()
            int r14 = r14 + r3
            if (r0 != 0) goto L_0x01a7
            r13.zze(r14, r2)
            goto L_0x01c8
        L_0x01a7:
            com.google.android.gms.internal.ads.zzakr r1 = r12.zzd
            r1.zza(r14)
            com.google.android.gms.internal.ads.zzakr r1 = r12.zzd
            byte[] r1 = r1.zzi()
            r13.zzb(r1, r2, r14, r2)
            com.google.android.gms.internal.ads.zzakr r13 = r12.zzd
            r13.zzh(r3)
            com.google.android.gms.internal.ads.zzakr r13 = r12.zzd
            r0.zzb(r13)
            com.google.android.gms.internal.ads.zzakr r13 = r12.zzd
            int r14 = r13.zzj()
            r13.zzf(r14)
        L_0x01c8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzza.zzf(com.google.android.gms.internal.ads.zztb, com.google.android.gms.internal.ads.zzts):int");
    }

    public final void zzg(long j, long j2) {
        if (this.zzb.zzc() == -9223372036854775807L || !(this.zzb.zza() == 0 || this.zzb.zza() == j2)) {
            this.zzb.zzd(j2);
        }
        zzyw zzyw = this.zzj;
        if (zzyw != null) {
            zzyw.zzb(j2);
        }
        for (int i = 0; i < this.zzc.size(); i++) {
            this.zzc.valueAt(i).zza();
        }
    }
}
