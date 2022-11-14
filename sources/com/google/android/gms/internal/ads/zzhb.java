package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzhb extends zzhg {
    public static volatile Long zzi;
    public static final Object zzj = new Object();

    public zzhb(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "cPHMZVY/KwIUfpGqtJoe3sZWjmRLYCJUzedPb6Eusduzq1fr7QzoocP3s4SDqjiP", "Wq/IKBdmFHBPtcQG2uw+enxSoneybsCZd6x3sGCEaqo=", zzcn, i, 33);
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
            this.zze.zzs(zzi.longValue());
        }
    }
}
