package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkDatabasePathHelper {
    public static final String[] DATABASE_EXTRA_FILES = {"-journal", "-shm", "-wal"};
    public static final String TAG = Logger.tagWithPrefix("WrkDbPathHelper");
    public static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    @VisibleForTesting
    @NonNull
    public static File getDatabasePath(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return getDefaultDatabasePath(context);
        }
        return getNoBackupPath(context, WORK_DATABASE_NAME);
    }

    @VisibleForTesting
    @NonNull
    public static File getDefaultDatabasePath(@NonNull Context context) {
        return context.getDatabasePath(WORK_DATABASE_NAME);
    }

    @RequiresApi(23)
    public static File getNoBackupPath(@NonNull Context context, @NonNull String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }

    @NonNull
    public static String getWorkDatabaseName() {
        return WORK_DATABASE_NAME;
    }

    public static void migrateDatabase(@NonNull Context context) {
        String str;
        File defaultDatabasePath = getDefaultDatabasePath(context);
        if (Build.VERSION.SDK_INT >= 23 && defaultDatabasePath.exists()) {
            Logger.get().debug(TAG, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            Map<File, File> migrationPaths = migrationPaths(context);
            for (File next : migrationPaths.keySet()) {
                File file = migrationPaths.get(next);
                if (next.exists() && file != null) {
                    if (file.exists()) {
                        Logger.get().warning(TAG, String.format("Over-writing contents of %s", new Object[]{file}), new Throwable[0]);
                    }
                    if (next.renameTo(file)) {
                        str = String.format("Migrated %s to %s", new Object[]{next, file});
                    } else {
                        str = String.format("Renaming %s to %s failed", new Object[]{next, file});
                    }
                    Logger.get().debug(TAG, str, new Throwable[0]);
                }
            }
        }
    }

    @VisibleForTesting
    @NonNull
    public static Map<File, File> migrationPaths(@NonNull Context context) {
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File defaultDatabasePath = getDefaultDatabasePath(context);
            File databasePath = getDatabasePath(context);
            hashMap.put(defaultDatabasePath, databasePath);
            for (String str : DATABASE_EXTRA_FILES) {
                hashMap.put(new File(defaultDatabasePath.getPath() + str), new File(databasePath.getPath() + str));
            }
        }
        return hashMap;
    }
}
