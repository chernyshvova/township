package com.google.android.gms.games.multiplayer;

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
@SafeParcelable.Class(creator = "ParticipantEntityCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class ParticipantEntity extends GamesDowngradeableSafeParcel {
    @RecentlyNonNull
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new zza();

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
            return;
        }
        parcel.writeString("unsupported");
        parcel.writeString("unsupported");
        parcel.writeString((String) null);
        parcel.writeString((String) null);
        parcel.writeInt(0);
        parcel.writeString("unsupported");
        parcel.writeInt(0);
        parcel.writeInt(0);
    }
}
