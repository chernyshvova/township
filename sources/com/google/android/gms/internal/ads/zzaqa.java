package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaqa {
    public float zzA = -1.0f;
    public float zzB = -1.0f;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public int zzG = 1;
    public int zzH = -1;
    public int zzI = 8000;
    public long zzJ = 0;
    public long zzK = 0;
    public boolean zzL;
    public boolean zzM = true;
    public zzapu zzN;
    public int zzO;
    public String zzP = "eng";
    public String zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public boolean zze;
    public byte[] zzf;
    public zzapt zzg;
    public byte[] zzh;
    public zzaph zzi;
    public int zzj = -1;
    public int zzk = -1;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = 0;
    public byte[] zzo = null;
    public int zzp = -1;
    public boolean zzq = false;
    public int zzr = -1;
    public int zzs = -1;
    public int zzt = -1;
    public int zzu = 1000;
    public int zzv = 200;
    public float zzw = -1.0f;
    public float zzx = -1.0f;
    public float zzy = -1.0f;
    public float zzz = -1.0f;

    public zzaqa() {
    }

    public /* synthetic */ zzaqa(zzapy zzapy) {
    }

    public static List<byte[]> zzc(zzaut zzaut) throws zzann {
        try {
            zzaut.zzj(16);
            if (zzaut.zzq() != 826496599) {
                return null;
            }
            int zzg2 = zzaut.zzg() + 20;
            byte[] bArr = zzaut.zza;
            while (true) {
                int length = bArr.length;
                if (zzg2 >= length - 4) {
                    throw new zzann("Failed to find FourCC VC1 initialization data");
                } else if (bArr[zzg2] == 0 && bArr[zzg2 + 1] == 0 && bArr[zzg2 + 2] == 1 && bArr[zzg2 + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, zzg2, length));
                } else {
                    zzg2++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzann("Error parsing FourCC VC1 codec private");
        }
    }

    public static List<byte[]> zzd(byte[] bArr) throws zzann {
        byte b;
        byte b2;
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (true) {
                    b = bArr[i];
                    if (b != -1) {
                        break;
                    }
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + b;
                int i5 = 0;
                while (true) {
                    b2 = bArr[i3];
                    if (b2 != -1) {
                        break;
                    }
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + b2;
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            int length = bArr.length - i9;
                            byte[] bArr3 = new byte[length];
                            System.arraycopy(bArr, i9, bArr3, 0, length);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzann("Error parsing vorbis codec private");
                    }
                    throw new zzann("Error parsing vorbis codec private");
                }
                throw new zzann("Error parsing vorbis codec private");
            }
            throw new zzann("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzann("Error parsing vorbis codec private");
        }
    }

    public static boolean zze(zzaut zzaut) throws zzann {
        try {
            int zzn2 = zzaut.zzn();
            if (zzn2 == 1) {
                return true;
            }
            if (zzn2 == 65534) {
                zzaut.zzi(24);
                return zzaut.zzs() == zzaqb.zzd.getMostSignificantBits() && zzaut.zzs() == zzaqb.zzd.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzann("Error parsing MS/ACM codec private");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01fd, code lost:
        r12 = "audio/x-unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0224, code lost:
        r1 = null;
        r27 = -1;
        r32 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02cd, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02e5, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02e7, code lost:
        r27 = -1;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02e9, code lost:
        r32 = -1;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02eb, code lost:
        r2 = r0.zzM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02ef, code lost:
        if (true == r0.zzL) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02f1, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02f3, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02f4, code lost:
        r2 = r2 | r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02f9, code lost:
        if (com.google.android.gms.internal.ads.zzauq.zza(r12) == false) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02fb, code lost:
        r1 = com.google.android.gms.internal.ads.zzank.zzc(java.lang.Integer.toString(r45), r12, (java.lang.String) null, -1, r32, r0.zzG, r0.zzI, r27, -1, -1, r1, r0.zzi, r2 ? 1 : 0, r0.zzP, (com.google.android.gms.internal.ads.zzarq) null);
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x032c, code lost:
        if (com.google.android.gms.internal.ads.zzauq.zzb(r12) == false) goto L_0x0459;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0330, code lost:
        if (r0.zzn != 0) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0332, code lost:
        r2 = r0.zzl;
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0335, code lost:
        if (r2 != -1) goto L_0x0339;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0337, code lost:
        r2 = r0.zzj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0339, code lost:
        r0.zzl = r2;
        r2 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x033d, code lost:
        if (r2 != -1) goto L_0x0341;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x033f, code lost:
        r2 = r0.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0341, code lost:
        r0.zzm = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0344, code lost:
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0345, code lost:
        r2 = r0.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0349, code lost:
        if (r2 == r3) goto L_0x035d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x034b, code lost:
        r5 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x034d, code lost:
        if (r5 == r3) goto L_0x035d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x034f, code lost:
        r38 = ((float) (r0.zzk * r2)) / ((float) (r0.zzj * r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x035d, code lost:
        r38 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0361, code lost:
        if (r0.zzq == false) goto L_0x042e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0367, code lost:
        if (r0.zzw == -1.0f) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x036d, code lost:
        if (r0.zzx == -1.0f) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0373, code lost:
        if (r0.zzy == -1.0f) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0379, code lost:
        if (r0.zzz == -1.0f) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x037f, code lost:
        if (r0.zzA == -1.0f) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0385, code lost:
        if (r0.zzB == -1.0f) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x038b, code lost:
        if (r0.zzC == -1.0f) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0391, code lost:
        if (r0.zzD == -1.0f) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0397, code lost:
        if (r0.zzE == -1.0f) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x039d, code lost:
        if (r0.zzF != -1.0f) goto L_0x03a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03a1, code lost:
        r2 = new byte[25];
        r3 = java.nio.ByteBuffer.wrap(r2);
        r3.put((byte) 0);
        r3.putShort((short) ((int) ((r0.zzw * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzx * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzy * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzz * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzA * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzB * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzC * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzD * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) (r0.zzE + 0.5f)));
        r3.putShort((short) ((int) (r0.zzF + 0.5f)));
        r3.putShort((short) r0.zzu);
        r3.putShort((short) r0.zzv);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x041e, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0420, code lost:
        r41 = new com.google.android.gms.internal.ads.zzavd(r0.zzr, r0.zzt, r0.zzs, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x042e, code lost:
        r41 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0430, code lost:
        r1 = com.google.android.gms.internal.ads.zzank.zza(java.lang.Integer.toString(r45), r12, (java.lang.String) null, -1, r32, r0.zzj, r0.zzk, -1.0f, r1, -1, r38, r0.zzo, r0.zzp, r41, r0.zzi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x045d, code lost:
        if ("application/x-subrip".equals(r12) == false) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x045f, code lost:
        r1 = com.google.android.gms.internal.ads.zzank.zzd(java.lang.Integer.toString(r45), r12, (java.lang.String) null, -1, r2 ? 1 : 0, r0.zzP, -1, r0.zzi, androidx.recyclerview.widget.RecyclerView.FOREVER_NS, java.util.Collections.emptyList());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0482, code lost:
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0488, code lost:
        if ("application/vobsub".equals(r12) != false) goto L_0x049f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x048e, code lost:
        if ("application/pgs".equals(r12) != false) goto L_0x049f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0494, code lost:
        if ("application/dvbsubs".equals(r12) == false) goto L_0x0497;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x049e, code lost:
        throw new com.google.android.gms.internal.ads.zzann("Unexpected MIME type.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x049f, code lost:
        r1 = com.google.android.gms.internal.ads.zzank.zze(java.lang.Integer.toString(r45), r12, (java.lang.String) null, -1, r1, r0.zzP, r0.zzi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04b8, code lost:
        r2 = r44.zzbn(r0.zzb, r6);
        r0.zzN = r2;
        r2.zza(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04c5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c3, code lost:
        r27 = r1;
        r1 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzapm r44, int r45) throws com.google.android.gms.internal.ads.zzann {
        /*
            r43 = this;
            r0 = r43
            java.lang.String r1 = r0.zza
            int r2 = r1.hashCode()
            r4 = 4
            r5 = 8
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 3
            switch(r2) {
                case -2095576542: goto L_0x0149;
                case -2095575984: goto L_0x013f;
                case -1985379776: goto L_0x0134;
                case -1784763192: goto L_0x0129;
                case -1730367663: goto L_0x011e;
                case -1482641358: goto L_0x0113;
                case -1482641357: goto L_0x0108;
                case -1373388978: goto L_0x00fd;
                case -933872740: goto L_0x00f2;
                case -538363189: goto L_0x00e7;
                case -538363109: goto L_0x00dc;
                case -425012669: goto L_0x00d0;
                case -356037306: goto L_0x00c4;
                case 62923557: goto L_0x00b8;
                case 62923603: goto L_0x00ac;
                case 62927045: goto L_0x00a0;
                case 82338133: goto L_0x0095;
                case 82338134: goto L_0x008a;
                case 99146302: goto L_0x007e;
                case 444813526: goto L_0x0072;
                case 542569478: goto L_0x0066;
                case 725957860: goto L_0x005a;
                case 855502857: goto L_0x004f;
                case 1422270023: goto L_0x0043;
                case 1809237540: goto L_0x0038;
                case 1950749482: goto L_0x002c;
                case 1950789798: goto L_0x0020;
                case 1951062397: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0153
        L_0x0014:
            java.lang.String r2 = "A_OPUS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 11
            goto L_0x0154
        L_0x0020:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 21
            goto L_0x0154
        L_0x002c:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 16
            goto L_0x0154
        L_0x0038:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 2
            goto L_0x0154
        L_0x0043:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 24
            goto L_0x0154
        L_0x004f:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 7
            goto L_0x0154
        L_0x005a:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 23
            goto L_0x0154
        L_0x0066:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 19
            goto L_0x0154
        L_0x0072:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 9
            goto L_0x0154
        L_0x007e:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 26
            goto L_0x0154
        L_0x008a:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 1
            goto L_0x0154
        L_0x0095:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 0
            goto L_0x0154
        L_0x00a0:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 18
            goto L_0x0154
        L_0x00ac:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 15
            goto L_0x0154
        L_0x00b8:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 12
            goto L_0x0154
        L_0x00c4:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 20
            goto L_0x0154
        L_0x00d0:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 25
            goto L_0x0154
        L_0x00dc:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 6
            goto L_0x0154
        L_0x00e7:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 4
            goto L_0x0154
        L_0x00f2:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 27
            goto L_0x0154
        L_0x00fd:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 8
            goto L_0x0154
        L_0x0108:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 14
            goto L_0x0154
        L_0x0113:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 13
            goto L_0x0154
        L_0x011e:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 10
            goto L_0x0154
        L_0x0129:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 17
            goto L_0x0154
        L_0x0134:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 22
            goto L_0x0154
        L_0x013f:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 3
            goto L_0x0154
        L_0x0149:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 5
            goto L_0x0154
        L_0x0153:
            r1 = -1
        L_0x0154:
            java.lang.String r2 = ". Setting mimeType to audio/x-unknown"
            r11 = 75
            java.lang.String r12 = "audio/raw"
            java.lang.String r13 = "application/dvbsubs"
            java.lang.String r14 = "application/pgs"
            java.lang.String r15 = "application/vobsub"
            java.lang.String r3 = "application/x-subrip"
            r16 = 4096(0x1000, float:5.74E-42)
            java.lang.String r17 = "video/x-unknown"
            java.lang.String r18 = "audio/x-unknown"
            java.lang.String r10 = "MatroskaExtractor"
            r19 = 0
            switch(r1) {
                case 0: goto L_0x02e3;
                case 1: goto L_0x02e0;
                case 2: goto L_0x02dd;
                case 3: goto L_0x02cf;
                case 4: goto L_0x02cf;
                case 5: goto L_0x02cf;
                case 6: goto L_0x02ba;
                case 7: goto L_0x02a6;
                case 8: goto L_0x028e;
                case 9: goto L_0x028b;
                case 10: goto L_0x027c;
                case 11: goto L_0x0236;
                case 12: goto L_0x022c;
                case 13: goto L_0x0222;
                case 14: goto L_0x021f;
                case 15: goto L_0x021b;
                case 16: goto L_0x0217;
                case 17: goto L_0x0213;
                case 18: goto L_0x020f;
                case 19: goto L_0x020f;
                case 20: goto L_0x020b;
                case 21: goto L_0x0201;
                case 22: goto L_0x01c9;
                case 23: goto L_0x01a1;
                case 24: goto L_0x019e;
                case 25: goto L_0x0195;
                case 26: goto L_0x0192;
                case 27: goto L_0x0177;
                default: goto L_0x016f;
            }
        L_0x016f:
            com.google.android.gms.internal.ads.zzann r1 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2)
            throw r1
        L_0x0177:
            byte[] r1 = new byte[r4]
            byte[] r2 = r0.zzh
            byte r4 = r2[r8]
            r1[r8] = r4
            byte r4 = r2[r7]
            r1[r7] = r4
            byte r4 = r2[r6]
            r1[r6] = r4
            byte r2 = r2[r9]
            r1[r9] = r2
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r12 = r13
            goto L_0x02e7
        L_0x0192:
            r12 = r14
            goto L_0x02e5
        L_0x0195:
            byte[] r1 = r0.zzh
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r12 = r15
            goto L_0x02e7
        L_0x019e:
            r12 = r3
            goto L_0x02e5
        L_0x01a1:
            int r1 = r0.zzH
            int r1 = com.google.android.gms.internal.ads.zzava.zzo(r1)
            if (r1 != 0) goto L_0x01c3
            int r1 = r0.zzH
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            java.lang.String r5 = "Unsupported PCM bit depth: "
            r4.append(r5)
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            android.util.Log.w(r10, r1)
            goto L_0x01fd
        L_0x01c3:
            r27 = r1
            r1 = r19
            goto L_0x02e9
        L_0x01c9:
            com.google.android.gms.internal.ads.zzaut r1 = new com.google.android.gms.internal.ads.zzaut
            byte[] r4 = r0.zzh
            r1.<init>((byte[]) r4)
            boolean r1 = zze(r1)
            if (r1 == 0) goto L_0x01f8
            int r1 = r0.zzH
            int r1 = com.google.android.gms.internal.ads.zzava.zzo(r1)
            if (r1 != 0) goto L_0x01c3
            int r1 = r0.zzH
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            java.lang.String r5 = "Unsupported PCM bit depth: "
            r4.append(r5)
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            android.util.Log.w(r10, r1)
            goto L_0x01fd
        L_0x01f8:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
            android.util.Log.w(r10, r1)
        L_0x01fd:
            r12 = r18
            goto L_0x02e5
        L_0x0201:
            byte[] r1 = r0.zzh
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r12 = "audio/x-flac"
            goto L_0x02e7
        L_0x020b:
            java.lang.String r12 = "audio/vnd.dts.hd"
            goto L_0x02e5
        L_0x020f:
            java.lang.String r12 = "audio/vnd.dts"
            goto L_0x02e5
        L_0x0213:
            java.lang.String r12 = "audio/true-hd"
            goto L_0x02e5
        L_0x0217:
            java.lang.String r12 = "audio/eac3"
            goto L_0x02e5
        L_0x021b:
            java.lang.String r12 = "audio/ac3"
            goto L_0x02e5
        L_0x021f:
            java.lang.String r12 = "audio/mpeg"
            goto L_0x0224
        L_0x0222:
            java.lang.String r12 = "audio/mpeg-L2"
        L_0x0224:
            r1 = r19
            r27 = -1
            r32 = 4096(0x1000, float:5.74E-42)
            goto L_0x02eb
        L_0x022c:
            byte[] r1 = r0.zzh
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r12 = "audio/mp4a-latm"
            goto L_0x02e7
        L_0x0236:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r9)
            byte[] r2 = r0.zzh
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r4)
            long r10 = r0.zzJ
            java.nio.ByteBuffer r2 = r2.putLong(r10)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r4)
            long r4 = r0.zzK
            java.nio.ByteBuffer r2 = r2.putLong(r4)
            byte[] r2 = r2.array()
            r1.add(r2)
            r16 = 5760(0x1680, float:8.071E-42)
            java.lang.String r12 = "audio/opus"
            r27 = -1
            r32 = 5760(0x1680, float:8.071E-42)
            goto L_0x02eb
        L_0x027c:
            byte[] r1 = r0.zzh
            java.util.List r1 = zzd(r1)
            r16 = 8192(0x2000, float:1.14794E-41)
            java.lang.String r12 = "audio/vorbis"
            r27 = -1
            r32 = 8192(0x2000, float:1.14794E-41)
            goto L_0x02eb
        L_0x028b:
            r12 = r17
            goto L_0x02e5
        L_0x028e:
            com.google.android.gms.internal.ads.zzaut r1 = new com.google.android.gms.internal.ads.zzaut
            byte[] r2 = r0.zzh
            r1.<init>((byte[]) r2)
            java.util.List r1 = zzc(r1)
            if (r1 == 0) goto L_0x029e
            java.lang.String r12 = "video/wvc1"
            goto L_0x02e7
        L_0x029e:
            java.lang.String r2 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            android.util.Log.w(r10, r2)
            r12 = r17
            goto L_0x02e7
        L_0x02a6:
            com.google.android.gms.internal.ads.zzaut r1 = new com.google.android.gms.internal.ads.zzaut
            byte[] r2 = r0.zzh
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzavh r1 = com.google.android.gms.internal.ads.zzavh.zza(r1)
            java.util.List<byte[]> r2 = r1.zza
            int r1 = r1.zzb
            r0.zzO = r1
            java.lang.String r12 = "video/hevc"
            goto L_0x02cd
        L_0x02ba:
            com.google.android.gms.internal.ads.zzaut r1 = new com.google.android.gms.internal.ads.zzaut
            byte[] r2 = r0.zzh
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzavb r1 = com.google.android.gms.internal.ads.zzavb.zza(r1)
            java.util.List<byte[]> r2 = r1.zza
            int r1 = r1.zzb
            r0.zzO = r1
            java.lang.String r12 = "video/avc"
        L_0x02cd:
            r1 = r2
            goto L_0x02e7
        L_0x02cf:
            byte[] r1 = r0.zzh
            if (r1 != 0) goto L_0x02d6
            r1 = r19
            goto L_0x02da
        L_0x02d6:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x02da:
            java.lang.String r12 = "video/mp4v-es"
            goto L_0x02e7
        L_0x02dd:
            java.lang.String r12 = "video/mpeg2"
            goto L_0x02e5
        L_0x02e0:
            java.lang.String r12 = "video/x-vnd.on2.vp9"
            goto L_0x02e5
        L_0x02e3:
            java.lang.String r12 = "video/x-vnd.on2.vp8"
        L_0x02e5:
            r1 = r19
        L_0x02e7:
            r27 = -1
        L_0x02e9:
            r32 = -1
        L_0x02eb:
            boolean r2 = r0.zzM
            boolean r4 = r0.zzL
            if (r7 == r4) goto L_0x02f3
            r4 = 0
            goto L_0x02f4
        L_0x02f3:
            r4 = 2
        L_0x02f4:
            r2 = r2 | r4
            boolean r4 = com.google.android.gms.internal.ads.zzauq.zza(r12)
            if (r4 == 0) goto L_0x0328
            java.lang.String r20 = java.lang.Integer.toString(r45)
            r22 = 0
            r23 = -1
            int r3 = r0.zzG
            int r4 = r0.zzI
            r28 = -1
            r29 = -1
            com.google.android.gms.internal.ads.zzaph r5 = r0.zzi
            java.lang.String r6 = r0.zzP
            r34 = 0
            r21 = r12
            r24 = r32
            r25 = r3
            r26 = r4
            r30 = r1
            r31 = r5
            r32 = r2
            r33 = r6
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzank.zzc(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            r6 = 1
            goto L_0x04b8
        L_0x0328:
            boolean r4 = com.google.android.gms.internal.ads.zzauq.zzb(r12)
            if (r4 == 0) goto L_0x0459
            int r2 = r0.zzn
            if (r2 != 0) goto L_0x0344
            int r2 = r0.zzl
            r3 = -1
            if (r2 != r3) goto L_0x0339
            int r2 = r0.zzj
        L_0x0339:
            r0.zzl = r2
            int r2 = r0.zzm
            if (r2 != r3) goto L_0x0341
            int r2 = r0.zzk
        L_0x0341:
            r0.zzm = r2
            goto L_0x0345
        L_0x0344:
            r3 = -1
        L_0x0345:
            int r2 = r0.zzl
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r3) goto L_0x035d
            int r5 = r0.zzm
            if (r5 == r3) goto L_0x035d
            int r3 = r0.zzk
            int r3 = r3 * r2
            float r2 = (float) r3
            int r3 = r0.zzj
            int r3 = r3 * r5
            float r3 = (float) r3
            float r2 = r2 / r3
            r38 = r2
            goto L_0x035f
        L_0x035d:
            r38 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x035f:
            boolean r2 = r0.zzq
            if (r2 == 0) goto L_0x042e
            float r2 = r0.zzw
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x041e
            float r2 = r0.zzx
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x041e
            float r2 = r0.zzy
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x041e
            float r2 = r0.zzz
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x041e
            float r2 = r0.zzA
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x041e
            float r2 = r0.zzB
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x041e
            float r2 = r0.zzC
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x041e
            float r2 = r0.zzD
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x041e
            float r2 = r0.zzE
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x041e
            float r2 = r0.zzF
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x03a1
            goto L_0x041e
        L_0x03a1:
            r2 = 25
            byte[] r2 = new byte[r2]
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r2)
            r3.put(r8)
            float r4 = r0.zzw
            r5 = 1195593728(0x47435000, float:50000.0)
            float r4 = r4 * r5
            r7 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzx
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzy
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzz
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzA
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzB
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzC
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzD
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzE
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzF
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            int r4 = r0.zzu
            short r4 = (short) r4
            r3.putShort(r4)
            int r4 = r0.zzv
            short r4 = (short) r4
            r3.putShort(r4)
            goto L_0x0420
        L_0x041e:
            r2 = r19
        L_0x0420:
            com.google.android.gms.internal.ads.zzavd r3 = new com.google.android.gms.internal.ads.zzavd
            int r4 = r0.zzr
            int r5 = r0.zzt
            int r7 = r0.zzs
            r3.<init>(r4, r5, r7, r2)
            r41 = r3
            goto L_0x0430
        L_0x042e:
            r41 = r19
        L_0x0430:
            java.lang.String r28 = java.lang.Integer.toString(r45)
            r30 = 0
            r31 = -1
            int r2 = r0.zzj
            int r3 = r0.zzk
            r35 = -1082130432(0xffffffffbf800000, float:-1.0)
            r37 = -1
            byte[] r4 = r0.zzo
            int r5 = r0.zzp
            com.google.android.gms.internal.ads.zzaph r7 = r0.zzi
            r29 = r12
            r33 = r2
            r34 = r3
            r36 = r1
            r39 = r4
            r40 = r5
            r42 = r7
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzank.zza(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            goto L_0x04b8
        L_0x0459:
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x0484
            java.lang.String r28 = java.lang.Integer.toString(r45)
            r30 = 0
            r31 = -1
            java.lang.String r1 = r0.zzP
            r34 = -1
            com.google.android.gms.internal.ads.zzaph r3 = r0.zzi
            r36 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.util.List r38 = java.util.Collections.emptyList()
            r29 = r12
            r32 = r2
            r33 = r1
            r35 = r3
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzank.zzd(r28, r29, r30, r31, r32, r33, r34, r35, r36, r38)
        L_0x0482:
            r6 = 3
            goto L_0x04b8
        L_0x0484:
            boolean r2 = r15.equals(r12)
            if (r2 != 0) goto L_0x049f
            boolean r2 = r14.equals(r12)
            if (r2 != 0) goto L_0x049f
            boolean r2 = r13.equals(r12)
            if (r2 == 0) goto L_0x0497
            goto L_0x049f
        L_0x0497:
            com.google.android.gms.internal.ads.zzann r1 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2)
            throw r1
        L_0x049f:
            java.lang.String r20 = java.lang.Integer.toString(r45)
            r22 = 0
            r23 = -1
            java.lang.String r2 = r0.zzP
            com.google.android.gms.internal.ads.zzaph r3 = r0.zzi
            r21 = r12
            r24 = r1
            r25 = r2
            r26 = r3
            com.google.android.gms.internal.ads.zzank r1 = com.google.android.gms.internal.ads.zzank.zze(r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0482
        L_0x04b8:
            int r2 = r0.zzb
            r3 = r44
            com.google.android.gms.internal.ads.zzapu r2 = r3.zzbn(r2, r6)
            r0.zzN = r2
            r2.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqa.zza(com.google.android.gms.internal.ads.zzapm, int):void");
    }
}
