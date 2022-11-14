package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzamu implements zzanp, zzanq {
    public final int zza;
    public zzanr zzb;
    public int zzc;
    public int zzd;
    public zzasx zze;
    public long zzf;
    public boolean zzg = true;
    public boolean zzh;

    public zzamu(int i) {
        this.zza = i;
    }

    public final int zzA(zzanl zzanl, zzapd zzapd, boolean z) {
        zzanl zzanl2 = zzanl;
        zzapd zzapd2 = zzapd;
        int zzc2 = this.zze.zzc(zzanl2, zzapd2, z);
        if (zzc2 == -4) {
            if (zzapd.zzc()) {
                this.zzg = true;
                return this.zzh ? -4 : -3;
            }
            zzapd2.zzc += this.zzf;
        } else if (zzc2 == -5) {
            zzank zzank = zzanl2.zza;
            long j = zzank.zzw;
            if (j != RecyclerView.FOREVER_NS) {
                zzanl2.zza = new zzank(zzank.zza, zzank.zze, zzank.zzf, zzank.zzc, zzank.zzb, zzank.zzg, zzank.zzj, zzank.zzk, zzank.zzl, zzank.zzm, zzank.zzn, zzank.zzp, zzank.zzo, zzank.zzq, zzank.zzr, zzank.zzs, zzank.zzt, zzank.zzu, zzank.zzv, zzank.zzx, zzank.zzy, zzank.zzz, j + this.zzf, zzank.zzh, zzank.zzi, zzank.zzd);
                return -5;
            }
        }
        return zzc2;
    }

    public final void zzB(long j) {
        this.zze.zzd(j - this.zzf);
    }

    public final boolean zzC() {
        return this.zzg ? this.zzh : this.zze.zza();
    }

    public final int zza() {
        return this.zza;
    }

    public final zzanq zzb() {
        return this;
    }

    public final void zzc(int i) {
        this.zzc = i;
    }

    public zzaup zzd() {
        return null;
    }

    public final int zze() {
        return this.zzd;
    }

    public final void zzf(zzanr zzanr, zzank[] zzankArr, zzasx zzasx, long j, boolean z, long j2) throws zzamw {
        zzaul.zzd(this.zzd == 0);
        this.zzb = zzanr;
        this.zzd = 1;
        zzs(z);
        zzh(zzankArr, zzasx, j2);
        zzu(j, z);
    }

    public final void zzg() throws zzamw {
        boolean z = true;
        if (this.zzd != 1) {
            z = false;
        }
        zzaul.zzd(z);
        this.zzd = 2;
        zzv();
    }

    public final void zzh(zzank[] zzankArr, zzasx zzasx, long j) throws zzamw {
        zzaul.zzd(!this.zzh);
        this.zze = zzasx;
        this.zzg = false;
        this.zzf = j;
        zzt(zzankArr, j);
    }

    public final zzasx zzi() {
        return this.zze;
    }

    public final boolean zzj() {
        return this.zzg;
    }

    public final void zzk() {
        this.zzh = true;
    }

    public final boolean zzl() {
        return this.zzh;
    }

    public final void zzm() throws IOException {
        this.zze.zzb();
    }

    public final void zzn(long j) throws zzamw {
        this.zzh = false;
        this.zzg = false;
        zzu(j, false);
    }

    public final void zzo() throws zzamw {
        zzaul.zzd(this.zzd == 2);
        this.zzd = 1;
        zzw();
    }

    public final void zzp() {
        boolean z = true;
        if (this.zzd != 1) {
            z = false;
        }
        zzaul.zzd(z);
        this.zzd = 0;
        this.zze = null;
        this.zzh = false;
        zzx();
    }

    public int zzq() throws zzamw {
        throw null;
    }

    public void zzr(int i, Object obj) throws zzamw {
    }

    public void zzs(boolean z) throws zzamw {
    }

    public void zzt(zzank[] zzankArr, long j) throws zzamw {
    }

    public void zzu(long j, boolean z) throws zzamw {
        throw null;
    }

    public void zzv() throws zzamw {
    }

    public void zzw() throws zzamw {
    }

    public void zzx() {
        throw null;
    }

    public final zzanr zzy() {
        return this.zzb;
    }

    public final int zzz() {
        return this.zzc;
    }
}
