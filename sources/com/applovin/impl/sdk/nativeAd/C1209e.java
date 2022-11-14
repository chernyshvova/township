package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.nativeAd.C1204a;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1150r;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import com.vungle.warren.downloader.CleverCache;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.nativeAd.e */
public class C1209e extends C1109a implements C1204a.C1205a, AppLovinAdLoadListener {

    /* renamed from: a */
    public final JSONObject f2254a;

    /* renamed from: c */
    public final JSONObject f2255c;

    /* renamed from: d */
    public final AppLovinNativeAdLoadListener f2256d;

    /* renamed from: e */
    public String f2257e = "";

    /* renamed from: f */
    public String f2258f = "";

    /* renamed from: g */
    public String f2259g = "";

    /* renamed from: h */
    public String f2260h = "";

    /* renamed from: i */
    public Uri f2261i = null;

    /* renamed from: j */
    public Uri f2262j = null;

    /* renamed from: k */
    public Uri f2263k = null;
    @Nullable

    /* renamed from: l */
    public C0631a f2264l;
    @Nullable

    /* renamed from: m */
    public Uri f2265m = null;
    @Nullable

    /* renamed from: n */
    public Uri f2266n = null;

    /* renamed from: o */
    public final List<String> f2267o = new ArrayList();

    /* renamed from: p */
    public final List<String> f2268p = new ArrayList();

    /* renamed from: q */
    public final List<String> f2269q = new ArrayList();

    /* renamed from: r */
    public final List<String> f2270r = new ArrayList();

    /* renamed from: s */
    public final List<String> f2271s = new ArrayList();

    public C1209e(JSONObject jSONObject, JSONObject jSONObject2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, C1188m mVar) {
        super("TaskRenderNativeAd", mVar);
        this.f2254a = jSONObject;
        this.f2255c = jSONObject2;
        this.f2256d = appLovinNativeAdLoadListener;
    }

    /* renamed from: a */
    private void m2186a() {
        AppLovinNativeAdImpl build = new AppLovinNativeAdImpl.Builder(JsonUtils.shallowCopy(this.f2254a), JsonUtils.shallowCopy(this.f2255c), this.f1961b).setTitle(this.f2257e).setAdvertiser(this.f2258f).setBody(this.f2259g).setCallToAction(this.f2260h).setIconUri(this.f2261i).setMainImageUri(this.f2262j).setVastAd(this.f2264l).setPrivacyDestinationUri(this.f2263k).setClickDestinationUri(this.f2265m).setClickDestinationBackupUri(this.f2266n).setClickTrackingUrls(this.f2267o).setImpressionUrls(this.f2268p).setViewableMRC50Urls(this.f2269q).setViewableMRC100Urls(this.f2270r).setViewableVideo50Urls(this.f2271s).build();
        build.getAdEventTracker().mo10455b();
        mo10768a("Starting cache task for type: " + build.getType() + "...");
        this.f1961b.mo10938S().mo10829a((C1109a) new C1204a(build, this.f1961b, this), C1140o.C1142a.MAIN);
    }

    /* renamed from: a */
    private void m2190a(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            String string = JsonUtils.getString(jSONObject, "url", (String) null);
            if (StringUtils.isValidString(string)) {
                this.f2265m = Uri.parse(string);
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Processed click destination URL: ");
                outline24.append(this.f2265m);
                mo10768a(outline24.toString());
            }
            String string2 = JsonUtils.getString(jSONObject, "fallback", (String) null);
            if (StringUtils.isValidString(string2)) {
                this.f2266n = Uri.parse(string2);
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Processed click destination backup URL: ");
                outline242.append(this.f2266n);
                mo10768a(outline242.toString());
            }
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "clicktrackers", (JSONArray) null);
            if (jSONArray != null) {
                try {
                    this.f2267o.addAll(JsonUtils.toList(jSONArray));
                    mo10768a("Processed click tracking URLs: " + this.f2267o);
                } catch (Throwable th) {
                    mo10769a("Failed to render click tracking URLs", th);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2192b() {
        this.f2256d.onNativeAdLoadFailed(-6);
    }

    /* renamed from: b */
    private void m2193b(final AppLovinNativeAdImpl appLovinNativeAdImpl) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C1209e.this.mo10768a("Preparing native ad view components...");
                try {
                    appLovinNativeAdImpl.setUpNativeAdViewComponents();
                    C1209e.this.mo10768a("Successfully prepared native ad view components");
                    appLovinNativeAdImpl.getAdEventTracker().mo10457c();
                    C1209e.this.f2256d.onNativeAdLoaded(appLovinNativeAdImpl);
                } catch (Throwable th) {
                    C1209e.this.mo10769a("Failed to prepare native ad view components", th);
                    C1209e.this.m2192b();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo11083a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        mo10768a("Successfully cached and loaded ad");
        m2193b(appLovinNativeAdImpl);
    }

    public void adReceived(AppLovinAd appLovinAd) {
        mo10768a("VAST ad rendered successfully");
        this.f2264l = (C0631a) appLovinAd;
        m2186a();
    }

    public void failedToReceiveAd(int i) {
        mo10773d("VAST ad failed to render");
        m2186a();
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [org.json.JSONObject, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v4 */
    public void run() {
        String str;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        String str3;
        String str4;
        StringBuilder sb3;
        String str5;
        String str6;
        StringBuilder sb4;
        String str7;
        StringBuilder outline24;
        Uri uri;
        ? r2 = 0;
        String string = JsonUtils.getString(this.f2254a, "privacy_url", (String) null);
        if (!URLUtil.isValidUrl(string)) {
            string = "https://www.applovin.com/privacy/";
        }
        this.f2263k = Uri.parse(string);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f2254a, "ortb_response", (JSONObject) null);
        if (jSONObject == null || jSONObject.length() == 0) {
            sb = new StringBuilder();
            str = "No oRtb response provided: ";
        } else {
            String string2 = JsonUtils.getString(jSONObject, "version", (String) null);
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "value", (JSONObject) null);
            mo10768a("Rendering native ad for oRTB version: " + string2);
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, jSONObject2);
            m2190a(JsonUtils.getJSONObject(jSONObject3, "link", (JSONObject) null));
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject3, CleverCache.ASSETS_DIR, (JSONArray) null);
            if (jSONArray == null || jSONArray.length() == 0) {
                sb = new StringBuilder();
                str = "Unable to retrieve assets - failing ad load: ";
            } else {
                String str8 = "";
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) r2);
                    if (jSONObject4.has("title")) {
                        this.f2257e = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "title", (JSONObject) r2), "text", r2);
                        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Processed title: ");
                        outline242.append(this.f2257e);
                        mo10768a(outline242.toString());
                    } else if (jSONObject4.has("link")) {
                        m2190a(JsonUtils.getJSONObject(jSONObject4, "link", (JSONObject) r2));
                    } else {
                        if (jSONObject4.has("img")) {
                            int i2 = JsonUtils.getInt(jSONObject4, "id", -1);
                            JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "img", (JSONObject) r2);
                            int i3 = JsonUtils.getInt(jSONObject5, "type", -1);
                            String string3 = JsonUtils.getString(jSONObject5, "url", r2);
                            if (i3 == 1 || 3 == i2) {
                                this.f2261i = Uri.parse(string3);
                                sb3 = GeneratedOutlineSupport.outline24("Processed icon URL: ");
                                uri = this.f2261i;
                            } else if (i3 == 3 || 2 == i2) {
                                this.f2262j = Uri.parse(string3);
                                sb3 = GeneratedOutlineSupport.outline24("Processed main image URL: ");
                                uri = this.f2262j;
                            } else {
                                mo10771c("Unrecognized image: " + jSONObject4);
                                int i4 = JsonUtils.getInt(jSONObject5, "w", -1);
                                int i5 = JsonUtils.getInt(jSONObject5, "h", -1);
                                if (i4 <= 0 || i5 <= 0) {
                                    str5 = "Skipping...";
                                } else {
                                    int i6 = (((double) (((float) i4) / ((float) i5))) > 1.0d ? 1 : (((double) (((float) i4) / ((float) i5))) == 1.0d ? 0 : -1));
                                    StringBuilder sb5 = new StringBuilder();
                                    if (i6 > 0) {
                                        sb5.append("Inferring main image from ");
                                        sb5.append(i4);
                                        sb5.append("x");
                                        sb5.append(i5);
                                        sb5.append("...");
                                        mo10768a(sb5.toString());
                                        this.f2262j = Uri.parse(string3);
                                    } else {
                                        sb5.append("Inferring icon image from ");
                                        sb5.append(i4);
                                        sb5.append("x");
                                        sb5.append(i5);
                                        sb5.append("...");
                                        mo10768a(sb5.toString());
                                        this.f2261i = Uri.parse(string3);
                                    }
                                }
                            }
                            sb3.append(uri);
                            String str9 = str8;
                            str3 = sb3.toString();
                            str4 = str9;
                            mo10768a(str3);
                            str8 = str4;
                        } else {
                            if (jSONObject4.has("video")) {
                                str4 = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "video", (JSONObject) null), "vasttag", (String) null);
                                if (StringUtils.isValidString(str4)) {
                                    str3 = "Processed VAST video";
                                    mo10768a(str3);
                                    str8 = str4;
                                } else {
                                    sb4 = new StringBuilder();
                                    str6 = "Ignoring invalid \"vasttag\" for video: ";
                                }
                            } else if (jSONObject4.has("data")) {
                                int i7 = JsonUtils.getInt(jSONObject4, "id", -1);
                                JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject4, "data", (JSONObject) null);
                                int i8 = JsonUtils.getInt(jSONObject6, "type", -1);
                                String string4 = JsonUtils.getString(jSONObject6, "value", (String) null);
                                if (i8 == 1 || i7 == 8) {
                                    this.f2258f = string4;
                                    outline24 = GeneratedOutlineSupport.outline24("Processed advertiser: ");
                                    str7 = this.f2258f;
                                } else if (i8 == 2 || i7 == 4) {
                                    this.f2259g = string4;
                                    outline24 = GeneratedOutlineSupport.outline24("Processed body: ");
                                    str7 = this.f2259g;
                                } else if (i8 == 12 || i7 == 5) {
                                    this.f2260h = string4;
                                    outline24 = GeneratedOutlineSupport.outline24("Processed cta: ");
                                    str7 = this.f2260h;
                                } else {
                                    str6 = "Skipping unsupported data: ";
                                    String str10 = str8;
                                    sb4 = new StringBuilder();
                                    str4 = str10;
                                }
                                sb3.append(str7);
                                String str92 = str8;
                                str3 = sb3.toString();
                                str4 = str92;
                                mo10768a(str3);
                                str8 = str4;
                            } else {
                                mo10773d("Unsupported asset object: " + jSONObject4);
                            }
                            sb4.append(str6);
                            sb4.append(jSONObject4);
                            String sb6 = sb4.toString();
                            str8 = str4;
                            str5 = sb6;
                        }
                        mo10771c(str5);
                    }
                    i++;
                    r2 = 0;
                }
                if (jSONObject3.has("imptrackers")) {
                    mo10773d("Ignoring \"imptrackers\" field - it is deprecated in lieu of \"eventtrackers\"");
                }
                if (jSONObject3.has("jstracker")) {
                    mo10773d("Ignoring \"jstracker\" field - it is deprecated in lieu of \"eventtrackers\"");
                }
                JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject3, "eventtrackers", (JSONArray) null);
                if (jSONArray2 != null) {
                    for (int i9 = 0; i9 < jSONArray2.length(); i9++) {
                        JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONArray2, i9, (JSONObject) null);
                        int i10 = JsonUtils.getInt(jSONObject7, "event", -1);
                        int i11 = JsonUtils.getInt(jSONObject7, "method", -1);
                        String string5 = JsonUtils.getString(jSONObject7, "url", (String) null);
                        if (!TextUtils.isEmpty(string5)) {
                            if (i11 != 1) {
                                mo10773d("Unsupported method for event tracker: " + jSONObject7);
                            } else if (i10 == 1) {
                                this.f2268p.add(string5);
                                mo10768a("Processed impression URL: " + string5);
                            } else {
                                if (i10 == 2) {
                                    this.f2269q.add(string5);
                                    sb2 = new StringBuilder();
                                    str2 = "Processed viewable MRC50 URL: ";
                                } else if (i10 == 3) {
                                    this.f2270r.add(string5);
                                    sb2 = new StringBuilder();
                                    str2 = "Processed viewable MRC100 URL: ";
                                } else if (i10 == 4) {
                                    this.f2271s.add(string5);
                                    sb2 = new StringBuilder();
                                    str2 = "Processed viewable video 50 URL: ";
                                } else {
                                    mo10773d("Unsupported event tracker: " + jSONObject7);
                                }
                                sb2.append(str2);
                                sb2.append(string5);
                                mo10768a(sb2.toString());
                            }
                        }
                    }
                }
                if (StringUtils.isValidString(str8)) {
                    mo10768a("Processing VAST video...");
                    this.f1961b.mo10938S().mo10828a((C1109a) C1150r.m1940a(str8, this.f2254a, this.f2255c, C1053b.UNKNOWN, this, this.f1961b));
                    return;
                }
                m2186a();
                return;
            }
        }
        sb.append(str);
        sb.append(this.f2254a);
        mo10773d(sb.toString());
        m2192b();
    }
}
