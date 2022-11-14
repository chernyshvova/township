package com.google.android.gms.auth.api.signin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {
    public Status mStatus;
    public GoogleSignInAccount zzaz;

    public GoogleSignInResult(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.zzaz = googleSignInAccount;
        this.mStatus = status;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccount() {
        return this.zzaz;
    }

    @NonNull
    public Status getStatus() {
        return this.mStatus;
    }

    public boolean isSuccess() {
        return this.mStatus.isSuccess();
    }
}
