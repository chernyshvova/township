package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzn extends zzdzl {
    public zzdzn(Context context) {
        this.zzf = new zzcav(context, zzs.zzq().zza(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzf(this.zze, new zzdzk(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzeaa(1));
                } catch (Throwable th) {
                    zzs.zzg().zzg(th, "RemoteSignalsClientTask.onConnected");
                    this.zza.zzd(new zzeaa(1));
                }
            }
        }
    }
}
