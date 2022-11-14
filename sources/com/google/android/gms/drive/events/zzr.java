package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.drive.zzh;

@SafeParcelable.Class(creator = "TransferProgressEventCreator")
@SafeParcelable.Reserved({1})
public final class zzr extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @SafeParcelable.Field(mo17147id = 2)
    public final zzh zzcs;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(mo17150id = 2) zzh zzh) {
        this.zzcs = zzh;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != zzr.class) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Objects.equal(this.zzcs, ((zzr) obj).zzcs);
    }

    public final int getType() {
        return 8;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzcs);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzcs, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzh zzac() {
        return this.zzcs;
    }
}
