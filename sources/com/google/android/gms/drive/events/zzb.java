package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

@ShowFirstParty
@SafeParcelable.Class(creator = "ChangesAvailableEventCreator")
@SafeParcelable.Reserved({1, 2})
public final class zzb extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();
    @SafeParcelable.Field(mo17147id = 3)
    public final zze zzbv;

    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param(mo17150id = 3) zze zze) {
        this.zzbv = zze;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != zzb.class) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Objects.equal(this.zzbv, ((zzb) obj).zzbv);
    }

    public final int getType() {
        return 4;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbv);
    }

    public final String toString() {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", new Object[]{this.zzbv});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzbv, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
