package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "ProgramResponseCreator")
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfik extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfik> CREATOR = new zzfil();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final byte[] zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final int zzc;

    @SafeParcelable.Constructor
    public zzfik(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) byte[] bArr, @SafeParcelable.Param(mo17150id = 3) int i2) {
        byte[] bArr2;
        this.zza = i;
        if (bArr == null) {
            bArr2 = null;
        } else {
            bArr2 = Arrays.copyOf(bArr, bArr.length);
        }
        this.zzb = bArr2;
        this.zzc = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzfik(byte[] bArr, int i) {
        this(1, (byte[]) null, 1);
    }
}
