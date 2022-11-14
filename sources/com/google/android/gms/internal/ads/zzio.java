package com.google.android.gms.internal.ads;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzio extends zzli {
    public static final zzif<zzio> zzh = zzin.zza;
    public final int zza;
    @Nullable
    public final String zzb;
    public final int zzc;
    @Nullable
    public final zzkc zzd;
    public final int zze;
    @Nullable
    public final zzadu zzf;
    public final boolean zzg;

    public zzio(int i, Throwable th, int i2) {
        this(i, th, (String) null, i2, (String) null, -1, (zzkc) null, 4, false);
    }

    public static zzio zza(IOException iOException, int i) {
        return new zzio(0, iOException, i);
    }

    public static zzio zzb(Exception exc) {
        return new zzio(1, exc, (String) null, 1000, (String) null, -1, (zzkc) null, 4, false);
    }

    public static zzio zzc(Throwable th, String str, int i, @Nullable zzkc zzkc, int i2, boolean z) {
        return new zzio(1, th, (String) null, 1000, str, i, zzkc, zzkc == null ? 4 : i2, z);
    }

    public static zzio zzd(RuntimeException runtimeException) {
        return new zzio(2, runtimeException, 1000);
    }

    @CheckResult
    public final zzio zze(@Nullable zzadu zzadu) {
        String message = getMessage();
        int i = zzalh.zza;
        return new zzio(message, getCause(), this.zzi, this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzadu, this.zzj, this.zzg);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzio(int r14, @androidx.annotation.Nullable java.lang.Throwable r15, @androidx.annotation.Nullable java.lang.String r16, int r17, @androidx.annotation.Nullable java.lang.String r18, int r19, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzkc r20, int r21, boolean r22) {
        /*
            r13 = this;
            r4 = r14
            if (r4 == 0) goto L_0x004b
            r0 = 1
            if (r4 == r0) goto L_0x000d
            java.lang.String r0 = "Unexpected runtime error"
            r5 = r18
            r7 = r19
            goto L_0x0051
        L_0x000d:
            java.lang.String r0 = java.lang.String.valueOf(r20)
            java.lang.String r1 = com.google.android.gms.internal.ads.zzig.zzd(r21)
            java.lang.String r2 = java.lang.String.valueOf(r18)
            int r2 = r2.length()
            int r3 = r0.length()
            int r5 = r1.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r7 = 53
            int r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline1(r2, r7, r3, r5)
            r6.<init>(r2)
            r5 = r18
            r6.append(r5)
            java.lang.String r2 = " error, index="
            r6.append(r2)
            r7 = r19
            r6.append(r7)
            java.lang.String r2 = ", format="
            r6.append(r2)
            java.lang.String r2 = ", format_supported="
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline19(r6, r0, r2, r1)
            goto L_0x0051
        L_0x004b:
            r5 = r18
            r7 = r19
            java.lang.String r0 = "Source error"
        L_0x0051:
            r1 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0074
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "null"
            int r2 = r2.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = r1 + 2
            int r1 = r1 + r2
            r3.<init>(r1)
            java.lang.String r1 = ": null"
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline18(r3, r0, r1)
        L_0x0074:
            r1 = r0
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r2 = r15
            r3 = r17
            r4 = r14
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r12 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzio.<init>(int, java.lang.Throwable, java.lang.String, int, java.lang.String, int, com.google.android.gms.internal.ads.zzkc, int, boolean):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzio(java.lang.String r9, @androidx.annotation.Nullable java.lang.Throwable r10, int r11, int r12, @androidx.annotation.Nullable java.lang.String r13, int r14, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzkc r15, int r16, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzadu r17, long r18, boolean r20) {
        /*
            r8 = this;
            r6 = r8
            r7 = r20
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r18
            r0.<init>(r1, r2, r3, r4)
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L_0x0017
            r2 = r12
            if (r2 != r1) goto L_0x0015
            r2 = 1
            goto L_0x0018
        L_0x0015:
            r3 = 0
            goto L_0x0019
        L_0x0017:
            r2 = r12
        L_0x0018:
            r3 = 1
        L_0x0019:
            com.google.android.gms.internal.ads.zzajg.zza(r3)
            if (r10 != 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            com.google.android.gms.internal.ads.zzajg.zza(r0)
            r6.zza = r2
            r0 = r13
            r6.zzb = r0
            r0 = r14
            r6.zzc = r0
            r0 = r15
            r6.zzd = r0
            r0 = r16
            r6.zze = r0
            r0 = r17
            r6.zzf = r0
            r6.zzg = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzio.<init>(java.lang.String, java.lang.Throwable, int, int, java.lang.String, int, com.google.android.gms.internal.ads.zzkc, int, com.google.android.gms.internal.ads.zzadu, long, boolean):void");
    }
}
