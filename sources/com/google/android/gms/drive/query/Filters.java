package com.google.android.gms.drive.query;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.query.internal.zzb;
import com.google.android.gms.drive.query.internal.zzd;
import com.google.android.gms.drive.query.internal.zzn;
import com.google.android.gms.drive.query.internal.zzp;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzv;
import com.google.android.gms.drive.query.internal.zzx;
import com.google.android.gms.drive.query.internal.zzz;

public class Filters {
    public static Filter and(@NonNull Filter filter, @NonNull Filter... filterArr) {
        Preconditions.checkNotNull(filter, "Filter may not be null.");
        Preconditions.checkNotNull(filterArr, "Additional filters may not be null.");
        return new zzr(zzx.zzmv, filter, filterArr);
    }

    public static Filter contains(@NonNull SearchableMetadataField<String> searchableMetadataField, @NonNull String str) {
        Preconditions.checkNotNull(searchableMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(str, "Value may not be null.");
        return new zzb(zzx.zzmy, searchableMetadataField, str);
    }

    /* renamed from: eq */
    public static <T> Filter m2748eq(@NonNull SearchableMetadataField<T> searchableMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzmq, searchableMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter greaterThan(@NonNull SearchableOrderedMetadataField<T> searchableOrderedMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzmt, searchableOrderedMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(@NonNull SearchableOrderedMetadataField<T> searchableOrderedMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzmu, searchableOrderedMetadataField, t);
    }

    /* renamed from: in */
    public static <T> Filter m2749in(@NonNull SearchableCollectionMetadataField<T> searchableCollectionMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableCollectionMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzp(searchableCollectionMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter lessThan(@NonNull SearchableOrderedMetadataField<T> searchableOrderedMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzmr, searchableOrderedMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(@NonNull SearchableOrderedMetadataField<T> searchableOrderedMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzms, searchableOrderedMetadataField, t);
    }

    public static Filter not(@NonNull Filter filter) {
        Preconditions.checkNotNull(filter, "Filter may not be null");
        return new zzv(filter);
    }

    public static Filter openedByMe() {
        return new zzd((SearchableMetadataField<?>) SearchableField.LAST_VIEWED_BY_ME);
    }

    /* renamed from: or */
    public static Filter m2750or(@NonNull Filter filter, @NonNull Filter... filterArr) {
        Preconditions.checkNotNull(filter, "Filter may not be null.");
        Preconditions.checkNotNull(filterArr, "Additional filters may not be null.");
        return new zzr(zzx.zzmw, filter, filterArr);
    }

    public static Filter ownedByMe() {
        return new zzz();
    }

    public static Filter sharedWithMe() {
        return new zzd((SearchableMetadataField<?>) SearchableField.zzlu);
    }

    public static Filter and(@NonNull Iterable<Filter> iterable) {
        Preconditions.checkNotNull(iterable, "Filters may not be null");
        return new zzr(zzx.zzmv, iterable);
    }

    /* renamed from: eq */
    public static Filter m2747eq(@NonNull CustomPropertyKey customPropertyKey, @NonNull String str) {
        Preconditions.checkNotNull(customPropertyKey, "Custom property key may not be null.");
        Preconditions.checkNotNull(str, "Custom property value may not be null.");
        return new zzn(SearchableField.zzlv, new AppVisibleCustomProperties.zza().zza(customPropertyKey, str).zzbb());
    }

    /* renamed from: or */
    public static Filter m2751or(@NonNull Iterable<Filter> iterable) {
        Preconditions.checkNotNull(iterable, "Filters may not be null");
        return new zzr(zzx.zzmw, iterable);
    }
}
