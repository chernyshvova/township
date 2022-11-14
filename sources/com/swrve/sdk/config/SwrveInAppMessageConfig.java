package com.swrve.sdk.config;

import android.graphics.Color;
import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.swrve.sdk.messaging.SwrveClipboardButtonListener;
import com.swrve.sdk.messaging.SwrveCustomButtonListener;
import com.swrve.sdk.messaging.SwrveDismissButtonListener;
import com.swrve.sdk.messaging.SwrveInAppWindowListener;
import com.swrve.sdk.messaging.SwrveInstallButtonListener;
import com.swrve.sdk.messaging.SwrveMessagePersonalizationProvider;

public class SwrveInAppMessageConfig {
    public long autoShowMessagesMaxDelay;
    public int clickColor;
    public SwrveClipboardButtonListener clipboardButtonListener;
    public SwrveCustomButtonListener customButtonListener;
    public int defaultBackgroundColor;
    public SwrveDismissButtonListener dismissButtonListener;
    public int focusColor;
    public boolean hideToolbar;
    public SwrveInstallButtonListener installButtonListener;
    public SwrveMessagePersonalizationProvider personalizationProvider;
    public int personalizedTextBackgroundColor;
    public int personalizedTextForegroundColor;
    public Typeface personalizedTextTypeface;
    public SwrveInAppWindowListener windowListener;

    public static class Builder {
        public long autoShowMessagesMaxDelay = 5000;
        public int clickColor = Color.argb(100, 0, 0, 0);
        public SwrveClipboardButtonListener clipboardButtonListener;
        public SwrveCustomButtonListener customButtonListener;
        public int defaultBackgroundColor = 0;
        public SwrveDismissButtonListener dismissButtonListener;
        public int focusColor = Color.argb(100, 0, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 152);
        public boolean hideToolbar = true;
        public SwrveInstallButtonListener installButtonListener;
        public SwrveMessagePersonalizationProvider personalizationProvider;
        public int personalizedTextBackgroundColor = 0;
        public int personalizedTextForegroundColor = ViewCompat.MEASURED_STATE_MASK;
        public Typeface personalizedTextTypeface = null;
        public SwrveInAppWindowListener windowListener;

        public Builder autoShowMessagesMaxDelay(long j) {
            this.autoShowMessagesMaxDelay = j;
            return this;
        }

        public SwrveInAppMessageConfig build() {
            return new SwrveInAppMessageConfig(this);
        }

        public Builder clickColor(int i) {
            this.clickColor = i;
            return this;
        }

        public Builder clipboardButtonListener(SwrveClipboardButtonListener swrveClipboardButtonListener) {
            this.clipboardButtonListener = swrveClipboardButtonListener;
            return this;
        }

        public Builder customButtonListener(SwrveCustomButtonListener swrveCustomButtonListener) {
            this.customButtonListener = swrveCustomButtonListener;
            return this;
        }

        public Builder defaultBackgroundColor(int i) {
            this.defaultBackgroundColor = i;
            return this;
        }

        public Builder dismissButtonListener(SwrveDismissButtonListener swrveDismissButtonListener) {
            this.dismissButtonListener = swrveDismissButtonListener;
            return this;
        }

        public Builder focusColor(int i) {
            this.focusColor = i;
            return this;
        }

        public Builder hideToolbar(boolean z) {
            this.hideToolbar = z;
            return this;
        }

        public Builder installButtonListener(SwrveInstallButtonListener swrveInstallButtonListener) {
            this.installButtonListener = swrveInstallButtonListener;
            return this;
        }

        public Builder personalizationProvider(SwrveMessagePersonalizationProvider swrveMessagePersonalizationProvider) {
            this.personalizationProvider = swrveMessagePersonalizationProvider;
            return this;
        }

        public Builder personalizedTextBackgroundColor(int i) {
            this.personalizedTextBackgroundColor = i;
            return this;
        }

        public Builder personalizedTextForegroundColor(int i) {
            this.personalizedTextForegroundColor = i;
            return this;
        }

        public Builder personalizedTextTypeface(Typeface typeface) {
            this.personalizedTextTypeface = typeface;
            return this;
        }

        public Builder windowListener(SwrveInAppWindowListener swrveInAppWindowListener) {
            this.windowListener = swrveInAppWindowListener;
            return this;
        }
    }

    public long getAutoShowMessagesMaxDelay() {
        return this.autoShowMessagesMaxDelay;
    }

    public int getClickColor() {
        return this.clickColor;
    }

    public SwrveClipboardButtonListener getClipboardButtonListener() {
        return this.clipboardButtonListener;
    }

    public SwrveCustomButtonListener getCustomButtonListener() {
        return this.customButtonListener;
    }

    public int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    public SwrveDismissButtonListener getDismissButtonListener() {
        return this.dismissButtonListener;
    }

    public int getFocusColor() {
        return this.focusColor;
    }

    public SwrveInstallButtonListener getInstallButtonListener() {
        return this.installButtonListener;
    }

    public SwrveMessagePersonalizationProvider getPersonalizationProvider() {
        return this.personalizationProvider;
    }

    public int getPersonalizedTextBackgroundColor() {
        return this.personalizedTextBackgroundColor;
    }

    public int getPersonalizedTextForegroundColor() {
        return this.personalizedTextForegroundColor;
    }

    public Typeface getPersonalizedTextTypeface() {
        return this.personalizedTextTypeface;
    }

    public SwrveInAppWindowListener getWindowListener() {
        return this.windowListener;
    }

    public boolean isHideToolbar() {
        return this.hideToolbar;
    }

    public SwrveInAppMessageConfig(Builder builder) {
        this.defaultBackgroundColor = builder.defaultBackgroundColor;
        this.focusColor = builder.focusColor;
        this.clickColor = builder.clickColor;
        this.hideToolbar = builder.hideToolbar;
        this.personalizedTextBackgroundColor = builder.personalizedTextBackgroundColor;
        this.personalizedTextForegroundColor = builder.personalizedTextForegroundColor;
        this.personalizedTextTypeface = builder.personalizedTextTypeface;
        this.autoShowMessagesMaxDelay = builder.autoShowMessagesMaxDelay;
        this.installButtonListener = builder.installButtonListener;
        this.customButtonListener = builder.customButtonListener;
        this.dismissButtonListener = builder.dismissButtonListener;
        this.clipboardButtonListener = builder.clipboardButtonListener;
        this.personalizationProvider = builder.personalizationProvider;
        this.windowListener = builder.windowListener;
    }
}
