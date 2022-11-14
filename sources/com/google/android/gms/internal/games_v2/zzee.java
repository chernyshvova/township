package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzee implements PlayersClient {
    public final zzar zza;

    public zzee(zzar zzar) {
        this.zza = zzar;
    }

    private final Task<AnnotatedData<PlayerBuffer>> zza(String str, int i) {
        return this.zza.zzb(new zzdn(str, i));
    }

    private final Task<AnnotatedData<PlayerBuffer>> zzb(String str, int i, boolean z) {
        return this.zza.zzb(new zzdo(str, i, z));
    }

    public final Task<Intent> getCompareProfileIntent(@NonNull Player player) {
        return this.zza.zzb(new zzed(player));
    }

    public final Task<Intent> getCompareProfileIntentWithAlternativeNameHints(String str, @Nullable String str2, @Nullable String str3) {
        return this.zza.zzb(new zzdp(str, str2, str3));
    }

    public final Task<Player> getCurrentPlayer() {
        return this.zza.zzb(zzds.zza);
    }

    public final Task<String> getCurrentPlayerId() {
        return this.zza.zzb(zzdt.zza);
    }

    public final Task<Intent> getPlayerSearchIntent() {
        return this.zza.zzb(zzdu.zza);
    }

    public final Task<AnnotatedData<PlayerBuffer>> loadFriends(int i, boolean z) {
        return zzb("friends_all", i, z);
    }

    public final Task<AnnotatedData<PlayerBuffer>> loadMoreFriends(int i) {
        return zza("friends_all", i);
    }

    public final Task<AnnotatedData<PlayerBuffer>> loadMoreRecentlyPlayedWithPlayers(int i) {
        return zza("played_with", i);
    }

    public final Task<AnnotatedData<Player>> loadPlayer(@NonNull String str) {
        return this.zza.zzb(new zzdq(str, false));
    }

    public final Task<AnnotatedData<PlayerBuffer>> loadRecentlyPlayedWithPlayers(int i, boolean z) {
        return zzb("played_with", i, z);
    }

    public final Task<Intent> getCompareProfileIntent(String str) {
        return this.zza.zzb(new zzdp(str, (String) null, (String) null));
    }

    public final Task<AnnotatedData<Player>> getCurrentPlayer(boolean z) {
        return this.zza.zzb(new zzdr(z));
    }

    public final Task<AnnotatedData<Player>> loadPlayer(@NonNull String str, boolean z) {
        return this.zza.zzb(new zzdq(str, z));
    }
}
