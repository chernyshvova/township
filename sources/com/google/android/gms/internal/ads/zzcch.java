package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcch extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcch> CREATOR = new zzcci();
    @SafeParcelable.Field(mo17147id = 2)
    public final zzbdk zza;
    @SafeParcelable.Field(mo17147id = 3)
    public final String zzb;

    @SafeParcelable.Constructor
    public zzcch(@SafeParcelable.Param(mo17150id = 2) zzbdk zzbdk, @SafeParcelable.Param(mo17150id = 3) String str) {
        this.zza = zzbdk;
        this.zzb = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
