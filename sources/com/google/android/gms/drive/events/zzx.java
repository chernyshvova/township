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
import java.util.Locale;

@ShowFirstParty
@SafeParcelable.Class(creator = "TransferStateOptionsCreator")
@SafeParcelable.Reserved({1})
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    @SafeParcelable.Field(mo17147id = 2)
    public final List<DriveSpace> zzby;

    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(mo17150id = 2) @NonNull List<DriveSpace> list) {
        this.zzby = list;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != zzx.class) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Objects.equal(this.zzby, ((zzx) obj).zzby);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzby);
    }

    public final String toString() {
        return String.format(Locale.US, "TransferStateOptions[Spaces=%s]", new Object[]{this.zzby});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzby, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
