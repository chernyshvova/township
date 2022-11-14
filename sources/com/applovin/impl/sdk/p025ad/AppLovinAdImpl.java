package com.applovin.impl.sdk.p025ad;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.AppLovinAdImpl */
public abstract class AppLovinAdImpl extends AppLovinAdBase implements AppLovinAd {

    /* renamed from: a */
    public C1056d f1386a;

    /* renamed from: b */
    public C1063f f1387b;
    public final C1053b source;

    public AppLovinAdImpl(JSONObject jSONObject, JSONObject jSONObject2, C1053b bVar, C1188m mVar) {
        super(jSONObject, jSONObject2, mVar);
        this.source = bVar;
    }

    public boolean equals(Object obj) {
        AppLovinAd b;
        if ((obj instanceof C1063f) && (b = ((C1063f) obj).mo10639b()) != null) {
            obj = b;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) obj;
        C1056d dVar = this.f1386a;
        if (dVar == null ? appLovinAdImpl.f1386a == null : dVar.equals(appLovinAdImpl.f1386a)) {
            return this.source == appLovinAdImpl.source && this.responseHash == appLovinAdImpl.responseHash;
        }
        return false;
    }

    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1);
    }

    public String getAdValue(String str) {
        return getAdValue(str, (String) null);
    }

    public String getAdValue(String str, String str2) {
        return JsonUtils.getString(getJsonObjectFromAdObject("ad_values", new JSONObject()), str, str2);
    }

    public C1056d getAdZone() {
        C1056d dVar = this.f1386a;
        if (dVar != null) {
            if (dVar.mo10550c() != null && this.f1386a.mo10551d() != null) {
                return this.f1386a;
            }
            if (getSize() == null && getType() == null) {
                return this.f1386a;
            }
        }
        C1056d a = C1056d.m1472a(getSize(), getType(), getStringFromFullResponse("zone_id", (String) null));
        this.f1386a = a;
        return a;
    }

    public C1063f getDummyAd() {
        return this.f1387b;
    }

    public abstract JSONObject getOriginalFullResponse();

    public String getRawFullResponse() {
        String jSONObject;
        synchronized (this.fullResponseLock) {
            jSONObject = this.fullResponse.toString();
        }
        return jSONObject;
    }

    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", (String) null));
    }

    public C1053b getSource() {
        return this.source;
    }

    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse("ad_type", (String) null));
    }

    public String getZoneId() {
        if (getAdZone().mo10552e()) {
            return null;
        }
        return getStringFromFullResponse("zone_id", (String) null);
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", Boolean.FALSE);
    }

    public boolean hasVideoUrl() {
        this.sdk.mo10922B().mo11376e("AppLovinAd", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public int hashCode() {
        return this.responseHash;
    }

    public boolean isVideoAd() {
        return this.adObject.has("is_video_ad") ? getBooleanFromAdObject("is_video_ad", Boolean.FALSE) : hasVideoUrl();
    }

    public void setDummyAd(C1063f fVar) {
        this.f1387b = fVar;
    }

    public void setHasShown(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("shown", z);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean shouldCancelHtmlCachingIfShown() {
        return getBooleanFromAdObject("chcis", Boolean.FALSE);
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinAd{adIdNumber=");
        outline24.append(getAdIdNumber());
        outline24.append(", source=");
        outline24.append(getSource());
        outline24.append(", zoneId=\"");
        outline24.append(getZoneId());
        outline24.append("\"");
        outline24.append('}');
        return outline24.toString();
    }
}
