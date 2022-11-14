package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzie implements zzma, zzmb {
    public final int zza;
    public final zzkd zzb = new zzkd();
    @Nullable
    public zzmc zzc;
    public int zzd;
    public int zze;
    @Nullable
    public zzafj zzf;
    @Nullable
    public zzkc[] zzg;
    public long zzh;
    public long zzi = Long.MIN_VALUE;
    public boolean zzj;
    public boolean zzk;

    public zzie(int i) {
        this.zza = i;
    }

    public void zzA() {
    }

    public final zzkd zzB() {
        zzkd zzkd = this.zzb;
        zzkd.zzb = null;
        zzkd.zza = null;
        return zzkd;
    }

    public final zzkc[] zzC() {
        zzkc[] zzkcArr = this.zzg;
        if (zzkcArr != null) {
            return zzkcArr;
        }
        throw null;
    }

    public final zzmc zzD() {
        zzmc zzmc = this.zzc;
        if (zzmc != null) {
            return zzmc;
        }
        throw null;
    }

    public final zzio zzE(Throwable th, @Nullable zzkc zzkc, boolean z) {
        int i;
        if (zzkc != null && !this.zzk) {
            this.zzk = true;
            try {
                int zzN = zzN(zzkc) & 7;
                this.zzk = false;
                i = zzN;
            } catch (zzio unused) {
                this.zzk = false;
            } catch (Throwable th2) {
                this.zzk = false;
                throw th2;
            }
            return zzio.zzc(th, zzJ(), this.zzd, zzkc, i, z);
        }
        i = 4;
        return zzio.zzc(th, zzJ(), this.zzd, zzkc, i, z);
    }

    public final int zzF(zzkd zzkd, zzrr zzrr, int i) {
        zzafj zzafj = this.zzf;
        if (zzafj != null) {
            int zzd2 = zzafj.zzd(zzkd, zzrr, i);
            if (zzd2 == -4) {
                if (zzrr.zzc()) {
                    this.zzi = Long.MIN_VALUE;
                    return this.zzj ? -4 : -3;
                }
                long j = zzrr.zzd + this.zzh;
                zzrr.zzd = j;
                this.zzi = Math.max(this.zzi, j);
            } else if (zzd2 == -5) {
                zzkc zzkc = zzkd.zza;
                if (zzkc == null) {
                    throw null;
                } else if (zzkc.zzp != RecyclerView.FOREVER_NS) {
                    zzkb zzkb = new zzkb(zzkc, (zzka) null);
                    zzkb.zzn(zzkc.zzp + this.zzh);
                    zzkd.zza = new zzkc(zzkb, (zzka) null);
                    return -5;
                }
            }
            return zzd2;
        }
        throw null;
    }

    public final int zzG(long j) {
        zzafj zzafj = this.zzf;
        if (zzafj != null) {
            return zzafj.zze(j - this.zzh);
        }
        throw null;
    }

    public final boolean zzH() {
        if (zzj()) {
            return this.zzj;
        }
        zzafj zzafj = this.zzf;
        if (zzafj != null) {
            return zzafj.zzb();
        }
        throw null;
    }

    public void zzI(float f, float f2) throws zzio {
    }

    public final int zza() {
        return this.zza;
    }

    public final zzmb zzb() {
        return this;
    }

    public final void zzbi() throws zzio {
        boolean z = true;
        if (this.zze != 1) {
            z = false;
        }
        zzajg.zzd(z);
        this.zze = 2;
        zzx();
    }

    public final void zzbj(zzkc[] zzkcArr, zzafj zzafj, long j, long j2) throws zzio {
        zzajg.zzd(!this.zzj);
        this.zzf = zzafj;
        if (this.zzi == Long.MIN_VALUE) {
            this.zzi = j;
        }
        this.zzg = zzkcArr;
        this.zzh = j2;
        zzv(zzkcArr, j, j2);
    }

    @Nullable
    public final zzafj zzbk() {
        return this.zzf;
    }

    public final void zzc(int i) {
        this.zzd = i;
    }

    @Nullable
    public zzakc zzd() {
        return null;
    }

    public final int zze() {
        return this.zze;
    }

    public final void zzf(zzmc zzmc, zzkc[] zzkcArr, zzafj zzafj, long j, boolean z, boolean z2, long j2, long j3) throws zzio {
        boolean z3 = z;
        zzajg.zzd(this.zze == 0);
        this.zzc = zzmc;
        this.zze = 1;
        zzu(z, z2);
        zzbj(zzkcArr, zzafj, j2, j3);
        long j4 = j;
        zzw(j, z);
    }

    public final boolean zzj() {
        return this.zzi == Long.MIN_VALUE;
    }

    public final long zzk() {
        return this.zzi;
    }

    public final void zzl() {
        this.zzj = true;
    }

    public final boolean zzm() {
        return this.zzj;
    }

    public final void zzn() throws IOException {
        zzafj zzafj = this.zzf;
        if (zzafj != null) {
            zzafj.zzc();
            return;
        }
        throw null;
    }

    public final void zzo(long j) throws zzio {
        this.zzj = false;
        this.zzi = j;
        zzw(j, false);
    }

    public final void zzp() {
        zzajg.zzd(this.zze == 2);
        this.zze = 1;
        zzy();
    }

    public final void zzq() {
        boolean z = true;
        if (this.zze != 1) {
            z = false;
        }
        zzajg.zzd(z);
        zzkd zzkd = this.zzb;
        zzkd.zzb = null;
        zzkd.zza = null;
        this.zze = 0;
        this.zzf = null;
        this.zzg = null;
        this.zzj = false;
        zzz();
    }

    public final void zzr() {
        zzajg.zzd(this.zze == 0);
        zzkd zzkd = this.zzb;
        zzkd.zzb = null;
        zzkd.zza = null;
        zzA();
    }

    public int zzs() throws zzio {
        return 0;
    }

    public void zzt(int i, @Nullable Object obj) throws zzio {
    }

    public void zzu(boolean z, boolean z2) throws zzio {
    }

    public void zzv(zzkc[] zzkcArr, long j, long j2) throws zzio {
        throw null;
    }

    public void zzw(long j, boolean z) throws zzio {
        throw null;
    }

    public void zzx() throws zzio {
    }

    public void zzy() {
    }

    public void zzz() {
        throw null;
    }
}
