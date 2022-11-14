package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabLoginMethodHandler.kt */
public final class CustomTabLoginMethodHandler$Companion$CREATOR$1 implements Parcelable.Creator<CustomTabLoginMethodHandler> {
    public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new CustomTabLoginMethodHandler(parcel);
    }

    public CustomTabLoginMethodHandler[] newArray(int i) {
        return new CustomTabLoginMethodHandler[i];
    }
}
