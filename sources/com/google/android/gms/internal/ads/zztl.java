package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zztl implements zztv {
    public final zztn zza;
    public final long zzb;

    public zztl(zztn zztn, long j) {
        this.zza = zztn;
        this.zzb = j;
    }

    private final zztw zzd(long j, long j2) {
        return new zztw((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    public final boolean zza() {
        return true;
    }

    public final zztt zzb(long j) {
        long j2;
        zzajg.zze(this.zza.zzk);
        zztn zztn = this.zza;
        zztm zztm = zztn.zzk;
        long[] jArr = zztm.zza;
        long[] jArr2 = zztm.zzb;
        int zzD = zzalh.zzD(jArr, zztn.zzb(j), true, false);
        long j3 = 0;
        if (zzD == -1) {
            j2 = 0;
        } else {
            j2 = jArr[zzD];
        }
        if (zzD != -1) {
            j3 = jArr2[zzD];
        }
        zztw zzd = zzd(j2, j3);
        if (zzd.zzb == j || zzD == jArr.length - 1) {
            return new zztt(zzd, zzd);
        }
        int i = zzD + 1;
        return new zztt(zzd, zzd(jArr[i], jArr2[i]));
    }

    public final long zzc() {
        return this.zza.zza();
    }
}
