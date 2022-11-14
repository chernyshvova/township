package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.core.app.FrameMetricsAggregator;
import androidx.drawerlayout.widget.DrawerLayout;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.support.views.HSTypingIndicatorView;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaqb implements zzapl {
    public static final zzapn zza = new zzapy();
    public static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] zzc = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    public static final UUID zzd = new UUID(72057594037932032L, -9223371306706625679L);
    public boolean zzA;
    public long zzB;
    public long zzC;
    public long zzD;
    public zzauo zzE;
    public zzauo zzF;
    public boolean zzG;
    public int zzH;
    public long zzI;
    public long zzJ;
    public int zzK;
    public int zzL;
    public int[] zzM;
    public int zzN;
    public int zzO;
    public int zzP;
    public int zzQ;
    public boolean zzR;
    public boolean zzS;
    public boolean zzT;
    public boolean zzU;
    public byte zzV;
    public int zzW;
    public int zzX;
    public int zzY;
    public boolean zzZ;
    public boolean zzaa;
    public zzapm zzab;
    public final zzapx zzac;
    public final zzaqd zze;
    public final SparseArray<zzaqa> zzf;
    public final boolean zzg;
    public final zzaut zzh;
    public final zzaut zzi;
    public final zzaut zzj;
    public final zzaut zzk;
    public final zzaut zzl;
    public final zzaut zzm;
    public final zzaut zzn;
    public final zzaut zzo;
    public final zzaut zzp;
    public ByteBuffer zzq;
    public long zzr;
    public long zzs;
    public long zzt;
    public long zzu;
    public long zzv;
    public zzaqa zzw;
    public boolean zzx;
    public int zzy;
    public long zzz;

    public zzaqb() {
        this(0);
    }

    public static final int zzl(int i) {
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
            case 241:
            case 251:
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
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case DrawerLayout.PEEK_DELAY:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
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
                return 5;
            default:
                return 0;
        }
    }

    public static final boolean zzm(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    private final void zzn(zzaqa zzaqa, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzaqa.zza)) {
            byte[] bArr2 = this.zzn.zza;
            long j2 = this.zzJ;
            if (j2 == -9223372036854775807L) {
                bArr = zzc;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArr = zzava.zzd(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (i3 * FrameMetricsAggregator.FrameMetricsApi24Impl.NANOS_PER_MS))) / 1000))}));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzapu zzapu = zzaqa.zzN;
            zzaut zzaut = this.zzn;
            zzapu.zzb(zzaut, zzaut.zze());
            this.zzY = this.zzn.zze() + this.zzY;
        }
        zzaqa.zzN.zzc(j, this.zzP, this.zzY, 0, zzaqa.zzg);
        this.zzZ = true;
        zzo();
    }

    private final void zzo() {
        this.zzQ = 0;
        this.zzY = 0;
        this.zzX = 0;
        this.zzR = false;
        this.zzS = false;
        this.zzU = false;
        this.zzW = 0;
        this.zzV = 0;
        this.zzT = false;
        this.zzm.zzc();
    }

    private final long zzp(long j) throws zzann {
        long j2 = this.zzt;
        if (j2 != -9223372036854775807L) {
            return zzava.zzj(j, j2, 1000);
        }
        throw new zzann("Can't scale timecode prior to timecodeScale being set.");
    }

    public static int[] zzq(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    private final void zzr(zzapk zzapk, int i) throws IOException, InterruptedException {
        if (this.zzj.zze() < i) {
            if (this.zzj.zzh() < i) {
                zzaut zzaut = this.zzj;
                byte[] bArr = zzaut.zza;
                int length = bArr.length;
                zzaut.zzb(Arrays.copyOf(bArr, Math.max(length + length, i)), this.zzj.zze());
            }
            zzaut zzaut2 = this.zzj;
            zzapk.zzb(zzaut2.zza, zzaut2.zze(), i - this.zzj.zze(), false);
            this.zzj.zzf(i);
        }
    }

    private final void zzs(zzapk zzapk, zzaqa zzaqa, int i) throws IOException, InterruptedException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzaqa.zza)) {
            int length = zzb.length;
            int i3 = i + 32;
            if (this.zzn.zzh() < i3) {
                this.zzn.zza = Arrays.copyOf(zzb, i3 + i);
            }
            byte[] bArr = this.zzn.zza;
            int length2 = zzb.length;
            zzapk.zzb(bArr, 32, i, false);
            this.zzn.zzi(0);
            this.zzn.zzf(i3);
            return;
        }
        zzapu zzapu = zzaqa.zzN;
        if (!this.zzR) {
            if (zzaqa.zze) {
                this.zzP &= -1073741825;
                int i4 = 128;
                if (!this.zzS) {
                    zzapk.zzb(this.zzj.zza, 0, 1, false);
                    this.zzQ++;
                    byte b = this.zzj.zza[0];
                    if ((b & 128) != 128) {
                        this.zzV = b;
                        this.zzS = true;
                    } else {
                        throw new zzann("Extension bit is set in signal byte");
                    }
                }
                byte b2 = this.zzV;
                if ((b2 & 1) == 1) {
                    byte b3 = b2 & 2;
                    this.zzP |= 1073741824;
                    if (!this.zzT) {
                        zzapk.zzb(this.zzo.zza, 0, 8, false);
                        this.zzQ += 8;
                        this.zzT = true;
                        zzaut zzaut = this.zzj;
                        byte[] bArr2 = zzaut.zza;
                        if (b3 != 2) {
                            i4 = 0;
                        }
                        bArr2[0] = (byte) (i4 | 8);
                        zzaut.zzi(0);
                        zzapu.zzb(this.zzj, 1);
                        this.zzY++;
                        this.zzo.zzi(0);
                        zzapu.zzb(this.zzo, 8);
                        this.zzY += 8;
                    }
                    if (b3 == 2) {
                        if (!this.zzU) {
                            zzapk.zzb(this.zzj.zza, 0, 1, false);
                            this.zzQ++;
                            this.zzj.zzi(0);
                            this.zzW = this.zzj.zzl();
                            this.zzU = true;
                        }
                        int i5 = this.zzW * 4;
                        this.zzj.zza(i5);
                        zzapk.zzb(this.zzj.zza, 0, i5, false);
                        this.zzQ += i5;
                        int i6 = (this.zzW >> 1) + 1;
                        int i7 = (i6 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzq;
                        if (byteBuffer == null || byteBuffer.capacity() < i7) {
                            this.zzq = ByteBuffer.allocate(i7);
                        }
                        this.zzq.position(0);
                        this.zzq.putShort((short) i6);
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            i2 = this.zzW;
                            if (i8 >= i2) {
                                break;
                            }
                            int zzu2 = this.zzj.zzu();
                            if (i8 % 2 == 0) {
                                this.zzq.putShort((short) (zzu2 - i9));
                            } else {
                                this.zzq.putInt(zzu2 - i9);
                            }
                            i8++;
                            i9 = zzu2;
                        }
                        int i10 = (i - this.zzQ) - i9;
                        if ((i2 & 1) == 1) {
                            this.zzq.putInt(i10);
                        } else {
                            this.zzq.putShort((short) i10);
                            this.zzq.putInt(0);
                        }
                        this.zzp.zzb(this.zzq.array(), i7);
                        zzapu.zzb(this.zzp, i7);
                        this.zzY += i7;
                    }
                }
            } else {
                byte[] bArr3 = zzaqa.zzf;
                if (bArr3 != null) {
                    this.zzm.zzb(bArr3, bArr3.length);
                }
            }
            this.zzR = true;
        }
        int zze2 = this.zzm.zze() + i;
        if (!"V_MPEG4/ISO/AVC".equals(zzaqa.zza) && !"V_MPEGH/ISO/HEVC".equals(zzaqa.zza)) {
            while (true) {
                int i11 = this.zzQ;
                if (i11 >= zze2) {
                    break;
                }
                zzt(zzapk, zzapu, zze2 - i11);
            }
        } else {
            byte[] bArr4 = this.zzi.zza;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i12 = zzaqa.zzO;
            int i13 = 4 - i12;
            while (this.zzQ < zze2) {
                int i14 = this.zzX;
                if (i14 == 0) {
                    int min = Math.min(i12, this.zzm.zzd());
                    zzapk.zzb(bArr4, i13 + min, i12 - min, false);
                    if (min > 0) {
                        this.zzm.zzk(bArr4, i13, min);
                    }
                    this.zzQ += i12;
                    this.zzi.zzi(0);
                    this.zzX = this.zzi.zzu();
                    this.zzh.zzi(0);
                    zzapu.zzb(this.zzh, 4);
                    this.zzY += 4;
                } else {
                    this.zzX = i14 - zzt(zzapk, zzapu, i14);
                }
            }
        }
        if ("A_VORBIS".equals(zzaqa.zza)) {
            this.zzk.zzi(0);
            zzapu.zzb(this.zzk, 4);
            this.zzY += 4;
        }
    }

    private final int zzt(zzapk zzapk, zzapu zzapu, int i) throws IOException, InterruptedException {
        int i2;
        int zzd2 = this.zzm.zzd();
        if (zzd2 > 0) {
            i2 = Math.min(i, zzd2);
            zzapu.zzb(this.zzm, i2);
        } else {
            i2 = zzapu.zzd(zzapk, i, false);
        }
        this.zzQ += i2;
        this.zzY += i2;
        return i2;
    }

    public final void zza(int i, long j, long j2) throws zzann {
        if (i == 160) {
            this.zzaa = false;
        } else if (i == 174) {
            this.zzw = new zzaqa((zzapy) null);
        } else if (i == 187) {
            this.zzG = false;
        } else if (i == 19899) {
            this.zzy = -1;
            this.zzz = -1;
        } else if (i == 20533) {
            this.zzw.zze = true;
        } else if (i == 21968) {
            this.zzw.zzq = true;
        } else if (i == 408125543) {
            long j3 = this.zzs;
            if (j3 == -1 || j3 == j) {
                this.zzs = j;
                this.zzr = j2;
                return;
            }
            throw new zzann("Multiple Segment elements not supported");
        } else if (i == 475249515) {
            this.zzE = new zzauo(32);
            this.zzF = new zzauo(32);
        } else if (i != 524531317 || this.zzx) {
        } else {
            if (!this.zzg || this.zzB == -1) {
                this.zzab.zzc(new zzapr(this.zzv));
                this.zzx = true;
                return;
            }
            this.zzA = true;
        }
    }

    public final void zzb(int i) throws zzann {
        zzaps zzaps;
        zzauo zzauo;
        zzauo zzauo2;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i == 174) {
                String str = this.zzw.zza;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    zzaqa zzaqa = this.zzw;
                    zzaqa.zza(this.zzab, zzaqa.zzb);
                    SparseArray<zzaqa> sparseArray = this.zzf;
                    zzaqa zzaqa2 = this.zzw;
                    sparseArray.put(zzaqa2.zzb, zzaqa2);
                }
                this.zzw = null;
            } else if (i == 19899) {
                int i4 = this.zzy;
                if (i4 != -1) {
                    long j = this.zzz;
                    if (j != -1) {
                        if (i4 == 475249515) {
                            this.zzB = j;
                            return;
                        }
                        return;
                    }
                }
                throw new zzann("Mandatory element SeekID or SeekPosition not found");
            } else if (i == 25152) {
                zzaqa zzaqa3 = this.zzw;
                if (!zzaqa3.zze) {
                    return;
                }
                if (zzaqa3.zzg != null) {
                    zzaqa3.zzi = new zzaph(new zzapg(zzamv.zzb, "video/webm", this.zzw.zzg.zzb, false));
                    return;
                }
                throw new zzann("Encrypted Track found but ContentEncKeyID was not found");
            } else if (i == 28032) {
                zzaqa zzaqa4 = this.zzw;
                if (zzaqa4.zze && zzaqa4.zzf != null) {
                    throw new zzann("Combining encryption and compression is not supported");
                }
            } else if (i == 357149030) {
                if (this.zzt == -9223372036854775807L) {
                    this.zzt = 1000000;
                }
                long j2 = this.zzu;
                if (j2 != -9223372036854775807L) {
                    this.zzv = zzp(j2);
                }
            } else if (i != 374648427) {
                if (i == 475249515 && !this.zzx) {
                    zzapm zzapm = this.zzab;
                    if (this.zzs == -1 || this.zzv == -9223372036854775807L || (zzauo = this.zzE) == null || zzauo.zzc() == 0 || (zzauo2 = this.zzF) == null || zzauo2.zzc() != this.zzE.zzc()) {
                        this.zzE = null;
                        this.zzF = null;
                        zzaps = new zzapr(this.zzv);
                    } else {
                        int zzc2 = this.zzE.zzc();
                        int[] iArr = new int[zzc2];
                        long[] jArr = new long[zzc2];
                        long[] jArr2 = new long[zzc2];
                        long[] jArr3 = new long[zzc2];
                        for (int i5 = 0; i5 < zzc2; i5++) {
                            jArr3[i5] = this.zzE.zzb(i5);
                            jArr[i5] = this.zzF.zzb(i5) + this.zzs;
                        }
                        while (true) {
                            i2 = zzc2 - 1;
                            if (i3 >= i2) {
                                break;
                            }
                            int i6 = i3 + 1;
                            iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                            jArr2[i3] = jArr3[i6] - jArr3[i3];
                            i3 = i6;
                        }
                        iArr[i2] = (int) ((this.zzs + this.zzr) - jArr[i2]);
                        jArr2[i2] = this.zzv - jArr3[i2];
                        this.zzE = null;
                        this.zzF = null;
                        zzaps = new zzapj(iArr, jArr, jArr2, jArr3);
                    }
                    zzapm.zzc(zzaps);
                    this.zzx = true;
                }
            } else if (this.zzf.size() != 0) {
                this.zzab.zzbo();
            } else {
                throw new zzann("No valid tracks were found");
            }
        } else if (this.zzH == 2) {
            if (!this.zzaa) {
                this.zzP |= 1;
            }
            zzn(this.zzf.get(this.zzN), this.zzI);
            this.zzH = 0;
        }
    }

    public final void zzc(int i, long j) throws zzann {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        this.zzw.zzc = (int) j;
                        return;
                    case 136:
                        zzaqa zzaqa = this.zzw;
                        if (j == 1) {
                            z = true;
                        }
                        zzaqa.zzL = z;
                        return;
                    case 155:
                        this.zzJ = zzp(j);
                        return;
                    case 159:
                        this.zzw.zzG = (int) j;
                        return;
                    case 176:
                        this.zzw.zzj = (int) j;
                        return;
                    case HSTypingIndicatorView.ALPHA_DARK /*179*/:
                        this.zzE.zza(zzp(j));
                        return;
                    case 186:
                        this.zzw.zzk = (int) j;
                        return;
                    case 215:
                        this.zzw.zzb = (int) j;
                        return;
                    case 231:
                        this.zzD = zzp(j);
                        return;
                    case 241:
                        if (!this.zzG) {
                            this.zzF.zza(j);
                            this.zzG = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzaa = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j);
                            sb.append(" not supported");
                            throw new zzann(sb.toString());
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j);
                            sb2.append(" not supported");
                            throw new zzann(sb2.toString());
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j);
                            sb3.append(" not supported");
                            throw new zzann(sb3.toString());
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j);
                            sb4.append(" not supported");
                            throw new zzann(sb4.toString());
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j);
                            sb5.append(" not supported");
                            throw new zzann(sb5.toString());
                        }
                        return;
                    case 21420:
                        this.zzz = j + this.zzs;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.zzw.zzp = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzw.zzp = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzw.zzp = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzw.zzp = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.zzw.zzl = (int) j;
                        return;
                    case 21682:
                        this.zzw.zzn = (int) j;
                        return;
                    case 21690:
                        this.zzw.zzm = (int) j;
                        return;
                    case 21930:
                        zzaqa zzaqa2 = this.zzw;
                        if (j == 1) {
                            z = true;
                        }
                        zzaqa2.zzM = z;
                        return;
                    case 22186:
                        this.zzw.zzJ = j;
                        return;
                    case 22203:
                        this.zzw.zzK = j;
                        return;
                    case 25188:
                        this.zzw.zzH = (int) j;
                        return;
                    case 2352003:
                        this.zzw.zzd = (int) j;
                        return;
                    case 2807729:
                        this.zzt = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.zzw.zzt = 2;
                                    return;
                                } else if (i3 == 2) {
                                    this.zzw.zzt = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 16) {
                                        this.zzw.zzs = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.zzw.zzs = 7;
                                        return;
                                    } else if (!(i4 == 6 || i4 == 7)) {
                                        return;
                                    }
                                }
                                this.zzw.zzs = 3;
                                return;
                            case 21947:
                                zzaqa zzaqa3 = this.zzw;
                                zzaqa3.zzq = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    zzaqa3.zzr = 1;
                                    return;
                                } else if (i5 == 9) {
                                    zzaqa3.zzr = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    zzaqa3.zzr = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.zzw.zzu = (int) j;
                                return;
                            case 21949:
                                this.zzw.zzv = (int) j;
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
                throw new zzann(sb6.toString());
            }
        } else if (j != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j);
            sb7.append(" not supported");
            throw new zzann(sb7.toString());
        }
    }

    public final void zzd(zzapm zzapm) {
        this.zzab = zzapm;
    }

    public final void zze(long j, long j2) {
        this.zzD = -9223372036854775807L;
        this.zzH = 0;
        this.zzac.zza();
        this.zze.zza();
        zzo();
    }

    public final boolean zzf(zzapk zzapk) throws IOException, InterruptedException {
        return new zzaqc().zza(zzapk);
    }

    public final int zzg(zzapk zzapk, zzapq zzapq) throws IOException, InterruptedException {
        this.zzZ = false;
        while (!this.zzZ) {
            if (!this.zzac.zzc(zzapk)) {
                return -1;
            }
            long zzh2 = zzapk.zzh();
            if (this.zzA) {
                this.zzC = zzh2;
                zzapq.zza = this.zzB;
                this.zzA = false;
                return 1;
            } else if (this.zzx) {
                long j = this.zzC;
                if (j != -1) {
                    zzapq.zza = j;
                    this.zzC = -1;
                    return 1;
                }
            }
        }
        return 0;
    }

    public final void zzh(int i, double d) {
        if (i == 181) {
            this.zzw.zzI = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzw.zzw = (float) d;
                    return;
                case 21970:
                    this.zzw.zzx = (float) d;
                    return;
                case 21971:
                    this.zzw.zzy = (float) d;
                    return;
                case 21972:
                    this.zzw.zzz = (float) d;
                    return;
                case 21973:
                    this.zzw.zzA = (float) d;
                    return;
                case 21974:
                    this.zzw.zzB = (float) d;
                    return;
                case 21975:
                    this.zzw.zzC = (float) d;
                    return;
                case 21976:
                    this.zzw.zzD = (float) d;
                    return;
                case 21977:
                    this.zzw.zzE = (float) d;
                    return;
                case 21978:
                    this.zzw.zzF = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.zzu = (long) d;
        }
    }

    public final void zzi(int i, String str) throws zzann {
        if (i == 134) {
            this.zzw.zza = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                String unused = this.zzw.zzP = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw new zzann(GeneratedOutlineSupport.outline19(new StringBuilder(str.length() + 22), "DocType ", str, " not supported"));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01c5, code lost:
        throw new com.google.android.gms.internal.ads.zzann("EBML lacing sample size out of range.");
     */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0213  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzk(int r13, int r14, com.google.android.gms.internal.ads.zzapk r15) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r12 = this;
            r0 = 161(0xa1, float:2.26E-43)
            r1 = 163(0xa3, float:2.28E-43)
            r2 = 1
            r3 = 0
            if (r13 == r0) goto L_0x0078
            if (r13 == r1) goto L_0x0078
            r0 = 16981(0x4255, float:2.3795E-41)
            if (r13 == r0) goto L_0x006e
            r0 = 18402(0x47e2, float:2.5787E-41)
            if (r13 == r0) goto L_0x005f
            r0 = 21419(0x53ab, float:3.0014E-41)
            if (r13 == r0) goto L_0x0040
            r0 = 25506(0x63a2, float:3.5742E-41)
            if (r13 == r0) goto L_0x0036
            r0 = 30322(0x7672, float:4.249E-41)
            if (r13 != r0) goto L_0x0028
            com.google.android.gms.internal.ads.zzaqa r13 = r12.zzw
            byte[] r0 = new byte[r14]
            r13.zzo = r0
            r15.zzb(r0, r3, r14, r3)
            return
        L_0x0028:
            com.google.android.gms.internal.ads.zzann r14 = new com.google.android.gms.internal.ads.zzann
            r15 = 26
            java.lang.String r0 = "Unexpected id: "
            java.lang.String r13 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r15, r0, r13)
            r14.<init>(r13)
            throw r14
        L_0x0036:
            com.google.android.gms.internal.ads.zzaqa r13 = r12.zzw
            byte[] r0 = new byte[r14]
            r13.zzh = r0
            r15.zzb(r0, r3, r14, r3)
            return
        L_0x0040:
            com.google.android.gms.internal.ads.zzaut r13 = r12.zzl
            byte[] r13 = r13.zza
            java.util.Arrays.fill(r13, r3)
            com.google.android.gms.internal.ads.zzaut r13 = r12.zzl
            byte[] r13 = r13.zza
            int r0 = 4 - r14
            r15.zzb(r13, r0, r14, r3)
            com.google.android.gms.internal.ads.zzaut r13 = r12.zzl
            r13.zzi(r3)
            com.google.android.gms.internal.ads.zzaut r13 = r12.zzl
            long r13 = r13.zzp()
            int r14 = (int) r13
            r12.zzy = r14
            return
        L_0x005f:
            byte[] r13 = new byte[r14]
            r15.zzb(r13, r3, r14, r3)
            com.google.android.gms.internal.ads.zzaqa r14 = r12.zzw
            com.google.android.gms.internal.ads.zzapt r15 = new com.google.android.gms.internal.ads.zzapt
            r15.<init>(r2, r13)
            r14.zzg = r15
            return
        L_0x006e:
            com.google.android.gms.internal.ads.zzaqa r13 = r12.zzw
            byte[] r0 = new byte[r14]
            r13.zzf = r0
            r15.zzb(r0, r3, r14, r3)
            return
        L_0x0078:
            int r0 = r12.zzH
            r4 = 8
            if (r0 != 0) goto L_0x009d
            com.google.android.gms.internal.ads.zzaqd r0 = r12.zze
            long r5 = r0.zze(r15, r3, r2, r4)
            int r0 = (int) r5
            r12.zzN = r0
            com.google.android.gms.internal.ads.zzaqd r0 = r12.zze
            int r0 = r0.zzb()
            r12.zzO = r0
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r12.zzJ = r5
            r12.zzH = r2
            com.google.android.gms.internal.ads.zzaut r0 = r12.zzj
            r0.zzc()
        L_0x009d:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaqa> r0 = r12.zzf
            int r5 = r12.zzN
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.internal.ads.zzaqa r0 = (com.google.android.gms.internal.ads.zzaqa) r0
            if (r0 != 0) goto L_0x00b2
            int r13 = r12.zzO
            int r14 = r14 - r13
            r15.zzd(r14, r3)
            r12.zzH = r3
            return
        L_0x00b2:
            int r5 = r12.zzH
            if (r5 != r2) goto L_0x022e
            r5 = 3
            r12.zzr(r15, r5)
            com.google.android.gms.internal.ads.zzaut r6 = r12.zzj
            byte[] r6 = r6.zza
            r7 = 2
            byte r6 = r6[r7]
            r6 = r6 & 6
            int r6 = r6 >> r2
            r8 = 255(0xff, float:3.57E-43)
            if (r6 != 0) goto L_0x00db
            r12.zzL = r2
            int[] r1 = r12.zzM
            int[] r1 = zzq(r1, r2)
            r12.zzM = r1
            int r2 = r12.zzO
            int r14 = r14 - r2
            int r14 = r14 + -3
            r1[r3] = r14
            goto L_0x01d7
        L_0x00db:
            if (r13 != r1) goto L_0x0226
            r1 = 4
            r12.zzr(r15, r1)
            com.google.android.gms.internal.ads.zzaut r9 = r12.zzj
            byte[] r9 = r9.zza
            byte r9 = r9[r5]
            r9 = r9 & r8
            int r9 = r9 + r2
            r12.zzL = r9
            int[] r10 = r12.zzM
            int[] r9 = zzq(r10, r9)
            r12.zzM = r9
            if (r6 != r7) goto L_0x0102
            int r1 = r12.zzO
            int r2 = r12.zzL
            int r14 = r14 - r1
            int r14 = r14 + -4
            int r14 = r14 / r2
            java.util.Arrays.fill(r9, r3, r2, r14)
            goto L_0x01d7
        L_0x0102:
            if (r6 != r2) goto L_0x0135
            r5 = 0
            r6 = 0
        L_0x0106:
            int r7 = r12.zzL
            int r7 = r7 + -1
            if (r5 >= r7) goto L_0x012a
            int[] r7 = r12.zzM
            r7[r5] = r3
        L_0x0110:
            int r1 = r1 + r2
            r12.zzr(r15, r1)
            com.google.android.gms.internal.ads.zzaut r7 = r12.zzj
            byte[] r7 = r7.zza
            int r9 = r1 + -1
            byte r7 = r7[r9]
            r7 = r7 & r8
            int[] r9 = r12.zzM
            r10 = r9[r5]
            int r10 = r10 + r7
            r9[r5] = r10
            if (r7 == r8) goto L_0x0110
            int r6 = r6 + r10
            int r5 = r5 + 1
            goto L_0x0106
        L_0x012a:
            int[] r2 = r12.zzM
            int r3 = r12.zzO
            int r14 = r14 - r3
            int r14 = r14 - r1
            int r14 = r14 - r6
            r2[r7] = r14
            goto L_0x01d7
        L_0x0135:
            if (r6 != r5) goto L_0x021e
            r5 = 0
            r6 = 0
        L_0x0139:
            int r7 = r12.zzL
            int r7 = r7 + -1
            if (r5 >= r7) goto L_0x01ce
            int[] r7 = r12.zzM
            r7[r5] = r3
            int r1 = r1 + 1
            r12.zzr(r15, r1)
            int r3 = r1 + -1
            com.google.android.gms.internal.ads.zzaut r7 = r12.zzj
            byte[] r7 = r7.zza
            byte r7 = r7[r3]
            if (r7 == 0) goto L_0x01c6
            r7 = 0
        L_0x0153:
            if (r7 >= r4) goto L_0x0199
            int r9 = 7 - r7
            int r2 = r2 << r9
            com.google.android.gms.internal.ads.zzaut r9 = r12.zzj
            byte[] r9 = r9.zza
            byte r9 = r9[r3]
            r9 = r9 & r2
            if (r9 == 0) goto L_0x0193
            int r1 = r1 + r7
            r12.zzr(r15, r1)
            int r9 = r3 + 1
            com.google.android.gms.internal.ads.zzaut r10 = r12.zzj
            byte[] r10 = r10.zza
            byte r3 = r10[r3]
            r3 = r3 & r8
            r2 = r2 ^ -1
            r2 = r2 & r3
            long r2 = (long) r2
        L_0x0172:
            if (r9 >= r1) goto L_0x0184
            int r10 = r9 + 1
            long r2 = r2 << r4
            com.google.android.gms.internal.ads.zzaut r11 = r12.zzj
            byte[] r11 = r11.zza
            byte r9 = r11[r9]
            r8 = r8 & r9
            long r8 = (long) r8
            long r2 = r2 | r8
            r8 = 255(0xff, float:3.57E-43)
            r9 = r10
            goto L_0x0172
        L_0x0184:
            if (r5 <= 0) goto L_0x019b
            r8 = 1
            int r7 = r7 * 7
            int r7 = r7 + 6
            long r7 = r8 << r7
            r9 = -1
            long r7 = r7 + r9
            long r2 = r2 - r7
            goto L_0x019b
        L_0x0193:
            int r7 = r7 + 1
            r2 = 1
            r8 = 255(0xff, float:3.57E-43)
            goto L_0x0153
        L_0x0199:
            r2 = 0
        L_0x019b:
            r7 = -2147483648(0xffffffff80000000, double:NaN)
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x01be
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x01be
            int r3 = (int) r2
            int[] r2 = r12.zzM
            if (r5 == 0) goto L_0x01b3
            int r7 = r5 + -1
            r7 = r2[r7]
            int r3 = r3 + r7
        L_0x01b3:
            r2[r5] = r3
            int r6 = r6 + r3
            int r5 = r5 + 1
            r2 = 1
            r3 = 0
            r8 = 255(0xff, float:3.57E-43)
            goto L_0x0139
        L_0x01be:
            com.google.android.gms.internal.ads.zzann r13 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r14 = "EBML lacing sample size out of range."
            r13.<init>(r14)
            throw r13
        L_0x01c6:
            com.google.android.gms.internal.ads.zzann r13 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r14 = "No valid varint length mask found"
            r13.<init>(r14)
            throw r13
        L_0x01ce:
            int[] r2 = r12.zzM
            int r3 = r12.zzO
            int r14 = r14 - r3
            int r14 = r14 - r1
            int r14 = r14 - r6
            r2[r7] = r14
        L_0x01d7:
            com.google.android.gms.internal.ads.zzaut r14 = r12.zzj
            byte[] r14 = r14.zza
            r1 = 0
            byte r1 = r14[r1]
            r2 = 1
            byte r14 = r14[r2]
            long r2 = r12.zzD
            int r1 = r1 << 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r14 | r1
            long r5 = (long) r14
            long r5 = r12.zzp(r5)
            long r2 = r2 + r5
            r12.zzI = r2
            com.google.android.gms.internal.ads.zzaut r14 = r12.zzj
            byte[] r14 = r14.zza
            r1 = 2
            byte r14 = r14[r1]
            r2 = r14 & 8
            int r3 = r0.zzc
            if (r3 == r1) goto L_0x020d
            r1 = 163(0xa3, float:2.28E-43)
            if (r13 != r1) goto L_0x020b
            r13 = 128(0x80, float:1.794E-43)
            r14 = r14 & r13
            if (r14 != r13) goto L_0x0209
            r13 = 163(0xa3, float:2.28E-43)
            goto L_0x020d
        L_0x0209:
            r13 = 163(0xa3, float:2.28E-43)
        L_0x020b:
            r14 = 0
            goto L_0x020e
        L_0x020d:
            r14 = 1
        L_0x020e:
            if (r2 != r4) goto L_0x0213
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0214
        L_0x0213:
            r1 = 0
        L_0x0214:
            r14 = r14 | r1
            r12.zzP = r14
            r14 = 2
            r12.zzH = r14
            r14 = 0
            r12.zzK = r14
            goto L_0x022e
        L_0x021e:
            com.google.android.gms.internal.ads.zzann r13 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r14 = "Unexpected lacing value: 2"
            r13.<init>(r14)
            throw r13
        L_0x0226:
            com.google.android.gms.internal.ads.zzann r13 = new com.google.android.gms.internal.ads.zzann
            java.lang.String r14 = "Lacing only supported in SimpleBlocks."
            r13.<init>(r14)
            throw r13
        L_0x022e:
            r14 = 163(0xa3, float:2.28E-43)
            if (r13 != r14) goto L_0x0259
        L_0x0232:
            int r13 = r12.zzK
            int r14 = r12.zzL
            if (r13 >= r14) goto L_0x0255
            int[] r14 = r12.zzM
            r13 = r14[r13]
            r12.zzs(r15, r0, r13)
            long r13 = r12.zzI
            int r1 = r12.zzK
            int r2 = r0.zzd
            int r1 = r1 * r2
            int r1 = r1 / 1000
            long r1 = (long) r1
            long r13 = r13 + r1
            r12.zzn(r0, r13)
            int r13 = r12.zzK
            int r13 = r13 + 1
            r12.zzK = r13
            goto L_0x0232
        L_0x0255:
            r13 = 0
            r12.zzH = r13
            return
        L_0x0259:
            r13 = 0
            int[] r14 = r12.zzM
            r13 = r14[r13]
            r12.zzs(r15, r0, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqb.zzk(int, int, com.google.android.gms.internal.ads.zzapk):void");
    }

    public zzaqb(int i) {
        zzapx zzapx = new zzapx();
        this.zzs = -1;
        this.zzt = -9223372036854775807L;
        this.zzu = -9223372036854775807L;
        this.zzv = -9223372036854775807L;
        this.zzB = -1;
        this.zzC = -1;
        this.zzD = -9223372036854775807L;
        this.zzac = zzapx;
        zzapx.zzb(new zzapz(this, (zzapy) null));
        this.zzg = true;
        this.zze = new zzaqd();
        this.zzf = new SparseArray<>();
        this.zzj = new zzaut(4);
        this.zzk = new zzaut(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzl = new zzaut(4);
        this.zzh = new zzaut(zzaur.zza);
        this.zzi = new zzaut(4);
        this.zzm = new zzaut();
        this.zzn = new zzaut();
        this.zzo = new zzaut(8);
        this.zzp = new zzaut();
    }
}
