package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzym {
    public final zztz zza;
    public long zzb;
    public boolean zzc;
    public int zzd;
    public long zze;
    public boolean zzf;
    public boolean zzg;
    public boolean zzh;
    public boolean zzi;
    public boolean zzj;
    public long zzk;
    public long zzl;
    public boolean zzm;

    public zzym(zztz zztz) {
        this.zza = zztz;
    }

    private final void zze(int i) {
        boolean z = this.zzm;
        long j = this.zzb;
        long j2 = this.zzk;
        int i2 = z ? 1 : 0;
        this.zza.zzd(this.zzl, i2, (int) (j - j2), i, (zzty) null);
    }

    public final void zza() {
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
    }

    public final void zzb(long j, int i, int i2, long j2, boolean z) {
        boolean z2 = false;
        this.zzg = false;
        this.zzh = false;
        this.zze = j2;
        this.zzd = 0;
        this.zzb = j;
        if (i2 >= 32 && i2 != 40) {
            if (this.zzi && !this.zzj) {
                if (z) {
                    zze(i);
                }
                this.zzi = false;
            }
            if (i2 <= 35 || i2 == 39) {
                this.zzh = !this.zzj;
                this.zzj = true;
            }
        }
        boolean z3 = i2 >= 16 && i2 <= 21;
        this.zzc = z3;
        if (z3 || i2 <= 9) {
            z2 = true;
        }
        this.zzf = z2;
    }

    public final void zzc(byte[] bArr, int i, int i2) {
        if (this.zzf) {
            int i3 = this.zzd;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                this.zzg = (bArr[i4] & 128) != 0;
                this.zzf = false;
                return;
            }
            this.zzd = (i2 - i) + i3;
        }
    }

    public final void zzd(long j, int i, boolean z) {
        if (this.zzj && this.zzg) {
            this.zzm = this.zzc;
            this.zzj = false;
        } else if (this.zzh || this.zzg) {
            if (z && this.zzi) {
                zze(i + ((int) (j - this.zzb)));
            }
            this.zzk = this.zzb;
            this.zzl = this.zze;
            this.zzm = this.zzc;
            this.zzi = true;
        }
    }
}
