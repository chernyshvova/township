package com.google.android.gms.internal.games_v2;

import androidx.annotation.NonNull;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.EventsClient;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzck implements EventsClient {
    public final zzar zza;

    public zzck(zzar zzar) {
        this.zza = zzar;
    }

    public final void increment(@NonNull String str, int i) {
        this.zza.zzb(new zzch(str, i));
    }

    public final Task<AnnotatedData<EventBuffer>> load(boolean z) {
        return this.zza.zzb(new zzci(z));
    }

    public final Task<AnnotatedData<EventBuffer>> loadByIds(boolean z, @NonNull String... strArr) {
        return this.zza.zzb(new zzcj(z, strArr));
    }
}
