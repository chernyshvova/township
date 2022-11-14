package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.network.C1226g;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.vungle.warren.log.LogEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventServiceImpl implements AppLovinEventService {

    /* renamed from: a */
    public final C1188m f1280a;

    /* renamed from: b */
    public final Map<String, Object> f1281b;

    /* renamed from: c */
    public final AtomicBoolean f1282c = new AtomicBoolean();

    public EventServiceImpl(C1188m mVar) {
        this.f1280a = mVar;
        if (((Boolean) mVar.mo10946a(C1085b.f1632bk)).booleanValue()) {
            this.f1281b = JsonUtils.toStringObjectMap((String) this.f1280a.mo10978b(C1087d.f1837t, JsonUtils.EMPTY_JSON), new HashMap());
            return;
        }
        this.f1281b = new HashMap();
        mVar.mo10953a(C1087d.f1837t, JsonUtils.EMPTY_JSON);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m1358a() {
        return GeneratedOutlineSupport.outline18(new StringBuilder(), (String) this.f1280a.mo10946a(C1085b.f1623bb), "4.0/pix");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m1361a(C1246q qVar, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        boolean contains = this.f1280a.mo10980b(C1085b.f1630bi).contains(qVar.mo11231a());
        hashMap.put("AppLovin-Event", contains ? qVar.mo11231a() : "postinstall");
        if (!contains) {
            hashMap.put("AppLovin-Sub-Event", qVar.mo11231a());
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m1362a(C1246q qVar, boolean z) {
        boolean contains = this.f1280a.mo10980b(C1085b.f1630bi).contains(qVar.mo11231a());
        Map<String, Object> a = this.f1280a.mo10941V().mo11205a((Map<String, String>) null, z, false);
        a.put("event", contains ? qVar.mo11231a() : "postinstall");
        a.put(LogEntry.LOG_ITEM_EVENT_ID, qVar.mo11234d());
        a.put("ts", Long.toString(qVar.mo11233c()));
        if (!contains) {
            a.put("sub_event", qVar.mo11231a());
        }
        return Utils.stringifyObjectMap(a);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m1363b() {
        return GeneratedOutlineSupport.outline18(new StringBuilder(), (String) this.f1280a.mo10946a(C1085b.f1624bc), "4.0/pix");
    }

    /* renamed from: c */
    private void m1366c() {
        if (((Boolean) this.f1280a.mo10946a(C1085b.f1632bk)).booleanValue()) {
            this.f1280a.mo10953a(C1087d.f1837t, CollectionUtils.toJsonString(this.f1281b, JsonUtils.EMPTY_JSON));
        }
    }

    public Map<String, Object> getSuperProperties() {
        return new HashMap(this.f1281b);
    }

    public void maybeTrackAppOpenEvent() {
        if (this.f1282c.compareAndSet(false, true)) {
            this.f1280a.mo11007w().trackEvent("landing");
        }
    }

    public void setSuperProperty(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            C1314v.m2663i("AppLovinEventService", "Super property key cannot be null or empty");
        } else if (obj == null) {
            this.f1281b.remove(str);
            m1366c();
        } else {
            List<String> b = this.f1280a.mo10980b(C1085b.f1631bj);
            if (!Utils.objectIsOfType(obj, b, this.f1280a)) {
                C1314v.m2663i("AppLovinEventService", "Failed to set super property '" + obj + "' for key '" + str + "' - valid super property types include: " + b);
                return;
            }
            this.f1281b.put(str, Utils.sanitizeSuperProperty(obj, this.f1280a));
            m1366c();
        }
    }

    public String toString() {
        return "EventService{}";
    }

    public void trackCheckout(String str, Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap(1);
        }
        hashMap.put("transaction_id", str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, hashMap);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, (Map<String, String>) null);
    }

    public void trackEvent(String str, Map<String, String> map, final Map<String, String> map2) {
        C1314v B = this.f1280a.mo10922B();
        B.mo11372b("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
        final C1246q qVar = new C1246q(str, map, this.f1281b);
        try {
            this.f1280a.mo10938S().mo10829a((C1109a) new C1166z(this.f1280a, new Runnable() {
                public void run() {
                    EventServiceImpl.this.f1280a.mo10940U().mo11145a(C1226g.m2290o().mo11174c(EventServiceImpl.this.m1358a()).mo11177d(EventServiceImpl.this.m1363b()).mo11168a((Map<String, String>) EventServiceImpl.this.m1362a(qVar, false)).mo11172b((Map<String, String>) EventServiceImpl.this.m1361a(qVar, (Map<String, String>) map2)).mo11175c(qVar.mo11232b()).mo11173b(((Boolean) EventServiceImpl.this.f1280a.mo10946a(C1085b.f1754eC)).booleanValue()).mo11169a(((Boolean) EventServiceImpl.this.f1280a.mo10946a(C1085b.f1797et)).booleanValue()).mo11170a());
                }
            }), C1140o.C1142a.BACKGROUND);
        } catch (Throwable th) {
            C1314v B2 = this.f1280a.mo10922B();
            B2.mo11373b("AppLovinEventService", "Unable to track event: " + qVar, th);
        }
    }

    public void trackEventSynchronously(String str) {
        C1314v B = this.f1280a.mo10922B();
        B.mo11372b("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        C1246q qVar = new C1246q(str, new HashMap(), this.f1281b);
        this.f1280a.mo10940U().mo11145a(C1226g.m2290o().mo11174c(m1358a()).mo11177d(m1363b()).mo11168a(m1362a(qVar, true)).mo11172b(m1361a(qVar, (Map<String, String>) null)).mo11175c(qVar.mo11232b()).mo11173b(((Boolean) this.f1280a.mo10946a(C1085b.f1754eC)).booleanValue()).mo11169a(((Boolean) this.f1280a.mo10946a(C1085b.f1797et)).booleanValue()).mo11170a());
    }

    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        }
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            C1314v.m2659c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
        }
        trackEvent("iap", hashMap);
    }
}
