package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzetg extends zzbfq implements zzz, zzaxm, zzddc {
    @GuardedBy("this")
    @Nullable
    public zzcus zza;
    public final zzcop zzb;
    public final Context zzc;
    public final ViewGroup zzd;
    public AtomicBoolean zze = new AtomicBoolean();
    public final String zzf;
    public final zzeta zzg;
    public final zzeud zzh;
    public final zzcgy zzi;
    public long zzj = -1;
    @Nullable
    public zzcue zzk;

    public zzetg(zzcop zzcop, Context context, String str, zzeta zzeta, zzeud zzeud, zzcgy zzcgy) {
        this.zzd = new FrameLayout(context);
        this.zzb = zzcop;
        this.zzc = context;
        this.zzf = str;
        this.zzg = zzeta;
        this.zzh = zzeud;
        zzeud.zzj(this);
        this.zzi = zzcgy;
    }

    public static /* synthetic */ zzq zzT(zzetg zzetg, zzcus zzcus) {
        boolean zzf2 = zzcus.zzf();
        int intValue = ((Integer) zzbex.zzc().zzb(zzbjn.zzdh)).intValue();
        zzp zzp = new zzp();
        zzp.zzd = 50;
        int i = 0;
        zzp.zza = true != zzf2 ? 0 : intValue;
        if (true != zzf2) {
            i = intValue;
        }
        zzp.zzb = i;
        zzp.zzc = intValue;
        return new zzq(zzetg.zzc, zzp, zzetg);
    }

    private final synchronized void zzW(int i) {
        if (this.zze.compareAndSet(false, true)) {
            zzcus zzcus = this.zza;
            if (!(zzcus == null || zzcus.zzk() == null)) {
                this.zzh.zzq(this.zza.zzk());
            }
            this.zzh.zzo();
            this.zzd.removeAllViews();
            zzcue zzcue = this.zzk;
            if (zzcue != null) {
                zzs.zzf().zzc(zzcue);
            }
            if (this.zza != null) {
                long j = -1;
                if (this.zzj != -1) {
                    j = zzs.zzj().elapsedRealtime() - this.zzj;
                }
                this.zza.zzi(j, i);
            }
            zzc();
        }
    }

    public final synchronized boolean zzA() {
        return this.zzg.zzb();
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
        this.zzg.zzd(zzbdv);
    }

    public final void zzI(zzaxv zzaxv) {
        this.zzh.zzh(zzaxv);
    }

    public final void zzJ(boolean z) {
    }

    public final void zzK() {
        if (this.zza != null) {
            this.zzj = zzs.zzj().elapsedRealtime();
            int zzc2 = this.zza.zzc();
            if (zzc2 > 0) {
                zzcue zzcue = new zzcue(this.zzb.zzf(), zzs.zzj());
                this.zzk = zzcue;
                zzcue.zzb(zzc2, new zzetd(this));
            }
        }
    }

    @VisibleForTesting
    public final void zzL() {
        zzbev.zza();
        if (zzcgl.zzp()) {
            zzW(5);
        } else {
            this.zzb.zze().execute(new zzetc(this));
        }
    }

    public final /* synthetic */ void zzM() {
        zzW(5);
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
        zzW(3);
    }

    public final synchronized void zzab(zzbgc zzbgc) {
    }

    public final IObjectWrapper zzb() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzd);
    }

    public final boolean zzbZ() {
        return false;
    }

    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcus zzcus = this.zza;
        if (zzcus != null) {
            zzcus.zzT();
        }
    }

    public final void zzd() {
        zzW(4);
    }

    public final synchronized boolean zze(zzbdk zzbdk) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzs.zzc();
        if (zzr.zzK(this.zzc)) {
            if (zzbdk.zzs == null) {
                zzcgs.zzf("Failed to load the ad because app ID is missing.");
                this.zzh.zzbT(zzezr.zzd(4, (String) null, (zzbdd) null));
                return false;
            }
        }
        if (zzA()) {
            return false;
        }
        this.zze = new AtomicBoolean();
        return this.zzg.zza(zzbdk, this.zzf, new zzete(this), new zzetf(this));
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

    public final void zzl() {
    }

    public final synchronized void zzm() {
    }

    public final synchronized zzbdp zzn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcus zzcus = this.zza;
        if (zzcus == null) {
            return null;
        }
        return zzeza.zzb(this.zzc, Collections.singletonList(zzcus.zza()));
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
        return this.zzf;
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
