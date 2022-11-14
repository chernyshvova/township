package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzfd implements RemoteCall {
    public final /* synthetic */ ListenerHolder zza;

    public /* synthetic */ zzfd(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzas) obj).zzP(this.zza);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
