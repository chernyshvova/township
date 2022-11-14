package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

@SafeParcelable.Class(creator = "CustomPropertyCreator")
@SafeParcelable.Reserved({1})
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();
    @SafeParcelable.Field(mo17147id = 3)
    @Nullable
    public final String value;
    @SafeParcelable.Field(mo17147id = 2)
    public final CustomPropertyKey zzje;

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(mo17150id = 2) CustomPropertyKey customPropertyKey, @SafeParcelable.Param(mo17150id = 3) @Nullable String str) {
        Preconditions.checkNotNull(customPropertyKey, "key");
        this.zzje = customPropertyKey;
        this.value = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzc.class) {
            zzc zzc = (zzc) obj;
            return Objects.equal(this.zzje, zzc.zzje) && Objects.equal(this.value, zzc.value);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzje, this.value);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzje, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
