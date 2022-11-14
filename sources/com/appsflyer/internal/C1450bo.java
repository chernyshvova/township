package com.appsflyer.internal;

import android.content.Context;
import java.util.Map;

/* renamed from: com.appsflyer.internal.bo */
public abstract class C1450bo extends C1461bw {
    public C1450bo(String str, Runnable runnable) {
        super(str, runnable);
    }

    public final void AFInAppEventParameterName(Context context, C1428av<Map<String, Object>> avVar) {
        C1387af.AFInAppEventParameterName();
        if (C1387af.AFInAppEventParameterName(C1387af.AFInAppEventType(context), "appsFlyerCount", false) <= 0 && avVar.AFInAppEventParameterName()) {
            new Thread(avVar.AFInAppEventParameterName).start();
            values();
        }
    }
}
