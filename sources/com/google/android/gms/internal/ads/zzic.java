package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzic {
    public final AudioManager zza;
    public final zzia zzb;
    @Nullable
    public zzib zzc;
    public int zzd;
    public float zze = 1.0f;

    public zzic(Context context, Handler handler, zzib zzib) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            this.zza = audioManager;
            this.zzc = zzib;
            this.zzb = new zzia(this, handler);
            this.zzd = 0;
            return;
        }
        throw null;
    }

    public static /* synthetic */ void zzd(zzic zzic, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzic.zzf(3);
                return;
            }
            zzic.zzg(0);
            zzic.zzf(2);
        } else if (i == -1) {
            zzic.zzg(-1);
            zzic.zze();
        } else if (i != 1) {
            GeneratedOutlineSupport.outline29(38, "Unknown focus change type: ", i, "AudioFocusManager");
        } else {
            zzic.zzf(1);
            zzic.zzg(1);
        }
    }

    private final void zze() {
        if (this.zzd != 0) {
            if (zzalh.zza < 26) {
                this.zza.abandonAudioFocus(this.zzb);
            }
            zzf(0);
        }
    }

    private final void zzf(int i) {
        if (this.zzd != i) {
            this.zzd = i;
            float f = i == 3 ? 0.2f : 1.0f;
            if (this.zze != f) {
                this.zze = f;
                zzib zzib = this.zzc;
                if (zzib != null) {
                    ((zzmh) zzib).zza.zzac();
                }
            }
        }
    }

    private final void zzg(int i) {
        zzib zzib = this.zzc;
        if (zzib != null) {
            zzmh zzmh = (zzmh) zzib;
            boolean zzn = zzmh.zza.zzn();
            zzmh.zza.zzad(zzn, i, zzmj.zzah(zzn, i));
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z, int i) {
        zze();
        return z ? 1 : -1;
    }

    public final void zzc() {
        this.zzc = null;
        zze();
    }
}
