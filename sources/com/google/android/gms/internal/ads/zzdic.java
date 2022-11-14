package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdic implements zzgjg<zzdib> {
    public final zzgju<Context> zza;
    public final zzgju<Set<zzdhz<zzavz>>> zzb;
    public final zzgju<zzeye> zzc;

    public zzdic(zzgju<Context> zzgju, zzgju<Set<zzdhz<zzavz>>> zzgju2, zzgju<zzeye> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdib(this.zza.zzb(), ((zzgjs) this.zzb).zzb(), ((zzcxy) this.zzc).zza());
    }
}
