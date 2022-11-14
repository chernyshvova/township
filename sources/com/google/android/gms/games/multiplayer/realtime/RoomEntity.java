package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@RetainForClient
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "RoomEntityCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class RoomEntity extends GamesDowngradeableSafeParcel {
    @RecentlyNonNull
    public static final Parcelable.Creator<RoomEntity> CREATOR = new zzc();

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
            return;
        }
        parcel.writeString("unsupported");
        parcel.writeString("unsupported");
        parcel.writeLong(0);
        parcel.writeInt(0);
        parcel.writeString("unsupported");
        parcel.writeInt(-1);
        parcel.writeBundle((Bundle) null);
        parcel.writeInt(0);
    }
}
