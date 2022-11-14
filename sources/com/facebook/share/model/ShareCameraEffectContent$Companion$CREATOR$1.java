package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareCameraEffectContent.kt */
public final class ShareCameraEffectContent$Companion$CREATOR$1 implements Parcelable.Creator<ShareCameraEffectContent> {
    public ShareCameraEffectContent createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new ShareCameraEffectContent(parcel);
    }

    public ShareCameraEffectContent[] newArray(int i) {
        return new ShareCameraEffectContent[i];
    }
}
