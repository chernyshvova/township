package com.applovin.impl.p007a;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.p007a.C0648m;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p024a.C1023g;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1093a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.a */
public class C0631a extends C1057e {

    /* renamed from: a */
    public final String f58a;

    /* renamed from: b */
    public final String f59b;

    /* renamed from: c */
    public final C0644i f60c;

    /* renamed from: d */
    public final long f61d;

    /* renamed from: e */
    public final C0648m f62e;

    /* renamed from: f */
    public final C0638d f63f;

    /* renamed from: g */
    public final String f64g;

    /* renamed from: h */
    public final C0637c f65h;

    /* renamed from: i */
    public final C1023g f66i;

    /* renamed from: j */
    public final Set<C0645j> f67j;

    /* renamed from: k */
    public final Set<C0645j> f68k;

    /* renamed from: com.applovin.impl.a.a$a */
    public static class C0633a {

        /* renamed from: a */
        public JSONObject f69a;

        /* renamed from: b */
        public JSONObject f70b;

        /* renamed from: c */
        public C1053b f71c;

        /* renamed from: d */
        public C1188m f72d;

        /* renamed from: e */
        public long f73e;

        /* renamed from: f */
        public String f74f;

        /* renamed from: g */
        public String f75g;

        /* renamed from: h */
        public C0644i f76h;

        /* renamed from: i */
        public C0648m f77i;

        /* renamed from: j */
        public C0638d f78j;

        /* renamed from: k */
        public C0637c f79k;

        /* renamed from: l */
        public Set<C0645j> f80l;

        /* renamed from: m */
        public Set<C0645j> f81m;

        /* renamed from: a */
        public C0633a mo9331a(long j) {
            this.f73e = j;
            return this;
        }

        /* renamed from: a */
        public C0633a mo9332a(C0637c cVar) {
            this.f79k = cVar;
            return this;
        }

        /* renamed from: a */
        public C0633a mo9333a(C0638d dVar) {
            this.f78j = dVar;
            return this;
        }

        /* renamed from: a */
        public C0633a mo9334a(C0644i iVar) {
            this.f76h = iVar;
            return this;
        }

        /* renamed from: a */
        public C0633a mo9335a(C0648m mVar) {
            this.f77i = mVar;
            return this;
        }

        /* renamed from: a */
        public C0633a mo9336a(C1053b bVar) {
            this.f71c = bVar;
            return this;
        }

        /* renamed from: a */
        public C0633a mo9337a(C1188m mVar) {
            if (mVar != null) {
                this.f72d = mVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        /* renamed from: a */
        public C0633a mo9338a(String str) {
            this.f74f = str;
            return this;
        }

        /* renamed from: a */
        public C0633a mo9339a(Set<C0645j> set) {
            this.f80l = set;
            return this;
        }

        /* renamed from: a */
        public C0633a mo9340a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f69a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        /* renamed from: a */
        public C0631a mo9341a() {
            return new C0631a(this);
        }

        /* renamed from: b */
        public C0633a mo9342b(String str) {
            this.f75g = str;
            return this;
        }

        /* renamed from: b */
        public C0633a mo9343b(Set<C0645j> set) {
            this.f81m = set;
            return this;
        }

        /* renamed from: b */
        public C0633a mo9344b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f70b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }
    }

    /* renamed from: com.applovin.impl.a.a$b */
    public enum C0634b {
        COMPANION_AD,
        VIDEO
    }

    /* renamed from: com.applovin.impl.a.a$c */
    public enum C0635c {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        ERROR
    }

    public C0631a(C0633a aVar) {
        super(aVar.f69a, aVar.f70b, aVar.f71c, aVar.f72d);
        this.f58a = aVar.f74f;
        this.f60c = aVar.f76h;
        this.f59b = aVar.f75g;
        this.f62e = aVar.f77i;
        this.f63f = aVar.f78j;
        this.f65h = aVar.f79k;
        this.f67j = aVar.f80l;
        this.f68k = aVar.f81m;
        this.f66i = new C1023g(this);
        Uri g = mo9317g();
        this.f64g = g != null ? g.toString() : "";
        this.f61d = aVar.f73e;
    }

    /* renamed from: a */
    private Set<C0645j> m46a(C0634b bVar, String[] strArr) {
        C0638d dVar;
        C0648m mVar;
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptySet();
        }
        Map<String, Set<C0645j>> map = null;
        if (bVar == C0634b.VIDEO && (mVar = this.f62e) != null) {
            map = mVar.mo9400e();
        } else if (bVar == C0634b.COMPANION_AD && (dVar = this.f63f) != null) {
            map = dVar.mo9359d();
        }
        HashSet hashSet = new HashSet();
        if (map != null && !map.isEmpty()) {
            for (String str : strArr) {
                if (map.containsKey(str)) {
                    hashSet.addAll(map.get(str));
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: aR */
    private String m47aR() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace(Utils.MACRO_CLCODE, getClCode());
        }
        return null;
    }

    /* renamed from: aS */
    private C0648m.C0650a m48aS() {
        C0648m.C0650a[] values = C0648m.C0650a.values();
        int intValue = ((Integer) this.sdk.mo10946a(C1085b.f1794eq)).intValue();
        return (intValue < 0 || intValue >= values.length) ? C0648m.C0650a.UNSPECIFIED : values[intValue];
    }

    /* renamed from: aT */
    private Set<C0645j> m49aT() {
        C0648m mVar = this.f62e;
        return mVar != null ? mVar.mo9399d() : Collections.emptySet();
    }

    /* renamed from: aU */
    private Set<C0645j> m50aU() {
        C0638d dVar = this.f63f;
        return dVar != null ? dVar.mo9358c() : Collections.emptySet();
    }

    /* renamed from: B */
    public boolean mo9297B() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE) && mo9324i() != null;
    }

    /* renamed from: a */
    public Set<C0645j> mo9298a(C0635c cVar, String str) {
        return mo9299a(cVar, new String[]{str});
    }

    /* renamed from: a */
    public Set<C0645j> mo9299a(C0635c cVar, String[] strArr) {
        C1314v B = this.sdk.mo10922B();
        B.mo11372b("VastAd", "Retrieving trackers of type '" + cVar + "' and events '" + strArr + "'...");
        if (cVar == C0635c.IMPRESSION) {
            return this.f67j;
        }
        if (cVar == C0635c.VIDEO_CLICK) {
            return m49aT();
        }
        if (cVar == C0635c.COMPANION_CLICK) {
            return m50aU();
        }
        if (cVar == C0635c.VIDEO) {
            return m46a(C0634b.VIDEO, strArr);
        }
        if (cVar == C0635c.COMPANION) {
            return m46a(C0634b.COMPANION_AD, strArr);
        }
        if (cVar == C0635c.ERROR) {
            return this.f68k;
        }
        C1314v B2 = this.sdk.mo10922B();
        B2.mo11376e("VastAd", "Failed to retrieve trackers of invalid type '" + cVar + "' and events '" + strArr + "'");
        return Collections.emptySet();
    }

    /* renamed from: a */
    public void mo9300a() {
    }

    /* renamed from: a */
    public void mo9301a(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    /* renamed from: aJ */
    public C0651n mo9302aJ() {
        C0648m mVar = this.f62e;
        if (mVar != null) {
            return mVar.mo9395a(m48aS());
        }
        return null;
    }

    /* renamed from: aK */
    public C0638d mo9303aK() {
        return this.f63f;
    }

    /* renamed from: aL */
    public boolean mo9304aL() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", Boolean.FALSE);
    }

    /* renamed from: aM */
    public String mo9305aM() {
        return getStringFromAdObject("html_template", "");
    }

    /* renamed from: aN */
    public Uri mo9306aN() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aO */
    public boolean mo9307aO() {
        return getBooleanFromAdObject("cache_companion_ad", Boolean.TRUE);
    }

    /* renamed from: aP */
    public boolean mo9308aP() {
        return getBooleanFromAdObject("cache_video", Boolean.TRUE);
    }

    @Nullable
    /* renamed from: aQ */
    public C0637c mo9309aQ() {
        return this.f65h;
    }

    /* renamed from: ap */
    public List<C1093a> mo9310ap() {
        List<C1093a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("vimp_urls", this.adObject, getClCode(), CollectionUtils.map(Utils.SHOWN_OUT_OF_CONTEXT_MACRO, String.valueOf(mo10602ah())), m47aR(), mo10610aq(), mo10633w(), this.sdk);
        }
        return postbacks;
    }

    /* renamed from: b */
    public void mo9311b() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    /* renamed from: c */
    public String mo9312c() {
        return this.f64g;
    }

    /* renamed from: d */
    public C1023g getAdEventTracker() {
        return this.f66i;
    }

    /* renamed from: e */
    public boolean mo9314e() {
        return getBooleanFromAdObject("vast_is_streaming", Boolean.FALSE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0631a) || !super.equals(obj)) {
            return false;
        }
        C0631a aVar = (C0631a) obj;
        String str = this.f58a;
        if (str == null ? aVar.f58a != null : !str.equals(aVar.f58a)) {
            return false;
        }
        String str2 = this.f59b;
        if (str2 == null ? aVar.f59b != null : !str2.equals(aVar.f59b)) {
            return false;
        }
        C0644i iVar = this.f60c;
        if (iVar == null ? aVar.f60c != null : !iVar.equals(aVar.f60c)) {
            return false;
        }
        C0648m mVar = this.f62e;
        if (mVar == null ? aVar.f62e != null : !mVar.equals(aVar.f62e)) {
            return false;
        }
        C0638d dVar = this.f63f;
        if (dVar == null ? aVar.f63f != null : !dVar.equals(aVar.f63f)) {
            return false;
        }
        C0637c cVar = this.f65h;
        if (cVar == null ? aVar.f65h != null : !cVar.equals(aVar.f65h)) {
            return false;
        }
        Set<C0645j> set = this.f67j;
        if (set == null ? aVar.f67j != null : !set.equals(aVar.f67j)) {
            return false;
        }
        Set<C0645j> set2 = this.f68k;
        Set<C0645j> set3 = aVar.f68k;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    /* renamed from: f */
    public long mo9316f() {
        return getLongFromAdObject("real_close_delay", 0);
    }

    /* renamed from: g */
    public Uri mo9317g() {
        C0651n aJ = mo9302aJ();
        if (aJ != null) {
            return aJ.mo9408b();
        }
        return null;
    }

    public long getCreatedAtMillis() {
        return this.f61d;
    }

    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    /* renamed from: h */
    public C0634b mo9321h() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? C0634b.COMPANION_AD : C0634b.VIDEO;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.mo9396a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasVideoUrl() {
        /*
            r2 = this;
            com.applovin.impl.a.m r0 = r2.f62e
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = r0.mo9396a()
            if (r0 == 0) goto L_0x0012
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0012
            r1 = 1
        L_0x0012:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.p007a.C0631a.hasVideoUrl():boolean");
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f58a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f59b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        C0644i iVar = this.f60c;
        int hashCode4 = (hashCode3 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        C0648m mVar = this.f62e;
        int hashCode5 = (hashCode4 + (mVar != null ? mVar.hashCode() : 0)) * 31;
        C0638d dVar = this.f63f;
        int hashCode6 = (hashCode5 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        C0637c cVar = this.f65h;
        int hashCode7 = (hashCode6 + (cVar != null ? cVar.hashCode() : 0)) * 31;
        Set<C0645j> set = this.f67j;
        int hashCode8 = (hashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set<C0645j> set2 = this.f68k;
        if (set2 != null) {
            i = set2.hashCode();
        }
        return hashCode8 + i;
    }

    /* renamed from: i */
    public Uri mo9324i() {
        C0648m mVar = this.f62e;
        if (mVar != null) {
            return mVar.mo9398c();
        }
        return null;
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", Boolean.TRUE) && this.f65h != null;
    }

    /* renamed from: j */
    public Uri mo9326j() {
        return mo9324i();
    }

    /* renamed from: k */
    public boolean mo9327k() {
        return getBooleanFromAdObject("vast_immediate_ad_load", Boolean.TRUE);
    }

    /* renamed from: l */
    public C0644i mo9328l() {
        return this.f60c;
    }

    /* renamed from: m */
    public C0648m mo9329m() {
        return this.f62e;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastAd{title='");
        GeneratedOutlineSupport.outline33(outline24, this.f58a, '\'', ", adDescription='");
        GeneratedOutlineSupport.outline33(outline24, this.f59b, '\'', ", systemInfo=");
        outline24.append(this.f60c);
        outline24.append(", videoCreative=");
        outline24.append(this.f62e);
        outline24.append(", companionAd=");
        outline24.append(this.f63f);
        outline24.append(", adVerifications=");
        outline24.append(this.f65h);
        outline24.append(", impressionTrackers=");
        outline24.append(this.f67j);
        outline24.append(", errorTrackers=");
        outline24.append(this.f68k);
        outline24.append('}');
        return outline24.toString();
    }
}
