package com.appsflyer.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Nullable;

/* renamed from: com.appsflyer.internal.ao */
public final class C1416ao {
    @Nullable
    public static Uri values(Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return activity.getReferrer();
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }
}
