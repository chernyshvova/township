package com.applovin.impl.adview.activity.p008a;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.C0767m;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1057e;

/* renamed from: com.applovin.impl.adview.activity.a.b */
public class C0663b extends C0662a {
    public C0663b(C1057e eVar, Activity activity, C1188m mVar) {
        super(eVar, activity, mVar);
    }

    /* renamed from: a */
    public void mo9439a(C0767m mVar, AppLovinAdView appLovinAdView, @Nullable ViewGroup viewGroup) {
        this.f208d.addView(appLovinAdView);
        if (mVar != null) {
            mo9438a(this.f207c.mo10573S(), (this.f207c.mo10577W() ? 3 : 5) | 48, mVar);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.f208d);
        } else {
            this.f206b.setContentView(this.f208d);
        }
    }
}
