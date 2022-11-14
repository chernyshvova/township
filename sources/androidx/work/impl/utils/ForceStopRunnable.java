package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import com.google.android.gms.drive.DriveFile;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForceStopRunnable implements Runnable {
    @VisibleForTesting
    public static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    public static final int ALARM_ID = -1;
    public static final String TAG = Logger.tagWithPrefix("ForceStopRunnable");
    public static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    public final Context mContext;
    public final WorkManagerImpl mWorkManager;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && ForceStopRunnable.ACTION_FORCE_STOP_RESCHEDULE.equals(intent.getAction())) {
                Logger.get().verbose(TAG, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.setAlarm(context);
            }
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
    }

    @VisibleForTesting
    public static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return intent;
    }

    public static PendingIntent getPendingIntent(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, getIntent(context), i);
    }

    public static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = getPendingIntent(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, pendingIntent);
        }
    }

    @VisibleForTesting
    public boolean cleanUp() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.cancelInvalidJobs(this.mContext);
        }
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkProgressDao workProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> runningWork = workSpecDao.getRunningWork();
            boolean z = runningWork != null && !runningWork.isEmpty();
            if (z) {
                for (WorkSpec next : runningWork) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, next.f34id);
                    workSpecDao.markWorkSpecScheduled(next.f34id, -1);
                }
            }
            workProgressDao.deleteAll();
            workDatabase.setTransactionSuccessful();
            return z;
        } finally {
            workDatabase.endTransaction();
        }
    }

    @VisibleForTesting
    public boolean isForceStopped() {
        if (getPendingIntent(this.mContext, DriveFile.MODE_WRITE_ONLY) != null) {
            return false;
        }
        setAlarm(this.mContext);
        return true;
    }

    public void run() {
        WorkDatabasePathHelper.migrateDatabase(this.mContext);
        Logger.get().debug(TAG, "Performing cleanup operations.", new Throwable[0]);
        try {
            boolean cleanUp = cleanUp();
            if (shouldRescheduleWorkers()) {
                Logger.get().debug(TAG, "Rescheduling Workers.", new Throwable[0]);
                this.mWorkManager.rescheduleEligibleWork();
                this.mWorkManager.getPreferenceUtils().setNeedsReschedule(false);
            } else if (isForceStopped()) {
                Logger.get().debug(TAG, "Application was force-stopped, rescheduling.", new Throwable[0]);
                this.mWorkManager.rescheduleEligibleWork();
            } else if (cleanUp) {
                Logger.get().debug(TAG, "Found unfinished work, scheduling it.", new Throwable[0]);
                Schedulers.schedule(this.mWorkManager.getConfiguration(), this.mWorkManager.getWorkDatabase(), this.mWorkManager.getSchedulers());
            }
            this.mWorkManager.onForceStopRunnableCompleted();
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteDatabaseCorruptException e) {
            Logger.get().error(TAG, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
            throw new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
        }
    }

    @VisibleForTesting
    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.getPreferenceUtils().getNeedsReschedule();
    }
}
