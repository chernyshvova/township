package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "OnResourceIdSetResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzgd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgd> CREATOR = new zzge();
    @SafeParcelable.Field(getter = "getResourceIds", mo17147id = 2)
    public final List<String> zzim;

    @SafeParcelable.Constructor
    public zzgd(@SafeParcelable.Param(mo17150id = 2) List<String> list) {
        this.zzim = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzim, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
