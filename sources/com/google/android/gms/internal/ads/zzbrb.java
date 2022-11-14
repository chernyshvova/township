package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "HttpResponseParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbrb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbrb> CREATOR = new zzbrc();
    @SafeParcelable.Field(mo17147id = 1)
    public final boolean zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final String zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final int zzc;
    @SafeParcelable.Field(mo17147id = 4)
    public final byte[] zzd;
    @SafeParcelable.Field(mo17147id = 5)
    public final String[] zze;
    @SafeParcelable.Field(mo17147id = 6)
    public final String[] zzf;
    @SafeParcelable.Field(mo17147id = 7)
    public final boolean zzg;
    @SafeParcelable.Field(mo17147id = 8)
    public final long zzh;

    @SafeParcelable.Constructor
    public zzbrb(@SafeParcelable.Param(mo17150id = 1) boolean z, @SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) int i, @SafeParcelable.Param(mo17150id = 4) byte[] bArr, @SafeParcelable.Param(mo17150id = 5) String[] strArr, @SafeParcelable.Param(mo17150id = 6) String[] strArr2, @SafeParcelable.Param(mo17150id = 7) boolean z2, @SafeParcelable.Param(mo17150id = 8) long j) {
        this.zza = z;
        this.zzb = str;
        this.zzc = i;
        this.zzd = bArr;
        this.zze = strArr;
        this.zzf = strArr2;
        this.zzg = z2;
        this.zzh = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeLong(parcel, 8, this.zzh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
