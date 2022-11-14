package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzerw implements Callable {
    public final zzerx zza;

    public zzerw(zzerx zzerx) {
        this.zza = zzerx;
    }

    public final Object call() {
        return new zzery(new JSONObject());
    }
}
