package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdErrorParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdd> CREATOR = new zzbde();
    @SafeParcelable.Field(mo17147id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final String zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final String zzc;
    @SafeParcelable.Field(mo17147id = 4)
    @Nullable
    public zzbdd zzd;
    @SafeParcelable.Field(mo17147id = 5, type = "android.os.IBinder")
    @Nullable
    public IBinder zze;

    @SafeParcelable.Constructor
    public zzbdd(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) String str2, @SafeParcelable.Param(mo17150id = 4) @Nullable zzbdd zzbdd, @SafeParcelable.Param(mo17150id = 5) @Nullable IBinder iBinder) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzbdd;
        this.zze = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdError zza() {
        AdError adError;
        zzbdd zzbdd = this.zzd;
        if (zzbdd == null) {
            adError = null;
        } else {
            adError = new AdError(zzbdd.zza, zzbdd.zzb, zzbdd.zzc);
        }
        return new AdError(this.zza, this.zzb, this.zzc, adError);
    }

    public final LoadAdError zzb() {
        AdError adError;
        zzbdd zzbdd = this.zzd;
        zzbhd zzbhd = null;
        if (zzbdd == null) {
            adError = null;
        } else {
            adError = new AdError(zzbdd.zza, zzbdd.zzb, zzbdd.zzc);
        }
        int i = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        IBinder iBinder = this.zze;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzbhd) {
                zzbhd = (zzbhd) queryLocalInterface;
            } else {
                zzbhd = new zzbhb(iBinder);
            }
        }
        return new LoadAdError(i, str, str2, adError, ResponseInfo.zzb(zzbhd));
    }
}
