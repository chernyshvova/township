package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzcai;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class QueryInfo {
    public final zzbhy zza;

    public QueryInfo(zzbhy zzbhy) {
        this.zza = zzbhy;
    }

    @KeepForSdk
    public static void generate(@RecentlyNonNull Context context, @RecentlyNonNull AdFormat adFormat, @Nullable AdRequest adRequest, @RecentlyNonNull QueryInfoGenerationCallback queryInfoGenerationCallback) {
        new zzcai(context, adFormat, adRequest == null ? null : adRequest.zza()).zzb(queryInfoGenerationCallback);
    }

    @RecentlyNonNull
    @KeepForSdk
    public String getQuery() {
        return this.zza.zza();
    }

    @RecentlyNonNull
    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zza.zzc();
    }

    @RecentlyNonNull
    @KeepForSdk
    public String getRequestId() {
        return this.zza.zzb();
    }

    @NonNull
    public final zzbhy zza() {
        return this.zza;
    }
}
