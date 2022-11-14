package com.google.android.gms.ads.search;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzbhm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzc {
    public final zzbhm zza = new zzbhm();
    public String zzb;

    public final zzc zza(NetworkExtras networkExtras) {
        this.zza.zzb(networkExtras);
        return this;
    }

    public final zzc zzb(Class<? extends MediationAdapter> cls, Bundle bundle) {
        this.zza.zzc(cls, bundle);
        return this;
    }

    public final zzc zzc(Class<? extends CustomEvent> cls, Bundle bundle) {
        this.zza.zzd(cls, bundle);
        return this;
    }

    public final zzc zzd(String str) {
        this.zzb = str;
        return this;
    }
}
