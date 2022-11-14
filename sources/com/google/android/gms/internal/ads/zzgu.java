package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgu extends zzhg {
    public zzgu(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "4GWYMakWxK9XLQ6iDAU2C2VTll8aRULhAGrQnxilr2Nj0cSsO+IgSBJ8ViB0NlP9", "taliwg2sD442czfWRrq8VGyNA1t1bXjQxpcCvWnfA/c=", zzcn, i, 3);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        boolean booleanValue = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbJ)).booleanValue();
        zzff zzff = new zzff((String) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb(), Boolean.valueOf(booleanValue)}));
        synchronized (this.zze) {
            this.zze.zzc(zzff.zza);
            this.zze.zzQ(zzff.zzb);
        }
    }
}
