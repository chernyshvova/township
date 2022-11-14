package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgdc extends zzgde {
    public final Iterable<ByteBuffer> zzc;
    public final Iterator<ByteBuffer> zzd;
    public ByteBuffer zze;
    public int zzf;
    public int zzg;
    public int zzh = Integer.MAX_VALUE;
    public int zzi;
    public int zzj;
    public long zzk;
    public long zzl;
    public long zzm;

    public /* synthetic */ zzgdc(Iterable iterable, int i, boolean z, zzgda zzgda) {
        super((zzgda) null);
        this.zzf = i;
        this.zzc = iterable;
        this.zzd = iterable.iterator();
        this.zzj = 0;
        if (i == 0) {
            this.zze = zzgem.zzd;
            this.zzk = 0;
            this.zzl = 0;
            this.zzm = 0;
            return;
        }
        zzJ();
    }

    private final void zzI() throws zzgeo {
        if (this.zzd.hasNext()) {
            zzJ();
            return;
        }
        throw zzgeo.zzd();
    }

    private final void zzJ() {
        ByteBuffer next = this.zzd.next();
        this.zze = next;
        this.zzj += (int) (this.zzk - this.zzl);
        long position = (long) next.position();
        this.zzk = position;
        this.zzl = position;
        this.zzm = (long) this.zze.limit();
        long zzs = zzggy.zzs(this.zze);
        this.zzk += zzs;
        this.zzl += zzs;
        this.zzm += zzs;
    }

    private final void zzK() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = this.zzh;
        if (i > i2) {
            int i3 = i - i2;
            this.zzg = i3;
            this.zzf = i - i3;
            return;
        }
        this.zzg = 0;
    }

    private final void zzL(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= zzM()) {
            int i3 = i2;
            while (i3 > 0) {
                if (this.zzm - this.zzk == 0) {
                    zzI();
                }
                int min = Math.min(i3, (int) (this.zzm - this.zzk));
                long j = (long) min;
                zzggy.zzq(this.zzk, bArr, (long) (i2 - i3), j);
                i3 -= min;
                this.zzk += j;
            }
        } else if (i2 > 0) {
            throw zzgeo.zzd();
        }
    }

    private final int zzM() {
        return (int) ((((long) (this.zzf - this.zzj)) - this.zzk) + this.zzl);
    }

    public final void zzA(int i) {
        this.zzh = i;
        zzK();
    }

    public final boolean zzB() throws IOException {
        return (((long) this.zzj) + this.zzk) - this.zzl == ((long) this.zzf);
    }

    public final int zzC() {
        return (int) ((((long) this.zzj) + this.zzk) - this.zzl);
    }

    public final byte zzD() throws IOException {
        if (this.zzm - this.zzk == 0) {
            zzI();
        }
        long j = this.zzk;
        this.zzk = 1 + j;
        return zzggy.zzr(j);
    }

    public final void zzE(int i) throws IOException {
        if (i >= 0 && ((long) i) <= (((long) (this.zzf - this.zzj)) - this.zzk) + this.zzl) {
            while (i > 0) {
                if (this.zzm - this.zzk == 0) {
                    zzI();
                }
                int min = Math.min(i, (int) (this.zzm - this.zzk));
                i -= min;
                this.zzk += (long) min;
            }
        } else if (i < 0) {
            throw zzgeo.zze();
        } else {
            throw zzgeo.zzd();
        }
    }

    public final int zza() throws IOException {
        if (zzB()) {
            this.zzi = 0;
            return 0;
        }
        int zzu = zzu();
        this.zzi = zzu;
        if ((zzu >>> 3) != 0) {
            return zzu;
        }
        throw zzgeo.zzg();
    }

    public final void zzb(int i) throws zzgeo {
        if (this.zzi != i) {
            throw zzgeo.zzh();
        }
    }

    public final boolean zzc(int i) throws IOException {
        int zza;
        int i2 = i & 7;
        if (i2 == 0) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (zzD() >= 0) {
                    return true;
                }
            }
            throw zzgeo.zzf();
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
            long j = (long) zzu;
            long j2 = this.zzm;
            long j3 = this.zzk;
            if (j <= j2 - j3) {
                byte[] bArr = new byte[zzu];
                zzggy.zzq(j3, bArr, 0, j);
                String str = new String(bArr, zzgem.zza);
                this.zzk += j;
                return str;
            }
        }
        if (zzu > 0 && zzu <= zzM()) {
            byte[] bArr2 = new byte[zzu];
            zzL(bArr2, 0, zzu);
            return new String(bArr2, zzgem.zza);
        } else if (zzu == 0) {
            return "";
        } else {
            if (zzu < 0) {
                throw zzgeo.zze();
            }
            throw zzgeo.zzd();
        }
    }

    public final String zzm() throws IOException {
        int zzu = zzu();
        if (zzu > 0) {
            long j = (long) zzu;
            long j2 = this.zzm;
            long j3 = this.zzk;
            if (j <= j2 - j3) {
                String zzf2 = zzghd.zzf(this.zze, (int) (j3 - this.zzl), zzu);
                this.zzk += j;
                return zzf2;
            }
        }
        if (zzu >= 0 && zzu <= zzM()) {
            byte[] bArr = new byte[zzu];
            zzL(bArr, 0, zzu);
            return zzghd.zzg(bArr, 0, zzu);
        } else if (zzu == 0) {
            return "";
        } else {
            if (zzu <= 0) {
                throw zzgeo.zze();
            }
            throw zzgeo.zzd();
        }
    }

    public final zzgcz zzn() throws IOException {
        int zzu = zzu();
        if (zzu > 0) {
            long j = (long) zzu;
            long j2 = this.zzm;
            long j3 = this.zzk;
            if (j <= j2 - j3) {
                byte[] bArr = new byte[zzu];
                zzggy.zzq(j3, bArr, 0, j);
                this.zzk += j;
                return zzgcz.zzu(bArr);
            }
        }
        if (zzu > 0 && zzu <= zzM()) {
            byte[] bArr2 = new byte[zzu];
            zzL(bArr2, 0, zzu);
            return zzgcz.zzu(bArr2);
        } else if (zzu == 0) {
            return zzgcz.zzb;
        } else {
            if (zzu < 0) {
                throw zzgeo.zze();
            }
            throw zzgeo.zzd();
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

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
        if (com.google.android.gms.internal.ads.zzggy.zzr(r4) >= 0) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzu() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzk
            long r2 = r10.zzm
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x000a
            goto L_0x008c
        L_0x000a:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzggy.zzr(r0)
            if (r0 < 0) goto L_0x001a
            long r4 = r10.zzk
            long r4 = r4 + r2
            r10.zzk = r4
            return r0
        L_0x001a:
            long r6 = r10.zzm
            long r8 = r10.zzk
            long r6 = r6 - r8
            r8 = 10
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x008c
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzggy.zzr(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0033
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0089
        L_0x0033:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzggy.zzr(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0042
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x0040:
            r6 = r4
            goto L_0x0089
        L_0x0042:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzggy.zzr(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0052
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x0089
        L_0x0052:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzggy.zzr(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzggy.zzr(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzggy.zzr(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzggy.zzr(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzggy.zzr(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzggy.zzr(r4)
            if (r1 < 0) goto L_0x008c
        L_0x0089:
            r10.zzk = r6
            return r0
        L_0x008c:
            long r0 = r10.zzw()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgdc.zzu():int");
    }

    public final long zzv() throws IOException {
        long j;
        long j2;
        long j3;
        byte b;
        long j4 = this.zzk;
        if (this.zzm != j4) {
            long j5 = j4 + 1;
            byte zzr = zzggy.zzr(j4);
            if (zzr >= 0) {
                this.zzk++;
                return (long) zzr;
            } else if (this.zzm - this.zzk >= 10) {
                long j6 = j5 + 1;
                byte zzr2 = zzr ^ (zzggy.zzr(j5) << 7);
                if (zzr2 < 0) {
                    b = zzr2 ^ Byte.MIN_VALUE;
                } else {
                    long j7 = j6 + 1;
                    byte zzr3 = zzr2 ^ (zzggy.zzr(j6) << 14);
                    if (zzr3 >= 0) {
                        j = (long) (zzr3 ^ 16256);
                    } else {
                        j6 = j7 + 1;
                        byte zzr4 = zzr3 ^ (zzggy.zzr(j7) << 21);
                        if (zzr4 < 0) {
                            b = zzr4 ^ -2080896;
                        } else {
                            j7 = j6 + 1;
                            long zzr5 = ((long) zzr4) ^ (((long) zzggy.zzr(j6)) << 28);
                            if (zzr5 >= 0) {
                                j3 = 266354560;
                            } else {
                                long j8 = j7 + 1;
                                long zzr6 = zzr5 ^ (((long) zzggy.zzr(j7)) << 35);
                                if (zzr6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    j7 = j8 + 1;
                                    zzr5 = zzr6 ^ (((long) zzggy.zzr(j8)) << 42);
                                    if (zzr5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        j8 = j7 + 1;
                                        zzr6 = zzr5 ^ (((long) zzggy.zzr(j7)) << 49);
                                        if (zzr6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j7 = j8 + 1;
                                            j = (zzr6 ^ (((long) zzggy.zzr(j8)) << 56)) ^ 71499008037633920L;
                                            if (j < 0) {
                                                long j9 = 1 + j7;
                                                if (((long) zzggy.zzr(j7)) >= 0) {
                                                    j6 = j9;
                                                    this.zzk = j6;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = zzr6 ^ j2;
                                j6 = j8;
                                this.zzk = j6;
                                return j;
                            }
                            j = zzr5 ^ j3;
                        }
                    }
                    j6 = j7;
                    this.zzk = j6;
                    return j;
                }
                j = (long) b;
                this.zzk = j6;
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
        byte zzD;
        byte zzD2;
        long j = this.zzm;
        long j2 = this.zzk;
        if (j - j2 >= 4) {
            this.zzk = 4 + j2;
            zzD = (zzggy.zzr(j2) & Base64.EQUALS_SIGN_ENC) | ((zzggy.zzr(1 + j2) & Base64.EQUALS_SIGN_ENC) << 8) | ((zzggy.zzr(2 + j2) & Base64.EQUALS_SIGN_ENC) << 16);
            zzD2 = zzggy.zzr(j2 + 3);
        } else {
            zzD = (zzD() & Base64.EQUALS_SIGN_ENC) | ((zzD() & Base64.EQUALS_SIGN_ENC) << 8) | ((zzD() & Base64.EQUALS_SIGN_ENC) << 16);
            zzD2 = zzD();
        }
        return zzD | ((zzD2 & Base64.EQUALS_SIGN_ENC) << 24);
    }

    public final long zzy() throws IOException {
        long zzD;
        byte zzD2;
        long j = this.zzm;
        long j2 = this.zzk;
        if (j - j2 >= 8) {
            this.zzk = 8 + j2;
            zzD = (((long) zzggy.zzr(j2)) & 255) | ((((long) zzggy.zzr(1 + j2)) & 255) << 8) | ((((long) zzggy.zzr(2 + j2)) & 255) << 16) | ((((long) zzggy.zzr(3 + j2)) & 255) << 24) | ((((long) zzggy.zzr(4 + j2)) & 255) << 32) | ((((long) zzggy.zzr(5 + j2)) & 255) << 40) | ((((long) zzggy.zzr(6 + j2)) & 255) << 48);
            zzD2 = zzggy.zzr(j2 + 7);
        } else {
            zzD = (((long) zzD()) & 255) | ((((long) zzD()) & 255) << 8) | ((((long) zzD()) & 255) << 16) | ((((long) zzD()) & 255) << 24) | ((((long) zzD()) & 255) << 32) | ((((long) zzD()) & 255) << 40) | ((((long) zzD()) & 255) << 48);
            zzD2 = zzD();
        }
        return zzD | ((((long) zzD2) & 255) << 56);
    }

    public final int zzz(int i) throws zzgeo {
        if (i >= 0) {
            int zzC = zzC() + i;
            int i2 = this.zzh;
            if (zzC <= i2) {
                this.zzh = zzC;
                zzK();
                return i2;
            }
            throw zzgeo.zzd();
        }
        throw zzgeo.zze();
    }
}
