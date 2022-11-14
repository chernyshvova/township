package com.google.android.gms.games.internal;

import com.google.android.gms.games.VideosClient;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzp extends zzah {
    public final /* synthetic */ zzm zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzp(zzm zzm, byte[] bArr) {
        super((zzag) null);
        this.zza = zzm;
    }

    public final void notifyListener(Object obj) {
        ((VideosClient.OnCaptureOverlayStateListener) obj).onCaptureOverlayStateChanged(this.zza.zza);
    }
}
