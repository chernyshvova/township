package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.playrix.gplay.billing.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvi {
    public int zzA = 1000;
    public int zzB = 200;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public byte[] zzM;
    public int zzN = 1;
    public int zzO = -1;
    public int zzP = 8000;
    public long zzQ = 0;
    public long zzR = 0;
    public zzvj zzS;
    public boolean zzT;
    public boolean zzU = true;
    public zztz zzV;
    public int zzW;
    public int zzX;
    public String zzY = "eng";
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzty zzi;
    public byte[] zzj;
    public zzsa zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = 0;
    public int zzq = -1;
    public float zzr = 0.0f;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public byte[] zzu = null;
    public int zzv = -1;
    public boolean zzw = false;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;

    public zzvi() {
    }

    public /* synthetic */ zzvi(zzvg zzvg) {
    }

    public static /* synthetic */ void zzb(zzvi zzvi) {
        if (zzvi.zzV == null) {
            throw null;
        }
    }

    public static Pair<String, List<byte[]>> zzf(zzakr zzakr) throws zzlg {
        try {
            zzakr.zzk(16);
            long zzu2 = zzakr.zzu();
            if (zzu2 == 1482049860) {
                return new Pair<>("video/divx", (Object) null);
            }
            if (zzu2 == 859189832) {
                return new Pair<>("video/3gpp", (Object) null);
            }
            if (zzu2 == 826496599) {
                int zzg2 = zzakr.zzg() + 20;
                byte[] zzi2 = zzakr.zzi();
                while (true) {
                    int length = zzi2.length;
                    if (zzg2 >= length - 4) {
                        throw new zzlg("Failed to find FourCC VC1 initialization data", (Throwable) null);
                    } else if (zzi2[zzg2] == 0 && zzi2[zzg2 + 1] == 0 && zzi2[zzg2 + 2] == 1 && zzi2[zzg2 + 3] == 15) {
                        return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(zzi2, zzg2, length)));
                    } else {
                        zzg2++;
                    }
                }
            } else {
                Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", (Object) null);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlg("Error parsing FourCC private data", (Throwable) null);
        }
    }

    public static List<byte[]> zzg(byte[] bArr) throws zzlg {
        byte b;
        byte b2;
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (true) {
                    b = bArr[i] & Base64.EQUALS_SIGN_ENC;
                    if (b != 255) {
                        break;
                    }
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + b;
                int i5 = 0;
                while (true) {
                    b2 = bArr[i3] & Base64.EQUALS_SIGN_ENC;
                    if (b2 != 255) {
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
                        throw new zzlg("Error parsing vorbis codec private", (Throwable) null);
                    }
                    throw new zzlg("Error parsing vorbis codec private", (Throwable) null);
                }
                throw new zzlg("Error parsing vorbis codec private", (Throwable) null);
            }
            throw new zzlg("Error parsing vorbis codec private", (Throwable) null);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlg("Error parsing vorbis codec private", (Throwable) null);
        }
    }

    public static boolean zzh(zzakr zzakr) throws zzlg {
        try {
            int zzp2 = zzakr.zzp();
            if (zzp2 == 1) {
                return true;
            }
            if (zzp2 == 65534) {
                zzakr.zzh(24);
                return zzakr.zzx() == zzvk.zze.getMostSignificantBits() && zzakr.zzx() == zzvk.zze.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlg("Error parsing MS/ACM codec private", (Throwable) null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzlg {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        String valueOf = String.valueOf(str);
        throw new zzlg(valueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(valueOf) : new String("Missing CodecPrivate for codec "), (Throwable) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.google.android.gms.internal.ads.zzall} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.google.android.gms.internal.ads.zzfml} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.internal.ads.zzfml} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: com.google.android.gms.internal.ads.zzfml} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: com.google.android.gms.internal.ads.zzfml} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v60, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v62, resolved type: com.google.android.gms.internal.ads.zzfml} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v65, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v68, resolved type: com.google.android.gms.internal.ads.zzfml} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v69, resolved type: com.google.android.gms.internal.ads.zzfml} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v70, resolved type: com.google.android.gms.internal.ads.zzfml} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v5 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x024d, code lost:
        r1 = null;
        r2 = null;
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x028a, code lost:
        r1 = null;
        r2 = null;
        r17 = "audio/x-unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02bc, code lost:
        r1 = null;
        r2 = null;
        r3 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x034f, code lost:
        r2 = null;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0380, code lost:
        r3 = -1;
        r8 = -1;
        r19 = r2;
        r2 = r1;
        r1 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03a0, code lost:
        r1 = null;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03a2, code lost:
        r3 = -1;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03a3, code lost:
        r8 = -1;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a4, code lost:
        r4 = r0.zzM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03a6, code lost:
        if (r4 == null) goto L_0x03b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03a8, code lost:
        r4 = com.google.android.gms.internal.ads.zzalm.zza(new com.google.android.gms.internal.ads.zzakr(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03b1, code lost:
        if (r4 == null) goto L_0x03b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03b3, code lost:
        r2 = r4.zza;
        r17 = "video/dolby-vision";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03b7, code lost:
        r4 = r17;
        r7 = r0.zzU;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03bd, code lost:
        if (true == r0.zzT) goto L_0x03c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03bf, code lost:
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03c1, code lost:
        r12 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03c2, code lost:
        r7 = r7 | r12;
        r12 = new com.google.android.gms.internal.ads.zzkb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03cc, code lost:
        if (com.google.android.gms.internal.ads.zzakg.zza(r4) == false) goto L_0x03dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03ce, code lost:
        r12.zzw(r0.zzN);
        r12.zzx(r0.zzP);
        r12.zzy(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03e1, code lost:
        if (com.google.android.gms.internal.ads.zzakg.zzb(r4) == false) goto L_0x0572;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03e5, code lost:
        if (r0.zzp != 0) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03e7, code lost:
        r5 = r0.zzn;
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03ea, code lost:
        if (r5 != -1) goto L_0x03ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03ec, code lost:
        r5 = r0.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03ee, code lost:
        r0.zzn = r5;
        r5 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03f2, code lost:
        if (r5 != -1) goto L_0x03f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03f4, code lost:
        r5 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03f6, code lost:
        r0.zzo = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03f9, code lost:
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03fa, code lost:
        r5 = r0.zzn;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03fe, code lost:
        if (r5 == r6) goto L_0x0410;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0400, code lost:
        r10 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0402, code lost:
        if (r10 == r6) goto L_0x0410;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0404, code lost:
        r5 = ((float) (r0.zzm * r5)) / ((float) (r0.zzl * r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0410, code lost:
        r5 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0414, code lost:
        if (r0.zzw == false) goto L_0x04e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x041a, code lost:
        if (r0.zzC == -1.0f) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0420, code lost:
        if (r0.zzD == -1.0f) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0426, code lost:
        if (r0.zzE == -1.0f) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x042c, code lost:
        if (r0.zzF == -1.0f) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0432, code lost:
        if (r0.zzG == -1.0f) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0438, code lost:
        if (r0.zzH == -1.0f) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x043e, code lost:
        if (r0.zzI == -1.0f) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0444, code lost:
        if (r0.zzJ == -1.0f) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x044a, code lost:
        if (r0.zzK == -1.0f) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0450, code lost:
        if (r0.zzL != -1.0f) goto L_0x0454;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0454, code lost:
        r11 = new byte[25];
        r8 = java.nio.ByteBuffer.wrap(r11).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        r8.put((byte) 0);
        r8.putShort((short) ((int) ((r0.zzC * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzD * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzE * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzF * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzG * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzH * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzI * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzJ * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) (r0.zzK + 0.5f)));
        r8.putShort((short) ((int) (r0.zzL + 0.5f)));
        r8.putShort((short) r0.zzA);
        r8.putShort((short) r0.zzB);
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04d6, code lost:
        r11 = new com.google.android.gms.internal.ads.zzall(r0.zzx, r0.zzz, r0.zzy, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04e4, code lost:
        if (r0.zza == null) goto L_0x0502;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x04f0, code lost:
        if (com.google.android.gms.internal.ads.zzvk.zzf.containsKey(r0.zza) == false) goto L_0x0502;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x04f2, code lost:
        r6 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzvk.zzf.get(r0.zza)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0504, code lost:
        if (r0.zzq != 0) goto L_0x0552;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x050d, code lost:
        if (java.lang.Float.compare(r0.zzr, 0.0f) != 0) goto L_0x0552;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0515, code lost:
        if (java.lang.Float.compare(r0.zzs, 0.0f) != 0) goto L_0x0552;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x051d, code lost:
        if (java.lang.Float.compare(r0.zzt, 0.0f) != 0) goto L_0x0520;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0528, code lost:
        if (java.lang.Float.compare(r0.zzs, 90.0f) != 0) goto L_0x052d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x052a, code lost:
        r9 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0535, code lost:
        if (java.lang.Float.compare(r0.zzs, -180.0f) == 0) goto L_0x054f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x053f, code lost:
        if (java.lang.Float.compare(r0.zzs, 180.0f) != 0) goto L_0x0542;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x054a, code lost:
        if (java.lang.Float.compare(r0.zzs, -90.0f) != 0) goto L_0x0552;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x054c, code lost:
        r9 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x054f, code lost:
        r9 = 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0552, code lost:
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0553, code lost:
        r12.zzo(r0.zzl);
        r12.zzp(r0.zzm);
        r12.zzs(r5);
        r12.zzr(r9);
        r12.zzt(r0.zzu);
        r12.zzu(r0.zzv);
        r12.zzv(r11);
        r5 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0576, code lost:
        if ("application/x-subrip".equals(r4) != false) goto L_0x059b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x057c, code lost:
        if ("text/x-ssa".equals(r4) != false) goto L_0x059b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0582, code lost:
        if ("application/vobsub".equals(r4) != false) goto L_0x059b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0588, code lost:
        if ("application/pgs".equals(r4) != false) goto L_0x059b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0590, code lost:
        if ("application/dvbsubs".equals(r4) == false) goto L_0x0593;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x059a, code lost:
        throw new com.google.android.gms.internal.ads.zzlg("Unexpected MIME type.", (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x059b, code lost:
        r5 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x059e, code lost:
        if (r0.zza == null) goto L_0x05b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x05aa, code lost:
        if (com.google.android.gms.internal.ads.zzvk.zzf.containsKey(r0.zza) != false) goto L_0x05b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x05ac, code lost:
        r12.zzc(r0.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x05b1, code lost:
        r12.zzb(r22);
        r12.zzj(r4);
        r12.zzk(r3);
        r12.zzd(r0.zzY);
        r12.zze(r7);
        r12.zzl(r1);
        r12.zzh(r2);
        r12.zzm(r0.zzk);
        r1 = r12.zzD();
        r2 = r21.zza(r0.zzc, r5);
        r0.zzV = r2;
        r2.zza(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x05e0, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zztd r21, int r22) throws com.google.android.gms.internal.ads.zzlg {
        /*
            r20 = this;
            r0 = r20
            java.lang.String r1 = r0.zzb
            int r2 = r1.hashCode()
            r4 = 16
            r5 = 1
            r7 = 8
            r8 = 4
            r9 = 0
            r10 = 3
            switch(r2) {
                case -2095576542: goto L_0x017a;
                case -2095575984: goto L_0x0170;
                case -1985379776: goto L_0x0165;
                case -1784763192: goto L_0x015a;
                case -1730367663: goto L_0x014f;
                case -1482641358: goto L_0x0144;
                case -1482641357: goto L_0x0139;
                case -1373388978: goto L_0x012e;
                case -933872740: goto L_0x0123;
                case -538363189: goto L_0x0118;
                case -538363109: goto L_0x010d;
                case -425012669: goto L_0x0101;
                case -356037306: goto L_0x00f5;
                case 62923557: goto L_0x00e9;
                case 62923603: goto L_0x00dd;
                case 62927045: goto L_0x00d1;
                case 82318131: goto L_0x00c6;
                case 82338133: goto L_0x00bb;
                case 82338134: goto L_0x00b0;
                case 99146302: goto L_0x00a4;
                case 444813526: goto L_0x0098;
                case 542569478: goto L_0x008c;
                case 635596514: goto L_0x0080;
                case 725948237: goto L_0x0074;
                case 725957860: goto L_0x0068;
                case 738597099: goto L_0x005c;
                case 855502857: goto L_0x0050;
                case 1422270023: goto L_0x0044;
                case 1809237540: goto L_0x0039;
                case 1950749482: goto L_0x002d;
                case 1950789798: goto L_0x0021;
                case 1951062397: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0184
        L_0x0015:
            java.lang.String r2 = "A_OPUS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 12
            goto L_0x0185
        L_0x0021:
            java.lang.String r2 = "A_FLAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 22
            goto L_0x0185
        L_0x002d:
            java.lang.String r2 = "A_EAC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 17
            goto L_0x0185
        L_0x0039:
            java.lang.String r2 = "V_MPEG2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 3
            goto L_0x0185
        L_0x0044:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 27
            goto L_0x0185
        L_0x0050:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 8
            goto L_0x0185
        L_0x005c:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 28
            goto L_0x0185
        L_0x0068:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 24
            goto L_0x0185
        L_0x0074:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 25
            goto L_0x0185
        L_0x0080:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 26
            goto L_0x0185
        L_0x008c:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 20
            goto L_0x0185
        L_0x0098:
            java.lang.String r2 = "V_THEORA"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 10
            goto L_0x0185
        L_0x00a4:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 30
            goto L_0x0185
        L_0x00b0:
            java.lang.String r2 = "V_VP9"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 1
            goto L_0x0185
        L_0x00bb:
            java.lang.String r2 = "V_VP8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 0
            goto L_0x0185
        L_0x00c6:
            java.lang.String r2 = "V_AV1"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 2
            goto L_0x0185
        L_0x00d1:
            java.lang.String r2 = "A_DTS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 19
            goto L_0x0185
        L_0x00dd:
            java.lang.String r2 = "A_AC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 16
            goto L_0x0185
        L_0x00e9:
            java.lang.String r2 = "A_AAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 13
            goto L_0x0185
        L_0x00f5:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 21
            goto L_0x0185
        L_0x0101:
            java.lang.String r2 = "S_VOBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 29
            goto L_0x0185
        L_0x010d:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 7
            goto L_0x0185
        L_0x0118:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 5
            goto L_0x0185
        L_0x0123:
            java.lang.String r2 = "S_DVBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 31
            goto L_0x0185
        L_0x012e:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 9
            goto L_0x0185
        L_0x0139:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 15
            goto L_0x0185
        L_0x0144:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 14
            goto L_0x0185
        L_0x014f:
            java.lang.String r2 = "A_VORBIS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 11
            goto L_0x0185
        L_0x015a:
            java.lang.String r2 = "A_TRUEHD"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 18
            goto L_0x0185
        L_0x0165:
            java.lang.String r2 = "A_MS/ACM"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 23
            goto L_0x0185
        L_0x0170:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 4
            goto L_0x0185
        L_0x017a:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0184
            r2 = 6
            goto L_0x0185
        L_0x0184:
            r2 = -1
        L_0x0185:
            java.lang.String r12 = ". Setting mimeType to audio/x-unknown"
            java.lang.String r13 = "application/pgs"
            java.lang.String r14 = "application/vobsub"
            java.lang.String r15 = "text/x-ssa"
            java.lang.String r6 = "application/x-subrip"
            r16 = 4096(0x1000, float:5.74E-42)
            java.lang.String r17 = "audio/raw"
            java.lang.String r18 = "audio/x-unknown"
            java.lang.String r3 = "MatroskaExtractor"
            r11 = 0
            switch(r2) {
                case 0: goto L_0x039e;
                case 1: goto L_0x039b;
                case 2: goto L_0x0398;
                case 3: goto L_0x0395;
                case 4: goto L_0x0388;
                case 5: goto L_0x0388;
                case 6: goto L_0x0388;
                case 7: goto L_0x0369;
                case 8: goto L_0x0351;
                case 9: goto L_0x0338;
                case 10: goto L_0x0334;
                case 11: goto L_0x0323;
                case 12: goto L_0x02de;
                case 13: goto L_0x02c2;
                case 14: goto L_0x02ba;
                case 15: goto L_0x02b7;
                case 16: goto L_0x02b3;
                case 17: goto L_0x02af;
                case 18: goto L_0x02a4;
                case 19: goto L_0x02a0;
                case 20: goto L_0x02a0;
                case 21: goto L_0x029c;
                case 22: goto L_0x0290;
                case 23: goto L_0x0252;
                case 24: goto L_0x0229;
                case 25: goto L_0x0200;
                case 26: goto L_0x01de;
                case 27: goto L_0x01da;
                case 28: goto L_0x01c7;
                case 29: goto L_0x01ba;
                case 30: goto L_0x01b4;
                case 31: goto L_0x01a3;
                default: goto L_0x019b;
            }
        L_0x019b:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2, r11)
            throw r1
        L_0x01a3:
            byte[] r2 = new byte[r8]
            byte[] r1 = r0.zzi(r1)
            java.lang.System.arraycopy(r1, r9, r2, r9, r8)
            com.google.android.gms.internal.ads.zzfml r1 = com.google.android.gms.internal.ads.zzfml.zzj(r2)
            java.lang.String r17 = "application/dvbsubs"
            goto L_0x034f
        L_0x01b4:
            r1 = r11
            r2 = r1
            r17 = r13
            goto L_0x03a2
        L_0x01ba:
            byte[] r1 = r0.zzi(r1)
            com.google.android.gms.internal.ads.zzfml r1 = com.google.android.gms.internal.ads.zzfml.zzj(r1)
            r2 = r11
            r17 = r14
            goto L_0x03a2
        L_0x01c7:
            byte[] r1 = com.google.android.gms.internal.ads.zzvk.zzc
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            com.google.android.gms.internal.ads.zzfml r1 = com.google.android.gms.internal.ads.zzfml.zzk(r1, r2)
            r2 = r11
            r17 = r15
            goto L_0x03a2
        L_0x01da:
            r17 = r6
            goto L_0x03a0
        L_0x01de:
            int r1 = r0.zzO
            r2 = 32
            if (r1 != r2) goto L_0x01e5
            goto L_0x024d
        L_0x01e5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 90
            r2.<init>(r4)
            java.lang.String r4 = "Unsupported floating point PCM bit depth: "
            r2.append(r4)
            r2.append(r1)
            r2.append(r12)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r3, r1)
            goto L_0x028a
        L_0x0200:
            int r1 = r0.zzO
            if (r1 != r7) goto L_0x020a
            r1 = r11
            r2 = r1
            r3 = -1
            r8 = 3
            goto L_0x03a4
        L_0x020a:
            if (r1 != r4) goto L_0x020f
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x024d
        L_0x020f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 86
            r2.<init>(r4)
            java.lang.String r4 = "Unsupported big endian PCM bit depth: "
            r2.append(r4)
            r2.append(r1)
            r2.append(r12)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r3, r1)
            goto L_0x028a
        L_0x0229:
            int r1 = r0.zzO
            int r8 = com.google.android.gms.internal.ads.zzalh.zzM(r1)
            if (r8 != 0) goto L_0x024d
            int r1 = r0.zzO
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 89
            r2.<init>(r4)
            java.lang.String r4 = "Unsupported little endian PCM bit depth: "
            r2.append(r4)
            r2.append(r1)
            r2.append(r12)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r3, r1)
            goto L_0x028a
        L_0x024d:
            r1 = r11
            r2 = r1
            r3 = -1
            goto L_0x03a4
        L_0x0252:
            com.google.android.gms.internal.ads.zzakr r2 = new com.google.android.gms.internal.ads.zzakr
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            boolean r1 = zzh(r2)
            if (r1 == 0) goto L_0x0285
            int r1 = r0.zzO
            int r8 = com.google.android.gms.internal.ads.zzalh.zzM(r1)
            if (r8 != 0) goto L_0x024d
            int r1 = r0.zzO
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 75
            r2.<init>(r4)
            java.lang.String r4 = "Unsupported PCM bit depth: "
            r2.append(r4)
            r2.append(r1)
            r2.append(r12)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r3, r1)
            goto L_0x028a
        L_0x0285:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
            android.util.Log.w(r3, r1)
        L_0x028a:
            r1 = r11
            r2 = r1
            r17 = r18
            goto L_0x03a2
        L_0x0290:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r17 = "audio/flac"
            goto L_0x034f
        L_0x029c:
            java.lang.String r17 = "audio/vnd.dts.hd"
            goto L_0x03a0
        L_0x02a0:
            java.lang.String r17 = "audio/vnd.dts"
            goto L_0x03a0
        L_0x02a4:
            com.google.android.gms.internal.ads.zzvj r1 = new com.google.android.gms.internal.ads.zzvj
            r1.<init>()
            r0.zzS = r1
            java.lang.String r17 = "audio/true-hd"
            goto L_0x03a0
        L_0x02af:
            java.lang.String r17 = "audio/eac3"
            goto L_0x03a0
        L_0x02b3:
            java.lang.String r17 = "audio/ac3"
            goto L_0x03a0
        L_0x02b7:
            java.lang.String r17 = "audio/mpeg"
            goto L_0x02bc
        L_0x02ba:
            java.lang.String r17 = "audio/mpeg-L2"
        L_0x02bc:
            r1 = r11
            r2 = r1
            r3 = 4096(0x1000, float:5.74E-42)
            goto L_0x03a3
        L_0x02c2:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            byte[] r2 = r0.zzj
            com.google.android.gms.internal.ads.zzoy r2 = com.google.android.gms.internal.ads.zzoz.zza(r2)
            int r3 = r2.zza
            r0.zzP = r3
            int r3 = r2.zzb
            r0.zzN = r3
            java.lang.String r2 = r2.zzc
            java.lang.String r17 = "audio/mp4a-latm"
            goto L_0x03a2
        L_0x02de:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r10)
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r7)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzQ
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r7)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzR
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            r16 = 5760(0x1680, float:8.071E-42)
            java.lang.String r17 = "audio/opus"
            r2 = r11
            r3 = 5760(0x1680, float:8.071E-42)
            goto L_0x03a3
        L_0x0323:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = zzg(r1)
            r16 = 8192(0x2000, float:1.14794E-41)
            java.lang.String r17 = "audio/vorbis"
            r2 = r11
            r3 = 8192(0x2000, float:1.14794E-41)
            goto L_0x03a3
        L_0x0334:
            java.lang.String r17 = "video/x-unknown"
            goto L_0x03a0
        L_0x0338:
            com.google.android.gms.internal.ads.zzakr r2 = new com.google.android.gms.internal.ads.zzakr
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            android.util.Pair r1 = zzf(r2)
            java.lang.Object r2 = r1.first
            r17 = r2
            java.lang.String r17 = (java.lang.String) r17
            java.lang.Object r1 = r1.second
            java.util.List r1 = (java.util.List) r1
        L_0x034f:
            r2 = r11
            goto L_0x03a2
        L_0x0351:
            com.google.android.gms.internal.ads.zzakr r2 = new com.google.android.gms.internal.ads.zzakr
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            com.google.android.gms.internal.ads.zzals r1 = com.google.android.gms.internal.ads.zzals.zza(r2)
            java.util.List<byte[]> r2 = r1.zza
            int r3 = r1.zzb
            r0.zzW = r3
            java.lang.String r1 = r1.zzc
            java.lang.String r17 = "video/hevc"
            goto L_0x0380
        L_0x0369:
            com.google.android.gms.internal.ads.zzakr r2 = new com.google.android.gms.internal.ads.zzakr
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            com.google.android.gms.internal.ads.zzalj r1 = com.google.android.gms.internal.ads.zzalj.zza(r2)
            java.util.List<byte[]> r2 = r1.zza
            int r3 = r1.zzb
            r0.zzW = r3
            java.lang.String r1 = r1.zzf
            java.lang.String r17 = "video/avc"
        L_0x0380:
            r3 = -1
            r8 = -1
            r19 = r2
            r2 = r1
            r1 = r19
            goto L_0x03a4
        L_0x0388:
            byte[] r1 = r0.zzj
            if (r1 != 0) goto L_0x038e
            r1 = r11
            goto L_0x0392
        L_0x038e:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x0392:
            java.lang.String r17 = "video/mp4v-es"
            goto L_0x034f
        L_0x0395:
            java.lang.String r17 = "video/mpeg2"
            goto L_0x03a0
        L_0x0398:
            java.lang.String r17 = "video/av01"
            goto L_0x03a0
        L_0x039b:
            java.lang.String r17 = "video/x-vnd.on2.vp9"
            goto L_0x03a0
        L_0x039e:
            java.lang.String r17 = "video/x-vnd.on2.vp8"
        L_0x03a0:
            r1 = r11
            r2 = r1
        L_0x03a2:
            r3 = -1
        L_0x03a3:
            r8 = -1
        L_0x03a4:
            byte[] r4 = r0.zzM
            if (r4 == 0) goto L_0x03b7
            com.google.android.gms.internal.ads.zzakr r7 = new com.google.android.gms.internal.ads.zzakr
            r7.<init>((byte[]) r4)
            com.google.android.gms.internal.ads.zzalm r4 = com.google.android.gms.internal.ads.zzalm.zza(r7)
            if (r4 == 0) goto L_0x03b7
            java.lang.String r2 = r4.zza
            java.lang.String r17 = "video/dolby-vision"
        L_0x03b7:
            r4 = r17
            boolean r7 = r0.zzU
            boolean r12 = r0.zzT
            if (r5 == r12) goto L_0x03c1
            r12 = 0
            goto L_0x03c2
        L_0x03c1:
            r12 = 2
        L_0x03c2:
            r7 = r7 | r12
            com.google.android.gms.internal.ads.zzkb r12 = new com.google.android.gms.internal.ads.zzkb
            r12.<init>()
            boolean r16 = com.google.android.gms.internal.ads.zzakg.zza(r4)
            if (r16 == 0) goto L_0x03dd
            int r6 = r0.zzN
            r12.zzw(r6)
            int r6 = r0.zzP
            r12.zzx(r6)
            r12.zzy(r8)
            goto L_0x059c
        L_0x03dd:
            boolean r5 = com.google.android.gms.internal.ads.zzakg.zzb(r4)
            if (r5 == 0) goto L_0x0572
            int r5 = r0.zzp
            if (r5 != 0) goto L_0x03f9
            int r5 = r0.zzn
            r6 = -1
            if (r5 != r6) goto L_0x03ee
            int r5 = r0.zzl
        L_0x03ee:
            r0.zzn = r5
            int r5 = r0.zzo
            if (r5 != r6) goto L_0x03f6
            int r5 = r0.zzm
        L_0x03f6:
            r0.zzo = r5
            goto L_0x03fa
        L_0x03f9:
            r6 = -1
        L_0x03fa:
            int r5 = r0.zzn
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r5 == r6) goto L_0x0410
            int r10 = r0.zzo
            if (r10 == r6) goto L_0x0410
            int r13 = r0.zzm
            int r13 = r13 * r5
            float r5 = (float) r13
            int r13 = r0.zzl
            int r13 = r13 * r10
            float r10 = (float) r13
            float r5 = r5 / r10
            goto L_0x0412
        L_0x0410:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0412:
            boolean r10 = r0.zzw
            if (r10 == 0) goto L_0x04e2
            float r10 = r0.zzC
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x04d6
            float r10 = r0.zzD
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x04d6
            float r10 = r0.zzE
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x04d6
            float r10 = r0.zzF
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x04d6
            float r10 = r0.zzG
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x04d6
            float r10 = r0.zzH
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x04d6
            float r10 = r0.zzI
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x04d6
            float r10 = r0.zzJ
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x04d6
            float r10 = r0.zzK
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x04d6
            float r10 = r0.zzL
            int r8 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x0454
            goto L_0x04d6
        L_0x0454:
            r8 = 25
            byte[] r11 = new byte[r8]
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.wrap(r11)
            java.nio.ByteOrder r10 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r8 = r8.order(r10)
            r8.put(r9)
            float r10 = r0.zzC
            r13 = 1195593728(0x47435000, float:50000.0)
            float r10 = r10 * r13
            r14 = 1056964608(0x3f000000, float:0.5)
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzD
            float r10 = r10 * r13
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzE
            float r10 = r10 * r13
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzF
            float r10 = r10 * r13
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzG
            float r10 = r10 * r13
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzH
            float r10 = r10 * r13
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzI
            float r10 = r10 * r13
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzJ
            float r10 = r10 * r13
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzK
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzL
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            int r10 = r0.zzA
            short r10 = (short) r10
            r8.putShort(r10)
            int r10 = r0.zzB
            short r10 = (short) r10
            r8.putShort(r10)
        L_0x04d6:
            com.google.android.gms.internal.ads.zzall r8 = new com.google.android.gms.internal.ads.zzall
            int r10 = r0.zzx
            int r13 = r0.zzz
            int r14 = r0.zzy
            r8.<init>(r10, r13, r14, r11)
            r11 = r8
        L_0x04e2:
            java.lang.String r8 = r0.zza
            if (r8 == 0) goto L_0x0502
            java.util.Map r8 = com.google.android.gms.internal.ads.zzvk.zzf
            java.lang.String r10 = r0.zza
            boolean r8 = r8.containsKey(r10)
            if (r8 == 0) goto L_0x0502
            java.util.Map r6 = com.google.android.gms.internal.ads.zzvk.zzf
            java.lang.String r8 = r0.zza
            java.lang.Object r6 = r6.get(r8)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
        L_0x0502:
            int r8 = r0.zzq
            if (r8 != 0) goto L_0x0552
            float r8 = r0.zzr
            r10 = 0
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x0552
            float r8 = r0.zzs
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x0552
            float r8 = r0.zzt
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x0520
            goto L_0x0553
        L_0x0520:
            float r8 = r0.zzs
            r9 = 1119092736(0x42b40000, float:90.0)
            int r8 = java.lang.Float.compare(r8, r9)
            if (r8 != 0) goto L_0x052d
            r9 = 90
            goto L_0x0553
        L_0x052d:
            float r8 = r0.zzs
            r9 = -1020002304(0xffffffffc3340000, float:-180.0)
            int r8 = java.lang.Float.compare(r8, r9)
            if (r8 == 0) goto L_0x054f
            float r8 = r0.zzs
            r9 = 1127481344(0x43340000, float:180.0)
            int r8 = java.lang.Float.compare(r8, r9)
            if (r8 != 0) goto L_0x0542
            goto L_0x054f
        L_0x0542:
            float r8 = r0.zzs
            r9 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r8 = java.lang.Float.compare(r8, r9)
            if (r8 != 0) goto L_0x0552
            r9 = 270(0x10e, float:3.78E-43)
            goto L_0x0553
        L_0x054f:
            r9 = 180(0xb4, float:2.52E-43)
            goto L_0x0553
        L_0x0552:
            r9 = r6
        L_0x0553:
            int r6 = r0.zzl
            r12.zzo(r6)
            int r6 = r0.zzm
            r12.zzp(r6)
            r12.zzs(r5)
            r12.zzr(r9)
            byte[] r5 = r0.zzu
            r12.zzt(r5)
            int r5 = r0.zzv
            r12.zzu(r5)
            r12.zzv(r11)
            r5 = 2
            goto L_0x059c
        L_0x0572:
            boolean r5 = r6.equals(r4)
            if (r5 != 0) goto L_0x059b
            boolean r5 = r15.equals(r4)
            if (r5 != 0) goto L_0x059b
            boolean r5 = r14.equals(r4)
            if (r5 != 0) goto L_0x059b
            boolean r5 = r13.equals(r4)
            if (r5 != 0) goto L_0x059b
            java.lang.String r5 = "application/dvbsubs"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x0593
            goto L_0x059b
        L_0x0593:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2, r11)
            throw r1
        L_0x059b:
            r5 = 3
        L_0x059c:
            java.lang.String r6 = r0.zza
            if (r6 == 0) goto L_0x05b1
            java.util.Map r6 = com.google.android.gms.internal.ads.zzvk.zzf
            java.lang.String r8 = r0.zza
            boolean r6 = r6.containsKey(r8)
            if (r6 != 0) goto L_0x05b1
            java.lang.String r6 = r0.zza
            r12.zzc(r6)
        L_0x05b1:
            r6 = r22
            r12.zzb(r6)
            r12.zzj(r4)
            r12.zzk(r3)
            java.lang.String r3 = r0.zzY
            r12.zzd(r3)
            r12.zze(r7)
            r12.zzl(r1)
            r12.zzh(r2)
            com.google.android.gms.internal.ads.zzsa r1 = r0.zzk
            r12.zzm(r1)
            com.google.android.gms.internal.ads.zzkc r1 = r12.zzD()
            int r2 = r0.zzc
            r3 = r21
            com.google.android.gms.internal.ads.zztz r2 = r3.zza(r2, r5)
            r0.zzV = r2
            r2.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvi.zza(com.google.android.gms.internal.ads.zztd, int):void");
    }
}
