package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.drive.zzh;
import java.util.List;

@ShowFirstParty
@SafeParcelable.Class(creator = "TransferStateEventCreator")
@SafeParcelable.Reserved({1, 2})
public final class zzv extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();
    @SafeParcelable.Field(mo17147id = 3)
    public final List<zzh> zzcu;

    @SafeParcelable.Constructor
    public zzv(@SafeParcelable.Param(mo17150id = 3) List<zzh> list) {
        this.zzcu = list;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != zzv.class) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Objects.equal(this.zzcu, ((zzv) obj).zzcu);
    }

    public final int getType() {
        return 7;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzcu);
    }

    public final String toString() {
        return String.format("TransferStateEvent[%s]", new Object[]{TextUtils.join("','", this.zzcu)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzcu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
