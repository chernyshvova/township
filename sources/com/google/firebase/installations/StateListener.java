package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

public interface StateListener {
    boolean onException(PersistedInstallationEntry persistedInstallationEntry, Exception exc);

    boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry);
}
