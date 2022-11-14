package com.applovin.mediation.nativeAds;

import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

public class MaxNativeAdViewBinder {
    @IdRes
    public final int advertiserTextViewId;
    @IdRes
    public final int bodyTextViewId;
    @IdRes
    public final int callToActionButtonId;
    @IdRes
    public final int iconContentViewId;
    @IdRes
    public final int iconImageViewId;
    @LayoutRes
    public final int layoutResourceId;
    public final View mainView;
    @IdRes
    public final int mediaContentFrameLayoutId;
    @IdRes
    public final int mediaContentViewGroupId;
    @IdRes
    public final int optionsContentFrameLayoutId;
    @IdRes
    public final int optionsContentViewGroupId;
    public final String templateType;
    @IdRes
    public final int titleTextViewId;

    public static class Builder {

        /* renamed from: a */
        public final View f2695a;
        @LayoutRes

        /* renamed from: b */
        public final int f2696b;
        @IdRes

        /* renamed from: c */
        public int f2697c;
        @IdRes

        /* renamed from: d */
        public int f2698d;
        @IdRes

        /* renamed from: e */
        public int f2699e;
        @IdRes

        /* renamed from: f */
        public int f2700f;
        @IdRes

        /* renamed from: g */
        public int f2701g;
        @IdRes

        /* renamed from: h */
        public int f2702h;
        @IdRes

        /* renamed from: i */
        public int f2703i;
        @IdRes

        /* renamed from: j */
        public int f2704j;
        @IdRes

        /* renamed from: k */
        public int f2705k;
        @IdRes

        /* renamed from: l */
        public int f2706l;

        /* renamed from: m */
        public String f2707m;

        public Builder(@LayoutRes int i) {
            this(i, (View) null);
        }

        public Builder(@LayoutRes int i, View view) {
            this.f2697c = -1;
            this.f2698d = -1;
            this.f2699e = -1;
            this.f2700f = -1;
            this.f2701g = -1;
            this.f2702h = -1;
            this.f2703i = -1;
            this.f2704j = -1;
            this.f2705k = -1;
            this.f2706l = -1;
            this.f2696b = i;
            this.f2695a = view;
        }

        public Builder(View view) {
            this(-1, view);
        }

        public MaxNativeAdViewBinder build() {
            return new MaxNativeAdViewBinder(this.f2695a, this.f2696b, this.f2697c, this.f2698d, this.f2699e, this.f2700f, this.f2701g, this.f2702h, this.f2703i, this.f2704j, this.f2705k, this.f2706l, this.f2707m);
        }

        public Builder setAdvertiserTextViewId(@IdRes int i) {
            this.f2698d = i;
            return this;
        }

        public Builder setBodyTextViewId(@IdRes int i) {
            this.f2699e = i;
            return this;
        }

        public Builder setCallToActionButtonId(@IdRes int i) {
            this.f2706l = i;
            return this;
        }

        @Deprecated
        public Builder setIconContentViewId(@IdRes int i) {
            this.f2701g = i;
            return this;
        }

        public Builder setIconImageViewId(@IdRes int i) {
            this.f2700f = i;
            return this;
        }

        @Deprecated
        public Builder setMediaContentFrameLayoutId(@IdRes int i) {
            this.f2705k = i;
            return this;
        }

        public Builder setMediaContentViewGroupId(@IdRes int i) {
            this.f2704j = i;
            return this;
        }

        @Deprecated
        public Builder setOptionsContentFrameLayoutId(@IdRes int i) {
            this.f2703i = i;
            return this;
        }

        public Builder setOptionsContentViewGroupId(@IdRes int i) {
            this.f2702h = i;
            return this;
        }

        public Builder setTemplateType(String str) {
            this.f2707m = str;
            return this;
        }

        public Builder setTitleTextViewId(@IdRes int i) {
            this.f2697c = i;
            return this;
        }
    }

    public MaxNativeAdViewBinder(View view, @LayoutRes int i, @IdRes int i2, @IdRes int i3, @IdRes int i4, @IdRes int i5, @IdRes int i6, @IdRes int i7, @IdRes int i8, @IdRes int i9, @IdRes int i10, @IdRes int i11, String str) {
        this.mainView = view;
        this.layoutResourceId = i;
        this.titleTextViewId = i2;
        this.advertiserTextViewId = i3;
        this.bodyTextViewId = i4;
        this.iconImageViewId = i5;
        this.iconContentViewId = i6;
        this.optionsContentViewGroupId = i7;
        this.optionsContentFrameLayoutId = i8;
        this.mediaContentViewGroupId = i9;
        this.mediaContentFrameLayoutId = i10;
        this.callToActionButtonId = i11;
        this.templateType = str;
    }
}
