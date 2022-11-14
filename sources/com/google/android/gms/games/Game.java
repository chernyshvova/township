package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface Game extends Freezable<Game>, Parcelable {
    boolean areSnapshotsEnabled();

    int getAchievementTotalCount();

    @RecentlyNonNull
    String getApplicationId();

    @RecentlyNonNull
    String getDescription();

    void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    String getDeveloperName();

    void getDeveloperName(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    String getDisplayName();

    void getDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer);

    @RecentlyNonNull
    Uri getFeaturedImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getFeaturedImageUrl();

    @RecentlyNonNull
    Uri getHiResImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getHiResImageUrl();

    @RecentlyNonNull
    Uri getIconImageUri();

    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    int getLeaderboardCount();

    @RecentlyNonNull
    String getPrimaryCategory();

    @RecentlyNonNull
    String getSecondaryCategory();

    @RecentlyNonNull
    String getThemeColor();

    boolean hasGamepadSupport();

    @RecentlyNonNull
    String zza();

    boolean zzb();

    boolean zzc();

    boolean zzd();

    boolean zze();

    @Deprecated
    boolean zzf();

    @Deprecated
    boolean zzg();
}
