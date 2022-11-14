package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticationTokenClaims.kt */
public final class AuthenticationTokenClaims$Companion$CREATOR$1 implements Parcelable.Creator<AuthenticationTokenClaims> {
    public AuthenticationTokenClaims createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new AuthenticationTokenClaims(parcel);
    }

    public AuthenticationTokenClaims[] newArray(int i) {
        return new AuthenticationTokenClaims[i];
    }
}
