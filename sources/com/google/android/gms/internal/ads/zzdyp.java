package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdyp implements zzgjg<PackageInfo> {
    public final zzgju<Context> zza;
    public final zzgju<ApplicationInfo> zzb;

    public zzdyp(zzgju<Context> zzgju, zzgju<ApplicationInfo> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return Wrappers.packageManager(this.zza.zzb()).getPackageInfo(((zzdyk) this.zzb).zzb().packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
