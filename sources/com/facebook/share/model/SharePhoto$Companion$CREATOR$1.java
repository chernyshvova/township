package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePhoto.kt */
public final class SharePhoto$Companion$CREATOR$1 implements Parcelable.Creator<SharePhoto> {
    public SharePhoto createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new SharePhoto(parcel);
    }

    public SharePhoto[] newArray(int i) {
        return new SharePhoto[i];
    }
}
