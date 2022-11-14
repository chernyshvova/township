package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwh extends zzbvp {
    public final MediationInterscrollerAd zza;

    public zzbwh(MediationInterscrollerAd mediationInterscrollerAd) {
        this.zza = mediationInterscrollerAd;
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    public final boolean zzf() {
        return this.zza.shouldDelegateInterscrollerEffect();
    }
}
