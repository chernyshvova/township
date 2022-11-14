package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMessengerURLActionButton.kt */
public final class ShareMessengerURLActionButton$Companion$CREATOR$1 implements Parcelable.Creator<ShareMessengerURLActionButton> {
    public ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new ShareMessengerURLActionButton(parcel);
    }

    public ShareMessengerURLActionButton[] newArray(int i) {
        return new ShareMessengerURLActionButton[i];
    }
}
