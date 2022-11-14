package com.google.android.gms.games.event;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class EventBuffer extends AbstractDataBuffer<Event> {
    public EventBuffer(@RecentlyNonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @RecentlyNonNull
    public Event get(int i) {
        return new EventRef(this.mDataHolder, i);
    }
}
