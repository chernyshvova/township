package com.swrve.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.drive.DriveFile;

public final class SwrveIntentHelper {
    public static void openDeepLink(Context context, String str) {
        openDeepLink(context, str, (Bundle) null);
    }

    public static void openDialer(Uri uri, Activity activity) {
        activity.startActivity(new Intent("android.intent.action.VIEW", uri));
    }

    public static void openIntentWebView(Uri uri, Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        Bundle bundle = new Bundle();
        bundle.putString(SwrveImp.REFERRER, str);
        intent.putExtra("com.android.browser.headers", bundle);
        activity.startActivity(intent);
    }

    public static void openDeepLink(Context context, String str, Bundle bundle) {
        Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse(str));
        if (bundle != null) {
            data.putExtras(bundle);
        }
        data.addFlags(DriveFile.MODE_READ_ONLY);
        data.addFlags(67108864);
        try {
            context.startActivity(data);
        } catch (ActivityNotFoundException e) {
            SwrveLogger.m2753e(GeneratedOutlineSupport.outline17("Could not launch activity for uri: ", str, ". Possibly badly formatted deep link"), e, new Object[0]);
        }
    }
}
