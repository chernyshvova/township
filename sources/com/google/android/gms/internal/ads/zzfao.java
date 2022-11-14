package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "PoolConfigurationCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfao> CREATOR = new zzfap();
    @Nullable
    public final Context zza;
    public final zzfal zzb;
    @SafeParcelable.Field(mo17147id = 2)
    public final int zzc;
    @SafeParcelable.Field(mo17147id = 3)
    public final int zzd;
    @SafeParcelable.Field(mo17147id = 4)
    public final int zze;
    @SafeParcelable.Field(mo17147id = 5)
    public final String zzf;
    public final int zzg;
    public final zzfal[] zzh;
    @SafeParcelable.Field(getter = "getFormatInt", mo17147id = 1)
    public final int zzi;
    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", mo17147id = 6)
    public final int zzj;
    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", mo17147id = 7)
    public final int zzk;
    public final int[] zzl;
    public final int[] zzm;

    @SafeParcelable.Constructor
    public zzfao(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) int i2, @SafeParcelable.Param(mo17150id = 3) int i3, @SafeParcelable.Param(mo17150id = 4) int i4, @SafeParcelable.Param(mo17150id = 5) String str, @SafeParcelable.Param(mo17150id = 6) int i5, @SafeParcelable.Param(mo17150id = 7) int i6) {
        this.zzh = zzfal.values();
        this.zzl = zzfam.zza();
        int[] zza2 = zzfan.zza();
        this.zzm = zza2;
        this.zza = null;
        this.zzi = i;
        this.zzb = this.zzh[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = this.zzl[i5];
        this.zzk = i6;
        int i7 = zza2[i6];
    }

    public static zzfao zza(zzfal zzfal, Context context) {
        if (zzfal == zzfal.Rewarded) {
            return new zzfao(context, zzfal, ((Integer) zzbex.zzc().zzb(zzbjn.zzeE)).intValue(), ((Integer) zzbex.zzc().zzb(zzbjn.zzeK)).intValue(), ((Integer) zzbex.zzc().zzb(zzbjn.zzeM)).intValue(), (String) zzbex.zzc().zzb(zzbjn.zzeO), (String) zzbex.zzc().zzb(zzbjn.zzeG), (String) zzbex.zzc().zzb(zzbjn.zzeI));
        } else if (zzfal == zzfal.Interstitial) {
            return new zzfao(context, zzfal, ((Integer) zzbex.zzc().zzb(zzbjn.zzeF)).intValue(), ((Integer) zzbex.zzc().zzb(zzbjn.zzeL)).intValue(), ((Integer) zzbex.zzc().zzb(zzbjn.zzeN)).intValue(), (String) zzbex.zzc().zzb(zzbjn.zzeP), (String) zzbex.zzc().zzb(zzbjn.zzeH), (String) zzbex.zzc().zzb(zzbjn.zzeJ));
        } else if (zzfal != zzfal.AppOpen) {
            return null;
        } else {
            return new zzfao(context, zzfal, ((Integer) zzbex.zzc().zzb(zzbjn.zzeS)).intValue(), ((Integer) zzbex.zzc().zzb(zzbjn.zzeU)).intValue(), ((Integer) zzbex.zzc().zzb(zzbjn.zzeV)).intValue(), (String) zzbex.zzc().zzb(zzbjn.zzeQ), (String) zzbex.zzc().zzb(zzbjn.zzeR), (String) zzbex.zzc().zzb(zzbjn.zzeT));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzi);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzfao(@Nullable Context context, zzfal zzfal, int i, int i2, int i3, String str, String str2, String str3) {
        this.zzh = zzfal.values();
        this.zzl = zzfam.zza();
        this.zzm = zzfan.zza();
        this.zza = context;
        this.zzi = zzfal.ordinal();
        this.zzb = zzfal;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        int i4 = 2;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else if (!"lru".equals(str2) && "lfu".equals(str2)) {
            i4 = 3;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
