package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzaj {
    @WorkerThread
    public static Set<String> zza(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(str, 22), "SELECT * FROM ", str, " LIMIT 0"), (String[]) null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    @WorkerThread
    public static void zza(zzeq zzeq, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzeq != null) {
            if (!zza(zzeq, sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                Set<String> zza = zza(sQLiteDatabase, str);
                String[] split = str3.split(",");
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String str4 = split[i];
                    if (zza.remove(str4)) {
                        i++;
                    } else {
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length());
                        sb.append("Table ");
                        sb.append(str);
                        sb.append(" is missing required column: ");
                        sb.append(str4);
                        throw new SQLiteException(sb.toString());
                    }
                }
                if (strArr != null) {
                    for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                        if (!zza.remove(strArr[i2])) {
                            sQLiteDatabase.execSQL(strArr[i2 + 1]);
                        }
                    }
                }
                if (!zza.isEmpty()) {
                    zzeq.zzh().zza("Table has extra columns. table, columns", str, TextUtils.join(RESTClient.COMMA_SEPARATOR, zza));
                }
            } catch (SQLiteException e) {
                zzeq.zze().zza("Failed to verify columns on table that was just created", str);
                throw e;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    @WorkerThread
    public static boolean zza(zzeq zzeq, SQLiteDatabase sQLiteDatabase, String str) {
        if (zzeq != null) {
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, (String) null, (String) null, (String) null);
                boolean moveToFirst = query.moveToFirst();
                query.close();
                return moveToFirst;
            } catch (SQLiteException e) {
                zzeq.zzh().zza("Error querying for table", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    public static void zza(zzeq zzeq, SQLiteDatabase sQLiteDatabase) {
        if (zzeq != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                zzeq.zzh().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzeq.zzh().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzeq.zzh().zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzeq.zzh().zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
