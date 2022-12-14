package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PruneWorkRunnable implements Runnable {
    public final OperationImpl mOperation = new OperationImpl();
    public final WorkManagerImpl mWorkManagerImpl;

    public PruneWorkRunnable(WorkManagerImpl workManagerImpl) {
        this.mWorkManagerImpl = workManagerImpl;
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    public void run() {
        try {
            this.mWorkManagerImpl.getWorkDatabase().workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
            this.mOperation.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }
}
