package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* renamed from: com.google.android.play.core.assetpacks.n */
public final class C2272n {

    /* renamed from: a */
    public final Context f3213a;

    public C2272n(Context context) {
        this.f3213a = context;
    }

    @Nullable
    /* renamed from: a */
    public static String m2953a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.getString("local_testing_dir");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
