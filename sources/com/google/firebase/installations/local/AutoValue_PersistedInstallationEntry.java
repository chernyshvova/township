package com.google.firebase.installations.local;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

public final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {
    public final String authToken;
    public final long expiresInSecs;
    public final String firebaseInstallationId;
    public final String fisError;
    public final String refreshToken;
    public final PersistedInstallation.RegistrationStatus registrationStatus;
    public final long tokenCreationEpochInSecs;

    public static final class Builder extends PersistedInstallationEntry.Builder {
        public String authToken;
        public Long expiresInSecs;
        public String firebaseInstallationId;
        public String fisError;
        public String refreshToken;
        public PersistedInstallation.RegistrationStatus registrationStatus;
        public Long tokenCreationEpochInSecs;

        public Builder() {
        }

        public PersistedInstallationEntry build() {
            String str = this.registrationStatus == null ? " registrationStatus" : "";
            if (this.expiresInSecs == null) {
                str = GeneratedOutlineSupport.outline16(str, " expiresInSecs");
            }
            if (this.tokenCreationEpochInSecs == null) {
                str = GeneratedOutlineSupport.outline16(str, " tokenCreationEpochInSecs");
            }
            if (str.isEmpty()) {
                return new AutoValue_PersistedInstallationEntry(this.firebaseInstallationId, this.registrationStatus, this.authToken, this.refreshToken, this.expiresInSecs.longValue(), this.tokenCreationEpochInSecs.longValue(), this.fisError, (C23601) null);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str));
        }

        public PersistedInstallationEntry.Builder setExpiresInSecs(long j) {
            this.expiresInSecs = Long.valueOf(j);
            return this;
        }

        public PersistedInstallationEntry.Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus2) {
            if (registrationStatus2 != null) {
                this.registrationStatus = registrationStatus2;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        public PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long j) {
            this.tokenCreationEpochInSecs = Long.valueOf(j);
            return this;
        }

        public Builder(PersistedInstallationEntry persistedInstallationEntry, C23601 r4) {
            AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
            this.firebaseInstallationId = autoValue_PersistedInstallationEntry.firebaseInstallationId;
            this.registrationStatus = autoValue_PersistedInstallationEntry.registrationStatus;
            this.authToken = autoValue_PersistedInstallationEntry.authToken;
            this.refreshToken = autoValue_PersistedInstallationEntry.refreshToken;
            this.expiresInSecs = Long.valueOf(autoValue_PersistedInstallationEntry.expiresInSecs);
            this.tokenCreationEpochInSecs = Long.valueOf(autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs);
            this.fisError = autoValue_PersistedInstallationEntry.fisError;
        }
    }

    public AutoValue_PersistedInstallationEntry(String str, PersistedInstallation.RegistrationStatus registrationStatus2, String str2, String str3, long j, long j2, String str4, C23601 r10) {
        this.firebaseInstallationId = str;
        this.registrationStatus = registrationStatus2;
        this.authToken = str2;
        this.refreshToken = str3;
        this.expiresInSecs = j;
        this.tokenCreationEpochInSecs = j2;
        this.fisError = str4;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.firebaseInstallationId;
        if (str3 != null ? str3.equals(((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).firebaseInstallationId) : ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).firebaseInstallationId == null) {
            if (this.registrationStatus.equals(((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).registrationStatus) && ((str = this.authToken) != null ? str.equals(((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).authToken) : ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).authToken == null) && ((str2 = this.refreshToken) != null ? str2.equals(((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).refreshToken) : ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).refreshToken == null)) {
                AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
                if (this.expiresInSecs == autoValue_PersistedInstallationEntry.expiresInSecs && this.tokenCreationEpochInSecs == autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs) {
                    String str4 = this.fisError;
                    if (str4 == null) {
                        if (autoValue_PersistedInstallationEntry.fisError == null) {
                            return true;
                        }
                    } else if (str4.equals(autoValue_PersistedInstallationEntry.fisError)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.firebaseInstallationId;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.registrationStatus.hashCode()) * 1000003;
        String str2 = this.authToken;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.refreshToken;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j = this.expiresInSecs;
        long j2 = this.tokenCreationEpochInSecs;
        int i2 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.fisError;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 ^ i;
    }

    public PersistedInstallationEntry.Builder toBuilder() {
        return new Builder(this, (C23601) null);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("PersistedInstallationEntry{firebaseInstallationId=");
        outline24.append(this.firebaseInstallationId);
        outline24.append(", registrationStatus=");
        outline24.append(this.registrationStatus);
        outline24.append(", authToken=");
        outline24.append(this.authToken);
        outline24.append(", refreshToken=");
        outline24.append(this.refreshToken);
        outline24.append(", expiresInSecs=");
        outline24.append(this.expiresInSecs);
        outline24.append(", tokenCreationEpochInSecs=");
        outline24.append(this.tokenCreationEpochInSecs);
        outline24.append(", fisError=");
        return GeneratedOutlineSupport.outline18(outline24, this.fisError, "}");
    }
}
