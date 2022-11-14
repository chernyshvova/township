package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticationTokenHeader.kt */
public final class AuthenticationTokenHeader$Companion$CREATOR$1 implements Parcelable.Creator<AuthenticationTokenHeader> {
    public AuthenticationTokenHeader createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new AuthenticationTokenHeader(parcel);
    }

    public AuthenticationTokenHeader[] newArray(int i) {
        return new AuthenticationTokenHeader[i];
    }
}
