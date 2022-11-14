package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class SnapshotEntity extends zzh implements Snapshot {
    @RecentlyNonNull
    public static final Parcelable.Creator<SnapshotEntity> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getMetadata", mo17147id = 1)
    public final SnapshotMetadataEntity zza;
    @SafeParcelable.Field(getter = "getSnapshotContents", mo17147id = 3)
    public final SnapshotContentsEntity zzb;

    @SafeParcelable.Constructor
    public SnapshotEntity(@RecentlyNonNull @SafeParcelable.Param(mo17150id = 1) SnapshotMetadata snapshotMetadata, @RecentlyNonNull @SafeParcelable.Param(mo17150id = 3) SnapshotContentsEntity snapshotContentsEntity) {
        this.zza = new SnapshotMetadataEntity(snapshotMetadata);
        this.zzb = snapshotContentsEntity;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Snapshot) {
            if (this == obj) {
                return true;
            }
            Snapshot snapshot = (Snapshot) obj;
            return Objects.equal(snapshot.getMetadata(), getMetadata()) && Objects.equal(snapshot.getSnapshotContents(), getSnapshotContents());
        }
    }

    @RecentlyNonNull
    public Snapshot freeze() {
        return this;
    }

    @RecentlyNonNull
    public SnapshotMetadata getMetadata() {
        return this.zza;
    }

    @RecentlyNonNull
    public SnapshotContents getSnapshotContents() {
        if (this.zzb.isClosed()) {
            return null;
        }
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(getMetadata(), getSnapshotContents());
    }

    public boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public String toString() {
        return Objects.toStringHelper(this).add("Metadata", getMetadata()).add("HasContents", Boolean.valueOf(getSnapshotContents() != null)).toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getMetadata(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getSnapshotContents(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
