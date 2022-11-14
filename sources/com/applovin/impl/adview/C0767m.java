package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.C0752i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.m */
public class C0767m extends FrameLayout {

    /* renamed from: a */
    public C0752i f472a;

    /* renamed from: b */
    public int f473b;

    public C0767m(C0752i.C0753a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        C0752i a = C0752i.m513a(aVar, activity);
        this.f472a = a;
        addView(a);
    }

    /* renamed from: a */
    public void mo9673a(int i, int i2, int i3, int i4) {
        this.f473b = i;
        int i5 = i2 + i + i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i5;
            layoutParams.width = i5;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i5, i5));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i, i4);
        layoutParams2.setMargins(i3, i3, i3, 0);
        this.f472a.setLayoutParams(layoutParams2);
        this.f472a.mo9646a(i);
    }

    /* renamed from: a */
    public void mo9674a(C0752i.C0753a aVar) {
        if (aVar != null && aVar != this.f472a.getStyle()) {
            ViewGroup.LayoutParams layoutParams = this.f472a.getLayoutParams();
            removeView(this.f472a);
            C0752i a = C0752i.m513a(aVar, getContext());
            this.f472a = a;
            addView(a);
            this.f472a.setLayoutParams(layoutParams);
            this.f472a.mo9646a(this.f473b);
        }
    }
}
