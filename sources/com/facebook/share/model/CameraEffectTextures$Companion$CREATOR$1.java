package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraEffectTextures.kt */
public final class CameraEffectTextures$Companion$CREATOR$1 implements Parcelable.Creator<CameraEffectTextures> {
    public CameraEffectTextures createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new CameraEffectTextures(parcel);
    }

    public CameraEffectTextures[] newArray(int i) {
        return new CameraEffectTextures[i];
    }
}
