package com.google.android.gms.ads.mediation.customevent;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class CustomEventExtras implements NetworkExtras {
    public final HashMap<String, Object> zza = new HashMap<>();

    @RecentlyNullable
    public Object getExtra(@RecentlyNonNull String str) {
        return this.zza.get(str);
    }

    public void setExtra(@RecentlyNonNull String str, @RecentlyNonNull Object obj) {
        this.zza.put(str, obj);
    }
}
