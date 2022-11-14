package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.applovin.sdk.AppLovinMediationProvider;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzh implements Runnable {
    public final zzj zza;
    public final Context zzb;
    public final String zzc = AppLovinMediationProvider.ADMOB;

    public zzh(zzj zzj, Context context, String str) {
        this.zza = zzj;
        this.zzb = context;
    }

    public final void run() {
        this.zza.zzM(this.zzb, this.zzc);
    }
}
