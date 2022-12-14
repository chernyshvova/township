package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zae implements DeferredLifecycleHelper.zaa {
    public final /* synthetic */ FrameLayout zaa;
    public final /* synthetic */ LayoutInflater zab;
    public final /* synthetic */ ViewGroup zac;
    public final /* synthetic */ Bundle zad;
    public final /* synthetic */ DeferredLifecycleHelper zae;

    public zae(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.zae = deferredLifecycleHelper;
        this.zaa = frameLayout;
        this.zab = layoutInflater;
        this.zac = viewGroup;
        this.zad = bundle;
    }

    public final int zaa() {
        return 2;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        this.zaa.removeAllViews();
        this.zaa.addView(this.zae.zaa.onCreateView(this.zab, this.zac, this.zad));
    }
}
