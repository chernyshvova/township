package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "UserMetadataCreator")
@SafeParcelable.Reserved({1})
public class UserMetadata extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<UserMetadata> CREATOR = new zzt();
    @SafeParcelable.Field(mo17147id = 2)
    public final String zzbo;
    @SafeParcelable.Field(mo17147id = 3)
    @Nullable
    public final String zzbp;
    @SafeParcelable.Field(mo17147id = 4)
    @Nullable
    public final String zzbq;
    @SafeParcelable.Field(mo17147id = 5)
    public final boolean zzbr;
    @SafeParcelable.Field(mo17147id = 6)
    @Nullable
    public final String zzbs;

    @SafeParcelable.Constructor
    public UserMetadata(@SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) @Nullable String str2, @SafeParcelable.Param(mo17150id = 4) @Nullable String str3, @SafeParcelable.Param(mo17150id = 5) boolean z, @SafeParcelable.Param(mo17150id = 6) @Nullable String str4) {
        this.zzbo = str;
        this.zzbp = str2;
        this.zzbq = str3;
        this.zzbr = z;
        this.zzbs = str4;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.zzbo, this.zzbp, this.zzbq, Boolean.valueOf(this.zzbr), this.zzbs});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbo, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbp, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbq, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbr);
        SafeParcelWriter.writeString(parcel, 6, this.zzbs, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
