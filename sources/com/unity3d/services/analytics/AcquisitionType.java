package com.unity3d.services.analytics;

public enum AcquisitionType {
    SOFT,
    PREMIUM;

    /* renamed from: com.unity3d.services.analytics.AcquisitionType$1 */
    public static /* synthetic */ class C17921 {
        public static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$analytics$AcquisitionType = null;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.unity3d.services.analytics.AcquisitionType[] r0 = com.unity3d.services.analytics.AcquisitionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$unity3d$services$analytics$AcquisitionType = r0
                r1 = 1
                com.unity3d.services.analytics.AcquisitionType r2 = com.unity3d.services.analytics.AcquisitionType.SOFT     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$unity3d$services$analytics$AcquisitionType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.unity3d.services.analytics.AcquisitionType r2 = com.unity3d.services.analytics.AcquisitionType.PREMIUM     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.analytics.AcquisitionType.C17921.<clinit>():void");
        }
    }

    public String toString() {
        int ordinal = ordinal();
        if (ordinal != 0) {
            return ordinal != 1 ? "" : "premium";
        }
        return "soft";
    }
}
