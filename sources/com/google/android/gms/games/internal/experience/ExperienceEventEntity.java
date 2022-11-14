package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "ExperienceEventEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class ExperienceEventEntity extends zzh implements ExperienceEvent {
    @RecentlyNonNull
    public static final Parcelable.Creator<ExperienceEventEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getExperienceId", mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getGame", mo17147id = 2)
    public final GameEntity zzb;
    @SafeParcelable.Field(getter = "getDisplayTitle", mo17147id = 3)
    public final String zzc;
    @SafeParcelable.Field(getter = "getDisplayDescription", mo17147id = 4)
    public final String zzd;
    @SafeParcelable.Field(getter = "getIconImageUrl", mo17147id = 5)
    public final String zze;
    @SafeParcelable.Field(getter = "getIconImageUri", mo17147id = 6)
    public final Uri zzf;
    @SafeParcelable.Field(getter = "getCreatedTimestamp", mo17147id = 7)
    public final long zzg;
    @SafeParcelable.Field(getter = "getXpEarned", mo17147id = 8)
    public final long zzh;
    @SafeParcelable.Field(getter = "getCurrentXp", mo17147id = 9)
    public final long zzi;
    @SafeParcelable.Field(getter = "getType", mo17147id = 10)
    public final int zzj;
    @SafeParcelable.Field(getter = "getNewLevel", mo17147id = 11)
    public final int zzk;

    @SafeParcelable.Constructor
    public ExperienceEventEntity(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) GameEntity gameEntity, @SafeParcelable.Param(mo17150id = 3) String str2, @SafeParcelable.Param(mo17150id = 4) String str3, @SafeParcelable.Param(mo17150id = 5) String str4, @SafeParcelable.Param(mo17150id = 6) Uri uri, @SafeParcelable.Param(mo17150id = 7) long j, @SafeParcelable.Param(mo17150id = 8) long j2, @SafeParcelable.Param(mo17150id = 9) long j3, @SafeParcelable.Param(mo17150id = 10) int i, @SafeParcelable.Param(mo17150id = 11) int i2) {
        this.zza = str;
        this.zzb = gameEntity;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = uri;
        this.zzg = j;
        this.zzh = j2;
        this.zzi = j3;
        this.zzj = i;
        this.zzk = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof ExperienceEvent) {
            if (this == obj) {
                return true;
            }
            ExperienceEvent experienceEvent = (ExperienceEvent) obj;
            return Objects.equal(experienceEvent.zzj(), this.zza) && Objects.equal(experienceEvent.zzg(), this.zzb) && Objects.equal(experienceEvent.zzi(), this.zzc) && Objects.equal(experienceEvent.zzh(), this.zzd) && Objects.equal(experienceEvent.getIconImageUrl(), getIconImageUrl()) && Objects.equal(experienceEvent.zzf(), this.zzf) && Objects.equal(Long.valueOf(experienceEvent.zzc()), Long.valueOf(this.zzg)) && Objects.equal(Long.valueOf(experienceEvent.zze()), Long.valueOf(this.zzh)) && Objects.equal(Long.valueOf(experienceEvent.zzd()), Long.valueOf(this.zzi)) && Objects.equal(Integer.valueOf(experienceEvent.zzb()), Integer.valueOf(this.zzj)) && Objects.equal(Integer.valueOf(experienceEvent.zza()), Integer.valueOf(this.zzk));
        }
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @RecentlyNonNull
    public String getIconImageUrl() {
        return this.zze;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, getIconImageUrl(), this.zzf, Long.valueOf(this.zzg), Long.valueOf(this.zzh), Long.valueOf(this.zzi), Integer.valueOf(this.zzj), Integer.valueOf(this.zzk));
    }

    public final boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        return Objects.toStringHelper(this).add("ExperienceId", this.zza).add("Game", this.zzb).add("DisplayTitle", this.zzc).add("DisplayDescription", this.zzd).add("IconImageUrl", getIconImageUrl()).add("IconImageUri", this.zzf).add("CreatedTimestamp", Long.valueOf(this.zzg)).add("XpEarned", Long.valueOf(this.zzh)).add("CurrentXp", Long.valueOf(this.zzi)).add("Type", Integer.valueOf(this.zzj)).add("NewLevel", Integer.valueOf(this.zzk)).toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzg);
        SafeParcelWriter.writeLong(parcel, 8, this.zzh);
        SafeParcelWriter.writeLong(parcel, 9, this.zzi);
        SafeParcelWriter.writeInt(parcel, 10, this.zzj);
        SafeParcelWriter.writeInt(parcel, 11, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzk;
    }

    public final int zzb() {
        return this.zzj;
    }

    public final long zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzi;
    }

    public final long zze() {
        return this.zzh;
    }

    @RecentlyNonNull
    public final Uri zzf() {
        return this.zzf;
    }

    @RecentlyNonNull
    public final Game zzg() {
        return this.zzb;
    }

    @RecentlyNonNull
    public final String zzh() {
        return this.zzd;
    }

    @RecentlyNonNull
    public final String zzi() {
        return this.zzc;
    }

    @RecentlyNonNull
    public final String zzj() {
        return this.zza;
    }
}
