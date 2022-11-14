package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.VideosClient;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzfk implements zzaq {
    public final /* synthetic */ VideosClient.OnCaptureOverlayStateListener zza;

    public /* synthetic */ zzfk(VideosClient.OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        this.zza = onCaptureOverlayStateListener;
    }

    public final Task zza(GoogleApi googleApi) {
        ListenerHolder registerListener = googleApi.registerListener(this.zza, VideosClient.OnCaptureOverlayStateListener.class.getSimpleName());
        Preconditions.checkNotNull(registerListener.getListenerKey(), "Key must not be null");
        zzfd zzfd = new zzfd(registerListener);
        return googleApi.doRegisterEventListener(RegistrationMethods.builder().register(zzfd).unregister(zzfi.zza).withHolder(registerListener).setMethodKey(6735).build());
    }
}
