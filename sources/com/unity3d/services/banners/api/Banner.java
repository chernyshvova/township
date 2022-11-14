package com.unity3d.services.banners.api;

import com.unity3d.services.banners.BannerViewCache;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.banners.properties.BannerRefreshInfo;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

public class Banner {

    /* renamed from: com.unity3d.services.banners.api.Banner$1 */
    public static /* synthetic */ class C18081 {

        /* renamed from: $SwitchMap$com$unity3d$services$banners$api$Banner$BannerViewType */
        public static final /* synthetic */ int[] f2841xf0b64357;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.unity3d.services.banners.api.Banner$BannerViewType[] r0 = com.unity3d.services.banners.api.Banner.BannerViewType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2841xf0b64357 = r0
                r1 = 1
                com.unity3d.services.banners.api.Banner$BannerViewType r2 = com.unity3d.services.banners.api.Banner.BannerViewType.WEB_PLAYER     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f2841xf0b64357     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.unity3d.services.banners.api.Banner$BannerViewType r2 = com.unity3d.services.banners.api.Banner.BannerViewType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.banners.api.Banner.C18081.<clinit>():void");
        }
    }

    public enum BannerViewType {
        WEB_PLAYER,
        UNKNOWN;

        public static BannerViewType fromString(String str) {
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return UNKNOWN;
            }
        }
    }

    @WebViewExposed
    public static void load(String str, Integer num, Integer num2, String str2, WebViewCallback webViewCallback) {
        if (BannerViewType.fromString(str).ordinal() == 0 && BannerViewCache.getInstance().loadWebPlayer(str2, new UnityBannerSize(num.intValue(), num2.intValue()))) {
            BannerBridge.didLoad(str2);
        }
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setRefreshRate(String str, Integer num, WebViewCallback webViewCallback) {
        if (!(str == null || num == null)) {
            BannerRefreshInfo.getInstance().setRefreshRate(str, num);
        }
        webViewCallback.invoke(new Object[0]);
    }
}
