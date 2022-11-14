package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdyk implements zzgjg<ApplicationInfo> {
    public final zzgju<Context> zza;

    public zzdyk(zzgju<Context> zzgju) {
        this.zza = zzgju;
    }

    /* renamed from: zza */
    public final ApplicationInfo zzb() {
        ApplicationInfo applicationInfo = this.zza.zzb().getApplicationInfo();
        zzgjp.zzb(applicationInfo);
        return applicationInfo;
    }
}
