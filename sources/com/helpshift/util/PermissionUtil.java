package com.helpshift.util;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.material.snackbar.Snackbar;
import com.helpshift.views.HSSnackbar;

public class PermissionUtil {
    public static final String TAG = "Helpshift_Permissions";

    public static boolean hasPermissionInManifest(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo.requestedPermissions != null) {
                for (String equals : packageInfo.requestedPermissions) {
                    if (equals.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            HSLogger.m3238d(TAG, "Error checking permission in Manifest : ", (Throwable) e);
        }
        return false;
    }

    public static Snackbar requestPermissions(final Fragment fragment, final String[] strArr, int i, int i2, final int i3, View view) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Requesting permission : ");
        outline24.append(strArr[0]);
        HSLogger.m3237d(TAG, outline24.toString());
        if (fragment.shouldShowRequestPermissionRationale(strArr[0])) {
            Snackbar make = HSSnackbar.make(view, i, -2);
            make.setAction(i2, new View.OnClickListener() {
                public void onClick(View view) {
                    fragment.requestPermissions(strArr, i3);
                }
            });
            make.show();
            return make;
        }
        fragment.requestPermissions(strArr, i3);
        return null;
    }

    @TargetApi(9)
    public static void showSettingsPage(Context context) {
        if (context != null) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addCategory("android.intent.category.DEFAULT");
                String packageName = context.getPackageName();
                intent.setData(Uri.parse("package:" + packageName));
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Intent intent2 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                intent2.addCategory("android.intent.category.DEFAULT");
                context.startActivity(intent2);
            }
        }
    }
}
