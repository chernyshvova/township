package com.vungle.warren;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import com.unity3d.services.banners.UnityBannerSize;

public class AdConfig extends BaseAdConfig {
    public static final int AUTO_ROTATE = 2;
    public static final int IMMEDIATE_BACK = 2;
    public static final int IMMERSIVE = 4;
    public static final int LANDSCAPE = 1;
    public static final int MATCH_VIDEO = 3;
    public static final int PORTRAIT = 0;
    public static final int TRANSITION_ANIMATE = 8;
    @SerializedName("adOrientation")
    @Orientation
    public int adOrientation = 2;
    @SerializedName("ordinal")
    public int ordinal;

    @Keep
    public enum AdSize {
        VUNGLE_MREC("mrec", 300, 250),
        VUNGLE_DEFAULT("default", -1, -1),
        BANNER("banner", UnityBannerSize.BannerSize.STANDARD_WIDTH, 50),
        BANNER_SHORT("banner_short", 300, 50),
        BANNER_LEADERBOARD("banner_leaderboard", UnityBannerSize.BannerSize.LEADERBOARD_WIDTH, 90);
        
        public final int height;
        public final String name;
        public final int width;

        /* access modifiers changed from: public */
        AdSize(String str, int i, int i2) {
            this.width = i;
            this.height = i2;
            this.name = str;
        }

        public static AdSize fromName(String str) {
            for (AdSize adSize : values()) {
                if (adSize.name.equals(str)) {
                    return adSize;
                }
            }
            return VUNGLE_DEFAULT;
        }

        public static boolean isBannerAdSize(@NonNull AdSize adSize) {
            return adSize == BANNER || adSize == BANNER_LEADERBOARD || adSize == BANNER_SHORT || adSize == VUNGLE_MREC;
        }

        public static boolean isDefaultAdSize(@NonNull AdSize adSize) {
            return adSize == VUNGLE_DEFAULT || adSize == VUNGLE_MREC;
        }

        public static boolean isNonMrecBannerAdSize(@NonNull AdSize adSize) {
            return adSize != VUNGLE_MREC && isBannerAdSize(adSize);
        }

        public int getHeight() {
            return this.height;
        }

        public String getName() {
            return this.name;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public @interface Orientation {
    }

    public @interface Settings {
    }

    public AdConfig() {
    }

    @Orientation
    public int getAdOrientation() {
        return this.adOrientation;
    }

    public /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public /* bridge */ /* synthetic */ int getSettings() {
        return super.getSettings();
    }

    public void setAdOrientation(@Orientation int i) {
        this.adOrientation = i;
    }

    public /* bridge */ /* synthetic */ void setAdSize(AdSize adSize) {
        super.setAdSize(adSize);
    }

    public void setBackButtonImmediatelyEnabled(boolean z) {
        if (z) {
            this.settings |= 2;
        } else {
            this.settings &= -3;
        }
    }

    public void setImmersiveMode(boolean z) {
        if (z) {
            this.settings |= 4;
        } else {
            this.settings &= -5;
        }
    }

    public /* bridge */ /* synthetic */ void setMuted(boolean z) {
        super.setMuted(z);
    }

    public void setOrdinal(int i) {
        this.ordinal = i;
    }

    public void setTransitionAnimationEnabled(boolean z) {
        if (z) {
            this.settings |= 8;
        } else {
            this.settings &= -9;
        }
    }

    public AdConfig(AdSize adSize) {
        super(adSize);
    }

    public AdConfig(BaseAdConfig baseAdConfig) {
        super(baseAdConfig);
    }
}
