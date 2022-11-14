package com.applovin.impl.mediation.p010a;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.h */
public class C0809h extends C0806f {
    public C0809h(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, C1188m mVar) {
        super(map, jSONObject, jSONObject2, mVar);
    }

    /* renamed from: a */
    public boolean mo9825a() {
        return mo9921b("only_collect_signal_when_initialized", Boolean.FALSE).booleanValue();
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("SignalProviderSpec{adObject=");
        outline24.append(mo9896N());
        outline24.append('}');
        return outline24.toString();
    }
}
