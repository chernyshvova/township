package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zzd;

@SuppressLint({"ParcelCreator"})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzc extends zzn implements CurrentPlayerInfo {
    public final zzd zza;

    public zzc(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zza = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        return zza.zzc(this, obj);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return new zza((CurrentPlayerInfo) this);
    }

    public final int getFriendsListVisibilityStatus() {
        return zzp(this.zza.zzK, 0);
    }

    public final int hashCode() {
        return zza.zza(this);
    }

    public final String toString() {
        return zza.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(new zza((CurrentPlayerInfo) this), parcel, i);
    }

    public final boolean zza() {
        return hasColumn(this.zza.zzK) && !hasNull(this.zza.zzK);
    }
}
