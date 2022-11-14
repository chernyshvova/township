package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzr extends zzdzl {
    public String zzg;
    public int zzh = 1;

    public zzdzr(Context context) {
        this.zzf = new zzcav(context, zzs.zzq().zza(), this, this);
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i = this.zzh;
                    if (i == 2) {
                        this.zzf.zzp().zzg(this.zze, new zzdzk(this));
                    } else if (i == 3) {
                        this.zzf.zzp().zzh(this.zzg, new zzdzk(this));
                    } else {
                        this.zza.zzd(new zzeaa(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzeaa(1));
                } catch (Throwable th) {
                    zzs.zzg().zzg(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zzd(new zzeaa(1));
                }
            }
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzcgs.zzd("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzeaa(1));
    }

    public final zzfqn<InputStream> zzb(zzcbk zzcbk) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 2) {
                zzfqn<InputStream> zzc = zzfqe.zzc(new zzeaa(2));
                return zzc;
            } else if (this.zzc) {
                zzchj<InputStream> zzchj = this.zza;
                return zzchj;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzcbk;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zze(new zzdzp(this), zzche.zzf);
                zzchj<InputStream> zzchj2 = this.zza;
                return zzchj2;
            }
        }
    }

    public final zzfqn<InputStream> zzc(String str) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 3) {
                zzfqn<InputStream> zzc = zzfqe.zzc(new zzeaa(2));
                return zzc;
            } else if (this.zzc) {
                zzchj<InputStream> zzchj = this.zza;
                return zzchj;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zze(new zzdzq(this), zzche.zzf);
                zzchj<InputStream> zzchj2 = this.zza;
                return zzchj2;
            }
        }
    }
}
