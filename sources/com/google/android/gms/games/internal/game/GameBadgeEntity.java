package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "GameBadgeEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements zza {
    @RecentlyNonNull
    public static final Parcelable.Creator<GameBadgeEntity> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getType", mo17147id = 1)
    public int zza;
    @SafeParcelable.Field(getter = "getTitle", mo17147id = 2)
    public String zzb;
    @SafeParcelable.Field(getter = "getDescription", mo17147id = 3)
    public String zzc;
    @SafeParcelable.Field(getter = "getIconImageUri", mo17147id = 4)
    public Uri zzd;

    @SafeParcelable.Constructor
    public GameBadgeEntity(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) String str2, @SafeParcelable.Param(mo17150id = 4) Uri uri) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = uri;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zza) {
            if (this == obj) {
                return true;
            }
            zza zza2 = (zza) obj;
            return Objects.equal(Integer.valueOf(zza2.zza()), this.zzb) && Objects.equal(zza2.zzb(), this.zzd);
        }
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb, this.zzc, this.zzd);
    }

    public final boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        return Objects.toStringHelper(this).add("Type", Integer.valueOf(this.zza)).add("Title", this.zzb).add("Description", this.zzc).add("IconImageUri", this.zzd).toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        String str;
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zza);
            SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
            SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        Uri uri = this.zzd;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        parcel.writeString(str);
    }

    public final int zza() {
        return this.zza;
    }

    @RecentlyNonNull
    public final String zzb() {
        return this.zzc;
    }
}
