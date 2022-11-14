package com.applovin.impl.mediation;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;

public class MaxNetworkResponseInfoImpl implements MaxNetworkResponseInfo {

    /* renamed from: a */
    public final MaxNetworkResponseInfo.AdLoadState f554a;

    /* renamed from: b */
    public final MaxMediatedNetworkInfo f555b;

    /* renamed from: c */
    public final Bundle f556c;

    /* renamed from: d */
    public final long f557d;
    @Nullable

    /* renamed from: e */
    public final MaxError f558e;

    /* renamed from: com.applovin.impl.mediation.MaxNetworkResponseInfoImpl$1 */
    public static /* synthetic */ class C07921 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f559a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.applovin.mediation.MaxNetworkResponseInfo$AdLoadState[] r0 = com.applovin.mediation.MaxNetworkResponseInfo.AdLoadState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f559a = r0
                r1 = 1
                r2 = 2
                com.applovin.mediation.MaxNetworkResponseInfo$AdLoadState r3 = com.applovin.mediation.MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f559a     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.applovin.mediation.MaxNetworkResponseInfo$AdLoadState r3 = com.applovin.mediation.MaxNetworkResponseInfo.AdLoadState.AD_LOADED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.MaxNetworkResponseInfoImpl.C07921.<clinit>():void");
        }
    }

    public MaxNetworkResponseInfoImpl(MaxNetworkResponseInfo.AdLoadState adLoadState, Bundle bundle, MaxMediatedNetworkInfo maxMediatedNetworkInfo, long j, @Nullable MaxError maxError) {
        this.f554a = adLoadState;
        this.f555b = maxMediatedNetworkInfo;
        this.f556c = bundle;
        this.f557d = j;
        this.f558e = maxError;
    }

    public MaxNetworkResponseInfo.AdLoadState getAdLoadState() {
        return this.f554a;
    }

    public Bundle getCredentials() {
        return this.f556c;
    }

    @Nullable
    public MaxError getError() {
        return this.f558e;
    }

    public long getLatencyMillis() {
        return this.f557d;
    }

    public MaxMediatedNetworkInfo getMediatedNetwork() {
        return this.f555b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0036, code lost:
        if (r1 != 2) goto L_0x005d;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "MaxResponseInfo{adLoadState="
            java.lang.StringBuilder r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r1)
            com.applovin.mediation.MaxNetworkResponseInfo$AdLoadState r2 = r4.f554a
            r1.append(r2)
            java.lang.String r2 = ", mediatedNetwork="
            r1.append(r2)
            com.applovin.mediation.MaxMediatedNetworkInfo r2 = r4.f555b
            r1.append(r2)
            java.lang.String r2 = ", credentials="
            r1.append(r2)
            android.os.Bundle r2 = r4.f556c
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            int[] r1 = com.applovin.impl.mediation.MaxNetworkResponseInfoImpl.C07921.f559a
            com.applovin.mediation.MaxNetworkResponseInfo$AdLoadState r2 = r4.f554a
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L_0x0039
            r2 = 2
            if (r1 == r2) goto L_0x004b
            goto L_0x005d
        L_0x0039:
            java.lang.String r1 = ", error="
            java.lang.StringBuilder r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r1)
            com.applovin.mediation.MaxError r2 = r4.f558e
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
        L_0x004b:
            java.lang.String r1 = ", latencyMillis="
            java.lang.StringBuilder r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r1)
            long r2 = r4.f557d
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
        L_0x005d:
            java.lang.String r1 = "]"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.MaxNetworkResponseInfoImpl.toString():java.lang.String");
    }
}
