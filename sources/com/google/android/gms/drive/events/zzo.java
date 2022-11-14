package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzu;

@SafeParcelable.Class(creator = "QueryResultEventParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzo extends zzu implements DriveEvent {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    @SafeParcelable.Field(mo17147id = 2)
    @Nullable
    public final DataHolder zzav;
    @SafeParcelable.Field(mo17147id = 3)
    public final boolean zzcq;
    @SafeParcelable.Field(mo17147id = 4)
    public final int zzcr;

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(mo17150id = 2) @Nullable DataHolder dataHolder, @SafeParcelable.Param(mo17150id = 3) boolean z, @SafeParcelable.Param(mo17150id = 4) int i) {
        this.zzav = dataHolder;
        this.zzcq = z;
        this.zzcr = i;
    }

    public final int getType() {
        return 3;
    }

    public final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzav, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzcq);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcr);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzaa() {
        return this.zzcq;
    }

    public final int zzab() {
        return this.zzcr;
    }

    @Nullable
    public final DataHolder zzz() {
        return this.zzav;
    }
}
