package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzedb extends SQLiteOpenHelper {
    public final Context zza;
    public final zzfqo zzb;

    public zzedb(Context context, zzfqo zzfqo) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzbex.zzc().zzb(zzbjn.zzfL)).intValue());
        this.zza = context;
        this.zzb = zzfqo;
    }

    public static final /* synthetic */ void zzg(SQLiteDatabase sQLiteDatabase, String str, zzcgx zzcgx) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zzj(sQLiteDatabase, zzcgx);
    }

    public static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    public static void zzj(SQLiteDatabase sQLiteDatabase, zzcgx zzcgx) {
        sQLiteDatabase.beginTransaction();
        try {
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", new String[]{"url"}, "event_state = 1", (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            int count = query.getCount();
            String[] strArr = new String[count];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex("url");
                if (columnIndex != -1) {
                    strArr[i] = query.getString(columnIndex);
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i2 = 0; i2 < count; i2++) {
                zzcgx.zza(strArr[i2]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void zza(zzfcb<SQLiteDatabase, Void> zzfcb) {
        zzfqe.zzp(this.zzb.zzb(new zzecu(this)), new zzeda(this, zzfcb), this.zzb);
    }

    public final void zzb(SQLiteDatabase sQLiteDatabase, zzcgx zzcgx, String str) {
        this.zzb.execute(new zzecw(sQLiteDatabase, str, zzcgx));
    }

    public final void zzc(zzcgx zzcgx, String str) {
        zza(new zzecx(this, zzcgx, str));
    }

    public final void zzd(String str) {
        zza(new zzecy(this, str));
    }

    public final void zze(zzedd zzedd) {
        zza(new zzecz(this, zzedd));
    }

    public final /* synthetic */ Void zzf(zzedd zzedd, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzedd.zza));
        contentValues.put("gws_query_id", zzedd.zzb);
        contentValues.put("url", zzedd.zzc);
        contentValues.put("event_state", Integer.valueOf(zzedd.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        zzs.zzc();
        zzbs zzD = zzr.zzD(this.zza);
        if (zzD != null) {
            try {
                zzD.zzf(ObjectWrapper.wrap(this.zza));
            } catch (RemoteException e) {
                zze.zzb("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }
}
