package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@SafeParcelable.Class(creator = "CurrentPlayerInfoEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zza extends zzh implements CurrentPlayerInfo {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getFriendsListVisibilityStatus", mo17147id = 1)
    public final int zza;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(mo17150id = 1) int i) {
        this.zza = i;
    }

    public static int zza(CurrentPlayerInfo currentPlayerInfo) {
        return Objects.hashCode(Integer.valueOf(currentPlayerInfo.getFriendsListVisibilityStatus()));
    }

    public static String zzb(CurrentPlayerInfo currentPlayerInfo) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(currentPlayerInfo);
        stringHelper.add("FriendsListVisibilityStatus", Integer.valueOf(currentPlayerInfo.getFriendsListVisibilityStatus()));
        return stringHelper.toString();
    }

    public static boolean zzc(CurrentPlayerInfo currentPlayerInfo, Object obj) {
        if (!(obj instanceof CurrentPlayerInfo)) {
            return false;
        }
        return obj == currentPlayerInfo || ((CurrentPlayerInfo) obj).getFriendsListVisibilityStatus() == currentPlayerInfo.getFriendsListVisibilityStatus();
    }

    public final boolean equals(@Nullable Object obj) {
        return zzc(this, obj);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int getFriendsListVisibilityStatus() {
        return this.zza;
    }

    public final int hashCode() {
        return zza(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public zza(CurrentPlayerInfo currentPlayerInfo) {
        this.zza = currentPlayerInfo.getFriendsListVisibilityStatus();
    }
}
