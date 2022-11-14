package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzecp implements zzfcb {
    public final zzect zza;
    public final boolean zzb;

    public zzecp(zzect zzect, boolean z) {
        this.zza = zzect;
        this.zzb = z;
    }

    public final Object zza(Object obj) {
        this.zza.zzb(this.zzb, (SQLiteDatabase) obj);
        return null;
    }
}
