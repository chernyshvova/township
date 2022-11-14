package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzadn implements zzadt, zzads {
    public final zzadv zza;
    public final long zzb;
    public zzadx zzc;
    public zzadt zzd;
    @Nullable
    public zzads zze;
    public long zzf = -9223372036854775807L;
    public final zzahy zzg;

    public zzadn(zzadv zzadv, zzahy zzahy, long j, byte[] bArr) {
        this.zza = zzadv;
        this.zzg = zzahy;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    public final long zza() {
        return this.zzb;
    }

    public final void zzb(zzads zzads, long j) {
        this.zze = zzads;
        zzadt zzadt = this.zzd;
        if (zzadt != null) {
            zzadt.zzb(this, zzv(this.zzb));
        }
    }

    public final void zzc() throws IOException {
        try {
            zzadt zzadt = this.zzd;
            if (zzadt != null) {
                zzadt.zzc();
                return;
            }
            zzadx zzadx = this.zzc;
            if (zzadx != null) {
                zzadx.zzu();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public final zzaft zzd() {
        zzadt zzadt = this.zzd;
        int i = zzalh.zza;
        return zzadt.zzd();
    }

    public final void zze(long j, boolean z) {
        zzadt zzadt = this.zzd;
        int i = zzalh.zza;
        zzadt.zze(j, false);
    }

    public final void zzf(long j) {
        zzadt zzadt = this.zzd;
        int i = zzalh.zza;
        zzadt.zzf(j);
    }

    public final long zzg() {
        zzadt zzadt = this.zzd;
        int i = zzalh.zza;
        return zzadt.zzg();
    }

    public final long zzh() {
        zzadt zzadt = this.zzd;
        int i = zzalh.zza;
        return zzadt.zzh();
    }

    public final long zzi(long j) {
        zzadt zzadt = this.zzd;
        int i = zzalh.zza;
        return zzadt.zzi(j);
    }

    public final void zzj(zzadt zzadt) {
        zzads zzads = this.zze;
        int i = zzalh.zza;
        zzads.zzj(this);
    }

    public final long zzk(long j, zzme zzme) {
        zzadt zzadt = this.zzd;
        int i = zzalh.zza;
        return zzadt.zzk(j, zzme);
    }

    public final long zzl() {
        zzadt zzadt = this.zzd;
        int i = zzalh.zza;
        return zzadt.zzl();
    }

    public final /* bridge */ /* synthetic */ void zzm(zzafl zzafl) {
        zzadt zzadt = (zzadt) zzafl;
        zzads zzads = this.zze;
        int i = zzalh.zza;
        zzads.zzm(this);
    }

    public final boolean zzn(long j) {
        zzadt zzadt = this.zzd;
        return zzadt != null && zzadt.zzn(j);
    }

    public final boolean zzo() {
        zzadt zzadt = this.zzd;
        return zzadt != null && zzadt.zzo();
    }

    public final void zzp(long j) {
        this.zzf = j;
    }

    public final long zzq(zzagf[] zzagfArr, boolean[] zArr, zzafj[] zzafjArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.zzf;
        if (j3 == -9223372036854775807L || j != this.zzb) {
            j2 = j;
        } else {
            this.zzf = -9223372036854775807L;
            j2 = j3;
        }
        zzadt zzadt = this.zzd;
        int i = zzalh.zza;
        return zzadt.zzq(zzagfArr, zArr, zzafjArr, zArr2, j2);
    }

    public final long zzr() {
        return this.zzf;
    }

    public final void zzs(zzadx zzadx) {
        zzajg.zzd(this.zzc == null);
        this.zzc = zzadx;
    }

    public final void zzt(zzadv zzadv) {
        long zzv = zzv(this.zzb);
        zzadx zzadx = this.zzc;
        if (zzadx != null) {
            zzadt zzC = zzadx.zzC(zzadv, this.zzg, zzv);
            this.zzd = zzC;
            if (this.zze != null) {
                zzC.zzb(this, zzv);
                return;
            }
            return;
        }
        throw null;
    }

    public final void zzu() {
        zzadt zzadt = this.zzd;
        if (zzadt != null) {
            zzadx zzadx = this.zzc;
            if (zzadx != null) {
                zzadx.zzA(zzadt);
                return;
            }
            throw null;
        }
    }
}
