package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class zzap<T> extends zza {
    public final BaseImplementation.ResultHolder<T> zza;

    public zzap(BaseImplementation.ResultHolder<T> resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder, "Holder must not be null");
    }

    public final void zzw(T t) {
        this.zza.setResult(t);
    }
}
