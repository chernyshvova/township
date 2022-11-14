package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

@SafeParcelable.Class(creator = "NotFilterCreator")
@SafeParcelable.Reserved({1000})
public final class zzv extends zza {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();
    @SafeParcelable.Field(mo17147id = 1)
    public final FilterHolder zzmp;

    @SafeParcelable.Constructor
    public zzv(@SafeParcelable.Param(mo17150id = 1) FilterHolder filterHolder) {
        this.zzmp = filterHolder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzmp, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final <T> T zza(zzj<T> zzj) {
        return zzj.zza(this.zzmp.getFilter().zza(zzj));
    }

    public zzv(Filter filter) {
        this(new FilterHolder(filter));
    }
}
