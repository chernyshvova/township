package com.applovin.impl.mediation.p010a;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.C0951g;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vungle.warren.log.LogEntry;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a */
public abstract class C0801a extends C0806f implements MaxAd {

    /* renamed from: a */
    public C0951g f596a;

    /* renamed from: c */
    public final AtomicBoolean f597c = new AtomicBoolean();

    /* renamed from: d */
    public MaxAdWaterfallInfo f598d;

    /* renamed from: e */
    public String f599e;

    public C0801a(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, @Nullable C0951g gVar, C1188m mVar) {
        super(map, jSONObject, jSONObject2, mVar);
        this.f596a = gVar;
    }

    /* renamed from: a */
    public static C0801a m654a(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, C1188m mVar) {
        String string = JsonUtils.getString(jSONObject2, FirebaseAnalytics.Param.AD_FORMAT, (String) null);
        MaxAdFormat formatFromString = MaxAdFormat.formatFromString(string);
        if (formatFromString.isAdViewAd()) {
            return new C0802b(map, jSONObject, jSONObject2, mVar);
        }
        if (formatFromString == MaxAdFormat.NATIVE) {
            return new C0804d(map, jSONObject, jSONObject2, mVar);
        }
        if (formatFromString.isFullscreenAd()) {
            return new C0803c(map, jSONObject, jSONObject2, mVar);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("Unsupported ad format: ", string));
    }

    /* renamed from: v */
    private long mo9862v() {
        return mo9920b("load_started_time_ms", 0);
    }

    /* renamed from: a */
    public abstract C0801a mo9824a(C0951g gVar);

    /* renamed from: a */
    public String mo9825a() {
        return this.f599e;
    }

    /* renamed from: a */
    public void mo9826a(@Nullable Bundle bundle) {
        if (bundle != null && bundle.containsKey("creative_id") && !mo9924b("creative_id")) {
            mo9927c("creative_id", BundleUtils.getString("creative_id", bundle));
        }
    }

    /* renamed from: a */
    public void mo9827a(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.f598d = maxAdWaterfallInfo;
    }

    /* renamed from: a */
    public void mo9828a(String str) {
        this.f599e = str;
    }

    /* renamed from: b */
    public JSONObject mo9829b() {
        return mo9916a("ad_values", new JSONObject());
    }

    /* renamed from: c */
    public JSONObject mo9830c() {
        return mo9916a("revenue_parameters", new JSONObject());
    }

    /* renamed from: d */
    public String mo9831d() {
        return JsonUtils.getString(mo9830c(), "revenue_event", "");
    }

    /* renamed from: e */
    public boolean mo9832e() {
        C0951g gVar = this.f596a;
        return gVar != null && gVar.mo10256f() && this.f596a.mo10257g();
    }

    /* renamed from: f */
    public String mo9833f() {
        return mo9914a(LogEntry.LOG_ITEM_EVENT_ID, "");
    }

    /* renamed from: g */
    public C0951g mo9834g() {
        return this.f596a;
    }

    public String getAdValue(String str) {
        return getAdValue(str, (String) null);
    }

    public String getAdValue(String str, String str2) {
        JSONObject b = mo9829b();
        return b.has(str) ? JsonUtils.getString(b, str, str2) : mo9906X().getString(str, str2);
    }

    public String getCreativeId() {
        return mo9922b("creative_id", (String) null);
    }

    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(mo9922b(FirebaseAnalytics.Param.AD_FORMAT, mo9914a(FirebaseAnalytics.Param.AD_FORMAT, (String) null)));
    }

    public String getNetworkName() {
        return mo9922b("network_name", "");
    }

    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(mo9849m());
    }

    public double getRevenue() {
        return JsonUtils.getDouble(mo9916a("revenue_parameters", (JSONObject) null), "revenue", -1.0d);
    }

    public String getRevenuePrecision() {
        return JsonUtils.getString(mo9916a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    public MaxAdWaterfallInfo getWaterfall() {
        return this.f598d;
    }

    @Nullable
    /* renamed from: h */
    public Float mo9844h() {
        return mo9913a("r_mbr", (Float) null);
    }

    /* renamed from: i */
    public Bundle mo9845i() {
        JSONObject jSONObject;
        if (mo9924b("credentials")) {
            jSONObject = mo9916a("credentials", new JSONObject());
        } else {
            jSONObject = mo9916a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_PLACEMENT_ID, mo9849m());
        }
        return JsonUtils.toBundle(jSONObject);
    }

    /* renamed from: j */
    public String mo9846j() {
        return mo9922b("bid_response", (String) null);
    }

    /* renamed from: k */
    public long mo9847k() {
        return mo9920b("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1, mo9906X()));
    }

    /* renamed from: l */
    public boolean mo9848l() {
        return mo9921b("is_js_tag_ad", Boolean.FALSE).booleanValue();
    }

    /* renamed from: m */
    public String mo9849m() {
        return mo9922b("third_party_ad_placement_id", (String) null);
    }

    /* renamed from: n */
    public String mo9850n() {
        return mo9914a("waterfall_name", "");
    }

    /* renamed from: o */
    public String mo9851o() {
        return mo9914a("waterfall_test_name", "");
    }

    /* renamed from: p */
    public long mo9852p() {
        if (mo9862v() > 0) {
            return mo9854r() - mo9862v();
        }
        return -1;
    }

    /* renamed from: q */
    public void mo9853q() {
        mo9926c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    /* renamed from: r */
    public long mo9854r() {
        return mo9920b("load_completed_time_ms", 0);
    }

    /* renamed from: s */
    public void mo9855s() {
        mo9926c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    /* renamed from: t */
    public AtomicBoolean mo9856t() {
        return this.f597c;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediatedAd{thirdPartyAdPlacementId=");
        outline24.append(mo9849m());
        outline24.append(", adUnitId=");
        outline24.append(getAdUnitId());
        outline24.append(", format=");
        outline24.append(getFormat().getLabel());
        outline24.append(", networkName='");
        outline24.append(getNetworkName());
        outline24.append("'}");
        return outline24.toString();
    }

    /* renamed from: u */
    public void mo9858u() {
        this.f596a = null;
        this.f598d = null;
    }
}
