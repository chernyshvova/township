package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfey {
    @SuppressLint({"StaticFieldLeak"})
    public static final zzfey zza = new zzfey();
    public Context zzb;
    public BroadcastReceiver zzc;
    public boolean zzd;
    public boolean zze;
    public zzffd zzf;

    public static zzfey zza() {
        return zza;
    }

    public static /* synthetic */ void zzf(zzfey zzfey, boolean z) {
        if (zzfey.zze != z) {
            zzfey.zze = z;
            if (zzfey.zzd) {
                zzfey.zzh();
                if (zzfey.zzf == null) {
                    return;
                }
                if (zzfey.zze()) {
                    zzffz.zzb().zzc();
                } else {
                    zzffz.zzb().zze();
                }
            }
        }
    }

    private final void zzh() {
        boolean z = this.zze;
        for (zzfel zzh : zzfew.zza().zze()) {
            zzffj zzh2 = zzh.zzh();
            if (zzh2.zze()) {
                zzffc.zza().zzg(zzh2.zzd(), "setState", true != z ? "foregrounded" : "backgrounded");
            }
        }
    }

    public final void zzb(@NonNull Context context) {
        this.zzb = context.getApplicationContext();
    }

    public final void zzc() {
        this.zzc = new zzfex(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zzb.registerReceiver(this.zzc, intentFilter);
        this.zzd = true;
        zzh();
    }

    public final void zzd() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.zzb;
        if (!(context == null || (broadcastReceiver = this.zzc) == null)) {
            context.unregisterReceiver(broadcastReceiver);
            this.zzc = null;
        }
        this.zzd = false;
        this.zze = false;
        this.zzf = null;
    }

    public final boolean zze() {
        return !this.zze;
    }

    public final void zzg(zzffd zzffd) {
        this.zzf = zzffd;
    }
}
