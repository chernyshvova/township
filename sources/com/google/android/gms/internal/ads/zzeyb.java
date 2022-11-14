package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeyb extends zzccc {
    public final zzexr zza;
    public final zzexi zzb;
    public final zzeyr zzc;
    @GuardedBy("this")
    @Nullable
    public zzdrj zzd;
    @GuardedBy("this")
    public boolean zze = false;

    public zzeyb(zzexr zzexr, zzexi zzexi, zzeyr zzeyr) {
        this.zza = zzexr;
        this.zzb = zzexi;
        this.zzc = zzeyr;
    }

    private final synchronized boolean zzx() {
        zzdrj zzdrj;
        zzdrj = this.zzd;
        return zzdrj != null && !zzdrj.zze();
    }

    public final synchronized void zzb(zzcch zzcch) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        String str = zzcch.zzb;
        String str2 = (String) zzbex.zzc().zzb(zzbjn.zzdI);
        if (!(str2 == null || str == null)) {
            try {
                if (Pattern.matches(str2, str)) {
                    return;
                }
            } catch (RuntimeException e) {
                zzs.zzg().zzg(e, "NonagonUtil.isPatternMatched");
            }
        }
        if (zzx()) {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdK)).booleanValue()) {
                return;
            }
        }
        zzexk zzexk = new zzexk((String) null);
        this.zzd = null;
        this.zza.zzi(1);
        this.zza.zza(zzcch.zza, zzcch.zzb, zzexk, new zzexz(this));
    }

    public final synchronized void zzc() throws RemoteException {
        zzp((IObjectWrapper) null);
    }

    public final void zzd(zzccg zzccg) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzo(zzccg);
    }

    public final boolean zze() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzx();
    }

    public final void zzf() {
        zzi((IObjectWrapper) null);
    }

    public final void zzg() {
        zzj((IObjectWrapper) null);
    }

    public final void zzh() throws RemoteException {
        zzk((IObjectWrapper) null);
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzl().zza(context);
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzl().zzb(context);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzk(com.google.android.gms.dynamic.IObjectWrapper r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzexi r0 = r2.zzb     // Catch:{ all -> 0x0027 }
            r1 = 0
            r0.zzm(r1)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzdrj r0 = r2.zzd     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0025
            if (r3 != 0) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0027 }
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x0027 }
        L_0x001a:
            com.google.android.gms.internal.ads.zzdrj r3 = r2.zzd     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzdcc r3 = r3.zzl()     // Catch:{ all -> 0x0027 }
            r3.zzc(r1)     // Catch:{ all -> 0x0027 }
            monitor-exit(r2)
            return
        L_0x0025:
            monitor-exit(r2)
            return
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyb.zzk(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final synchronized String zzl() throws RemoteException {
        zzdrj zzdrj = this.zzd;
        if (zzdrj == null || zzdrj.zzm() == null) {
            return null;
        }
        return this.zzd.zzm().zze();
    }

    public final synchronized void zzm(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    public final void zzn(zzbfv zzbfv) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzbfv == null) {
            this.zzb.zzm((zzfgi) null);
        } else {
            this.zzb.zzm(new zzeya(this, zzbfv));
        }
    }

    public final Bundle zzo() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzdrj zzdrj = this.zzd;
        return zzdrj != null ? zzdrj.zzg() : new Bundle();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.app.Activity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzp(@androidx.annotation.Nullable com.google.android.gms.dynamic.IObjectWrapper r3) throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "showAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0024 }
            com.google.android.gms.internal.ads.zzdrj r0 = r2.zzd     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            r0 = 0
            if (r3 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0024 }
            boolean r1 = r3 instanceof android.app.Activity     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0019
            r0 = r3
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ all -> 0x0024 }
        L_0x0019:
            com.google.android.gms.internal.ads.zzdrj r3 = r2.zzd     // Catch:{ all -> 0x0024 }
            boolean r1 = r2.zze     // Catch:{ all -> 0x0024 }
            r3.zza(r1, r0)     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0022:
            monitor-exit(r2)
            return
        L_0x0024:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyb.zzp(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final synchronized void zzq(String str) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    public final synchronized void zzr(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zze = z;
    }

    public final boolean zzs() {
        zzdrj zzdrj = this.zzd;
        return zzdrj != null && zzdrj.zzf();
    }

    public final synchronized zzbhd zzt() throws RemoteException {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzeY)).booleanValue()) {
            return null;
        }
        zzdrj zzdrj = this.zzd;
        if (zzdrj == null) {
            return null;
        }
        return zzdrj.zzm();
    }

    public final void zzu(zzccb zzccb) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzr(zzccb);
    }
}
