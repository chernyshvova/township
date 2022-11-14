package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0805e;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.aa */
public class C1041aa {

    /* renamed from: a */
    public final C1188m f1359a;

    /* renamed from: b */
    public final C1314v f1360b;

    /* renamed from: c */
    public final View f1361c;

    public C1041aa(View view, C1188m mVar) {
        this.f1359a = mVar;
        this.f1360b = mVar.mo10922B();
        this.f1361c = view;
    }

    /* renamed from: a */
    public long mo10508a(C0805e eVar) {
        long j;
        this.f1360b.mo11372b("ViewabilityTracker", "Checking visibility...");
        if (!this.f1361c.isShown()) {
            this.f1360b.mo11376e("ViewabilityTracker", "View is hidden");
            j = 2;
        } else {
            j = 0;
        }
        if (this.f1361c.getAlpha() < eVar.mo9891F()) {
            this.f1360b.mo11376e("ViewabilityTracker", "View is transparent");
            j |= 4;
        }
        Animation animation = this.f1361c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            this.f1360b.mo11376e("ViewabilityTracker", "View is animating");
            j |= 8;
        }
        if (this.f1361c.getParent() == null) {
            this.f1360b.mo11376e("ViewabilityTracker", "No parent view found");
            j |= 16;
        }
        int pxToDp = AppLovinSdkUtils.pxToDp(this.f1361c.getContext(), this.f1361c.getWidth());
        if (pxToDp < eVar.mo9889D()) {
            C1314v vVar = this.f1360b;
            vVar.mo11376e("ViewabilityTracker", "View has width (" + pxToDp + ") below threshold");
            j |= 32;
        }
        int pxToDp2 = AppLovinSdkUtils.pxToDp(this.f1361c.getContext(), this.f1361c.getHeight());
        if (pxToDp2 < eVar.mo9890E()) {
            C1314v vVar2 = this.f1360b;
            vVar2.mo11376e("ViewabilityTracker", "View has height (" + pxToDp2 + ") below threshold");
            j |= 64;
        }
        Point a = C1263g.m2503a(this.f1361c.getContext());
        Rect rect = new Rect(0, 0, a.x, a.y);
        int[] iArr = {-1, -1};
        this.f1361c.getLocationOnScreen(iArr);
        Rect rect2 = new Rect(iArr[0], iArr[1], this.f1361c.getWidth() + iArr[0], this.f1361c.getHeight() + iArr[1]);
        if (!Rect.intersects(rect, rect2)) {
            C1314v vVar3 = this.f1360b;
            vVar3.mo11376e("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            j |= 128;
        }
        Activity a2 = this.f1359a.mo10967ae().mo10434a();
        if (a2 != null && !Utils.isViewInTopActivity(this.f1361c, a2)) {
            this.f1360b.mo11376e("ViewabilityTracker", "View is not in top activity's view hierarchy");
            j |= 256;
        }
        C1314v vVar4 = this.f1360b;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Returning flags: ");
        outline24.append(Long.toBinaryString(j));
        vVar4.mo11372b("ViewabilityTracker", outline24.toString());
        return j;
    }
}
