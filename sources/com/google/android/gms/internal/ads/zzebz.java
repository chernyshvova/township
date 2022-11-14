package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzebz implements Callable {
    public final zzebx zza;

    public zzebz(zzebx zzebx) {
        this.zza = zzebx;
    }

    public static Callable zza(zzebx zzebx) {
        return new zzebz(zzebx);
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
