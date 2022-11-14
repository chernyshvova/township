package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnRealtimeLoadedResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfx> CREATOR = new zzgc();
    @SafeParcelable.Field(mo17147id = 2)
    public final boolean zzik;

    @SafeParcelable.Constructor
    public zzfx(@SafeParcelable.Param(mo17150id = 2) boolean z) {
        this.zzik = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzik);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
