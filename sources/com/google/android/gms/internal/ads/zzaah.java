package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaah {
    public final String zza;
    public final String zzb;
    public final String zzc;
    @Nullable
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;

    @VisibleForTesting
    public zzaah(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (str != null) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = codecCapabilities;
            this.zze = z4;
            this.zzf = z6;
            this.zzg = zzakg.zzb(str2);
            return;
        }
        throw null;
    }

    public static zzaah zza(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        String str4 = str;
        MediaCodecInfo.CodecCapabilities codecCapabilities2 = codecCapabilities;
        return new zzaah(str, str2, str3, codecCapabilities, z, z2, z3, codecCapabilities2 != null && zzalh.zza >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback") && (zzalh.zza > 22 || ((!"ODROID-XU3".equals(zzalh.zzd) && !"Nexus 10".equals(zzalh.zzd)) || (!"OMX.Exynos.AVC.Decoder".equals(str) && !"OMX.Exynos.AVC.Decoder.secure".equals(str)))), codecCapabilities2 != null && zzalh.zza >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback"), z5 || (codecCapabilities2 != null && zzalh.zza >= 21 && codecCapabilities.isFeatureSupported("secure-playback")));
    }

    private final void zzh(String str) {
        String str2 = this.zza;
        String str3 = this.zzb;
        String str4 = zzalh.zze;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 20 + length2 + str3.length() + String.valueOf(str4).length());
        GeneratedOutlineSupport.outline34(sb, "NoSupport [", str, "] [", str2);
        GeneratedOutlineSupport.outline34(sb, RESTClient.COMMA_SEPARATOR, str3, "] [", str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @RequiresApi(21)
    public static boolean zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point zzj = zzj(videoCapabilities, i, i2);
        int i3 = zzj.x;
        int i4 = zzj.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    @RequiresApi(21)
    public static Point zzj(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzalh.zzw(i, widthAlignment) * widthAlignment, zzalh.zzw(i2, heightAlignment) * heightAlignment);
    }

    public final String toString() {
        return this.zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.profileLevels;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.media.MediaCodecInfo.CodecProfileLevel[] zzb() {
        /*
            r1 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.zzd
            if (r0 == 0) goto L_0x0008
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaah.zzb():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        r7 = r7.getVideoCapabilities();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzkc r13) throws com.google.android.gms.internal.ads.zzaas {
        /*
            r12 = this;
            java.lang.String r0 = r13.zzi
            r1 = 16
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0119
            java.lang.String r0 = com.google.android.gms.internal.ads.zzakg.zzd(r0)
            if (r0 != 0) goto L_0x0010
            goto L_0x0119
        L_0x0010:
            java.lang.String r4 = r12.zzb
            boolean r4 = r4.equals(r0)
            java.lang.String r5 = ", "
            if (r4 != 0) goto L_0x003b
            java.lang.String r13 = r13.zzi
            java.lang.String r1 = java.lang.String.valueOf(r13)
            int r1 = r1.length()
            int r3 = r0.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = r1 + 13
            int r1 = r1 + r3
            r4.<init>(r1)
            java.lang.String r1 = "codec.mime "
            java.lang.String r13 = com.android.tools.p006r8.GeneratedOutlineSupport.outline20(r4, r1, r13, r5, r0)
            r12.zzh(r13)
            goto L_0x0118
        L_0x003b:
            android.util.Pair r4 = com.google.android.gms.internal.ads.zzaax.zzf(r13)
            if (r4 == 0) goto L_0x0119
            java.lang.Object r6 = r4.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r4 = r4.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            boolean r7 = r12.zzg
            r8 = 42
            if (r7 != 0) goto L_0x005b
            if (r6 != r8) goto L_0x0119
            r6 = 42
        L_0x005b:
            android.media.MediaCodecInfo$CodecProfileLevel[] r7 = r12.zzb()
            int r8 = com.google.android.gms.internal.ads.zzalh.zza
            r9 = 23
            if (r8 > r9) goto L_0x00e8
            java.lang.String r8 = r12.zzb
            java.lang.String r9 = "video/x-vnd.on2.vp9"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x00e8
            int r8 = r7.length
            if (r8 != 0) goto L_0x00e8
            android.media.MediaCodecInfo$CodecCapabilities r7 = r12.zzd
            if (r7 == 0) goto L_0x008b
            android.media.MediaCodecInfo$VideoCapabilities r7 = r7.getVideoCapabilities()
            if (r7 == 0) goto L_0x008b
            android.util.Range r7 = r7.getBitrateRange()
            java.lang.Comparable r7 = r7.getUpper()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            goto L_0x008c
        L_0x008b:
            r7 = 0
        L_0x008c:
            r8 = 180000000(0xaba9500, float:1.7967196E-32)
            if (r7 < r8) goto L_0x0094
            r7 = 1024(0x400, float:1.435E-42)
            goto L_0x00db
        L_0x0094:
            r8 = 120000000(0x7270e00, float:1.2567798E-34)
            if (r7 < r8) goto L_0x009c
            r7 = 512(0x200, float:7.175E-43)
            goto L_0x00db
        L_0x009c:
            r8 = 60000000(0x3938700, float:8.670878E-37)
            if (r7 < r8) goto L_0x00a4
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x00db
        L_0x00a4:
            r8 = 30000000(0x1c9c380, float:7.411627E-38)
            if (r7 < r8) goto L_0x00ac
            r7 = 128(0x80, float:1.794E-43)
            goto L_0x00db
        L_0x00ac:
            r8 = 18000000(0x112a880, float:2.6936858E-38)
            if (r7 < r8) goto L_0x00b4
            r7 = 64
            goto L_0x00db
        L_0x00b4:
            r8 = 12000000(0xb71b00, float:1.6815582E-38)
            if (r7 < r8) goto L_0x00bc
            r7 = 32
            goto L_0x00db
        L_0x00bc:
            r8 = 7200000(0x6ddd00, float:1.0089349E-38)
            if (r7 < r8) goto L_0x00c4
            r7 = 16
            goto L_0x00db
        L_0x00c4:
            r8 = 3600000(0x36ee80, float:5.044674E-39)
            if (r7 < r8) goto L_0x00cc
            r7 = 8
            goto L_0x00db
        L_0x00cc:
            r8 = 1800000(0x1b7740, float:2.522337E-39)
            if (r7 < r8) goto L_0x00d3
            r7 = 4
            goto L_0x00db
        L_0x00d3:
            r8 = 800000(0xc3500, float:1.121039E-39)
            if (r7 < r8) goto L_0x00da
            r7 = 2
            goto L_0x00db
        L_0x00da:
            r7 = 1
        L_0x00db:
            android.media.MediaCodecInfo$CodecProfileLevel r8 = new android.media.MediaCodecInfo$CodecProfileLevel
            r8.<init>()
            r8.profile = r3
            r8.level = r7
            android.media.MediaCodecInfo$CodecProfileLevel[] r7 = new android.media.MediaCodecInfo.CodecProfileLevel[r3]
            r7[r2] = r8
        L_0x00e8:
            int r8 = r7.length
            r9 = 0
        L_0x00ea:
            if (r9 >= r8) goto L_0x00f9
            r10 = r7[r9]
            int r11 = r10.profile
            if (r11 != r6) goto L_0x00f6
            int r10 = r10.level
            if (r10 >= r4) goto L_0x0119
        L_0x00f6:
            int r9 = r9 + 1
            goto L_0x00ea
        L_0x00f9:
            java.lang.String r13 = r13.zzi
            java.lang.String r1 = java.lang.String.valueOf(r13)
            int r1 = r1.length()
            int r3 = r0.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = r1 + 22
            int r1 = r1 + r3
            r4.<init>(r1)
            java.lang.String r1 = "codec.profileLevel, "
            java.lang.String r13 = com.android.tools.p006r8.GeneratedOutlineSupport.outline20(r4, r1, r13, r5, r0)
            r12.zzh(r13)
        L_0x0118:
            return r2
        L_0x0119:
            boolean r0 = r12.zzg
            r4 = 21
            if (r0 == 0) goto L_0x0152
            int r0 = r13.zzq
            if (r0 <= 0) goto L_0x0151
            int r1 = r13.zzr
            if (r1 > 0) goto L_0x0128
            goto L_0x0151
        L_0x0128:
            int r3 = com.google.android.gms.internal.ads.zzalh.zza
            if (r3 < r4) goto L_0x0134
            float r13 = r13.zzs
            double r2 = (double) r13
            boolean r13 = r12.zzf(r0, r1, r2)
            return r13
        L_0x0134:
            int r0 = r0 * r1
            int r1 = com.google.android.gms.internal.ads.zzaax.zze()
            if (r0 > r1) goto L_0x013d
            r2 = 1
        L_0x013d:
            if (r2 != 0) goto L_0x0150
            int r0 = r13.zzq
            int r13 = r13.zzr
            r1 = 40
            java.lang.String r3 = "legacyFrameSize, "
            java.lang.String r4 = "x"
            java.lang.String r13 = com.android.tools.p006r8.GeneratedOutlineSupport.outline11(r1, r3, r0, r4, r13)
            r12.zzh(r13)
        L_0x0150:
            return r2
        L_0x0151:
            return r3
        L_0x0152:
            int r0 = com.google.android.gms.internal.ads.zzalh.zza
            if (r0 < r4) goto L_0x0268
            int r0 = r13.zzz
            r4 = -1
            if (r0 == r4) goto L_0x0186
            android.media.MediaCodecInfo$CodecCapabilities r5 = r12.zzd
            if (r5 != 0) goto L_0x0166
            java.lang.String r13 = "sampleRate.caps"
            r12.zzh(r13)
            goto L_0x0269
        L_0x0166:
            android.media.MediaCodecInfo$AudioCapabilities r5 = r5.getAudioCapabilities()
            if (r5 != 0) goto L_0x0173
            java.lang.String r13 = "sampleRate.aCaps"
            r12.zzh(r13)
            goto L_0x0269
        L_0x0173:
            boolean r5 = r5.isSampleRateSupported(r0)
            if (r5 != 0) goto L_0x0186
            r13 = 31
            java.lang.String r1 = "sampleRate.support, "
            java.lang.String r13 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r13, r1, r0)
            r12.zzh(r13)
            goto L_0x0269
        L_0x0186:
            int r13 = r13.zzy
            if (r13 == r4) goto L_0x0268
            android.media.MediaCodecInfo$CodecCapabilities r0 = r12.zzd
            if (r0 != 0) goto L_0x0195
            java.lang.String r13 = "channelCount.caps"
            r12.zzh(r13)
            goto L_0x0267
        L_0x0195:
            android.media.MediaCodecInfo$AudioCapabilities r0 = r0.getAudioCapabilities()
            if (r0 != 0) goto L_0x01a2
            java.lang.String r13 = "channelCount.aCaps"
            r12.zzh(r13)
            goto L_0x0267
        L_0x01a2:
            java.lang.String r4 = r12.zza
            java.lang.String r5 = r12.zzb
            int r0 = r0.getMaxInputChannelCount()
            if (r0 > r3) goto L_0x025a
            int r3 = com.google.android.gms.internal.ads.zzalh.zza
            r6 = 26
            if (r3 < r6) goto L_0x01b6
            if (r0 <= 0) goto L_0x01b6
            goto L_0x025a
        L_0x01b6:
            java.lang.String r3 = "audio/mpeg"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/3gpp"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/amr-wb"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/vorbis"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/opus"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/raw"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/flac"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/g711-alaw"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/g711-mlaw"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "audio/gsm"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x020f
            goto L_0x025a
        L_0x020f:
            java.lang.String r3 = "audio/ac3"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0219
            r1 = 6
            goto L_0x0224
        L_0x0219:
            java.lang.String r3 = "audio/eac3"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0222
            goto L_0x0224
        L_0x0222:
            r1 = 30
        L_0x0224:
            java.lang.String r3 = java.lang.String.valueOf(r4)
            int r3 = r3.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r3 = r3 + 59
            r5.<init>(r3)
            java.lang.String r3 = "AssumedMaxChannelAdjustment: "
            r5.append(r3)
            r5.append(r4)
            java.lang.String r3 = ", ["
            r5.append(r3)
            r5.append(r0)
            java.lang.String r0 = " to "
            r5.append(r0)
            r5.append(r1)
            java.lang.String r0 = "]"
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.String r3 = "MediaCodecInfo"
            android.util.Log.w(r3, r0)
            r0 = r1
        L_0x025a:
            if (r0 >= r13) goto L_0x0268
            r0 = 33
            java.lang.String r1 = "channelCount.support, "
            java.lang.String r13 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r0, r1, r13)
            r12.zzh(r13)
        L_0x0267:
            return r2
        L_0x0268:
            r2 = 1
        L_0x0269:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaah.zzc(com.google.android.gms.internal.ads.zzkc):boolean");
    }

    public final boolean zzd(zzkc zzkc) {
        if (this.zzg) {
            return this.zze;
        }
        Pair<Integer, Integer> zzf2 = zzaax.zzf(zzkc);
        return zzf2 != null && ((Integer) zzf2.first).intValue() == 42;
    }

    public final zzrs zze(zzkc zzkc, zzkc zzkc2) {
        int i = true != zzalh.zzc(zzkc.zzl, zzkc2.zzl) ? 8 : 0;
        if (this.zzg) {
            if (zzkc.zzt != zzkc2.zzt) {
                i |= 1024;
            }
            if (!this.zze && !(zzkc.zzq == zzkc2.zzq && zzkc.zzr == zzkc2.zzr)) {
                i |= 512;
            }
            if (!zzalh.zzc(zzkc.zzx, zzkc2.zzx)) {
                i |= 2048;
            }
            String str = this.zza;
            if (zzalh.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzkc.zzd(zzkc2)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzrs(this.zza, zzkc, zzkc2, true != zzkc.zzd(zzkc2) ? 2 : 3, 0);
            }
        } else {
            if (zzkc.zzy != zzkc2.zzy) {
                i |= 4096;
            }
            if (zzkc.zzz != zzkc2.zzz) {
                i |= 8192;
            }
            if (zzkc.zzA != zzkc2.zzA) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                Pair<Integer, Integer> zzf2 = zzaax.zzf(zzkc);
                Pair<Integer, Integer> zzf3 = zzaax.zzf(zzkc2);
                if (!(zzf2 == null || zzf3 == null)) {
                    int intValue = ((Integer) zzf2.first).intValue();
                    int intValue2 = ((Integer) zzf3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new zzrs(this.zza, zzkc, zzkc2, 3, 0);
                    }
                }
            }
            if (!zzkc.zzd(zzkc2)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzrs(this.zza, zzkc, zzkc2, 1, 0);
            }
        }
        return new zzrs(this.zza, zzkc, zzkc2, 0, i);
    }

    @RequiresApi(21)
    public final boolean zzf(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzh("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzh("sizeAndRate.vCaps");
            return false;
        } else if (zzi(videoCapabilities, i, i2, d)) {
            return true;
        } else {
            if (i >= i2 || (("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) && "mcv5a".equals(zzalh.zzb)) || !zzi(videoCapabilities, i2, i, d))) {
                StringBuilder outline22 = GeneratedOutlineSupport.outline22(69, "sizeAndRate.support, ", i, "x", i2);
                outline22.append("x");
                outline22.append(d);
                zzh(outline22.toString());
                return false;
            }
            StringBuilder outline222 = GeneratedOutlineSupport.outline22(69, "sizeAndRate.rotated, ", i, "x", i2);
            outline222.append("x");
            outline222.append(d);
            String sb = outline222.toString();
            String str = this.zza;
            String str2 = this.zzb;
            String str3 = zzalh.zze;
            int length = String.valueOf(sb).length();
            int length2 = String.valueOf(str).length();
            StringBuilder sb2 = new StringBuilder(length + 25 + length2 + str2.length() + String.valueOf(str3).length());
            GeneratedOutlineSupport.outline34(sb2, "AssumedSupport [", sb, "] [", str);
            GeneratedOutlineSupport.outline34(sb2, RESTClient.COMMA_SEPARATOR, str2, "] [", str3);
            sb2.append("]");
            Log.d("MediaCodecInfo", sb2.toString());
            return true;
        }
    }

    @RequiresApi(21)
    @Nullable
    public final Point zzg(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzj(videoCapabilities, i, i2);
    }
}
