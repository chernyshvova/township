package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgg extends zzhg {
    public final Activity zzi;
    public final View zzj;

    public zzgg(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2, View view, Activity activity) {
        super(zzfy, "rJ0kz5REr7A9K6ozGPC9p0oxIBL7S4eVwdLIqy6EWt/H1xyroUvdpxSKqrgIZI+n", "8IixZ0CbQtqPEft6f86OLqdXtqxnPQDWPkO7PVnus4g=", zzcn, i, 62);
        this.zzj = view;
        this.zzi = activity;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzj != null) {
            boolean booleanValue = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbG)).booleanValue();
            Object[] objArr = (Object[]) this.zzf.invoke((Object) null, new Object[]{this.zzj, this.zzi, Boolean.valueOf(booleanValue)});
            synchronized (this.zze) {
                this.zze.zzS(((Long) objArr[0]).longValue());
                this.zze.zzT(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zze.zzU((String) objArr[2]);
                }
            }
        }
    }
}
