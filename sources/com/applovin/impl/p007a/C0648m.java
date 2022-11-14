package com.applovin.impl.p007a;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.m */
public class C0648m {

    /* renamed from: a */
    public List<C0651n> f148a = Collections.emptyList();

    /* renamed from: b */
    public List<String> f149b = Collections.emptyList();

    /* renamed from: c */
    public int f150c;

    /* renamed from: d */
    public Uri f151d;

    /* renamed from: e */
    public final Set<C0645j> f152e = new HashSet();

    /* renamed from: f */
    public final Map<String, Set<C0645j>> f153f = new HashMap();

    /* renamed from: com.applovin.impl.a.m$a */
    public enum C0650a {
        UNSPECIFIED,
        LOW,
        MEDIUM,
        HIGH
    }

    public C0648m() {
    }

    public C0648m(C0639e eVar) {
        this.f149b = eVar.mo9369g();
    }

    /* renamed from: a */
    public static int m161a(String str, C1188m mVar) {
        try {
            List<String> explode = CollectionUtils.explode(str, CertificateUtil.DELIMITER);
            if (explode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds((long) StringUtils.parseInt(explode.get(0))) + TimeUnit.MINUTES.toSeconds((long) StringUtils.parseInt(explode.get(1))) + ((long) StringUtils.parseInt(explode.get(2))));
            }
        } catch (Throwable unused) {
            C1314v B = mVar.mo10922B();
            B.mo11376e("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
        }
        return 0;
    }

    /* renamed from: a */
    public static C0648m m162a(C1310q qVar, C0648m mVar, C0639e eVar, C1188m mVar2) {
        C1310q b;
        List<C0651n> a;
        C1310q b2;
        int a2;
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (eVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (mVar2 != null) {
            if (mVar == null) {
                try {
                    mVar = new C0648m(eVar);
                } catch (Throwable th) {
                    mVar2.mo10922B().mo11373b("VastVideoCreative", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (mVar.f150c == 0 && (b2 = qVar.mo11350b("Duration")) != null && (a2 = m161a(b2.mo11353c(), mVar2)) > 0) {
                mVar.f150c = a2;
            }
            C1310q b3 = qVar.mo11350b("MediaFiles");
            if (!(b3 == null || (a = m163a(b3, mVar2)) == null || a.size() <= 0)) {
                if (mVar.f148a != null) {
                    a.addAll(mVar.f148a);
                }
                mVar.f148a = a;
            }
            C1310q b4 = qVar.mo11350b("VideoClicks");
            if (b4 != null) {
                if (mVar.f151d == null && (b = b4.mo11350b("ClickThrough")) != null) {
                    String c = b.mo11353c();
                    if (StringUtils.isValidString(c)) {
                        mVar.f151d = Uri.parse(c);
                    }
                }
                C0647l.m152a(b4.mo11349a("ClickTracking"), mVar.f152e, eVar, mVar2);
            }
            C0647l.m151a(qVar, mVar.f153f, eVar, mVar2);
            return mVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public static List<C0651n> m163a(C1310q qVar, C1188m mVar) {
        List<C1310q> a = qVar.mo11349a("MediaFile");
        ArrayList arrayList = new ArrayList(a.size());
        List<String> explode = CollectionUtils.explode((String) mVar.mo10946a(C1085b.f1792eo));
        List<String> explode2 = CollectionUtils.explode((String) mVar.mo10946a(C1085b.f1791en));
        for (C1310q a2 : a) {
            C0651n a3 = C0651n.m172a(a2, mVar);
            if (a3 != null) {
                try {
                    String c = a3.mo9409c();
                    if (!StringUtils.isValidString(c) || explode.contains(c)) {
                        if (((Boolean) mVar.mo10946a(C1085b.f1793ep)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a3.mo9408b().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !explode2.contains(fileExtensionFromUrl)) {
                            }
                        }
                        C1314v B = mVar.mo10922B();
                        B.mo11375d("VastVideoCreative", "Video file not supported: " + a3);
                    }
                    arrayList.add(a3);
                } catch (Throwable th) {
                    C1314v B2 = mVar.mo10922B();
                    B2.mo11373b("VastVideoCreative", "Failed to validate video file: " + a3, th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C0651n mo9395a(C0650a aVar) {
        List<C0651n> list = this.f148a;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(3);
        for (String next : this.f149b) {
            for (C0651n next2 : this.f148a) {
                String c = next2.mo9409c();
                if (StringUtils.isValidString(c) && next.equalsIgnoreCase(c)) {
                    arrayList.add(next2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        boolean isEmpty = arrayList.isEmpty();
        List list2 = arrayList;
        if (isEmpty) {
            list2 = this.f148a;
        }
        if (C1263g.m2507c()) {
            Collections.sort(list2, new Comparator<C0651n>() {
                @TargetApi(19)
                /* renamed from: a */
                public int compare(C0651n nVar, C0651n nVar2) {
                    return Integer.compare(nVar.mo9410d(), nVar2.mo9410d());
                }
            });
        }
        return (C0651n) list2.get(aVar == C0650a.LOW ? 0 : aVar == C0650a.MEDIUM ? list2.size() / 2 : list2.size() - 1);
    }

    /* renamed from: a */
    public List<C0651n> mo9396a() {
        return this.f148a;
    }

    /* renamed from: b */
    public int mo9397b() {
        return this.f150c;
    }

    /* renamed from: c */
    public Uri mo9398c() {
        return this.f151d;
    }

    /* renamed from: d */
    public Set<C0645j> mo9399d() {
        return this.f152e;
    }

    /* renamed from: e */
    public Map<String, Set<C0645j>> mo9400e() {
        return this.f153f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0648m)) {
            return false;
        }
        C0648m mVar = (C0648m) obj;
        if (this.f150c != mVar.f150c) {
            return false;
        }
        List<C0651n> list = this.f148a;
        if (list == null ? mVar.f148a != null : !list.equals(mVar.f148a)) {
            return false;
        }
        Uri uri = this.f151d;
        if (uri == null ? mVar.f151d != null : !uri.equals(mVar.f151d)) {
            return false;
        }
        Set<C0645j> set = this.f152e;
        if (set == null ? mVar.f152e != null : !set.equals(mVar.f152e)) {
            return false;
        }
        Map<String, Set<C0645j>> map = this.f153f;
        Map<String, Set<C0645j>> map2 = mVar.f153f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        List<C0651n> list = this.f148a;
        int i = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f150c) * 31;
        Uri uri = this.f151d;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<C0645j> set = this.f152e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C0645j>> map = this.f153f;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastVideoCreative{videoFiles=");
        outline24.append(this.f148a);
        outline24.append(", durationSeconds=");
        outline24.append(this.f150c);
        outline24.append(", destinationUri=");
        outline24.append(this.f151d);
        outline24.append(", clickTrackers=");
        outline24.append(this.f152e);
        outline24.append(", eventTrackers=");
        outline24.append(this.f153f);
        outline24.append('}');
        return outline24.toString();
    }
}
