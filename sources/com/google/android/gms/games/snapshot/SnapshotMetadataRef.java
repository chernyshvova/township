package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class SnapshotMetadataRef extends DataBufferRef implements SnapshotMetadata {
    public final Game zza;
    public final Player zzb;

    public SnapshotMetadataRef(@RecentlyNonNull DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zza = new GameRef(dataHolder, i);
        this.zzb = new PlayerRef(dataHolder, i, (String) null);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        return SnapshotMetadataEntity.zzd(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return new SnapshotMetadataEntity(this);
    }

    public final float getCoverImageAspectRatio() {
        float f = getFloat("cover_icon_image_height");
        float f2 = getFloat("cover_icon_image_width");
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    @RecentlyNonNull
    public final Uri getCoverImageUri() {
        return parseUri("cover_icon_image_uri");
    }

    @RecentlyNonNull
    public String getCoverImageUrl() {
        return getString("cover_icon_image_url");
    }

    @RecentlyNonNull
    public final String getDescription() {
        return getString("description");
    }

    @RecentlyNonNull
    public final String getDeviceName() {
        return getString("device_name");
    }

    @RecentlyNonNull
    public final Game getGame() {
        return this.zza;
    }

    public final long getLastModifiedTimestamp() {
        return getLong("last_modified_timestamp");
    }

    @RecentlyNonNull
    public final Player getOwner() {
        return this.zzb;
    }

    public final long getPlayedTime() {
        return getLong("duration");
    }

    public final long getProgressValue() {
        return getLong("progress_value");
    }

    @RecentlyNonNull
    public final String getSnapshotId() {
        return getString("external_snapshot_id");
    }

    @RecentlyNonNull
    public final String getUniqueName() {
        return getString("unique_name");
    }

    public final boolean hasChangePending() {
        return getInteger("pending_change_count") > 0;
    }

    public final int hashCode() {
        return SnapshotMetadataEntity.zzb(this);
    }

    @RecentlyNonNull
    public final String toString() {
        return SnapshotMetadataEntity.zzc(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        new SnapshotMetadataEntity(this).writeToParcel(parcel, i);
    }

    @RecentlyNonNull
    public final String zza() {
        return getString("title");
    }

    public final void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }
}
