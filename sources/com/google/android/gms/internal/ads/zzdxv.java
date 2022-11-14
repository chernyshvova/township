package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdxv implements zzo, zzcod {
    public final Context zza;
    public final zzcgy zzb;
    public zzdxo zzc;
    public zzcmr zzd;
    public boolean zze;
    public boolean zzf;
    public long zzg;
    @Nullable
    public zzbgu zzh;
    public boolean zzi;

    public zzdxv(Context context, zzcgy zzcgy) {
        this.zza = context;
        this.zzb = zzcgy;
    }

    private final synchronized boolean zzj(zzbgu zzbgu) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue()) {
            zzcgs.zzi("Ad inspector had an internal error.");
            try {
                zzbgu.zze(zzezr.zzd(16, (String) null, (zzbdd) null));
            } catch (RemoteException unused) {
            }
        } else if (this.zzc == null) {
            zzcgs.zzi("Ad inspector had an internal error.");
            try {
                zzbgu.zze(zzezr.zzd(16, (String) null, (zzbdd) null));
            } catch (RemoteException unused2) {
            }
        } else {
            if (!this.zze && !this.zzf) {
                if (zzs.zzj().currentTimeMillis() >= this.zzg + ((long) ((Integer) zzbex.zzc().zzb(zzbjn.zzge)).intValue())) {
                    return true;
                }
            }
            zzcgs.zzi("Ad inspector cannot be opened because it is already open.");
            try {
                zzbgu.zze(zzezr.zzd(19, (String) null, (zzbdd) null));
            } catch (RemoteException unused3) {
            }
        }
        return false;
        return false;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzk() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            boolean r0 = r2.zzf     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            com.google.android.gms.internal.ads.zzfqo r0 = com.google.android.gms.internal.ads.zzche.zze     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzdxu r1 = new com.google.android.gms.internal.ads.zzdxu     // Catch:{ all -> 0x0018 }
            r1.<init>(r2)     // Catch:{ all -> 0x0018 }
            r0.execute(r1)     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return
        L_0x0016:
            monitor-exit(r2)
            return
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxv.zzk():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|11|12|(1:14)|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 1
            if (r4 == 0) goto L_0x0010
            java.lang.String r4 = "Ad inspector loaded."
            com.google.android.gms.ads.internal.util.zze.zza(r4)     // Catch:{ all -> 0x002c }
            r3.zze = r0     // Catch:{ all -> 0x002c }
            r3.zzk()     // Catch:{ all -> 0x002c }
            monitor-exit(r3)
            return
        L_0x0010:
            java.lang.String r4 = "Ad inspector failed to load."
            com.google.android.gms.internal.ads.zzcgs.zzi(r4)     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzbgu r4 = r3.zzh     // Catch:{ RemoteException -> 0x0023 }
            if (r4 == 0) goto L_0x0023
            r1 = 17
            r2 = 0
            com.google.android.gms.internal.ads.zzbdd r1 = com.google.android.gms.internal.ads.zzezr.zzd(r1, r2, r2)     // Catch:{ RemoteException -> 0x0023 }
            r4.zze(r1)     // Catch:{ RemoteException -> 0x0023 }
        L_0x0023:
            r3.zzi = r0     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzcmr r4 = r3.zzd     // Catch:{ all -> 0x002c }
            r4.destroy()     // Catch:{ all -> 0x002c }
            monitor-exit(r3)
            return
        L_0x002c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxv.zza(boolean):void");
    }

    public final synchronized void zzbE() {
        this.zzf = true;
        zzk();
    }

    public final void zzbH() {
    }

    public final void zzbI() {
    }

    public final void zzbJ() {
    }

    public final synchronized void zzbK(int i) {
        this.zzd.destroy();
        if (!this.zzi) {
            zze.zza("Inspector closed.");
            zzbgu zzbgu = this.zzh;
            if (zzbgu != null) {
                try {
                    zzbgu.zze((zzbdd) null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0;
        this.zzi = false;
        this.zzh = null;
    }

    public final void zzca() {
    }

    public final void zzg(zzdxo zzdxo) {
        this.zzc = zzdxo;
    }

    public final synchronized void zzh(zzbgu zzbgu, zzbpt zzbpt) {
        zzbgu zzbgu2 = zzbgu;
        synchronized (this) {
            if (zzj(zzbgu)) {
                try {
                    zzs.zzd();
                    zzcmr zza2 = zzcnd.zza(this.zza, zzcoh.zzb(), "", false, false, (zzfb) null, (zzbkm) null, this.zzb, (zzbkc) null, (zzl) null, (zza) null, zzayx.zza(), (zzeye) null, (zzeyh) null);
                    this.zzd = zza2;
                    zzcof zzR = zza2.zzR();
                    if (zzR == null) {
                        zzcgs.zzi("Failed to obtain a web view for the ad inspector");
                        try {
                            zzbgu2.zze(zzezr.zzd(17, "Failed to obtain a web view for the ad inspector", (zzbdd) null));
                        } catch (RemoteException unused) {
                        }
                    } else {
                        this.zzh = zzbgu2;
                        zzR.zzK((zzbcz) null, (zzbos) null, (zzo) null, (zzbou) null, (zzv) null, false, (zzbpv) null, (zzb) null, (zzbyr) null, (zzcdz) null, (zzedb) null, (zzfdz) null, (zzduu) null, (zzfdh) null, zzbpt);
                        zzR.zzw(this);
                        this.zzd.loadUrl((String) zzbex.zzc().zzb(zzbjn.zzgc));
                        zzs.zzb();
                        zzm.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
                        this.zzg = zzs.zzj().currentTimeMillis();
                    }
                } catch (zzcnc e) {
                    zzcgs.zzj("Failed to obtain a web view for the ad inspector", e);
                    try {
                        zzbgu2.zze(zzezr.zzd(17, "Failed to obtain a web view for the ad inspector", (zzbdd) null));
                    } catch (RemoteException unused2) {
                    }
                }
            }
        }
    }

    public final /* synthetic */ void zzi() {
        this.zzd.zzb("window.inspectorInfo", this.zzc.zzm().toString());
    }
}
