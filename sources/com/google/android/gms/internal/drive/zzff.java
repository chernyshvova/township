package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zza;
import com.google.android.gms.drive.zzu;
import java.util.List;

@SafeParcelable.Class(creator = "OnChangesResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzff extends zzu {
    public static final Parcelable.Creator<zzff> CREATOR = new zzfg();
    @SafeParcelable.Field(mo17147id = 2)
    public final DataHolder zzhr;
    @SafeParcelable.Field(mo17147id = 3)
    public final List<DriveId> zzhs;
    @SafeParcelable.Field(mo17147id = 4)
    public final zza zzht;
    @SafeParcelable.Field(mo17147id = 5)
    public final boolean zzhu;

    @SafeParcelable.Constructor
    public zzff(@SafeParcelable.Param(mo17150id = 2) DataHolder dataHolder, @SafeParcelable.Param(mo17150id = 3) List<DriveId> list, @SafeParcelable.Param(mo17150id = 4) zza zza, @SafeParcelable.Param(mo17150id = 5) boolean z) {
        this.zzhr = dataHolder;
        this.zzhs = list;
        this.zzht = zza;
        this.zzhu = z;
    }

    public final void zza(Parcel parcel, int i) {
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhr, i2, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzhs, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzht, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzhu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
