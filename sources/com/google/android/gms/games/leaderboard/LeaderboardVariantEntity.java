package com.google.android.gms.games.leaderboard;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.games_v2.zzah;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class LeaderboardVariantEntity implements LeaderboardVariant {
    public final int zza;
    public final int zzb;
    public final boolean zzc;
    public final long zzd;
    public final String zze;
    public final long zzf;
    public final String zzg;
    public final String zzh;
    public final long zzi;
    public final String zzj;
    public final String zzk;
    public final String zzl;

    public LeaderboardVariantEntity(@RecentlyNonNull LeaderboardVariant leaderboardVariant) {
        this.zza = leaderboardVariant.getTimeSpan();
        this.zzb = leaderboardVariant.getCollection();
        this.zzc = leaderboardVariant.hasPlayerInfo();
        this.zzd = leaderboardVariant.getRawPlayerScore();
        this.zze = leaderboardVariant.getDisplayPlayerScore();
        this.zzf = leaderboardVariant.getPlayerRank();
        this.zzg = leaderboardVariant.getDisplayPlayerRank();
        this.zzh = leaderboardVariant.getPlayerScoreTag();
        this.zzi = leaderboardVariant.getNumScores();
        this.zzj = leaderboardVariant.zza();
        this.zzk = leaderboardVariant.zzc();
        this.zzl = leaderboardVariant.zzb();
    }

    public static int zzd(LeaderboardVariant leaderboardVariant) {
        return Objects.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zza(), leaderboardVariant.zzb(), leaderboardVariant.zzc());
    }

    public static String zze(LeaderboardVariant leaderboardVariant) {
        Objects.ToStringHelper add = Objects.toStringHelper(leaderboardVariant).add("TimeSpan", zzah.zza(leaderboardVariant.getTimeSpan()));
        int collection = leaderboardVariant.getCollection();
        String str = "SOCIAL_1P";
        if (collection == -1) {
            str = "UNKNOWN";
        } else if (collection == 0) {
            str = "PUBLIC";
        } else if (collection == 1) {
            str = "SOCIAL";
        } else if (collection != 2) {
            if (collection == 3) {
                str = ShareConstants.PEOPLE_IDS;
            } else if (collection != 4) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(43, "Unknown leaderboard collection: ", collection));
            }
        }
        Objects.ToStringHelper add2 = add.add("Collection", str);
        boolean hasPlayerInfo = leaderboardVariant.hasPlayerInfo();
        String str2 = IntegrityManager.INTEGRITY_TYPE_NONE;
        Objects.ToStringHelper add3 = add2.add("RawPlayerScore", hasPlayerInfo ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : str2).add("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : str2).add("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : str2);
        if (leaderboardVariant.hasPlayerInfo()) {
            str2 = leaderboardVariant.getDisplayPlayerRank();
        }
        return add3.add("DisplayPlayerRank", str2).add("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).add("TopPageNextToken", leaderboardVariant.zza()).add("WindowPageNextToken", leaderboardVariant.zzb()).add("WindowPagePrevToken", leaderboardVariant.zzc()).toString();
    }

    public static boolean zzf(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return Objects.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && Objects.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && Objects.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && Objects.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && Objects.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && Objects.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && Objects.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && Objects.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && Objects.equal(leaderboardVariant2.zza(), leaderboardVariant.zza()) && Objects.equal(leaderboardVariant2.zzb(), leaderboardVariant.zzb()) && Objects.equal(leaderboardVariant2.zzc(), leaderboardVariant.zzc());
    }

    public final boolean equals(@Nullable Object obj) {
        return zzf(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int getCollection() {
        return this.zzb;
    }

    @RecentlyNonNull
    public final String getDisplayPlayerRank() {
        return this.zzg;
    }

    @RecentlyNonNull
    public final String getDisplayPlayerScore() {
        return this.zze;
    }

    public final long getNumScores() {
        return this.zzi;
    }

    public final long getPlayerRank() {
        return this.zzf;
    }

    @RecentlyNonNull
    public final String getPlayerScoreTag() {
        return this.zzh;
    }

    public final long getRawPlayerScore() {
        return this.zzd;
    }

    public final int getTimeSpan() {
        return this.zza;
    }

    public final boolean hasPlayerInfo() {
        return this.zzc;
    }

    public final int hashCode() {
        return zzd(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        return zze(this);
    }

    @RecentlyNonNull
    public final String zza() {
        return this.zzj;
    }

    @RecentlyNonNull
    public final String zzb() {
        return this.zzl;
    }

    @RecentlyNonNull
    public final String zzc() {
        return this.zzk;
    }
}
