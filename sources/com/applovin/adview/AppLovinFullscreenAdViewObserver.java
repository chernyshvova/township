package com.applovin.adview;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.applovin.impl.adview.C0769o;
import com.applovin.impl.adview.activity.p009b.C0670a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1085b;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinFullscreenAdViewObserver implements LifecycleObserver {

    /* renamed from: a */
    public final C1188m f47a;

    /* renamed from: b */
    public final AtomicBoolean f48b = new AtomicBoolean(true);

    /* renamed from: c */
    public C0670a f49c;

    /* renamed from: d */
    public C0769o f50d;

    public AppLovinFullscreenAdViewObserver(Lifecycle lifecycle, C0769o oVar, C1188m mVar) {
        this.f50d = oVar;
        this.f47a = mVar;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        C0769o oVar = this.f50d;
        if (oVar != null) {
            oVar.mo9680e();
            this.f50d = null;
        }
        C0670a aVar = this.f49c;
        if (aVar != null) {
            aVar.mo9466h();
            this.f49c.mo9468j();
            this.f49c = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        C0670a aVar = this.f49c;
        if (aVar != null) {
            aVar.mo9465g();
            this.f49c.mo9463e();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        C0670a aVar;
        if (!this.f48b.getAndSet(false) && (aVar = this.f49c) != null) {
            aVar.mo9464f();
            this.f49c.mo9449a(((Boolean) this.f47a.mo10946a(C1085b.f1769eR)).booleanValue() ? 0 : 250);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        C0670a aVar = this.f49c;
        if (aVar != null) {
            aVar.mo9467i();
        }
    }

    public void setPresenter(C0670a aVar) {
        this.f49c = aVar;
    }
}
