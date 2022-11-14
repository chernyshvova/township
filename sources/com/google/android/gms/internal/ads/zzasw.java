package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzasw implements zzapu {
    public final zzast zza = new zzast();
    public final zzass zzb = new zzass();
    public final zzaut zzc = new zzaut(32);
    public final AtomicInteger zzd = new AtomicInteger();
    public zzasu zze;
    public zzasu zzf;
    public zzank zzg;
    public zzank zzh;
    public long zzi;
    public int zzj = 65536;
    public zzasv zzk;
    public final zzaty zzl;

    public zzasw(zzaty zzaty, byte[] bArr) {
        this.zzl = zzaty;
        zzasu zzasu = new zzasu(0, 65536);
        this.zze = zzasu;
        this.zzf = zzasu;
    }

    private final void zzo(long j, byte[] bArr, int i) {
        zzp(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zze.zza);
            int min = Math.min(i - i2, 65536 - i3);
            zzats zzats = this.zze.zzd;
            System.arraycopy(zzats.zza, i3, bArr, i2, min);
            j += (long) min;
            i2 += min;
            if (j == this.zze.zzb) {
                this.zzl.zzd(zzats);
                zzasu zzasu = this.zze;
                zzasu.zzd = null;
                this.zze = zzasu.zze;
            }
        }
    }

    private final void zzp(long j) {
        while (true) {
            zzasu zzasu = this.zze;
            if (j >= zzasu.zzb) {
                this.zzl.zzd(zzasu.zzd);
                zzasu zzasu2 = this.zze;
                zzasu2.zzd = null;
                this.zze = zzasu2.zze;
            } else {
                return;
            }
        }
    }

    private final boolean zzq() {
        return this.zzd.compareAndSet(0, 1);
    }

    private final void zzr() {
        if (!this.zzd.compareAndSet(1, 0)) {
            zzs();
        }
    }

    private final void zzs() {
        this.zza.zza();
        zzasu zzasu = this.zze;
        if (zzasu.zzc) {
            zzasu zzasu2 = this.zzf;
            int i = (((int) (zzasu2.zza - zzasu.zza)) / 65536) + (zzasu2.zzc ? 1 : 0);
            zzats[] zzatsArr = new zzats[i];
            for (int i2 = 0; i2 < i; i2++) {
                zzatsArr[i2] = zzasu.zzd;
                zzasu.zzd = null;
                zzasu = zzasu.zze;
            }
            this.zzl.zze(zzatsArr);
        }
        zzasu zzasu3 = new zzasu(0, 65536);
        this.zze = zzasu3;
        this.zzf = zzasu3;
        this.zzi = 0;
        this.zzj = 65536;
        this.zzl.zzf();
    }

    private final int zzt(int i) {
        if (this.zzj == 65536) {
            this.zzj = 0;
            zzasu zzasu = this.zzf;
            if (zzasu.zzc) {
                this.zzf = zzasu.zze;
            }
            zzasu zzasu2 = this.zzf;
            zzats zzc2 = this.zzl.zzc();
            zzasu zzasu3 = new zzasu(this.zzf.zzb, 65536);
            zzasu2.zzd = zzc2;
            zzasu2.zze = zzasu3;
            zzasu2.zzc = true;
        }
        return Math.min(i, 65536 - this.zzj);
    }

    public final void zza(zzank zzank) {
        zzank zzank2 = zzank == null ? null : zzank;
        boolean zzj2 = this.zza.zzj(zzank2);
        this.zzh = zzank;
        zzasv zzasv = this.zzk;
        if (zzasv != null && zzj2) {
            zzasv.zzp(zzank2);
        }
    }

    public final void zzb(zzaut zzaut, int i) {
        if (zzq()) {
            while (i > 0) {
                int zzt = zzt(i);
                zzaut.zzk(this.zzf.zzd.zza, this.zzj, zzt);
                this.zzj += zzt;
                this.zzi += (long) zzt;
                i -= zzt;
            }
            zzr();
            return;
        }
        zzaut.zzj(i);
    }

    public final void zzc(long j, int i, int i2, int i3, zzapt zzapt) {
        if (zzq()) {
            try {
                this.zza.zzk(j, i, this.zzi - ((long) i2), i2, zzapt);
            } finally {
                zzr();
            }
        } else {
            long j2 = j;
            this.zza.zzl(j);
        }
    }

    public final int zzd(zzapk zzapk, int i, boolean z) throws IOException, InterruptedException {
        if (!zzq()) {
            int zzc2 = zzapk.zzc(i);
            if (zzc2 != -1) {
                return zzc2;
            }
            throw new EOFException();
        }
        try {
            int zza2 = zzapk.zza(this.zzf.zzd.zza, this.zzj, zzt(i));
            if (zza2 != -1) {
                this.zzj += zza2;
                this.zzi += (long) zza2;
                return zza2;
            }
            throw new EOFException();
        } finally {
            zzr();
        }
    }

    public final void zze(boolean z) {
        int andSet = this.zzd.getAndSet(true != z ? 2 : 0);
        zzs();
        this.zza.zzb();
        if (andSet == 2) {
            this.zzg = null;
        }
    }

    public final int zzf() {
        return this.zza.zzc();
    }

    public final void zzg() {
        if (this.zzd.getAndSet(2) == 0) {
            zzs();
        }
    }

    public final boolean zzh() {
        return this.zza.zzd();
    }

    public final zzank zzi() {
        return this.zza.zze();
    }

    public final long zzj() {
        return this.zza.zzf();
    }

    public final void zzk() {
        long zzh2 = this.zza.zzh();
        if (zzh2 != -1) {
            zzp(zzh2);
        }
    }

    public final boolean zzl(long j, boolean z) {
        long zzi2 = this.zza.zzi(j, z);
        if (zzi2 == -1) {
            return false;
        }
        zzp(zzi2);
        return true;
    }

    public final int zzm(zzanl zzanl, zzapd zzapd, boolean z, boolean z2, long j) {
        int i;
        zzapd zzapd2 = zzapd;
        int zzg2 = this.zza.zzg(zzanl, zzapd, z, z2, this.zzg, this.zzb);
        if (zzg2 == -5) {
            this.zzg = zzanl.zza;
            return -5;
        } else if (zzg2 != -4) {
            return -3;
        } else {
            if (!zzapd.zzc()) {
                if (zzapd2.zzc < j) {
                    zzapd2.zzf(Integer.MIN_VALUE);
                }
                if (zzapd.zzi()) {
                    zzass zzass = this.zzb;
                    long j2 = zzass.zzb;
                    this.zzc.zza(1);
                    zzo(j2, this.zzc.zza, 1);
                    long j3 = j2 + 1;
                    byte b = this.zzc.zza[0];
                    byte b2 = b & 128;
                    byte b3 = b & Byte.MAX_VALUE;
                    zzapb zzapb = zzapd2.zza;
                    if (zzapb.zza == null) {
                        zzapb.zza = new byte[16];
                    }
                    zzo(j3, zzapb.zza, b3);
                    long j4 = j3 + ((long) b3);
                    if (b2 != 0) {
                        this.zzc.zza(2);
                        zzo(j4, this.zzc.zza, 2);
                        j4 += 2;
                        i = this.zzc.zzm();
                    } else {
                        i = 1;
                    }
                    zzapb zzapb2 = zzapd2.zza;
                    int[] iArr = zzapb2.zzd;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzapb2.zze;
                    if (iArr3 == null || iArr3.length < i) {
                        iArr3 = new int[i];
                    }
                    int[] iArr4 = iArr3;
                    if (b2 != 0) {
                        int i2 = i * 6;
                        this.zzc.zza(i2);
                        zzo(j4, this.zzc.zza, i2);
                        j4 += (long) i2;
                        this.zzc.zzi(0);
                        for (int i3 = 0; i3 < i; i3++) {
                            iArr2[i3] = this.zzc.zzm();
                            iArr4[i3] = this.zzc.zzu();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zzass.zza - ((int) (j4 - zzass.zzb));
                    }
                    zzapt zzapt = zzass.zzd;
                    zzapb zzapb3 = zzapd2.zza;
                    zzapb3.zza(i, iArr2, iArr4, zzapt.zzb, zzapb3.zza, 1);
                    long j5 = zzass.zzb;
                    int i4 = (int) (j4 - j5);
                    zzass.zzb = j5 + ((long) i4);
                    zzass.zza -= i4;
                }
                zzapd2.zzh(this.zzb.zza);
                zzass zzass2 = this.zzb;
                long j6 = zzass2.zzb;
                ByteBuffer byteBuffer = zzapd2.zzb;
                int i5 = zzass2.zza;
                zzp(j6);
                while (i5 > 0) {
                    int i6 = (int) (j6 - this.zze.zza);
                    int min = Math.min(i5, 65536 - i6);
                    zzats zzats = this.zze.zzd;
                    byteBuffer.put(zzats.zza, i6, min);
                    j6 += (long) min;
                    i5 -= min;
                    if (j6 == this.zze.zzb) {
                        this.zzl.zzd(zzats);
                        zzasu zzasu = this.zze;
                        zzasu.zzd = null;
                        this.zze = zzasu.zze;
                    }
                }
                zzp(this.zzb.zzc);
            }
            return -4;
        }
    }

    public final void zzn(zzasv zzasv) {
        this.zzk = zzasv;
    }
}
