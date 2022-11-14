package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.games_v2.zzal;
import com.google.android.gms.tasks.Task;

@zzal
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface GamesSignInClient {
    @RecentlyNonNull
    @zzal
    Task<AuthenticationResult> isAuthenticated();

    @RecentlyNonNull
    @zzal
    Task<String> requestServerSideAccess(@RecentlyNonNull String str, boolean z);

    @RecentlyNonNull
    @zzal
    Task<AuthenticationResult> signIn();
}
