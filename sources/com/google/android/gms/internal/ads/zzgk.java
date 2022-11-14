package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgk extends zzhg {
    public zzgk(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "TiB8Pl2o8LKtvrRgwN2UZPBx2FfVwXaA2LJIyoIsON4gk8JWSfnQXytrQilOHtcO", "aBYwH2ThFYuy1U18GzcFTBDhpF5mRbr30vOPELmr1Hc=", zzcn, i, 5);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzd(-1);
        this.zze.zze(-1);
        int[] iArr = (int[]) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()});
        synchronized (this.zze) {
            this.zze.zzd((long) iArr[0]);
            this.zze.zze((long) iArr[1]);
            int i = iArr[2];
            if (i != Integer.MIN_VALUE) {
                this.zze.zzP((long) i);
            }
        }
    }
}
