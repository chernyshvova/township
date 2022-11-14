package com.helpshift.p042db.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import java.util.List;

/* renamed from: com.helpshift.db.base.BaseSqliteHelper */
public abstract class BaseSqliteHelper extends SQLiteOpenHelper {
    public DatabaseContract contract;
    public IDbMigrationListener listener;

    /* renamed from: com.helpshift.db.base.BaseSqliteHelper$IDbMigrationListener */
    public interface IDbMigrationListener {
        void onDbMigrationFailed(MigrationType migrationType, String str);

        void onDbMigrationSuccess(MigrationType migrationType, String str);
    }

    /* renamed from: com.helpshift.db.base.BaseSqliteHelper$MigrationType */
    public enum MigrationType {
        UPGRADE,
        DOWNGRADE
    }

    public BaseSqliteHelper(Context context, DatabaseContract databaseContract) {
        super(context, databaseContract.getDatabaseName(), (SQLiteDatabase.CursorFactory) null, databaseContract.getDatabaseVersion());
        this.contract = databaseContract;
    }

    private void createAllTables(SQLiteDatabase sQLiteDatabase) {
        for (String execSQL : this.contract.getCreateTableQueries()) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    private void dropAllTables(SQLiteDatabase sQLiteDatabase) {
        for (String str : this.contract.getTableNames()) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }
    }

    private boolean dropAndCreateAllTablesOnMigrate(SQLiteDatabase sQLiteDatabase) {
        try {
            dropAllTables(sQLiteDatabase);
            createAllTables(sQLiteDatabase);
            return true;
        } catch (Exception e) {
            String tag = this.contract.getTag();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Exception while recreating tables on DB upgrade/downgrade: version: ");
            outline24.append(this.contract.getDatabaseVersion());
            HSLogger.m3245f(tag, outline24.toString(), (Throwable) e, new ILogExtrasModel[0]);
            throw e;
        }
    }

    private boolean migrate(SQLiteDatabase sQLiteDatabase, List<IMigrator> list, int i) {
        boolean z = false;
        try {
            for (IMigrator migrate : list) {
                migrate.migrate(sQLiteDatabase);
            }
            z = true;
        } catch (Exception e) {
            String tag = this.contract.getTag();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Exception while migrating ");
            outline24.append(this.contract.getDatabaseName());
            outline24.append(" old: ");
            outline24.append(i);
            outline24.append(", new: ");
            outline24.append(this.contract.getDatabaseVersion());
            HSLogger.m3245f(tag, outline24.toString(), (Throwable) e, new ILogExtrasModel[0]);
        }
        if (!z) {
            dropAndCreateAllTablesOnMigrate(sQLiteDatabase);
        }
        return z;
    }

    public boolean dropAndCreateAllTables(SQLiteDatabase sQLiteDatabase) {
        if (!sQLiteDatabase.isOpen()) {
            return true;
        }
        try {
            sQLiteDatabase.beginTransaction();
            dropAllTables(sQLiteDatabase);
            createAllTables(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            try {
                if (!sQLiteDatabase.inTransaction()) {
                    return true;
                }
                sQLiteDatabase.endTransaction();
                return true;
            } catch (Exception e) {
                HSLogger.m3245f(this.contract.getTag(), "Error in recreating inside finally block, ", (Throwable) e, new ILogExtrasModel[0]);
                return true;
            }
        } catch (Exception e2) {
            String tag = this.contract.getTag();
            HSLogger.m3245f(tag, "Exception while recreating tables: version: " + this.contract.getDatabaseVersion(), (Throwable) e2, new ILogExtrasModel[0]);
            try {
                if (sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e3) {
                HSLogger.m3245f(this.contract.getTag(), "Error in recreating inside finally block, ", (Throwable) e3, new ILogExtrasModel[0]);
            }
            return false;
        } catch (Throwable th) {
            try {
                if (sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e4) {
                HSLogger.m3245f(this.contract.getTag(), "Error in recreating inside finally block, ", (Throwable) e4, new ILogExtrasModel[0]);
            }
            throw th;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            createAllTables(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            try {
            } catch (Exception e) {
                HSLogger.m3245f(this.contract.getTag(), "Error in onCreate inside finally block, ", (Throwable) e, new ILogExtrasModel[0]);
            }
        } finally {
            try {
                if (sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e2) {
                HSLogger.m3245f(this.contract.getTag(), "Error in onCreate inside finally block, ", (Throwable) e2, new ILogExtrasModel[0]);
            }
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        boolean dropAndCreateAllTablesOnMigrate = dropAndCreateAllTablesOnMigrate(sQLiteDatabase);
        IDbMigrationListener iDbMigrationListener = this.listener;
        if (iDbMigrationListener == null) {
            return;
        }
        if (dropAndCreateAllTablesOnMigrate) {
            iDbMigrationListener.onDbMigrationSuccess(MigrationType.DOWNGRADE, this.contract.getDatabaseName());
        } else {
            iDbMigrationListener.onDbMigrationFailed(MigrationType.DOWNGRADE, this.contract.getDatabaseName());
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<IMigrator> migratorsForUpgrade = this.contract.getMigratorsForUpgrade(i);
        if (!ListUtils.isEmpty(migratorsForUpgrade)) {
            boolean migrate = migrate(sQLiteDatabase, migratorsForUpgrade, i);
            IDbMigrationListener iDbMigrationListener = this.listener;
            if (iDbMigrationListener == null) {
                return;
            }
            if (migrate) {
                iDbMigrationListener.onDbMigrationSuccess(MigrationType.UPGRADE, this.contract.getDatabaseName());
            } else {
                iDbMigrationListener.onDbMigrationFailed(MigrationType.UPGRADE, this.contract.getDatabaseName());
            }
        }
    }

    public void setListener(IDbMigrationListener iDbMigrationListener) {
        this.listener = iDbMigrationListener;
    }
}
