package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzas;
import com.google.android.gms.games.internal.zzay;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzdm implements RemoteCall {
    public final /* synthetic */ Player zza;

    public /* synthetic */ zzdm(Player player) {
        this.zza = player;
    }

    public final void accept(Object obj, Object obj2) {
        Intent zzi = ((zzay) ((zzas) obj).getService()).zzi(new PlayerEntity(this.zza));
        zzi.setExtrasClassLoader(PlayerEntity.class.getClassLoader());
        ((TaskCompletionSource) obj2).setResult(zzi);
    }
}
