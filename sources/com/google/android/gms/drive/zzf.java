package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.internal.drive.zzaw;

public final class zzf extends Api.AbstractClientBuilder<zzaw, Drive.zzb> {
    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (((Drive.zzb) obj) == null) {
            return new zzaw(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener, new Bundle());
        }
        throw new NoSuchMethodError();
    }
}
