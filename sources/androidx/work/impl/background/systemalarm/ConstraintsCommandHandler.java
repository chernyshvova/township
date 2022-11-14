package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ConstraintsCommandHandler {
    public static final String TAG = Logger.tagWithPrefix("ConstraintsCmdHandler");
    public final Context mContext;
    public final SystemAlarmDispatcher mDispatcher;
    public final int mStartId;
    public final WorkConstraintsTracker mWorkConstraintsTracker;

    public ConstraintsCommandHandler(@NonNull Context context, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mStartId = i;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(this.mContext, systemAlarmDispatcher.getTaskExecutor(), (WorkConstraintsCallback) null);
    }

    @WorkerThread
    public void handleConstraintsChanged() {
        List<WorkSpec> scheduledWork = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.updateAll(this.mContext, scheduledWork);
        this.mWorkConstraintsTracker.replace(scheduledWork);
        ArrayList arrayList = new ArrayList(scheduledWork.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (WorkSpec next : scheduledWork) {
            String str = next.f34id;
            if (currentTimeMillis >= next.calculateNextRunTime() && (!next.hasConstraints() || this.mWorkConstraintsTracker.areAllConstraintsMet(str))) {
                arrayList.add(next);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = ((WorkSpec) it.next()).f34id;
            Intent createDelayMetIntent = CommandHandler.createDelayMetIntent(this.mContext, str2);
            Logger.get().debug(TAG, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
            SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
            systemAlarmDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, createDelayMetIntent, this.mStartId));
        }
        this.mWorkConstraintsTracker.reset();
    }
}
