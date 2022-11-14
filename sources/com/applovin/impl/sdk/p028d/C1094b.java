package com.applovin.impl.sdk.p028d;

import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.d.b */
public class C1094b {

    /* renamed from: A */
    public static final C1094b f1863A = m1703a("wvhec", "WEB_VIEW_HTTP_ERROR_COUNT");

    /* renamed from: B */
    public static final C1094b f1864B = m1703a("wvrec", "WEB_VIEW_RENDER_ERROR_COUNT");

    /* renamed from: C */
    public static final C1094b f1865C = m1703a("wvsem", "WEB_VIEW_SSL_ERROR_MESSAGES");

    /* renamed from: D */
    public static final C1094b f1866D = m1703a("wvruc", "WEB_VIEW_RENDERER_UNRESPONSIVE_COUNT");

    /* renamed from: G */
    public static final Set<String> f1867G = new HashSet(32);

    /* renamed from: a */
    public static final C1094b f1868a = m1703a("sas", "AD_SOURCE");

    /* renamed from: b */
    public static final C1094b f1869b = m1703a("srt", "AD_RENDER_TIME");

    /* renamed from: c */
    public static final C1094b f1870c = m1703a("sft", "AD_FETCH_TIME");

    /* renamed from: d */
    public static final C1094b f1871d = m1703a("sfs", "AD_FETCH_SIZE");

    /* renamed from: e */
    public static final C1094b f1872e = m1703a("sadb", "AD_DOWNLOADED_BYTES");

    /* renamed from: f */
    public static final C1094b f1873f = m1703a("sacb", "AD_CACHED_BYTES");

    /* renamed from: g */
    public static final C1094b f1874g = m1703a("stdl", "TIME_TO_DISPLAY_FROM_LOAD");

    /* renamed from: h */
    public static final C1094b f1875h = m1703a("stdi", "TIME_TO_DISPLAY_FROM_INIT");

    /* renamed from: i */
    public static final C1094b f1876i = m1703a("snas", "AD_NUMBER_IN_SESSION");

    /* renamed from: j */
    public static final C1094b f1877j = m1703a("snat", "AD_NUMBER_TOTAL");

    /* renamed from: k */
    public static final C1094b f1878k = m1703a("stah", "TIME_AD_HIDDEN_FROM_SHOW");

    /* renamed from: l */
    public static final C1094b f1879l = m1703a("stas", "TIME_TO_SKIP_FROM_SHOW");

    /* renamed from: m */
    public static final C1094b f1880m = m1703a("stac", "TIME_TO_CLICK_FROM_SHOW");

    /* renamed from: n */
    public static final C1094b f1881n = m1703a("stbe", "TIME_TO_EXPAND_FROM_SHOW");

    /* renamed from: o */
    public static final C1094b f1882o = m1703a("stbc", "TIME_TO_CONTRACT_FROM_SHOW");

    /* renamed from: p */
    public static final C1094b f1883p = m1703a("saan", "AD_SHOWN_WITH_ACTIVE_NETWORK");

    /* renamed from: q */
    public static final C1094b f1884q = m1703a("suvs", "INTERSTITIAL_USED_VIDEO_STREAM");

    /* renamed from: r */
    public static final C1094b f1885r = m1703a("sugs", "AD_USED_GRAPHIC_STREAM");

    /* renamed from: s */
    public static final C1094b f1886s = m1703a("svpv", "INTERSTITIAL_VIDEO_PERCENT_VIEWED");

    /* renamed from: t */
    public static final C1094b f1887t = m1703a("stpd", "INTERSTITIAL_PAUSED_DURATION");

    /* renamed from: u */
    public static final C1094b f1888u = m1703a("shsc", "HTML_RESOURCE_CACHE_SUCCESS_COUNT");

    /* renamed from: v */
    public static final C1094b f1889v = m1703a("shfc", "HTML_RESOURCE_CACHE_FAILURE_COUNT");

    /* renamed from: w */
    public static final C1094b f1890w = m1703a("schc", "AD_CANCELLED_HTML_CACHING");

    /* renamed from: x */
    public static final C1094b f1891x = m1703a("smwm", "AD_SHOWN_IN_MULTIWINDOW_MODE");

    /* renamed from: y */
    public static final C1094b f1892y = m1703a("vssc", "VIDEO_STREAM_STALLED_COUNT");

    /* renamed from: z */
    public static final C1094b f1893z = m1703a("wvem", "WEB_VIEW_ERROR_MESSAGES");

    /* renamed from: E */
    public final String f1894E;

    /* renamed from: F */
    public final String f1895F;

    static {
        m1703a("sisw", "IS_STREAMING_WEBKIT");
        m1703a("surw", "UNABLE_TO_RETRIEVE_WEBKIT_HTML_STRING");
        m1703a("surp", "UNABLE_TO_PERSIST_WEBKIT_HTML_PLACEMENT_REPLACED_STRING");
        m1703a("swhp", "SUCCESSFULLY_PERSISTED_WEBKIT_HTML_STRING");
        m1703a("skr", "STOREKIT_REDIRECTED");
        m1703a("sklf", "STOREKIT_LOAD_FAILURE");
        m1703a("skps", "STOREKIT_PRELOAD_SKIPPED");
    }

    public C1094b(String str, String str2) {
        this.f1894E = str;
        this.f1895F = str2;
    }

    /* renamed from: a */
    public static C1094b m1703a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        } else if (f1867G.contains(str)) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("Key has already been used: ", str));
        } else if (!TextUtils.isEmpty(str2)) {
            f1867G.add(str);
            return new C1094b(str, str2);
        } else {
            throw new IllegalArgumentException("No debug name specified");
        }
    }

    /* renamed from: a */
    public String mo10715a() {
        return this.f1894E;
    }

    /* renamed from: b */
    public String mo10716b() {
        return this.f1895F;
    }
}
