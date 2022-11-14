package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzayo implements Runnable {
    public final zzayr zza;
    public final zzayi zzb;
    public final zzayj zzc;
    public final zzchj zzd;

    public zzayo(zzayr zzayr, zzayi zzayi, zzayj zzayj, zzchj zzchj) {
        this.zza = zzayr;
        this.zzb = zzayi;
        this.zzc = zzayj;
        this.zzd = zzchj;
    }

    public final void run() {
        zzayg zzayg;
        zzayr zzayr = this.zza;
        zzayi zzayi = this.zzb;
        zzayj zzayj = this.zzc;
        zzchj zzchj = this.zzd;
        try {
            zzayl zzq = zzayi.zzq();
            if (zzayi.zzp()) {
                zzayg = zzq.zzf(zzayj);
            } else {
                zzayg = zzq.zze(zzayj);
            }
            if (!zzayg.zza()) {
                zzchj.zzd(new RuntimeException("No entry contents."));
                zzayt.zzb(zzayr.zzc);
                return;
            }
            zzayq zzayq = new zzayq(zzayr, zzayg.zzb(), 1);
            int read = zzayq.read();
            if (read != -1) {
                zzayq.unread(read);
                zzchj.zzc(zzayv.zza(zzayq, zzayg.zzd(), zzayg.zzg(), zzayg.zzf(), zzayg.zze()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzcgs.zzg("Unable to obtain a cache service instance.", e);
            zzchj.zzd(e);
            zzayt.zzb(zzayr.zzc);
        }
    }
}
