package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzexv extends zzccs {
    public final zzexr zza;
    public final zzexi zzb;
    public final String zzc;
    public final zzeyr zzd;
    public final Context zze;
    @GuardedBy("this")
    @Nullable
    public zzdrj zzf;
    @GuardedBy("this")
    public boolean zzg = ((Boolean) zzbex.zzc().zzb(zzbjn.zzat)).booleanValue();

    public zzexv(@Nullable String str, zzexr zzexr, Context context, zzexi zzexi, zzeyr zzeyr) {
        this.zzc = str;
        this.zza = zzexr;
        this.zzb = zzexi;
        this.zzd = zzeyr;
        this.zze = context;
    }

    private final synchronized void zzt(zzbdk zzbdk, zzcda zzcda, int i) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzb(zzcda);
        zzs.zzc();
        if (zzr.zzK(this.zze)) {
            if (zzbdk.zzs == null) {
                zzcgs.zzf("Failed to load the ad because app ID is missing.");
                this.zzb.zzbT(zzezr.zzd(4, (String) null, (zzbdd) null));
                return;
            }
        }
        if (this.zzf == null) {
            zzexk zzexk = new zzexk((String) null);
            this.zza.zzi(i);
            this.zza.zza(zzbdk, this.zzc, zzexk, new zzexu(this));
        }
    }

    public final synchronized void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzk(iObjectWrapper, this.zzg);
    }

    public final synchronized void zzc(zzbdk zzbdk, zzcda zzcda) throws RemoteException {
        zzt(zzbdk, zzcda, 2);
    }

    public final synchronized void zzd(zzbdk zzbdk, zzcda zzcda) throws RemoteException {
        zzt(zzbdk, zzcda, 3);
    }

    public final void zze(zzccw zzccw) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzj(zzccw);
    }

    public final void zzf(zzbgx zzbgx) {
        if (zzbgx == null) {
            this.zzb.zzm((zzfgi) null);
        } else {
            this.zzb.zzm(new zzext(this, zzbgx));
        }
    }

    public final Bundle zzg() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdrj zzdrj = this.zzf;
        return zzdrj != null ? zzdrj.zzg() : new Bundle();
    }

    public final synchronized void zzh(zzcdh zzcdh) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzeyr zzeyr = this.zzd;
        zzeyr.zza = zzcdh.zza;
        zzeyr.zzb = zzcdh.zzb;
    }

    public final boolean zzi() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdrj zzdrj = this.zzf;
        return zzdrj != null && !zzdrj.zzb();
    }

    public final synchronized String zzj() throws RemoteException {
        zzdrj zzdrj = this.zzf;
        if (zzdrj == null || zzdrj.zzm() == null) {
            return null;
        }
        return this.zzf.zzm().zze();
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzf == null) {
            zzcgs.zzi("Rewarded can not be shown before loaded");
            this.zzb.zzi(zzezr.zzd(9, (String) null, (zzbdd) null));
            return;
        }
        this.zzf.zza(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Nullable
    public final zzccq zzl() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdrj zzdrj = this.zzf;
        if (zzdrj != null) {
            return zzdrj.zzc();
        }
        return null;
    }

    public final zzbhd zzm() {
        zzdrj zzdrj;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeY)).booleanValue() && (zzdrj = this.zzf) != null) {
            return zzdrj.zzm();
        }
        return null;
    }

    public final void zzn(zzbha zzbha) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzb.zzn(zzbha);
    }

    public final synchronized void zzo(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzg = z;
    }

    public final void zzp(zzcdb zzcdb) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzq(zzcdb);
    }
}
