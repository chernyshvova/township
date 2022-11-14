package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgcn {
    public static int zza(byte[] bArr, int i, zzgcm zzgcm) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzgcm);
        }
        zzgcm.zza = b;
        return i2;
    }

    public static int zzb(int i, byte[] bArr, int i2, zzgcm zzgcm) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzgcm.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzgcm.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgcm.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgcm.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzgcm.zza = i11;
                return i12;
            }
        }
    }

    public static int zzc(byte[] bArr, int i, zzgcm zzgcm) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j < 0) {
            int i3 = i2 + 1;
            byte b = bArr[i2];
            long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
            int i4 = 7;
            while (b < 0) {
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                i4 += 7;
                j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
                int i6 = i5;
                b = b2;
                i3 = i6;
            }
            zzgcm.zzb = j2;
            return i3;
        }
        zzgcm.zzb = j;
        return i2;
    }

    public static int zzd(byte[] bArr, int i) {
        return ((bArr[i + 3] & Base64.EQUALS_SIGN_ENC) << 24) | (bArr[i] & Base64.EQUALS_SIGN_ENC) | ((bArr[i + 1] & Base64.EQUALS_SIGN_ENC) << 8) | ((bArr[i + 2] & Base64.EQUALS_SIGN_ENC) << 16);
    }

    public static long zze(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int zzf(byte[] bArr, int i, zzgcm zzgcm) throws zzgeo {
        int zza = zza(bArr, i, zzgcm);
        int i2 = zzgcm.zza;
        if (i2 < 0) {
            throw zzgeo.zze();
        } else if (i2 == 0) {
            zzgcm.zzc = "";
            return zza;
        } else {
            zzgcm.zzc = new String(bArr, zza, i2, zzgem.zza);
            return zza + i2;
        }
    }

    public static int zzg(byte[] bArr, int i, zzgcm zzgcm) throws zzgeo {
        int zza = zza(bArr, i, zzgcm);
        int i2 = zzgcm.zza;
        if (i2 < 0) {
            throw zzgeo.zze();
        } else if (i2 == 0) {
            zzgcm.zzc = "";
            return zza;
        } else {
            zzgcm.zzc = zzghd.zzg(bArr, zza, i2);
            return zza + i2;
        }
    }

    public static int zzh(byte[] bArr, int i, zzgcm zzgcm) throws zzgeo {
        int zza = zza(bArr, i, zzgcm);
        int i2 = zzgcm.zza;
        if (i2 < 0) {
            throw zzgeo.zze();
        } else if (i2 > bArr.length - zza) {
            throw zzgeo.zzd();
        } else if (i2 == 0) {
            zzgcm.zzc = zzgcz.zzb;
            return zza;
        } else {
            zzgcm.zzc = zzgcz.zzs(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzi(com.google.android.gms.internal.ads.zzgga r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.ads.zzgcm r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzb(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zza()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzi(r1, r2, r3, r4, r5)
            r6.zzj(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.ads.zzgeo r6 = com.google.android.gms.internal.ads.zzgeo.zzd()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgcn.zzi(com.google.android.gms.internal.ads.zzgga, byte[], int, int, com.google.android.gms.internal.ads.zzgcm):int");
    }

    public static int zzj(zzgga zzgga, byte[] bArr, int i, int i2, int i3, zzgcm zzgcm) throws IOException {
        zzgfn zzgfn = (zzgfn) zzgga;
        Object zza = zzgfn.zza();
        int zzh = zzgfn.zzh(zza, bArr, i, i2, i3, zzgcm);
        zzgfn.zzj(zza);
        zzgcm.zzc = zza;
        return zzh;
    }

    public static int zzk(int i, byte[] bArr, int i2, int i3, zzgel<?> zzgel, zzgcm zzgcm) {
        zzged zzged = (zzged) zzgel;
        int zza = zza(bArr, i2, zzgcm);
        zzged.zzh(zzgcm.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzgcm);
            if (i != zzgcm.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzgcm);
            zzged.zzh(zzgcm.zza);
        }
        return zza;
    }

    public static int zzl(byte[] bArr, int i, zzgel<?> zzgel, zzgcm zzgcm) throws IOException {
        zzged zzged = (zzged) zzgel;
        int zza = zza(bArr, i, zzgcm);
        int i2 = zzgcm.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzgcm);
            zzged.zzh(zzgcm.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzgeo.zzd();
    }

    public static int zzm(zzgga<?> zzgga, int i, byte[] bArr, int i2, int i3, zzgel<?> zzgel, zzgcm zzgcm) throws IOException {
        int zzi = zzi(zzgga, bArr, i2, i3, zzgcm);
        zzgel.add(zzgcm.zzc);
        while (zzi < i3) {
            int zza = zza(bArr, zzi, zzgcm);
            if (i != zzgcm.zza) {
                break;
            }
            zzi = zzi(zzgga, bArr, zza, i3, zzgcm);
            zzgel.add(zzgcm.zzc);
        }
        return zzi;
    }

    public static int zzn(int i, byte[] bArr, int i2, int i3, zzggp zzggp, zzgcm zzgcm) throws zzgeo {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzc = zzc(bArr, i2, zzgcm);
                zzggp.zzh(i, Long.valueOf(zzgcm.zzb));
                return zzc;
            } else if (i4 == 1) {
                zzggp.zzh(i, Long.valueOf(zze(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzgcm);
                int i5 = zzgcm.zza;
                if (i5 < 0) {
                    throw zzgeo.zze();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzggp.zzh(i, zzgcz.zzb);
                    } else {
                        zzggp.zzh(i, zzgcz.zzs(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzgeo.zzd();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzggp zzb = zzggp.zzb();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzgcm);
                    int i8 = zzgcm.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzn(i8, bArr, zza2, i3, zzb, zzgcm);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzgeo.zzk();
                }
                zzggp.zzh(i, zzb);
                return i2;
            } else if (i4 == 5) {
                zzggp.zzh(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzgeo.zzg();
            }
        } else {
            throw zzgeo.zzg();
        }
    }
}
