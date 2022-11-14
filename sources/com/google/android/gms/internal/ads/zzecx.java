package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzecx implements zzfcb {
    public final zzedb zza;
    public final zzcgx zzb;
    public final String zzc;

    public zzecx(zzedb zzedb, zzcgx zzcgx, String str) {
        this.zza = zzedb;
        this.zzb = zzcgx;
        this.zzc = str;
    }

    public final Object zza(Object obj) {
        this.zza.zzb((SQLiteDatabase) obj, this.zzb, this.zzc);
        return null;
    }
}
