package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.io.IOException;
import java.util.Arrays;

public final class zzmy {
    public static final zzmy zzvr = new zzmy(0, new int[0], new Object[0], false);
    public int count;
    public boolean zznh;
    public int zzrr;
    public Object[] zzue;
    public int[] zzvs;

    public zzmy() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzmy zza(zzmy zzmy, zzmy zzmy2) {
        int i = zzmy.count + zzmy2.count;
        int[] copyOf = Arrays.copyOf(zzmy.zzvs, i);
        System.arraycopy(zzmy2.zzvs, 0, copyOf, zzmy.count, zzmy2.count);
        Object[] copyOf2 = Arrays.copyOf(zzmy.zzue, i);
        System.arraycopy(zzmy2.zzue, 0, copyOf2, zzmy.count, zzmy2.count);
        return new zzmy(i, copyOf, copyOf2, true);
    }

    public static zzmy zzfa() {
        return zzvr;
    }

    public static zzmy zzfb() {
        return new zzmy();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmy)) {
            return false;
        }
        zzmy zzmy = (zzmy) obj;
        int i = this.count;
        if (i == zzmy.count) {
            int[] iArr = this.zzvs;
            int[] iArr2 = zzmy.zzvs;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzue;
                Object[] objArr2 = zzmy.zzue;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzvs;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzue;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb(zzns zzns) throws IOException {
        if (this.count != 0) {
            if (zzns.zzcd() == zzkk.zze.zzsi) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzvs[i], this.zzue[i], zzns);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzvs[i2], this.zzue[i2], zzns);
            }
        }
    }

    public final void zzbp() {
        this.zznh = false;
    }

    public final int zzcx() {
        int i;
        int i2 = this.zzrr;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzvs[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzjr.zze(i6, ((Long) this.zzue[i4]).longValue());
            } else if (i7 == 1) {
                i = zzjr.zzg(i6, ((Long) this.zzue[i4]).longValue());
            } else if (i7 == 2) {
                i = zzjr.zzc(i6, (zzjc) this.zzue[i4]);
            } else if (i7 == 3) {
                i3 = ((zzmy) this.zzue[i4]).zzcx() + (zzjr.zzab(i6) << 1) + i3;
            } else if (i7 == 5) {
                i = zzjr.zzj(i6, ((Integer) this.zzue[i4]).intValue());
            } else {
                throw new IllegalStateException(zzkq.zzdl());
            }
            i3 = i + i3;
        }
        this.zzrr = i3;
        return i3;
    }

    public final int zzfc() {
        int i = this.zzrr;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzjr.zzd(this.zzvs[i3] >>> 3, (zzjc) this.zzue[i3]);
        }
        this.zzrr = i2;
        return i2;
    }

    public zzmy(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzrr = -1;
        this.count = i;
        this.zzvs = iArr;
        this.zzue = objArr;
        this.zznh = z;
    }

    public static void zzb(int i, Object obj, zzns zzns) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzns.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzns.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzns.zza(i2, (zzjc) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzns.zzf(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzkq.zzdl());
        } else if (zzns.zzcd() == zzkk.zze.zzsi) {
            zzns.zzak(i2);
            ((zzmy) obj).zzb(zzns);
            zzns.zzal(i2);
        } else {
            zzns.zzal(i2);
            ((zzmy) obj).zzb(zzns);
            zzns.zzak(i2);
        }
    }

    public final void zza(zzns zzns) throws IOException {
        if (zzns.zzcd() == zzkk.zze.zzsj) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzns.zza(this.zzvs[i] >>> 3, this.zzue[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzns.zza(this.zzvs[i2] >>> 3, this.zzue[i2]);
        }
    }

    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzlt.zza(sb, i, String.valueOf(this.zzvs[i2] >>> 3), this.zzue[i2]);
        }
    }

    public final void zzb(int i, Object obj) {
        if (this.zznh) {
            int i2 = this.count;
            if (i2 == this.zzvs.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzvs = Arrays.copyOf(this.zzvs, i3);
                this.zzue = Arrays.copyOf(this.zzue, i3);
            }
            int[] iArr = this.zzvs;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzue[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
