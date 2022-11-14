package com.applovin.impl.sdk.p025ad;

import android.net.Uri;
import com.applovin.impl.adview.C0752i;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p024a.C1010b;
import com.applovin.impl.sdk.p024a.C1018c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.vungle.warren.analytics.AnalyticsEvent;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.a */
public final class C1052a extends C1057e {

    /* renamed from: a */
    public final String f1388a = mo9311b();

    /* renamed from: b */
    public final String f1389b = mo10535h();

    /* renamed from: c */
    public final String f1390c = m1448aJ();

    /* renamed from: d */
    public final C1018c f1391d = new C1018c(this);

    public C1052a(JSONObject jSONObject, JSONObject jSONObject2, C1053b bVar, C1188m mVar) {
        super(jSONObject, jSONObject2, bVar, mVar);
    }

    /* renamed from: aJ */
    private String m1448aJ() {
        return getStringFromAdObject("stream_url", "");
    }

    /* renamed from: a */
    public void mo9300a() {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", this.f1388a);
            JsonUtils.putString(this.adObject, "stream_url", this.f1390c);
        }
    }

    /* renamed from: a */
    public void mo10532a(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "video", uri.toString());
        }
    }

    /* renamed from: a */
    public void mo10533a(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", str);
        }
    }

    /* renamed from: b */
    public String mo9311b() {
        String string;
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, "html", "");
        }
        return string;
    }

    /* renamed from: c */
    public String mo9312c() {
        return this.f1389b;
    }

    /* renamed from: d */
    public String mo9313d() {
        return this.f1390c;
    }

    /* renamed from: e */
    public boolean mo9314e() {
        return this.adObject.has("stream_url");
    }

    /* renamed from: f */
    public void mo10534f() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    /* renamed from: g */
    public Uri mo9317g() {
        String aJ = m1448aJ();
        if (StringUtils.isValidString(aJ)) {
            return Uri.parse(aJ);
        }
        String h = mo10535h();
        if (StringUtils.isValidString(h)) {
            return Uri.parse(h);
        }
        return null;
    }

    public C1010b getAdEventTracker() {
        return this.f1391d;
    }

    public JSONObject getOriginalFullResponse() {
        JSONObject deepCopy;
        synchronized (this.fullResponseLock) {
            deepCopy = JsonUtils.deepCopy(this.fullResponse);
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(deepCopy, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject, "html", this.f1388a);
            JsonUtils.putString(jSONObject, "video", this.f1389b);
            JsonUtils.putString(jSONObject, "stream_url", this.f1390c);
        }
        return deepCopy;
    }

    /* renamed from: h */
    public String mo10535h() {
        return getStringFromAdObject("video", "");
    }

    public boolean hasVideoUrl() {
        return mo9317g() != null;
    }

    /* renamed from: i */
    public Uri mo9324i() {
        String stringFromAdObject = getStringFromAdObject(AnalyticsEvent.C1956Ad.clickUrl, "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", Boolean.FALSE);
    }

    /* renamed from: j */
    public Uri mo9326j() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return StringUtils.isValidString(stringFromAdObject) ? Uri.parse(stringFromAdObject) : mo9324i();
    }

    /* renamed from: k */
    public float mo10536k() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    /* renamed from: l */
    public boolean mo10537l() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", Boolean.FALSE);
        }
        return true;
    }

    /* renamed from: m */
    public C0752i.C0753a mo10538m() {
        return mo10581a(getIntFromAdObject("expandable_style", C0752i.C0753a.INVISIBLE.mo9650a()));
    }
}
