package com.applovin.impl.sdk.p027c;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.c.d */
public class C1087d<T> {

    /* renamed from: A */
    public static final C1087d<String> f1814A;

    /* renamed from: B */
    public static final C1087d<String> f1815B;

    /* renamed from: C */
    public static final C1087d<String> f1816C;

    /* renamed from: D */
    public static final C1087d<Boolean> f1817D;

    /* renamed from: a */
    public static final C1087d<String> f1818a;

    /* renamed from: b */
    public static final C1087d<Boolean> f1819b;

    /* renamed from: c */
    public static final C1087d<String> f1820c;

    /* renamed from: d */
    public static final C1087d<Long> f1821d = new C1087d<>("com.applovin.sdk.install_date", Long.class);

    /* renamed from: e */
    public static final C1087d<String> f1822e;

    /* renamed from: f */
    public static final C1087d<String> f1823f;

    /* renamed from: g */
    public static final C1087d<String> f1824g;

    /* renamed from: h */
    public static final C1087d<String> f1825h;

    /* renamed from: i */
    public static final C1087d<String> f1826i;

    /* renamed from: j */
    public static final C1087d<String> f1827j;

    /* renamed from: k */
    public static final C1087d<Boolean> f1828k;

    /* renamed from: l */
    public static final C1087d<Boolean> f1829l;

    /* renamed from: m */
    public static final C1087d<Boolean> f1830m;

    /* renamed from: n */
    public static final C1087d<String> f1831n;

    /* renamed from: o */
    public static final C1087d<?> f1832o = new C1087d<>("IABTCF_gdprApplies", Object.class);

    /* renamed from: p */
    public static final C1087d<HashSet> f1833p = new C1087d<>("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);

    /* renamed from: q */
    public static final C1087d<String> f1834q;

    /* renamed from: r */
    public static final C1087d<HashSet> f1835r = new C1087d<>("com.applovin.sdk.task.stats", HashSet.class);

    /* renamed from: s */
    public static final C1087d<String> f1836s;

    /* renamed from: t */
    public static final C1087d<String> f1837t;

    /* renamed from: u */
    public static final C1087d<String> f1838u;

    /* renamed from: v */
    public static final C1087d<HashSet> f1839v = new C1087d<>("com.applovin.sdk.ad.stats", HashSet.class);

    /* renamed from: w */
    public static final C1087d<Integer> f1840w = new C1087d<>("com.applovin.sdk.last_video_position", Integer.class);

    /* renamed from: x */
    public static final C1087d<Boolean> f1841x;

    /* renamed from: y */
    public static final C1087d<String> f1842y;

    /* renamed from: z */
    public static final C1087d<String> f1843z;

    /* renamed from: E */
    public final String f1844E;

    /* renamed from: F */
    public final Class<T> f1845F;

    static {
        Class<Boolean> cls = Boolean.class;
        Class<String> cls2 = String.class;
        f1818a = new C1087d<>("com.applovin.sdk.impl.isFirstRun", cls2);
        f1819b = new C1087d<>("com.applovin.sdk.launched_before", cls);
        f1820c = new C1087d<>("com.applovin.sdk.latest_installed_version", cls2);
        f1822e = new C1087d<>("com.applovin.sdk.user_id", cls2);
        f1823f = new C1087d<>("com.applovin.sdk.compass_id", cls2);
        f1824g = new C1087d<>("com.applovin.sdk.compass_random_token", cls2);
        f1825h = new C1087d<>("com.applovin.sdk.applovin_random_token", cls2);
        f1826i = new C1087d<>("com.applovin.sdk.device_test_group", cls2);
        f1827j = new C1087d<>("com.applovin.sdk.variables", cls2);
        f1828k = new C1087d<>("com.applovin.sdk.compliance.has_user_consent", cls);
        f1829l = new C1087d<>("com.applovin.sdk.compliance.is_age_restricted_user", cls);
        f1830m = new C1087d<>("com.applovin.sdk.compliance.is_do_not_sell", cls);
        f1831n = new C1087d<>("IABTCF_TCString", cls2);
        f1834q = new C1087d<>("com.applovin.sdk.stats", cls2);
        f1836s = new C1087d<>("com.applovin.sdk.network_response_code_mapping", cls2);
        f1837t = new C1087d<>("com.applovin.sdk.event_tracking.super_properties", cls2);
        f1838u = new C1087d<>("com.applovin.sdk.request_tracker.counter", cls2);
        f1841x = new C1087d<>("com.applovin.sdk.should_resume_video", cls);
        f1842y = new C1087d<>("com.applovin.sdk.mediation.signal_providers", cls2);
        f1843z = new C1087d<>("com.applovin.sdk.mediation.auto_init_adapters", cls2);
        f1814A = new C1087d<>("com.applovin.sdk.persisted_data", cls2);
        f1815B = new C1087d<>("com.applovin.sdk.mediation_provider", cls2);
        f1816C = new C1087d<>("com.applovin.sdk.mediation.test_mode_network", cls2);
        f1817D = new C1087d<>("com.applovin.sdk.mediation.test_mode_enabled", cls);
    }

    public C1087d(String str, Class<T> cls) {
        this.f1844E = str;
        this.f1845F = cls;
    }

    /* renamed from: a */
    public String mo10687a() {
        return this.f1844E;
    }

    /* renamed from: b */
    public Class<T> mo10688b() {
        return this.f1845F;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Key{name='");
        GeneratedOutlineSupport.outline33(outline24, this.f1844E, '\'', ", type=");
        outline24.append(this.f1845F);
        outline24.append('}');
        return outline24.toString();
    }
}
