package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zza;
import com.google.android.gms.games.internal.player.zzc;
import com.google.android.gms.games.internal.player.zzd;

@SuppressLint({"ParcelCreator"})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class PlayerRef extends zzn implements Player {
    public final zzd zza;
    public final PlayerLevelInfo zzb;
    public final zzc zzc;
    public final zzu zzd;
    public final zzc zze;

    public PlayerRef(@RecentlyNonNull DataHolder dataHolder, int i, @RecentlyNonNull String str) {
        super(dataHolder, i);
        PlayerLevel playerLevel;
        zzd zzd2 = new zzd((String) null);
        this.zza = zzd2;
        this.zzc = new zzc(dataHolder, i, zzd2);
        this.zzd = new zzu(dataHolder, i, this.zza);
        this.zze = new zzc(dataHolder, i, this.zza);
        if (!hasNull(this.zza.zzj) && getLong(this.zza.zzj) != -1) {
            int integer = getInteger(this.zza.zzk);
            int integer2 = getInteger(this.zza.zzn);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.zza.zzl), getLong(this.zza.zzm));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.zza.zzm), getLong(this.zza.zzo));
            } else {
                playerLevel = playerLevel2;
            }
            this.zzb = new PlayerLevelInfo(getLong(this.zza.zzj), getLong(this.zza.zzp), playerLevel2, playerLevel);
            return;
        }
        this.zzb = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        return PlayerEntity.zzn(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return new PlayerEntity(this);
    }

    @RecentlyNonNull
    public final Uri getBannerImageLandscapeUri() {
        return parseUri(this.zza.zzB);
    }

    @RecentlyNonNull
    public String getBannerImageLandscapeUrl() {
        return getString(this.zza.zzC);
    }

    @RecentlyNonNull
    public final Uri getBannerImagePortraitUri() {
        return parseUri(this.zza.zzD);
    }

    @RecentlyNonNull
    public String getBannerImagePortraitUrl() {
        return getString(this.zza.zzE);
    }

    @RecentlyNonNull
    public final CurrentPlayerInfo getCurrentPlayerInfo() {
        if (this.zze.zza()) {
            return this.zze;
        }
        return null;
    }

    @RecentlyNonNull
    public final String getDisplayName() {
        return getString(this.zza.zzb);
    }

    @RecentlyNonNull
    public final Uri getHiResImageUri() {
        return parseUri(this.zza.zze);
    }

    @RecentlyNonNull
    public String getHiResImageUrl() {
        return getString(this.zza.zzf);
    }

    @RecentlyNonNull
    public final Uri getIconImageUri() {
        return parseUri(this.zza.zzc);
    }

    @RecentlyNonNull
    public String getIconImageUrl() {
        return getString(this.zza.zzd);
    }

    public final long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.zza.zzi) || hasNull(this.zza.zzi)) {
            return -1;
        }
        return getLong(this.zza.zzi);
    }

    @RecentlyNonNull
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzb;
    }

    @RecentlyNonNull
    public final String getPlayerId() {
        return getString(this.zza.zza);
    }

    @RecentlyNonNull
    public final PlayerRelationshipInfo getRelationshipInfo() {
        zzu zzu = this.zzd;
        if (zzu.getFriendStatus() == -1 && zzu.zzb() == null && zzu.zza() == null) {
            return null;
        }
        return this.zzd;
    }

    public final long getRetrievedTimestamp() {
        return getLong(this.zza.zzg);
    }

    @RecentlyNonNull
    public final String getTitle() {
        return getString(this.zza.zzq);
    }

    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public final int hashCode() {
        return PlayerEntity.zzi(this);
    }

    @RecentlyNonNull
    public final String toString() {
        return PlayerEntity.zzk(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        new PlayerEntity(this).writeToParcel(parcel, i);
    }

    public final int zza() {
        return getInteger(this.zza.zzh);
    }

    public final long zzb() {
        String str = this.zza.zzF;
        if (!hasColumn(str) || hasNull(str)) {
            return -1;
        }
        return getLong(str);
    }

    public final zza zzc() {
        if (hasNull(this.zza.zzs)) {
            return null;
        }
        return this.zzc;
    }

    @RecentlyNonNull
    public final String zzd() {
        return getString(this.zza.zzz);
    }

    @RecentlyNonNull
    public final String zze() {
        return getString(this.zza.zzA);
    }

    public final boolean zzf() {
        return getBoolean(this.zza.zzy);
    }

    public final boolean zzg() {
        return hasColumn(this.zza.zzL) && getBoolean(this.zza.zzL);
    }

    public final boolean zzh() {
        return getBoolean(this.zza.zzr);
    }

    public final void getDisplayName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzb, charArrayBuffer);
    }

    public final void getTitle(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzq, charArrayBuffer);
    }
}
