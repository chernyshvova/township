package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zab implements DeferredLifecycleHelper.zaa {
    public final /* synthetic */ Bundle zaa;
    public final /* synthetic */ DeferredLifecycleHelper zab;

    public zab(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.zab = deferredLifecycleHelper;
        this.zaa = bundle;
    }

    public final int zaa() {
        return 1;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        this.zab.zaa.onCreate(this.zaa);
    }
}
