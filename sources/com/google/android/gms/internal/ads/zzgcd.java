package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-base@@20.3.0 */
public final class zzgcd extends zzgca {
    public final zzgcc zza = new zzgcc();

    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            this.zza.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }

    public final void zzb(Throwable th) {
        th.printStackTrace();
        List<Throwable> zza2 = this.zza.zza(th, false);
        if (zza2 != null) {
            synchronized (zza2) {
                for (Throwable printStackTrace : zza2) {
                    System.err.print("Suppressed: ");
                    printStackTrace.printStackTrace();
                }
            }
        }
    }

    public final void zzc(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> zza2 = this.zza.zza(th, false);
        if (zza2 != null) {
            synchronized (zza2) {
                for (Throwable printStackTrace : zza2) {
                    printWriter.print("Suppressed: ");
                    printStackTrace.printStackTrace(printWriter);
                }
            }
        }
    }
}
