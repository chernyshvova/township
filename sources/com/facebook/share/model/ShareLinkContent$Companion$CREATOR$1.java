package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareLinkContent.kt */
public final class ShareLinkContent$Companion$CREATOR$1 implements Parcelable.Creator<ShareLinkContent> {
    public ShareLinkContent createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new ShareLinkContent(parcel);
    }

    public ShareLinkContent[] newArray(int i) {
        return new ShareLinkContent[i];
    }
}
