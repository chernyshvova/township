package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzecu implements Callable {
    public final zzedb zza;

    public zzecu(zzedb zzedb) {
        this.zza = zzedb;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
