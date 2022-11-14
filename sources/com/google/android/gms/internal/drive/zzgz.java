package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "StringListResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzgz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgz> CREATOR = new zzha();
    @SafeParcelable.Field(getter = "getList", mo17147id = 2)
    public final List<String> zziu;

    @SafeParcelable.Constructor
    public zzgz(@SafeParcelable.Param(mo17150id = 2) List<String> list) {
        this.zziu = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 2, this.zziu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
