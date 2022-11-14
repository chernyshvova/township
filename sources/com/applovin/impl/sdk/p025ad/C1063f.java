package com.applovin.impl.sdk.p025ad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p024a.C1010b;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.f */
public final class C1063f extends AppLovinAdImpl {

    /* renamed from: a */
    public AppLovinAd f1443a;

    /* renamed from: b */
    public final C1056d f1444b;

    public C1063f(C1056d dVar, C1188m mVar) {
        super(new JSONObject(), new JSONObject(), C1053b.UNKNOWN, mVar);
        this.f1444b = dVar;
    }

    /* renamed from: c */
    private AppLovinAd m1589c() {
        return (AppLovinAd) this.sdk.mo10945Z().mo10672c(this.f1444b);
    }

    /* renamed from: d */
    private String m1590d() {
        C1056d adZone = getAdZone();
        if (adZone == null || adZone.mo10552e()) {
            return null;
        }
        return adZone.mo10548a();
    }

    /* renamed from: a */
    public AppLovinAd mo10637a() {
        return this.f1443a;
    }

    /* renamed from: a */
    public void mo10638a(AppLovinAd appLovinAd) {
        this.f1443a = appLovinAd;
    }

    /* renamed from: b */
    public AppLovinAd mo10639b() {
        AppLovinAd appLovinAd = this.f1443a;
        return appLovinAd != null ? appLovinAd : m1589c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1063f.class != obj.getClass()) {
            return false;
        }
        AppLovinAd b = mo10639b();
        return b != null ? b.equals(obj) : super.equals(obj);
    }

    public C1010b getAdEventTracker() {
        return null;
    }

    public long getAdIdNumber() {
        AppLovinAd b = mo10639b();
        if (b != null) {
            return b.getAdIdNumber();
        }
        return 0;
    }

    public C1056d getAdZone() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) mo10639b();
        return appLovinAdImpl != null ? appLovinAdImpl.getAdZone() : this.f1444b;
    }

    public long getCreatedAtMillis() {
        AppLovinAd b = mo10639b();
        if (b instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) b).getCreatedAtMillis();
        }
        return 0;
    }

    @Nullable
    public String getOpenMeasurementContentUrl() {
        return null;
    }

    public String getOpenMeasurementCustomReferenceData() {
        return null;
    }

    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        return null;
    }

    public JSONObject getOriginalFullResponse() {
        AppLovinAd b = mo10639b();
        if (b instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) b).getOriginalFullResponse();
        }
        return null;
    }

    public AppLovinAdSize getSize() {
        return getAdZone().mo10550c();
    }

    public C1053b getSource() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) mo10639b();
        return appLovinAdImpl != null ? appLovinAdImpl.getSource() : C1053b.UNKNOWN;
    }

    public AppLovinAdType getType() {
        return getAdZone().mo10551d();
    }

    public String getZoneId() {
        if (this.f1444b.mo10552e()) {
            return null;
        }
        return this.f1444b.mo10548a();
    }

    public int hashCode() {
        AppLovinAd b = mo10639b();
        return b != null ? b.hashCode() : super.hashCode();
    }

    public boolean isOpenMeasurementEnabled() {
        return false;
    }

    public boolean isVideoAd() {
        AppLovinAd b = mo10639b();
        return b != null && b.isVideoAd();
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinAd{ #");
        outline24.append(getAdIdNumber());
        outline24.append(", adType=");
        outline24.append(getType());
        outline24.append(", adSize=");
        outline24.append(getSize());
        outline24.append(", zoneId='");
        outline24.append(m1590d());
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
