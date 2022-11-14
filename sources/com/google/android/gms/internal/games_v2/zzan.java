package com.google.android.gms.internal.games_v2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@SafeParcelable.Class(creator = "PopupLocationInfoParcelableCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzan extends zzh {
    public static final Parcelable.Creator<zzan> CREATOR = new zzao();
    @SafeParcelable.Field(getter = "getInfoBundle", mo17147id = 1)
    public final Bundle zza;
    @SafeParcelable.Field(getter = "getWindowToken", mo17147id = 2)
    @Nullable
    public final IBinder zzb;

    @SafeParcelable.Constructor
    public zzan(@SafeParcelable.Param(mo17150id = 1) Bundle bundle, @SafeParcelable.Param(mo17150id = 2) IBinder iBinder) {
        this.zza = bundle;
        this.zzb = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zza, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzan(zzam zzam) {
        this.zza = zzam.zza();
        this.zzb = zzam.zza;
    }
}
