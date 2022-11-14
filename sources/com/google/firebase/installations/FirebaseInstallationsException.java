package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

public class FirebaseInstallationsException extends FirebaseException {
    @NonNull
    public final Status status;

    public enum Status {
        BAD_CONFIG,
        UNAVAILABLE
    }

    public FirebaseInstallationsException(@NonNull Status status2) {
        this.status = status2;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status2) {
        super(str);
        this.status = status2;
    }
}
