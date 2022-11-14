package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.sdk.utils.C1257b;
import com.applovin.impl.sdk.utils.C1307p;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;

public class MaxAdView extends RelativeLayout {

    /* renamed from: a */
    public MaxAdViewImpl f2656a;

    /* renamed from: b */
    public View f2657b;

    /* renamed from: c */
    public int f2658c;

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String attributeValue = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "adUnitId");
        String attributeValue2 = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "adFormat");
        MaxAdFormat formatFromString = StringUtils.isValidString(attributeValue2) ? MaxAdFormat.formatFromString(attributeValue2) : C1257b.m2483a(context);
        int attributeIntValue = attributeSet.getAttributeIntValue(TypedArrayUtils.NAMESPACE, NotificationCompat.WearableExtender.KEY_GRAVITY, 49);
        if (attributeValue == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(attributeValue)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (context instanceof Activity) {
            m2698a(attributeValue, formatFromString, attributeIntValue, AppLovinSdk.getInstance(context), context);
        } else {
            throw new IllegalArgumentException("Max ad view context is not an activity");
        }
    }

    public MaxAdView(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, Context context) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Context context) {
        super(context);
        C0836a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", sdk=" + appLovinSdk + ")");
        m2698a(str, maxAdFormat, 49, appLovinSdk, context);
    }

    public MaxAdView(String str, AppLovinSdk appLovinSdk, Context context) {
        this(str, C1257b.m2483a(context), appLovinSdk, context);
    }

    /* renamed from: a */
    private void m2697a(MaxAdFormat maxAdFormat, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int applyDimension = maxAdFormat == MaxAdFormat.MREC ? (int) TypedValue.applyDimension(1, (float) maxAdFormat.getSize().getWidth(), displayMetrics) : displayMetrics.widthPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, applyDimension, (int) TypedValue.applyDimension(1, (float) maxAdFormat.getSize().getHeight(), displayMetrics));
    }

    /* renamed from: a */
    private void m2698a(String str, MaxAdFormat maxAdFormat, int i, AppLovinSdk appLovinSdk, Context context) {
        if (!isInEditMode()) {
            View view = new View(context);
            this.f2657b = view;
            view.setBackgroundColor(0);
            addView(this.f2657b);
            this.f2657b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f2658c = getVisibility();
            this.f2656a = new MaxAdViewImpl(str.trim(), maxAdFormat, this, this.f2657b, appLovinSdk.coreSdk, context);
            setGravity(i);
            if (getBackground() instanceof ColorDrawable) {
                setBackgroundColor(((ColorDrawable) getBackground()).getColor());
            }
            super.setBackgroundColor(0);
            return;
        }
        m2697a(maxAdFormat, context);
    }

    public void destroy() {
        this.f2656a.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.f2656a.getAdFormat();
    }

    public String getAdUnitId() {
        return this.f2656a.getAdUnitId();
    }

    public String getPlacement() {
        return this.f2656a.getPlacement();
    }

    public void loadAd() {
        this.f2656a.loadAd();
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        MaxAdViewImpl maxAdViewImpl = this.f2656a;
        maxAdViewImpl.logApiCall("onWindowVisibilityChanged(visibility=" + i + ")");
        if (this.f2656a != null && C1307p.m2631a(this.f2658c, i)) {
            this.f2656a.onWindowVisibilityChanged(i);
        }
        this.f2658c = i;
    }

    public void setAlpha(float f) {
        MaxAdViewImpl maxAdViewImpl = this.f2656a;
        maxAdViewImpl.logApiCall("setAlpha(alpha=" + f + ")");
        View view = this.f2657b;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    public void setBackgroundColor(int i) {
        MaxAdViewImpl maxAdViewImpl = this.f2656a;
        maxAdViewImpl.logApiCall("setBackgroundColor(color=" + i + ")");
        MaxAdViewImpl maxAdViewImpl2 = this.f2656a;
        if (maxAdViewImpl2 != null) {
            maxAdViewImpl2.setPublisherBackgroundColor(i);
        }
        View view = this.f2657b;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setCustomPostbackData(String str) {
        MaxAdViewImpl maxAdViewImpl = this.f2656a;
        maxAdViewImpl.logApiCall("setCustomPostbackData(value=" + str + ")");
        this.f2656a.setCustomPostbackData(str);
    }

    public void setExtraParameter(String str, String str2) {
        MaxAdViewImpl maxAdViewImpl = this.f2656a;
        maxAdViewImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f2656a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        MaxAdViewImpl maxAdViewImpl = this.f2656a;
        maxAdViewImpl.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.f2656a.setListener(maxAdViewAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxAdViewImpl maxAdViewImpl = this.f2656a;
        maxAdViewImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f2656a.setLocalExtraParameter(str, obj);
    }

    public void setPlacement(String str) {
        this.f2656a.setPlacement(str);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxAdViewImpl maxAdViewImpl = this.f2656a;
        maxAdViewImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f2656a.setRevenueListener(maxAdRevenueListener);
    }

    public void startAutoRefresh() {
        this.f2656a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f2656a.stopAutoRefresh();
    }

    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f2656a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }
}
