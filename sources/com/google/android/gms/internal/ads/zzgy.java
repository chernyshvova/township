package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgy extends zzhg {
    public final StackTraceElement[] zzi;

    public zzgy(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzfy, "vuf0ICTkN+8t3/Roe9XcG+iOkkRVIongIbQ07rmD3KnIXUvNCzewBpWyZLB3p3/7", "wNtnu9iz9FxlWQ/xUwtzm8lbyA6loylNTisLT38FjBA=", zzcn, i, 45);
        this.zzi = stackTraceElementArr;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzdm zzdm;
        Object obj = this.zzi;
        if (obj != null) {
            zzfq zzfq = new zzfq((String) this.zzf.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zze) {
                this.zze.zzC(zzfq.zza.longValue());
                if (zzfq.zzb.booleanValue()) {
                    zzcn zzcn = this.zze;
                    if (zzfq.zzc.booleanValue()) {
                        zzdm = zzdm.ENUM_FALSE;
                    } else {
                        zzdm = zzdm.ENUM_TRUE;
                    }
                    zzcn.zzK(zzdm);
                } else {
                    this.zze.zzK(zzdm.ENUM_FAILURE);
                }
            }
        }
    }
}
