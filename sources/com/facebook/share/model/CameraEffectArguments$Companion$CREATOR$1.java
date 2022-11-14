package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraEffectArguments.kt */
public final class CameraEffectArguments$Companion$CREATOR$1 implements Parcelable.Creator<CameraEffectArguments> {
    public CameraEffectArguments createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new CameraEffectArguments(parcel);
    }

    public CameraEffectArguments[] newArray(int i) {
        return new CameraEffectArguments[i];
    }
}
