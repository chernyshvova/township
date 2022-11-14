package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;

@SafeParcelable.Class(creator = "CloseContentsRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    @SafeParcelable.Field(mo17147id = 2)
    @Nullable
    public final Contents zzdf;
    @SafeParcelable.Field(mo17147id = 4)
    public final int zzdh;
    @SafeParcelable.Field(mo17147id = 3)
    public final Boolean zzdj;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzo(@SafeParcelable.Param(mo17150id = 2) Contents contents, @SafeParcelable.Param(mo17150id = 3) Boolean bool, @SafeParcelable.Param(mo17150id = 4) int i) {
        this.zzdf = contents;
        this.zzdj = bool;
        this.zzdh = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdf, i, false);
        SafeParcelWriter.writeBooleanObject(parcel, 3, this.zzdj, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzdh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @VisibleForTesting
    public zzo(int i, boolean z) {
        this((Contents) null, Boolean.FALSE, i);
    }
}
