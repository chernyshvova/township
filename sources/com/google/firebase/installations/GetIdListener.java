package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallationEntry;

public class GetIdListener implements StateListener {
    public final TaskCompletionSource<String> taskCompletionSource;

    public GetIdListener(TaskCompletionSource<String> taskCompletionSource2) {
        this.taskCompletionSource = taskCompletionSource2;
    }

    public boolean onException(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        return false;
    }

    public boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && !persistedInstallationEntry.isErrored()) {
            return false;
        }
        this.taskCompletionSource.trySetResult(((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).firebaseInstallationId);
        return true;
    }
}
