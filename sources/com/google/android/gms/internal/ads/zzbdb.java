package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdDataParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdb> CREATOR = new zzbdc();
    @SafeParcelable.Field(mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final String zzb;

    @SafeParcelable.Constructor
    public zzbdb(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
