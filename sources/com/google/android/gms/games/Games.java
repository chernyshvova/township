package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games_v2.zzd;
import com.google.android.gms.internal.games_v2.zzf;
import com.google.android.gms.internal.games_v2.zzg;
import com.google.android.gms.internal.games_v2.zzh;
import com.google.android.gms.internal.games_v2.zzi;
import com.google.android.gms.internal.games_v2.zzj;
import com.google.android.gms.internal.games_v2.zzk;
import com.google.android.gms.internal.games_v2.zzl;

@ShowFirstParty
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class Games {
    public static final Api.ClientKey<zzas> zza = new Api.ClientKey<>();
    @RecentlyNonNull
    public static final Scope zzb = new Scope(Scopes.GAMES);
    @RecentlyNonNull
    public static final Scope zzc = new Scope(Scopes.GAMES_LITE);
    @RecentlyNonNull
    public static final Scope zzd = new Scope(Scopes.DRIVE_APPFOLDER);
    @RecentlyNonNull
    @Deprecated
    public static final Api<zzm> zze = new Api<>("Games.API", zzp, zza);
    @RecentlyNonNull
    @ShowFirstParty
    public static final Scope zzf = new Scope(FirstPartyScopes.GAMES_1P);
    @RecentlyNonNull
    @ShowFirstParty
    public static final Api<zzm> zzg = new Api<>("Games.API_1P", zzq, zza);
    @RecentlyNonNull
    @Deprecated
    public static final GamesMetadata zzh = new zzg();
    @RecentlyNonNull
    @Deprecated
    public static final Achievements zzi = new zzd();
    @RecentlyNonNull
    @Deprecated
    public static final Events zzj = new zzf();
    @RecentlyNonNull
    @Deprecated
    public static final Leaderboards zzk = new zzh();
    @RecentlyNonNull
    @Deprecated
    public static final Players zzl = new zzi();
    @RecentlyNonNull
    @Deprecated
    public static final Snapshots zzm = new zzj();
    @RecentlyNonNull
    @Deprecated
    public static final Stats zzn = new zzk();
    @RecentlyNonNull
    @Deprecated
    public static final Videos zzo = new zzl();
    public static final Api.AbstractClientBuilder<zzas, zzm> zzp = new zzf();
    public static final Api.AbstractClientBuilder<zzas, zzm> zzq = new zzg();

    @KeepForSdk
    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public interface GetServerAuthCodeResult extends Result {
        @RecentlyNonNull
        @KeepForSdk
        String getCode();
    }
}
