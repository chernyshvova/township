package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeck implements zzfcb {
    public final zzecl zza;
    public final boolean zzb;
    public final ArrayList zzc;
    public final zzbbf zzd;
    public final zzbbo zze;

    public zzeck(zzecl zzecl, boolean z, ArrayList arrayList, zzbbf zzbbf, zzbbo zzbbo) {
        this.zza = zzecl;
        this.zzb = z;
        this.zzc = arrayList;
        this.zzd = zzbbf;
        this.zze = zzbbo;
    }

    public final Object zza(Object obj) {
        zzecl zzecl = this.zza;
        boolean z = this.zzb;
        ArrayList arrayList = this.zzc;
        zzbbf zzbbf = this.zzd;
        zzbbo zzbbo = this.zze;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (!zzecl.zzb.zzf.zzC()) {
            byte[] zzf = zzecm.zzf(zzecl.zzb, z, arrayList, zzbbf, zzbbo);
            ContentValues contentValues = new ContentValues();
            contentValues.put("timestamp", Long.valueOf(zzs.zzj().currentTimeMillis()));
            contentValues.put("serialized_proto_data", zzf);
            sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"}));
            if (!z) {
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"}));
            }
        }
        return null;
    }
}
