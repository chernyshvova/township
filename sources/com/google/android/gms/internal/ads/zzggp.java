package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzggp {
    public static final zzggp zza = new zzggp(0, new int[0], new Object[0], false);
    public int zzb;
    public int[] zzc;
    public Object[] zzd;
    public int zze;
    public boolean zzf;

    public zzggp() {
        this(0, new int[8], new Object[8], true);
    }

    public zzggp(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzggp zza() {
        return zza;
    }

    public static zzggp zzb() {
        return new zzggp(0, new int[8], new Object[8], true);
    }

    public static zzggp zzc(zzggp zzggp, zzggp zzggp2) {
        int i = zzggp.zzb + zzggp2.zzb;
        int[] copyOf = Arrays.copyOf(zzggp.zzc, i);
        System.arraycopy(zzggp2.zzc, 0, copyOf, zzggp.zzb, zzggp2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzggp.zzd, i);
        System.arraycopy(zzggp2.zzd, 0, copyOf2, zzggp.zzb, zzggp2.zzb);
        return new zzggp(i, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzggp)) {
            return false;
        }
        zzggp zzggp = (zzggp) obj;
        int i = this.zzb;
        if (i == zzggp.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzggp.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzggp.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzd() {
        this.zzf = false;
    }

    public final int zze() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int zzw = zzgdj.zzw(8);
            int zzc2 = ((zzgcz) this.zzd[i3]).zzc();
            i2 += zzgdj.zzw(zzc2) + zzc2 + zzgdj.zzw(24) + zzgdj.zzw(i4 >>> 3) + zzgdj.zzw(16) + zzw + zzw;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzf() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i3 = zzgdj.zzw(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int zzw = zzgdj.zzw(i8 << 3);
                    int zzc2 = ((zzgcz) this.zzd[i6]).zzc();
                    i5 = zzgdj.zzw(zzc2) + zzc2 + zzw + i5;
                } else if (i9 == 3) {
                    int zzu = zzgdj.zzu(i8);
                    i2 = zzu + zzu;
                    i = ((zzggp) this.zzd[i6]).zzf();
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i3 = zzgdj.zzw(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzgeo.zzi());
                }
                i5 = i3 + i5;
            } else {
                long longValue = ((Long) this.zzd[i6]).longValue();
                i2 = zzgdj.zzw(i8 << 3);
                i = zzgdj.zzx(longValue);
            }
            i5 = i + i2 + i5;
        }
        this.zze = i5;
        return i5;
    }

    public final void zzg(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzgfm.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzh(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            int[] iArr = this.zzc;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(iArr, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr2 = this.zzc;
            int i4 = this.zzb;
            iArr2[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zzgdk zzgdk) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zzgdk.zzc(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzgdk.zzj(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzgdk.zzn(i3, (zzgcz) obj);
                } else if (i4 == 3) {
                    zzgdk.zzt(i3);
                    ((zzggp) obj).zzi(zzgdk);
                    zzgdk.zzu(i3);
                } else if (i4 == 5) {
                    zzgdk.zzk(i3, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzgeo.zzi());
                }
            }
        }
    }
}
