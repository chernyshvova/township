package com.google.android.gms.internal.games_v2;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzfo {
    public static <T> T zza(@CheckForNull T t) {
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("expected a non-null reference", 0, 29);
        throw new zzfp(sb.toString());
    }
}
