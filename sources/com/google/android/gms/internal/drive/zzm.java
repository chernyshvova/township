package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzn;

@SafeParcelable.Class(creator = "CloseContentsAndUpdateMetadataRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();
    @SafeParcelable.Field(mo17147id = 6)
    public final String zzan;
    @SafeParcelable.Field(mo17147id = 5)
    public final boolean zzao;
    @SafeParcelable.Field(defaultValue = "true", mo17147id = 10)
    public final boolean zzat;
    @SafeParcelable.Field(mo17147id = 2)
    public final DriveId zzdd;
    @SafeParcelable.Field(mo17147id = 3)
    public final MetadataBundle zzde;
    @SafeParcelable.Field(mo17147id = 4)
    @Nullable
    public final Contents zzdf;
    @SafeParcelable.Field(mo17147id = 7)
    public final int zzdg;
    @SafeParcelable.Field(mo17147id = 8)
    public final int zzdh;
    @SafeParcelable.Field(mo17147id = 9)
    public final boolean zzdi;

    @SafeParcelable.Constructor
    public zzm(@SafeParcelable.Param(mo17150id = 2) DriveId driveId, @SafeParcelable.Param(mo17150id = 3) MetadataBundle metadataBundle, @SafeParcelable.Param(mo17150id = 4) Contents contents, @SafeParcelable.Param(mo17150id = 5) boolean z, @SafeParcelable.Param(mo17150id = 6) String str, @SafeParcelable.Param(mo17150id = 7) int i, @SafeParcelable.Param(mo17150id = 8) int i2, @SafeParcelable.Param(mo17150id = 9) boolean z2, @SafeParcelable.Param(mo17150id = 10) boolean z3) {
        this.zzdd = driveId;
        this.zzde = metadataBundle;
        this.zzdf = contents;
        this.zzao = z;
        this.zzan = str;
        this.zzdg = i;
        this.zzdh = i2;
        this.zzdi = z2;
        this.zzat = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzde, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzao);
        SafeParcelWriter.writeString(parcel, 6, this.zzan, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzdg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzdh);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzdi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzat);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @VisibleForTesting
    public zzm(DriveId driveId, MetadataBundle metadataBundle, int i, boolean z, zzn zzn) {
        this(driveId, metadataBundle, (Contents) null, zzn.zzm(), zzn.zzl(), zzn.zzn(), i, z, zzn.zzp());
    }
}
