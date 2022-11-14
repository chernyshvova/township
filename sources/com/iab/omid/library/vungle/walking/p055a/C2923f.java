package com.iab.omid.library.vungle.walking.p055a;

import android.text.TextUtils;
import com.iab.omid.library.vungle.adsession.C2889a;
import com.iab.omid.library.vungle.p051b.C2891a;
import com.iab.omid.library.vungle.p051b.C2896e;
import com.iab.omid.library.vungle.p053d.C2904b;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.walking.C2924b;
import com.iab.omid.library.vungle.walking.p055a.C2917b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.walking.a.f */
public class C2923f extends C2916a {
    public C2923f(C2917b.C2919b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        C2891a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = C2891a.f3501a) != null) {
            for (C2889a next : aVar.mo36837b()) {
                if (this.f3561a.contains(next.f3499i)) {
                    AdSessionStatePublisher adSessionStatePublisher = next.f3496f;
                    if (this.f3563c >= adSessionStatePublisher.f3528e) {
                        adSessionStatePublisher.f3527d = AdSessionStatePublisher.C2907a.AD_STATE_VISIBLE;
                        C2896e.f3510a.mo36849a(adSessionStatePublisher.getWebView(), "setNativeViewHierarchy", str);
                    }
                }
            }
        }
        C2917b.C2918a aVar2 = this.f3564a;
        if (aVar2 != null) {
            C2920c cVar = (C2920c) aVar2;
            cVar.f3569d = null;
            cVar.mo36869a();
        }
    }

    public Object doInBackground(Object[] objArr) {
        if (C2904b.m3506b(this.f3562b, ((C2924b) this.f3565d).f3570a)) {
            return null;
        }
        C2917b.C2919b bVar = this.f3565d;
        JSONObject jSONObject = this.f3562b;
        ((C2924b) bVar).f3570a = jSONObject;
        return jSONObject.toString();
    }
}
