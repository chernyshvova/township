package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.internal.zzay;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzec implements RemoteCall {
    public static final /* synthetic */ zzec zza = new zzec();

    public final void accept(Object obj, Object obj2) {
        ((TaskCompletionSource) obj2).setResult(((zzay) ((zzas) obj).getService()).zzl());
    }
}
