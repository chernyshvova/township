package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdnc implements View.OnClickListener {
    @VisibleForTesting
    @Nullable
    public String zza;
    @VisibleForTesting
    @Nullable
    public Long zzb;
    @VisibleForTesting
    @Nullable
    public WeakReference<View> zzc;
    public final zzdqu zzd;
    public final Clock zze;
    @Nullable
    public zzboc zzf;
    @Nullable
    public zzbps<Object> zzg;

    public zzdnc(zzdqu zzdqu, Clock clock) {
        this.zzd = zzdqu;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzc = null;
        }
    }

    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zza == null || this.zzb == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zza);
                hashMap.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzd.zzf("sendMessageToNativeJs", hashMap);
            }
            zzd();
        }
    }

    public final void zza(zzboc zzboc) {
        this.zzf = zzboc;
        zzbps<Object> zzbps = this.zzg;
        if (zzbps != null) {
            this.zzd.zze("/unconfirmedClick", zzbps);
        }
        zzdnb zzdnb = new zzdnb(this, zzboc);
        this.zzg = zzdnb;
        this.zzd.zzd("/unconfirmedClick", zzdnb);
    }

    @Nullable
    public final zzboc zzb() {
        return this.zzf;
    }

    public final void zzc() {
        if (this.zzf != null && this.zzb != null) {
            zzd();
            try {
                this.zzf.zzf();
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
