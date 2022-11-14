package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayf {
    public final Runnable zza = new zzayb(this);
    public final Object zzb = new Object();
    @GuardedBy("lock")
    @Nullable
    public zzayi zzc;
    @GuardedBy("lock")
    @Nullable
    public Context zzd;
    @GuardedBy("lock")
    @Nullable
    public zzayl zze;

    public static /* synthetic */ void zzf(zzayf zzayf) {
        synchronized (zzayf.zzb) {
            zzayi zzayi = zzayf.zzc;
            if (zzayi != null) {
                if (zzayi.isConnected() || zzayf.zzc.isConnecting()) {
                    zzayf.zzc.disconnect();
                }
                zzayf.zzc = null;
                zzayf.zze = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzb
            monitor-enter(r0)
            android.content.Context r1 = r3.zzd     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzayi r1 = r3.zzc     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.google.android.gms.internal.ads.zzayd r1 = new com.google.android.gms.internal.ads.zzayd     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzaye r2 = new com.google.android.gms.internal.ads.zzaye     // Catch:{ all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzayi r1 = r3.zze(r1, r2)     // Catch:{ all -> 0x0023 }
            r3.zzc = r1     // Catch:{ all -> 0x0023 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayf.zzl():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.zzb
            monitor-enter(r0)
            android.content.Context r1 = r2.zzd     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zzd = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzbjn.zzcz     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.zzl()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzbjn.zzcy     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzayc r3 = new com.google.android.gms.internal.ads.zzayc     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzawt r1 = com.google.android.gms.ads.internal.zzs.zzf()     // Catch:{ all -> 0x0048 }
            r1.zzb(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayf.zza(android.content.Context):void");
    }

    public final void zzb() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcA)).booleanValue()) {
            synchronized (this.zzb) {
                zzl();
                zzr.zza.removeCallbacks(this.zza);
                zzr.zza.postDelayed(this.zza, ((Long) zzbex.zzc().zzb(zzbjn.zzcB)).longValue());
            }
        }
    }

    public final zzayg zzc(zzayj zzayj) {
        synchronized (this.zzb) {
            if (this.zze == null) {
                zzayg zzayg = new zzayg();
                return zzayg;
            }
            try {
                if (this.zzc.zzp()) {
                    zzayg zzf = this.zze.zzf(zzayj);
                    return zzf;
                }
                zzayg zze2 = this.zze.zze(zzayj);
                return zze2;
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call into cache service.", e);
                return new zzayg();
            }
        }
    }

    public final long zzd(zzayj zzayj) {
        synchronized (this.zzb) {
            if (this.zze == null) {
                return -2;
            }
            if (this.zzc.zzp()) {
                try {
                    long zzg = this.zze.zzg(zzayj);
                    return zzg;
                } catch (RemoteException e) {
                    zzcgs.zzg("Unable to call into cache service.", e);
                    return -2;
                }
            }
        }
    }

    @VisibleForTesting
    public final synchronized zzayi zze(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzayi(this.zzd, zzs.zzq().zza(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }
}
