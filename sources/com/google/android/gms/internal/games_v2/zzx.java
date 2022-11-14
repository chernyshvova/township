package com.google.android.gms.internal.games_v2;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzx extends GmsClient<zzae> {
    public final zzq zze;

    public zzx(Context context, Looper looper, ClientSettings clientSettings, zzq zzq, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zze = zzq;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.connect.IGamesConnectService");
        if (queryLocalInterface instanceof zzae) {
            return (zzae) queryLocalInterface;
        }
        return new zzae(iBinder);
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        zzq zzq = this.zze;
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", zzq.zza);
        bundle.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, zzq.zzb);
        return bundle;
    }

    public final int getMinApkVersion() {
        return 213000000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.connect.IGamesConnectService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.games.internal.connect.service.START";
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
