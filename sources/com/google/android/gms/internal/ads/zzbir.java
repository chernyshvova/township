package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SearchAdRequestParcelCreator")
@SafeParcelable.Reserved({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbir extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbir> CREATOR = new zzbis();
    @SafeParcelable.Field(mo17147id = 15)
    public final String zza;

    public zzbir(SearchAdRequest searchAdRequest) {
        this.zza = searchAdRequest.getQuery();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzbir(@SafeParcelable.Param(mo17150id = 15) String str) {
        this.zza = str;
    }
}
