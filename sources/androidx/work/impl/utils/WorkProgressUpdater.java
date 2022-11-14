package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkProgressUpdater implements ProgressUpdater {
    public static final String TAG = Logger.tagWithPrefix("WorkProgressUpdater");
    public final TaskExecutor mTaskExecutor;
    public final WorkDatabase mWorkDatabase;

    public WorkProgressUpdater(@NonNull WorkDatabase workDatabase, @NonNull TaskExecutor taskExecutor) {
        this.mWorkDatabase = workDatabase;
        this.mTaskExecutor = taskExecutor;
    }

    @NonNull
    public ListenableFuture<Void> updateProgress(@NonNull Context context, @NonNull final UUID uuid, @NonNull final Data data) {
        final SettableFuture create = SettableFuture.create();
        this.mTaskExecutor.executeOnBackgroundThread(new Runnable() {
            public void run() {
                String uuid = uuid.toString();
                Logger.get().debug(WorkProgressUpdater.TAG, String.format("Updating progress for %s (%s)", new Object[]{uuid, data}), new Throwable[0]);
                WorkProgressUpdater.this.mWorkDatabase.beginTransaction();
                try {
                    WorkSpec workSpec = WorkProgressUpdater.this.mWorkDatabase.workSpecDao().getWorkSpec(uuid);
                    if (workSpec != null) {
                        if (workSpec.state == WorkInfo.State.RUNNING) {
                            WorkProgressUpdater.this.mWorkDatabase.workProgressDao().insert(new WorkProgress(uuid, data));
                        } else {
                            Logger.get().warning(WorkProgressUpdater.TAG, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", new Object[]{uuid}), new Throwable[0]);
                        }
                        create.set(null);
                        WorkProgressUpdater.this.mWorkDatabase.setTransactionSuccessful();
                        WorkProgressUpdater.this.mWorkDatabase.endTransaction();
                        return;
                    }
                    throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                } catch (Throwable th) {
                    WorkProgressUpdater.this.mWorkDatabase.endTransaction();
                    throw th;
                }
            }
        });
        return create;
    }
}
