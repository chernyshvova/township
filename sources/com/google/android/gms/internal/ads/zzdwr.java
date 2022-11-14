package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdwr implements Runnable {
    public final zzdww zza;
    public final zzezn zzb;
    public final zzbrq zzc;
    public final List zzd;
    public final String zze;

    public zzdwr(zzdww zzdww, zzezn zzezn, zzbrq zzbrq, List list, String str) {
        this.zza = zzdww;
        this.zzb = zzezn;
        this.zzc = zzbrq;
        this.zzd = list;
        this.zze = str;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
