package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzbw implements RemoteCall {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzbw(String str) {
        this.zza = str;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzas) obj).zzX((TaskCompletionSource) obj2, this.zza);
    }
}