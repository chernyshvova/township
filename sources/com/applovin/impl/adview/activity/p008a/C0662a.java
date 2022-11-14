package com.applovin.impl.adview.activity.p008a;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.C0767m;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1057e;

/* renamed from: com.applovin.impl.adview.activity.a.a */
public abstract class C0662a {

    /* renamed from: a */
    public final C1188m f205a;

    /* renamed from: b */
    public final Activity f206b;

    /* renamed from: c */
    public final C1057e f207c;

    /* renamed from: d */
    public final ViewGroup f208d;

    /* renamed from: e */
    public final FrameLayout.LayoutParams f209e = new FrameLayout.LayoutParams(-1, -1, 17);

    public C0662a(C1057e eVar, Activity activity, C1188m mVar) {
        this.f207c = eVar;
        this.f205a = mVar;
        this.f206b = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f208d = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f208d.setLayoutParams(this.f209e);
    }

    /* renamed from: a */
    public void mo9438a(C1057e.C1061c cVar, int i, C0767m mVar) {
        mVar.mo9673a(cVar.f1431a, cVar.f1435e, cVar.f1434d, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mVar.getLayoutParams());
        int i2 = cVar.f1433c;
        layoutParams.setMargins(i2, cVar.f1432b, i2, 0);
        layoutParams.gravity = i;
        this.f208d.addView(mVar, layoutParams);
    }
}
