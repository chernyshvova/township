package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzejy extends zzbfq implements zzddt {
    public final Context zza;
    public final zzeur zzb;
    public final String zzc;
    public final zzekq zzd;
    public zzbdp zze;
    @GuardedBy("this")
    public final zzeyv zzf;
    @GuardedBy("this")
    @Nullable
    public zzcvj zzg;

    public zzejy(Context context, zzbdp zzbdp, String str, zzeur zzeur, zzekq zzekq) {
        this.zza = context;
        this.zzb = zzeur;
        this.zze = zzbdp;
        this.zzc = str;
        this.zzd = zzekq;
        this.zzf = zzeur.zzf();
        zzeur.zzh(this);
    }

    private final synchronized void zzM(zzbdp zzbdp) {
        this.zzf.zzc(zzbdp);
        this.zzf.zzd(this.zze.zzn);
    }

    private final synchronized boolean zzN(zzbdk zzbdk) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzs.zzc();
        if (!zzr.zzK(this.zza) || zzbdk.zzs != null) {
            zzezm.zzb(this.zza, zzbdk.zzf);
            return this.zzb.zza(zzbdk, this.zzc, (zzele) null, new zzejx(this));
        }
        zzcgs.zzf("Failed to load the ad because app ID is missing.");
        zzekq zzekq = this.zzd;
        if (zzekq != null) {
            zzekq.zzbT(zzezr.zzd(4, (String) null, (zzbdd) null));
        }
        return false;
    }

    public final synchronized boolean zzA() {
        return this.zzb.zzb();
    }

    public final void zzB(zzccg zzccg) {
    }

    public final void zzC(String str) {
    }

    public final void zzD(String str) {
    }

    public final synchronized zzbhg zzE() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzcvj zzcvj = this.zzg;
        if (zzcvj == null) {
            return null;
        }
        return zzcvj.zzc();
    }

    public final synchronized void zzF(zzbiv zzbiv) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzf.zzh(zzbiv);
    }

    public final void zzG(zzbhk zzbhk) {
    }

    public final void zzH(zzbdv zzbdv) {
    }

    public final void zzI(zzaxv zzaxv) {
    }

    public final void zzJ(boolean z) {
    }

    public final void zzO(zzbha zzbha) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzd.zzp(zzbha);
    }

    public final void zzP(zzbdk zzbdk, zzbfh zzbfh) {
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzR(zzbgf zzbgf) {
    }

    public final synchronized void zza() {
        if (this.zzb.zzg()) {
            zzbdp zze2 = this.zzf.zze();
            zzcvj zzcvj = this.zzg;
            if (!(zzcvj == null || zzcvj.zzf() == null || !this.zzf.zzv())) {
                zze2 = zzeza.zzb(this.zza, Collections.singletonList(this.zzg.zzf()));
            }
            zzM(zze2);
            try {
                zzN(this.zzf.zzb());
            } catch (RemoteException unused) {
                zzcgs.zzi("Failed to refresh the banner ad.");
            }
        } else {
            this.zzb.zzi();
        }
    }

    public final synchronized void zzab(zzbgc zzbgc) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzf.zzN(zzbgc);
    }

    public final IObjectWrapper zzb() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzb.zzc());
    }

    public final boolean zzbZ() {
        return false;
    }

    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcvj zzcvj = this.zzg;
        if (zzcvj != null) {
            zzcvj.zzT();
        }
    }

    public final synchronized boolean zze(zzbdk zzbdk) throws RemoteException {
        zzM(this.zze);
        return zzN(zzbdk);
    }

    public final synchronized void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzcvj zzcvj = this.zzg;
        if (zzcvj != null) {
            zzcvj.zzl().zza((Context) null);
        }
    }

    public final synchronized void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzcvj zzcvj = this.zzg;
        if (zzcvj != null) {
            zzcvj.zzl().zzb((Context) null);
        }
    }

    public final void zzh(zzbfe zzbfe) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzd.zzn(zzbfe);
    }

    public final void zzi(zzbfy zzbfy) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzd.zzo(zzbfy);
    }

    public final void zzj(zzbfv zzbfv) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle zzk() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final void zzl() {
    }

    public final synchronized void zzm() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzcvj zzcvj = this.zzg;
        if (zzcvj != null) {
            zzcvj.zzh();
        }
    }

    public final synchronized zzbdp zzn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcvj zzcvj = this.zzg;
        if (zzcvj != null) {
            return zzeza.zzb(this.zza, Collections.singletonList(zzcvj.zze()));
        }
        return this.zzf.zze();
    }

    public final synchronized void zzo(zzbdp zzbdp) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzf.zzc(zzbdp);
        this.zze = zzbdp;
        zzcvj zzcvj = this.zzg;
        if (zzcvj != null) {
            zzcvj.zzb(this.zzb.zzc(), zzbdp);
        }
    }

    public final void zzp(zzcaa zzcaa) {
    }

    public final void zzq(zzcad zzcad, String str) {
    }

    public final synchronized String zzr() {
        zzcvj zzcvj = this.zzg;
        if (zzcvj == null || zzcvj.zzm() == null) {
            return null;
        }
        return this.zzg.zzm().zze();
    }

    public final synchronized String zzs() {
        zzcvj zzcvj = this.zzg;
        if (zzcvj == null || zzcvj.zzm() == null) {
            return null;
        }
        return this.zzg.zzm().zze();
    }

    public final synchronized zzbhd zzt() {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzeY)).booleanValue()) {
            return null;
        }
        zzcvj zzcvj = this.zzg;
        if (zzcvj == null) {
            return null;
        }
        return zzcvj.zzm();
    }

    public final synchronized String zzu() {
        return this.zzc;
    }

    public final zzbfy zzv() {
        return this.zzd.zzm();
    }

    public final zzbfe zzw() {
        return this.zzd.zzl();
    }

    public final synchronized void zzx(zzbki zzbki) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzb.zzd(zzbki);
    }

    public final void zzy(zzbfb zzbfb) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzb.zze(zzbfb);
    }

    public final synchronized void zzz(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzf.zzj(z);
    }
}
