package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzezt implements zzgjg<Clock> {
    public final zzezs zza;

    public zzezt(zzezs zzezs) {
        this.zza = zzezs;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Clock instance = DefaultClock.getInstance();
        zzgjp.zzb(instance);
        return instance;
    }
}
