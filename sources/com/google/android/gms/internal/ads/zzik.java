package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.facebook.appevents.AppEventsConstants;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzik implements zzkf {
    public final zzahy zza;
    public final long zzb = zzig.zzb(50000);
    public final long zzc = zzig.zzb(50000);
    public final long zzd = zzig.zzb(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    public final long zze = zzig.zzb(5000);
    public final long zzf = zzig.zzb(0);
    public int zzg = 13107200;
    public boolean zzh;

    public zzik() {
        zzahy zzahy = new zzahy(true, 65536);
        zzk(2500, 0, "bufferForPlaybackMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzk(5000, 0, "bufferForPlaybackAfterRebufferMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzk(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzk(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzk(50000, 50000, "maxBufferMs", "minBufferMs");
        zzk(0, 0, "backBufferDurationMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.zza = zzahy;
    }

    private final void zzj(boolean z) {
        this.zzg = 13107200;
        this.zzh = false;
        if (z) {
            this.zza.zza();
        }
    }

    public static void zzk(int i, int i2, String str, String str2) {
        boolean z = i >= i2;
        StringBuilder sb = new StringBuilder(str.length() + 21 + str2.length());
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        zzajg.zzb(z, sb.toString());
    }

    public final void zza() {
        zzj(false);
    }

    public final void zzb() {
        zzj(true);
    }

    public final void zzc() {
        zzj(true);
    }

    public final long zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return false;
    }

    public final boolean zzf(long j, long j2, float f) {
        int zzg2 = this.zza.zzg();
        int i = this.zzg;
        long j3 = this.zzb;
        if (f > 1.0f) {
            j3 = Math.min(zzalh.zzH(j3, f), this.zzc);
        }
        boolean z = false;
        if (j2 < Math.max(j3, 500000)) {
            if (zzg2 < i) {
                z = true;
            }
            this.zzh = z;
            if (!z && j2 < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.zzc || zzg2 >= i) {
            this.zzh = false;
        }
        return this.zzh;
    }

    public final boolean zzg(long j, float f, boolean z, long j2) {
        long j3;
        long zzI = zzalh.zzI(j, f);
        if (z) {
            j3 = this.zze;
        } else {
            j3 = this.zzd;
        }
        if (j2 != -9223372036854775807L) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || zzI >= j3 || this.zza.zzg() >= this.zzg;
    }

    public final zzahy zzh() {
        return this.zza;
    }

    public final void zzi(zzma[] zzmaArr, zzaft zzaft, zzagf[] zzagfArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 13107200;
            if (i < 2) {
                if (zzagfArr[i] != null) {
                    if (zzmaArr[i].zza() != 1) {
                        i3 = 131072000;
                    }
                    i2 += i3;
                }
                i++;
            } else {
                int max = Math.max(13107200, i2);
                this.zzg = max;
                this.zza.zzb(max);
                return;
            }
        }
    }
}
