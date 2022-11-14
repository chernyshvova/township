package com.google.android.gms.internal.games_v2;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzu extends Api.AbstractClientBuilder<zzx, zzq> {
    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzx(context, looper, clientSettings, (zzq) obj, connectionCallbacks, onConnectionFailedListener);
    }
}
