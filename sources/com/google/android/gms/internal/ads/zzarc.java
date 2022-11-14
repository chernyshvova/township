package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzarc {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final String zze;
    public final MediaCodecInfo.CodecCapabilities zzf;

    public zzarc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        if (str != null) {
            this.zza = str;
            this.zze = str2;
            this.zzf = codecCapabilities;
            boolean z3 = true;
            this.zzb = !z && codecCapabilities != null && zzava.zza >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
            this.zzc = codecCapabilities != null && zzava.zza >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
            if (!z2 && (codecCapabilities == null || zzava.zza < 21 || !codecCapabilities.isFeatureSupported("secure-playback"))) {
                z3 = false;
            }
            this.zzd = z3;
            return;
        }
        throw null;
    }

    public static zzarc zza(String str) {
        return new zzarc("OMX.google.raw.decoder", (String) null, (MediaCodecInfo.CodecCapabilities) null, false, false);
    }

    public static zzarc zzb(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzarc(str, str2, codecCapabilities, z, z2);
    }

    private final void zzi(String str) {
        String str2 = this.zza;
        String str3 = this.zze;
        String str4 = zzava.zze;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 20 + length2 + String.valueOf(str3).length() + String.valueOf(str4).length());
        GeneratedOutlineSupport.outline34(sb, "NoSupport [", str, "] [", str2);
        GeneratedOutlineSupport.outline34(sb, RESTClient.COMMA_SEPARATOR, str3, "] [", str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    public static boolean zzj(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= RoundRectDrawableWithShadow.COS_45) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.profileLevels;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.media.MediaCodecInfo.CodecProfileLevel[] zzc() {
        /*
            r1 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.zzf
            if (r0 == 0) goto L_0x0008
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarc.zzc():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }

    public final boolean zzd(String str) {
        if (str == null || this.zze == null) {
            return true;
        }
        String trim = str.trim();
        String str2 = (trim.startsWith("avc1") || trim.startsWith("avc3")) ? "video/avc" : (trim.startsWith("hev1") || trim.startsWith("hvc1")) ? "video/hevc" : trim.startsWith("vp9") ? "video/x-vnd.on2.vp9" : trim.startsWith("vp8") ? "video/x-vnd.on2.vp8" : trim.startsWith("mp4a") ? "audio/mp4a-latm" : (trim.startsWith("ac-3") || trim.startsWith("dac3")) ? "audio/ac3" : (trim.startsWith("ec-3") || trim.startsWith("dec3")) ? "audio/eac3" : (trim.startsWith("dtsc") || trim.startsWith("dtse")) ? "audio/vnd.dts" : (trim.startsWith("dtsh") || trim.startsWith("dtsl")) ? "audio/vnd.dts.hd" : trim.startsWith("opus") ? "audio/opus" : trim.startsWith("vorbis") ? "audio/vorbis" : null;
        if (str2 == null) {
            return true;
        }
        if (!this.zze.equals(str2)) {
            zzi(GeneratedOutlineSupport.outline20(new StringBuilder(str.length() + 13 + str2.length()), "codec.mime ", str, RESTClient.COMMA_SEPARATOR, str2));
            return false;
        }
        Pair<Integer, Integer> zzd2 = zzarn.zzd(str);
        if (zzd2 == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzc()) {
            if (codecProfileLevel.profile == ((Integer) zzd2.first).intValue() && codecProfileLevel.level >= ((Integer) zzd2.second).intValue()) {
                return true;
            }
        }
        zzi(GeneratedOutlineSupport.outline20(new StringBuilder(str.length() + 22 + str2.length()), "codec.profileLevel, ", str, RESTClient.COMMA_SEPARATOR, str2));
        return false;
    }

    @TargetApi(21)
    public final boolean zze(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzi("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzi("sizeAndRate.vCaps");
            return false;
        } else if (zzj(videoCapabilities, i, i2, d)) {
            return true;
        } else {
            if (i >= i2 || !zzj(videoCapabilities, i2, i, d)) {
                StringBuilder outline22 = GeneratedOutlineSupport.outline22(69, "sizeAndRate.support, ", i, "x", i2);
                outline22.append("x");
                outline22.append(d);
                zzi(outline22.toString());
                return false;
            }
            StringBuilder outline222 = GeneratedOutlineSupport.outline22(69, "sizeAndRate.rotated, ", i, "x", i2);
            outline222.append("x");
            outline222.append(d);
            String sb = outline222.toString();
            String str = this.zza;
            String str2 = this.zze;
            String str3 = zzava.zze;
            int length = String.valueOf(sb).length();
            int length2 = String.valueOf(str).length();
            StringBuilder sb2 = new StringBuilder(length + 25 + length2 + String.valueOf(str2).length() + String.valueOf(str3).length());
            GeneratedOutlineSupport.outline34(sb2, "AssumedSupport [", sb, "] [", str);
            GeneratedOutlineSupport.outline34(sb2, RESTClient.COMMA_SEPARATOR, str2, "] [", str3);
            sb2.append("]");
            Log.d("MediaCodecInfo", sb2.toString());
            return true;
        }
    }

    @TargetApi(21)
    public final Point zzf(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzi("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzi("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzava.zze(i, widthAlignment) * widthAlignment, zzava.zze(i2, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    public final boolean zzg(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzi("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzi("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            zzi(GeneratedOutlineSupport.outline9(31, "sampleRate.support, ", i));
            return false;
        }
    }

    @TargetApi(21)
    public final boolean zzh(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzi("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzi("channelCount.aCaps");
            return false;
        } else if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        } else {
            zzi(GeneratedOutlineSupport.outline9(33, "channelCount.support, ", i));
            return false;
        }
    }
}
