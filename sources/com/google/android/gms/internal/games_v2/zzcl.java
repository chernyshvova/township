package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzcl implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzcl(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzas) obj).zzQ((TaskCompletionSource) obj2, this.zza, this.zzb);
    }
}
