package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdwf implements zzdvt {
    public final long zza;
    public final zzeky zzb;

    public zzdwf(long j, Context context, zzdvy zzdvy, zzcop zzcop, String str) {
        this.zza = j;
        zzewl zzq = zzcop.zzq();
        zzq.zzd(context);
        zzq.zzb(new zzbdp());
        zzq.zzc(str);
        zzeky zza2 = zzq.zza().zza();
        this.zzb = zza2;
        zza2.zzh(new zzdwe(this, zzdvy));
    }

    public final void zza(zzbdk zzbdk) {
        this.zzb.zze(zzbdk);
    }

    public final void zzb() {
        this.zzb.zzQ(ObjectWrapper.wrap(null));
    }

    public final void zzc() {
        this.zzb.zzc();
    }
}
