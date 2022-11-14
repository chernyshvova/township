package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcgl;
import com.vungle.warren.VisionController;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzy extends zzx {
    @VisibleForTesting
    public static final boolean zzp(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public final boolean zzo(Activity activity, Configuration configuration) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzde)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdg)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzbev.zza();
        int zzs = zzcgl.zzs(activity, configuration.screenHeightDp);
        int zzs2 = zzcgl.zzs(activity, configuration.screenWidthDp);
        zzs.zzc();
        DisplayMetrics zzy = zzr.zzy((WindowManager) activity.getApplicationContext().getSystemService(VisionController.WINDOW));
        int i = zzy.heightPixels;
        int i2 = zzy.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d = (double) activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int intValue = ((Integer) zzbex.zzc().zzb(zzbjn.zzdc)).intValue() * ((int) Math.round(d + 0.5d));
        if (!zzp(i, zzs + dimensionPixelSize, intValue) || !zzp(i2, zzs2, intValue)) {
            return true;
        }
        return false;
    }
}
