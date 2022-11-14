package com.applovin.impl.mediation.p010a;

import androidx.annotation.Nullable;
import com.applovin.impl.mediation.C0951g;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.d */
public class C0804d extends C0805e {

    /* renamed from: c */
    public final AtomicBoolean f603c = new AtomicBoolean();

    public C0804d(C0804d dVar, C0951g gVar) {
        super(dVar.mo9905W(), dVar.mo9896N(), dVar.mo9895M(), gVar, dVar.f605b);
    }

    public C0804d(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, C1188m mVar) {
        super(map, jSONObject, jSONObject2, (C0951g) null, mVar);
    }

    /* renamed from: a */
    public C0801a mo9824a(C0951g gVar) {
        return new C0804d(this, gVar);
    }

    /* renamed from: a */
    public void mo9884a(MaxNativeAdView maxNativeAdView) {
        this.f596a.mo10249a(maxNativeAdView);
    }

    /* renamed from: v */
    public MaxNativeAd mo9862v() {
        return this.f596a.mo10252b();
    }

    @Nullable
    /* renamed from: w */
    public MaxNativeAdView mo9885w() {
        return this.f596a.mo10253c();
    }

    /* renamed from: x */
    public String mo9886x() {
        return BundleUtils.getString("template", "", mo9906X());
    }

    /* renamed from: y */
    public boolean mo9887y() {
        return this.f596a == null;
    }

    /* renamed from: z */
    public AtomicBoolean mo9888z() {
        return this.f603c;
    }
}
