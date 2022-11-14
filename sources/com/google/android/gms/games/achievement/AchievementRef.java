package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class AchievementRef extends DataBufferRef implements Achievement {
    public AchievementRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        return AchievementEntity.zzf(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return new AchievementEntity(this);
    }

    @RecentlyNonNull
    public final String getAchievementId() {
        return getString("external_achievement_id");
    }

    public final int getCurrentSteps() {
        boolean z = true;
        if (getInteger("type") != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getInteger("current_steps");
    }

    @RecentlyNonNull
    public final String getDescription() {
        return getString("description");
    }

    @RecentlyNonNull
    public final String getFormattedCurrentSteps() {
        boolean z = true;
        if (getInteger("type") != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getString("formatted_current_steps");
    }

    @RecentlyNonNull
    public final String getFormattedTotalSteps() {
        boolean z = true;
        if (getInteger("type") != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getString("formatted_total_steps");
    }

    public final long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    @RecentlyNonNull
    public final String getName() {
        return getString("name");
    }

    @RecentlyNonNull
    public final Player getPlayer() {
        return (Player) Preconditions.checkNotNull(zzb());
    }

    @RecentlyNonNull
    public final Uri getRevealedImageUri() {
        return parseUri("revealed_icon_image_uri");
    }

    @RecentlyNonNull
    public String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public final int getState() {
        return getInteger("state");
    }

    public final int getTotalSteps() {
        boolean z = true;
        if (getInteger("type") != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getInteger("total_steps");
    }

    public final int getType() {
        return getInteger("type");
    }

    @RecentlyNonNull
    public final Uri getUnlockedImageUri() {
        return parseUri("unlocked_icon_image_uri");
    }

    @RecentlyNonNull
    public String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    public final long getXpValue() {
        if (!hasColumn("instance_xp_value") || hasNull("instance_xp_value")) {
            return getLong("definition_xp_value");
        }
        return getLong("instance_xp_value");
    }

    public final int hashCode() {
        return AchievementEntity.zzd(this);
    }

    @RecentlyNonNull
    public final String toString() {
        return AchievementEntity.zze(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        new AchievementEntity(this).writeToParcel(parcel, i);
    }

    public final float zza() {
        if (!hasColumn("rarity_percent") || hasNull("rarity_percent")) {
            return -1.0f;
        }
        return getFloat("rarity_percent");
    }

    @RecentlyNullable
    public final Player zzb() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return new PlayerRef(this.mDataHolder, this.mDataRow, (String) null);
    }

    @RecentlyNonNull
    public final String zzc() {
        return getString("external_game_id");
    }

    public final void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    public final void getName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }

    public final void getFormattedCurrentSteps(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getInteger("type") != 1) {
            z = false;
        }
        Asserts.checkState(z);
        copyToBuffer("formatted_current_steps", charArrayBuffer);
    }

    public final void getFormattedTotalSteps(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getInteger("type") != 1) {
            z = false;
        }
        Asserts.checkState(z);
        copyToBuffer("formatted_total_steps", charArrayBuffer);
    }
}
