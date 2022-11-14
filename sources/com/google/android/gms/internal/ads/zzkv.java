package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzkv {
    public final zzadt zza;
    public final Object zzb;
    public final zzafj[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzkw zzf;
    public boolean zzg;
    public final boolean[] zzh;
    public final zzmb[] zzi;
    public final zzahc zzj;
    public final zzlf zzk;
    @Nullable
    public zzkv zzl;
    public zzaft zzm = zzaft.zza;
    public zzahd zzn;
    public long zzo;

    public zzkv(zzmb[] zzmbArr, long j, zzahc zzahc, zzahy zzahy, zzlf zzlf, zzkw zzkw, zzahd zzahd, byte[] bArr) {
        zzkw zzkw2 = zzkw;
        this.zzi = zzmbArr;
        this.zzo = j;
        this.zzj = zzahc;
        this.zzk = zzlf;
        zzadv zzadv = zzkw2.zza;
        this.zzb = zzadv.zza;
        this.zzf = zzkw2;
        this.zzn = zzahd;
        this.zzc = new zzafj[2];
        this.zzh = new boolean[2];
        long j2 = zzkw2.zzb;
        long j3 = zzkw2.zzd;
        zzahy zzahy2 = zzahy;
        zzadt zzo2 = zzlf.zzo(zzadv, zzahy, j2);
        this.zza = j3 != -9223372036854775807L ? new zzadb(zzo2, true, 0, j3) : zzo2;
    }

    private final void zzs() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzahd zzahd = this.zzn;
                if (i < zzahd.zza) {
                    zzahd.zza(i);
                    zzagf zzagf = this.zzn.zzd[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzt() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzahd zzahd = this.zzn;
                if (i < zzahd.zza) {
                    zzahd.zza(i);
                    zzagf zzagf = this.zzn.zzd[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza() {
        return this.zzo;
    }

    public final void zzb(long j) {
        this.zzo = 0;
    }

    public final long zzc() {
        return this.zzf.zzb + this.zzo;
    }

    public final boolean zzd() {
        return this.zzd && (!this.zze || this.zza.zzh() == Long.MIN_VALUE);
    }

    public final long zze() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long zzh2 = this.zze ? this.zza.zzh() : Long.MIN_VALUE;
        return zzh2 == Long.MIN_VALUE ? this.zzf.zze : zzh2;
    }

    public final long zzf() {
        if (!this.zzd) {
            return 0;
        }
        return this.zza.zzl();
    }

    public final void zzg(float f, zzmv zzmv) throws zzio {
        this.zzd = true;
        this.zzm = this.zza.zzd();
        zzahd zzj2 = zzj(f, zzmv);
        zzkw zzkw = this.zzf;
        long j = zzkw.zzb;
        long j2 = zzkw.zze;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0, j2 - 1);
        }
        long zzk2 = zzk(zzj2, j, false);
        long j3 = this.zzo;
        zzkw zzkw2 = this.zzf;
        this.zzo = (zzkw2.zzb - zzk2) + j3;
        this.zzf = zzkw2.zza(zzk2);
    }

    public final void zzh(long j) {
        zzajg.zzd(zzu());
        if (this.zzd) {
            this.zza.zzf(j - this.zzo);
        }
    }

    public final void zzi(long j) {
        zzajg.zzd(zzu());
        this.zza.zzn(j - this.zzo);
    }

    public final zzahd zzj(float f, zzmv zzmv) throws zzio {
        zzahd zzj2 = this.zzj.zzj(this.zzi, this.zzm, this.zzf.zza, zzmv);
        for (zzagf zzagf : zzj2.zzd) {
        }
        return zzj2;
    }

    public final long zzk(zzahd zzahd, long j, boolean z) {
        return zzl(zzahd, j, false, new boolean[2]);
    }

    public final long zzl(zzahd zzahd, long j, boolean z, boolean[] zArr) {
        zzahd zzahd2 = zzahd;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzahd2.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z || !zzahd.zzb(this.zzn, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            this.zzi[i2].zza();
        }
        zzt();
        this.zzn = zzahd2;
        zzs();
        long zzq = this.zza.zzq(zzahd2.zzd, this.zzh, this.zzc, zArr, j);
        for (int i3 = 0; i3 < 2; i3++) {
            this.zzi[i3].zza();
        }
        this.zze = false;
        int i4 = 0;
        while (true) {
            zzafj[] zzafjArr = this.zzc;
            if (i4 >= 2) {
                return zzq;
            }
            if (zzafjArr[i4] != null) {
                zzajg.zzd(zzahd.zza(i4));
                this.zzi[i4].zza();
                this.zze = true;
            } else {
                zzajg.zzd(zzahd2.zzd[i4] == null);
            }
            i4++;
        }
    }

    public final void zzm() {
        zzt();
        zzlf zzlf = this.zzk;
        zzadt zzadt = this.zza;
        try {
            if (zzadt instanceof zzadb) {
                zzlf.zzd(((zzadb) zzadt).zza);
            } else {
                zzlf.zzd(zzadt);
            }
        } catch (RuntimeException e) {
            zzaka.zzb("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzn(@Nullable zzkv zzkv) {
        if (zzkv != this.zzl) {
            zzt();
            this.zzl = zzkv;
            zzs();
        }
    }

    @Nullable
    public final zzkv zzo() {
        return this.zzl;
    }

    public final zzaft zzp() {
        return this.zzm;
    }

    public final zzahd zzq() {
        return this.zzn;
    }

    public final void zzr() {
        zzadt zzadt = this.zza;
        if (zzadt instanceof zzadb) {
            long j = this.zzf.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zzadb) zzadt).zza(0, j);
        }
    }
}
