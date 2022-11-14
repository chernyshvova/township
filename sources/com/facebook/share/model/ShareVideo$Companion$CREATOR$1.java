package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareVideo.kt */
public final class ShareVideo$Companion$CREATOR$1 implements Parcelable.Creator<ShareVideo> {
    public ShareVideo createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new ShareVideo(parcel);
    }

    public ShareVideo[] newArray(int i) {
        return new ShareVideo[i];
    }
}
