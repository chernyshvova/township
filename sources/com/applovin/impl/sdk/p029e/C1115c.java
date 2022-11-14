package com.applovin.impl.sdk.p029e;

import android.net.Uri;
import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.C0996h;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1247r;
import com.applovin.impl.sdk.network.C1213b;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1101d;
import com.applovin.impl.sdk.p028d.C1102e;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.vungle.warren.analytics.AnalyticsEvent;
import com.vungle.warren.model.Advertisement;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.sdk.e.c */
public abstract class C1115c extends C1109a implements C0996h.C0997a {

    /* renamed from: a */
    public final C1057e f1969a;

    /* renamed from: c */
    public AppLovinAdLoadListener f1970c;

    /* renamed from: d */
    public final C1247r f1971d;

    /* renamed from: e */
    public final Collection<Character> f1972e;

    /* renamed from: f */
    public final C1102e f1973f;

    /* renamed from: g */
    public boolean f1974g;

    public C1115c(String str, C1057e eVar, C1188m mVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, mVar);
        if (eVar != null) {
            this.f1969a = eVar;
            this.f1970c = appLovinAdLoadListener;
            this.f1971d = mVar.mo10963aa();
            this.f1972e = m1832j();
            this.f1973f = new C1102e();
            return;
        }
        throw new IllegalArgumentException("No ad specified.");
    }

    /* renamed from: a */
    private Uri m1827a(Uri uri, String str) {
        String str2;
        StringBuilder sb;
        if (uri != null) {
            String uri2 = uri.toString();
            if (StringUtils.isValidString(uri2)) {
                mo10768a("Caching " + str + " image...");
                return m1831g(uri2);
            }
            sb = new StringBuilder();
            sb.append("Failed to cache ");
            sb.append(str);
            str2 = " image";
        } else {
            sb = new StringBuilder();
            sb.append("No ");
            sb.append(str);
            str2 = " image to cache";
        }
        sb.append(str2);
        mo10768a(sb.toString());
        return null;
    }

    /* renamed from: a */
    private Uri m1828a(String str, String str2) {
        StringBuilder sb;
        String replace = str2.replace("/", "_");
        String G = this.f1969a.mo10561G();
        if (StringUtils.isValidString(G)) {
            replace = GeneratedOutlineSupport.outline16(G, replace);
        }
        File a = this.f1971d.mo11240a(replace, this.f1961b.mo10932L());
        if (a == null) {
            return null;
        }
        if (a.exists()) {
            this.f1973f.mo10745b(a.length());
            sb = new StringBuilder();
        } else {
            if (!this.f1971d.mo11245a(a, GeneratedOutlineSupport.outline16(str, str2), (List<String>) Arrays.asList(new String[]{str}), this.f1973f)) {
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append(Advertisement.FILE_SCHEME);
        sb.append(a.getAbsolutePath());
        return Uri.parse(sb.toString());
    }

    /* renamed from: g */
    private Uri m1831g(String str) {
        return mo10789b(str, this.f1969a.mo10560F(), true);
    }

    /* renamed from: j */
    private Collection<Character> m1832j() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.f1961b.mo10946a(C1085b.f1640bs)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* renamed from: a */
    public Uri mo10784a(String str, List<String> list, boolean z) {
        String str2;
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        mo10768a("Caching video " + str + "...");
        String a = this.f1971d.mo11241a(mo10775f(), str, this.f1969a.mo10561G(), list, z, this.f1973f);
        if (StringUtils.isValidString(a)) {
            File a2 = this.f1971d.mo11240a(a, mo10775f());
            if (a2 != null) {
                Uri fromFile = Uri.fromFile(a2);
                if (fromFile != null) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Finish caching video for ad #");
                    outline24.append(this.f1969a.getAdIdNumber());
                    outline24.append(". Updating ad with cachedVideoFilename = ");
                    outline24.append(a);
                    mo10768a(outline24.toString());
                    return fromFile;
                }
                str2 = "Unable to create URI from cached video file = " + a2;
            } else {
                str2 = GeneratedOutlineSupport.outline17("Unable to cache video = ", str, "Video file was missing or null");
            }
            mo10773d(str2);
            return null;
        }
        mo10773d("Failed to cache video");
        mo10794h();
        Bundle bundle = new Bundle();
        bundle.putLong("ad_id", this.f1969a.getAdIdNumber());
        bundle.putInt("load_response_code", this.f1973f.mo10754j());
        Exception i = this.f1973f.mo10753i();
        if (i != null) {
            bundle.putString("load_exception_message", i.getMessage());
        }
        this.f1961b.mo10969ag().mo10893a(bundle, "video_caching_failed");
        return null;
    }

    /* renamed from: a */
    public String mo10785a(String str, List<String> list) {
        if (StringUtils.isValidString(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                mo10768a("Nothing to cache, skipping...");
                return null;
            }
            String lastPathSegment = parse.getLastPathSegment();
            if (StringUtils.isValidString(this.f1969a.mo10561G())) {
                lastPathSegment = this.f1969a.mo10561G() + lastPathSegment;
            }
            File a = this.f1971d.mo11240a(lastPathSegment, mo10775f());
            ByteArrayOutputStream a2 = (a == null || !a.exists()) ? null : this.f1971d.mo11238a(a);
            if (a2 == null) {
                a2 = this.f1971d.mo11239a(str, list, true, this.f1973f);
                if (a2 != null) {
                    this.f1971d.mo11244a(a2, a);
                    this.f1973f.mo10743a((long) a2.size());
                }
            } else {
                this.f1973f.mo10745b((long) a2.size());
            }
            try {
                return a2.toString("UTF-8");
            } catch (UnsupportedEncodingException e) {
                mo10769a("UTF-8 encoding not supported.", e);
            } catch (Throwable th) {
                mo10769a("String resource at " + str + " failed to load.", th);
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo10786a(String str, List<String> list, C1057e eVar) {
        StringBuilder sb;
        if (!StringUtils.isValidString(str)) {
            return str;
        }
        if (!((Boolean) this.f1961b.mo10946a(C1085b.f1641bt)).booleanValue()) {
            mo10768a("Resource caching is disabled, skipping cache...");
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str);
        boolean shouldCancelHtmlCachingIfShown = eVar.shouldCancelHtmlCachingIfShown();
        boolean aH = eVar.mo10593aH();
        List<String> E = eVar.mo10559E();
        for (String next : list) {
            int i = 0;
            int i2 = 0;
            while (i < sb2.length()) {
                if (mo10790b()) {
                    return str;
                }
                i = sb2.indexOf(next, i2);
                if (i == -1) {
                    continue;
                    break;
                }
                int length = sb2.length();
                int i3 = i;
                while (!this.f1972e.contains(Character.valueOf(sb2.charAt(i3))) && i3 < length) {
                    i3++;
                }
                if (i3 <= i || i3 == length) {
                    mo10773d("Unable to cache resource; ad HTML is invalid.");
                    return str;
                }
                String substring = sb2.substring(next.length() + i, i3);
                if (!StringUtils.isValidString(substring)) {
                    sb = new StringBuilder();
                    sb.append("Skip caching of non-resource ");
                } else if (!shouldCancelHtmlCachingIfShown || !eVar.hasShown()) {
                    if (aH) {
                        String c = eVar.mo9312c();
                        if (c.equals(next + substring)) {
                            sb = new StringBuilder();
                            sb.append("Postponing caching for \"");
                            sb.append(substring);
                            substring = "\" video resource";
                        }
                    }
                    Uri a = m1828a(next, substring);
                    if (a != null) {
                        sb2.replace(i, i3, a.toString());
                        eVar.mo10620b(a);
                        this.f1973f.mo10749e();
                    } else {
                        if (E.contains(next + substring)) {
                            mo10794h();
                            this.f1974g = true;
                        }
                        this.f1973f.mo10750f();
                    }
                    i2 = i3;
                } else {
                    mo10768a("Cancelling HTML caching due to ad being shown already");
                    this.f1973f.mo10741a();
                    return str;
                }
                sb.append(substring);
                mo10768a(sb.toString());
                i2 = i3;
            }
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public void mo10787a() {
        this.f1961b.mo10928H().mo10348b(this);
    }

    /* renamed from: a */
    public void mo10349a(C0801a aVar) {
        if (aVar.mo9833f().equalsIgnoreCase(this.f1969a.mo10563I())) {
            mo10773d("Updating flag for timeout...");
            this.f1974g = true;
        }
        this.f1961b.mo10928H().mo10348b(this);
    }

    /* renamed from: a */
    public void mo10788a(AppLovinAdBase appLovinAdBase) {
        C1101d.m1739a(this.f1973f, appLovinAdBase, this.f1961b);
    }

    /* renamed from: b */
    public Uri mo10789b(String str, List<String> list, boolean z) {
        String str2;
        try {
            String a = this.f1971d.mo11241a(mo10775f(), str, this.f1969a.mo10561G(), list, z, this.f1973f);
            if (!StringUtils.isValidString(a)) {
                return null;
            }
            File a2 = this.f1971d.mo11240a(a, mo10775f());
            if (a2 != null) {
                Uri fromFile = Uri.fromFile(a2);
                if (fromFile != null) {
                    return fromFile;
                }
                str2 = "Unable to extract Uri from image file";
            } else {
                str2 = "Unable to retrieve File from cached image filename = " + a;
            }
            mo10773d(str2);
            return null;
        } catch (Throwable th) {
            mo10769a("Failed to cache image at url = " + str, th);
            return null;
        }
    }

    /* renamed from: b */
    public boolean mo10790b() {
        return this.f1974g;
    }

    /* renamed from: c */
    public void mo10791c() {
        mo10768a("Caching mute images...");
        Uri a = m1827a(this.f1969a.mo10618ay(), AnalyticsEvent.C1956Ad.mute);
        if (a != null) {
            this.f1969a.mo10622c(a);
        }
        Uri a2 = m1827a(this.f1969a.mo10619az(), AnalyticsEvent.C1956Ad.unmute);
        if (a2 != null) {
            this.f1969a.mo10623d(a2);
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Ad updated with muteImageFilename = ");
        outline24.append(this.f1969a.mo10618ay());
        outline24.append(", unmuteImageFilename = ");
        outline24.append(this.f1969a.mo10619az());
        mo10768a(outline24.toString());
    }

    /* renamed from: e */
    public Uri mo10792e(String str) {
        return mo10784a(str, this.f1969a.mo10560F(), true);
    }

    /* renamed from: f */
    public String mo10793f(final String str) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        C1217c a = C1217c.m2223a(this.f1961b).mo11127a(str).mo11133b("GET").mo11126a("").mo11125a(0).mo11131a();
        final AtomicReference atomicReference = new AtomicReference((Object) null);
        this.f1961b.mo10937R().mo11095a(a, new C1213b.C1214a(), new C1213b.C1216c<String>() {
            /* renamed from: a */
            public void mo10008a(int i, String str, String str2) {
                C1115c cVar = C1115c.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to load resource from '");
                outline24.append(str);
                outline24.append("'");
                cVar.mo10773d(outline24.toString());
            }

            /* renamed from: a */
            public void mo10010a(String str, int i) {
                atomicReference.set(str);
            }
        });
        String str2 = (String) atomicReference.get();
        if (str2 != null) {
            this.f1973f.mo10743a((long) str2.length());
        }
        return str2;
    }

    /* renamed from: h */
    public void mo10794h() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f1970c;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            this.f1970c = null;
        }
    }

    /* renamed from: i */
    public void mo10795i() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rendered new ad:");
        outline24.append(this.f1969a);
        mo10768a(outline24.toString());
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C1115c.this.f1970c != null) {
                    C1115c.this.f1970c.adReceived(C1115c.this.f1969a);
                    AppLovinAdLoadListener unused = C1115c.this.f1970c = null;
                }
            }
        });
    }

    public void run() {
        if (this.f1969a.mo10562H()) {
            mo10768a("Subscribing to timeout events...");
            this.f1961b.mo10928H().mo10347a((C0996h.C0997a) this);
        }
    }
}
