package com.google.android.gms.games;

import android.app.Activity;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.games_v2.zzal;
import com.google.android.gms.internal.games_v2.zzar;
import com.google.android.gms.internal.games_v2.zzax;
import com.google.android.gms.internal.games_v2.zzbq;
import com.google.android.gms.internal.games_v2.zzcd;
import com.google.android.gms.internal.games_v2.zzck;
import com.google.android.gms.internal.games_v2.zzcn;
import com.google.android.gms.internal.games_v2.zzdi;
import com.google.android.gms.internal.games_v2.zzdl;
import com.google.android.gms.internal.games_v2.zzee;
import com.google.android.gms.internal.games_v2.zzex;
import com.google.android.gms.internal.games_v2.zzfm;

@ShowFirstParty
@zzal
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class PlayGames {
    @RecentlyNonNull
    @zzal
    public static AchievementsClient getAchievementsClient(@RecentlyNonNull Activity activity) {
        zzbq.zzb();
        return new zzcd(zzar.zza(zzbq.zza()));
    }

    @RecentlyNonNull
    @zzal
    public static EventsClient getEventsClient(@RecentlyNonNull Activity activity) {
        zzbq.zzb();
        return new zzck(zzar.zza(zzbq.zza()));
    }

    @RecentlyNonNull
    @zzal
    public static GamesSignInClient getGamesSignInClient(@RecentlyNonNull Activity activity) {
        zzbq.zzb();
        return new zzcn(zzax.zza(zzbq.zza()), zzar.zza(zzbq.zza()));
    }

    @RecentlyNonNull
    @zzal
    public static LeaderboardsClient getLeaderboardsClient(@RecentlyNonNull Activity activity) {
        zzbq.zzb();
        return new zzdi(zzar.zza(zzbq.zza()));
    }

    @RecentlyNonNull
    @zzal
    public static PlayerStatsClient getPlayerStatsClient(@RecentlyNonNull Activity activity) {
        zzbq.zzb();
        return new zzdl(zzar.zza(zzbq.zza()));
    }

    @RecentlyNonNull
    @zzal
    public static PlayersClient getPlayersClient(@RecentlyNonNull Activity activity) {
        zzbq.zzb();
        return new zzee(zzar.zza(zzbq.zza()));
    }

    @RecentlyNonNull
    @zzal
    public static SnapshotsClient getSnapshotsClient(@RecentlyNonNull Activity activity) {
        zzbq.zzb();
        return new zzex(zzar.zza(zzbq.zza()));
    }

    @RecentlyNonNull
    @zzal
    public static VideosClient getVideosClient(@RecentlyNonNull Activity activity) {
        zzbq.zzb();
        return new zzfm(zzar.zza(zzbq.zza()));
    }
}
