package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zag implements DeferredLifecycleHelper.zaa {
    public final /* synthetic */ DeferredLifecycleHelper zaa;

    public zag(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    public final int zaa() {
        return 4;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        this.zaa.zaa.onStart();
    }
}
