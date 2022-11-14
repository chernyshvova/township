package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzy {
    public final int zza;
    public final long zzb;

    public zzzy(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzzy zza(zztb zztb, zzakr zzakr) throws IOException {
        ((zzsx) zztb).zzh(zzakr.zzi(), 0, 8, false);
        zzakr.zzh(0);
        return new zzzy(zzakr.zzv(), zzakr.zzu());
    }
}
