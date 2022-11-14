package com.facebook;

/* compiled from: AccessTokenSource.kt */
public enum AccessTokenSource {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true),
    INSTAGRAM_APPLICATION_WEB(true),
    INSTAGRAM_CUSTOM_CHROME_TAB(true),
    INSTAGRAM_WEB_VIEW(true);
    
    public final boolean canExtendToken;

    /* compiled from: AccessTokenSource.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[AccessTokenSource.values().length];
            AccessTokenSource accessTokenSource = AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
            iArr[9] = 1;
            AccessTokenSource accessTokenSource2 = AccessTokenSource.INSTAGRAM_CUSTOM_CHROME_TAB;
            iArr[10] = 2;
            AccessTokenSource accessTokenSource3 = AccessTokenSource.INSTAGRAM_WEB_VIEW;
            iArr[11] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: public */
    AccessTokenSource(boolean z) {
        this.canExtendToken = z;
    }

    public final boolean canExtendToken() {
        return this.canExtendToken;
    }

    public final boolean fromInstagram() {
        switch (ordinal()) {
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }
}
