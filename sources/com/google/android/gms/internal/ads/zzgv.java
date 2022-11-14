package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgv extends zzhg {
    public zzgv(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "VkS+X+TtwRpHm8NnTYcac+8VmOK3ly2dr/dAyJrO24Sc1GEe26lkfA2Nk61lr0mw", "iqnfwKKqiNqrk8VWEttLTKe7o3UJQGSCfPqGJpMmsBc=", zzcn, i, 73);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            this.zze.zzV(((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue() ? zzdm.ENUM_TRUE : zzdm.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.zze.zzV(zzdm.ENUM_FAILURE);
        }
    }
}
