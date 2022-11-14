package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeky extends zzbfq {
    public final zzbdp zza;
    public final Context zzb;
    public final zzewj zzc;
    public final String zzd;
    public final zzekq zze;
    public final zzexi zzf;
    @GuardedBy("this")
    @Nullable
    public zzdiw zzg;
    @GuardedBy("this")
    public boolean zzh = ((Boolean) zzbex.zzc().zzb(zzbjn.zzat)).booleanValue();

    public zzeky(Context context, zzbdp zzbdp, String str, zzewj zzewj, zzekq zzekq, zzexi zzexi) {
        this.zza = zzbdp;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzewj;
        this.zze = zzekq;
        this.zzf = zzexi;
    }

    private final synchronized boolean zzM() {
        zzdiw zzdiw;
        zzdiw = this.zzg;
        return zzdiw != null && !zzdiw.zzb();
    }

    public final synchronized boolean zzA() {
        return this.zzc.zzb();
    }

    public final void zzB(zzccg zzccg) {
        this.zzf.zzo(zzccg);
    }

    public final void zzC(String str) {
    }

    public final void zzD(String str) {
    }

    public final zzbhg zzE() {
        return null;
    }

    public final void zzF(zzbiv zzbiv) {
    }

    public final void zzG(zzbhk zzbhk) {
    }

    public final void zzH(zzbdv zzbdv) {
    }

    public final void zzI(zzaxv zzaxv) {
    }

    public final synchronized void zzJ(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzh = z;
    }

    public final void zzO(zzbha zzbha) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zze.zzp(zzbha);
    }

    public final void zzP(zzbdk zzbdk, zzbfh zzbfh) {
        this.zze.zzr(zzbfh);
        zze(zzbdk);
    }

    public final synchronized void zzQ(IObjectWrapper iObjectWrapper) {
        if (this.zzg == null) {
            zzcgs.zzi("Interstitial can not be shown before loaded.");
            this.zze.zzi(zzezr.zzd(9, (String) null, (zzbdd) null));
            return;
        }
        this.zzg.zza(this.zzh, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzR(zzbgf zzbgf) {
        this.zze.zzs(zzbgf);
    }

    public final void zzab(zzbgc zzbgc) {
    }

    public final IObjectWrapper zzb() {
        return null;
    }

    public final synchronized boolean zzbZ() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzM();
    }

    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdiw zzdiw = this.zzg;
        if (zzdiw != null) {
            zzdiw.zzl().zzc((Context) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(com.google.android.gms.internal.ads.zzbdk r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0051 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0051 }
            android.content.Context r0 = r4.zzb     // Catch:{ all -> 0x0051 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzr.zzK(r0)     // Catch:{ all -> 0x0051 }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbdb r0 = r5.zzs     // Catch:{ all -> 0x0051 }
            if (r0 != 0) goto L_0x002a
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzcgs.zzf(r5)     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzekq r5 = r4.zze     // Catch:{ all -> 0x0051 }
            if (r5 == 0) goto L_0x0028
            r0 = 4
            com.google.android.gms.internal.ads.zzbdd r0 = com.google.android.gms.internal.ads.zzezr.zzd(r0, r2, r2)     // Catch:{ all -> 0x0051 }
            r5.zzbT(r0)     // Catch:{ all -> 0x0051 }
        L_0x0028:
            monitor-exit(r4)
            return r1
        L_0x002a:
            boolean r0 = r4.zzM()     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0032
            monitor-exit(r4)
            return r1
        L_0x0032:
            android.content.Context r0 = r4.zzb     // Catch:{ all -> 0x0051 }
            boolean r1 = r5.zzf     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzezm.zzb(r0, r1)     // Catch:{ all -> 0x0051 }
            r4.zzg = r2     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzewj r0 = r4.zzc     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r4.zzd     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzewc r2 = new com.google.android.gms.internal.ads.zzewc     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzbdp r3 = r4.zza     // Catch:{ all -> 0x0051 }
            r2.<init>(r3)     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzekx r3 = new com.google.android.gms.internal.ads.zzekx     // Catch:{ all -> 0x0051 }
            r3.<init>(r4)     // Catch:{ all -> 0x0051 }
            boolean r5 = r0.zza(r5, r1, r2, r3)     // Catch:{ all -> 0x0051 }
            monitor-exit(r4)
            return r5
        L_0x0051:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeky.zze(com.google.android.gms.internal.ads.zzbdk):boolean");
    }

    public final synchronized void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzdiw zzdiw = this.zzg;
        if (zzdiw != null) {
            zzdiw.zzl().zza((Context) null);
        }
    }

    public final synchronized void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzdiw zzdiw = this.zzg;
        if (zzdiw != null) {
            zzdiw.zzl().zzb((Context) null);
        }
    }

    public final void zzh(zzbfe zzbfe) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zze.zzn(zzbfe);
    }

    public final void zzi(zzbfy zzbfy) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zze.zzo(zzbfy);
    }

    public final void zzj(zzbfv zzbfv) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle zzk() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized void zzl() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        zzdiw zzdiw = this.zzg;
        if (zzdiw == null) {
            zzcgs.zzi("Interstitial can not be shown before loaded.");
            this.zze.zzi(zzezr.zzd(9, (String) null, (zzbdd) null));
            return;
        }
        zzdiw.zza(this.zzh, (Activity) null);
    }

    public final void zzm() {
    }

    public final zzbdp zzn() {
        return null;
    }

    public final void zzo(zzbdp zzbdp) {
    }

    public final void zzp(zzcaa zzcaa) {
    }

    public final void zzq(zzcad zzcad, String str) {
    }

    public final synchronized String zzr() {
        zzdiw zzdiw = this.zzg;
        if (zzdiw == null || zzdiw.zzm() == null) {
            return null;
        }
        return this.zzg.zzm().zze();
    }

    public final synchronized String zzs() {
        zzdiw zzdiw = this.zzg;
        if (zzdiw == null || zzdiw.zzm() == null) {
            return null;
        }
        return this.zzg.zzm().zze();
    }

    public final synchronized zzbhd zzt() {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzeY)).booleanValue()) {
            return null;
        }
        zzdiw zzdiw = this.zzg;
        if (zzdiw == null) {
            return null;
        }
        return zzdiw.zzm();
    }

    public final synchronized String zzu() {
        return this.zzd;
    }

    public final zzbfy zzv() {
        return this.zze.zzm();
    }

    public final zzbfe zzw() {
        return this.zze.zzl();
    }

    public final synchronized void zzx(zzbki zzbki) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzc(zzbki);
    }

    public final void zzy(zzbfb zzbfb) {
    }

    public final void zzz(boolean z) {
    }
}
