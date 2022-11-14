package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.cf */
public final /* synthetic */ class C2224cf implements C2231co {

    /* renamed from: a */
    public final C2232cp f3057a;

    /* renamed from: b */
    public final List f3058b;

    public C2224cf(C2232cp cpVar, List list) {
        this.f3057a = cpVar;
        this.f3058b = list;
    }

    /* renamed from: a */
    public final Object mo33216a() {
        C2232cp cpVar = this.f3057a;
        List list = this.f3058b;
        if (cpVar != null) {
            HashMap hashMap = new HashMap();
            for (C2229cm next : cpVar.f3082f.values()) {
                String str = next.f3071c.f3064a;
                if (list.contains(str)) {
                    C2229cm cmVar = (C2229cm) hashMap.get(str);
                    if ((cmVar == null ? -1 : cmVar.f3069a) < next.f3069a) {
                        hashMap.put(str, next);
                    }
                }
            }
            return hashMap;
        }
        throw null;
    }
}
