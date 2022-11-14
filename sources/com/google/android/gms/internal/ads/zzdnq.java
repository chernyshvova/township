package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.swrve.sdk.SwrveImp;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdnq implements ViewTreeObserver.OnScrollChangedListener {
    public final View zza;
    public final zzcmr zzb;
    public final String zzc;
    public final WindowManager.LayoutParams zzd;
    public final int zze;
    public final WindowManager zzf;

    public zzdnq(View view, zzcmr zzcmr, String str, WindowManager.LayoutParams layoutParams, int i, WindowManager windowManager) {
        this.zza = view;
        this.zzb = zzcmr;
        this.zzc = str;
        this.zzd = layoutParams;
        this.zze = i;
        this.zzf = windowManager;
    }

    public final void onScrollChanged() {
        View view = this.zza;
        zzcmr zzcmr = this.zzb;
        String str = this.zzc;
        WindowManager.LayoutParams layoutParams = this.zzd;
        int i = this.zze;
        WindowManager windowManager = this.zzf;
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && zzcmr.zzH().getWindowToken() != null) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str) || SwrveImp.CAMPAIGN_RESPONSE_VERSION.equals(str)) {
                layoutParams.y = rect.bottom - i;
            } else {
                layoutParams.y = rect.top - i;
            }
            windowManager.updateViewLayout(zzcmr.zzH(), layoutParams);
        }
    }
}
