package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterResponseInfoParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdt> CREATOR = new zzbdu();
    @SafeParcelable.Field(mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(mo17147id = 2)
    public long zzb;
    @SafeParcelable.Field(mo17147id = 3)
    @Nullable
    public zzbdd zzc;
    @SafeParcelable.Field(mo17147id = 4)
    public final Bundle zzd;

    @SafeParcelable.Constructor
    public zzbdt(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) long j, @SafeParcelable.Param(mo17150id = 3) @Nullable zzbdd zzbdd, @SafeParcelable.Param(mo17150id = 4) Bundle bundle) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzbdd;
        this.zzd = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
