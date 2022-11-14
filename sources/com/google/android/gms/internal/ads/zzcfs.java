package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcfs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcfs> CREATOR = new zzcft();
    @SafeParcelable.Field(mo17147id = 1)
    @Deprecated
    public final String zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final String zzb;
    @SafeParcelable.Field(mo17147id = 3)
    @Deprecated
    public final zzbdp zzc;
    @SafeParcelable.Field(mo17147id = 4)
    public final zzbdk zzd;

    @SafeParcelable.Constructor
    public zzcfs(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) String str2, @SafeParcelable.Param(mo17150id = 3) zzbdp zzbdp, @SafeParcelable.Param(mo17150id = 4) zzbdk zzbdk) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbdp;
        this.zzd = zzbdk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
