package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzblw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzblw> CREATOR = new zzblx();
    @SafeParcelable.Field(mo17147id = 1)
    public final int zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final boolean zzb;
    @SafeParcelable.Field(mo17147id = 3)
    public final int zzc;
    @SafeParcelable.Field(mo17147id = 4)
    public final boolean zzd;
    @SafeParcelable.Field(mo17147id = 5)
    public final int zze;
    @SafeParcelable.Field(mo17147id = 6)
    @Nullable
    public final zzbiv zzf;
    @SafeParcelable.Field(mo17147id = 7)
    public final boolean zzg;
    @SafeParcelable.Field(mo17147id = 8)
    public final int zzh;

    @SafeParcelable.Constructor
    public zzblw(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) boolean z, @SafeParcelable.Param(mo17150id = 3) int i2, @SafeParcelable.Param(mo17150id = 4) boolean z2, @SafeParcelable.Param(mo17150id = 5) int i3, @SafeParcelable.Param(mo17150id = 6) zzbiv zzbiv, @SafeParcelable.Param(mo17150id = 7) boolean z3, @SafeParcelable.Param(mo17150id = 8) int i4) {
        this.zza = i;
        this.zzb = z;
        this.zzc = i2;
        this.zzd = z2;
        this.zze = i3;
        this.zzf = zzbiv;
        this.zzg = z3;
        this.zzh = i4;
    }

    @NonNull
    public static NativeAdOptions zza(@Nullable zzblw zzblw) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzblw == null) {
            return builder.build();
        }
        int i = zzblw.zza;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    builder.setRequestCustomMuteThisAd(zzblw.zzg);
                    builder.setMediaAspectRatio(zzblw.zzh);
                }
                builder.setReturnUrlsForImageAssets(zzblw.zzb);
                builder.setRequestMultipleImages(zzblw.zzd);
                return builder.build();
            }
            zzbiv zzbiv = zzblw.zzf;
            if (zzbiv != null) {
                builder.setVideoOptions(new VideoOptions(zzbiv));
            }
        }
        builder.setAdChoicesPlacement(zzblw.zze);
        builder.setReturnUrlsForImageAssets(zzblw.zzb);
        builder.setRequestMultipleImages(zzblw.zzd);
        return builder.build();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzblw(com.google.android.gms.ads.formats.NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzbiv(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio());
    }
}
