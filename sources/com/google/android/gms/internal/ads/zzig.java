package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import androidx.annotation.RequiresApi;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzig {
    public static final UUID zza = new UUID(0, 0);
    public static final UUID zzb = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID zzc = new UUID(-2129748144642739255L, 8654423357094679310L);
    public static final UUID zzd = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID zze = new UUID(-7348484286925749626L, -6083546864340672619L);

    public static long zza(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static long zzb(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    @RequiresApi(21)
    public static int zzc(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static String zzd(int i) {
        if (i == 0) {
            return "NO";
        }
        if (i == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }
}
