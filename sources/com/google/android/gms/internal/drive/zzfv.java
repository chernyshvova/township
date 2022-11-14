package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzu;

@SafeParcelable.Class(creator = "OnListParentsResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfv extends zzu {
    public static final Parcelable.Creator<zzfv> CREATOR = new zzfw();
    @SafeParcelable.Field(mo17147id = 2)
    public final DataHolder zzij;

    @SafeParcelable.Constructor
    public zzfv(@SafeParcelable.Param(mo17150id = 2) DataHolder dataHolder) {
        this.zzij = dataHolder;
    }

    public final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzij, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DataHolder zzav() {
        return this.zzij;
    }
}
