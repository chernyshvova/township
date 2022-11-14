package com.google.android.gms.internal.games_v2;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.zzm;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zze extends GoogleApi<zzm> {
    public zze(Context context, @Nullable zzm zzm) {
        super(context, Games.zze, zzm, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder createClientSettingsBuilder = super.createClientSettingsBuilder();
        if (getApiOptions() != null) {
            String str = ((zzm) getApiOptions()).zzl;
        }
        return createClientSettingsBuilder;
    }
}
