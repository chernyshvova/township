package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.TransferPreferences;

@SafeParcelable.Class(creator = "ParcelableTransferPreferencesCreator")
@SafeParcelable.Reserved({1})
public final class zzgo extends AbstractSafeParcelable implements TransferPreferences {
    public static final Parcelable.Creator<zzgo> CREATOR = new zzgp();
    @SafeParcelable.Field(mo17147id = 4)
    public final boolean zzbm;
    @SafeParcelable.Field(mo17147id = 3)
    public final int zzbn;
    @SafeParcelable.Field(mo17147id = 2)
    public final int zzgy;

    @SafeParcelable.Constructor
    public zzgo(@SafeParcelable.Param(mo17150id = 2) int i, @SafeParcelable.Param(mo17150id = 3) int i2, @SafeParcelable.Param(mo17150id = 4) boolean z) {
        this.zzgy = i;
        this.zzbn = i2;
        this.zzbm = z;
    }

    public final int getBatteryUsagePreference() {
        return this.zzbn;
    }

    public final int getNetworkPreference() {
        return this.zzgy;
    }

    public final boolean isRoamingAllowed() {
        return this.zzbm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgy);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbn);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
