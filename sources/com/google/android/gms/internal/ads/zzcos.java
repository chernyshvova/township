package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcos {
    public final zzcgy zza;
    public final Context zzb;
    public final WeakReference<Context> zzc;

    public /* synthetic */ zzcos(zzcor zzcor, zzcoq zzcoq) {
        this.zza = zzcor.zza;
        this.zzb = zzcor.zzb;
        this.zzc = zzcor.zzc;
    }

    public final Context zza() {
        return this.zzb;
    }

    public final WeakReference<Context> zzb() {
        return this.zzc;
    }

    public final zzcgy zzc() {
        return this.zza;
    }

    public final String zzd() {
        return zzs.zzc().zze(this.zzb, this.zza.zza);
    }

    public final zzfb zze() {
        return new zzfb(new zzi(this.zzb, this.zza));
    }
}
