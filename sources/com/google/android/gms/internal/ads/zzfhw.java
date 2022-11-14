package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassEventParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfhw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfhw> CREATOR = new zzfhx();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final byte[] zzb;

    @SafeParcelable.Constructor
    public zzfhw(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) byte[] bArr) {
        this.zza = i;
        this.zzb = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzfhw(byte[] bArr) {
        this(1, bArr);
    }
}
