package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface AchievementsClient {
    @RecentlyNonNull
    Task<Intent> getAchievementsIntent();

    void increment(@RecentlyNonNull String str, @IntRange(from = 0) int i);

    @RecentlyNonNull
    Task<Boolean> incrementImmediate(@RecentlyNonNull String str, @IntRange(from = 0) int i);

    @RecentlyNonNull
    Task<AnnotatedData<AchievementBuffer>> load(boolean z);

    void reveal(@RecentlyNonNull String str);

    @RecentlyNonNull
    Task<Void> revealImmediate(@RecentlyNonNull String str);

    void setSteps(@RecentlyNonNull String str, @IntRange(from = 0) int i);

    @RecentlyNonNull
    Task<Boolean> setStepsImmediate(@RecentlyNonNull String str, @IntRange(from = 0) int i);

    void unlock(@RecentlyNonNull String str);

    @RecentlyNonNull
    Task<Void> unlockImmediate(@RecentlyNonNull String str);
}
