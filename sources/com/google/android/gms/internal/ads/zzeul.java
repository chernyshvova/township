package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeul extends zzbfq implements zzo, zzaxm {
    @GuardedBy("this")
    @Nullable
    public zzcvc zza;
    public final zzcop zzb;
    public final Context zzc;
    public AtomicBoolean zzd = new AtomicBoolean();
    public final String zze;
    public final zzeuf zzf;
    public final zzeud zzg;
    @GuardedBy("this")
    public long zzh = -1;
    @GuardedBy("this")
    @Nullable
    public zzcue zzi;

    public zzeul(zzcop zzcop, Context context, String str, zzeuf zzeuf, zzeud zzeud) {
        this.zzb = zzcop;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzeuf;
        this.zzg = zzeud;
        zzeud.zzl(this);
    }

    private final synchronized void zzN(int i) {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzg.zzo();
            zzcue zzcue = this.zzi;
            if (zzcue != null) {
                zzs.zzf().zzc(zzcue);
            }
            if (this.zza != null) {
                long j = -1;
                if (this.zzh != -1) {
                    j = zzs.zzj().elapsedRealtime() - this.zzh;
                }
                this.zza.zze(j, i);
            }
            zzc();
        }
    }

    public final synchronized boolean zzA() {
        return this.zzf.zzb();
    }

    public final void zzB(zzccg zzccg) {
    }

    public final void zzC(String str) {
    }

    public final void zzD(String str) {
    }

    public final synchronized zzbhg zzE() {
        return null;
    }

    public final synchronized void zzF(zzbiv zzbiv) {
    }

    public final void zzG(zzbhk zzbhk) {
    }

    public final void zzH(zzbdv zzbdv) {
        this.zzf.zzd(zzbdv);
    }

    public final void zzI(zzaxv zzaxv) {
        this.zzg.zzh(zzaxv);
    }

    public final void zzJ(boolean z) {
    }

    @VisibleForTesting
    public final void zzK() {
        this.zzb.zze().execute(new zzeuh(this));
    }

    public final /* synthetic */ void zzL() {
        zzN(5);
    }

    public final void zzO(zzbha zzbha) {
    }

    public final void zzP(zzbdk zzbdk, zzbfh zzbfh) {
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzR(zzbgf zzbgf) {
    }

    public final void zza() {
        zzN(3);
    }

    public final synchronized void zzab(zzbgc zzbgc) {
    }

    public final IObjectWrapper zzb() {
        return null;
    }

    public final synchronized void zzbE() {
        if (this.zza != null) {
            this.zzh = zzs.zzj().elapsedRealtime();
            int zzc2 = this.zza.zzc();
            if (zzc2 > 0) {
                zzcue zzcue = new zzcue(this.zzb.zzf(), zzs.zzj());
                this.zzi = zzcue;
                zzcue.zzb(zzc2, new zzeui(this));
            }
        }
    }

    public final void zzbH() {
    }

    public final synchronized void zzbI() {
        zzcvc zzcvc = this.zza;
        if (zzcvc != null) {
            zzcvc.zze(zzs.zzj().elapsedRealtime() - this.zzh, 1);
        }
    }

    public final void zzbJ() {
    }

    public final void zzbK(int i) {
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        } else if (i2 == 0) {
            zzN(2);
        } else if (i2 == 1) {
            zzN(4);
        } else if (i2 == 2) {
            zzN(3);
        } else if (i2 == 3) {
            zzN(6);
        }
    }

    public final boolean zzbZ() {
        return false;
    }

    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcvc zzcvc = this.zza;
        if (zzcvc != null) {
            zzcvc.zzT();
        }
    }

    public final void zzca() {
    }

    public final synchronized boolean zze(zzbdk zzbdk) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzs.zzc();
        if (zzr.zzK(this.zzc)) {
            if (zzbdk.zzs == null) {
                zzcgs.zzf("Failed to load the ad because app ID is missing.");
                this.zzg.zzbT(zzezr.zzd(4, (String) null, (zzbdd) null));
                return false;
            }
        }
        if (zzA()) {
            return false;
        }
        this.zzd = new AtomicBoolean();
        return this.zzf.zza(zzbdk, this.zze, new zzeuj(this), new zzeuk(this));
    }

    public final synchronized void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final synchronized void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzh(zzbfe zzbfe) {
    }

    public final void zzi(zzbfy zzbfy) {
    }

    public final void zzj(zzbfv zzbfv) {
    }

    public final Bundle zzk() {
        return new Bundle();
    }

    public final synchronized void zzl() {
    }

    public final synchronized void zzm() {
    }

    public final synchronized zzbdp zzn() {
        return null;
    }

    public final synchronized void zzo(zzbdp zzbdp) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final void zzp(zzcaa zzcaa) {
    }

    public final void zzq(zzcad zzcad, String str) {
    }

    public final synchronized String zzr() {
        return null;
    }

    public final synchronized String zzs() {
        return null;
    }

    public final synchronized zzbhd zzt() {
        return null;
    }

    public final synchronized String zzu() {
        return this.zze;
    }

    public final zzbfy zzv() {
        return null;
    }

    public final zzbfe zzw() {
        return null;
    }

    public final synchronized void zzx(zzbki zzbki) {
    }

    public final void zzy(zzbfb zzbfb) {
    }

    public final synchronized void zzz(boolean z) {
    }
}
