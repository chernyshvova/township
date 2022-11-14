package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzat();
    @SafeParcelable.Field(mo17147id = 2)
    public final String zza;
    @SafeParcelable.Field(mo17147id = 3)
    public final zzap zzb;
    @SafeParcelable.Field(mo17147id = 4)
    public final String zzc;
    @SafeParcelable.Field(mo17147id = 5)
    public final long zzd;

    @SafeParcelable.Constructor
    public zzaq(@SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) zzap zzap, @SafeParcelable.Param(mo17150id = 4) String str2, @SafeParcelable.Param(mo17150id = 5) long j) {
        this.zza = str;
        this.zzb = zzap;
        this.zzc = str2;
        this.zzd = j;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        return GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline23(valueOf.length() + GeneratedOutlineSupport.outline3(str2, GeneratedOutlineSupport.outline3(str, 21)), "origin=", str, ",name=", str2), ",params=", valueOf);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzaq(zzaq zzaq, long j) {
        Preconditions.checkNotNull(zzaq);
        this.zza = zzaq.zza;
        this.zzb = zzaq.zzb;
        this.zzc = zzaq.zzc;
        this.zzd = j;
    }
}
