package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzug implements zzta {
    public static final zztg zza = zzuf.zza;
    public static final int[] zzb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final int[] zzc = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    public static final byte[] zzd = zzalh.zzs("#!AMR\n");
    public static final byte[] zze = zzalh.zzs("#!AMR-WB\n");
    public static final int zzf = zzc[8];
    public final byte[] zzg;
    public boolean zzh;
    public long zzi;
    public int zzj;
    public int zzk;
    public boolean zzl;
    public int zzm;
    public int zzn;
    public zztd zzo;
    public zztz zzp;
    public zztv zzq;
    public boolean zzr;

    public zzug() {
        this(0);
    }

    public zzug(int i) {
        this.zzg = new byte[1];
        this.zzm = -1;
    }

    private final boolean zza(zztb zztb) throws IOException {
        if (zzb(zztb, zzd)) {
            this.zzh = false;
            ((zzsx) zztb).zze(zzd.length, false);
            return true;
        } else if (!zzb(zztb, zze)) {
            return false;
        } else {
            this.zzh = true;
            ((zzsx) zztb).zze(zze.length, false);
            return true;
        }
    }

    public static boolean zzb(zztb zztb, byte[] bArr) throws IOException {
        zztb.zzl();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzsx) zztb).zzh(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[Catch:{ EOFException -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[Catch:{ EOFException -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzc(com.google.android.gms.internal.ads.zztb r12) throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.zzk
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x009b
            r12.zzl()     // Catch:{ EOFException -> 0x009a }
            byte[] r0 = r11.zzg     // Catch:{ EOFException -> 0x009a }
            r4 = r12
            com.google.android.gms.internal.ads.zzsx r4 = (com.google.android.gms.internal.ads.zzsx) r4     // Catch:{ EOFException -> 0x009a }
            r4.zzh(r0, r3, r2, r3)     // Catch:{ EOFException -> 0x009a }
            byte[] r0 = r11.zzg     // Catch:{ EOFException -> 0x009a }
            byte r0 = r0[r3]     // Catch:{ EOFException -> 0x009a }
            r4 = r0 & 131(0x83, float:1.84E-43)
            r5 = 0
            if (r4 > 0) goto L_0x0081
            int r0 = r0 >> 3
            r0 = r0 & 15
            boolean r4 = r11.zzh     // Catch:{ EOFException -> 0x009a }
            if (r4 == 0) goto L_0x002c
            r6 = 10
            if (r0 < r6) goto L_0x0037
            r6 = 13
            if (r0 <= r6) goto L_0x002c
            goto L_0x0037
        L_0x002c:
            if (r4 != 0) goto L_0x0055
            r6 = 12
            if (r0 < r6) goto L_0x0037
            r6 = 14
            if (r0 > r6) goto L_0x0037
            goto L_0x0055
        L_0x0037:
            if (r4 == 0) goto L_0x003e
            int[] r4 = zzc     // Catch:{ EOFException -> 0x009a }
            r0 = r4[r0]     // Catch:{ EOFException -> 0x009a }
            goto L_0x0042
        L_0x003e:
            int[] r4 = zzb     // Catch:{ EOFException -> 0x009a }
            r0 = r4[r0]     // Catch:{ EOFException -> 0x009a }
        L_0x0042:
            r11.zzj = r0     // Catch:{ EOFException -> 0x009a }
            r11.zzk = r0
            int r4 = r11.zzm
            if (r4 != r1) goto L_0x004d
            r11.zzm = r0
            r4 = r0
        L_0x004d:
            if (r4 != r0) goto L_0x009b
            int r4 = r11.zzn
            int r4 = r4 + r2
            r11.zzn = r4
            goto L_0x009b
        L_0x0055:
            com.google.android.gms.internal.ads.zzlg r12 = new com.google.android.gms.internal.ads.zzlg     // Catch:{ EOFException -> 0x009a }
            java.lang.String r3 = "WB"
            java.lang.String r6 = "NB"
            if (r2 == r4) goto L_0x005e
            r3 = r6
        L_0x005e:
            int r2 = r3.length()     // Catch:{ EOFException -> 0x009a }
            int r2 = r2 + 35
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x009a }
            r4.<init>(r2)     // Catch:{ EOFException -> 0x009a }
            java.lang.String r2 = "Illegal AMR "
            r4.append(r2)     // Catch:{ EOFException -> 0x009a }
            r4.append(r3)     // Catch:{ EOFException -> 0x009a }
            java.lang.String r2 = " frame type "
            r4.append(r2)     // Catch:{ EOFException -> 0x009a }
            r4.append(r0)     // Catch:{ EOFException -> 0x009a }
            java.lang.String r0 = r4.toString()     // Catch:{ EOFException -> 0x009a }
            r12.<init>(r0, r5)     // Catch:{ EOFException -> 0x009a }
            throw r12     // Catch:{ EOFException -> 0x009a }
        L_0x0081:
            com.google.android.gms.internal.ads.zzlg r12 = new com.google.android.gms.internal.ads.zzlg     // Catch:{ EOFException -> 0x009a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x009a }
            r3 = 42
            r2.<init>(r3)     // Catch:{ EOFException -> 0x009a }
            java.lang.String r3 = "Invalid padding bits for frame header "
            r2.append(r3)     // Catch:{ EOFException -> 0x009a }
            r2.append(r0)     // Catch:{ EOFException -> 0x009a }
            java.lang.String r0 = r2.toString()     // Catch:{ EOFException -> 0x009a }
            r12.<init>(r0, r5)     // Catch:{ EOFException -> 0x009a }
            throw r12     // Catch:{ EOFException -> 0x009a }
        L_0x009a:
            return r1
        L_0x009b:
            com.google.android.gms.internal.ads.zztz r4 = r11.zzp
            int r12 = com.google.android.gms.internal.ads.zztx.zza(r4, r12, r0, r2)
            if (r12 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            int r0 = r11.zzk
            int r0 = r0 - r12
            r11.zzk = r0
            if (r0 <= 0) goto L_0x00ac
            return r3
        L_0x00ac:
            com.google.android.gms.internal.ads.zztz r4 = r11.zzp
            long r5 = r11.zzi
            r7 = 1
            int r8 = r11.zzj
            r9 = 0
            r10 = 0
            r4.zzd(r5, r7, r8, r9, r10)
            long r0 = r11.zzi
            r4 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r4
            r11.zzi = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzug.zzc(com.google.android.gms.internal.ads.zztb):int");
    }

    public final boolean zzd(zztb zztb) throws IOException {
        return zza(zztb);
    }

    public final void zze(zztd zztd) {
        this.zzo = zztd;
        this.zzp = zztd.zza(0, 1);
        zztd.zzbl();
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        zzajg.zze(this.zzp);
        int i = zzalh.zza;
        if (zztb.zzn() != 0 || zza(zztb)) {
            if (!this.zzr) {
                this.zzr = true;
                boolean z = this.zzh;
                String str = true != z ? "audio/3gpp" : "audio/amr-wb";
                int i2 = true != z ? 8000 : 16000;
                zztz zztz = this.zzp;
                zzkb zzkb = new zzkb();
                zzkb.zzj(str);
                zzkb.zzk(zzf);
                zzkb.zzw(1);
                zzkb.zzx(i2);
                zztz.zza(zzkb.zzD());
            }
            int zzc2 = zzc(zztb);
            if (!this.zzl) {
                zztu zztu = new zztu(-9223372036854775807L, 0);
                this.zzq = zztu;
                this.zzo.zzbm(zztu);
                this.zzl = true;
            }
            return zzc2;
        }
        throw new zzlg("Could not find AMR header.", (Throwable) null);
    }

    public final void zzg(long j, long j2) {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 0;
    }
}
