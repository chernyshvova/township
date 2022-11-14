package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzy();
    @SafeParcelable.Field(mo17147id = 2)
    public String zza;
    @SafeParcelable.Field(mo17147id = 3)
    public String zzb;
    @SafeParcelable.Field(mo17147id = 4)
    public zzku zzc;
    @SafeParcelable.Field(mo17147id = 5)
    public long zzd;
    @SafeParcelable.Field(mo17147id = 6)
    public boolean zze;
    @SafeParcelable.Field(mo17147id = 7)
    public String zzf;
    @SafeParcelable.Field(mo17147id = 8)
    public zzaq zzg;
    @SafeParcelable.Field(mo17147id = 9)
    public long zzh;
    @SafeParcelable.Field(mo17147id = 10)
    public zzaq zzi;
    @SafeParcelable.Field(mo17147id = 11)
    public long zzj;
    @SafeParcelable.Field(mo17147id = 12)
    public zzaq zzk;

    public zzz(zzz zzz) {
        Preconditions.checkNotNull(zzz);
        this.zza = zzz.zza;
        this.zzb = zzz.zzb;
        this.zzc = zzz.zzc;
        this.zzd = zzz.zzd;
        this.zze = zzz.zze;
        this.zzf = zzz.zzf;
        this.zzg = zzz.zzg;
        this.zzh = zzz.zzh;
        this.zzi = zzz.zzi;
        this.zzj = zzz.zzj;
        this.zzk = zzz.zzk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzz(@SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) String str2, @SafeParcelable.Param(mo17150id = 4) zzku zzku, @SafeParcelable.Param(mo17150id = 5) long j, @SafeParcelable.Param(mo17150id = 6) boolean z, @SafeParcelable.Param(mo17150id = 7) String str3, @SafeParcelable.Param(mo17150id = 8) zzaq zzaq, @SafeParcelable.Param(mo17150id = 9) long j2, @SafeParcelable.Param(mo17150id = 10) zzaq zzaq2, @SafeParcelable.Param(mo17150id = 11) long j3, @SafeParcelable.Param(mo17150id = 12) zzaq zzaq3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzku;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzaq;
        this.zzh = j2;
        this.zzi = zzaq2;
        this.zzj = j3;
        this.zzk = zzaq3;
    }
}
