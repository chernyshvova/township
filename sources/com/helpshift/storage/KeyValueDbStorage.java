package com.helpshift.storage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.helpshift.p042db.key_value.tables.KeyValueTable;
import com.helpshift.util.ByteArrayUtil;
import com.helpshift.util.DatabaseUtils;
import com.helpshift.util.HSLogger;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class KeyValueDbStorage implements KeyValueStorage {
    public static final String TAG = "HS_KeyValueDB";
    public SQLiteOpenHelper helper;

    public KeyValueDbStorage(SQLiteOpenHelper sQLiteOpenHelper) {
        this.helper = sQLiteOpenHelper;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.database.Cursor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object get(java.lang.String r11) {
        /*
            r10 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.database.sqlite.SQLiteOpenHelper r0 = r10.helper     // Catch:{ all -> 0x0035 }
            android.database.sqlite.SQLiteDatabase r2 = r0.getReadableDatabase()     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "key=?"
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ all -> 0x0035 }
            r3 = 0
            r6[r3] = r11     // Catch:{ all -> 0x0035 }
            java.lang.String r3 = "key_value_store"
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0035 }
            boolean r2 = r11.moveToFirst()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x002e
            byte[] r0 = r11.getBlob(r0)     // Catch:{ Exception -> 0x002e }
            java.lang.Object r1 = com.helpshift.util.ByteArrayUtil.toObject(r0)     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            r11.close()
            return r1
        L_0x0032:
            r0 = move-exception
            r1 = r11
            goto L_0x0036
        L_0x0035:
            r0 = move-exception
        L_0x0036:
            if (r1 == 0) goto L_0x003b
            r1.close()
        L_0x003b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.storage.KeyValueDbStorage.get(java.lang.String):java.lang.Object");
    }

    public void removeAllKeys() {
        this.helper.getWritableDatabase().delete(KeyValueTable.TABLE_NAME, (String) null, (String[]) null);
    }

    public void removeKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.helper.getWritableDatabase().delete(KeyValueTable.TABLE_NAME, "key=?", new String[]{str});
        }
    }

    public boolean set(String str, Serializable serializable) {
        if (!TextUtils.isEmpty(str) && serializable != null) {
            SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
            String[] strArr = {str};
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            try {
                contentValues.put("value", ByteArrayUtil.toByteArray(serializable));
                if (DatabaseUtils.exists(writableDatabase, KeyValueTable.TABLE_NAME, "key=?", strArr)) {
                    writableDatabase.update(KeyValueTable.TABLE_NAME, contentValues, "key=?", strArr);
                } else if (writableDatabase.insert(KeyValueTable.TABLE_NAME, (String) null, contentValues) == -1) {
                    throw new SQLiteException("DB insert failed and return -1");
                }
                return true;
            } catch (IOException e) {
                HSLogger.m3242e(TAG, "Error in serializing value", e);
            }
        }
        return false;
    }

    public boolean setKeyValues(Map<String, Serializable> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
        SQLiteStatement compileStatement = writableDatabase.compileStatement("INSERT INTO key_value_store VALUES (?,?)");
        SQLiteStatement compileStatement2 = writableDatabase.compileStatement("UPDATE key_value_store SET value = ? WHERE key = ?");
        writableDatabase.beginTransaction();
        for (Map.Entry next : map.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) next.getKey()) && next.getValue() != null) {
                try {
                    String[] strArr = {(String) next.getKey()};
                    byte[] byteArray = ByteArrayUtil.toByteArray(next.getValue());
                    if (DatabaseUtils.exists(writableDatabase, KeyValueTable.TABLE_NAME, "key=?", strArr)) {
                        compileStatement2.bindString(2, (String) next.getKey());
                        compileStatement2.bindBlob(1, byteArray);
                        compileStatement2.execute();
                        compileStatement2.clearBindings();
                    } else {
                        compileStatement.bindString(1, (String) next.getKey());
                        compileStatement.bindBlob(2, byteArray);
                        compileStatement.execute();
                        compileStatement.clearBindings();
                    }
                } catch (IOException e) {
                    HSLogger.m3242e(TAG, "Error in serializing value", e);
                }
            }
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        return true;
    }
}
