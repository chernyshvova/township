package com.applovin.impl.adview.activity.p008a;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.C0653a;
import com.applovin.impl.adview.C0767m;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.activity.a.d */
public class C0668d extends C0662a {
    public C0668d(C1057e eVar, Activity activity, C1188m mVar) {
        super(eVar, activity, mVar);
    }

    /* renamed from: a */
    public void mo9445a(ImageView imageView, C0767m mVar, C0767m mVar2, C0653a aVar, AppLovinAdView appLovinAdView, @Nullable ViewGroup viewGroup) {
        this.f208d.addView(appLovinAdView);
        int i = 3;
        if (mVar != null) {
            mo9438a(this.f207c.mo10573S(), (this.f207c.mo10578X() ? 3 : 5) | 48, mVar);
        }
        if (mVar2 != null) {
            if (!this.f207c.mo10577W()) {
                i = 5;
            }
            mo9438a(this.f207c.mo10573S(), i | 48, mVar2);
        }
        if (imageView != null) {
            int dpToPx = AppLovinSdkUtils.dpToPx(this.f206b, ((Integer) this.f205a.mo10946a(C1085b.f1648cA)).intValue());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, ((Integer) this.f205a.mo10946a(C1085b.f1650cC)).intValue());
            int dpToPx2 = AppLovinSdkUtils.dpToPx(this.f206b, ((Integer) this.f205a.mo10946a(C1085b.f1649cB)).intValue());
            layoutParams.setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
            this.f208d.addView(imageView, layoutParams);
        }
        if (aVar != null) {
            this.f208d.addView(aVar, this.f209e);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.f208d);
        } else {
            this.f206b.setContentView(this.f208d);
        }
    }
}
