package com.google.android.gms.games.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.util.GmsVersion;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    public static boolean zzo(@Nullable Integer num) {
        if (num == null) {
            return false;
        }
        return GmsVersion.isAtLeastFenacho(num.intValue());
    }

    public final boolean prepareForClientVersion(int i) {
        setShouldDowngrade(!zzo(Integer.valueOf(i)));
        return true;
    }
}
