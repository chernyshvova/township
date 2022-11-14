package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzaa implements View.OnApplyWindowInsetsListener {
    public final zzab zza;
    public final Activity zzb;

    public zzaa(zzab zzab, Activity activity) {
        this.zza = zzab;
        this.zzb = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzab.zzs(this.zzb, view, windowInsets);
    }
}
