package androidx.sqlite.p005db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Closeable;
import java.io.File;

/* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Callback */
    public static abstract class Callback {
        public static final String TAG = "SupportSQLite";
        public final int version;

        public Callback(int i) {
            this.version = i;
        }

        private void deleteDatabaseFile(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                Log.w(TAG, "deleting the database file: " + str);
                try {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } catch (Exception e) {
                    Log.w(TAG, "delete failed: ", e);
                }
            }
        }

        public void onConfigure(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
            if (r0 != null) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
            r3 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
            if (r3.hasNext() != false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
            deleteDatabaseFile((java.lang.String) r3.next().second);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
            deleteDatabaseFile(r3.getPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002c */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x002a A[ExcHandler: all (r1v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
          PHI: (r0v11 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x0025, B:8:0x002c, B:9:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0025] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCorruption(@androidx.annotation.NonNull androidx.sqlite.p005db.SupportSQLiteDatabase r3) {
            /*
                r2 = this;
                java.lang.String r0 = "Corruption reported by sqlite on database: "
                java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r0)
                java.lang.String r1 = r3.getPath()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "SupportSQLite"
                android.util.Log.e(r1, r0)
                boolean r0 = r3.isOpen()
                if (r0 != 0) goto L_0x0024
                java.lang.String r3 = r3.getPath()
                r2.deleteDatabaseFile(r3)
                return
            L_0x0024:
                r0 = 0
                java.util.List r0 = r3.getAttachedDbs()     // Catch:{ SQLiteException -> 0x002c, all -> 0x002a }
                goto L_0x002c
            L_0x002a:
                r1 = move-exception
                goto L_0x0030
            L_0x002c:
                r3.close()     // Catch:{ IOException -> 0x0052, all -> 0x002a }
                goto L_0x0053
            L_0x0030:
                if (r0 == 0) goto L_0x004a
                java.util.Iterator r3 = r0.iterator()
            L_0x0036:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x0051
                java.lang.Object r0 = r3.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r2.deleteDatabaseFile(r0)
                goto L_0x0036
            L_0x004a:
                java.lang.String r3 = r3.getPath()
                r2.deleteDatabaseFile(r3)
            L_0x0051:
                throw r1
            L_0x0052:
            L_0x0053:
                if (r0 == 0) goto L_0x006d
                java.util.Iterator r3 = r0.iterator()
            L_0x0059:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x0074
                java.lang.Object r0 = r3.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r2.deleteDatabaseFile(r0)
                goto L_0x0059
            L_0x006d:
                java.lang.String r3 = r3.getPath()
                r2.deleteDatabaseFile(r3)
            L_0x0074:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.p005db.SupportSQLiteOpenHelper.Callback.onCorruption(androidx.sqlite.db.SupportSQLiteDatabase):void");
        }

        public abstract void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void onUpgrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);
    }

    /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration */
    public static class Configuration {
        @NonNull
        public final Callback callback;
        @NonNull
        public final Context context;
        @Nullable
        public final String name;
        public final boolean useNoBackupDirectory;

        /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder */
        public static class Builder {
            public Callback mCallback;
            public Context mContext;
            public String mName;
            public boolean mUseNoBackUpDirectory;

            public Builder(@NonNull Context context) {
                this.mContext = context;
            }

            @NonNull
            public Configuration build() {
                if (this.mCallback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.mContext == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                } else if (!this.mUseNoBackUpDirectory || !TextUtils.isEmpty(this.mName)) {
                    return new Configuration(this.mContext, this.mName, this.mCallback, this.mUseNoBackUpDirectory);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            @NonNull
            public Builder callback(@NonNull Callback callback) {
                this.mCallback = callback;
                return this;
            }

            @NonNull
            public Builder name(@Nullable String str) {
                this.mName = str;
                return this;
            }

            @NonNull
            public Builder noBackupDirectory(boolean z) {
                this.mUseNoBackUpDirectory = z;
                return this;
            }
        }

        public Configuration(@NonNull Context context2, @Nullable String str, @NonNull Callback callback2) {
            this(context2, str, callback2, false);
        }

        @NonNull
        public static Builder builder(@NonNull Context context2) {
            return new Builder(context2);
        }

        public Configuration(@NonNull Context context2, @Nullable String str, @NonNull Callback callback2, boolean z) {
            this.context = context2;
            this.name = str;
            this.callback = callback2;
            this.useNoBackupDirectory = z;
        }
    }

    /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Factory */
    public interface Factory {
        @NonNull
        SupportSQLiteOpenHelper create(@NonNull Configuration configuration);
    }

    void close();

    @Nullable
    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);
}
