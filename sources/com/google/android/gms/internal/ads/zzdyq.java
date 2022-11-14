package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdyq implements zzgjg<String> {
    public final zzgju<Context> zza;

    public zzdyq(zzgju<Context> zzgju) {
        this.zza = zzgju;
    }

    /* renamed from: zza */
    public final String zzb() {
        String packageName = ((zzfaa) this.zza).zza().getPackageName();
        zzgjp.zzb(packageName);
        return packageName;
    }
}
