package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzw extends zzv {
    public final boolean zzg(View view) {
        return view.isAttachedToWindow();
    }

    public final ViewGroup.LayoutParams zzj() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
