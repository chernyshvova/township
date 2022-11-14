package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzt;
import com.google.android.gms.drive.query.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@SafeParcelable.Class(creator = "QueryCreator")
@SafeParcelable.Reserved({1000})
public class Query extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new zzb();
    @SafeParcelable.Field(mo17147id = 7)
    public final List<DriveSpace> zzby;
    @SafeParcelable.Field(mo17147id = 1)
    public final zzr zzlm;
    @SafeParcelable.Field(mo17147id = 3)
    public final String zzln;
    @SafeParcelable.Field(mo17147id = 4)
    @Nullable
    public final SortOrder zzlo;
    @SafeParcelable.Field(mo17147id = 5)
    public final List<String> zzlp;
    @SafeParcelable.Field(mo17147id = 6)
    public final boolean zzlq;
    @SafeParcelable.Field(mo17147id = 8)
    public final boolean zzlr;

    public Query(zzr zzr, String str, SortOrder sortOrder, @NonNull List<String> list, boolean z, @NonNull Set<DriveSpace> set, boolean z2) {
        this(zzr, str, sortOrder, list, z, (List<DriveSpace>) new ArrayList(set), z2);
    }

    public Filter getFilter() {
        return this.zzlm;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzln;
    }

    @Nullable
    public SortOrder getSortOrder() {
        return this.zzlo;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzlm, this.zzlo, this.zzln, this.zzby});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzlm, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzln, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzlo, i, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzlp, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzlq);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zzby, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzlr);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    public final Set<DriveSpace> zzbi() {
        return this.zzby == null ? new HashSet() : new HashSet(this.zzby);
    }

    @SafeParcelable.Constructor
    public Query(@SafeParcelable.Param(mo17150id = 1) zzr zzr, @SafeParcelable.Param(mo17150id = 3) String str, @SafeParcelable.Param(mo17150id = 4) @Nullable SortOrder sortOrder, @SafeParcelable.Param(mo17150id = 5) @NonNull List<String> list, @SafeParcelable.Param(mo17150id = 6) boolean z, @SafeParcelable.Param(mo17150id = 7) @NonNull List<DriveSpace> list2, @SafeParcelable.Param(mo17150id = 8) boolean z2) {
        this.zzlm = zzr;
        this.zzln = str;
        this.zzlo = sortOrder;
        this.zzlp = list;
        this.zzlq = z;
        this.zzby = list2;
        this.zzlr = z2;
    }

    @VisibleForTesting
    public static class Builder {
        public String zzln;
        public SortOrder zzlo;
        public List<String> zzlp = Collections.emptyList();
        public boolean zzlq;
        public boolean zzlr;
        public final List<Filter> zzls = new ArrayList();
        public Set<DriveSpace> zzlt = Collections.emptySet();

        public Builder() {
        }

        public Builder addFilter(@NonNull Filter filter) {
            Preconditions.checkNotNull(filter, "Filter may not be null.");
            if (!(filter instanceof zzt)) {
                this.zzls.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new zzr(zzx.zzmv, (Iterable<Filter>) this.zzls), this.zzln, this.zzlo, this.zzlp, this.zzlq, this.zzlt, this.zzlr);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.zzln = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzlo = sortOrder;
            return this;
        }

        public Builder(Query query) {
            this.zzls.add(query.getFilter());
            this.zzln = query.getPageToken();
            this.zzlo = query.getSortOrder();
            this.zzlp = query.zzlp;
            this.zzlq = query.zzlq;
            query.zzbi();
            this.zzlt = query.zzbi();
            this.zzlr = query.zzlr;
        }
    }
}
