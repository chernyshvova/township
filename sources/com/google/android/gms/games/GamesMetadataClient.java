package com.google.android.gms.games;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface GamesMetadataClient {
    @RecentlyNonNull
    Task<Game> getCurrentGame();

    @RecentlyNonNull
    Task<AnnotatedData<Game>> loadGame();
}
