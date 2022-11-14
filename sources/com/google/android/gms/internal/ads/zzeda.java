package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeda implements zzfqa<SQLiteDatabase> {
    public final /* synthetic */ zzfcb zza;

    public zzeda(zzedb zzedb, zzfcb zzfcb) {
        this.zza = zzfcb;
    }

    public final void zza(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzcgs.zzf(valueOf.length() != 0 ? "Failed to get offline buffered ping database: ".concat(valueOf) : new String("Failed to get offline buffered ping database: "));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str;
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                str = "Error executing function on offline buffered ping database: ".concat(valueOf);
            } else {
                str = new String("Error executing function on offline buffered ping database: ");
            }
            zzcgs.zzf(str);
        }
    }
}
