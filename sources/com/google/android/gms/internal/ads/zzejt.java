package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzejt extends zzbfq {
    public final Context zza;
    public final zzbfe zzb;
    public final zzeyw zzc;
    public final zzcvj zzd;
    public final ViewGroup zze;

    public zzejt(Context context, @Nullable zzbfe zzbfe, zzeyw zzeyw, zzcvj zzcvj) {
        this.zza = context;
        this.zzb = zzbfe;
        this.zzc = zzeyw;
        this.zzd = zzcvj;
        FrameLayout frameLayout = new FrameLayout(this.zza);
        frameLayout.removeAllViews();
        frameLayout.addView(this.zzd.zza(), zzs.zze().zzj());
        frameLayout.setMinimumHeight(zzn().zzc);
        frameLayout.setMinimumWidth(zzn().zzf);
        this.zze = frameLayout;
    }

    public final boolean zzA() throws RemoteException {
        return false;
    }

    public final void zzB(zzccg zzccg) throws RemoteException {
    }

    public final void zzC(String str) throws RemoteException {
    }

    public final void zzD(String str) throws RemoteException {
    }

    public final zzbhg zzE() throws RemoteException {
        return this.zzd.zzc();
    }

    public final void zzF(zzbiv zzbiv) throws RemoteException {
        zzcgs.zzh("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzG(zzbhk zzbhk) throws RemoteException {
    }

    public final void zzH(zzbdv zzbdv) throws RemoteException {
    }

    public final void zzI(zzaxv zzaxv) throws RemoteException {
    }

    public final void zzJ(boolean z) throws RemoteException {
    }

    public final void zzO(zzbha zzbha) {
        zzcgs.zzh("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzP(zzbdk zzbdk, zzbfh zzbfh) {
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzR(zzbgf zzbgf) {
    }

    public final void zzab(zzbgc zzbgc) throws RemoteException {
        zzcgs.zzh("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.wrap(this.zze);
    }

    public final boolean zzbZ() throws RemoteException {
        return false;
    }

    public final void zzc() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzT();
    }

    public final boolean zze(zzbdk zzbdk) throws RemoteException {
        zzcgs.zzh("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    public final void zzf() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzl().zza((Context) null);
    }

    public final void zzg() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzl().zzb((Context) null);
    }

    public final void zzh(zzbfe zzbfe) throws RemoteException {
        zzcgs.zzh("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzi(zzbfy zzbfy) throws RemoteException {
        zzekq zzekq = this.zzc.zzc;
        if (zzekq != null) {
            zzekq.zzo(zzbfy);
        }
    }

    public final void zzj(zzbfv zzbfv) throws RemoteException {
        zzcgs.zzh("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final Bundle zzk() throws RemoteException {
        zzcgs.zzh("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    public final void zzl() throws RemoteException {
    }

    public final void zzm() throws RemoteException {
        this.zzd.zzh();
    }

    public final zzbdp zzn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzeza.zzb(this.zza, Collections.singletonList(this.zzd.zze()));
    }

    public final void zzo(zzbdp zzbdp) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzcvj zzcvj = this.zzd;
        if (zzcvj != null) {
            zzcvj.zzb(this.zze, zzbdp);
        }
    }

    public final void zzp(zzcaa zzcaa) throws RemoteException {
    }

    public final void zzq(zzcad zzcad, String str) throws RemoteException {
    }

    public final String zzr() throws RemoteException {
        if (this.zzd.zzm() != null) {
            return this.zzd.zzm().zze();
        }
        return null;
    }

    public final String zzs() throws RemoteException {
        if (this.zzd.zzm() != null) {
            return this.zzd.zzm().zze();
        }
        return null;
    }

    public final zzbhd zzt() {
        return this.zzd.zzm();
    }

    public final String zzu() throws RemoteException {
        return this.zzc.zzf;
    }

    public final zzbfy zzv() throws RemoteException {
        return this.zzc.zzn;
    }

    public final zzbfe zzw() throws RemoteException {
        return this.zzb;
    }

    public final void zzx(zzbki zzbki) throws RemoteException {
        zzcgs.zzh("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzy(zzbfb zzbfb) throws RemoteException {
        zzcgs.zzh("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzz(boolean z) throws RemoteException {
        zzcgs.zzh("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }
}
