package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.io.IOException;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvd {
    public final byte[] zza = new byte[8];
    public final ArrayDeque<zzvc> zzb = new ArrayDeque<>();
    public final zzvm zzc = new zzvm();
    public zzve zzd;
    public int zze;
    public int zzf;
    public long zzg;

    private final long zzd(zztb zztb, int i) throws IOException {
        ((zzsx) zztb).zzb(this.zza, 0, i, false);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zza[i2] & Base64.EQUALS_SIGN_ENC));
        }
        return j;
    }

    public final void zza(zzve zzve) {
        this.zzd = zzve;
    }

    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        if (r0 == 1) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zztb r13) throws java.io.IOException {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzve r0 = r12.zzd
            com.google.android.gms.internal.ads.zzajg.zze(r0)
        L_0x0005:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvc> r0 = r12.zzb
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzvc r0 = (com.google.android.gms.internal.ads.zzvc) r0
            r1 = 1
            if (r0 == 0) goto L_0x0033
            long r2 = r13.zzn()
            long r4 = r0.zzb
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x001d
            goto L_0x0033
        L_0x001d:
            com.google.android.gms.internal.ads.zzve r13 = r12.zzd
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvc> r0 = r12.zzb
            java.lang.Object r0 = r0.pop()
            com.google.android.gms.internal.ads.zzvc r0 = (com.google.android.gms.internal.ads.zzvc) r0
            int r0 = r0.zza
            com.google.android.gms.internal.ads.zzvh r13 = (com.google.android.gms.internal.ads.zzvh) r13
            com.google.android.gms.internal.ads.zzvk r13 = r13.zza
            r13.zzb(r0)
            return r1
        L_0x0033:
            int r0 = r12.zze
            r2 = 2
            r3 = 4
            r4 = 0
            if (r0 != 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzvm r0 = r12.zzc
            long r5 = r0.zzb(r13, r1, r4, r3)
            r7 = -2
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x007a
            r13.zzl()
        L_0x0049:
            byte[] r0 = r12.zza
            r5 = r13
            com.google.android.gms.internal.ads.zzsx r5 = (com.google.android.gms.internal.ads.zzsx) r5
            r5.zzh(r0, r4, r3, r4)
            byte[] r0 = r12.zza
            byte r0 = r0[r4]
            int r0 = com.google.android.gms.internal.ads.zzvm.zzd(r0)
            r6 = -1
            if (r0 == r6) goto L_0x0076
            if (r0 > r3) goto L_0x0076
            byte[] r6 = r12.zza
            long r6 = com.google.android.gms.internal.ads.zzvm.zze(r6, r0, r4)
            int r7 = (int) r6
            com.google.android.gms.internal.ads.zzve r6 = r12.zzd
            com.google.android.gms.internal.ads.zzvh r6 = (com.google.android.gms.internal.ads.zzvh) r6
            com.google.android.gms.internal.ads.zzvk r6 = r6.zza
            boolean r6 = com.google.android.gms.internal.ads.zzvk.zzo(r7)
            if (r6 == 0) goto L_0x0076
            r5.zze(r0, r4)
            long r5 = (long) r7
            goto L_0x007a
        L_0x0076:
            r5.zze(r1, r4)
            goto L_0x0049
        L_0x007a:
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0081
            return r4
        L_0x0081:
            int r0 = (int) r5
            r12.zzf = r0
            r12.zze = r1
            goto L_0x0089
        L_0x0087:
            if (r0 != r1) goto L_0x0095
        L_0x0089:
            com.google.android.gms.internal.ads.zzvm r0 = r12.zzc
            r5 = 8
            long r5 = r0.zzb(r13, r4, r1, r5)
            r12.zzg = r5
            r12.zze = r2
        L_0x0095:
            com.google.android.gms.internal.ads.zzve r0 = r12.zzd
            int r5 = r12.zzf
            com.google.android.gms.internal.ads.zzvh r0 = (com.google.android.gms.internal.ads.zzvh) r0
            com.google.android.gms.internal.ads.zzvk r0 = r0.zza
            int r0 = com.google.android.gms.internal.ads.zzvk.zzn(r5)
            if (r0 == 0) goto L_0x01a7
            r5 = 0
            if (r0 == r1) goto L_0x0184
            r6 = 8
            if (r0 == r2) goto L_0x0152
            r2 = 3
            if (r0 == r2) goto L_0x0106
            if (r0 == r3) goto L_0x00f5
            long r8 = r12.zzg
            r10 = 4
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00d5
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x00bc
            goto L_0x00d5
        L_0x00bc:
            com.google.android.gms.internal.ads.zzlg r13 = new com.google.android.gms.internal.ads.zzlg
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 40
            r0.<init>(r1)
            java.lang.String r1 = "Invalid float size: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0, r5)
            throw r13
        L_0x00d5:
            com.google.android.gms.internal.ads.zzve r0 = r12.zzd
            int r2 = r12.zzf
            int r5 = (int) r8
            long r6 = r12.zzd(r13, r5)
            if (r5 != r3) goto L_0x00e7
            int r13 = (int) r6
            float r13 = java.lang.Float.intBitsToFloat(r13)
            double r5 = (double) r13
            goto L_0x00eb
        L_0x00e7:
            double r5 = java.lang.Double.longBitsToDouble(r6)
        L_0x00eb:
            com.google.android.gms.internal.ads.zzvh r0 = (com.google.android.gms.internal.ads.zzvh) r0
            com.google.android.gms.internal.ads.zzvk r13 = r0.zza
            r13.zzh(r2, r5)
            r12.zze = r4
            return r1
        L_0x00f5:
            com.google.android.gms.internal.ads.zzve r0 = r12.zzd
            int r2 = r12.zzf
            long r5 = r12.zzg
            com.google.android.gms.internal.ads.zzvh r0 = (com.google.android.gms.internal.ads.zzvh) r0
            com.google.android.gms.internal.ads.zzvk r0 = r0.zza
            int r3 = (int) r5
            r0.zzj(r2, r3, r13)
            r12.zze = r4
            return r1
        L_0x0106:
            long r2 = r12.zzg
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x0139
            com.google.android.gms.internal.ads.zzve r0 = r12.zzd
            int r5 = r12.zzf
            int r3 = (int) r2
            if (r3 != 0) goto L_0x0119
            java.lang.String r13 = ""
            goto L_0x012f
        L_0x0119:
            byte[] r2 = new byte[r3]
            com.google.android.gms.internal.ads.zzsx r13 = (com.google.android.gms.internal.ads.zzsx) r13
            r13.zzb(r2, r4, r3, r4)
        L_0x0120:
            if (r3 <= 0) goto L_0x012a
            int r13 = r3 + -1
            byte r6 = r2[r13]
            if (r6 != 0) goto L_0x012a
            r3 = r13
            goto L_0x0120
        L_0x012a:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r2, r4, r3)
        L_0x012f:
            com.google.android.gms.internal.ads.zzvh r0 = (com.google.android.gms.internal.ads.zzvh) r0
            com.google.android.gms.internal.ads.zzvk r0 = r0.zza
            r0.zzi(r5, r13)
            r12.zze = r4
            return r1
        L_0x0139:
            com.google.android.gms.internal.ads.zzlg r13 = new com.google.android.gms.internal.ads.zzlg
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 41
            r0.<init>(r1)
            java.lang.String r1 = "String element size: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0, r5)
            throw r13
        L_0x0152:
            long r2 = r12.zzg
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x016b
            com.google.android.gms.internal.ads.zzve r0 = r12.zzd
            int r5 = r12.zzf
            int r3 = (int) r2
            long r2 = r12.zzd(r13, r3)
            com.google.android.gms.internal.ads.zzvh r0 = (com.google.android.gms.internal.ads.zzvh) r0
            com.google.android.gms.internal.ads.zzvk r13 = r0.zza
            r13.zzc(r5, r2)
            r12.zze = r4
            return r1
        L_0x016b:
            com.google.android.gms.internal.ads.zzlg r13 = new com.google.android.gms.internal.ads.zzlg
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 42
            r0.<init>(r1)
            java.lang.String r1 = "Invalid integer size: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0, r5)
            throw r13
        L_0x0184:
            long r8 = r13.zzn()
            long r2 = r12.zzg
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvc> r13 = r12.zzb
            com.google.android.gms.internal.ads.zzvc r0 = new com.google.android.gms.internal.ads.zzvc
            int r6 = r12.zzf
            long r2 = r2 + r8
            r0.<init>(r6, r2, r5)
            r13.push(r0)
            com.google.android.gms.internal.ads.zzve r13 = r12.zzd
            int r7 = r12.zzf
            long r10 = r12.zzg
            com.google.android.gms.internal.ads.zzvh r13 = (com.google.android.gms.internal.ads.zzvh) r13
            com.google.android.gms.internal.ads.zzvk r6 = r13.zza
            r6.zza(r7, r8, r10)
            r12.zze = r4
            return r1
        L_0x01a7:
            long r0 = r12.zzg
            r2 = r13
            com.google.android.gms.internal.ads.zzsx r2 = (com.google.android.gms.internal.ads.zzsx) r2
            int r1 = (int) r0
            r2.zze(r1, r4)
            r12.zze = r4
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvd.zzc(com.google.android.gms.internal.ads.zztb):boolean");
    }
}
