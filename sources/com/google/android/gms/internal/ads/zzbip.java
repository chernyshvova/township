package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RequestConfigurationParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbip extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbip> CREATOR = new zzbiq();
    @SafeParcelable.Field(mo17147id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final int zzb;

    @SafeParcelable.Constructor
    public zzbip(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzbip(RequestConfiguration requestConfiguration) {
        this.zza = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzb = requestConfiguration.getTagForUnderAgeOfConsent();
    }
}
