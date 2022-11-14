package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.ads.zzcgs;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class RequestConfiguration {
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    @RecentlyNonNull
    public static final List<String> zza = Arrays.asList(new String[]{MAX_AD_CONTENT_RATING_MA, MAX_AD_CONTENT_RATING_T, MAX_AD_CONTENT_RATING_PG, MAX_AD_CONTENT_RATING_G});
    public final int zzb;
    public final int zzc;
    @Nullable
    public final String zzd;
    public final List<String> zze;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static class Builder {
        public int zza = -1;
        public int zzb = -1;
        @Nullable
        public String zzc = null;
        public final List<String> zzd = new ArrayList();

        @RecentlyNonNull
        public RequestConfiguration build() {
            return new RequestConfiguration(this.zza, this.zzb, this.zzc, this.zzd, (zzc) null);
        }

        @RecentlyNonNull
        public Builder setMaxAdContentRating(@Nullable String str) {
            if (str == null || "".equals(str)) {
                this.zzc = null;
            } else if (RequestConfiguration.MAX_AD_CONTENT_RATING_G.equals(str) || RequestConfiguration.MAX_AD_CONTENT_RATING_PG.equals(str) || RequestConfiguration.MAX_AD_CONTENT_RATING_T.equals(str) || RequestConfiguration.MAX_AD_CONTENT_RATING_MA.equals(str)) {
                this.zzc = str;
            } else {
                zzcgs.zzi(str.length() != 0 ? "Invalid value passed to setMaxAdContentRating: ".concat(str) : new String("Invalid value passed to setMaxAdContentRating: "));
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setTagForChildDirectedTreatment(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zza = i;
            } else {
                StringBuilder sb = new StringBuilder(68);
                sb.append("Invalid value passed to setTagForChildDirectedTreatment: ");
                sb.append(i);
                zzcgs.zzi(sb.toString());
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setTagForUnderAgeOfConsent(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzb = i;
            } else {
                StringBuilder sb = new StringBuilder(63);
                sb.append("Invalid value passed to setTagForUnderAgeOfConsent: ");
                sb.append(i);
                zzcgs.zzi(sb.toString());
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setTestDeviceIds(@Nullable List<String> list) {
            this.zzd.clear();
            if (list != null) {
                this.zzd.addAll(list);
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public @interface TagForChildDirectedTreatment {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public @interface TagForUnderAgeOfConsent {
    }

    public /* synthetic */ RequestConfiguration(int i, int i2, String str, List list, zzc zzc2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
        this.zze = list;
    }

    @RecentlyNonNull
    public String getMaxAdContentRating() {
        String str = this.zzd;
        return str == null ? "" : str;
    }

    public int getTagForChildDirectedTreatment() {
        return this.zzb;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.zzc;
    }

    @RecentlyNonNull
    public List<String> getTestDeviceIds() {
        return new ArrayList(this.zze);
    }

    @RecentlyNonNull
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setTagForChildDirectedTreatment(this.zzb);
        builder.setTagForUnderAgeOfConsent(this.zzc);
        builder.setMaxAdContentRating(this.zzd);
        builder.setTestDeviceIds(this.zze);
        return builder;
    }
}
