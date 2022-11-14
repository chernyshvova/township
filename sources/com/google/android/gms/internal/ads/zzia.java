package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzia implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ zzic zza;
    public final Handler zzb;

    public zzia(zzic zzic, Handler handler) {
        this.zza = zzic;
        this.zzb = handler;
    }

    public final void onAudioFocusChange(int i) {
        this.zzb.post(new zzhz(this, i));
    }
}
