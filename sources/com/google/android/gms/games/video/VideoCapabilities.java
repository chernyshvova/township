package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@SafeParcelable.Class(creator = "VideoCapabilitiesCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class VideoCapabilities extends zzh {
    @RecentlyNonNull
    public static final Parcelable.Creator<VideoCapabilities> CREATOR = new zza();
    @SafeParcelable.Field(getter = "isCameraSupported", mo17147id = 1)
    public final boolean zza;
    @SafeParcelable.Field(getter = "isMicSupported", mo17147id = 2)
    public final boolean zzb;
    @SafeParcelable.Field(getter = "isWriteStorageSupported", mo17147id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(getter = "getSupportedCaptureModes", mo17147id = 4)
    public final boolean[] zzd;
    @SafeParcelable.Field(getter = "getSupportedQualityLevels", mo17147id = 5)
    public final boolean[] zze;

    @SafeParcelable.Constructor
    public VideoCapabilities(@SafeParcelable.Param(mo17150id = 1) boolean z, @SafeParcelable.Param(mo17150id = 2) boolean z2, @SafeParcelable.Param(mo17150id = 3) boolean z3, @RecentlyNonNull @SafeParcelable.Param(mo17150id = 4) boolean[] zArr, @RecentlyNonNull @SafeParcelable.Param(mo17150id = 5) boolean[] zArr2) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = zArr;
        this.zze = zArr2;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof VideoCapabilities)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
        return Objects.equal(videoCapabilities.getSupportedCaptureModes(), getSupportedCaptureModes()) && Objects.equal(videoCapabilities.getSupportedQualityLevels(), getSupportedQualityLevels()) && Objects.equal(Boolean.valueOf(videoCapabilities.isCameraSupported()), Boolean.valueOf(isCameraSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isMicSupported()), Boolean.valueOf(isMicSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isWriteStorageSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    @RecentlyNonNull
    public boolean[] getSupportedCaptureModes() {
        return this.zzd;
    }

    @RecentlyNonNull
    public boolean[] getSupportedQualityLevels() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(getSupportedCaptureModes(), getSupportedQualityLevels(), Boolean.valueOf(isCameraSupported()), Boolean.valueOf(isMicSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public boolean isCameraSupported() {
        return this.zza;
    }

    public boolean isFullySupported(int i, int i2) {
        return this.zza && this.zzb && this.zzc && supportsCaptureMode(i) && supportsQualityLevel(i2);
    }

    public boolean isMicSupported() {
        return this.zzb;
    }

    public boolean isWriteStorageSupported() {
        return this.zzc;
    }

    public boolean supportsCaptureMode(int i) {
        Preconditions.checkState(VideoConfiguration.isValidCaptureMode(i, false));
        return this.zzd[i];
    }

    public boolean supportsQualityLevel(int i) {
        Preconditions.checkState(VideoConfiguration.isValidQualityLevel(i, false));
        return this.zze[i];
    }

    @RecentlyNonNull
    public String toString() {
        return Objects.toStringHelper(this).add("SupportedCaptureModes", getSupportedCaptureModes()).add("SupportedQualityLevels", getSupportedQualityLevels()).add("CameraSupported", Boolean.valueOf(isCameraSupported())).add("MicSupported", Boolean.valueOf(isMicSupported())).add("StorageWriteSupported", Boolean.valueOf(isWriteStorageSupported())).toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isCameraSupported());
        SafeParcelWriter.writeBoolean(parcel, 2, isMicSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, isWriteStorageSupported());
        SafeParcelWriter.writeBooleanArray(parcel, 4, getSupportedCaptureModes(), false);
        SafeParcelWriter.writeBooleanArray(parcel, 5, getSupportedQualityLevels(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
