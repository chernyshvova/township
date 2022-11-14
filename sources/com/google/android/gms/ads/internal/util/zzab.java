package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.facebook.internal.FetchedAppSettings;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

@TargetApi(28)
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzab extends zzz {
    public static final /* synthetic */ WindowInsets zzs(Activity activity, View view, WindowInsets windowInsets) {
        if (zzs.zzg().zzl().zzz() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String str = "";
            if (displayCutout != null) {
                zzg zzl = zzs.zzg().zzl();
                for (Rect next : displayCutout.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", new Object[]{Integer.valueOf(next.left), Integer.valueOf(next.top), Integer.valueOf(next.right), Integer.valueOf(next.bottom)});
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat(FetchedAppSettings.DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                zzl.zzA(str);
            } else {
                zzs.zzg().zzl().zzA(str);
            }
        }
        zzv(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    public static final void zzv(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = attributes.layoutInDisplayCutoutMode;
        int i2 = 1;
        if (true != z) {
            i2 = 2;
        }
        if (i2 != i) {
            attributes.layoutInDisplayCutoutMode = i2;
            window.setAttributes(attributes);
        }
    }

    public final void zzr(Activity activity) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaM)).booleanValue() && zzs.zzg().zzl().zzz() == null && !activity.isInMultiWindowMode()) {
            zzv(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new zzaa(this, activity));
        }
    }
}
