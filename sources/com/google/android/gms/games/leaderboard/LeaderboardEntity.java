package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class LeaderboardEntity implements Leaderboard {
    public final String zza;
    public final String zzb;
    public final Uri zzc;
    public final int zzd;
    public final ArrayList<LeaderboardVariantEntity> zze;
    public final Game zzf;
    public final String zzg;

    public LeaderboardEntity(@RecentlyNonNull Leaderboard leaderboard) {
        GameEntity gameEntity;
        this.zza = leaderboard.getLeaderboardId();
        this.zzb = leaderboard.getDisplayName();
        this.zzc = leaderboard.getIconImageUri();
        this.zzg = leaderboard.getIconImageUrl();
        this.zzd = leaderboard.getScoreOrder();
        Game zza2 = leaderboard.zza();
        if (zza2 == null) {
            gameEntity = null;
        } else {
            gameEntity = new GameEntity(zza2);
        }
        this.zzf = gameEntity;
        ArrayList<LeaderboardVariant> variants = leaderboard.getVariants();
        int size = variants.size();
        this.zze = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.zze.add(variants.get(i).freeze());
        }
    }

    public static int zzb(Leaderboard leaderboard) {
        return Objects.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    public static String zzc(Leaderboard leaderboard) {
        return Objects.toStringHelper(leaderboard).add("LeaderboardId", leaderboard.getLeaderboardId()).add("DisplayName", leaderboard.getDisplayName()).add("IconImageUri", leaderboard.getIconImageUri()).add("IconImageUrl", leaderboard.getIconImageUrl()).add("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).add("Variants", leaderboard.getVariants()).toString();
    }

    public static boolean zzd(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return Objects.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && Objects.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && Objects.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && Objects.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && Objects.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    public final boolean equals(@Nullable Object obj) {
        return zzd(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @RecentlyNonNull
    public final String getDisplayName() {
        return this.zzb;
    }

    public final void getDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @RecentlyNonNull
    public final Uri getIconImageUri() {
        return this.zzc;
    }

    @RecentlyNonNull
    public String getIconImageUrl() {
        return this.zzg;
    }

    @RecentlyNonNull
    public final String getLeaderboardId() {
        return this.zza;
    }

    public final int getScoreOrder() {
        return this.zzd;
    }

    @RecentlyNonNull
    public final ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<>(this.zze);
    }

    public final int hashCode() {
        return zzb(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        return zzc(this);
    }

    @RecentlyNonNull
    public final Game zza() {
        throw null;
    }
}
