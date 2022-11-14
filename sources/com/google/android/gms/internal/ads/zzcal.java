package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcal {
    @Nonnull
    public View zza;
    public final Map<String, WeakReference<View>> zzb = new HashMap();

    public final zzcal zza(View view) {
        this.zza = view;
        return this;
    }

    public final zzcal zzb(Map<String, View> map) {
        this.zzb.clear();
        for (Map.Entry next : map.entrySet()) {
            View view = (View) next.getValue();
            if (view != null) {
                this.zzb.put((String) next.getKey(), new WeakReference(view));
            }
        }
        return this;
    }
}
