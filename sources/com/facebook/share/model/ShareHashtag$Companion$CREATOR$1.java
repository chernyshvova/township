package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareHashtag.kt */
public final class ShareHashtag$Companion$CREATOR$1 implements Parcelable.Creator<ShareHashtag> {
    public ShareHashtag createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new ShareHashtag(parcel);
    }

    public ShareHashtag[] newArray(int i) {
        return new ShareHashtag[i];
    }
}
