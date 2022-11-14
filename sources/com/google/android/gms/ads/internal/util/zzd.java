package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcgr;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzchh;
import com.google.android.gms.internal.ads.zzfqn;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzd {
    public static void zza(Context context) {
        if (zzcgr.zzk(context) && !zzcgr.zzi()) {
            zzfqn<?> zzb = new zzc(context).zzb();
            zzcgs.zzh("Updating ad debug logging enablement.");
            zzchh.zza(zzb, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
