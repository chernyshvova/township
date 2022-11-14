package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class AdValue {
    public final int zza;
    public final String zzb;
    public final long zzc;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public @interface PrecisionType {
        public static final int ESTIMATED = 1;
        public static final int PRECISE = 3;
        public static final int PUBLISHER_PROVIDED = 2;
        public static final int UNKNOWN = 0;
    }

    public AdValue(int i, String str, long j) {
        this.zza = i;
        this.zzb = str;
        this.zzc = j;
    }

    @RecentlyNonNull
    public static AdValue zza(int i, @RecentlyNonNull String str, long j) {
        return new AdValue(i, str, j);
    }

    @RecentlyNonNull
    public String getCurrencyCode() {
        return this.zzb;
    }

    public int getPrecisionType() {
        return this.zza;
    }

    public long getValueMicros() {
        return this.zzc;
    }
}
