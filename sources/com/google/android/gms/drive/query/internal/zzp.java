package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

@SafeParcelable.Class(creator = "InFilterCreator")
@SafeParcelable.Reserved({1000})
public final class zzp<T> extends zza {
    public static final zzq CREATOR = new zzq();
    @SafeParcelable.Field(mo17147id = 1)
    public final MetadataBundle zzma;
    public final zzb<T> zzmn;

    @SafeParcelable.Constructor
    public zzp(@SafeParcelable.Param(mo17150id = 1) MetadataBundle metadataBundle) {
        this.zzma = metadataBundle;
        this.zzmn = (zzb) zzi.zza(metadataBundle);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzma, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final <F> F zza(zzj<F> zzj) {
        zzb<T> zzb = this.zzmn;
        return zzj.zza(zzb, ((Collection) this.zzma.zza(zzb)).iterator().next());
    }

    public zzp(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        this(MetadataBundle.zza(searchableCollectionMetadataField, Collections.singleton(t)));
    }
}
