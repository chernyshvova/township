package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdli implements zzgjg<zzdib> {
    public final zzgju<Context> zza;
    public final zzgju<zzeye> zzb;

    public zzdli(zzgju<Context> zzgju, zzgju<zzeye> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdib(this.zza.zzb(), new HashSet(), ((zzcxy) this.zzb).zza());
    }
}
