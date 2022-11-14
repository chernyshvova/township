package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdry implements View.OnTouchListener {
    public final zzdse zza;

    public zzdry(zzdse zzdse) {
        this.zza = zzdse;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zzc(view, motionEvent);
        return false;
    }
}
