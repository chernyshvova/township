package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.drive.DriveFile;
import com.helpshift.support.views.HSTypingIndicatorView;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvk implements zzta {
    public static final zztg zza = zzvf.zza;
    public static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] zzc = zzalh.zzs("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    public static final byte[] zzd = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    public static final UUID zze = new UUID(72057594037932032L, -9223371306706625679L);
    public static final Map<String, Integer> zzf;
    public boolean zzA;
    public int zzB;
    public long zzC;
    public boolean zzD;
    public long zzE;
    public long zzF;
    public long zzG;
    @Nullable
    public zzakb zzH;
    @Nullable
    public zzakb zzI;
    public boolean zzJ;
    public boolean zzK;
    public int zzL;
    public long zzM;
    public long zzN;
    public int zzO;
    public int zzP;
    public int[] zzQ;
    public int zzR;
    public int zzS;
    public int zzT;
    public int zzU;
    public boolean zzV;
    public int zzW;
    public int zzX;
    public int zzY;
    public boolean zzZ;
    public boolean zzaa;
    public boolean zzab;
    public int zzac;
    public byte zzad;
    public boolean zzae;
    public zztd zzaf;
    public final zzvd zzag;
    public final zzvm zzg;
    public final SparseArray<zzvi> zzh;
    public final boolean zzi;
    public final zzakr zzj;
    public final zzakr zzk;
    public final zzakr zzl;
    public final zzakr zzm;
    public final zzakr zzn;
    public final zzakr zzo;
    public final zzakr zzp;
    public final zzakr zzq;
    public final zzakr zzr;
    public final zzakr zzs;
    public ByteBuffer zzt;
    public long zzu;
    public long zzv;
    public long zzw;
    public long zzx;
    public long zzy;
    @Nullable
    public zzvi zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(hashMap);
    }

    public zzvk() {
        this(0);
    }

    @CallSuper
    public static final int zzn(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case HSTypingIndicatorView.ALPHA_DARK /*179*/:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case DrawerLayout.PEEK_DELAY:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    @CallSuper
    public static final boolean zzo(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzp(int i) throws zzlg {
        if (this.zzz == null) {
            throw new zzlg(GeneratedOutlineSupport.outline10(43, "Element ", i, " must be in a TrackEntry"), (Throwable) null);
        }
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzq(int i) throws zzlg {
        if (this.zzH == null || this.zzI == null) {
            throw new zzlg(GeneratedOutlineSupport.outline10(37, "Element ", i, " must be in a Cues"), (Throwable) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b9 A[EDGE_INSN: B:49:0x00b9->B:38:0x00b9 ?: BREAK  , SYNTHETIC] */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzr(com.google.android.gms.internal.ads.zzvi r17, long r18, int r20, int r21, int r22) {
        /*
            r16 = this;
            r0 = r16
            r2 = r17
            com.google.android.gms.internal.ads.zzvj r1 = r2.zzS
            r8 = 1
            if (r1 == 0) goto L_0x0018
            r2 = r17
            r3 = r18
            r5 = r20
            r6 = r21
            r7 = r22
            r1.zzc(r2, r3, r5, r6, r7)
            goto L_0x00fb
        L_0x0018:
            java.lang.String r1 = r2.zzb
            java.lang.String r3 = "S_TEXT/UTF8"
            boolean r1 = r3.equals(r1)
            java.lang.String r4 = "S_TEXT/ASS"
            if (r1 != 0) goto L_0x002c
            java.lang.String r1 = r2.zzb
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0048
        L_0x002c:
            int r1 = r0.zzP
            java.lang.String r5 = "MatroskaExtractor"
            if (r1 <= r8) goto L_0x0038
            java.lang.String r1 = "Skipping subtitle sample in laced block."
            android.util.Log.w(r5, r1)
            goto L_0x0048
        L_0x0038:
            long r6 = r0.zzN
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x004c
            java.lang.String r1 = "Skipping subtitle sample with no duration."
            android.util.Log.w(r5, r1)
        L_0x0048:
            r1 = r21
            goto L_0x00cc
        L_0x004c:
            java.lang.String r1 = r2.zzb
            com.google.android.gms.internal.ads.zzakr r5 = r0.zzp
            byte[] r5 = r5.zzi()
            int r9 = r1.hashCode()
            r10 = 738597099(0x2c0618eb, float:1.9056378E-12)
            r11 = 0
            if (r9 == r10) goto L_0x006c
            r4 = 1422270023(0x54c61e47, float:6.807292E12)
            if (r9 == r4) goto L_0x0064
            goto L_0x0074
        L_0x0064:
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0074
            r1 = 0
            goto L_0x0075
        L_0x006c:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0074
            r1 = 1
            goto L_0x0075
        L_0x0074:
            r1 = -1
        L_0x0075:
            if (r1 == 0) goto L_0x008a
            if (r1 != r8) goto L_0x0084
            r3 = 10000(0x2710, double:4.9407E-320)
            java.lang.String r1 = "%01d:%02d:%02d:%02d"
            byte[] r1 = zzw(r6, r1, r3)
            r3 = 21
            goto L_0x0094
        L_0x0084:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x008a:
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r1 = "%02d:%02d:%02d,%03d"
            byte[] r1 = zzw(r6, r1, r3)
            r3 = 19
        L_0x0094:
            int r4 = r1.length
            java.lang.System.arraycopy(r1, r11, r5, r3, r4)
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzp
            int r1 = r1.zzg()
        L_0x009e:
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzp
            int r3 = r3.zze()
            if (r1 >= r3) goto L_0x00b9
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzp
            byte[] r3 = r3.zzi()
            byte r3 = r3[r1]
            if (r3 != 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzp
            r3.zzf(r1)
            goto L_0x00b9
        L_0x00b6:
            int r1 = r1 + 1
            goto L_0x009e
        L_0x00b9:
            com.google.android.gms.internal.ads.zztz r1 = r2.zzV
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzp
            int r4 = r3.zze()
            com.google.android.gms.internal.ads.zztx.zzb(r1, r3, r4)
            com.google.android.gms.internal.ads.zzakr r1 = r0.zzp
            int r1 = r1.zze()
            int r1 = r1 + r21
        L_0x00cc:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r20 & r3
            if (r3 == 0) goto L_0x00ed
            int r3 = r0.zzP
            if (r3 <= r8) goto L_0x00de
            r3 = -268435457(0xffffffffefffffff, float:-1.5845632E29)
            r3 = r20 & r3
            r13 = r1
            r12 = r3
            goto L_0x00f0
        L_0x00de:
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzs
            int r3 = r3.zze()
            com.google.android.gms.internal.ads.zztz r4 = r2.zzV
            com.google.android.gms.internal.ads.zzakr r5 = r0.zzs
            r6 = 2
            r4.zzc(r5, r3, r6)
            int r1 = r1 + r3
        L_0x00ed:
            r12 = r20
            r13 = r1
        L_0x00f0:
            com.google.android.gms.internal.ads.zztz r9 = r2.zzV
            com.google.android.gms.internal.ads.zzty r15 = r2.zzi
            r10 = r18
            r14 = r22
            r9.zzd(r10, r12, r13, r14, r15)
        L_0x00fb:
            r0.zzK = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvk.zzr(com.google.android.gms.internal.ads.zzvi, long, int, int, int):void");
    }

    private final void zzs(zztb zztb, int i) throws IOException {
        if (this.zzl.zze() < i) {
            if (this.zzl.zzj() < i) {
                zzakr zzakr = this.zzl;
                int zzj2 = zzakr.zzj();
                zzakr.zzc(Math.max(zzj2 + zzj2, i));
            }
            ((zzsx) zztb).zzb(this.zzl.zzi(), this.zzl.zze(), i - this.zzl.zze(), false);
            this.zzl.zzf(i);
        }
    }

    @RequiresNonNull({"#2.output"})
    private final int zzt(zztb zztb, zzvi zzvi, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzvi.zzb)) {
            zzv(zztb, zzb, i);
            int i3 = this.zzX;
            zzu();
            return i3;
        } else if ("S_TEXT/ASS".equals(zzvi.zzb)) {
            zzv(zztb, zzd, i);
            int i4 = this.zzX;
            zzu();
            return i4;
        } else {
            zztz zztz = zzvi.zzV;
            boolean z = true;
            if (!this.zzZ) {
                if (zzvi.zzg) {
                    this.zzT &= -1073741825;
                    int i5 = 128;
                    if (!this.zzaa) {
                        ((zzsx) zztb).zzb(this.zzl.zzi(), 0, 1, false);
                        this.zzW++;
                        if ((this.zzl.zzi()[0] & 128) != 128) {
                            this.zzad = this.zzl.zzi()[0];
                            this.zzaa = true;
                        } else {
                            throw new zzlg("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b = this.zzad;
                    if ((b & 1) == 1) {
                        byte b2 = b & 2;
                        this.zzT |= 1073741824;
                        if (!this.zzae) {
                            ((zzsx) zztb).zzb(this.zzq.zzi(), 0, 8, false);
                            this.zzW += 8;
                            this.zzae = true;
                            byte[] zzi2 = this.zzl.zzi();
                            if (b2 != 2) {
                                i5 = 0;
                            }
                            zzi2[0] = (byte) (i5 | 8);
                            this.zzl.zzh(0);
                            zztz.zzc(this.zzl, 1, 1);
                            this.zzX++;
                            this.zzq.zzh(0);
                            zztz.zzc(this.zzq, 8, 1);
                            this.zzX += 8;
                        }
                        if (b2 == 2) {
                            if (!this.zzab) {
                                ((zzsx) zztb).zzb(this.zzl.zzi(), 0, 1, false);
                                this.zzW++;
                                this.zzl.zzh(0);
                                this.zzac = this.zzl.zzn();
                                this.zzab = true;
                            }
                            int i6 = this.zzac * 4;
                            this.zzl.zza(i6);
                            ((zzsx) zztb).zzb(this.zzl.zzi(), 0, i6, false);
                            this.zzW += i6;
                            int i7 = (this.zzac >> 1) + 1;
                            int i8 = (i7 * 6) + 2;
                            ByteBuffer byteBuffer = this.zzt;
                            if (byteBuffer == null || byteBuffer.capacity() < i8) {
                                this.zzt = ByteBuffer.allocate(i8);
                            }
                            this.zzt.position(0);
                            this.zzt.putShort((short) i7);
                            int i9 = 0;
                            int i10 = 0;
                            while (true) {
                                i2 = this.zzac;
                                if (i9 >= i2) {
                                    break;
                                }
                                int zzB2 = this.zzl.zzB();
                                if (i9 % 2 == 0) {
                                    this.zzt.putShort((short) (zzB2 - i10));
                                } else {
                                    this.zzt.putInt(zzB2 - i10);
                                }
                                i9++;
                                i10 = zzB2;
                            }
                            int i11 = (i - this.zzW) - i10;
                            if ((i2 & 1) == 1) {
                                this.zzt.putInt(i11);
                            } else {
                                this.zzt.putShort((short) i11);
                                this.zzt.putInt(0);
                            }
                            this.zzr.zzb(this.zzt.array(), i8);
                            zztz.zzc(this.zzr, i8, 1);
                            this.zzX += i8;
                        }
                    }
                } else {
                    byte[] bArr = zzvi.zzh;
                    if (bArr != null) {
                        this.zzo.zzb(bArr, bArr.length);
                    }
                }
                if (zzvi.zzf > 0) {
                    this.zzT |= DriveFile.MODE_READ_ONLY;
                    this.zzs.zza(0);
                    this.zzl.zza(4);
                    this.zzl.zzi()[0] = (byte) ((i >> 24) & 255);
                    this.zzl.zzi()[1] = (byte) ((i >> 16) & 255);
                    this.zzl.zzi()[2] = (byte) ((i >> 8) & 255);
                    this.zzl.zzi()[3] = (byte) (i & 255);
                    zztz.zzc(this.zzl, 4, 2);
                    this.zzX += 4;
                }
                this.zzZ = true;
            }
            int zze2 = this.zzo.zze() + i;
            if (!"V_MPEG4/ISO/AVC".equals(zzvi.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzvi.zzb)) {
                if (zzvi.zzS != null) {
                    if (this.zzo.zze() != 0) {
                        z = false;
                    }
                    zzajg.zzd(z);
                    zzvi.zzS.zzb(zztb);
                }
                while (true) {
                    int i12 = this.zzW;
                    if (i12 >= zze2) {
                        break;
                    }
                    int zzx2 = zzx(zztb, zztz, zze2 - i12);
                    this.zzW += zzx2;
                    this.zzX += zzx2;
                }
            } else {
                byte[] zzi3 = this.zzk.zzi();
                zzi3[0] = 0;
                zzi3[1] = 0;
                zzi3[2] = 0;
                int i13 = zzvi.zzW;
                int i14 = 4 - i13;
                while (this.zzW < zze2) {
                    int i15 = this.zzY;
                    if (i15 == 0) {
                        int min = Math.min(i13, this.zzo.zzd());
                        ((zzsx) zztb).zzb(zzi3, i14 + min, i13 - min, false);
                        if (min > 0) {
                            this.zzo.zzm(zzi3, i14, min);
                        }
                        this.zzW += i13;
                        this.zzk.zzh(0);
                        this.zzY = this.zzk.zzB();
                        this.zzj.zzh(0);
                        zztx.zzb(zztz, this.zzj, 4);
                        this.zzX += 4;
                    } else {
                        int zzx3 = zzx(zztb, zztz, i15);
                        this.zzW += zzx3;
                        this.zzX += zzx3;
                        this.zzY -= zzx3;
                    }
                }
            }
            if ("A_VORBIS".equals(zzvi.zzb)) {
                this.zzm.zzh(0);
                zztx.zzb(zztz, this.zzm, 4);
                this.zzX += 4;
            }
            int i16 = this.zzX;
            zzu();
            return i16;
        }
    }

    private final void zzu() {
        this.zzW = 0;
        this.zzX = 0;
        this.zzY = 0;
        this.zzZ = false;
        this.zzaa = false;
        this.zzab = false;
        this.zzac = 0;
        this.zzad = 0;
        this.zzae = false;
        this.zzo.zza(0);
    }

    private final void zzv(zztb zztb, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.zzp.zzj() < i2) {
            zzakr zzakr = this.zzp;
            byte[] copyOf = Arrays.copyOf(bArr, i2 + i);
            zzakr.zzb(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzp.zzi(), 0, length);
        }
        ((zzsx) zztb).zzb(this.zzp.zzi(), length, i, false);
        this.zzp.zzh(0);
        this.zzp.zzf(i2);
    }

    public static byte[] zzw(long j, String str, long j2) {
        zzajg.zza(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) (i * 3600)) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) (i2 * 60)) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return zzalh.zzs(String.format(Locale.US, str, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))}));
    }

    private final int zzx(zztb zztb, zztz zztz, int i) throws IOException {
        int zzd2 = this.zzo.zzd();
        if (zzd2 <= 0) {
            return zztx.zza(zztz, zztb, i, false);
        }
        int min = Math.min(i, zzd2);
        zztx.zzb(zztz, this.zzo, min);
        return min;
    }

    private final long zzy(long j) throws zzlg {
        long j2 = this.zzw;
        if (j2 != -9223372036854775807L) {
            return zzalh.zzF(j, j2, 1000);
        }
        throw new zzlg("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    public static int[] zzz(@Nullable int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    @CallSuper
    public final void zza(int i, long j, long j2) throws zzlg {
        zzajg.zze(this.zzaf);
        if (i == 160) {
            this.zzV = false;
        } else if (i == 174) {
            this.zzz = new zzvi((zzvg) null);
        } else if (i == 187) {
            this.zzJ = false;
        } else if (i == 19899) {
            this.zzB = -1;
            this.zzC = -1;
        } else if (i == 20533) {
            zzp(i);
            this.zzz.zzg = true;
        } else if (i == 21968) {
            zzp(i);
            this.zzz.zzw = true;
        } else if (i == 408125543) {
            long j3 = this.zzv;
            if (j3 == -1 || j3 == j) {
                this.zzv = j;
                this.zzu = j2;
                return;
            }
            throw new zzlg("Multiple Segment elements not supported", (Throwable) null);
        } else if (i == 475249515) {
            this.zzH = new zzakb(32);
            this.zzI = new zzakb(32);
        } else if (i != 524531317 || this.zzA) {
        } else {
            if (!this.zzi || this.zzE == -1) {
                this.zzaf.zzbm(new zztu(this.zzy, 0));
                this.zzA = true;
                return;
            }
            this.zzD = true;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0256, code lost:
        if (r3.equals("V_AV1") != false) goto L_0x030e;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(int r22) throws com.google.android.gms.internal.ads.zzlg {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            com.google.android.gms.internal.ads.zztd r1 = r7.zzaf
            com.google.android.gms.internal.ads.zzajg.zze(r1)
            r1 = 160(0xa0, float:2.24E-43)
            r2 = 2
            if (r0 == r1) goto L_0x032e
            r1 = 174(0xae, float:2.44E-43)
            r3 = -1
            if (r0 == r1) goto L_0x018c
            r1 = 19899(0x4dbb, float:2.7884E-41)
            r5 = -1
            r2 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r0 == r1) goto L_0x0173
            r1 = 25152(0x6240, float:3.5245E-41)
            if (r0 == r1) goto L_0x013f
            r1 = 28032(0x6d80, float:3.9281E-41)
            if (r0 == r1) goto L_0x0128
            r1 = 357149030(0x1549a966, float:4.072526E-26)
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == r1) goto L_0x0110
            r1 = 374648427(0x1654ae6b, float:1.718026E-25)
            if (r0 == r1) goto L_0x00f9
            if (r0 == r2) goto L_0x0037
            goto L_0x0182
        L_0x0037:
            boolean r0 = r7.zzA
            if (r0 != 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zztd r0 = r7.zzaf
            com.google.android.gms.internal.ads.zzakb r1 = r7.zzH
            com.google.android.gms.internal.ads.zzakb r2 = r7.zzI
            long r12 = r7.zzv
            r14 = 0
            int r16 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r16 == 0) goto L_0x00e6
            long r5 = r7.zzy
            int r12 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x00e6
            if (r1 == 0) goto L_0x00e6
            int r5 = r1.zzc()
            if (r5 == 0) goto L_0x00e6
            if (r2 == 0) goto L_0x00e6
            int r5 = r2.zzc()
            int r6 = r1.zzc()
            if (r5 == r6) goto L_0x0065
            goto L_0x00e6
        L_0x0065:
            int r5 = r1.zzc()
            int[] r6 = new int[r5]
            long[] r10 = new long[r5]
            long[] r11 = new long[r5]
            long[] r12 = new long[r5]
            r13 = 0
        L_0x0072:
            if (r13 >= r5) goto L_0x0087
            long r16 = r1.zzb(r13)
            r12[r13] = r16
            long r8 = r7.zzv
            long r18 = r2.zzb(r13)
            long r18 = r18 + r8
            r10[r13] = r18
            int r13 = r13 + 1
            goto L_0x0072
        L_0x0087:
            r9 = 0
        L_0x0088:
            int r1 = r5 + -1
            if (r9 >= r1) goto L_0x00a2
            int r1 = r9 + 1
            r17 = r10[r1]
            r19 = r10[r9]
            long r3 = r17 - r19
            int r2 = (int) r3
            r6[r9] = r2
            r2 = r12[r1]
            r17 = r12[r9]
            long r2 = r2 - r17
            r11[r9] = r2
            r9 = r1
            r3 = -1
            goto L_0x0088
        L_0x00a2:
            long r2 = r7.zzv
            long r4 = r7.zzu
            long r2 = r2 + r4
            r4 = r10[r1]
            long r2 = r2 - r4
            int r3 = (int) r2
            r6[r1] = r3
            long r2 = r7.zzy
            r4 = r12[r1]
            long r2 = r2 - r4
            r11[r1] = r2
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 > 0) goto L_0x00e0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r5 = 72
            r4.<init>(r5)
            java.lang.String r5 = "Discarding last cue point with unexpected duration: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r3 = "MatroskaExtractor"
            android.util.Log.w(r3, r2)
            int[] r6 = java.util.Arrays.copyOf(r6, r1)
            long[] r10 = java.util.Arrays.copyOf(r10, r1)
            long[] r11 = java.util.Arrays.copyOf(r11, r1)
            long[] r12 = java.util.Arrays.copyOf(r12, r1)
        L_0x00e0:
            com.google.android.gms.internal.ads.zzsv r1 = new com.google.android.gms.internal.ads.zzsv
            r1.<init>(r6, r10, r11, r12)
            goto L_0x00ed
        L_0x00e6:
            com.google.android.gms.internal.ads.zztu r1 = new com.google.android.gms.internal.ads.zztu
            long r2 = r7.zzy
            r1.<init>(r2, r14)
        L_0x00ed:
            r0.zzbm(r1)
            r0 = 1
            r7.zzA = r0
        L_0x00f3:
            r0 = 0
            r7.zzH = r0
            r7.zzI = r0
            return
        L_0x00f9:
            r0 = 0
            android.util.SparseArray<com.google.android.gms.internal.ads.zzvi> r1 = r7.zzh
            int r1 = r1.size()
            if (r1 == 0) goto L_0x0108
            com.google.android.gms.internal.ads.zztd r0 = r7.zzaf
            r0.zzbl()
            return
        L_0x0108:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "No valid tracks were found"
            r1.<init>(r2, r0)
            throw r1
        L_0x0110:
            long r0 = r7.zzw
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x011b
            r0 = 1000000(0xf4240, double:4.940656E-318)
            r7.zzw = r0
        L_0x011b:
            long r0 = r7.zzx
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x0182
            long r0 = r7.zzy(r0)
            r7.zzy = r0
            return
        L_0x0128:
            r21.zzp(r22)
            com.google.android.gms.internal.ads.zzvi r0 = r7.zzz
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x0182
            byte[] r0 = r0.zzh
            if (r0 != 0) goto L_0x0136
            goto L_0x0182
        L_0x0136:
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r1 = "Combining encryption and compression is not supported"
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        L_0x013f:
            r21.zzp(r22)
            com.google.android.gms.internal.ads.zzvi r0 = r7.zzz
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x0182
            com.google.android.gms.internal.ads.zzty r1 = r0.zzi
            if (r1 == 0) goto L_0x016a
            com.google.android.gms.internal.ads.zzsa r1 = new com.google.android.gms.internal.ads.zzsa
            r2 = 1
            com.google.android.gms.internal.ads.zzrz[] r2 = new com.google.android.gms.internal.ads.zzrz[r2]
            com.google.android.gms.internal.ads.zzrz r3 = new com.google.android.gms.internal.ads.zzrz
            java.util.UUID r4 = com.google.android.gms.internal.ads.zzig.zza
            com.google.android.gms.internal.ads.zzvi r5 = r7.zzz
            com.google.android.gms.internal.ads.zzty r5 = r5.zzi
            byte[] r5 = r5.zzb
            java.lang.String r6 = "video/webm"
            r8 = 0
            r3.<init>(r4, r8, r6, r5)
            r4 = 0
            r2[r4] = r3
            r1.<init>(r8, r2)
            r0.zzk = r1
            return
        L_0x016a:
            r8 = 0
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r1 = "Encrypted Track found but ContentEncKeyID was not found"
            r0.<init>(r1, r8)
            throw r0
        L_0x0173:
            int r0 = r7.zzB
            r1 = -1
            if (r0 == r1) goto L_0x0183
            long r3 = r7.zzC
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0183
            if (r0 != r2) goto L_0x0182
            r7.zzE = r3
        L_0x0182:
            return
        L_0x0183:
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r1 = "Mandatory element SeekID or SeekPosition not found"
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        L_0x018c:
            r1 = -1
            com.google.android.gms.internal.ads.zzvi r0 = r7.zzz
            com.google.android.gms.internal.ads.zzajg.zze(r0)
            java.lang.String r3 = r0.zzb
            if (r3 == 0) goto L_0x0325
            int r4 = r3.hashCode()
            switch(r4) {
                case -2095576542: goto L_0x0303;
                case -2095575984: goto L_0x02f9;
                case -1985379776: goto L_0x02ee;
                case -1784763192: goto L_0x02e3;
                case -1730367663: goto L_0x02d8;
                case -1482641358: goto L_0x02cd;
                case -1482641357: goto L_0x02c2;
                case -1373388978: goto L_0x02b7;
                case -933872740: goto L_0x02ac;
                case -538363189: goto L_0x02a1;
                case -538363109: goto L_0x0296;
                case -425012669: goto L_0x028a;
                case -356037306: goto L_0x027e;
                case 62923557: goto L_0x0272;
                case 62923603: goto L_0x0266;
                case 62927045: goto L_0x025a;
                case 82318131: goto L_0x0250;
                case 82338133: goto L_0x0245;
                case 82338134: goto L_0x023a;
                case 99146302: goto L_0x022e;
                case 444813526: goto L_0x0222;
                case 542569478: goto L_0x0216;
                case 635596514: goto L_0x020a;
                case 725948237: goto L_0x01fe;
                case 725957860: goto L_0x01f2;
                case 738597099: goto L_0x01e6;
                case 855502857: goto L_0x01da;
                case 1422270023: goto L_0x01ce;
                case 1809237540: goto L_0x01c3;
                case 1950749482: goto L_0x01b7;
                case 1950789798: goto L_0x01ab;
                case 1951062397: goto L_0x019f;
                default: goto L_0x019d;
            }
        L_0x019d:
            goto L_0x030d
        L_0x019f:
            java.lang.String r2 = "A_OPUS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 11
            goto L_0x030e
        L_0x01ab:
            java.lang.String r2 = "A_FLAC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 22
            goto L_0x030e
        L_0x01b7:
            java.lang.String r2 = "A_EAC3"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 17
            goto L_0x030e
        L_0x01c3:
            java.lang.String r2 = "V_MPEG2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 3
            goto L_0x030e
        L_0x01ce:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 27
            goto L_0x030e
        L_0x01da:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 8
            goto L_0x030e
        L_0x01e6:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 28
            goto L_0x030e
        L_0x01f2:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 24
            goto L_0x030e
        L_0x01fe:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 25
            goto L_0x030e
        L_0x020a:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 26
            goto L_0x030e
        L_0x0216:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 20
            goto L_0x030e
        L_0x0222:
            java.lang.String r2 = "V_THEORA"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 10
            goto L_0x030e
        L_0x022e:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 30
            goto L_0x030e
        L_0x023a:
            java.lang.String r2 = "V_VP9"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 1
            goto L_0x030e
        L_0x0245:
            java.lang.String r2 = "V_VP8"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 0
            goto L_0x030e
        L_0x0250:
            java.lang.String r4 = "V_AV1"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x030d
            goto L_0x030e
        L_0x025a:
            java.lang.String r2 = "A_DTS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 19
            goto L_0x030e
        L_0x0266:
            java.lang.String r2 = "A_AC3"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 16
            goto L_0x030e
        L_0x0272:
            java.lang.String r2 = "A_AAC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 13
            goto L_0x030e
        L_0x027e:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 21
            goto L_0x030e
        L_0x028a:
            java.lang.String r2 = "S_VOBSUB"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 29
            goto L_0x030e
        L_0x0296:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 7
            goto L_0x030e
        L_0x02a1:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 5
            goto L_0x030e
        L_0x02ac:
            java.lang.String r2 = "S_DVBSUB"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 31
            goto L_0x030e
        L_0x02b7:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 9
            goto L_0x030e
        L_0x02c2:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 15
            goto L_0x030e
        L_0x02cd:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 14
            goto L_0x030e
        L_0x02d8:
            java.lang.String r2 = "A_VORBIS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 12
            goto L_0x030e
        L_0x02e3:
            java.lang.String r2 = "A_TRUEHD"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 18
            goto L_0x030e
        L_0x02ee:
            java.lang.String r2 = "A_MS/ACM"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 23
            goto L_0x030e
        L_0x02f9:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 4
            goto L_0x030e
        L_0x0303:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x030d
            r2 = 6
            goto L_0x030e
        L_0x030d:
            r2 = -1
        L_0x030e:
            switch(r2) {
                case 0: goto L_0x0313;
                case 1: goto L_0x0313;
                case 2: goto L_0x0313;
                case 3: goto L_0x0313;
                case 4: goto L_0x0313;
                case 5: goto L_0x0313;
                case 6: goto L_0x0313;
                case 7: goto L_0x0313;
                case 8: goto L_0x0313;
                case 9: goto L_0x0313;
                case 10: goto L_0x0313;
                case 11: goto L_0x0313;
                case 12: goto L_0x0313;
                case 13: goto L_0x0313;
                case 14: goto L_0x0313;
                case 15: goto L_0x0313;
                case 16: goto L_0x0313;
                case 17: goto L_0x0313;
                case 18: goto L_0x0313;
                case 19: goto L_0x0313;
                case 20: goto L_0x0313;
                case 21: goto L_0x0313;
                case 22: goto L_0x0313;
                case 23: goto L_0x0313;
                case 24: goto L_0x0313;
                case 25: goto L_0x0313;
                case 26: goto L_0x0313;
                case 27: goto L_0x0313;
                case 28: goto L_0x0313;
                case 29: goto L_0x0313;
                case 30: goto L_0x0313;
                case 31: goto L_0x0313;
                default: goto L_0x0311;
            }
        L_0x0311:
            r0 = 0
            goto L_0x0322
        L_0x0313:
            com.google.android.gms.internal.ads.zztd r1 = r7.zzaf
            int r2 = r0.zzc
            r0.zza(r1, r2)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzvi> r1 = r7.zzh
            int r2 = r0.zzc
            r1.put(r2, r0)
            goto L_0x0311
        L_0x0322:
            r7.zzz = r0
            return
        L_0x0325:
            r0 = 0
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "CodecId is missing in TrackEntry element"
            r1.<init>(r2, r0)
            throw r1
        L_0x032e:
            int r0 = r7.zzL
            if (r0 != r2) goto L_0x0383
            r0 = 0
            r4 = 0
        L_0x0334:
            int r1 = r7.zzP
            if (r4 >= r1) goto L_0x0340
            int[] r1 = r7.zzQ
            r1 = r1[r4]
            int r0 = r0 + r1
            int r4 = r4 + 1
            goto L_0x0334
        L_0x0340:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzvi> r1 = r7.zzh
            int r2 = r7.zzR
            java.lang.Object r1 = r1.get(r2)
            r8 = r1
            com.google.android.gms.internal.ads.zzvi r8 = (com.google.android.gms.internal.ads.zzvi) r8
            com.google.android.gms.internal.ads.zzvi.zzb(r8)
            r4 = 0
        L_0x034f:
            int r1 = r7.zzP
            if (r4 >= r1) goto L_0x0380
            long r1 = r7.zzM
            int r3 = r8.zze
            int r3 = r3 * r4
            int r3 = r3 / 1000
            long r5 = (long) r3
            long r5 = r5 + r1
            int r1 = r7.zzT
            if (r4 != 0) goto L_0x036a
            boolean r2 = r7.zzV
            if (r2 != 0) goto L_0x0367
            r1 = r1 | 1
        L_0x0367:
            r4 = r1
            r9 = 0
            goto L_0x036c
        L_0x036a:
            r9 = r4
            r4 = r1
        L_0x036c:
            int[] r1 = r7.zzQ
            r10 = r1[r9]
            int r11 = r0 - r10
            r0 = r21
            r1 = r8
            r2 = r5
            r5 = r10
            r6 = r11
            r0.zzr(r1, r2, r4, r5, r6)
            r0 = 1
            int r4 = r9 + 1
            r0 = r11
            goto L_0x034f
        L_0x0380:
            r1 = 0
            r7.zzL = r1
        L_0x0383:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvk.zzb(int):void");
    }

    @CallSuper
    public final void zzc(int i, long j) throws zzlg {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        zzp(i);
                        this.zzz.zzd = (int) j;
                        return;
                    case 136:
                        zzp(i);
                        zzvi zzvi = this.zzz;
                        if (j == 1) {
                            z = true;
                        }
                        zzvi.zzU = z;
                        return;
                    case 155:
                        this.zzN = zzy(j);
                        return;
                    case 159:
                        zzp(i);
                        this.zzz.zzN = (int) j;
                        return;
                    case 176:
                        zzp(i);
                        this.zzz.zzl = (int) j;
                        return;
                    case HSTypingIndicatorView.ALPHA_DARK /*179*/:
                        zzq(i);
                        this.zzH.zza(zzy(j));
                        return;
                    case 186:
                        zzp(i);
                        this.zzz.zzm = (int) j;
                        return;
                    case 215:
                        zzp(i);
                        this.zzz.zzc = (int) j;
                        return;
                    case 231:
                        this.zzG = zzy(j);
                        return;
                    case 238:
                        this.zzU = (int) j;
                        return;
                    case 241:
                        if (!this.zzJ) {
                            zzq(i);
                            this.zzI.zza(j);
                            this.zzJ = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzV = true;
                        return;
                    case 16871:
                        zzp(i);
                        int unused = this.zzz.zzX = (int) j;
                        return;
                    case 16980:
                        if (j != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j);
                            sb.append(" not supported");
                            throw new zzlg(sb.toString(), (Throwable) null);
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j);
                            sb2.append(" not supported");
                            throw new zzlg(sb2.toString(), (Throwable) null);
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j);
                            sb3.append(" not supported");
                            throw new zzlg(sb3.toString(), (Throwable) null);
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j);
                            sb4.append(" not supported");
                            throw new zzlg(sb4.toString(), (Throwable) null);
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j);
                            sb5.append(" not supported");
                            throw new zzlg(sb5.toString(), (Throwable) null);
                        }
                        return;
                    case 21420:
                        this.zzC = j + this.zzv;
                        return;
                    case 21432:
                        zzp(i);
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.zzz.zzv = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzz.zzv = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzz.zzv = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzz.zzv = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        zzp(i);
                        this.zzz.zzn = (int) j;
                        return;
                    case 21682:
                        zzp(i);
                        this.zzz.zzp = (int) j;
                        return;
                    case 21690:
                        zzp(i);
                        this.zzz.zzo = (int) j;
                        return;
                    case 21930:
                        zzp(i);
                        zzvi zzvi2 = this.zzz;
                        if (j == 1) {
                            z = true;
                        }
                        zzvi2.zzT = z;
                        return;
                    case 21998:
                        zzp(i);
                        this.zzz.zzf = (int) j;
                        return;
                    case 22186:
                        zzp(i);
                        this.zzz.zzQ = j;
                        return;
                    case 22203:
                        zzp(i);
                        this.zzz.zzR = j;
                        return;
                    case 25188:
                        zzp(i);
                        this.zzz.zzO = (int) j;
                        return;
                    case 30321:
                        zzp(i);
                        int i3 = (int) j;
                        if (i3 == 0) {
                            this.zzz.zzq = 0;
                            return;
                        } else if (i3 == 1) {
                            this.zzz.zzq = 1;
                            return;
                        } else if (i3 == 2) {
                            this.zzz.zzq = 2;
                            return;
                        } else if (i3 == 3) {
                            this.zzz.zzq = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        zzp(i);
                        this.zzz.zze = (int) j;
                        return;
                    case 2807729:
                        this.zzw = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                zzp(i);
                                int i4 = (int) j;
                                if (i4 == 1) {
                                    this.zzz.zzz = 2;
                                    return;
                                } else if (i4 == 2) {
                                    this.zzz.zzz = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                zzp(i);
                                int i5 = (int) j;
                                if (i5 != 1) {
                                    if (i5 == 16) {
                                        this.zzz.zzy = 6;
                                        return;
                                    } else if (i5 == 18) {
                                        this.zzz.zzy = 7;
                                        return;
                                    } else if (!(i5 == 6 || i5 == 7)) {
                                        return;
                                    }
                                }
                                this.zzz.zzy = 3;
                                return;
                            case 21947:
                                zzp(i);
                                zzvi zzvi3 = this.zzz;
                                zzvi3.zzw = true;
                                int i6 = (int) j;
                                if (i6 == 1) {
                                    zzvi3.zzx = 1;
                                    return;
                                } else if (i6 == 9) {
                                    zzvi3.zzx = 6;
                                    return;
                                } else if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                    zzvi3.zzx = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                zzp(i);
                                this.zzz.zzA = (int) j;
                                return;
                            case 21949:
                                zzp(i);
                                this.zzz.zzB = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzlg(sb6.toString(), (Throwable) null);
            }
        } else if (j != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j);
            sb7.append(" not supported");
            throw new zzlg(sb7.toString(), (Throwable) null);
        }
    }

    public final boolean zzd(zztb zztb) throws IOException {
        return new zzvl().zza(zztb);
    }

    public final void zze(zztd zztd) {
        this.zzaf = zztd;
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        this.zzK = false;
        while (!this.zzK) {
            if (this.zzag.zzc(zztb)) {
                long zzn2 = zztb.zzn();
                if (this.zzD) {
                    this.zzF = zzn2;
                    zzts.zza = this.zzE;
                    this.zzD = false;
                    return 1;
                } else if (this.zzA) {
                    long j = this.zzF;
                    if (j != -1) {
                        zzts.zza = j;
                        this.zzF = -1;
                        return 1;
                    }
                }
            } else {
                for (int i = 0; i < this.zzh.size(); i++) {
                    zzvi valueAt = this.zzh.valueAt(i);
                    zzvi.zzb(valueAt);
                    zzvj zzvj = valueAt.zzS;
                    if (zzvj != null) {
                        zzvj.zzd(valueAt);
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    @CallSuper
    public final void zzg(long j, long j2) {
        this.zzG = -9223372036854775807L;
        this.zzL = 0;
        this.zzag.zzb();
        this.zzg.zza();
        zzu();
        for (int i = 0; i < this.zzh.size(); i++) {
            zzvj zzvj = this.zzh.valueAt(i).zzS;
            if (zzvj != null) {
                zzvj.zza();
            }
        }
    }

    @CallSuper
    public final void zzh(int i, double d) throws zzlg {
        if (i == 181) {
            zzp(i);
            this.zzz.zzP = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    zzp(i);
                    this.zzz.zzC = (float) d;
                    return;
                case 21970:
                    zzp(i);
                    this.zzz.zzD = (float) d;
                    return;
                case 21971:
                    zzp(i);
                    this.zzz.zzE = (float) d;
                    return;
                case 21972:
                    zzp(i);
                    this.zzz.zzF = (float) d;
                    return;
                case 21973:
                    zzp(i);
                    this.zzz.zzG = (float) d;
                    return;
                case 21974:
                    zzp(i);
                    this.zzz.zzH = (float) d;
                    return;
                case 21975:
                    zzp(i);
                    this.zzz.zzI = (float) d;
                    return;
                case 21976:
                    zzp(i);
                    this.zzz.zzJ = (float) d;
                    return;
                case 21977:
                    zzp(i);
                    this.zzz.zzK = (float) d;
                    return;
                case 21978:
                    zzp(i);
                    this.zzz.zzL = (float) d;
                    return;
                default:
                    switch (i) {
                        case 30323:
                            zzp(i);
                            this.zzz.zzr = (float) d;
                            return;
                        case 30324:
                            zzp(i);
                            this.zzz.zzs = (float) d;
                            return;
                        case 30325:
                            zzp(i);
                            this.zzz.zzt = (float) d;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.zzx = (long) d;
        }
    }

    @CallSuper
    public final void zzi(int i, String str) throws zzlg {
        if (i == 134) {
            zzp(i);
            this.zzz.zzb = str;
        } else if (i != 17026) {
            if (i == 21358) {
                zzp(i);
                this.zzz.zza = str;
            } else if (i == 2274716) {
                zzp(i);
                String unused = this.zzz.zzY = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw new zzlg(GeneratedOutlineSupport.outline19(new StringBuilder(str.length() + 22), "DocType ", str, " not supported"), (Throwable) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0270, code lost:
        throw new com.google.android.gms.internal.ads.zzlg("EBML lacing sample size out of range.", (java.lang.Throwable) null);
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(int r17, int r18, com.google.android.gms.internal.ads.zztb r19) throws java.io.IOException {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            r1 = r18
            r8 = r19
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 0
            r4 = 4
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            if (r0 == r2) goto L_0x010a
            if (r0 == r5) goto L_0x010a
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L_0x00d4
            r2 = 16877(0x41ed, float:2.365E-41)
            if (r0 == r2) goto L_0x00aa
            r2 = 16981(0x4255, float:2.3795E-41)
            if (r0 == r2) goto L_0x009a
            r2 = 18402(0x47e2, float:2.5787E-41)
            if (r0 == r2) goto L_0x0085
            r2 = 21419(0x53ab, float:3.0014E-41)
            if (r0 == r2) goto L_0x005f
            r2 = 25506(0x63a2, float:3.5742E-41)
            if (r0 == r2) goto L_0x004f
            r2 = 30322(0x7672, float:4.249E-41)
            if (r0 != r2) goto L_0x0041
            r16.zzp(r17)
            com.google.android.gms.internal.ads.zzvi r0 = r7.zzz
            byte[] r2 = new byte[r1]
            r0.zzu = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzsx r0 = (com.google.android.gms.internal.ads.zzsx) r0
            r0.zzb(r2, r10, r1, r10)
            return
        L_0x0041:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            r2 = 26
            java.lang.String r4 = "Unexpected id: "
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r2, r4, r0)
            r1.<init>(r0, r3)
            throw r1
        L_0x004f:
            r16.zzp(r17)
            com.google.android.gms.internal.ads.zzvi r0 = r7.zzz
            byte[] r2 = new byte[r1]
            r0.zzj = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzsx r0 = (com.google.android.gms.internal.ads.zzsx) r0
            r0.zzb(r2, r10, r1, r10)
            return
        L_0x005f:
            com.google.android.gms.internal.ads.zzakr r0 = r7.zzn
            byte[] r0 = r0.zzi()
            java.util.Arrays.fill(r0, r10)
            com.google.android.gms.internal.ads.zzakr r0 = r7.zzn
            byte[] r0 = r0.zzi()
            r2 = r8
            com.google.android.gms.internal.ads.zzsx r2 = (com.google.android.gms.internal.ads.zzsx) r2
            int r3 = 4 - r1
            r2.zzb(r0, r3, r1, r10)
            com.google.android.gms.internal.ads.zzakr r0 = r7.zzn
            r0.zzh(r10)
            com.google.android.gms.internal.ads.zzakr r0 = r7.zzn
            long r0 = r0.zzt()
            int r1 = (int) r0
            r7.zzB = r1
            return
        L_0x0085:
            byte[] r2 = new byte[r1]
            r3 = r8
            com.google.android.gms.internal.ads.zzsx r3 = (com.google.android.gms.internal.ads.zzsx) r3
            r3.zzb(r2, r10, r1, r10)
            r16.zzp(r17)
            com.google.android.gms.internal.ads.zzvi r0 = r7.zzz
            com.google.android.gms.internal.ads.zzty r1 = new com.google.android.gms.internal.ads.zzty
            r1.<init>(r9, r2, r10, r10)
            r0.zzi = r1
            return
        L_0x009a:
            r16.zzp(r17)
            com.google.android.gms.internal.ads.zzvi r0 = r7.zzz
            byte[] r2 = new byte[r1]
            r0.zzh = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzsx r0 = (com.google.android.gms.internal.ads.zzsx) r0
            r0.zzb(r2, r10, r1, r10)
            return
        L_0x00aa:
            r16.zzp(r17)
            com.google.android.gms.internal.ads.zzvi r0 = r7.zzz
            int r2 = r0.zzX
            r3 = 1685485123(0x64767643, float:1.8185683E22)
            if (r2 == r3) goto L_0x00c9
            int r2 = r0.zzX
            r3 = 1685480259(0x64766343, float:1.8180206E22)
            if (r2 != r3) goto L_0x00c2
            goto L_0x00c9
        L_0x00c2:
            r0 = r8
            com.google.android.gms.internal.ads.zzsx r0 = (com.google.android.gms.internal.ads.zzsx) r0
            r0.zze(r1, r10)
            return
        L_0x00c9:
            byte[] r2 = new byte[r1]
            r0.zzM = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzsx r0 = (com.google.android.gms.internal.ads.zzsx) r0
            r0.zzb(r2, r10, r1, r10)
            return
        L_0x00d4:
            int r0 = r7.zzL
            if (r0 == r6) goto L_0x00d9
            return
        L_0x00d9:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzvi> r0 = r7.zzh
            int r2 = r7.zzR
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.ads.zzvi r0 = (com.google.android.gms.internal.ads.zzvi) r0
            int r2 = r7.zzU
            if (r2 != r4) goto L_0x0103
            java.lang.String r0 = r0.zzb
            java.lang.String r2 = "V_VP9"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0103
            com.google.android.gms.internal.ads.zzakr r0 = r7.zzs
            r0.zza(r1)
            com.google.android.gms.internal.ads.zzakr r0 = r7.zzs
            byte[] r0 = r0.zzi()
            r2 = r8
            com.google.android.gms.internal.ads.zzsx r2 = (com.google.android.gms.internal.ads.zzsx) r2
            r2.zzb(r0, r10, r1, r10)
            return
        L_0x0103:
            r0 = r8
            com.google.android.gms.internal.ads.zzsx r0 = (com.google.android.gms.internal.ads.zzsx) r0
            r0.zze(r1, r10)
            return
        L_0x010a:
            int r2 = r7.zzL
            r5 = 8
            if (r2 != 0) goto L_0x012f
            com.google.android.gms.internal.ads.zzvm r2 = r7.zzg
            long r11 = r2.zzb(r8, r10, r9, r5)
            int r2 = (int) r11
            r7.zzR = r2
            com.google.android.gms.internal.ads.zzvm r2 = r7.zzg
            int r2 = r2.zzc()
            r7.zzS = r2
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zzN = r11
            r7.zzL = r9
            com.google.android.gms.internal.ads.zzakr r2 = r7.zzl
            r2.zza(r10)
        L_0x012f:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzvi> r2 = r7.zzh
            int r11 = r7.zzR
            java.lang.Object r2 = r2.get(r11)
            r11 = r2
            com.google.android.gms.internal.ads.zzvi r11 = (com.google.android.gms.internal.ads.zzvi) r11
            if (r11 != 0) goto L_0x0149
            int r0 = r7.zzS
            r2 = r8
            com.google.android.gms.internal.ads.zzsx r2 = (com.google.android.gms.internal.ads.zzsx) r2
            int r0 = r1 - r0
            r2.zze(r0, r10)
            r7.zzL = r10
            return
        L_0x0149:
            com.google.android.gms.internal.ads.zzvi.zzb(r11)
            int r2 = r7.zzL
            if (r2 != r9) goto L_0x02d1
            r2 = 3
            r7.zzs(r8, r2)
            com.google.android.gms.internal.ads.zzakr r12 = r7.zzl
            byte[] r12 = r12.zzi()
            byte r12 = r12[r6]
            r12 = r12 & 6
            int r12 = r12 >> r9
            r13 = 255(0xff, float:3.57E-43)
            if (r12 != 0) goto L_0x0176
            r7.zzP = r9
            int[] r2 = r7.zzQ
            int[] r2 = zzz(r2, r9)
            r7.zzQ = r2
            int r3 = r7.zzS
            int r1 = r1 - r3
            int r1 = r1 + -3
            r2[r10] = r1
            goto L_0x0282
        L_0x0176:
            r7.zzs(r8, r4)
            com.google.android.gms.internal.ads.zzakr r4 = r7.zzl
            byte[] r4 = r4.zzi()
            byte r4 = r4[r2]
            r4 = r4 & r13
            int r4 = r4 + r9
            r7.zzP = r4
            int[] r14 = r7.zzQ
            int[] r4 = zzz(r14, r4)
            r7.zzQ = r4
            if (r12 != r6) goto L_0x019c
            int r2 = r7.zzS
            int r3 = r7.zzP
            int r1 = r1 - r2
            int r1 = r1 + -4
            int r1 = r1 / r3
            java.util.Arrays.fill(r4, r10, r3, r1)
            goto L_0x0282
        L_0x019c:
            if (r12 != r9) goto L_0x01d2
            r2 = 0
            r3 = 0
            r4 = 4
        L_0x01a1:
            int r5 = r7.zzP
            int r5 = r5 + -1
            if (r2 >= r5) goto L_0x01c7
            int[] r5 = r7.zzQ
            r5[r2] = r10
        L_0x01ab:
            int r4 = r4 + r9
            r7.zzs(r8, r4)
            com.google.android.gms.internal.ads.zzakr r5 = r7.zzl
            byte[] r5 = r5.zzi()
            int r6 = r4 + -1
            byte r5 = r5[r6]
            r5 = r5 & r13
            int[] r6 = r7.zzQ
            r12 = r6[r2]
            int r12 = r12 + r5
            r6[r2] = r12
            if (r5 == r13) goto L_0x01ab
            int r3 = r3 + r12
            int r2 = r2 + 1
            goto L_0x01a1
        L_0x01c7:
            int[] r2 = r7.zzQ
            int r6 = r7.zzS
            int r1 = r1 - r6
            int r1 = r1 - r4
            int r1 = r1 - r3
            r2[r5] = r1
            goto L_0x0282
        L_0x01d2:
            if (r12 != r2) goto L_0x02c9
            r2 = 0
            r4 = 4
            r6 = 0
        L_0x01d7:
            int r12 = r7.zzP
            int r12 = r12 + -1
            if (r2 >= r12) goto L_0x0279
            int[] r12 = r7.zzQ
            r12[r2] = r10
            int r4 = r4 + 1
            r7.zzs(r8, r4)
            int r10 = r4 + -1
            com.google.android.gms.internal.ads.zzakr r12 = r7.zzl
            byte[] r12 = r12.zzi()
            byte r12 = r12[r10]
            if (r12 == 0) goto L_0x0271
            r12 = 0
        L_0x01f3:
            if (r12 >= r5) goto L_0x0242
            int r14 = 7 - r12
            int r9 = r9 << r14
            com.google.android.gms.internal.ads.zzakr r14 = r7.zzl
            byte[] r14 = r14.zzi()
            byte r14 = r14[r10]
            r14 = r14 & r9
            if (r14 == 0) goto L_0x023a
            int r4 = r4 + r12
            r7.zzs(r8, r4)
            int r14 = r10 + 1
            com.google.android.gms.internal.ads.zzakr r15 = r7.zzl
            byte[] r15 = r15.zzi()
            byte r10 = r15[r10]
            r10 = r10 & r13
            r9 = r9 ^ -1
            r9 = r9 & r10
            long r9 = (long) r9
        L_0x0216:
            if (r14 >= r4) goto L_0x022b
            int r13 = r14 + 1
            long r9 = r9 << r5
            com.google.android.gms.internal.ads.zzakr r5 = r7.zzl
            byte[] r5 = r5.zzi()
            byte r5 = r5[r14]
            r5 = r5 & 255(0xff, float:3.57E-43)
            long r14 = (long) r5
            long r9 = r9 | r14
            r5 = 8
            r14 = r13
            goto L_0x0216
        L_0x022b:
            if (r2 <= 0) goto L_0x0244
            r13 = 1
            int r12 = r12 * 7
            int r12 = r12 + 6
            long r12 = r13 << r12
            r14 = -1
            long r12 = r12 + r14
            long r9 = r9 - r12
            goto L_0x0244
        L_0x023a:
            int r12 = r12 + 1
            r9 = 1
            r5 = 8
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x01f3
        L_0x0242:
            r9 = 0
        L_0x0244:
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x0269
            r12 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r5 > 0) goto L_0x0269
            int r5 = (int) r9
            int[] r9 = r7.zzQ
            if (r2 == 0) goto L_0x025c
            int r10 = r2 + -1
            r10 = r9[r10]
            int r5 = r5 + r10
        L_0x025c:
            r9[r2] = r5
            int r6 = r6 + r5
            int r2 = r2 + 1
            r9 = 1
            r10 = 0
            r5 = 8
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x01d7
        L_0x0269:
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r1 = "EBML lacing sample size out of range."
            r0.<init>(r1, r3)
            throw r0
        L_0x0271:
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r1 = "No valid varint length mask found"
            r0.<init>(r1, r3)
            throw r0
        L_0x0279:
            int[] r2 = r7.zzQ
            int r3 = r7.zzS
            int r1 = r1 - r3
            int r1 = r1 - r4
            int r1 = r1 - r6
            r2[r12] = r1
        L_0x0282:
            com.google.android.gms.internal.ads.zzakr r1 = r7.zzl
            byte[] r1 = r1.zzi()
            r2 = 0
            byte r1 = r1[r2]
            com.google.android.gms.internal.ads.zzakr r2 = r7.zzl
            byte[] r2 = r2.zzi()
            r3 = 1
            byte r2 = r2[r3]
            long r3 = r7.zzG
            int r1 = r1 << 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            r1 = r1 | r2
            long r1 = (long) r1
            long r1 = r7.zzy(r1)
            long r3 = r3 + r1
            r7.zzM = r3
            int r1 = r11.zzd
            r2 = 2
            if (r1 == r2) goto L_0x02c0
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x02be
            com.google.android.gms.internal.ads.zzakr r0 = r7.zzl
            byte[] r0 = r0.zzi()
            byte r0 = r0[r2]
            r1 = 128(0x80, float:1.794E-43)
            r0 = r0 & r1
            if (r0 != r1) goto L_0x02bc
            r0 = 163(0xa3, float:2.28E-43)
            goto L_0x02c0
        L_0x02bc:
            r0 = 163(0xa3, float:2.28E-43)
        L_0x02be:
            r1 = 0
            goto L_0x02c1
        L_0x02c0:
            r1 = 1
        L_0x02c1:
            r7.zzT = r1
            r7.zzL = r2
            r1 = 0
            r7.zzO = r1
            goto L_0x02d1
        L_0x02c9:
            com.google.android.gms.internal.ads.zzlg r0 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r1 = "Unexpected lacing value: 2"
            r0.<init>(r1, r3)
            throw r0
        L_0x02d1:
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x0303
        L_0x02d5:
            int r0 = r7.zzO
            int r1 = r7.zzP
            if (r0 >= r1) goto L_0x02ff
            int[] r1 = r7.zzQ
            r0 = r1[r0]
            int r5 = r7.zzt(r8, r11, r0)
            long r0 = r7.zzM
            int r2 = r7.zzO
            int r3 = r11.zze
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.zzT
            r6 = 0
            r0 = r16
            r1 = r11
            r0.zzr(r1, r2, r4, r5, r6)
            int r0 = r7.zzO
            int r0 = r0 + 1
            r7.zzO = r0
            goto L_0x02d5
        L_0x02ff:
            r0 = 0
            r7.zzL = r0
            return
        L_0x0303:
            int r0 = r7.zzO
            int r1 = r7.zzP
            if (r0 >= r1) goto L_0x031a
            int[] r1 = r7.zzQ
            r2 = r1[r0]
            int r2 = r7.zzt(r8, r11, r2)
            r1[r0] = r2
            int r0 = r7.zzO
            int r0 = r0 + 1
            r7.zzO = r0
            goto L_0x0303
        L_0x031a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvk.zzj(int, int, com.google.android.gms.internal.ads.zztb):void");
    }

    public zzvk(int i) {
        zzvd zzvd = new zzvd();
        this.zzv = -1;
        this.zzw = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzy = -9223372036854775807L;
        this.zzE = -1;
        this.zzF = -1;
        this.zzG = -9223372036854775807L;
        this.zzag = zzvd;
        zzvd.zza(new zzvh(this, (zzvg) null));
        this.zzi = true;
        this.zzg = new zzvm();
        this.zzh = new SparseArray<>();
        this.zzl = new zzakr(4);
        this.zzm = new zzakr(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzn = new zzakr(4);
        this.zzj = new zzakr(zzakj.zza);
        this.zzk = new zzakr(4);
        this.zzo = new zzakr();
        this.zzp = new zzakr();
        this.zzq = new zzakr(8);
        this.zzr = new zzakr();
        this.zzs = new zzakr();
        this.zzQ = new int[1];
    }
}
