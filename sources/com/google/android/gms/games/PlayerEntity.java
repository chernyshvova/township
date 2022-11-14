package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.internal.player.zza;

@RetainForClient
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "PlayerEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    @RecentlyNonNull
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new zzo();
    @SafeParcelable.Field(getter = "getPlayerId", mo17147id = 1)
    public String zza;
    @SafeParcelable.Field(getter = "getDisplayName", mo17147id = 2)
    public String zzb;
    @SafeParcelable.Field(getter = "getIconImageUri", mo17147id = 3)
    @Nullable
    public final Uri zzc;
    @SafeParcelable.Field(getter = "getHiResImageUri", mo17147id = 4)
    @Nullable
    public final Uri zzd;
    @SafeParcelable.Field(getter = "getRetrievedTimestamp", mo17147id = 5)
    public final long zze;
    @SafeParcelable.Field(getter = "isInCircles", mo17147id = 6)
    public final int zzf;
    @SafeParcelable.Field(getter = "getLastPlayedWithTimestamp", mo17147id = 7)
    public final long zzg;
    @SafeParcelable.Field(getter = "getIconImageUrl", mo17147id = 8)
    @Nullable
    public final String zzh;
    @SafeParcelable.Field(getter = "getHiResImageUrl", mo17147id = 9)
    @Nullable
    public final String zzi;
    @SafeParcelable.Field(getter = "getTitle", mo17147id = 14)
    @Nullable
    public final String zzj;
    @SafeParcelable.Field(getter = "getMostRecentGameInfo", mo17147id = 15)
    @Nullable
    public final MostRecentGameInfoEntity zzk;
    @SafeParcelable.Field(getter = "getLevelInfo", mo17147id = 16)
    @Nullable
    public final PlayerLevelInfo zzl;
    @SafeParcelable.Field(getter = "isProfileVisible", mo17147id = 18)
    public final boolean zzm;
    @SafeParcelable.Field(getter = "hasDebugAccess", mo17147id = 19)
    public final boolean zzn;
    @SafeParcelable.Field(getter = "getGamerTag", mo17147id = 20)
    @Nullable
    public final String zzo;
    @SafeParcelable.Field(getter = "getName", mo17147id = 21)
    public final String zzp;
    @SafeParcelable.Field(getter = "getBannerImageLandscapeUri", mo17147id = 22)
    @Nullable
    public final Uri zzq;
    @SafeParcelable.Field(getter = "getBannerImageLandscapeUrl", mo17147id = 23)
    @Nullable
    public final String zzr;
    @SafeParcelable.Field(getter = "getBannerImagePortraitUri", mo17147id = 24)
    @Nullable
    public final Uri zzs;
    @SafeParcelable.Field(getter = "getBannerImagePortraitUrl", mo17147id = 25)
    @Nullable
    public final String zzt;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getTotalUnlockedAchievement", mo17147id = 29)
    public long zzu;
    @SafeParcelable.Field(getter = "getRelationshipInfo", mo17147id = 33)
    @Nullable
    public final zzs zzv;
    @SafeParcelable.Field(getter = "getCurrentPlayerInfo", mo17147id = 35)
    @Nullable
    public final zza zzw;
    @SafeParcelable.Field(getter = "isAlwaysAutoSignIn", mo17147id = 36)
    public boolean zzx;

    /* JADX WARNING: type inference failed for: r0v23, types: [java.lang.Object, com.google.android.gms.games.PlayerRelationshipInfo] */
    public PlayerEntity(@RecentlyNonNull Player player) {
        MostRecentGameInfoEntity mostRecentGameInfoEntity;
        zzs zzs2;
        this.zza = player.getPlayerId();
        this.zzb = player.getDisplayName();
        this.zzc = player.getIconImageUri();
        this.zzh = player.getIconImageUrl();
        this.zzd = player.getHiResImageUri();
        this.zzi = player.getHiResImageUrl();
        this.zze = player.getRetrievedTimestamp();
        this.zzf = player.zza();
        this.zzg = player.getLastPlayedWithTimestamp();
        this.zzj = player.getTitle();
        this.zzm = player.zzh();
        zza zzc2 = player.zzc();
        Object obj = null;
        if (zzc2 == null) {
            mostRecentGameInfoEntity = null;
        } else {
            mostRecentGameInfoEntity = new MostRecentGameInfoEntity(zzc2);
        }
        this.zzk = mostRecentGameInfoEntity;
        this.zzl = player.getLevelInfo();
        this.zzn = player.zzf();
        this.zzo = player.zzd();
        this.zzp = player.zze();
        this.zzq = player.getBannerImageLandscapeUri();
        this.zzr = player.getBannerImageLandscapeUrl();
        this.zzs = player.getBannerImagePortraitUri();
        this.zzt = player.getBannerImagePortraitUrl();
        this.zzu = player.zzb();
        PlayerRelationshipInfo relationshipInfo = player.getRelationshipInfo();
        if (relationshipInfo == null) {
            zzs2 = null;
        } else {
            zzs2 = new zzs(relationshipInfo.freeze());
        }
        this.zzv = zzs2;
        CurrentPlayerInfo currentPlayerInfo = player.getCurrentPlayerInfo();
        this.zzw = (zza) (currentPlayerInfo != null ? currentPlayerInfo.freeze() : obj);
        this.zzx = player.zzg();
        Asserts.checkNotNull(this.zza);
        Asserts.checkNotNull(this.zzb);
        Asserts.checkState(this.zze > 0);
    }

    public static int zzi(Player player) {
        return Objects.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzf()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzd(), player.zze(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Long.valueOf(player.zzb()), player.getRelationshipInfo(), player.getCurrentPlayerInfo(), Boolean.valueOf(player.zzg()));
    }

    public static String zzk(Player player) {
        Objects.ToStringHelper add = Objects.toStringHelper(player).add("PlayerId", player.getPlayerId()).add("DisplayName", player.getDisplayName()).add("HasDebugAccess", Boolean.valueOf(player.zzf())).add("IconImageUri", player.getIconImageUri()).add("IconImageUrl", player.getIconImageUrl()).add("HiResImageUri", player.getHiResImageUri()).add("HiResImageUrl", player.getHiResImageUrl()).add("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).add("Title", player.getTitle()).add("LevelInfo", player.getLevelInfo()).add("GamerTag", player.zzd()).add("Name", player.zze()).add("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).add("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).add("BannerImagePortraitUri", player.getBannerImagePortraitUri()).add("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).add("CurrentPlayerInfo", player.getCurrentPlayerInfo()).add("TotalUnlockedAchievement", Long.valueOf(player.zzb()));
        if (player.zzg()) {
            add.add("AlwaysAutoSignIn", Boolean.valueOf(player.zzg()));
        }
        if (player.getRelationshipInfo() != null) {
            add.add("RelationshipInfo", player.getRelationshipInfo());
        }
        return add.toString();
    }

    public static boolean zzn(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return Objects.equal(player2.getPlayerId(), player.getPlayerId()) && Objects.equal(player2.getDisplayName(), player.getDisplayName()) && Objects.equal(Boolean.valueOf(player2.zzf()), Boolean.valueOf(player.zzf())) && Objects.equal(player2.getIconImageUri(), player.getIconImageUri()) && Objects.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && Objects.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && Objects.equal(player2.getTitle(), player.getTitle()) && Objects.equal(player2.getLevelInfo(), player.getLevelInfo()) && Objects.equal(player2.zzd(), player.zzd()) && Objects.equal(player2.zze(), player.zze()) && Objects.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && Objects.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && Objects.equal(Long.valueOf(player2.zzb()), Long.valueOf(player.zzb())) && Objects.equal(player2.getCurrentPlayerInfo(), player.getCurrentPlayerInfo()) && Objects.equal(player2.getRelationshipInfo(), player.getRelationshipInfo()) && Objects.equal(Boolean.valueOf(player2.zzg()), Boolean.valueOf(player.zzg()));
    }

    public boolean equals(@Nullable Object obj) {
        return zzn(this, obj);
    }

    @RecentlyNonNull
    public Player freeze() {
        return this;
    }

    @RecentlyNullable
    public Uri getBannerImageLandscapeUri() {
        return this.zzq;
    }

    @RecentlyNullable
    public String getBannerImageLandscapeUrl() {
        return this.zzr;
    }

    @RecentlyNullable
    public Uri getBannerImagePortraitUri() {
        return this.zzs;
    }

    @RecentlyNullable
    public String getBannerImagePortraitUrl() {
        return this.zzt;
    }

    @RecentlyNonNull
    public CurrentPlayerInfo getCurrentPlayerInfo() {
        return this.zzw;
    }

    @RecentlyNonNull
    public String getDisplayName() {
        return this.zzb;
    }

    public void getDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @RecentlyNullable
    public Uri getHiResImageUri() {
        return this.zzd;
    }

    @RecentlyNullable
    public String getHiResImageUrl() {
        return this.zzi;
    }

    @RecentlyNullable
    public Uri getIconImageUri() {
        return this.zzc;
    }

    @RecentlyNullable
    public String getIconImageUrl() {
        return this.zzh;
    }

    public long getLastPlayedWithTimestamp() {
        return this.zzg;
    }

    @RecentlyNullable
    public PlayerLevelInfo getLevelInfo() {
        return this.zzl;
    }

    @RecentlyNonNull
    public String getPlayerId() {
        return this.zza;
    }

    @RecentlyNullable
    public PlayerRelationshipInfo getRelationshipInfo() {
        return this.zzv;
    }

    public long getRetrievedTimestamp() {
        return this.zze;
    }

    @RecentlyNullable
    public String getTitle() {
        return this.zzj;
    }

    public void getTitle(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzi(this);
    }

    public boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public String toString() {
        return zzk(this);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        String str;
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getPlayerId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
            SafeParcelWriter.writeLong(parcel, 5, getRetrievedTimestamp());
            SafeParcelWriter.writeInt(parcel, 6, this.zzf);
            SafeParcelWriter.writeLong(parcel, 7, getLastPlayedWithTimestamp());
            SafeParcelWriter.writeString(parcel, 8, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 9, getHiResImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 14, getTitle(), false);
            SafeParcelWriter.writeParcelable(parcel, 15, this.zzk, i, false);
            SafeParcelWriter.writeParcelable(parcel, 16, getLevelInfo(), i, false);
            SafeParcelWriter.writeBoolean(parcel, 18, this.zzm);
            SafeParcelWriter.writeBoolean(parcel, 19, this.zzn);
            SafeParcelWriter.writeString(parcel, 20, this.zzo, false);
            SafeParcelWriter.writeString(parcel, 21, this.zzp, false);
            SafeParcelWriter.writeParcelable(parcel, 22, getBannerImageLandscapeUri(), i, false);
            SafeParcelWriter.writeString(parcel, 23, getBannerImageLandscapeUrl(), false);
            SafeParcelWriter.writeParcelable(parcel, 24, getBannerImagePortraitUri(), i, false);
            SafeParcelWriter.writeString(parcel, 25, getBannerImagePortraitUrl(), false);
            SafeParcelWriter.writeLong(parcel, 29, this.zzu);
            SafeParcelWriter.writeParcelable(parcel, 33, getRelationshipInfo(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 35, getCurrentPlayerInfo(), i, false);
            SafeParcelWriter.writeBoolean(parcel, 36, this.zzx);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        Uri uri = this.zzc;
        String str2 = null;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        parcel.writeString(str);
        Uri uri2 = this.zzd;
        if (uri2 != null) {
            str2 = uri2.toString();
        }
        parcel.writeString(str2);
        parcel.writeLong(this.zze);
    }

    public final int zza() {
        return this.zzf;
    }

    public final long zzb() {
        return this.zzu;
    }

    @Nullable
    public final zza zzc() {
        return this.zzk;
    }

    @RecentlyNullable
    public final String zzd() {
        return this.zzo;
    }

    @RecentlyNonNull
    public final String zze() {
        return this.zzp;
    }

    public final boolean zzf() {
        return this.zzn;
    }

    public final boolean zzg() {
        return this.zzx;
    }

    public final boolean zzh() {
        return this.zzm;
    }

    @SafeParcelable.Constructor
    public PlayerEntity(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) String str2, @SafeParcelable.Param(mo17150id = 3) @Nullable Uri uri, @SafeParcelable.Param(mo17150id = 4) @Nullable Uri uri2, @SafeParcelable.Param(mo17150id = 5) long j, @SafeParcelable.Param(mo17150id = 6) int i, @SafeParcelable.Param(mo17150id = 7) long j2, @SafeParcelable.Param(mo17150id = 8) @Nullable String str3, @SafeParcelable.Param(mo17150id = 9) @Nullable String str4, @SafeParcelable.Param(mo17150id = 14) @Nullable String str5, @SafeParcelable.Param(mo17150id = 15) @Nullable MostRecentGameInfoEntity mostRecentGameInfoEntity, @SafeParcelable.Param(mo17150id = 16) @Nullable PlayerLevelInfo playerLevelInfo, @SafeParcelable.Param(mo17150id = 18) boolean z, @SafeParcelable.Param(mo17150id = 19) boolean z2, @SafeParcelable.Param(mo17150id = 20) @Nullable String str6, @SafeParcelable.Param(mo17150id = 21) String str7, @SafeParcelable.Param(mo17150id = 22) @Nullable Uri uri3, @SafeParcelable.Param(mo17150id = 23) @Nullable String str8, @SafeParcelable.Param(mo17150id = 24) @Nullable Uri uri4, @SafeParcelable.Param(mo17150id = 25) @Nullable String str9, @SafeParcelable.Param(mo17150id = 29) long j3, @SafeParcelable.Param(mo17150id = 33) @Nullable zzs zzs2, @SafeParcelable.Param(mo17150id = 35) @Nullable zza zza2, @SafeParcelable.Param(mo17150id = 36) boolean z3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = uri;
        this.zzh = str3;
        this.zzd = uri2;
        this.zzi = str4;
        this.zze = j;
        this.zzf = i;
        this.zzg = j2;
        this.zzj = str5;
        this.zzm = z;
        this.zzk = mostRecentGameInfoEntity;
        this.zzl = playerLevelInfo;
        this.zzn = z2;
        this.zzo = str6;
        this.zzp = str7;
        this.zzq = uri3;
        this.zzr = str8;
        this.zzs = uri4;
        this.zzt = str9;
        this.zzu = j3;
        this.zzv = zzs2;
        this.zzw = zza2;
        this.zzx = z3;
    }
}
