package com.google.android.gms.internal.drive;

import com.facebook.internal.FileLruCache;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzjr extends zzjb {
    public static final Logger logger = Logger.getLogger(zzjr.class.getName());
    public static final boolean zzog = zznd.zzfd();
    public zzjt zzoh;

    public static class zza extends zzjr {
        public final byte[] buffer;
        public final int limit;
        public final int offset;
        public int position;

        public zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = 0;
                    this.position = 0;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
            throw new NullPointerException(FileLruCache.BufferFile.FILE_NAME_PREFIX);
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzl(j);
        }

        public final void zzaa(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzb(int i, int i2) throws IOException {
            zzy((i << 3) | i2);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzx(i2);
        }

        public final int zzca() {
            return this.limit - this.position;
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzy(i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzaa(i2);
        }

        public final void zzl(long j) throws IOException {
            if (!zzjr.zzog || zzca() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zznd.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zznd.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzn(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i3 = i2 + 1;
                this.position = i3;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i6 = i5 + 1;
                this.position = i6;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i7 = i6 + 1;
                this.position = i7;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i8 = i7 + 1;
                this.position = i8;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzx(int i) throws IOException {
            if (i >= 0) {
                zzy(i);
            } else {
                zzl((long) i);
            }
        }

        public final void zzy(int i) throws IOException {
            if (!zzjr.zzog || zzix.zzbr() || zzca() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zznd.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zznd.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zznd.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zznd.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zznd.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zznd.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zznd.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zznd.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zznd.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzl(str);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzn(j);
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzy(i2);
            write(bArr, 0, i2);
        }

        public final void zzb(int i, zzjc zzjc) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzjc);
            zzb(1, 4);
        }

        public final void zza(int i, zzjc zzjc) throws IOException {
            zzb(i, 2);
            zza(zzjc);
        }

        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zza(zzjc zzjc) throws IOException {
            zzy(zzjc.size());
            zzjc.zza((zzjb) this);
        }

        public final void zzb(zzlq zzlq) throws IOException {
            zzy(zzlq.zzcx());
            zzlq.zzb(this);
        }

        public final void zzl(String str) throws IOException {
            int i = this.position;
            try {
                int zzad = zzjr.zzad(str.length() * 3);
                int zzad2 = zzjr.zzad(str.length());
                if (zzad2 == zzad) {
                    int i2 = i + zzad2;
                    this.position = i2;
                    int zza = zznf.zza(str, this.buffer, i2, zzca());
                    this.position = i;
                    zzy((zza - i) - zzad2);
                    this.position = zza;
                    return;
                }
                zzy(zznf.zza(str));
                this.position = zznf.zza(str, this.buffer, this.position, zzca());
            } catch (zznj e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        public final void zza(int i, zzlq zzlq, zzmf zzmf) throws IOException {
            zzb(i, 2);
            zzit zzit = (zzit) zzlq;
            int zzbm = zzit.zzbm();
            if (zzbm == -1) {
                zzbm = zzmf.zzn(zzit);
                zzit.zzo(zzbm);
            }
            zzy(zzbm);
            zzmf.zza(zzlq, this.zzoh);
        }

        public final void zza(int i, zzlq zzlq) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zzb(3, 2);
            zzb(zzlq);
            zzb(1, 4);
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }
    }

    public static class zzb extends IOException {
        public zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public zzb(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L_0x0011
                java.lang.String r3 = r0.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzjr.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    public zzjr() {
    }

    public static int zzab(int i) {
        return zzad(i << 3);
    }

    public static int zzac(int i) {
        if (i >= 0) {
            return zzad(i);
        }
        return 10;
    }

    public static int zzad(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzae(int i) {
        return zzad(zzai(i));
    }

    public static int zzaf(int i) {
        return 4;
    }

    public static int zzag(int i) {
        return 4;
    }

    public static int zzah(int i) {
        return zzac(i);
    }

    public static int zzai(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzaj(int i) {
        return zzad(i);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static zzjr zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzd(int i, long j) {
        return zzp(j) + zzab(i);
    }

    public static int zzd(boolean z) {
        return 1;
    }

    public static int zzf(int i, long j) {
        return zzp(zzt(j)) + zzab(i);
    }

    public static int zzg(int i, int i2) {
        return zzac(i2) + zzab(i);
    }

    public static int zzh(int i, int i2) {
        return zzad(i2) + zzab(i);
    }

    public static int zzi(int i, int i2) {
        return zzad(zzai(i2)) + zzab(i);
    }

    public static int zzj(int i, int i2) {
        return zzab(i) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzab(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzac(i2) + zzab(i);
    }

    public static int zzo(long j) {
        return zzp(j);
    }

    public static int zzp(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzq(long j) {
        return zzp(zzt(j));
    }

    public static int zzr(long j) {
        return 8;
    }

    public static int zzs(long j) {
        return 8;
    }

    public static long zzt(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public final void zza(int i, float f) throws IOException {
        zzf(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzjc zzjc) throws IOException;

    public abstract void zza(int i, zzlq zzlq) throws IOException;

    public abstract void zza(int i, zzlq zzlq, zzmf zzmf) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzjc zzjc) throws IOException;

    public abstract void zzaa(int i) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzb(int i, zzjc zzjc) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzlq zzlq) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public final void zzc(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public abstract int zzca();

    public final void zzcb() {
        if (zzca() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zzd(byte[] bArr, int i, int i2) throws IOException;

    public final void zze(int i, int i2) throws IOException {
        zzd(i, zzai(i2));
    }

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzl(long j) throws IOException;

    public abstract void zzl(String str) throws IOException;

    public final void zzm(long j) throws IOException {
        zzl(zzt(j));
    }

    public abstract void zzn(long j) throws IOException;

    public abstract void zzx(int i) throws IOException;

    public abstract void zzy(int i) throws IOException;

    public final void zzz(int i) throws IOException {
        zzy(zzai(i));
    }

    public static int zzc(int i, boolean z) {
        return zzab(i) + 1;
    }

    public static int zze(int i, long j) {
        return zzp(j) + zzab(i);
    }

    public static int zzg(int i, long j) {
        return zzab(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzab(i) + 8;
    }

    public static int zzm(String str) {
        int i;
        try {
            i = zznf.zza(str);
        } catch (zznj unused) {
            i = str.getBytes(zzkm.UTF_8).length;
        }
        return zzad(i) + i;
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public static int zzc(int i, zzjc zzjc) {
        int zzab = zzab(i);
        int size = zzjc.size();
        return zzad(size) + size + zzab;
    }

    public static int zzd(int i, zzjc zzjc) {
        int zzh = zzh(2, i);
        return zzc(3, zzjc) + zzh + (zzab(1) << 1);
    }

    public final void zza(float f) throws IOException {
        zzaa(Float.floatToRawIntBits(f));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzt(j));
    }

    public static int zzb(int i, float f) {
        return zzab(i) + 4;
    }

    public final void zza(double d) throws IOException {
        zzn(Double.doubleToRawLongBits(d));
    }

    public static int zza(int i, zzkx zzkx) {
        int zzab = zzab(i);
        int zzcx = zzkx.zzcx();
        return zzad(zzcx) + zzcx + zzab;
    }

    public static int zzb(int i, double d) {
        return zzab(i) + 8;
    }

    public static int zzb(int i, String str) {
        return zzm(str) + zzab(i);
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return zzad(length) + length;
    }

    @Deprecated
    public static int zzd(zzlq zzlq) {
        return zzlq.zzcx();
    }

    public static int zzb(int i, zzlq zzlq, zzmf zzmf) {
        return zza(zzlq, zzmf) + zzab(i);
    }

    public static int zza(zzkx zzkx) {
        int zzcx = zzkx.zzcx();
        return zzad(zzcx) + zzcx;
    }

    public static int zzb(int i, zzlq zzlq) {
        return zzc(zzlq) + zzab(3) + zzh(2, i) + (zzab(1) << 1);
    }

    public static int zzc(zzlq zzlq) {
        int zzcx = zzlq.zzcx();
        return zzad(zzcx) + zzcx;
    }

    public static int zza(zzlq zzlq, zzmf zzmf) {
        zzit zzit = (zzit) zzlq;
        int zzbm = zzit.zzbm();
        if (zzbm == -1) {
            zzbm = zzmf.zzn(zzit);
            zzit.zzo(zzbm);
        }
        return zzad(zzbm) + zzbm;
    }

    @Deprecated
    public static int zzc(int i, zzlq zzlq, zzmf zzmf) {
        int zzab = zzab(i) << 1;
        zzit zzit = (zzit) zzlq;
        int zzbm = zzit.zzbm();
        if (zzbm == -1) {
            zzbm = zzmf.zzn(zzit);
            zzit.zzo(zzbm);
        }
        return zzab + zzbm;
    }

    public static int zzb(int i, zzkx zzkx) {
        int zzh = zzh(2, i);
        return zza(3, zzkx) + zzh + (zzab(1) << 1);
    }

    public static int zzb(zzjc zzjc) {
        int size = zzjc.size();
        return zzad(size) + size;
    }

    public final void zza(String str, zznj zznj) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zznj);
        byte[] bytes = str.getBytes(zzkm.UTF_8);
        try {
            zzy(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }
}
