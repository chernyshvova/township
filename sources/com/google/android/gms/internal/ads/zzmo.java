package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzmo {
    public final Context zza;
    public final Handler zzb;
    public final zzml zzc;
    public final AudioManager zzd;
    @Nullable
    public zzmn zze;
    public int zzf = 3;
    public int zzg;
    public boolean zzh;

    public zzmo(Context context, Handler handler, zzml zzml) {
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzb = handler;
        this.zzc = zzml;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
        zzajg.zze(audioManager);
        this.zzd = audioManager;
        this.zzg = zzh(audioManager, 3);
        this.zzh = zzi(this.zzd, this.zzf);
        zzmn zzmn = new zzmn(this, (zzmk) null);
        try {
            this.zza.registerReceiver(zzmn, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.zze = zzmn;
        } catch (RuntimeException e) {
            zzaka.zza("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        int zzh2 = zzh(this.zzd, this.zzf);
        boolean zzi = zzi(this.zzd, this.zzf);
        if (this.zzg != zzh2 || this.zzh != zzi) {
            this.zzg = zzh2;
            this.zzh = zzi;
            Iterator it = ((zzmh) this.zzc).zza.zzl.iterator();
            while (it.hasNext()) {
                ((zzrv) it.next()).zzab(zzh2, zzi);
            }
        }
    }

    public static int zzh(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder(60);
            sb.append("Could not retrieve stream volume for stream type ");
            sb.append(i);
            zzaka.zza("StreamVolumeManager", sb.toString(), e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    public static boolean zzi(AudioManager audioManager, int i) {
        if (zzalh.zza >= 23) {
            return audioManager.isStreamMute(i);
        }
        return zzh(audioManager, i) == 0;
    }

    public final void zza(int i) {
        if (this.zzf != 3) {
            this.zzf = 3;
            zzg();
            zzmh zzmh = (zzmh) this.zzc;
            zzru zzV = zzmj.zzag(zzmh.zza.zzp);
            if (!zzV.equals(zzmh.zza.zzJ)) {
                zzru unused = zzmh.zza.zzJ = zzV;
                Iterator it = zzmh.zza.zzl.iterator();
                while (it.hasNext()) {
                    ((zzrv) it.next()).zzaa(zzV);
                }
            }
        }
    }

    public final int zzb() {
        if (zzalh.zza >= 28) {
            return this.zzd.getStreamMinVolume(this.zzf);
        }
        return 0;
    }

    public final int zzc() {
        return this.zzd.getStreamMaxVolume(this.zzf);
    }

    public final void zzd() {
        zzmn zzmn = this.zze;
        if (zzmn != null) {
            try {
                this.zza.unregisterReceiver(zzmn);
            } catch (RuntimeException e) {
                zzaka.zza("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            this.zze = null;
        }
    }
}
