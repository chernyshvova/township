package androidx.work.impl.background.greedy;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("GreedyScheduler");
    public final Set<WorkSpec> mConstrainedWorkSpecs = new HashSet();
    public final Context mContext;
    public DelayedWorkTracker mDelayedWorkTracker;
    public Boolean mIsMainProcess;
    public final Object mLock;
    public boolean mRegisteredExecutionListener;
    public final WorkConstraintsTracker mWorkConstraintsTracker;
    public final WorkManagerImpl mWorkManagerImpl;

    public GreedyScheduler(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkManagerImpl workManagerImpl) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, taskExecutor, this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, configuration.getRunnableScheduler());
        this.mLock = new Object();
    }

    @Nullable
    private String getProcessName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, GreedyScheduler.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th) {
            Logger.get().debug(TAG, "Unable to check ActivityThread for processName", th);
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return null;
    }

    private void registerExecutionListenerIfNeeded() {
        if (!this.mRegisteredExecutionListener) {
            this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
    }

    private void removeConstraintTrackingFor(@NonNull String str) {
        synchronized (this.mLock) {
            Iterator<WorkSpec> it = this.mConstrainedWorkSpecs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WorkSpec next = it.next();
                if (next.f34id.equals(str)) {
                    Logger.get().debug(TAG, String.format("Stopping tracking for %s", new Object[]{str}), new Throwable[0]);
                    this.mConstrainedWorkSpecs.remove(next);
                    this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                    break;
                }
            }
        }
    }

    public void cancel(@NonNull String str) {
        if (this.mIsMainProcess == null) {
            this.mIsMainProcess = Boolean.valueOf(TextUtils.equals(this.mContext.getPackageName(), getProcessName()));
        }
        if (!this.mIsMainProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, String.format("Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.unschedule(str);
        }
        this.mWorkManagerImpl.stopWork(str);
    }

    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
        for (String next : list) {
            Logger.get().debug(TAG, String.format("Constraints met: Scheduling work ID %s", new Object[]{next}), new Throwable[0]);
            this.mWorkManagerImpl.startWork(next);
        }
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        for (String next : list) {
            Logger.get().debug(TAG, String.format("Constraints not met: Cancelling work ID %s", new Object[]{next}), new Throwable[0]);
            this.mWorkManagerImpl.stopWork(next);
        }
    }

    public void onExecuted(@NonNull String str, boolean z) {
        removeConstraintTrackingFor(str);
    }

    public void schedule(@NonNull WorkSpec... workSpecArr) {
        if (this.mIsMainProcess == null) {
            this.mIsMainProcess = Boolean.valueOf(TextUtils.equals(this.mContext.getPackageName(), getProcessName()));
        }
        if (!this.mIsMainProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        registerExecutionListenerIfNeeded();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            long calculateNextRunTime = workSpec.calculateNextRunTime();
            long currentTimeMillis = System.currentTimeMillis();
            if (workSpec.state == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < calculateNextRunTime) {
                    DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                    if (delayedWorkTracker != null) {
                        delayedWorkTracker.schedule(workSpec);
                    }
                } else if (!workSpec.hasConstraints()) {
                    Logger.get().debug(TAG, String.format("Starting work for %s", new Object[]{workSpec.f34id}), new Throwable[0]);
                    this.mWorkManagerImpl.startWork(workSpec.f34id);
                } else if (Build.VERSION.SDK_INT >= 23 && workSpec.constraints.requiresDeviceIdle()) {
                    Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[]{workSpec}), new Throwable[0]);
                } else if (Build.VERSION.SDK_INT < 24 || !workSpec.constraints.hasContentUriTriggers()) {
                    hashSet.add(workSpec);
                    hashSet2.add(workSpec.f34id);
                } else {
                    Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[]{workSpec}), new Throwable[0]);
                }
            }
        }
        synchronized (this.mLock) {
            if (!hashSet.isEmpty()) {
                Logger.get().debug(TAG, String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", hashSet2)}), new Throwable[0]);
                this.mConstrainedWorkSpecs.addAll(hashSet);
                this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
            }
        }
    }

    @VisibleForTesting
    public void setDelayedWorkTracker(@NonNull DelayedWorkTracker delayedWorkTracker) {
        this.mDelayedWorkTracker = delayedWorkTracker;
    }

    @VisibleForTesting
    public GreedyScheduler(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull WorkConstraintsTracker workConstraintsTracker) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = workConstraintsTracker;
        this.mLock = new Object();
    }
}
