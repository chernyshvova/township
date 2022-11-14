package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import androidx.annotation.RequiresApi;

@RequiresApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaly implements DisplayManager.DisplayListener {
    public final /* synthetic */ zzama zza;
    public final DisplayManager zzb;

    public zzaly(zzama zzama, DisplayManager displayManager) {
        this.zza = zzama;
        this.zzb = displayManager;
    }

    public final void onDisplayAdded(int i) {
    }

    public final void onDisplayChanged(int i) {
        if (i == 0) {
            this.zza.zzq();
        }
    }

    public final void onDisplayRemoved(int i) {
    }

    public final void zza() {
        this.zzb.registerDisplayListener(this, zzalh.zzh((Handler.Callback) null));
    }

    public final void zzb() {
        this.zzb.unregisterDisplayListener(this);
    }
}
