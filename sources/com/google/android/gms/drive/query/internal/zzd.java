package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "FieldOnlyFilterCreator")
@SafeParcelable.Reserved({1000})
public final class zzd extends zza {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    @SafeParcelable.Field(mo17147id = 1)
    public final MetadataBundle zzma;
    public final MetadataField<?> zzmb;

    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(mo17150id = 1) MetadataBundle metadataBundle) {
        this.zzma = metadataBundle;
        this.zzmb = zzi.zza(metadataBundle);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzma, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final <T> T zza(zzj<T> zzj) {
        return zzj.zze(this.zzmb);
    }

    public zzd(SearchableMetadataField<?> searchableMetadataField) {
        this(MetadataBundle.zza(searchableMetadataField, null));
    }
}
