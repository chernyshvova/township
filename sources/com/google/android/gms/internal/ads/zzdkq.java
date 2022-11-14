package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdkq implements zzgjg<Set<String>> {
    public final zzgju<zzdml> zza;

    public zzdkq(zzgju<zzdml> zzgju) {
        this.zza = zzgju;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        if (((zzdkn) this.zza).zza().zzd() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        zzgjp.zzb(set);
        return set;
    }
}
