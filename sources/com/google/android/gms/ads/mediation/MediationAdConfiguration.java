package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public final String zza;
    public final Bundle zzb;
    public final Bundle zzc;
    public final Context zzd;
    public final boolean zze;
    @Nullable
    public final Location zzf;
    public final int zzg;
    public final int zzh;
    @Nullable
    public final String zzi;
    public final String zzj;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull Bundle bundle, @RecentlyNonNull Bundle bundle2, boolean z, @Nullable Location location, int i, int i2, @Nullable String str2, @RecentlyNonNull String str3) {
        this.zza = str;
        this.zzb = bundle;
        this.zzc = bundle2;
        this.zzd = context;
        this.zze = z;
        this.zzf = location;
        this.zzg = i;
        this.zzh = i2;
        this.zzi = str2;
        this.zzj = str3;
    }

    @RecentlyNonNull
    public String getBidResponse() {
        return this.zza;
    }

    @RecentlyNonNull
    public Context getContext() {
        return this.zzd;
    }

    @RecentlyNullable
    public Location getLocation() {
        return this.zzf;
    }

    @RecentlyNullable
    public String getMaxAdContentRating() {
        return this.zzi;
    }

    @RecentlyNonNull
    public Bundle getMediationExtras() {
        return this.zzc;
    }

    @RecentlyNonNull
    public Bundle getServerParameters() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String getWatermark() {
        return this.zzj;
    }

    public boolean isTestRequest() {
        return this.zze;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzg;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzh;
    }
}
