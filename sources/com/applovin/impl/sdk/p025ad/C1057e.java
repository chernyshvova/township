package com.applovin.impl.sdk.p025ad;

import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.applovin.impl.adview.C0752i;
import com.applovin.impl.adview.C0781s;
import com.applovin.impl.adview.C0785v;
import com.applovin.impl.sdk.C1046ac;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p026b.C1082c;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1093a;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.vungle.warren.log.LogEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.e */
public abstract class C1057e extends AppLovinAdImpl {

    /* renamed from: a */
    public final List<Uri> f1413a = CollectionUtils.synchronizedList();

    /* renamed from: b */
    public final AtomicBoolean f1414b = new AtomicBoolean();

    /* renamed from: c */
    public final AtomicBoolean f1415c = new AtomicBoolean();

    /* renamed from: d */
    public final AtomicReference<C1082c> f1416d = new AtomicReference<>();

    /* renamed from: e */
    public boolean f1417e;

    /* renamed from: f */
    public List<C1093a> f1418f;

    /* renamed from: g */
    public List<C1093a> f1419g;

    /* renamed from: h */
    public List<C1093a> f1420h;

    /* renamed from: i */
    public List<C1093a> f1421i;

    /* renamed from: j */
    public C1061c f1422j;

    /* renamed from: com.applovin.impl.sdk.ad.e$a */
    public enum C1059a {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    /* renamed from: com.applovin.impl.sdk.ad.e$b */
    public enum C1060b {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    /* renamed from: com.applovin.impl.sdk.ad.e$c */
    public class C1061c {

        /* renamed from: a */
        public final int f1431a;

        /* renamed from: b */
        public final int f1432b;

        /* renamed from: c */
        public final int f1433c;

        /* renamed from: d */
        public final int f1434d;

        /* renamed from: e */
        public final int f1435e;

        public C1061c() {
            this.f1431a = AppLovinSdkUtils.dpToPx(C1057e.this.sdk.mo10932L(), C1057e.this.mo10574T());
            this.f1432b = AppLovinSdkUtils.dpToPx(C1057e.this.sdk.mo10932L(), C1057e.this.mo10575U());
            this.f1433c = AppLovinSdkUtils.dpToPx(C1057e.this.sdk.mo10932L(), C1057e.this.mo10576V());
            this.f1434d = AppLovinSdkUtils.dpToPx(C1057e.this.sdk.mo10932L(), ((Integer) C1057e.this.sdk.mo10946a(C1085b.f1607bL)).intValue());
            this.f1435e = AppLovinSdkUtils.dpToPx(C1057e.this.sdk.mo10932L(), ((Integer) C1057e.this.sdk.mo10946a(C1085b.f1606bK)).intValue());
        }
    }

    /* renamed from: com.applovin.impl.sdk.ad.e$d */
    public enum C1062d {
        RESIZE_ASPECT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public C1057e(JSONObject jSONObject, JSONObject jSONObject2, C1053b bVar, C1188m mVar) {
        super(jSONObject, jSONObject2, bVar, mVar);
    }

    /* renamed from: b */
    private String m1490b(PointF pointF, boolean z) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", (String) null);
        Map<String, String> c = m1494c(pointF, z);
        if (stringFromAdObject != null) {
            return StringUtils.replace(stringFromAdObject, c);
        }
        return null;
    }

    @Nullable
    /* renamed from: b */
    private List<Integer> mo9311b() {
        return getIntegerListFromAdObject("multi_close_style", (List<Integer>) null);
    }

    /* renamed from: c */
    private C0752i.C0753a m1492c(boolean z) {
        return z ? C0752i.C0753a.WHITE_ON_TRANSPARENT : C0752i.C0753a.WHITE_ON_BLACK;
    }

    /* renamed from: c */
    private Map<String, String> m1494c(PointF pointF, boolean z) {
        Point a = C1263g.m2503a(this.sdk.mo10932L());
        HashMap hashMap = new HashMap(5);
        hashMap.put(Utils.MACRO_CLCODE, getClCode());
        hashMap.put(Utils.MACRO_CLICK_X, String.valueOf(pointF.x));
        hashMap.put(Utils.MACRO_CLICK_Y, String.valueOf(pointF.y));
        hashMap.put(Utils.MACRO_SCREEN_WIDTH, String.valueOf(a.x));
        hashMap.put(Utils.MACRO_SCREEN_HEIGHT, String.valueOf(a.y));
        hashMap.put(Utils.MACRO_IS_VIDEO_CLICK, String.valueOf(z));
        return hashMap;
    }

    /* renamed from: d */
    private String mo9313d() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace(Utils.MACRO_CLCODE, getClCode());
        }
        return null;
    }

    /* renamed from: A */
    public C0781s mo10556A() {
        return new C0781s(getJsonObjectFromAdObject("video_button_properties", (JSONObject) null), this.sdk);
    }

    /* renamed from: B */
    public boolean mo9297B() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE);
    }

    /* renamed from: C */
    public boolean mo10557C() {
        return getBooleanFromAdObject("lock_current_orientation", Boolean.FALSE);
    }

    /* renamed from: D */
    public C1059a mo10558D() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return C1059a.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return C1059a.DO_NOT_DISMISS;
            }
        }
        return C1059a.UNSPECIFIED;
    }

    /* renamed from: E */
    public List<String> mo10559E() {
        String stringFromAdObject = getStringFromAdObject("required_html_resources", (String) null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.emptyList();
    }

    /* renamed from: F */
    public List<String> mo10560F() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", (String) null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : this.sdk.mo10980b(C1085b.f1643bv);
    }

    /* renamed from: G */
    public String mo10561G() {
        return getStringFromAdObject("cache_prefix", (String) null);
    }

    /* renamed from: H */
    public boolean mo10562H() {
        return getBooleanFromAdObject("sscomt", Boolean.FALSE);
    }

    /* renamed from: I */
    public String mo10563I() {
        return getStringFromFullResponse(LogEntry.LOG_ITEM_EVENT_ID, (String) null);
    }

    /* renamed from: J */
    public boolean mo10564J() {
        return getBooleanFromAdObject("progress_bar_enabled", Boolean.FALSE);
    }

    /* renamed from: K */
    public int mo10565K() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    /* renamed from: L */
    public int mo10566L() {
        int videoCompletionPercent;
        synchronized (this.adObjectLock) {
            videoCompletionPercent = Utils.getVideoCompletionPercent(this.adObject);
        }
        return videoCompletionPercent;
    }

    /* renamed from: M */
    public int mo10567M() {
        synchronized (this.adObjectLock) {
            int i = JsonUtils.getInt(this.adObject, "graphic_completion_percent", -1);
            if (i < 0 || i > 100) {
                return 90;
            }
            return i;
        }
    }

    /* renamed from: N */
    public int mo10568N() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    /* renamed from: O */
    public int mo10569O() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    /* renamed from: P */
    public boolean mo10570P() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", Boolean.FALSE);
    }

    /* renamed from: Q */
    public boolean mo10571Q() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", Boolean.FALSE);
    }

    /* renamed from: R */
    public boolean mo10572R() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", Boolean.FALSE);
    }

    /* renamed from: S */
    public C1061c mo10573S() {
        if (this.f1422j == null) {
            this.f1422j = new C1061c();
        }
        return this.f1422j;
    }

    /* renamed from: T */
    public int mo10574T() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.mo10946a(C1085b.f1688co)).intValue());
    }

    /* renamed from: U */
    public int mo10575U() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.mo10946a(C1085b.f1689cp)).intValue());
    }

    /* renamed from: V */
    public int mo10576V() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.mo10946a(C1085b.f1687cn)).intValue());
    }

    /* renamed from: W */
    public boolean mo10577W() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.mo10946a(C1085b.f1686cm));
    }

    /* renamed from: X */
    public boolean mo10578X() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.mo10946a(C1085b.f1693ct));
    }

    /* renamed from: Y */
    public long mo10579Y() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1;
    }

    /* renamed from: Z */
    public int mo10580Z() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    /* renamed from: a */
    public C0752i.C0753a mo10581a(int i) {
        return i == 1 ? C0752i.C0753a.WHITE_ON_TRANSPARENT : i == 2 ? C0752i.C0753a.INVISIBLE : i == 3 ? C0752i.C0753a.TRANSPARENT_SKIP : C0752i.C0753a.WHITE_ON_BLACK;
    }

    /* renamed from: a */
    public List<C1093a> mo10582a(PointF pointF) {
        List<C1093a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("video_click_tracking_urls", this.adObject, m1494c(pointF, true), (String) null, mo10610aq(), mo10633w(), this.sdk);
        }
        return postbacks.isEmpty() ? mo10583a(pointF, true) : postbacks;
    }

    /* renamed from: a */
    public List<C1093a> mo10583a(PointF pointF, boolean z) {
        List<C1093a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("click_tracking_urls", this.adObject, m1494c(pointF, z), m1490b(pointF, z), mo10610aq(), mo10633w(), this.sdk);
        }
        return postbacks;
    }

    /* renamed from: a */
    public abstract void mo9300a();

    /* renamed from: a */
    public void mo10584a(C1082c cVar) {
        this.f1416d.set(cVar);
    }

    /* renamed from: a */
    public void mo10585a(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("html_resources_cached", z);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: aA */
    public boolean mo10586aA() {
        return this.f1415c.get();
    }

    /* renamed from: aB */
    public void mo10587aB() {
        this.f1415c.set(true);
    }

    /* renamed from: aC */
    public C1082c mo10588aC() {
        return this.f1416d.getAndSet((Object) null);
    }

    /* renamed from: aD */
    public boolean mo10589aD() {
        return getBooleanFromAdObject("suep", Boolean.FALSE) || (getBooleanFromAdObject("suepfs", Boolean.FALSE) && mo9314e());
    }

    /* renamed from: aE */
    public boolean mo10590aE() {
        return getBooleanFromAdObject("rwvbv", Boolean.FALSE);
    }

    /* renamed from: aF */
    public long mo10591aF() {
        return getLongFromAdObject("vrsbt_ms", TimeUnit.SECONDS.toMillis(3));
    }

    /* renamed from: aG */
    public boolean mo10592aG() {
        return getBooleanFromAdObject("upiosp", Boolean.FALSE);
    }

    /* renamed from: aH */
    public boolean mo10593aH() {
        return getBooleanFromAdObject("web_video", Boolean.FALSE);
    }

    /* renamed from: aI */
    public C1062d mo10594aI() {
        String stringFromAdObject = getStringFromAdObject("video_gravity", (String) null);
        return ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(stringFromAdObject) ? C1062d.TOP : "bottom".equals(stringFromAdObject) ? C1062d.BOTTOM : ViewHierarchyConstants.DIMENSION_LEFT_KEY.equals(stringFromAdObject) ? C1062d.LEFT : "right".equals(stringFromAdObject) ? C1062d.RIGHT : C1062d.RESIZE_ASPECT;
    }

    /* renamed from: aa */
    public boolean mo10595aa() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", Boolean.TRUE);
    }

    /* renamed from: ab */
    public AtomicBoolean mo10596ab() {
        return this.f1414b;
    }

    /* renamed from: ac */
    public boolean mo10597ac() {
        return getBooleanFromAdObject("show_nia", Boolean.FALSE);
    }

    /* renamed from: ad */
    public String mo10598ad() {
        return getStringFromAdObject("nia_title", "");
    }

    /* renamed from: ae */
    public String mo10599ae() {
        return getStringFromAdObject("nia_message", "");
    }

    /* renamed from: af */
    public String mo10600af() {
        return getStringFromAdObject("nia_button_title", "");
    }

    /* renamed from: ag */
    public boolean mo10601ag() {
        return getBooleanFromAdObject("avoms", Boolean.FALSE);
    }

    /* renamed from: ah */
    public boolean mo10602ah() {
        return this.f1417e;
    }

    /* renamed from: ai */
    public boolean mo10603ai() {
        return getBooleanFromAdObject("show_rewarded_interstitial_overlay_alert", Boolean.valueOf(AppLovinAdType.AUTO_INCENTIVIZED == getType()));
    }

    /* renamed from: aj */
    public String mo10604aj() {
        return getStringFromAdObject("text_rewarded_inter_alert_title", "Watch a video to earn a reward!");
    }

    /* renamed from: ak */
    public String mo10605ak() {
        return getStringFromAdObject("text_rewarded_inter_alert_body", "");
    }

    /* renamed from: al */
    public String mo10606al() {
        return getStringFromAdObject("text_rewarded_inter_alert_ok_action", "OK!");
    }

    /* renamed from: am */
    public List<C1093a> mo10607am() {
        List<C1093a> postbacks;
        List<C1093a> list = this.f1418f;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("video_end_urls", this.adObject, getClCode(), mo9313d(), this.sdk);
            this.f1418f = postbacks;
        }
        return postbacks;
    }

    /* renamed from: an */
    public List<C1093a> mo10608an() {
        List<C1093a> postbacks;
        List<C1093a> list = this.f1419g;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("ad_closed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.f1419g = postbacks;
        }
        return postbacks;
    }

    /* renamed from: ao */
    public List<C1093a> mo10609ao() {
        List<C1093a> postbacks;
        List<C1093a> list = this.f1420h;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("app_killed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.f1420h = postbacks;
        }
        return postbacks;
    }

    /* renamed from: ap */
    public List<C1093a> mo9310ap() {
        List<C1093a> postbacks;
        List<C1093a> list = this.f1421i;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("imp_urls", this.adObject, getClCode(), CollectionUtils.map(Utils.SHOWN_OUT_OF_CONTEXT_MACRO, String.valueOf(mo10602ah())), (String) null, mo10610aq(), mo10633w(), this.sdk);
            this.f1421i = postbacks;
        }
        return postbacks;
    }

    /* renamed from: aq */
    public Map<String, String> mo10610aq() {
        HashMap hashMap = new HashMap();
        if (getBooleanFromAdObject("send_webview_http_headers", Boolean.FALSE)) {
            hashMap.putAll(C1046ac.m1444b());
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", Boolean.FALSE)) {
            hashMap.put(GraphRequest.USER_AGENT_HEADER, C1046ac.m1440a());
        }
        return hashMap;
    }

    /* renamed from: ar */
    public boolean mo10611ar() {
        return getBooleanFromAdObject("playback_requires_user_action", Boolean.TRUE);
    }

    /* renamed from: as */
    public String mo10612as() {
        String stringFromAdObject = getStringFromAdObject("base_url", "/");
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    /* renamed from: at */
    public boolean mo10613at() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", Boolean.FALSE);
    }

    /* renamed from: au */
    public C0785v mo10614au() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", (JSONObject) null);
        if (jsonObjectFromAdObject != null) {
            return new C0785v(jsonObjectFromAdObject);
        }
        return null;
    }

    /* renamed from: av */
    public int mo10615av() {
        return getIntFromAdObject("whalt", Utils.isBML(getSize()) ? 1 : ((Boolean) this.sdk.mo10946a(C1085b.f1768eQ)).booleanValue() ? 0 : -1);
    }

    /* renamed from: aw */
    public List<String> mo10616aw() {
        return CollectionUtils.explode(getStringFromAdObject("wls", ""));
    }

    /* renamed from: ax */
    public List<String> mo10617ax() {
        return CollectionUtils.explode(getStringFromAdObject("wlh", (String) null));
    }

    /* renamed from: ay */
    public Uri mo10618ay() {
        String stringFromAdObject = getStringFromAdObject("mute_image", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: az */
    public Uri mo10619az() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: b */
    public void mo10620b(Uri uri) {
        this.f1413a.add(uri);
    }

    /* renamed from: b */
    public void mo10621b(boolean z) {
        this.f1417e = z;
    }

    /* renamed from: c */
    public abstract String mo9312c();

    /* renamed from: c */
    public void mo10622c(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putObject(this.adObject, "mute_image", uri);
        }
    }

    /* renamed from: d */
    public void mo10623d(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putObject(this.adObject, "unmute_image", uri);
        }
    }

    /* renamed from: e */
    public boolean mo9314e() {
        this.sdk.mo10922B().mo11376e("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
        return false;
    }

    /* renamed from: g */
    public Uri mo9317g() {
        this.sdk.mo10922B().mo11376e("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
        return null;
    }

    @Nullable
    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", (String) null);
    }

    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        return Collections.emptyList();
    }

    /* renamed from: i */
    public Uri mo9324i() {
        this.sdk.mo10922B().mo11376e("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
        return null;
    }

    public abstract boolean isOpenMeasurementEnabled();

    /* renamed from: j */
    public Uri mo9326j() {
        this.sdk.mo10922B().mo11376e("DirectAd", "Attempting to invoke getVideoClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: n */
    public C1060b mo10624n() {
        C1060b bVar = C1060b.DEFAULT;
        String upperCase = getStringFromAdObject("ad_target", "a").toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? C1060b.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? C1060b.ACTIVITY_LANDSCAPE : C1060b.DEFAULT;
    }

    /* renamed from: o */
    public long mo10625o() {
        return getLongFromAdObject("close_delay", 0);
    }

    /* renamed from: p */
    public long mo10626p() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5));
    }

    /* renamed from: q */
    public long mo10627q() {
        List<Integer> r = mo10628r();
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", (r == null || r.size() <= 0) ? 0 : (long) r.get(0).intValue());
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0;
        }
        return longFromAdObject;
    }

    @Nullable
    /* renamed from: r */
    public List<Integer> mo10628r() {
        return getIntegerListFromAdObject("multi_close_delay_graphic", (List<Integer>) null);
    }

    /* renamed from: s */
    public C0752i.C0753a mo10629s() {
        List<Integer> b = mo9311b();
        int intFromAdObject = getIntFromAdObject("close_style", (b == null || b.size() <= 0) ? -1 : b.get(0).intValue());
        return intFromAdObject == -1 ? m1492c(hasVideoUrl()) : mo10581a(intFromAdObject);
    }

    @Nullable
    /* renamed from: t */
    public List<C0752i.C0753a> mo10630t() {
        List<Integer> b = mo9311b();
        if (b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(b.size());
        for (Integer intValue : b) {
            arrayList.add(mo10581a(intValue.intValue()));
        }
        return arrayList;
    }

    /* renamed from: u */
    public C0752i.C0753a mo10631u() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? mo10629s() : mo10581a(intFromAdObject);
    }

    /* renamed from: v */
    public boolean mo10632v() {
        return getBooleanFromAdObject("dismiss_on_skip", Boolean.FALSE);
    }

    /* renamed from: w */
    public boolean mo10633w() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", Boolean.FALSE);
    }

    /* renamed from: x */
    public boolean mo10634x() {
        return getBooleanFromAdObject("html_resources_cached", Boolean.FALSE);
    }

    /* renamed from: y */
    public List<Uri> mo10635y() {
        return this.f1413a;
    }

    /* renamed from: z */
    public String mo10636z() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("video_button_properties", (JSONObject) null);
        return jsonObjectFromAdObject != null ? JsonUtils.getString(jsonObjectFromAdObject, "video_button_html", "") : "";
    }
}
