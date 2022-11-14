package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppGroupCreationContent.kt */
public final class AppGroupCreationContent$Companion$CREATOR$1 implements Parcelable.Creator<AppGroupCreationContent> {
    public AppGroupCreationContent createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new AppGroupCreationContent(parcel);
    }

    public AppGroupCreationContent[] newArray(int i) {
        return new AppGroupCreationContent[i];
    }
}
