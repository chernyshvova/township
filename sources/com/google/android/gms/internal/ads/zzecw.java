package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzecw implements Runnable {
    public final SQLiteDatabase zza;
    public final String zzb;
    public final zzcgx zzc;

    public zzecw(SQLiteDatabase sQLiteDatabase, String str, zzcgx zzcgx) {
        this.zza = sQLiteDatabase;
        this.zzb = str;
        this.zzc = zzcgx;
    }

    public final void run() {
        zzedb.zzg(this.zza, this.zzb, this.zzc);
    }
}
