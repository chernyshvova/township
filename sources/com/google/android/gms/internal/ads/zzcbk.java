package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcbk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcbk> CREATOR = new zzcbl();
    @SafeParcelable.Field(mo17147id = 1)
    public final Bundle zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final zzcgy zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final ApplicationInfo zzc;
    @SafeParcelable.Field(mo17147id = 4)
    public final String zzd;
    @SafeParcelable.Field(mo17147id = 5)
    public final List<String> zze;
    @SafeParcelable.Field(mo17147id = 6)
    @Nullable
    public final PackageInfo zzf;
    @SafeParcelable.Field(mo17147id = 7)
    public final String zzg;
    @SafeParcelable.Field(mo17147id = 9)
    public final String zzh;
    @SafeParcelable.Field(mo17147id = 10)
    @Nullable
    public zzfao zzi;
    @SafeParcelable.Field(mo17147id = 11)
    @Nullable
    public String zzj;

    @SafeParcelable.Constructor
    public zzcbk(@SafeParcelable.Param(mo17150id = 1) Bundle bundle, @SafeParcelable.Param(mo17150id = 2) zzcgy zzcgy, @SafeParcelable.Param(mo17150id = 3) ApplicationInfo applicationInfo, @SafeParcelable.Param(mo17150id = 4) String str, @SafeParcelable.Param(mo17150id = 5) List<String> list, @SafeParcelable.Param(mo17150id = 6) @Nullable PackageInfo packageInfo, @SafeParcelable.Param(mo17150id = 7) String str2, @SafeParcelable.Param(mo17150id = 9) String str3, @SafeParcelable.Param(mo17150id = 10) zzfao zzfao, @SafeParcelable.Param(mo17150id = 11) String str4) {
        this.zza = bundle;
        this.zzb = zzcgy;
        this.zzd = str;
        this.zzc = applicationInfo;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = str2;
        this.zzh = str3;
        this.zzi = zzfao;
        this.zzj = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
