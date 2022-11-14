package com.vungle.warren.utility;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.drive.DriveFile;
import com.vungle.warren.utility.ActivityManager;

public class ExternalRouter {
    public static final String TAG = "ExternalRouter";

    public static boolean launch(@Nullable String str, @NonNull Context context, @Nullable ActivityManager.LeftApplicationCallback leftApplicationCallback) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setFlags(DriveFile.MODE_READ_ONLY);
                ActivityManager.startWhenForeground(context, parseUri, leftApplicationCallback);
                return true;
            } catch (Exception e) {
                String str2 = TAG;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error while opening url");
                outline24.append(e.getLocalizedMessage());
                Log.e(str2, outline24.toString());
                String str3 = TAG;
                Log.d(str3, "Cannot open url " + str);
            }
        }
        return false;
    }
}
