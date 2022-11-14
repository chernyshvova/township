package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AdRequestParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdk> CREATOR = new zzbdm();
    @SafeParcelable.Field(mo17147id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 2)
    @Deprecated
    public final long zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final Bundle zzc;
    @SafeParcelable.Field(mo17147id = 4)
    @Deprecated
    public final int zzd;
    @SafeParcelable.Field(mo17147id = 5)
    public final List<String> zze;
    @SafeParcelable.Field(mo17147id = 6)
    public final boolean zzf;
    @SafeParcelable.Field(mo17147id = 7)
    public final int zzg;
    @SafeParcelable.Field(mo17147id = 8)
    public final boolean zzh;
    @SafeParcelable.Field(mo17147id = 9)
    public final String zzi;
    @SafeParcelable.Field(mo17147id = 10)
    public final zzbir zzj;
    @SafeParcelable.Field(mo17147id = 11)
    public final Location zzk;
    @SafeParcelable.Field(mo17147id = 12)
    public final String zzl;
    @SafeParcelable.Field(mo17147id = 13)
    public final Bundle zzm;
    @SafeParcelable.Field(mo17147id = 14)
    public final Bundle zzn;
    @SafeParcelable.Field(mo17147id = 15)
    public final List<String> zzo;
    @SafeParcelable.Field(mo17147id = 16)
    public final String zzp;
    @SafeParcelable.Field(mo17147id = 17)
    public final String zzq;
    @SafeParcelable.Field(mo17147id = 18)
    @Deprecated
    public final boolean zzr;
    @SafeParcelable.Field(mo17147id = 19)
    @Nullable
    public final zzbdb zzs;
    @SafeParcelable.Field(mo17147id = 20)
    public final int zzt;
    @SafeParcelable.Field(mo17147id = 21)
    @Nullable
    public final String zzu;
    @SafeParcelable.Field(mo17147id = 22)
    public final List<String> zzv;
    @SafeParcelable.Field(mo17147id = 23)
    public final int zzw;
    @SafeParcelable.Field(mo17147id = 24)
    @Nullable
    public final String zzx;

    @SafeParcelable.Constructor
    public zzbdk(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) long j, @SafeParcelable.Param(mo17150id = 3) Bundle bundle, @SafeParcelable.Param(mo17150id = 4) int i2, @SafeParcelable.Param(mo17150id = 5) List<String> list, @SafeParcelable.Param(mo17150id = 6) boolean z, @SafeParcelable.Param(mo17150id = 7) int i3, @SafeParcelable.Param(mo17150id = 8) boolean z2, @SafeParcelable.Param(mo17150id = 9) String str, @SafeParcelable.Param(mo17150id = 10) zzbir zzbir, @SafeParcelable.Param(mo17150id = 11) Location location, @SafeParcelable.Param(mo17150id = 12) String str2, @SafeParcelable.Param(mo17150id = 13) Bundle bundle2, @SafeParcelable.Param(mo17150id = 14) Bundle bundle3, @SafeParcelable.Param(mo17150id = 15) List<String> list2, @SafeParcelable.Param(mo17150id = 16) String str3, @SafeParcelable.Param(mo17150id = 17) String str4, @SafeParcelable.Param(mo17150id = 18) boolean z3, @SafeParcelable.Param(mo17150id = 19) zzbdb zzbdb, @SafeParcelable.Param(mo17150id = 20) int i4, @SafeParcelable.Param(mo17150id = 21) @Nullable String str5, @SafeParcelable.Param(mo17150id = 22) List<String> list3, @SafeParcelable.Param(mo17150id = 23) int i5, @SafeParcelable.Param(mo17150id = 24) String str6) {
        this.zza = i;
        this.zzb = j;
        this.zzc = bundle == null ? new Bundle() : bundle;
        this.zzd = i2;
        this.zze = list;
        this.zzf = z;
        this.zzg = i3;
        this.zzh = z2;
        this.zzi = str;
        this.zzj = zzbir;
        this.zzk = location;
        this.zzl = str2;
        this.zzm = bundle2 == null ? new Bundle() : bundle2;
        this.zzn = bundle3;
        this.zzo = list2;
        this.zzp = str3;
        this.zzq = str4;
        this.zzr = z3;
        this.zzs = zzbdb;
        this.zzt = i4;
        this.zzu = str5;
        this.zzv = list3 == null ? new ArrayList<>() : list3;
        this.zzw = i5;
        this.zzx = str6;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbdk)) {
            return false;
        }
        zzbdk zzbdk = (zzbdk) obj;
        if (this.zza != zzbdk.zza || this.zzb != zzbdk.zzb || !zzcgt.zza(this.zzc, zzbdk.zzc) || this.zzd != zzbdk.zzd || !Objects.equal(this.zze, zzbdk.zze) || this.zzf != zzbdk.zzf || this.zzg != zzbdk.zzg || this.zzh != zzbdk.zzh || !Objects.equal(this.zzi, zzbdk.zzi) || !Objects.equal(this.zzj, zzbdk.zzj) || !Objects.equal(this.zzk, zzbdk.zzk) || !Objects.equal(this.zzl, zzbdk.zzl) || !zzcgt.zza(this.zzm, zzbdk.zzm) || !zzcgt.zza(this.zzn, zzbdk.zzn) || !Objects.equal(this.zzo, zzbdk.zzo) || !Objects.equal(this.zzp, zzbdk.zzp) || !Objects.equal(this.zzq, zzbdk.zzq) || this.zzr != zzbdk.zzr || this.zzt != zzbdk.zzt || !Objects.equal(this.zzu, zzbdk.zzu) || !Objects.equal(this.zzv, zzbdk.zzv) || this.zzw != zzbdk.zzw || !Objects.equal(this.zzx, zzbdk.zzx)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze, Boolean.valueOf(this.zzf), Integer.valueOf(this.zzg), Boolean.valueOf(this.zzh), this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, Boolean.valueOf(this.zzr), Integer.valueOf(this.zzt), this.zzu, this.zzv, Integer.valueOf(this.zzw), this.zzx);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeBundle(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeStringList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzm, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzr);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzs, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzt);
        SafeParcelWriter.writeString(parcel, 21, this.zzu, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzv, false);
        SafeParcelWriter.writeInt(parcel, 23, this.zzw);
        SafeParcelWriter.writeString(parcel, 24, this.zzx, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
