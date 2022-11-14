package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupResponseCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    @SafeParcelable.Field(getter = "getResult", mo17147id = 1)
    public final boolean zza;
    @SafeParcelable.Field(getter = "getErrorMessage", mo17147id = 2)
    @Nullable
    public final String zzb;
    @SafeParcelable.Field(getter = "getStatusValue", mo17147id = 3)
    public final int zzc;

    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param(mo17150id = 1) boolean z, @SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) int i) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzp.zza(i) - 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return zzp.zza(this.zzc);
    }
}
