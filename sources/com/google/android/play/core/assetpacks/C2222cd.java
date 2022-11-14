package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.android.billingclient.api.zzam;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.cd */
public final /* synthetic */ class C2222cd implements C2231co {

    /* renamed from: a */
    public final C2232cp f3051a;

    /* renamed from: b */
    public final Bundle f3052b;

    public C2222cd(C2232cp cpVar, Bundle bundle) {
        this.f3051a = cpVar;
        this.f3052b = bundle;
    }

    /* renamed from: a */
    public final Object mo33216a() {
        C2232cp cpVar = this.f3051a;
        Bundle bundle = this.f3052b;
        if (cpVar != null) {
            int i = bundle.getInt("session_id");
            if (i != 0) {
                Map<Integer, C2229cm> map = cpVar.f3082f;
                Integer valueOf = Integer.valueOf(i);
                if (map.containsKey(valueOf)) {
                    C2229cm cmVar = cpVar.f3082f.get(valueOf);
                    if (cmVar.f3071c.f3066c == 6) {
                        return Boolean.FALSE;
                    }
                    return Boolean.valueOf(!zzam.m29a(cmVar.f3071c.f3066c, bundle.getInt(zzam.m20a("status", C2232cp.m2899e(bundle)))));
                }
            }
            return Boolean.TRUE;
        }
        throw null;
    }
}
