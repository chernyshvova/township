package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;
import com.google.android.gms.games.zzv;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "ProfileSettingsEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class ProfileSettingsEntity extends zzh implements zzv {
    @RecentlyNonNull
    public static final Parcelable.Creator<ProfileSettingsEntity> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getStatus", mo17147id = 1)
    public final Status zza;
    @SafeParcelable.Field(getter = "getGamerTag", mo17147id = 2)
    public final String zzb;
    @SafeParcelable.Field(getter = "isGamerTagExplicitlySet", mo17147id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(getter = "isProfileVisible", mo17147id = 4)
    public final boolean zzd;
    @SafeParcelable.Field(getter = "isVisibilityExplicitlySet", mo17147id = 5)
    public final boolean zze;
    @SafeParcelable.Field(getter = "getStockProfileImage", mo17147id = 6)
    public final StockProfileImageEntity zzf;
    @SafeParcelable.Field(getter = "isProfileDiscoverable", mo17147id = 7)
    public final boolean zzg;
    @SafeParcelable.Field(getter = "isAutoSignInEnabled", mo17147id = 8)
    public final boolean zzh;
    @SafeParcelable.Field(getter = "getHttpErrorCode", mo17147id = 9)
    public final int zzi;
    @SafeParcelable.Field(getter = "isSettingsChangesProhibited", mo17147id = 10)
    public final boolean zzj;
    @SafeParcelable.Field(getter = "allowFriendInvites", mo17147id = 11)
    public final boolean zzk;
    @SafeParcelable.Field(getter = "getProfileVisibility", mo17147id = 12)
    public final int zzl;
    @SafeParcelable.Field(getter = "getGlobalFriendsListVisibility", mo17147id = 13)
    public final int zzm;
    @SafeParcelable.Field(getter = "isAlwaysAutoSignIn", mo17147id = 14)
    public final boolean zzn;

    @SafeParcelable.Constructor
    public ProfileSettingsEntity(@RecentlyNonNull @SafeParcelable.Param(mo17150id = 1) Status status, @RecentlyNonNull @SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) boolean z, @SafeParcelable.Param(mo17150id = 4) boolean z2, @SafeParcelable.Param(mo17150id = 5) boolean z3, @RecentlyNonNull @SafeParcelable.Param(mo17150id = 6) StockProfileImageEntity stockProfileImageEntity, @SafeParcelable.Param(mo17150id = 7) boolean z4, @SafeParcelable.Param(mo17150id = 8) boolean z5, @SafeParcelable.Param(mo17150id = 9) int i, @SafeParcelable.Param(mo17150id = 10) boolean z6, @SafeParcelable.Param(mo17150id = 11) boolean z7, @SafeParcelable.Param(mo17150id = 12) int i2, @SafeParcelable.Param(mo17150id = 13) int i3, @SafeParcelable.Param(mo17150id = 14) boolean z8) {
        this.zza = status;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = z3;
        this.zzf = stockProfileImageEntity;
        this.zzg = z4;
        this.zzh = z5;
        this.zzi = i;
        this.zzj = z6;
        this.zzk = z7;
        this.zzl = i2;
        this.zzm = i3;
        this.zzn = z8;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzv)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzv zzv = (zzv) obj;
        return Objects.equal(this.zzb, zzv.zze()) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzv.zzi())) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzv.zzk())) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(zzv.zzm())) && Objects.equal(this.zza, zzv.getStatus()) && Objects.equal(this.zzf, zzv.zzd()) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(zzv.zzj())) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(zzv.zzh())) && this.zzi == zzv.zzb() && this.zzj == zzv.zzl() && this.zzk == zzv.zzf() && this.zzl == zzv.zzc() && this.zzm == zzv.zza() && this.zzn == zzv.zzg();
    }

    @RecentlyNonNull
    public final Status getStatus() {
        return this.zza;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zza, this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Integer.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(this.zzm), Boolean.valueOf(this.zzn));
    }

    @RecentlyNonNull
    public final String toString() {
        return Objects.toStringHelper(this).add("GamerTag", this.zzb).add("IsGamerTagExplicitlySet", Boolean.valueOf(this.zzc)).add("IsProfileVisible", Boolean.valueOf(this.zzd)).add("IsVisibilityExplicitlySet", Boolean.valueOf(this.zze)).add("Status", this.zza).add("StockProfileImage", this.zzf).add("IsProfileDiscoverable", Boolean.valueOf(this.zzg)).add("AutoSignIn", Boolean.valueOf(this.zzh)).add("httpErrorCode", Integer.valueOf(this.zzi)).add("IsSettingsChangesProhibited", Boolean.valueOf(this.zzj)).add("AllowFriendInvites", Boolean.valueOf(this.zzk)).add("ProfileVisibility", Integer.valueOf(this.zzl)).add("global_friends_list_visibility", Integer.valueOf(this.zzm)).add("always_auto_sign_in", Boolean.valueOf(this.zzn)).toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzn);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzm;
    }

    public final int zzb() {
        return this.zzi;
    }

    public final int zzc() {
        return this.zzl;
    }

    @RecentlyNonNull
    public final StockProfileImage zzd() {
        return this.zzf;
    }

    @RecentlyNonNull
    public final String zze() {
        return this.zzb;
    }

    public final boolean zzf() {
        return this.zzk;
    }

    public final boolean zzg() {
        return this.zzn;
    }

    public final boolean zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return this.zzc;
    }

    public final boolean zzj() {
        return this.zzg;
    }

    public final boolean zzk() {
        return this.zzd;
    }

    public final boolean zzl() {
        return this.zzj;
    }

    public final boolean zzm() {
        return this.zze;
    }
}
