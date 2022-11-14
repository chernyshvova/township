package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgdb extends zzgde {
    public final byte[] zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public final int zzg;
    public int zzh;
    public int zzi = Integer.MAX_VALUE;

    public /* synthetic */ zzgdb(byte[] bArr, int i, int i2, boolean z, zzgda zzgda) {
        super((zzgda) null);
        this.zzc = bArr;
        this.zzd = i2 + i;
        this.zzf = i;
        this.zzg = i;
    }

    private final void zzI() {
        int i = this.zzd + this.zze;
        this.zzd = i;
        int i2 = i - this.zzg;
        int i3 = this.zzi;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zze = i4;
            this.zzd = i - i4;
            return;
        }
        this.zze = 0;
    }

    public final void zzA(int i) {
        this.zzi = i;
        zzI();
    }

    public final boolean zzB() throws IOException {
        return this.zzf == this.zzd;
    }

    public final int zzC() {
        return this.zzf - this.zzg;
    }

    public final byte zzD() throws IOException {
        int i = this.zzf;
        if (i != this.zzd) {
            byte[] bArr = this.zzc;
            this.zzf = i + 1;
            return bArr[i];
        }
        throw zzgeo.zzd();
    }

    public final void zzE(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzd;
            int i3 = this.zzf;
            if (i <= i2 - i3) {
                this.zzf = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzgeo.zze();
        }
        throw zzgeo.zzd();
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
            if (this.zzd - this.zzf >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzc;
                    int i4 = this.zzf;
                    this.zzf = i4 + 1;
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
            int i = this.zzd;
            int i2 = this.zzf;
            if (zzu <= i - i2) {
                String str = new String(this.zzc, i2, zzu, zzgem.zza);
                this.zzf += zzu;
                return str;
            }
        }
        if (zzu == 0) {
            return "";
        }
        if (zzu < 0) {
            throw zzgeo.zze();
        }
        throw zzgeo.zzd();
    }

    public final String zzm() throws IOException {
        int zzu = zzu();
        if (zzu > 0) {
            int i = this.zzd;
            int i2 = this.zzf;
            if (zzu <= i - i2) {
                String zzg2 = zzghd.zzg(this.zzc, i2, zzu);
                this.zzf += zzu;
                return zzg2;
            }
        }
        if (zzu == 0) {
            return "";
        }
        if (zzu <= 0) {
            throw zzgeo.zze();
        }
        throw zzgeo.zzd();
    }

    public final zzgcz zzn() throws IOException {
        int zzu = zzu();
        if (zzu > 0) {
            int i = this.zzd;
            int i2 = this.zzf;
            if (zzu <= i - i2) {
                zzgcz zzs = zzgcz.zzs(this.zzc, i2, zzu);
                this.zzf += zzu;
                return zzs;
            }
        }
        if (zzu == 0) {
            return zzgcz.zzb;
        }
        if (zzu > 0) {
            int i3 = this.zzd;
            int i4 = this.zzf;
            if (zzu <= i3 - i4) {
                int i5 = zzu + i4;
                this.zzf = i5;
                return zzgcz.zzu(Arrays.copyOfRange(this.zzc, i4, i5));
            }
        }
        if (zzu <= 0) {
            throw zzgeo.zze();
        }
        throw zzgeo.zzd();
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
            int r0 = r5.zzf
            int r1 = r5.zzd
            if (r1 != r0) goto L_0x0007
            goto L_0x006c
        L_0x0007:
            byte[] r2 = r5.zzc
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzf = r3
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
            r5.zzf = r1
            return r0
        L_0x006c:
            long r0 = r5.zzw()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgdb.zzu():int");
    }

    public final long zzv() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        byte b;
        int i = this.zzf;
        int i2 = this.zzd;
        if (i2 != i) {
            byte[] bArr = this.zzc;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.zzf = i3;
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
                                                    this.zzf = i4;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = j3 ^ j6;
                                i4 = i6;
                                this.zzf = i4;
                                return j;
                            }
                            j2 = j5 ^ j4;
                        }
                    }
                    i4 = i5;
                    j = j2;
                    this.zzf = i4;
                    return j;
                }
                j = (long) b;
                this.zzf = i4;
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
        int i = this.zzf;
        if (this.zzd - i >= 4) {
            byte[] bArr = this.zzc;
            this.zzf = i + 4;
            return ((bArr[i + 3] & Base64.EQUALS_SIGN_ENC) << 24) | (bArr[i] & Base64.EQUALS_SIGN_ENC) | ((bArr[i + 1] & Base64.EQUALS_SIGN_ENC) << 8) | ((bArr[i + 2] & Base64.EQUALS_SIGN_ENC) << 16);
        }
        throw zzgeo.zzd();
    }

    public final long zzy() throws IOException {
        int i = this.zzf;
        if (this.zzd - i >= 8) {
            byte[] bArr = this.zzc;
            this.zzf = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzgeo.zzd();
    }

    public final int zzz(int i) throws zzgeo {
        if (i >= 0) {
            int i2 = (this.zzf - this.zzg) + i;
            if (i2 >= 0) {
                int i3 = this.zzi;
                if (i2 <= i3) {
                    this.zzi = i2;
                    zzI();
                    return i3;
                }
                throw zzgeo.zzd();
            }
            throw zzgeo.zzk();
        }
        throw zzgeo.zze();
    }
}
