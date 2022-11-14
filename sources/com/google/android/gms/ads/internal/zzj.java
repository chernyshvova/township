package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    @SafeParcelable.Field(mo17147id = 2)
    public final boolean zza;
    @SafeParcelable.Field(mo17147id = 3)
    public final boolean zzb;
    @SafeParcelable.Field(mo17147id = 4)
    public final String zzc;
    @SafeParcelable.Field(mo17147id = 5)
    public final boolean zzd;
    @SafeParcelable.Field(mo17147id = 6)
    public final float zze;
    @SafeParcelable.Field(mo17147id = 7)
    public final int zzf;
    @SafeParcelable.Field(mo17147id = 8)
    public final boolean zzg;
    @SafeParcelable.Field(mo17147id = 9)
    public final boolean zzh;
    @SafeParcelable.Field(mo17147id = 10)
    public final boolean zzi;

    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(mo17150id = 2) boolean z, @SafeParcelable.Param(mo17150id = 3) boolean z2, @SafeParcelable.Param(mo17150id = 4) String str, @SafeParcelable.Param(mo17150id = 5) boolean z3, @SafeParcelable.Param(mo17150id = 6) float f, @SafeParcelable.Param(mo17150id = 7) int i, @SafeParcelable.Param(mo17150id = 8) boolean z4, @SafeParcelable.Param(mo17150id = 9) boolean z5, @SafeParcelable.Param(mo17150id = 10) boolean z6) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = str;
        this.zzd = z3;
        this.zze = f;
        this.zzf = i;
        this.zzg = z4;
        this.zzh = z5;
        this.zzi = z6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeFloat(parcel, 6, this.zze);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzj(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, (String) null, z3, f, -1, z4, z5, z6);
    }
}
