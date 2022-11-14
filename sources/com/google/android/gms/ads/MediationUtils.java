package com.google.android.gms.ads;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class MediationUtils {
    public static final double MIN_HEIGHT_RATIO = 0.7d;
    public static final double MIN_WIDTH_RATIO = 0.5d;

    @RecentlyNullable
    public static AdSize findClosestSize(@RecentlyNonNull Context context, @RecentlyNonNull AdSize adSize, @RecentlyNonNull List<AdSize> list) {
        AdSize adSize2 = null;
        if (!(list == null || adSize == null)) {
            if (!adSize.zzb() && !adSize.zzf()) {
                float f = context.getResources().getDisplayMetrics().density;
                adSize = new AdSize(Math.round(((float) adSize.getWidthInPixels(context)) / f), Math.round(((float) adSize.getHeightInPixels(context)) / f));
            }
            for (AdSize next : list) {
                if (next != null) {
                    int width = adSize.getWidth();
                    int width2 = next.getWidth();
                    int height = adSize.getHeight();
                    int height2 = next.getHeight();
                    double d = (double) width;
                    Double.isNaN(d);
                    if (d * 0.5d <= ((double) width2) && width >= width2) {
                        if (adSize.zzf()) {
                            int zzh = adSize.zzh();
                            if (((Integer) zzbex.zzc().zzb(zzbjn.zzfp)).intValue() <= width2) {
                                if (((Integer) zzbex.zzc().zzb(zzbjn.zzfq)).intValue() <= height2) {
                                    if (zzh < height2) {
                                    }
                                }
                            }
                        } else if (!adSize.zzb()) {
                            double d2 = (double) height;
                            Double.isNaN(d2);
                            if (d2 * 0.7d <= ((double) height2)) {
                                if (height < height2) {
                                }
                            }
                        } else if (adSize.zze() < height2) {
                        }
                        if (adSize2 != null) {
                            if (adSize2.getHeight() * adSize2.getWidth() > next.getHeight() * next.getWidth()) {
                            }
                        }
                        adSize2 = next;
                    }
                }
            }
        }
        return adSize2;
    }
}
