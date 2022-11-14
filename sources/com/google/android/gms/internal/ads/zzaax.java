package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.util.Log;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaax {
    public static final /* synthetic */ int zza = 0;
    public static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    @GuardedBy("MediaCodecUtil.class")
    public static final HashMap<zzaar, List<zzaah>> zzc = new HashMap<>();
    public static int zzd = -1;

    @Nullable
    public static zzaah zza() throws zzaas {
        return zzb("audio/raw", false, false);
    }

    @Nullable
    public static zzaah zzb(String str, boolean z, boolean z2) throws zzaas {
        List<zzaah> zzc2 = zzc(str, false, false);
        if (zzc2.isEmpty()) {
            return null;
        }
        return zzc2.get(0);
    }

    public static synchronized List<zzaah> zzc(String str, boolean z, boolean z2) throws zzaas {
        zzaat zzaat;
        String str2 = str;
        boolean z3 = z;
        boolean z4 = z2;
        synchronized (zzaax.class) {
            zzaar zzaar = new zzaar(str2, z3, z4);
            List<zzaah> list = zzc.get(zzaar);
            if (list != null) {
                return list;
            }
            if (zzalh.zza >= 21) {
                zzaat = new zzaav(z3, z4);
            } else {
                zzaat = new zzaau((zzaaq) null);
            }
            ArrayList<zzaah> zzg = zzg(zzaar, zzaat);
            if (z3 && zzg.isEmpty() && zzalh.zza >= 21 && zzalh.zza <= 23) {
                zzg = zzg(zzaar, new zzaau((zzaaq) null));
                if (!zzg.isEmpty()) {
                    String str3 = zzg.get(0).zza;
                    StringBuilder sb = new StringBuilder(str.length() + 63 + String.valueOf(str3).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str2);
                    sb.append(". Assuming: ");
                    sb.append(str3);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            if ("audio/raw".equals(str2)) {
                if (zzalh.zza < 26 && zzalh.zzb.equals("R9") && zzg.size() == 1 && zzg.get(0).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzg.add(zzaah.zza("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
                }
                zzi(zzg, zzaan.zza);
            }
            if (zzalh.zza < 21 && zzg.size() > 1) {
                String str4 = zzg.get(0).zza;
                if ("OMX.SEC.mp3.dec".equals(str4) || "OMX.SEC.MP3.Decoder".equals(str4) || "OMX.brcm.audio.mp3.decoder".equals(str4)) {
                    zzi(zzg, zzaao.zza);
                }
            }
            if (zzalh.zza < 30 && zzg.size() > 1 && "OMX.qti.audio.decoder.flac".equals(zzg.get(0).zza)) {
                zzg.add(zzg.remove(0));
            }
            List<zzaah> unmodifiableList = Collections.unmodifiableList(zzg);
            zzc.put(zzaar, unmodifiableList);
            return unmodifiableList;
        }
    }

    @CheckResult
    public static List<zzaah> zzd(List<zzaah> list, zzkc zzkc) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zzaam(zzkc));
        return arrayList;
    }

    public static int zze() throws zzaas {
        int i;
        if (zzd == -1) {
            int i2 = 0;
            zzaah zzb2 = zzb("video/avc", false, false);
            if (zzb2 != null) {
                MediaCodecInfo.CodecProfileLevel[] zzb3 = zzb2.zzb();
                int length = zzb3.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = zzb3[i2].level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i = 35651584;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzalh.zza >= 21 ? 345600 : 172800);
            }
            zzd = i2;
        }
        return zzd;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x030a A[Catch:{ NumberFormatException -> 0x0319 }] */
    /* JADX WARNING: Removed duplicated region for block: B:460:0x074d  */
    /* JADX WARNING: Removed duplicated region for block: B:461:0x0753  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzf(com.google.android.gms.internal.ads.zzkc r15) {
        /*
            java.lang.String r0 = r15.zzi
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r1 = "\\."
            java.lang.String[] r0 = r0.split(r1)
            java.lang.String r1 = r15.zzl
            java.lang.String r2 = "video/dolby-vision"
            boolean r1 = r2.equals(r1)
            r2 = 512(0x200, float:7.175E-43)
            r3 = 256(0x100, float:3.59E-43)
            r4 = 128(0x80, float:1.794E-43)
            r5 = 64
            r6 = 4096(0x1000, float:5.74E-42)
            r7 = 32
            r8 = 16
            r9 = 8
            r10 = 3
            r11 = 4
            r12 = 2
            java.lang.String r13 = "MediaCodecUtil"
            r14 = 1
            if (r1 == 0) goto L_0x0229
            java.lang.String r15 = r15.zzi
            int r1 = r0.length
            if (r1 >= r10) goto L_0x004c
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed Dolby Vision codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x0042
            java.lang.String r15 = r0.concat(r15)
            goto L_0x0047
        L_0x0042:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x0047:
            android.util.Log.w(r13, r15)
            goto L_0x0221
        L_0x004c:
            java.util.regex.Pattern r1 = zzb
            r10 = r0[r14]
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r10 = r1.matches()
            if (r10 != 0) goto L_0x0075
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed Dolby Vision codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x006b
            java.lang.String r15 = r0.concat(r15)
            goto L_0x0070
        L_0x006b:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x0070:
            android.util.Log.w(r13, r15)
            goto L_0x0221
        L_0x0075:
            java.lang.String r15 = r1.group(r14)
            if (r15 != 0) goto L_0x007d
            goto L_0x0123
        L_0x007d:
            int r1 = r15.hashCode()
            switch(r1) {
                case 1536: goto L_0x00e2;
                case 1537: goto L_0x00d8;
                case 1538: goto L_0x00ce;
                case 1539: goto L_0x00c4;
                case 1540: goto L_0x00ba;
                case 1541: goto L_0x00b0;
                case 1542: goto L_0x00a6;
                case 1543: goto L_0x009c;
                case 1544: goto L_0x0091;
                case 1545: goto L_0x0086;
                default: goto L_0x0084;
            }
        L_0x0084:
            goto L_0x00ec
        L_0x0086:
            java.lang.String r1 = "09"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 9
            goto L_0x00ed
        L_0x0091:
            java.lang.String r1 = "08"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 8
            goto L_0x00ed
        L_0x009c:
            java.lang.String r1 = "07"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 7
            goto L_0x00ed
        L_0x00a6:
            java.lang.String r1 = "06"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 6
            goto L_0x00ed
        L_0x00b0:
            java.lang.String r1 = "05"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 5
            goto L_0x00ed
        L_0x00ba:
            java.lang.String r1 = "04"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 4
            goto L_0x00ed
        L_0x00c4:
            java.lang.String r1 = "03"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 3
            goto L_0x00ed
        L_0x00ce:
            java.lang.String r1 = "02"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 2
            goto L_0x00ed
        L_0x00d8:
            java.lang.String r1 = "01"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 1
            goto L_0x00ed
        L_0x00e2:
            java.lang.String r1 = "00"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x00ec
            r1 = 0
            goto L_0x00ed
        L_0x00ec:
            r1 = -1
        L_0x00ed:
            switch(r1) {
                case 0: goto L_0x011e;
                case 1: goto L_0x0119;
                case 2: goto L_0x0114;
                case 3: goto L_0x010f;
                case 4: goto L_0x010a;
                case 5: goto L_0x0105;
                case 6: goto L_0x0100;
                case 7: goto L_0x00fb;
                case 8: goto L_0x00f6;
                case 9: goto L_0x00f1;
                default: goto L_0x00f0;
            }
        L_0x00f0:
            goto L_0x0123
        L_0x00f1:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            goto L_0x0124
        L_0x00f6:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x0124
        L_0x00fb:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0124
        L_0x0100:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x0124
        L_0x0105:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            goto L_0x0124
        L_0x010a:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            goto L_0x0124
        L_0x010f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            goto L_0x0124
        L_0x0114:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x0124
        L_0x0119:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            goto L_0x0124
        L_0x011e:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            goto L_0x0124
        L_0x0123:
            r1 = 0
        L_0x0124:
            if (r1 != 0) goto L_0x0141
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Unknown Dolby Vision profile string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x0137
            java.lang.String r15 = r0.concat(r15)
            goto L_0x013c
        L_0x0137:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x013c:
            android.util.Log.w(r13, r15)
            goto L_0x0221
        L_0x0141:
            r15 = r0[r12]
            if (r15 != 0) goto L_0x0147
            goto L_0x0205
        L_0x0147:
            int r0 = r15.hashCode()
            switch(r0) {
                case 1537: goto L_0x01c0;
                case 1538: goto L_0x01b3;
                case 1539: goto L_0x01a6;
                case 1540: goto L_0x0199;
                case 1541: goto L_0x018b;
                case 1542: goto L_0x017d;
                case 1543: goto L_0x016f;
                case 1544: goto L_0x0161;
                case 1545: goto L_0x0153;
                default: goto L_0x014e;
            }
        L_0x014e:
            switch(r0) {
                case 1567: goto L_0x01f8;
                case 1568: goto L_0x01e9;
                case 1569: goto L_0x01da;
                case 1570: goto L_0x01cd;
                default: goto L_0x0151;
            }
        L_0x0151:
            goto L_0x0205
        L_0x0153:
            java.lang.String r0 = "09"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            goto L_0x0206
        L_0x0161:
            java.lang.String r0 = "08"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            goto L_0x0206
        L_0x016f:
            java.lang.String r0 = "07"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            goto L_0x0206
        L_0x017d:
            java.lang.String r0 = "06"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            goto L_0x0206
        L_0x018b:
            java.lang.String r0 = "05"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            goto L_0x0206
        L_0x0199:
            java.lang.String r0 = "04"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            goto L_0x0206
        L_0x01a6:
            java.lang.String r0 = "03"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            goto L_0x0206
        L_0x01b3:
            java.lang.String r0 = "02"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
            goto L_0x0206
        L_0x01c0:
            java.lang.String r0 = "01"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            goto L_0x0206
        L_0x01cd:
            java.lang.String r0 = "13"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            goto L_0x0206
        L_0x01da:
            java.lang.String r0 = "12"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            r0 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0206
        L_0x01e9:
            java.lang.String r0 = "11"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            r0 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0206
        L_0x01f8:
            java.lang.String r0 = "10"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x0205
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            goto L_0x0206
        L_0x0205:
            r0 = 0
        L_0x0206:
            if (r0 != 0) goto L_0x0223
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Unknown Dolby Vision level string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x0219
            java.lang.String r15 = r0.concat(r15)
            goto L_0x021e
        L_0x0219:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x021e:
            android.util.Log.w(r13, r15)
        L_0x0221:
            r15 = 0
            goto L_0x0228
        L_0x0223:
            android.util.Pair r15 = new android.util.Pair
            r15.<init>(r1, r0)
        L_0x0228:
            return r15
        L_0x0229:
            r1 = 0
            r1 = r0[r1]
            int r3 = r1.hashCode()
            switch(r3) {
                case 3004662: goto L_0x0270;
                case 3006243: goto L_0x0266;
                case 3006244: goto L_0x025c;
                case 3199032: goto L_0x0252;
                case 3214780: goto L_0x0248;
                case 3356560: goto L_0x023e;
                case 3624515: goto L_0x0234;
                default: goto L_0x0233;
            }
        L_0x0233:
            goto L_0x027a
        L_0x0234:
            java.lang.String r3 = "vp09"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x027a
            r1 = 2
            goto L_0x027b
        L_0x023e:
            java.lang.String r3 = "mp4a"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x027a
            r1 = 6
            goto L_0x027b
        L_0x0248:
            java.lang.String r3 = "hvc1"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x027a
            r1 = 4
            goto L_0x027b
        L_0x0252:
            java.lang.String r3 = "hev1"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x027a
            r1 = 3
            goto L_0x027b
        L_0x025c:
            java.lang.String r3 = "avc2"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x027a
            r1 = 1
            goto L_0x027b
        L_0x0266:
            java.lang.String r3 = "avc1"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x027a
            r1 = 0
            goto L_0x027b
        L_0x0270:
            java.lang.String r3 = "av01"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x027a
            r1 = 5
            goto L_0x027b
        L_0x027a:
            r1 = -1
        L_0x027b:
            r3 = 30
            r5 = 20
            switch(r1) {
                case 0: goto L_0x077d;
                case 1: goto L_0x077d;
                case 2: goto L_0x06a8;
                case 3: goto L_0x0418;
                case 4: goto L_0x0418;
                case 5: goto L_0x0335;
                case 6: goto L_0x0284;
                default: goto L_0x0282;
            }
        L_0x0282:
            r15 = 0
            return r15
        L_0x0284:
            java.lang.String r15 = r15.zzi
            int r1 = r0.length
            r2 = 3
            if (r1 == r2) goto L_0x02a5
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed MP4A codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x029b
            java.lang.String r15 = r0.concat(r15)
            goto L_0x02a0
        L_0x029b:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x02a0:
            android.util.Log.w(r13, r15)
            goto L_0x0333
        L_0x02a5:
            java.lang.String r1 = "audio/mp4a-latm"
            r2 = r0[r14]     // Catch:{ NumberFormatException -> 0x0319 }
            int r2 = java.lang.Integer.parseInt(r2, r8)     // Catch:{ NumberFormatException -> 0x0319 }
            java.lang.String r2 = com.google.android.gms.internal.ads.zzakg.zze(r2)     // Catch:{ NumberFormatException -> 0x0319 }
            boolean r1 = r1.equals(r2)     // Catch:{ NumberFormatException -> 0x0319 }
            if (r1 == 0) goto L_0x0333
            r0 = r0[r12]     // Catch:{ NumberFormatException -> 0x0319 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0319 }
            r1 = 17
            if (r0 == r1) goto L_0x0303
            if (r0 == r5) goto L_0x02ff
            r1 = 23
            if (r0 == r1) goto L_0x02fa
            r1 = 29
            if (r0 == r1) goto L_0x02f5
            r1 = 39
            if (r0 == r1) goto L_0x02f0
            r1 = 42
            if (r0 == r1) goto L_0x02eb
            switch(r0) {
                case 1: goto L_0x02e8;
                case 2: goto L_0x02e5;
                case 3: goto L_0x02e2;
                case 4: goto L_0x02df;
                case 5: goto L_0x02dc;
                case 6: goto L_0x02d9;
                default: goto L_0x02d6;
            }     // Catch:{ NumberFormatException -> 0x0319 }
        L_0x02d6:
            r0 = -1
            r1 = -1
            goto L_0x0308
        L_0x02d9:
            r0 = -1
            r1 = 6
            goto L_0x0308
        L_0x02dc:
            r0 = -1
            r1 = 5
            goto L_0x0308
        L_0x02df:
            r0 = -1
            r1 = 4
            goto L_0x0308
        L_0x02e2:
            r0 = -1
            r1 = 3
            goto L_0x0308
        L_0x02e5:
            r0 = -1
            r1 = 2
            goto L_0x0308
        L_0x02e8:
            r0 = -1
            r1 = 1
            goto L_0x0308
        L_0x02eb:
            r0 = 42
            r1 = 42
            goto L_0x0307
        L_0x02f0:
            r0 = 39
            r1 = 39
            goto L_0x0307
        L_0x02f5:
            r0 = 29
            r1 = 29
            goto L_0x0307
        L_0x02fa:
            r0 = 23
            r1 = 23
            goto L_0x0307
        L_0x02ff:
            r0 = -1
            r1 = 20
            goto L_0x0308
        L_0x0303:
            r0 = 17
            r1 = 17
        L_0x0307:
            r0 = -1
        L_0x0308:
            if (r1 == r0) goto L_0x0333
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x0319 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0319 }
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x0319 }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x0319 }
            goto L_0x0334
        L_0x0319:
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed MP4A codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x032b
            java.lang.String r15 = r0.concat(r15)
            goto L_0x0330
        L_0x032b:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x0330:
            android.util.Log.w(r13, r15)
        L_0x0333:
            r0 = 0
        L_0x0334:
            return r0
        L_0x0335:
            java.lang.String r1 = r15.zzi
            com.google.android.gms.internal.ads.zzall r15 = r15.zzx
            int r2 = r0.length
            if (r2 >= r11) goto L_0x0357
            java.lang.String r15 = java.lang.String.valueOf(r1)
            java.lang.String r0 = "Ignoring malformed AV1 codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x034d
            java.lang.String r15 = r0.concat(r15)
            goto L_0x0352
        L_0x034d:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x0352:
            android.util.Log.w(r13, r15)
            goto L_0x0416
        L_0x0357:
            r2 = r0[r14]     // Catch:{ NumberFormatException -> 0x03fc }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x03fc }
            r4 = r0[r12]     // Catch:{ NumberFormatException -> 0x03fc }
            r5 = 0
            java.lang.String r4 = r4.substring(r5, r12)     // Catch:{ NumberFormatException -> 0x03fc }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x03fc }
            r5 = 3
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x03fc }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x03fc }
            if (r2 == 0) goto L_0x0378
            java.lang.String r15 = "Unknown AV1 profile: "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r7, r15, r2, r13)
            goto L_0x0416
        L_0x0378:
            if (r0 == r9) goto L_0x039a
            r1 = 10
            if (r0 == r1) goto L_0x0387
            r15 = 34
            java.lang.String r1 = "Unknown AV1 bit depth: "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r15, r1, r0, r13)
            goto L_0x0416
        L_0x0387:
            if (r15 == 0) goto L_0x0398
            byte[] r0 = r15.zzd
            if (r0 != 0) goto L_0x0395
            int r15 = r15.zzc
            r0 = 7
            if (r15 == r0) goto L_0x0395
            r0 = 6
            if (r15 != r0) goto L_0x0398
        L_0x0395:
            r15 = 4096(0x1000, float:5.74E-42)
            goto L_0x039b
        L_0x0398:
            r15 = 2
            goto L_0x039b
        L_0x039a:
            r15 = 1
        L_0x039b:
            switch(r4) {
                case 0: goto L_0x03e4;
                case 1: goto L_0x03e2;
                case 2: goto L_0x03e0;
                case 3: goto L_0x03dd;
                case 4: goto L_0x03da;
                case 5: goto L_0x03d7;
                case 6: goto L_0x03d4;
                case 7: goto L_0x03d1;
                case 8: goto L_0x03ce;
                case 9: goto L_0x03cb;
                case 10: goto L_0x03c8;
                case 11: goto L_0x03c5;
                case 12: goto L_0x03c2;
                case 13: goto L_0x03bf;
                case 14: goto L_0x03bc;
                case 15: goto L_0x03b8;
                case 16: goto L_0x03b5;
                case 17: goto L_0x03b2;
                case 18: goto L_0x03af;
                case 19: goto L_0x03ac;
                case 20: goto L_0x03a9;
                case 21: goto L_0x03a6;
                case 22: goto L_0x03a3;
                case 23: goto L_0x03a0;
                default: goto L_0x039e;
            }
        L_0x039e:
            r0 = -1
            goto L_0x03e5
        L_0x03a0:
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x03e5
        L_0x03a3:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x03e5
        L_0x03a6:
            r0 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x03e5
        L_0x03a9:
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x03e5
        L_0x03ac:
            r0 = 524288(0x80000, float:7.34684E-40)
            goto L_0x03e5
        L_0x03af:
            r0 = 262144(0x40000, float:3.67342E-40)
            goto L_0x03e5
        L_0x03b2:
            r0 = 131072(0x20000, float:1.83671E-40)
            goto L_0x03e5
        L_0x03b5:
            r0 = 65536(0x10000, float:9.18355E-41)
            goto L_0x03e5
        L_0x03b8:
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L_0x03e5
        L_0x03bc:
            r0 = 16384(0x4000, float:2.2959E-41)
            goto L_0x03e5
        L_0x03bf:
            r0 = 8192(0x2000, float:1.14794E-41)
            goto L_0x03e5
        L_0x03c2:
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x03e5
        L_0x03c5:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x03e5
        L_0x03c8:
            r0 = 1024(0x400, float:1.435E-42)
            goto L_0x03e5
        L_0x03cb:
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x03e5
        L_0x03ce:
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x03e5
        L_0x03d1:
            r0 = 128(0x80, float:1.794E-43)
            goto L_0x03e5
        L_0x03d4:
            r0 = 64
            goto L_0x03e5
        L_0x03d7:
            r0 = 32
            goto L_0x03e5
        L_0x03da:
            r0 = 16
            goto L_0x03e5
        L_0x03dd:
            r0 = 8
            goto L_0x03e5
        L_0x03e0:
            r0 = 4
            goto L_0x03e5
        L_0x03e2:
            r0 = 2
            goto L_0x03e5
        L_0x03e4:
            r0 = 1
        L_0x03e5:
            r1 = -1
            if (r0 != r1) goto L_0x03ee
            java.lang.String r15 = "Unknown AV1 level: "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r3, r15, r4, r13)
            goto L_0x0416
        L_0x03ee:
            android.util.Pair r1 = new android.util.Pair
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.<init>(r15, r0)
            goto L_0x0417
        L_0x03fc:
            java.lang.String r15 = java.lang.String.valueOf(r1)
            java.lang.String r0 = "Ignoring malformed AV1 codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x040e
            java.lang.String r15 = r0.concat(r15)
            goto L_0x0413
        L_0x040e:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x0413:
            android.util.Log.w(r13, r15)
        L_0x0416:
            r1 = 0
        L_0x0417:
            return r1
        L_0x0418:
            java.lang.String r15 = r15.zzi
            int r1 = r0.length
            if (r1 >= r11) goto L_0x0438
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed HEVC codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x042e
            java.lang.String r15 = r0.concat(r15)
            goto L_0x0433
        L_0x042e:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x0433:
            android.util.Log.w(r13, r15)
            goto L_0x06a6
        L_0x0438:
            java.util.regex.Pattern r1 = zzb
            r3 = r0[r14]
            java.util.regex.Matcher r1 = r1.matcher(r3)
            boolean r3 = r1.matches()
            if (r3 != 0) goto L_0x0461
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed HEVC codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x0457
            java.lang.String r15 = r0.concat(r15)
            goto L_0x045c
        L_0x0457:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x045c:
            android.util.Log.w(r13, r15)
            goto L_0x06a6
        L_0x0461:
            java.lang.String r15 = r1.group(r14)
            java.lang.String r1 = "1"
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x046f
            r15 = 1
            goto L_0x0478
        L_0x046f:
            java.lang.String r1 = "2"
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x068d
            r15 = 2
        L_0x0478:
            r1 = 3
            r0 = r0[r1]
            if (r0 != 0) goto L_0x047f
            goto L_0x0666
        L_0x047f:
            int r1 = r0.hashCode()
            switch(r1) {
                case 70821: goto L_0x05a3;
                case 70914: goto L_0x0598;
                case 70917: goto L_0x058d;
                case 71007: goto L_0x0582;
                case 71010: goto L_0x0577;
                case 74665: goto L_0x056d;
                case 74758: goto L_0x0563;
                case 74761: goto L_0x0559;
                case 74851: goto L_0x054f;
                case 74854: goto L_0x0545;
                case 2193639: goto L_0x0539;
                case 2193642: goto L_0x052d;
                case 2193732: goto L_0x0521;
                case 2193735: goto L_0x0515;
                case 2193738: goto L_0x0509;
                case 2193825: goto L_0x04fd;
                case 2193828: goto L_0x04f1;
                case 2193831: goto L_0x04e5;
                case 2312803: goto L_0x04da;
                case 2312806: goto L_0x04cf;
                case 2312896: goto L_0x04c4;
                case 2312899: goto L_0x04b8;
                case 2312902: goto L_0x04ac;
                case 2312989: goto L_0x04a0;
                case 2312992: goto L_0x0494;
                case 2312995: goto L_0x0488;
                default: goto L_0x0486;
            }
        L_0x0486:
            goto L_0x05ae
        L_0x0488:
            java.lang.String r1 = "L186"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 12
            goto L_0x05af
        L_0x0494:
            java.lang.String r1 = "L183"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 11
            goto L_0x05af
        L_0x04a0:
            java.lang.String r1 = "L180"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 10
            goto L_0x05af
        L_0x04ac:
            java.lang.String r1 = "L156"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 9
            goto L_0x05af
        L_0x04b8:
            java.lang.String r1 = "L153"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 8
            goto L_0x05af
        L_0x04c4:
            java.lang.String r1 = "L150"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 7
            goto L_0x05af
        L_0x04cf:
            java.lang.String r1 = "L123"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 6
            goto L_0x05af
        L_0x04da:
            java.lang.String r1 = "L120"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 5
            goto L_0x05af
        L_0x04e5:
            java.lang.String r1 = "H186"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 25
            goto L_0x05af
        L_0x04f1:
            java.lang.String r1 = "H183"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 24
            goto L_0x05af
        L_0x04fd:
            java.lang.String r1 = "H180"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 23
            goto L_0x05af
        L_0x0509:
            java.lang.String r1 = "H156"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 22
            goto L_0x05af
        L_0x0515:
            java.lang.String r1 = "H153"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 21
            goto L_0x05af
        L_0x0521:
            java.lang.String r1 = "H150"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 20
            goto L_0x05af
        L_0x052d:
            java.lang.String r1 = "H123"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 19
            goto L_0x05af
        L_0x0539:
            java.lang.String r1 = "H120"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 18
            goto L_0x05af
        L_0x0545:
            java.lang.String r1 = "L93"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 4
            goto L_0x05af
        L_0x054f:
            java.lang.String r1 = "L90"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 3
            goto L_0x05af
        L_0x0559:
            java.lang.String r1 = "L63"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 2
            goto L_0x05af
        L_0x0563:
            java.lang.String r1 = "L60"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 1
            goto L_0x05af
        L_0x056d:
            java.lang.String r1 = "L30"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 0
            goto L_0x05af
        L_0x0577:
            java.lang.String r1 = "H93"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 17
            goto L_0x05af
        L_0x0582:
            java.lang.String r1 = "H90"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 16
            goto L_0x05af
        L_0x058d:
            java.lang.String r1 = "H63"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 15
            goto L_0x05af
        L_0x0598:
            java.lang.String r1 = "H60"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 14
            goto L_0x05af
        L_0x05a3:
            java.lang.String r1 = "H30"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x05ae
            r1 = 13
            goto L_0x05af
        L_0x05ae:
            r1 = -1
        L_0x05af:
            switch(r1) {
                case 0: goto L_0x0661;
                case 1: goto L_0x065c;
                case 2: goto L_0x0655;
                case 3: goto L_0x064e;
                case 4: goto L_0x0647;
                case 5: goto L_0x0640;
                case 6: goto L_0x063b;
                case 7: goto L_0x0634;
                case 8: goto L_0x062d;
                case 9: goto L_0x0626;
                case 10: goto L_0x061f;
                case 11: goto L_0x0618;
                case 12: goto L_0x0611;
                case 13: goto L_0x060c;
                case 14: goto L_0x0607;
                case 15: goto L_0x0601;
                case 16: goto L_0x05fb;
                case 17: goto L_0x05f5;
                case 18: goto L_0x05ed;
                case 19: goto L_0x05e5;
                case 20: goto L_0x05dc;
                case 21: goto L_0x05d4;
                case 22: goto L_0x05cc;
                case 23: goto L_0x05c4;
                case 24: goto L_0x05bc;
                case 25: goto L_0x05b4;
                default: goto L_0x05b2;
            }
        L_0x05b2:
            goto L_0x0666
        L_0x05b4:
            r1 = 33554432(0x2000000, float:9.403955E-38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x05bc:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x05c4:
            r1 = 2097152(0x200000, float:2.938736E-39)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x05cc:
            r1 = 524288(0x80000, float:7.34684E-40)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x05d4:
            r1 = 131072(0x20000, float:1.83671E-40)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x05dc:
            r1 = 32768(0x8000, float:4.5918E-41)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x05e5:
            r1 = 8192(0x2000, float:1.14794E-41)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x05ed:
            r1 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x05f5:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            goto L_0x0667
        L_0x05fb:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0667
        L_0x0601:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            goto L_0x0667
        L_0x0607:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            goto L_0x0667
        L_0x060c:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            goto L_0x0667
        L_0x0611:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x0618:
            r1 = 4194304(0x400000, float:5.877472E-39)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x061f:
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x0626:
            r1 = 262144(0x40000, float:3.67342E-40)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x062d:
            r1 = 65536(0x10000, float:9.18355E-41)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x0634:
            r1 = 16384(0x4000, float:2.2959E-41)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x063b:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            goto L_0x0667
        L_0x0640:
            r1 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x0647:
            r1 = 256(0x100, float:3.59E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x064e:
            r1 = 64
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x0655:
            r1 = 16
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0667
        L_0x065c:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x0667
        L_0x0661:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            goto L_0x0667
        L_0x0666:
            r1 = 0
        L_0x0667:
            if (r1 != 0) goto L_0x0683
            java.lang.String r15 = java.lang.String.valueOf(r0)
            java.lang.String r0 = "Unknown HEVC level string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x067a
            java.lang.String r15 = r0.concat(r15)
            goto L_0x067f
        L_0x067a:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x067f:
            android.util.Log.w(r13, r15)
            goto L_0x06a6
        L_0x0683:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r0.<init>(r15, r1)
            goto L_0x06a7
        L_0x068d:
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Unknown HEVC profile string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x069e
            java.lang.String r15 = r0.concat(r15)
            goto L_0x06a3
        L_0x069e:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x06a3:
            android.util.Log.w(r13, r15)
        L_0x06a6:
            r0 = 0
        L_0x06a7:
            return r0
        L_0x06a8:
            java.lang.String r15 = r15.zzi
            int r1 = r0.length
            r2 = 3
            if (r1 >= r2) goto L_0x06c9
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed VP9 codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x06bf
            java.lang.String r15 = r0.concat(r15)
            goto L_0x06c4
        L_0x06bf:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x06c4:
            android.util.Log.w(r13, r15)
            goto L_0x077b
        L_0x06c9:
            r1 = r0[r14]     // Catch:{ NumberFormatException -> 0x0761 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0761 }
            r0 = r0[r12]     // Catch:{ NumberFormatException -> 0x0761 }
            int r15 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0761 }
            if (r1 == 0) goto L_0x06e7
            if (r1 == r14) goto L_0x06e5
            if (r1 == r12) goto L_0x06e3
            r0 = 3
            if (r1 == r0) goto L_0x06e0
            r0 = -1
            goto L_0x06e8
        L_0x06e0:
            r0 = 8
            goto L_0x06e8
        L_0x06e3:
            r0 = 4
            goto L_0x06e8
        L_0x06e5:
            r0 = 2
            goto L_0x06e8
        L_0x06e7:
            r0 = 1
        L_0x06e8:
            r2 = -1
            if (r0 != r2) goto L_0x06f2
            java.lang.String r15 = "Unknown VP9 profile: "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r7, r15, r1, r13)
            goto L_0x077b
        L_0x06f2:
            r1 = 10
            if (r15 == r1) goto L_0x0749
            r1 = 11
            if (r15 == r1) goto L_0x0746
            if (r15 == r5) goto L_0x0743
            r1 = 21
            if (r15 == r1) goto L_0x073f
            if (r15 == r3) goto L_0x073b
            r1 = 31
            if (r15 == r1) goto L_0x0737
            r1 = 40
            if (r15 == r1) goto L_0x0733
            r1 = 41
            if (r15 == r1) goto L_0x072f
            r1 = 50
            if (r15 == r1) goto L_0x072b
            r1 = 51
            if (r15 == r1) goto L_0x0727
            switch(r15) {
                case 60: goto L_0x0723;
                case 61: goto L_0x071f;
                case 62: goto L_0x071c;
                default: goto L_0x0719;
            }
        L_0x0719:
            r1 = -1
            r2 = -1
            goto L_0x074b
        L_0x071c:
            r14 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0749
        L_0x071f:
            r1 = -1
            r2 = 4096(0x1000, float:5.74E-42)
            goto L_0x074b
        L_0x0723:
            r1 = -1
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x074b
        L_0x0727:
            r1 = -1
            r2 = 512(0x200, float:7.175E-43)
            goto L_0x074b
        L_0x072b:
            r1 = -1
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x074b
        L_0x072f:
            r1 = -1
            r2 = 128(0x80, float:1.794E-43)
            goto L_0x074b
        L_0x0733:
            r1 = -1
            r2 = 64
            goto L_0x074b
        L_0x0737:
            r1 = -1
            r2 = 32
            goto L_0x074b
        L_0x073b:
            r1 = -1
            r2 = 16
            goto L_0x074b
        L_0x073f:
            r1 = -1
            r2 = 8
            goto L_0x074b
        L_0x0743:
            r1 = -1
            r2 = 4
            goto L_0x074b
        L_0x0746:
            r1 = -1
            r2 = 2
            goto L_0x074b
        L_0x0749:
            r1 = -1
            r2 = r14
        L_0x074b:
            if (r2 != r1) goto L_0x0753
            java.lang.String r0 = "Unknown VP9 level: "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r3, r0, r15, r13)
            goto L_0x077b
        L_0x0753:
            android.util.Pair r15 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r15.<init>(r0, r1)
            goto L_0x077c
        L_0x0761:
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed VP9 codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x0773
            java.lang.String r15 = r0.concat(r15)
            goto L_0x0778
        L_0x0773:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x0778:
            android.util.Log.w(r13, r15)
        L_0x077b:
            r15 = 0
        L_0x077c:
            return r15
        L_0x077d:
            java.lang.String r15 = r15.zzi
            int r1 = r0.length
            if (r1 >= r12) goto L_0x079d
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed AVC codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x0793
            java.lang.String r15 = r0.concat(r15)
            goto L_0x0798
        L_0x0793:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x0798:
            android.util.Log.w(r13, r15)
            goto L_0x0897
        L_0x079d:
            r2 = r0[r14]     // Catch:{ NumberFormatException -> 0x087d }
            int r2 = r2.length()     // Catch:{ NumberFormatException -> 0x087d }
            r4 = 6
            if (r2 != r4) goto L_0x07be
            r1 = r0[r14]     // Catch:{ NumberFormatException -> 0x087d }
            r2 = 0
            java.lang.String r1 = r1.substring(r2, r12)     // Catch:{ NumberFormatException -> 0x087d }
            r2 = 16
            int r1 = java.lang.Integer.parseInt(r1, r2)     // Catch:{ NumberFormatException -> 0x087d }
            r0 = r0[r14]     // Catch:{ NumberFormatException -> 0x087d }
            java.lang.String r0 = r0.substring(r11)     // Catch:{ NumberFormatException -> 0x087d }
            int r15 = java.lang.Integer.parseInt(r0, r2)     // Catch:{ NumberFormatException -> 0x087d }
            goto L_0x07cd
        L_0x07be:
            r2 = 3
            if (r1 < r2) goto L_0x0862
            r1 = r0[r14]     // Catch:{ NumberFormatException -> 0x087d }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x087d }
            r0 = r0[r12]     // Catch:{ NumberFormatException -> 0x087d }
            int r15 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x087d }
        L_0x07cd:
            r0 = 66
            if (r1 == r0) goto L_0x0801
            r0 = 77
            if (r1 == r0) goto L_0x07ff
            r0 = 88
            if (r1 == r0) goto L_0x07fc
            r0 = 100
            if (r1 == r0) goto L_0x07f8
            r0 = 110(0x6e, float:1.54E-43)
            if (r1 == r0) goto L_0x07f4
            r0 = 122(0x7a, float:1.71E-43)
            if (r1 == r0) goto L_0x07f0
            r0 = 244(0xf4, float:3.42E-43)
            if (r1 == r0) goto L_0x07ec
            r0 = -1
            r12 = -1
            goto L_0x0803
        L_0x07ec:
            r0 = -1
            r12 = 64
            goto L_0x0803
        L_0x07f0:
            r0 = -1
            r12 = 32
            goto L_0x0803
        L_0x07f4:
            r0 = -1
            r12 = 16
            goto L_0x0803
        L_0x07f8:
            r0 = -1
            r12 = 8
            goto L_0x0803
        L_0x07fc:
            r0 = -1
            r12 = 4
            goto L_0x0803
        L_0x07ff:
            r0 = -1
            goto L_0x0803
        L_0x0801:
            r0 = -1
            r12 = 1
        L_0x0803:
            if (r12 != r0) goto L_0x080c
            java.lang.String r15 = "Unknown AVC profile: "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r7, r15, r1, r13)
            goto L_0x0897
        L_0x080c:
            switch(r15) {
                case 10: goto L_0x0825;
                case 11: goto L_0x0823;
                case 12: goto L_0x0820;
                case 13: goto L_0x081d;
                default: goto L_0x080f;
            }
        L_0x080f:
            switch(r15) {
                case 20: goto L_0x082d;
                case 21: goto L_0x082a;
                case 22: goto L_0x0827;
                default: goto L_0x0812;
            }
        L_0x0812:
            switch(r15) {
                case 30: goto L_0x0836;
                case 31: goto L_0x0833;
                case 32: goto L_0x0830;
                default: goto L_0x0815;
            }
        L_0x0815:
            switch(r15) {
                case 40: goto L_0x083f;
                case 41: goto L_0x083c;
                case 42: goto L_0x0839;
                default: goto L_0x0818;
            }
        L_0x0818:
            switch(r15) {
                case 50: goto L_0x0849;
                case 51: goto L_0x0845;
                case 52: goto L_0x0842;
                default: goto L_0x081b;
            }
        L_0x081b:
            r0 = -1
            goto L_0x084b
        L_0x081d:
            r0 = 16
            goto L_0x084b
        L_0x0820:
            r0 = 8
            goto L_0x084b
        L_0x0823:
            r0 = 4
            goto L_0x084b
        L_0x0825:
            r0 = 1
            goto L_0x084b
        L_0x0827:
            r0 = 128(0x80, float:1.794E-43)
            goto L_0x084b
        L_0x082a:
            r0 = 64
            goto L_0x084b
        L_0x082d:
            r0 = 32
            goto L_0x084b
        L_0x0830:
            r0 = 1024(0x400, float:1.435E-42)
            goto L_0x084b
        L_0x0833:
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x084b
        L_0x0836:
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x084b
        L_0x0839:
            r0 = 8192(0x2000, float:1.14794E-41)
            goto L_0x084b
        L_0x083c:
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x084b
        L_0x083f:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x084b
        L_0x0842:
            r0 = 65536(0x10000, float:9.18355E-41)
            goto L_0x084b
        L_0x0845:
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L_0x084b
        L_0x0849:
            r0 = 16384(0x4000, float:2.2959E-41)
        L_0x084b:
            r1 = -1
            if (r0 != r1) goto L_0x0854
            java.lang.String r0 = "Unknown AVC level: "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r3, r0, r15, r13)
            goto L_0x0897
        L_0x0854:
            android.util.Pair r15 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r15.<init>(r1, r0)
            goto L_0x0898
        L_0x0862:
            java.lang.String r0 = "Ignoring malformed AVC codec string: "
            java.lang.String r1 = java.lang.String.valueOf(r15)     // Catch:{ NumberFormatException -> 0x087d }
            int r2 = r1.length()     // Catch:{ NumberFormatException -> 0x087d }
            if (r2 == 0) goto L_0x0873
            java.lang.String r0 = r0.concat(r1)     // Catch:{ NumberFormatException -> 0x087d }
            goto L_0x0879
        L_0x0873:
            java.lang.String r1 = new java.lang.String     // Catch:{ NumberFormatException -> 0x087d }
            r1.<init>(r0)     // Catch:{ NumberFormatException -> 0x087d }
            r0 = r1
        L_0x0879:
            android.util.Log.w(r13, r0)     // Catch:{ NumberFormatException -> 0x087d }
            goto L_0x0897
        L_0x087d:
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r0 = "Ignoring malformed AVC codec string: "
            int r1 = r15.length()
            if (r1 == 0) goto L_0x088f
            java.lang.String r15 = r0.concat(r15)
            goto L_0x0894
        L_0x088f:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x0894:
            android.util.Log.w(r13, r15)
        L_0x0897:
            r15 = 0
        L_0x0898:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaax.zzf(com.google.android.gms.internal.ads.zzkc):android.util.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01d1, code lost:
        if ("SCV31".equals(com.google.android.gms.internal.ads.zzalh.zzb) == false) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0219, code lost:
        if (com.google.android.gms.internal.ads.zzalh.zzb.startsWith("t0") != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (r12.endsWith(".secure") == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0179, code lost:
        if ("OMX.Exynos.AAC.Decoder".equals(r12) == false) goto L_0x01d3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0371 A[SYNTHETIC, Splitter:B:217:0x0371] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x039d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzaah> zzg(com.google.android.gms.internal.ads.zzaar r23, com.google.android.gms.internal.ads.zzaat r24) throws com.google.android.gms.internal.ads.zzaas {
        /*
            r1 = r23
            r2 = r24
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x03da }
            r6.<init>()     // Catch:{ Exception -> 0x03da }
            java.lang.String r15 = r1.zza     // Catch:{ Exception -> 0x03da }
            int r14 = r24.zza()     // Catch:{ Exception -> 0x03da }
            boolean r16 = r24.zzc()     // Catch:{ Exception -> 0x03da }
            r17 = 0
            r13 = 0
        L_0x001a:
            if (r13 >= r14) goto L_0x03d9
            android.media.MediaCodecInfo r0 = r2.zzb(r13)     // Catch:{ Exception -> 0x03da }
            int r7 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x03da }
            r8 = 29
            if (r7 < r8) goto L_0x0033
            boolean r7 = r0.isAlias()     // Catch:{ Exception -> 0x03da }
            if (r7 == 0) goto L_0x0033
        L_0x002c:
            r21 = r13
            r22 = r14
            r2 = r15
            goto L_0x03d0
        L_0x0033:
            java.lang.String r12 = r0.getName()     // Catch:{ Exception -> 0x03da }
            boolean r7 = r0.isEncoder()     // Catch:{ Exception -> 0x03da }
            if (r7 != 0) goto L_0x002c
            java.lang.String r7 = ".secure"
            if (r16 != 0) goto L_0x0047
            boolean r9 = r12.endsWith(r7)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
        L_0x0047:
            int r9 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x03da }
            r10 = 21
            if (r9 >= r10) goto L_0x007d
            java.lang.String r9 = "CIPAACDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "CIPMP3Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "CIPVorbisDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "CIPAMRNBDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "AACDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "MP3Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
        L_0x007d:
            int r9 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x03da }
            r10 = 18
            if (r9 >= r10) goto L_0x00a9
            java.lang.String r9 = "OMX.MTK.AUDIO.DECODER.AAC"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 == 0) goto L_0x00a9
            java.lang.String r9 = "a70"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "Xiaomi"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzc     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 == 0) goto L_0x00a9
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            java.lang.String r10 = "HM"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
        L_0x00a9:
            int r9 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x03da }
            r10 = 16
            if (r9 != r10) goto L_0x012f
            java.lang.String r9 = "OMX.qcom.audio.decoder.mp3"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 == 0) goto L_0x012f
            java.lang.String r9 = "dlxu"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "protou"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "ville"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "villeplus"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "villec2"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            java.lang.String r11 = "gee"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "C6602"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "C6603"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "C6606"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "C6616"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "L36h"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "SO-02E"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
        L_0x012f:
            int r9 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x03da }
            if (r9 != r10) goto L_0x0163
            java.lang.String r9 = "OMX.qcom.audio.decoder.aac"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 == 0) goto L_0x0163
            java.lang.String r9 = "C1504"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "C1505"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "C1604"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "C1605"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
        L_0x0163:
            int r9 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x03da }
            r10 = 24
            java.lang.String r11 = "samsung"
            if (r9 >= r10) goto L_0x01d3
            java.lang.String r9 = "OMX.SEC.aac.dec"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x017b
            java.lang.String r9 = "OMX.Exynos.AAC.Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 == 0) goto L_0x01d3
        L_0x017b:
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzc     // Catch:{ Exception -> 0x03da }
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x03da }
            if (r9 == 0) goto L_0x01d3
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            java.lang.String r10 = "zeroflte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            java.lang.String r10 = "zerolte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            java.lang.String r10 = "zenlte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "SC-05G"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "marinelteatt"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "404SC"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "SC-04G"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "SCV31"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
        L_0x01d3:
            int r9 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x03da }
            java.lang.String r10 = "jflte"
            r5 = 19
            if (r9 > r5) goto L_0x021b
            java.lang.String r9 = "OMX.SEC.vp8.dec"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r9 == 0) goto L_0x021b
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzc     // Catch:{ Exception -> 0x03da }
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x03da }
            if (r9 == 0) goto L_0x021b
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            java.lang.String r11 = "d2"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            java.lang.String r11 = "serrano"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            java.lang.String r11 = "santos"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            java.lang.String r11 = "t0"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x03da }
            if (r9 != 0) goto L_0x002c
        L_0x021b:
            int r9 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x03da }
            if (r9 > r5) goto L_0x022f
            java.lang.String r5 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x03da }
            boolean r5 = r5.startsWith(r10)     // Catch:{ Exception -> 0x03da }
            if (r5 == 0) goto L_0x022f
            java.lang.String r5 = "OMX.qcom.video.decoder.vp8"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r5 != 0) goto L_0x002c
        L_0x022f:
            java.lang.String r5 = "audio/eac3-joc"
            boolean r5 = r5.equals(r15)     // Catch:{ Exception -> 0x03da }
            if (r5 == 0) goto L_0x023f
            java.lang.String r5 = "OMX.MTK.AUDIO.DECODER.DSPAC3"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r5 != 0) goto L_0x002c
        L_0x023f:
            java.lang.String[] r5 = r0.getSupportedTypes()     // Catch:{ Exception -> 0x03da }
            int r9 = r5.length     // Catch:{ Exception -> 0x03da }
            r10 = 0
        L_0x0245:
            if (r10 >= r9) goto L_0x0254
            r11 = r5[r10]     // Catch:{ Exception -> 0x03da }
            boolean r18 = r11.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x03da }
            if (r18 == 0) goto L_0x0251
        L_0x024f:
            r5 = r11
            goto L_0x02a1
        L_0x0251:
            int r10 = r10 + 1
            goto L_0x0245
        L_0x0254:
            java.lang.String r5 = "video/dolby-vision"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x03da }
            if (r5 == 0) goto L_0x027a
            java.lang.String r5 = "OMX.MS.HEVCDV.Decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r5 == 0) goto L_0x0267
            java.lang.String r11 = "video/hevcdv"
            goto L_0x024f
        L_0x0267:
            java.lang.String r5 = "OMX.RTK.video.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r5 != 0) goto L_0x0277
            java.lang.String r5 = "OMX.realtek.video.decoder.tunneled"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r5 == 0) goto L_0x02a0
        L_0x0277:
            java.lang.String r11 = "video/dv_hevc"
            goto L_0x024f
        L_0x027a:
            java.lang.String r5 = "audio/alac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x03da }
            if (r5 == 0) goto L_0x028d
            java.lang.String r5 = "OMX.lge.alac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r5 == 0) goto L_0x028d
            java.lang.String r11 = "audio/x-lg-alac"
            goto L_0x024f
        L_0x028d:
            java.lang.String r5 = "audio/flac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x03da }
            if (r5 == 0) goto L_0x02a0
            java.lang.String r5 = "OMX.lge.flac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x03da }
            if (r5 == 0) goto L_0x02a0
            java.lang.String r11 = "audio/x-lg-flac"
            goto L_0x024f
        L_0x02a0:
            r5 = 0
        L_0x02a1:
            if (r5 == 0) goto L_0x002c
            android.media.MediaCodecInfo$CodecCapabilities r10 = r0.getCapabilitiesForType(r5)     // Catch:{ Exception -> 0x0361 }
            boolean r9 = r2.zzd(r4, r5, r10)     // Catch:{ Exception -> 0x0361 }
            boolean r11 = r2.zze(r4, r5, r10)     // Catch:{ Exception -> 0x0361 }
            boolean r8 = r1.zzc     // Catch:{ Exception -> 0x0361 }
            if (r8 != 0) goto L_0x02b6
            if (r11 != 0) goto L_0x002c
            goto L_0x02ba
        L_0x02b6:
            if (r9 != 0) goto L_0x02ba
            goto L_0x002c
        L_0x02ba:
            boolean r8 = r2.zzd(r3, r5, r10)     // Catch:{ Exception -> 0x0361 }
            boolean r9 = r2.zze(r3, r5, r10)     // Catch:{ Exception -> 0x0361 }
            boolean r11 = r1.zzb     // Catch:{ Exception -> 0x0361 }
            r19 = 1
            if (r11 != 0) goto L_0x02cb
            if (r9 != 0) goto L_0x002c
            goto L_0x02ce
        L_0x02cb:
            if (r8 == 0) goto L_0x002c
            r8 = 1
        L_0x02ce:
            int r9 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0361 }
            r11 = 29
            if (r9 < r11) goto L_0x02da
            boolean r9 = r0.isHardwareAccelerated()     // Catch:{ Exception -> 0x0361 }
            r11 = r9
            goto L_0x02e3
        L_0x02da:
            boolean r9 = zzh(r0)     // Catch:{ Exception -> 0x0361 }
            if (r9 != 0) goto L_0x02e2
            r11 = 1
            goto L_0x02e3
        L_0x02e2:
            r11 = 0
        L_0x02e3:
            boolean r20 = zzh(r0)     // Catch:{ Exception -> 0x0361 }
            int r9 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0361 }
            r2 = 29
            if (r9 < r2) goto L_0x02f2
            boolean r0 = r0.isVendor()     // Catch:{ Exception -> 0x0361 }
            goto L_0x0315
        L_0x02f2:
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x0361 }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfjm.zza(r0)     // Catch:{ Exception -> 0x0361 }
            java.lang.String r2 = "omx.google."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x0361 }
            if (r2 != 0) goto L_0x0314
            java.lang.String r2 = "c2.android."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x0361 }
            if (r2 != 0) goto L_0x0314
            java.lang.String r2 = "c2.google."
            boolean r0 = r0.startsWith(r2)     // Catch:{ Exception -> 0x0361 }
            if (r0 != 0) goto L_0x0314
            r0 = 1
            goto L_0x0315
        L_0x0314:
            r0 = 0
        L_0x0315:
            if (r16 == 0) goto L_0x031b
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x0361 }
            if (r2 == r8) goto L_0x0321
        L_0x031b:
            if (r16 != 0) goto L_0x033f
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x0361 }
            if (r2 != 0) goto L_0x033f
        L_0x0321:
            r2 = 0
            r18 = 0
            r7 = r12
            r8 = r15
            r9 = r5
            r19 = r12
            r12 = r20
            r21 = r13
            r13 = r0
            r22 = r14
            r14 = r2
            r2 = r15
            r15 = r18
            com.google.android.gms.internal.ads.zzaah r0 = com.google.android.gms.internal.ads.zzaah.zza(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x033d }
            r6.add(r0)     // Catch:{ Exception -> 0x033d }
            goto L_0x03d0
        L_0x033d:
            r0 = move-exception
            goto L_0x0369
        L_0x033f:
            r19 = r12
            r21 = r13
            r22 = r14
            r2 = r15
            if (r16 != 0) goto L_0x03d0
            if (r8 == 0) goto L_0x03d0
            java.lang.String r8 = java.lang.String.valueOf(r19)     // Catch:{ Exception -> 0x033d }
            java.lang.String r7 = r8.concat(r7)     // Catch:{ Exception -> 0x033d }
            r14 = 0
            r15 = 1
            r8 = r2
            r9 = r5
            r12 = r20
            r13 = r0
            com.google.android.gms.internal.ads.zzaah r0 = com.google.android.gms.internal.ads.zzaah.zza(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x033d }
            r6.add(r0)     // Catch:{ Exception -> 0x033d }
            return r6
        L_0x0361:
            r0 = move-exception
            r19 = r12
            r21 = r13
            r22 = r14
            r2 = r15
        L_0x0369:
            int r7 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x03da }
            r8 = 23
            java.lang.String r9 = "MediaCodecUtil"
            if (r7 > r8) goto L_0x039d
            boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x03da }
            if (r7 != 0) goto L_0x039d
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch:{ Exception -> 0x03da }
            int r0 = r0.length()     // Catch:{ Exception -> 0x03da }
            int r0 = r0 + 46
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03da }
            r5.<init>(r0)     // Catch:{ Exception -> 0x03da }
            java.lang.String r0 = "Skipping codec "
            r5.append(r0)     // Catch:{ Exception -> 0x03da }
            r7 = r19
            r5.append(r7)     // Catch:{ Exception -> 0x03da }
            java.lang.String r0 = " (failed to query capabilities)"
            r5.append(r0)     // Catch:{ Exception -> 0x03da }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x03da }
            android.util.Log.e(r9, r0)     // Catch:{ Exception -> 0x03da }
            goto L_0x03d0
        L_0x039d:
            r7 = r19
            java.lang.String r1 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x03da }
            int r1 = r1.length()     // Catch:{ Exception -> 0x03da }
            int r1 = r1 + 25
            int r2 = r5.length()     // Catch:{ Exception -> 0x03da }
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03da }
            r2.<init>(r1)     // Catch:{ Exception -> 0x03da }
            java.lang.String r1 = "Failed to query codec "
            r2.append(r1)     // Catch:{ Exception -> 0x03da }
            r2.append(r7)     // Catch:{ Exception -> 0x03da }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x03da }
            r2.append(r5)     // Catch:{ Exception -> 0x03da }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x03da }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x03da }
            android.util.Log.e(r9, r1)     // Catch:{ Exception -> 0x03da }
            throw r0     // Catch:{ Exception -> 0x03da }
        L_0x03d0:
            int r13 = r21 + 1
            r15 = r2
            r14 = r22
            r2 = r24
            goto L_0x001a
        L_0x03d9:
            return r6
        L_0x03da:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzaas r1 = new com.google.android.gms.internal.ads.zzaas
            r2 = 0
            r1.<init>(r0, r2)
            goto L_0x03e3
        L_0x03e2:
            throw r1
        L_0x03e3:
            goto L_0x03e2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaax.zzg(com.google.android.gms.internal.ads.zzaar, com.google.android.gms.internal.ads.zzaat):java.util.ArrayList");
    }

    public static boolean zzh(MediaCodecInfo mediaCodecInfo) {
        if (zzalh.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        String zza2 = zzfjm.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.") || ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.") || (!zza2.startsWith("omx.") && !zza2.startsWith("c2.")))) {
            return true;
        }
        return false;
    }

    public static <T> void zzi(List<T> list, zzaaw<T> zzaaw) {
        Collections.sort(list, new zzaap(zzaaw));
    }
}
