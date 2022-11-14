package com.applovin.impl.mediation.p011b;

import android.net.Uri;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p010a.C0806f;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1226g;
import com.applovin.impl.sdk.network.C1229h;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.d */
public class C0852d extends C1109a {

    /* renamed from: a */
    public final String f740a;

    /* renamed from: c */
    public final String f741c;

    /* renamed from: d */
    public final C0806f f742d;

    /* renamed from: e */
    public final Map<String, String> f743e;

    /* renamed from: f */
    public final Map<String, String> f744f;

    /* renamed from: g */
    public final MaxError f745g;

    public C0852d(String str, Map<String, String> map, MaxError maxError, C0806f fVar, C1188m mVar) {
        super("TaskFireMediationPostbacks", mVar);
        this.f740a = str;
        this.f741c = GeneratedOutlineSupport.outline16(str, "_urls");
        this.f743e = Utils.toUrlSafeMap(map);
        this.f745g = maxError != null ? maxError : new MaxErrorImpl(-1);
        this.f742d = fVar;
        HashMap hashMap = new HashMap(7);
        hashMap.put("AppLovin-Event-Type", str);
        hashMap.put("AppLovin-Ad-Network-Name", fVar.mo9898P());
        if (fVar instanceof C0801a) {
            C0801a aVar = (C0801a) fVar;
            hashMap.put("AppLovin-Ad-Unit-Id", aVar.getAdUnitId());
            hashMap.put("AppLovin-Ad-Format", aVar.getFormat().getLabel());
            hashMap.put("AppLovin-Third-Party-Ad-Placement-ID", aVar.mo9849m());
        }
        if (maxError != null) {
            hashMap.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            hashMap.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.f744f = hashMap;
    }

    /* renamed from: a */
    private String m883a(String str, MaxError maxError) {
        int i;
        String str2;
        if (maxError instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            i = maxAdapterError.getThirdPartySdkErrorCode();
            str2 = maxAdapterError.getThirdPartySdkErrorMessage();
        } else {
            i = 0;
            str2 = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUrlString(maxError.getMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(i)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUrlString(str2));
    }

    /* renamed from: a */
    private List<String> m884a(List<String> list, Map<String, String> map, Map<String, String> map2, MaxError maxError) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (String next2 : map.keySet()) {
                next = next.replace(next2, this.f742d.mo9931g(map.get(next2)));
            }
            arrayList.add(m883a(m889b(next, map2), maxError));
        }
        return arrayList;
    }

    /* renamed from: a */
    private Map<String, String> m885a() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.f1961b.mo10946a(C1084a.f1526i)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    /* renamed from: a */
    private void m887a(String str, Map<String, Object> map) {
        mo10772d().mo10940U().mo11145a(C1226g.m2290o().mo11174c(str).mo11171b("POST").mo11172b(this.f744f).mo11169a(false).mo11175c(map).mo11173b(((Boolean) this.f1961b.mo10946a(C1084a.f1518ab)).booleanValue()).mo11170a());
    }

    /* renamed from: a */
    private void m888a(List<String> list) {
        if (!list.isEmpty()) {
            for (String c : list) {
                mo10772d().mo10940U().mo11145a(C1226g.m2290o().mo11174c(c).mo11169a(false).mo11172b(this.f744f).mo11170a());
            }
        }
    }

    /* renamed from: b */
    private String m889b(String str, Map<String, String> map) {
        for (String next : map.keySet()) {
            str = str.replace(next, StringUtils.emptyIfNull(map.get(next)));
        }
        return str;
    }

    /* renamed from: b */
    private void m890b(List<String> list) {
        if (!list.isEmpty()) {
            for (String d : list) {
                mo10772d().mo10943X().dispatchPostbackRequest(C1229h.m2326b(mo10772d()).mo11127a(d).mo11138c(false).mo11134b(this.f744f).mo11131a(), C1140o.C1142a.MEDIATION_POSTBACKS, new AppLovinPostbackListener() {
                    public void onPostbackFailure(String str, int i) {
                        C0852d dVar = C0852d.this;
                        dVar.mo10773d("Failed to fire postback with code: " + i + " and url: " + str);
                    }

                    public void onPostbackSuccess(String str) {
                    }
                });
            }
        }
    }

    public void run() {
        List<String> f = this.f742d.mo9930f(this.f741c);
        Map<String, String> a = m885a();
        if (((Boolean) mo10772d().mo10946a(C1084a.f1510U)).booleanValue()) {
            for (String b : f) {
                Uri parse = Uri.parse(m883a(m889b(b, this.f743e), this.f745g));
                Uri.Builder clearQuery = parse.buildUpon().clearQuery();
                HashMap hashMap = new HashMap(a.size());
                for (String next : parse.getQueryParameterNames()) {
                    String queryParameter = parse.getQueryParameter(next);
                    if (a.containsKey(queryParameter)) {
                        hashMap.put(next, this.f742d.mo9931g(a.get(queryParameter)));
                    } else {
                        clearQuery.appendQueryParameter(next, queryParameter);
                    }
                }
                m887a(clearQuery.build().toString(), (Map<String, Object>) hashMap);
            }
            return;
        }
        List<String> a2 = m884a(f, a, this.f743e, this.f745g);
        if (((Boolean) mo10772d().mo10946a(C1084a.f1527j)).booleanValue()) {
            m888a(a2);
        } else {
            m890b(a2);
        }
    }
}
