package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "PlayerStatsEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class PlayerStatsEntity extends zzh implements PlayerStats {
    @RecentlyNonNull
    public static final Parcelable.Creator<PlayerStatsEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getAverageSessionLength", mo17147id = 1)
    public final float zza;
    @SafeParcelable.Field(getter = "getChurnProbability", mo17147id = 2)
    public final float zzb;
    @SafeParcelable.Field(getter = "getDaysSinceLastPlayed", mo17147id = 3)
    public final int zzc;
    @SafeParcelable.Field(getter = "getNumberOfPurchases", mo17147id = 4)
    public final int zzd;
    @SafeParcelable.Field(getter = "getNumberOfSessions", mo17147id = 5)
    public final int zze;
    @SafeParcelable.Field(getter = "getSessionPercentile", mo17147id = 6)
    public final float zzf;
    @SafeParcelable.Field(getter = "getSpendPercentile", mo17147id = 7)
    public final float zzg;
    @SafeParcelable.Field(getter = "getRawValues", mo17147id = 8)
    public final Bundle zzh;
    @SafeParcelable.Field(getter = "getSpendProbability", mo17147id = 9)
    public final float zzi;
    @SafeParcelable.Field(getter = "getHighSpenderProbability", mo17147id = 10)
    public final float zzj;
    @SafeParcelable.Field(getter = "getTotalSpendNext28Days", mo17147id = 11)
    public final float zzk;

    @SafeParcelable.Constructor
    public PlayerStatsEntity(@SafeParcelable.Param(mo17150id = 1) float f, @SafeParcelable.Param(mo17150id = 2) float f2, @SafeParcelable.Param(mo17150id = 3) int i, @SafeParcelable.Param(mo17150id = 4) int i2, @SafeParcelable.Param(mo17150id = 5) int i3, @SafeParcelable.Param(mo17150id = 6) float f3, @SafeParcelable.Param(mo17150id = 7) float f4, @SafeParcelable.Param(mo17150id = 8) Bundle bundle, @SafeParcelable.Param(mo17150id = 9) float f5, @SafeParcelable.Param(mo17150id = 10) float f6, @SafeParcelable.Param(mo17150id = 11) float f7) {
        this.zza = f;
        this.zzb = f2;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = f3;
        this.zzg = f4;
        this.zzh = bundle;
        this.zzi = f5;
        this.zzj = f6;
        this.zzk = f7;
    }

    public static int zzb(PlayerStats playerStats) {
        return Objects.hashCode(Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.getChurnProbability()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()), Float.valueOf(playerStats.getSpendProbability()), Float.valueOf(playerStats.getHighSpenderProbability()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    public static String zzc(PlayerStats playerStats) {
        return Objects.toStringHelper(playerStats).add("AverageSessionLength", Float.valueOf(playerStats.getAverageSessionLength())).add("ChurnProbability", Float.valueOf(playerStats.getChurnProbability())).add("DaysSinceLastPlayed", Integer.valueOf(playerStats.getDaysSinceLastPlayed())).add("NumberOfPurchases", Integer.valueOf(playerStats.getNumberOfPurchases())).add("NumberOfSessions", Integer.valueOf(playerStats.getNumberOfSessions())).add("SessionPercentile", Float.valueOf(playerStats.getSessionPercentile())).add("SpendPercentile", Float.valueOf(playerStats.getSpendPercentile())).add("SpendProbability", Float.valueOf(playerStats.getSpendProbability())).add("HighSpenderProbability", Float.valueOf(playerStats.getHighSpenderProbability())).add("TotalSpendNext28Days", Float.valueOf(playerStats.getTotalSpendNext28Days())).toString();
    }

    public static boolean zzd(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return Objects.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) && Objects.equal(Float.valueOf(playerStats2.getChurnProbability()), Float.valueOf(playerStats.getChurnProbability())) && Objects.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) && Objects.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendProbability()), Float.valueOf(playerStats.getSpendProbability())) && Objects.equal(Float.valueOf(playerStats2.getHighSpenderProbability()), Float.valueOf(playerStats.getHighSpenderProbability())) && Objects.equal(Float.valueOf(playerStats2.getTotalSpendNext28Days()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    public final boolean equals(@Nullable Object obj) {
        return zzd(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final float getAverageSessionLength() {
        return this.zza;
    }

    public final float getChurnProbability() {
        return this.zzb;
    }

    public final int getDaysSinceLastPlayed() {
        return this.zzc;
    }

    public final float getHighSpenderProbability() {
        return this.zzj;
    }

    public final int getNumberOfPurchases() {
        return this.zzd;
    }

    public final int getNumberOfSessions() {
        return this.zze;
    }

    public final float getSessionPercentile() {
        return this.zzf;
    }

    public final float getSpendPercentile() {
        return this.zzg;
    }

    public final float getSpendProbability() {
        return this.zzi;
    }

    public final float getTotalSpendNext28Days() {
        return this.zzk;
    }

    public final int hashCode() {
        return zzb(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    @RecentlyNonNull
    public final String toString() {
        return zzc(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    @RecentlyNonNull
    public final Bundle zza() {
        return this.zzh;
    }

    public PlayerStatsEntity(@RecentlyNonNull PlayerStats playerStats) {
        this.zza = playerStats.getAverageSessionLength();
        this.zzb = playerStats.getChurnProbability();
        this.zzc = playerStats.getDaysSinceLastPlayed();
        this.zzd = playerStats.getNumberOfPurchases();
        this.zze = playerStats.getNumberOfSessions();
        this.zzf = playerStats.getSessionPercentile();
        this.zzg = playerStats.getSpendPercentile();
        this.zzi = playerStats.getSpendProbability();
        this.zzj = playerStats.getHighSpenderProbability();
        this.zzk = playerStats.getTotalSpendNext28Days();
        this.zzh = playerStats.zza();
    }
}
