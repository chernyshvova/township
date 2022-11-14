package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "ScreenshotEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class ScreenshotEntity extends zzh implements Freezable, Parcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<ScreenshotEntity> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getUri", mo17147id = 1)
    public final Uri zza;
    @SafeParcelable.Field(getter = "getWidth", mo17147id = 2)
    public final int zzb;
    @SafeParcelable.Field(getter = "getHeight", mo17147id = 3)
    public final int zzc;

    @SafeParcelable.Constructor
    public ScreenshotEntity(@RecentlyNonNull @SafeParcelable.Param(mo17150id = 1) Uri uri, @SafeParcelable.Param(mo17150id = 2) int i, @SafeParcelable.Param(mo17150id = 3) int i2) {
        this.zza = uri;
        this.zzb = i;
        this.zzc = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof ScreenshotEntity) {
            if (this == obj) {
                return true;
            }
            ScreenshotEntity screenshotEntity = (ScreenshotEntity) obj;
            return Objects.equal(screenshotEntity.zza, this.zza) && Objects.equal(Integer.valueOf(screenshotEntity.zzb), Integer.valueOf(this.zzb)) && Objects.equal(Integer.valueOf(screenshotEntity.zzc), Integer.valueOf(this.zzc));
        }
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public final boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        return Objects.toStringHelper(this).add("Uri", this.zza).add("Width", Integer.valueOf(this.zzb)).add("Height", Integer.valueOf(this.zzc)).toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
