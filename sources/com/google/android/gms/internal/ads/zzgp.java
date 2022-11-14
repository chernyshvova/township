package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgp extends zzhg {
    public static volatile Long zzi;
    public static final Object zzj = new Object();

    public zzgp(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "2dswfnJ/W5wvAmGjTx8kzB+odO16I5BX/UKh5zlazknHfACvhbFP+Zqb0TpxIZsQ", "ejLzeiJ5qubwImg6nJzCiB7UFg2tGEG87mpwCGv3DVQ=", zzcn, i, 22);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (Long) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzm(zzi.longValue());
        }
    }
}
