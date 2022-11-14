package com.swrve.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class SwrveInstallReferrerReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(SwrveImp.REFERRER);
        SwrveLogger.m2755i("Received INSTALL_REFERRER broadcast with referrer:%s", stringExtra);
        if (!SwrveHelper.isNullOrEmpty(stringExtra)) {
            try {
                context.getSharedPreferences(ISwrveCommon.SDK_PREFS_NAME, 0).edit().putString("swrve.referrer_id", URLDecoder.decode(stringExtra, "UTF-8")).apply();
            } catch (UnsupportedEncodingException e) {
                SwrveLogger.m2753e(GeneratedOutlineSupport.outline16("Error decoding the referrer:", stringExtra), e, new Object[0]);
            }
        }
    }
}
