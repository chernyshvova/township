package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.appsflyer.internal.C1387af;
import com.swrve.sdk.SwrveImp;

public class MultipleInstallBroadcastReceiver extends BroadcastReceiver {
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
                AFLogger.AFInAppEventParameterName("MultipleInstallBroadcastReceiver called");
                C1387af.AFInAppEventParameterName().AFInAppEventType(context, intent);
                for (ResolveInfo next : context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0)) {
                    String action = intent.getAction();
                    if (next.activityInfo.packageName.equals(context.getPackageName()) && "com.android.vending.INSTALL_REFERRER".equals(action) && !MultipleInstallBroadcastReceiver.class.getName().equals(next.activityInfo.name)) {
                        StringBuilder sb = new StringBuilder("trigger onReceive: class: ");
                        sb.append(next.activityInfo.name);
                        AFLogger.AFInAppEventParameterName(sb.toString());
                        try {
                            ((BroadcastReceiver) Class.forName(next.activityInfo.name).newInstance()).onReceive(context, intent);
                        } catch (Throwable th2) {
                            StringBuilder sb2 = new StringBuilder("error in BroadcastReceiver ");
                            sb2.append(next.activityInfo.name);
                            AFLogger.values(sb2.toString(), th2);
                        }
                    }
                }
                return;
            }
            C1387af.AFInAppEventParameterName().valueOf(context, str);
        }
    }
}
