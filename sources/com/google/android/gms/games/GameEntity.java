package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@RetainForClient
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "GameEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    @RecentlyNonNull
    public static final Parcelable.Creator<GameEntity> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getApplicationId", mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getDisplayName", mo17147id = 2)
    public final String zzb;
    @SafeParcelable.Field(getter = "getPrimaryCategory", mo17147id = 3)
    public final String zzc;
    @SafeParcelable.Field(getter = "getSecondaryCategory", mo17147id = 4)
    public final String zzd;
    @SafeParcelable.Field(getter = "getDescription", mo17147id = 5)
    public final String zze;
    @SafeParcelable.Field(getter = "getDeveloperName", mo17147id = 6)
    public final String zzf;
    @SafeParcelable.Field(getter = "getIconImageUri", mo17147id = 7)
    public final Uri zzg;
    @SafeParcelable.Field(getter = "getHiResImageUri", mo17147id = 8)
    public final Uri zzh;
    @SafeParcelable.Field(getter = "getFeaturedImageUri", mo17147id = 9)
    public final Uri zzi;
    @SafeParcelable.Field(getter = "isPlayEnabledGame", mo17147id = 10)
    public final boolean zzj;
    @SafeParcelable.Field(getter = "isInstanceInstalled", mo17147id = 11)
    public final boolean zzk;
    @SafeParcelable.Field(getter = "getInstancePackageName", mo17147id = 12)
    public final String zzl;
    @SafeParcelable.Field(getter = "getGameplayAclStatus", mo17147id = 13)
    public final int zzm;
    @SafeParcelable.Field(getter = "getAchievementTotalCount", mo17147id = 14)
    public final int zzn;
    @SafeParcelable.Field(getter = "getLeaderboardCount", mo17147id = 15)
    public final int zzo;
    @SafeParcelable.Field(getter = "isRealTimeMultiplayerEnabled", mo17147id = 16)
    public final boolean zzp;
    @SafeParcelable.Field(getter = "isTurnBasedMultiplayerEnabled", mo17147id = 17)
    public final boolean zzq;
    @SafeParcelable.Field(getter = "getIconImageUrl", mo17147id = 18)
    public final String zzr;
    @SafeParcelable.Field(getter = "getHiResImageUrl", mo17147id = 19)
    public final String zzs;
    @SafeParcelable.Field(getter = "getFeaturedImageUrl", mo17147id = 20)
    public final String zzt;
    @SafeParcelable.Field(getter = "isMuted", mo17147id = 21)
    public final boolean zzu;
    @SafeParcelable.Field(getter = "isIdentitySharingConfirmed", mo17147id = 22)
    public final boolean zzv;
    @SafeParcelable.Field(getter = "areSnapshotsEnabled", mo17147id = 23)
    public final boolean zzw;
    @SafeParcelable.Field(getter = "getThemeColor", mo17147id = 24)
    public final String zzx;
    @SafeParcelable.Field(getter = "hasGamepadSupport", mo17147id = 25)
    public final boolean zzy;

    public GameEntity(@RecentlyNonNull Game game) {
        this.zza = game.getApplicationId();
        this.zzc = game.getPrimaryCategory();
        this.zzd = game.getSecondaryCategory();
        this.zze = game.getDescription();
        this.zzf = game.getDeveloperName();
        this.zzb = game.getDisplayName();
        this.zzg = game.getIconImageUri();
        this.zzr = game.getIconImageUrl();
        this.zzh = game.getHiResImageUri();
        this.zzs = game.getHiResImageUrl();
        this.zzi = game.getFeaturedImageUri();
        this.zzt = game.getFeaturedImageUrl();
        this.zzj = game.zze();
        this.zzk = game.zzc();
        this.zzl = game.zza();
        this.zzm = 1;
        this.zzn = game.getAchievementTotalCount();
        this.zzo = game.getLeaderboardCount();
        this.zzp = game.zzf();
        this.zzq = game.zzg();
        this.zzu = game.zzd();
        this.zzv = game.zzb();
        this.zzw = game.areSnapshotsEnabled();
        this.zzx = game.getThemeColor();
        this.zzy = game.hasGamepadSupport();
    }

    public static int zzh(Game game) {
        return Objects.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zze()), Boolean.valueOf(game.zzc()), game.zza(), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.zzf()), Boolean.valueOf(game.zzg()), Boolean.valueOf(game.zzd()), Boolean.valueOf(game.zzb()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    public static String zzj(Game game) {
        return Objects.toStringHelper(game).add("ApplicationId", game.getApplicationId()).add("DisplayName", game.getDisplayName()).add("PrimaryCategory", game.getPrimaryCategory()).add("SecondaryCategory", game.getSecondaryCategory()).add("Description", game.getDescription()).add("DeveloperName", game.getDeveloperName()).add("IconImageUri", game.getIconImageUri()).add("IconImageUrl", game.getIconImageUrl()).add("HiResImageUri", game.getHiResImageUri()).add("HiResImageUrl", game.getHiResImageUrl()).add("FeaturedImageUri", game.getFeaturedImageUri()).add("FeaturedImageUrl", game.getFeaturedImageUrl()).add("PlayEnabledGame", Boolean.valueOf(game.zze())).add("InstanceInstalled", Boolean.valueOf(game.zzc())).add("InstancePackageName", game.zza()).add("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).add("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).add("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).add("ThemeColor", game.getThemeColor()).add("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    public static boolean zzm(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        return Objects.equal(game2.getApplicationId(), game.getApplicationId()) && Objects.equal(game2.getDisplayName(), game.getDisplayName()) && Objects.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && Objects.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && Objects.equal(game2.getDescription(), game.getDescription()) && Objects.equal(game2.getDeveloperName(), game.getDeveloperName()) && Objects.equal(game2.getIconImageUri(), game.getIconImageUri()) && Objects.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && Objects.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && Objects.equal(Boolean.valueOf(game2.zze()), Boolean.valueOf(game.zze())) && Objects.equal(Boolean.valueOf(game2.zzc()), Boolean.valueOf(game.zzc())) && Objects.equal(game2.zza(), game.zza()) && Objects.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && Objects.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && Objects.equal(Boolean.valueOf(game2.zzf()), Boolean.valueOf(game.zzf())) && Objects.equal(Boolean.valueOf(game2.zzg()), Boolean.valueOf(game.zzg())) && Objects.equal(Boolean.valueOf(game2.zzd()), Boolean.valueOf(game.zzd())) && Objects.equal(Boolean.valueOf(game2.zzb()), Boolean.valueOf(game.zzb())) && Objects.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && Objects.equal(game2.getThemeColor(), game.getThemeColor()) && Objects.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()));
    }

    public boolean areSnapshotsEnabled() {
        return this.zzw;
    }

    public boolean equals(@Nullable Object obj) {
        return zzm(this, obj);
    }

    @RecentlyNonNull
    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.zzn;
    }

    @RecentlyNonNull
    public String getApplicationId() {
        return this.zza;
    }

    @RecentlyNonNull
    public String getDescription() {
        return this.zze;
    }

    public void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zze, charArrayBuffer);
    }

    @RecentlyNonNull
    public String getDeveloperName() {
        return this.zzf;
    }

    public void getDeveloperName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzf, charArrayBuffer);
    }

    @RecentlyNonNull
    public String getDisplayName() {
        return this.zzb;
    }

    public void getDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @RecentlyNonNull
    public Uri getFeaturedImageUri() {
        return this.zzi;
    }

    @RecentlyNonNull
    public String getFeaturedImageUrl() {
        return this.zzt;
    }

    @RecentlyNonNull
    public Uri getHiResImageUri() {
        return this.zzh;
    }

    @RecentlyNonNull
    public String getHiResImageUrl() {
        return this.zzs;
    }

    @RecentlyNonNull
    public Uri getIconImageUri() {
        return this.zzg;
    }

    @RecentlyNonNull
    public String getIconImageUrl() {
        return this.zzr;
    }

    public int getLeaderboardCount() {
        return this.zzo;
    }

    @RecentlyNonNull
    public String getPrimaryCategory() {
        return this.zzc;
    }

    @RecentlyNonNull
    public String getSecondaryCategory() {
        return this.zzd;
    }

    @RecentlyNonNull
    public String getThemeColor() {
        return this.zzx;
    }

    public boolean hasGamepadSupport() {
        return this.zzy;
    }

    public int hashCode() {
        return zzh(this);
    }

    public boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public String toString() {
        return zzj(this);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        String str;
        String str2;
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getApplicationId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeString(parcel, 3, getPrimaryCategory(), false);
            SafeParcelWriter.writeString(parcel, 4, getSecondaryCategory(), false);
            SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
            SafeParcelWriter.writeString(parcel, 6, getDeveloperName(), false);
            SafeParcelWriter.writeParcelable(parcel, 7, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 8, getHiResImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 9, getFeaturedImageUri(), i, false);
            SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
            SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
            SafeParcelWriter.writeString(parcel, 12, this.zzl, false);
            SafeParcelWriter.writeInt(parcel, 13, this.zzm);
            SafeParcelWriter.writeInt(parcel, 14, getAchievementTotalCount());
            SafeParcelWriter.writeInt(parcel, 15, getLeaderboardCount());
            SafeParcelWriter.writeBoolean(parcel, 16, this.zzp);
            SafeParcelWriter.writeBoolean(parcel, 17, this.zzq);
            SafeParcelWriter.writeString(parcel, 18, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 19, getHiResImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 20, getFeaturedImageUrl(), false);
            SafeParcelWriter.writeBoolean(parcel, 21, this.zzu);
            SafeParcelWriter.writeBoolean(parcel, 22, this.zzv);
            SafeParcelWriter.writeBoolean(parcel, 23, areSnapshotsEnabled());
            SafeParcelWriter.writeString(parcel, 24, getThemeColor(), false);
            SafeParcelWriter.writeBoolean(parcel, 25, hasGamepadSupport());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeString(this.zzd);
        parcel.writeString(this.zze);
        parcel.writeString(this.zzf);
        Uri uri = this.zzg;
        String str3 = null;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        parcel.writeString(str);
        Uri uri2 = this.zzh;
        if (uri2 == null) {
            str2 = null;
        } else {
            str2 = uri2.toString();
        }
        parcel.writeString(str2);
        Uri uri3 = this.zzi;
        if (uri3 != null) {
            str3 = uri3.toString();
        }
        parcel.writeString(str3);
        parcel.writeInt(this.zzj ? 1 : 0);
        parcel.writeInt(this.zzk ? 1 : 0);
        parcel.writeString(this.zzl);
        parcel.writeInt(this.zzm);
        parcel.writeInt(this.zzn);
        parcel.writeInt(this.zzo);
    }

    @RecentlyNonNull
    public final String zza() {
        return this.zzl;
    }

    public final boolean zzb() {
        return this.zzv;
    }

    public final boolean zzc() {
        return this.zzk;
    }

    public final boolean zzd() {
        return this.zzu;
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzp;
    }

    public final boolean zzg() {
        return this.zzq;
    }

    @SafeParcelable.Constructor
    public GameEntity(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) String str2, @SafeParcelable.Param(mo17150id = 3) String str3, @SafeParcelable.Param(mo17150id = 4) String str4, @SafeParcelable.Param(mo17150id = 5) String str5, @SafeParcelable.Param(mo17150id = 6) String str6, @SafeParcelable.Param(mo17150id = 7) Uri uri, @SafeParcelable.Param(mo17150id = 8) Uri uri2, @SafeParcelable.Param(mo17150id = 9) Uri uri3, @SafeParcelable.Param(mo17150id = 10) boolean z, @SafeParcelable.Param(mo17150id = 11) boolean z2, @SafeParcelable.Param(mo17150id = 12) String str7, @SafeParcelable.Param(mo17150id = 13) int i, @SafeParcelable.Param(mo17150id = 14) int i2, @SafeParcelable.Param(mo17150id = 15) int i3, @SafeParcelable.Param(mo17150id = 16) boolean z3, @SafeParcelable.Param(mo17150id = 17) boolean z4, @SafeParcelable.Param(mo17150id = 18) String str8, @SafeParcelable.Param(mo17150id = 19) String str9, @SafeParcelable.Param(mo17150id = 20) String str10, @SafeParcelable.Param(mo17150id = 21) boolean z5, @SafeParcelable.Param(mo17150id = 22) boolean z6, @SafeParcelable.Param(mo17150id = 23) boolean z7, @SafeParcelable.Param(mo17150id = 24) String str11, @SafeParcelable.Param(mo17150id = 25) boolean z8) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = uri;
        this.zzr = str8;
        this.zzh = uri2;
        this.zzs = str9;
        this.zzi = uri3;
        this.zzt = str10;
        this.zzj = z;
        this.zzk = z2;
        this.zzl = str7;
        this.zzm = i;
        this.zzn = i2;
        this.zzo = i3;
        this.zzp = z3;
        this.zzq = z4;
        this.zzu = z5;
        this.zzv = z6;
        this.zzw = z7;
        this.zzx = str11;
        this.zzy = z8;
    }
}
