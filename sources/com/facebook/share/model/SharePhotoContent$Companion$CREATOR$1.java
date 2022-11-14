package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePhotoContent.kt */
public final class SharePhotoContent$Companion$CREATOR$1 implements Parcelable.Creator<SharePhotoContent> {
    public SharePhotoContent createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new SharePhotoContent(parcel);
    }

    public SharePhotoContent[] newArray(int i) {
        return new SharePhotoContent[i];
    }
}
