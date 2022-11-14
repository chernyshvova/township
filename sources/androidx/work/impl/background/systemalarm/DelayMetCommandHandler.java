package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, WorkTimer.TimeLimitExceededListener {
    public static final int STATE_INITIAL = 0;
    public static final int STATE_START_REQUESTED = 1;
    public static final int STATE_STOP_REQUESTED = 2;
    public static final String TAG = Logger.tagWithPrefix("DelayMetCommandHandler");
    public final Context mContext;
    public int mCurrentState = 0;
    public final SystemAlarmDispatcher mDispatcher;
    public boolean mHasConstraints = false;
    public final Object mLock = new Object();
    public final int mStartId;
    @Nullable
    public PowerManager.WakeLock mWakeLock;
    public final WorkConstraintsTracker mWorkConstraintsTracker;
    public final String mWorkSpecId;

    public DelayMetCommandHandler(@NonNull Context context, int i, @NonNull String str, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mStartId = i;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkSpecId = str;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(this.mContext, systemAlarmDispatcher.getTaskExecutor(), this);
    }

    private void cleanUp() {
        synchronized (this.mLock) {
            this.mWorkConstraintsTracker.reset();
            this.mDispatcher.getWorkTimer().stopTimer(this.mWorkSpecId);
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                Logger.get().debug(TAG, String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.mWakeLock, this.mWorkSpecId}), new Throwable[0]);
                this.mWakeLock.release();
            }
        }
    }

    private void stopWork() {
        synchronized (this.mLock) {
            if (this.mCurrentState < 2) {
                this.mCurrentState = 2;
                Logger.get().debug(TAG, String.format("Stopping work for WorkSpec %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                this.mDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createStopWorkIntent(this.mContext, this.mWorkSpecId), this.mStartId));
                if (this.mDispatcher.getProcessor().isEnqueued(this.mWorkSpecId)) {
                    Logger.get().debug(TAG, String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                    this.mDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkSpecId), this.mStartId));
                } else {
                    Logger.get().debug(TAG, String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                }
            } else {
                Logger.get().debug(TAG, String.format("Already stopped work for %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
            }
        }
    }

    @WorkerThread
    public void handleProcessWork() {
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, String.format("%s (%s)", new Object[]{this.mWorkSpecId, Integer.valueOf(this.mStartId)}));
        Logger.get().debug(TAG, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.mWakeLock, this.mWorkSpecId}), new Throwable[0]);
        this.mWakeLock.acquire();
        WorkSpec workSpec = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getWorkSpec(this.mWorkSpecId);
        if (workSpec == null) {
            stopWork();
            return;
        }
        boolean hasConstraints = workSpec.hasConstraints();
        this.mHasConstraints = hasConstraints;
        if (!hasConstraints) {
            Logger.get().debug(TAG, String.format("No constraints for %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
            onAllConstraintsMet(Collections.singletonList(this.mWorkSpecId));
            return;
        }
        this.mWorkConstraintsTracker.replace(Collections.singletonList(workSpec));
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
        if (list.contains(this.mWorkSpecId)) {
            synchronized (this.mLock) {
                if (this.mCurrentState == 0) {
                    this.mCurrentState = 1;
                    Logger.get().debug(TAG, String.format("onAllConstraintsMet for %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                    if (this.mDispatcher.getProcessor().startWork(this.mWorkSpecId)) {
                        this.mDispatcher.getWorkTimer().startTimer(this.mWorkSpecId, 600000, this);
                    } else {
                        cleanUp();
                    }
                } else {
                    Logger.get().debug(TAG, String.format("Already started work for %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                }
            }
        }
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        stopWork();
    }

    public void onExecuted(@NonNull String str, boolean z) {
        Logger.get().debug(TAG, String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z)}), new Throwable[0]);
        cleanUp();
        if (z) {
            Intent createScheduleWorkIntent = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkSpecId);
            SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
            systemAlarmDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, createScheduleWorkIntent, this.mStartId));
        }
        if (this.mHasConstraints) {
            Intent createConstraintsChangedIntent = CommandHandler.createConstraintsChangedIntent(this.mContext);
            SystemAlarmDispatcher systemAlarmDispatcher2 = this.mDispatcher;
            systemAlarmDispatcher2.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, createConstraintsChangedIntent, this.mStartId));
        }
    }

    public void onTimeLimitExceeded(@NonNull String str) {
        Logger.get().debug(TAG, String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        stopWork();
    }
}
