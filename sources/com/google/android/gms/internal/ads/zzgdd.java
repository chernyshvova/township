package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;
import com.vungle.warren.downloader.DownloadRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgdd extends zzgde {
    public final InputStream zzc;
    public final byte[] zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    public int zzj = Integer.MAX_VALUE;

    public /* synthetic */ zzgdd(InputStream inputStream, int i, zzgda zzgda) {
        super((zzgda) null);
        zzgem.zzb(inputStream, "input");
        this.zzc = inputStream;
        this.zzd = new byte[4096];
        this.zze = 0;
        this.zzg = 0;
        this.zzi = 0;
    }

    private final void zzI() {
        int i = this.zze + this.zzf;
        this.zze = i;
        int i2 = this.zzi + i;
        int i3 = this.zzj;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzf = i4;
            this.zze = i - i4;
            return;
        }
        this.zzf = 0;
    }

    private final void zzJ(int i) throws IOException {
        if (zzK(i)) {
            return;
        }
        if (i > (Integer.MAX_VALUE - this.zzi) - this.zzg) {
            throw zzgeo.zzj();
        }
        throw zzgeo.zzd();
    }

    private final boolean zzK(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zze;
        if (i2 + i > i3) {
            int i4 = this.zzi;
            if (i > (Integer.MAX_VALUE - i4) - i2 || i4 + i2 + i > this.zzj) {
                return false;
            }
            if (i2 > 0) {
                if (i3 > i2) {
                    byte[] bArr = this.zzd;
                    System.arraycopy(bArr, i2, bArr, 0, i3 - i2);
                }
                i4 = this.zzi + i2;
                this.zzi = i4;
                i3 = this.zze - i2;
                this.zze = i3;
                this.zzg = 0;
            }
            try {
                int read = this.zzc.read(this.zzd, i3, Math.min(4096 - i3, (Integer.MAX_VALUE - i4) - i3));
                if (read == 0 || read < -1 || read > 4096) {
                    String valueOf = String.valueOf(this.zzc.getClass());
                    StringBuilder sb = new StringBuilder(valueOf.length() + 91);
                    sb.append(valueOf);
                    sb.append("#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zze += read;
                    zzI();
                    if (this.zze >= i) {
                        return true;
                    }
                    return zzK(i);
                }
            } catch (zzgeo e) {
                e.zzb();
                throw e;
            }
        } else {
            throw new IllegalStateException(GeneratedOutlineSupport.outline10(77, "refillBuffer() called when ", i, " bytes were already available in buffer"));
        }
    }

    private final byte[] zzL(int i, boolean z) throws IOException {
        byte[] zzM = zzM(i);
        if (zzM != null) {
            return zzM;
        }
        int i2 = this.zzg;
        int i3 = this.zze;
        int i4 = i3 - i2;
        this.zzi += i3;
        this.zzg = 0;
        this.zze = 0;
        List<byte[]> zzN = zzN(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzd, i2, bArr, 0, i4);
        for (byte[] next : zzN) {
            int length = next.length;
            System.arraycopy(next, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzM(int i) throws IOException {
        if (i == 0) {
            return zzgem.zzc;
        }
        if (i >= 0) {
            int i2 = this.zzi;
            int i3 = this.zzg;
            int i4 = i2 + i3 + i;
            if (DownloadRequest.Priority.CRITICAL + i4 <= 0) {
                int i5 = this.zzj;
                if (i4 <= i5) {
                    int i6 = this.zze - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096) {
                        try {
                            if (i7 > this.zzc.available()) {
                                return null;
                            }
                        } catch (zzgeo e) {
                            e.zzb();
                            throw e;
                        }
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.zzd, this.zzg, bArr, 0, i6);
                    this.zzi += this.zze;
                    this.zzg = 0;
                    this.zze = 0;
                    while (i6 < i) {
                        try {
                            int read = this.zzc.read(bArr, i6, i - i6);
                            if (read != -1) {
                                this.zzi += read;
                                i6 += read;
                            } else {
                                throw zzgeo.zzd();
                            }
                        } catch (zzgeo e2) {
                            e2.zzb();
                            throw e2;
                        }
                    }
                    return bArr;
                }
                zzE((i5 - i2) - i3);
                throw zzgeo.zzd();
            }
            throw zzgeo.zzj();
        }
        throw zzgeo.zze();
    }

    private final List<byte[]> zzN(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zzc.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.zzi += read;
                    i2 += read;
                } else {
                    throw zzgeo.zzd();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final void zzA(int i) {
        this.zzj = i;
        zzI();
    }

    public final boolean zzB() throws IOException {
        return this.zzg == this.zze && !zzK(1);
    }

    public final int zzC() {
        return this.zzi + this.zzg;
    }

    public final byte zzD() throws IOException {
        if (this.zzg == this.zze) {
            zzJ(1);
        }
        byte[] bArr = this.zzd;
        int i = this.zzg;
        this.zzg = i + 1;
        return bArr[i];
    }

    public final void zzE(int i) throws IOException {
        int i2 = this.zze;
        int i3 = this.zzg;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzg = i3 + i;
        } else if (i >= 0) {
            int i5 = this.zzi;
            int i6 = i5 + i3;
            int i7 = this.zzj;
            if (i6 + i <= i7) {
                this.zzi = i6;
                this.zze = 0;
                this.zzg = 0;
                while (i4 < i) {
                    try {
                        long j = (long) (i - i4);
                        long skip = this.zzc.skip(j);
                        if (skip < 0 || skip > j) {
                            String valueOf = String.valueOf(this.zzc.getClass());
                            StringBuilder sb = new StringBuilder(valueOf.length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        } else if (skip == 0) {
                            break;
                        } else {
                            i4 += (int) skip;
                        }
                    } catch (zzgeo e) {
                        e.zzb();
                        throw e;
                    } catch (Throwable th) {
                        this.zzi += i4;
                        zzI();
                        throw th;
                    }
                }
                this.zzi += i4;
                zzI();
                if (i4 < i) {
                    int i8 = this.zze;
                    int i9 = i8 - this.zzg;
                    this.zzg = i8;
                    zzJ(1);
                    while (true) {
                        int i10 = i - i9;
                        int i11 = this.zze;
                        if (i10 > i11) {
                            i9 += i11;
                            this.zzg = i11;
                            zzJ(1);
                        } else {
                            this.zzg = i10;
                            return;
                        }
                    }
                }
            } else {
                zzE((i7 - i5) - i3);
                throw zzgeo.zzd();
            }
        } else {
            throw zzgeo.zze();
        }
    }

    public final int zza() throws IOException {
        if (zzB()) {
            this.zzh = 0;
            return 0;
        }
        int zzu = zzu();
        this.zzh = zzu;
        if ((zzu >>> 3) != 0) {
            return zzu;
        }
        throw zzgeo.zzg();
    }

    public final void zzb(int i) throws zzgeo {
        if (this.zzh != i) {
            throw zzgeo.zzh();
        }
    }

    public final boolean zzc(int i) throws IOException {
        int zza;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zze - this.zzg >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzd;
                    int i4 = this.zzg;
                    this.zzg = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzgeo.zzf();
            }
            while (i3 < 10) {
                if (zzD() < 0) {
                    i3++;
                }
            }
            throw zzgeo.zzf();
            return true;
        } else if (i2 == 1) {
            zzE(8);
            return true;
        } else if (i2 == 2) {
            zzE(zzu());
            return true;
        } else if (i2 == 3) {
            do {
                zza = zza();
                if (zza == 0 || !zzc(zza)) {
                    zzb(((i >>> 3) << 3) | 4);
                }
                zza = zza();
                break;
            } while (!zzc(zza));
            zzb(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzE(4);
                return true;
            }
            throw zzgeo.zzi();
        }
    }

    public final double zzd() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    public final float zze() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    public final long zzf() throws IOException {
        return zzv();
    }

    public final long zzg() throws IOException {
        return zzv();
    }

    public final int zzh() throws IOException {
        return zzu();
    }

    public final long zzi() throws IOException {
        return zzy();
    }

    public final int zzj() throws IOException {
        return zzx();
    }

    public final boolean zzk() throws IOException {
        return zzv() != 0;
    }

    public final String zzl() throws IOException {
        int zzu = zzu();
        if (zzu > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (zzu <= i - i2) {
                String str = new String(this.zzd, i2, zzu, zzgem.zza);
                this.zzg += zzu;
                return str;
            }
        }
        if (zzu == 0) {
            return "";
        }
        if (zzu > this.zze) {
            return new String(zzL(zzu, false), zzgem.zza);
        }
        zzJ(zzu);
        String str2 = new String(this.zzd, this.zzg, zzu, zzgem.zza);
        this.zzg += zzu;
        return str2;
    }

    public final String zzm() throws IOException {
        byte[] bArr;
        int zzu = zzu();
        int i = this.zzg;
        int i2 = this.zze;
        if (zzu <= i2 - i && zzu > 0) {
            bArr = this.zzd;
            this.zzg = i + zzu;
        } else if (zzu == 0) {
            return "";
        } else {
            if (zzu <= i2) {
                zzJ(zzu);
                bArr = this.zzd;
                this.zzg = zzu;
            } else {
                bArr = zzL(zzu, false);
            }
            i = 0;
        }
        return zzghd.zzg(bArr, i, zzu);
    }

    public final zzgcz zzn() throws IOException {
        int zzu = zzu();
        int i = this.zze;
        int i2 = this.zzg;
        if (zzu <= i - i2 && zzu > 0) {
            zzgcz zzs = zzgcz.zzs(this.zzd, i2, zzu);
            this.zzg += zzu;
            return zzs;
        } else if (zzu == 0) {
            return zzgcz.zzb;
        } else {
            byte[] zzM = zzM(zzu);
            if (zzM != null) {
                return zzgcz.zzt(zzM);
            }
            int i3 = this.zzg;
            int i4 = this.zze;
            int i5 = i4 - i3;
            this.zzi += i4;
            this.zzg = 0;
            this.zze = 0;
            List<byte[]> zzN = zzN(zzu - i5);
            byte[] bArr = new byte[zzu];
            System.arraycopy(this.zzd, i3, bArr, 0, i5);
            for (byte[] next : zzN) {
                int length = next.length;
                System.arraycopy(next, 0, bArr, i5, length);
                i5 += length;
            }
            return zzgcz.zzu(bArr);
        }
    }

    public final int zzo() throws IOException {
        return zzu();
    }

    public final int zzp() throws IOException {
        return zzu();
    }

    public final int zzq() throws IOException {
        return zzx();
    }

    public final long zzr() throws IOException {
        return zzy();
    }

    public final int zzs() throws IOException {
        return zzgde.zzG(zzu());
    }

    public final long zzt() throws IOException {
        return zzgde.zzH(zzv());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] >= 0) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzu() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzg
            int r1 = r5.zze
            if (r1 != r0) goto L_0x0007
            goto L_0x006c
        L_0x0007:
            byte[] r2 = r5.zzd
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzg = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006c
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0069
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x0069
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0069
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006c
        L_0x0069:
            r5.zzg = r1
            return r0
        L_0x006c:
            long r0 = r5.zzw()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgdd.zzu():int");
    }

    public final long zzv() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        byte b;
        int i = this.zzg;
        int i2 = this.zze;
        if (i2 != i) {
            byte[] bArr = this.zzd;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.zzg = i3;
                return (long) b2;
            } else if (i2 - i3 >= 9) {
                int i4 = i3 + 1;
                byte b3 = b2 ^ (bArr[i3] << 7);
                if (b3 < 0) {
                    b = b3 ^ Byte.MIN_VALUE;
                } else {
                    int i5 = i4 + 1;
                    byte b4 = b3 ^ (bArr[i4] << 14);
                    if (b4 >= 0) {
                        j2 = (long) (b4 ^ 16256);
                    } else {
                        i4 = i5 + 1;
                        byte b5 = b4 ^ (bArr[i5] << 21);
                        if (b5 < 0) {
                            b = b5 ^ -2080896;
                        } else {
                            i5 = i4 + 1;
                            long j5 = (((long) bArr[i4]) << 28) ^ ((long) b5);
                            if (j5 >= 0) {
                                j4 = 266354560;
                            } else {
                                int i6 = i5 + 1;
                                long j6 = j5 ^ (((long) bArr[i5]) << 35);
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i5 = i6 + 1;
                                    j5 = j6 ^ (((long) bArr[i6]) << 42);
                                    if (j5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i6 = i5 + 1;
                                        j6 = j5 ^ (((long) bArr[i5]) << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i5 = i6 + 1;
                                            j2 = (j6 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                            if (j2 < 0) {
                                                i6 = i5 + 1;
                                                if (((long) bArr[i5]) >= 0) {
                                                    j = j2;
                                                    i4 = i6;
                                                    this.zzg = i4;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = j3 ^ j6;
                                i4 = i6;
                                this.zzg = i4;
                                return j;
                            }
                            j2 = j5 ^ j4;
                        }
                    }
                    i4 = i5;
                    j = j2;
                    this.zzg = i4;
                    return j;
                }
                j = (long) b;
                this.zzg = i4;
                return j;
            }
        }
        return zzw();
    }

    public final long zzw() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzD = zzD();
            j |= ((long) (zzD & Byte.MAX_VALUE)) << i;
            if ((zzD & 128) == 0) {
                return j;
            }
        }
        throw zzgeo.zzf();
    }

    public final int zzx() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 4) {
            zzJ(4);
            i = this.zzg;
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 4;
        return ((bArr[i + 3] & Base64.EQUALS_SIGN_ENC) << 24) | (bArr[i] & Base64.EQUALS_SIGN_ENC) | ((bArr[i + 1] & Base64.EQUALS_SIGN_ENC) << 8) | ((bArr[i + 2] & Base64.EQUALS_SIGN_ENC) << 16);
    }

    public final long zzy() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 8) {
            zzJ(8);
            i = this.zzg;
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int zzz(int i) throws zzgeo {
        if (i >= 0) {
            int i2 = this.zzi + this.zzg + i;
            int i3 = this.zzj;
            if (i2 <= i3) {
                this.zzj = i2;
                zzI();
                return i3;
            }
            throw zzgeo.zzd();
        }
        throw zzgeo.zze();
    }
}
