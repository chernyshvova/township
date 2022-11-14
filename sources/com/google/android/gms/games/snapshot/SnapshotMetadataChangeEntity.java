package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotMetadataChangeCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class SnapshotMetadataChangeEntity extends zzh implements SnapshotMetadataChange {
    @RecentlyNonNull
    public static final Parcelable.Creator<SnapshotMetadataChangeEntity> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getDescription", mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getPlayedTimeMillis", mo17147id = 2)
    public final Long zzb;
    @SafeParcelable.Field(getter = "getCoverImageUri", mo17147id = 4)
    public final Uri zzc;
    @SafeParcelable.Field(getter = "getCoverImageTeleporter", mo17147id = 5)
    public BitmapTeleporter zzd;
    @SafeParcelable.Field(getter = "getProgressValue", mo17147id = 6)
    public final Long zze;

    public SnapshotMetadataChangeEntity() {
        this((String) null, (Long) null, (BitmapTeleporter) null, (Uri) null, (Long) null);
    }

    @RecentlyNullable
    public final Bitmap getCoverImage() {
        BitmapTeleporter bitmapTeleporter = this.zzd;
        if (bitmapTeleporter == null) {
            return null;
        }
        return bitmapTeleporter.get();
    }

    @RecentlyNullable
    public final String getDescription() {
        return this.zza;
    }

    @RecentlyNullable
    public final Long getPlayedTimeMillis() {
        return this.zzb;
    }

    @RecentlyNullable
    public final Long getProgressValue() {
        return this.zze;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeLongObject(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        SafeParcelWriter.writeLongObject(parcel, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNullable
    public final BitmapTeleporter zza() {
        return this.zzd;
    }

    @SafeParcelable.Constructor
    public SnapshotMetadataChangeEntity(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) Long l, @SafeParcelable.Param(mo17150id = 5) BitmapTeleporter bitmapTeleporter, @SafeParcelable.Param(mo17150id = 4) Uri uri, @SafeParcelable.Param(mo17150id = 6) Long l2) {
        this.zza = str;
        this.zzb = l;
        this.zzd = bitmapTeleporter;
        this.zzc = uri;
        this.zze = l2;
        boolean z = true;
        if (!(bitmapTeleporter == null || uri == null)) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot set both a URI and an image");
    }
}
