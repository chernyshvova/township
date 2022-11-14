package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbty {
    public final Object zza = new Object();
    public final Object zzb = new Object();
    @GuardedBy("lockClient")
    public zzbuh zzc;
    @GuardedBy("lockService")
    public zzbuh zzd;

    public static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzbuh zza(Context context, zzcgy zzcgy) {
        zzbuh zzbuh;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbuh(zzc(context), zzcgy, zzbli.zzb.zze());
            }
            zzbuh = this.zzd;
        }
        return zzbuh;
    }

    public final zzbuh zzb(Context context, zzcgy zzcgy) {
        zzbuh zzbuh;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbuh(zzc(context), zzcgy, (String) zzbex.zzc().zzb(zzbjn.zza));
            }
            zzbuh = this.zzc;
        }
        return zzbuh;
    }
}
