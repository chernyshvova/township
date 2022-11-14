package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzf {
    public final zzfu zza;
    public long zzaa;
    public long zzab;
    public long zzac;
    public String zzad;
    public boolean zzae;
    public long zzaf;
    public long zzag;
    public final String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public String zzf;
    public long zzg;
    public long zzh;
    public long zzi;
    public String zzj;
    public long zzk;
    public String zzl;
    public long zzm;
    public long zzn;
    public boolean zzo;
    public long zzp;
    public boolean zzq;
    public boolean zzr;
    public String zzs;
    public Boolean zzt;
    public long zzu;
    public List<String> zzv;
    public String zzw;
    public long zzx;
    public long zzy;
    public long zzz;

    @WorkerThread
    public zzf(zzfu zzfu, String str) {
        Preconditions.checkNotNull(zzfu);
        Preconditions.checkNotEmpty(str);
        this.zza = zzfu;
        this.zzb = str;
        zzfu.zzp().zzc();
    }

    @WorkerThread
    public final boolean zza() {
        this.zza.zzp().zzc();
        return this.zzae;
    }

    @WorkerThread
    public final long zzaa() {
        this.zza.zzp().zzc();
        return this.zzac;
    }

    @WorkerThread
    public final long zzab() {
        this.zza.zzp().zzc();
        return this.zzab;
    }

    @WorkerThread
    public final String zzac() {
        this.zza.zzp().zzc();
        return this.zzad;
    }

    @WorkerThread
    public final String zzad() {
        this.zza.zzp().zzc();
        String str = this.zzad;
        zzi((String) null);
        return str;
    }

    @WorkerThread
    public final long zzae() {
        this.zza.zzp().zzc();
        return this.zzp;
    }

    @WorkerThread
    public final boolean zzaf() {
        this.zza.zzp().zzc();
        return this.zzq;
    }

    @WorkerThread
    public final boolean zzag() {
        this.zza.zzp().zzc();
        return this.zzr;
    }

    @WorkerThread
    public final Boolean zzah() {
        this.zza.zzp().zzc();
        return this.zzt;
    }

    @WorkerThread
    @Nullable
    public final List<String> zzai() {
        this.zza.zzp().zzc();
        return this.zzv;
    }

    @WorkerThread
    public final void zzb() {
        this.zza.zzp().zzc();
        this.zzae = false;
    }

    @WorkerThread
    public final String zzc() {
        this.zza.zzp().zzc();
        return this.zzb;
    }

    @WorkerThread
    public final String zzd() {
        this.zza.zzp().zzc();
        return this.zzc;
    }

    @WorkerThread
    public final String zze() {
        this.zza.zzp().zzc();
        return this.zzd;
    }

    @WorkerThread
    public final String zzf() {
        this.zza.zzp().zzc();
        return this.zzs;
    }

    @WorkerThread
    public final String zzg() {
        this.zza.zzp().zzc();
        return this.zzw;
    }

    @WorkerThread
    public final String zzh() {
        this.zza.zzp().zzc();
        return this.zze;
    }

    @WorkerThread
    public final String zzi() {
        this.zza.zzp().zzc();
        return this.zzf;
    }

    @WorkerThread
    public final long zzj() {
        this.zza.zzp().zzc();
        return this.zzh;
    }

    @WorkerThread
    public final long zzk() {
        this.zza.zzp().zzc();
        return this.zzi;
    }

    @WorkerThread
    public final String zzl() {
        this.zza.zzp().zzc();
        return this.zzj;
    }

    @WorkerThread
    public final long zzm() {
        this.zza.zzp().zzc();
        return this.zzk;
    }

    @WorkerThread
    public final String zzn() {
        this.zza.zzp().zzc();
        return this.zzl;
    }

    @WorkerThread
    public final long zzo() {
        this.zza.zzp().zzc();
        return this.zzm;
    }

    @WorkerThread
    public final long zzp() {
        this.zza.zzp().zzc();
        return this.zzn;
    }

    @WorkerThread
    public final long zzq() {
        this.zza.zzp().zzc();
        return this.zzu;
    }

    @WorkerThread
    public final boolean zzr() {
        this.zza.zzp().zzc();
        return this.zzo;
    }

    @WorkerThread
    public final long zzs() {
        this.zza.zzp().zzc();
        return this.zzg;
    }

    @WorkerThread
    public final long zzt() {
        this.zza.zzp().zzc();
        return this.zzaf;
    }

    @WorkerThread
    public final long zzu() {
        this.zza.zzp().zzc();
        return this.zzag;
    }

    @WorkerThread
    public final void zzv() {
        this.zza.zzp().zzc();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            this.zza.zzq().zzh().zza("Bundle index overflow. appId", zzeq.zza(this.zzb));
            j = 0;
        }
        this.zzae = true;
        this.zzg = j;
    }

    @WorkerThread
    public final long zzw() {
        this.zza.zzp().zzc();
        return this.zzx;
    }

    @WorkerThread
    public final long zzx() {
        this.zza.zzp().zzc();
        return this.zzy;
    }

    @WorkerThread
    public final long zzy() {
        this.zza.zzp().zzc();
        return this.zzz;
    }

    @WorkerThread
    public final long zzz() {
        this.zza.zzp().zzc();
        return this.zzaa;
    }

    @WorkerThread
    public final void zza(String str) {
        this.zza.zzp().zzc();
        this.zzae |= !zzkv.zzc(this.zzc, str);
        this.zzc = str;
    }

    @WorkerThread
    public final void zzb(String str) {
        this.zza.zzp().zzc();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzae |= !zzkv.zzc(this.zzd, str);
        this.zzd = str;
    }

    @WorkerThread
    public final void zzc(String str) {
        this.zza.zzp().zzc();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzae |= !zzkv.zzc(this.zzs, str);
        this.zzs = str;
    }

    @WorkerThread
    public final void zzd(String str) {
        this.zza.zzp().zzc();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzae |= !zzkv.zzc(this.zzw, str);
        this.zzw = str;
    }

    @WorkerThread
    public final void zze(String str) {
        this.zza.zzp().zzc();
        this.zzae |= !zzkv.zzc(this.zze, str);
        this.zze = str;
    }

    @WorkerThread
    public final void zzf(String str) {
        this.zza.zzp().zzc();
        this.zzae |= !zzkv.zzc(this.zzf, str);
        this.zzf = str;
    }

    @WorkerThread
    public final void zzg(String str) {
        this.zza.zzp().zzc();
        this.zzae |= !zzkv.zzc(this.zzj, str);
        this.zzj = str;
    }

    @WorkerThread
    public final void zzh(String str) {
        this.zza.zzp().zzc();
        this.zzae |= !zzkv.zzc(this.zzl, str);
        this.zzl = str;
    }

    @WorkerThread
    public final void zzi(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzag != j;
        this.zzag = j;
    }

    @WorkerThread
    public final void zzj(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzx != j;
        this.zzx = j;
    }

    @WorkerThread
    public final void zzk(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzy != j;
        this.zzy = j;
    }

    @WorkerThread
    public final void zzl(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzz != j;
        this.zzz = j;
    }

    @WorkerThread
    public final void zzm(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzaa != j;
        this.zzaa = j;
    }

    @WorkerThread
    public final void zzn(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzac != j;
        this.zzac = j;
    }

    @WorkerThread
    public final void zzo(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzab != j;
        this.zzab = j;
    }

    @WorkerThread
    public final void zzp(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzp != j;
        this.zzp = j;
    }

    @WorkerThread
    public final void zza(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzh != j;
        this.zzh = j;
    }

    @WorkerThread
    public final void zze(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzn != j;
        this.zzn = j;
    }

    @WorkerThread
    public final void zzf(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzu != j;
        this.zzu = j;
    }

    @WorkerThread
    public final void zzg(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.zza.zzp().zzc();
        boolean z2 = this.zzae;
        if (this.zzg == j) {
            z = false;
        }
        this.zzae = z | z2;
        this.zzg = j;
    }

    @WorkerThread
    public final void zzh(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzaf != j;
        this.zzaf = j;
    }

    @WorkerThread
    public final void zzi(String str) {
        this.zza.zzp().zzc();
        this.zzae |= !zzkv.zzc(this.zzad, str);
        this.zzad = str;
    }

    @WorkerThread
    public final void zzb(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzi != j;
        this.zzi = j;
    }

    @WorkerThread
    public final void zzc(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzk != j;
        this.zzk = j;
    }

    @WorkerThread
    public final void zzd(long j) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzm != j;
        this.zzm = j;
    }

    @WorkerThread
    public final void zza(boolean z) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzo != z;
        this.zzo = z;
    }

    @WorkerThread
    public final void zzb(boolean z) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzq != z;
        this.zzq = z;
    }

    @WorkerThread
    public final void zzc(boolean z) {
        this.zza.zzp().zzc();
        this.zzae |= this.zzr != z;
        this.zzr = z;
    }

    @WorkerThread
    public final void zza(Boolean bool) {
        this.zza.zzp().zzc();
        this.zzae |= !zzkv.zza(this.zzt, bool);
        this.zzt = bool;
    }

    @WorkerThread
    public final void zza(@Nullable List<String> list) {
        this.zza.zzp().zzc();
        if (!zzkv.zza(this.zzv, list)) {
            this.zzae = true;
            this.zzv = list != null ? new ArrayList(list) : null;
        }
    }
}
