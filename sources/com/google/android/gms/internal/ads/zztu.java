package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zztu implements zztv {
    public final long zza;
    public final zztt zzb;

    public zztu(long j, long j2) {
        zztw zztw;
        this.zza = j;
        if (j2 == 0) {
            zztw = zztw.zza;
        } else {
            zztw = new zztw(0, j2);
        }
        this.zzb = new zztt(zztw, zztw);
    }

    public final boolean zza() {
        return false;
    }

    public final zztt zzb(long j) {
        return this.zzb;
    }

    public final long zzc() {
        return this.zza;
    }
}
