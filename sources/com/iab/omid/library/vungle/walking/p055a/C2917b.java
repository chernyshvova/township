package com.iab.omid.library.vungle.walking.p055a;

import android.os.AsyncTask;

/* renamed from: com.iab.omid.library.vungle.walking.a.b */
public abstract class C2917b extends AsyncTask<Object, Void, String> {

    /* renamed from: a */
    public C2918a f3564a;

    /* renamed from: d */
    public final C2919b f3565d;

    /* renamed from: com.iab.omid.library.vungle.walking.a.b$a */
    public interface C2918a {
    }

    /* renamed from: com.iab.omid.library.vungle.walking.a.b$b */
    public interface C2919b {
    }

    public C2917b(C2919b bVar) {
        this.f3565d = bVar;
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        C2918a aVar = this.f3564a;
        if (aVar != null) {
            C2920c cVar = (C2920c) aVar;
            cVar.f3569d = null;
            cVar.mo36869a();
        }
    }
}
