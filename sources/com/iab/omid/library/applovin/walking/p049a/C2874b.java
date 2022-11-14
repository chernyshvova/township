package com.iab.omid.library.applovin.walking.p049a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.walking.a.b */
public abstract class C2874b extends AsyncTask<Object, Void, String> {

    /* renamed from: a */
    public C2875a f3475a;

    /* renamed from: d */
    public final C2876b f3476d;

    /* renamed from: com.iab.omid.library.applovin.walking.a.b$a */
    public interface C2875a {
        /* renamed from: a */
        void mo36816a(C2874b bVar);
    }

    /* renamed from: com.iab.omid.library.applovin.walking.a.b$b */
    public interface C2876b {
        /* renamed from: a */
        void mo36817a(JSONObject jSONObject);

        /* renamed from: b */
        JSONObject mo36818b();
    }

    public C2874b(C2876b bVar) {
        this.f3476d = bVar;
    }

    /* renamed from: a */
    public void mo36812a(C2875a aVar) {
        this.f3475a = aVar;
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        C2875a aVar = this.f3475a;
        if (aVar != null) {
            aVar.mo36816a(this);
        }
    }

    /* renamed from: a */
    public void mo36814a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
