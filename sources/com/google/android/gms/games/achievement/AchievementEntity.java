package com.google.android.gms.games.achievement;

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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "AchievementEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class AchievementEntity extends zzh implements Achievement {
    @RecentlyNonNull
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getAchievementId", mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getType", mo17147id = 2)
    public final int zzb;
    @SafeParcelable.Field(getter = "getName", mo17147id = 3)
    public final String zzc;
    @SafeParcelable.Field(getter = "getDescription", mo17147id = 4)
    public final String zzd;
    @SafeParcelable.Field(getter = "getUnlockedImageUri", mo17147id = 5)
    @Nullable
    public final Uri zze;
    @SafeParcelable.Field(getter = "getUnlockedImageUrl", mo17147id = 6)
    @Nullable
    public final String zzf;
    @SafeParcelable.Field(getter = "getRevealedImageUri", mo17147id = 7)
    @Nullable
    public final Uri zzg;
    @SafeParcelable.Field(getter = "getRevealedImageUrl", mo17147id = 8)
    @Nullable
    public final String zzh;
    @SafeParcelable.Field(getter = "getTotalStepsRaw", mo17147id = 9)
    public final int zzi;
    @SafeParcelable.Field(getter = "getFormattedTotalStepsRaw", mo17147id = 10)
    @Nullable
    public final String zzj;
    @SafeParcelable.Field(getter = "getPlayerInternal", mo17147id = 11)
    @Nullable
    public final PlayerEntity zzk;
    @SafeParcelable.Field(getter = "getState", mo17147id = 12)
    public final int zzl;
    @SafeParcelable.Field(getter = "getCurrentStepsRaw", mo17147id = 13)
    public final int zzm;
    @SafeParcelable.Field(getter = "getFormattedCurrentStepsRaw", mo17147id = 14)
    @Nullable
    public final String zzn;
    @SafeParcelable.Field(getter = "getLastUpdatedTimestamp", mo17147id = 15)
    public final long zzo;
    @SafeParcelable.Field(getter = "getXpValue", mo17147id = 16)
    public final long zzp;
    @SafeParcelable.Field(defaultValue = "-1.0f", getter = "getRarityPercent", mo17147id = 17)
    public final float zzq;
    @SafeParcelable.Field(getter = "getApplicationId", mo17147id = 18)
    public final String zzr;

    public AchievementEntity(@RecentlyNonNull Achievement achievement) {
        this.zza = achievement.getAchievementId();
        this.zzb = achievement.getType();
        this.zzc = achievement.getName();
        this.zzd = achievement.getDescription();
        this.zze = achievement.getUnlockedImageUri();
        this.zzf = achievement.getUnlockedImageUrl();
        this.zzg = achievement.getRevealedImageUri();
        this.zzh = achievement.getRevealedImageUrl();
        Player zzb2 = achievement.zzb();
        if (zzb2 != null) {
            this.zzk = new PlayerEntity(zzb2);
        } else {
            this.zzk = null;
        }
        this.zzl = achievement.getState();
        this.zzo = achievement.getLastUpdatedTimestamp();
        this.zzp = achievement.getXpValue();
        this.zzq = achievement.zza();
        this.zzr = achievement.zzc();
        if (achievement.getType() == 1) {
            this.zzi = achievement.getTotalSteps();
            this.zzj = achievement.getFormattedTotalSteps();
            this.zzm = achievement.getCurrentSteps();
            this.zzn = achievement.getFormattedCurrentSteps();
        } else {
            this.zzi = 0;
            this.zzj = null;
            this.zzm = 0;
            this.zzn = null;
        }
        Asserts.checkNotNull(this.zza);
        Asserts.checkNotNull(this.zzd);
    }

    public static int zzd(Achievement achievement) {
        int i;
        int i2;
        if (achievement.getType() == 1) {
            i2 = achievement.getCurrentSteps();
            i = achievement.getTotalSteps();
        } else {
            i2 = 0;
            i = 0;
        }
        return Objects.hashCode(achievement.getAchievementId(), achievement.zzc(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.zzb(), Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static String zze(Achievement achievement) {
        Objects.ToStringHelper add = Objects.toStringHelper(achievement).add("Id", achievement.getAchievementId()).add("Game Id", achievement.zzc()).add("Type", Integer.valueOf(achievement.getType())).add("Name", achievement.getName()).add("Description", achievement.getDescription()).add("Player", achievement.zzb()).add("State", Integer.valueOf(achievement.getState())).add("Rarity Percent", Float.valueOf(achievement.zza()));
        if (achievement.getType() == 1) {
            add.add("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            add.add("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return add.toString();
    }

    public static boolean zzf(Achievement achievement, @Nullable Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement2.getType() != achievement.getType()) {
            return false;
        }
        return (achievement.getType() != 1 || (achievement2.getCurrentSteps() == achievement.getCurrentSteps() && achievement2.getTotalSteps() == achievement.getTotalSteps())) && achievement2.getXpValue() == achievement.getXpValue() && achievement2.getState() == achievement.getState() && achievement2.getLastUpdatedTimestamp() == achievement.getLastUpdatedTimestamp() && Objects.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && Objects.equal(achievement2.zzc(), achievement.zzc()) && Objects.equal(achievement2.getName(), achievement.getName()) && Objects.equal(achievement2.getDescription(), achievement.getDescription()) && Objects.equal(achievement2.zzb(), achievement.zzb()) && achievement2.zza() == achievement.zza();
    }

    public boolean equals(@Nullable Object obj) {
        return zzf(this, obj);
    }

    @RecentlyNonNull
    public Achievement freeze() {
        return this;
    }

    @RecentlyNonNull
    public String getAchievementId() {
        return this.zza;
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzm;
    }

    @RecentlyNonNull
    public String getDescription() {
        return this.zzd;
    }

    public void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzd, charArrayBuffer);
    }

    @RecentlyNullable
    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzn;
    }

    @RecentlyNullable
    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzj;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzo;
    }

    @RecentlyNonNull
    public String getName() {
        return this.zzc;
    }

    public void getName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    @RecentlyNonNull
    public Player getPlayer() {
        return (Player) Preconditions.checkNotNull(this.zzk);
    }

    @RecentlyNullable
    public Uri getRevealedImageUri() {
        return this.zzg;
    }

    @RecentlyNullable
    public String getRevealedImageUrl() {
        return this.zzh;
    }

    public int getState() {
        return this.zzl;
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return this.zzi;
    }

    public int getType() {
        return this.zzb;
    }

    @RecentlyNullable
    public Uri getUnlockedImageUri() {
        return this.zze;
    }

    @RecentlyNullable
    public String getUnlockedImageUrl() {
        return this.zzf;
    }

    public long getXpValue() {
        return this.zzp;
    }

    public int hashCode() {
        return zzd(this);
    }

    public boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public String toString() {
        return zze(this);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAchievementId(), false);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getUnlockedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getUnlockedImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getRevealedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 8, getRevealedImageUrl(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeString(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 12, getState());
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeLong(parcel, 15, getLastUpdatedTimestamp());
        SafeParcelWriter.writeLong(parcel, 16, getXpValue());
        SafeParcelWriter.writeFloat(parcel, 17, this.zzq);
        SafeParcelWriter.writeString(parcel, 18, this.zzr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final float zza() {
        return this.zzq;
    }

    @RecentlyNullable
    public final Player zzb() {
        return this.zzk;
    }

    @RecentlyNonNull
    public final String zzc() {
        return this.zzr;
    }

    public void getFormattedCurrentSteps(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        DataUtils.copyStringToBuffer(this.zzn, charArrayBuffer);
    }

    public void getFormattedTotalSteps(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    @SafeParcelable.Constructor
    public AchievementEntity(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) int i, @SafeParcelable.Param(mo17150id = 3) String str2, @SafeParcelable.Param(mo17150id = 4) String str3, @SafeParcelable.Param(mo17150id = 5) Uri uri, @SafeParcelable.Param(mo17150id = 6) String str4, @SafeParcelable.Param(mo17150id = 7) Uri uri2, @SafeParcelable.Param(mo17150id = 8) String str5, @SafeParcelable.Param(mo17150id = 9) int i2, @SafeParcelable.Param(mo17150id = 10) String str6, @SafeParcelable.Param(mo17150id = 11) @Nullable PlayerEntity playerEntity, @SafeParcelable.Param(mo17150id = 12) int i3, @SafeParcelable.Param(mo17150id = 13) int i4, @SafeParcelable.Param(mo17150id = 14) String str7, @SafeParcelable.Param(mo17150id = 15) long j, @SafeParcelable.Param(mo17150id = 16) long j2, @SafeParcelable.Param(mo17150id = 17) float f, @SafeParcelable.Param(mo17150id = 18) String str8) {
        this.zza = str;
        this.zzb = i;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = uri;
        this.zzf = str4;
        this.zzg = uri2;
        this.zzh = str5;
        this.zzi = i2;
        this.zzj = str6;
        this.zzk = playerEntity;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = str7;
        this.zzo = j;
        this.zzp = j2;
        this.zzq = f;
        this.zzr = str8;
    }
}
