package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "ParentDriveIdSetCreator")
@SafeParcelable.Reserved({1})
public class ParentDriveIdSet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ParentDriveIdSet> CREATOR = new zzn();
    @SafeParcelable.Field(mo17147id = 2)
    public final List<zzq> zzjj;

    @SafeParcelable.Constructor
    public ParentDriveIdSet(@SafeParcelable.Param(mo17150id = 2) List<zzq> list) {
        this.zzjj = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzjj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public ParentDriveIdSet() {
        this(new ArrayList());
    }
}
