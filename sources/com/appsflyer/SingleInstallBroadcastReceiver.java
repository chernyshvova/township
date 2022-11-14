package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appsflyer.internal.C1387af;
import com.swrve.sdk.SwrveImp;

public class SingleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            try {
                str = intent.getStringExtra(SwrveImp.REFERRER);
            } catch (Throwable th) {
                AFLogger.values("error in BroadcastReceiver ", th);
                str = null;
            }
            if (str == null || C1387af.AFInAppEventType(context).getString(SwrveImp.REFERRER, (String) null) == null) {
                String string = AppsFlyerProperties.getInstance().getString("referrer_timestamp");
                long currentTimeMillis = System.currentTimeMillis();
                if (string == null || currentTimeMillis - Long.valueOf(string).longValue() >= 2000) {
                    AFLogger.AFInAppEventParameterName("SingleInstallBroadcastReceiver called");
                    C1387af.AFInAppEventParameterName().AFInAppEventType(context, intent);
                    AppsFlyerProperties.getInstance().set("referrer_timestamp", String.valueOf(System.currentTimeMillis()));
                    return;
                }
                return;
            }
            C1387af.AFInAppEventParameterName().valueOf(context, str);
        }
    }
}
