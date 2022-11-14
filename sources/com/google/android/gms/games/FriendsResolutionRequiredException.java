package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class FriendsResolutionRequiredException extends ResolvableApiException {
    public FriendsResolutionRequiredException(Status status) {
        super(status);
    }

    @RecentlyNonNull
    public static FriendsResolutionRequiredException zza(@RecentlyNonNull Status status) {
        return new FriendsResolutionRequiredException(status);
    }
}
