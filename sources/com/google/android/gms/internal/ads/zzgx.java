package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgx extends zzhg {
    public final boolean zzi;

    public zzgx(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "zC/fwdDuQM8Ntp2Exq4j6LLE+G4/I91mCFjFlTTx2t2L43JC1sGihEzWo+AiDO3l", "m91XZsk+YhuzWKD4cAkZ4TbV2JwQi634x6I7GtEZSF0=", zzcn, i, 61);
        this.zzi = zzfy.zzk();
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb(), Boolean.valueOf(this.zzi)})).longValue();
        synchronized (this.zze) {
            this.zze.zzR(longValue);
        }
    }
}
