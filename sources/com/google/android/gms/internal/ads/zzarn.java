package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzarn {
    public static final zzarc zza = zzarc.zza("OMX.google.raw.decoder");
    public static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    public static final HashMap<zzari, List<zzarc>> zzc = new HashMap<>();
    public static final SparseIntArray zzd;
    public static final SparseIntArray zze;
    public static final Map<String, Integer> zzf;
    public static int zzg = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzd = sparseIntArray;
        sparseIntArray.put(66, 1);
        zzd.put(77, 2);
        zzd.put(88, 4);
        zzd.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zze = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        zze.put(11, 4);
        zze.put(12, 8);
        zze.put(13, 16);
        zze.put(20, 32);
        zze.put(21, 64);
        zze.put(22, 128);
        zze.put(30, 256);
        zze.put(31, 512);
        zze.put(32, 1024);
        zze.put(40, 2048);
        zze.put(41, 4096);
        zze.put(42, 8192);
        zze.put(50, 16384);
        zze.put(51, 32768);
        zze.put(52, 65536);
        HashMap hashMap = new HashMap();
        zzf = hashMap;
        hashMap.put("L30", 1);
        zzf.put("L60", 4);
        zzf.put("L63", 16);
        zzf.put("L90", 64);
        zzf.put("L93", 256);
        zzf.put("L120", 1024);
        zzf.put("L123", 4096);
        zzf.put("L150", 16384);
        zzf.put("L153", 65536);
        zzf.put("L156", 262144);
        zzf.put("L180", 1048576);
        zzf.put("L183", 4194304);
        zzf.put("L186", 16777216);
        zzf.put("H30", 2);
        zzf.put("H60", 8);
        zzf.put("H63", 32);
        zzf.put("H90", 128);
        zzf.put("H93", 512);
        zzf.put("H120", 2048);
        zzf.put("H123", 8192);
        zzf.put("H150", 32768);
        zzf.put("H153", 131072);
        zzf.put("H156", 524288);
        zzf.put("H180", 2097152);
        zzf.put("H183", 8388608);
        zzf.put("H186", 33554432);
    }

    public static zzarc zza(String str, boolean z) throws zzarj {
        List<zzarc> zzb2 = zzb(str, z);
        if (zzb2.isEmpty()) {
            return null;
        }
        return zzb2.get(0);
    }

    public static synchronized List<zzarc> zzb(String str, boolean z) throws zzarj {
        zzark zzark;
        synchronized (zzarn.class) {
            zzari zzari = new zzari(str, z);
            List<zzarc> list = zzc.get(zzari);
            if (list != null) {
                return list;
            }
            if (zzava.zza >= 21) {
                zzark = new zzarm(z);
            } else {
                zzark = new zzarl((zzarh) null);
            }
            List<zzarc> zze2 = zze(zzari, zzark);
            if (z && zze2.isEmpty() && zzava.zza >= 21 && zzava.zza <= 23) {
                zze2 = zze(zzari, new zzarl((zzarh) null));
                if (!zze2.isEmpty()) {
                    String str2 = zze2.get(0).zza;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzarc> unmodifiableList = Collections.unmodifiableList(zze2);
            zzc.put(zzari, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int zzc() throws zzarj {
        if (zzg == -1) {
            int i = 0;
            zzarc zza2 = zza("video/avc", false);
            if (zza2 != null) {
                MediaCodecInfo.CodecProfileLevel[] zzc2 = zza2.zzc();
                int length = zzc2.length;
                int i2 = 0;
                while (i < length) {
                    int i3 = zzc2[i].level;
                    int i4 = 9437184;
                    if (i3 != 1 && i3 != 2) {
                        switch (i3) {
                            case 8:
                            case 16:
                            case 32:
                                i4 = 101376;
                                break;
                            case 64:
                                i4 = 202752;
                                break;
                            case 128:
                            case 256:
                                i4 = 414720;
                                break;
                            case 512:
                                i4 = 921600;
                                break;
                            case 1024:
                                i4 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i4 = 2097152;
                                break;
                            case 8192:
                                i4 = 2228224;
                                break;
                            case 16384:
                                i4 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i4 = -1;
                                break;
                        }
                    } else {
                        i4 = 25344;
                    }
                    i2 = Math.max(i4, i2);
                    i++;
                }
                i = Math.max(i2, zzava.zza >= 21 ? 345600 : 172800);
            }
            zzg = i;
        }
        return zzg;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzd(java.lang.String r12) {
        /*
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r12.split(r0)
            r1 = 0
            r2 = r0[r1]
            int r3 = r2.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case 3006243: goto L_0x0032;
                case 3006244: goto L_0x0028;
                case 3199032: goto L_0x001e;
                case 3214780: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x003c
        L_0x0014:
            java.lang.String r3 = "hvc1"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003c
            r2 = 1
            goto L_0x003d
        L_0x001e:
            java.lang.String r3 = "hev1"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003c
            r2 = 0
            goto L_0x003d
        L_0x0028:
            java.lang.String r3 = "avc2"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003c
            r2 = 3
            goto L_0x003d
        L_0x0032:
            java.lang.String r3 = "avc1"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003c
            r2 = 2
            goto L_0x003d
        L_0x003c:
            r2 = -1
        L_0x003d:
            r3 = 4
            java.lang.String r7 = "MediaCodecUtil"
            r8 = 0
            if (r2 == 0) goto L_0x00ed
            if (r2 == r6) goto L_0x00ed
            if (r2 == r5) goto L_0x004a
            if (r2 == r4) goto L_0x004a
            return r8
        L_0x004a:
            int r2 = r0.length
            java.lang.String r9 = "Ignoring malformed AVC codec string: "
            if (r2 >= r5) goto L_0x0064
            int r0 = r12.length()
            if (r0 == 0) goto L_0x005a
            java.lang.String r12 = r9.concat(r12)
            goto L_0x005f
        L_0x005a:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r9)
        L_0x005f:
            android.util.Log.w(r7, r12)
            goto L_0x00ec
        L_0x0064:
            r10 = r0[r6]     // Catch:{ NumberFormatException -> 0x00d8 }
            int r10 = r10.length()     // Catch:{ NumberFormatException -> 0x00d8 }
            r11 = 6
            if (r10 != r11) goto L_0x008c
            r2 = r0[r6]     // Catch:{ NumberFormatException -> 0x00d8 }
            java.lang.String r1 = r2.substring(r1, r5)     // Catch:{ NumberFormatException -> 0x00d8 }
            r2 = 16
            int r1 = java.lang.Integer.parseInt(r1, r2)     // Catch:{ NumberFormatException -> 0x00d8 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x00d8 }
            r0 = r0[r6]     // Catch:{ NumberFormatException -> 0x00d8 }
            java.lang.String r0 = r0.substring(r3)     // Catch:{ NumberFormatException -> 0x00d8 }
            int r0 = java.lang.Integer.parseInt(r0, r2)     // Catch:{ NumberFormatException -> 0x00d8 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00d8 }
            goto L_0x00a2
        L_0x008c:
            if (r2 < r4) goto L_0x00c4
            r1 = r0[r6]     // Catch:{ NumberFormatException -> 0x00d8 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x00d8 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x00d8 }
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x00d8 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x00d8 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00d8 }
        L_0x00a2:
            android.util.SparseIntArray r0 = zzd
            int r1 = r1.intValue()
            int r0 = r0.get(r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            android.util.SparseIntArray r1 = zze
            int r12 = r12.intValue()
            int r12 = r1.get(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            android.util.Pair r8 = new android.util.Pair
            r8.<init>(r0, r12)
            goto L_0x00ec
        L_0x00c4:
            int r0 = r12.length()     // Catch:{ NumberFormatException -> 0x00d8 }
            if (r0 == 0) goto L_0x00cf
            java.lang.String r0 = r9.concat(r12)     // Catch:{ NumberFormatException -> 0x00d8 }
            goto L_0x00d4
        L_0x00cf:
            java.lang.String r0 = new java.lang.String     // Catch:{ NumberFormatException -> 0x00d8 }
            r0.<init>(r9)     // Catch:{ NumberFormatException -> 0x00d8 }
        L_0x00d4:
            android.util.Log.w(r7, r0)     // Catch:{ NumberFormatException -> 0x00d8 }
            goto L_0x00ec
        L_0x00d8:
            int r0 = r12.length()
            if (r0 == 0) goto L_0x00e4
            java.lang.String r12 = r9.concat(r12)
            goto L_0x00e9
        L_0x00e4:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r9)
        L_0x00e9:
            android.util.Log.w(r7, r12)
        L_0x00ec:
            return r8
        L_0x00ed:
            int r1 = r0.length
            java.lang.String r2 = "Ignoring malformed HEVC codec string: "
            if (r1 >= r3) goto L_0x0107
            int r0 = r12.length()
            if (r0 == 0) goto L_0x00fd
            java.lang.String r12 = r2.concat(r12)
            goto L_0x0102
        L_0x00fd:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r2)
        L_0x0102:
            android.util.Log.w(r7, r12)
            goto L_0x018c
        L_0x0107:
            java.util.regex.Pattern r1 = zzb
            r3 = r0[r6]
            java.util.regex.Matcher r1 = r1.matcher(r3)
            boolean r3 = r1.matches()
            if (r3 != 0) goto L_0x0129
            int r0 = r12.length()
            if (r0 == 0) goto L_0x0120
            java.lang.String r12 = r2.concat(r12)
            goto L_0x0125
        L_0x0120:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r2)
        L_0x0125:
            android.util.Log.w(r7, r12)
            goto L_0x018c
        L_0x0129:
            java.lang.String r12 = r1.group(r6)
            java.lang.String r2 = "1"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0137
            r5 = 1
            goto L_0x013f
        L_0x0137:
            java.lang.String r2 = "2"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0173
        L_0x013f:
            java.util.Map<java.lang.String, java.lang.Integer> r12 = zzf
            r0 = r0[r4]
            java.lang.Object r12 = r12.get(r0)
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 != 0) goto L_0x0169
            java.lang.String r12 = r1.group(r6)
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r0 = "Unknown HEVC level string: "
            int r1 = r12.length()
            if (r1 == 0) goto L_0x0160
            java.lang.String r12 = r0.concat(r12)
            goto L_0x0165
        L_0x0160:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r0)
        L_0x0165:
            android.util.Log.w(r7, r12)
            goto L_0x018c
        L_0x0169:
            android.util.Pair r8 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r8.<init>(r0, r12)
            goto L_0x018c
        L_0x0173:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r0 = "Unknown HEVC profile string: "
            int r1 = r12.length()
            if (r1 == 0) goto L_0x0184
            java.lang.String r12 = r0.concat(r12)
            goto L_0x0189
        L_0x0184:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r0)
        L_0x0189:
            android.util.Log.w(r7, r12)
        L_0x018c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarn.zzd(java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x01f0 A[Catch:{ Exception -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x022c A[SYNTHETIC, Splitter:B:146:0x022c] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0256 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.google.android.gms.internal.ads.zzarc> zze(com.google.android.gms.internal.ads.zzari r18, com.google.android.gms.internal.ads.zzark r19) throws com.google.android.gms.internal.ads.zzarj {
        /*
            r1 = r18
            r2 = r19
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x02a2 }
            r3.<init>()     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r4 = r1.zza     // Catch:{ Exception -> 0x02a2 }
            int r5 = r19.zza()     // Catch:{ Exception -> 0x02a2 }
            boolean r6 = r19.zzc()     // Catch:{ Exception -> 0x02a2 }
            r8 = 0
        L_0x0014:
            if (r8 >= r5) goto L_0x02a1
            android.media.MediaCodecInfo r9 = r2.zzb(r8)     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r10 = r9.getName()     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r9.isEncoder()     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r11 = ".secure"
            if (r6 != 0) goto L_0x0030
            boolean r0 = r10.endsWith(r11)     // Catch:{ Exception -> 0x02a2 }
            if (r0 == 0) goto L_0x0030
            goto L_0x0296
        L_0x0030:
            int r0 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ Exception -> 0x02a2 }
            r12 = 21
            if (r0 >= r12) goto L_0x0066
            java.lang.String r0 = "CIPAACDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "CIPMP3Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "CIPVorbisDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "CIPAMRNBDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "AACDecoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "MP3Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
        L_0x0066:
            int r0 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ Exception -> 0x02a2 }
            r12 = 18
            if (r0 >= r12) goto L_0x0074
            java.lang.String r0 = "OMX.SEC.MP3.Decoder"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
        L_0x0074:
            int r0 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ Exception -> 0x02a2 }
            if (r0 >= r12) goto L_0x008a
            java.lang.String r0 = "OMX.MTK.AUDIO.DECODER.AAC"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 == 0) goto L_0x008a
            java.lang.String r0 = "a70"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
        L_0x008a:
            int r0 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ Exception -> 0x02a2 }
            r12 = 16
            if (r0 != r12) goto L_0x0110
            java.lang.String r0 = "OMX.qcom.audio.decoder.mp3"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 == 0) goto L_0x0110
            java.lang.String r0 = "dlxu"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "protou"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "ville"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "villeplus"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "villec2"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r13 = "gee"
            boolean r0 = r0.startsWith(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "C6602"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "C6603"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "C6606"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "C6616"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "L36h"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "SO-02E"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
        L_0x0110:
            int r0 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ Exception -> 0x02a2 }
            if (r0 != r12) goto L_0x0144
            java.lang.String r0 = "OMX.qcom.audio.decoder.aac"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 == 0) goto L_0x0144
            java.lang.String r0 = "C1504"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "C1505"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "C1604"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "C1605"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
        L_0x0144:
            int r0 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r12 = "jflte"
            r13 = 19
            if (r0 > r13) goto L_0x018e
            java.lang.String r0 = "OMX.SEC.vp8.dec"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 == 0) goto L_0x018e
            java.lang.String r0 = "samsung"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzava.zzc     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.equals(r14)     // Catch:{ Exception -> 0x02a2 }
            if (r0 == 0) goto L_0x018e
            java.lang.String r0 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r14 = "d2"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r14 = "serrano"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.startsWith(r12)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r14 = "santos"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r14 = "t0"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
        L_0x018e:
            int r0 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ Exception -> 0x02a2 }
            if (r0 > r13) goto L_0x01a2
            java.lang.String r0 = com.google.android.gms.internal.ads.zzava.zzb     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r0.startsWith(r12)     // Catch:{ Exception -> 0x02a2 }
            if (r0 == 0) goto L_0x01a2
            java.lang.String r0 = "OMX.qcom.video.decoder.vp8"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x02a2 }
            if (r0 != 0) goto L_0x0296
        L_0x01a2:
            java.lang.String[] r12 = r9.getSupportedTypes()     // Catch:{ Exception -> 0x02a2 }
            int r13 = r12.length     // Catch:{ Exception -> 0x02a2 }
            r14 = 0
        L_0x01a8:
            if (r14 >= r13) goto L_0x0296
            r15 = r12[r14]     // Catch:{ Exception -> 0x02a2 }
            boolean r0 = r15.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x02a2 }
            if (r0 == 0) goto L_0x0287
            android.media.MediaCodecInfo$CodecCapabilities r0 = r9.getCapabilitiesForType(r15)     // Catch:{ Exception -> 0x021e }
            boolean r7 = r2.zzd(r4, r0)     // Catch:{ Exception -> 0x021e }
            int r2 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ Exception -> 0x021e }
            r16 = r5
            r5 = 22
            r17 = r9
            r9 = 1
            if (r2 > r5) goto L_0x01ed
            java.lang.String r2 = com.google.android.gms.internal.ads.zzava.zzd     // Catch:{ Exception -> 0x01eb }
            java.lang.String r5 = "ODROID-XU3"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x01eb }
            if (r2 != 0) goto L_0x01d9
            java.lang.String r2 = com.google.android.gms.internal.ads.zzava.zzd     // Catch:{ Exception -> 0x01eb }
            java.lang.String r5 = "Nexus 10"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x01eb }
            if (r2 == 0) goto L_0x01ed
        L_0x01d9:
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01eb }
            if (r2 != 0) goto L_0x01e9
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01eb }
            if (r2 == 0) goto L_0x01ed
        L_0x01e9:
            r2 = 1
            goto L_0x01ee
        L_0x01eb:
            r0 = move-exception
            goto L_0x0223
        L_0x01ed:
            r2 = 0
        L_0x01ee:
            if (r6 == 0) goto L_0x01f7
            boolean r5 = r1.zzb     // Catch:{ Exception -> 0x01eb }
            if (r5 == r7) goto L_0x01f5
            goto L_0x01f7
        L_0x01f5:
            r5 = 0
            goto L_0x01fe
        L_0x01f7:
            if (r6 != 0) goto L_0x0209
            boolean r5 = r1.zzb     // Catch:{ Exception -> 0x01eb }
            if (r5 != 0) goto L_0x0209
            goto L_0x01f5
        L_0x01fe:
            com.google.android.gms.internal.ads.zzarc r0 = com.google.android.gms.internal.ads.zzarc.zzb(r10, r4, r0, r2, r5)     // Catch:{ Exception -> 0x0207 }
            r3.add(r0)     // Catch:{ Exception -> 0x0207 }
            goto L_0x028c
        L_0x0207:
            r0 = move-exception
            goto L_0x0224
        L_0x0209:
            r5 = 0
            if (r6 != 0) goto L_0x028c
            if (r7 == 0) goto L_0x028c
            java.lang.String r7 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r7 = r7.concat(r11)     // Catch:{ Exception -> 0x0207 }
            com.google.android.gms.internal.ads.zzarc r0 = com.google.android.gms.internal.ads.zzarc.zzb(r7, r4, r0, r2, r9)     // Catch:{ Exception -> 0x0207 }
            r3.add(r0)     // Catch:{ Exception -> 0x0207 }
            return r3
        L_0x021e:
            r0 = move-exception
            r16 = r5
            r17 = r9
        L_0x0223:
            r5 = 0
        L_0x0224:
            int r2 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ Exception -> 0x02a2 }
            r7 = 23
            java.lang.String r9 = "MediaCodecUtil"
            if (r2 > r7) goto L_0x0256
            boolean r2 = r3.isEmpty()     // Catch:{ Exception -> 0x02a2 }
            if (r2 != 0) goto L_0x0256
            java.lang.String r0 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x02a2 }
            int r0 = r0.length()     // Catch:{ Exception -> 0x02a2 }
            int r0 = r0 + 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a2 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r0 = "Skipping codec "
            r2.append(r0)     // Catch:{ Exception -> 0x02a2 }
            r2.append(r10)     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r0 = " (failed to query capabilities)"
            r2.append(r0)     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x02a2 }
            android.util.Log.e(r9, r0)     // Catch:{ Exception -> 0x02a2 }
            goto L_0x028c
        L_0x0256:
            java.lang.String r1 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x02a2 }
            int r1 = r1.length()     // Catch:{ Exception -> 0x02a2 }
            int r1 = r1 + 25
            int r2 = r15.length()     // Catch:{ Exception -> 0x02a2 }
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a2 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r1 = "Failed to query codec "
            r2.append(r1)     // Catch:{ Exception -> 0x02a2 }
            r2.append(r10)     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x02a2 }
            r2.append(r15)     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x02a2 }
            android.util.Log.e(r9, r1)     // Catch:{ Exception -> 0x02a2 }
            throw r0     // Catch:{ Exception -> 0x02a2 }
        L_0x0287:
            r16 = r5
            r17 = r9
            r5 = 0
        L_0x028c:
            int r14 = r14 + 1
            r2 = r19
            r5 = r16
            r9 = r17
            goto L_0x01a8
        L_0x0296:
            r16 = r5
            r5 = 0
            int r8 = r8 + 1
            r2 = r19
            r5 = r16
            goto L_0x0014
        L_0x02a1:
            return r3
        L_0x02a2:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzarj r1 = new com.google.android.gms.internal.ads.zzarj
            r2 = 0
            r1.<init>(r0, r2)
            goto L_0x02ab
        L_0x02aa:
            throw r1
        L_0x02ab:
            goto L_0x02aa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarn.zze(com.google.android.gms.internal.ads.zzari, com.google.android.gms.internal.ads.zzark):java.util.List");
    }
}
