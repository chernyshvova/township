package com.applovin.impl.mediation;

import android.os.Bundle;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p010a.C0806f;
import com.applovin.impl.mediation.p010a.C0809h;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.Map;

public class MaxAdapterParametersImpl implements MaxAdapterInitializationParameters, MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters {

    /* renamed from: a */
    public String f542a;

    /* renamed from: b */
    public Map<String, Object> f543b;

    /* renamed from: c */
    public Bundle f544c;

    /* renamed from: d */
    public Boolean f545d;

    /* renamed from: e */
    public Boolean f546e;

    /* renamed from: f */
    public Boolean f547f;

    /* renamed from: g */
    public boolean f548g;

    /* renamed from: h */
    public String f549h;

    /* renamed from: i */
    public String f550i;

    /* renamed from: j */
    public long f551j;

    /* renamed from: k */
    public MaxAdFormat f552k;

    /* renamed from: a */
    public static MaxAdapterParametersImpl m621a(C0801a aVar) {
        MaxAdapterParametersImpl a = m622a((C0806f) aVar);
        a.f549h = aVar.mo9849m();
        a.f550i = aVar.mo9846j();
        a.f551j = aVar.mo9847k();
        return a;
    }

    /* renamed from: a */
    public static MaxAdapterParametersImpl m622a(C0806f fVar) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f542a = fVar.getAdUnitId();
        maxAdapterParametersImpl.f545d = fVar.mo9901S();
        maxAdapterParametersImpl.f546e = fVar.mo9902T();
        maxAdapterParametersImpl.f547f = fVar.mo9903U();
        maxAdapterParametersImpl.f543b = fVar.mo9905W();
        maxAdapterParametersImpl.f544c = fVar.mo9906X();
        maxAdapterParametersImpl.f548g = fVar.mo9900R();
        return maxAdapterParametersImpl;
    }

    /* renamed from: a */
    public static MaxAdapterParametersImpl m623a(C0809h hVar, MaxAdFormat maxAdFormat) {
        MaxAdapterParametersImpl a = m622a((C0806f) hVar);
        a.f552k = maxAdFormat;
        return a;
    }

    public MaxAdFormat getAdFormat() {
        return this.f552k;
    }

    public String getAdUnitId() {
        return this.f542a;
    }

    public long getBidExpirationMillis() {
        return this.f551j;
    }

    public String getBidResponse() {
        return this.f550i;
    }

    public Map<String, Object> getLocalExtraParameters() {
        return this.f543b;
    }

    public Bundle getServerParameters() {
        return this.f544c;
    }

    public String getThirdPartyAdPlacementId() {
        return this.f549h;
    }

    public Boolean hasUserConsent() {
        return this.f545d;
    }

    public Boolean isAgeRestrictedUser() {
        return this.f546e;
    }

    public Boolean isDoNotSell() {
        return this.f547f;
    }

    public boolean isTesting() {
        return this.f548g;
    }
}
