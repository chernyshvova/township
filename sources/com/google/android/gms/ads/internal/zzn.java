package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzn implements View.OnTouchListener {
    public final /* synthetic */ zzr zza;

    public zzn(zzr zzr) {
        this.zza = zzr;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zza.zzh == null) {
            return false;
        }
        this.zza.zzh.zzd(motionEvent);
        return false;
    }
}
