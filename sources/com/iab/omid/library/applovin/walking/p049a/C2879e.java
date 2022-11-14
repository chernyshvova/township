package com.iab.omid.library.applovin.walking.p049a;

import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.p045b.C2841a;
import com.iab.omid.library.applovin.walking.p049a.C2874b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.walking.a.e */
public class C2879e extends C2873a {
    public C2879e(C2874b.C2876b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m3470b(String str) {
        C2841a a = C2841a.m3285a();
        if (a != null) {
            for (C2839a next : a.mo36710b()) {
                if (this.f3472a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo36776b(str, this.f3474c);
                }
            }
        }
    }

    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.f3473b.toString();
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        m3470b(str);
        super.onPostExecute(str);
    }
}
