package com.applovin.impl.mediation.p011b;

import android.content.Context;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0807g;
import com.applovin.impl.mediation.p010a.C0809h;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.applinks.FacebookAppLinkResolver;
import com.facebook.internal.FetchedAppGateKeepersManager;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.b */
public class C0845b extends C1109a {

    /* renamed from: a */
    public static String f718a;

    /* renamed from: c */
    public final MaxAdFormat f719c;

    /* renamed from: d */
    public final Map<String, Object> f720d;

    /* renamed from: e */
    public final Context f721e;

    /* renamed from: f */
    public final C0849a f722f;

    /* renamed from: com.applovin.impl.mediation.b.b$a */
    public interface C0849a {
        /* renamed from: a */
        void mo10006a(JSONArray jSONArray);
    }

    static {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m853a("APPLOVIN_NETWORK", "com.applovin.mediation.adapters.AppLovinMediationAdapter"));
            m853a("FACEBOOK_NETWORK", "com.applovin.mediation.adapters.FacebookMediationAdapter").put("run_on_ui_thread", false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signal_providers", jSONArray);
            f718a = jSONObject.toString();
        } catch (JSONException unused) {
        }
    }

    public C0845b(MaxAdFormat maxAdFormat, Map<String, Object> map, Context context, C1188m mVar, C0849a aVar) {
        super("TaskCollectSignals", mVar);
        this.f719c = maxAdFormat;
        this.f720d = map;
        this.f721e = context;
        this.f722f = aVar;
    }

    /* renamed from: a */
    public static JSONObject m853a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put(FacebookAppLinkResolver.APP_LINK_TARGET_CLASS_KEY, str2);
        jSONObject.put("adapter_timeout_ms", 30000);
        jSONObject.put("max_signal_length", 32768);
        jSONObject.put("scode", "");
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m854a(final C0809h hVar, final C0807g.C0808a aVar) {
        C08482 r0 = new Runnable() {
            public void run() {
                C0845b.this.f1961b.mo10925E().collectSignal(C0845b.this.f719c, hVar, C0845b.this.f721e, aVar);
            }
        };
        if (hVar.mo9904V()) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Running signal collection for ");
            outline24.append(hVar.mo9898P());
            outline24.append(" on the main thread");
            mo10768a(outline24.toString());
            AppLovinSdkUtils.runOnUiThread(r0);
            return;
        }
        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Running signal collection for ");
        outline242.append(hVar.mo9898P());
        outline242.append(" on the background thread");
        mo10768a(outline242.toString());
        r0.run();
    }

    /* renamed from: a */
    private void m856a(Collection<C0807g> collection) {
        String str;
        String d;
        JSONArray jSONArray = new JSONArray();
        for (C0807g next : collection) {
            try {
                JSONObject jSONObject = new JSONObject();
                C0809h a = next.mo9934a();
                jSONObject.put("name", a.mo9898P());
                jSONObject.put(FacebookAppLinkResolver.APP_LINK_TARGET_CLASS_KEY, a.mo9897O());
                jSONObject.put("adapter_version", next.mo9936c());
                jSONObject.put(FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, next.mo9935b());
                JSONObject jSONObject2 = new JSONObject();
                if (StringUtils.isValidString(next.mo9938e())) {
                    str = "error_message";
                    d = next.mo9938e();
                } else {
                    str = "signal";
                    d = next.mo9937d();
                }
                jSONObject2.put(str, d);
                jSONObject.put("data", jSONObject2);
                jSONArray.put(jSONObject);
                mo10768a("Collected signal from " + a);
            } catch (JSONException e) {
                mo10769a("Failed to create signal data", e);
            }
        }
        m857a(jSONArray);
    }

    /* renamed from: a */
    private void m857a(JSONArray jSONArray) {
        C0849a aVar = this.f722f;
        if (aVar != null) {
            aVar.mo10006a(jSONArray);
        }
    }

    /* renamed from: a */
    private void m858a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        List synchronizedList = CollectionUtils.synchronizedList(jSONArray.length());
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        CountDownLatch countDownLatch = new CountDownLatch(jSONArray.length());
        ScheduledExecutorService b = this.f1961b.mo10938S().mo10833b();
        for (int i = 0; i < jSONArray.length(); i++) {
            final C0809h hVar = new C0809h(this.f720d, jSONArray.getJSONObject(i), jSONObject, this.f1961b);
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            final List list = synchronizedList;
            final CountDownLatch countDownLatch2 = countDownLatch;
            b.execute(new Runnable() {
                public void run() {
                    C0845b.this.m854a(hVar, (C0807g.C0808a) new C0807g.C0808a() {
                        /* renamed from: a */
                        public void mo9940a(C0807g gVar) {
                            if (atomicBoolean2.get() && gVar != null) {
                                list.add(gVar);
                            }
                            countDownLatch2.countDown();
                        }
                    });
                }
            });
        }
        countDownLatch.await(((Long) this.f1961b.mo10946a(C1084a.f1528k)).longValue(), TimeUnit.MILLISECONDS);
        atomicBoolean.set(false);
        m856a((Collection<C0807g>) synchronizedList);
    }

    /* renamed from: b */
    private void m860b(String str, Throwable th) {
        mo10769a("No signals collected: " + str, th);
        m857a(new JSONArray());
    }

    public void run() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject((String) this.f1961b.mo10978b(C1087d.f1842y, f718a));
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", (JSONArray) null);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    m858a(jSONArray, jSONObject);
                    return;
                }
            }
            m860b("No signal providers found", (Throwable) null);
        } catch (JSONException e) {
            th = e;
            str = "Failed to parse signals JSON";
            m860b(str, th);
        } catch (InterruptedException e2) {
            th = e2;
            str = "Failed to wait for signals";
            m860b(str, th);
        } catch (Throwable th) {
            th = th;
            str = "Failed to collect signals";
            m860b(str, th);
        }
    }
}
