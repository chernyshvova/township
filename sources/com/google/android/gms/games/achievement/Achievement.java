package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Player;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface Achievement extends Freezable<Achievement>, Parcelable {
    public static final int STATE_HIDDEN = 2;
    public static final int STATE_REVEALED = 1;
    public static final int STATE_UNLOCKED = 0;
    public static final int TYPE_INCREMENTAL = 1;
    public static final int TYPE_STANDARD = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public @interface AchievementState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public @interface AchievementType {
    }

    @RecentlyNonNull
    String getAchievementId();

    int getCurrentSteps();

    @RecentlyNonNull
    String getDescription();

    void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNullable
    String getFormattedCurrentSteps();

    void getFormattedCurrentSteps(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNullable
    String getFormattedTotalSteps();

    void getFormattedTotalSteps(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    long getLastUpdatedTimestamp();

    @RecentlyNonNull
    String getName();

    void getName(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    Player getPlayer();

    @RecentlyNullable
    Uri getRevealedImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getRevealedImageUrl();

    int getState();

    int getTotalSteps();

    int getType();

    @RecentlyNullable
    Uri getUnlockedImageUri();

    @KeepName
    @Deprecated
    @RecentlyNullable
    String getUnlockedImageUrl();

    long getXpValue();

    float zza();

    @RecentlyNullable
    Player zzb();

    @RecentlyNonNull
    String zzc();
}
