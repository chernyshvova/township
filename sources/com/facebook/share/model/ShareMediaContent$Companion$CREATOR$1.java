package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMediaContent.kt */
public final class ShareMediaContent$Companion$CREATOR$1 implements Parcelable.Creator<ShareMediaContent> {
    public ShareMediaContent createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new ShareMediaContent(parcel);
    }

    public ShareMediaContent[] newArray(int i) {
        return new ShareMediaContent[i];
    }
}
