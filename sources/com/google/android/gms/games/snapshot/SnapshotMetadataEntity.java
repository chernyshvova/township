package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotMetadataEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class SnapshotMetadataEntity extends zzh implements SnapshotMetadata {
    @RecentlyNonNull
    public static final Parcelable.Creator<SnapshotMetadataEntity> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getGame", mo17147id = 1)
    public final GameEntity zza;
    @SafeParcelable.Field(getter = "getOwner", mo17147id = 2)
    public final PlayerEntity zzb;
    @SafeParcelable.Field(getter = "getSnapshotId", mo17147id = 3)
    public final String zzc;
    @SafeParcelable.Field(getter = "getCoverImageUri", mo17147id = 5)
    @Nullable
    public final Uri zzd;
    @SafeParcelable.Field(getter = "getCoverImageUrl", mo17147id = 6)
    @Nullable
    public final String zze;
    @SafeParcelable.Field(getter = "getTitle", mo17147id = 7)
    public final String zzf;
    @SafeParcelable.Field(getter = "getDescription", mo17147id = 8)
    public final String zzg;
    @SafeParcelable.Field(getter = "getLastModifiedTimestamp", mo17147id = 9)
    public final long zzh;
    @SafeParcelable.Field(getter = "getPlayedTime", mo17147id = 10)
    public final long zzi;
    @SafeParcelable.Field(getter = "getCoverImageAspectRatio", mo17147id = 11)
    public final float zzj;
    @SafeParcelable.Field(getter = "getUniqueName", mo17147id = 12)
    public final String zzk;
    @SafeParcelable.Field(getter = "hasChangePending", mo17147id = 13)
    public final boolean zzl;
    @SafeParcelable.Field(getter = "getProgressValue", mo17147id = 14)
    public final long zzm;
    @SafeParcelable.Field(getter = "getDeviceName", mo17147id = 15)
    @Nullable
    public final String zzn;

    @SafeParcelable.Constructor
    public SnapshotMetadataEntity(@SafeParcelable.Param(mo17150id = 1) GameEntity gameEntity, @SafeParcelable.Param(mo17150id = 2) PlayerEntity playerEntity, @SafeParcelable.Param(mo17150id = 3) String str, @SafeParcelable.Param(mo17150id = 5) @Nullable Uri uri, @SafeParcelable.Param(mo17150id = 6) @Nullable String str2, @SafeParcelable.Param(mo17150id = 7) String str3, @SafeParcelable.Param(mo17150id = 8) String str4, @SafeParcelable.Param(mo17150id = 9) long j, @SafeParcelable.Param(mo17150id = 10) long j2, @SafeParcelable.Param(mo17150id = 11) float f, @SafeParcelable.Param(mo17150id = 12) String str5, @SafeParcelable.Param(mo17150id = 13) boolean z, @SafeParcelable.Param(mo17150id = 14) long j3, @SafeParcelable.Param(mo17150id = 15) @Nullable String str6) {
        this.zza = gameEntity;
        this.zzb = playerEntity;
        this.zzc = str;
        this.zzd = uri;
        this.zze = str2;
        this.zzj = f;
        this.zzf = str3;
        this.zzg = str4;
        this.zzh = j;
        this.zzi = j2;
        this.zzk = str5;
        this.zzl = z;
        this.zzm = j3;
        this.zzn = str6;
    }

    public static int zzb(SnapshotMetadata snapshotMetadata) {
        return Objects.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.zza(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName());
    }

    public static String zzc(SnapshotMetadata snapshotMetadata) {
        return Objects.toStringHelper(snapshotMetadata).add("Game", snapshotMetadata.getGame()).add("Owner", snapshotMetadata.getOwner()).add("SnapshotId", snapshotMetadata.getSnapshotId()).add("CoverImageUri", snapshotMetadata.getCoverImageUri()).add("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).add("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).add("Description", snapshotMetadata.getDescription()).add("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).add("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).add("UniqueName", snapshotMetadata.getUniqueName()).add("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).add("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).add("DeviceName", snapshotMetadata.getDeviceName()).toString();
    }

    public static boolean zzd(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return Objects.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && Objects.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && Objects.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && Objects.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && Objects.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && Objects.equal(snapshotMetadata2.zza(), snapshotMetadata.zza()) && Objects.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && Objects.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && Objects.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && Objects.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && Objects.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && Objects.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && Objects.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    public boolean equals(@Nullable Object obj) {
        return zzd(this, obj);
    }

    @RecentlyNonNull
    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.zzj;
    }

    @RecentlyNullable
    public Uri getCoverImageUri() {
        return this.zzd;
    }

    @RecentlyNullable
    public String getCoverImageUrl() {
        return this.zze;
    }

    @RecentlyNonNull
    public String getDescription() {
        return this.zzg;
    }

    public void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzg, charArrayBuffer);
    }

    @RecentlyNonNull
    public String getDeviceName() {
        return this.zzn;
    }

    @RecentlyNonNull
    public Game getGame() {
        return this.zza;
    }

    public long getLastModifiedTimestamp() {
        return this.zzh;
    }

    @RecentlyNonNull
    public Player getOwner() {
        return this.zzb;
    }

    public long getPlayedTime() {
        return this.zzi;
    }

    public long getProgressValue() {
        return this.zzm;
    }

    @RecentlyNonNull
    public String getSnapshotId() {
        return this.zzc;
    }

    @RecentlyNonNull
    public String getUniqueName() {
        return this.zzk;
    }

    public boolean hasChangePending() {
        return this.zzl;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getOwner(), i, false);
        SafeParcelWriter.writeString(parcel, 3, getSnapshotId(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getCoverImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getCoverImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 8, getDescription(), false);
        SafeParcelWriter.writeLong(parcel, 9, getLastModifiedTimestamp());
        SafeParcelWriter.writeLong(parcel, 10, getPlayedTime());
        SafeParcelWriter.writeFloat(parcel, 11, getCoverImageAspectRatio());
        SafeParcelWriter.writeString(parcel, 12, getUniqueName(), false);
        SafeParcelWriter.writeBoolean(parcel, 13, hasChangePending());
        SafeParcelWriter.writeLong(parcel, 14, getProgressValue());
        SafeParcelWriter.writeString(parcel, 15, getDeviceName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final String zza() {
        return this.zzf;
    }

    public SnapshotMetadataEntity(@RecentlyNonNull SnapshotMetadata snapshotMetadata) {
        PlayerEntity playerEntity = new PlayerEntity(snapshotMetadata.getOwner());
        this.zza = new GameEntity(snapshotMetadata.getGame());
        this.zzb = playerEntity;
        this.zzc = snapshotMetadata.getSnapshotId();
        this.zzd = snapshotMetadata.getCoverImageUri();
        this.zze = snapshotMetadata.getCoverImageUrl();
        this.zzj = snapshotMetadata.getCoverImageAspectRatio();
        this.zzf = snapshotMetadata.zza();
        this.zzg = snapshotMetadata.getDescription();
        this.zzh = snapshotMetadata.getLastModifiedTimestamp();
        this.zzi = snapshotMetadata.getPlayedTime();
        this.zzk = snapshotMetadata.getUniqueName();
        this.zzl = snapshotMetadata.hasChangePending();
        this.zzm = snapshotMetadata.getProgressValue();
        this.zzn = snapshotMetadata.getDeviceName();
    }
}
