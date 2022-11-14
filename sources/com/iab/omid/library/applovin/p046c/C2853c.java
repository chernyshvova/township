package com.iab.omid.library.applovin.p046c;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.p045b.C2841a;
import com.iab.omid.library.applovin.p046c.C2850a;
import com.iab.omid.library.applovin.p047d.C2856b;
import com.iab.omid.library.applovin.p047d.C2861f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.c.c */
public class C2853c implements C2850a {

    /* renamed from: a */
    public final C2850a f3425a;

    public C2853c(C2850a aVar) {
        this.f3425a = aVar;
    }

    @NonNull
    /* renamed from: a */
    public ArrayList<View> mo36760a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        C2841a a = C2841a.m3285a();
        if (a != null) {
            Collection<C2839a> c = a.mo36712c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (C2839a e : c) {
                View e2 = e.mo36678e();
                if (e2 != null && C2861f.m3391c(e2) && (rootView = e2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = C2861f.m3389a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C2861f.m3389a(arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public JSONObject mo36755a(View view) {
        return C2856b.m3356a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void mo36756a(View view, JSONObject jSONObject, C2850a.C2851a aVar, boolean z, boolean z2) {
        Iterator<View> it = mo36760a().iterator();
        while (it.hasNext()) {
            aVar.mo36757a(it.next(), this.f3425a, jSONObject, z2);
        }
    }
}
