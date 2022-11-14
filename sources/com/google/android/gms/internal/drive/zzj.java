package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zze;
import com.google.android.gms.drive.events.zzt;
import com.google.android.gms.drive.events.zzx;

@SafeParcelable.Class(creator = "AddEventListenerRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    @SafeParcelable.Field(mo17147id = 4)
    @Nullable
    public final zze zzbv;
    @SafeParcelable.Field(mo17147id = 3)
    public final int zzda;
    @SafeParcelable.Field(mo17147id = 5)
    @Nullable
    public final zzx zzdb;
    @SafeParcelable.Field(mo17147id = 6)
    @Nullable
    public final zzt zzdc;
    @SafeParcelable.Field(mo17147id = 2)
    @Nullable
    public final DriveId zzk;

    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(mo17150id = 2) DriveId driveId, @SafeParcelable.Param(mo17150id = 3) int i, @SafeParcelable.Param(mo17150id = 4) zze zze, @SafeParcelable.Param(mo17150id = 5) zzx zzx, @SafeParcelable.Param(mo17150id = 6) zzt zzt) {
        this.zzk = driveId;
        this.zzda = i;
        this.zzbv = zze;
        this.zzdb = zzx;
        this.zzdc = zzt;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzda);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbv, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzdb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzj(int i, DriveId driveId) {
        this((DriveId) Preconditions.checkNotNull(driveId), 1, (zze) null, (zzx) null, (zzt) null);
    }
}
