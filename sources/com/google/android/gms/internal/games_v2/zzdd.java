package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzdd implements RemoteCall {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzdd(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzas) obj).zzV((TaskCompletionSource) obj2, this.zza, this.zzb, (String) null);
    }
}
