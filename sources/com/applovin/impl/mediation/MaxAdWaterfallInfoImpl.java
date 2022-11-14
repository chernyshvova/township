package com.applovin.impl.mediation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import java.util.List;

public class MaxAdWaterfallInfoImpl implements MaxAdWaterfallInfo {
    @Nullable

    /* renamed from: a */
    public final C0801a f537a;

    /* renamed from: b */
    public final String f538b;

    /* renamed from: c */
    public final String f539c;

    /* renamed from: d */
    public final List<MaxNetworkResponseInfo> f540d;

    /* renamed from: e */
    public final long f541e;

    public MaxAdWaterfallInfoImpl(C0801a aVar, long j, List<MaxNetworkResponseInfo> list) {
        this(aVar, aVar.mo9850n(), aVar.mo9851o(), j, list);
    }

    public MaxAdWaterfallInfoImpl(@Nullable C0801a aVar, String str, String str2, long j, List<MaxNetworkResponseInfo> list) {
        this.f537a = aVar;
        this.f538b = str;
        this.f539c = str2;
        this.f540d = list;
        this.f541e = j;
    }

    public long getLatencyMillis() {
        return this.f541e;
    }

    public MaxAd getLoadedAd() {
        return this.f537a;
    }

    public String getName() {
        return this.f538b;
    }

    public List<MaxNetworkResponseInfo> getNetworkResponses() {
        return this.f540d;
    }

    public String getTestName() {
        return this.f539c;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MaxAdWaterfallInfo{name=");
        outline24.append(this.f538b);
        outline24.append(", testName=");
        outline24.append(this.f539c);
        outline24.append(", networkResponses=");
        outline24.append(this.f540d);
        outline24.append(", latencyMillis=");
        outline24.append(this.f541e);
        outline24.append('}');
        return outline24.toString();
    }
}
