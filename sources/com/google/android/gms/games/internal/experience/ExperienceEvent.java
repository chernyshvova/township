package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Game;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface ExperienceEvent extends Freezable<ExperienceEvent>, Parcelable {
    @RecentlyNonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    int zza();

    int zzb();

    long zzc();

    long zzd();

    long zze();

    @RecentlyNonNull
    Uri zzf();

    @RecentlyNonNull
    Game zzg();

    @RecentlyNonNull
    String zzh();

    @RecentlyNonNull
    String zzi();

    @RecentlyNonNull
    String zzj();
}
