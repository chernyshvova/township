package com.applovin.impl.mediation.debugger.p017ui.p018a;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1368R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.d */
public class C0906d extends Dialog {

    /* renamed from: a */
    public ViewGroup f940a;

    /* renamed from: b */
    public AppLovinSdkUtils.Size f941b;

    /* renamed from: c */
    public Activity f942c;

    /* renamed from: d */
    public RelativeLayout f943d;

    public C0906d(ViewGroup viewGroup, AppLovinSdkUtils.Size size, Activity activity) {
        super(activity, 16973840);
        this.f940a = viewGroup;
        this.f941b = size;
        this.f942c = activity;
        requestWindowFeature(1);
    }

    public void dismiss() {
        this.f943d.removeView(this.f940a);
        super.dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this.f942c, this.f941b.getWidth()), AppLovinSdkUtils.dpToPx(this.f942c, this.f941b.getHeight()));
        layoutParams.addRule(13);
        this.f940a.setLayoutParams(layoutParams);
        int dpToPx = AppLovinSdkUtils.dpToPx(this.f942c, 60);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        ImageButton imageButton = new ImageButton(this.f942c);
        imageButton.setLayoutParams(layoutParams2);
        imageButton.setImageDrawable(this.f942c.getResources().getDrawable(C1368R.C1369drawable.applovin_ic_x_mark));
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setColorFilter(-1);
        imageButton.setBackground((Drawable) null);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0906d.this.dismiss();
            }
        });
        RelativeLayout relativeLayout = new RelativeLayout(this.f942c);
        this.f943d = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f943d.setBackgroundColor(Integer.MIN_VALUE);
        this.f943d.addView(imageButton);
        this.f943d.addView(this.f940a);
        this.f943d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0906d.this.dismiss();
            }
        });
        setContentView(this.f943d);
    }
}
