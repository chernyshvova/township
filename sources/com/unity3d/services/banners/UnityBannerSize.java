package com.unity3d.services.banners;

import android.content.Context;
import android.content.res.Resources;
import com.unity3d.services.core.misc.ViewUtilities;

public class UnityBannerSize {
    public int height;
    public int width;

    /* renamed from: com.unity3d.services.banners.UnityBannerSize$1 */
    public static /* synthetic */ class C18011 {

        /* renamed from: $SwitchMap$com$unity3d$services$banners$UnityBannerSize$BannerSize */
        public static final /* synthetic */ int[] f2840xd7cd7171;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.unity3d.services.banners.UnityBannerSize$BannerSize[] r0 = com.unity3d.services.banners.UnityBannerSize.BannerSize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2840xd7cd7171 = r0
                r1 = 1
                com.unity3d.services.banners.UnityBannerSize$BannerSize r2 = com.unity3d.services.banners.UnityBannerSize.BannerSize.BANNER_SIZE_STANDARD     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f2840xd7cd7171     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.unity3d.services.banners.UnityBannerSize$BannerSize r3 = com.unity3d.services.banners.UnityBannerSize.BannerSize.BANNER_SIZE_LEADERBOARD     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f2840xd7cd7171     // Catch:{ NoSuchFieldError -> 0x001d }
                com.unity3d.services.banners.UnityBannerSize$BannerSize r2 = com.unity3d.services.banners.UnityBannerSize.BannerSize.BANNER_SIZE_IAB_STANDARD     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.banners.UnityBannerSize.C18011.<clinit>():void");
        }
    }

    public enum BannerSize {
        BANNER_SIZE_STANDARD,
        BANNER_SIZE_LEADERBOARD,
        BANNER_SIZE_IAB_STANDARD,
        BANNER_SIZE_DYNAMIC;
        
        public static final int IAB_STANDARD_HEIGHT = 60;
        public static final int IAB_STANDARD_WIDTH = 468;
        public static final int LEADERBOARD_HEIGHT = 90;
        public static final int LEADERBOARD_WIDTH = 728;
        public static final int STANDARD_HEIGHT = 50;
        public static final int STANDARD_WIDTH = 320;

        /* access modifiers changed from: private */
        public int getHeight(Context context) {
            int ordinal = getNonDynamicSize(context).ordinal();
            if (ordinal != 1) {
                return ordinal != 2 ? 50 : 60;
            }
            return 90;
        }

        private BannerSize getNonDynamicSize(Context context) {
            if (this != BANNER_SIZE_DYNAMIC) {
                return this;
            }
            int round = Math.round(ViewUtilities.dpFromPx(context, (float) Resources.getSystem().getDisplayMetrics().widthPixels));
            if (round >= 728) {
                return BANNER_SIZE_LEADERBOARD;
            }
            if (round >= 468) {
                return BANNER_SIZE_IAB_STANDARD;
            }
            return BANNER_SIZE_STANDARD;
        }

        /* access modifiers changed from: private */
        public int getWidth(Context context) {
            int ordinal = getNonDynamicSize(context).ordinal();
            if (ordinal != 1) {
                return ordinal != 2 ? STANDARD_WIDTH : IAB_STANDARD_WIDTH;
            }
            return LEADERBOARD_WIDTH;
        }
    }

    public UnityBannerSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public static UnityBannerSize getDynamicSize(Context context) {
        return new UnityBannerSize(BannerSize.BANNER_SIZE_DYNAMIC.getWidth(context), BannerSize.BANNER_SIZE_DYNAMIC.getHeight(context));
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
