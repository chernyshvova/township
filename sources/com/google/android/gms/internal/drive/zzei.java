package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.TransferPreferences;

@SafeParcelable.Class(creator = "FileUploadPreferencesImplCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public final class zzei extends AbstractSafeParcelable implements FileUploadPreferences {
    public static final Parcelable.Creator<zzei> CREATOR = new zzej();
    @SafeParcelable.Field(mo17147id = 3)
    public int zzbn;
    @SafeParcelable.Field(mo17147id = 2)
    public int zzgy;
    @SafeParcelable.Field(mo17147id = 4)
    public boolean zzgz;

    @SafeParcelable.Constructor
    public zzei(@SafeParcelable.Param(mo17150id = 2) int i, @SafeParcelable.Param(mo17150id = 3) int i2, @SafeParcelable.Param(mo17150id = 4) boolean z) {
        this.zzgy = i;
        this.zzbn = i2;
        this.zzgz = z;
    }

    public static boolean zzh(int i) {
        return i == 1 || i == 2;
    }

    public static boolean zzi(int i) {
        return i == 256 || i == 257;
    }

    public final int getBatteryUsagePreference() {
        if (!zzi(this.zzbn)) {
            return 0;
        }
        return this.zzbn;
    }

    public final int getNetworkTypePreference() {
        if (!zzh(this.zzgy)) {
            return 0;
        }
        return this.zzgy;
    }

    public final boolean isRoamingAllowed() {
        return this.zzgz;
    }

    public final void setBatteryUsagePreference(int i) {
        if (zzi(i)) {
            this.zzbn = i;
            return;
        }
        throw new IllegalArgumentException("Invalid battery usage preference value.");
    }

    public final void setNetworkTypePreference(int i) {
        if (zzh(i)) {
            this.zzgy = i;
            return;
        }
        throw new IllegalArgumentException("Invalid data connection preference value.");
    }

    public final void setRoamingAllowed(boolean z) {
        this.zzgz = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgy);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbn);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzgz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzei(TransferPreferences transferPreferences) {
        this(transferPreferences.getNetworkPreference(), transferPreferences.getBatteryUsagePreference(), transferPreferences.isRoamingAllowed());
    }
}
