package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticationToken.kt */
public final class AuthenticationToken$Companion$CREATOR$1 implements Parcelable.Creator<AuthenticationToken> {
    public AuthenticationToken createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new AuthenticationToken(parcel);
    }

    public AuthenticationToken[] newArray(int i) {
        return new AuthenticationToken[i];
    }
}
