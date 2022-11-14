package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzy implements Runnable {
    public final /* synthetic */ zzu zza;
    public final /* synthetic */ Callable zzb;

    public zzy(zzu zzu, Callable callable) {
        this.zza = zzu;
        this.zzb = callable;
    }

    public final void run() {
        try {
            this.zza.zza(this.zzb.call());
        } catch (Exception e) {
            this.zza.zza(e);
        } catch (Throwable th) {
            this.zza.zza((Exception) new RuntimeException(th));
        }
    }
}
