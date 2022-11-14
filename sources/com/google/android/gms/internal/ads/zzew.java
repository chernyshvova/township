package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzew {
    @VisibleForTesting
    public static volatile zzfit zza = null;
    public static final ConditionVariable zzd = new ConditionVariable();
    public static volatile Random zze = null;
    @VisibleForTesting
    public volatile Boolean zzb;
    public final zzfy zzc;

    public zzew(zzfy zzfy) {
        this.zzc = zzfy;
        zzfy.zzd().execute(new zzev(this));
    }

    public static final int zzd() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return zze().nextInt();
        } catch (RuntimeException unused) {
            return zze().nextInt();
        }
    }

    public static Random zze() {
        if (zze == null) {
            synchronized (zzew.class) {
                if (zze == null) {
                    zze = new Random();
                }
            }
        }
        return zze;
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzd.block();
            if (this.zzb.booleanValue() && zza != null) {
                zzbv zza2 = zzcb.zza();
                zza2.zza(this.zzc.zza.getPackageName());
                zza2.zzb(j);
                if (str != null) {
                    zza2.zze(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    zzgcg.zzc(exc, new PrintWriter(stringWriter));
                    zza2.zzc(stringWriter.toString());
                    zza2.zzd(exc.getClass().getName());
                }
                zzfis zza3 = zza.zza(((zzcb) zza2.zzah()).zzao());
                zza3.zzc(i);
                if (i2 != -1) {
                    zza3.zzb(i2);
                }
                zza3.zza();
            }
        } catch (Exception unused) {
        }
    }
}
