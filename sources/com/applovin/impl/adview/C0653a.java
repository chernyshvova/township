package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.a */
public class C0653a extends RelativeLayout {

    /* renamed from: a */
    public final ProgressBar f184a;

    public C0653a(Context context, int i, int i2) {
        super(context);
        RelativeLayout.LayoutParams layoutParams;
        setClickable(false);
        ProgressBar progressBar = new ProgressBar(context, (AttributeSet) null, i2);
        this.f184a = progressBar;
        progressBar.setIndeterminate(true);
        this.f184a.setClickable(false);
        if (i == -2 || i == -1) {
            layoutParams = new RelativeLayout.LayoutParams(i, i);
        } else {
            int dpToPx = AppLovinSdkUtils.dpToPx(context, i);
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        }
        layoutParams.addRule(13);
        this.f184a.setLayoutParams(layoutParams);
        addView(this.f184a);
    }

    /* renamed from: a */
    public void mo9422a() {
        setVisibility(0);
    }

    /* renamed from: b */
    public void mo9423b() {
        setVisibility(8);
    }

    public void setColor(int i) {
        this.f184a.getIndeterminateDrawable().setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }
}
