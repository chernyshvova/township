package com.swrve.sdk;

public enum SwrveFlavour {
    AMAZON,
    CORE,
    FIREBASE,
    HUAWEI;

    /* renamed from: com.swrve.sdk.SwrveFlavour$1 */
    public static /* synthetic */ class C16851 {
        public static final /* synthetic */ int[] $SwitchMap$com$swrve$sdk$SwrveFlavour = null;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.swrve.sdk.SwrveFlavour[] r0 = com.swrve.sdk.SwrveFlavour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$swrve$sdk$SwrveFlavour = r0
                r1 = 1
                com.swrve.sdk.SwrveFlavour r2 = com.swrve.sdk.SwrveFlavour.AMAZON     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$swrve$sdk$SwrveFlavour     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.SwrveFlavour r3 = com.swrve.sdk.SwrveFlavour.CORE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$com$swrve$sdk$SwrveFlavour     // Catch:{ NoSuchFieldError -> 0x001d }
                com.swrve.sdk.SwrveFlavour r3 = com.swrve.sdk.SwrveFlavour.FIREBASE     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$swrve$sdk$SwrveFlavour     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.swrve.sdk.SwrveFlavour r2 = com.swrve.sdk.SwrveFlavour.HUAWEI     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveFlavour.C16851.<clinit>():void");
        }
    }

    public String toString() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return SwrveAppStore.Amazon;
        }
        if (ordinal == 1) {
            return "core";
        }
        if (ordinal == 2) {
            return BuildConfig.FLAVOR;
        }
        if (ordinal == 3) {
            return SwrveAppStore.Huawei;
        }
        throw new IllegalArgumentException();
    }
}
