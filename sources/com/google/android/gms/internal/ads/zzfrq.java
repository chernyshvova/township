package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfrq {
    public final zzfyx zza;

    public zzfrq(zzfyx zzfyx) {
        this.zza = zzfyx;
    }

    public static zzfrq zzc(String str, byte[] bArr, int i) {
        zzfzy zzfzy;
        zzfyw zze = zzfyx.zze();
        zze.zza(str);
        zze.zzb(zzgcz.zzt(bArr));
        zzfzy zzfzy2 = zzfzy.UNKNOWN_PREFIX;
        int i2 = i - 1;
        if (i2 != 0) {
            zzfzy = i2 != 1 ? zzfzy.RAW : zzfzy.LEGACY;
        } else {
            zzfzy = zzfzy.TINK;
        }
        zze.zzc(zzfzy);
        return new zzfrq((zzfyx) zze.zzah());
    }

    public final String zza() {
        return this.zza.zza();
    }

    public final byte[] zzb() {
        return this.zza.zzc().zzz();
    }

    public final int zzd() {
        zzfzy zzd = this.zza.zzd();
        zzfzy zzfzy = zzfzy.UNKNOWN_PREFIX;
        int ordinal = zzd.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        return 4;
                    }
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
            }
        }
        return i;
    }
}
