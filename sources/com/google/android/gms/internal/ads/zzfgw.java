package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfgw implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    @VisibleForTesting
    public final zzfhy zza;
    public final String zzb;
    public final String zzc;
    public final zzhl zzd;
    public final LinkedBlockingQueue<zzfik> zze;
    public final HandlerThread zzf;
    public final zzfgn zzg;
    public final long zzh = System.currentTimeMillis();

    public zzfgw(Context context, int i, zzhl zzhl, String str, String str2, String str3, zzfgn zzfgn) {
        this.zzb = str;
        this.zzd = zzhl;
        this.zzc = str2;
        this.zzg = zzfgn;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzf = handlerThread;
        handlerThread.start();
        this.zza = new zzfhy(context, this.zzf.getLooper(), this, this, 19621000);
        this.zze = new LinkedBlockingQueue<>();
        this.zza.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    public static zzfik zzc() {
        return new zzfik((byte[]) null, 1);
    }

    private final void zze(int i, long j, Exception exc) {
        this.zzg.zzd(i, System.currentTimeMillis() - j, exc);
    }

    public final void onConnected(Bundle bundle) {
        zzfid zzd2 = zzd();
        if (zzd2 != null) {
            try {
                zzfik zzg2 = zzd2.zzg(new zzfii(1, this.zzd, this.zzb, this.zzc));
                zze(5011, this.zzh, (Exception) null);
                this.zze.put(zzg2);
            } catch (Throwable th) {
                zzb();
                this.zzf.quit();
                throw th;
            }
            zzb();
            this.zzf.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(4012, this.zzh, (Exception) null);
            this.zze.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            zze(4011, this.zzh, (Exception) null);
            this.zze.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    public final zzfik zza(int i) {
        zzfik zzfik;
        try {
            zzfik = this.zze.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zze(AdError.INTERSTITIAL_AD_TIMEOUT, this.zzh, e);
            zzfik = null;
        }
        zze(AuthApiStatusCodes.AUTH_TOKEN_ERROR, this.zzh, (Exception) null);
        if (zzfik != null) {
            if (zzfik.zzc == 7) {
                zzfgn.zza(zzca.DISABLED);
            } else {
                zzfgn.zza(zzca.ENABLED);
            }
        }
        return zzfik == null ? zzc() : zzfik;
    }

    public final void zzb() {
        zzfhy zzfhy = this.zza;
        if (zzfhy == null) {
            return;
        }
        if (zzfhy.isConnected() || this.zza.isConnecting()) {
            this.zza.disconnect();
        }
    }

    public final zzfid zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
