package com.iab.omid.library.applovin.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.p045b.C2841a;
import com.iab.omid.library.applovin.p045b.C2844c;
import com.iab.omid.library.applovin.p047d.C2861f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.iab.omid.library.applovin.walking.a */
public class C2871a {

    /* renamed from: a */
    public final HashMap<View, String> f3461a = new HashMap<>();

    /* renamed from: b */
    public final HashMap<View, C2872a> f3462b = new HashMap<>();

    /* renamed from: c */
    public final HashMap<String, View> f3463c = new HashMap<>();

    /* renamed from: d */
    public final HashSet<View> f3464d = new HashSet<>();

    /* renamed from: e */
    public final HashSet<String> f3465e = new HashSet<>();

    /* renamed from: f */
    public final HashSet<String> f3466f = new HashSet<>();

    /* renamed from: g */
    public final HashMap<String, String> f3467g = new HashMap<>();

    /* renamed from: h */
    public final Map<View, Boolean> f3468h = new WeakHashMap();

    /* renamed from: i */
    public boolean f3469i;

    /* renamed from: com.iab.omid.library.applovin.walking.a$a */
    public static class C2872a {

        /* renamed from: a */
        public final C2844c f3470a;

        /* renamed from: b */
        public final ArrayList<String> f3471b = new ArrayList<>();

        public C2872a(C2844c cVar, String str) {
            this.f3470a = cVar;
            mo36810a(str);
        }

        /* renamed from: a */
        public C2844c mo36809a() {
            return this.f3470a;
        }

        /* renamed from: a */
        public void mo36810a(String str) {
            this.f3471b.add(str);
        }

        /* renamed from: b */
        public ArrayList<String> mo36811b() {
            return this.f3471b;
        }
    }

    /* renamed from: a */
    private void m3442a(C2839a aVar) {
        for (C2844c a : aVar.mo36672a()) {
            m3443a(a, aVar);
        }
    }

    /* renamed from: a */
    private void m3443a(C2844c cVar, C2839a aVar) {
        View view = (View) cVar.mo36728a().get();
        if (view != null) {
            C2872a aVar2 = this.f3462b.get(view);
            if (aVar2 != null) {
                aVar2.mo36810a(aVar.getAdSessionId());
            } else {
                this.f3462b.put(view, new C2872a(cVar, aVar.getAdSessionId()));
            }
        }
    }

    /* renamed from: e */
    private String m3444e(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (m3445f(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String e = C2861f.m3393e(view);
            if (e != null) {
                return e;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f3464d.addAll(hashSet);
        return null;
    }

    /* renamed from: f */
    private Boolean m3445f(View view) {
        if (view.hasWindowFocus()) {
            this.f3468h.remove(view);
            return Boolean.FALSE;
        } else if (this.f3468h.containsKey(view)) {
            return this.f3468h.get(view);
        } else {
            this.f3468h.put(view, Boolean.FALSE);
            return Boolean.FALSE;
        }
    }

    /* renamed from: a */
    public String mo36798a(View view) {
        if (this.f3461a.size() == 0) {
            return null;
        }
        String str = this.f3461a.get(view);
        if (str != null) {
            this.f3461a.remove(view);
        }
        return str;
    }

    /* renamed from: a */
    public String mo36799a(String str) {
        return this.f3467g.get(str);
    }

    /* renamed from: a */
    public HashSet<String> mo36800a() {
        return this.f3465e;
    }

    /* renamed from: b */
    public View mo36801b(String str) {
        return this.f3463c.get(str);
    }

    /* renamed from: b */
    public C2872a mo36802b(View view) {
        C2872a aVar = this.f3462b.get(view);
        if (aVar != null) {
            this.f3462b.remove(view);
        }
        return aVar;
    }

    /* renamed from: b */
    public HashSet<String> mo36803b() {
        return this.f3466f;
    }

    /* renamed from: c */
    public C2882c mo36804c(View view) {
        return this.f3464d.contains(view) ? C2882c.PARENT_VIEW : this.f3469i ? C2882c.OBSTRUCTION_VIEW : C2882c.UNDERLYING_VIEW;
    }

    /* renamed from: c */
    public void mo36805c() {
        C2841a a = C2841a.m3285a();
        if (a != null) {
            for (C2839a next : a.mo36712c()) {
                View e = next.mo36678e();
                if (next.mo36679f()) {
                    String adSessionId = next.getAdSessionId();
                    if (e != null) {
                        String e2 = m3444e(e);
                        if (e2 == null) {
                            this.f3465e.add(adSessionId);
                            this.f3461a.put(e, adSessionId);
                            m3442a(next);
                        } else if (e2 != "noWindowFocus") {
                            this.f3466f.add(adSessionId);
                            this.f3463c.put(adSessionId, e);
                            this.f3467g.put(adSessionId, e2);
                        }
                    } else {
                        this.f3466f.add(adSessionId);
                        this.f3467g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo36806d() {
        this.f3461a.clear();
        this.f3462b.clear();
        this.f3463c.clear();
        this.f3464d.clear();
        this.f3465e.clear();
        this.f3466f.clear();
        this.f3467g.clear();
        this.f3469i = false;
    }

    /* renamed from: d */
    public boolean mo36807d(View view) {
        if (!this.f3468h.containsKey(view)) {
            return true;
        }
        this.f3468h.put(view, Boolean.TRUE);
        return false;
    }

    /* renamed from: e */
    public void mo36808e() {
        this.f3469i = true;
    }
}
