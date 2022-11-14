package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzafc {
    public final zzakr zza = new zzakr(32);
    public zzafb zzb;
    public zzafb zzc;
    public zzafb zzd;
    public long zze;
    public final zzahy zzf;

    public zzafc(zzahy zzahy, byte[] bArr) {
        this.zzf = zzahy;
        zzafb zzafb = new zzafb(0, 65536);
        this.zzb = zzafb;
        this.zzc = zzafb;
        this.zzd = zzafb;
    }

    private final int zzi(int i) {
        zzafb zzafb = this.zzd;
        if (!zzafb.zzc) {
            zzahe zzc2 = this.zzf.zzc();
            zzafb zzafb2 = new zzafb(this.zzd.zzb, 65536);
            zzafb.zzd = zzc2;
            zzafb.zze = zzafb2;
            zzafb.zzc = true;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private final void zzj(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzafb zzafb = this.zzd;
        if (j == zzafb.zzb) {
            this.zzd = zzafb.zze;
        }
    }

    public static zzafb zzk(zzafb zzafb, zzrr zzrr, zzaff zzaff, zzakr zzakr) {
        zzafb zzafb2;
        int i;
        zzrr zzrr2 = zzrr;
        zzaff zzaff2 = zzaff;
        zzakr zzakr2 = zzakr;
        if (zzrr.zzj()) {
            long j = zzaff2.zzb;
            zzakr2.zza(1);
            zzafb zzm = zzm(zzafb, j, zzakr.zzi(), 1);
            long j2 = j + 1;
            byte b = zzakr.zzi()[0];
            byte b2 = b & 128;
            byte b3 = b & Byte.MAX_VALUE;
            zzrn zzrn = zzrr2.zza;
            byte[] bArr = zzrn.zza;
            if (bArr == null) {
                zzrn.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            zzafb2 = zzm(zzm, j2, zzrn.zza, b3);
            long j3 = j2 + ((long) b3);
            if (b2 != 0) {
                zzakr2.zza(2);
                zzafb2 = zzm(zzafb2, j3, zzakr.zzi(), 2);
                j3 += 2;
                i = zzakr.zzo();
            } else {
                i = 1;
            }
            int[] iArr = zzrn.zzc;
            if (iArr == null || iArr.length < i) {
                iArr = new int[i];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzrn.zzd;
            if (iArr3 == null || iArr3.length < i) {
                iArr3 = new int[i];
            }
            int[] iArr4 = iArr3;
            if (b2 != 0) {
                int i2 = i * 6;
                zzakr2.zza(i2);
                zzafb2 = zzm(zzafb2, j3, zzakr.zzi(), i2);
                j3 += (long) i2;
                zzakr2.zzh(0);
                for (int i3 = 0; i3 < i; i3++) {
                    iArr2[i3] = zzakr.zzo();
                    iArr4[i3] = zzakr.zzB();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzaff2.zza - ((int) (j3 - zzaff2.zzb));
            }
            zzty zzty = zzaff2.zzc;
            int i4 = zzalh.zza;
            zzrn.zza(i, iArr2, iArr4, zzty.zzb, zzrn.zza, zzty.zza, zzty.zzc, zzty.zzd);
            long j4 = zzaff2.zzb;
            int i5 = (int) (j3 - j4);
            zzaff2.zzb = j4 + ((long) i5);
            zzaff2.zza -= i5;
        } else {
            zzafb2 = zzafb;
        }
        if (zzrr.zze()) {
            zzakr2.zza(4);
            zzafb zzm2 = zzm(zzafb2, zzaff2.zzb, zzakr.zzi(), 4);
            int zzB = zzakr.zzB();
            zzaff2.zzb += 4;
            zzaff2.zza -= 4;
            zzrr2.zzi(zzB);
            zzafb zzl = zzl(zzm2, zzaff2.zzb, zzrr2.zzb, zzB);
            zzaff2.zzb += (long) zzB;
            int i6 = zzaff2.zza - zzB;
            zzaff2.zza = i6;
            ByteBuffer byteBuffer = zzrr2.zze;
            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                zzrr2.zze = ByteBuffer.allocate(i6);
            } else {
                zzrr2.zze.clear();
            }
            return zzl(zzl, zzaff2.zzb, zzrr2.zze, zzaff2.zza);
        }
        zzrr2.zzi(zzaff2.zza);
        return zzl(zzafb2, zzaff2.zzb, zzrr2.zzb, zzaff2.zza);
    }

    public static zzafb zzl(zzafb zzafb, long j, ByteBuffer byteBuffer, int i) {
        zzafb zzn = zzn(zzafb, j);
        while (i > 0) {
            int min = Math.min(i, (int) (zzn.zzb - j));
            byteBuffer.put(zzn.zzd.zza, zzn.zza(j), min);
            i -= min;
            j += (long) min;
            if (j == zzn.zzb) {
                zzn = zzn.zze;
            }
        }
        return zzn;
    }

    public static zzafb zzm(zzafb zzafb, long j, byte[] bArr, int i) {
        zzafb zzn = zzn(zzafb, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (zzn.zzb - j));
            System.arraycopy(zzn.zzd.zza, zzn.zza(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == zzn.zzb) {
                zzn = zzn.zze;
            }
        }
        return zzn;
    }

    public static zzafb zzn(zzafb zzafb, long j) {
        while (j >= zzafb.zzb) {
            zzafb = zzafb.zze;
        }
        return zzafb;
    }

    public final void zza() {
        zzafb zzafb = this.zzb;
        if (zzafb.zzc) {
            zzafb zzafb2 = this.zzd;
            int i = (((int) (zzafb2.zza - zzafb.zza)) / 65536) + (zzafb2.zzc ? 1 : 0);
            zzahe[] zzaheArr = new zzahe[i];
            for (int i2 = 0; i2 < i; i2++) {
                zzaheArr[i2] = zzafb.zzd;
                zzafb = zzafb.zzb();
            }
            this.zzf.zze(zzaheArr);
        }
        zzafb zzafb3 = new zzafb(0, 65536);
        this.zzb = zzafb3;
        this.zzc = zzafb3;
        this.zzd = zzafb3;
        this.zze = 0;
        this.zzf.zzf();
    }

    public final void zzb() {
        this.zzc = this.zzb;
    }

    public final void zzc(zzrr zzrr, zzaff zzaff) {
        this.zzc = zzk(this.zzc, zzrr, zzaff, this.zza);
    }

    public final void zzd(zzrr zzrr, zzaff zzaff) {
        zzk(this.zzc, zzrr, zzaff, this.zza);
    }

    public final void zze(long j) {
        zzafb zzafb;
        if (j != -1) {
            while (true) {
                zzafb = this.zzb;
                if (j < zzafb.zzb) {
                    break;
                }
                this.zzf.zzd(zzafb.zzd);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzafb.zza) {
                this.zzc = zzafb;
            }
        }
    }

    public final long zzf() {
        return this.zze;
    }

    public final int zzg(zzahq zzahq, int i, boolean z) throws IOException {
        int zzi = zzi(i);
        zzafb zzafb = this.zzd;
        int zza2 = zzahq.zza(zzafb.zzd.zza, zzafb.zza(this.zze), zzi);
        if (zza2 != -1) {
            zzj(zza2);
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void zzh(zzakr zzakr, int i) {
        while (i > 0) {
            int zzi = zzi(i);
            zzafb zzafb = this.zzd;
            zzakr.zzm(zzafb.zzd.zza, zzafb.zza(this.zze), zzi);
            i -= zzi;
            zzj(zzi);
        }
    }
}
