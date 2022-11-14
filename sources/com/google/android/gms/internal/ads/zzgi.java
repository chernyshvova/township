package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgi extends zzhg {
    public static final zzhh<String> zzi = new zzhh<>();
    public final Context zzj;

    public zzgi(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2, Context context) {
        super(zzfy, "Ta7q+IK2mYjuCH0of+Vj0vM5Rtwz8hWo89Z4HIfL3B2t8tHFxG0TQ0Yh0ikc7raQ", "BnUGtdO8J5ukLmkm+ZGsWDuDWstQiBaJlb5Kf+8oxak=", zzcn, i, 29);
        this.zzj = context;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzp("E");
        AtomicReference<String> zza = zzi.zza(this.zzj.getPackageName());
        if (zza.get() == null) {
            synchronized (zza) {
                if (zza.get() == null) {
                    zza.set((String) this.zzf.invoke((Object) null, new Object[]{this.zzj}));
                }
            }
        }
        String str = zza.get();
        synchronized (this.zze) {
            this.zze.zzp(zzdx.zza(str.getBytes(), true));
        }
    }
}
