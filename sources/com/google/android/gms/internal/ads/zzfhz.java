package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassRequestParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfhz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfhz> CREATOR = new zzfia();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final String zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final String zzc;

    @SafeParcelable.Constructor
    public zzfhz(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) String str2) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzfhz(String str, String str2) {
        this(1, str, str2);
    }
}
