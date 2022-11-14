package com.applovin.mediation.nativeAds;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.NonNull;
import com.applovin.mediation.MaxAdFormat;

public class MaxNativeAd {
    public final String advertiser;
    public final String body;
    public final String callToAction;
    public final MaxAdFormat format;
    public final MaxNativeAdImage icon;
    public final View iconView;
    public final View mediaView;
    public final View optionsView;
    @NonNull
    public final String title;

    public static class Builder {

        /* renamed from: a */
        public MaxAdFormat f2667a;

        /* renamed from: b */
        public String f2668b;

        /* renamed from: c */
        public String f2669c;

        /* renamed from: d */
        public String f2670d;

        /* renamed from: e */
        public String f2671e;

        /* renamed from: f */
        public MaxNativeAdImage f2672f;

        /* renamed from: g */
        public View f2673g;

        /* renamed from: h */
        public View f2674h;

        /* renamed from: i */
        public View f2675i;

        public MaxNativeAd build() {
            return new MaxNativeAd(this);
        }

        public Builder setAdFormat(MaxAdFormat maxAdFormat) {
            this.f2667a = maxAdFormat;
            return this;
        }

        public Builder setAdvertiser(String str) {
            this.f2669c = str;
            return this;
        }

        public Builder setBody(String str) {
            this.f2670d = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.f2671e = str;
            return this;
        }

        public Builder setIcon(MaxNativeAdImage maxNativeAdImage) {
            this.f2672f = maxNativeAdImage;
            return this;
        }

        public Builder setIconView(View view) {
            this.f2673g = view;
            return this;
        }

        public Builder setMediaView(View view) {
            this.f2675i = view;
            return this;
        }

        public Builder setOptionsView(View view) {
            this.f2674h = view;
            return this;
        }

        public Builder setTitle(String str) {
            this.f2668b = str;
            return this;
        }
    }

    public static class MaxNativeAdImage {

        /* renamed from: a */
        public Drawable f2676a;

        /* renamed from: b */
        public Uri f2677b;

        public MaxNativeAdImage(Drawable drawable) {
            this.f2676a = drawable;
        }

        public MaxNativeAdImage(Uri uri) {
            this.f2677b = uri;
        }

        public Drawable getDrawable() {
            return this.f2676a;
        }

        public Uri getUri() {
            return this.f2677b;
        }
    }

    public MaxNativeAd(Builder builder) {
        this.format = builder.f2667a;
        this.title = builder.f2668b;
        this.advertiser = builder.f2669c;
        this.body = builder.f2670d;
        this.callToAction = builder.f2671e;
        this.icon = builder.f2672f;
        this.iconView = builder.f2673g;
        this.optionsView = builder.f2674h;
        this.mediaView = builder.f2675i;
    }

    public final String getAdvertiser() {
        return this.advertiser;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getCallToAction() {
        return this.callToAction;
    }

    public final MaxAdFormat getFormat() {
        return this.format;
    }

    public final MaxNativeAdImage getIcon() {
        return this.icon;
    }

    public final View getIconView() {
        return this.iconView;
    }

    public final View getMediaView() {
        return this.mediaView;
    }

    public final View getOptionsView() {
        return this.optionsView;
    }

    @NonNull
    public final String getTitle() {
        return this.title;
    }

    public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
    }
}
