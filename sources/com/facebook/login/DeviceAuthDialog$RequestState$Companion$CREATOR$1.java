package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.login.DeviceAuthDialog;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceAuthDialog.kt */
public final class DeviceAuthDialog$RequestState$Companion$CREATOR$1 implements Parcelable.Creator<DeviceAuthDialog.RequestState> {
    public DeviceAuthDialog.RequestState createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new DeviceAuthDialog.RequestState(parcel);
    }

    public DeviceAuthDialog.RequestState[] newArray(int i) {
        return new DeviceAuthDialog.RequestState[i];
    }
}
