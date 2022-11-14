package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.internal.player.zza;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface Player extends Freezable<Player>, Parcelable {
    public static final long CURRENT_XP_UNKNOWN = -1;
    public static final long TIMESTAMP_UNKNOWN = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public @interface FriendsListVisibilityStatus {
        public static final int FEATURE_UNAVAILABLE = 3;
        public static final int REQUEST_REQUIRED = 2;
        public static final int UNKNOWN = 0;
        public static final int VISIBLE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public @interface PlayerFriendStatus {
        public static final int FRIEND = 4;
        public static final int NO_RELATIONSHIP = 0;
        public static final int UNKNOWN = -1;
    }

    @RecentlyNullable
    Uri getBannerImageLandscapeUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getBannerImageLandscapeUrl();

    @RecentlyNullable
    Uri getBannerImagePortraitUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getBannerImagePortraitUrl();

    @RecentlyNullable
    CurrentPlayerInfo getCurrentPlayerInfo();

    @RecentlyNonNull
    String getDisplayName();

    void getDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNullable
    Uri getHiResImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getHiResImageUrl();

    @RecentlyNullable
    Uri getIconImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getIconImageUrl();

    @Deprecated
    long getLastPlayedWithTimestamp();

    @RecentlyNullable
    PlayerLevelInfo getLevelInfo();

    @RecentlyNonNull
    String getPlayerId();

    @RecentlyNullable
    PlayerRelationshipInfo getRelationshipInfo();

    long getRetrievedTimestamp();

    @RecentlyNullable
    String getTitle();

    void getTitle(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    boolean hasHiResImage();

    boolean hasIconImage();

    @Deprecated
    int zza();

    long zzb();

    @Nullable
    zza zzc();

    @RecentlyNullable
    String zzd();

    @RecentlyNonNull
    String zze();

    boolean zzf();

    boolean zzg();

    boolean zzh();
}
