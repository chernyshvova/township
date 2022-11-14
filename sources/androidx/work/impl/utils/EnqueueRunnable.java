package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.swrve.sdk.rest.RESTClient;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EnqueueRunnable implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    public final OperationImpl mOperation = new OperationImpl();
    public final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(@NonNull WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    public static boolean enqueueContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01e5 A[LOOP:7: B:120:0x01df->B:122:0x01e5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x020e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r19, @androidx.annotation.NonNull java.util.List<? extends androidx.work.WorkRequest> r20, java.lang.String[] r21, java.lang.String r22, androidx.work.ExistingWorkPolicy r23) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = r23
            long r4 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r6 = r19.getWorkDatabase()
            r7 = 1
            if (r1 == 0) goto L_0x0018
            int r9 = r1.length
            if (r9 <= 0) goto L_0x0018
            r9 = 1
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            if (r9 == 0) goto L_0x005d
            int r10 = r1.length
            r11 = 0
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0020:
            if (r11 >= r10) goto L_0x0060
            r15 = r1[r11]
            androidx.work.impl.model.WorkSpecDao r8 = r6.workSpecDao()
            androidx.work.impl.model.WorkSpec r8 = r8.getWorkSpec(r15)
            if (r8 != 0) goto L_0x0045
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r3 = 0
            r2[r3] = r15
            java.lang.String r4 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String r2 = java.lang.String.format(r4, r2)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r3]
            r0.error(r1, r2, r4)
            return r3
        L_0x0045:
            androidx.work.WorkInfo$State r8 = r8.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r8 != r15) goto L_0x004d
            r15 = 1
            goto L_0x004e
        L_0x004d:
            r15 = 0
        L_0x004e:
            r12 = r12 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r8 != r15) goto L_0x0055
            r14 = 1
            goto L_0x005a
        L_0x0055:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r8 != r15) goto L_0x005a
            r13 = 1
        L_0x005a:
            int r11 = r11 + 1
            goto L_0x0020
        L_0x005d:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0060:
            boolean r8 = android.text.TextUtils.isEmpty(r22)
            r8 = r8 ^ r7
            if (r8 == 0) goto L_0x006b
            if (r9 != 0) goto L_0x006b
            r10 = 1
            goto L_0x006c
        L_0x006b:
            r10 = 0
        L_0x006c:
            if (r10 == 0) goto L_0x0150
            androidx.work.impl.model.WorkSpecDao r10 = r6.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r2)
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x0150
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND
            if (r3 == r11) goto L_0x00ca
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r11) goto L_0x0085
            goto L_0x00ca
        L_0x0085:
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.KEEP
            if (r3 != r11) goto L_0x00a5
            java.util.Iterator r3 = r10.iterator()
        L_0x008d:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x00a5
            java.lang.Object r11 = r3.next()
            androidx.work.impl.model.WorkSpec$IdAndState r11 = (androidx.work.impl.model.WorkSpec.IdAndState) r11
            androidx.work.WorkInfo$State r11 = r11.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r11 == r15) goto L_0x00a3
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.RUNNING
            if (r11 != r15) goto L_0x008d
        L_0x00a3:
            r11 = 0
            return r11
        L_0x00a5:
            r11 = 0
            androidx.work.impl.utils.CancelWorkRunnable r3 = androidx.work.impl.utils.CancelWorkRunnable.forName(r2, r0, r11)
            r3.run()
            androidx.work.impl.model.WorkSpecDao r3 = r6.workSpecDao()
            java.util.Iterator r10 = r10.iterator()
        L_0x00b5:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x00c7
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r15 = r15.f35id
            r3.delete(r15)
            goto L_0x00b5
        L_0x00c7:
            r3 = 1
            goto L_0x0151
        L_0x00ca:
            r11 = 0
            androidx.work.impl.model.DependencyDao r9 = r6.dependencyDao()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00d8:
            boolean r16 = r10.hasNext()
            if (r16 == 0) goto L_0x0115
            java.lang.Object r16 = r10.next()
            r7 = r16
            androidx.work.impl.model.WorkSpec$IdAndState r7 = (androidx.work.impl.model.WorkSpec.IdAndState) r7
            java.lang.String r11 = r7.f35id
            boolean r11 = r9.hasDependents(r11)
            if (r11 != 0) goto L_0x010e
            androidx.work.WorkInfo$State r11 = r7.state
            r17 = r9
            androidx.work.WorkInfo$State r9 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r11 != r9) goto L_0x00f8
            r9 = 1
            goto L_0x00f9
        L_0x00f8:
            r9 = 0
        L_0x00f9:
            r9 = r9 & r12
            androidx.work.WorkInfo$State r11 = r7.state
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.FAILED
            if (r11 != r12) goto L_0x0102
            r14 = 1
            goto L_0x0107
        L_0x0102:
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.CANCELLED
            if (r11 != r12) goto L_0x0107
            r13 = 1
        L_0x0107:
            java.lang.String r7 = r7.f35id
            r15.add(r7)
            r12 = r9
            goto L_0x0110
        L_0x010e:
            r17 = r9
        L_0x0110:
            r9 = r17
            r7 = 1
            r11 = 0
            goto L_0x00d8
        L_0x0115:
            androidx.work.ExistingWorkPolicy r7 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r7) goto L_0x0142
            if (r13 != 0) goto L_0x011d
            if (r14 == 0) goto L_0x0142
        L_0x011d:
            androidx.work.impl.model.WorkSpecDao r3 = r6.workSpecDao()
            java.util.List r7 = r3.getWorkSpecIdAndStatesForName(r2)
            java.util.Iterator r7 = r7.iterator()
        L_0x0129:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x013b
            java.lang.Object r9 = r7.next()
            androidx.work.impl.model.WorkSpec$IdAndState r9 = (androidx.work.impl.model.WorkSpec.IdAndState) r9
            java.lang.String r9 = r9.f35id
            r3.delete(r9)
            goto L_0x0129
        L_0x013b:
            java.util.List r15 = java.util.Collections.emptyList()
            r3 = 0
            r13 = 0
            goto L_0x0143
        L_0x0142:
            r3 = r14
        L_0x0143:
            java.lang.Object[] r1 = r15.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r7 = r1.length
            if (r7 <= 0) goto L_0x014e
            r9 = 1
            goto L_0x014f
        L_0x014e:
            r9 = 0
        L_0x014f:
            r14 = r3
        L_0x0150:
            r3 = 0
        L_0x0151:
            java.util.Iterator r7 = r20.iterator()
        L_0x0155:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x0214
            java.lang.Object r10 = r7.next()
            androidx.work.WorkRequest r10 = (androidx.work.WorkRequest) r10
            androidx.work.impl.model.WorkSpec r11 = r10.getWorkSpec()
            if (r9 == 0) goto L_0x017c
            if (r12 != 0) goto L_0x017c
            if (r14 == 0) goto L_0x0170
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            r11.state = r15
            goto L_0x0184
        L_0x0170:
            if (r13 == 0) goto L_0x0177
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            r11.state = r15
            goto L_0x0184
        L_0x0177:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.BLOCKED
            r11.state = r15
            goto L_0x0184
        L_0x017c:
            boolean r15 = r11.isPeriodic()
            if (r15 != 0) goto L_0x0187
            r11.periodStartTime = r4
        L_0x0184:
            r17 = r4
            goto L_0x018d
        L_0x0187:
            r17 = r4
            r4 = 0
            r11.periodStartTime = r4
        L_0x018d:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x019b
            r5 = 25
            if (r4 > r5) goto L_0x019b
            tryDelegateConstrainedWorkSpec(r11)
            goto L_0x01ac
        L_0x019b:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 22
            if (r4 > r5) goto L_0x01ac
            java.lang.String r4 = "androidx.work.impl.background.gcm.GcmScheduler"
            boolean r4 = usesScheduler(r0, r4)
            if (r4 == 0) goto L_0x01ac
            tryDelegateConstrainedWorkSpec(r11)
        L_0x01ac:
            androidx.work.WorkInfo$State r4 = r11.state
            androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.ENQUEUED
            if (r4 != r5) goto L_0x01b3
            r3 = 1
        L_0x01b3:
            androidx.work.impl.model.WorkSpecDao r4 = r6.workSpecDao()
            r4.insertWorkSpec(r11)
            if (r9 == 0) goto L_0x01d7
            int r4 = r1.length
            r5 = 0
        L_0x01be:
            if (r5 >= r4) goto L_0x01d7
            r11 = r1[r5]
            androidx.work.impl.model.Dependency r15 = new androidx.work.impl.model.Dependency
            java.lang.String r0 = r10.getStringId()
            r15.<init>(r0, r11)
            androidx.work.impl.model.DependencyDao r0 = r6.dependencyDao()
            r0.insertDependency(r15)
            int r5 = r5 + 1
            r0 = r19
            goto L_0x01be
        L_0x01d7:
            java.util.Set r0 = r10.getTags()
            java.util.Iterator r0 = r0.iterator()
        L_0x01df:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01fc
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            androidx.work.impl.model.WorkTagDao r5 = r6.workTagDao()
            androidx.work.impl.model.WorkTag r11 = new androidx.work.impl.model.WorkTag
            java.lang.String r15 = r10.getStringId()
            r11.<init>(r4, r15)
            r5.insert(r11)
            goto L_0x01df
        L_0x01fc:
            if (r8 == 0) goto L_0x020e
            androidx.work.impl.model.WorkNameDao r0 = r6.workNameDao()
            androidx.work.impl.model.WorkName r4 = new androidx.work.impl.model.WorkName
            java.lang.String r5 = r10.getStringId()
            r4.<init>(r2, r5)
            r0.insert(r4)
        L_0x020e:
            r0 = r19
            r4 = r17
            goto L_0x0155
        L_0x0214:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    public static boolean processContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z = false;
        if (parents != null) {
            boolean z2 = false;
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z2 |= processContinuation(next);
                } else {
                    Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(RESTClient.COMMA_SEPARATOR, next.getIds())}), new Throwable[0]);
                }
            }
            z = z2;
        }
        return enqueueContinuation(workContinuationImpl) | z;
    }

    public static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        if (constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow()) {
            String str = workSpec.workerClassName;
            Data.Builder builder = new Data.Builder();
            builder.putAll(workSpec.input).putString(ConstraintTrackingWorker.ARGUMENT_CLASS_NAME, str);
            workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
            workSpec.input = builder.build();
        }
    }

    public static boolean usesScheduler(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (Scheduler scheduler : workManagerImpl.getSchedulers()) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    @VisibleForTesting
    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.mOperation.setState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.mWorkContinuation}));
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    @VisibleForTesting
    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
