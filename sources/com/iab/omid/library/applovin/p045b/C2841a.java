package com.iab.omid.library.applovin.p045b;

import com.iab.omid.library.applovin.adsession.C2839a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.applovin.b.a */
public class C2841a {

    /* renamed from: a */
    public static C2841a f3393a = new C2841a();

    /* renamed from: b */
    public final ArrayList<C2839a> f3394b = new ArrayList<>();

    /* renamed from: c */
    public final ArrayList<C2839a> f3395c = new ArrayList<>();

    /* renamed from: a */
    public static C2841a m3285a() {
        return f3393a;
    }

    /* renamed from: a */
    public void mo36709a(C2839a aVar) {
        this.f3394b.add(aVar);
    }

    /* renamed from: b */
    public Collection<C2839a> mo36710b() {
        return Collections.unmodifiableCollection(this.f3394b);
    }

    /* renamed from: b */
    public void mo36711b(C2839a aVar) {
        boolean d = mo36714d();
        this.f3395c.add(aVar);
        if (!d) {
            C2848f.m3325a().mo36752b();
        }
    }

    /* renamed from: c */
    public Collection<C2839a> mo36712c() {
        return Collections.unmodifiableCollection(this.f3395c);
    }

    /* renamed from: c */
    public void mo36713c(C2839a aVar) {
        boolean d = mo36714d();
        this.f3394b.remove(aVar);
        this.f3395c.remove(aVar);
        if (d && !mo36714d()) {
            C2848f.m3325a().mo36753c();
        }
    }

    /* renamed from: d */
    public boolean mo36714d() {
        return this.f3395c.size() > 0;
    }
}
