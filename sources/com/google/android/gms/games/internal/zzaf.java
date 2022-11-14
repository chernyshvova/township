package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class zzaf<T> extends zza {
    public final ListenerHolder<T> zza;

    public zzaf(ListenerHolder<T> listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callback must not be null");
    }

    public final void zzw(zzm zzm) {
        ListenerHolder<T> listenerHolder = this.zza;
        int i = zzas.zze;
        listenerHolder.notifyListener(new zzp(zzm, (byte[]) null));
    }
}
