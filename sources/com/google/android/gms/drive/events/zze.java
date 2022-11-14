package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

@ShowFirstParty
@SafeParcelable.Class(creator = "ChangesAvailableOptionsCreator")
@SafeParcelable.Reserved({1})
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    @SafeParcelable.Field(mo17147id = 2)
    public final int zzbw;
    @SafeParcelable.Field(mo17147id = 3)
    public final boolean zzbx;
    @SafeParcelable.Field(mo17147id = 4)
    public final List<DriveSpace> zzby;

    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(mo17150id = 2) int i, @SafeParcelable.Param(mo17150id = 3) boolean z, @SafeParcelable.Param(mo17150id = 4) @NonNull List<DriveSpace> list) {
        this.zzbw = i;
        this.zzbx = z;
        this.zzby = list;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zze.class) {
            if (obj == this) {
                return true;
            }
            zze zze = (zze) obj;
            return Objects.equal(this.zzby, zze.zzby) && this.zzbw == zze.zzbw && this.zzbx == zze.zzbx;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzby, Integer.valueOf(this.zzbw), Boolean.valueOf(this.zzbx));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzbw);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbx);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzby, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
