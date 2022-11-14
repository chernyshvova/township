package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.games.VideosClient;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzfl implements zzaq {
    public final /* synthetic */ VideosClient.OnCaptureOverlayStateListener zza;

    public /* synthetic */ zzfl(VideosClient.OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        this.zza = onCaptureOverlayStateListener;
    }

    public final Task zza(GoogleApi googleApi) {
        return googleApi.doUnregisterEventListener(ListenerHolders.createListenerKey(this.zza, VideosClient.OnCaptureOverlayStateListener.class.getSimpleName()), 6736);
    }
}
