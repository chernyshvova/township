package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@SafeParcelable.Class(creator = "PlayerLevelInfoCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class PlayerLevelInfo extends zzh {
    @RecentlyNonNull
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new zzr();
    @SafeParcelable.Field(getter = "getCurrentXpTotal", mo17147id = 1)
    public final long zza;
    @SafeParcelable.Field(getter = "getLastLevelUpTimestamp", mo17147id = 2)
    public final long zzb;
    @SafeParcelable.Field(getter = "getCurrentLevel", mo17147id = 3)
    public final PlayerLevel zzc;
    @SafeParcelable.Field(getter = "getNextLevel", mo17147id = 4)
    public final PlayerLevel zzd;

    @SafeParcelable.Constructor
    public PlayerLevelInfo(@SafeParcelable.Param(mo17150id = 1) long j, @SafeParcelable.Param(mo17150id = 2) long j2, @RecentlyNonNull @SafeParcelable.Param(mo17150id = 3) PlayerLevel playerLevel, @RecentlyNonNull @SafeParcelable.Param(mo17150id = 4) PlayerLevel playerLevel2) {
        Preconditions.checkState(j != -1);
        Preconditions.checkNotNull(playerLevel);
        Preconditions.checkNotNull(playerLevel2);
        this.zza = j;
        this.zzb = j2;
        this.zzc = playerLevel;
        this.zzd = playerLevel2;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return Objects.equal(Long.valueOf(this.zza), Long.valueOf(playerLevelInfo.zza)) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(playerLevelInfo.zzb)) && Objects.equal(this.zzc, playerLevelInfo.zzc) && Objects.equal(this.zzd, playerLevelInfo.zzd);
    }

    @RecentlyNonNull
    public PlayerLevel getCurrentLevel() {
        return this.zzc;
    }

    public long getCurrentXpTotal() {
        return this.zza;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzb;
    }

    @RecentlyNonNull
    public PlayerLevel getNextLevel() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public boolean isMaxLevel() {
        return this.zzc.equals(this.zzd);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getCurrentXpTotal());
        SafeParcelWriter.writeLong(parcel, 2, getLastLevelUpTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 3, getCurrentLevel(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getNextLevel(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
