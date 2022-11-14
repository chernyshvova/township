package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class PlayerBuffer extends AbstractDataBuffer<Player> {
    public PlayerBuffer(@RecentlyNonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @RecentlyNonNull
    public Player get(int i) {
        return new PlayerRef(this.mDataHolder, i, (String) null);
    }
}
