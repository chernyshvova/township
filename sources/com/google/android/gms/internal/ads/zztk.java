package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zztk {
    @Nullable
    public static zzabe zza(zztb zztb, boolean z) throws IOException {
        zzabe zza = new zztq().zza(zztb, z ? null : zzacf.zza);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }

    public static zztm zzb(zzakr zzakr) {
        zzakr.zzk(1);
        int zzr = zzakr.zzr();
        long zzg = ((long) zzakr.zzg()) + ((long) zzr);
        int i = zzr / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long zzx = zzakr.zzx();
            if (zzx == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = zzx;
            jArr2[i2] = zzakr.zzx();
            zzakr.zzk(2);
            i2++;
        }
        zzakr.zzk((int) (zzg - ((long) zzakr.zzg())));
        return new zztm(jArr, jArr2);
    }
}
