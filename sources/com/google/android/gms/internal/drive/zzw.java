package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "CreateFileRequestCreator")
@SafeParcelable.Reserved({1, 10})
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzx();
    @SafeParcelable.Field(mo17147id = 7)
    public final String zzan;
    @SafeParcelable.Field(mo17147id = 4)
    public final Contents zzdf;
    @SafeParcelable.Field(mo17147id = 3)
    public final MetadataBundle zzdn;
    @SafeParcelable.Field(mo17147id = 5)
    public final Integer zzdo;
    @SafeParcelable.Field(mo17147id = 2)
    public final DriveId zzdp;
    @SafeParcelable.Field(mo17147id = 6)
    public final boolean zzdq;
    @SafeParcelable.Field(mo17147id = 8)
    public final int zzdr;
    @SafeParcelable.Field(mo17147id = 9)
    public final int zzds;

    @SafeParcelable.Constructor
    public zzw(@SafeParcelable.Param(mo17150id = 2) DriveId driveId, @SafeParcelable.Param(mo17150id = 3) MetadataBundle metadataBundle, @SafeParcelable.Param(mo17150id = 4) Contents contents, @SafeParcelable.Param(mo17150id = 5) int i, @SafeParcelable.Param(mo17150id = 6) boolean z, @SafeParcelable.Param(mo17150id = 7) String str, @SafeParcelable.Param(mo17150id = 8) int i2, @SafeParcelable.Param(mo17150id = 9) int i3) {
        if (!(contents == null || i3 == 0)) {
            Preconditions.checkArgument(contents.getRequestId() == i3, "inconsistent contents reference");
        }
        if (i == 0 && contents == null && i3 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.zzdp = (DriveId) Preconditions.checkNotNull(driveId);
        this.zzdn = (MetadataBundle) Preconditions.checkNotNull(metadataBundle);
        this.zzdf = contents;
        this.zzdo = Integer.valueOf(i);
        this.zzan = str;
        this.zzdr = i2;
        this.zzdq = z;
        this.zzds = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdp, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdf, i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, this.zzdo, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzdq);
        SafeParcelWriter.writeString(parcel, 7, this.zzan, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zzdr);
        SafeParcelWriter.writeInt(parcel, 9, this.zzds);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @VisibleForTesting
    public zzw(DriveId driveId, MetadataBundle metadataBundle, int i, int i2, ExecutionOptions executionOptions) {
        this(driveId, metadataBundle, (Contents) null, i2, executionOptions.zzm(), executionOptions.zzl(), executionOptions.zzn(), i);
    }
}
