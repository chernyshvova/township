package com.google.android.gms.games;

import androidx.annotation.IntRange;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface EventsClient {
    void increment(@RecentlyNonNull String str, @IntRange(from = 0) int i);

    @RecentlyNonNull
    Task<AnnotatedData<EventBuffer>> load(boolean z);

    @RecentlyNonNull
    Task<AnnotatedData<EventBuffer>> loadByIds(boolean z, @RecentlyNonNull String... strArr);
}
