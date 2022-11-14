package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AppOpenAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdv> CREATOR = new zzbdw();
    @SafeParcelable.Field(mo17147id = 2)
    @AppOpenAd.AppOpenAdOrientation
    public final int zza;

    @SafeParcelable.Constructor
    public zzbdv(@SafeParcelable.Param(mo17150id = 2) @AppOpenAd.AppOpenAdOrientation int i) {
        this.zza = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
