package com.google.android.gms.internal.games_v2;

import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.PlayerStatsClient;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzdl implements PlayerStatsClient {
    public final zzar zza;

    public zzdl(zzar zzar) {
        this.zza = zzar;
    }

    public final Task<AnnotatedData<PlayerStats>> loadPlayerStats(boolean z) {
        return this.zza.zzb(new zzdk(z));
    }
}
