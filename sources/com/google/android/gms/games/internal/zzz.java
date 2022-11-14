package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.games_v2.zzaj;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzz extends zzaj {
    public final /* synthetic */ zzas zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzz(zzas zzas) {
        super(zzas.getContext().getMainLooper(), 1000);
        this.zza = zzas;
    }

    public final void zza(String str, int i) {
        try {
            if (this.zza.isConnected()) {
                ((zzay) this.zza.getService()).zzz(str, i);
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 89);
            sb.append("Unable to increment event ");
            sb.append(str);
            sb.append(" by ");
            sb.append(i);
            sb.append(" because the games client is no longer connected");
            zzat.zzc("GamesGmsClientImpl", sb.toString());
        } catch (RemoteException e) {
            zzas.zzZ(e);
        } catch (SecurityException e2) {
            zzat.zzd("GamesGmsClientImpl", "Is player signed out?", e2);
        }
    }
}
