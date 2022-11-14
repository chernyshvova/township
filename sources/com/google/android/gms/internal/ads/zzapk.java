package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzapk {
    public static final byte[] zza = new byte[4096];
    public final zzatv zzb;
    public final long zzc;
    public long zzd;
    public byte[] zze = new byte[65536];
    public int zzf;
    public int zzg;

    public zzapk(zzatv zzatv, long j, long j2) {
        this.zzb = zzatv;
        this.zzd = j;
        this.zzc = j2;
    }

    private final int zzj(int i) {
        int min = Math.min(this.zzg, i);
        zzl(min);
        return min;
    }

    private final int zzk(byte[] bArr, int i, int i2) {
        int i3 = this.zzg;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zze, 0, bArr, i, min);
        zzl(min);
        return min;
    }

    private final void zzl(int i) {
        int i2 = this.zzg - i;
        this.zzg = i2;
        this.zzf = 0;
        byte[] bArr = this.zze;
        byte[] bArr2 = i2 < bArr.length + -524288 ? new byte[(65536 + i2)] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.zze = bArr2;
    }

    private final int zzm(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int zzb2 = this.zzb.zzb(bArr, i + i3, i2 - i3);
            if (zzb2 != -1) {
                return i3 + zzb2;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private final void zzn(int i) {
        if (i != -1) {
            this.zzd += (long) i;
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int zzk = zzk(bArr, i, i2);
        if (zzk == 0) {
            zzk = zzm(bArr, i, i2, 0, true);
        }
        zzn(zzk);
        return zzk;
    }

    public final boolean zzb(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int zzk = zzk(bArr, i, i2);
        while (zzk < i2 && zzk != -1) {
            zzk = zzm(bArr, i, i2, zzk, z);
        }
        zzn(zzk);
        return zzk != -1;
    }

    public final int zzc(int i) throws IOException, InterruptedException {
        int zzj = zzj(i);
        if (zzj == 0) {
            zzj = zzm(zza, 0, Math.min(i, 4096), 0, true);
        }
        zzn(zzj);
        return zzj;
    }

    public final boolean zzd(int i, boolean z) throws IOException, InterruptedException {
        int zzj = zzj(i);
        while (zzj < i && zzj != -1) {
            zzj = zzm(zza, -zzj, Math.min(i, zzj + 4096), zzj, false);
        }
        zzn(zzj);
        return zzj != -1;
    }

    public final boolean zze(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        if (!zzf(i2, false)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i2, bArr, i, i2);
        return true;
    }

    public final boolean zzf(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.zzf + i;
        int length = this.zze.length;
        if (i2 > length) {
            this.zze = Arrays.copyOf(this.zze, zzava.zzf(length + length, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.zzg - this.zzf, i);
        while (min < i) {
            min = zzm(this.zze, this.zzf, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        int i3 = this.zzf + i;
        this.zzf = i3;
        this.zzg = Math.max(this.zzg, i3);
        return true;
    }

    public final void zzg() {
        this.zzf = 0;
    }

    public final long zzh() {
        return this.zzd;
    }

    public final long zzi() {
        return this.zzc;
    }
}
