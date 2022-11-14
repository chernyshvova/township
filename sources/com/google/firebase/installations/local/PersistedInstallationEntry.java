package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

public abstract class PersistedInstallationEntry {

    public static abstract class Builder {
        @NonNull
        public abstract PersistedInstallationEntry build();

        @NonNull
        public abstract Builder setExpiresInSecs(long j);

        @NonNull
        public abstract Builder setRegistrationStatus(@NonNull PersistedInstallation.RegistrationStatus registrationStatus);

        @NonNull
        public abstract Builder setTokenCreationEpochInSecs(long j);
    }

    static {
        Long l = 0L;
        String str = l == null ? " expiresInSecs" : "";
        if (l == null) {
            str = GeneratedOutlineSupport.outline16(str, " tokenCreationEpochInSecs");
        }
        if (str.isEmpty()) {
            l.longValue();
            l.longValue();
            return;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str));
    }

    @NonNull
    public static Builder builder() {
        AutoValue_PersistedInstallationEntry.Builder builder = new AutoValue_PersistedInstallationEntry.Builder();
        builder.setTokenCreationEpochInSecs(0);
        builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION);
        builder.setExpiresInSecs(0);
        return builder;
    }

    public boolean isErrored() {
        return ((AutoValue_PersistedInstallationEntry) this).registrationStatus == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
    }

    public boolean isNotGenerated() {
        PersistedInstallation.RegistrationStatus registrationStatus = ((AutoValue_PersistedInstallationEntry) this).registrationStatus;
        return registrationStatus == PersistedInstallation.RegistrationStatus.NOT_GENERATED || registrationStatus == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public boolean isRegistered() {
        return ((AutoValue_PersistedInstallationEntry) this).registrationStatus == PersistedInstallation.RegistrationStatus.REGISTERED;
    }

    public boolean isUnregistered() {
        return ((AutoValue_PersistedInstallationEntry) this).registrationStatus == PersistedInstallation.RegistrationStatus.UNREGISTERED;
    }

    @NonNull
    public abstract Builder toBuilder();
}
