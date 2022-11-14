package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzecy implements zzfcb {
    public final zzedb zza;
    public final String zzb;

    public zzecy(zzedb zzedb, String str) {
        this.zza = zzedb;
        this.zzb = str;
    }

    public final Object zza(Object obj) {
        zzedb.zzi((SQLiteDatabase) obj, this.zzb);
        return null;
    }
}
