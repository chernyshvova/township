package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

@SafeParcelable.Class(creator = "ChangeEventCreator")
@SafeParcelable.Reserved({1})
public final class ChangeEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final Parcelable.Creator<ChangeEvent> CREATOR = new zza();
    @SafeParcelable.Field(mo17147id = 3)
    public final int zzbu;
    @SafeParcelable.Field(mo17147id = 2)
    public final DriveId zzk;

    @SafeParcelable.Constructor
    public ChangeEvent(@SafeParcelable.Param(mo17150id = 2) DriveId driveId, @SafeParcelable.Param(mo17150id = 3) int i) {
        this.zzk = driveId;
        this.zzbu = i;
    }

    public final DriveId getDriveId() {
        return this.zzk;
    }

    public final int getType() {
        return 1;
    }

    public final boolean hasBeenDeleted() {
        return (this.zzbu & 4) != 0;
    }

    public final boolean hasContentChanged() {
        return (this.zzbu & 2) != 0;
    }

    public final boolean hasMetadataChanged() {
        return (this.zzbu & 1) != 0;
    }

    public final String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.zzk, Integer.valueOf(this.zzbu)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
