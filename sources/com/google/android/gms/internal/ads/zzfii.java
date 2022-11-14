package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ProgramRequestCreator")
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfii extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfii> CREATOR = new zzfij();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final int zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final String zzc;
    @SafeParcelable.Field(mo17147id = 4)
    public final String zzd;
    @SafeParcelable.Field(mo17147id = 5)
    public final int zze;

    @SafeParcelable.Constructor
    public zzfii(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) int i2, @SafeParcelable.Param(mo17150id = 5) int i3, @SafeParcelable.Param(mo17150id = 3) String str, @SafeParcelable.Param(mo17150id = 4) String str2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = str2;
        this.zze = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzfii(int i, zzhl zzhl, String str, String str2) {
        this(1, 1, zzhl.zza(), str, str2);
    }
}
