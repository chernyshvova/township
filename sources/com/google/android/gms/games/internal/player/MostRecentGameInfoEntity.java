package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "MostRecentGameInfoEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class MostRecentGameInfoEntity extends zzh implements zza {
    @RecentlyNonNull
    public static final Parcelable.Creator<MostRecentGameInfoEntity> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getGameId", mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getGameName", mo17147id = 2)
    public final String zzb;
    @SafeParcelable.Field(getter = "getActivityTimestampMillis", mo17147id = 3)
    public final long zzc;
    @SafeParcelable.Field(getter = "getGameIconImageUri", mo17147id = 4)
    public final Uri zzd;
    @SafeParcelable.Field(getter = "getGameHiResImageUri", mo17147id = 5)
    public final Uri zze;
    @SafeParcelable.Field(getter = "getGameFeaturedImageUri", mo17147id = 6)
    public final Uri zzf;

    public MostRecentGameInfoEntity(zza zza2) {
        this.zza = zza2.zze();
        this.zzb = zza2.zzf();
        this.zzc = zza2.zza();
        this.zzd = zza2.zzd();
        this.zze = zza2.zzc();
        this.zzf = zza2.zzb();
    }

    public static int zzg(zza zza2) {
        return Objects.hashCode(zza2.zze(), zza2.zzf(), Long.valueOf(zza2.zza()), zza2.zzd(), zza2.zzc(), zza2.zzb());
    }

    public static String zzh(zza zza2) {
        return Objects.toStringHelper(zza2).add("GameId", zza2.zze()).add("GameName", zza2.zzf()).add("ActivityTimestampMillis", Long.valueOf(zza2.zza())).add("GameIconUri", zza2.zzd()).add("GameHiResUri", zza2.zzc()).add("GameFeaturedUri", zza2.zzb()).toString();
    }

    public static boolean zzi(zza zza2, Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (zza2 == obj) {
            return true;
        }
        zza zza3 = (zza) obj;
        return Objects.equal(zza3.zze(), zza2.zze()) && Objects.equal(zza3.zzf(), zza2.zzf()) && Objects.equal(Long.valueOf(zza3.zza()), Long.valueOf(zza2.zza())) && Objects.equal(zza3.zzd(), zza2.zzd()) && Objects.equal(zza3.zzc(), zza2.zzc()) && Objects.equal(zza3.zzb(), zza2.zzb());
    }

    public final boolean equals(@Nullable Object obj) {
        return zzi(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return zzg(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        return zzh(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public final long zza() {
        return this.zzc;
    }

    @RecentlyNonNull
    public final Uri zzb() {
        return this.zzf;
    }

    @RecentlyNonNull
    public final Uri zzc() {
        return this.zze;
    }

    @RecentlyNonNull
    public final Uri zzd() {
        return this.zzd;
    }

    @RecentlyNonNull
    public final String zze() {
        return this.zza;
    }

    @RecentlyNonNull
    public final String zzf() {
        return this.zzb;
    }

    @SafeParcelable.Constructor
    public MostRecentGameInfoEntity(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) String str2, @SafeParcelable.Param(mo17150id = 3) long j, @SafeParcelable.Param(mo17150id = 4) Uri uri, @SafeParcelable.Param(mo17150id = 5) Uri uri2, @SafeParcelable.Param(mo17150id = 6) Uri uri3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = uri;
        this.zze = uri2;
        this.zzf = uri3;
    }
}
