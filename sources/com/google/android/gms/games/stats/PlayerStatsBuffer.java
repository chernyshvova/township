package com.google.android.gms.games.stats;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class PlayerStatsBuffer extends AbstractDataBuffer<PlayerStats> {
    public PlayerStatsBuffer(@RecentlyNonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @RecentlyNonNull
    /* renamed from: zza */
    public final PlayerStats get(int i) {
        return new zzb(this.mDataHolder, i);
    }
}
