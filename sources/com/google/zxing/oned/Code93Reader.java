package com.google.zxing.oned;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.unity3d.services.banners.UnityBannerSize;

public final class Code93Reader extends OneDReader {
    public static final int[] CHARACTER_ENCODINGS;

    static {
        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, UnityBannerSize.BannerSize.IAB_STANDARD_WIDTH, 466, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 366, 374, 430, 294, 474, 470, 306, 350};
        CHARACTER_ENCODINGS = iArr;
        int i = iArr[47];
    }
}
