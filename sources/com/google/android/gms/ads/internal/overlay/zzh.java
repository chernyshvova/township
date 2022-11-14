package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzh extends RelativeLayout {
    @VisibleForTesting
    public final zzau zza;
    @VisibleForTesting
    public boolean zzb;

    public zzh(Context context, String str, String str2, String str3) {
        super(context);
        zzau zzau = new zzau(context, str);
        this.zza = zzau;
        zzau.zzd(str2);
        this.zza.zzc(str3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) {
            return false;
        }
        this.zza.zza(motionEvent);
        return false;
    }
}
