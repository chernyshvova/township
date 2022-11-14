package com.google.android.gms.internal.games_v2;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzah {
    public static String zza(int i) {
        if (i == 0) {
            return "DAILY";
        }
        if (i == 1) {
            return "WEEKLY";
        }
        if (i == 2) {
            return "ALL_TIME";
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(29, "Unknown time span ", i));
    }
}
