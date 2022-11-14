package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@KeepForSdk
@SafeParcelable.Class(creator = "ContentsCreator")
@SafeParcelable.Reserved({1})
public class Contents extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new zzc();
    @SafeParcelable.Field(mo17147id = 4)
    public final int mode;
    @SafeParcelable.Field(mo17147id = 2)
    public final ParcelFileDescriptor zzi;
    @SafeParcelable.Field(mo17147id = 3)
    public final int zzj;
    @SafeParcelable.Field(mo17147id = 5)
    public final DriveId zzk;
    @SafeParcelable.Field(mo17147id = 7)
    public final boolean zzl;
    @SafeParcelable.Field(mo17147id = 8)
    @Nullable
    public final String zzm;

    @SafeParcelable.Constructor
    public Contents(@SafeParcelable.Param(mo17150id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(mo17150id = 3) int i, @SafeParcelable.Param(mo17150id = 4) int i2, @SafeParcelable.Param(mo17150id = 5) DriveId driveId, @SafeParcelable.Param(mo17150id = 7) boolean z, @SafeParcelable.Param(mo17150id = 8) @Nullable String str) {
        this.zzi = parcelFileDescriptor;
        this.zzj = i;
        this.mode = i2;
        this.zzk = driveId;
        this.zzl = z;
        this.zzm = str;
    }

    public final DriveId getDriveId() {
        return this.zzk;
    }

    public final InputStream getInputStream() {
        return new FileInputStream(this.zzi.getFileDescriptor());
    }

    public final int getMode() {
        return this.mode;
    }

    public final OutputStream getOutputStream() {
        return new FileOutputStream(this.zzi.getFileDescriptor());
    }

    @KeepForSdk
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzi;
    }

    public final int getRequestId() {
        return this.zzj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzi, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzj);
        SafeParcelWriter.writeInt(parcel, 4, this.mode);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzk, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzl);
        SafeParcelWriter.writeString(parcel, 8, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzb() {
        return this.zzl;
    }
}
