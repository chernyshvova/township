package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzu;

@SafeParcelable.Class(creator = "OnListEntriesResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzft extends zzu {
    public static final Parcelable.Creator<zzft> CREATOR = new zzfu();
    @SafeParcelable.Field(mo17147id = 3)
    public final boolean zzea;
    @SafeParcelable.Field(mo17147id = 2)
    public final DataHolder zzii;

    @SafeParcelable.Constructor
    public zzft(@SafeParcelable.Param(mo17150id = 2) DataHolder dataHolder, @SafeParcelable.Param(mo17150id = 3) boolean z) {
        this.zzii = dataHolder;
        this.zzea = z;
    }

    public final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzii, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzea);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DataHolder zzau() {
        return this.zzii;
    }
}
