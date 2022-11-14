package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class GameRef extends DataBufferRef implements Game {
    public GameRef(@RecentlyNonNull DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final boolean areSnapshotsEnabled() {
        return getInteger("snapshots_enabled") > 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        return GameEntity.zzm(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return new GameEntity(this);
    }

    public final int getAchievementTotalCount() {
        return getInteger("achievement_total_count");
    }

    @RecentlyNonNull
    public final String getApplicationId() {
        return getString("external_game_id");
    }

    @RecentlyNonNull
    public final String getDescription() {
        return getString("game_description");
    }

    @RecentlyNonNull
    public final String getDeveloperName() {
        return getString("developer_name");
    }

    @RecentlyNonNull
    public final String getDisplayName() {
        return getString("display_name");
    }

    @RecentlyNonNull
    public final Uri getFeaturedImageUri() {
        return parseUri("featured_image_uri");
    }

    @RecentlyNonNull
    public String getFeaturedImageUrl() {
        return getString("featured_image_url");
    }

    @RecentlyNonNull
    public final Uri getHiResImageUri() {
        return parseUri("game_hi_res_image_uri");
    }

    @RecentlyNonNull
    public String getHiResImageUrl() {
        return getString("game_hi_res_image_url");
    }

    @RecentlyNonNull
    public final Uri getIconImageUri() {
        return parseUri("game_icon_image_uri");
    }

    @RecentlyNonNull
    public String getIconImageUrl() {
        return getString("game_icon_image_url");
    }

    public final int getLeaderboardCount() {
        return getInteger("leaderboard_count");
    }

    @RecentlyNonNull
    public final String getPrimaryCategory() {
        return getString("primary_category");
    }

    @RecentlyNonNull
    public final String getSecondaryCategory() {
        return getString("secondary_category");
    }

    @RecentlyNonNull
    public final String getThemeColor() {
        return getString("theme_color");
    }

    public final boolean hasGamepadSupport() {
        return getInteger("gamepad_support") > 0;
    }

    public final int hashCode() {
        return GameEntity.zzh(this);
    }

    @RecentlyNonNull
    public final String toString() {
        return GameEntity.zzj(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        new GameEntity(this).writeToParcel(parcel, i);
    }

    @RecentlyNonNull
    public final String zza() {
        return getString("package_name");
    }

    public final boolean zzb() {
        return getBoolean("identity_sharing_confirmed");
    }

    public final boolean zzc() {
        return getInteger("installed") > 0;
    }

    public final boolean zzd() {
        return getBoolean("muted");
    }

    public final boolean zze() {
        return getBoolean("play_enabled_game");
    }

    public final boolean zzf() {
        return getInteger("real_time_support") > 0;
    }

    public final boolean zzg() {
        return getInteger("turn_based_support") > 0;
    }

    public final void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("game_description", charArrayBuffer);
    }

    public final void getDeveloperName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("developer_name", charArrayBuffer);
    }

    public final void getDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_name", charArrayBuffer);
    }
}
