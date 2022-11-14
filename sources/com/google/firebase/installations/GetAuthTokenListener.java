package com.google.firebase.installations;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.AutoValue_InstallationTokenResult;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallationEntry;

public class GetAuthTokenListener implements StateListener {
    public final TaskCompletionSource<InstallationTokenResult> resultTaskCompletionSource;
    public final Utils utils;

    public GetAuthTokenListener(Utils utils2, TaskCompletionSource<InstallationTokenResult> taskCompletionSource) {
        this.utils = utils2;
        this.resultTaskCompletionSource = taskCompletionSource;
    }

    public boolean onException(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        if (!persistedInstallationEntry.isErrored() && !persistedInstallationEntry.isNotGenerated() && !persistedInstallationEntry.isUnregistered()) {
            return false;
        }
        this.resultTaskCompletionSource.trySetException(exc);
        return true;
    }

    public boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isRegistered() || this.utils.isAuthTokenExpired(persistedInstallationEntry)) {
            return false;
        }
        TaskCompletionSource<InstallationTokenResult> taskCompletionSource = this.resultTaskCompletionSource;
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
        String str = autoValue_PersistedInstallationEntry.authToken;
        if (str != null) {
            Long valueOf = Long.valueOf(autoValue_PersistedInstallationEntry.expiresInSecs);
            Long valueOf2 = Long.valueOf(autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs);
            String str2 = "";
            if (valueOf == null) {
                str2 = GeneratedOutlineSupport.outline16(str2, " tokenExpirationTimestamp");
            }
            if (valueOf2 == null) {
                str2 = GeneratedOutlineSupport.outline16(str2, " tokenCreationTimestamp");
            }
            if (str2.isEmpty()) {
                taskCompletionSource.setResult(new AutoValue_InstallationTokenResult(str, valueOf.longValue(), valueOf2.longValue(), (AutoValue_InstallationTokenResult.C23581) null));
                return true;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str2));
        }
        throw new NullPointerException("Null token");
    }
}
