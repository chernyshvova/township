package com.applovin.impl.sdk.p028d;

import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.d.f */
public class C1103f {

    /* renamed from: a */
    public static final C1103f f1923a = m1765a("ad_req");

    /* renamed from: b */
    public static final C1103f f1924b = m1765a("ad_imp");

    /* renamed from: c */
    public static final C1103f f1925c = m1765a("ad_session_start");

    /* renamed from: d */
    public static final C1103f f1926d = m1765a("ad_imp_session");

    /* renamed from: e */
    public static final C1103f f1927e = m1765a("cached_files_expired");

    /* renamed from: f */
    public static final C1103f f1928f = m1765a("cache_drop_count");

    /* renamed from: g */
    public static final C1103f f1929g = m1766a("sdk_reset_state_count", true);

    /* renamed from: h */
    public static final C1103f f1930h = m1766a("ad_response_process_failures", true);

    /* renamed from: i */
    public static final C1103f f1931i = m1766a("response_process_failures", true);

    /* renamed from: j */
    public static final C1103f f1932j = m1766a("incent_failed_to_display_count", true);

    /* renamed from: k */
    public static final C1103f f1933k = m1765a("app_paused_and_resumed");

    /* renamed from: l */
    public static final C1103f f1934l = m1766a("ad_rendered_with_mismatched_sdk_key", true);

    /* renamed from: m */
    public static final C1103f f1935m = m1765a("ad_shown_outside_app_count");

    /* renamed from: n */
    public static final C1103f f1936n = m1765a("med_ad_req");

    /* renamed from: o */
    public static final C1103f f1937o = m1766a("med_ad_response_process_failures", true);

    /* renamed from: p */
    public static final C1103f f1938p = m1766a("med_waterfall_ad_no_fill", true);

    /* renamed from: q */
    public static final C1103f f1939q = m1766a("med_waterfall_ad_adapter_load_failed", true);

    /* renamed from: r */
    public static final C1103f f1940r = m1766a("med_waterfall_ad_invalid_response", true);

    /* renamed from: s */
    public static final Set<String> f1941s = new HashSet(32);

    /* renamed from: u */
    public static final Set<C1103f> f1942u = new HashSet(16);

    /* renamed from: t */
    public final String f1943t;

    static {
        m1765a("fullscreen_ad_nil_vc_count");
        m1765a("applovin_bundle_missing");
    }

    public C1103f(String str) {
        this.f1943t = str;
    }

    /* renamed from: a */
    public static C1103f m1765a(String str) {
        return m1766a(str, false);
    }

    /* renamed from: a */
    public static C1103f m1766a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        } else if (!f1941s.contains(str)) {
            f1941s.add(str);
            C1103f fVar = new C1103f(str);
            if (z) {
                f1942u.add(fVar);
            }
            return fVar;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("Key has already been used: ", str));
        }
    }

    /* renamed from: b */
    public static Set<C1103f> m1767b() {
        return f1942u;
    }

    /* renamed from: a */
    public String mo10756a() {
        return this.f1943t;
    }
}
