package com.iab.omid.library.applovin.walking.p049a;

import android.text.TextUtils;
import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.p045b.C2841a;
import com.iab.omid.library.applovin.p047d.C2856b;
import com.iab.omid.library.applovin.walking.p049a.C2874b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.walking.a.f */
public class C2880f extends C2873a {
    public C2880f(C2874b.C2876b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m3473b(String str) {
        C2841a a = C2841a.m3285a();
        if (a != null) {
            for (C2839a next : a.mo36710b()) {
                if (this.f3472a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo36771a(str, this.f3474c);
                }
            }
        }
    }

    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (C2856b.m3367b(this.f3473b, this.f3476d.mo36818b())) {
            return null;
        }
        this.f3476d.mo36817a(this.f3473b);
        return this.f3473b.toString();
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            m3473b(str);
        }
        super.onPostExecute(str);
    }
}
