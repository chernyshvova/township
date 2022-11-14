package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zzd;

@SuppressLint({"ParcelCreator"})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzu extends zzn implements PlayerRelationshipInfo {
    public final zzd zza;

    public zzu(DataHolder dataHolder, int i, zzd zzd) {
        super(dataHolder, i);
        this.zza = zzd;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        return zzs.zzf(this, obj);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return new zzs(this);
    }

    public final int getFriendStatus() {
        return zzp(this.zza.zzG, -1);
    }

    public final int hashCode() {
        return zzs.zzd(this);
    }

    public final String toString() {
        return zzs.zze(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzt.zza(new zzs(this), parcel, i);
    }

    public final String zza() {
        return zzq(this.zza.zzI, (String) null);
    }

    public final String zzb() {
        return zzq(this.zza.zzH, (String) null);
    }

    public final String zzc() {
        return zzq(this.zza.zzJ, (String) null);
    }
}
