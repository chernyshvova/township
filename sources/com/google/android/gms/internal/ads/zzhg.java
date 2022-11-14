package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzhg implements Callable {
    public final String zza = getClass().getSimpleName();
    public final zzfy zzb;
    public final String zzc;
    public final String zzd;
    public final zzcn zze;
    public Method zzf;
    public final int zzg;
    public final int zzh;

    public zzhg(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        this.zzb = zzfy;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzcn;
        this.zzg = i;
        this.zzh = i2;
    }

    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzk();
        return null;
    }

    public abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzk() throws Exception {
        int i;
        try {
            long nanoTime = System.nanoTime();
            Method zzp = this.zzb.zzp(this.zzc, this.zzd);
            this.zzf = zzp;
            if (zzp == null) {
                return null;
            }
            zza();
            zzew zzi = this.zzb.zzi();
            if (!(zzi == null || (i = this.zzg) == Integer.MIN_VALUE)) {
                zzi.zza(this.zzh, i, (System.nanoTime() - nanoTime) / 1000, (String) null, (Exception) null);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
