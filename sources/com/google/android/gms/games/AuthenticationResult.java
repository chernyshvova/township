package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.games_v2.zzal;

@zzal
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class AuthenticationResult {
    @RecentlyNonNull
    public static final AuthenticationResult zza = new AuthenticationResult(true);
    @RecentlyNonNull
    public static final AuthenticationResult zzb = new AuthenticationResult(false);
    public final boolean zzc;

    public AuthenticationResult(boolean z) {
        this.zzc = z;
    }

    @zzal
    public boolean isAuthenticated() {
        return this.zzc;
    }
}
