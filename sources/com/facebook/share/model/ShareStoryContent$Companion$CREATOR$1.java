package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareStoryContent.kt */
public final class ShareStoryContent$Companion$CREATOR$1 implements Parcelable.Creator<ShareStoryContent> {
    public ShareStoryContent createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new ShareStoryContent(parcel);
    }

    public ShareStoryContent[] newArray(int i) {
        return new ShareStoryContent[i];
    }
}
