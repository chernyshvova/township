package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final /* synthetic */ class zzbm implements Executor {
    public final Handler zza;

    public zzbm(Handler handler) {
        this.zza = handler;
    }

    public static Executor zza(Handler handler) {
        return new zzbm(handler);
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
