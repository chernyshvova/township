package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.internal.zzay;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzeu implements RemoteCall {
    public static final /* synthetic */ zzeu zza = new zzeu();

    public final void accept(Object obj, Object obj2) {
        ((TaskCompletionSource) obj2).setResult(Integer.valueOf(((zzay) ((zzas) obj).getService()).zzd()));
    }
}
