package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.p005db.SupportSQLiteDatabase;
import androidx.sqlite.p005db.SupportSQLiteOpenHelper;
import androidx.sqlite.p005db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.Data;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTypeConverters;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Database(entities = {Dependency.class, WorkSpec.class, WorkTag.class, SystemIdInfo.class, WorkName.class, WorkProgress.class, Preference.class}, version = 11)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@TypeConverters({Data.class, WorkTypeConverters.class})
public abstract class WorkDatabase extends RoomDatabase {
    public static final String PRUNE_SQL_FORMAT_PREFIX = "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ";
    public static final String PRUNE_SQL_FORMAT_SUFFIX = " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    public static final long PRUNE_THRESHOLD_MILLIS = TimeUnit.DAYS.toMillis(7);

    @NonNull
    public static WorkDatabase create(@NonNull final Context context, @NonNull Executor executor, boolean z) {
        RoomDatabase.Builder<WorkDatabase> builder;
        Class<WorkDatabase> cls = WorkDatabase.class;
        if (z) {
            builder = Room.inMemoryDatabaseBuilder(context, cls).allowMainThreadQueries();
        } else {
            builder = Room.databaseBuilder(context, cls, WorkDatabasePathHelper.getWorkDatabaseName());
            builder.openHelperFactory(new SupportSQLiteOpenHelper.Factory() {
                @NonNull
                public SupportSQLiteOpenHelper create(@NonNull SupportSQLiteOpenHelper.Configuration configuration) {
                    SupportSQLiteOpenHelper.Configuration.Builder builder = SupportSQLiteOpenHelper.Configuration.builder(context);
                    builder.name(configuration.name).callback(configuration.callback).noBackupDirectory(true);
                    return new FrameworkSQLiteOpenHelperFactory().create(builder.build());
                }
            });
        }
        return builder.setQueryExecutor(executor).addCallback(generateCleanupCallback()).addMigrations(WorkDatabaseMigrations.MIGRATION_1_2).addMigrations(new WorkDatabaseMigrations.RescheduleMigration(context, 2, 3)).addMigrations(WorkDatabaseMigrations.MIGRATION_3_4).addMigrations(WorkDatabaseMigrations.MIGRATION_4_5).addMigrations(new WorkDatabaseMigrations.RescheduleMigration(context, 5, 6)).addMigrations(WorkDatabaseMigrations.MIGRATION_6_7).addMigrations(WorkDatabaseMigrations.MIGRATION_7_8).addMigrations(WorkDatabaseMigrations.MIGRATION_8_9).addMigrations(new WorkDatabaseMigrations.WorkMigration9To10(context)).addMigrations(new WorkDatabaseMigrations.RescheduleMigration(context, 10, 11)).fallbackToDestructiveMigration().build();
    }

    public static RoomDatabase.Callback generateCleanupCallback() {
        return new RoomDatabase.Callback() {
            public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onOpen(supportSQLiteDatabase);
                supportSQLiteDatabase.beginTransaction();
                try {
                    supportSQLiteDatabase.execSQL(WorkDatabase.getPruneSQL());
                    supportSQLiteDatabase.setTransactionSuccessful();
                } finally {
                    supportSQLiteDatabase.endTransaction();
                }
            }
        };
    }

    public static long getPruneDate() {
        return System.currentTimeMillis() - PRUNE_THRESHOLD_MILLIS;
    }

    @NonNull
    public static String getPruneSQL() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(PRUNE_SQL_FORMAT_PREFIX);
        outline24.append(getPruneDate());
        outline24.append(PRUNE_SQL_FORMAT_SUFFIX);
        return outline24.toString();
    }

    @NonNull
    public abstract DependencyDao dependencyDao();

    @NonNull
    public abstract PreferenceDao preferenceDao();

    @NonNull
    public abstract RawWorkInfoDao rawWorkInfoDao();

    @NonNull
    public abstract SystemIdInfoDao systemIdInfoDao();

    @NonNull
    public abstract WorkNameDao workNameDao();

    @NonNull
    public abstract WorkProgressDao workProgressDao();

    @NonNull
    public abstract WorkSpecDao workSpecDao();

    @NonNull
    public abstract WorkTagDao workTagDao();
}
