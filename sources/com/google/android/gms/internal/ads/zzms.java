package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzms {
    public static final zzif<zzms> zzg = zzmr.zza;
    @Nullable
    public Object zza;
    @Nullable
    public Object zzb;
    public int zzc;
    public long zzd;
    public long zze;
    public boolean zzf;
    public zzafy zzh = zzafy.zza;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzms.class.equals(obj.getClass())) {
            zzms zzms = (zzms) obj;
            return zzalh.zzc(this.zza, zzms.zza) && zzalh.zzc(this.zzb, zzms.zzb) && this.zzc == zzms.zzc && this.zzd == zzms.zzd && this.zzf == zzms.zzf && zzalh.zzc(this.zzh, zzms.zzh);
        }
    }

    public final int hashCode() {
        Object obj = this.zza;
        int i = 0;
        int hashCode = ((obj == null ? 0 : obj.hashCode()) + 217) * 31;
        Object obj2 = this.zzb;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        int i2 = this.zzc;
        long j = this.zzd;
        return this.zzh.hashCode() + ((((((((hashCode + i) * 31) + i2) * 31) + ((int) ((j >>> 32) ^ j))) * 961) + (this.zzf ? 1 : 0)) * 31);
    }

    public final zzms zza(@Nullable Object obj, @Nullable Object obj2, int i, long j, long j2, zzafy zzafy, boolean z) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = 0;
        this.zzd = j;
        this.zze = 0;
        this.zzh = zzafy;
        this.zzf = z;
        return this;
    }

    public final long zzb(int i) {
        return this.zzh.zzc[i];
    }

    public final int zzc(int i) {
        zzafx zzafx = this.zzh.zzd[i];
        throw null;
    }

    public final int zzd(int i, int i2) {
        zzafx zzafx = this.zzh.zzd[i];
        throw null;
    }

    public final int zze(long j) {
        zzafy zzafy = this.zzh;
        long j2 = this.zzd;
        int length = zzafy.zzc.length - 1;
        while (length >= 0 && j != Long.MIN_VALUE) {
            long j3 = zzafy.zzc[length];
            if (j3 != Long.MIN_VALUE) {
                if (j >= j3) {
                    break;
                }
            } else if (j2 != -9223372036854775807L && j >= j2) {
                break;
            }
            length--;
        }
        if (length < 0) {
            return -1;
        }
        zzafx zzafx = zzafy.zzd[length];
        throw null;
    }

    public final int zzf(long j) {
        zzafy zzafy = this.zzh;
        long j2 = this.zzd;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int i = 0;
        if (j2 != -9223372036854775807L && j >= j2) {
            return -1;
        }
        while (true) {
            long[] jArr = zzafy.zzc;
            int length = jArr.length;
            if (i < length) {
                long j3 = jArr[i];
                if (j3 == Long.MIN_VALUE || j3 > j) {
                    zzafx zzafx = zzafy.zzd[i];
                } else {
                    i++;
                }
            } else if (i < length) {
                return i;
            } else {
                return -1;
            }
        }
        zzafx zzafx2 = zzafy.zzd[i];
        throw null;
    }

    public final int zzg(int i) {
        int i2 = this.zzh.zzd[i].zza;
        throw null;
    }

    public final long zzh(int i, int i2) {
        int i3 = this.zzh.zzd[i].zza;
        throw null;
    }

    public final long zzi() {
        long j = this.zzh.zze;
        return 0;
    }

    public final boolean zzj(int i) {
        boolean z = this.zzh.zzd[i].zzf;
        throw null;
    }

    public final long zzk(int i) {
        long j = this.zzh.zzd[i].zze;
        throw null;
    }
}
