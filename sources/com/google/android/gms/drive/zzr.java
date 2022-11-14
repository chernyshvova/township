package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "PermissionCreator")
@SafeParcelable.Reserved({1})
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @SafeParcelable.Field(getter = "getAccountType", mo17147id = 3)
    public int accountType;
    @SafeParcelable.Field(getter = "getAccountIdentifier", mo17147id = 2)
    @Nullable
    public String zzbg;
    @SafeParcelable.Field(getter = "getAccountDisplayName", mo17147id = 4)
    @Nullable
    public String zzbh;
    @SafeParcelable.Field(getter = "getPhotoLink", mo17147id = 5)
    @Nullable
    public String zzbi;
    @SafeParcelable.Field(getter = "getRole", mo17147id = 6)
    public int zzbj;
    @SafeParcelable.Field(getter = "isLinkRequiredForAccess", mo17147id = 7)
    public boolean zzbk;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(mo17150id = 2) @Nullable String str, @SafeParcelable.Param(mo17150id = 3) int i, @SafeParcelable.Param(mo17150id = 4) @Nullable String str2, @SafeParcelable.Param(mo17150id = 5) @Nullable String str3, @SafeParcelable.Param(mo17150id = 6) int i2, @SafeParcelable.Param(mo17150id = 7) boolean z) {
        this.zzbg = str;
        this.accountType = i;
        this.zzbh = str2;
        this.zzbi = str3;
        this.zzbj = i2;
        this.zzbk = z;
    }

    public static boolean zzb(int i) {
        switch (i) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzr.class) {
            if (obj == this) {
                return true;
            }
            zzr zzr = (zzr) obj;
            return Objects.equal(this.zzbg, zzr.zzbg) && this.accountType == zzr.accountType && this.zzbj == zzr.zzbj && this.zzbk == zzr.zzbk;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbg, Integer.valueOf(this.accountType), Integer.valueOf(this.zzbj), Boolean.valueOf(this.zzbk));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        String str;
        int i2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        if (!zzb(this.accountType)) {
            str = null;
        } else {
            str = this.zzbg;
        }
        boolean z = false;
        SafeParcelWriter.writeString(parcel, 2, str, false);
        int i3 = -1;
        if (!zzb(this.accountType)) {
            i2 = -1;
        } else {
            i2 = this.accountType;
        }
        SafeParcelWriter.writeInt(parcel, 3, i2);
        SafeParcelWriter.writeString(parcel, 4, this.zzbh, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbi, false);
        int i4 = this.zzbj;
        if (i4 == 0 || i4 == 1 || i4 == 2 || i4 == 3) {
            z = true;
        }
        if (z) {
            i3 = this.zzbj;
        }
        SafeParcelWriter.writeInt(parcel, 6, i3);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
