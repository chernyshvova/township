package com.iab.omid.library.vungle.p052c;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.vungle.adsession.C2889a;
import com.iab.omid.library.vungle.p051b.C2891a;
import com.iab.omid.library.vungle.p052c.C2899a;
import com.iab.omid.library.vungle.p053d.C2904b;
import com.iab.omid.library.vungle.walking.TreeWalker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.c.c */
public class C2902c implements C2899a {

    /* renamed from: a */
    public final C2899a f3521a;

    public C2902c(C2899a aVar) {
        this.f3521a = aVar;
    }

    /* renamed from: a */
    public JSONObject mo36851a(View view) {
        return C2904b.m3498a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void mo36852a(View view, JSONObject jSONObject, C2899a.C2900a aVar, boolean z) {
        View rootView;
        ArrayList arrayList = new ArrayList();
        C2891a aVar2 = C2891a.f3501a;
        if (aVar2 != null) {
            Collection<C2889a> c = aVar2.mo36838c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (C2889a d : c) {
                View d2 = d.mo36836d();
                if (d2 != null) {
                    boolean z2 = false;
                    if (d2.isAttachedToWindow() && d2.isShown()) {
                        View view2 = d2;
                        while (true) {
                            if (view2 == null) {
                                z2 = true;
                                break;
                            } else if (view2.getAlpha() == 0.0f) {
                                break;
                            } else {
                                ViewParent parent = view2.getParent();
                                view2 = parent instanceof View ? (View) parent : null;
                            }
                        }
                    }
                    if (z2 && (rootView = d2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                        identityHashMap.put(rootView, rootView);
                        float z3 = Build.VERSION.SDK_INT >= 21 ? rootView.getZ() : 0.0f;
                        int size = arrayList.size();
                        while (size > 0) {
                            int i = size - 1;
                            if ((Build.VERSION.SDK_INT >= 21 ? ((View) arrayList.get(i)).getZ() : 0.0f) <= z3) {
                                break;
                            }
                            size = i;
                        }
                        arrayList.add(size, rootView);
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((TreeWalker) aVar).mo36861a((View) it.next(), this.f3521a, jSONObject);
        }
    }
}
