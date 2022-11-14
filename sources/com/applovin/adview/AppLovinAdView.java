package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.adview.C0725b;
import com.applovin.impl.sdk.C1314v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinAdView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";

    /* renamed from: a */
    public C0725b f40a;

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m40a((AppLovinAdSize) null, (String) null, (AppLovinSdk) null, context, attributeSet);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m40a(appLovinAdSize, str, (AppLovinSdk) null, context, (AttributeSet) null);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinSdk, appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m40a(appLovinAdSize, str, appLovinSdk, context, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m39a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, displayMetrics.widthPixels, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
    }

    /* renamed from: a */
    private void m40a(AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            C0725b bVar = new C0725b();
            this.f40a = bVar;
            bVar.mo9567a(this, context, appLovinAdSize, str, appLovinSdk, attributeSet);
            return;
        }
        m39a(attributeSet, context);
    }

    public void destroy() {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9583f();
        }
    }

    public C0725b getController() {
        return this.f40a;
    }

    public AppLovinAdSize getSize() {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            return bVar.mo9578b();
        }
        return null;
    }

    public String getZoneId() {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            return bVar.mo9580c();
        }
        return null;
    }

    public void loadNextAd() {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9563a();
        } else {
            C1314v.m2661g(AppLovinSdk.TAG, "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9586i();
        }
    }

    public void onDetachedFromWindow() {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9587j();
        }
        super.onDetachedFromWindow();
    }

    public void pause() {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9581d();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9572a(appLovinAd);
        }
    }

    public void resume() {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9582e();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9574a(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9575a(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9576a(appLovinAdLoadListener);
        }
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        C0725b bVar = this.f40a;
        if (bVar != null) {
            bVar.mo9568a(appLovinAdViewEventListener);
        }
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinAdView{zoneId='");
        outline24.append(getZoneId());
        outline24.append("\", size=");
        outline24.append(getSize());
        outline24.append('}');
        return outline24.toString();
    }
}
