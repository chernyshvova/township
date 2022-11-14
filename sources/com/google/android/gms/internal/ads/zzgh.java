package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgh extends zzhg {
    public zzgh(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "C4ABHXMC4Or135sUJAGmAZL7HooHNZP1UfgRABckcZiPz1ZmVgJdnOYsXpFfGNDm", "g3OSAw6b49bJrXDnrxpVD58FlN62AVv4SO1GAfJ7rnU=", zzcn, i, 49);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzdm zzdm;
        this.zze.zzG(zzdm.ENUM_FAILURE);
        try {
            boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
            zzcn zzcn = this.zze;
            if (booleanValue) {
                zzdm = zzdm.ENUM_TRUE;
            } else {
                zzdm = zzdm.ENUM_FALSE;
            }
            zzcn.zzG(zzdm);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
