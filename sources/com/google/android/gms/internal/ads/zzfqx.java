package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqx<V> implements Runnable {
    @CheckForNull
    public zzfqz<V> zza;

    public zzfqx(zzfqz<V> zzfqz) {
        this.zza = zzfqz;
    }

    public final void run() {
        zzfqn zzb;
        String str;
        zzfqz<V> zzfqz = this.zza;
        if (zzfqz != null && (zzb = zzfqz.zza) != null) {
            this.zza = null;
            if (zzb.isDone()) {
                zzfqz.zzj(zzb);
                return;
            }
            try {
                ScheduledFuture zzx = zzfqz.zzb;
                ScheduledFuture unused = zzfqz.zzb = null;
                str = "Timed out";
                if (zzx != null) {
                    long abs = Math.abs(zzx.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        StringBuilder sb = new StringBuilder(75);
                        sb.append(str);
                        sb.append(" (timeout delayed by ");
                        sb.append(abs);
                        sb.append(" ms after scheduled time)");
                        str = sb.toString();
                    }
                }
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(zzb);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
                sb2.append(valueOf);
                sb2.append(": ");
                sb2.append(valueOf2);
                zzfqz.zzi(new zzfqy(sb2.toString(), (zzfqw) null));
                zzb.cancel(true);
            } catch (Throwable th) {
                zzb.cancel(true);
                throw th;
            }
        }
    }
}
