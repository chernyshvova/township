package com.iab.omid.library.vungle.walking.p055a;

import com.iab.omid.library.vungle.adsession.C2889a;
import com.iab.omid.library.vungle.p051b.C2891a;
import com.iab.omid.library.vungle.p051b.C2896e;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.walking.p055a.C2917b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.walking.a.e */
public class C2922e extends C2916a {
    public C2922e(C2917b.C2919b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        AdSessionStatePublisher.C2907a aVar;
        C2891a aVar2 = C2891a.f3501a;
        if (aVar2 != null) {
            for (C2889a next : aVar2.mo36837b()) {
                if (this.f3561a.contains(next.f3499i)) {
                    AdSessionStatePublisher adSessionStatePublisher = next.f3496f;
                    if (this.f3563c >= adSessionStatePublisher.f3528e && adSessionStatePublisher.f3527d != (aVar = AdSessionStatePublisher.C2907a.AD_STATE_NOTVISIBLE)) {
                        adSessionStatePublisher.f3527d = aVar;
                        C2896e.f3510a.mo36849a(adSessionStatePublisher.getWebView(), "setNativeViewHierarchy", str);
                    }
                }
            }
        }
        C2917b.C2918a aVar3 = this.f3564a;
        if (aVar3 != null) {
            C2920c cVar = (C2920c) aVar3;
            cVar.f3569d = null;
            cVar.mo36869a();
        }
    }

    public Object doInBackground(Object[] objArr) {
        return this.f3562b.toString();
    }
}
