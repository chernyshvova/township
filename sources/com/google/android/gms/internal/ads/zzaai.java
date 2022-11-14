package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaai extends Exception {
    public final String zza;
    public final boolean zzb;
    @Nullable
    public final zzaah zzc;
    @Nullable
    public final String zzd;
    @Nullable
    public final zzaai zze;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaai(com.google.android.gms.internal.ads.zzkc r11, @androidx.annotation.Nullable java.lang.Throwable r12, boolean r13, int r14) {
        /*
            r10 = this;
            java.lang.String r13 = java.lang.String.valueOf(r11)
            int r0 = r13.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 36
            r1.<init>(r0)
            java.lang.String r0 = "Decoder init failed: ["
            r1.append(r0)
            r1.append(r14)
            java.lang.String r0 = "], "
            r1.append(r0)
            r1.append(r13)
            java.lang.String r3 = r1.toString()
            java.lang.String r5 = r11.zzl
            int r11 = java.lang.Math.abs(r14)
            r13 = 75
            java.lang.String r14 = "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_neg_"
            java.lang.String r8 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r13, r14, r11)
            r6 = 0
            r7 = 0
            r9 = 0
            r2 = r10
            r4 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaai.<init>(com.google.android.gms.internal.ads.zzkc, java.lang.Throwable, boolean, int):void");
    }

    public static /* synthetic */ zzaai zza(zzaai zzaai, zzaai zzaai2) {
        return new zzaai(zzaai.getMessage(), zzaai.getCause(), zzaai.zza, false, zzaai.zzc, zzaai.zzd, zzaai2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaai(com.google.android.gms.internal.ads.zzkc r9, @androidx.annotation.Nullable java.lang.Throwable r10, boolean r11, com.google.android.gms.internal.ads.zzaah r12) {
        /*
            r8 = this;
            java.lang.String r0 = r12.zza
            java.lang.String r1 = java.lang.String.valueOf(r9)
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r4 = r1.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r3 = r3 + 23
            int r3 = r3 + r4
            r6.<init>(r3)
            java.lang.String r3 = "Decoder init failed: "
            java.lang.String r4 = ", "
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline20(r6, r3, r0, r4, r1)
            java.lang.String r3 = r9.zzl
            int r0 = com.google.android.gms.internal.ads.zzalh.zza
            r4 = 0
            r6 = 21
            if (r0 < r6) goto L_0x0038
            boolean r0 = r10 instanceof android.media.MediaCodec.CodecException
            if (r0 == 0) goto L_0x0038
            r0 = r10
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            java.lang.String r0 = r0.getDiagnosticInfo()
            r6 = r0
            goto L_0x0039
        L_0x0038:
            r6 = r4
        L_0x0039:
            r4 = 0
            r7 = 0
            r0 = r8
            r2 = r10
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaai.<init>(com.google.android.gms.internal.ads.zzkc, java.lang.Throwable, boolean, com.google.android.gms.internal.ads.zzaah):void");
    }

    public zzaai(String str, @Nullable Throwable th, String str2, boolean z, @Nullable zzaah zzaah, @Nullable String str3, @Nullable zzaai zzaai) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzaah;
        this.zzd = str3;
        this.zze = zzaai;
    }
}
