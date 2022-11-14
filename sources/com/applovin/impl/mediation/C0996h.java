package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p010a.C0801a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.h */
public class C0996h {

    /* renamed from: a */
    public final List<C0997a> f1241a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.mediation.h$a */
    public interface C0997a {
        /* renamed from: a */
        void mo10349a(C0801a aVar);
    }

    /* renamed from: a */
    public void mo10346a(C0801a aVar) {
        Iterator it = new ArrayList(this.f1241a).iterator();
        while (it.hasNext()) {
            ((C0997a) it.next()).mo10349a(aVar);
        }
    }

    /* renamed from: a */
    public void mo10347a(C0997a aVar) {
        this.f1241a.add(aVar);
    }

    /* renamed from: b */
    public void mo10348b(C0997a aVar) {
        this.f1241a.remove(aVar);
    }
}
