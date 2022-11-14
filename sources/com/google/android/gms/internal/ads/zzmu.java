package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzmu {
    public static final Object zza = new Object();
    public static final zzif<zzmu> zzp = zzmt.zza;
    public static final Object zzq = new Object();
    public static final zzkq zzr;
    public Object zzb = zza;
    public zzkq zzc = zzr;
    public long zzd;
    public long zze;
    public long zzf;
    public boolean zzg;
    public boolean zzh;
    @Deprecated
    public boolean zzi;
    @Nullable
    public zzko zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    public int zzn;
    public int zzo;

    static {
        zzkj zzkj = new zzkj();
        zzkj.zza("com.google.android.exoplayer2.Timeline");
        zzkj.zzb(Uri.EMPTY);
        zzr = zzkj.zzc();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmu.class.equals(obj.getClass())) {
            zzmu zzmu = (zzmu) obj;
            return zzalh.zzc(this.zzb, zzmu.zzb) && zzalh.zzc(this.zzc, zzmu.zzc) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc(this.zzj, zzmu.zzj) && this.zzd == zzmu.zzd && this.zze == zzmu.zze && this.zzf == zzmu.zzf && this.zzg == zzmu.zzg && this.zzh == zzmu.zzh && this.zzk == zzmu.zzk && this.zzm == zzmu.zzm && this.zzn == zzmu.zzn && this.zzo == zzmu.zzo;
        }
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.zzc.hashCode() + ((this.zzb.hashCode() + 217) * 31)) * 961;
        zzko zzko = this.zzj;
        if (zzko == null) {
            i = 0;
        } else {
            i = zzko.hashCode();
        }
        long j = this.zzd;
        long j2 = this.zze;
        long j3 = this.zzf;
        boolean z = this.zzg;
        boolean z2 = this.zzh;
        boolean z3 = this.zzk;
        long j4 = this.zzm;
        return (((((((((((((((((((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + (z3 ? 1 : 0)) * 961) + ((int) ((j4 >>> 32) ^ j4))) * 31) + this.zzn) * 31) + this.zzo) * 31;
    }

    public final zzmu zza(Object obj, @Nullable zzkq zzkq, @Nullable Object obj2, long j, long j2, long j3, boolean z, boolean z2, @Nullable zzko zzko, long j4, long j5, int i, int i2, long j6) {
        zzko zzko2 = zzko;
        this.zzb = obj;
        this.zzc = zzkq != null ? zzkq : zzr;
        this.zzd = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        this.zzf = -9223372036854775807L;
        this.zzg = z;
        this.zzh = z2;
        this.zzi = zzko2 != null;
        this.zzj = zzko2;
        this.zzl = 0;
        this.zzm = j5;
        this.zzn = 0;
        this.zzo = 0;
        this.zzk = false;
        return this;
    }

    public final boolean zzb() {
        zzajg.zzd(this.zzi == (this.zzj != null));
        return this.zzj != null;
    }
}
