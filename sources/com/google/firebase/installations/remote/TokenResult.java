package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import com.google.firebase.installations.remote.AutoValue_TokenResult;

public abstract class TokenResult {

    public static abstract class Builder {
        @NonNull
        public abstract TokenResult build();

        @NonNull
        public abstract Builder setTokenExpirationTimestamp(long j);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    public static Builder builder() {
        AutoValue_TokenResult.Builder builder = new AutoValue_TokenResult.Builder();
        builder.setTokenExpirationTimestamp(0);
        return builder;
    }
}
