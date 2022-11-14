package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceAuthMethodHandler.kt */
public final class DeviceAuthMethodHandler$Companion$CREATOR$1 implements Parcelable.Creator<DeviceAuthMethodHandler> {
    public DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new DeviceAuthMethodHandler(parcel);
    }

    public DeviceAuthMethodHandler[] newArray(int i) {
        return new DeviceAuthMethodHandler[i];
    }
}
