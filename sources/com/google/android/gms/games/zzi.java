package com.google.android.gms.games;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.internal.zzba;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class zzi extends Api.AbstractClientBuilder<zzas, zzm> {
    public /* synthetic */ zzi(zzh zzh) {
    }

    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzm zzm = (zzm) obj;
        if (zzm == null) {
            zzm = new zzk((zzj) null).zze();
        }
        zzas zzas = new zzas(context, looper, clientSettings, zzm, connectionCallbacks, onConnectionFailedListener, zzba.zza());
        if (zzm.zzo.zzc()) {
            zzas.zzW(zzg.zzc(context));
        }
        return zzas;
    }

    public final int getPriority() {
        return 1;
    }
}
