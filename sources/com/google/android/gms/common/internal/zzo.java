package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzo implements ServiceConnection, zzr {
    public final /* synthetic */ zzq zza;
    public final Map<ServiceConnection, ServiceConnection> zzb = new HashMap();
    public int zzc = 2;
    public boolean zzd;
    @Nullable
    public IBinder zze;
    public final zzm zzf;
    public ComponentName zzg;

    public zzo(zzq zzq, zzm zzm) {
        this.zza = zzq;
        this.zzf = zzm;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zza.zza) {
            this.zza.zzc.removeMessages(1, this.zzf);
            this.zze = iBinder;
            this.zzg = componentName;
            for (ServiceConnection onServiceConnected : this.zzb.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.zzc = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zza.zza) {
            this.zza.zzc.removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName;
            for (ServiceConnection onServiceDisconnected : this.zzb.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.zzc = 2;
        }
    }

    public final void zza(String str) {
        this.zzc = 3;
        boolean zza2 = this.zza.zzd.zza(this.zza.zzb, str, this.zzf.zzd(this.zza.zzb), this, this.zzf.zzc());
        this.zzd = zza2;
        if (zza2) {
            this.zza.zzc.sendMessageDelayed(this.zza.zzc.obtainMessage(1, this.zzf), this.zza.zzf);
            return;
        }
        this.zzc = 2;
        try {
            this.zza.zzd.unbindService(this.zza.zzb, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void zzb(String str) {
        this.zza.zzc.removeMessages(1, this.zzf);
        this.zza.zzd.unbindService(this.zza.zzb, this);
        this.zzd = false;
        this.zzc = 2;
    }

    public final void zzc(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.zzb.put(serviceConnection, serviceConnection2);
    }

    public final void zzd(ServiceConnection serviceConnection, String str) {
        this.zzb.remove(serviceConnection);
    }

    public final boolean zze() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zzc;
    }

    public final boolean zzg(ServiceConnection serviceConnection) {
        return this.zzb.containsKey(serviceConnection);
    }

    public final boolean zzh() {
        return this.zzb.isEmpty();
    }

    @Nullable
    public final IBinder zzi() {
        return this.zze;
    }

    public final ComponentName zzj() {
        return this.zzg;
    }
}
