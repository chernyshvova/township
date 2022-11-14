package com.helpshift.util;

import android.content.Context;
import com.helpshift.network.connectivity.HSConnectivityManager;

public class ConnectivityUtil {
    public final Context context;
    public final int defaultBatchSize;
    public final int maximumBatchSize;

    /* renamed from: com.helpshift.util.ConnectivityUtil$1 */
    public static /* synthetic */ class C28181 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$network$connectivity$HSConnectivityType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
        static {
            /*
                com.helpshift.network.connectivity.HSConnectivityType[] r0 = com.helpshift.network.connectivity.HSConnectivityType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$network$connectivity$HSConnectivityType = r0
                com.helpshift.network.connectivity.HSConnectivityType r1 = com.helpshift.network.connectivity.HSConnectivityType.WIFI     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$com$helpshift$network$connectivity$HSConnectivityType     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.helpshift.network.connectivity.HSConnectivityType r1 = com.helpshift.network.connectivity.HSConnectivityType.MOBILE_DATA     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r0 = $SwitchMap$com$helpshift$network$connectivity$HSConnectivityType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.network.connectivity.HSConnectivityType r1 = com.helpshift.network.connectivity.HSConnectivityType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                r1 = 0
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.util.ConnectivityUtil.C28181.<clinit>():void");
        }
    }

    public ConnectivityUtil(Context context2, int i, int i2) {
        this.context = context2;
        this.defaultBatchSize = i;
        this.maximumBatchSize = i2;
    }

    public int getBatchSize() {
        int i;
        if (HSConnectivityManager.getInstance(this.context).getConnectivityType().ordinal() != 1) {
            i = this.defaultBatchSize;
        } else {
            i = this.maximumBatchSize;
        }
        return Math.min(i, this.maximumBatchSize);
    }
}
