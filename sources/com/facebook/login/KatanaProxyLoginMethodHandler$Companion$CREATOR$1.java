package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KatanaProxyLoginMethodHandler.kt */
public final class KatanaProxyLoginMethodHandler$Companion$CREATOR$1 implements Parcelable.Creator<KatanaProxyLoginMethodHandler> {
    public KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new KatanaProxyLoginMethodHandler(parcel);
    }

    public KatanaProxyLoginMethodHandler[] newArray(int i) {
        return new KatanaProxyLoginMethodHandler[i];
    }
}
