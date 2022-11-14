package com.google.android.gms.games.achievement;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class AchievementBuffer extends AbstractDataBuffer<Achievement> {
    public AchievementBuffer(@RecentlyNonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @RecentlyNonNull
    public Achievement get(int i) {
        return new AchievementRef(this.mDataHolder, i);
    }
}
