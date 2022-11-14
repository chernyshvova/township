package com.applovin.impl.p007a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1226g;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.l */
public class C0647l {

    /* renamed from: a */
    public static final DateFormat f146a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    /* renamed from: b */
    public static final Random f147b = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static Uri m142a(String str, long j, Uri uri, C0640f fVar, C1188m mVar) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String num = Integer.toString(fVar.mo9371a());
                String replace = str.replace("[ERRORCODE]", num).replace("[REASON]", num);
                if (j >= 0) {
                    replace = replace.replace("[CONTENTPLAYHEAD]", m145a(j));
                }
                if (uri != null) {
                    replace = replace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(replace.replace("[CACHEBUSTING]", m144a()).replace("[TIMESTAMP]", m157b()));
            } catch (Throwable th) {
                C1314v B = mVar.mo10922B();
                B.mo11373b("VastUtils", "Unable to replace macros in URL string " + str, th);
                return null;
            }
        } else {
            mVar.mo10922B().mo11376e("VastUtils", "Unable to replace macros in invalid URL string.");
            return null;
        }
    }

    /* renamed from: a */
    public static C0640f m143a(C0631a aVar) {
        if (m158b(aVar) || m160c(aVar)) {
            return null;
        }
        return C0640f.GENERAL_WRAPPER_ERROR;
    }

    /* renamed from: a */
    public static String m144a() {
        return Integer.toString(f147b.nextInt(89999999) + 10000000);
    }

    /* renamed from: a */
    public static String m145a(long j) {
        if (j <= 0) {
            return "00:00:00.000";
        }
        long hours = TimeUnit.SECONDS.toHours(j);
        long seconds = j % TimeUnit.MINUTES.toSeconds(1);
        return String.format(Locale.US, "%02d:%02d:%02d.000", new Object[]{Long.valueOf(hours), Long.valueOf(TimeUnit.SECONDS.toMinutes(j) % TimeUnit.MINUTES.toSeconds(1)), Long.valueOf(seconds)});
    }

    /* renamed from: a */
    public static String m146a(C0639e eVar) {
        C1310q c;
        if (eVar != null) {
            List<C1310q> b = eVar.mo9364b();
            int size = eVar.mo9364b().size();
            if (size <= 0 || (c = b.get(size - 1).mo11352c("VASTAdTagURI")) == null) {
                return null;
            }
            return c.mo11353c();
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    /* renamed from: a */
    public static String m147a(C1310q qVar, String str, String str2) {
        C1310q b = qVar.mo11350b(str);
        if (b != null) {
            String c = b.mo11353c();
            if (StringUtils.isValidString(c)) {
                return c;
            }
        }
        return str2;
    }

    /* renamed from: a */
    public static Set<C0645j> m148a(C0639e eVar, C1188m mVar) {
        if (eVar == null) {
            return null;
        }
        List<C1310q> b = eVar.mo9364b();
        Set<C0645j> hashSet = new HashSet<>(b.size());
        for (C1310q next : b) {
            C1310q c = next.mo11352c("Wrapper");
            if (c == null) {
                c = next.mo11352c("InLine");
            }
            hashSet = m149a(hashSet, c != null ? c.mo11349a("Error") : next.mo11349a("Error"), eVar, mVar);
        }
        C1314v B = mVar.mo10922B();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Retrieved ");
        outline24.append(hashSet.size());
        outline24.append(" top level error trackers: ");
        outline24.append(hashSet);
        B.mo11372b("VastUtils", outline24.toString());
        return hashSet;
    }

    /* renamed from: a */
    public static Set<C0645j> m149a(Set<C0645j> set, List<C1310q> list, C0639e eVar, C1188m mVar) {
        if (list != null) {
            for (C1310q a : list) {
                C0645j a2 = C0645j.m138a(a, eVar, mVar);
                if (a2 != null) {
                    set.add(a2);
                }
            }
        }
        return set;
    }

    /* renamed from: a */
    public static void m150a(C0639e eVar, AppLovinAdLoadListener appLovinAdLoadListener, C0640f fVar, int i, C1188m mVar) {
        if (mVar != null) {
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
            }
            m154a(m148a(eVar, mVar), fVar, mVar);
            return;
        }
        throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
    }

    /* renamed from: a */
    public static void m151a(C1310q qVar, Map<String, Set<C0645j>> map, C0639e eVar, C1188m mVar) {
        List<C1310q> a;
        C1314v B;
        String str;
        if (mVar != null) {
            if (qVar == null) {
                B = mVar.mo10922B();
                str = "Unable to render event trackers; null node provided";
            } else if (map == null) {
                B = mVar.mo10922B();
                str = "Unable to render event trackers; null event trackers provided";
            } else {
                C1310q b = qVar.mo11350b("TrackingEvents");
                if (b != null && (a = b.mo11349a("Tracking")) != null) {
                    for (C1310q next : a) {
                        String str2 = next.mo11351b().get("event");
                        if (StringUtils.isValidString(str2)) {
                            C0645j a2 = C0645j.m138a(next, eVar, mVar);
                            if (a2 != null) {
                                Set set = map.get(str2);
                                if (set != null) {
                                    set.add(a2);
                                } else {
                                    HashSet hashSet = new HashSet();
                                    hashSet.add(a2);
                                    map.put(str2, hashSet);
                                }
                            }
                        } else {
                            C1314v B2 = mVar.mo10922B();
                            B2.mo11376e("VastUtils", "Could not find event for tracking node = " + next);
                        }
                    }
                    return;
                }
                return;
            }
            B.mo11376e("VastUtils", str);
            return;
        }
        throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m152a(List<C1310q> list, Set<C0645j> set, C0639e eVar, C1188m mVar) {
        C1314v B;
        String str;
        if (mVar != null) {
            if (list == null) {
                B = mVar.mo10922B();
                str = "Unable to render trackers; null nodes provided";
            } else if (set == null) {
                B = mVar.mo10922B();
                str = "Unable to render trackers; null trackers provided";
            } else {
                for (C1310q a : list) {
                    C0645j a2 = C0645j.m138a(a, eVar, mVar);
                    if (a2 != null) {
                        set.add(a2);
                    }
                }
                return;
            }
            B.mo11376e("VastUtils", str);
            return;
        }
        throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m153a(Set<C0645j> set, long j, Uri uri, C0640f fVar, C1188m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        } else if (set != null && !set.isEmpty()) {
            for (C0645j b : set) {
                Uri a = m142a(b.mo9391b(), j, uri, fVar, mVar);
                if (a != null) {
                    mVar.mo10940U().mo11146a(C1226g.m2290o().mo11174c(a.toString()).mo11169a(false).mo11170a(), false);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m154a(Set<C0645j> set, C0640f fVar, C1188m mVar) {
        m153a(set, -1, (Uri) null, fVar, mVar);
    }

    /* renamed from: a */
    public static void m155a(Set<C0645j> set, C1188m mVar) {
        m153a(set, -1, (Uri) null, C0640f.UNSPECIFIED, mVar);
    }

    /* renamed from: a */
    public static boolean m156a(C1310q qVar) {
        if (qVar != null) {
            return qVar.mo11352c("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    /* renamed from: b */
    public static String m157b() {
        f146a.setTimeZone(TimeZone.getDefault());
        return f146a.format(new Date());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r1 = (r1 = r1.mo9329m()).mo9396a();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m158b(com.applovin.impl.p007a.C0631a r1) {
        /*
            r0 = 0
            if (r1 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.applovin.impl.a.m r1 = r1.mo9329m()
            if (r1 == 0) goto L_0x0017
            java.util.List r1 = r1.mo9396a()
            if (r1 == 0) goto L_0x0017
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0017
            r0 = 1
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.p007a.C0647l.m158b(com.applovin.impl.a.a):boolean");
    }

    /* renamed from: b */
    public static boolean m159b(C1310q qVar) {
        if (qVar != null) {
            return qVar.mo11352c("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    /* renamed from: c */
    public static boolean m160c(C0631a aVar) {
        C0638d aK;
        C0642h b;
        if (aVar == null || (aK = aVar.mo9303aK()) == null || (b = aK.mo9357b()) == null) {
            return false;
        }
        return b.mo9380b() != null || StringUtils.isValidString(b.mo9381c());
    }
}
