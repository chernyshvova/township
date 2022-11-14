package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameRequestContent.kt */
public final class GameRequestContent$Companion$CREATOR$1 implements Parcelable.Creator<GameRequestContent> {
    public GameRequestContent createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new GameRequestContent(parcel);
    }

    public GameRequestContent[] newArray(int i) {
        return new GameRequestContent[i];
    }
}
