package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@SafeParcelable.Class(creator = "PlayerRelationshipInfoEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzs extends zzh implements PlayerRelationshipInfo {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();
    @SafeParcelable.Field(getter = "getFriendStatus", mo17147id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getNickname", mo17147id = 2)
    @Nullable
    public final String zzb;
    @SafeParcelable.Field(getter = "getInvitationNickname", mo17147id = 3)
    @Nullable
    public final String zzc;
    @SafeParcelable.Field(getter = "getNicknameAbuseReportToken", mo17147id = 4)
    @Nullable
    public final String zzd;

    @SafeParcelable.Constructor
    public zzs(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) @Nullable String str, @SafeParcelable.Param(mo17150id = 3) @Nullable String str2, @SafeParcelable.Param(mo17150id = 4) @Nullable String str3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public static int zzd(PlayerRelationshipInfo playerRelationshipInfo) {
        return Objects.hashCode(Integer.valueOf(playerRelationshipInfo.getFriendStatus()), playerRelationshipInfo.zzb(), playerRelationshipInfo.zza(), playerRelationshipInfo.zzc());
    }

    public static String zze(PlayerRelationshipInfo playerRelationshipInfo) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(playerRelationshipInfo);
        stringHelper.add("FriendStatus", Integer.valueOf(playerRelationshipInfo.getFriendStatus()));
        if (playerRelationshipInfo.zzb() != null) {
            stringHelper.add("Nickname", playerRelationshipInfo.zzb());
        }
        if (playerRelationshipInfo.zza() != null) {
            stringHelper.add("InvitationNickname", playerRelationshipInfo.zza());
        }
        if (playerRelationshipInfo.zzc() != null) {
            stringHelper.add("NicknameAbuseReportToken", playerRelationshipInfo.zza());
        }
        return stringHelper.toString();
    }

    public static boolean zzf(PlayerRelationshipInfo playerRelationshipInfo, Object obj) {
        if (!(obj instanceof PlayerRelationshipInfo)) {
            return false;
        }
        if (obj == playerRelationshipInfo) {
            return true;
        }
        PlayerRelationshipInfo playerRelationshipInfo2 = (PlayerRelationshipInfo) obj;
        return playerRelationshipInfo2.getFriendStatus() == playerRelationshipInfo.getFriendStatus() && Objects.equal(playerRelationshipInfo2.zzb(), playerRelationshipInfo.zzb()) && Objects.equal(playerRelationshipInfo2.zza(), playerRelationshipInfo.zza()) && Objects.equal(playerRelationshipInfo2.zzc(), playerRelationshipInfo.zzc());
    }

    public final boolean equals(@Nullable Object obj) {
        return zzf(this, obj);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int getFriendStatus() {
        return this.zza;
    }

    public final int hashCode() {
        return zzd(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zze(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzt.zza(this, parcel, i);
    }

    @Nullable
    public final String zza() {
        return this.zzc;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    @Nullable
    public final String zzc() {
        return this.zzd;
    }

    public zzs(PlayerRelationshipInfo playerRelationshipInfo) {
        this.zza = playerRelationshipInfo.getFriendStatus();
        this.zzb = playerRelationshipInfo.zzb();
        this.zzc = playerRelationshipInfo.zza();
        this.zzd = playerRelationshipInfo.zzc();
    }
}
