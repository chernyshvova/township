package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.appsflyer.internal.aw */
public final class C1430aw {
    public final SharedPreferences AFInAppEventType;
    public final Application values;

    public C1430aw(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.values = application;
        this.AFInAppEventType = C1387af.AFInAppEventType((Context) application);
    }

    public final boolean AFKeystoreWrapper() {
        C1387af.AFInAppEventParameterName();
        if (C1387af.AFInAppEventParameterName(this.AFInAppEventType, "appsFlyerCount", false) == 0) {
            return true;
        }
        return false;
    }
}
