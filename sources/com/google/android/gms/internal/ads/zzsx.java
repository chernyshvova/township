package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsx implements zztb {
    public final byte[] zza = new byte[4096];
    public final zzahq zzb;
    public final long zzc;
    public long zzd;
    public byte[] zze = new byte[65536];
    public int zzf;
    public int zzg;

    public zzsx(zzahq zzahq, long j, long j2) {
        this.zzb = zzahq;
        this.zzd = j;
        this.zzc = j2;
    }

    private final void zzp(int i) {
        int i2 = this.zzf + i;
        int length = this.zze.length;
        if (i2 > length) {
            this.zze = Arrays.copyOf(this.zze, zzalh.zzx(length + length, 65536 + i2, i2 + 524288));
        }
    }

    private final int zzq(int i) {
        int min = Math.min(this.zzg, i);
        zzs(min);
        return min;
    }

    private final int zzr(byte[] bArr, int i, int i2) {
        int i3 = this.zzg;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zze, 0, bArr, i, min);
        zzs(min);
        return min;
    }

    private final void zzs(int i) {
        int i2 = this.zzg - i;
        this.zzg = i2;
        this.zzf = 0;
        byte[] bArr = this.zze;
        byte[] bArr2 = i2 < bArr.length + -524288 ? new byte[(65536 + i2)] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.zze = bArr2;
    }

    private final int zzt(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (!Thread.interrupted()) {
            int zza2 = this.zzb.zza(bArr, i + i3, i2 - i3);
            if (zza2 != -1) {
                return i3 + zza2;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    private final void zzu(int i) {
        if (i != -1) {
            this.zzd += (long) i;
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int zzr = zzr(bArr, i, i2);
        if (zzr == 0) {
            zzr = zzt(bArr, i, i2, 0, true);
        }
        zzu(zzr);
        return zzr;
    }

    public final boolean zzb(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int zzr = zzr(bArr, i, i2);
        while (zzr < i2 && zzr != -1) {
            zzr = zzt(bArr, i, i2, zzr, z);
        }
        zzu(zzr);
        return zzr != -1;
    }

    public final void zzc(byte[] bArr, int i, int i2) throws IOException {
        zzb(bArr, i, i2, false);
    }

    public final int zzd(int i) throws IOException {
        int zzq = zzq(1);
        if (zzq == 0) {
            zzq = zzt(this.zza, 0, Math.min(1, 4096), 0, true);
        }
        zzu(zzq);
        return zzq;
    }

    public final boolean zze(int i, boolean z) throws IOException {
        int zzq = zzq(i);
        while (zzq < i && zzq != -1) {
            zzq = zzt(this.zza, -zzq, Math.min(i, zzq + 4096), zzq, false);
        }
        zzu(zzq);
        return zzq != -1;
    }

    public final void zzf(int i) throws IOException {
        zze(i, false);
    }

    public final int zzg(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        zzp(i2);
        int i4 = this.zzg;
        int i5 = this.zzf;
        int i6 = i4 - i5;
        if (i6 == 0) {
            i3 = zzt(this.zze, i5, i2, 0, true);
            if (i3 == -1) {
                return -1;
            }
            this.zzg += i3;
        } else {
            i3 = Math.min(i2, i6);
        }
        System.arraycopy(this.zze, this.zzf, bArr, i, i3);
        this.zzf += i3;
        return i3;
    }

    public final boolean zzh(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!zzj(i2, z)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i2, bArr, i, i2);
        return true;
    }

    public final void zzi(byte[] bArr, int i, int i2) throws IOException {
        zzh(bArr, i, i2, false);
    }

    public final boolean zzj(int i, boolean z) throws IOException {
        zzp(i);
        int i2 = this.zzg - this.zzf;
        while (i2 < i) {
            i2 = zzt(this.zze, this.zzf, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.zzg = this.zzf + i2;
        }
        this.zzf += i;
        return true;
    }

    public final void zzk(int i) throws IOException {
        zzj(i, false);
    }

    public final void zzl() {
        this.zzf = 0;
    }

    public final long zzm() {
        return this.zzd + ((long) this.zzf);
    }

    public final long zzn() {
        return this.zzd;
    }

    public final long zzo() {
        return this.zzc;
    }
}
