package com.google.android.gms.common.internal.service;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class Common {
    @RecentlyNonNull
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> API;
    @RecentlyNonNull
    @KeepForSdk
    public static final Api.ClientKey<zah> CLIENT_KEY = new Api.ClientKey<>();
    public static final zab zaa = new zae();
    public static final Api.AbstractClientBuilder<zah, Api.ApiOptions.NoOptions> zab;

    static {
        zac zac = new zac();
        zab = zac;
        API = new Api<>("Common.API", zac, CLIENT_KEY);
    }
}
