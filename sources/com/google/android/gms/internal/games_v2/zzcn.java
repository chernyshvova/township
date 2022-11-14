package com.google.android.gms.internal.games_v2;

import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzcn implements GamesSignInClient {
    public final zzav zza;
    public final zzar zzb;

    public zzcn(zzav zzav, zzar zzar) {
        this.zza = zzav;
        this.zzb = zzar;
    }

    public final Task<AuthenticationResult> isAuthenticated() {
        return this.zza.zzc();
    }

    public final Task<String> requestServerSideAccess(String str, boolean z) {
        return this.zzb.zzb(new zzcm(str, z));
    }

    public final Task<AuthenticationResult> signIn() {
        return this.zza.zzb();
    }
}
