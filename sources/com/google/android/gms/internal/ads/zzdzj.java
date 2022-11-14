package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzj extends zzdzl {
    public zzdzj(Context context) {
        this.zzf = new zzcav(context, zzs.zzq().zza(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zze(this.zze, new zzdzk(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzeaa(1));
                } catch (Throwable th) {
                    zzs.zzg().zzg(th, "RemoteAdRequestClientTask.onConnected");
                    this.zza.zzd(new zzeaa(1));
                }
            }
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzcgs.zzd("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzeaa(1));
    }
}
