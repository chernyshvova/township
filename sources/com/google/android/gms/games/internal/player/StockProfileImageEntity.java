package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "StockProfileImageEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class StockProfileImageEntity extends zzh implements StockProfileImage {
    @RecentlyNonNull
    public static final Parcelable.Creator<StockProfileImageEntity> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getImageUrl", mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getImageUri", mo17147id = 2)
    public final Uri zzb;

    @SafeParcelable.Constructor
    public StockProfileImageEntity(@RecentlyNonNull @SafeParcelable.Param(mo17150id = 1) String str, @RecentlyNonNull @SafeParcelable.Param(mo17150id = 2) Uri uri) {
        this.zza = str;
        this.zzb = uri;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof StockProfileImage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        StockProfileImage stockProfileImage = (StockProfileImage) obj;
        return Objects.equal(this.zza, stockProfileImage.getImageUrl()) && Objects.equal(this.zzb, stockProfileImage.zza());
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @RecentlyNonNull
    public String getImageUrl() {
        return this.zza;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        return Objects.toStringHelper(this).add("ImageId", this.zza).add("ImageUri", this.zzb).toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final Uri zza() {
        return this.zzb;
    }
}
