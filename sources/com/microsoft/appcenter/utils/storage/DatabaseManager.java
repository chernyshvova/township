package com.microsoft.appcenter.utils.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.persistence.DatabasePersistence;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.io.Closeable;
import java.util.Arrays;

public class DatabaseManager implements Closeable {
    public static final String[] SELECT_PRIMARY_KEY = {"oid"};
    public final Context mContext;
    public final String mDatabase;
    public final String mDefaultTable;
    public final Listener mListener;
    public SQLiteOpenHelper mSQLiteOpenHelper;
    public final ContentValues mSchema;

    public interface Listener {
    }

    public DatabaseManager(Context context, String str, String str2, int i, ContentValues contentValues, String str3, @NonNull Listener listener) {
        this.mContext = context;
        this.mDatabase = str;
        this.mDefaultTable = str2;
        this.mSchema = contentValues;
        this.mListener = listener;
        this.mSQLiteOpenHelper = new SQLiteOpenHelper(context, str, (SQLiteDatabase.CursorFactory) null, i, str3) {
            public final /* synthetic */ String val$sqlCreateCommand;

            {
                this.val$sqlCreateCommand = r6;
            }

            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL(this.val$sqlCreateCommand);
                if (((DatabasePersistence.C29701) DatabaseManager.this.mListener) != null) {
                    sQLiteDatabase.execSQL("CREATE INDEX `ix_logs_priority` ON logs (`priority`)");
                    return;
                }
                throw null;
            }

            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                if (((DatabasePersistence.C29701) DatabaseManager.this.mListener) != null) {
                    sQLiteDatabase.execSQL("DROP TABLE `logs`");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `logs`(`oid` INTEGER PRIMARY KEY AUTOINCREMENT,`target_token` TEXT,`type` TEXT,`priority` INTEGER,`log` TEXT,`persistence_group` TEXT,`target_key` TEXT);");
                    sQLiteDatabase.execSQL("CREATE INDEX `ix_logs_priority` ON logs (`priority`)");
                    return;
                }
                throw null;
            }
        };
    }

    public ContentValues buildValues(Cursor cursor) {
        ContentValues contentValues = this.mSchema;
        ContentValues contentValues2 = new ContentValues();
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            if (!cursor.isNull(i)) {
                String columnName = cursor.getColumnName(i);
                if (columnName.equals("oid")) {
                    contentValues2.put(columnName, Long.valueOf(cursor.getLong(i)));
                } else {
                    Object obj = contentValues.get(columnName);
                    if (obj instanceof byte[]) {
                        contentValues2.put(columnName, cursor.getBlob(i));
                    } else if (obj instanceof Double) {
                        contentValues2.put(columnName, Double.valueOf(cursor.getDouble(i)));
                    } else if (obj instanceof Float) {
                        contentValues2.put(columnName, Float.valueOf(cursor.getFloat(i)));
                    } else if (obj instanceof Integer) {
                        contentValues2.put(columnName, Integer.valueOf(cursor.getInt(i)));
                    } else if (obj instanceof Long) {
                        contentValues2.put(columnName, Long.valueOf(cursor.getLong(i)));
                    } else if (obj instanceof Short) {
                        contentValues2.put(columnName, Short.valueOf(cursor.getShort(i)));
                    } else if (obj instanceof Boolean) {
                        boolean z = true;
                        if (cursor.getInt(i) != 1) {
                            z = false;
                        }
                        contentValues2.put(columnName, Boolean.valueOf(z));
                    } else {
                        contentValues2.put(columnName, cursor.getString(i));
                    }
                }
            }
        }
        return contentValues2;
    }

    public void close() {
        try {
            this.mSQLiteOpenHelper.close();
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to close the database.", e);
        }
    }

    public void delete(@IntRange(from = 0) long j) {
        delete(this.mDefaultTable, "oid", Long.valueOf(j));
    }

    public Cursor getCursor(@Nullable SQLiteQueryBuilder sQLiteQueryBuilder, String[] strArr, @Nullable String[] strArr2, @Nullable String str) throws RuntimeException {
        String str2 = this.mDefaultTable;
        if (sQLiteQueryBuilder == null) {
            sQLiteQueryBuilder = new SQLiteQueryBuilder();
        }
        SQLiteQueryBuilder sQLiteQueryBuilder2 = sQLiteQueryBuilder;
        sQLiteQueryBuilder2.setTables(str2);
        return sQLiteQueryBuilder2.query(getDatabase(), strArr, (String) null, strArr2, (String) null, (String) null, str);
    }

    @VisibleForTesting
    public SQLiteDatabase getDatabase() {
        try {
            return this.mSQLiteOpenHelper.getWritableDatabase();
        } catch (RuntimeException e) {
            AppCenterLog.warn("AppCenter", "Failed to open database. Trying to delete database (may be corrupted).", e);
            if (this.mContext.deleteDatabase(this.mDatabase)) {
                AppCenterLog.info("AppCenter", "The database was successfully deleted.");
            } else {
                AppCenterLog.warn("AppCenter", "Failed to delete database.");
            }
            return this.mSQLiteOpenHelper.getWritableDatabase();
        }
    }

    public long put(@NonNull ContentValues contentValues, @NonNull String str) {
        Long l = null;
        Cursor cursor = null;
        while (l == null) {
            try {
                l = Long.valueOf(getDatabase().insertOrThrow(this.mDefaultTable, (String) null, contentValues));
            } catch (SQLiteFullException e) {
                AppCenterLog.debug("AppCenter", "Storage is full, trying to delete the oldest log that has the lowest priority which is lower or equal priority than the new log");
                if (cursor == null) {
                    String asString = contentValues.getAsString(str);
                    SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
                    sQLiteQueryBuilder.appendWhere(str + " <= ?");
                    cursor = getCursor(sQLiteQueryBuilder, SELECT_PRIMARY_KEY, new String[]{asString}, str + " , " + "oid");
                }
                if (cursor.moveToNext()) {
                    long j = cursor.getLong(0);
                    delete(j);
                    AppCenterLog.debug("AppCenter", "Deleted log id=" + j);
                } else {
                    throw e;
                }
            } catch (RuntimeException e2) {
                l = -1L;
                AppCenterLog.error("AppCenter", String.format("Failed to insert values (%s) to database %s.", new Object[]{contentValues.toString(), this.mDatabase}), e2);
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (RuntimeException unused) {
            }
        }
        return l.longValue();
    }

    public final int delete(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        String[] strArr = {String.valueOf(obj)};
        try {
            SQLiteDatabase database = getDatabase();
            return database.delete(str, str2 + " = ?", strArr);
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", String.format("Failed to delete values that match condition=\"%s\" and values=\"%s\" from database %s.", new Object[]{GeneratedOutlineSupport.outline16(str2, " = ?"), Arrays.toString(strArr), this.mDatabase}), e);
            return 0;
        }
    }
}
